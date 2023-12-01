package java.util.concurrent.atomic;

import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicStampedReference.class */
public class AtomicStampedReference<V> {
    private static final Unsafe UNSAFE = Unsafe.getUnsafe();
    private static final long pairOffset = objectFieldOffset(UNSAFE, "pair", AtomicStampedReference.class);
    private volatile Pair<V> pair;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicStampedReference$Pair.class */
    public static class Pair<T> {
        final T reference;
        final int stamp;

        private Pair(T t, int i) {
            this.reference = t;
            this.stamp = i;
        }

        static <T> Pair<T> of(T t, int i) {
            return new Pair<>(t, i);
        }
    }

    public AtomicStampedReference(V v, int i) {
        this.pair = Pair.of(v, i);
    }

    private boolean casPair(Pair<V> pair, Pair<V> pair2) {
        return UNSAFE.compareAndSwapObject(this, pairOffset, pair, pair2);
    }

    static long objectFieldOffset(Unsafe unsafe, String str, Class<?> cls) {
        try {
            return unsafe.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            NoSuchFieldError noSuchFieldError = new NoSuchFieldError(str);
            noSuchFieldError.initCause(e);
            throw noSuchFieldError;
        }
    }

    public boolean attemptStamp(V v, int i) {
        Pair<V> pair = this.pair;
        if (v == pair.reference) {
            return i == pair.stamp || casPair(pair, Pair.of(v, i));
        }
        return false;
    }

    public boolean compareAndSet(V v, V v2, int i, int i2) {
        Pair<V> pair = this.pair;
        if (v == pair.reference && i == pair.stamp) {
            return (v2 == pair.reference && i2 == pair.stamp) || casPair(pair, Pair.of(v2, i2));
        }
        return false;
    }

    public V get(int[] iArr) {
        Pair<V> pair = this.pair;
        iArr[0] = pair.stamp;
        return pair.reference;
    }

    public V getReference() {
        return this.pair.reference;
    }

    public int getStamp() {
        return this.pair.stamp;
    }

    public void set(V v, int i) {
        Pair<V> pair = this.pair;
        if (v == pair.reference && i == pair.stamp) {
            return;
        }
        this.pair = Pair.of(v, i);
    }

    public boolean weakCompareAndSet(V v, V v2, int i, int i2) {
        return compareAndSet(v, v2, i, i2);
    }
}
