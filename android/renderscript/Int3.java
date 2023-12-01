package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Int3.class */
public class Int3 {
    public int x;
    public int y;
    public int z;

    public Int3() {
    }

    public Int3(int i) {
        this.z = i;
        this.y = i;
        this.x = i;
    }

    public Int3(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
    }

    public Int3(Int3 int3) {
        this.x = int3.x;
        this.y = int3.y;
        this.z = int3.z;
    }

    public static Int3 add(Int3 int3, int i) {
        Int3 int32 = new Int3();
        int32.x = int3.x + i;
        int32.y = int3.y + i;
        int32.z = int3.z + i;
        return int32;
    }

    public static Int3 add(Int3 int3, Int3 int32) {
        Int3 int33 = new Int3();
        int33.x = int3.x + int32.x;
        int33.y = int3.y + int32.y;
        int33.z = int3.z + int32.z;
        return int33;
    }

    public static Int3 div(Int3 int3, int i) {
        Int3 int32 = new Int3();
        int32.x = int3.x / i;
        int32.y = int3.y / i;
        int32.z = int3.z / i;
        return int32;
    }

    public static Int3 div(Int3 int3, Int3 int32) {
        Int3 int33 = new Int3();
        int33.x = int3.x / int32.x;
        int33.y = int3.y / int32.y;
        int33.z = int3.z / int32.z;
        return int33;
    }

    public static int dotProduct(Int3 int3, Int3 int32) {
        return (int32.x * int3.x) + (int32.y * int3.y) + (int32.z * int3.z);
    }

    public static Int3 mod(Int3 int3, int i) {
        Int3 int32 = new Int3();
        int32.x = int3.x % i;
        int32.y = int3.y % i;
        int32.z = int3.z % i;
        return int32;
    }

    public static Int3 mod(Int3 int3, Int3 int32) {
        Int3 int33 = new Int3();
        int33.x = int3.x % int32.x;
        int33.y = int3.y % int32.y;
        int33.z = int3.z % int32.z;
        return int33;
    }

    public static Int3 mul(Int3 int3, int i) {
        Int3 int32 = new Int3();
        int32.x = int3.x * i;
        int32.y = int3.y * i;
        int32.z = int3.z * i;
        return int32;
    }

    public static Int3 mul(Int3 int3, Int3 int32) {
        Int3 int33 = new Int3();
        int33.x = int3.x * int32.x;
        int33.y = int3.y * int32.y;
        int33.z = int3.z * int32.z;
        return int33;
    }

    public static Int3 sub(Int3 int3, int i) {
        Int3 int32 = new Int3();
        int32.x = int3.x - i;
        int32.y = int3.y - i;
        int32.z = int3.z - i;
        return int32;
    }

    public static Int3 sub(Int3 int3, Int3 int32) {
        Int3 int33 = new Int3();
        int33.x = int3.x - int32.x;
        int33.y = int3.y - int32.y;
        int33.z = int3.z - int32.z;
        return int33;
    }

    public void add(int i) {
        this.x += i;
        this.y += i;
        this.z += i;
    }

    public void add(Int3 int3) {
        this.x += int3.x;
        this.y += int3.y;
        this.z += int3.z;
    }

    public void addAt(int i, int i2) {
        switch (i) {
            case 0:
                this.x += i2;
                return;
            case 1:
                this.y += i2;
                return;
            case 2:
                this.z += i2;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Int3 int3, int i) {
        this.x += int3.x * i;
        this.y += int3.y * i;
        this.z += int3.z * i;
    }

    public void copyTo(int[] iArr, int i) {
        iArr[i] = this.x;
        iArr[i + 1] = this.y;
        iArr[i + 2] = this.z;
    }

    public void div(int i) {
        this.x /= i;
        this.y /= i;
        this.z /= i;
    }

    public void div(Int3 int3) {
        this.x /= int3.x;
        this.y /= int3.y;
        this.z /= int3.z;
    }

    public int dotProduct(Int3 int3) {
        return (this.x * int3.x) + (this.y * int3.y) + (this.z * int3.z);
    }

    public int elementSum() {
        return this.x + this.y + this.z;
    }

    public int get(int i) {
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

    public void mod(int i) {
        this.x %= i;
        this.y %= i;
        this.z %= i;
    }

    public void mod(Int3 int3) {
        this.x %= int3.x;
        this.y %= int3.y;
        this.z %= int3.z;
    }

    public void mul(int i) {
        this.x *= i;
        this.y *= i;
        this.z *= i;
    }

    public void mul(Int3 int3) {
        this.x *= int3.x;
        this.y *= int3.y;
        this.z *= int3.z;
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public void set(Int3 int3) {
        this.x = int3.x;
        this.y = int3.y;
        this.z = int3.z;
    }

    public void setAt(int i, int i2) {
        switch (i) {
            case 0:
                this.x = i2;
                return;
            case 1:
                this.y = i2;
                return;
            case 2:
                this.z = i2;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
    }

    public void sub(int i) {
        this.x -= i;
        this.y -= i;
        this.z -= i;
    }

    public void sub(Int3 int3) {
        this.x -= int3.x;
        this.y -= int3.y;
        this.z -= int3.z;
    }
}
