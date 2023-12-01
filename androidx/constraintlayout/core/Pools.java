package androidx.constraintlayout.core;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/Pools.class */
final class Pools {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/Pools$Pool.class */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/Pools$SimplePool.class */
    static class SimplePool<T> implements Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f1992a;
        private int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1992a = new Object[i];
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public T acquire() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.f1992a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.b = i - 1;
                return t;
            }
            return null;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t) {
            int i = this.b;
            Object[] objArr = this.f1992a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.b = i + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i) {
            int i2 = i;
            if (i > tArr.length) {
                i2 = tArr.length;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    return;
                }
                T t = tArr[i4];
                int i5 = this.b;
                Object[] objArr = this.f1992a;
                if (i5 < objArr.length) {
                    objArr[i5] = t;
                    this.b = i5 + 1;
                }
                i3 = i4 + 1;
            }
        }
    }

    private Pools() {
    }
}
