package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/LruResourceCache.class */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f7226a;

    public LruResourceCache(long j) {
        super(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    public int a(Resource<?> resource) {
        return resource == null ? super.a((LruResourceCache) null) : resource.b();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* synthetic */ Resource a(Key key) {
        return (Resource) super.c(key);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void a(int i) {
        if (i >= 40) {
            c();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    public void a(Key key, Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f7226a;
        if (resourceRemovedListener == null || resource == null) {
            return;
        }
        resourceRemovedListener.b(resource);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void a(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f7226a = resourceRemovedListener;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource b(Key key, Resource resource) {
        return (Resource) super.b((LruResourceCache) key, (Key) resource);
    }
}
