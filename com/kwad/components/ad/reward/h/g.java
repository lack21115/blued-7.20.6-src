package com.kwad.components.ad.reward.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/g.class */
public final class g implements com.kwad.sdk.core.webview.b.a {
    private int wX;

    public g(int i) {
        this.wX = i;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.f fVar = new com.kwad.components.core.webview.a.a.f();
        fVar.UZ = this.wX;
        cVar.a(fVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
