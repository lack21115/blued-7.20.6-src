package com.kwad.sdk.core.webview.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/b/d.class */
public final class d implements a {
    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, c cVar) {
        cVar.onError(-1, "DefaultHandler response data");
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
