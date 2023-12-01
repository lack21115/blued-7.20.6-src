package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.hp;
import com.amap.api.col.p0003sl.ia;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.iw;
import com.amap.api.col.p0003sl.ki;
import com.amap.api.col.p0003sl.kk;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/a.class */
public final class a {
    private static volatile boolean h = false;
    private static boolean i = true;
    private static int j = 1000;
    private static int k = 200;
    private static boolean l = false;
    private static int m = 20;
    private static int n = 0;
    private static volatile int o = 0;
    private static boolean p = true;
    private static boolean q = false;
    private static int r = -1;
    private static long s;
    private static ArrayList<String> t = new ArrayList<>();
    private static ArrayList<String> u = new ArrayList<>();
    private static volatile boolean v = false;
    private static boolean w = true;
    private static long x = 300000;
    private static boolean y = false;
    private static double z = 0.618d;
    private static boolean A = true;
    private static int B = 80;

    /* renamed from: a  reason: collision with root package name */
    static long f9275a = 3600000;
    private static boolean C = false;
    private static boolean D = true;
    private static boolean E = false;
    public static volatile long b = 0;

    /* renamed from: c  reason: collision with root package name */
    static boolean f9276c = true;
    private static boolean F = true;
    private static long G = -1;
    private static boolean H = true;
    private static int I = 1;
    private static boolean J = false;
    private static int K = 5;
    private static boolean L = false;
    private static String M = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long N = 0;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 10800000;

    public static void a(final Context context) {
        if (h) {
            return;
        }
        h = true;
        hp.a(context, b.c(), b.d(), new hp.a() { // from class: com.autonavi.aps.amapapi.utils.a.1
            @Override // com.amap.api.col.p0003sl.hp.a
            public final void a(hp.b bVar) {
                a.a(Context.this, bVar);
            }
        });
    }

    private static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                long optInt = optJSONObject.optInt("at", 123) * 60 * 1000;
                f9275a = optInt;
                h.a(editor, "13S_at", optInt);
                d(optJSONObject, editor);
                try {
                    boolean a2 = hp.a(optJSONObject.optString("nla"), true);
                    D = a2;
                    h.a(editor, "13S_nla", a2);
                } catch (Throwable th) {
                }
                try {
                    boolean a3 = hp.a(optJSONObject.optString("asw"), true);
                    F = a3;
                    h.a(editor, "asw", a3);
                } catch (Throwable th2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray == null || optJSONArray.length() <= 0 || context == null) {
                        E = false;
                        h.a(editor, "13S_mlpl");
                        return;
                    }
                    h.a(editor, "13S_mlpl", ib.b(optJSONArray.toString()));
                    E = a(context, optJSONArray);
                } catch (Throwable th3) {
                }
            }
        } catch (Throwable th4) {
            b.a(th4, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static void a(hp.b bVar, SharedPreferences.Editor editor) {
        try {
            hp.b.a aVar = bVar.g;
            if (aVar != null) {
                boolean z2 = aVar.f5086a;
                i = z2;
                h.a(editor, "exception", z2);
                JSONObject jSONObject = aVar.f5087c;
                if (jSONObject != null) {
                    j = jSONObject.optInt("fn", j);
                    int optInt = jSONObject.optInt("mpn", k);
                    k = optInt;
                    if (optInt > 500) {
                        k = 500;
                    }
                    if (k < 30) {
                        k = 30;
                    }
                    l = hp.a(jSONObject.optString("igu"), false);
                    m = jSONObject.optInt("ms", m);
                    o = jSONObject.optInt("rot", 0);
                    n = jSONObject.optInt("pms", 0);
                }
                ki.a(j, l, m, n);
                kk.a(l, n);
                h.a(editor, "fn", j);
                h.a(editor, "mpn", k);
                h.a(editor, "igu", l);
                h.a(editor, "ms", m);
                h.a(editor, "rot", o);
                h.a(editor, "pms", n);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean a2 = hp.a(optJSONObject.optString("able"), true);
                w = a2;
                if (a2) {
                    x = optJSONObject.optInt("c", 300) * 1000;
                }
                y = hp.a(optJSONObject.optString("fa"), false);
                z = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                h.a(editor, com.igexin.push.core.b.Y, w);
                h.a(editor, com.anythink.expressad.d.a.b.dx, x);
                h.a(editor, "11G_fa", y);
                h.a(editor, "11G_ms", String.valueOf(z));
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean a() {
        return i;
    }

    public static boolean a(long j2) {
        if (w) {
            long a2 = i.a();
            long j3 = x;
            return j3 < 0 || a2 - j2 < j3;
        }
        return false;
    }

    static boolean a(Context context, hp.b bVar) {
        SharedPreferences.Editor editor;
        try {
            SharedPreferences.Editor a2 = h.a(context, "pref");
            try {
                a(bVar, a2);
                c(context);
                JSONObject jSONObject = bVar.f;
                if (jSONObject == null) {
                    if (a2 != null) {
                        try {
                            h.a(a2);
                            return true;
                        } catch (Throwable th) {
                            return true;
                        }
                    }
                    return true;
                }
                a(context, jSONObject, a2);
                a(jSONObject, a2);
                c(jSONObject, a2);
                e(jSONObject, a2);
                g(jSONObject, a2);
                f(jSONObject, a2);
                h(jSONObject, a2);
                b(jSONObject, a2);
                if (a2 != null) {
                    try {
                        h.a(a2);
                        return true;
                    } catch (Throwable th2) {
                        return true;
                    }
                }
                return true;
            } catch (Throwable th3) {
                editor = a2;
                if (editor != null) {
                    try {
                        h.a(editor);
                        return false;
                    } catch (Throwable th4) {
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable th5) {
            editor = null;
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        try {
            if (jSONArray.length() <= 0 || context == null) {
                return false;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    return false;
                }
                if (i.b(context, jSONArray.getString(i3))) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static int b() {
        return k;
    }

    public static void b(Context context) {
        if (v) {
            return;
        }
        v = true;
        try {
            i = h.a(context, "pref", "exception", i);
            c(context);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            j = h.a(context, "pref", "fn", j);
            k = h.a(context, "pref", "mpn", k);
            l = h.a(context, "pref", "igu", l);
            m = h.a(context, "pref", "ms", m);
            o = h.a(context, "pref", "rot", 0);
            int a2 = h.a(context, "pref", "pms", 0);
            n = a2;
            ki.a(j, l, m, a2);
            kk.a(l, n);
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            w = h.a(context, "pref", com.igexin.push.core.b.Y, w);
            x = h.a(context, "pref", com.anythink.expressad.d.a.b.dx, x);
            y = h.a(context, "pref", "11G_fa", y);
            double doubleValue = Double.valueOf(h.a(context, "pref", "11G_ms", String.valueOf(z))).doubleValue();
            z = doubleValue;
            z = Math.max(0.2d, doubleValue);
        } catch (Throwable th3) {
            b.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f9276c = h.a(context, "pref", com.anythink.expressad.video.dynview.a.a.Z, f9276c);
        } catch (Throwable th4) {
            b.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            F = h.a(context, "pref", "asw", F);
        } catch (Throwable th5) {
            b.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            G = h.a(context, "pref", "awsi", G);
        } catch (Throwable th6) {
            b.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            H = h.a(context, "pref", "15ua", H);
            I = h.a(context, "pref", "15un", I);
            N = h.a(context, "pref", "15ust", N);
        } catch (Throwable th7) {
            b.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            J = h.a(context, "pref", "ok9", J);
            K = h.a(context, "pref", "ok10", K);
            M = h.a(context, "pref", "ok11", M);
        } catch (Throwable th8) {
            b.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            d = h.a(context, "pref", "17ya", false);
            e = h.a(context, "pref", "17ym", false);
            g = h.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f = h.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            b.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            b = i.b();
            f9275a = h.a(context, "pref", "13S_at", f9275a);
            D = h.a(context, "pref", "13S_nla", D);
            A = h.a(context, "pref", "13J_able", A);
            B = h.a(context, "pref", "13J_c", B);
        } catch (Throwable th10) {
            b.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        hp.b(context);
        try {
            String a3 = h.a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(a3)) {
                E = a(context, new JSONArray(ib.c(a3)));
            }
        } catch (Throwable th11) {
            b.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean a4 = h.a(context, "pref", "197a", false);
            String a5 = h.a(context, "pref", "197dv", "");
            String a6 = h.a(context, "pref", "197tv", "");
            if (a4 && b.f9278a.equals(a5)) {
                for (String str : b.b) {
                    if (str.equals(a6)) {
                        b.f9278a = a6;
                    }
                }
            }
        } catch (Throwable th12) {
            b.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean a2 = hp.a(jSONObject2.optString("able"), false);
                h.a(editor, "197a", a2);
                if (a2) {
                    h.a(editor, "197dv", jSONObject2.optString("sv", ""));
                    h.a(editor, "197tv", jSONObject2.optString("tv", ""));
                    return;
                }
                h.a(editor, "197dv", "");
                h.a(editor, "197tv", "");
            }
        } catch (Throwable th) {
        }
    }

    public static int c() {
        if (o < 0) {
            o = 0;
        }
        return o;
    }

    public static void c(Context context) {
        try {
            ia c2 = b.c();
            c2.a(i);
            iw.a(context, c2);
        } catch (Throwable th) {
        }
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean a2 = hp.a(optJSONObject.optString("able"), true);
                A = a2;
                if (a2) {
                    B = optJSONObject.optInt("c", B);
                }
                h.a(editor, "13J_able", A);
                h.a(editor, "13J_c", B);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    public static long d() {
        return x;
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a2 = hp.a(jSONObject.optString("re"), true);
            f9276c = a2;
            h.a(editor, com.anythink.expressad.video.dynview.a.a.Z, a2);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (hp.a(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(Build.MANUFACTURER))) {
                    G = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    G = -1L;
                }
                h.a(editor, "awsi", G);
            }
        } catch (Throwable th) {
        }
    }

    public static boolean e() {
        return w;
    }

    private static void f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean a2 = hp.a(jSONObject2.optString("able"), false);
                d = a2;
                h.a(editor, "17ya", a2);
                boolean a3 = hp.a(jSONObject2.optString("mup"), false);
                e = a3;
                h.a(editor, "17ym", a3);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    h.a(editor, "17yx", optInt);
                    f = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    h.a(editor, "17yi", optInt2);
                    g = optInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable th) {
        }
    }

    public static boolean f() {
        return y;
    }

    public static double g() {
        return z;
    }

    private static void g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean a2 = hp.a(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", I);
                N = optJSONObject.optLong("sysTime", N);
                h.a(editor, "15ua", a2);
                h.a(editor, "15un", optInt);
                h.a(editor, "15ust", N);
            }
        } catch (Throwable th) {
        }
    }

    private static void h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean a2 = hp.a(optJSONObject.optString("able"), false);
                J = a2;
                h.a(editor, "ok9", a2);
                if (a2) {
                    String optString = optJSONObject.optString(com.alipay.sdk.app.statistic.c.d);
                    String optString2 = optJSONObject.optString("ht");
                    M = optString2;
                    h.a(editor, "ok11", optString2);
                    hp.a(optString, false);
                    L = hp.a(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString("tm");
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    K = parseInt;
                    h.a(editor, "ok10", parseInt);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static boolean h() {
        return A;
    }

    public static int i() {
        return B;
    }

    public static boolean j() {
        return D;
    }

    public static boolean k() {
        return E;
    }

    public static boolean l() {
        return f9276c;
    }

    public static boolean m() {
        return F;
    }

    public static long n() {
        return G;
    }

    public static boolean o() {
        return L;
    }

    public static boolean p() {
        return J;
    }

    public static String q() {
        return ib.c(M);
    }

    public static boolean r() {
        return H && I > 0;
    }

    public static int s() {
        return I;
    }

    public static long t() {
        return N;
    }
}
