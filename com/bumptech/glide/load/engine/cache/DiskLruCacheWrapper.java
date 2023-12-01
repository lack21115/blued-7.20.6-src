package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.class */
public class DiskLruCacheWrapper implements DiskCache {
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7222c;
    private DiskLruCache e;
    private final DiskCacheWriteLocker d = new DiskCacheWriteLocker();

    /* renamed from: a  reason: collision with root package name */
    private final SafeKeyGenerator f7221a = new SafeKeyGenerator();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.b = file;
        this.f7222c = j;
    }

    public static DiskCache a(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    private DiskLruCache b() throws IOException {
        DiskLruCache diskLruCache;
        synchronized (this) {
            if (this.e == null) {
                this.e = DiskLruCache.a(this.b, 1, 1, this.f7222c);
            }
            diskLruCache = this.e;
        }
        return diskLruCache;
    }

    private void c() {
        synchronized (this) {
            this.e = null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File a(Key key) {
        String a2 = this.f7221a.a(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a2 + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value a3 = b().a(a2);
            if (a3 != null) {
                return a3.a(0);
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a() {
        synchronized (this) {
            try {
                b().delete();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e);
                }
            }
            c();
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a(Key key, DiskCache.Writer writer) {
        DiskLruCache b;
        String a2 = this.f7221a.a(key);
        this.d.a(a2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a2 + " for for Key: " + key);
            }
            try {
                b = b();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (b.a(a2) != null) {
                return;
            }
            DiskLruCache.Editor b2 = b.b(a2);
            if (b2 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + a2);
            }
            try {
                if (writer.a(b2.a(0))) {
                    b2.a();
                }
                b2.c();
            } catch (Throwable th) {
                b2.c();
                throw th;
            }
        } finally {
            this.d.b(a2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            b().c(this.f7221a.a(key));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
