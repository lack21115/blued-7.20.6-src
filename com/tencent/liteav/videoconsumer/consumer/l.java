package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/l.class */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23024a;
    private final Rotation b;

    private l(j jVar, Rotation rotation) {
        this.f23024a = jVar;
        this.b = rotation;
    }

    public static Runnable a(j jVar, Rotation rotation) {
        return new l(jVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23024a;
        Rotation rotation = this.b;
        LiteavLog.i(jVar.f23014a, "setRenderRotation: ".concat(String.valueOf(rotation)));
        jVar.k = rotation;
        for (VideoRenderInterface videoRenderInterface : jVar.a()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setRenderRotation(jVar.k);
            }
        }
    }
}
