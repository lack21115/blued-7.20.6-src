package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Byte3.class */
public class Byte3 {
    public byte x;
    public byte y;
    public byte z;

    public Byte3() {
    }

    public Byte3(byte b, byte b2, byte b3) {
        this.x = b;
        this.y = b2;
        this.z = b3;
    }

    public Byte3(Byte3 byte3) {
        this.x = byte3.x;
        this.y = byte3.y;
        this.z = byte3.z;
    }

    public static Byte3 add(Byte3 byte3, byte b) {
        Byte3 byte32 = new Byte3();
        byte32.x = (byte) (byte3.x + b);
        byte32.y = (byte) (byte3.y + b);
        byte32.z = (byte) (byte3.z + b);
        return byte32;
    }

    public static Byte3 add(Byte3 byte3, Byte3 byte32) {
        Byte3 byte33 = new Byte3();
        byte33.x = (byte) (byte3.x + byte32.x);
        byte33.y = (byte) (byte3.y + byte32.y);
        byte33.z = (byte) (byte3.z + byte32.z);
        return byte33;
    }

    public static Byte3 div(Byte3 byte3, byte b) {
        Byte3 byte32 = new Byte3();
        byte32.x = (byte) (byte3.x / b);
        byte32.y = (byte) (byte3.y / b);
        byte32.z = (byte) (byte3.z / b);
        return byte32;
    }

    public static Byte3 div(Byte3 byte3, Byte3 byte32) {
        Byte3 byte33 = new Byte3();
        byte33.x = (byte) (byte3.x / byte32.x);
        byte33.y = (byte) (byte3.y / byte32.y);
        byte33.z = (byte) (byte3.z / byte32.z);
        return byte33;
    }

    public static byte dotProduct(Byte3 byte3, Byte3 byte32) {
        return (byte) (((byte) (((byte) (byte32.x * byte3.x)) + ((byte) (byte32.y * byte3.y)))) + ((byte) (byte32.z * byte3.z)));
    }

    public static Byte3 mul(Byte3 byte3, byte b) {
        Byte3 byte32 = new Byte3();
        byte32.x = (byte) (byte3.x * b);
        byte32.y = (byte) (byte3.y * b);
        byte32.z = (byte) (byte3.z * b);
        return byte32;
    }

    public static Byte3 mul(Byte3 byte3, Byte3 byte32) {
        Byte3 byte33 = new Byte3();
        byte33.x = (byte) (byte3.x * byte32.x);
        byte33.y = (byte) (byte3.y * byte32.y);
        byte33.z = (byte) (byte3.z * byte32.z);
        return byte33;
    }

    public static Byte3 sub(Byte3 byte3, byte b) {
        Byte3 byte32 = new Byte3();
        byte32.x = (byte) (byte3.x - b);
        byte32.y = (byte) (byte3.y - b);
        byte32.z = (byte) (byte3.z - b);
        return byte32;
    }

    public static Byte3 sub(Byte3 byte3, Byte3 byte32) {
        Byte3 byte33 = new Byte3();
        byte33.x = (byte) (byte3.x - byte32.x);
        byte33.y = (byte) (byte3.y - byte32.y);
        byte33.z = (byte) (byte3.z - byte32.z);
        return byte33;
    }

    public void add(byte b) {
        this.x = (byte) (this.x + b);
        this.y = (byte) (this.y + b);
        this.z = (byte) (this.z + b);
    }

    public void add(Byte3 byte3) {
        this.x = (byte) (this.x + byte3.x);
        this.y = (byte) (this.y + byte3.y);
        this.z = (byte) (this.z + byte3.z);
    }

    public void addAt(int i, byte b) {
        switch (i) {
            case 0:
                this.x = (byte) (this.x + b);
                return;
            case 1:
                this.y = (byte) (this.y + b);
                return;
            case 2:
                this.z = (byte) (this.z + b);
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Byte3 byte3, byte b) {
        this.x = (byte) (this.x + (byte3.x * b));
        this.y = (byte) (this.y + (byte3.y * b));
        this.z = (byte) (this.z + (byte3.z * b));
    }

    public void copyTo(byte[] bArr, int i) {
        bArr[i] = this.x;
        bArr[i + 1] = this.y;
        bArr[i + 2] = this.z;
    }

    public void div(byte b) {
        this.x = (byte) (this.x / b);
        this.y = (byte) (this.y / b);
        this.z = (byte) (this.z / b);
    }

    public void div(Byte3 byte3) {
        this.x = (byte) (this.x / byte3.x);
        this.y = (byte) (this.y / byte3.y);
        this.z = (byte) (this.z / byte3.z);
    }

    public byte dotProduct(Byte3 byte3) {
        return (byte) (((byte) (((byte) (this.x * byte3.x)) + ((byte) (this.y * byte3.y)))) + ((byte) (this.z * byte3.z)));
    }

    public byte elementSum() {
        return (byte) (this.x + this.y + this.z);
    }

    public byte get(int i) {
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

    public byte length() {
        return (byte) 3;
    }

    public void mul(byte b) {
        this.x = (byte) (this.x * b);
        this.y = (byte) (this.y * b);
        this.z = (byte) (this.z * b);
    }

    public void mul(Byte3 byte3) {
        this.x = (byte) (this.x * byte3.x);
        this.y = (byte) (this.y * byte3.y);
        this.z = (byte) (this.z * byte3.z);
    }

    public void negate() {
        this.x = (byte) (-this.x);
        this.y = (byte) (-this.y);
        this.z = (byte) (-this.z);
    }

    public void set(Byte3 byte3) {
        this.x = byte3.x;
        this.y = byte3.y;
        this.z = byte3.z;
    }

    public void setAt(int i, byte b) {
        switch (i) {
            case 0:
                this.x = b;
                return;
            case 1:
                this.y = b;
                return;
            case 2:
                this.z = b;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(byte b, byte b2, byte b3) {
        this.x = b;
        this.y = b2;
        this.z = b3;
    }

    public void sub(byte b) {
        this.x = (byte) (this.x - b);
        this.y = (byte) (this.y - b);
        this.z = (byte) (this.z - b);
    }

    public void sub(Byte3 byte3) {
        this.x = (byte) (this.x - byte3.x);
        this.y = (byte) (this.y - byte3.y);
        this.z = (byte) (this.z - byte3.z);
    }
}
