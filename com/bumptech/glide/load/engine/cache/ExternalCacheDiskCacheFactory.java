package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/ExternalCacheDiskCacheFactory.class */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/ExternalCacheDiskCacheFactory$1.class */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f20829a;
        final /* synthetic */ String b;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            File externalCacheDir = this.f20829a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
        }
    }
}
