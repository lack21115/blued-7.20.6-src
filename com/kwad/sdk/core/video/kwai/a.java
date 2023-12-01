package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/a.class */
public abstract class a implements c {
    private c.e QP;
    private c.h QQ;
    private c.b QR;
    private c.InterfaceC0567c QS;
    private c.d QT;
    private c.a QU;
    private c.f amO;
    private c.g amP;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(float f) {
        com.kwad.sdk.core.video.kwai.kwai.a.cN(f == 0.0f ? "autoMute" : "autoVoice");
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.a aVar) {
        this.QU = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.b bVar) {
        this.QR = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.InterfaceC0567c interfaceC0567c) {
        this.QS = interfaceC0567c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.f fVar) {
        this.amO = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.g gVar) {
        this.amP = gVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.h hVar) {
        this.QQ = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(TimedText timedText) {
        c.g gVar = this.amP;
        if (gVar != null) {
            gVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void b(c.e eVar) {
        this.QP = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void c(c.d dVar) {
        this.QT = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.QU;
        if (aVar != null) {
            aVar.ax(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnCompletion() {
        c.b bVar = this.QR;
        if (bVar != null) {
            bVar.nU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnError(int i, int i2) {
        c.InterfaceC0567c interfaceC0567c = this.QS;
        return interfaceC0567c != null && interfaceC0567c.j(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.QT;
        return dVar != null && dVar.k(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnPrepared() {
        c.e eVar = this.QP;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSeekComplete() {
        c.f fVar = this.amO;
        if (fVar != null) {
            fVar.nV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(int i, int i2) {
        c.h hVar = this.QQ;
        if (hVar != null) {
            hVar.i(i, i2);
        }
    }

    public final void resetListeners() {
        this.QP = null;
        this.QU = null;
        this.QR = null;
        this.amO = null;
        this.QQ = null;
        this.QS = null;
        this.QT = null;
        this.amP = null;
    }
}
