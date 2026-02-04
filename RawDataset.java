public class RawDataset extends Dataset {

    public RawDataset(int d) {
        super(d);
    }

    @Override
    public Record transform(Record r) {
        return r;
    }

    @Override
    public double output(double yHat) {
        return yHat;
    }
}
