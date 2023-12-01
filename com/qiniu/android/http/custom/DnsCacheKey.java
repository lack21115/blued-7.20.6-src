package com.qiniu.android.http.custom;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/custom/DnsCacheKey.class */
public class DnsCacheKey {
    public String akScope;
    public String currentTime;
    public String localIp;

    public DnsCacheKey() {
    }

    public DnsCacheKey(String str, String str2, String str3) {
        this.currentTime = str;
        this.localIp = str2;
        this.akScope = str3;
    }

    public static DnsCacheKey toCacheKey(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new DnsCacheKey(jSONObject.getString("currentTime"), jSONObject.getString("localIp"), jSONObject.getString("akScope"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAkScope() {
        return this.akScope;
    }

    public String getCurrentTime() {
        return this.currentTime;
    }

    public String getLocalIp() {
        return this.localIp;
    }

    public void setAkScope(String str) {
        this.akScope = str;
    }

    public void setCurrentTime(String str) {
        this.currentTime = str;
    }

    public void setLocalIp(String str) {
        this.localIp = str;
    }

    public String toString() {
        return "{\"currentTime\":\"" + this.currentTime + "\", \"localIp\":\"" + this.localIp + "\", \"akScope\":\"" + this.akScope + "\"}";
    }
}
