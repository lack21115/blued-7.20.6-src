package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ah.class */
final /* synthetic */ class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23426a;
    private final GLConstants.PixelFormatType b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.PixelBufferType f23427c;
    private final CustomVideoProcessListener d;

    private ah(f fVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        this.f23426a = fVar;
        this.b = pixelFormatType;
        this.f23427c = pixelBufferType;
        this.d = customVideoProcessListener;
    }

    public static Runnable a(f fVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        return new ah(fVar, pixelFormatType, pixelBufferType, customVideoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23426a, this.b, this.f23427c, this.d);
    }
}
