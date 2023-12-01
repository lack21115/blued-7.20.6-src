package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cg.class */
public class cg {

    /* renamed from: a  reason: collision with root package name */
    private Context f23779a;
    private int b;

    public cg(Context context, int i) {
        this.f23779a = context;
        this.b = i;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.j).a(this.f23779a);
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
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f23779a, "re_po_rt").b(de.w, 1) != 1 || (a2 = new x().a(this.f23779a)) == null || a2.length() <= 0) {
                return null;
            }
            jSONObject.put("10000", a2);
            try {
                jSONObject.put("11203", bg.b(com.kwad.sdk.d.b.Ax().Av()));
                jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                return jSONObject;
            } catch (Throwable th) {
                return jSONObject;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
