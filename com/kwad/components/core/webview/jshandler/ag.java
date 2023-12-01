package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ag.class */
public final class ag implements com.kwad.sdk.core.webview.b.a {
    private a TJ;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ag$a.class */
    public interface a {
        void a(com.kwad.components.core.webview.kwai.b bVar);
    }

    public ag(a aVar) {
        this.TJ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.kwai.b bVar = new com.kwad.components.core.webview.kwai.b();
        try {
            bVar.parseJson(new JSONObject(str));
            if (this.TJ != null) {
                this.TJ.a(bVar);
            }
        } catch (Exception e) {
            cVar.onError(-1, "");
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.TJ = null;
    }
}
