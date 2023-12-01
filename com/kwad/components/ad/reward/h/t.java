package com.kwad.components.ad.reward.h;

import android.content.Context;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/t.class */
public final class t implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.components.ad.reward.j xc;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/t$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean xe;
    }

    public t(Context context, com.kwad.components.ad.reward.j jVar) {
        this.mContext = context;
        this.mAdTemplate = jVar.mAdTemplate;
        this.xc = jVar;
    }

    private void a(a aVar) {
        if (aVar.xe) {
            com.kwad.components.ad.reward.presenter.e.r(this.xc);
        } else {
            AdWebViewActivityProxy.launch(this.mContext, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "showLandingPage";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a(aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xc = null;
        this.mContext = null;
        this.mAdTemplate = null;
    }
}
