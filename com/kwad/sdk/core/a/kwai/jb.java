package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.z;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/jb.class */
public final class jb implements com.kwad.sdk.core.d<z.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(z.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (aVar.appName == JSONObject.NULL) {
            aVar.appName = "";
        }
        aVar.Td = jSONObject.optString("pkgName");
        if (aVar.Td == JSONObject.NULL) {
            aVar.Td = "";
        }
        aVar.version = jSONObject.optString("version");
        if (aVar.version == JSONObject.NULL) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.Te = jSONObject.optInt("appSize");
        aVar.Tf = jSONObject.optString("md5");
        if (aVar.Tf == JSONObject.NULL) {
            aVar.Tf = "";
        }
        aVar.url = jSONObject.optString("url");
        if (aVar.url == JSONObject.NULL) {
            aVar.url = "";
        }
        aVar.Tg = jSONObject.optString("appLink");
        if (aVar.Tg == JSONObject.NULL) {
            aVar.Tg = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (aVar.icon == JSONObject.NULL) {
            aVar.icon = "";
        }
        aVar.qi = jSONObject.optString("desc");
        if (aVar.qi == JSONObject.NULL) {
            aVar.qi = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (aVar.appId == JSONObject.NULL) {
            aVar.appId = "";
        }
        aVar.Th = jSONObject.optString("marketUri");
        if (aVar.Th == JSONObject.NULL) {
            aVar.Th = "";
        }
        aVar.Ti = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.Tj = jSONObject.optBoolean("isLandscapeSupported");
        aVar.Tk = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(z.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", aVar.type);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", aVar.appName);
        }
        if (aVar.Td != null && !aVar.Td.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pkgName", aVar.Td);
        }
        if (aVar.version != null && !aVar.version.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "version", aVar.version);
        }
        if (aVar.versionCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "versionCode", aVar.versionCode);
        }
        if (aVar.Te != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appSize", aVar.Te);
        }
        if (aVar.Tf != null && !aVar.Tf.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "md5", aVar.Tf);
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", aVar.url);
        }
        if (aVar.Tg != null && !aVar.Tg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appLink", aVar.Tg);
        }
        if (aVar.icon != null && !aVar.icon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "icon", aVar.icon);
        }
        if (aVar.qi != null && !aVar.qi.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "desc", aVar.qi);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appId", aVar.appId);
        }
        if (aVar.Th != null && !aVar.Th.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "marketUri", aVar.Th);
        }
        if (aVar.Ti) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "disableLandingPageDeepLink", aVar.Ti);
        }
        if (aVar.Tj) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isLandscapeSupported", aVar.Tj);
        }
        if (aVar.Tk) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isFromLive", aVar.Tk);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(z.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(z.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
