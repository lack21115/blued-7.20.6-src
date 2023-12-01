package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/FactoryPools.class */
public final class FactoryPools {

    /* renamed from: a  reason: collision with root package name */
    private static final Resetter<Object> f21112a = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void a(Object obj) {
        }
    };

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/FactoryPools$Factory.class */
    public interface Factory<T> {
        T b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/FactoryPools$FactoryPool.class */
    public static final class FactoryPool<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Factory<T> f21113a;
        private final Resetter<T> b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f21114c;

        FactoryPool(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
            this.f21114c = pool;
            this.f21113a = factory;
            this.b = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f21114c.acquire();
            T t = acquire;
            if (acquire == null) {
                T b = this.f21113a.b();
                t = b;
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b.getClass());
                    t = b;
                }
            }
            if (t instanceof Poolable) {
                ((Poolable) t).d().a(false);
            }
            return t;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).d().a(true);
            }
            this.b.a(t);
            return this.f21114c.release(t);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/FactoryPools$Poolable.class */
    public interface Poolable {
        StateVerifier d();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/FactoryPools$Resetter.class */
    public interface Resetter<T> {
        void a(T t);
    }

    private FactoryPools() {
    }

    public static <T> Pools.Pool<List<T>> a() {
        return a(20);
    }

    public static <T> Pools.Pool<List<T>> a(int i) {
        return a(new Pools.SynchronizedPool(i), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: a */
            public List<T> b() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public /* bridge */ /* synthetic */ void a(Object obj) {
                a((List) ((List) obj));
            }

            public void a(List<T> list) {
                list.clear();
            }
        });
    }

    public static <T extends Poolable> Pools.Pool<T> a(int i, Factory<T> factory) {
        return a(new Pools.SynchronizedPool(i), factory);
    }

    private static <T extends Poolable> Pools.Pool<T> a(Pools.Pool<T> pool, Factory<T> factory) {
        return a(pool, factory, b());
    }

    private static <T> Pools.Pool<T> a(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    private static <T> Resetter<T> b() {
        return (Resetter<T>) f21112a;
    }
}
