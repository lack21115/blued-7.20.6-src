package com.kwad.components.ad.reward.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/c.class */
public class c implements com.kwad.sdk.core.webview.b.a {
    private a wT;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/c$a.class */
    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        iT();
    }

    public void iT() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.wT = null;
    }
}
