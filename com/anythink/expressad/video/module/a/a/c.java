package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.signal.factory.IJSFactory;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/c.class */
public final class c extends d {
    private IJSFactory ag;

    public c(IJSFactory iJSFactory, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i, z);
        this.ag = iJSFactory;
        if (iJSFactory == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.d, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, Object obj) {
        int i2 = i;
        if (this.W) {
            if (i != 8) {
                if (i == 105) {
                    this.ag.getJSNotifyProxy().a(3, obj.toString());
                    i2 = -1;
                } else if (i == 107) {
                    this.ag.getJSContainerModule().showVideoClickView(-1);
                    this.ag.getJSVideoModule().setCover(false);
                    this.ag.getJSVideoModule().videoOperate(1);
                    i2 = i;
                } else if (i == 112) {
                    this.ag.getJSVideoModule().setCover(true);
                    this.ag.getJSVideoModule().videoOperate(2);
                    i2 = i;
                } else if (i != 115) {
                    i2 = i;
                } else {
                    com.anythink.expressad.video.signal.j jSVideoModule = this.ag.getJSVideoModule();
                    this.ag.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                    i2 = i;
                }
            } else if (this.ag.getJSContainerModule().showAlertWebView()) {
                this.ag.getJSVideoModule().alertWebViewShowed();
                i2 = i;
            } else {
                this.ag.getJSVideoModule().showAlertView();
                i2 = i;
            }
        }
        super.a(i2, obj);
    }
}
