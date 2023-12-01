package com.kwad.components.core.webview.a.kwai;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/t.class */
public final class t implements com.kwad.sdk.core.webview.b.a {
    private a UM;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/t$a.class */
    public interface a {
        void a(com.kwad.components.core.webview.a.a.u uVar);
    }

    public final void a(a aVar) {
        this.UM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UM != null) {
            com.kwad.components.core.webview.a.a.u uVar = new com.kwad.components.core.webview.a.a.u();
            try {
                try {
                    uVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.UM.a(uVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UM = null;
    }
}
