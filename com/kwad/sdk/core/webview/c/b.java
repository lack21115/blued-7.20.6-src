package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.core.webview.b.c;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import com.kwad.sdk.core.webview.request.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/c/b.class */
public final class b implements com.kwad.sdk.core.webview.b.a {
    private c aql;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/c/b$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String method;
        public String params;
        public String url;
    }

    private void a(a aVar) {
        new com.kwad.sdk.core.webview.request.b().a(aVar, new b.a() { // from class: com.kwad.sdk.core.webview.c.b.1
            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void a(WebCardGetDataResponse webCardGetDataResponse) {
                if (b.this.aql != null) {
                    b.this.aql.a(webCardGetDataResponse);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void onError(int i, String str) {
                if (b.this.aql != null) {
                    b.this.aql.onError(i, str);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "requestData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, c cVar) {
        this.aql = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            a(aVar);
        } catch (JSONException e) {
            c cVar2 = this.aql;
            if (cVar2 != null) {
                cVar2.onError(-1, "data parse json error.");
            }
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.aql = null;
    }
}
