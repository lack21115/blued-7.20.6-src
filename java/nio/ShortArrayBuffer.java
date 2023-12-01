package java.nio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/ShortArrayBuffer.class */
public final class ShortArrayBuffer extends ShortBuffer {
    private final int arrayOffset;
    private final short[] backingArray;
    private final boolean isReadOnly;

    private ShortArrayBuffer(int i, short[] sArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = sArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortArrayBuffer(short[] sArr) {
        this(sArr.length, sArr, 0, false);
    }

    private static ShortArrayBuffer copy(ShortArrayBuffer shortArrayBuffer, int i, boolean z) {
        ShortArrayBuffer shortArrayBuffer2 = new ShortArrayBuffer(shortArrayBuffer.capacity(), shortArrayBuffer.backingArray, shortArrayBuffer.arrayOffset, z);
        shortArrayBuffer2.limit = shortArrayBuffer.limit;
        shortArrayBuffer2.position = shortArrayBuffer.position();
        shortArrayBuffer2.mark = i;
        return shortArrayBuffer2;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.ShortBuffer
    public final ShortBuffer get(short[] sArr, int i, int i2) {
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, sArr, i, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public final short get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        short[] sArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return sArr[i + i2];
    }

    @Override // java.nio.ShortBuffer
    public final short get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.ShortBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.ShortBuffer
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @Override // java.nio.ShortBuffer
    short[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.ShortBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.ShortBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(int i, short s) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = s;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(short s) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        short[] sArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        sArr[i + i2] = s;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(short[] sArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(sArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer slice() {
        return new ShortArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }
}
