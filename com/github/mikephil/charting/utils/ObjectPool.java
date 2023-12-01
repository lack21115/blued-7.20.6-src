package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/ObjectPool.class */
public class ObjectPool<T extends Poolable> {

    /* renamed from: a  reason: collision with root package name */
    private static int f22205a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f22206c;
    private Object[] d;
    private int e;
    private T f;
    private float g;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/ObjectPool$Poolable.class */
    public static abstract class Poolable {
        public static int r = -1;
        int s = r;

        protected abstract Poolable b();
    }

    private ObjectPool(int i, T t) {
        if (i <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.f22206c = i;
        this.d = new Object[i];
        this.e = 0;
        this.f = t;
        this.g = 1.0f;
        b();
    }

    public static ObjectPool a(int i, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            try {
                objectPool = new ObjectPool(i, poolable);
                objectPool.b = f22205a;
                f22205a++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectPool;
    }

    private void b() {
        b(this.g);
    }

    private void b(float f) {
        int i = this.f22206c;
        int i2 = (int) (i * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                this.e = i - 1;
                return;
            } else {
                this.d[i4] = this.f.b();
                i3 = i4 + 1;
            }
        }
    }

    private void c() {
        int i = this.f22206c;
        int i2 = i * 2;
        this.f22206c = i2;
        Object[] objArr = new Object[i2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                this.d = objArr;
                return;
            } else {
                objArr[i4] = this.d[i4];
                i3 = i4 + 1;
            }
        }
    }

    public T a() {
        T t;
        synchronized (this) {
            if (this.e == -1 && this.g > 0.0f) {
                b();
            }
            t = (T) this.d[this.e];
            t.s = Poolable.r;
            this.e--;
        }
        return t;
    }

    public void a(float f) {
        float f2;
        if (f > 1.0f) {
            f2 = 1.0f;
        } else {
            f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
        }
        this.g = f2;
    }

    public void a(T t) {
        synchronized (this) {
            if (t.s != Poolable.r) {
                if (t.s == this.b) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.s + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            int i = this.e + 1;
            this.e = i;
            if (i >= this.d.length) {
                c();
            }
            t.s = this.b;
            this.d[this.e] = t;
        }
    }
}
