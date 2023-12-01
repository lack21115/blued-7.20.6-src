package com.kwad.sdk.core.a.kwai;

import android.net.wifi.WifiEnterpriseConfig;
import com.kwad.sdk.core.scene.URLPackage;
import com.sina.weibo.sdk.constant.WBPageConstants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ix.class */
public final class ix implements com.kwad.sdk.core.d<URLPackage> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt(WBPageConstants.ParamKey.PAGE);
        uRLPackage.identity = jSONObject.optString(WifiEnterpriseConfig.IDENTITY_KEY);
        if (uRLPackage.identity == JSONObject.NULL) {
            uRLPackage.identity = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(URLPackage uRLPackage, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (uRLPackage.page != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, WBPageConstants.ParamKey.PAGE, uRLPackage.page);
        }
        if (uRLPackage.identity != null && !uRLPackage.identity.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, WifiEnterpriseConfig.IDENTITY_KEY, uRLPackage.identity);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(URLPackage uRLPackage, JSONObject jSONObject) {
        a2(uRLPackage, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        return b2(uRLPackage, jSONObject);
    }
}
