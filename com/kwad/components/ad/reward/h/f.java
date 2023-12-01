package com.kwad.components.ad.reward.h;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/f.class */
public class f implements com.kwad.sdk.core.webview.b.a {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/f$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean wW;
    }

    public void Z(boolean z) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        boolean z;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            z = aVar.wW;
        } catch (Exception e) {
            z = false;
        }
        Z(z);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
