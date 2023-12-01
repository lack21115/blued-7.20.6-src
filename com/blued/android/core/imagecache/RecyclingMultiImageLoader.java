package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.view.RecyclingImageView;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/RecyclingMultiImageLoader.class */
public class RecyclingMultiImageLoader {

    /* renamed from: a  reason: collision with root package name */
    private RecyclingImageView f9601a;
    private String[] b;

    /* renamed from: c  reason: collision with root package name */
    private LoadOptions f9602c;
    private ImageLoadingListener d;
    private String f;
    private FailReason h;
    private int e = -1;
    private Drawable g = null;
    private Handler i = null;

    private RecyclingMultiImageLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LoadOptions loadOptions = new LoadOptions(this.f9602c);
        loadOptions.h = false;
        int i = this.e + 1;
        this.e = i;
        String[] strArr = this.b;
        if (i < strArr.length) {
            RecyclingImageLoader.a(this.f9601a, strArr[i], loadOptions, new ImageLoadingListener() { // from class: com.blued.android.core.imagecache.RecyclingMultiImageLoader.1
                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(int i2, int i3) {
                    if (RecyclingMultiImageLoader.this.d != null) {
                        RecyclingMultiImageLoader.this.d.a(i2, i3);
                    }
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions2) {
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions2, Drawable drawable, boolean z) {
                    RecyclingMultiImageLoader.this.f = str;
                    RecyclingMultiImageLoader.this.g = drawable;
                    RecyclingMultiImageLoader.this.c();
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions2, FailReason failReason) {
                    RecyclingMultiImageLoader.this.a();
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public boolean a() {
                    if (RecyclingMultiImageLoader.this.d != null) {
                        return RecyclingMultiImageLoader.this.d.a();
                    }
                    return false;
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void b(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions2) {
                    RecyclingMultiImageLoader.this.d.b(str, recyclingImageView, loadOptions2);
                }
            });
            return;
        }
        this.e = -1;
        b();
    }

    public static void a(RecyclingImageView recyclingImageView, String[] strArr, LoadOptions loadOptions, ImageLoadingListener imageLoadingListener) {
        if (strArr == null || strArr.length <= 0) {
            throw new IllegalArgumentException("参数异常");
        }
        LoadOptions loadOptions2 = loadOptions;
        if (loadOptions == null) {
            loadOptions2 = new LoadOptions();
        }
        ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
        if (imageLoadingListener == null) {
            imageLoadingListener2 = RecyclingImageLoader.f9596a;
        }
        ImageLoadEngine.a(recyclingImageView, "");
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                RecyclingMultiImageLoader recyclingMultiImageLoader = new RecyclingMultiImageLoader();
                recyclingMultiImageLoader.i = new Handler();
                recyclingMultiImageLoader.f9601a = recyclingImageView;
                recyclingMultiImageLoader.b = strArr;
                recyclingMultiImageLoader.f9602c = loadOptions2;
                recyclingMultiImageLoader.d = imageLoadingListener2;
                recyclingMultiImageLoader.a();
                return;
            }
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str)) {
                imageLoadingListener2.a(str, recyclingImageView, loadOptions2);
                Drawable a2 = RecyclingImageLoader.a(RecyclingUtils.a(str, loadOptions2));
                if (a2 != null) {
                    imageLoadingListener2.a(str, recyclingImageView, loadOptions2, a2, true);
                    return;
                }
            }
            i = i2 + 1;
        }
    }

    private void b() {
        String str;
        if (!this.f9602c.h) {
            this.h = new FailReason(FailReason.FailType.UNKNOWN, null);
            c();
            return;
        }
        String[] strArr = this.b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.h = new FailReason(FailReason.FailType.UNKNOWN, null);
                c();
                return;
            }
            str = strArr[i2];
            RecyclingUtils.Scheme a2 = RecyclingUtils.Scheme.a(str);
            if (a2 == RecyclingUtils.Scheme.HTTP || a2 == RecyclingUtils.Scheme.HTTPS) {
                break;
            }
            i = i2 + 1;
        }
        RecyclingImageLoader.a(this.f9601a, str, this.f9602c, new ImageLoadingListener() { // from class: com.blued.android.core.imagecache.RecyclingMultiImageLoader.2
            @Override // com.blued.android.core.imagecache.ImageLoadingListener
            public void a(int i3, int i4) {
                if (RecyclingMultiImageLoader.this.d != null) {
                    RecyclingMultiImageLoader.this.d.a(i3, i4);
                }
            }

            @Override // com.blued.android.core.imagecache.ImageLoadingListener
            public void a(String str2, RecyclingImageView recyclingImageView, LoadOptions loadOptions) {
            }

            @Override // com.blued.android.core.imagecache.ImageLoadingListener
            public void a(String str2, RecyclingImageView recyclingImageView, LoadOptions loadOptions, Drawable drawable, boolean z) {
                RecyclingMultiImageLoader.this.f = str2;
                RecyclingMultiImageLoader.this.g = drawable;
                RecyclingMultiImageLoader.this.c();
            }

            @Override // com.blued.android.core.imagecache.ImageLoadingListener
            public void a(String str2, RecyclingImageView recyclingImageView, LoadOptions loadOptions, FailReason failReason) {
                RecyclingMultiImageLoader.this.h = failReason;
                RecyclingMultiImageLoader.this.c();
            }

            @Override // com.blued.android.core.imagecache.ImageLoadingListener
            public boolean a() {
                if (RecyclingMultiImageLoader.this.d != null) {
                    return RecyclingMultiImageLoader.this.d.a();
                }
                return false;
            }

            @Override // com.blued.android.core.imagecache.ImageLoadingListener
            public void b(String str2, RecyclingImageView recyclingImageView, LoadOptions loadOptions) {
                RecyclingMultiImageLoader.this.d.b(str2, recyclingImageView, loadOptions);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Drawable drawable = this.g;
        if (drawable == null) {
            this.d.a(null, this.f9601a, this.f9602c, this.h);
            return;
        }
        ImageLoadingListener imageLoadingListener = this.d;
        String str = this.f;
        RecyclingImageView recyclingImageView = this.f9601a;
        LoadOptions loadOptions = this.f9602c;
        imageLoadingListener.a(str, recyclingImageView, loadOptions, drawable, loadOptions.g);
    }
}
