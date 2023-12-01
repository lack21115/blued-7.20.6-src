package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b.d;
import com.kwad.sdk.core.webview.b.e;
import com.kwad.sdk.core.webview.b.f;
import com.kwad.sdk.utils.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a.class */
public final class a {
    private WebView Lc;
    private final Map<String, com.kwad.sdk.core.webview.b.a> RI = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.b.a RJ = new d();
    private boolean RK;

    public a(WebView webView) {
        this.Lc = webView;
        qJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2) {
        String str3;
        if (this.RK) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.b.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.Lc;
            if (webView == null) {
                return;
            }
            bo.a(webView, str, str2);
            return;
        } else {
            str3 = "callJS callback is empty";
        }
        com.kwad.sdk.core.d.b.d("KSAdJSBridge", str3);
    }

    private void qJ() {
        a(new com.kwad.sdk.core.webview.c.a());
        a(new com.kwad.sdk.core.webview.c.b());
        a(new r());
    }

    public final void a(com.kwad.sdk.core.webview.b.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.RI.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.RI.put(aVar.getKey(), aVar);
    }

    public final void b(com.kwad.sdk.core.webview.b.a aVar) {
        if (TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
        } else {
            this.RI.put(aVar.getKey(), aVar);
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.d.b.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.b.b bVar = new com.kwad.sdk.core.webview.b.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.b.a aVar = this.RI.get(bVar.aqe);
            com.kwad.sdk.core.webview.b.a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = this.RJ;
            }
            if (this.Lc != null && (this.Lc instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) this.Lc;
                com.kwad.sdk.core.webview.a.b.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.aqe, bVar.data);
            }
            if (aVar2 == null) {
                com.kwad.sdk.core.d.b.e("KSAdJSBridge", "bridgeHandler is null");
                return;
            }
            aVar2.handleJsCall(bVar.data, !TextUtils.isEmpty(bVar.aqf) ? new com.kwad.sdk.core.webview.b.c() { // from class: com.kwad.components.core.webview.a.1
                @Override // com.kwad.sdk.core.webview.b.c
                public final void a(com.kwad.sdk.core.b bVar2) {
                    a.this.h(bVar.aqf, new f(bVar2).toJson().toString());
                }

                @Override // com.kwad.sdk.core.webview.b.c
                public final void onError(int i, String str2) {
                    a.this.h(bVar.aqf, new e(i, str2).toJson().toString());
                }
            } : new com.kwad.sdk.core.webview.b.c() { // from class: com.kwad.components.core.webview.a.2
                @Override // com.kwad.sdk.core.webview.b.c
                public final void a(com.kwad.sdk.core.b bVar2) {
                }

                @Override // com.kwad.sdk.core.webview.b.c
                public final void onError(int i, String str2) {
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            com.kwad.sdk.core.d.b.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.d.b.i("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, com.kwad.sdk.core.webview.b.a> entry : this.RI.entrySet()) {
            com.kwad.sdk.core.webview.b.a value = entry.getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.RK = true;
    }
}
