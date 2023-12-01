package com.kwad.components.core.webview.a.kwai;

import com.kwad.components.core.webview.a.a.z;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/p.class */
public class p extends v {
    private boolean Ig = true;

    public final void a(z zVar) {
        if (this.Ig) {
            super.b(zVar);
        }
    }

    public final void aP(boolean z) {
        this.Ig = false;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "registerVideoProgressListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
    }
}
