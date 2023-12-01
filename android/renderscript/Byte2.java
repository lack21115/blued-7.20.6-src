package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Byte2.class */
public class Byte2 {
    public byte x;
    public byte y;

    public Byte2() {
    }

    public Byte2(byte b, byte b2) {
        this.x = b;
        this.y = b2;
    }

    public Byte2(Byte2 byte2) {
        this.x = byte2.x;
        this.y = byte2.y;
    }

    public static Byte2 add(Byte2 byte2, byte b) {
        Byte2 byte22 = new Byte2();
        byte22.x = (byte) (byte2.x + b);
        byte22.y = (byte) (byte2.y + b);
        return byte22;
    }

    public static Byte2 add(Byte2 byte2, Byte2 byte22) {
        Byte2 byte23 = new Byte2();
        byte23.x = (byte) (byte2.x + byte22.x);
        byte23.y = (byte) (byte2.y + byte22.y);
        return byte23;
    }

    public static Byte2 div(Byte2 byte2, byte b) {
        Byte2 byte22 = new Byte2();
        byte22.x = (byte) (byte2.x / b);
        byte22.y = (byte) (byte2.y / b);
        return byte22;
    }

    public static Byte2 div(Byte2 byte2, Byte2 byte22) {
        Byte2 byte23 = new Byte2();
        byte23.x = (byte) (byte2.x / byte22.x);
        byte23.y = (byte) (byte2.y / byte22.y);
        return byte23;
    }

    public static byte dotProduct(Byte2 byte2, Byte2 byte22) {
        return (byte) ((byte22.x * byte2.x) + (byte22.y * byte2.y));
    }

    public static Byte2 mul(Byte2 byte2, byte b) {
        Byte2 byte22 = new Byte2();
        byte22.x = (byte) (byte2.x * b);
        byte22.y = (byte) (byte2.y * b);
        return byte22;
    }

    public static Byte2 mul(Byte2 byte2, Byte2 byte22) {
        Byte2 byte23 = new Byte2();
        byte23.x = (byte) (byte2.x * byte22.x);
        byte23.y = (byte) (byte2.y * byte22.y);
        return byte23;
    }

    public static Byte2 sub(Byte2 byte2, byte b) {
        Byte2 byte22 = new Byte2();
        byte22.x = (byte) (byte2.x - b);
        byte22.y = (byte) (byte2.y - b);
        return byte22;
    }

    public static Byte2 sub(Byte2 byte2, Byte2 byte22) {
        Byte2 byte23 = new Byte2();
        byte23.x = (byte) (byte2.x - byte22.x);
        byte23.y = (byte) (byte2.y - byte22.y);
        return byte23;
    }

    public void add(byte b) {
        this.x = (byte) (this.x + b);
        this.y = (byte) (this.y + b);
    }

    public void add(Byte2 byte2) {
        this.x = (byte) (this.x + byte2.x);
        this.y = (byte) (this.y + byte2.y);
    }

    public void addAt(int i, byte b) {
        switch (i) {
            case 0:
                this.x = (byte) (this.x + b);
                return;
            case 1:
                this.y = (byte) (this.y + b);
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Byte2 byte2, byte b) {
        this.x = (byte) (this.x + (byte2.x * b));
        this.y = (byte) (this.y + (byte2.y * b));
    }

    public void copyTo(byte[] bArr, int i) {
        bArr[i] = this.x;
        bArr[i + 1] = this.y;
    }

    public void div(byte b) {
        this.x = (byte) (this.x / b);
        this.y = (byte) (this.y / b);
    }

    public void div(Byte2 byte2) {
        this.x = (byte) (this.x / byte2.x);
        this.y = (byte) (this.y / byte2.y);
    }

    public byte dotProduct(Byte2 byte2) {
        return (byte) ((this.x * byte2.x) + (this.y * byte2.y));
    }

    public byte elementSum() {
        return (byte) (this.x + this.y);
    }

    public byte get(int i) {
        switch (i) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public byte length() {
        return (byte) 2;
    }

    public void mul(byte b) {
        this.x = (byte) (this.x * b);
        this.y = (byte) (this.y * b);
    }

    public void mul(Byte2 byte2) {
        this.x = (byte) (this.x * byte2.x);
        this.y = (byte) (this.y * byte2.y);
    }

    public void negate() {
        this.x = (byte) (-this.x);
        this.y = (byte) (-this.y);
    }

    public void set(Byte2 byte2) {
        this.x = byte2.x;
        this.y = byte2.y;
    }

    public void setAt(int i, byte b) {
        switch (i) {
            case 0:
                this.x = b;
                return;
            case 1:
                this.y = b;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(byte b, byte b2) {
        this.x = b;
        this.y = b2;
    }

    public void sub(byte b) {
        this.x = (byte) (this.x - b);
        this.y = (byte) (this.y - b);
    }

    public void sub(Byte2 byte2) {
        this.x = (byte) (this.x - byte2.x);
        this.y = (byte) (this.y - byte2.y);
    }
}
