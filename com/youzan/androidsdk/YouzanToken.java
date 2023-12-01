package com.youzan.androidsdk;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/YouzanToken.class */
public class YouzanToken {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1055;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f1056;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f1057;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f1058;

    public YouzanToken() {
    }

    public YouzanToken(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.has("data") ? jSONObject.optJSONObject("data") : jSONObject;
        this.f1055 = optJSONObject.optString("access_token");
        this.f1056 = optJSONObject.optString("cookie_key");
        this.f1057 = optJSONObject.optString("cookie_value");
        this.f1058 = optJSONObject.optString("yz_open_id");
    }

    public String getAccessToken() {
        return this.f1055;
    }

    public String getCookieKey() {
        return this.f1056;
    }

    public String getCookieValue() {
        return this.f1057;
    }

    public String getYzOpenId() {
        return this.f1058;
    }

    public void setAccessToken(String str) {
        this.f1055 = str;
    }

    public void setCookieKey(String str) {
        this.f1056 = str;
    }

    public void setCookieValue(String str) {
        this.f1057 = str;
    }

    public void setYzOpenId(String str) {
        this.f1058 = str;
    }
}
