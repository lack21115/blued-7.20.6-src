package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cl.class */
public class cl {

    /* renamed from: a  reason: collision with root package name */
    private String f10178a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f10179c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public cl(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.i = sb.toString();
        this.f10179c = str;
        this.g = str2;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bh.v = 1;
                return str;
            }
        } catch (Exception e) {
        }
        try {
            h a2 = h.a(context, "re_po_rt");
            boolean e2 = a2.e("a1_p_s_p_s");
            boolean e3 = a2.e("a1_p_s_p_s_c_b");
            if (e2 || e3) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bh.v = 3;
                    return str2;
                }
            }
        } catch (Exception e4) {
        }
        bh.v = 4;
        return "";
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception e) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f10178a);
            jSONObject.put("2", this.b);
            jSONObject.put("3", this.f10179c);
            jSONObject.put("4", this.d);
            jSONObject.put("5", this.e);
            jSONObject.put("6", this.f);
            jSONObject.put("7", this.g);
            jSONObject.put("8", this.h);
            jSONObject.put("9", this.i);
            jSONObject.put("11", this.j);
            jSONObject.put("12", this.l);
            jSONObject.put("13", "com.kuaishou.weapon");
            jSONObject.put("14", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public String a() {
        return this.f10178a;
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bg.q(context));
            e(bg.r(context));
            f(bg.s(context));
            h("5.0.9");
            j(bs.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable th) {
            return null;
        }
    }

    public void a(String str) {
        this.f10178a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f10179c;
    }

    public void c(String str) {
        this.f10179c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String f() {
        return this.f;
    }

    public void f(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public String h() {
        return this.h;
    }

    public void h(String str) {
        this.h = str;
    }

    public String i() {
        return this.i;
    }

    public void i(String str) {
        this.i = str;
    }

    public String j() {
        return this.j;
    }

    public void j(String str) {
        this.j = str;
    }

    public String k() {
        return this.k;
    }

    public void k(String str) {
        this.k = str;
    }

    public String l() {
        return this.l;
    }

    public void l(String str) {
        this.l = str;
    }
}
