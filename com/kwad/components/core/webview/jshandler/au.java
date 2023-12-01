package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/au.class */
public final class au implements com.kwad.sdk.core.webview.b.a {
    private a Uf;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/au$a.class */
    public interface a {
        void qQ();
    }

    public au(a aVar) {
        this.Uf = aVar;
    }

    private void rf() {
        if (com.kwad.components.core.d.a.b.mF()) {
            return;
        }
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.au.1
            @Override // java.lang.Runnable
            public final void run() {
                if (au.this.Uf != null) {
                    au.this.Uf.qQ();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        rf();
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
