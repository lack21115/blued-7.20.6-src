package com.zx.a.I8b7;

import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.xiaomi.mipush.sdk.Constants;
import com.zx.sdk.api.ZXID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/p0.class */
public abstract class p0 {
    public ZXID a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        ZXID zxid = new ZXID();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("ext"));
            JSONObject optJSONObject = jSONObject2.optJSONObject("aids").optJSONObject(str);
            zxid.setAids(optJSONObject == null ? "" : optJSONObject.toString());
            JSONArray optJSONArray = jSONObject2.optJSONArray("tags");
            zxid.setTags(optJSONArray == null ? null : optJSONArray.toString());
            String optString = jSONObject.optString(bh.al);
            zxid.setValue(optString);
            String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            zxid.setVersion(split[0]);
            zxid.setExpiredTime(Long.parseLong(split[1]) * 1000);
            zxid.setOpenid(jSONObject2.optString("openid"));
            return zxid;
        } catch (Exception e) {
            z1.a(e);
            return zxid;
        }
    }

    public abstract void a(String str);
}
