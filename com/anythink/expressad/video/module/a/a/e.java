package com.anythink.expressad.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/e.class */
public class e implements com.anythink.expressad.foundation.g.d.c {
    protected static final String b = "ImageLoaderListener";

    /* renamed from: a  reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f5666a;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<ImageView> f5667c;
    private String d;

    public e(ImageView imageView) {
        this.f5667c = new WeakReference<>(imageView);
    }

    public e(ImageView imageView, com.anythink.expressad.foundation.d.c cVar, String str) {
        this.f5667c = new WeakReference<>(imageView);
        this.f5666a = cVar;
        this.d = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                com.anythink.expressad.foundation.h.o.d(b, "bitmap=null");
            } else if (this.f5667c == null || this.f5667c.get() == null || bitmap.isRecycled()) {
            } else {
                this.f5667c.get().setImageBitmap(bitmap);
                this.f5667c.get().setVisibility(0);
            }
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f4103a) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(String str, String str2) {
    }
}
