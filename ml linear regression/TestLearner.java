public class TestLearner {
    public static void main(String[] args) {

        RawDataset raw = new RawDataset(1);
        raw.addRecord(new Record(new Vector(1, new double[]{0}), 1));
        raw.addRecord(new Record(new Vector(1, new double[]{1}), 3));
        raw.addRecord(new Record(new Vector(1, new double[]{2}), 5));
        raw.addRecord(new Record(new Vector(1, new double[]{3}), 7));

        System.out.println("Raw dataset:");
        System.out.println(raw);

        StandardizedDataset std = raw.standardize();
        System.out.println("Standardized dataset:");
        System.out.println(std);

        GradientDescent gd = new GradientDescent(0.01, 1e-6, 10000);
        SupervisedLearner learnerGD = new SupervisedLearner(raw, gd);
        learnerGD.solve();
        System.out.println("GD on raw: " + learnerGD);
        System.out.println("GD raw predict x=4: " + learnerGD.predict(new Vector(1, new double[]{4})));

        GradientDescent gdStd = new GradientDescent(0.01, 1e-6, 10000);
        SupervisedLearner learnerGDStd = new SupervisedLearner(std, gdStd);
        learnerGDStd.solve();
        System.out.println("GD on standardized: " + learnerGDStd);
        System.out.println("GD std predict x=4: " + learnerGDStd.predict(new Vector(1, new double[]{4})));

        StochasticGradientDescent sgd = new StochasticGradientDescent(0.01, 2, 5000);
        SupervisedLearner learnerSGD = new SupervisedLearner(raw, sgd);
        learnerSGD.solve();
        System.out.println("SGD on raw: " + learnerSGD);
        System.out.println("SGD raw predict x=4: " + learnerSGD.predict(new Vector(1, new double[]{4})));

        StochasticGradientDescent sgdStd = new StochasticGradientDescent(0.01, 2, 5000);
        SupervisedLearner learnerSGDStd = new SupervisedLearner(std, sgdStd);
        learnerSGDStd.solve();
        System.out.println("SGD on standardized: " + learnerSGDStd);
        System.out.println("SGD std predict x=4: " + learnerSGDStd.predict(new Vector(1, new double[]{4})));
    }
}

