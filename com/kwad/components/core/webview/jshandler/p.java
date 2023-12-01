package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/p.class */
public class p implements com.kwad.sdk.core.webview.b.a {
    private boolean dontShowDialog;
    private List<com.kwad.components.core.d.b.c> mApkDownloadHelperList;
    protected final com.kwad.sdk.core.webview.b mBridgeContext;
    private int mClickActionSource;
    private final boolean mNeedReport;
    private DialogInterface.OnDismissListener mTaskDismissListener;
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;

    public p(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, cVar, aVar, false, 0, false);
    }

    public p(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar, int i) {
        this(bVar, cVar, aVar, false, i, false);
    }

    public p(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar, int i, boolean z) {
        this(bVar, cVar, aVar, false, i, z);
    }

    public p(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false);
        this.mTaskDismissListener = onDismissListener;
    }

    public p(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar, boolean z, int i, boolean z2) {
        this.dontShowDialog = false;
        this.mApkDownloadHelperList = new ArrayList();
        this.dontShowDialog = z;
        this.mBridgeContext = bVar;
        this.mClickActionSource = i;
        if (cVar != null) {
            cVar.as(1);
            this.mApkDownloadHelperList.add(cVar);
        }
        this.mWebCardClickListener = aVar;
        this.mNeedReport = z2;
    }

    public p(com.kwad.sdk.core.webview.b bVar, List<com.kwad.components.core.d.b.c> list, com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, null, aVar, false, 0, false);
        if (list != null) {
            this.mApkDownloadHelperList.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enablePauseByActionbar(com.kwad.sdk.core.webview.c.a.a aVar) {
        return aVar.TC == 1;
    }

    private boolean isInterstitialAd(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.bW(adTemplate) == 13;
    }

    public void afterHandleAdClick(int i) {
    }

    protected com.kwad.components.core.d.b.c getApkDownloadHelper(long j) {
        List<com.kwad.components.core.d.b.c> list = this.mApkDownloadHelperList;
        if (list == null) {
            return null;
        }
        if (j >= 0 || list.size() != 1) {
            for (com.kwad.components.core.d.b.c cVar : this.mApkDownloadHelperList) {
                if (com.kwad.sdk.core.response.a.d.cl(cVar.nj()) == j) {
                    return cVar;
                }
            }
            return null;
        }
        return this.mApkDownloadHelperList.get(0);
    }

    public y.b getClientParams(com.kwad.sdk.core.webview.c.a.a aVar, AdTemplate adTemplate) {
        y.b bVar = new y.b();
        if (aVar.TD != null && !TextUtils.isEmpty(aVar.TD.Ts)) {
            bVar.Ts = aVar.TD.Ts;
        }
        if (aVar.TD != null && aVar.TD.aqp != 0) {
            bVar.akR = aVar.TD.aqp;
        }
        if (!isInterstitialAd(adTemplate) || aVar.TD == null || aVar.TD.aqq == null) {
            com.kwad.sdk.widget.e eVar = this.mBridgeContext.app;
            if (eVar != null) {
                bVar.jW = eVar.getTouchCoords();
            }
            return bVar;
        }
        ac.a aVar2 = new ac.a();
        aVar2.g((float) aVar.TD.aqq.x, (float) aVar.TD.aqq.y);
        aVar2.f((float) aVar.TD.aqq.x, (float) aVar.TD.aqq.y);
        aVar2.u(aVar.TD.aqq.width, aVar.TD.aqq.height);
        bVar.jW = aVar2;
        return bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        Runnable runnable;
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        if (!this.mBridgeContext.apr) {
            if (this.mWebCardClickListener != null) {
                runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.p.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (p.this.mWebCardClickListener != null) {
                            p.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.p.1
            @Override // java.lang.Runnable
            public final void run() {
                AdTemplate adTemplate;
                String str2;
                if (p.this.mBridgeContext.aps) {
                    long j = aVar.creativeId;
                    com.kwad.sdk.core.webview.b bVar = p.this.mBridgeContext;
                    if (j >= 0) {
                        adTemplate = com.kwad.sdk.core.response.a.d.a(bVar.yT(), aVar.creativeId, aVar.adStyle);
                    } else {
                        adTemplate = bVar.getAdTemplate();
                        aVar.creativeId = com.kwad.sdk.core.response.a.d.cl(adTemplate);
                        aVar.adStyle = com.kwad.sdk.core.response.a.d.bW(adTemplate);
                    }
                    com.kwad.components.core.d.b.c apkDownloadHelper = p.this.getApkDownloadHelper(aVar.creativeId);
                    if (p.this.mTaskDismissListener != null && apkDownloadHelper != null) {
                        apkDownloadHelper.setOnDismissListener(p.this.mTaskDismissListener);
                    }
                    if (TextUtils.isEmpty(aVar.IY)) {
                        str2 = null;
                        if (adTemplate != null) {
                            str2 = null;
                            if (adTemplate.tkLiveShopItemInfo != null) {
                                str2 = adTemplate.tkLiveShopItemInfo.itemId;
                            }
                        }
                    } else {
                        try {
                            str2 = com.kwad.components.core.d.kwai.a.o(Long.parseLong(aVar.IY));
                        } catch (Exception e2) {
                            str2 = aVar.IY;
                        }
                    }
                    p.this.afterHandleAdClick(com.kwad.components.core.d.b.a.a(new a.C0519a(p.this.mBridgeContext.LD.getContext()).I(adTemplate).b(apkDownloadHelper).ap(str2).ao(p.this.enablePauseByActionbar(aVar)).ap(p.this.dontShowDialog).d(p.this.mBridgeContext.mReportExtData).ap(aVar.TC).an(aVar.aqo).ao(aVar.jU).aq(p.this.mNeedReport || aVar.IQ).ar(p.this.mClickActionSource).a(p.this.getClientParams(aVar, adTemplate)).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.p.1.1
                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            p.this.onAdClickListen();
                            if (p.this.mWebCardClickListener != null) {
                                p.this.mWebCardClickListener.onAdClicked(aVar);
                            }
                        }
                    })));
                }
            }
        };
        bi.runOnUiThread(runnable);
        cVar.a(null);
    }

    public void onAdClickListen() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.mWebCardClickListener = null;
    }
}
