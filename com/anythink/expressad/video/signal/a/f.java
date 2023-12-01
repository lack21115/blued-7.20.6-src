package com.anythink.expressad.video.signal.a;

import android.content.res.Configuration;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/f.class */
public class f implements com.anythink.expressad.video.signal.i {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f5677a = "js";

    @Override // com.anythink.expressad.video.signal.i
    public String a() {
        com.anythink.expressad.foundation.h.o.a("js", "getEndScreenInfo");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.i
    public void a(String str) {
        com.anythink.expressad.foundation.h.o.a("js", "triggerCloseBtn,state=".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.i
    public void b(String str) {
        com.anythink.expressad.foundation.h.o.a("js", "setOrientation,landscape=".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.i, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        com.anythink.expressad.foundation.h.o.a("js", "handlerPlayableException，msg=".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.h.o.a("js", "install:campaignEx=".concat(String.valueOf(cVar)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i) {
        com.anythink.expressad.foundation.h.o.a("js", "notifyCloseBtn,state=".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        com.anythink.expressad.foundation.h.o.a("js", "orientation，config=".concat(String.valueOf(configuration)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void readyStatus(int i) {
        com.anythink.expressad.foundation.h.o.a("js", "readyStatus,isReady=".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i) {
        com.anythink.expressad.foundation.h.o.a("js", "toggleCloseBtn,state=".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
        com.anythink.expressad.foundation.h.o.a("js", "webviewshow");
    }
}
