package java.nio;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/LongBuffer.class */
public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LongBuffer(int i, long j) {
        super(3, i, j);
    }

    public static LongBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new LongArrayBuffer(new long[i]);
    }

    public static LongBuffer wrap(long[] jArr) {
        return wrap(jArr, 0, jArr.length);
    }

    public static LongBuffer wrap(long[] jArr, int i, int i2) {
        Arrays.checkOffsetAndCount(jArr.length, i, i2);
        LongArrayBuffer longArrayBuffer = new LongArrayBuffer(jArr);
        longArrayBuffer.position = i;
        longArrayBuffer.limit = i + i2;
        return longArrayBuffer;
    }

    @Override // java.nio.Buffer
    public final long[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract LongBuffer asReadOnlyBuffer();

    public abstract LongBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(LongBuffer longBuffer) {
        int i = this.position;
        int i2 = longBuffer.position;
        for (int remaining = remaining() < longBuffer.remaining() ? remaining() : longBuffer.remaining(); remaining > 0; remaining--) {
            long j = get(i);
            long j2 = longBuffer.get(i2);
            if (j != j2) {
                return j < j2 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - longBuffer.remaining();
    }

    public abstract LongBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof LongBuffer) {
            LongBuffer longBuffer = (LongBuffer) obj;
            if (remaining() == longBuffer.remaining()) {
                int i = longBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    z = get(i2) == longBuffer.get(i);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public abstract long get();

    public abstract long get(int i);

    public LongBuffer get(long[] jArr) {
        return get(jArr, 0, jArr.length);
    }

    public LongBuffer get(long[] jArr, int i, int i2) {
        Arrays.checkOffsetAndCount(jArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            jArr[i4] = get();
            i3 = i4 + 1;
        }
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return protectedHasArray();
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.position; i2 < this.limit; i2++) {
            long j = get(i2);
            i = (((int) j) + i) ^ ((int) (j >> 32));
        }
        return i;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    public abstract ByteOrder order();

    abstract long[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract LongBuffer put(int i, long j);

    public abstract LongBuffer put(long j);

    public LongBuffer put(LongBuffer longBuffer) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (longBuffer == this) {
            throw new IllegalArgumentException("src == this");
        }
        if (longBuffer.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        long[] jArr = new long[longBuffer.remaining()];
        longBuffer.get(jArr);
        put(jArr);
        return this;
    }

    public final LongBuffer put(long[] jArr) {
        return put(jArr, 0, jArr.length);
    }

    public LongBuffer put(long[] jArr, int i, int i2) {
        Arrays.checkOffsetAndCount(jArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(jArr[i4]);
            i3 = i4 + 1;
        }
    }

    public abstract LongBuffer slice();
}
