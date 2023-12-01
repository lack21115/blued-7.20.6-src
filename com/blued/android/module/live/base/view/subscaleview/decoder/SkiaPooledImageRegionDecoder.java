package com.blued.android.module.live.base.view.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.b.g;
import com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/decoder/SkiaPooledImageRegionDecoder.class */
public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String a = SkiaPooledImageRegionDecoder.class.getSimpleName();
    private static boolean b = false;
    private DecoderPool c;
    private final ReadWriteLock d;
    private final Bitmap.Config e;
    private Context f;
    private Uri g;
    private long h;
    private final Point i;
    private final AtomicBoolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/decoder/SkiaPooledImageRegionDecoder$DecoderPool.class */
    public static class DecoderPool {
        private final Semaphore a;
        private final Map<BitmapRegionDecoder, Boolean> b;

        private DecoderPool() {
            this.a = new Semaphore(0, true);
            this.b = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BitmapRegionDecoder bitmapRegionDecoder) {
            if (c(bitmapRegionDecoder)) {
                this.a.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            boolean isEmpty;
            synchronized (this) {
                isEmpty = this.b.isEmpty();
            }
            return isEmpty;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int b() {
            int size;
            synchronized (this) {
                size = this.b.size();
            }
            return size;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(BitmapRegionDecoder bitmapRegionDecoder) {
            synchronized (this) {
                this.b.put(bitmapRegionDecoder, false);
                this.a.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder c() {
            this.a.acquireUninterruptibly();
            return e();
        }

        private boolean c(BitmapRegionDecoder bitmapRegionDecoder) {
            Map.Entry<BitmapRegionDecoder, Boolean> next;
            synchronized (this) {
                Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> it = this.b.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next = it.next();
                } while (bitmapRegionDecoder != next.getKey());
                if (next.getValue().booleanValue()) {
                    next.setValue(false);
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            synchronized (this) {
                while (!this.b.isEmpty()) {
                    BitmapRegionDecoder c = c();
                    c.recycle();
                    this.b.remove(c);
                }
            }
        }

        private BitmapRegionDecoder e() {
            Map.Entry<BitmapRegionDecoder, Boolean> next;
            synchronized (this) {
                Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> it = this.b.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        return null;
                    }
                    next = it.next();
                } while (next.getValue().booleanValue());
                next.setValue(true);
                return next.getKey();
            }
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.c = new DecoderPool();
        this.d = new ReentrantReadWriteLock(true);
        this.h = Long.MAX_VALUE;
        this.i = new Point(0, 0);
        this.j = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.e = config;
        } else if (preferredBitmapConfig != null) {
            this.e = preferredBitmapConfig;
        } else {
            this.e = Bitmap.Config.RGB_565;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (b) {
            Log.d(a, str);
        }
    }

    private void c() {
        if (!this.j.compareAndSet(false, true) || this.h >= Long.MAX_VALUE) {
            return;
        }
        a("Starting lazy init of additional decoders");
        new Thread() { // from class: com.blued.android.module.live.base.view.subscaleview.decoder.SkiaPooledImageRegionDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (SkiaPooledImageRegionDecoder.this.c != null) {
                    SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                    if (!skiaPooledImageRegionDecoder.a(skiaPooledImageRegionDecoder.c.b(), SkiaPooledImageRegionDecoder.this.h)) {
                        return;
                    }
                    try {
                        if (SkiaPooledImageRegionDecoder.this.c != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.a("Starting decoder");
                            SkiaPooledImageRegionDecoder.this.d();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder2 = SkiaPooledImageRegionDecoder.this;
                            skiaPooledImageRegionDecoder2.a("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        }
                    } catch (Exception e) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder3 = SkiaPooledImageRegionDecoder.this;
                        skiaPooledImageRegionDecoder3.a("Failed to start decoder: " + e.getMessage());
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws Exception {
        long j;
        BitmapRegionDecoder bitmapRegionDecoder;
        long j2;
        int i;
        String uri = this.g.toString();
        long j3 = Long.MAX_VALUE;
        if (uri.startsWith("android.resource://")) {
            String authority = this.g.getAuthority();
            Resources resources = this.f.getPackageName().equals(authority) ? this.f.getResources() : this.f.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = this.g.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException e) {
                    }
                }
                i = 0;
            }
            try {
                j3 = this.f.getResources().openRawResourceFd(i).getLength();
            } catch (Exception e2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.f.getResources().openRawResource(i), false);
        } else if (uri.startsWith("file:///android_asset/")) {
            String substring = uri.substring(22);
            try {
                j3 = this.f.getAssets().openFd(substring).getLength();
            } catch (Exception e3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.f.getAssets().open(substring, 1), false);
        } else if (uri.startsWith("file://")) {
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(uri.substring(7), false);
            try {
                File file = new File(uri);
                j2 = Long.MAX_VALUE;
                if (file.exists()) {
                    j2 = file.length();
                }
            } catch (Exception e4) {
                j2 = Long.MAX_VALUE;
            }
            j3 = j2;
        } else {
            InputStream inputStream = null;
            try {
                ContentResolver contentResolver = this.f.getContentResolver();
                InputStream openInputStream = contentResolver.openInputStream(this.g);
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.g, g.o.o);
                    j = Long.MAX_VALUE;
                    if (openAssetFileDescriptor != null) {
                        inputStream = openInputStream;
                        j = openAssetFileDescriptor.getLength();
                    }
                } catch (Exception e5) {
                    j = Long.MAX_VALUE;
                }
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                bitmapRegionDecoder = newInstance;
                j3 = j;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                    }
                }
                throw th;
            }
        }
        this.h = j3;
        this.i.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.d.writeLock().lock();
        try {
            if (this.c != null) {
                this.c.b(bitmapRegionDecoder);
            }
        } finally {
            this.d.writeLock().unlock();
        }
    }

    private int e() {
        return Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : f();
    }

    private int f() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.blued.android.module.live.base.view.subscaleview.decoder.SkiaPooledImageRegionDecoder.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private boolean g() {
        ActivityManager activityManager = (ActivityManager) this.f.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return true;
    }

    public static void setDebug(boolean z) {
        b = z;
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public Bitmap a(Rect rect, int i) {
        a("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.i.x || rect.height() < this.i.y) {
            c();
        }
        this.d.readLock().lock();
        try {
            if (this.c != null) {
                BitmapRegionDecoder c = this.c.c();
                if (c != null && !c.isRecycled()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = i;
                    options.inPreferredConfig = this.e;
                    Bitmap decodeRegion = c.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        if (c != null) {
                            this.c.a(c);
                        }
                        return decodeRegion;
                    }
                    throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                } else if (c != null) {
                    this.c.a(c);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.d.readLock().unlock();
        }
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public Point a(Context context, Uri uri) throws Exception {
        this.f = context;
        this.g = uri;
        d();
        return this.i;
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public boolean a() {
        boolean z;
        synchronized (this) {
            if (this.c != null) {
                if (!this.c.a()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    protected boolean a(int i, long j) {
        if (i >= 4) {
            a("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j2 = i * j;
        if (j2 > 20971520) {
            a("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        } else if (i >= e()) {
            a("No additional encoders allowed, limited by CPU cores (" + e() + ")");
            return false;
        } else if (g()) {
            a("No additional encoders allowed, memory is low");
            return false;
        } else {
            a("Additional decoder allowed, current count is " + i + ", estimated native memory " + (j2 / 1048576) + "Mb");
            return true;
        }
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public void b() {
        synchronized (this) {
            this.d.writeLock().lock();
            if (this.c != null) {
                this.c.d();
                this.c = null;
                this.f = null;
                this.g = null;
            }
            this.d.writeLock().unlock();
        }
    }
}
