package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBufferAsFloatBuffer.class */
final class ByteBufferAsFloatBuffer extends FloatBuffer {
    private final ByteBuffer byteBuffer;

    ByteBufferAsFloatBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / 4, byteBuffer.effectiveDirectAddress);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsFloatBuffer(slice);
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer asReadOnlyBuffer() {
        ByteBufferAsFloatBuffer byteBufferAsFloatBuffer = new ByteBufferAsFloatBuffer(this.byteBuffer.asReadOnlyBuffer());
        byteBufferAsFloatBuffer.limit = this.limit;
        byteBufferAsFloatBuffer.position = this.position;
        byteBufferAsFloatBuffer.mark = this.mark;
        byteBufferAsFloatBuffer.byteBuffer.order = this.byteBuffer.order;
        return byteBufferAsFloatBuffer;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer compact() {
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

    @Override // java.nio.FloatBuffer
    public FloatBuffer duplicate() {
        ByteBufferAsFloatBuffer byteBufferAsFloatBuffer = new ByteBufferAsFloatBuffer(this.byteBuffer.duplicate().order(this.byteBuffer.order()));
        byteBufferAsFloatBuffer.limit = this.limit;
        byteBufferAsFloatBuffer.position = this.position;
        byteBufferAsFloatBuffer.mark = this.mark;
        return byteBufferAsFloatBuffer;
    }

    @Override // java.nio.FloatBuffer
    public float get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return byteBuffer.getFloat(i * 4);
    }

    @Override // java.nio.FloatBuffer
    public float get(int i) {
        checkIndex(i);
        return this.byteBuffer.getFloat(i * 4);
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer get(float[] fArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).get(fArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).get(fArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.byteBuffer.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.byteBuffer.isReadOnly();
    }

    @Override // java.nio.FloatBuffer
    public ByteOrder order() {
        return this.byteBuffer.order();
    }

    @Override // java.nio.FloatBuffer
    float[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.FloatBuffer
    int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.FloatBuffer
    boolean protectedHasArray() {
        return false;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float f) {
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        byteBuffer.putFloat(i * 4, f);
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(int i, float f) {
        checkIndex(i);
        this.byteBuffer.putFloat(i * 4, f);
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float[] fArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).put(fArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).put(fArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer slice() {
        this.byteBuffer.limit(this.limit * 4);
        this.byteBuffer.position(this.position * 4);
        ByteBufferAsFloatBuffer byteBufferAsFloatBuffer = new ByteBufferAsFloatBuffer(this.byteBuffer.slice().order(this.byteBuffer.order()));
        this.byteBuffer.clear();
        return byteBufferAsFloatBuffer;
    }
}
