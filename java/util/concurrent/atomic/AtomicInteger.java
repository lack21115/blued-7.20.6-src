package java.util.concurrent.atomic;

import com.anythink.core.common.c.d;
import java.io.Serializable;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicInteger.class */
public class AtomicInteger extends Number implements Serializable {
    private static final long serialVersionUID = 6214790243416807050L;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;
    private volatile int value;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField(d.a.d));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public AtomicInteger() {
    }

    public AtomicInteger(int i) {
        this.value = i;
    }

    public final int addAndGet(int i) {
        int i2;
        int i3;
        do {
            i2 = get();
            i3 = i2 + i;
        } while (!compareAndSet(i2, i3));
        return i3;
    }

    public final boolean compareAndSet(int i, int i2) {
        return unsafe.compareAndSwapInt(this, valueOffset, i, i2);
    }

    public final int decrementAndGet() {
        int i;
        int i2;
        do {
            i = get();
            i2 = i - 1;
        } while (!compareAndSet(i, i2));
        return i2;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return get();
    }

    public final int get() {
        return this.value;
    }

    public final int getAndAdd(int i) {
        int i2;
        do {
            i2 = get();
        } while (!compareAndSet(i2, i2 + i));
        return i2;
    }

    public final int getAndDecrement() {
        int i;
        do {
            i = get();
        } while (!compareAndSet(i, i - 1));
        return i;
    }

    public final int getAndIncrement() {
        int i;
        do {
            i = get();
        } while (!compareAndSet(i, i + 1));
        return i;
    }

    public final int getAndSet(int i) {
        int i2;
        do {
            i2 = get();
        } while (!compareAndSet(i2, i));
        return i2;
    }

    public final int incrementAndGet() {
        int i;
        int i2;
        do {
            i = get();
            i2 = i + 1;
        } while (!compareAndSet(i, i2));
        return i2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return get();
    }

    public final void lazySet(int i) {
        unsafe.putOrderedInt(this, valueOffset, i);
    }

    @Override // java.lang.Number
    public long longValue() {
        return get();
    }

    public final void set(int i) {
        this.value = i;
    }

    public String toString() {
        return Integer.toString(get());
    }

    public final boolean weakCompareAndSet(int i, int i2) {
        return unsafe.compareAndSwapInt(this, valueOffset, i, i2);
    }
}
