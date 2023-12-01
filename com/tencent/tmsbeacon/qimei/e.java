package com.tencent.tmsbeacon.qimei;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.b.d;
import com.tencent.tmsbeacon.a.d.a;
import com.tencent.tmsbeacon.a.d.g;
import com.tencent.tmsbeacon.b.a.b;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static g f39613a;

    public static String a(Context context) {
        g b = b(context);
        if (b != null) {
            String str = (String) b.a("Q_V3", "");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        b a2 = b.a();
        String a3 = com.tencent.tmsbeacon.a.c.g.a() != 1 ? a2.a("BEACON_QIMEI_1", "") : a2.a("QIMEI_DENGTA", "qimei_v2", "");
        String str2 = a3;
        if (TextUtils.isEmpty(a3)) {
            str2 = a2.a("QIMEI_DENGTA", "");
        }
        return str2;
    }

    public static HashMap<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>(3);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                return hashMap;
            }
        } catch (JSONException e) {
            com.tencent.tmsbeacon.base.util.c.a("[qimei] jsonToMap error: " + e.getMessage(), new Object[0]);
            hashMap.put("A3", str);
        }
        return hashMap;
    }

    public static void a(long j) {
        a.SharedPreferences$EditorC1031a edit = com.tencent.tmsbeacon.a.d.a.a().edit();
        if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putLong("q_i_t", j);
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(context).b("Q_V3", str);
    }

    public static boolean a() {
        return "n".equalsIgnoreCase(com.tencent.tmsbeacon.d.g.b().a("enableQimei"));
    }

    private static g b(Context context) {
        g gVar;
        synchronized (e.class) {
            try {
                if (f39613a == null) {
                    try {
                        f39613a = g.a(context, "Q_V3");
                    } catch (Exception e) {
                        com.tencent.tmsbeacon.base.util.c.a("[qimei] qimeiFile create error: " + e.getMessage(), new Object[0]);
                        d.b().a("511", "getQimeiStoreFile error", e);
                    }
                }
                gVar = f39613a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static boolean b() {
        long j = com.tencent.tmsbeacon.a.d.a.a().getLong("q_i_t", 0L);
        boolean z = j == 0 || System.currentTimeMillis() - j >= 86400000;
        com.tencent.tmsbeacon.base.util.c.a("[qimei] lastUpdateQimei time: " + j + ", isOver24h: " + z, new Object[0]);
        return z;
    }

    public static boolean c() {
        String a2 = com.tencent.tmsbeacon.d.g.b().a("qimeiZeroPeak");
        boolean z = false;
        if (a2 != null) {
            z = false;
            if ("y".equalsIgnoreCase(a2)) {
                z = false;
                if (Calendar.getInstance().get(11) == 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static void d() {
        g gVar = f39613a;
        if (gVar != null) {
            gVar.c();
        }
    }
}
