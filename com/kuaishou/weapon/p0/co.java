package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/co.class */
public class co {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str, final String str2, final boolean z, boolean z2) {
        JSONObject jSONObject;
        StringBuilder sb;
        try {
            String str3 = ct.f10190a + ct.e;
            String a2 = cu.a(context);
            String str4 = str3;
            if (!TextUtils.isEmpty(a2)) {
                if (!ct.a() || str2 == null) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("?");
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("?logId=");
                    sb.append(str2);
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(a2);
                str4 = sb.toString();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z2) {
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
            l a3 = l.a(context);
            m mVar = new m(str4, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.co.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                    if (z) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable th) {
        }
    }
}
