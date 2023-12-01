package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ao.class */
public final class ao implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private final Handler Sw = new Handler(Looper.getMainLooper());
    private final c TT;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ao$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ao$b.class */
    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.b.c> Qf;

        public b(com.kwad.sdk.core.webview.b.c cVar) {
            this.Qf = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.b.c cVar = this.Qf.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ao$c.class */
    public interface c {
        void a(b bVar);
    }

    public ao(c cVar) {
        this.TT = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
        this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ao.1
            @Override // java.lang.Runnable
            public final void run() {
                ao.this.TT.a(new b(ao.this.Sb));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
