package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/constants/LoadAdParams.class */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    private LoginType f27907a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27908c;
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
        return this.f27908c;
    }

    public LoginType getLoginType() {
        return this.f27907a;
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
        this.f27908c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f27907a = loginType;
    }

    public void setUin(String str) {
        this.d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f27907a + ", loginAppId=" + this.b + ", loginOpenid=" + this.f27908c + ", uin=" + this.d + ", passThroughInfo=" + this.e + ", extraInfo=" + this.f + '}';
    }
}
