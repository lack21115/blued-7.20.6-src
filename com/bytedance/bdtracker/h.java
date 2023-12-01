package com.bytedance.bdtracker;

import com.anythink.pd.ExHandler;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h.class */
public final class h extends l {
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f7618c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public Integer p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;

    @Override // com.bytedance.bdtracker.l
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.o);
        jSONObject.put("aid", this.b);
        jSONObject.put(bh.x, this.l);
        jSONObject.put("bd_did", this.f7618c);
        jSONObject.put("ssid", this.d);
        jSONObject.put("user_unique_id", this.e);
        jSONObject.put("androidid", this.h);
        jSONObject.put(ExHandler.JSON_REQUEST_IMEI, this.i);
        jSONObject.put("oaid", this.j);
        jSONObject.put("os_version", this.m);
        jSONObject.put("device_model", this.n);
        jSONObject.put("google_aid", this.k);
        jSONObject.put(com.anythink.expressad.foundation.d.f.s, this.p);
        jSONObject.put("tr_shareuser", this.q);
        jSONObject.put("tr_admaster", this.r);
        jSONObject.put("tr_param1", this.s);
        jSONObject.put("tr_param2", this.t);
        jSONObject.put("tr_param3", this.u);
        jSONObject.put("tr_param4", this.v);
        jSONObject.put("ab_version", this.f);
        jSONObject.put("tr_web_ssid", this.g);
        return jSONObject;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.bytedance.bdtracker.l
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.o = jSONObject.optString("tr_token", null);
            this.b = jSONObject.optString("aid", null);
            this.l = jSONObject.optString(bh.x, null);
            this.f7618c = jSONObject.optString("bd_did", null);
            this.d = jSONObject.optString("ssid", null);
            this.e = jSONObject.optString("user_unique_id", null);
            this.h = jSONObject.optString("androidid", null);
            this.i = jSONObject.optString(ExHandler.JSON_REQUEST_IMEI, null);
            this.j = jSONObject.optString("oaid", null);
            this.m = jSONObject.optString("os_version", null);
            this.n = jSONObject.optString("device_model", null);
            this.k = jSONObject.optString("google_aid", null);
            this.p = Integer.valueOf(jSONObject.optInt(com.anythink.expressad.foundation.d.f.s));
            this.q = jSONObject.optString("tr_shareuser", null);
            this.r = jSONObject.optString("tr_admaster", null);
            this.s = jSONObject.optString("tr_param1", null);
            this.t = jSONObject.optString("tr_param2", null);
            this.u = jSONObject.optString("tr_param3", null);
            this.v = jSONObject.optString("tr_param4", null);
            this.f = jSONObject.optString("ab_version", null);
            this.g = jSONObject.optString("tr_web_ssid", null);
        }
    }

    public final void b(String str) {
        this.f7618c = str;
    }

    public final String c() {
        return this.f;
    }

    public final void c(String str) {
        this.d = str;
    }

    public final String d() {
        return this.o;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final String e() {
        return this.g;
    }
}
