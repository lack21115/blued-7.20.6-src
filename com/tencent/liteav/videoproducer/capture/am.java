package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/am.class */
final /* synthetic */ class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f23184a;

    private am(ah ahVar) {
        this.f23184a = ahVar;
    }

    public static Runnable a(ah ahVar) {
        return new am(ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f23184a;
        if (ahVar.k != ah.a.PAUSED) {
            LiteavLog.w("CaptureController", "resume capture but mStatus is " + ahVar.k);
            return;
        }
        ahVar.k = ah.a.STARTED;
        if (ahVar.f23173a != null) {
            ahVar.f23173a.stop();
            ahVar.f23173a = null;
        }
        if (ahVar.f23174c != null) {
            ahVar.f23174c.resume();
        }
    }
}
