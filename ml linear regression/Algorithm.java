public abstract class Algorithm {
    protected double learningRate;

    public Algorithm(double learningRate) {
        this.learningRate = learningRate;
    }

    public abstract Model solve(Dataset ds);
}
