package com.igexin.push.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.push.f.o;
import com.igexin.sdk.main.SdkInitSwitch;
import com.igexin.sdk.main.SdkPushSwitch;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e.class */
public class e {
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    public static String I;
    public static boolean J = false;
    public static String K;
    public static String L;
    public static String M;
    public static String Z;

    /* renamed from: a  reason: collision with root package name */
    public static String f23495a = "";
    public static int aA = 0;
    public static byte[] aB;
    public static long aH = 0;
    private static final String aM = "CoreRuntimeInfo";
    private static Map<String, Integer> aN;
    public static String ac;
    public static byte[] ad;
    public static boolean ae = false;
    public static boolean af = false;
    public static boolean ag = false;
    public static Map<String, PushTaskBean> ah;
    public static Map<String, Integer> ai;
    public static Map<String, HashSet<String>> aj;
    public static Map<String, Integer> ak;
    public static HashMap<String, Long> al;
    public static String an;
    public static long ao = 0;
    public static String ap;
    public static String aq;

    /* renamed from: ar  reason: collision with root package name */
    public static String f23496ar;
    public static String as;
    public static String at;
    public static String au;
    public static long av = 0;
    public static long aw = 0;
    public static volatile long ax = 0;
    public static long ay = 0;
    public static boolean az = false;
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static long f23497c = 0;
    public static String d;
    public static String e;
    public static String f = "";
    public static String g = "";
    public static String h;
    public static String i = "";
    public static int j;
    public static int k;
    public static Context l;
    public static volatile boolean s;
    public static volatile boolean u;
    public static volatile boolean v;
    public static AtomicBoolean m = new AtomicBoolean(false);
    public static boolean n = true;
    public static HashMap<String, ClassLoader> o = new HashMap<>();
    public static volatile boolean p = true;
    public static volatile boolean q = false;
    public static int r = 0;
    public static boolean t = true;
    public static boolean w = true;
    public static int x = 0;
    public static int y = 0;
    public static long z = 0;
    public static String N = "";
    public static long O = -1;
    public static long P = -1;
    public static long Q = 0;
    public static long R = 0;
    public static long S = 0;
    public static long T = 0;
    public static long U = 0;
    public static String V = null;
    public static boolean W = false;
    public static long X = 0;
    public static long Y = 0;
    public static long aa = 0;
    public static int ab = 0;
    public static int am = 0;
    public static String aC = null;
    public static int aD = 3600;
    public static boolean aE = false;
    public static long aF = 7200000;
    public static long aG = 7200000;
    public static String aI = "oppo r9";
    public static int aJ = 200;
    public static String aK = "";
    public static String aL = "";

    public static int a(String str) {
        int intValue;
        synchronized (e.class) {
            try {
                if (aN.get(str) == null) {
                    aN.put(str, 0);
                }
                intValue = aN.get(str).intValue() - 1;
                aN.put(str, Integer.valueOf(intValue));
                if (intValue == 0) {
                    aN.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.a():void");
    }

    public static void a(long j2) {
        z = j2;
        A = com.igexin.c.b.a.b(String.valueOf(j2));
    }

    public static boolean a(Context context) {
        l = context;
        g = context.getPackageName();
        i = o.b(context, "sc", "").toString();
        ac = "getui.permission.GetuiService." + g;
        if (!d()) {
            com.igexin.c.a.c.a.a(aM, "parseManifests failed");
            com.igexin.c.a.c.a.a("CoreRuntimeInfo|parseManifests failed", new Object[0]);
            throw new IllegalArgumentException("parseManifests failed");
        }
        ad = com.igexin.c.b.a.b(f23495a + context.getPackageName()).getBytes();
        com.igexin.push.f.j.a();
        com.igexin.push.config.e.a();
        a();
        if (Build.VERSION.SDK_INT < 29) {
            System.currentTimeMillis();
            D = com.igexin.push.f.n.g();
            System.currentTimeMillis();
            E = com.igexin.push.f.n.f();
            System.currentTimeMillis();
        }
        F = com.igexin.push.f.n.e();
        G = com.igexin.push.f.n.d();
        n = com.igexin.push.f.c.e();
        ah = new ConcurrentHashMap();
        ai = new ConcurrentHashMap();
        aj = new HashMap();
        ak = new HashMap();
        al = new HashMap<>();
        s = com.igexin.push.core.d.d.a().b("p");
        aN = new HashMap();
        az = true;
        com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init success ##########", new Object[0]);
        if (new SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a("i", Boolean.TRUE);
            new SdkInitSwitch(l).delete();
        }
        if (new SdkPushSwitch(l).isSwitchOn()) {
            s = true;
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            new SdkPushSwitch(l).delete();
            return true;
        }
        return true;
    }

    public static boolean a(String str, Integer num) {
        synchronized (e.class) {
            try {
                int intValue = num.intValue();
                if (aN.get(str) != null) {
                    int intValue2 = aN.get(str).intValue() + num.intValue();
                    intValue = intValue2;
                    if (intValue2 == 0) {
                        aN.remove(str);
                        return false;
                    }
                }
                aN.put(str, Integer.valueOf(intValue));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ClassLoader b(String str) {
        String str2 = str.split(BridgeUtil.UNDERLINE_STR)[0];
        if (o.containsKey(str2)) {
            return o.get(str2);
        }
        return null;
    }

    private static void b() {
        if (new SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a("i", Boolean.TRUE);
            new SdkInitSwitch(l).delete();
        }
        if (new SdkPushSwitch(l).isSwitchOn()) {
            s = true;
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            new SdkPushSwitch(l).delete();
        }
    }

    private static String c() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    private static boolean d() {
        try {
            ApplicationInfo b2 = com.igexin.push.f.n.b(l);
            boolean z2 = false;
            if (b2 != null) {
                z2 = false;
                if (b2.metaData != null) {
                    String a2 = com.igexin.push.f.d.a(b2);
                    String str = a2;
                    if (TextUtils.isEmpty(a2)) {
                        str = b2.metaData.getString(b.b);
                    }
                    String str2 = str;
                    if (TextUtils.isEmpty(str)) {
                        str2 = b2.metaData.getString("GETUI_APPID");
                    }
                    String str3 = str2;
                    if (str2 != null) {
                        str3 = str2.trim();
                    }
                    b = b2.metaData.getString(b.d);
                    if (TextUtils.isEmpty(str3)) {
                        com.igexin.c.a.c.a.a(aM, "getui sdk init error, missing parm ######");
                        com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init error, missing parm #####", new Object[0]);
                        return false;
                    }
                    f23495a = str3;
                    f = SDKUrlConfig.getLocation();
                    z2 = true;
                }
            }
            return z2;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static void e() {
        if (Build.VERSION.SDK_INT < 29) {
            System.currentTimeMillis();
            D = com.igexin.push.f.n.g();
            System.currentTimeMillis();
            E = com.igexin.push.f.n.f();
            System.currentTimeMillis();
        }
        F = com.igexin.push.f.n.e();
        G = com.igexin.push.f.n.d();
    }
}
