package com.kwad.components.ad.reward.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/b.class */
public class b implements com.kwad.sdk.core.webview.b.a {
    private a wS;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/b$a.class */
    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        iT();
    }

    public void iT() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.wS = null;
    }
}
