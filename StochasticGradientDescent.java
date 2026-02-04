import java.util.Random;

public class StochasticGradientDescent extends Algorithm {

    private int batchsize;
    private int iterations;
    private Random random;

    public StochasticGradientDescent(double learningRate, int batchsize, int iterations) {
        super(learningRate);
        this.batchsize = batchsize;
        this.iterations = iterations;
        this.random = new Random();
    }

    private Vector stochasticGradient(Dataset ds, Model md){
        int n = ds.size();
        int d = ds.getDim() + 1;

        double[] g = new double[d];

        int[] idx = random.ints(0, n).distinct().limit(batchsize).toArray();

        for (int k = 0; k < idx.length; k++) {
            Record r = ds.getRecord(idx[k]);
            Vector xAug = r.getInput().augment();
            double y = r.getOutput();
            double yhat = md.predict(r.getInput());
            double e = yhat - y;

            double[] xv = xAug.getElems();
            for (int j = 0; j < d; j++) {
                g[j] += 2 * e * xv[j];
            }
        }

        for (int j = 0; j < d; j++) g[j] /= batchsize;

        return new Vector(d, g);
    }

    @Override
    public Model solve(Dataset ds){ 
        Model md = new Model(ds.getDim());

        for (int iter = 0; iter < iterations; iter++) {
            Vector grad = stochasticGradient(ds, md);
            md.update(grad, (float) learningRate);
        }
        return md;
    }
}
