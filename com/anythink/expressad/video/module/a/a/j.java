package com.anythink.expressad.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/j.class */
public final class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f5669a;

    public j(ImageView imageView, int i) {
        super(imageView);
        this.f5669a = i;
    }

    @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        Bitmap a2;
        if (bitmap == null) {
            return;
        }
        try {
            if (this.f5667c == null || this.f5667c.get() == null || bitmap.isRecycled() || (a2 = com.anythink.expressad.foundation.h.n.a(bitmap, this.f5669a)) == null) {
                return;
            }
            this.f5667c.get().setImageBitmap(a2);
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f4103a) {
                th.printStackTrace();
            }
        }
    }
}
