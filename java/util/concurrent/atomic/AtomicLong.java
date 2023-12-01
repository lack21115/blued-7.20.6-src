package java.util.concurrent.atomic;

import java.io.Serializable;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicLong.class */
public class AtomicLong extends Number implements Serializable {
    private static final long serialVersionUID = 1927816293512124184L;
    private static final long valueOffset;
    private volatile long value;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public AtomicLong() {
    }

    public AtomicLong(long j) {
        this.value = j;
    }

    private static native boolean VMSupportsCS8();

    public final long addAndGet(long j) {
        long j2;
        long j3;
        do {
            j2 = get();
            j3 = j2 + j;
        } while (!compareAndSet(j2, j3));
        return j3;
    }

    public final boolean compareAndSet(long j, long j2) {
        return unsafe.compareAndSwapLong(this, valueOffset, j, j2);
    }

    public final long decrementAndGet() {
        long j;
        long j2;
        do {
            j = get();
            j2 = j - 1;
        } while (!compareAndSet(j, j2));
        return j2;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final long get() {
        return this.value;
    }

    public final long getAndAdd(long j) {
        long j2;
        do {
            j2 = get();
        } while (!compareAndSet(j2, j2 + j));
        return j2;
    }

    public final long getAndDecrement() {
        long j;
        do {
            j = get();
        } while (!compareAndSet(j, j - 1));
        return j;
    }

    public final long getAndIncrement() {
        long j;
        do {
            j = get();
        } while (!compareAndSet(j, j + 1));
        return j;
    }

    public final long getAndSet(long j) {
        long j2;
        do {
            j2 = get();
        } while (!compareAndSet(j2, j));
        return j2;
    }

    public final long incrementAndGet() {
        long j;
        long j2;
        do {
            j = get();
            j2 = j + 1;
        } while (!compareAndSet(j, j2));
        return j2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(long j) {
        unsafe.putOrderedLong(this, valueOffset, j);
    }

    @Override // java.lang.Number
    public long longValue() {
        return get();
    }

    public final void set(long j) {
        this.value = j;
    }

    public String toString() {
        return Long.toString(get());
    }

    public final boolean weakCompareAndSet(long j, long j2) {
        return unsafe.compareAndSwapLong(this, valueOffset, j, j2);
    }
}
