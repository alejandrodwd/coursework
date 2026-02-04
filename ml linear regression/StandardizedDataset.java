public class StandardizedDataset extends Dataset {

    private Vector meanIn;
    private Vector stdIn;
    private double meanOut;
    private double stdOut;

    public StandardizedDataset(Vector meanIn, Vector stdIn, double meanOut, double stdOut) {
        super(meanIn.getDim());
        this.meanIn = meanIn;
        this.stdIn = stdIn;
        this.meanOut = meanOut;
        this.stdOut = stdOut;
    }

    @Override
    public Record transform(Record r) {
        Vector standardizedInput = r.getInput()
                .subtract(meanIn)
                .divide(stdIn);
        double standardizedOutput = (r.getOutput() - meanOut) / stdOut;
        return new Record(standardizedInput, standardizedOutput);
    }

    @Override
    public double output(double yHat) {
        return yHat * stdOut + meanOut;
    }
}
