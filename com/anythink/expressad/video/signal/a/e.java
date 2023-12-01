package com.anythink.expressad.video.signal.a;

import com.anythink.expressad.video.module.AnythinkVideoView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/e.class */
public class e implements com.anythink.expressad.video.signal.g {
    protected static final String m = "DefaultJSNotifyProxy";

    @Override // com.anythink.expressad.video.signal.g
    public void a() {
        com.anythink.expressad.foundation.h.o.a(m, "onSignalCommunication");
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(int i) {
        com.anythink.expressad.foundation.h.o.a(m, "onVideoStatusNotify:".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(int i, int i2, int i3, int i4) {
        com.anythink.expressad.foundation.h.o.a(m, "showDataInfo");
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(int i, String str) {
        com.anythink.expressad.foundation.h.o.a(m, "onClick:" + i + ",pt:" + str);
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(AnythinkVideoView.a aVar) {
        com.anythink.expressad.foundation.h.o.a(m, "onProgressNotify:" + aVar.toString());
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(Object obj) {
        com.anythink.expressad.foundation.h.o.a(m, "onWebviewShow:".concat(String.valueOf(obj)));
    }
}
