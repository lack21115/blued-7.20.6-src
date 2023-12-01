package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ad.class */
public final class ad implements com.kwad.sdk.core.webview.b.a {
    private final Handler Sw;
    private final b Tu;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ad$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean TA;
        public String TB;
        public int TC;
        public com.kwad.sdk.core.webview.c.a.c TD;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ad$b.class */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.TB));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        if (com.kwad.sdk.core.response.a.d.bT(adTemplate)) {
            if (this.mBridgeContext.apq != null) {
                cVar2 = (com.kwad.components.core.d.b.c) this.mBridgeContext.apq.eE(com.kwad.sdk.core.response.a.d.cb(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.mBridgeContext.apr) {
                final com.kwad.components.core.d.b.c cVar3 = cVar2;
                this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.b bVar = new y.b();
                        bVar.Ts = aVar.TD.Ts;
                        com.kwad.components.core.d.b.a.a(new a.C0519a(ad.this.mBridgeContext.LD.getContext()).I(adTemplate).b(cVar3).ap(aVar.TC).ao(true).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ad.1.1
                            @Override // com.kwad.components.core.d.b.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.Tu != null) {
                this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.2
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sw.removeCallbacksAndMessages(null);
    }
}
