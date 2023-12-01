package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ch.class */
public class ch {

    /* renamed from: a  reason: collision with root package name */
    private Context f10172a;
    private int b;

    public ch(Context context, int i) {
        this.f10172a = context;
        this.b = i;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.j).a(this.f10172a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public JSONObject a() {
        JSONArray a2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (WeaponHI.as) {
                h a3 = h.a(this.f10172a, "re_po_rt");
                int b = a3.b(de.m, 0);
                boolean e = a3.e("a1_p_s_p_s");
                boolean e2 = a3.e("a1_p_s_p_s_c_b");
                if (b == 1) {
                    if ((e || e2) && (a2 = new w(this.f10172a).a(0)) != null) {
                        jSONObject.put("10000", a2);
                        try {
                            jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                            jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                            jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                        } catch (Throwable th) {
                        }
                        jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                        jSONObject.put("11017", jSONObject.toString().length());
                        return jSONObject;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }
}
