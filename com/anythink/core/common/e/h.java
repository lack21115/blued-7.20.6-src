package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.c.d;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/h.class */
public final class h extends q {
    public String A;
    public String B;
    public String C;
    public String D;

    /* renamed from: a  reason: collision with root package name */
    public String f6660a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f6661c;
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
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    private h() {
    }

    public h(String str, String str2) {
        this.A = str;
        this.B = str2;
    }

    public static h a(String str) {
        h hVar = new h();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("key")) {
                    hVar.f6660a = jSONObject.optString("key", "");
                }
                if (jSONObject.has("requestid")) {
                    hVar.b = jSONObject.optString("requestid", "");
                }
                if (jSONObject.has("unitid")) {
                    hVar.d = jSONObject.optString("unitid", "");
                }
                if (jSONObject.has(com.anythink.core.common.b.e.f6488c)) {
                    hVar.e = jSONObject.optString(com.anythink.core.common.b.e.f6488c, "");
                }
                if (jSONObject.has("sessionid")) {
                    hVar.f = jSONObject.optString("sessionid", "");
                }
                if (jSONObject.has("groupid")) {
                    hVar.g = jSONObject.optString("groupid", "");
                }
                if (jSONObject.has("unitgroupid")) {
                    hVar.h = jSONObject.optString("unitgroupid", "");
                }
                if (jSONObject.has("timestamp")) {
                    hVar.i = jSONObject.optString("timestamp", "");
                }
                if (jSONObject.has("asid")) {
                    hVar.j = jSONObject.optString("asid", "");
                }
                if (jSONObject.has("refresh")) {
                    hVar.k = jSONObject.optString("refresh", "");
                }
                if (jSONObject.has("traffic_group_id")) {
                    hVar.l = jSONObject.optString("traffic_group_id", "");
                }
                if (jSONObject.has("msg")) {
                    hVar.m = jSONObject.optString("msg", "");
                }
                if (jSONObject.has("msg1")) {
                    hVar.n = jSONObject.optString("msg1", "");
                }
                if (jSONObject.has("msg2")) {
                    hVar.o = jSONObject.optString("msg2", "");
                }
                if (jSONObject.has("msg3")) {
                    hVar.p = jSONObject.optString("msg3", "");
                }
                if (jSONObject.has("msg4")) {
                    hVar.q = jSONObject.optString("msg4", "");
                }
                if (jSONObject.has("msg5")) {
                    hVar.r = jSONObject.optString("msg5", "");
                }
                if (jSONObject.has("msg6")) {
                    hVar.s = jSONObject.optString("msg6", "");
                }
                if (jSONObject.has("msg7")) {
                    hVar.t = jSONObject.optString("msg7", "");
                }
                if (jSONObject.has("msg8")) {
                    hVar.u = jSONObject.optString("msg8", "");
                }
                if (jSONObject.has("msg9")) {
                    hVar.v = jSONObject.optString("msg9", "");
                }
                if (jSONObject.has("msg10")) {
                    hVar.w = jSONObject.optString("msg10", "");
                }
                if (jSONObject.has("msg11")) {
                    hVar.x = jSONObject.optString("msg11", "");
                }
                if (jSONObject.has("msg12")) {
                    hVar.y = jSONObject.optString("msg12", "");
                }
                if (jSONObject.has("msg13")) {
                    hVar.z = jSONObject.optString("msg13", "");
                }
                if (jSONObject.has(d.a.U)) {
                    hVar.C = jSONObject.optString(d.a.U, "");
                }
                if (jSONObject.has(com.anythink.core.common.g.c.am)) {
                    hVar.D = jSONObject.optString(com.anythink.core.common.g.c.am, "");
                    return hVar;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hVar;
    }

    @Override // com.anythink.core.common.e.q
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.f6660a);
            jSONObject.put("requestid", this.b);
            jSONObject.put("unitid", this.d);
            jSONObject.put(com.anythink.core.common.b.e.f6488c, this.e);
            jSONObject.put("sessionid", this.f);
            jSONObject.put("groupid", this.g);
            jSONObject.put("unitgroupid", this.h);
            jSONObject.put("timestamp", this.i);
            jSONObject.put("asid", this.j);
            jSONObject.put("refresh", this.k);
            jSONObject.put("traffic_group_id", this.l);
            jSONObject.put("msg", this.m);
            jSONObject.put("msg1", this.n);
            jSONObject.put("msg2", this.o);
            jSONObject.put("msg3", this.p);
            jSONObject.put("msg4", this.q);
            jSONObject.put("msg5", this.r);
            jSONObject.put("msg6", this.s);
            jSONObject.put("msg7", this.t);
            jSONObject.put("msg8", this.u);
            jSONObject.put("msg9", this.v);
            jSONObject.put("msg10", this.w);
            jSONObject.put("msg11", this.x);
            jSONObject.put("msg12", this.y);
            jSONObject.put("msg13", this.z);
            jSONObject.put(d.a.U, this.C);
            jSONObject.put(com.anythink.core.common.g.c.am, this.D);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
