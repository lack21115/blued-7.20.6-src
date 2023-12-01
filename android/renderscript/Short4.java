package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Short4.class */
public class Short4 {
    public short w;
    public short x;
    public short y;
    public short z;

    public Short4() {
    }

    public Short4(Short4 short4) {
        this.x = short4.x;
        this.y = short4.y;
        this.z = short4.z;
        this.w = short4.w;
    }

    public Short4(short s) {
        this.w = s;
        this.z = s;
        this.y = s;
        this.x = s;
    }

    public Short4(short s, short s2, short s3, short s4) {
        this.x = s;
        this.y = s2;
        this.z = s3;
        this.w = s4;
    }

    public static Short4 add(Short4 short4, Short4 short42) {
        Short4 short43 = new Short4();
        short43.x = (short) (short4.x + short42.x);
        short43.y = (short) (short4.y + short42.y);
        short43.z = (short) (short4.z + short42.z);
        short43.w = (short) (short4.w + short42.w);
        return short43;
    }

    public static Short4 add(Short4 short4, short s) {
        Short4 short42 = new Short4();
        short42.x = (short) (short4.x + s);
        short42.y = (short) (short4.y + s);
        short42.z = (short) (short4.z + s);
        short42.w = (short) (short4.w + s);
        return short42;
    }

    public static Short4 div(Short4 short4, Short4 short42) {
        Short4 short43 = new Short4();
        short43.x = (short) (short4.x / short42.x);
        short43.y = (short) (short4.y / short42.y);
        short43.z = (short) (short4.z / short42.z);
        short43.w = (short) (short4.w / short42.w);
        return short43;
    }

    public static Short4 div(Short4 short4, short s) {
        Short4 short42 = new Short4();
        short42.x = (short) (short4.x / s);
        short42.y = (short) (short4.y / s);
        short42.z = (short) (short4.z / s);
        short42.w = (short) (short4.w / s);
        return short42;
    }

    public static short dotProduct(Short4 short4, Short4 short42) {
        return (short) ((short42.x * short4.x) + (short42.y * short4.y) + (short42.z * short4.z) + (short42.w * short4.w));
    }

    public static Short4 mod(Short4 short4, Short4 short42) {
        Short4 short43 = new Short4();
        short43.x = (short) (short4.x % short42.x);
        short43.y = (short) (short4.y % short42.y);
        short43.z = (short) (short4.z % short42.z);
        short43.w = (short) (short4.w % short42.w);
        return short43;
    }

    public static Short4 mod(Short4 short4, short s) {
        Short4 short42 = new Short4();
        short42.x = (short) (short4.x % s);
        short42.y = (short) (short4.y % s);
        short42.z = (short) (short4.z % s);
        short42.w = (short) (short4.w % s);
        return short42;
    }

    public static Short4 mul(Short4 short4, Short4 short42) {
        Short4 short43 = new Short4();
        short43.x = (short) (short4.x * short42.x);
        short43.y = (short) (short4.y * short42.y);
        short43.z = (short) (short4.z * short42.z);
        short43.w = (short) (short4.w * short42.w);
        return short43;
    }

    public static Short4 mul(Short4 short4, short s) {
        Short4 short42 = new Short4();
        short42.x = (short) (short4.x * s);
        short42.y = (short) (short4.y * s);
        short42.z = (short) (short4.z * s);
        short42.w = (short) (short4.w * s);
        return short42;
    }

    public static Short4 sub(Short4 short4, Short4 short42) {
        Short4 short43 = new Short4();
        short43.x = (short) (short4.x - short42.x);
        short43.y = (short) (short4.y - short42.y);
        short43.z = (short) (short4.z - short42.z);
        short43.w = (short) (short4.w - short42.w);
        return short43;
    }

    public static Short4 sub(Short4 short4, short s) {
        Short4 short42 = new Short4();
        short42.x = (short) (short4.x - s);
        short42.y = (short) (short4.y - s);
        short42.z = (short) (short4.z - s);
        short42.w = (short) (short4.w - s);
        return short42;
    }

    public void add(Short4 short4) {
        this.x = (short) (this.x + short4.x);
        this.y = (short) (this.y + short4.y);
        this.z = (short) (this.z + short4.z);
        this.w = (short) (this.w + short4.w);
    }

    public void add(short s) {
        this.x = (short) (this.x + s);
        this.y = (short) (this.y + s);
        this.z = (short) (this.z + s);
        this.w = (short) (this.w + s);
    }

    public void addAt(int i, short s) {
        switch (i) {
            case 0:
                this.x = (short) (this.x + s);
                return;
            case 1:
                this.y = (short) (this.y + s);
                return;
            case 2:
                this.z = (short) (this.z + s);
                return;
            case 3:
                this.w = (short) (this.w + s);
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Short4 short4, short s) {
        this.x = (short) (this.x + (short4.x * s));
        this.y = (short) (this.y + (short4.y * s));
        this.z = (short) (this.z + (short4.z * s));
        this.w = (short) (this.w + (short4.w * s));
    }

    public void copyTo(short[] sArr, int i) {
        sArr[i] = this.x;
        sArr[i + 1] = this.y;
        sArr[i + 2] = this.z;
        sArr[i + 3] = this.w;
    }

    public void div(Short4 short4) {
        this.x = (short) (this.x / short4.x);
        this.y = (short) (this.y / short4.y);
        this.z = (short) (this.z / short4.z);
        this.w = (short) (this.w / short4.w);
    }

    public void div(short s) {
        this.x = (short) (this.x / s);
        this.y = (short) (this.y / s);
        this.z = (short) (this.z / s);
        this.w = (short) (this.w / s);
    }

    public short dotProduct(Short4 short4) {
        return (short) ((this.x * short4.x) + (this.y * short4.y) + (this.z * short4.z) + (this.w * short4.w));
    }

    public short elementSum() {
        return (short) (this.x + this.y + this.z + this.w);
    }

    public short get(int i) {
        switch (i) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 2:
                return this.z;
            case 3:
                return this.w;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public short length() {
        return (short) 4;
    }

    public void mod(Short4 short4) {
        this.x = (short) (this.x % short4.x);
        this.y = (short) (this.y % short4.y);
        this.z = (short) (this.z % short4.z);
        this.w = (short) (this.w % short4.w);
    }

    public void mod(short s) {
        this.x = (short) (this.x % s);
        this.y = (short) (this.y % s);
        this.z = (short) (this.z % s);
        this.w = (short) (this.w % s);
    }

    public void mul(Short4 short4) {
        this.x = (short) (this.x * short4.x);
        this.y = (short) (this.y * short4.y);
        this.z = (short) (this.z * short4.z);
        this.w = (short) (this.w * short4.w);
    }

    public void mul(short s) {
        this.x = (short) (this.x * s);
        this.y = (short) (this.y * s);
        this.z = (short) (this.z * s);
        this.w = (short) (this.w * s);
    }

    public void negate() {
        this.x = (short) (-this.x);
        this.y = (short) (-this.y);
        this.z = (short) (-this.z);
        this.w = (short) (-this.w);
    }

    public void set(Short4 short4) {
        this.x = short4.x;
        this.y = short4.y;
        this.z = short4.z;
        this.w = short4.w;
    }

    public void setAt(int i, short s) {
        switch (i) {
            case 0:
                this.x = s;
                return;
            case 1:
                this.y = s;
                return;
            case 2:
                this.z = s;
                return;
            case 3:
                this.w = s;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(short s, short s2, short s3, short s4) {
        this.x = s;
        this.y = s2;
        this.z = s3;
        this.w = s4;
    }

    public void sub(Short4 short4) {
        this.x = (short) (this.x - short4.x);
        this.y = (short) (this.y - short4.y);
        this.z = (short) (this.z - short4.z);
        this.w = (short) (this.w - short4.w);
    }

    public void sub(short s) {
        this.x = (short) (this.x - s);
        this.y = (short) (this.y - s);
        this.z = (short) (this.z - s);
        this.w = (short) (this.w - s);
    }
}
