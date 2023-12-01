package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/an.class */
final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f23185a;

    private an(ah ahVar) {
        this.f23185a = ahVar;
    }

    public static Runnable a(ah ahVar) {
        return new an(ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f23185a;
        if (ahVar.k == ah.a.STOPED) {
            LiteavLog.w("CaptureController", "Stop capture but mStatus is stoped");
            return;
        }
        ahVar.k = ah.a.STOPED;
        if (ahVar.f23174c != null) {
            ahVar.f23174c.stop();
            ahVar.f23174c = null;
        }
        if (ahVar.f23173a != null) {
            ahVar.f23173a.stop();
            ahVar.f23173a = null;
        }
        ahVar.l = false;
        ahVar.m.b();
    }
}
