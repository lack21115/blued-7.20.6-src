package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/ExternalPreferredCacheDiskCacheFactory.class */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/ExternalPreferredCacheDiskCacheFactory$1.class */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7224a;
        final /* synthetic */ String b;

        private File b() {
            File cacheDir = this.f7224a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            File externalCacheDir;
            File b = b();
            if ((b == null || !b.exists()) && (externalCacheDir = this.f7224a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
            }
            return b;
        }
    }
}
