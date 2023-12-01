package com.tencent.tendinsv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/t.class */
public class t {
    public static final String A = "cmccSwitch";
    public static final String B = "cuccSwitch";
    public static final String C = "ctccSwitch";
    public static final String D = "woSwitch";
    public static final String E = "accOff";
    public static final String F = "sto";
    public static final String G = "initTimeOut";
    public static final String H = "getPhoneInfoTimeOut";
    public static final String I = "openLoginAuthTimeOut";
    public static final String J = "initTimestart";
    public static final String K = "uuid";
    public static final String L = "DID";
    public static final String M = "reportMax";
    public static final String N = "pks";
    public static final String O = "rptDly";
    public static final String P = "backrp";
    public static final String Q = "ns";
    public static final String R = "preResult";
    public static final String S = "initResult";
    public static final String T = "initCount";
    public static final String U = "preInitStatus";
    public static String V = "deviceOaid";

    /* renamed from: a  reason: collision with root package name */
    public static final String f25423a = "sdkVersion";
    public static final String b = "authPageFlag";

    /* renamed from: c  reason: collision with root package name */
    public static final String f25424c = "cmccfn";
    public static final String d = "SIMOperator";
    public static final String e = "timeend";
    public static final String f = "preFailFlag";
    public static final String g = "ctcc_gwAuth";
    public static final String h = "clientAppId";
    public static final String i = "appId";
    public static final String j = "accountFlag";
    public static final String k = "cmccAppid";
    public static final String l = "cuccAppid";
    public static final String m = "ctccAppid";
    public static final String n = "woClientId";
    public static final String o = "cmccAppkey";
    public static final String p = "cuccAppkey";
    public static final String q = "ctccAppkey";
    public static final String r = "woClientSecret";
    public static final String s = "reportTimestart";
    public static final String t = "reportFlag";
    public static final String u = "reportCount";
    public static final String v = "cmccPreFlag";
    public static final String w = "ctccPreFlag";
    public static final String x = "cuccPreFlag";
    public static final String y = "initFlag";
    public static final String z = "ispStatus";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/t$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Method f25425a = a();

        private a() {
        }

        private static Method a() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        static void a(SharedPreferences.Editor editor) {
            try {
                if (f25425a != null) {
                    f25425a.invoke(editor, new Object[0]);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }

    public static void a(Context context, String str, int i2) {
        if (context != null) {
            try {
                a.a(u.a(context).b().putInt(str, i2));
            } catch (Exception e2) {
                l.d(com.tencent.tendinsv.b.F, "putInt--Exception__key=", str, "__value=", Integer.valueOf(i2), "__e==", e2);
            }
        }
    }

    public static void a(Context context, String str, long j2) {
        if (context != null) {
            try {
                a.a(u.a(context).b().putLong(str, j2));
            } catch (Exception e2) {
                l.d(com.tencent.tendinsv.b.F, "putLong--Exception__key=", str, "__value=", Long.valueOf(j2), "__e==", e2);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            try {
                a.a(u.a(context).b().putString(str, str2));
            } catch (Exception e2) {
                e2.printStackTrace();
                l.d(com.tencent.tendinsv.b.F, "putString--Exception__key=", str, "__value=", str2, "__e==", e2);
            }
        }
    }

    public static void a(Context context, String str, boolean z2) {
        if (context != null) {
            try {
                a.a(u.a(context).b().putBoolean(str, z2));
            } catch (Exception e2) {
                l.d(com.tencent.tendinsv.b.F, "putBoolean--Exception__key=", str, "__value=", Boolean.valueOf(z2), "__e==", e2);
            }
        }
    }

    public static int b(Context context, String str, int i2) {
        if (context != null) {
            try {
                return u.a(context).a().getInt(str, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                l.d(com.tencent.tendinsv.b.F, "getInt--Exception__key=", str, "__defaultValue=", Integer.valueOf(i2), "__e==", e2);
            }
        }
        return i2;
    }

    public static long b(Context context, String str, long j2) {
        if (context != null) {
            try {
                return u.a(context).a().getLong(str, j2);
            } catch (Exception e2) {
                e2.printStackTrace();
                l.d(com.tencent.tendinsv.b.F, "getLong--Exception__key=", str, "__defaultValue=", Long.valueOf(j2), "__e==", e2);
            }
        }
        return j2;
    }

    public static String b(Context context, String str, String str2) {
        if (context != null) {
            try {
                return u.a(context).a().getString(str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                l.d(com.tencent.tendinsv.b.F, "getString--Exception__key=", str, "__defaultValue=", str2, "__e==", e2);
            }
        }
        return str2;
    }

    public static boolean b(Context context, String str, boolean z2) {
        if (context != null) {
            try {
                return u.a(context).a().getBoolean(str, z2);
            } catch (Exception e2) {
                e2.printStackTrace();
                l.d(com.tencent.tendinsv.b.F, "getBoolean--Exception__key=", str, "__defaultValue=", Boolean.valueOf(z2), "__e==", e2);
            }
        }
        return z2;
    }
}
