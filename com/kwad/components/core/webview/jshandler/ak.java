package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ak.class */
public final class ak implements com.kwad.sdk.core.webview.b.a {
    private KsAppDownloadListener RT;
    private com.kwad.sdk.core.webview.b.c Sb;
    private final com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ak$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double TI;
        public int status;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ak$b.class */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public long TQ;
        public String Td;
        public String Tf;
        public String appName;
        public String icon;
        public String qi;
        public String url;
        public String version;
        public int versionCode;
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.cV = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = this.cV.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.Sb != null) {
            a aVar = new a();
            aVar.TI = f;
            aVar.status = i;
            this.Sb.a(aVar);
        }
    }

    private static void a(AdInfo adInfo, b bVar) {
        adInfo.adBaseInfo.adOperationType = 1;
        adInfo.adBaseInfo.appPackageName = bVar.Td;
        adInfo.adBaseInfo.appName = bVar.appName;
        adInfo.adBaseInfo.appVersion = bVar.version;
        adInfo.adBaseInfo.packageSize = bVar.TQ;
        adInfo.adBaseInfo.appIconUrl = bVar.icon;
        adInfo.adBaseInfo.appDescription = bVar.qi;
        adInfo.adConversionInfo.appDownloadUrl = bVar.url;
        adInfo.downloadId = com.kwad.sdk.utils.ad.eC(adInfo.adConversionInfo.appDownloadUrl);
    }

    private KsAppDownloadListener qU() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.ak.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                ak.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                ak.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                ak.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                ak.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                ak.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                ak.this.a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        int i;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 2;
        } else {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
            a(cb, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 1;
        }
        cVar2.as(i);
        this.Sb = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.RT;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener qU = qU();
        this.RT = qU;
        this.mApkDownloadHelper.b(qU);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.Sb = null;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.RT) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.RT = null;
    }
}
