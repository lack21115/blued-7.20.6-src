package java.nio;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ShortBuffer.class */
public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortBuffer(int i, long j) {
        super(1, i, j);
    }

    public static ShortBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new ShortArrayBuffer(new short[i]);
    }

    public static ShortBuffer wrap(short[] sArr) {
        return wrap(sArr, 0, sArr.length);
    }

    public static ShortBuffer wrap(short[] sArr, int i, int i2) {
        Arrays.checkOffsetAndCount(sArr.length, i, i2);
        ShortArrayBuffer shortArrayBuffer = new ShortArrayBuffer(sArr);
        shortArrayBuffer.position = i;
        shortArrayBuffer.limit = i + i2;
        return shortArrayBuffer;
    }

    @Override // java.nio.Buffer
    public final short[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract ShortBuffer asReadOnlyBuffer();

    public abstract ShortBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(ShortBuffer shortBuffer) {
        int i = this.position;
        int i2 = shortBuffer.position;
        for (int remaining = remaining() < shortBuffer.remaining() ? remaining() : shortBuffer.remaining(); remaining > 0; remaining--) {
            short s = get(i);
            short s2 = shortBuffer.get(i2);
            if (s != s2) {
                return s < s2 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - shortBuffer.remaining();
    }

    public abstract ShortBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof ShortBuffer) {
            ShortBuffer shortBuffer = (ShortBuffer) obj;
            if (remaining() == shortBuffer.remaining()) {
                int i = shortBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    z = get(i2) == shortBuffer.get(i);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public ShortBuffer get(short[] sArr) {
        return get(sArr, 0, sArr.length);
    }

    public ShortBuffer get(short[] sArr, int i, int i2) {
        Arrays.checkOffsetAndCount(sArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            sArr[i4] = get();
            i3 = i4 + 1;
        }
    }

    public abstract short get();

    public abstract short get(int i);

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return protectedHasArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    public int hashCode() {
        short s = 0;
        for (int i = this.position; i < this.limit; i++) {
            s += get(i);
        }
        return s;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    public abstract ByteOrder order();

    abstract short[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract ShortBuffer put(int i, short s);

    public ShortBuffer put(ShortBuffer shortBuffer) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (shortBuffer == this) {
            throw new IllegalArgumentException("src == this");
        }
        if (shortBuffer.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        short[] sArr = new short[shortBuffer.remaining()];
        shortBuffer.get(sArr);
        put(sArr);
        return this;
    }

    public abstract ShortBuffer put(short s);

    public final ShortBuffer put(short[] sArr) {
        return put(sArr, 0, sArr.length);
    }

    public ShortBuffer put(short[] sArr, int i, int i2) {
        Arrays.checkOffsetAndCount(sArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(sArr[i4]);
            i3 = i4 + 1;
        }
    }

    public abstract ShortBuffer slice();
}
