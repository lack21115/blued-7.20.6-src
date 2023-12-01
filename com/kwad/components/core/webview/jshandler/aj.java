package com.kwad.components.core.webview.jshandler;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aj.class */
public final class aj implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private a TN = new a();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aj$a.class */
    public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }

    private void p(int i, int i2) {
        if (this.Sb != null) {
            this.TN.id = i;
            this.TN.status = 2;
            this.Sb.a(this.TN);
        }
    }

    public final void aP(int i) {
        p(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }
}
