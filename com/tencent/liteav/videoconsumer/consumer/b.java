package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36696a;
    private final GLConstants.PixelFormatType b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.PixelBufferType f36697c;

    private b(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        this.f36696a = aVar;
        this.b = pixelFormatType;
        this.f36697c = pixelBufferType;
    }

    public static Runnable a(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        return new b(aVar, pixelFormatType, pixelBufferType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36696a, this.b, this.f36697c);
    }
}
