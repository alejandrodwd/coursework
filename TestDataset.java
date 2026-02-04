public class TestDataset {

    public static void main(String[] args) {
        RawDataset ds = new RawDataset(2);


        ds.addRecord(new Record(new Vector(2, new double[]{1.0, 2.0}), 5.0));
        ds.addRecord(new Record(new Vector(2, new double[]{2.0, 3.0}), 6.0));
        ds.addRecord(new Record(new Vector(2, new double[]{3.0, 4.0}), 7.0));

        System.out.println(ds);

        System.out.println("Mean Input: " + ds.meanIn());
        System.out.println("Std Input: " + ds.stdIn());
        System.out.println("Mean Output: " + ds.meanOut());
        System.out.println("Std Output: " + ds.stdOut());

        StandardizedDataset sds = ds.standardize();
        System.out.println("\nStandardized Dataset:");
        System.out.println(sds);

        System.out.println("Mean Input (should be approx 0): " + sds.meanIn());
        System.out.println("Std Input (should be approx 1): " + sds.stdIn());
        System.out.println("Mean Output (should be approx 0): " + sds.meanOut());
        System.out.println("Std Output (should be approx 1): " + sds.stdOut());
    }
}
