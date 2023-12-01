package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import com.kwad.components.core.n.kwai.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/adbit/c.class */
public final class c {
    private static <T extends com.kwad.components.core.n.a> T a(com.kwad.sdk.e.c<T> cVar) {
        return cVar.get();
    }

    private static AdTemplate a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == d.cl(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        final com.kwad.components.core.n.kwai.a pj = new a.C0527a().e(new com.kwad.components.core.n.kwai.b(sceneImpl)).a(new com.kwad.components.core.n.c()).pj();
        b bVar = (b) a(new com.kwad.sdk.e.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.c
            /* renamed from: ae */
            public b get() {
                return new b(com.kwad.components.core.n.kwai.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).ad();
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate a2;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0 && (a2 = a(adBitResultData2, adBid.creativeId)) != null) {
                a2.mBidEcpm = adBid.bidEcpm;
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private static void a(String str, com.kwad.components.core.n.kwai.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.JW.Ow);
            adBitResultData.parseJson(jSONObject);
            List<String> a2 = a(adBitResultData);
            if (a2.isEmpty()) {
                com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? f.agn.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(a2, adBitResultData, aVar);
            }
        } catch (Exception e) {
            com.kwad.components.core.n.kwai.a.a(aVar, f.agm.errorCode, f.agm.msg, false);
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    private static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.n.kwai.a aVar) {
        new m<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: ag */
            public com.kwad.components.ad.kwai.b createRequest() {
                return new com.kwad.components.ad.kwai.b(adBitResultData.adxId, list);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m
            /* renamed from: r */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.n.kwai.a.this.JW.Ow);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new p<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            private void b(int i, String str) {
                com.kwad.components.core.n.kwai.a.a(aVar, i, str, false);
            }

            private void c(AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData2.testErrorMsg) ? f.agn.msg : adBitResultData2.testErrorMsg, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i = aVar.JW.Ow.adStyle;
                if (i == 10000 || i == d.bV(adTemplate)) {
                    com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData2, false);
                } else {
                    com.kwad.components.core.n.kwai.a.a(aVar, f.agr.errorCode, f.agr.msg, false);
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(g gVar, int i, String str) {
                b(i, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate a2;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0 && (a2 = a(adBitResultData, adBid.creativeId)) != null) {
                a2.mBidEcpm = adBid.bidEcpm;
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static boolean b(final com.kwad.components.core.n.kwai.a aVar) {
        String bidResponseV2 = aVar.JW.Ow.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.JW.Ow.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject(String.this);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.JW.Ow);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? f.agn.msg : adBitResultData.testErrorMsg, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.JW.Ow.getAdStyle();
                    if (adStyle == 10000 || adStyle == d.bV(adTemplate)) {
                        com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData, true);
                    } else {
                        com.kwad.components.core.n.kwai.a.a(aVar, f.agr.errorCode, f.agr.msg, true);
                    }
                } catch (Exception e) {
                    com.kwad.components.core.n.kwai.a.a(aVar, f.agm.errorCode, f.agm.msg, true);
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.n.kwai.a pj = new a.C0527a().e(new com.kwad.components.core.n.kwai.b(SceneImpl.covert(ksScene))).a(new com.kwad.components.core.n.c()).pj();
        com.kwad.components.ad.kwai.a aVar = (com.kwad.components.ad.kwai.a) a(new com.kwad.sdk.e.c<com.kwad.components.ad.kwai.a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.c
            /* renamed from: af */
            public com.kwad.components.ad.kwai.a get() {
                return new com.kwad.components.ad.kwai.a(com.kwad.components.core.n.kwai.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).ad();
    }
}
