package com.blued.android.core.image;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.http.HttpRequestListener;
import com.blued.android.core.image.util.ExecutorUtils;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.request.FutureTarget;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageFileWrapper.class */
public class ImageFileWrapper {

    /* renamed from: a  reason: collision with root package name */
    private RequestBuilder f9495a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private FutureTarget<File> f9496c;
    private ImageFileLoader.OnLoadFileListener j;
    private String d = "";
    private boolean e = false;
    private boolean f = false;
    private String g = "";
    private String h = "";
    private Object i = null;
    private ImageSize k = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageFileWrapper(IRequestHost iRequestHost, RequestBuilder requestBuilder) {
        this.b = iRequestHost;
        this.f9495a = requestBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final Object obj) {
        if (this.j != null) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.image.ImageFileWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageFileWrapper.this.j != null) {
                        if (ImageFileWrapper.this.b == null || ImageFileWrapper.this.b.isActive()) {
                            if (z) {
                                ImageFileWrapper.this.j.onUIFinish((File) obj, null);
                            } else {
                                ImageFileWrapper.this.j.onUIFinish(null, (Exception) obj);
                            }
                        }
                    }
                }
            });
        }
    }

    private Runnable c() {
        return new Runnable() { // from class: com.blued.android.core.image.ImageFileWrapper.2
            /* JADX WARN: Removed duplicated region for block: B:63:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 502
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.image.ImageFileWrapper.AnonymousClass2.run():void");
            }
        };
    }

    private void d(String str) {
        this.d = str;
        this.e = true;
    }

    public ImageFileWrapper a(ImageFileLoader.OnLoadFileListener onLoadFileListener) {
        this.j = onLoadFileListener;
        return this;
    }

    public ImageFileWrapper a(ImageLoadResult imageLoadResult) {
        if (imageLoadResult != null) {
            this.f9495a.d(new HttpRequestListener(imageLoadResult));
        }
        return this;
    }

    public ImageFileWrapper a(ImageSize imageSize) {
        this.k = imageSize;
        return this;
    }

    public ImageFileWrapper a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.f = true;
        d(str2);
        this.f9495a.b(str2);
        return this;
    }

    public ImageFileWrapper a(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        this.g = str3;
        this.f9495a.b(str4);
        this.f9495a.b((Option<Option<String>>) ImageLoaderOptions.f9505a, (Option<String>) str3);
        return this;
    }

    public void a() {
        LinkedHashSet<ImageFileWrapper> linkedHashSet;
        boolean z = false;
        if (this.e) {
            if (TextUtils.isEmpty(this.d)) {
                a(false, (Object) new Exception("load url is empty!"));
                return;
            }
        } else if (TextUtils.isEmpty(this.g)) {
            a(false, (Object) new Exception("Local source image path is empty!"));
            return;
        } else if (!new File(this.g).exists()) {
            a(false, (Object) new Exception("Can't find local image at " + this.g));
            return;
        }
        int b = b();
        HashMap<Integer, LinkedHashSet<ImageFileWrapper>> a2 = ImageFileLoader.a(this.f);
        synchronized (a2) {
            LinkedHashSet<ImageFileWrapper> linkedHashSet2 = a2.get(Integer.valueOf(b));
            linkedHashSet = linkedHashSet2;
            if (linkedHashSet2 == null) {
                linkedHashSet = new LinkedHashSet<>();
                a2.put(Integer.valueOf(b), linkedHashSet);
                z = true;
            }
        }
        linkedHashSet.add(this);
        if (z) {
            this.f9496c = this.f9495a.g();
            if (this.f) {
                ExecutorUtils.a(b, c());
            } else {
                ExecutorUtils.b(b, c());
            }
        }
    }

    protected int b() {
        return ImageFileLoader.a(this.i, this.e ? this.d : this.g);
    }

    public ImageFileWrapper b(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        d(str2);
        this.f9495a.b(str2);
        this.f9495a.e(true);
        return this;
    }

    public ImageFileWrapper c(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.g = str2;
        this.f9495a.b(str2);
        return this;
    }
}
