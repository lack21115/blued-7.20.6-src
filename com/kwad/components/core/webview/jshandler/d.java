package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/d.class */
public final class d implements com.kwad.sdk.core.webview.b.a {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/d$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "md5";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.j jVar = new com.kwad.components.core.webview.a.a.j();
        try {
            jVar.parseJson(new JSONObject(str));
        } catch (Exception e) {
        }
        a aVar = new a();
        aVar.data = TextUtils.isEmpty(jVar.data) ? "" : com.kwad.sdk.utils.ad.eC(jVar.data);
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
