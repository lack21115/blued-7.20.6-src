package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.j;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/x.class */
public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36730a;
    private final boolean b;

    private x(j jVar, boolean z) {
        this.f36730a = jVar;
        this.b = z;
    }

    public static Runnable a(j jVar, boolean z) {
        return new x(jVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36730a;
        boolean z = this.b;
        LiteavLog.i(jVar.f36705a, "Stop");
        if (jVar.p != j.a.STOPPED) {
            jVar.p = j.a.STOPPED;
            jVar.n = false;
            jVar.o.b();
            jVar.v.getAndSet(0L);
            if (jVar.f != null) {
                jVar.f.g();
            }
            for (VideoRenderInterface videoRenderInterface : jVar.a()) {
                if (videoRenderInterface != null) {
                    videoRenderInterface.stop(z);
                }
            }
            jVar.x.b();
            com.tencent.liteav.videoconsumer.renderer.f fVar = jVar.w;
            fVar.f = false;
            fVar.b.b();
            jVar.u = null;
            jVar.r = 0;
            jVar.s = 0;
        }
    }
}
