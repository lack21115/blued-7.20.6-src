package java.nio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/DoubleArrayBuffer.class */
public final class DoubleArrayBuffer extends DoubleBuffer {
    private final int arrayOffset;
    private final double[] backingArray;
    private final boolean isReadOnly;

    private DoubleArrayBuffer(int i, double[] dArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = dArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleArrayBuffer(double[] dArr) {
        this(dArr.length, dArr, 0, false);
    }

    private static DoubleArrayBuffer copy(DoubleArrayBuffer doubleArrayBuffer, int i, boolean z) {
        DoubleArrayBuffer doubleArrayBuffer2 = new DoubleArrayBuffer(doubleArrayBuffer.capacity(), doubleArrayBuffer.backingArray, doubleArrayBuffer.arrayOffset, z);
        doubleArrayBuffer2.limit = doubleArrayBuffer.limit;
        doubleArrayBuffer2.position = doubleArrayBuffer.position();
        doubleArrayBuffer2.mark = i;
        return doubleArrayBuffer2;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.DoubleBuffer
    public final double get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        double[] dArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return dArr[i + i2];
    }

    @Override // java.nio.DoubleBuffer
    public final double get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.DoubleBuffer
    public final DoubleBuffer get(double[] dArr, int i, int i2) {
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, dArr, i, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.DoubleBuffer
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @Override // java.nio.DoubleBuffer
    double[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.DoubleBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.DoubleBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double d) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        double[] dArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        dArr[i + i2] = d;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(int i, double d) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = d;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double[] dArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(dArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer slice() {
        return new DoubleArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }
}
