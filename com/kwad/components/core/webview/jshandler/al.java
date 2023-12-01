package com.kwad.components.core.webview.jshandler;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/al.class */
public final class al implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private c TR;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/al$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int status;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/al$b.class */
    public interface b {
        void ox();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/al$c.class */
    public interface c {
        void oB();
    }

    public al(c cVar) {
        this.TR = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
        c cVar2 = this.TR;
        if (cVar2 != null) {
            cVar2.oB();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }

    public final void qY() {
        if (this.Sb != null) {
            a aVar = new a();
            aVar.status = 1;
            this.Sb.a(aVar);
        }
    }
}
