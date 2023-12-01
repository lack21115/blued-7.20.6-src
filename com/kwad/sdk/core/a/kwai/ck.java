package com.kwad.sdk.core.a.kwai;

import com.anythink.pd.ExHandler;
import com.tencent.tendinsv.a.b;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ck.class */
public final class ck implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.adV = jSONObject.optString(ExHandler.JSON_REQUEST_IMEI);
        if (bVar.adV == JSONObject.NULL) {
            bVar.adV = "";
        }
        bVar.ala = jSONObject.optString("imei1");
        if (bVar.ala == JSONObject.NULL) {
            bVar.ala = "";
        }
        bVar.alb = jSONObject.optString("imei2");
        if (bVar.alb == JSONObject.NULL) {
            bVar.alb = "";
        }
        bVar.alc = jSONObject.optString("meid");
        if (bVar.alc == JSONObject.NULL) {
            bVar.alc = "";
        }
        bVar.adW = jSONObject.optString("oaid");
        if (bVar.adW == JSONObject.NULL) {
            bVar.adW = "";
        }
        bVar.ald = jSONObject.optString("appMkt");
        if (bVar.ald == JSONObject.NULL) {
            bVar.ald = "";
        }
        bVar.ale = jSONObject.optString("appMktParam");
        if (bVar.ale == JSONObject.NULL) {
            bVar.ale = "";
        }
        bVar.OK = jSONObject.optString("romName");
        if (bVar.OK == JSONObject.NULL) {
            bVar.OK = "";
        }
        bVar.SS = jSONObject.optInt("osType");
        bVar.SU = jSONObject.optInt("osApi");
        bVar.alf = jSONObject.optString(b.a.l);
        if (bVar.alf == JSONObject.NULL) {
            bVar.alf = "";
        }
        bVar.SV = jSONObject.optString("language");
        if (bVar.SV == JSONObject.NULL) {
            bVar.SV = "";
        }
        bVar.SX = jSONObject.optInt("screenWidth");
        bVar.SY = jSONObject.optInt("screenHeight");
        bVar.alg = jSONObject.optInt("deviceWidth");
        bVar.alh = jSONObject.optInt("deviceHeight");
        bVar.ali = jSONObject.optString("androidId");
        if (bVar.ali == JSONObject.NULL) {
            bVar.ali = "";
        }
        bVar.alj = jSONObject.optString("deviceId");
        if (bVar.alj == JSONObject.NULL) {
            bVar.alj = "";
        }
        bVar.alk = jSONObject.optString("deviceVendor");
        if (bVar.alk == JSONObject.NULL) {
            bVar.alk = "";
        }
        bVar.all = jSONObject.optInt("platform");
        bVar.alm = jSONObject.optString("deviceModel");
        if (bVar.alm == JSONObject.NULL) {
            bVar.alm = "";
        }
        bVar.SR = jSONObject.optString("deviceBrand");
        if (bVar.SR == JSONObject.NULL) {
            bVar.SR = "";
        }
        bVar.aln = jSONObject.optString("deviceSig");
        if (bVar.aln == JSONObject.NULL) {
            bVar.aln = "";
        }
        bVar.alo = jSONObject.optString("eGid");
        if (bVar.alo == JSONObject.NULL) {
            bVar.alo = "";
        }
        bVar.alp = jSONObject.optJSONArray("appPackageName");
        bVar.alq = jSONObject.optString("arch");
        if (bVar.alq == JSONObject.NULL) {
            bVar.alq = "";
        }
        bVar.alr = jSONObject.optInt("screenDirection");
        bVar.als = jSONObject.optString("kwaiVersionName");
        if (bVar.als == JSONObject.NULL) {
            bVar.als = "";
        }
        bVar.alt = jSONObject.optString("kwaiNebulaVersionName");
        if (bVar.alt == JSONObject.NULL) {
            bVar.alt = "";
        }
        bVar.alu = jSONObject.optString("wechatVersionName");
        if (bVar.alu == JSONObject.NULL) {
            bVar.alu = "";
        }
        bVar.alv = jSONObject.optLong("sourceFlag");
        bVar.alw = jSONObject.optString("systemBootTime");
        if (bVar.alw == JSONObject.NULL) {
            bVar.alw = "";
        }
        bVar.alx = jSONObject.optString("systemUpdateTime");
        if (bVar.alx == JSONObject.NULL) {
            bVar.alx = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.adV != null && !bVar.adV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, ExHandler.JSON_REQUEST_IMEI, bVar.adV);
        }
        if (bVar.ala != null && !bVar.ala.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "imei1", bVar.ala);
        }
        if (bVar.alb != null && !bVar.alb.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "imei2", bVar.alb);
        }
        if (bVar.alc != null && !bVar.alc.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "meid", bVar.alc);
        }
        if (bVar.adW != null && !bVar.adW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "oaid", bVar.adW);
        }
        if (bVar.ald != null && !bVar.ald.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appMkt", bVar.ald);
        }
        if (bVar.ale != null && !bVar.ale.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appMktParam", bVar.ale);
        }
        if (bVar.OK != null && !bVar.OK.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "romName", bVar.OK);
        }
        if (bVar.SS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osType", bVar.SS);
        }
        if (bVar.SU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osApi", bVar.SU);
        }
        if (bVar.alf != null && !bVar.alf.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, b.a.l, bVar.alf);
        }
        if (bVar.SV != null && !bVar.SV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "language", bVar.SV);
        }
        if (bVar.SX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenWidth", bVar.SX);
        }
        if (bVar.SY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenHeight", bVar.SY);
        }
        if (bVar.alg != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceWidth", bVar.alg);
        }
        if (bVar.alh != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceHeight", bVar.alh);
        }
        if (bVar.ali != null && !bVar.ali.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "androidId", bVar.ali);
        }
        if (bVar.alj != null && !bVar.alj.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceId", bVar.alj);
        }
        if (bVar.alk != null && !bVar.alk.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceVendor", bVar.alk);
        }
        if (bVar.all != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "platform", bVar.all);
        }
        if (bVar.alm != null && !bVar.alm.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceModel", bVar.alm);
        }
        if (bVar.SR != null && !bVar.SR.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceBrand", bVar.SR);
        }
        if (bVar.aln != null && !bVar.aln.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceSig", bVar.aln);
        }
        if (bVar.alo != null && !bVar.alo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "eGid", bVar.alo);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appPackageName", bVar.alp);
        if (bVar.alq != null && !bVar.alq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "arch", bVar.alq);
        }
        if (bVar.alr != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenDirection", bVar.alr);
        }
        if (bVar.als != null && !bVar.als.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "kwaiVersionName", bVar.als);
        }
        if (bVar.alt != null && !bVar.alt.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "kwaiNebulaVersionName", bVar.alt);
        }
        if (bVar.alu != null && !bVar.alu.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "wechatVersionName", bVar.alu);
        }
        if (bVar.alv != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sourceFlag", bVar.alv);
        }
        if (bVar.alw != null && !bVar.alw.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "systemBootTime", bVar.alw);
        }
        if (bVar.alx != null && !bVar.alx.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "systemUpdateTime", bVar.alx);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
