package java.util.concurrent.atomic;

import java.io.Serializable;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicLongArray.class */
public class AtomicLongArray implements Serializable {
    private static final long serialVersionUID = -2308431214976778248L;
    private static final int shift;
    private final long[] array;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final int base = unsafe.arrayBaseOffset(long[].class);

    static {
        int arrayIndexScale = unsafe.arrayIndexScale(long[].class);
        if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
            throw new Error("data type scale not a power of two");
        }
        shift = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
    }

    public AtomicLongArray(int i) {
        this.array = new long[i];
    }

    public AtomicLongArray(long[] jArr) {
        this.array = (long[]) jArr.clone();
    }

    private static long byteOffset(int i) {
        return (i << shift) + base;
    }

    private long checkedByteOffset(int i) {
        if (i < 0 || i >= this.array.length) {
            throw new IndexOutOfBoundsException("index " + i);
        }
        return byteOffset(i);
    }

    private boolean compareAndSetRaw(long j, long j2, long j3) {
        return unsafe.compareAndSwapLong(this.array, j, j2, j3);
    }

    private long getRaw(long j) {
        return unsafe.getLongVolatile(this.array, j);
    }

    public long addAndGet(int i, long j) {
        long raw;
        long j2;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
            j2 = raw + j;
        } while (!compareAndSetRaw(checkedByteOffset, raw, j2));
        return j2;
    }

    public final boolean compareAndSet(int i, long j, long j2) {
        return compareAndSetRaw(checkedByteOffset(i), j, j2);
    }

    public final long decrementAndGet(int i) {
        return addAndGet(i, -1L);
    }

    public final long get(int i) {
        return getRaw(checkedByteOffset(i));
    }

    public final long getAndAdd(int i, long j) {
        long raw;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
        } while (!compareAndSetRaw(checkedByteOffset, raw, raw + j));
        return raw;
    }

    public final long getAndDecrement(int i) {
        return getAndAdd(i, -1L);
    }

    public final long getAndIncrement(int i) {
        return getAndAdd(i, 1L);
    }

    public final long getAndSet(int i, long j) {
        long raw;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
        } while (!compareAndSetRaw(checkedByteOffset, raw, j));
        return raw;
    }

    public final long incrementAndGet(int i) {
        return addAndGet(i, 1L);
    }

    public final void lazySet(int i, long j) {
        unsafe.putOrderedLong(this.array, checkedByteOffset(i), j);
    }

    public final int length() {
        return this.array.length;
    }

    public final void set(int i, long j) {
        unsafe.putLongVolatile(this.array, checkedByteOffset(i), j);
    }

    public String toString() {
        int length = this.array.length - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (true) {
            int i2 = i;
            sb.append(getRaw(byteOffset(i2)));
            if (i2 == length) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
            i = i2 + 1;
        }
    }

    public final boolean weakCompareAndSet(int i, long j, long j2) {
        return compareAndSet(i, j, j2);
    }
}
