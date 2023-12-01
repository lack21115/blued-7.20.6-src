package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/n.class */
public class n implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.y yVar) {
    }

    public void b(com.kwad.components.core.webview.a.a.y yVar) {
    }

    public void c(com.kwad.components.core.webview.a.a.y yVar) {
    }

    public void d(com.kwad.components.core.webview.a.a.y yVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        final com.kwad.components.core.webview.a.a.y yVar = new com.kwad.components.core.webview.a.a.y();
        try {
            yVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.n.1
            @Override // java.lang.Runnable
            public final void run() {
                if (yVar.rg()) {
                    n.this.a(yVar);
                } else if (yVar.ri()) {
                    n.this.b(yVar);
                } else if (yVar.rh()) {
                    n.this.c(yVar);
                } else if (yVar.isFailed()) {
                    n.this.d(yVar);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
