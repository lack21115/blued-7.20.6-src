package java.util.concurrent.atomic;

import com.anythink.core.common.c.d;
import java.io.Serializable;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicReference.class */
public class AtomicReference<V> implements Serializable {
    private static final long serialVersionUID = -1848883965231344442L;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;
    private volatile V value;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicReference.class.getDeclaredField(d.a.d));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public AtomicReference() {
    }

    public AtomicReference(V v) {
        this.value = v;
    }

    public final boolean compareAndSet(V v, V v2) {
        return unsafe.compareAndSwapObject(this, valueOffset, v, v2);
    }

    public final V get() {
        return this.value;
    }

    public final V getAndSet(V v) {
        V v2;
        do {
            v2 = get();
        } while (!compareAndSet(v2, v));
        return v2;
    }

    public final void lazySet(V v) {
        unsafe.putOrderedObject(this, valueOffset, v);
    }

    public final void set(V v) {
        this.value = v;
    }

    public String toString() {
        return String.valueOf(get());
    }

    public final boolean weakCompareAndSet(V v, V v2) {
        return unsafe.compareAndSwapObject(this, valueOffset, v, v2);
    }
}
