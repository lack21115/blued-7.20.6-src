package com.kwad.components.core.webview.a.kwai;

import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/b.class */
public final class b implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    protected final com.kwad.sdk.core.webview.b mBridgeContext;

    public b(com.kwad.sdk.core.webview.b bVar, AdTemplate adTemplate) {
        this.mBridgeContext = bVar;
        this.mAdTemplate = adTemplate;
    }

    private void R(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.d.b.a.a(new a.C0349a(this.mBridgeContext.LD.getContext()).I(adTemplate).ap(1).aq(false));
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("adTemplate")) {
                String string = jSONObject.getString("adTemplate");
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(string));
                R(adTemplate);
            } else {
                R(this.mAdTemplate);
            }
            cVar.a(null);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
