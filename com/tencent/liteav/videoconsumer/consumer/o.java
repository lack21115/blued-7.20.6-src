package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/o.class */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36718a;
    private final DisplayTarget b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f36719c;

    private o(j jVar, DisplayTarget displayTarget, boolean z) {
        this.f36718a = jVar;
        this.b = displayTarget;
        this.f36719c = z;
    }

    public static Runnable a(j jVar, DisplayTarget displayTarget, boolean z) {
        return new o(jVar, displayTarget, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36718a;
        DisplayTarget displayTarget = this.b;
        boolean z = this.f36719c;
        String str = jVar.f36705a;
        LiteavLog.i(str, "setDisplayTarget: " + displayTarget + ",clearLastImage=" + z);
        jVar.i = displayTarget;
        if (jVar.i != null && jVar.i.getTXCloudVideoView() != null && jVar.i.getTXCloudVideoView().getOpenGLContext() != null) {
            jVar.u = jVar.i.getTXCloudVideoView().getOpenGLContext();
            if (jVar.f != null) {
                jVar.f.a(jVar.u);
            }
        }
        for (VideoRenderInterface videoRenderInterface : jVar.a()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setDisplayView(displayTarget, z);
            }
        }
    }
}
