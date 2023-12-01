package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Long3.class */
public class Long3 {
    public long x;
    public long y;
    public long z;

    public Long3() {
    }

    public Long3(long j) {
        this.z = j;
        this.y = j;
        this.x = j;
    }

    public Long3(long j, long j2, long j3) {
        this.x = j;
        this.y = j2;
        this.z = j3;
    }

    public Long3(Long3 long3) {
        this.x = long3.x;
        this.y = long3.y;
        this.z = long3.z;
    }

    public static Long3 add(Long3 long3, long j) {
        Long3 long32 = new Long3();
        long32.x = long3.x + j;
        long32.y = long3.y + j;
        long32.z = long3.z + j;
        return long32;
    }

    public static Long3 add(Long3 long3, Long3 long32) {
        Long3 long33 = new Long3();
        long33.x = long3.x + long32.x;
        long33.y = long3.y + long32.y;
        long33.z = long3.z + long32.z;
        return long33;
    }

    public static Long3 div(Long3 long3, long j) {
        Long3 long32 = new Long3();
        long32.x = long3.x / j;
        long32.y = long3.y / j;
        long32.z = long3.z / j;
        return long32;
    }

    public static Long3 div(Long3 long3, Long3 long32) {
        Long3 long33 = new Long3();
        long33.x = long3.x / long32.x;
        long33.y = long3.y / long32.y;
        long33.z = long3.z / long32.z;
        return long33;
    }

    public static long dotProduct(Long3 long3, Long3 long32) {
        return (long32.x * long3.x) + (long32.y * long3.y) + (long32.z * long3.z);
    }

    public static Long3 mod(Long3 long3, long j) {
        Long3 long32 = new Long3();
        long32.x = long3.x % j;
        long32.y = long3.y % j;
        long32.z = long3.z % j;
        return long32;
    }

    public static Long3 mod(Long3 long3, Long3 long32) {
        Long3 long33 = new Long3();
        long33.x = long3.x % long32.x;
        long33.y = long3.y % long32.y;
        long33.z = long3.z % long32.z;
        return long33;
    }

    public static Long3 mul(Long3 long3, long j) {
        Long3 long32 = new Long3();
        long32.x = long3.x * j;
        long32.y = long3.y * j;
        long32.z = long3.z * j;
        return long32;
    }

    public static Long3 mul(Long3 long3, Long3 long32) {
        Long3 long33 = new Long3();
        long33.x = long3.x * long32.x;
        long33.y = long3.y * long32.y;
        long33.z = long3.z * long32.z;
        return long33;
    }

    public static Long3 sub(Long3 long3, long j) {
        Long3 long32 = new Long3();
        long32.x = long3.x - j;
        long32.y = long3.y - j;
        long32.z = long3.z - j;
        return long32;
    }

    public static Long3 sub(Long3 long3, Long3 long32) {
        Long3 long33 = new Long3();
        long33.x = long3.x - long32.x;
        long33.y = long3.y - long32.y;
        long33.z = long3.z - long32.z;
        return long33;
    }

    public void add(long j) {
        this.x += j;
        this.y += j;
        this.z += j;
    }

    public void add(Long3 long3) {
        this.x += long3.x;
        this.y += long3.y;
        this.z += long3.z;
    }

    public void addAt(int i, long j) {
        switch (i) {
            case 0:
                this.x += j;
                return;
            case 1:
                this.y += j;
                return;
            case 2:
                this.z += j;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void addMultiple(Long3 long3, long j) {
        this.x += long3.x * j;
        this.y += long3.y * j;
        this.z += long3.z * j;
    }

    public void copyTo(long[] jArr, int i) {
        jArr[i] = this.x;
        jArr[i + 1] = this.y;
        jArr[i + 2] = this.z;
    }

    public void div(long j) {
        this.x /= j;
        this.y /= j;
        this.z /= j;
    }

    public void div(Long3 long3) {
        this.x /= long3.x;
        this.y /= long3.y;
        this.z /= long3.z;
    }

    public long dotProduct(Long3 long3) {
        return (this.x * long3.x) + (this.y * long3.y) + (this.z * long3.z);
    }

    public long elementSum() {
        return this.x + this.y + this.z;
    }

    public long get(int i) {
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

    public long length() {
        return 3L;
    }

    public void mod(long j) {
        this.x %= j;
        this.y %= j;
        this.z %= j;
    }

    public void mod(Long3 long3) {
        this.x %= long3.x;
        this.y %= long3.y;
        this.z %= long3.z;
    }

    public void mul(long j) {
        this.x *= j;
        this.y *= j;
        this.z *= j;
    }

    public void mul(Long3 long3) {
        this.x *= long3.x;
        this.y *= long3.y;
        this.z *= long3.z;
    }

    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public void set(Long3 long3) {
        this.x = long3.x;
        this.y = long3.y;
        this.z = long3.z;
    }

    public void setAt(int i, long j) {
        switch (i) {
            case 0:
                this.x = j;
                return;
            case 1:
                this.y = j;
                return;
            case 2:
                this.z = j;
                return;
            default:
                throw new IndexOutOfBoundsException("Index: i");
        }
    }

    public void setValues(long j, long j2, long j3) {
        this.x = j;
        this.y = j2;
        this.z = j3;
    }

    public void sub(long j) {
        this.x -= j;
        this.y -= j;
        this.z -= j;
    }

    public void sub(Long3 long3) {
        this.x -= long3.x;
        this.y -= long3.y;
        this.z -= long3.z;
    }
}
