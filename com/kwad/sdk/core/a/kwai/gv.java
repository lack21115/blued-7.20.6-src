package com.kwad.sdk.core.a.kwai;

import android.accounts.AccountManager;
import android.provider.BrowserContract;
import android.provider.Downloads;
import android.speech.tts.TextToSpeech;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.scene.URLPackage;
import com.oplus.quickgame.sdk.hall.Constant;
import com.opos.mobad.activity.VideoActivity;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gv.class */
public final class gv implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.q> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.timestamp = jSONObject.optLong("timestamp");
        qVar.sessionId = jSONObject.optString(TextToSpeech.Engine.KEY_PARAM_SESSION_ID);
        if (qVar.sessionId == JSONObject.NULL) {
            qVar.sessionId = "";
        }
        qVar.Ht = jSONObject.optLong("seq");
        qVar.aiF = jSONObject.optLong("listId");
        qVar.aiG = jSONObject.optLong(VideoActivity.EXTRA_KEY_ACTION_TYPE);
        qVar.Ts = jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD);
        if (qVar.Ts == JSONObject.NULL) {
            qVar.Ts = "";
        }
        qVar.llsid = jSONObject.optLong("llsid");
        qVar.aiH = jSONObject.optJSONObject("extra");
        qVar.aiI = jSONObject.optJSONObject("impAdExtra");
        qVar.posId = jSONObject.optLong("posId");
        qVar.contentType = jSONObject.optInt("contentType");
        qVar.realShowType = jSONObject.optInt("realShowType");
        qVar.photoId = jSONObject.optLong("photoId");
        qVar.position = jSONObject.optLong(BrowserContract.Bookmarks.POSITION);
        qVar.aiJ = jSONObject.optLong("serverPosition");
        qVar.aiK = jSONObject.optLong("photoDuration");
        qVar.aiL = jSONObject.optLong("effectivePlayDuration");
        qVar.Vl = jSONObject.optLong("playDuration");
        qVar.blockDuration = jSONObject.optLong("blockDuration");
        qVar.aiM = jSONObject.optLong("intervalDuration");
        qVar.aiN = jSONObject.optLong("allIntervalDuration");
        qVar.aiO = jSONObject.optLong("flowSdk");
        qVar.aiP = jSONObject.optLong("blockTimes");
        qVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        qVar.aiQ = jSONObject.optInt("adAggPageSource");
        qVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (qVar.entryPageSource == JSONObject.NULL) {
            qVar.entryPageSource = "";
        }
        qVar.urlPackage = new URLPackage();
        qVar.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        qVar.aiR = new URLPackage();
        qVar.aiR.parseJson(jSONObject.optJSONObject("referURLPackage"));
        qVar.Pa = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        qVar.aiS = jSONObject.optString("photoSize");
        if (qVar.aiS == JSONObject.NULL) {
            qVar.aiS = "";
        }
        qVar.aiT = jSONObject.optJSONArray("appInstalled");
        qVar.aiU = jSONObject.optJSONArray("appUninstalled");
        qVar.aiV = new q.a();
        qVar.aiV.parseJson(jSONObject.optJSONObject("clientExt"));
        qVar.aiW = jSONObject.optInt("playerType");
        qVar.aiX = jSONObject.optInt(WbCloudFaceContant.CUSTOMER_TIPS_LOC);
        qVar.aiY = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        qVar.Tt = jSONObject.optInt("refreshType");
        qVar.aiZ = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        qVar.failUrl = jSONObject.optString("failUrl");
        if (qVar.failUrl == JSONObject.NULL) {
            qVar.failUrl = "";
        }
        qVar.errorMsg = jSONObject.optString(Downloads.Impl.COLUMN_ERROR_MSG);
        if (qVar.errorMsg == JSONObject.NULL) {
            qVar.errorMsg = "";
        }
        qVar.errorCode = jSONObject.optInt(AccountManager.KEY_ERROR_CODE, new Integer("0").intValue());
        qVar.creativeId = jSONObject.optLong("creativeId");
        qVar.ajc = jSONObject.optString("cacheFailedReason");
        if (qVar.ajc == JSONObject.NULL) {
            qVar.ajc = "";
        }
        qVar.ajd = jSONObject.optJSONObject("appExt");
        qVar.aje = jSONObject.optJSONArray("appRunningInfoList");
        qVar.downloadDuration = jSONObject.optLong("downloadDuration");
        qVar.pageType = jSONObject.optInt(Constant.Param.KEY_RPK_PAGE_TYPE, new Integer("0").intValue());
        qVar.ajf = jSONObject.optInt("speedLimitStatus");
        qVar.ajg = jSONObject.optInt("speedLimitThreshold");
        qVar.ajh = jSONObject.optInt("currentRealDownloadSpeed");
        qVar.ajj = jSONObject.optJSONArray("sdkPlatform");
        qVar.ajk = jSONObject.optBoolean("isKsUnion");
        qVar.ajl = jSONObject.optString("trackMethodName");
        if (qVar.ajl == JSONObject.NULL) {
            qVar.ajl = "";
        }
        qVar.ajm = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        qVar.clickTime = jSONObject.optLong("clickTime");
        qVar.ajo = jSONObject.optLong("frameRenderTime");
        qVar.ajp = jSONObject.optInt("playerEnterAction");
        qVar.ajq = jSONObject.optString("requestUrl");
        if (qVar.ajq == JSONObject.NULL) {
            qVar.ajq = "";
        }
        qVar.ajr = jSONObject.optLong("requestTotalTime");
        qVar.ajs = jSONObject.optLong("requestResponseTime");
        qVar.ajt = jSONObject.optLong("requestParseDataTime");
        qVar.aju = jSONObject.optLong("requestCallbackTime");
        qVar.ajv = jSONObject.optString("requestFailReason");
        if (qVar.ajv == JSONObject.NULL) {
            qVar.ajv = "";
        }
        qVar.NY = jSONObject.optString("pageName");
        if (qVar.NY == JSONObject.NULL) {
            qVar.NY = "";
        }
        qVar.Of = jSONObject.optLong("pageCreateTime");
        qVar.Og = jSONObject.optLong("pageResumeTime");
        qVar.ajw = jSONObject.optInt("trackUrlType");
        qVar.ajx = jSONObject.optJSONArray("trackUrlList");
        qVar.Oe = jSONObject.optLong("pageLaunchTime");
        qVar.ajA = jSONObject.optJSONArray("appAuthorityInfoList");
        qVar.ajB = jSONObject.optString("tkVersion");
        if (qVar.ajB == JSONObject.NULL) {
            qVar.ajB = "";
        }
        qVar.ajC = jSONObject.optString("jsVersion");
        if (qVar.ajC == JSONObject.NULL) {
            qVar.ajC = "";
        }
        qVar.ajD = jSONObject.optString("jsFileName");
        if (qVar.ajD == JSONObject.NULL) {
            qVar.ajD = "";
        }
        qVar.ajE = jSONObject.optString("jsErrorMsg");
        if (qVar.ajE == JSONObject.NULL) {
            qVar.ajE = "";
        }
        qVar.ajF = jSONObject.optString("jsConfig");
        if (qVar.ajF == JSONObject.NULL) {
            qVar.ajF = "";
        }
        qVar.ajG = jSONObject.optInt("adBizType");
        qVar.ajH = jSONObject.optString("customKey");
        if (qVar.ajH == JSONObject.NULL) {
            qVar.ajH = "";
        }
        qVar.ajI = jSONObject.optString("customValue");
        if (qVar.ajI == JSONObject.NULL) {
            qVar.ajI = "";
        }
        qVar.trace = jSONObject.optString("trace");
        if (qVar.trace == JSONObject.NULL) {
            qVar.trace = "";
        }
        qVar.ajJ = jSONObject.optInt("filterCode");
        qVar.ajK = jSONObject.optInt("sdkVersionCode");
        qVar.sdkVersion = jSONObject.optString("sdkVersion");
        if (qVar.sdkVersion == JSONObject.NULL) {
            qVar.sdkVersion = "";
        }
        qVar.SM = jSONObject.optString("sdkApiVersion");
        if (qVar.SM == JSONObject.NULL) {
            qVar.SM = "";
        }
        qVar.SO = jSONObject.optInt("sdkType");
        qVar.ajL = jSONObject.optLong("appUseDuration");
        qVar.ajM = jSONObject.optLong("appStartType");
        qVar.aeM = jSONObject.optLong("sequenceNumber");
        qVar.Hq = jSONObject.optString("appColdStart");
        if (qVar.Hq == JSONObject.NULL) {
            qVar.Hq = "";
        }
        qVar.Hr = jSONObject.optString("appStart");
        if (qVar.Hr == JSONObject.NULL) {
            qVar.Hr = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (qVar.timestamp != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "timestamp", qVar.timestamp);
        }
        if (qVar.sessionId != null && !qVar.sessionId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, TextToSpeech.Engine.KEY_PARAM_SESSION_ID, qVar.sessionId);
        }
        if (qVar.Ht != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "seq", qVar.Ht);
        }
        if (qVar.aiF != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "listId", qVar.aiF);
        }
        if (qVar.aiG != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, VideoActivity.EXTRA_KEY_ACTION_TYPE, qVar.aiG);
        }
        if (qVar.Ts != null && !qVar.Ts.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AssistPushConsts.MSG_TYPE_PAYLOAD, qVar.Ts);
        }
        if (qVar.llsid != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "llsid", qVar.llsid);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "extra", qVar.aiH);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "impAdExtra", qVar.aiI);
        if (qVar.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "posId", qVar.posId);
        }
        if (qVar.contentType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "contentType", qVar.contentType);
        }
        if (qVar.realShowType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "realShowType", qVar.realShowType);
        }
        if (qVar.photoId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoId", qVar.photoId);
        }
        if (qVar.position != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, BrowserContract.Bookmarks.POSITION, qVar.position);
        }
        if (qVar.aiJ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "serverPosition", qVar.aiJ);
        }
        if (qVar.aiK != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoDuration", qVar.aiK);
        }
        if (qVar.aiL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "effectivePlayDuration", qVar.aiL);
        }
        if (qVar.Vl != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playDuration", qVar.Vl);
        }
        if (qVar.blockDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "blockDuration", qVar.blockDuration);
        }
        if (qVar.aiM != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "intervalDuration", qVar.aiM);
        }
        if (qVar.aiN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "allIntervalDuration", qVar.aiN);
        }
        if (qVar.aiO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "flowSdk", qVar.aiO);
        }
        if (qVar.aiP != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "blockTimes", qVar.aiP);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "contentSourceType", qVar.contentSourceType);
        if (qVar.aiQ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adAggPageSource", qVar.aiQ);
        }
        if (qVar.entryPageSource != null && !qVar.entryPageSource.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "entryPageSource", qVar.entryPageSource);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "urlPackage", qVar.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject2, "referURLPackage", qVar.aiR);
        if (qVar.Pa != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, URLPackage.KEY_AUTHOR_ID, qVar.Pa);
        }
        if (qVar.aiS != null && !qVar.aiS.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoSize", qVar.aiS);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appInstalled", qVar.aiT);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appUninstalled", qVar.aiU);
        com.kwad.sdk.utils.t.a(jSONObject2, "clientExt", qVar.aiV);
        if (qVar.aiW != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playerType", qVar.aiW);
        }
        if (qVar.aiX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, WbCloudFaceContant.CUSTOMER_TIPS_LOC, qVar.aiX);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "isLeftSlipStatus", qVar.aiY);
        if (qVar.Tt != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "refreshType", qVar.Tt);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "photoResponseType", qVar.aiZ);
        if (qVar.failUrl != null && !qVar.failUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "failUrl", qVar.failUrl);
        }
        if (qVar.errorMsg != null && !qVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, Downloads.Impl.COLUMN_ERROR_MSG, qVar.errorMsg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, AccountManager.KEY_ERROR_CODE, qVar.errorCode);
        if (qVar.creativeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "creativeId", qVar.creativeId);
        }
        if (qVar.ajc != null && !qVar.ajc.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cacheFailedReason", qVar.ajc);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appExt", qVar.ajd);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appRunningInfoList", qVar.aje);
        if (qVar.downloadDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadDuration", qVar.downloadDuration);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, Constant.Param.KEY_RPK_PAGE_TYPE, qVar.pageType);
        if (qVar.ajf != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "speedLimitStatus", qVar.ajf);
        }
        if (qVar.ajg != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "speedLimitThreshold", qVar.ajg);
        }
        if (qVar.ajh != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentRealDownloadSpeed", qVar.ajh);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkPlatform", qVar.ajj);
        if (qVar.ajk) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isKsUnion", qVar.ajk);
        }
        if (qVar.ajl != null && !qVar.ajl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "trackMethodName", qVar.ajl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "viewModeType", qVar.ajm);
        if (qVar.clickTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "clickTime", qVar.clickTime);
        }
        if (qVar.ajo != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "frameRenderTime", qVar.ajo);
        }
        if (qVar.ajp != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playerEnterAction", qVar.ajp);
        }
        if (qVar.ajq != null && !qVar.ajq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestUrl", qVar.ajq);
        }
        if (qVar.ajr != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestTotalTime", qVar.ajr);
        }
        if (qVar.ajs != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestResponseTime", qVar.ajs);
        }
        if (qVar.ajt != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestParseDataTime", qVar.ajt);
        }
        if (qVar.aju != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestCallbackTime", qVar.aju);
        }
        if (qVar.ajv != null && !qVar.ajv.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestFailReason", qVar.ajv);
        }
        if (qVar.NY != null && !qVar.NY.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pageName", qVar.NY);
        }
        if (qVar.Of != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pageCreateTime", qVar.Of);
        }
        if (qVar.Og != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pageResumeTime", qVar.Og);
        }
        if (qVar.ajw != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "trackUrlType", qVar.ajw);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "trackUrlList", qVar.ajx);
        if (qVar.Oe != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pageLaunchTime", qVar.Oe);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appAuthorityInfoList", qVar.ajA);
        if (qVar.ajB != null && !qVar.ajB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "tkVersion", qVar.ajB);
        }
        if (qVar.ajC != null && !qVar.ajC.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "jsVersion", qVar.ajC);
        }
        if (qVar.ajD != null && !qVar.ajD.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "jsFileName", qVar.ajD);
        }
        if (qVar.ajE != null && !qVar.ajE.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "jsErrorMsg", qVar.ajE);
        }
        if (qVar.ajF != null && !qVar.ajF.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "jsConfig", qVar.ajF);
        }
        if (qVar.ajG != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adBizType", qVar.ajG);
        }
        if (qVar.ajH != null && !qVar.ajH.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "customKey", qVar.ajH);
        }
        if (qVar.ajI != null && !qVar.ajI.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "customValue", qVar.ajI);
        }
        if (qVar.trace != null && !qVar.trace.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "trace", qVar.trace);
        }
        if (qVar.ajJ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "filterCode", qVar.ajJ);
        }
        if (qVar.ajK != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkVersionCode", qVar.ajK);
        }
        if (qVar.sdkVersion != null && !qVar.sdkVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkVersion", qVar.sdkVersion);
        }
        if (qVar.SM != null && !qVar.SM.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersion", qVar.SM);
        }
        if (qVar.SO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkType", qVar.SO);
        }
        if (qVar.ajL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appUseDuration", qVar.ajL);
        }
        if (qVar.ajM != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appStartType", qVar.ajM);
        }
        if (qVar.aeM != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sequenceNumber", qVar.aeM);
        }
        if (qVar.Hq != null && !qVar.Hq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appColdStart", qVar.Hq);
        }
        if (qVar.Hr != null && !qVar.Hr.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appStart", qVar.Hr);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
