package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/Pools.class */
public final class Pools {

    /* loaded from: source-9557208-dex2jar.jar:android/util/Pools$Pool.class */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/util/Pools$SimplePool.class */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i];
        }

        private boolean isInPool(T t) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mPoolSize) {
                    return false;
                }
                if (this.mPool[i2] == t) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        @Override // android.util.Pools.Pool
        public T acquire() {
            if (this.mPoolSize > 0) {
                int i = this.mPoolSize - 1;
                T t = (T) this.mPool[i];
                this.mPool[i] = null;
                this.mPoolSize--;
                return t;
            }
            return null;
        }

        @Override // android.util.Pools.Pool
        public boolean release(T t) {
            if (isInPool(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.mPoolSize < this.mPool.length) {
                this.mPool[this.mPoolSize] = t;
                this.mPoolSize++;
                return true;
            }
            return false;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/util/Pools$SynchronizedPool.class */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i) {
            super(i);
            this.mLock = new Object();
        }

        @Override // android.util.Pools.SimplePool, android.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // android.util.Pools.SimplePool, android.util.Pools.Pool
        public boolean release(T t) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
