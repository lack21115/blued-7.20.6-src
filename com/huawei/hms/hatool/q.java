package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/q.class */
public class q implements s {

    /* renamed from: a  reason: collision with root package name */
    public String f9179a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f9180c;
    public String d;
    public String e;
    public String f;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f9179a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put("event", this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (TextUtils.isEmpty(this.f9180c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f9180c));
        return jSONObject;
    }

    public void a(String str) {
        this.f9180c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString("event");
        this.f9180c = jSONObject.optString("properties");
        this.f9180c = d.a(this.f9180c, e0.f().a());
        this.f9179a = jSONObject.optString("type");
        this.d = jSONObject.optString("eventtime");
        this.e = jSONObject.optString("event_session_name");
        this.f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f9179a;
    }

    public void c(String str) {
        this.d = str;
    }

    public JSONObject d() {
        JSONObject a2 = a();
        a2.put("properties", d.b(this.f9180c, e0.f().a()));
        return a2;
    }

    public void d(String str) {
        this.f9179a = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.e = str;
    }
}
