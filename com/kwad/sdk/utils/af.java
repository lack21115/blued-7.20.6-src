package com.kwad.sdk.utils;

import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/af.class */
public final class af {
    private Map<String, com.kwad.sdk.core.webview.a> azX;
    private Map<String, com.kwad.sdk.core.webview.b.c> azY;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.azX.put(str, aVar);
    }

    public final void a(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.azY.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a eE(String str) {
        return this.azX.get(str);
    }

    public final com.kwad.sdk.core.webview.b.c eF(String str) {
        return this.azY.get(str);
    }

    public final void release() {
        for (com.kwad.sdk.core.webview.a aVar : this.azX.values()) {
            aVar.nq();
        }
        this.azX.clear();
        this.azY.clear();
    }
}
