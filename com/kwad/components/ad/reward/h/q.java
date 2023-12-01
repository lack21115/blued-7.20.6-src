package com.kwad.components.ad.reward.h;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/q.class */
public final class q extends com.kwad.components.core.webview.jshandler.p {
    private long uV;
    private WeakReference<com.kwad.components.ad.reward.j> xb;

    public q(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.components.ad.reward.j jVar, long j, com.kwad.sdk.core.webview.c.kwai.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.uV = -1L;
        this.uV = j;
        if (jVar != null) {
            this.xb = new WeakReference<>(jVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
        if (r8 > 0) goto L6;
     */
    @Override // com.kwad.components.core.webview.jshandler.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kwad.sdk.core.report.y.b getClientParams(com.kwad.sdk.core.webview.c.a.a r6, com.kwad.sdk.core.response.model.AdTemplate r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r2 = r7
            com.kwad.sdk.core.report.y$b r0 = super.getClientParams(r1, r2)
            r6 = r0
            r0 = r5
            java.lang.ref.WeakReference<com.kwad.components.ad.reward.j> r0 = r0.xb
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L2b
            r0 = r7
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L2b
            r0 = r5
            java.lang.ref.WeakReference<com.kwad.components.ad.reward.j> r0 = r0.xb
            java.lang.Object r0 = r0.get()
            com.kwad.components.ad.reward.j r0 = (com.kwad.components.ad.reward.j) r0
            com.kwad.components.ad.reward.j.b r0 = r0.oN
            long r0 = r0.getPlayDuration()
            r8 = r0
            goto L36
        L2b:
            r0 = r5
            long r0 = r0.uV
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L3b
        L36:
            r0 = r6
            r1 = r8
            r0.uV = r1
        L3b:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.h.q.getClientParams(com.kwad.sdk.core.webview.c.a.a, com.kwad.sdk.core.response.model.AdTemplate):com.kwad.sdk.core.report.y$b");
    }

    @Override // com.kwad.components.core.webview.jshandler.p
    public final void onAdClickListen() {
        super.onAdClickListen();
        if (this.mBridgeContext != null) {
            com.kwad.components.ad.reward.b.a.gQ().d(this.mBridgeContext.getAdTemplate(), com.kwad.components.ad.reward.b.b.STATUS_NONE);
        }
    }
}
