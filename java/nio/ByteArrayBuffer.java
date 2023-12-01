package java.nio;

import libcore.io.Memory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteArrayBuffer.class */
public final class ByteArrayBuffer extends ByteBuffer {
    final int arrayOffset;
    final byte[] backingArray;
    private final boolean isReadOnly;

    private ByteArrayBuffer(int i, byte[] bArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = bArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
        if (i2 + i > bArr.length) {
            throw new IndexOutOfBoundsException("backingArray.length=" + bArr.length + ", capacity=" + i + ", arrayOffset=" + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteArrayBuffer(byte[] bArr) {
        this(bArr.length, bArr, 0, false);
    }

    private static ByteArrayBuffer copy(ByteArrayBuffer byteArrayBuffer, int i, boolean z) {
        ByteArrayBuffer byteArrayBuffer2 = new ByteArrayBuffer(byteArrayBuffer.capacity(), byteArrayBuffer.backingArray, byteArrayBuffer.arrayOffset, z);
        byteArrayBuffer2.limit = byteArrayBuffer.limit;
        byteArrayBuffer2.position = byteArrayBuffer.position();
        byteArrayBuffer2.mark = i;
        return byteArrayBuffer2;
    }

    @Override // java.nio.ByteBuffer
    public final CharBuffer asCharBuffer() {
        return ByteBufferAsCharBuffer.asCharBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final DoubleBuffer asDoubleBuffer() {
        return ByteBufferAsDoubleBuffer.asDoubleBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final FloatBuffer asFloatBuffer() {
        return ByteBufferAsFloatBuffer.asFloatBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final IntBuffer asIntBuffer() {
        return ByteBufferAsIntBuffer.asIntBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final LongBuffer asLongBuffer() {
        return ByteBufferAsLongBuffer.asLongBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.ByteBuffer
    public final ShortBuffer asShortBuffer() {
        return ByteBufferAsShortBuffer.asShortBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.ByteBuffer
    public final byte get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        byte[] bArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return bArr[i + i2];
    }

    @Override // java.nio.ByteBuffer
    public final byte get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer get(byte[] bArr, int i, int i2) {
        checkGetBounds(1, bArr.length, i, i2);
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, bArr, i, i2);
        this.position += i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(char[] cArr, int i, int i2) {
        int checkGetBounds = checkGetBounds(2, cArr.length, i, i2);
        Memory.unsafeBulkGet(cArr, i, checkGetBounds, this.backingArray, this.arrayOffset + this.position, 2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(double[] dArr, int i, int i2) {
        int checkGetBounds = checkGetBounds(8, dArr.length, i, i2);
        Memory.unsafeBulkGet(dArr, i, checkGetBounds, this.backingArray, this.arrayOffset + this.position, 8, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(float[] fArr, int i, int i2) {
        int checkGetBounds = checkGetBounds(4, fArr.length, i, i2);
        Memory.unsafeBulkGet(fArr, i, checkGetBounds, this.backingArray, this.arrayOffset + this.position, 4, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(int[] iArr, int i, int i2) {
        int checkGetBounds = checkGetBounds(4, iArr.length, i, i2);
        Memory.unsafeBulkGet(iArr, i, checkGetBounds, this.backingArray, this.arrayOffset + this.position, 4, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(long[] jArr, int i, int i2) {
        int checkGetBounds = checkGetBounds(8, jArr.length, i, i2);
        Memory.unsafeBulkGet(jArr, i, checkGetBounds, this.backingArray, this.arrayOffset + this.position, 8, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(short[] sArr, int i, int i2) {
        int checkGetBounds = checkGetBounds(2, sArr.length, i, i2);
        Memory.unsafeBulkGet(sArr, i, checkGetBounds, this.backingArray, this.arrayOffset + this.position, 2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    @Override // java.nio.ByteBuffer
    public final char getChar() {
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        char peekShort = (char) Memory.peekShort(this.backingArray, this.arrayOffset + this.position, this.order);
        this.position = i;
        return peekShort;
    }

    @Override // java.nio.ByteBuffer
    public final char getChar(int i) {
        checkIndex(i, 2);
        return (char) Memory.peekShort(this.backingArray, this.arrayOffset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    @Override // java.nio.ByteBuffer
    public final double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // java.nio.ByteBuffer
    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    @Override // java.nio.ByteBuffer
    public final float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // java.nio.ByteBuffer
    public final int getInt() {
        int i = this.position + 4;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        int peekInt = Memory.peekInt(this.backingArray, this.arrayOffset + this.position, this.order);
        this.position = i;
        return peekInt;
    }

    @Override // java.nio.ByteBuffer
    public final int getInt(int i) {
        checkIndex(i, 4);
        return Memory.peekInt(this.backingArray, this.arrayOffset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final long getLong() {
        int i = this.position + 8;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        long peekLong = Memory.peekLong(this.backingArray, this.arrayOffset + this.position, this.order);
        this.position = i;
        return peekLong;
    }

    @Override // java.nio.ByteBuffer
    public final long getLong(int i) {
        checkIndex(i, 8);
        return Memory.peekLong(this.backingArray, this.arrayOffset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final short getShort() {
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        short peekShort = Memory.peekShort(this.backingArray, this.arrayOffset + this.position, this.order);
        this.position = i;
        return peekShort;
    }

    @Override // java.nio.ByteBuffer
    public final short getShort(int i) {
        checkIndex(i, 2);
        return Memory.peekShort(this.backingArray, this.arrayOffset + i, this.order);
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.ByteBuffer
    byte[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.ByteBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.ByteBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte b) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        byte[] bArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i + i2] = b;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(int i, byte b) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = b;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte[] bArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkPutBounds(1, bArr.length, i, i2);
        System.arraycopy(bArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(char[] cArr, int i, int i2) {
        int checkPutBounds = checkPutBounds(2, cArr.length, i, i2);
        Memory.unsafeBulkPut(this.backingArray, this.arrayOffset + this.position, checkPutBounds, cArr, i, 2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(double[] dArr, int i, int i2) {
        int checkPutBounds = checkPutBounds(8, dArr.length, i, i2);
        Memory.unsafeBulkPut(this.backingArray, this.arrayOffset + this.position, checkPutBounds, dArr, i, 8, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(float[] fArr, int i, int i2) {
        int checkPutBounds = checkPutBounds(4, fArr.length, i, i2);
        Memory.unsafeBulkPut(this.backingArray, this.arrayOffset + this.position, checkPutBounds, fArr, i, 4, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(int[] iArr, int i, int i2) {
        int checkPutBounds = checkPutBounds(4, iArr.length, i, i2);
        Memory.unsafeBulkPut(this.backingArray, this.arrayOffset + this.position, checkPutBounds, iArr, i, 4, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(long[] jArr, int i, int i2) {
        int checkPutBounds = checkPutBounds(8, jArr.length, i, i2);
        Memory.unsafeBulkPut(this.backingArray, this.arrayOffset + this.position, checkPutBounds, jArr, i, 8, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(short[] sArr, int i, int i2) {
        int checkPutBounds = checkPutBounds(2, sArr.length, i, i2);
        Memory.unsafeBulkPut(this.backingArray, this.arrayOffset + this.position, checkPutBounds, sArr, i, 2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putChar(char c2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeShort(this.backingArray, this.arrayOffset + this.position, (short) c2, this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putChar(int i, char c2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 2);
        Memory.pokeShort(this.backingArray, this.arrayOffset + i, (short) c2, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putDouble(double d) {
        return putLong(Double.doubleToRawLongBits(d));
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putDouble(int i, double d) {
        return putLong(i, Double.doubleToRawLongBits(d));
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putFloat(float f) {
        return putInt(Float.floatToRawIntBits(f));
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putFloat(int i, float f) {
        return putInt(i, Float.floatToRawIntBits(f));
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putInt(int i) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i2 = this.position + 4;
        if (i2 > this.limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeInt(this.backingArray, this.arrayOffset + this.position, i, this.order);
        this.position = i2;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putInt(int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 4);
        Memory.pokeInt(this.backingArray, this.arrayOffset + i, i2, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putLong(int i, long j) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 8);
        Memory.pokeLong(this.backingArray, this.arrayOffset + i, j, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putLong(long j) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 8;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeLong(this.backingArray, this.arrayOffset + this.position, j, this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putShort(int i, short s) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 2);
        Memory.pokeShort(this.backingArray, this.arrayOffset + i, s, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putShort(short s) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeShort(this.backingArray, this.arrayOffset + this.position, s, this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer slice() {
        return new ByteArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }
}
