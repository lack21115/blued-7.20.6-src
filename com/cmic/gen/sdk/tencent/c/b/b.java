package com.cmic.gen.sdk.tencent.c.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/b.class */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f8025a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f8026c;
    private String d;
    private String e;
    private String f;
    private String g;

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public String a() {
        return this.f;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    protected String a(String str) {
        return this.f8025a + this.e + this.f + "iYm0HAnkxQtpvN44";
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f8025a);
            jSONObject.put("apptype", this.b);
            jSONObject.put("phone_ID", this.f8026c);
            jSONObject.put("certflag", this.d);
            jSONObject.put("sdkversion", this.e);
            jSONObject.put("appid", this.f);
            jSONObject.put("expandparams", "");
            jSONObject.put(com.anythink.expressad.d.a.b.d, this.g);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void b(String str) {
        this.f8025a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.f8026c = str;
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

    public void h(String str) {
        this.g = str;
    }
}
