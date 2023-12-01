package com.youzan.androidsdk;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/YouzanToken.class */
public class YouzanToken {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1102;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f1103;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f1104;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f1105;

    public YouzanToken() {
    }

    public YouzanToken(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.has("data") ? jSONObject.optJSONObject("data") : jSONObject;
        this.f1102 = optJSONObject.optString("access_token");
        this.f1103 = optJSONObject.optString("cookie_key");
        this.f1104 = optJSONObject.optString("cookie_value");
        this.f1105 = optJSONObject.optString("yz_open_id");
    }

    public String getAccessToken() {
        return this.f1102;
    }

    public String getCookieKey() {
        return this.f1103;
    }

    public String getCookieValue() {
        return this.f1104;
    }

    public String getYzOpenId() {
        return this.f1105;
    }

    public void setAccessToken(String str) {
        this.f1102 = str;
    }

    public void setCookieKey(String str) {
        this.f1103 = str;
    }

    public void setCookieValue(String str) {
        this.f1104 = str;
    }

    public void setYzOpenId(String str) {
        this.f1105 = str;
    }
}
