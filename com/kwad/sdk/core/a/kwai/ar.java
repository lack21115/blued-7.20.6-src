package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ak;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ar.class */
public final class ar implements com.kwad.sdk.core.d<ak.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ak.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString("appName");
        if (bVar.appName == JSONObject.NULL) {
            bVar.appName = "";
        }
        bVar.Td = jSONObject.optString("pkgName");
        if (bVar.Td == JSONObject.NULL) {
            bVar.Td = "";
        }
        bVar.version = jSONObject.optString("version");
        if (bVar.version == JSONObject.NULL) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.TQ = jSONObject.optLong("appSize");
        bVar.Tf = jSONObject.optString("md5");
        if (bVar.Tf == JSONObject.NULL) {
            bVar.Tf = "";
        }
        bVar.url = jSONObject.optString("url");
        if (bVar.url == JSONObject.NULL) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString("icon");
        if (bVar.icon == JSONObject.NULL) {
            bVar.icon = "";
        }
        bVar.qi = jSONObject.optString("desc");
        if (bVar.qi == JSONObject.NULL) {
            bVar.qi = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ak.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.appName != null && !bVar.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", bVar.appName);
        }
        if (bVar.Td != null && !bVar.Td.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pkgName", bVar.Td);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "version", bVar.version);
        }
        if (bVar.versionCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "versionCode", bVar.versionCode);
        }
        if (bVar.TQ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appSize", bVar.TQ);
        }
        if (bVar.Tf != null && !bVar.Tf.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "md5", bVar.Tf);
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", bVar.url);
        }
        if (bVar.icon != null && !bVar.icon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "icon", bVar.icon);
        }
        if (bVar.qi != null && !bVar.qi.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "desc", bVar.qi);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ak.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ak.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
