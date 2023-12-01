package java.util.concurrent.atomic;

import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicMarkableReference.class */
public class AtomicMarkableReference<V> {
    private static final Unsafe UNSAFE = Unsafe.getUnsafe();
    private static final long pairOffset = objectFieldOffset(UNSAFE, "pair", AtomicMarkableReference.class);
    private volatile Pair<V> pair;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicMarkableReference$Pair.class */
    public static class Pair<T> {
        final boolean mark;
        final T reference;

        private Pair(T t, boolean z) {
            this.reference = t;
            this.mark = z;
        }

        static <T> Pair<T> of(T t, boolean z) {
            return new Pair<>(t, z);
        }
    }

    public AtomicMarkableReference(V v, boolean z) {
        this.pair = Pair.of(v, z);
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

    public boolean attemptMark(V v, boolean z) {
        Pair<V> pair = this.pair;
        if (v == pair.reference) {
            return z == pair.mark || casPair(pair, Pair.of(v, z));
        }
        return false;
    }

    public boolean compareAndSet(V v, V v2, boolean z, boolean z2) {
        Pair<V> pair = this.pair;
        if (v == pair.reference && z == pair.mark) {
            return (v2 == pair.reference && z2 == pair.mark) || casPair(pair, Pair.of(v2, z2));
        }
        return false;
    }

    public V get(boolean[] zArr) {
        Pair<V> pair = this.pair;
        zArr[0] = pair.mark;
        return pair.reference;
    }

    public V getReference() {
        return this.pair.reference;
    }

    public boolean isMarked() {
        return this.pair.mark;
    }

    public void set(V v, boolean z) {
        Pair<V> pair = this.pair;
        if (v == pair.reference && z == pair.mark) {
            return;
        }
        this.pair = Pair.of(v, z);
    }

    public boolean weakCompareAndSet(V v, V v2, boolean z, boolean z2) {
        return compareAndSet(v, v2, z, z2);
    }
}
