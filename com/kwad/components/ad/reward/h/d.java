package com.kwad.components.ad.reward.h;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/d.class */
public final class d implements com.kwad.sdk.core.webview.b.a {
    private a wU;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/d$a.class */
    public interface a {
        void a(com.kwad.components.core.webview.a.a.q qVar);
    }

    public final void a(a aVar) {
        this.wU = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.q qVar = new com.kwad.components.core.webview.a.a.q();
        try {
            qVar.parseJson(new JSONObject(str));
            if (this.wU != null) {
                this.wU.a(qVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wU = null;
    }
}
