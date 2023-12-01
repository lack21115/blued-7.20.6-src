package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCacheAdapter.class */
public class DiskCacheAdapter implements DiskCache {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCacheAdapter$Factory.class */
    public static final class Factory implements DiskCache.Factory {
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public DiskCache a() {
            return new DiskCacheAdapter();
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File a(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a(Key key, DiskCache.Writer writer) {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
    }
}
