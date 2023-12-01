package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBufferAsDoubleBuffer.class */
final class ByteBufferAsDoubleBuffer extends DoubleBuffer {
    private final ByteBuffer byteBuffer;

    private ByteBufferAsDoubleBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / 8, byteBuffer.effectiveDirectAddress);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleBuffer asDoubleBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsDoubleBuffer(slice);
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer asReadOnlyBuffer() {
        ByteBufferAsDoubleBuffer byteBufferAsDoubleBuffer = new ByteBufferAsDoubleBuffer(this.byteBuffer.asReadOnlyBuffer());
        byteBufferAsDoubleBuffer.limit = this.limit;
        byteBufferAsDoubleBuffer.position = this.position;
        byteBufferAsDoubleBuffer.mark = this.mark;
        byteBufferAsDoubleBuffer.byteBuffer.order = this.byteBuffer.order;
        return byteBufferAsDoubleBuffer;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer compact() {
        if (this.byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        this.byteBuffer.compact();
        this.byteBuffer.clear();
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer duplicate() {
        ByteBufferAsDoubleBuffer byteBufferAsDoubleBuffer = new ByteBufferAsDoubleBuffer(this.byteBuffer.duplicate().order(this.byteBuffer.order()));
        byteBufferAsDoubleBuffer.limit = this.limit;
        byteBufferAsDoubleBuffer.position = this.position;
        byteBufferAsDoubleBuffer.mark = this.mark;
        return byteBufferAsDoubleBuffer;
    }

    @Override // java.nio.DoubleBuffer
    public double get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return byteBuffer.getDouble(i * 8);
    }

    @Override // java.nio.DoubleBuffer
    public double get(int i) {
        checkIndex(i);
        return this.byteBuffer.getDouble(i * 8);
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer get(double[] dArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).get(dArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).get(dArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.byteBuffer.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.byteBuffer.isReadOnly();
    }

    @Override // java.nio.DoubleBuffer
    public ByteOrder order() {
        return this.byteBuffer.order();
    }

    @Override // java.nio.DoubleBuffer
    double[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.DoubleBuffer
    int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.DoubleBuffer
    boolean protectedHasArray() {
        return false;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double d) {
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        byteBuffer.putDouble(i * 8, d);
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(int i, double d) {
        checkIndex(i);
        this.byteBuffer.putDouble(i * 8, d);
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double[] dArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).put(dArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).put(dArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer slice() {
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        ByteBufferAsDoubleBuffer byteBufferAsDoubleBuffer = new ByteBufferAsDoubleBuffer(this.byteBuffer.slice().order(this.byteBuffer.order()));
        this.byteBuffer.clear();
        return byteBufferAsDoubleBuffer;
    }
}
