package com.cmic.gen.sdk.tencent.view;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f8095a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f8096c;
    private String d;
    private String e;
    private String f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authPageOut", this.b);
            jSONObject.put("authPageIn", this.f8095a);
            jSONObject.put("authClickSuccess", this.d);
            jSONObject.put("timeOnAuthPage", this.e);
            jSONObject.put("authClickFailed", this.f8096c);
            jSONObject.put("authPrivacyState", this.f);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void a(String str) {
        this.f = str;
    }

    public void b(String str) {
        this.f8096c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f8095a = str;
    }

    public void f(String str) {
        this.b = str;
    }
}
