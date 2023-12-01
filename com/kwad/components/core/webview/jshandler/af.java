package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/af.class */
public final class af implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b cV;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/af$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String TB;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/af$b.class */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public double TI;
        public int status;
        public long totalBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.b.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.TI = f;
            bVar.status = i;
            bVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(this.cV.getAdTemplate()).totalBytes;
            cVar.a(bVar);
        }
    }

    private KsAppDownloadListener aN(String str) {
        return new com.kwad.sdk.core.download.kwai.a(str) { // from class: com.kwad.components.core.webview.jshandler.af.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (af.this.cV.apq != null) {
                    af.this.a(1, 0.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (af.this.cV.apq != null) {
                    af.this.a(5, 1.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (af.this.cV.apq != null) {
                    af.this.a(1, 0.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (af.this.cV.apq != null) {
                    af.this.a(6, 1.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                if (af.this.cV.apq != null) {
                    af.this.a(3, (i * 1.0f) / 100.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (af.this.cV.apq != null) {
                    af.this.a(2, (i * 1.0f) / 100.0f, af.this.cV.apq.eF(nc()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        AdTemplate adTemplate;
        a aVar = new a();
        AdTemplate adTemplate2 = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate2.parseJson(new JSONObject(aVar.TB));
            adTemplate = adTemplate2;
        } catch (Exception e) {
            adTemplate = null;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.a.d.bT(adTemplate) || this.cV.apq == null) {
            return;
        }
        com.kwad.components.core.d.b.c cVar2 = new com.kwad.components.core.d.b.c(adTemplate);
        String nc = cVar2.nc();
        cVar2.b(aN(nc));
        this.cV.apq.a(nc, cVar2);
        this.cV.apq.a(nc, cVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        if (this.cV.apq != null) {
            this.cV.apq.release();
        }
    }
}
