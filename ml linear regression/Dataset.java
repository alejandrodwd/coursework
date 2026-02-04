import java.util.ArrayList;

public abstract class Dataset {
    protected int dim;
    protected ArrayList<Record> records;

    public Dataset(int d){
        this.dim = d;
        this.records = new ArrayList<>();
    }

    public int getDim() {
        return dim;
    }

    public Record getRecord(int i) {
        return records.get(i);
    }

    public void addRecord(Record r) {
        records.add(r);
    }

    public int size() {
        return records.size();
    }

    public String toString() {
        String s = "Dataset with " + records.size() + " records:\n";
        for (Record r : records) {
            s += r.toString() + "\n";
        }
        return s;
    }

    public Vector meanIn() {
        double[] sum = new double[dim];
        for (Record r : records) {
            double[] vals = r.getInput().getElems();
            for (int i = 0; i < dim; i++) {
                sum[i] += vals[i];
            }
        }
        for (int i = 0; i < dim; i++) {
            sum[i] /= records.size();
        }
        return new Vector(dim, sum);
    }

    public double meanOut() {
        double sum = 0;
        for (Record r : records) {
            sum += r.getOutput();
        }
        return sum / records.size();
    }

    public Vector stdIn() {
        Vector mean = meanIn();
        double[] meanVals = mean.getElems();
        double[] var = new double[dim];

        for (Record r : records) {
            double[] vals = r.getInput().getElems();
            for (int i = 0; i < dim; i++) {
                var[i] += Math.pow(vals[i] - meanVals[i], 2);
            }
        }

        for (int i = 0; i < dim; i++) {
            var[i] = Math.sqrt(var[i] / records.size());
            if (var[i] == 0) var[i] = 1e-9;
        }

        return new Vector(dim, var);
    }

    public double stdOut() {
        double mean = meanOut();
        double var = 0;
        for (Record r : records) {
            double diff = r.getOutput() - mean;
            var += diff * diff;
        }
        double std = Math.sqrt(var / records.size());
        return (std == 0) ? 1e-9 : std;
    }

    public StandardizedDataset standardize() {
        Vector meanIn = meanIn();
        Vector stdIn = stdIn();
        double meanOut = meanOut();
        double stdOut = stdOut();

        StandardizedDataset sds = new StandardizedDataset(meanIn, stdIn, meanOut, stdOut);
        for (Record r : records) {
            sds.addRecord(sds.transform(r));
        }
        return sds;
    }

// new methods for lab4
    public abstract Record transform(Record r);
    public abstract double output(double yHat);
}
