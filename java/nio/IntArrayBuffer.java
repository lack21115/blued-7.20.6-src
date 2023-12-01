package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/IntArrayBuffer.class */
final class IntArrayBuffer extends IntBuffer {
    private final int arrayOffset;
    private final int[] backingArray;
    private final boolean isReadOnly;

    private IntArrayBuffer(int i, int[] iArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = iArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntArrayBuffer(int[] iArr) {
        this(iArr.length, iArr, 0, false);
    }

    private static IntArrayBuffer copy(IntArrayBuffer intArrayBuffer, int i, boolean z) {
        IntArrayBuffer intArrayBuffer2 = new IntArrayBuffer(intArrayBuffer.capacity(), intArrayBuffer.backingArray, intArrayBuffer.arrayOffset, z);
        intArrayBuffer2.limit = intArrayBuffer.limit;
        intArrayBuffer2.position = intArrayBuffer.position();
        intArrayBuffer2.mark = i;
        return intArrayBuffer2;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.IntBuffer
    public IntBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.IntBuffer
    public final int get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        int[] iArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return iArr[i + i2];
    }

    @Override // java.nio.IntBuffer
    public final int get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.IntBuffer
    public final IntBuffer get(int[] iArr, int i, int i2) {
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, iArr, i, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.IntBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.IntBuffer
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @Override // java.nio.IntBuffer
    int[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.IntBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.IntBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int i) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        int[] iArr = this.backingArray;
        int i2 = this.arrayOffset;
        int i3 = this.position;
        this.position = i3 + 1;
        iArr[i2 + i3] = i;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = i2;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int[] iArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(iArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer slice() {
        return new IntArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }
}
