package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/as.class */
public final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ar f36882a;
    private final CaptureSourceInterface.a b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f36883c;
    private final CaptureSourceInterface.CaptureParams d;

    private as(ar arVar, CaptureSourceInterface.a aVar, Object obj, CaptureSourceInterface.CaptureParams captureParams) {
        this.f36882a = arVar;
        this.b = aVar;
        this.f36883c = obj;
        this.d = captureParams;
    }

    public static Runnable a(ar arVar, CaptureSourceInterface.a aVar, Object obj, CaptureSourceInterface.CaptureParams captureParams) {
        return new as(arVar, aVar, obj, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ar.a(this.f36882a, this.b, this.f36883c, this.d);
    }
}
