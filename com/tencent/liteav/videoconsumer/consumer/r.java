package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/r.class */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36723a;
    private final GLConstants.PixelFormatType b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.PixelBufferType f36724c;
    private final VideoRenderListener d;

    private r(j jVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        this.f36723a = jVar;
        this.b = pixelFormatType;
        this.f36724c = pixelBufferType;
        this.d = videoRenderListener;
    }

    public static Runnable a(j jVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        return new r(jVar, pixelFormatType, pixelBufferType, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36723a;
        GLConstants.PixelFormatType pixelFormatType = this.b;
        GLConstants.PixelBufferType pixelBufferType = this.f36724c;
        VideoRenderListener videoRenderListener = this.d;
        String str = jVar.f36705a;
        LiteavLog.i(str, "setCustomRenderListener: formatType = " + pixelFormatType + " bufferType = " + pixelBufferType + " ," + videoRenderListener);
        jVar.h = videoRenderListener;
        if (jVar.h != null) {
            if (jVar.e == null) {
                jVar.e = new a(jVar.b.getLooper());
                jVar.a(jVar.e);
            }
            ((a) jVar.e).a(pixelFormatType, pixelBufferType);
        } else if (jVar.e != null) {
            jVar.e.stop(true);
            jVar.e = null;
        }
    }
}
