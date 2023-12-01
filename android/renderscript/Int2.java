package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Int2.class */
public class Int2 {
    public int x;
    public int y;

    public Int2() {
    }

    public Int2(int i) {
        this.y = i;
        this.x = i;
    }

    public Int2(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public Int2(Int2 int2) {
        this.x = int2.x;
        this.y = int2.y;
    }

    public static Int2 add(Int2 int2, int i) {
        Int2 int22 = new Int2();
        int22.x = int2.x + i;
        int22.y = int2.y + i;
        return int22;
    }

    public static Int2 add(Int2 int2, Int2 int22) {
        Int2 int23 = new Int2();
        int23.x = int2.x + int22.x;
        int23.y = int2.y + int22.y;
        return int23;
    }

    public static Int2 div(Int2 int2, int i) {
        Int2 int22 = new Int2();
        int22.x = int2.x / i;
        int22.y = int2.y / i;
        return int22;
    }

    public static Int2 div(Int2 int2, Int2 int22) {
        Int2 int23 = new Int2();
        int23.x = int2.x / int22.x;
        int23.y = int2.y / int22.y;
        return int23;
    }

    public static int dotProduct(Int2 int2, Int2 int22) {
        return (int22.x * int2.x) + (int22.y * int2.y);
    }

    public static Int2 mod(Int2 int2, int i) {
        Int2 int22 = new Int2();
        int22.x = int2.x % i;
        int22.y = int2.y % i;
        return int22;
    }

    public static Int2 mod(Int2 int2, Int2 int22) {
        Int2 int23 = new Int2();
        int23.x = int2.x % int22.x;
        int23.y = int2.y % int22.y;
        return int23;
    }

    public static Int2 mul(Int2 int2, int i) {
        Int2 int22 = new Int2();
        int22.x = int2.x * i;
        int22.y = int2.y * i;
        return int22;
    }

    public static Int2 mul(Int2 int2, Int2 int22) {
        Int2 int23 = new Int2();
        int23.x = int2.x * int22.x;
        int23.y = int2.y * int22.y;
        return int23;
    }

    public static Int2 sub(Int2 int2, int i) {
        Int2 int22 = new Int2();
        int22.x = int2.x - i;
        int22.y = int2.y - i;
        return int22;
    }

    public static Int2 sub(Int2 int2, Int2 int22) {
        Int2 int23 = new Int2();
        int23.x = int2.x - int22.x;
        int23.y = int2.y - int22.y;
        return int23;
    }

    public void add(int i) {
        this.x += i;
        this.y += i;
    }

    public void add(Int2 int2) {
        this.x += int2.x;
        this.y += int2.y;
    }

    public void addAt(int i, int i2) {
        switch (i) {
            case 0:
                this.x += i2;
                return;
            case 1:
                this.y += i2;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Int2 int2, int i) {
        this.x += int2.x * i;
        this.y += int2.y * i;
    }

    public void copyTo(int[] iArr, int i) {
        iArr[i] = this.x;
        iArr[i + 1] = this.y;
    }

    public void div(int i) {
        this.x /= i;
        this.y /= i;
    }

    public void div(Int2 int2) {
        this.x /= int2.x;
        this.y /= int2.y;
    }

    public int dotProduct(Int2 int2) {
        return (this.x * int2.x) + (this.y * int2.y);
    }

    public int elementSum() {
        return this.x + this.y;
    }

    public int get(int i) {
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

    public void mod(int i) {
        this.x %= i;
        this.y %= i;
    }

    public void mod(Int2 int2) {
        this.x %= int2.x;
        this.y %= int2.y;
    }

    public void mul(int i) {
        this.x *= i;
        this.y *= i;
    }

    public void mul(Int2 int2) {
        this.x *= int2.x;
        this.y *= int2.y;
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public void set(Int2 int2) {
        this.x = int2.x;
        this.y = int2.y;
    }

    public void setAt(int i, int i2) {
        switch (i) {
            case 0:
                this.x = i2;
                return;
            case 1:
                this.y = i2;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public void sub(int i) {
        this.x -= i;
        this.y -= i;
    }

    public void sub(Int2 int2) {
        this.x -= int2.x;
        this.y -= int2.y;
    }
}
