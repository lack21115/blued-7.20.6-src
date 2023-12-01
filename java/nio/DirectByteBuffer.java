package java.nio;

import java.nio.channels.FileChannel;
import libcore.io.Memory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/DirectByteBuffer.class */
public class DirectByteBuffer extends MappedByteBuffer {
    private final boolean isReadOnly;
    protected final int offset;

    DirectByteBuffer(long j, int i) {
        this(MemoryBlock.wrapFromJni(j, i), i, 0, false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DirectByteBuffer(MemoryBlock memoryBlock, int i, int i2, boolean z, FileChannel.MapMode mapMode) {
        super(memoryBlock, i, mapMode, memoryBlock.toLong() + i2);
        long size = memoryBlock.getSize();
        if (size >= 0 && i + i2 > size) {
            throw new IllegalArgumentException("capacity + offset > baseSize");
        }
        this.offset = i2;
        this.isReadOnly = z;
    }

    private void checkIsAccessible() {
        checkNotFreed();
        if (!this.block.isAccessible()) {
            throw new IllegalStateException("buffer is inaccessible");
        }
    }

    private void checkNotFreed() {
        if (this.block.isFreed()) {
            throw new IllegalStateException("buffer was freed");
        }
    }

    private static DirectByteBuffer copy(DirectByteBuffer directByteBuffer, int i, boolean z) {
        directByteBuffer.checkNotFreed();
        DirectByteBuffer directByteBuffer2 = new DirectByteBuffer(directByteBuffer.block, directByteBuffer.capacity(), directByteBuffer.offset, z, directByteBuffer.mapMode);
        directByteBuffer2.limit = directByteBuffer.limit;
        directByteBuffer2.position = directByteBuffer.position();
        directByteBuffer2.mark = i;
        return directByteBuffer2;
    }

    @Override // java.nio.ByteBuffer
    public final CharBuffer asCharBuffer() {
        checkNotFreed();
        return ByteBufferAsCharBuffer.asCharBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final DoubleBuffer asDoubleBuffer() {
        checkNotFreed();
        return ByteBufferAsDoubleBuffer.asDoubleBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final FloatBuffer asFloatBuffer() {
        checkNotFreed();
        return ByteBufferAsFloatBuffer.asFloatBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final IntBuffer asIntBuffer() {
        checkNotFreed();
        return ByteBufferAsIntBuffer.asIntBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public final LongBuffer asLongBuffer() {
        checkNotFreed();
        return ByteBufferAsLongBuffer.asLongBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.ByteBuffer
    public final ShortBuffer asShortBuffer() {
        checkNotFreed();
        return ByteBufferAsShortBuffer.asShortBuffer(this);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer compact() {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Memory.memmove(this, 0, this, this.position, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    public final void free() {
        this.block.free();
    }

    @Override // java.nio.ByteBuffer
    public final byte get() {
        checkIsAccessible();
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        MemoryBlock memoryBlock = this.block;
        int i = this.offset;
        int i2 = this.position;
        this.position = i2 + 1;
        return memoryBlock.peekByte(i + i2);
    }

    @Override // java.nio.ByteBuffer
    public final byte get(int i) {
        checkIsAccessible();
        checkIndex(i);
        return this.block.peekByte(this.offset + i);
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer get(byte[] bArr, int i, int i2) {
        checkIsAccessible();
        checkGetBounds(1, bArr.length, i, i2);
        this.block.peekByteArray(this.offset + this.position, bArr, i, i2);
        this.position += i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(char[] cArr, int i, int i2) {
        checkIsAccessible();
        int checkGetBounds = checkGetBounds(2, cArr.length, i, i2);
        this.block.peekCharArray(this.offset + this.position, cArr, i, i2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(double[] dArr, int i, int i2) {
        checkIsAccessible();
        int checkGetBounds = checkGetBounds(8, dArr.length, i, i2);
        this.block.peekDoubleArray(this.offset + this.position, dArr, i, i2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(float[] fArr, int i, int i2) {
        checkIsAccessible();
        int checkGetBounds = checkGetBounds(4, fArr.length, i, i2);
        this.block.peekFloatArray(this.offset + this.position, fArr, i, i2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(int[] iArr, int i, int i2) {
        checkIsAccessible();
        int checkGetBounds = checkGetBounds(4, iArr.length, i, i2);
        this.block.peekIntArray(this.offset + this.position, iArr, i, i2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(long[] jArr, int i, int i2) {
        checkIsAccessible();
        int checkGetBounds = checkGetBounds(8, jArr.length, i, i2);
        this.block.peekLongArray(this.offset + this.position, jArr, i, i2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void get(short[] sArr, int i, int i2) {
        checkIsAccessible();
        int checkGetBounds = checkGetBounds(2, sArr.length, i, i2);
        this.block.peekShortArray(this.offset + this.position, sArr, i, i2, this.order.needsSwap);
        this.position += checkGetBounds;
    }

    @Override // java.nio.ByteBuffer
    public final char getChar() {
        checkIsAccessible();
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        char peekShort = (char) this.block.peekShort(this.offset + this.position, this.order);
        this.position = i;
        return peekShort;
    }

    @Override // java.nio.ByteBuffer
    public final char getChar(int i) {
        checkIsAccessible();
        checkIndex(i, 2);
        return (char) this.block.peekShort(this.offset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final double getDouble() {
        checkIsAccessible();
        int i = this.position + 8;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        double longBitsToDouble = Double.longBitsToDouble(this.block.peekLong(this.offset + this.position, this.order));
        this.position = i;
        return longBitsToDouble;
    }

    @Override // java.nio.ByteBuffer
    public final double getDouble(int i) {
        checkIsAccessible();
        checkIndex(i, 8);
        return Double.longBitsToDouble(this.block.peekLong(this.offset + i, this.order));
    }

    @Override // java.nio.ByteBuffer
    public final float getFloat() {
        checkIsAccessible();
        int i = this.position + 4;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        float intBitsToFloat = Float.intBitsToFloat(this.block.peekInt(this.offset + this.position, this.order));
        this.position = i;
        return intBitsToFloat;
    }

    @Override // java.nio.ByteBuffer
    public final float getFloat(int i) {
        checkIsAccessible();
        checkIndex(i, 4);
        return Float.intBitsToFloat(this.block.peekInt(this.offset + i, this.order));
    }

    @Override // java.nio.ByteBuffer
    public final int getInt() {
        checkIsAccessible();
        int i = this.position + 4;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        int peekInt = this.block.peekInt(this.offset + this.position, this.order);
        this.position = i;
        return peekInt;
    }

    @Override // java.nio.ByteBuffer
    public final int getInt(int i) {
        checkIsAccessible();
        checkIndex(i, 4);
        return this.block.peekInt(this.offset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final long getLong() {
        checkIsAccessible();
        int i = this.position + 8;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        long peekLong = this.block.peekLong(this.offset + this.position, this.order);
        this.position = i;
        return peekLong;
    }

    @Override // java.nio.ByteBuffer
    public final long getLong(int i) {
        checkIsAccessible();
        checkIndex(i, 8);
        return this.block.peekLong(this.offset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final short getShort() {
        checkIsAccessible();
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferUnderflowException();
        }
        short peekShort = this.block.peekShort(this.offset + this.position, this.order);
        this.position = i;
        return peekShort;
    }

    @Override // java.nio.ByteBuffer
    public final short getShort(int i) {
        checkIsAccessible();
        checkIndex(i, 2);
        return this.block.peekShort(this.offset + i, this.order);
    }

    @Override // java.nio.ByteBuffer
    public final boolean isAccessible() {
        return this.block.isAccessible();
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return true;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.ByteBuffer
    byte[] protectedArray() {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        byte[] array = this.block.array();
        if (array == null) {
            throw new UnsupportedOperationException();
        }
        return array;
    }

    @Override // java.nio.ByteBuffer
    int protectedArrayOffset() {
        protectedArray();
        return this.offset;
    }

    @Override // java.nio.ByteBuffer
    boolean protectedHasArray() {
        return (this.isReadOnly || this.block.array() == null) ? false : true;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte b) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        MemoryBlock memoryBlock = this.block;
        int i = this.offset;
        int i2 = this.position;
        this.position = i2 + 1;
        memoryBlock.pokeByte(i + i2, b);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(int i, byte b) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.block.pokeByte(this.offset + i, b);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte[] bArr, int i, int i2) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkPutBounds(1, bArr.length, i, i2);
        this.block.pokeByteArray(this.offset + this.position, bArr, i, i2);
        this.position += i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(char[] cArr, int i, int i2) {
        checkIsAccessible();
        int checkPutBounds = checkPutBounds(2, cArr.length, i, i2);
        this.block.pokeCharArray(this.offset + this.position, cArr, i, i2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(double[] dArr, int i, int i2) {
        checkIsAccessible();
        int checkPutBounds = checkPutBounds(8, dArr.length, i, i2);
        this.block.pokeDoubleArray(this.offset + this.position, dArr, i, i2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(float[] fArr, int i, int i2) {
        checkIsAccessible();
        int checkPutBounds = checkPutBounds(4, fArr.length, i, i2);
        this.block.pokeFloatArray(this.offset + this.position, fArr, i, i2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(int[] iArr, int i, int i2) {
        checkIsAccessible();
        int checkPutBounds = checkPutBounds(4, iArr.length, i, i2);
        this.block.pokeIntArray(this.offset + this.position, iArr, i, i2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(long[] jArr, int i, int i2) {
        checkIsAccessible();
        int checkPutBounds = checkPutBounds(8, jArr.length, i, i2);
        this.block.pokeLongArray(this.offset + this.position, jArr, i, i2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(short[] sArr, int i, int i2) {
        checkIsAccessible();
        int checkPutBounds = checkPutBounds(2, sArr.length, i, i2);
        this.block.pokeShortArray(this.offset + this.position, sArr, i, i2, this.order.needsSwap);
        this.position += checkPutBounds;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putChar(char c2) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeShort(this.offset + this.position, (short) c2, this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putChar(int i, char c2) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 2);
        this.block.pokeShort(this.offset + i, (short) c2, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putDouble(double d) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 8;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeLong(this.offset + this.position, Double.doubleToRawLongBits(d), this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putDouble(int i, double d) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 8);
        this.block.pokeLong(this.offset + i, Double.doubleToRawLongBits(d), this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putFloat(float f) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 4;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeInt(this.offset + this.position, Float.floatToRawIntBits(f), this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putFloat(int i, float f) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 4);
        this.block.pokeInt(this.offset + i, Float.floatToRawIntBits(f), this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putInt(int i) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i2 = this.position + 4;
        if (i2 > this.limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeInt(this.offset + this.position, i, this.order);
        this.position = i2;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putInt(int i, int i2) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 4);
        this.block.pokeInt(this.offset + i, i2, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putLong(int i, long j) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 8);
        this.block.pokeLong(this.offset + i, j, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putLong(long j) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 8;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeLong(this.offset + this.position, j, this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putShort(int i, short s) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i, 2);
        this.block.pokeShort(this.offset + i, s, this.order);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putShort(short s) {
        checkIsAccessible();
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int i = this.position + 2;
        if (i > this.limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeShort(this.offset + this.position, s, this.order);
        this.position = i;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public void setAccessible(boolean z) {
        this.block.setAccessible(z);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer slice() {
        checkNotFreed();
        return new DirectByteBuffer(this.block, remaining(), this.offset + this.position, this.isReadOnly, this.mapMode);
    }
}
