package com.kwad.components.core.webview.a;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/b.class */
public final class b implements com.kwad.sdk.core.webview.b.a {
    private a Uo;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/b$a.class */
    public interface a {
        void es();
    }

    public b(a aVar) {
        this.Uo = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.Uo;
        if (aVar != null) {
            aVar.es();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
