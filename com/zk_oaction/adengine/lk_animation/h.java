package com.zk_oaction.adengine.lk_animation;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/h.class */
public class h extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f28212a;

    public h(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f28212a = cVar;
        b();
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f28212a.u;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void a(long j) {
        com.zk_oaction.adengine.lk_variable.g gVar = this.f28212a.n;
        gVar.a("time", "" + (System.currentTimeMillis() % 3600000));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public boolean a(XmlPullParser xmlPullParser) {
        return false;
    }
}
