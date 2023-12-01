package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.j;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36729a;

    private w(j jVar) {
        this.f36729a = jVar;
    }

    public static Runnable a(j jVar) {
        return new w(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36729a;
        LiteavLog.i(jVar.f36705a, "Start");
        if (jVar.p != j.a.STOPPED) {
            LiteavLog.w(jVar.f36705a, "video consumer is started.");
            return;
        }
        jVar.a(jVar.d);
        com.tencent.liteav.videoconsumer.renderer.f fVar = jVar.w;
        fVar.f = false;
        fVar.a();
        if (jVar.f != null) {
            jVar.f.a(jVar.z);
        }
        jVar.m.a();
        jVar.p = jVar.q ? j.a.PAUSED : j.a.STARTED;
    }
}
