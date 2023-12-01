package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;
import android.os.Build;
import com.blued.android.core.imagecache.ImageLoaderUtils;
import com.blued.android.core.utils.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/LruBitmapPool.class */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
    private final LruPoolStrategy b;
    private final Set<Bitmap.Config> c;
    private final int d;
    private final BitmapTracker e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/LruBitmapPool$BitmapTracker.class */
    public interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/LruBitmapPool$NullBitmapTracker.class */
    static class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        @Override // com.blued.android.core.imagecache.glide.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
        }

        @Override // com.blued.android.core.imagecache.glide.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/LruBitmapPool$ThrowingBitmapTracker.class */
    static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> a = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.blued.android.core.imagecache.glide.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
            if (!this.a.contains(bitmap)) {
                this.a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.blued.android.core.imagecache.glide.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
            if (!this.a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.a.remove(bitmap);
        }
    }

    public LruBitmapPool(int i) {
        this(i, e(), f());
    }

    LruBitmapPool(int i, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.d = i;
        this.f = i;
        this.b = lruPoolStrategy;
        this.c = set;
        this.e = new NullBitmapTracker();
    }

    private Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        synchronized (this) {
            a2 = this.b.a(i, i2, config != null ? config : a);
            if (a2 == null) {
                if (ImageLoaderUtils.a) {
                    Log.b("LruBitmapPool", "Missing bitmap=" + this.b.b(i, i2, config));
                }
                this.i++;
            } else {
                this.h++;
                this.g -= this.b.c(a2);
                this.e.b(a2);
                b(a2);
            }
            if (ImageLoaderUtils.a) {
                Log.a("LruBitmapPool", "Get bitmap=" + this.b.b(i, i2, config));
            }
            c();
        }
        return a2;
    }

    private void b() {
        b(this.f);
    }

    private void b(int i) {
        synchronized (this) {
            while (this.g > i) {
                Bitmap a2 = this.b.a();
                if (a2 == null) {
                    if (ImageLoaderUtils.a) {
                        Log.d("LruBitmapPool", "Size mismatch, resetting");
                        d();
                    }
                    this.g = 0;
                    return;
                }
                this.e.b(a2);
                this.g -= this.b.c(a2);
                this.k++;
                if (ImageLoaderUtils.a) {
                    Log.b("LruBitmapPool", "Evicting bitmap=" + this.b.b(a2));
                }
                c();
                a2.recycle();
            }
        }
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    private void c() {
        if (ImageLoaderUtils.a) {
            d();
        }
    }

    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private void d() {
        Log.a("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b);
    }

    private static LruPoolStrategy e() {
        return Build.VERSION.SDK_INT >= 19 ? new SizeConfigStrategy() : new AttributeStrategy();
    }

    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap b = b(i, i2, config);
        if (b != null) {
            b.eraseColor(0);
        }
        return b;
    }

    public void a() {
        if (ImageLoaderUtils.a) {
            Log.b("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    public void a(int i) {
        if (ImageLoaderUtils.a) {
            Log.b("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            a();
        } else if (i >= 20) {
            b(this.f / 2);
        }
    }

    public void a(Bitmap bitmap) {
        synchronized (this) {
            if (bitmap == null) {
                if (ImageLoaderUtils.a) {
                    throw new NullPointerException("Bitmap must not be null");
                }
            } else if (bitmap.isRecycled()) {
                if (ImageLoaderUtils.a) {
                    throw new IllegalStateException("Cannot pool recycled bitmap");
                }
            } else {
                if (bitmap.isMutable() && this.b.c(bitmap) <= this.f && this.c.contains(bitmap.getConfig())) {
                    int c = this.b.c(bitmap);
                    this.b.a(bitmap);
                    this.e.a(bitmap);
                    this.j++;
                    this.g += c;
                    if (ImageLoaderUtils.a) {
                        Log.a("LruBitmapPool", "Put bitmap in pool=" + this.b.b(bitmap));
                    }
                    c();
                    b();
                    return;
                }
                if (ImageLoaderUtils.a) {
                    Log.a("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.c.contains(bitmap.getConfig()));
                }
                bitmap.recycle();
            }
        }
    }
}
