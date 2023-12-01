package androidx.core.util;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/Pools.class */
public final class Pools {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/util/Pools$Pool.class */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/util/Pools$SimplePool.class */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f2555a;
        private int b;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2555a = new Object[i];
        }

        private boolean a(T t) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b) {
                    return false;
                }
                if (this.f2555a[i2] == t) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.f2555a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.b = i - 1;
                return t;
            }
            return null;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t) {
            if (a(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.b;
            Object[] objArr = this.f2555a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.b = i + 1;
                return true;
            }
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/util/Pools$SynchronizedPool.class */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f2556a;

        public SynchronizedPool(int i) {
            super(i);
            this.f2556a = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.f2556a) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T t) {
            boolean release;
            synchronized (this.f2556a) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
