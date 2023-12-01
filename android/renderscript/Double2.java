package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Double2.class */
public class Double2 {
    public double x;
    public double y;

    public Double2() {
    }

    public Double2(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Double2(Double2 double2) {
        this.x = double2.x;
        this.y = double2.y;
    }

    public static Double2 add(Double2 double2, double d) {
        Double2 double22 = new Double2();
        double22.x = double2.x + d;
        double22.y = double2.y + d;
        return double22;
    }

    public static Double2 add(Double2 double2, Double2 double22) {
        Double2 double23 = new Double2();
        double23.x = double2.x + double22.x;
        double23.y = double2.y + double22.y;
        return double23;
    }

    public static Double2 div(Double2 double2, double d) {
        Double2 double22 = new Double2();
        double22.x = double2.x / d;
        double22.y = double2.y / d;
        return double22;
    }

    public static Double2 div(Double2 double2, Double2 double22) {
        Double2 double23 = new Double2();
        double23.x = double2.x / double22.x;
        double23.y = double2.y / double22.y;
        return double23;
    }

    public static Double dotProduct(Double2 double2, Double2 double22) {
        return Double.valueOf((double22.x * double2.x) + (double22.y * double2.y));
    }

    public static Double2 mul(Double2 double2, double d) {
        Double2 double22 = new Double2();
        double22.x = double2.x * d;
        double22.y = double2.y * d;
        return double22;
    }

    public static Double2 mul(Double2 double2, Double2 double22) {
        Double2 double23 = new Double2();
        double23.x = double2.x * double22.x;
        double23.y = double2.y * double22.y;
        return double23;
    }

    public static Double2 sub(Double2 double2, double d) {
        Double2 double22 = new Double2();
        double22.x = double2.x - d;
        double22.y = double2.y - d;
        return double22;
    }

    public static Double2 sub(Double2 double2, Double2 double22) {
        Double2 double23 = new Double2();
        double23.x = double2.x - double22.x;
        double23.y = double2.y - double22.y;
        return double23;
    }

    public void add(double d) {
        this.x += d;
        this.y += d;
    }

    public void add(Double2 double2) {
        this.x += double2.x;
        this.y += double2.y;
    }

    public void addAt(int i, double d) {
        switch (i) {
            case 0:
                this.x += d;
                return;
            case 1:
                this.y += d;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Double2 double2, double d) {
        this.x += double2.x * d;
        this.y += double2.y * d;
    }

    public void copyTo(double[] dArr, int i) {
        dArr[i] = this.x;
        dArr[i + 1] = this.y;
    }

    public void div(double d) {
        this.x /= d;
        this.y /= d;
    }

    public void div(Double2 double2) {
        this.x /= double2.x;
        this.y /= double2.y;
    }

    public double dotProduct(Double2 double2) {
        return (this.x * double2.x) + (this.y * double2.y);
    }

    public double elementSum() {
        return this.x + this.y;
    }

    public double get(int i) {
        switch (i) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public int length() {
        return 2;
    }

    public void mul(double d) {
        this.x *= d;
        this.y *= d;
    }

    public void mul(Double2 double2) {
        this.x *= double2.x;
        this.y *= double2.y;
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public void set(Double2 double2) {
        this.x = double2.x;
        this.y = double2.y;
    }

    public void setAt(int i, double d) {
        switch (i) {
            case 0:
                this.x = d;
                return;
            case 1:
                this.y = d;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void sub(double d) {
        this.x -= d;
        this.y -= d;
    }

    public void sub(Double2 double2) {
        this.x -= double2.x;
        this.y -= double2.y;
    }
}
