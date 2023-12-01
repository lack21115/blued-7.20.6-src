package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aa.class */
public final class aa implements com.kwad.sdk.core.webview.b.a {
    private final Handler Sw = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.b.c Sx;
    private b cY;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aa$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int Tm = -1;
        public int type;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aa$b.class */
    public interface b {
        void a(a aVar);
    }

    public aa(b bVar) {
        this.cY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cY;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.Sx = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aa.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (aa.this.Sx != null) {
                        aa.this.Sx.a(null);
                    }
                    aa.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.Sx.onError(-1, e.getMessage());
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cY = null;
        this.Sx = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
