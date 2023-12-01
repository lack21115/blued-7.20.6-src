package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBufferAsShortBuffer.class */
final class ByteBufferAsShortBuffer extends ShortBuffer {
    private final ByteBuffer byteBuffer;

    private ByteBufferAsShortBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / 2, byteBuffer.effectiveDirectAddress);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsShortBuffer(slice);
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer asReadOnlyBuffer() {
        ByteBufferAsShortBuffer byteBufferAsShortBuffer = new ByteBufferAsShortBuffer(this.byteBuffer.asReadOnlyBuffer());
        byteBufferAsShortBuffer.limit = this.limit;
        byteBufferAsShortBuffer.position = this.position;
        byteBufferAsShortBuffer.mark = this.mark;
        byteBufferAsShortBuffer.byteBuffer.order = this.byteBuffer.order;
        return byteBufferAsShortBuffer;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer compact() {
        if (this.byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        this.byteBuffer.compact();
        this.byteBuffer.clear();
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer duplicate() {
        ByteBufferAsShortBuffer byteBufferAsShortBuffer = new ByteBufferAsShortBuffer(this.byteBuffer.duplicate().order(this.byteBuffer.order()));
        byteBufferAsShortBuffer.limit = this.limit;
        byteBufferAsShortBuffer.position = this.position;
        byteBufferAsShortBuffer.mark = this.mark;
        return byteBufferAsShortBuffer;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer get(short[] sArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).get(sArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).get(sArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public short get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return byteBuffer.getShort(i * 2);
    }

    @Override // java.nio.ShortBuffer
    public short get(int i) {
        checkIndex(i);
        return this.byteBuffer.getShort(i * 2);
    }

    @Override // java.nio.ShortBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.byteBuffer.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.byteBuffer.isReadOnly();
    }

    @Override // java.nio.ShortBuffer
    public ByteOrder order() {
        return this.byteBuffer.order();
    }

    @Override // java.nio.ShortBuffer
    short[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.ShortBuffer
    int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.ShortBuffer
    boolean protectedHasArray() {
        return false;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(int i, short s) {
        checkIndex(i);
        this.byteBuffer.putShort(i * 2, s);
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(short s) {
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        byteBuffer.putShort(i * 2, s);
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(short[] sArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).put(sArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).put(sArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer slice() {
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        ByteBufferAsShortBuffer byteBufferAsShortBuffer = new ByteBufferAsShortBuffer(this.byteBuffer.slice().order(this.byteBuffer.order()));
        this.byteBuffer.clear();
        return byteBufferAsShortBuffer;
    }
}
