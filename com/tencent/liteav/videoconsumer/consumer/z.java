package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.j;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/z.class */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36732a;

    private z(j jVar) {
        this.f36732a = jVar;
    }

    public static Runnable a(j jVar) {
        return new z(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36732a;
        String str = jVar.f36705a;
        LiteavLog.i(str, "resume , current status is " + jVar.p);
        if (jVar.p == j.a.PAUSED) {
            jVar.p = j.a.STARTED;
        }
        jVar.q = false;
    }
}
