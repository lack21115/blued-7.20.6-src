package com.sobot.chat.widget.subscaleview.decoder;

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
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.widget.subscaleview.SobotScaleImageView;
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

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/subscaleview/decoder/SkiaPooledImageRegionDecoder.class */
public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = SkiaPooledImageRegionDecoder.class.getSimpleName();
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private DecoderPool decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/subscaleview/decoder/SkiaPooledImageRegionDecoder$DecoderPool.class */
    public static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void add(BitmapRegionDecoder bitmapRegionDecoder) {
            synchronized (this) {
                this.decoders.put(bitmapRegionDecoder, false);
                this.available.release();
            }
        }

        private BitmapRegionDecoder getNextAvailable() {
            Map.Entry<BitmapRegionDecoder, Boolean> next;
            synchronized (this) {
                Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> it = this.decoders.entrySet().iterator();
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

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this) {
                isEmpty = this.decoders.isEmpty();
            }
            return isEmpty;
        }

        private boolean markAsUnused(BitmapRegionDecoder bitmapRegionDecoder) {
            Map.Entry<BitmapRegionDecoder, Boolean> next;
            synchronized (this) {
                Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> it = this.decoders.entrySet().iterator();
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
        public void recycle() {
            synchronized (this) {
                while (!this.decoders.isEmpty()) {
                    BitmapRegionDecoder acquire = acquire();
                    acquire.recycle();
                    this.decoders.remove(acquire);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int size() {
            int size;
            synchronized (this) {
                size = this.decoders.size();
            }
            return size;
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.decoderPool = new DecoderPool();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SobotScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    private int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.sobot.chat.widget.subscaleview.decoder.SkiaPooledImageRegionDecoder.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private int getNumberOfCores() {
        return Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : getNumCoresOldPhones();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseDecoder() throws Exception {
        long j;
        BitmapRegionDecoder bitmapRegionDecoder;
        long j2;
        int i;
        String uri = this.uri.toString();
        long j3 = Long.MAX_VALUE;
        if (uri.startsWith(RESOURCE_PREFIX)) {
            String authority = this.uri.getAuthority();
            Resources resources = this.context.getPackageName().equals(authority) ? this.context.getResources() : this.context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = this.uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals(i.f5112c)) {
                i = resources.getIdentifier(pathSegments.get(1), i.f5112c, authority);
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
                j3 = this.context.getResources().openRawResourceFd(i).getLength();
            } catch (Exception e2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(i), false);
        } else if (uri.startsWith(ASSET_PREFIX)) {
            String substring = uri.substring(22);
            try {
                j3 = this.context.getAssets().openFd(substring).getLength();
            } catch (Exception e3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getAssets().open(substring, 1), false);
        } else if (uri.startsWith(FILE_PREFIX)) {
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
                ContentResolver contentResolver = this.context.getContentResolver();
                InputStream openInputStream = contentResolver.openInputStream(this.uri);
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, "r");
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
        this.fileLength = j3;
        this.imageDimensions.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            if (this.decoderPool != null) {
                this.decoderPool.add(bitmapRegionDecoder);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return true;
    }

    private void lazyInit() {
        if (!this.lazyInited.compareAndSet(false, true) || this.fileLength >= Long.MAX_VALUE) {
            return;
        }
        debug("Starting lazy init of additional decoders");
        new Thread() { // from class: com.sobot.chat.widget.subscaleview.decoder.SkiaPooledImageRegionDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                    SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                    if (!skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), SkiaPooledImageRegionDecoder.this.fileLength)) {
                        return;
                    }
                    try {
                        if (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                            SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder2 = SkiaPooledImageRegionDecoder.this;
                            skiaPooledImageRegionDecoder2.debug("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        }
                    } catch (Exception e) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder3 = SkiaPooledImageRegionDecoder.this;
                        skiaPooledImageRegionDecoder3.debug("Failed to start decoder: " + e.getMessage());
                    }
                }
            }
        }.start();
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    protected boolean allowAdditionalDecoder(int i, long j) {
        if (i >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j2 = i * j;
        if (j2 > 20971520) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        } else if (i >= getNumberOfCores()) {
            debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
            return false;
        } else if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        } else {
            debug("Additional decoder allowed, current count is " + i + ", estimated native memory " + (j2 / 1048576) + "Mb");
            return true;
        }
    }

    @Override // com.sobot.chat.widget.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect rect, int i) {
        debug("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            if (this.decoderPool != null) {
                BitmapRegionDecoder acquire = this.decoderPool.acquire();
                if (acquire != null && !acquire.isRecycled()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = i;
                    options.inPreferredConfig = this.bitmapConfig;
                    Bitmap decodeRegion = acquire.decodeRegion(rect, options);
                    if (decodeRegion != null) {
                        if (acquire != null) {
                            this.decoderPool.release(acquire);
                        }
                        return decodeRegion;
                    }
                    throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                } else if (acquire != null) {
                    this.decoderPool.release(acquire);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.decoderLock.readLock().unlock();
        }
    }

    @Override // com.sobot.chat.widget.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context context, Uri uri) throws Exception {
        this.context = context;
        this.uri = uri;
        initialiseDecoder();
        return this.imageDimensions;
    }

    @Override // com.sobot.chat.widget.subscaleview.decoder.ImageRegionDecoder
    public boolean isReady() {
        boolean z;
        synchronized (this) {
            if (this.decoderPool != null) {
                if (!this.decoderPool.isEmpty()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.sobot.chat.widget.subscaleview.decoder.ImageRegionDecoder
    public void recycle() {
        synchronized (this) {
            this.decoderLock.writeLock().lock();
            if (this.decoderPool != null) {
                this.decoderPool.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
            this.decoderLock.writeLock().unlock();
        }
    }
}
