package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/o.class */
public final class o implements com.kwad.sdk.core.webview.b.a {
    private List<AdTemplate> Ss;
    private com.kwad.sdk.core.webview.b cV;
    private b oI;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/o$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/o$b.class */
    public interface b {
        void x(AdTemplate adTemplate);
    }

    public o(com.kwad.sdk.core.webview.b bVar) {
        this.cV = bVar;
    }

    public o(List<AdTemplate> list) {
        this.Ss = list;
    }

    private List<AdTemplate> qV() {
        List<AdTemplate> list = this.Ss;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.cV;
        if (bVar != null) {
            return bVar.yT();
        }
        return null;
    }

    public final void a(b bVar) {
        this.oI = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a2 = com.kwad.sdk.core.response.a.d.a(qV(), aVar.creativeId, aVar.adStyle);
            if (this.oI != null) {
                this.oI.x(a2);
            }
        } catch (JSONException e) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
