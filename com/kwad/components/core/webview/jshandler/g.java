package com.kwad.components.core.webview.jshandler;

import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/g.class */
public final class g implements com.kwad.sdk.core.webview.b.a {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/g$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "uuid";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        aVar.data = UUID.randomUUID().toString();
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
