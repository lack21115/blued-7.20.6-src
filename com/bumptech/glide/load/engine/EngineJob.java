package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJob.class */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory e = new EngineResourceFactory();

    /* renamed from: a  reason: collision with root package name */
    final ResourceCallbacksAndExecutors f7169a;
    DataSource b;

    /* renamed from: c  reason: collision with root package name */
    GlideException f7170c;
    EngineResource<?> d;
    private final StateVerifier f;
    private final EngineResource.ResourceListener g;
    private final Pools.Pool<EngineJob<?>> h;
    private final EngineResourceFactory i;
    private final EngineJobListener j;
    private final GlideExecutor k;
    private final GlideExecutor l;
    private final GlideExecutor m;
    private final GlideExecutor n;
    private final AtomicInteger o;
    private Key p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private Resource<?> u;
    private boolean v;
    private boolean w;
    private DecodeJob<R> x;
    private volatile boolean y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJob$CallLoadFailed.class */
    public class CallLoadFailed implements Runnable {
        private final ResourceCallback b;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.b = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.b.h()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f7169a.b(this.b)) {
                        EngineJob.this.b(this.b);
                    }
                    EngineJob.this.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJob$CallResourceReady.class */
    public class CallResourceReady implements Runnable {
        private final ResourceCallback b;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.b = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.b.h()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f7169a.b(this.b)) {
                        EngineJob.this.d.g();
                        EngineJob.this.a(this.b);
                        EngineJob.this.c(this.b);
                    }
                    EngineJob.this.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJob$EngineResourceFactory.class */
    public static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> a(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource<>(resource, z, true, key, resourceListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJob$ResourceCallbackAndExecutor.class */
    public static final class ResourceCallbackAndExecutor {

        /* renamed from: a  reason: collision with root package name */
        final ResourceCallback f7173a;
        final Executor b;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f7173a = resourceCallback;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f7173a.equals(((ResourceCallbackAndExecutor) obj).f7173a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7173a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors.class */
    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {

        /* renamed from: a  reason: collision with root package name */
        private final List<ResourceCallbackAndExecutor> f7174a;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.f7174a = list;
        }

        private static ResourceCallbackAndExecutor c(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.b());
        }

        void a(ResourceCallback resourceCallback) {
            this.f7174a.remove(c(resourceCallback));
        }

        void a(ResourceCallback resourceCallback, Executor executor) {
            this.f7174a.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        boolean a() {
            return this.f7174a.isEmpty();
        }

        int b() {
            return this.f7174a.size();
        }

        boolean b(ResourceCallback resourceCallback) {
            return this.f7174a.contains(c(resourceCallback));
        }

        void c() {
            this.f7174a.clear();
        }

        ResourceCallbacksAndExecutors d() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.f7174a));
        }

        @Override // java.lang.Iterable
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.f7174a.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, e);
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.f7169a = new ResourceCallbacksAndExecutors();
        this.f = StateVerifier.a();
        this.o = new AtomicInteger();
        this.k = glideExecutor;
        this.l = glideExecutor2;
        this.m = glideExecutor3;
        this.n = glideExecutor4;
        this.j = engineJobListener;
        this.g = resourceListener;
        this.h = pool;
        this.i = engineResourceFactory;
    }

    private GlideExecutor g() {
        return this.r ? this.m : this.s ? this.n : this.l;
    }

    private boolean h() {
        return this.w || this.v || this.y;
    }

    private void i() {
        synchronized (this) {
            if (this.p == null) {
                throw new IllegalArgumentException();
            }
            this.f7169a.c();
            this.p = null;
            this.d = null;
            this.u = null;
            this.w = false;
            this.y = false;
            this.v = false;
            this.x.a(false);
            this.x = null;
            this.f7170c = null;
            this.b = null;
            this.h.release(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob<R> a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        synchronized (this) {
            this.p = key;
            this.q = z;
            this.r = z2;
            this.s = z3;
            this.t = z4;
        }
        return this;
    }

    void a(int i) {
        synchronized (this) {
            Preconditions.a(h(), "Not yet complete!");
            if (this.o.getAndAdd(i) == 0 && this.d != null) {
                this.d.g();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void a(GlideException glideException) {
        synchronized (this) {
            this.f7170c = glideException;
        }
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void a(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.u = resource;
            this.b = dataSource;
        }
        c();
    }

    void a(ResourceCallback resourceCallback) {
        try {
            resourceCallback.a(this.d, this.b);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ResourceCallback resourceCallback, Executor executor) {
        synchronized (this) {
            this.f.b();
            this.f7169a.a(resourceCallback, executor);
            boolean z = true;
            if (this.v) {
                a(1);
                executor.execute(new CallResourceReady(resourceCallback));
            } else if (this.w) {
                a(1);
                executor.execute(new CallLoadFailed(resourceCallback));
            } else {
                if (this.y) {
                    z = false;
                }
                Preconditions.a(z, "Cannot add callbacks to a cancelled EngineJob");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.t;
    }

    void b() {
        if (h()) {
            return;
        }
        this.y = true;
        this.x.b();
        this.j.a(this, this.p);
    }

    public void b(DecodeJob<R> decodeJob) {
        synchronized (this) {
            this.x = decodeJob;
            (decodeJob.a() ? this.k : g()).execute(decodeJob);
        }
    }

    void b(ResourceCallback resourceCallback) {
        try {
            resourceCallback.a(this.f7170c);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void c() {
        synchronized (this) {
            this.f.b();
            if (this.y) {
                this.u.c();
                i();
            } else if (this.f7169a.a()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else {
                if (this.v) {
                    throw new IllegalStateException("Already have resource");
                }
                this.d = this.i.a(this.u, this.q, this.p, this.g);
                this.v = true;
                ResourceCallbacksAndExecutors d = this.f7169a.d();
                a(d.b() + 1);
                this.j.a(this, this.p, this.d);
                Iterator<ResourceCallbackAndExecutor> it = d.iterator();
                while (it.hasNext()) {
                    ResourceCallbackAndExecutor next = it.next();
                    next.b.execute(new CallResourceReady(next.f7173a));
                }
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ResourceCallback resourceCallback) {
        boolean z;
        synchronized (this) {
            this.f.b();
            this.f7169a.a(resourceCallback);
            if (this.f7169a.a()) {
                b();
                if (!this.v && !this.w) {
                    z = false;
                    if (z && this.o.get() == 0) {
                        i();
                    }
                }
                z = true;
                if (z) {
                    i();
                }
            }
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier d() {
        return this.f;
    }

    void e() {
        EngineResource<?> engineResource;
        synchronized (this) {
            this.f.b();
            Preconditions.a(h(), "Not yet complete!");
            int decrementAndGet = this.o.decrementAndGet();
            Preconditions.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource = this.d;
                i();
            } else {
                engineResource = null;
            }
        }
        if (engineResource != null) {
            engineResource.h();
        }
    }

    void f() {
        synchronized (this) {
            this.f.b();
            if (this.y) {
                i();
            } else if (this.f7169a.a()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else {
                if (this.w) {
                    throw new IllegalStateException("Already failed once");
                }
                this.w = true;
                Key key = this.p;
                ResourceCallbacksAndExecutors d = this.f7169a.d();
                a(d.b() + 1);
                this.j.a(this, key, null);
                Iterator<ResourceCallbackAndExecutor> it = d.iterator();
                while (it.hasNext()) {
                    ResourceCallbackAndExecutor next = it.next();
                    next.b.execute(new CallLoadFailed(next.f7173a));
                }
                e();
            }
        }
    }
}
