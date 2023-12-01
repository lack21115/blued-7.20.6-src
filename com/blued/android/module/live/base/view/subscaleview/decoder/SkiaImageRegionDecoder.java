package com.blued.android.module.live.base.view.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/decoder/SkiaImageRegionDecoder.class */
public class SkiaImageRegionDecoder implements ImageRegionDecoder {

    /* renamed from: a  reason: collision with root package name */
    private BitmapRegionDecoder f11575a;
    private final ReadWriteLock b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap.Config f11576c;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        this.b = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.f11576c = config;
        } else if (preferredBitmapConfig != null) {
            this.f11576c = preferredBitmapConfig;
        } else {
            this.f11576c = Bitmap.Config.RGB_565;
        }
    }

    private Lock c() {
        return Build.VERSION.SDK_INT < 21 ? this.b.writeLock() : this.b.readLock();
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public Bitmap a(Rect rect, int i) {
        c().lock();
        try {
            if (this.f11575a == null || this.f11575a.isRecycled()) {
                throw new IllegalStateException("Cannot decode region after decoder has been recycled");
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = this.f11576c;
            Bitmap decodeRegion = this.f11575a.decodeRegion(rect, options);
            if (decodeRegion != null) {
                return decodeRegion;
            }
            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        } finally {
            c().unlock();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0145 -> B:33:0x0111). Please submit an issue!!! */
    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public Point a(Context context, Uri uri) throws Exception {
        int i;
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals(i.f7952c)) {
                i = resources.getIdentifier(pathSegments.get(1), i.f7952c, authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException e) {
                    }
                }
                i = 0;
            }
            this.f11575a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.f11575a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.f11575a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            AutoCloseable autoCloseable = null;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream == null) {
                    throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                }
                this.f11575a = BitmapRegionDecoder.newInstance(openInputStream, false);
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        autoCloseable.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
        }
        return new Point(this.f11575a.getWidth(), this.f11575a.getHeight());
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public boolean a() {
        boolean z;
        synchronized (this) {
            if (this.f11575a != null) {
                if (!this.f11575a.isRecycled()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder
    public void b() {
        synchronized (this) {
            this.b.writeLock().lock();
            this.f11575a.recycle();
            this.f11575a = null;
            this.b.writeLock().unlock();
        }
    }
}
