package com.huawei.hms.hatool;

import com.anythink.pd.ExHandler;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/f1.class */
public class f1 extends n {
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f9134c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f9165a);
        jSONObject.put("oaid", this.g);
        jSONObject.put("uuid", this.f);
        jSONObject.put("upid", this.e);
        jSONObject.put(ExHandler.JSON_REQUEST_IMEI, this.b);
        jSONObject.put("sn", this.f9134c);
        jSONObject.put("udid", this.d);
        return jSONObject;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.f9134c = str;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f = str;
    }
}
