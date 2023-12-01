package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ai.class */
public final class ai implements com.kwad.sdk.core.webview.b.a {
    private Handler Sw = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.b.c Sx;
    private b cZ;
    private String mUrl;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ai$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ai$b.class */
    public interface b {
        void a(a aVar);
    }

    @Deprecated
    public ai(b bVar) {
        this.cZ = bVar;
    }

    public ai(b bVar, String str) {
        this.cZ = bVar;
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cZ;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ai.1
                @Override // java.lang.Runnable
                public final void run() {
                    ai.this.b(aVar);
                    if (ai.this.Sx != null) {
                        ai.this.Sx.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.sdk.core.webview.a.b.b.Q(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cZ = null;
        this.Sx = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
