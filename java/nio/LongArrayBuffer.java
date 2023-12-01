package java.nio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/LongArrayBuffer.class */
public final class LongArrayBuffer extends LongBuffer {
    private final int arrayOffset;
    private final long[] backingArray;
    private final boolean isReadOnly;

    private LongArrayBuffer(int i, long[] jArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = jArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongArrayBuffer(long[] jArr) {
        this(jArr.length, jArr, 0, false);
    }

    private static LongArrayBuffer copy(LongArrayBuffer longArrayBuffer, int i, boolean z) {
        LongArrayBuffer longArrayBuffer2 = new LongArrayBuffer(longArrayBuffer.capacity(), longArrayBuffer.backingArray, longArrayBuffer.arrayOffset, z);
        longArrayBuffer2.limit = longArrayBuffer.limit;
        longArrayBuffer2.position = longArrayBuffer.position();
        longArrayBuffer2.mark = i;
        return longArrayBuffer2;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.LongBuffer
    public LongBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.LongBuffer
    public final long get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        long[] jArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return jArr[i + i2];
    }

    @Override // java.nio.LongBuffer
    public final long get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.LongBuffer
    public final LongBuffer get(long[] jArr, int i, int i2) {
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, jArr, i, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.LongBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.LongBuffer
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @Override // java.nio.LongBuffer
    long[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.LongBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.LongBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(int i, long j) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = j;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(long j) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        long[] jArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        jArr[i + i2] = j;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(long[] jArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(jArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer slice() {
        return new LongArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }
}
