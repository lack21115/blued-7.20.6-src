package com.kwad.sdk.core.a.kwai;

import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.core.report.y;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bk.class */
public final class bk implements com.kwad.sdk.core.d<y.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.akf = jSONObject.optInt("photoPlaySecond");
        bVar.akg = jSONObject.optInt("awardReceiveStage");
        bVar.jU = jSONObject.optInt("itemClickType");
        bVar.akh = jSONObject.optInt("itemCloseType");
        bVar.aki = jSONObject.optInt("elementType");
        bVar.akj = jSONObject.optString("adRenderArea");
        if (bVar.akj == JSONObject.NULL) {
            bVar.akj = "";
        }
        bVar.akk = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        bVar.akl = jSONObject.optInt("impFailReason");
        bVar.akm = jSONObject.optLong("winEcpm");
        bVar.adnType = jSONObject.optInt("adnType");
        bVar.adnName = jSONObject.optString("adnName");
        if (bVar.adnName == JSONObject.NULL) {
            bVar.adnName = "";
        }
        bVar.akn = jSONObject.optInt("retainCodeType");
        bVar.ako = jSONObject.optInt("photoSizeStyle");
        bVar.Ts = jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD);
        if (bVar.Ts == JSONObject.NULL) {
            bVar.Ts = "";
        }
        bVar.akp = jSONObject.optInt("deeplinkType");
        bVar.akq = jSONObject.optString("deeplinkAppName");
        if (bVar.akq == JSONObject.NULL) {
            bVar.akq = "";
        }
        bVar.akr = jSONObject.optInt("deeplinkFailedReason");
        bVar.downloadSource = jSONObject.optInt(com.huawei.hms.ads.hl.I);
        bVar.aks = jSONObject.optInt("isPackageChanged");
        bVar.akt = jSONObject.optString("installedFrom");
        if (bVar.akt == JSONObject.NULL) {
            bVar.akt = "";
        }
        bVar.aku = jSONObject.optString("downloadFailedReason");
        if (bVar.aku == JSONObject.NULL) {
            bVar.aku = "";
        }
        bVar.akv = jSONObject.optInt("isChangedEndcard");
        bVar.aiQ = jSONObject.optInt("adAggPageSource");
        bVar.akw = jSONObject.optString("serverPackageName");
        if (bVar.akw == JSONObject.NULL) {
            bVar.akw = "";
        }
        bVar.akx = jSONObject.optString("installedPackageName");
        if (bVar.akx == JSONObject.NULL) {
            bVar.akx = "";
        }
        bVar.aky = jSONObject.optInt("closeButtonImpressionTime");
        bVar.akz = jSONObject.optInt("closeButtonClickTime");
        bVar.akA = jSONObject.optLong("landingPageLoadedDuration");
        bVar.Jm = jSONObject.optLong("leaveTime");
        bVar.akB = jSONObject.optLong("adItemClickBackDuration");
        bVar.akC = jSONObject.optInt("appStorePageType");
        bVar.akD = jSONObject.optInt("installStatus");
        bVar.akE = jSONObject.optInt("downloadStatus");
        bVar.akF = jSONObject.optInt("downloadCardType");
        bVar.akG = new y.a();
        bVar.akG.parseJson(jSONObject.optJSONObject("clientExtData"));
        bVar.akH = jSONObject.optInt("landingPageType");
        bVar.uV = jSONObject.optLong("playedDuration");
        bVar.akI = jSONObject.optInt("playedRate");
        bVar.akJ = jSONObject.optInt("adOrder");
        bVar.akK = jSONObject.optInt("adInterstitialSource");
        bVar.jX = jSONObject.optDouble("splashShakeAcceleration");
        bVar.akL = jSONObject.optInt("universeSecondAd");
        bVar.akM = jSONObject.optString("splashInteractionRotateAngle");
        if (bVar.akM == JSONObject.NULL) {
            bVar.akM = "";
        }
        bVar.akN = jSONObject.optInt("downloadInstallType");
        bVar.akO = jSONObject.optInt("businessSceneType");
        bVar.adxResult = jSONObject.optInt("adxResult");
        bVar.akP = jSONObject.optInt("fingerSwipeType");
        bVar.akQ = jSONObject.optInt("fingerSwipeDistance");
        bVar.akR = jSONObject.optInt("triggerType");
        bVar.akS = jSONObject.optInt("cardCloseType");
        bVar.akT = jSONObject.optString("clientPkFailAdInfo");
        if (bVar.akT == JSONObject.NULL) {
            bVar.akT = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(y.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.akf != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoPlaySecond", bVar.akf);
        }
        if (bVar.akg != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "awardReceiveStage", bVar.akg);
        }
        if (bVar.jU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "itemClickType", bVar.jU);
        }
        if (bVar.akh != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "itemCloseType", bVar.akh);
        }
        if (bVar.aki != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "elementType", bVar.aki);
        }
        if (bVar.akj != null && !bVar.akj.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adRenderArea", bVar.akj);
        }
        if (bVar.akk != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, IBidding.HIGHEST_LOSS_PRICE, bVar.akk);
        }
        if (bVar.akl != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "impFailReason", bVar.akl);
        }
        if (bVar.akm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "winEcpm", bVar.akm);
        }
        if (bVar.adnType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adnType", bVar.adnType);
        }
        if (bVar.adnName != null && !bVar.adnName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adnName", bVar.adnName);
        }
        if (bVar.akn != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "retainCodeType", bVar.akn);
        }
        if (bVar.ako != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoSizeStyle", bVar.ako);
        }
        if (bVar.Ts != null && !bVar.Ts.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AssistPushConsts.MSG_TYPE_PAYLOAD, bVar.Ts);
        }
        if (bVar.akp != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deeplinkType", bVar.akp);
        }
        if (bVar.akq != null && !bVar.akq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deeplinkAppName", bVar.akq);
        }
        if (bVar.akr != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deeplinkFailedReason", bVar.akr);
        }
        if (bVar.downloadSource != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.huawei.hms.ads.hl.I, bVar.downloadSource);
        }
        if (bVar.aks != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isPackageChanged", bVar.aks);
        }
        if (bVar.akt != null && !bVar.akt.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "installedFrom", bVar.akt);
        }
        if (bVar.aku != null && !bVar.aku.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadFailedReason", bVar.aku);
        }
        if (bVar.akv != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isChangedEndcard", bVar.akv);
        }
        if (bVar.aiQ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adAggPageSource", bVar.aiQ);
        }
        if (bVar.akw != null && !bVar.akw.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "serverPackageName", bVar.akw);
        }
        if (bVar.akx != null && !bVar.akx.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "installedPackageName", bVar.akx);
        }
        if (bVar.aky != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "closeButtonImpressionTime", bVar.aky);
        }
        if (bVar.akz != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "closeButtonClickTime", bVar.akz);
        }
        if (bVar.akA != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "landingPageLoadedDuration", bVar.akA);
        }
        if (bVar.Jm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "leaveTime", bVar.Jm);
        }
        if (bVar.akB != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adItemClickBackDuration", bVar.akB);
        }
        if (bVar.akC != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appStorePageType", bVar.akC);
        }
        if (bVar.akD != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "installStatus", bVar.akD);
        }
        if (bVar.akE != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadStatus", bVar.akE);
        }
        if (bVar.akF != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadCardType", bVar.akF);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "clientExtData", bVar.akG);
        if (bVar.akH != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "landingPageType", bVar.akH);
        }
        if (bVar.uV != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playedDuration", bVar.uV);
        }
        if (bVar.akI != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playedRate", bVar.akI);
        }
        if (bVar.akJ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adOrder", bVar.akJ);
        }
        if (bVar.akK != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adInterstitialSource", bVar.akK);
        }
        if (bVar.jX != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "splashShakeAcceleration", bVar.jX);
        }
        if (bVar.akL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "universeSecondAd", bVar.akL);
        }
        if (bVar.akM != null && !bVar.akM.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "splashInteractionRotateAngle", bVar.akM);
        }
        if (bVar.akN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadInstallType", bVar.akN);
        }
        if (bVar.akO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "businessSceneType", bVar.akO);
        }
        if (bVar.adxResult != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adxResult", bVar.adxResult);
        }
        if (bVar.akP != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fingerSwipeType", bVar.akP);
        }
        if (bVar.akQ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fingerSwipeDistance", bVar.akQ);
        }
        if (bVar.akR != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "triggerType", bVar.akR);
        }
        if (bVar.akS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardCloseType", bVar.akS);
        }
        if (bVar.akT != null && !bVar.akT.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "clientPkFailAdInfo", bVar.akT);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
