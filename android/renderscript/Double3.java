package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Double3.class */
public class Double3 {
    public double x;
    public double y;
    public double z;

    public Double3() {
    }

    public Double3(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public Double3(Double3 double3) {
        this.x = double3.x;
        this.y = double3.y;
        this.z = double3.z;
    }

    public static Double3 add(Double3 double3, double d) {
        Double3 double32 = new Double3();
        double32.x = double3.x + d;
        double32.y = double3.y + d;
        double32.z = double3.z + d;
        return double32;
    }

    public static Double3 add(Double3 double3, Double3 double32) {
        Double3 double33 = new Double3();
        double33.x = double3.x + double32.x;
        double33.y = double3.y + double32.y;
        double33.z = double3.z + double32.z;
        return double33;
    }

    public static Double3 div(Double3 double3, double d) {
        Double3 double32 = new Double3();
        double32.x = double3.x / d;
        double32.y = double3.y / d;
        double32.z = double3.z / d;
        return double32;
    }

    public static Double3 div(Double3 double3, Double3 double32) {
        Double3 double33 = new Double3();
        double33.x = double3.x / double32.x;
        double33.y = double3.y / double32.y;
        double33.z = double3.z / double32.z;
        return double33;
    }

    public static double dotProduct(Double3 double3, Double3 double32) {
        return (double32.x * double3.x) + (double32.y * double3.y) + (double32.z * double3.z);
    }

    public static Double3 mul(Double3 double3, double d) {
        Double3 double32 = new Double3();
        double32.x = double3.x * d;
        double32.y = double3.y * d;
        double32.z = double3.z * d;
        return double32;
    }

    public static Double3 mul(Double3 double3, Double3 double32) {
        Double3 double33 = new Double3();
        double33.x = double3.x * double32.x;
        double33.y = double3.y * double32.y;
        double33.z = double3.z * double32.z;
        return double33;
    }

    public static Double3 sub(Double3 double3, double d) {
        Double3 double32 = new Double3();
        double32.x = double3.x - d;
        double32.y = double3.y - d;
        double32.z = double3.z - d;
        return double32;
    }

    public static Double3 sub(Double3 double3, Double3 double32) {
        Double3 double33 = new Double3();
        double33.x = double3.x - double32.x;
        double33.y = double3.y - double32.y;
        double33.z = double3.z - double32.z;
        return double33;
    }

    public void add(double d) {
        this.x += d;
        this.y += d;
        this.z += d;
    }

    public void add(Double3 double3) {
        this.x += double3.x;
        this.y += double3.y;
        this.z += double3.z;
    }

    public void addAt(int i, double d) {
        switch (i) {
            case 0:
                this.x += d;
                return;
            case 1:
                this.y += d;
                return;
            case 2:
                this.z += d;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Double3 double3, double d) {
        this.x += double3.x * d;
        this.y += double3.y * d;
        this.z += double3.z * d;
    }

    public void copyTo(double[] dArr, int i) {
        dArr[i] = this.x;
        dArr[i + 1] = this.y;
        dArr[i + 2] = this.z;
    }

    public void div(double d) {
        this.x /= d;
        this.y /= d;
        this.z /= d;
    }

    public void div(Double3 double3) {
        this.x /= double3.x;
        this.y /= double3.y;
        this.z /= double3.z;
    }

    public double dotProduct(Double3 double3) {
        return (this.x * double3.x) + (this.y * double3.y) + (this.z * double3.z);
    }

    public double elementSum() {
        return this.x + this.y + this.z;
    }

    public double get(int i) {
        switch (i) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 2:
                return this.z;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public int length() {
        return 3;
    }

    public void mul(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
    }

    public void mul(Double3 double3) {
        this.x *= double3.x;
        this.y *= double3.y;
        this.z *= double3.z;
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public void set(Double3 double3) {
        this.x = double3.x;
        this.y = double3.y;
        this.z = double3.z;
    }

    public void setAt(int i, double d) {
        switch (i) {
            case 0:
                this.x = d;
                return;
            case 1:
                this.y = d;
                return;
            case 2:
                this.z = d;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public void sub(double d) {
        this.x -= d;
        this.y -= d;
        this.z -= d;
    }

    public void sub(Double3 double3) {
        this.x -= double3.x;
        this.y -= double3.y;
        this.z -= double3.z;
    }
}
