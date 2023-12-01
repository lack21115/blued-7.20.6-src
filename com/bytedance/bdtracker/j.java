package com.bytedance.bdtracker;

import android.drm.DrmInfoRequest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j.class */
public final class j extends l {
    public String A;
    public String B;
    public String C;
    public String D;
    public a E = a.PROMOTION;
    public String F;
    public boolean G;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f7628c;
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
    public boolean n;
    public int o;
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

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j$a.class */
    public enum a {
        PROMOTION,
        ORGANIC
    }

    @Override // com.bytedance.bdtracker.l
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.b);
        jSONObject.put("utm_campaign", this.f7628c);
        jSONObject.put("utm_source", this.d);
        jSONObject.put("utm_medium", this.e);
        jSONObject.put("utm_content", this.f);
        jSONObject.put("utm_term", this.g);
        jSONObject.put("tr_shareuser", this.h);
        jSONObject.put("tr_admaster", this.i);
        jSONObject.put("tr_param1", this.j);
        jSONObject.put("tr_param2", this.k);
        jSONObject.put("tr_param3", this.l);
        jSONObject.put("tr_param4", this.m);
        jSONObject.put("is_retargeting", this.n);
        jSONObject.put("reengagement_window", this.o);
        jSONObject.put("tr_dp", this.p);
        jSONObject.put("deeplink_value", this.q);
        jSONObject.put("tr_site_id", this.r);
        jSONObject.put("tr_site_name", this.s);
        jSONObject.put(DrmInfoRequest.ACCOUNT_ID, this.t);
        jSONObject.put("account_name", this.u);
        jSONObject.put("campaign_id", this.v);
        jSONObject.put("campaign_name", this.w);
        jSONObject.put("ad_id", this.x);
        jSONObject.put("ad_name", this.y);
        jSONObject.put(com.anythink.expressad.foundation.d.c.l, this.z);
        jSONObject.put("creative_name", this.A);
        jSONObject.put("tr_install_type", this.B);
        jSONObject.put("touch_type", this.C);
        jSONObject.put("touch_timestamp", this.D);
        String name = this.E.name();
        Locale locale = Locale.ROOT;
        Intrinsics.b(locale, "Locale.ROOT");
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            jSONObject.put("activation_type", lowerCase);
            jSONObject.put("activation_timestamp", this.F);
            jSONObject.put("is_first_launch", this.G);
            return jSONObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // com.bytedance.bdtracker.l
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject.optString("name", null);
            this.f7628c = jSONObject.optString("utm_campaign", null);
            this.d = jSONObject.optString("utm_source", null);
            this.e = jSONObject.optString("utm_medium", null);
            this.f = jSONObject.optString("utm_content", null);
            this.g = jSONObject.optString("utm_term", null);
            this.h = jSONObject.optString("tr_shareuser", null);
            this.i = jSONObject.optString("tr_admaster", null);
            this.j = jSONObject.optString("tr_param1", null);
            this.k = jSONObject.optString("tr_param2", null);
            this.l = jSONObject.optString("tr_param3", null);
            this.m = jSONObject.optString("tr_param4", null);
            this.n = jSONObject.optBoolean("is_retargeting");
            this.o = jSONObject.optInt("reengagement_window");
            this.p = jSONObject.optString("tr_dp", null);
            this.q = jSONObject.optString("deeplink_value", null);
            this.r = jSONObject.optString("tr_site_id", null);
            this.s = jSONObject.optString("tr_site_name", null);
            this.t = jSONObject.optString(DrmInfoRequest.ACCOUNT_ID, null);
            this.u = jSONObject.optString("account_name", null);
            this.v = jSONObject.optString("campaign_id", null);
            this.w = jSONObject.optString("campaign_name", null);
            this.x = jSONObject.optString("ad_id", null);
            this.y = jSONObject.optString("ad_name", null);
            this.z = jSONObject.optString(com.anythink.expressad.foundation.d.c.l, null);
            this.A = jSONObject.optString("creative_name", null);
            this.B = jSONObject.optString("tr_install_type", null);
            this.C = jSONObject.optString("touch_type", null);
            this.D = jSONObject.optString("touch_timestamp", null);
            this.E = Intrinsics.a(jSONObject.optString("activation_type"), "promotion") ? a.PROMOTION : a.ORGANIC;
            this.F = jSONObject.optString("activation_timestamp", null);
            this.G = jSONObject.optBoolean("is_first_launch");
        }
    }
}
