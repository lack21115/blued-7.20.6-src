package com.kwad.components.ad.reward.h;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/h.class */
public final class h implements com.kwad.sdk.core.webview.b.a {
    private a wY;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/h$a.class */
    public interface a {
        void T(int i);
    }

    public h(a aVar) {
        this.wY = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (this.wY != null) {
            int i = 0;
            try {
                i = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.wY.T(i);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wY = null;
    }
}
