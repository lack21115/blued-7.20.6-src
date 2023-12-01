package com.kwad.components.core.webview.jshandler;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/c.class */
public final class c implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private int mO;
    private int mP;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/c$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int showLiveStatus;
        public int showLiveStyle;
    }

    public c(int i, int i2) {
        this.mO = i;
        this.mP = i2;
    }

    private void o(int i, int i2) {
        if (this.Sb == null) {
            return;
        }
        a aVar = new a();
        aVar.showLiveStatus = i;
        aVar.showLiveStyle = i2;
        this.Sb.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getLiveInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
        o(this.mO, this.mP);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }
}
