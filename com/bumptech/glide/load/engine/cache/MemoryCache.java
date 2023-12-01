package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemoryCache.class */
public interface MemoryCache {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemoryCache$ResourceRemovedListener.class */
    public interface ResourceRemovedListener {
        void b(Resource<?> resource);
    }

    long a();

    Resource<?> a(Key key);

    void a(int i);

    void a(ResourceRemovedListener resourceRemovedListener);

    long b();

    Resource<?> b(Key key, Resource<?> resource);

    void c();
}
