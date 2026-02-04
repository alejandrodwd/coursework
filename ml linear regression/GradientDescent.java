public class GradientDescent extends Algorithm {

    private double tol;
    private int maxIter;

    public GradientDescent(double learningRate, double tol, int maxIter) {
        super(learningRate);
        this.tol = tol;
        this.maxIter = maxIter;
    }

    private Vector gradient(Dataset ds, Model md){
        int n = ds.size();
        int d = ds.getDim() + 1;

        double[] g = new double[d];

        for (int i = 0; i < n; i++) {
            Record r = ds.getRecord(i);
            Vector xAug = r.getInput().augment();
            double y = r.getOutput();
            double yhat = md.predict(r.getInput());
            double e = yhat - y;

            double[] xv = xAug.getElems();
            for (int j = 0; j < d; j++) {
                g[j] += 2 * e * xv[j];
            }
        }

        for (int j = 0; j < d; j++) g[j] /= n;

        return new Vector(d, g);
    }

    @Override
    public Model solve(Dataset ds){ 
        Model md = new Model(ds.getDim());

        for (int iter = 0; iter < maxIter; iter++) {
            Vector grad = gradient(ds, md);
            if (grad.norm() < tol) break;
            md.update(grad, (float) learningRate);
        }
        return md;
    }
}
