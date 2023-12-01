package com.anythink.expressad.video.bt.module.b;

import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/b/c.class */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8339a = "ShowRewardListener";

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a() {
        o.a(f8339a, "onAdShow");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(com.anythink.expressad.foundation.d.c cVar) {
        o.a(f8339a, "onVideoAdClicked:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(String str) {
        o.a(f8339a, "onShowFail:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(boolean z, int i) {
        o.a(f8339a, "onAdCloseWithIVReward: " + z + "  " + i);
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
        o.a(f8339a, "onAdClose:isCompleteView:" + z + ",reward:" + cVar);
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void b() {
        o.a(f8339a, "onVideoComplete: ");
    }

    @Override // com.anythink.expressad.video.bt.module.b.h
    public void c() {
        o.a(f8339a, "onEndcardShow: ");
    }
}
