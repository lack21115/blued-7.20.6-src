package com.kwad.components.ad.reward.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/e.class */
public final class e implements com.kwad.sdk.core.webview.b.a {
    private a wV;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/e$a.class */
    public interface a {
        void iS();
    }

    public final void a(a aVar) {
        this.wV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.wV;
        if (aVar != null) {
            aVar.iS();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wV = null;
    }
}
