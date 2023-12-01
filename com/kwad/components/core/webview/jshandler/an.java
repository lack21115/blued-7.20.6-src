package com.kwad.components.core.webview.jshandler;

import com.huawei.openalliance.ad.inter.data.AdEventType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/an.class */
public final class an implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/an$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        private String TS;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "lifeStatus", this.TS);
            return jSONObject;
        }
    }

    private void aO(String str) {
        if (this.Sb != null) {
            a aVar = new a();
            aVar.TS = str;
            this.Sb.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerLifecycleListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }

    public final void qZ() {
        aO(AdEventType.SHOW_START);
    }

    public final void ra() {
        aO("showEnd");
    }

    public final void rb() {
        aO("hideStart");
    }

    public final void rc() {
        aO("hideEnd");
    }

    public final void rd() {
        aO("pageVisiable");
    }

    public final void re() {
        aO("pageInvisiable");
    }
}
