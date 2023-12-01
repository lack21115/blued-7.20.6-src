package com.kwad.components.core.webview.a.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/o.class */
public class o extends v {
    private a UK;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/o$a.class */
    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.UK = aVar;
    }

    public final void b(com.kwad.components.core.webview.a.a.m mVar) {
        super.b((com.kwad.sdk.core.b) mVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "registerMuteStateListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
        if (this.UK != null) {
            com.kwad.components.core.webview.a.a.m mVar = new com.kwad.components.core.webview.a.a.m();
            mVar.Vf = this.UK.isMuted();
            cVar.a(mVar);
        }
    }
}
