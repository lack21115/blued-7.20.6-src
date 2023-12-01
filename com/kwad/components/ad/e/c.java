package com.kwad.components.ad.e;

import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/c.class */
public final class c {
    public static void loadNativeAd(KsScene ksScene, final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadNativeAd");
        covert.setAdStyle(10000);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0527a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.e.c.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void a(AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "dataReady").report();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList.add(new d(adTemplate));
                    }
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ac().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(final int i, final String str) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.NativeAdListener.this.onError(i, str);
                    }
                });
            }
        }).pj());
    }

    public static void loadNativeAd(String str, final KsLoadManager.NativeAdListener nativeAdListener) {
        if (k.pP().a((SceneImpl) null, "loadNativeAdByJson") && k.pP().pQ() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.f.agn.errorCode, com.kwad.sdk.core.network.f.agn.msg);
                }
            });
        }
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "requestFinish").aW(true).report();
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        nativeAdListener.onError(AdResultData.this.result, AdResultData.this.errorMsg);
                    }
                });
            } else if (adResultData.isAdResultDataEmpty()) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg);
                    }
                });
            } else {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        arrayList.add(new d(adTemplate));
                    }
                }
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "dataReady").aW(true).report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            nativeAdListener.onError(com.kwad.sdk.core.network.f.agm.errorCode, com.kwad.sdk.core.network.f.agm.msg);
        }
    }
}
