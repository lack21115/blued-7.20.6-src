package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/constants/LoadAdParams.class */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    private LoginType f14219a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f14220c;
    private String d;
    private Map<String, String> e;
    private JSONObject f;
    private final JSONObject g = new JSONObject();

    public Map getDevExtra() {
        return this.e;
    }

    public String getDevExtraJsonString() {
        String str = "";
        try {
            if (this.e != null) {
                str = "";
                if (this.e.size() > 0) {
                    str = new JSONObject(this.e).toString();
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f;
    }

    public String getLoginAppId() {
        return this.b;
    }

    public String getLoginOpenid() {
        return this.f14220c;
    }

    public LoginType getLoginType() {
        return this.f14219a;
    }

    public JSONObject getParams() {
        return this.g;
    }

    public String getUin() {
        return this.d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.b = str;
    }

    public void setLoginOpenid(String str) {
        this.f14220c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f14219a = loginType;
    }

    public void setUin(String str) {
        this.d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f14219a + ", loginAppId=" + this.b + ", loginOpenid=" + this.f14220c + ", uin=" + this.d + ", passThroughInfo=" + this.e + ", extraInfo=" + this.f + '}';
    }
}
