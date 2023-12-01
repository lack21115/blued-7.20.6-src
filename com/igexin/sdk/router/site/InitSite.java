package com.igexin.sdk.router.site;

import com.igexin.c.a.c.a;
import com.igexin.push.core.e;
import com.igexin.push.f.o;
import com.igexin.sdk.router.boatman.receive.IBoatResult;
import com.igexin.sdk.router.boatman.receive.Site;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/router/site/InitSite.class */
public class InitSite extends Site<JSONObject, JSONObject> {
    @Override // com.igexin.sdk.router.boatman.receive.Site
    public String getTag() {
        return "tag_extension_init";
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public JSONObject onArrived(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put("cid", e.A);
            jSONObject.put("deviceId", e.H);
            jSONObject.put("userPushService", o.b(e.l, o.f23664c, ""));
            return jSONObject;
        } catch (JSONException e) {
            a.a(e);
            return jSONObject;
        }
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public void onArrived(JSONObject jSONObject, IBoatResult<JSONObject> iBoatResult) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("cid", e.A);
            jSONObject.put("deviceId", e.H);
            jSONObject.put("userPushService", o.b(e.l, o.b, ""));
            iBoatResult.onResult(jSONObject);
        } catch (JSONException e) {
            a.a(e);
        }
    }
}
