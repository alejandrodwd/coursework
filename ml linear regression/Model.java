public class Model {
    private Vector theta;

    public Model(int d) {
        double[] z = new double[d + 1];
        this.theta = new Vector(d + 1, z);
    }

    public Model(Vector theta) {
        this.theta = theta;
    }

    public double predict(Vector x) {
        return theta.dotProduct(x.augment());
    }

    public void update(Vector grad, float alpha){
        this.theta = this.theta.subtract(grad.multScalar(alpha));
    }

    public Vector getTheta() {
        return theta;
    }

    public String toString() {
        return "Model{theta=" + theta + "}";
    }
}
