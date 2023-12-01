package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/t.class */
public final class t implements com.kwad.sdk.core.webview.b.a {
    private a SD;
    private final com.kwad.sdk.core.webview.b mBridgeContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/t$a.class */
    public interface a {
        void bI();
    }

    public t(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.mBridgeContext = bVar;
        this.SD = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.t.1
            @Override // java.lang.Runnable
            public final void run() {
                t.this.SD.bI();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
