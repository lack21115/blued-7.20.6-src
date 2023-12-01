package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cf.class */
public class cf {
    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new bm(context).a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt("status") == 1) {
                    bw.a(context, string);
                    bw.b(context, string);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void a(final Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        try {
            String str3 = ct.f23798a + ct.f;
            String a2 = cu.a(context);
            String str4 = str3;
            if (!TextUtils.isEmpty(a2)) {
                if (!ct.a() || str2 == null) {
                    str4 = str3 + "?" + a2;
                } else {
                    str4 = str3 + "?logId=" + str2 + "&" + a2;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z) {
                JSONObject jSONObject2 = new JSONObject();
                String c2 = new bm(context).c(str);
                jSONObject = jSONObject2;
                if (!TextUtils.isEmpty(c2)) {
                    jSONObject2.put("data", c2);
                    jSONObject = jSONObject2;
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j() { // from class: com.kuaishou.weapon.p0.cf.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                    cf.a(Context.this, str5);
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                }
            }));
        } catch (Exception e) {
        }
    }
}
