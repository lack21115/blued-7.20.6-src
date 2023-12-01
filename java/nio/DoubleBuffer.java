package java.nio;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/DoubleBuffer.class */
public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleBuffer(int i, long j) {
        super(3, i, j);
    }

    public static DoubleBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new DoubleArrayBuffer(new double[i]);
    }

    public static DoubleBuffer wrap(double[] dArr) {
        return wrap(dArr, 0, dArr.length);
    }

    public static DoubleBuffer wrap(double[] dArr, int i, int i2) {
        Arrays.checkOffsetAndCount(dArr.length, i, i2);
        DoubleArrayBuffer doubleArrayBuffer = new DoubleArrayBuffer(dArr);
        doubleArrayBuffer.position = i;
        doubleArrayBuffer.limit = i + i2;
        return doubleArrayBuffer;
    }

    @Override // java.nio.Buffer
    public final double[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract DoubleBuffer asReadOnlyBuffer();

    public abstract DoubleBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(DoubleBuffer doubleBuffer) {
        int i = this.position;
        int i2 = doubleBuffer.position;
        for (int remaining = remaining() < doubleBuffer.remaining() ? remaining() : doubleBuffer.remaining(); remaining > 0; remaining--) {
            double d = get(i);
            double d2 = doubleBuffer.get(i2);
            if (d != d2 && (d == d || d2 == d2)) {
                return d < d2 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - doubleBuffer.remaining();
    }

    public abstract DoubleBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof DoubleBuffer) {
            DoubleBuffer doubleBuffer = (DoubleBuffer) obj;
            if (remaining() == doubleBuffer.remaining()) {
                int i = doubleBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    double d = get(i2);
                    double d2 = doubleBuffer.get(i);
                    z = d == d2 || !(d == d || d2 == d2);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public abstract double get();

    public abstract double get(int i);

    public DoubleBuffer get(double[] dArr) {
        return get(dArr, 0, dArr.length);
    }

    public DoubleBuffer get(double[] dArr, int i, int i2) {
        Arrays.checkOffsetAndCount(dArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            dArr[i4] = get();
            i3 = i4 + 1;
        }
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return protectedHasArray();
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.position; i2 < this.limit; i2++) {
            long doubleToLongBits = Double.doubleToLongBits(get(i2));
            i = (((int) doubleToLongBits) + i) ^ ((int) (doubleToLongBits >> 32));
        }
        return i;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    public abstract ByteOrder order();

    abstract double[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract DoubleBuffer put(double d);

    public abstract DoubleBuffer put(int i, double d);

    public DoubleBuffer put(DoubleBuffer doubleBuffer) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (doubleBuffer == this) {
            throw new IllegalArgumentException("src == this");
        }
        if (doubleBuffer.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        double[] dArr = new double[doubleBuffer.remaining()];
        doubleBuffer.get(dArr);
        put(dArr);
        return this;
    }

    public final DoubleBuffer put(double[] dArr) {
        return put(dArr, 0, dArr.length);
    }

    public DoubleBuffer put(double[] dArr, int i, int i2) {
        Arrays.checkOffsetAndCount(dArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(dArr[i4]);
            i3 = i4 + 1;
        }
    }

    public abstract DoubleBuffer slice();
}
