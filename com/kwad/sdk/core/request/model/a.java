package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.t;
import com.tencent.qcloud.core.auth.AuthConstants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/request/model/a.class */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject akW;
    private String akX;
    private String appId;
    private String name;
    private String packageName;
    private String version;

    private static boolean C(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppId()) && optString2.equals(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppName());
    }

    public static JSONObject xo() {
        if (!C(akW)) {
            akW = xp().toJson();
        }
        return akW;
    }

    private static a xp() {
        a aVar = new a();
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        aVar.appId = eVar.getAppId();
        aVar.name = eVar.getAppName();
        Context context = eVar.getContext();
        if (context != null) {
            aVar.packageName = context.getPackageName();
            aVar.version = k.bH(context);
        }
        aVar.akX = com.kwad.sdk.utils.e.bx(context);
        if (!TextUtils.isEmpty(be.getAppId())) {
            aVar.appId = be.getAppId();
        }
        if (!TextUtils.isEmpty(be.getPackageName())) {
            aVar.packageName = be.getPackageName();
        }
        return aVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "appId", this.appId);
        t.putValue(jSONObject, "name", this.name);
        t.putValue(jSONObject, "packageName", this.packageName);
        t.putValue(jSONObject, "version", this.version);
        t.putValue(jSONObject, AuthConstants.SHA1, this.akX);
        return jSONObject;
    }
}
