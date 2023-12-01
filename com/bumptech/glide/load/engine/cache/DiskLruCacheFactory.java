package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskLruCacheFactory.class */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final long f7218a;
    private final CacheDirectoryGetter b;

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskLruCacheFactory$2.class */
    class AnonymousClass2 implements CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7220a;
        final /* synthetic */ String b;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            return new File(this.f7220a, this.b);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskLruCacheFactory$CacheDirectoryGetter.class */
    public interface CacheDirectoryGetter {
        File a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.f7218a = j;
        this.b = cacheDirectoryGetter;
    }

    public DiskLruCacheFactory(final String str, long j) {
        this(new CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.1
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File a() {
                return new File(str);
            }
        }, j);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache a() {
        File a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return DiskLruCacheWrapper.a(a2, this.f7218a);
        }
        return null;
    }
}
