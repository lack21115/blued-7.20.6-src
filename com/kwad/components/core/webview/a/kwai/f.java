package com.kwad.components.core.webview.a.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/f.class */
public final class f implements com.kwad.sdk.core.webview.b.a {
    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getKsAdConfig";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(com.kwad.sdk.core.config.d.uu());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
