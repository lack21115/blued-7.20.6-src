package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/an.class */
final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f36876a;

    private an(ah ahVar) {
        this.f36876a = ahVar;
    }

    public static Runnable a(ah ahVar) {
        return new an(ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f36876a;
        if (ahVar.k == ah.a.STOPED) {
            LiteavLog.w("CaptureController", "Stop capture but mStatus is stoped");
            return;
        }
        ahVar.k = ah.a.STOPED;
        if (ahVar.f36865c != null) {
            ahVar.f36865c.stop();
            ahVar.f36865c = null;
        }
        if (ahVar.f36864a != null) {
            ahVar.f36864a.stop();
            ahVar.f36864a = null;
        }
        ahVar.l = false;
        ahVar.m.b();
    }
}
