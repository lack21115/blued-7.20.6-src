package com.autonavi.ae.gmap.maploader;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/ae/gmap/maploader/Pools.class */
public final class Pools {

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/ae/gmap/maploader/Pools$Pool.class */
    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/ae/gmap/maploader/Pools$SimplePool.class */
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

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i = this.mPoolSize;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.mPoolSize = i - 1;
                return t;
            }
            return null;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i = 0;
            while (true) {
                int i2 = i;
                Object[] objArr = this.mPool;
                if (i2 >= objArr.length) {
                    return;
                }
                objArr[i2] = null;
                i = i2 + 1;
            }
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t) {
            if (isInPool(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i < objArr.length) {
                objArr[i] = t;
                this.mPoolSize = i + 1;
                return true;
            }
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/ae/gmap/maploader/Pools$SynchronizedPool.class */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i) {
            super(i);
            this.mLock = new Object();
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
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
