public class Vector {
    private double[] elems;
    private int dimension;

    public Vector(int d, double[] e) {
        this.dimension = d;
        this.elems = e;
    }

    public int getDim() {
        return dimension;
    }

    public double[] getElems() {
        return elems;
    }

    public Vector add(Vector v) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = this.elems[i] + v.elems[i];
        }
        return new Vector(this.dimension, result);
    }

    public Vector subtract(Vector v) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = this.elems[i] - v.elems[i];
        }
        return new Vector(this.dimension, result);
    }

    public Vector multiply(Vector v) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = this.elems[i] * v.elems[i];
        }
        return new Vector(this.dimension, result);
    }

    public Vector divide(Vector v) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = this.elems[i] / v.elems[i];
        }
        return new Vector(this.dimension, result);
    }

    public Vector multScalar(double s) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = this.elems[i] * s;
        }
        return new Vector(this.dimension, result);
    }

    public Vector divScalar(double s) {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = this.elems[i] / s;
        }
        return new Vector(this.dimension, result);
    }

    public Vector sqrt() {
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = Math.sqrt(this.elems[i]);
        }
        return new Vector(this.dimension, result);
    }

    public double dotProduct(Vector v) {
        double result = 0;
        for (int i = 0; i < dimension; i++) {
            result += this.elems[i] * v.elems[i];
        }
        return result;
    }

    public double norm() {
        double sum = 0;
        for (int i = 0; i < dimension; i++) {
            sum += Math.pow(this.elems[i], 2);
        }
        return Math.sqrt(sum);
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < dimension; i++) {
            s += this.elems[i];
            if (i < dimension - 1) s += ", ";
        }
        s += "]";
        return s;
    }

   
    public Vector augment() {
        double[] augmentedElems = new double[dimension + 1];
        augmentedElems[0] = 1.0;
        for (int i = 0; i < dimension; i++) {
            augmentedElems[i + 1] = this.elems[i];
        }
        return new Vector(dimension + 1, augmentedElems);
    }
}
