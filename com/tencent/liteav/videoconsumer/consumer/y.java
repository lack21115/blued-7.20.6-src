package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.j;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/y.class */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36731a;

    private y(j jVar) {
        this.f36731a = jVar;
    }

    public static Runnable a(j jVar) {
        return new y(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36731a;
        String str = jVar.f36705a;
        LiteavLog.i(str, "pause , current status is " + jVar.p);
        if (jVar.p == j.a.STARTED) {
            jVar.w.a();
            jVar.p = j.a.PAUSED;
        }
        jVar.q = true;
    }
}
