package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ao.class */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f36877a;
    private final CaptureSourceInterface.CaptureParams b;

    private ao(ah ahVar, CaptureSourceInterface.CaptureParams captureParams) {
        this.f36877a = ahVar;
        this.b = captureParams;
    }

    public static Runnable a(ah ahVar, CaptureSourceInterface.CaptureParams captureParams) {
        return new ao(ahVar, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f36877a;
        CaptureSourceInterface.CaptureParams captureParams = this.b;
        if (ahVar.f36865c != null) {
            ahVar.d = captureParams;
            if (ahVar.k == ah.a.STARTED) {
                ahVar.f36865c.updateParams(captureParams);
            } else if (ahVar.k == ah.a.PAUSED) {
                ahVar.f36865c.updateParams(captureParams);
                if (!ahVar.j || ahVar.f36864a == null) {
                    return;
                }
                ahVar.f36864a.updateParams(ahVar.d);
            }
        }
    }
}
