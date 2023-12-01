package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cu.class */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    public static String f10192a = "appkey";
    public static String b = "secretkey";

    /* renamed from: c  reason: collision with root package name */
    public static String f10193c = "pver";
    public static String d = "sdkver";
    public static String e = "ksid";
    public static String f = "timestamp";
    public static String g = "sign";

    public static String a(Context context) {
        Map d2 = d(context);
        if (d2 == null || d2.size() <= 0) {
            return null;
        }
        Iterator it = d2.entrySet().iterator();
        String str = "";
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2.substring(1);
            }
            Map.Entry entry = (Map.Entry) it.next();
            str = str2 + ContainerUtils.FIELD_DELIMITER + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
    }

    public static String a(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        String str = "";
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2.substring(1);
            }
            Map.Entry<String, String> next = it.next();
            str = str2 + ContainerUtils.FIELD_DELIMITER + next.getKey() + "=" + next.getValue();
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bs.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put(com.anythink.expressad.d.a.b.N, bg.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(de.g, bp.e));
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bp.g);
        } catch (Exception e2) {
        }
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f10192a));
            sb.append(map.get(b));
            sb.append(map.get(f));
            return f.a(sb.toString());
        } catch (Exception e2) {
            return null;
        }
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.0.9");
            jSONObject.put("device_id", cl.b(context));
            jSONObject.put("iv", com.huawei.hms.ads.dynamicloader.b.f);
            return jSONObject;
        } catch (Exception e2) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bs.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put(com.anythink.expressad.d.a.b.N, bg.q(context));
            try {
                String b2 = h.a(context, "re_po_rt").b(de.i, bp.e);
                String str = b2;
                if (TextUtils.isEmpty(b2)) {
                    str = bp.e;
                }
                jSONObject.put("pver", str);
            } catch (Exception e2) {
                jSONObject.put("pver", bp.e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bp.g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.0.9");
            jSONObject.put("device_id", cl.b(context));
            jSONObject.put("iv", com.huawei.hms.ads.dynamicloader.b.f);
            return jSONObject;
        } catch (Exception e3) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f10192a, str);
            hashMap.put(b, str2);
            hashMap.put(f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(g, b(hashMap));
            return hashMap;
        } catch (Exception e2) {
            return null;
        }
    }
}
