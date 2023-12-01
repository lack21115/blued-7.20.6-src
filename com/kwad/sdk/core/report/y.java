package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.huawei.hms.ads.hl;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bb;
import com.qq.e.comm.pi.IBidding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/y.class */
public final class y extends com.kwad.sdk.core.network.b {
    int ajV;
    private final b ajW;
    private final JSONObject ajX;
    private final AdTemplate mAdTemplate;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/y$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String ajZ;
        public int aka;
        public int akb;
        public int akc;
        public JSONObject akd;
        public int ake;
        public String templateId;
        public int ajY = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.ajY;
            if (i != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "show_live_style", i3);
            }
            JSONObject jSONObject2 = this.akd;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.akd.get(next));
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/y$b.class */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long Jm;
        public String Ts;
        public String adnName;
        public int adnType;
        public int aiQ;
        public long akA;
        public long akB;
        public int akF;
        public a akG;
        public int akH;
        public int akI;
        public String akM;
        public int akO;
        public int akP;
        public int akQ;
        public String akT;
        public int akf;
        public int akg;
        public int akh;
        public int aki;
        public String akj;
        public int akp;
        public String akq;
        public int akr;
        public int aks;
        public String aku;
        public int akv;
        public String akw;
        public String akx;
        public int aky;
        public int akz;
        public int downloadSource;
        public int jU;
        public ac.a jW;
        public double jX;
        public long uV;
        public long akk = -1;
        public int akl = -1;
        public long akm = -1;
        public int akn = -1;
        public int ako = 0;
        public String akt = "";
        public int akC = -1;
        public int akD = -1;
        public int akE = 0;
        public int akJ = -1;
        public int akK = -1;
        public int akL = -1;
        public int akN = -1;
        public int adxResult = -1;
        public int akR = -1;
        public int akS = 0;

        public final void a(j jVar) {
            if (jVar != null) {
                this.akT = jVar.wZ();
            }
        }

        public final void bx(int i) {
            if (i == 0) {
                this.akP = 1;
            } else if (i == 1) {
                this.akP = 2;
            } else if (i != 2) {
            } else {
                this.akP = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(AdTemplate adTemplate, int i, b bVar, JSONObject jSONObject) {
        this.mAdTemplate = adTemplate;
        this.ajV = i;
        this.ajW = bVar;
        this.ajX = jSONObject;
    }

    private void B(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        try {
            jSONObject2.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        putBody("extData", jSONObject2.toString());
    }

    private void a(String str, b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (bVar.akJ >= 0) {
            putBody("adOrder", bVar.akJ);
        }
        if (bVar.akK >= 0) {
            putBody("adInterstitialSource", bVar.akK);
        }
        if (!TextUtils.isEmpty(bVar.akj)) {
            putBody("adRenderArea", bVar.akj);
        }
        if (bVar.akL >= 0) {
            putBody("universeSecondAd", bVar.akL);
        }
        putBody("adxResult", bVar.adxResult);
        if (bVar.akP != 0) {
            putBody("fingerSwipeType", bVar.akP);
        }
        if (bVar.akQ != 0) {
            putBody("fingerSwipeDistance", bVar.akQ);
        }
        if (bVar.akD != -1) {
            putBody("installStatus", bVar.akD);
        }
        if (bVar.akG != null) {
            putBody("clientExtData", bVar.akG.toJson().toString());
        }
        if (bVar.akT != null) {
            putBody("clientPkFailAdInfo", bVar.akT);
        }
        if (bVar.akR != -1) {
            putBody("triggerType", bVar.akR);
        }
        if (bVar.ako != 0) {
            putBody("photoSizeStyle", bVar.ako);
        }
    }

    private void a(String str, AdTemplate adTemplate, b bVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        if (adTemplate.mInitVoiceStatus != 0) {
            putBody("initVoiceStatus", adTemplate.mInitVoiceStatus);
        }
        putBody("ecpmType", this.mAdTemplate.mBidEcpm == 0 ? 2 : 1);
        if (bVar == null) {
            return;
        }
        if (bVar.aiQ != 0) {
            putBody("adAggPageSource", bVar.aiQ);
        }
        if (TextUtils.isEmpty(bVar.Ts)) {
            return;
        }
        putBody(AssistPushConsts.MSG_TYPE_PAYLOAD, bVar.Ts);
    }

    private void b(String str, b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (bVar.jU != 0) {
            putBody("itemClickType", bVar.jU);
        }
        if (!TextUtils.isEmpty(bVar.Ts)) {
            putBody(AssistPushConsts.MSG_TYPE_PAYLOAD, bVar.Ts);
        }
        if (bVar.aiQ != 0) {
            putBody("adAggPageSource", bVar.aiQ);
        }
        if (bVar.akJ >= 0) {
            putBody("adOrder", bVar.akJ);
        }
        if (bVar.akK >= 0) {
            putBody("adInterstitialSource", bVar.akK);
        }
        if (bVar.akR != -1) {
            putBody("triggerType", bVar.akR);
        }
        if (bVar.akS != 0) {
            putBody("cardCloseType", bVar.akS);
        }
        putBody("adxResult", bVar.adxResult);
        if (bVar.jX > 0.0d) {
            putBody("splashShakeAcceleration", bVar.jX);
        }
        if (!TextUtils.isEmpty(bVar.akM)) {
            putBody("splashInteractionRotateAngle", bVar.akM);
        }
        if (bVar.akP != 0) {
            putBody("fingerSwipeType", bVar.akP);
        }
        if (bVar.akQ != 0) {
            putBody("fingerSwipeDistance", bVar.akQ);
        }
        if (bVar.uV > 0) {
            putBody("playedDuration", bVar.uV);
        }
        if (bVar.akI > 0) {
            putBody("playedRate", bVar.akI);
        }
        if (bVar.akT != null) {
            putBody("clientPkFailAdInfo", bVar.akT);
        }
        if (bVar.akn != -1) {
            putBody("retainCodeType", bVar.akn);
        }
        if (bVar.akG != null) {
            putBody("clientExtData", bVar.akG.toJson().toString());
        }
        if (bVar.ako != 0) {
            putBody("photoSizeStyle", bVar.ako);
        }
    }

    private void c(String str, b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (bVar.akh != 0) {
            putBody("itemCloseType", bVar.akh);
        }
        if (bVar.akf > 0) {
            putBody("photoPlaySecond", bVar.akf);
        }
        if (bVar.akg != 0) {
            putBody("awardReceiveStage", bVar.akg);
        }
        if (bVar.aki != 0) {
            putBody("elementType", bVar.aki);
        }
        if (!TextUtils.isEmpty(bVar.Ts)) {
            putBody(AssistPushConsts.MSG_TYPE_PAYLOAD, bVar.Ts);
        }
        if (bVar.akG != null) {
            putBody("clientExtData", bVar.akG.toJson().toString());
        }
        if (bVar.akp > 0) {
            putBody("deeplinkType", bVar.akp);
        }
        if (!TextUtils.isEmpty(bVar.akq)) {
            putBody("deeplinkAppName", bVar.akq);
        }
        if (bVar.akr != 0) {
            putBody("deeplinkFailedReason", bVar.akr);
        }
        if (bVar.downloadSource > 0) {
            putBody(hl.I, bVar.downloadSource);
        }
        if (bVar.akS != 0) {
            putBody("cardCloseType", bVar.akS);
        }
        if (bVar.aks > 0) {
            putBody("isPackageChanged", bVar.aks);
        }
        putBody("installedFrom", bVar.akt);
        putBody("isChangedEndcard", bVar.akv);
        if (bVar.aiQ != 0) {
            putBody("adAggPageSource", bVar.aiQ);
        }
        if (bVar.aku != null) {
            putBody("downloadFailedReason", bVar.aku);
        }
        if (!bb.isNullString(bVar.akx)) {
            putBody("installedPackageName", bVar.akx);
        }
        if (!bb.isNullString(bVar.akw)) {
            putBody("serverPackageName", bVar.akw);
        }
        if (bVar.akz > 0) {
            putBody("closeButtonClickTime", bVar.akz);
        }
        if (bVar.aky > 0) {
            putBody("closeButtonImpressionTime", bVar.aky);
        }
        if (bVar.akE >= 0) {
            putBody("downloadStatus", bVar.akE);
        }
        if (bVar.akA > 0) {
            putBody("landingPageLoadedDuration", bVar.akA);
        }
        if (bVar.Jm > 0) {
            putBody("leaveTime", bVar.Jm);
        }
        if (bVar.akB > 0) {
            putBody("adItemClickBackDuration", bVar.akB);
        }
        if (bVar.akn != -1) {
            putBody("retainCodeType", bVar.akn);
        }
        if (bVar.akk > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, bVar.akk);
        }
        if (bVar.akl >= 0) {
            putBody("impFailReason", bVar.akl);
        }
        if (bVar.akm > -1) {
            putBody("winEcpm", bVar.akm);
        }
        if (bVar.adnType > 0) {
            putBody("adnType", bVar.adnType);
        }
        if (!TextUtils.isEmpty(bVar.adnName)) {
            putBody("adnName", bVar.adnName);
        }
        putBody("downloadCardType", bVar.akF);
        putBody("landingPageType", bVar.akH);
        if (bVar.akK >= 0) {
            putBody("adInterstitialSource", bVar.akK);
        }
        if (bVar.akN > 0) {
            putBody("downloadInstallType", bVar.akN);
        }
        if (bVar.akP != 0) {
            putBody("fingerSwipeType", bVar.akP);
        }
        if (bVar.akQ != 0) {
            putBody("fingerSwipeDistance", bVar.akQ);
        }
        if (bVar.akO > 0) {
            putBody("businessSceneType", bVar.akO);
        }
        if (bVar.uV > 0) {
            putBody("playedDuration", bVar.uV);
        }
        if (bVar.akI > 0) {
            putBody("playedRate", bVar.akI);
        }
        if (bVar.akC != -1) {
            putBody("appStorePageType", bVar.akC);
        }
        if (bVar.akR != -1) {
            putBody("triggerType", bVar.akR);
        }
        if (bVar.ako != 0) {
            putBody("photoSizeStyle", bVar.ako);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public final int getActionType() {
        return this.ajV;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        String replaceFirst;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int i = this.ajV;
        if (i == 1) {
            replaceFirst = cb.adBaseInfo.showUrl.replaceFirst("__PR__", (this.mAdTemplate.mBidEcpm == 0 && ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sF()) ? String.valueOf(com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) : String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.ajW);
        } else {
            AdInfo.AdBaseInfo adBaseInfo = cb.adBaseInfo;
            if (i != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(this.ajV)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
                c(replaceFirst, this.ajW);
                B(this.ajX);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            String str2 = str;
            if (this.ajW != null) {
                ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                str2 = ac.a(str, this.ajW.jW);
            }
            replaceFirst = ac.ag(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), str2).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.ajW);
        }
        a(replaceFirst, this.mAdTemplate, this.ajW);
        B(this.ajX);
        return replaceFirst;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> xm() {
        AdInfo.AdTrackInfo adTrackInfo;
        ArrayList arrayList = new ArrayList();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (!cb.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = cb.adTrackInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.ajV && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                ac.a aVar = null;
                if (adTrackInfo.type == 2) {
                    b bVar = this.ajW;
                    aVar = null;
                    if (bVar != null) {
                        aVar = bVar.jW;
                    }
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(ab.a(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), str, aVar, com.kwad.sdk.core.response.a.a.at(cb)));
                }
            }
        }
        return arrayList;
    }
}
