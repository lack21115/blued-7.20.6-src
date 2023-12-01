package java.util.concurrent.atomic;

import java.io.Serializable;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicBoolean.class */
public class AtomicBoolean implements Serializable {
    private static final long serialVersionUID = 4654671469794556979L;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;
    private volatile int value;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicBoolean.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public AtomicBoolean() {
    }

    public AtomicBoolean(boolean z) {
        this.value = z ? 1 : 0;
    }

    public final boolean compareAndSet(boolean z, boolean z2) {
        int i = 1;
        int i2 = z ? 1 : 0;
        if (!z2) {
            i = 0;
        }
        return unsafe.compareAndSwapInt(this, valueOffset, i2, i);
    }

    public final boolean get() {
        return this.value != 0;
    }

    public final boolean getAndSet(boolean z) {
        boolean z2;
        do {
            z2 = get();
        } while (!compareAndSet(z2, z));
        return z2;
    }

    public final void lazySet(boolean z) {
        unsafe.putOrderedInt(this, valueOffset, z ? 1 : 0);
    }

    public final void set(boolean z) {
        this.value = z ? 1 : 0;
    }

    public String toString() {
        return Boolean.toString(get());
    }

    public boolean weakCompareAndSet(boolean z, boolean z2) {
        int i = 1;
        int i2 = z ? 1 : 0;
        if (!z2) {
            i = 0;
        }
        return unsafe.compareAndSwapInt(this, valueOffset, i2, i);
    }
}
