package com.blued.android.module.svgaplayer.utils;

import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/Pools.class */
public final class Pools {

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/Pools$Pool.class */
    public interface Pool<T> {
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/Pools$SimplePool.class */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] a;
        private int b;

        public SimplePool(int i) {
            if (!(i > 0)) {
                throw new IllegalArgumentException("The max pool size must be > 0".toString());
            }
            this.a = new Object[i];
        }

        private final boolean b(T t) {
            int i = this.b;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return false;
                }
                if (this.a[i3] == t) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }

        public T a() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.b = i - 1;
                return t;
            }
            return null;
        }

        public boolean a(T t) {
            if (!b(t)) {
                int i = this.b;
                Object[] objArr = this.a;
                if (i < objArr.length) {
                    objArr[i] = t;
                    this.b = i + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!".toString());
        }
    }

    private Pools() {
    }
}
