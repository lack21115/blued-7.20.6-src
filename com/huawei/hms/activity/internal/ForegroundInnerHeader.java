package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/activity/internal/ForegroundInnerHeader.class */
public class ForegroundInnerHeader {

    /* renamed from: a  reason: collision with root package name */
    private int f22407a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f22408c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f22407a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.b = JsonUtil.getStringValue(jSONObject, "action");
            this.f22408c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e.getMessage());
        }
    }

    public String getAction() {
        return this.b;
    }

    public int getApkVersion() {
        return this.f22407a;
    }

    public String getResponseCallbackKey() {
        return this.f22408c;
    }

    public void setAction(String str) {
        this.b = str;
    }

    public void setApkVersion(int i) {
        this.f22407a = i;
    }

    public void setResponseCallbackKey(String str) {
        this.f22408c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f22407a);
            jSONObject.put("action", this.b);
            jSONObject.put("responseCallbackKey", this.f22408c);
        } catch (JSONException e) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f22407a + ", action:" + this.b + ", responseCallbackKey:" + this.f22408c;
    }
}
