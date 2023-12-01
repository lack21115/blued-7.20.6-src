package com.anythink.expressad.video.bt.module.b;

import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/b/d.class */
public final class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5500a = "H5ShowRewardListener";
    private com.anythink.expressad.video.bt.module.a.b b;

    /* renamed from: c  reason: collision with root package name */
    private String f5501c;

    public d(com.anythink.expressad.video.bt.module.a.b bVar, String str) {
        this.b = bVar;
        this.f5501c = str;
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a() {
        if (this.b != null) {
            o.a(f5500a, "onAdShow");
            this.b.a(this.f5501c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (this.b != null) {
            o.a(f5500a, "onVideoAdClicked");
            this.b.a(this.f5501c, cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(String str) {
        if (this.b != null) {
            o.a(f5500a, "onShowFail");
            this.b.a(this.f5501c, str);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
        if (this.b != null) {
            o.a(f5500a, "onAdClose");
            this.b.a(this.f5501c, z, cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void b() {
        if (this.b != null) {
            o.a(f5500a, "onVideoComplete");
            this.b.b(this.f5501c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void c() {
        if (this.b != null) {
            o.a(f5500a, "onEndcardShow");
            this.b.c(this.f5501c);
        }
    }
}
