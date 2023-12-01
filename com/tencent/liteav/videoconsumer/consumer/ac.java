package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23002a;
    private final boolean b;

    private ac(j jVar, boolean z) {
        this.f23002a = jVar;
        this.b = z;
    }

    public static Runnable a(j jVar, boolean z) {
        return new ac(jVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23002a;
        boolean z = this.b;
        LiteavLog.i(jVar.f23014a, "setRenderMirrorEnabled: ".concat(String.valueOf(z)));
        jVar.l = z;
        for (VideoRenderInterface videoRenderInterface : jVar.a()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setHorizontalMirror(jVar.l);
            }
        }
    }
}
