package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBufferAsIntBuffer.class */
final class ByteBufferAsIntBuffer extends IntBuffer {
    private final ByteBuffer byteBuffer;

    private ByteBufferAsIntBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / 4, byteBuffer.effectiveDirectAddress);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsIntBuffer(slice);
    }

    @Override // java.nio.IntBuffer
    public IntBuffer asReadOnlyBuffer() {
        ByteBufferAsIntBuffer byteBufferAsIntBuffer = new ByteBufferAsIntBuffer(this.byteBuffer.asReadOnlyBuffer());
        byteBufferAsIntBuffer.limit = this.limit;
        byteBufferAsIntBuffer.position = this.position;
        byteBufferAsIntBuffer.mark = this.mark;
        byteBufferAsIntBuffer.byteBuffer.order = this.byteBuffer.order;
        return byteBufferAsIntBuffer;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer compact() {
        if (this.byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        this.byteBuffer.compact();
        this.byteBuffer.clear();
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer duplicate() {
        ByteBufferAsIntBuffer byteBufferAsIntBuffer = new ByteBufferAsIntBuffer(this.byteBuffer.duplicate().order(this.byteBuffer.order()));
        byteBufferAsIntBuffer.limit = this.limit;
        byteBufferAsIntBuffer.position = this.position;
        byteBufferAsIntBuffer.mark = this.mark;
        return byteBufferAsIntBuffer;
    }

    @Override // java.nio.IntBuffer
    public int get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return byteBuffer.getInt(i * 4);
    }

    @Override // java.nio.IntBuffer
    public int get(int i) {
        checkIndex(i);
        return this.byteBuffer.getInt(i * 4);
    }

    @Override // java.nio.IntBuffer
    public IntBuffer get(int[] iArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).get(iArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).get(iArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.IntBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.byteBuffer.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.byteBuffer.isReadOnly();
    }

    @Override // java.nio.IntBuffer
    public ByteOrder order() {
        return this.byteBuffer.order();
    }

    @Override // java.nio.IntBuffer
    int[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.IntBuffer
    int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.IntBuffer
    boolean protectedHasArray() {
        return false;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int i) {
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i2 = this.position;
        this.position = i2 + 1;
        byteBuffer.putInt(i2 * 4, i);
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int i, int i2) {
        checkIndex(i);
        this.byteBuffer.putInt(i * 4, i2);
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int[] iArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).put(iArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).put(iArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer slice() {
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        ByteBufferAsIntBuffer byteBufferAsIntBuffer = new ByteBufferAsIntBuffer(this.byteBuffer.slice().order(this.byteBuffer.order()));
        this.byteBuffer.clear();
        return byteBufferAsIntBuffer;
    }
}
