package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/at.class */
public final class at implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sx;
    private b Uc;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/at$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/at$b.class */
    public interface b {
        void a(a aVar);
    }

    public at(b bVar) {
        this.Uc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.Uc;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.at.1
            @Override // java.lang.Runnable
            public final void run() {
                at.this.b(aVar);
                if (at.this.Sx != null) {
                    at.this.Sx.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Uc = null;
        this.Sx = null;
    }
}
