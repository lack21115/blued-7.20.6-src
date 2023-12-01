package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.LoadJobImpl;
import com.blued.android.core.pool.ExecutorFactory;
import com.blued.android.core.utils.AsyncViewChecker;
import com.blued.android.core.utils.Log;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/ImageLoadEngine.class */
public class ImageLoadEngine {

    /* renamed from: a  reason: collision with root package name */
    protected static final AsyncViewChecker<String> f9576a = new AsyncViewChecker<>();
    protected static final Map<String, ReentrantLock> b = new WeakHashMap();

    /* renamed from: c  reason: collision with root package name */
    protected static final AtomicBoolean f9577c = new AtomicBoolean(false);
    private static final ThreadPoolExecutor d = ExecutorFactory.a().b();
    private static final ThreadPoolExecutor e = ExecutorFactory.a().c();
    private static final ExecutorService f = ExecutorFactory.a().d();

    public static LoadJob a(LoadJobImpl loadJobImpl) {
        loadJobImpl.a(loadJobImpl.f9586a == LoadJobImpl.LoadType.DATA ? d.submit(loadJobImpl) : loadJobImpl.b == null ? f.submit(loadJobImpl) : e.submit(loadJobImpl));
        return loadJobImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ReentrantLock a(String str) {
        ReentrantLock reentrantLock = b.get(str);
        ReentrantLock reentrantLock2 = reentrantLock;
        if (reentrantLock == null) {
            reentrantLock2 = new ReentrantLock();
            b.put(str, reentrantLock2);
        }
        return reentrantLock2;
    }

    public static void a() {
        f9577c.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView) {
        if (imageView != null) {
            f9576a.a(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, String str) {
        if (imageView != null) {
            f9576a.a(imageView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(final LoadJobImpl loadJobImpl, final Drawable drawable) {
        if (ImageLoaderUtils.f9582a) {
            Log.a("IMAGE_LOADER", "image load success, uri:" + loadJobImpl.d);
        }
        if (Thread.interrupted()) {
            return;
        }
        a(loadJobImpl, new Runnable() { // from class: com.blued.android.core.imagecache.ImageLoadEngine.3
            @Override // java.lang.Runnable
            public void run() {
                if (ImageLoadEngine.e(LoadJobImpl.this)) {
                    return;
                }
                ImageLoadEngine.a(LoadJobImpl.this.b);
                LoadJobImpl.this.f.a(LoadJobImpl.this.d, LoadJobImpl.this.b, LoadJobImpl.this.e, drawable, LoadJobImpl.this.e.g);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(final LoadJobImpl loadJobImpl, final FailReason.FailType failType, final Throwable th) {
        if (ImageLoaderUtils.f9582a) {
            Log.a("IMAGE_LOADER", "image load failed, uri:" + loadJobImpl.d + ", failType:" + failType + ", failCause:" + th);
        }
        if (Thread.interrupted()) {
            return;
        }
        a(loadJobImpl, new Runnable() { // from class: com.blued.android.core.imagecache.ImageLoadEngine.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageLoadEngine.e(LoadJobImpl.this)) {
                    return;
                }
                ImageLoadEngine.a(LoadJobImpl.this.b);
                LoadJobImpl.this.f.a(LoadJobImpl.this.d, LoadJobImpl.this.b, LoadJobImpl.this.e, new FailReason(failType, th));
            }
        });
    }

    private static void a(LoadJobImpl loadJobImpl, Runnable runnable) {
        if (runnable != null) {
            if (AppMethods.b() || loadJobImpl.g == null) {
                runnable.run();
            } else {
                loadJobImpl.g.post(runnable);
            }
        }
    }

    public static void b() {
        synchronized (f9577c) {
            f9577c.set(false);
            f9577c.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(LoadJobImpl loadJobImpl) {
        if (f9577c.get()) {
            synchronized (f9577c) {
                try {
                    f9577c.wait();
                } catch (InterruptedException e2) {
                    return true;
                }
            }
        }
        return e(loadJobImpl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(final LoadJobImpl loadJobImpl) {
        if (ImageLoaderUtils.f9582a) {
            Log.a("IMAGE_LOADER", "image load cancel, uri:" + loadJobImpl.d);
        }
        if (Thread.interrupted()) {
            return;
        }
        a(loadJobImpl, new Runnable() { // from class: com.blued.android.core.imagecache.ImageLoadEngine.1
            @Override // java.lang.Runnable
            public void run() {
                if (LoadJobImpl.this.f != null) {
                    LoadJobImpl.this.f.b(LoadJobImpl.this.d, LoadJobImpl.this.b, LoadJobImpl.this.e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(LoadJobImpl loadJobImpl) {
        if (loadJobImpl.b == null) {
            return false;
        }
        return !f9576a.b(loadJobImpl.b, loadJobImpl.f9587c);
    }
}
