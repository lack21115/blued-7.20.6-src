package com.anythink.expressad.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/j.class */
public final class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f8509a;

    public j(ImageView imageView, int i) {
        super(imageView);
        this.f8509a = i;
    }

    @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        Bitmap a2;
        if (bitmap == null) {
            return;
        }
        try {
            if (this.f8507c == null || this.f8507c.get() == null || bitmap.isRecycled() || (a2 = com.anythink.expressad.foundation.h.n.a(bitmap, this.f8509a)) == null) {
                return;
            }
            this.f8507c.get().setImageBitmap(a2);
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
            }
        }
    }
}
