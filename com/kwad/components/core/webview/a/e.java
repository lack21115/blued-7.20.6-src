package com.kwad.components.core.webview.a;

import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/e.class */
public class e implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c nN;

    public final void b(final com.kwad.sdk.core.response.kwai.a aVar) {
        if (this.nN != null) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.nN.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "giveRewardInAdvance";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
