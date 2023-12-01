package com.kwad.components.core.webview.jshandler;

import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ae.class */
public final class ae implements com.kwad.sdk.core.webview.b.a {
    private List<c> mHolders = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ae$a.class */
    public static final class a extends com.kwad.sdk.core.download.kwai.a {
        private c TE;

        public a(c cVar) {
            this.TE = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ae.a(this.TE, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ae.a(this.TE, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ae.a(this.TE, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ae.a(this.TE, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i) {
            ae.a(this.TE, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            ae.a(this.TE, 2, (i * 1.0f) / 100.0f);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ae$b.class */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ae$c.class */
    public static final class c {
        private com.kwad.components.core.d.b.c TF;
        private a TG;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.b.c nN;

        public c(com.kwad.components.core.d.b.c cVar, AdTemplate adTemplate) {
            this.TF = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            this.TF.b(aVar);
            this.TG = aVar;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.d.b.c cVar = this.TF;
            if (cVar == null || (aVar = this.TG) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long qX() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.a.d.cl(adTemplate);
        }
    }

    public ae(List<AdTemplate> list, List<com.kwad.components.core.d.b.c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mHolders.add(new c(list2.get(i2), list.get(i2)));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i, float f) {
        if (cVar == null || cVar.nN == null) {
            return;
        }
        com.kwad.sdk.core.d.b.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.nN + f);
        com.kwad.sdk.core.webview.b.c cVar2 = cVar.nN;
        aq.a aVar = new aq.a();
        aVar.TZ = f;
        aVar.status = i;
        aVar.creativeId = cVar.qX();
        aVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(cVar.mAdTemplate).totalBytes;
        cVar2.a(aVar);
    }

    private c y(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.qX() == j) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c y = y(bVar.creativeId);
                if (y != null) {
                    y.nN = cVar;
                    y.a(new a(y));
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        for (c cVar : this.mHolders) {
            cVar.destroy();
        }
    }
}
