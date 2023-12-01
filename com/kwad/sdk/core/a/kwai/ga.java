package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ga.class */
public final class ga implements com.kwad.sdk.core.d<com.kwad.sdk.f.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.atm = jSONObject.optString("packageId");
        if (bVar.atm == JSONObject.NULL) {
            bVar.atm = "";
        }
        bVar.atn = jSONObject.optString("zipFileName");
        if (bVar.atn == JSONObject.NULL) {
            bVar.atn = "";
        }
        bVar.ato = jSONObject.optString("zipPath");
        if (bVar.ato == JSONObject.NULL) {
            bVar.ato = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (bVar.packageUrl == JSONObject.NULL) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (bVar.version == JSONObject.NULL) {
            bVar.version = "";
        }
        bVar.atq = jSONObject.optString("checksum");
        if (bVar.atq == JSONObject.NULL) {
            bVar.atq = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.atr = jSONObject.optBoolean("public");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.atm != null && !bVar.atm.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageId", bVar.atm);
        }
        if (bVar.atn != null && !bVar.atn.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "zipFileName", bVar.atn);
        }
        if (bVar.ato != null && !bVar.ato.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "zipPath", bVar.ato);
        }
        if (bVar.packageUrl != null && !bVar.packageUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageUrl", bVar.packageUrl);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "version", bVar.version);
        }
        if (bVar.atq != null && !bVar.atq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "checksum", bVar.atq);
        }
        if (bVar.loadType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "loadType", bVar.loadType);
        }
        if (bVar.packageType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageType", bVar.packageType);
        }
        if (bVar.atr) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "public", bVar.atr);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
