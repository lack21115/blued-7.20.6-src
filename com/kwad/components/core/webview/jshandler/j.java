package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/j.class */
public final class j implements com.kwad.sdk.core.webview.b.a {
    private a Sj;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/j$a.class */
    public interface a {
        void onPlayAgainClick(boolean z);
    }

    public final void b(a aVar) {
        this.Sj = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "showPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.this.Sj != null) {
                    j.this.Sj.onPlayAgainClick(false);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
