package com.kwad.components.core.webview.a.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/h.class */
public final class h extends v {
    private a UF;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/h$a.class */
    public interface a {
        void a(h hVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/h$b.class */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int UG;
    }

    public final void a(a aVar) {
        this.UF = aVar;
    }

    public final void aO(boolean z) {
        int i = z ? 1 : 2;
        b bVar = new b();
        bVar.UG = i;
        b(bVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
        a aVar = this.UF;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        super.onDestroy();
        this.UF = null;
    }
}
