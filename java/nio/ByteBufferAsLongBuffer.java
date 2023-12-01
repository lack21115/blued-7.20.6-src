package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBufferAsLongBuffer.class */
final class ByteBufferAsLongBuffer extends LongBuffer {
    private final ByteBuffer byteBuffer;

    private ByteBufferAsLongBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / 8, byteBuffer.effectiveDirectAddress);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LongBuffer asLongBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsLongBuffer(slice);
    }

    @Override // java.nio.LongBuffer
    public LongBuffer asReadOnlyBuffer() {
        ByteBufferAsLongBuffer byteBufferAsLongBuffer = new ByteBufferAsLongBuffer(this.byteBuffer.asReadOnlyBuffer());
        byteBufferAsLongBuffer.limit = this.limit;
        byteBufferAsLongBuffer.position = this.position;
        byteBufferAsLongBuffer.mark = this.mark;
        byteBufferAsLongBuffer.byteBuffer.order = this.byteBuffer.order;
        return byteBufferAsLongBuffer;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer compact() {
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

    @Override // java.nio.LongBuffer
    public LongBuffer duplicate() {
        ByteBufferAsLongBuffer byteBufferAsLongBuffer = new ByteBufferAsLongBuffer(this.byteBuffer.duplicate().order(this.byteBuffer.order()));
        byteBufferAsLongBuffer.limit = this.limit;
        byteBufferAsLongBuffer.position = this.position;
        byteBufferAsLongBuffer.mark = this.mark;
        return byteBufferAsLongBuffer;
    }

    @Override // java.nio.LongBuffer
    public long get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return byteBuffer.getLong(i * 8);
    }

    @Override // java.nio.LongBuffer
    public long get(int i) {
        checkIndex(i);
        return this.byteBuffer.getLong(i * 8);
    }

    @Override // java.nio.LongBuffer
    public LongBuffer get(long[] jArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).get(jArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).get(jArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.LongBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.byteBuffer.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.byteBuffer.isReadOnly();
    }

    @Override // java.nio.LongBuffer
    public ByteOrder order() {
        return this.byteBuffer.order();
    }

    @Override // java.nio.LongBuffer
    long[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.LongBuffer
    int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.LongBuffer
    boolean protectedHasArray() {
        return false;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(int i, long j) {
        checkIndex(i);
        this.byteBuffer.putLong(i * 8, j);
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(long j) {
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        byteBuffer.putLong(i * 8, j);
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(long[] jArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).put(jArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).put(jArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer slice() {
        this.byteBuffer.limit(this.limit * 8);
        this.byteBuffer.position(this.position * 8);
        ByteBufferAsLongBuffer byteBufferAsLongBuffer = new ByteBufferAsLongBuffer(this.byteBuffer.slice().order(this.byteBuffer.order()));
        this.byteBuffer.clear();
        return byteBufferAsLongBuffer;
    }
}
