public class Record {

    private Vector input;
    private double output;

    public Record(Vector input, double output){
        this.input = input;
        this.output = output;
    }

    public Vector getInput(){
        return input;
    }

    public double getOutput(){
        return output;
    }

    public String toString(){
        return "Record [input=" + input + ", output=" + output + "]";
    }
}
