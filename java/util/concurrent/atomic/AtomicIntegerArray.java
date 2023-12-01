package java.util.concurrent.atomic;

import java.io.Serializable;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicIntegerArray.class */
public class AtomicIntegerArray implements Serializable {
    private static final long serialVersionUID = 2862133569453604235L;
    private static final int shift;
    private final int[] array;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final int base = unsafe.arrayBaseOffset(int[].class);

    static {
        int arrayIndexScale = unsafe.arrayIndexScale(int[].class);
        if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
            throw new Error("data type scale not a power of two");
        }
        shift = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
    }

    public AtomicIntegerArray(int i) {
        this.array = new int[i];
    }

    public AtomicIntegerArray(int[] iArr) {
        this.array = (int[]) iArr.clone();
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

    private boolean compareAndSetRaw(long j, int i, int i2) {
        return unsafe.compareAndSwapInt(this.array, j, i, i2);
    }

    private int getRaw(long j) {
        return unsafe.getIntVolatile(this.array, j);
    }

    public final int addAndGet(int i, int i2) {
        int raw;
        int i3;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
            i3 = raw + i2;
        } while (!compareAndSetRaw(checkedByteOffset, raw, i3));
        return i3;
    }

    public final boolean compareAndSet(int i, int i2, int i3) {
        return compareAndSetRaw(checkedByteOffset(i), i2, i3);
    }

    public final int decrementAndGet(int i) {
        return addAndGet(i, -1);
    }

    public final int get(int i) {
        return getRaw(checkedByteOffset(i));
    }

    public final int getAndAdd(int i, int i2) {
        int raw;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
        } while (!compareAndSetRaw(checkedByteOffset, raw, raw + i2));
        return raw;
    }

    public final int getAndDecrement(int i) {
        return getAndAdd(i, -1);
    }

    public final int getAndIncrement(int i) {
        return getAndAdd(i, 1);
    }

    public final int getAndSet(int i, int i2) {
        int raw;
        long checkedByteOffset = checkedByteOffset(i);
        do {
            raw = getRaw(checkedByteOffset);
        } while (!compareAndSetRaw(checkedByteOffset, raw, i2));
        return raw;
    }

    public final int incrementAndGet(int i) {
        return addAndGet(i, 1);
    }

    public final void lazySet(int i, int i2) {
        unsafe.putOrderedInt(this.array, checkedByteOffset(i), i2);
    }

    public final int length() {
        return this.array.length;
    }

    public final void set(int i, int i2) {
        unsafe.putIntVolatile(this.array, checkedByteOffset(i), i2);
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

    public final boolean weakCompareAndSet(int i, int i2, int i3) {
        return compareAndSet(i, i2, i3);
    }
}
