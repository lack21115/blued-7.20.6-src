package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/af.class */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37113a;
    private final GLConstants.PixelFormatType b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.PixelBufferType f37114c;
    private final VideoRenderListener d;

    private af(f fVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        this.f37113a = fVar;
        this.b = pixelFormatType;
        this.f37114c = pixelBufferType;
        this.d = videoRenderListener;
    }

    public static Runnable a(f fVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        return new af(fVar, pixelFormatType, pixelBufferType, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37113a, this.b, this.f37114c, this.d);
    }
}
