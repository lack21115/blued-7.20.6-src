package android.filterfw.geometry;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/geometry/Point.class */
public class Point {
    public float x;
    public float y;

    public Point() {
    }

    public Point(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public boolean IsInUnitRange() {
        return this.x >= 0.0f && this.x <= 1.0f && this.y >= 0.0f && this.y <= 1.0f;
    }

    public float distanceTo(Point point) {
        return point.minus(this).length();
    }

    public float length() {
        return (float) Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public Point minus(float f, float f2) {
        return new Point(this.x - f, this.y - f2);
    }

    public Point minus(Point point) {
        return minus(point.x, point.y);
    }

    public Point mult(float f, float f2) {
        return new Point(this.x * f, this.y * f2);
    }

    public Point normalize() {
        return scaledTo(1.0f);
    }

    public Point plus(float f, float f2) {
        return new Point(this.x + f, this.y + f2);
    }

    public Point plus(Point point) {
        return plus(point.x, point.y);
    }

    public Point rotated(float f) {
        return new Point((float) ((Math.cos(f) * this.x) - (Math.sin(f) * this.y)), (float) ((Math.sin(f) * this.x) + (Math.cos(f) * this.y)));
    }

    public Point rotated90(int i) {
        float f = this.x;
        float f2 = this.y;
        int i2 = 0;
        while (i2 < i) {
            float f3 = -f;
            i2++;
            f = f2;
            f2 = f3;
        }
        return new Point(f, f2);
    }

    public Point rotatedAround(Point point, float f) {
        return minus(point).rotated(f).plus(point);
    }

    public Point scaledTo(float f) {
        return times(f / length());
    }

    public void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public Point times(float f) {
        return new Point(this.x * f, this.y * f);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
