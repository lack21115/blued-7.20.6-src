package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.os.BatteryManager;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.e.ak;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/c.class */
public class c {
    private static final String y = "portrait";
    private static final String z = "landscape";
    public String d;
    public String e;
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
    public int v;
    public String w;
    public JSONObject x;

    /* renamed from: c  reason: collision with root package name */
    public String f7947c = "android";

    /* renamed from: a  reason: collision with root package name */
    public String f7946a = k.b();
    public String b = k.c();
    public String f = com.anythink.core.common.k.d.f();

    public c(Context context) {
        this.d = com.anythink.core.common.k.d.d(context);
        int a2 = k.a();
        this.g = String.valueOf(a2);
        this.h = k.a(context, a2);
        this.i = com.anythink.core.common.k.d.i();
        this.j = com.anythink.expressad.foundation.b.a.b().f();
        this.k = com.anythink.expressad.foundation.b.a.b().e();
        this.l = String.valueOf(t.f(context));
        this.m = String.valueOf(t.e(context));
        this.r = String.valueOf(t.c(context));
        this.s = com.anythink.expressad.foundation.b.a.b().i().toString();
        this.u = com.anythink.core.common.k.d.b();
        this.v = com.anythink.core.common.p.a().c();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.n = "landscape";
        } else {
            this.n = "portrait";
        }
        IExHandler b = com.anythink.core.common.b.n.a().b();
        String[] split = (b != null ? b.fillCDataParam("at_device1|||at_device12|||at_device3") : "|||").split("\\|\\|\\|");
        if (split != null) {
            this.e = split.length > 0 ? split[0] : "";
            this.w = split.length > 1 ? split[1] : "";
            this.q = split.length > 2 ? split[2] : "";
        }
        this.o = com.anythink.expressad.foundation.g.a.co;
        this.p = com.anythink.expressad.foundation.g.a.cp;
        this.t = k.e();
        this.x = b();
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(k.i());
            jSONObject.put("cid", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(k.f());
            jSONObject.put("dmt", sb2.toString());
            jSONObject.put("dmf", k.g());
            jSONObject.put(com.anythink.expressad.d.a.b.dx, k.h());
            jSONObject.put(com.anythink.core.common.k.c.b("aW1laQ=="), this.e);
            jSONObject.put(com.anythink.core.common.k.c.b("bWFj"), this.w);
            jSONObject.put("oaid", this.q);
            jSONObject.put("android_id", this.d);
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", this.f7946a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.g);
            jSONObject.put("network_type_str", this.h);
            jSONObject.put("device_ua", this.i);
            ak L = com.anythink.core.common.b.n.a().L();
            if (L != null) {
                jSONObject.put("has_wx", L.a());
                jSONObject.put("integrated_wx", L.b());
                StringBuilder sb = new StringBuilder();
                sb.append(L.c());
                jSONObject.put("opensdk_ver", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(L.d());
                jSONObject.put("wx_api_ver", sb2.toString());
            }
            jSONObject.put("brand", this.u);
            jSONObject.put("plantform", this.f7947c);
            jSONObject.put(com.anythink.core.common.k.c.b("ZGV2aWNlX2ltZWk="), this.e);
            jSONObject.put("android_id", this.d);
            jSONObject.put("google_ad_id", this.f);
            jSONObject.put("oaid", this.q);
            jSONObject.put("appkey", this.j);
            jSONObject.put("appId", this.k);
            jSONObject.put("screen_width", this.l);
            jSONObject.put("screen_height", this.m);
            jSONObject.put("orientation", this.n);
            jSONObject.put(BatteryManager.EXTRA_SCALE, this.r);
            jSONObject.put("b", this.o);
            jSONObject.put("c", this.p);
            jSONObject.put("web_env", this.s);
            jSONObject.put("f", this.t);
            jSONObject.put("misk_spt", this.v);
            jSONObject.put("dvi", j.a(this.x.toString()));
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
