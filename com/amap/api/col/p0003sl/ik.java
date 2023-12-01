package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.ik  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ik.class */
public final class ik {

    /* renamed from: a  reason: collision with root package name */
    public static int f5157a = 1;
    public static int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private String f5158c;
    private int d;
    private long e = System.currentTimeMillis();
    private String f;

    private ik(int i, String str, String str2) {
        this.f5158c = str2;
        this.d = i;
        this.f = str;
    }

    public static ik a(String str, String str2) {
        return new ik(f5157a, str, str2);
    }

    public static String a(int i) {
        return i == b ? "error" : "info";
    }

    public static String a(List<ik> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return "";
                }
                JSONArray jSONArray = new JSONArray();
                for (ik ikVar : list) {
                    String b2 = b(ikVar);
                    if (!TextUtils.isEmpty(b2)) {
                        jSONArray.put(b2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    public static boolean a(ik ikVar) {
        return (ikVar == null || TextUtils.isEmpty(ikVar.b())) ? false : true;
    }

    public static ik b(String str, String str2) {
        return new ik(b, str, str2);
    }

    private static String b(ik ikVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", ikVar.b());
            jSONObject.put(d.aw, ikVar.d());
            jSONObject.put("timestamp", ikVar.e);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private String d() {
        return this.f;
    }

    public final int a() {
        return this.d;
    }

    public final String b() {
        new JSONObject();
        return this.f5158c;
    }

    public final String c() {
        return a(this.d);
    }
}
