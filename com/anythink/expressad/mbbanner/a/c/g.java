package com.anythink.expressad.mbbanner.a.c;

import android.graphics.Bitmap;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/c/g.class */
public class g implements com.anythink.expressad.foundation.g.d.c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5179a = g.class.getSimpleName();
    private com.anythink.expressad.mbbanner.a.d.b b;

    /* renamed from: c  reason: collision with root package name */
    private String f5180c;

    public g(com.anythink.expressad.mbbanner.a.d.b bVar, String str) {
        this.b = bVar;
        this.f5180c = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        o.b(f5179a, "DownloadImageListener campaign image success");
        this.b.a(this.f5180c, 1, str, true);
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(String str, String str2) {
        o.b(f5179a, "DownloadImageListener campaign image fail");
        this.b.a(this.f5180c, 1, str2, false);
    }
}
