package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/m.class */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36716a;
    private final GLConstants.GLScaleType b;

    private m(j jVar, GLConstants.GLScaleType gLScaleType) {
        this.f36716a = jVar;
        this.b = gLScaleType;
    }

    public static Runnable a(j jVar, GLConstants.GLScaleType gLScaleType) {
        return new m(jVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36716a;
        GLConstants.GLScaleType gLScaleType = this.b;
        LiteavLog.i(jVar.f36705a, "setScaleType: ".concat(String.valueOf(gLScaleType)));
        jVar.j = gLScaleType;
        for (VideoRenderInterface videoRenderInterface : jVar.a()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setScaleType(gLScaleType);
            }
        }
    }
}
