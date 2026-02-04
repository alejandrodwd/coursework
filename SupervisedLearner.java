public class SupervisedLearner {
    private Dataset d;
    private Algorithm a;
    private Model m;

    public SupervisedLearner(Dataset dataset, Algorithm algorithm) {
        this.d = dataset;
        this.a = algorithm;
    }

    public void solve() {
        this.m = a.solve(d);
    }

    public double predict(Vector x) {
        Record fake = new Record(x, 0.0);
        Record transformed = d.transform(fake);
        double yHatInternal = m.predict(transformed.getInput());
        return d.output(yHatInternal);
    }

    public String toString() {
        return "SupervisedLearner{model=" + m + "}";
    }
}
