package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/q.class */
public final class q implements com.kwad.sdk.core.webview.b.a {
    private Handler Sw = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.b.c Sx;
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    public q(com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(WebCloseStatus webCloseStatus) {
        com.kwad.sdk.core.webview.c.kwai.b bVar = this.mWebCardCloseListener;
        if (bVar != null) {
            bVar.a(webCloseStatus);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "close";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        final WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.q.1
            @Override // java.lang.Runnable
            public final void run() {
                q.this.b(webCloseStatus);
                if (q.this.Sx != null) {
                    q.this.Sx.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.Sx = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
