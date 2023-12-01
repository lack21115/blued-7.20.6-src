package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/am.class */
final /* synthetic */ class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f36875a;

    private am(ah ahVar) {
        this.f36875a = ahVar;
    }

    public static Runnable a(ah ahVar) {
        return new am(ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f36875a;
        if (ahVar.k != ah.a.PAUSED) {
            LiteavLog.w("CaptureController", "resume capture but mStatus is " + ahVar.k);
            return;
        }
        ahVar.k = ah.a.STARTED;
        if (ahVar.f36864a != null) {
            ahVar.f36864a.stop();
            ahVar.f36864a = null;
        }
        if (ahVar.f36865c != null) {
            ahVar.f36865c.resume();
        }
    }
}
