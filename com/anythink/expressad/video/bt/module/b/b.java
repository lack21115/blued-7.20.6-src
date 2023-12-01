package com.anythink.expressad.video.bt.module.b;

import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/b/b.class */
public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5498a = "RewardVideoListener";

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void a() {
        o.a(f5498a, "onLoadSuccess:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void a(String str) {
        o.a(f5498a, "onVideoLoadFail:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void a(boolean z, String str, float f) {
        o.a(f5498a, "onAdClose:" + z + ",RewardName:" + str + ",rewardAmout:" + f);
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void b() {
        o.a(f5498a, "onVideoLoadSuccess:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void b(String str) {
        o.a(f5498a, "onShowFail:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void c() {
        o.a(f5498a, "onAdShow");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void d() {
        o.a(f5498a, "onVideoAdClicked:");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void e() {
        o.a(f5498a, "onEndcardShow: ");
    }

    @Override // com.anythink.expressad.video.bt.module.b.g
    public final void f() {
        o.a(f5498a, "onVideoComplete: ");
    }
}
