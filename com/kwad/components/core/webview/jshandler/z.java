package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/z.class */
public final class z implements com.kwad.sdk.core.webview.b.a {
    private final Handler Sw = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate = new AdTemplate();
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/z$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String Td;
        public int Te;
        public String Tf;
        public String Tg;
        public String Th;
        @Deprecated
        public boolean Ti;
        public boolean Tj;
        public boolean Tk;
        public String appId;
        public String appName;
        public String icon;
        public String qi;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public z(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
        try {
            AdTemplate adTemplate = this.mBridgeContext.getAdTemplate();
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

    private static void a(AdInfo adInfo, a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.Tg;
        adConversionInfo.marketUrl = aVar.Th;
        adInfo.adBaseInfo.adOperationType = aVar.type;
        adInfo.adBaseInfo.appPackageName = aVar.Td;
        adInfo.adBaseInfo.appName = aVar.appName;
        adInfo.adBaseInfo.appVersion = aVar.version;
        adInfo.adBaseInfo.packageSize = aVar.Te;
        adInfo.adBaseInfo.appIconUrl = aVar.icon;
        adInfo.adBaseInfo.appDescription = aVar.qi;
        if (!com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.url;
            return;
        }
        adInfo.adConversionInfo.appDownloadUrl = aVar.url;
        adInfo.downloadId = com.kwad.sdk.utils.ad.eC(adInfo.adConversionInfo.appDownloadUrl);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        int i;
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 2;
        } else {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
            a(cb, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 1;
        }
        cVar2.as(i);
        this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.d.b.a.a(new a.C0349a(z.this.mBridgeContext.LD.getContext()).I(z.this.mAdTemplate).b(z.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sw.removeCallbacksAndMessages(null);
    }
}
