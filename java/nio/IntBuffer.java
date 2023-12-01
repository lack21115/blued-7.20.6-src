package java.nio;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/IntBuffer.class */
public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IntBuffer(int i, long j) {
        super(2, i, j);
    }

    public static IntBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new IntArrayBuffer(new int[i]);
    }

    public static IntBuffer wrap(int[] iArr) {
        return wrap(iArr, 0, iArr.length);
    }

    public static IntBuffer wrap(int[] iArr, int i, int i2) {
        Arrays.checkOffsetAndCount(iArr.length, i, i2);
        IntArrayBuffer intArrayBuffer = new IntArrayBuffer(iArr);
        intArrayBuffer.position = i;
        intArrayBuffer.limit = i + i2;
        return intArrayBuffer;
    }

    @Override // java.nio.Buffer
    public final int[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract IntBuffer asReadOnlyBuffer();

    public abstract IntBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(IntBuffer intBuffer) {
        int i = this.position;
        int i2 = intBuffer.position;
        for (int remaining = remaining() < intBuffer.remaining() ? remaining() : intBuffer.remaining(); remaining > 0; remaining--) {
            int i3 = get(i);
            int i4 = intBuffer.get(i2);
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - intBuffer.remaining();
    }

    public abstract IntBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof IntBuffer) {
            IntBuffer intBuffer = (IntBuffer) obj;
            if (remaining() == intBuffer.remaining()) {
                int i = intBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    z = get(i2) == intBuffer.get(i);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public abstract int get();

    public abstract int get(int i);

    public IntBuffer get(int[] iArr) {
        return get(iArr, 0, iArr.length);
    }

    public IntBuffer get(int[] iArr, int i, int i2) {
        Arrays.checkOffsetAndCount(iArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            iArr[i4] = get();
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
            i += get(i2);
        }
        return i;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    public abstract ByteOrder order();

    abstract int[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract IntBuffer put(int i);

    public abstract IntBuffer put(int i, int i2);

    public IntBuffer put(IntBuffer intBuffer) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (intBuffer == this) {
            throw new IllegalArgumentException("src == this");
        }
        if (intBuffer.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        int[] iArr = new int[intBuffer.remaining()];
        intBuffer.get(iArr);
        put(iArr);
        return this;
    }

    public final IntBuffer put(int[] iArr) {
        return put(iArr, 0, iArr.length);
    }

    public IntBuffer put(int[] iArr, int i, int i2) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        Arrays.checkOffsetAndCount(iArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(iArr[i4]);
            i3 = i4 + 1;
        }
    }

    public abstract IntBuffer slice();
}
