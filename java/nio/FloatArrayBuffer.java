package java.nio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/FloatArrayBuffer.class */
public final class FloatArrayBuffer extends FloatBuffer {
    private final int arrayOffset;
    private final float[] backingArray;
    private final boolean isReadOnly;

    private FloatArrayBuffer(int i, float[] fArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = fArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayBuffer(float[] fArr) {
        this(fArr.length, fArr, 0, false);
    }

    private static FloatArrayBuffer copy(FloatArrayBuffer floatArrayBuffer, int i, boolean z) {
        FloatArrayBuffer floatArrayBuffer2 = new FloatArrayBuffer(floatArrayBuffer.capacity(), floatArrayBuffer.backingArray, floatArrayBuffer.arrayOffset, z);
        floatArrayBuffer2.limit = floatArrayBuffer.limit;
        floatArrayBuffer2.position = floatArrayBuffer.position();
        floatArrayBuffer2.mark = i;
        return floatArrayBuffer2;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.FloatBuffer
    public final float get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        float[] fArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return fArr[i + i2];
    }

    @Override // java.nio.FloatBuffer
    public final float get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.FloatBuffer
    public final FloatBuffer get(float[] fArr, int i, int i2) {
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, fArr, i, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.FloatBuffer
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @Override // java.nio.FloatBuffer
    float[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.FloatBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.FloatBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float f) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        float[] fArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        fArr[i + i2] = f;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(int i, float f) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = f;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float[] fArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(fArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer slice() {
        return new FloatArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }
}
