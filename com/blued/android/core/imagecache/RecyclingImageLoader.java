package com.blued.android.core.imagecache;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.glide.LruBitmapPool;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import com.blued.android.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingImageLoader.class */
public class RecyclingImageLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final ImageLoadingListener f9596a = new BaseImageLoadingListener();
    public LruBitmapPool b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, IRecyclingDrawable> f9597c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingImageLoader$SingletonCreator.class */
    public static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        private static final RecyclingImageLoader f9600a = new RecyclingImageLoader();

        private SingletonCreator() {
        }
    }

    private RecyclingImageLoader() {
        e();
    }

    public static Drawable a(String str) {
        IRecyclingDrawable iRecyclingDrawable;
        if (TextUtils.isEmpty(str) || (iRecyclingDrawable = a().f9597c.get(str)) == null || !iRecyclingDrawable.c()) {
            return null;
        }
        return (Drawable) iRecyclingDrawable;
    }

    public static LoadJob a(RecyclingImageView recyclingImageView, String str, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        if (ImageLoaderUtils.f9582a) {
            Log.a("IMAGE_LOADER", "RecyclingImageLoader.loadImage(), uri:" + str);
        }
        LoadOptions loadOptions2 = loadOptions;
        if (loadOptions == null) {
            loadOptions2 = LoadOptions.c();
        }
        ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
        if (imageLoadingListener == null) {
            imageLoadingListener2 = f9596a;
        }
        if (loadOptions2.i && !AppMethods.b()) {
            if (AppInfo.m()) {
                throw new RuntimeException("loadImage() must be called in UI thread");
            }
            return null;
        }
        imageLoadingListener2.a(str, recyclingImageView, loadOptions2);
        if (TextUtils.isEmpty(str)) {
            ImageLoadEngine.a(recyclingImageView);
            imageLoadingListener2.a(str, recyclingImageView, loadOptions2, new FailReason(FailReason.FailType.EMPTY_URL, null));
            return null;
        }
        ImageLoadEngine.a(recyclingImageView, "");
        if (recyclingImageView != null && !a(recyclingImageView, str)) {
            if (ImageLoaderUtils.f9582a) {
                Log.a("IMAGE_LOADER", "not need reload, uri:" + str);
            }
            imageLoadingListener2.a(str, recyclingImageView, loadOptions2, recyclingImageView.getDrawable(), true);
            return null;
        }
        String a2 = RecyclingUtils.a(str, loadOptions2);
        Drawable a3 = a(a2);
        if (a3 != null) {
            imageLoadingListener2.a(str, recyclingImageView, loadOptions2, a3, true);
            return null;
        }
        RecyclingUtils.Scheme a4 = RecyclingUtils.Scheme.a(str);
        if (loadOptions2.g && RecyclingUtils.Scheme.DRAWABLE == a4) {
            a(recyclingImageView, RecyclingUtils.a(RecyclingUtils.Scheme.DRAWABLE.c(str)), loadOptions2);
            imageLoadingListener2.a(str, recyclingImageView, loadOptions2, recyclingImageView.getDrawable(), true);
            return null;
        }
        if (recyclingImageView != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(loadOptions2.f9593c)) {
                Drawable a5 = a(RecyclingUtils.a(loadOptions2.f9593c, loadOptions2));
                z = false;
                if (a5 != null) {
                    recyclingImageView.setImageDrawable(a5);
                    z = true;
                }
            }
            if (!z && loadOptions2.b > 0) {
                if (loadOptions2.e) {
                    recyclingImageView.setImageResourceInner(loadOptions2.b);
                } else {
                    recyclingImageView.setImageResource(loadOptions2.b);
                }
            }
        }
        ImageLoadEngine.a(recyclingImageView, a2);
        LoadJobImpl loadJobImpl = new LoadJobImpl(recyclingImageView, str, loadOptions2, imageLoadingListener2, a2);
        if (loadOptions2.g) {
            loadJobImpl.run();
            return null;
        }
        return ImageLoadEngine.a(loadJobImpl);
    }

    public static RecyclingImageLoader a() {
        return SingletonCreator.f9600a;
    }

    public static void a(int i) {
        if (i >= 40) {
            a().f9597c.trimToSize(0);
        } else if (i >= 20) {
            a().f9597c.trimToSize(a().f9597c.maxSize() / 2);
        }
        synchronized (a().b) {
            a().b.a(i);
        }
    }

    public static void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable() || !RecyclingUtils.b()) {
            return;
        }
        synchronized (a().b) {
            a().b.a(bitmap);
        }
    }

    public static void a(RecyclingImageView recyclingImageView, int i, LoadOptions loadOptions) {
        if (ImageLoaderUtils.f9582a) {
            Log.a("IMAGE_LOADER", "RecyclingImageLoader.loadLocalResSync(), resId:" + i);
        }
        if (i <= 0) {
            return;
        }
        if (!AppMethods.b()) {
            if (AppInfo.m()) {
                throw new RuntimeException("loadLocalResSync() must be called in UI thread");
            }
            return;
        }
        if (loadOptions != null) {
            try {
                if (loadOptions.e) {
                    recyclingImageView.setImageResourceInner(i);
                    return;
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        String b = RecyclingUtils.Scheme.DRAWABLE.b(RecyclingUtils.a(i));
        if (a(recyclingImageView, b)) {
            LoadOptions loadOptions2 = loadOptions;
            if (loadOptions == null) {
                loadOptions2 = LoadOptions.c();
            }
            String a2 = RecyclingUtils.a(b, loadOptions2);
            Drawable a3 = a(a2);
            Drawable drawable = a3;
            if (a3 == null) {
                Drawable a4 = RecyclingUtils.a(recyclingImageView.getContext(), b, loadOptions2);
                drawable = a4;
                if (a4 instanceof IRecyclingDrawable) {
                    a(a2, (IRecyclingDrawable) a4);
                    drawable = a4;
                }
            }
            if (drawable != null) {
                recyclingImageView.setImageDrawable(drawable);
            } else if (loadOptions2.d > 0) {
                recyclingImageView.setImageResource(loadOptions2.d);
            } else if (loadOptions2.d == 0) {
                recyclingImageView.setImageBitmap(null);
            }
        }
    }

    public static void a(final String str, final IRecyclingDrawable iRecyclingDrawable) {
        if (a().f9597c == null || iRecyclingDrawable == null || !iRecyclingDrawable.a()) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.imagecache.RecyclingImageLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    IRecyclingDrawable.this.b(true);
                    RecyclingImageLoader.a().f9597c.put(str, IRecyclingDrawable.this);
                }
            });
            return;
        }
        iRecyclingDrawable.b(true);
        a().f9597c.put(str, iRecyclingDrawable);
    }

    public static boolean a(RecyclingImageView recyclingImageView, String str) {
        Drawable drawable = recyclingImageView.getDrawable();
        if (drawable == null || !(drawable instanceof IRecyclingDrawable)) {
            return true;
        }
        IRecyclingDrawable iRecyclingDrawable = (IRecyclingDrawable) drawable;
        return (iRecyclingDrawable.c() && str.equals(iRecyclingDrawable.b())) ? false : true;
    }

    public static void b() {
        ImageLoadEngine.a();
    }

    public static void c() {
        ImageLoadEngine.b();
    }

    public static void d() {
        a().f9597c.evictAll();
        synchronized (a().b) {
            a().b.a();
        }
    }

    private void e() {
        float f = AppInfo.s / 2.0f;
        int a2 = RecyclingUtils.a(f);
        int a3 = RecyclingUtils.a(f);
        if (this.b == null) {
            this.b = new LruBitmapPool(a3);
        }
        this.f9597c = new LruCache<String, IRecyclingDrawable>(a2) { // from class: com.blued.android.core.imagecache.RecyclingImageLoader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            public int a(String str, IRecyclingDrawable iRecyclingDrawable) {
                int e = iRecyclingDrawable.e();
                int i = e;
                if (e == 0) {
                    i = 1;
                }
                return i;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            public void a(boolean z, String str, IRecyclingDrawable iRecyclingDrawable, IRecyclingDrawable iRecyclingDrawable2) {
                iRecyclingDrawable.b(false);
            }
        };
    }
}
