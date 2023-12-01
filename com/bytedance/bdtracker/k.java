package com.bytedance.bdtracker;

import com.tencent.tendinsv.a.b;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/k.class */
public final class k extends l {
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f21241c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;

    @Override // com.bytedance.bdtracker.l
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", this.b);
        jSONObject.put("device_id", this.f21241c);
        jSONObject.put("bd_did", this.d);
        jSONObject.put("install_id", this.e);
        jSONObject.put(bh.x, this.f);
        jSONObject.put("caid", this.g);
        jSONObject.put("androidid", this.l);
        jSONObject.put("imei", this.m);
        jSONObject.put("oaid", this.n);
        jSONObject.put("google_aid", this.o);
        jSONObject.put(b.a.q, this.p);
        jSONObject.put("ua", this.q);
        jSONObject.put("device_model", this.r);
        jSONObject.put("os_version", this.s);
        jSONObject.put("is_new_user", this.h);
        jSONObject.put("exist_app_cache", this.i);
        jSONObject.put("app_version", this.j);
        jSONObject.put("channel", this.k);
        return jSONObject;
    }

    @Override // com.bytedance.bdtracker.l
    public void a(JSONObject jSONObject) {
    }
}
