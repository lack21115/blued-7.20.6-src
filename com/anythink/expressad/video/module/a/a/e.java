package com.anythink.expressad.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/e.class */
public class e implements com.anythink.expressad.foundation.g.d.c {
    protected static final String b = "ImageLoaderListener";

    /* renamed from: a  reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f8506a;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<ImageView> f8507c;
    private String d;

    public e(ImageView imageView) {
        this.f8507c = new WeakReference<>(imageView);
    }

    public e(ImageView imageView, com.anythink.expressad.foundation.d.c cVar, String str) {
        this.f8507c = new WeakReference<>(imageView);
        this.f8506a = cVar;
        this.d = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                com.anythink.expressad.foundation.h.o.d(b, "bitmap=null");
            } else if (this.f8507c == null || this.f8507c.get() == null || bitmap.isRecycled()) {
            } else {
                this.f8507c.get().setImageBitmap(bitmap);
                this.f8507c.get().setVisibility(0);
            }
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(String str, String str2) {
    }
}
