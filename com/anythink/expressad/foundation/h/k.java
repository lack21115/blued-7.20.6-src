package com.anythink.expressad.foundation.h;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/k.class */
public final class k extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7955a = "SameDiTool";
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f7956c;
    private static int d = -1;
    private static int e = -1;
    private static int f = -1;
    private static String g = "";
    private static String h = "";
    private static String i = "";
    private static String j = "";
    private static int k = 0;
    private static String l = "";
    private static String m = "";
    private static int n = -1;
    private static String o = "";
    private static int p = 0;
    private static String q = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.foundation.h.k$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/k$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7958a;

        AnonymousClass2(Context context) {
            this.f7958a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConnectivityManager connectivityManager;
            try {
                if (com.anythink.core.common.b.n.a().c("network_type")) {
                    return;
                }
                try {
                    if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() || this.f7958a == null || (connectivityManager = (ConnectivityManager) this.f7958a.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        int unused = k.f = 0;
                    } else if (activeNetworkInfo.getType() == 1) {
                        int unused2 = k.f = 9;
                    } else {
                        TelephonyManager telephonyManager = (TelephonyManager) this.f7958a.getSystemService("phone");
                        if (telephonyManager == null) {
                            int unused3 = k.f = 0;
                        } else {
                            int unused4 = k.f = k.a(telephonyManager.getNetworkType());
                        }
                    }
                } catch (Exception e) {
                }
            } catch (Throwable th) {
                o.b(k.f7955a, th.getMessage(), th);
                int unused5 = k.f = 0;
            }
        }
    }

    private k() {
    }

    public static int a() {
        try {
            Context g2 = com.anythink.core.common.b.n.a().g();
            if (com.anythink.core.common.b.n.a().c("network_type")) {
                return f;
            }
            try {
                if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() && g2 != null) {
                    if (f == -1) {
                        f = 0;
                        return 0;
                    }
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(g2);
                    if (com.anythink.expressad.foundation.g.h.a.b().getActiveCount() <= 0) {
                        com.anythink.expressad.foundation.g.h.a.b().execute(anonymousClass2);
                    }
                    return f;
                }
                return f;
            } catch (Exception e2) {
                return f;
            }
        } catch (Throwable th) {
            o.b(f7955a, th.getMessage(), th);
            f = 0;
            return 0;
        }
    }

    public static int a(int i2) {
        if (i2 != 20) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 0;
            }
        }
        return 5;
    }

    public static String a(Context context, int i2) {
        TelephonyManager telephonyManager;
        if (i2 == 0 || i2 == 9) {
            return "";
        }
        try {
            return (!com.anythink.expressad.foundation.g.a.bW || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            o.b(f7955a, th.getMessage(), th);
            return "";
        }
    }

    private static String a(String str, Context context) {
        try {
        } catch (Exception e2) {
            o.b(f7955a, e2.getMessage(), e2);
        }
        if (TextUtils.isEmpty(o)) {
            if (!TextUtils.isEmpty(str) && context != null) {
                o = context.getPackageManager().getInstallerPackageName(str);
                o.a(f7955a, "PKGSource:" + o);
            }
            return o;
        }
        return o;
    }

    private static void a(String str) {
        f7956c = j.a(str);
        b = str;
    }

    public static int b(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 1;
        }
        int i2 = configuration.orientation;
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
        }
        return 1;
    }

    public static String b() {
        if (com.anythink.core.common.b.n.a().c("model")) {
            return "";
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return Build.MANUFACTURER + " " + Build.MODEL;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return k;
        }
        int i2 = k;
        if (i2 == 0) {
            try {
                int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                k = i3;
                return i3;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return i2;
    }

    public static String c() {
        if (com.anythink.core.common.b.n.a().c("os_vc")) {
            return "";
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                if (TextUtils.isEmpty(h)) {
                    h = String.valueOf(d());
                }
                return h;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return j;
        }
        try {
            if (TextUtils.isEmpty(j)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                j = str;
                return str;
            }
            return j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        if (com.anythink.core.common.b.n.a().c("screen")) {
            return 0;
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() && context != null) {
                try {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    HashMap g2 = g(context);
                    return g2.get("width") == null ? displayMetrics.widthPixels : ((Integer) g2.get("width")).intValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return 0;
        } catch (Exception e3) {
            return 0;
        }
    }

    public static String e() {
        Context g2;
        long currentTimeMillis;
        long l2;
        String sb;
        String str;
        String str2 = "";
        try {
            g2 = com.anythink.core.common.b.n.a().g();
            currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            l2 = l();
            StringBuilder sb2 = new StringBuilder("app_tki_");
            sb2.append(currentTimeMillis);
            sb2.append(BridgeUtil.UNDERLINE_STR);
            sb2.append(l2);
            sb = sb2.toString();
            str = (String) v.b(g2, sb, "");
            str2 = str;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", "");
                    jSONObject.put("2", String.valueOf(l2));
                    jSONObject.put("3", String.valueOf(currentTimeMillis));
                    jSONObject.put("4", "");
                    jSONObject.put("5", "");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                String a2 = a.a(jSONObject.toString());
                str2 = a2;
                v.a(g2, sb, a2);
                str2 = a2;
            }
        } catch (Exception e4) {
            str2 = str;
            e = e4;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    public static int f() {
        if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
            if (d <= 0) {
                try {
                    Context g2 = com.anythink.core.common.b.n.a().g();
                    long longValue = ((Long) v.b(g2, "TotalRamSize", 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue > 1800000 || d == -1) {
                        d = Long.valueOf((l() / 1000) / 1000).intValue();
                        v.a(g2, "TotalRamSize", Long.valueOf(currentTimeMillis));
                    }
                } catch (Throwable th) {
                    o.b(f7955a, th.getMessage(), th);
                }
            }
            return d;
        }
        return 0;
    }

    public static int f(Context context) {
        if (com.anythink.core.common.b.n.a().c("screen")) {
            return 0;
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() && context != null) {
                try {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    HashMap g2 = g(context);
                    return g2.get("height") == null ? displayMetrics.heightPixels : ((Integer) g2.get("height")).intValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return 0;
        } catch (Exception e3) {
            return 0;
        }
    }

    public static int g() {
        try {
        } catch (Throwable th) {
            o.b(f7955a, th.getMessage(), th);
        }
        if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
            Context g2 = com.anythink.core.common.b.n.a().g();
            long j2 = 0;
            long longValue = ((Long) v.b(g2, "FreeRamSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || e == -1) {
                Context g3 = com.anythink.core.common.b.n.a().g();
                if (g3 != null) {
                    ActivityManager activityManager = (ActivityManager) g3.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j2 = memoryInfo.availMem;
                }
                e = Long.valueOf((j2 / 1000) / 1000).intValue();
                v.a(g2, "FreeRamSize", Long.valueOf(currentTimeMillis));
            }
            return e;
        }
        return 0;
    }

    public static HashMap g(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
            return hashMap;
        } catch (Exception e2) {
            o.b(f7955a, e2.getMessage(), e2);
            return hashMap;
        }
    }

    public static String h() {
        if (TextUtils.isEmpty(q)) {
            if (Build.VERSION.SDK_INT >= 21) {
                q = com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? Arrays.asList(Build.SUPPORTED_ABIS).toString() : "";
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.CPU_ABI);
                arrayList.add(com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? Build.CPU_ABI2 : "");
                q = arrayList.toString();
            }
        }
        return q;
    }

    public static String h(Context context) {
        if (context == null) {
            return i;
        }
        try {
            if (TextUtils.isEmpty(i)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                i = str;
                return str;
            }
            return i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int i() {
        return 0;
    }

    public static void i(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a(context);
            } else {
                com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.expressad.foundation.h.k.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a(Context.this);
                    }
                });
            }
        } catch (Throwable th) {
            o.b(f7955a, "", th);
        }
    }

    private static UUID j() {
        try {
            return UUID.randomUUID();
        } catch (Throwable th) {
            o.b(f7955a, th.getMessage(), th);
            return null;
        }
    }

    private static void j(Context context) {
        try {
            h(context);
            d(context);
            c(context);
            b(context);
            com.anythink.expressad.foundation.g.a.bX = t.a("android.permission.WRITE_EXTERNAL_STORAGE", context);
            com.anythink.expressad.foundation.g.a.bW = t.a("android.permission.ACCESS_NETWORK_STATE", context);
            k(context);
        } catch (Throwable th) {
        }
    }

    private static int k() {
        return n;
    }

    private static int k(Context context) {
        if (context == null) {
            return p;
        }
        if (p == 0) {
            try {
                p = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                o.d(f7955a, e2.getMessage());
            }
        }
        return p;
    }

    private static long l() {
        Context g2 = com.anythink.core.common.b.n.a().g();
        if (g2 != null) {
            ActivityManager activityManager = (ActivityManager) g2.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                return memoryInfo.totalMem;
            }
            return 0L;
        }
        return 0L;
    }

    private static void l(Context context) {
        try {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
            if (com.anythink.expressad.foundation.g.h.a.b().getActiveCount() <= 0) {
                com.anythink.expressad.foundation.g.h.a.b().execute(anonymousClass2);
            }
        } catch (Throwable th) {
            o.d(f7955a, th.getMessage());
        }
    }

    private static long m() {
        Context g2 = com.anythink.core.common.b.n.a().g();
        if (g2 != null) {
            ActivityManager activityManager = (ActivityManager) g2.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        }
        return 0L;
    }

    private static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 6.0d;
        } catch (Exception e2) {
            o.b(f7955a, e2.getMessage(), e2);
            return false;
        }
    }

    private static String n() {
        return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Arrays.asList(Build.SUPPORTED_ABIS).toString();
    }

    private static String o() {
        return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.CPU_ABI;
    }

    private static String p() {
        return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.CPU_ABI2;
    }
}
