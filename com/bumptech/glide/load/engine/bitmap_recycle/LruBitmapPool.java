package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.class */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f7204a = Bitmap.Config.ARGB_8888;
    private final LruPoolStrategy b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Bitmap.Config> f7205c;
    private final long d;
    private final BitmapTracker e;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker.class */
    public interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$NullBitmapTracker.class */
    static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$ThrowingBitmapTracker.class */
    static class ThrowingBitmapTracker implements BitmapTracker {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Bitmap> f7206a = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
            if (!this.f7206a.contains(bitmap)) {
                this.f7206a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
            if (!this.f7206a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f7206a.remove(bitmap);
        }
    }

    public LruBitmapPool(long j) {
        this(j, f(), g());
    }

    LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.d = j;
        this.f = j;
        this.b = lruPoolStrategy;
        this.f7205c = set;
        this.e = new NullBitmapTracker();
    }

    private void a(long j) {
        synchronized (this) {
            while (this.g > j) {
                Bitmap a2 = this.b.a();
                if (a2 == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        e();
                    }
                    this.g = 0L;
                    return;
                }
                this.e.b(a2);
                this.g -= this.b.c(a2);
                this.k++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.b.b(a2));
                }
                d();
                a2.recycle();
            }
        }
    }

    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    private static Bitmap c(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = f7204a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private void c() {
        a(this.f);
    }

    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        synchronized (this) {
            a(config);
            a2 = this.b.a(i, i2, config != null ? config : f7204a);
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.b.b(i, i2, config));
                }
                this.i++;
            } else {
                this.h++;
                this.g -= this.b.c(a2);
                this.e.b(a2);
                b(a2);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.b.b(i, i2, config));
            }
            d();
        }
        return a2;
    }

    private void d() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            e();
        }
    }

    private void e() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b);
    }

    private static LruPoolStrategy f() {
        return Build.VERSION.SDK_INT >= 19 ? new SizeConfigStrategy() : new AttributeStrategy();
    }

    private static Set<Bitmap.Config> g() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap d = d(i, i2, config);
        if (d != null) {
            d.eraseColor(0);
            return d;
        }
        return c(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void a(Bitmap bitmap) {
        synchronized (this) {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.b.c(bitmap) <= this.f && this.f7205c.contains(bitmap.getConfig())) {
                int c2 = this.b.c(bitmap);
                this.b.a(bitmap);
                this.e.a(bitmap);
                this.j++;
                this.g += c2;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.b.b(bitmap));
                }
                d();
                c();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f7205c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        }
    }

    public long b() {
        return this.f;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap d = d(i, i2, config);
        Bitmap bitmap = d;
        if (d == null) {
            bitmap = c(i, i2, config);
        }
        return bitmap;
    }
}
