package com.kwad.components.ad.reward.h;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/k.class */
public final class k implements com.kwad.sdk.core.webview.b.a {
    private a wZ;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/k$a.class */
    public interface a {
        void d(com.kwad.components.core.webview.a.a.r rVar);
    }

    public final void a(a aVar) {
        this.wZ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (this.wZ != null) {
            com.kwad.components.core.webview.a.a.r rVar = new com.kwad.components.core.webview.a.a.r();
            try {
                rVar.parseJson(new JSONObject(str));
                this.wZ.d(rVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wZ = null;
    }
}
