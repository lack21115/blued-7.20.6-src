package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Byte4.class */
public class Byte4 {
    public byte w;
    public byte x;
    public byte y;
    public byte z;

    public Byte4() {
    }

    public Byte4(byte b, byte b2, byte b3, byte b4) {
        this.x = b;
        this.y = b2;
        this.z = b3;
        this.w = b4;
    }

    public Byte4(Byte4 byte4) {
        this.x = byte4.x;
        this.y = byte4.y;
        this.z = byte4.z;
        this.w = byte4.w;
    }

    public static Byte4 add(Byte4 byte4, byte b) {
        Byte4 byte42 = new Byte4();
        byte42.x = (byte) (byte4.x + b);
        byte42.y = (byte) (byte4.y + b);
        byte42.z = (byte) (byte4.z + b);
        byte42.w = (byte) (byte4.w + b);
        return byte42;
    }

    public static Byte4 add(Byte4 byte4, Byte4 byte42) {
        Byte4 byte43 = new Byte4();
        byte43.x = (byte) (byte4.x + byte42.x);
        byte43.y = (byte) (byte4.y + byte42.y);
        byte43.z = (byte) (byte4.z + byte42.z);
        byte43.w = (byte) (byte4.w + byte42.w);
        return byte43;
    }

    public static Byte4 div(Byte4 byte4, byte b) {
        Byte4 byte42 = new Byte4();
        byte42.x = (byte) (byte4.x / b);
        byte42.y = (byte) (byte4.y / b);
        byte42.z = (byte) (byte4.z / b);
        byte42.w = (byte) (byte4.w / b);
        return byte42;
    }

    public static Byte4 div(Byte4 byte4, Byte4 byte42) {
        Byte4 byte43 = new Byte4();
        byte43.x = (byte) (byte4.x / byte42.x);
        byte43.y = (byte) (byte4.y / byte42.y);
        byte43.z = (byte) (byte4.z / byte42.z);
        byte43.w = (byte) (byte4.w / byte42.w);
        return byte43;
    }

    public static byte dotProduct(Byte4 byte4, Byte4 byte42) {
        return (byte) ((byte42.x * byte4.x) + (byte42.y * byte4.y) + (byte42.z * byte4.z) + (byte42.w * byte4.w));
    }

    public static Byte4 mul(Byte4 byte4, byte b) {
        Byte4 byte42 = new Byte4();
        byte42.x = (byte) (byte4.x * b);
        byte42.y = (byte) (byte4.y * b);
        byte42.z = (byte) (byte4.z * b);
        byte42.w = (byte) (byte4.w * b);
        return byte42;
    }

    public static Byte4 mul(Byte4 byte4, Byte4 byte42) {
        Byte4 byte43 = new Byte4();
        byte43.x = (byte) (byte4.x * byte42.x);
        byte43.y = (byte) (byte4.y * byte42.y);
        byte43.z = (byte) (byte4.z * byte42.z);
        byte43.w = (byte) (byte4.w * byte42.w);
        return byte43;
    }

    public static Byte4 sub(Byte4 byte4, byte b) {
        Byte4 byte42 = new Byte4();
        byte42.x = (byte) (byte4.x - b);
        byte42.y = (byte) (byte4.y - b);
        byte42.z = (byte) (byte4.z - b);
        byte42.w = (byte) (byte4.w - b);
        return byte42;
    }

    public static Byte4 sub(Byte4 byte4, Byte4 byte42) {
        Byte4 byte43 = new Byte4();
        byte43.x = (byte) (byte4.x - byte42.x);
        byte43.y = (byte) (byte4.y - byte42.y);
        byte43.z = (byte) (byte4.z - byte42.z);
        byte43.w = (byte) (byte4.w - byte42.w);
        return byte43;
    }

    public void add(byte b) {
        this.x = (byte) (this.x + b);
        this.y = (byte) (this.y + b);
        this.z = (byte) (this.z + b);
        this.w = (byte) (this.w + b);
    }

    public void add(Byte4 byte4) {
        this.x = (byte) (this.x + byte4.x);
        this.y = (byte) (this.y + byte4.y);
        this.z = (byte) (this.z + byte4.z);
        this.w = (byte) (this.w + byte4.w);
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
            case 3:
                this.w = (byte) (this.w + b);
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Byte4 byte4, byte b) {
        this.x = (byte) (this.x + (byte4.x * b));
        this.y = (byte) (this.y + (byte4.y * b));
        this.z = (byte) (this.z + (byte4.z * b));
        this.w = (byte) (this.w + (byte4.w * b));
    }

    public void copyTo(byte[] bArr, int i) {
        bArr[i] = this.x;
        bArr[i + 1] = this.y;
        bArr[i + 2] = this.z;
        bArr[i + 3] = this.w;
    }

    public void div(byte b) {
        this.x = (byte) (this.x / b);
        this.y = (byte) (this.y / b);
        this.z = (byte) (this.z / b);
        this.w = (byte) (this.w / b);
    }

    public void div(Byte4 byte4) {
        this.x = (byte) (this.x / byte4.x);
        this.y = (byte) (this.y / byte4.y);
        this.z = (byte) (this.z / byte4.z);
        this.w = (byte) (this.w / byte4.w);
    }

    public byte dotProduct(Byte4 byte4) {
        return (byte) ((this.x * byte4.x) + (this.y * byte4.y) + (this.z * byte4.z) + (this.w * byte4.w));
    }

    public byte elementSum() {
        return (byte) (this.x + this.y + this.z + this.w);
    }

    public byte get(int i) {
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

    public byte length() {
        return (byte) 4;
    }

    public void mul(byte b) {
        this.x = (byte) (this.x * b);
        this.y = (byte) (this.y * b);
        this.z = (byte) (this.z * b);
        this.w = (byte) (this.w * b);
    }

    public void mul(Byte4 byte4) {
        this.x = (byte) (this.x * byte4.x);
        this.y = (byte) (this.y * byte4.y);
        this.z = (byte) (this.z * byte4.z);
        this.w = (byte) (this.w * byte4.w);
    }

    public void negate() {
        this.x = (byte) (-this.x);
        this.y = (byte) (-this.y);
        this.z = (byte) (-this.z);
        this.w = (byte) (-this.w);
    }

    public void set(Byte4 byte4) {
        this.x = byte4.x;
        this.y = byte4.y;
        this.z = byte4.z;
        this.w = byte4.w;
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
            case 3:
                this.w = b;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(byte b, byte b2, byte b3, byte b4) {
        this.x = b;
        this.y = b2;
        this.z = b3;
        this.w = b4;
    }

    public void sub(byte b) {
        this.x = (byte) (this.x - b);
        this.y = (byte) (this.y - b);
        this.z = (byte) (this.z - b);
        this.w = (byte) (this.w - b);
    }

    public void sub(Byte4 byte4) {
        this.x = (byte) (this.x - byte4.x);
        this.y = (byte) (this.y - byte4.y);
        this.z = (byte) (this.z - byte4.z);
        this.w = (byte) (this.w - byte4.w);
    }
}
