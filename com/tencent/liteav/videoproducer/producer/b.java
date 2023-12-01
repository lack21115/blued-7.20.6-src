package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f23453a;
    private final GLConstants.PixelFormatType b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.PixelBufferType f23454c;
    private final CustomVideoProcessListener d;

    private b(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        this.f23453a = aVar;
        this.b = pixelFormatType;
        this.f23454c = pixelBufferType;
        this.d = customVideoProcessListener;
    }

    public static Runnable a(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        return new b(aVar, pixelFormatType, pixelBufferType, customVideoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f23453a;
        GLConstants.PixelFormatType pixelFormatType = this.b;
        GLConstants.PixelBufferType pixelBufferType = this.f23454c;
        CustomVideoProcessListener customVideoProcessListener = this.d;
        boolean z = (aVar.e == pixelFormatType && aVar.d == pixelBufferType) ? false : true;
        if (z) {
            LiteavLog.i("CustomVideoProcessListenerAdapter", "FormatOrBufferTypeChanged from (PixelFormat:" + aVar.e + ",  PixelBuffer:" + aVar.d + ") to (PixelFormat:" + pixelFormatType + ",  PixelBuffer:" + pixelBufferType);
            aVar.f = true;
        }
        if (aVar.f23414c == null) {
            aVar.a(customVideoProcessListener);
        }
        if (aVar.f23414c != null && (z || aVar.f23414c != customVideoProcessListener)) {
            aVar.b(aVar.f23414c);
            aVar.a(customVideoProcessListener);
        }
        aVar.e = pixelFormatType;
        aVar.d = pixelBufferType;
        aVar.f23414c = customVideoProcessListener;
    }
}
