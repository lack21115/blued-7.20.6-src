package com.anythink.expressad.mbbanner.a.c;

import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.videocommon.b.i;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/c/f.class */
public class f implements i.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5177a = f.class.getSimpleName();
    private com.anythink.expressad.mbbanner.a.d.b b;

    /* renamed from: c  reason: collision with root package name */
    private String f5178c;

    public f(com.anythink.expressad.mbbanner.a.d.b bVar, String str) {
        this.b = bVar;
        this.f5178c = str;
    }

    @Override // com.anythink.expressad.videocommon.b.i.a
    public final void a(String str) {
        o.b(f5177a, "DownloadBannerUrlListener HTML SUCCESS:".concat(String.valueOf(str)));
        com.anythink.expressad.mbbanner.a.d.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.f5178c, 3, str, true);
        }
    }

    @Override // com.anythink.expressad.videocommon.b.i.a
    public final void a(String str, String str2) {
        o.b(f5177a, "DownloadBannerUrlListener HTML FAIL:".concat(String.valueOf(str)));
        com.anythink.expressad.mbbanner.a.d.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.f5178c, 3, str, false);
        }
    }
}
