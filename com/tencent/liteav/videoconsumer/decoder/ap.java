package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ap.class */
public final /* synthetic */ class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36761a;
    private final Object b;

    private ap(VideoDecodeController videoDecodeController, Object obj) {
        this.f36761a = videoDecodeController;
        this.b = obj;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, Object obj) {
        return new ap(videoDecodeController, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f36761a;
        Object obj = this.b;
        if (CommonUtil.equals(videoDecodeController.h, obj)) {
            return;
        }
        String str = videoDecodeController.f36734a;
        LiteavLog.i(str, "setSharedEGLContext(object:" + obj + ", mEGLCore: " + videoDecodeController.i + ")");
        videoDecodeController.h = obj;
        if (videoDecodeController.i != null) {
            videoDecodeController.c();
            videoDecodeController.b();
            videoDecodeController.f36735c.u = true;
        }
    }
}
