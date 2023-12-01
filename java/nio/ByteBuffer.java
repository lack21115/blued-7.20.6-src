package java.nio;

import java.util.Arrays;
import libcore.io.Memory;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBuffer.class */
public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    ByteOrder order;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer(int i, long j) {
        super(0, i, j);
        this.order = ByteOrder.BIG_ENDIAN;
    }

    public static ByteBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new ByteArrayBuffer(new byte[i]);
    }

    public static ByteBuffer allocateDirect(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        MemoryBlock allocate = MemoryBlock.allocate(i + 7);
        long j = allocate.toLong();
        return new DirectByteBuffer(allocate, i, (int) (((7 + j) & (-8)) - j), false, null);
    }

    public static ByteBuffer wrap(byte[] bArr) {
        return new ByteArrayBuffer(bArr);
    }

    public static ByteBuffer wrap(byte[] bArr, int i, int i2) {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(bArr);
        byteArrayBuffer.position = i;
        byteArrayBuffer.limit = i + i2;
        return byteArrayBuffer;
    }

    @Override // java.nio.Buffer
    public final byte[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract CharBuffer asCharBuffer();

    public abstract DoubleBuffer asDoubleBuffer();

    public abstract FloatBuffer asFloatBuffer();

    public abstract IntBuffer asIntBuffer();

    public abstract LongBuffer asLongBuffer();

    public abstract ByteBuffer asReadOnlyBuffer();

    public abstract ShortBuffer asShortBuffer();

    public abstract ByteBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(ByteBuffer byteBuffer) {
        int i = this.position;
        int i2 = byteBuffer.position;
        for (int remaining = remaining() < byteBuffer.remaining() ? remaining() : byteBuffer.remaining(); remaining > 0; remaining--) {
            byte b = get(i);
            byte b2 = byteBuffer.get(i2);
            if (b != b2) {
                return b < b2 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - byteBuffer.remaining();
    }

    public abstract ByteBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (remaining() == byteBuffer.remaining()) {
                int i = byteBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    z = get(i2) == byteBuffer.get(i);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public abstract byte get();

    public abstract byte get(int i);

    public ByteBuffer get(byte[] bArr) {
        return get(bArr, 0, bArr.length);
    }

    public ByteBuffer get(byte[] bArr, int i, int i2) {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            bArr[i4] = get();
            i3 = i4 + 1;
        }
    }

    public abstract char getChar();

    public abstract char getChar(int i);

    public abstract double getDouble();

    public abstract double getDouble(int i);

    public abstract float getFloat();

    public abstract float getFloat(int i);

    public abstract int getInt();

    public abstract int getInt(int i);

    public abstract long getLong();

    public abstract long getLong(int i);

    public abstract short getShort();

    public abstract short getShort(int i);

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return protectedHasArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    public int hashCode() {
        byte b = 0;
        for (int i = this.position; i < this.limit; i++) {
            b += get(i);
        }
        return b;
    }

    public boolean isAccessible() {
        return true;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    public final ByteBuffer order(ByteOrder byteOrder) {
        ByteOrder byteOrder2 = byteOrder;
        if (byteOrder == null) {
            byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        }
        this.order = byteOrder2;
        return this;
    }

    public final ByteOrder order() {
        return this.order;
    }

    abstract byte[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract ByteBuffer put(byte b);

    public abstract ByteBuffer put(int i, byte b);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v22, types: [byte[]] */
    public ByteBuffer put(ByteBuffer byteBuffer) {
        if (isAccessible()) {
            if (isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            if (byteBuffer == this) {
                throw new IllegalArgumentException("src == this");
            }
            if (byteBuffer.isAccessible()) {
                int remaining = byteBuffer.remaining();
                if (remaining > remaining()) {
                    throw new BufferOverflowException();
                }
                ByteBuffer unsafeArray = byteBuffer.isDirect() ? byteBuffer : NioUtils.unsafeArray(byteBuffer);
                int position = byteBuffer.position();
                int i = position;
                if (!byteBuffer.isDirect()) {
                    i = position + NioUtils.unsafeArrayOffset(byteBuffer);
                }
                ByteBuffer unsafeArray2 = isDirect() ? this : NioUtils.unsafeArray(this);
                int position2 = position();
                int i2 = position2;
                if (!isDirect()) {
                    i2 = position2 + NioUtils.unsafeArrayOffset(this);
                }
                Memory.memmove(unsafeArray2, i2, unsafeArray, i, remaining);
                byteBuffer.position(byteBuffer.limit());
                position(position() + remaining);
                return this;
            }
            throw new IllegalStateException("src buffer is inaccessible");
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public final ByteBuffer put(byte[] bArr) {
        return put(bArr, 0, bArr.length);
    }

    public ByteBuffer put(byte[] bArr, int i, int i2) {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(bArr[i4]);
            i3 = i4 + 1;
        }
    }

    public abstract ByteBuffer putChar(char c2);

    public abstract ByteBuffer putChar(int i, char c2);

    public abstract ByteBuffer putDouble(double d);

    public abstract ByteBuffer putDouble(int i, double d);

    public abstract ByteBuffer putFloat(float f);

    public abstract ByteBuffer putFloat(int i, float f);

    public abstract ByteBuffer putInt(int i);

    public abstract ByteBuffer putInt(int i, int i2);

    public abstract ByteBuffer putLong(int i, long j);

    public abstract ByteBuffer putLong(long j);

    public abstract ByteBuffer putShort(int i, short s);

    public abstract ByteBuffer putShort(short s);

    public void setAccessible(boolean z) {
        throw new UnsupportedOperationException();
    }

    public abstract ByteBuffer slice();
}
