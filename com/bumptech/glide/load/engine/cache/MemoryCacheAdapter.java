package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemoryCacheAdapter.class */
public class MemoryCacheAdapter implements MemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f7227a;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long a() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource<?> a(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void a(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f7227a = resourceRemovedListener;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long b() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource<?> b(Key key, Resource<?> resource) {
        if (resource != null) {
            this.f7227a.b(resource);
            return null;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void c() {
    }
}
