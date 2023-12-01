package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ap.class */
public final class ap implements com.kwad.sdk.core.webview.b.a {
    private final a TV;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ap$a.class */
    public interface a {
        void bJ();
    }

    public ap(a aVar) {
        this.TV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, final com.kwad.sdk.core.webview.b.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ap.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ap.this.TV != null) {
                    ap.this.TV.bJ();
                }
                cVar.a(null);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
