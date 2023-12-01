package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/prefill/BitmapPreFillRunner.class */
final class BitmapPreFillRunner implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private final BitmapPool f7247c;
    private final MemoryCache d;
    private final PreFillQueue e;
    private final Clock f;
    private final Set<PreFillType> g;
    private final Handler h;
    private long i;
    private boolean j;
    private static final Clock b = new Clock();

    /* renamed from: a  reason: collision with root package name */
    static final long f7246a = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/prefill/BitmapPreFillRunner$Clock.class */
    public static class Clock {
        Clock() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/prefill/BitmapPreFillRunner$UniqueKey.class */
    public static final class UniqueKey implements Key {
        UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public void a(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    private boolean a(long j) {
        return this.f.a() - j >= 32;
    }

    private long b() {
        return this.d.b() - this.d.a();
    }

    private long c() {
        long j = this.i;
        this.i = Math.min(4 * j, f7246a);
        return j;
    }

    boolean a() {
        Bitmap createBitmap;
        long a2 = this.f.a();
        while (!this.e.b() && !a(a2)) {
            PreFillType a3 = this.e.a();
            if (this.g.contains(a3)) {
                createBitmap = Bitmap.createBitmap(a3.a(), a3.b(), a3.c());
            } else {
                this.g.add(a3);
                createBitmap = this.f7247c.b(a3.a(), a3.b(), a3.c());
            }
            int a4 = Util.a(createBitmap);
            if (b() >= a4) {
                this.d.b(new UniqueKey(), BitmapResource.a(createBitmap, this.f7247c));
            } else {
                this.f7247c.a(createBitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + a3.a() + "x" + a3.b() + "] " + a3.c() + " size: " + a4);
            }
        }
        return (this.j || this.e.b()) ? false : true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.h.postDelayed(this, c());
        }
    }
}
