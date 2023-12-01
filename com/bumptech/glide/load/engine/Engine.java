package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/Engine.class */
public class Engine implements EngineJobListener, EngineResource.ResourceListener, MemoryCache.ResourceRemovedListener {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f20764a = Log.isLoggable("Engine", 2);
    private final Jobs b;

    /* renamed from: c  reason: collision with root package name */
    private final EngineKeyFactory f20765c;
    private final MemoryCache d;
    private final EngineJobFactory e;
    private final ResourceRecycler f;
    private final LazyDiskCacheProvider g;
    private final DecodeJobFactory h;
    private final ActiveResources i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/Engine$DecodeJobFactory.class */
    public static class DecodeJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.DiskCacheProvider f20766a;
        final Pools.Pool<DecodeJob<?>> b = FactoryPools.a(150, new FactoryPools.Factory<DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: a */
            public DecodeJob<?> b() {
                return new DecodeJob<>(DecodeJobFactory.this.f20766a, DecodeJobFactory.this.b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f20767c;

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.f20766a = diskCacheProvider;
        }

        <R> DecodeJob<R> a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.Callback<R> callback) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.a(this.b.acquire());
            int i3 = this.f20767c;
            this.f20767c = i3 + 1;
            return decodeJob.a(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, callback, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/Engine$EngineJobFactory.class */
    public static class EngineJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final GlideExecutor f20769a;
        final GlideExecutor b;

        /* renamed from: c  reason: collision with root package name */
        final GlideExecutor f20770c;
        final GlideExecutor d;
        final EngineJobListener e;
        final EngineResource.ResourceListener f;
        final Pools.Pool<EngineJob<?>> g = FactoryPools.a(150, new FactoryPools.Factory<EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: a */
            public EngineJob<?> b() {
                return new EngineJob<>(EngineJobFactory.this.f20769a, EngineJobFactory.this.b, EngineJobFactory.this.f20770c, EngineJobFactory.this.d, EngineJobFactory.this.e, EngineJobFactory.this.f, EngineJobFactory.this.g);
            }
        });

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.f20769a = glideExecutor;
            this.b = glideExecutor2;
            this.f20770c = glideExecutor3;
            this.d = glideExecutor4;
            this.e = engineJobListener;
            this.f = resourceListener;
        }

        <R> EngineJob<R> a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((EngineJob) Preconditions.a(this.g.acquire())).a(key, z, z2, z3, z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.class */
    public static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* renamed from: a  reason: collision with root package name */
        private final DiskCache.Factory f20772a;
        private volatile DiskCache b;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f20772a = factory;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.f20772a.a();
                    }
                    if (this.b == null) {
                        this.b = new DiskCacheAdapter();
                    }
                }
            }
            return this.b;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/Engine$LoadStatus.class */
    public class LoadStatus {
        private final EngineJob<?> b;

        /* renamed from: c  reason: collision with root package name */
        private final ResourceCallback f20774c;

        LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f20774c = resourceCallback;
            this.b = engineJob;
        }

        public void a() {
            synchronized (Engine.this) {
                this.b.c(this.f20774c);
            }
        }
    }

    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z) {
        this.d = memoryCache;
        this.g = new LazyDiskCacheProvider(factory);
        activeResources = activeResources == null ? new ActiveResources(z) : activeResources;
        this.i = activeResources;
        activeResources.a(this);
        this.f20765c = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.b = jobs == null ? new Jobs() : jobs;
        this.e = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.h = decodeJobFactory == null ? new DecodeJobFactory(this.g) : decodeJobFactory;
        this.f = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.a(this);
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z);
    }

    private <R> LoadStatus a(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j) {
        EngineJob<?> a2 = this.b.a(engineKey, z6);
        if (a2 != null) {
            a2.a(resourceCallback, executor);
            if (f20764a) {
                a("Added to existing load", j, engineKey);
            }
            return new LoadStatus(resourceCallback, a2);
        }
        EngineJob<R> a3 = this.e.a(engineKey, z3, z4, z5, z6);
        DecodeJob<R> a4 = this.h.a(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, a3);
        this.b.a((Key) engineKey, (EngineJob<?>) a3);
        a3.a(resourceCallback, executor);
        a3.b(a4);
        if (f20764a) {
            a("Started new load", j, engineKey);
        }
        return new LoadStatus(resourceCallback, a3);
    }

    private EngineResource<?> a(Key key) {
        EngineResource<?> b = this.i.b(key);
        if (b != null) {
            b.g();
        }
        return b;
    }

    private EngineResource<?> a(EngineKey engineKey, boolean z, long j) {
        if (z) {
            EngineResource<?> a2 = a(engineKey);
            if (a2 != null) {
                if (f20764a) {
                    a("Loaded resource from active resources", j, engineKey);
                }
                return a2;
            }
            EngineResource<?> b = b(engineKey);
            if (b != null) {
                if (f20764a) {
                    a("Loaded resource from cache", j, engineKey);
                }
                return b;
            }
            return null;
        }
        return null;
    }

    private static void a(String str, long j, Key key) {
        Log.v("Engine", str + " in " + LogTime.a(j) + "ms, key: " + key);
    }

    private EngineResource<?> b(Key key) {
        EngineResource<?> c2 = c(key);
        if (c2 != null) {
            c2.g();
            this.i.a(key, c2);
        }
        return c2;
    }

    private EngineResource<?> c(Key key) {
        Resource<?> a2 = this.d.a(key);
        if (a2 == null) {
            return null;
        }
        return a2 instanceof EngineResource ? (EngineResource) a2 : new EngineResource<>(a2, true, true, key, this);
    }

    public <R> LoadStatus a(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long a2 = f20764a ? LogTime.a() : 0L;
        EngineKey a3 = this.f20765c.a(obj, key, i, i2, map, cls, cls2, options);
        synchronized (this) {
            EngineResource<?> a4 = a(a3, z3, a2);
            if (a4 == null) {
                return a(glideContext, obj, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, a3, a2);
            }
            resourceCallback.a(a4, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    public void a() {
        this.g.a().a();
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void a(Key key, EngineResource<?> engineResource) {
        this.i.a(key);
        if (engineResource.e()) {
            this.d.b(key, engineResource);
        } else {
            this.f.a(engineResource, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public void a(EngineJob<?> engineJob, Key key) {
        synchronized (this) {
            this.b.b(key, engineJob);
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public void a(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        synchronized (this) {
            if (engineResource != null) {
                if (engineResource.e()) {
                    this.i.a(key, engineResource);
                }
            }
            this.b.b(key, engineJob);
        }
    }

    public void a(Resource<?> resource) {
        if (!(resource instanceof EngineResource)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((EngineResource) resource).h();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void b(Resource<?> resource) {
        this.f.a(resource, true);
    }
}
