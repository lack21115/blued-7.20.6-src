package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import ar.com.hjg.pngj.PngReaderApng;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.utils.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngDrawable.class */
public class ApngDrawable extends Drawable implements Animatable {
    protected final Uri a;
    String b;
    int c;
    int d;
    ApngInvalidationHandler i;
    Bitmap j;
    private Paint k;
    private final ImageView.ScaleType l;
    private RectF o;
    private WeakReference<ApngPlayListener> m = null;
    private boolean n = false;
    ScheduledThreadPoolExecutor f = null;
    ApngFrameDecode g = new ApngFrameDecode(this);
    ApngBitmapCache h = new ApngBitmapCache();
    protected int e = -1;
    private int p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.imagecache.drawable.apng.ApngDrawable$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngDrawable$5.class */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ApngDrawable(Bitmap bitmap, Uri uri, ImageView.ScaleType scaleType) {
        this.l = scaleType;
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.b = RecyclingUtils.a();
        this.a = uri;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.a.getPath(), options);
        this.c = options.outWidth;
        this.d = options.outHeight;
        this.i = new ApngInvalidationHandler(this);
    }

    private RectF a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int width = canvas.getWidth();
        float f8 = width;
        float f9 = f8 / this.c;
        float height = canvas.getHeight();
        float f10 = height / this.d;
        int i = AnonymousClass5.a[this.l.ordinal()];
        float f11 = 0.0f;
        if (i != 1) {
            if (i != 2 && i != 3) {
                f5 = f8;
                f6 = 0.0f;
                f7 = f11;
                f3 = height;
            } else if (f9 > f10) {
                f = this.c * f10;
                f2 = (f8 - f) / 2.0f;
                float f12 = f2;
                f5 = f;
                f11 = f12;
                f6 = 0.0f;
                f7 = f11;
                f3 = height;
            } else {
                f3 = this.d * f9;
                f4 = (height - f3) / 2.0f;
                float f13 = f4;
                f5 = f8;
                f6 = f13;
                f7 = 0.0f;
            }
        } else if (f9 > f10) {
            f3 = this.d * f9;
            f4 = 0.0f - ((f3 - height) / 2.0f);
            float f132 = f4;
            f5 = f8;
            f6 = f132;
            f7 = 0.0f;
        } else {
            f = this.c * f10;
            f2 = 0.0f - ((f - f8) / 2.0f);
            float f122 = f2;
            f5 = f;
            f11 = f122;
            f6 = 0.0f;
            f7 = f11;
            f3 = height;
        }
        return new RectF(f7, f6, f5 + f7, f3 + f6);
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        if (this.o == null) {
            this.o = a(canvas);
        }
        canvas.drawBitmap(bitmap, (Rect) null, this.o, this.k);
    }

    public static boolean a(File file) {
        boolean z = false;
        try {
            PngReaderApng pngReaderApng = new PngReaderApng(file);
            pngReaderApng.c();
            if (pngReaderApng.h() > 1) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public void a(int i) {
        this.g.c = i;
    }

    public void a(ApngPlayListener apngPlayListener) {
        if (apngPlayListener != null) {
            this.m = new WeakReference<>(apngPlayListener);
        } else {
            this.m = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.e <= 0) {
            this.j = this.h.b(0);
        }
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            a(canvas, bitmap);
        }
    }

    public ApngPlayListener f() {
        WeakReference<ApngPlayListener> weakReference = this.m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void g() {
        this.o = null;
        this.m = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        int i = this.p + 1;
        this.p = i;
        if (i < this.g.c || this.g.c == 0) {
            this.i.post(new Runnable() { // from class: com.blued.android.core.imagecache.drawable.apng.ApngDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    ApngPlayListener f = ApngDrawable.this.f();
                    if (f != null) {
                        f.c(ApngDrawable.this);
                    }
                }
            });
            return true;
        }
        this.i.post(new Runnable() { // from class: com.blued.android.core.imagecache.drawable.apng.ApngDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                ApngDrawable.this.stop();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        Uri uri = this.a;
        if (uri == null) {
            return null;
        }
        try {
            File file = new File(this.b, uri.getLastPathSegment());
            if (!file.exists()) {
                AppMethods.a(this.a.getPath(), file.getPath(), false);
            }
            return file.getPath();
        } catch (Exception e) {
            Log.e("ApngDrawable2", "Error: " + e.toString());
            return null;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.k.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.k.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.n = true;
        this.e = 0;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        this.f = new ScheduledThreadPoolExecutor(1, new ThreadPoolExecutor.DiscardPolicy());
        if (!this.g.a) {
            this.f.execute(new Runnable() { // from class: com.blued.android.core.imagecache.drawable.apng.ApngDrawable.3
                @Override // java.lang.Runnable
                public void run() {
                    ApngDrawable.this.g.a();
                }
            });
        }
        this.f.execute(new Runnable() { // from class: com.blued.android.core.imagecache.drawable.apng.ApngDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                ApngDrawable.this.g.b();
                ApngDrawable.this.i.post(new Runnable() { // from class: com.blued.android.core.imagecache.drawable.apng.ApngDrawable.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ApngDrawable.this.g.a) {
                            ApngDrawable.this.stop();
                            return;
                        }
                        ApngPlayListener f = ApngDrawable.this.f();
                        if (f != null) {
                            f.a(ApngDrawable.this);
                        }
                        ApngDrawable.this.invalidateSelf();
                    }
                });
            }
        });
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.p = 0;
            this.n = false;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f;
            if (scheduledThreadPoolExecutor != null) {
                scheduledThreadPoolExecutor.shutdownNow();
                this.f = null;
            }
            ApngPlayListener f = f();
            if (f != null) {
                f.b(this);
            }
            this.h.a();
        }
    }
}
