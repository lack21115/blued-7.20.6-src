package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/s.class */
public final class s implements com.kwad.sdk.core.webview.b.a {
    private boolean SA;
    private Handler Sw;
    private boolean dontShowDialog;
    private final com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.sdk.core.webview.b mBridgeContext;
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;

    public s(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, cVar, aVar, false, false);
    }

    public s(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar, boolean z, boolean z2) {
        this.dontShowDialog = false;
        this.SA = false;
        this.dontShowDialog = z;
        this.Sw = new Handler(Looper.getMainLooper());
        this.mBridgeContext = bVar;
        this.mApkDownloadHelper = cVar;
        this.SA = z2;
        if (cVar != null) {
            cVar.as(1);
        }
        this.mWebCardClickListener = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.II = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        if (!this.mBridgeContext.apr) {
            if (this.mWebCardClickListener != null) {
                handler = this.Sw;
                runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.s.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (s.this.mWebCardClickListener != null) {
                            s.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.Sw;
        runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.s.1
            @Override // java.lang.Runnable
            public final void run() {
                if (s.this.mBridgeContext.aps || aVar.TA) {
                    AdTemplate adTemplate = s.this.mBridgeContext.getAdTemplate();
                    BusinessType businessType = null;
                    if (adTemplate.mAdScene != null) {
                        businessType = KSLoggerReporter.bv(adTemplate.mAdScene.getAdStyle());
                    }
                    KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(businessType, "adClick").b("isWebCard", Boolean.TRUE).report();
                    com.kwad.components.core.d.b.a.a(s.this.mBridgeContext.LD.getContext(), s.this.mBridgeContext.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.s.1.1
                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            if (s.this.mWebCardClickListener != null) {
                                s.this.mWebCardClickListener.onAdClicked(aVar);
                            }
                        }
                    }, s.this.mApkDownloadHelper, aVar.TA, s.this.dontShowDialog, s.this.SA);
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sw.removeCallbacksAndMessages(null);
        this.mWebCardClickListener = null;
    }
}
