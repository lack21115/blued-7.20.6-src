package com.blued.android.core.image;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoader.class */
public class ImageLoader {
    private static boolean a = false;

    /* renamed from: com.blued.android.core.image.ImageLoader$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoader$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ OnClearDiskCacheListener a;

        @Override // java.lang.Runnable
        public void run() {
            if (AppInfo.d() != null) {
                GlideApp.a(AppInfo.d()).f();
            }
            if (this.a != null) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.image.ImageLoader.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.a != null) {
                            AnonymousClass1.this.a.a();
                        }
                    }
                });
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoader$OnAnimationStateListener.class */
    public interface OnAnimationStateListener {
        void a();

        void b();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoader$OnClearDiskCacheListener.class */
    public interface OnClearDiskCacheListener {
        void a();
    }

    private ImageLoader() {
    }

    public static ImageWrapper a(IRequestHost iRequestHost, int i) {
        return new ImageWrapper(iRequestHost, a(iRequestHost).e().b(Integer.valueOf(i)).b(DiskCacheStrategy.d));
    }

    public static ImageWrapper a(IRequestHost iRequestHost, File file) {
        File file2 = file;
        if (file == null) {
            file2 = new File("");
        }
        return new ImageWrapper(iRequestHost, a(iRequestHost).e().b(file2).b(DiskCacheStrategy.a));
    }

    public static ImageWrapper a(IRequestHost iRequestHost, String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return new ImageWrapper(iRequestHost, a(iRequestHost).e().b(str2).b(DiskCacheStrategy.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bumptech.glide.RequestManager a(com.blued.android.core.net.IRequestHost r2) {
        /*
            r0 = r2
            if (r0 == 0) goto L43
            r0 = r2
            java.lang.Object r0 = com.blued.android.core.image.ImageLoaderHostManager.a(r0)
            r2 = r0
            r0 = r2
            if (r0 == 0) goto L43
            r0 = r2
            boolean r0 = r0 instanceof androidx.fragment.app.Fragment
            if (r0 == 0) goto L1f
            r0 = r2
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            com.blued.android.core.image.GlideRequests r0 = com.blued.android.core.image.GlideApp.a(r0)
            r2 = r0
            goto L45
        L1f:
            r0 = r2
            boolean r0 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L31
            r0 = r2
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            com.blued.android.core.image.GlideRequests r0 = com.blued.android.core.image.GlideApp.a(r0)
            r2 = r0
            goto L45
        L31:
            r0 = r2
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L43
            r0 = r2
            android.app.Activity r0 = (android.app.Activity) r0
            com.blued.android.core.image.GlideRequests r0 = com.blued.android.core.image.GlideApp.a(r0)
            r2 = r0
            goto L45
        L43:
            r0 = 0
            r2 = r0
        L45:
            r0 = r2
            r3 = r0
            r0 = r2
            if (r0 != 0) goto L52
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            com.blued.android.core.image.GlideRequests r0 = com.blued.android.core.image.GlideApp.b(r0)
            r3 = r0
        L52:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.image.ImageLoader.a(com.blued.android.core.net.IRequestHost):com.bumptech.glide.RequestManager");
    }

    private static String a(String str, String str2) {
        String str3 = str;
        if (str.startsWith(str2)) {
            str3 = str.substring(str2.length());
        }
        return str3;
    }

    public static void a(int i) {
        if (AppInfo.d() != null) {
            GlideApp.a(AppInfo.d()).a(i);
        }
    }

    public static void a(IRequestHost iRequestHost, ImageView imageView) {
        if (imageView != null) {
            a(iRequestHost).a(imageView);
        }
    }

    public static void a(IRequestHost iRequestHost, Target<Drawable> target) {
        if (target != null) {
            a(iRequestHost).a(target);
        }
    }

    public static boolean a() {
        return a;
    }

    public static ImageWrapper b(IRequestHost iRequestHost, String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
            if (!str.startsWith("content://")) {
                str2 = "content://" + str;
            }
        }
        return new ImageWrapper(iRequestHost, a(iRequestHost).e().b(Uri.parse(str2)).b(DiskCacheStrategy.a));
    }

    public static void b() {
        if (AppInfo.d() != null) {
            GlideApp.a(AppInfo.d()).e();
        }
    }

    public static ImageWrapper c(IRequestHost iRequestHost, String str) {
        String a2 = str == null ? "" : a(str, "assets://");
        RequestBuilder e = a(iRequestHost).e();
        return new ImageWrapper(iRequestHost, e.b(Uri.parse("file:///android_asset/" + a2)).b(DiskCacheStrategy.d));
    }

    public static ImageWrapper d(IRequestHost iRequestHost, String str) {
        return a(iRequestHost, new File(str == null ? "" : a(str, "file://")));
    }
}
