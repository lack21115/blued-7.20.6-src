package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadJobImpl.class */
public class LoadJobImpl extends LoadJob implements Runnable {
    protected LoadType a = LoadType.DATA;
    protected final RecyclingImageView b;
    protected final String c;
    protected final String d;
    protected final LoadOptions e;
    protected final ImageLoadingListener f;
    protected final Handler g;
    protected Future h;
    private final ReentrantLock i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.imagecache.LoadJobImpl$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadJobImpl$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[RecyclingUtils.Scheme.values().length];
            a = iArr;
            try {
                iArr[RecyclingUtils.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[RecyclingUtils.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[RecyclingUtils.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[RecyclingUtils.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[RecyclingUtils.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[RecyclingUtils.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[RecyclingUtils.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadJobImpl$LoadType.class */
    public enum LoadType {
        DATA,
        NET
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadJobImpl$SwitchJobLoadType.class */
    public class SwitchJobLoadType extends RuntimeException {
        private SwitchJobLoadType() {
        }

        /* synthetic */ SwitchJobLoadType(LoadJobImpl loadJobImpl, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public LoadJobImpl(RecyclingImageView recyclingImageView, String str, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener, String str2) {
        this.b = recyclingImageView;
        this.d = str;
        this.e = loadOptions;
        this.f = imageLoadingListener;
        this.c = str2;
        this.i = ImageLoadEngine.a(str);
        if (AppMethods.b()) {
            this.g = new Handler();
        } else {
            this.g = null;
        }
    }

    private boolean b() {
        try {
            this.i.lockInterruptibly();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c() {
        this.i.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.drawable.Drawable d() throws com.blued.android.core.imagecache.LoadJobImpl.SwitchJobLoadType, com.blued.android.core.imagecache.LoadDrawableException {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.imagecache.LoadJobImpl.d():android.graphics.drawable.Drawable");
    }

    @Override // com.blued.android.core.imagecache.LoadJob
    public void a() {
        Future future = this.h;
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Future future) {
        this.h = future;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th;
        if (ImageLoadEngine.b(this)) {
            ImageLoadEngine.c(this);
        } else if (b()) {
            FailReason.FailType failType = FailReason.FailType.SUCCESS;
            Drawable drawable = null;
            try {
                try {
                    Drawable d = d();
                    c();
                    th = null;
                    drawable = d;
                } catch (LoadDrawableException e) {
                    e.printStackTrace();
                    failType = e.a;
                    th = e.b;
                    c();
                } catch (SwitchJobLoadType e2) {
                    if (this.a != LoadType.NET) {
                        this.a = LoadType.NET;
                        ImageLoadEngine.a(this);
                        c();
                        return;
                    }
                    c();
                    th = null;
                }
                FailReason.FailType failType2 = failType;
                if (failType == FailReason.FailType.SUCCESS) {
                    failType2 = failType;
                    if (drawable == null) {
                        failType2 = failType;
                        if (this.e.i) {
                            failType2 = !this.e.h ? FailReason.FailType.NETWORK_DENIED : FailReason.FailType.UNKNOWN;
                        }
                    }
                }
                if (drawable != null && (drawable instanceof IRecyclingDrawable)) {
                    RecyclingImageLoader.a(this.c, (IRecyclingDrawable) drawable);
                }
                if (ImageLoadEngine.b(this)) {
                    ImageLoadEngine.c(this);
                } else if (failType2 != FailReason.FailType.SUCCESS) {
                    ImageLoadEngine.a(this, failType2, th);
                } else {
                    ImageLoadEngine.a(this, drawable);
                }
            } catch (Throwable th2) {
                c();
                throw th2;
            }
        }
    }
}
