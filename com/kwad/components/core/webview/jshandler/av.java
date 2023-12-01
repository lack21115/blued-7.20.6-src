package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/av.class */
public final class av implements com.kwad.sdk.core.webview.b.a {
    private static Handler Uk;
    private com.kwad.components.core.d.b.c IM;
    private b Ul;
    private com.kwad.sdk.core.webview.b jsBridgeContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/av$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int jU;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/av$b.class */
    public interface b {
        void S(int i);
    }

    public av(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, b bVar2) {
        this.jsBridgeContext = bVar;
        this.IM = cVar;
        this.Ul = bVar2;
        if (Uk == null) {
            Uk = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.jU;
            Uk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.av.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (av.this.Ul != null) {
                        av.this.Ul.S(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
