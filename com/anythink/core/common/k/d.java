package com.anythink.core.common.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.g;
import com.anythink.core.common.k.g;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/d.class */
public final class d {
    public static String a;
    public static String b;
    public static String c;
    public static String d = "";
    static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i = "";
    private static String j = "";
    private static String k = "";
    private static String l = "";
    private static String m = "";
    private static int n = 0;
    private static String o = "";
    private static String p = "";
    private static String q;
    private static String r = "";
    private static String s = "";
    private static int t = -1;
    private static int u = -1;
    private static int v = -1;
    private static int w = -1;

    private d() {
    }

    private static int a(int i2) {
        if (i2 != 20) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
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
                    return 13;
                default:
                    return -1;
            }
        }
        return 16;
    }

    public static String a() {
        if (com.anythink.core.common.b.n.a().c("model")) {
            return "";
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.MODEL;
        } catch (Exception e2) {
            return "";
        }
    }

    public static void a(int i2, String str) {
        synchronized (d.class) {
            try {
                if (TextUtils.isEmpty(a)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(i2), str);
                        a = jSONObject.toString();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(a);
                    if (jSONObject2.has(String.valueOf(i2))) {
                        return;
                    }
                    jSONObject2.put(String.valueOf(i2), str);
                    a = jSONObject2.toString();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context) {
        try {
            d();
            k(context);
            i(context);
            h(context);
            g(context);
            a();
            b();
            d(context);
            f();
            f(context);
            c();
            n(context);
            a = p.b(context, com.anythink.core.common.b.g.o, g.o.e, "");
            if (h.a(com.anythink.china.common.d.a, context)) {
                String simOperator = ((TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY)).getSimOperator();
                if (!h.b(simOperator) || simOperator.length() <= 3) {
                    return;
                }
                r = simOperator.substring(0, 3);
                s = simOperator.substring(3, simOperator.length());
            }
        } catch (Exception e2) {
        }
    }

    public static void a(String str) {
        g = str;
        p.a(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.o, com.anythink.core.common.b.g.r, g);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0037 -> B:8:0x0033). Please submit an issue!!! */
    public static int b(String str) {
        int i2 = w;
        if (i2 != -1) {
            return i2;
        }
        w = 0;
        try {
            w = ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(c(str), new Object[0])).intValue();
        } catch (Throwable th) {
        }
        return w;
    }

    public static String b() {
        if (com.anythink.core.common.b.n.a().c("brand")) {
            return "";
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.BRAND;
        } catch (Exception e2) {
            return "";
        }
    }

    public static String b(Context context) {
        if (com.anythink.core.common.b.n.a().c("mcc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.b.n.a().g();
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : r;
        } catch (Exception e2) {
            return "";
        }
    }

    public static Object c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.anythink.core.common.b.n.a().g(), str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String c() {
        if (com.anythink.core.common.b.n.a().c("timezone")) {
            return "";
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                try {
                    if (TextUtils.isEmpty(p)) {
                        String displayName = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        p = displayName;
                        return displayName;
                    }
                } catch (Throwable th) {
                }
                return p;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static String c(Context context) {
        if (com.anythink.core.common.b.n.a().c("mnc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.b.n.a().g();
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : s;
        } catch (Exception e2) {
            return "";
        }
    }

    public static String d() {
        if (com.anythink.core.common.b.n.a().c("os_vc")) {
            return "";
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                if (TextUtils.isEmpty(k)) {
                    k = String.valueOf(Build.VERSION.SDK_INT);
                }
                return k;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static String d(Context context) {
        if (com.anythink.core.common.b.n.a().c("android_id")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                try {
                    if (h == null) {
                        String string = Settings.Secure.getString(context2.getContentResolver(), "android_id");
                        h = string;
                        if (string == null) {
                            h = "";
                        }
                    }
                } catch (Exception e2) {
                    h = "";
                }
                return h;
            }
            return "";
        } catch (Exception e3) {
            return "";
        }
    }

    static /* synthetic */ boolean d(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String e() {
        if (com.anythink.core.common.b.n.a().c("os_vn")) {
            return "";
        }
        if (TextUtils.isEmpty(j)) {
            j = Build.VERSION.RELEASE;
        }
        return j;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0026 -> B:10:0x0022). Please submit an issue!!! */
    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        e = null;
        try {
            if (TextUtils.isEmpty(null)) {
                String d2 = d(context);
                e = d2;
                e = f.b(d2);
            }
        } catch (Throwable th) {
        }
        return e;
    }

    private static boolean e(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String f() {
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                if (TextUtils.isEmpty(g)) {
                    g = p.b(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.o, com.anythink.core.common.b.g.r, "");
                }
                return g;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static String f(Context context) {
        if (com.anythink.core.common.b.n.a().c("language")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                if (TextUtils.isEmpty(o)) {
                    String language = context2.getResources().getConfiguration().locale.getLanguage();
                    o = language;
                    return language;
                }
                return o;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static int g(Context context) {
        if (com.anythink.core.common.b.n.a().c("orient")) {
            return 0;
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        int i2 = context2.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
        }
        return 1;
    }

    public static String g() {
        if (com.anythink.core.common.b.n.a().b() == null) {
            return "";
        }
        try {
            return new BigDecimal((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d).setScale(6, 4).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String h(Context context) {
        if (com.anythink.core.common.b.n.a().c("app_vc")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        if (n != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            return sb.toString();
        }
        try {
            n = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(n);
            return sb2.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static JSONObject h() {
        if (!TextUtils.isEmpty(a)) {
            try {
                return new JSONObject(a);
            } catch (Exception e2) {
            }
        }
        return new JSONObject();
    }

    public static String i() {
        synchronized (d.class) {
            try {
                if (com.anythink.core.common.b.n.a().c("ua")) {
                    return "";
                }
                try {
                    if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                        if (!TextUtils.isEmpty(i)) {
                            return i;
                        }
                        String str = Build.VERSION.RELEASE;
                        String a2 = a();
                        String str2 = Build.ID;
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(a2) || TextUtils.isEmpty(str2)) {
                            return "";
                        }
                        return "Mozilla/5.0 (Linux; Android " + str + "; " + a2 + " Build/" + str2 + ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
                    }
                    return "";
                } catch (Exception e2) {
                    return "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String i(Context context) {
        if (com.anythink.core.common.b.n.a().c("app_vn")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (TextUtils.isEmpty(m)) {
                String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                m = str;
                return str;
            }
            return m;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String j() {
        if (TextUtils.isEmpty(d)) {
            String G = com.anythink.core.common.b.n.a().G();
            if (!TextUtils.isEmpty(G)) {
                d = G;
                return G;
            }
            String G2 = com.anythink.core.common.b.n.a().G();
            String str = G2;
            if (TextUtils.isEmpty(G2)) {
                try {
                    Class.forName("com.unity3d.player.UnityPlayer");
                    str = "2";
                } catch (Throwable th) {
                    str = "1";
                }
                try {
                    Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
                    str = "3";
                    Class.forName("org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge");
                    str = "4";
                } catch (Throwable th2) {
                }
            }
            d = str;
            return str;
        }
        return d;
    }

    public static String j(Context context) {
        if (com.anythink.core.common.b.n.a().c("screen")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                StringBuilder sb = new StringBuilder();
                sb.append((context2 == null ? com.anythink.core.common.b.n.a().g() : context2).getResources().getDisplayMetrics().widthPixels);
                sb.append(PhoneConstants.APN_TYPE_ALL);
                Context context3 = context2;
                if (context2 == null) {
                    context3 = com.anythink.core.common.b.n.a().g();
                }
                sb.append(context3.getResources().getDisplayMetrics().heightPixels);
                return sb.toString();
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public static int k() {
        if (u == -1) {
            if (TextUtils.isEmpty(l())) {
                u = 0;
            } else {
                try {
                    Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                    Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
                    u = 1;
                } catch (Throwable th) {
                    u = 0;
                }
            }
        }
        return u;
    }

    public static String k(Context context) {
        if (com.anythink.core.common.b.n.a().c("package_name")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (TextUtils.isEmpty(l)) {
                String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).packageName;
                l = str;
                return str;
            }
            return l;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String l() {
        Object obj;
        String d2 = com.anythink.core.common.b.n.a().d();
        if (TextUtils.isEmpty(d2)) {
            try {
                Map<String, Object> m2 = com.anythink.core.common.b.n.a().m();
                if (m2 == null || (obj = m2.get(ATAdConst.KEY.WECHAT_APPID)) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return d2;
    }

    public static String l(Context context) {
        if (com.anythink.core.common.b.n.a().c("it_src")) {
            return "";
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (TextUtils.isEmpty(b)) {
                String installerPackageName = context2.getPackageManager().getInstallerPackageName(k(context2));
                b = installerPackageName;
                return installerPackageName;
            }
            return b;
        } catch (Exception e2) {
            return "";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:8:0x0028). Please submit an issue!!! */
    public static int m() {
        int i2 = v;
        if (i2 != -1) {
            return i2;
        }
        v = 0;
        try {
            v = ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th) {
        }
        return v;
    }

    public static String m(Context context) {
        NetworkInfo activeNetworkInfo;
        if (com.anythink.core.common.b.n.a().c("network_type")) {
            return "";
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                if (context == null) {
                    return YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null || !h.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
                    }
                    int i2 = 1;
                    if (activeNetworkInfo.getType() == 1) {
                        return "-2";
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
                    if (telephonyManager == null) {
                        return YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
                    }
                    int networkType = telephonyManager.getNetworkType();
                    StringBuilder sb = new StringBuilder();
                    if (networkType != 20) {
                        switch (networkType) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                i2 = 3;
                                break;
                            case 13:
                                i2 = 13;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 16;
                    }
                    sb.append(i2);
                    return sb.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
                }
            }
            return "";
        } catch (Exception e3) {
            return "";
        }
    }

    private static int n() {
        return Build.VERSION.SDK_INT;
    }

    public static String n(Context context) {
        String str = q;
        if (str != null) {
            if (str == null) {
                q = "";
            }
            return q;
        }
        try {
            String str2 = context.getPackageManager().getPackageInfo(g.a.a, 0).versionName;
            q = str2;
            if (str2 == null) {
                q = "";
            }
            return q;
        } catch (Exception e2) {
            q = "";
            return "";
        }
    }

    public static String o(Context context) {
        if (com.anythink.core.common.b.n.a().b() == null) {
            return "";
        }
        if (TextUtils.isEmpty(c)) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            c = String.valueOf(displayMetrics.density);
        }
        return c;
    }

    public static void p(Context context) {
        if (com.anythink.core.common.b.n.a().c("ua")) {
            return;
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                i = p.b(context, com.anythink.core.common.b.g.o, com.anythink.core.common.b.g.e, "");
                String b2 = p.b(context, com.anythink.core.common.b.g.o, com.anythink.core.common.b.g.f, "");
                if (TextUtils.isEmpty(i) || !Build.VERSION.RELEASE.equals(b2)) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        if (TextUtils.isEmpty(i)) {
                        }
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        i = WebSettings.getDefaultUserAgent(context);
                    } else {
                        WebView webView = new WebView(context);
                        g.a(webView);
                        i = webView.getSettings().getUserAgentString();
                    }
                    try {
                        p.a(context, com.anythink.core.common.b.g.o, com.anythink.core.common.b.g.e, i);
                        p.a(context, com.anythink.core.common.b.g.o, com.anythink.core.common.b.g.f, Build.VERSION.RELEASE);
                    } catch (Throwable th) {
                    }
                    if (TextUtils.isEmpty(i)) {
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (java.util.regex.Pattern.matches("^[0-]+$", r9) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void q(android.content.Context r6) {
        /*
            java.lang.Class<com.anythink.core.common.k.d> r0 = com.anythink.core.common.k.d.class
            monitor-enter(r0)
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r0.x()     // Catch: java.lang.Throwable -> L7f
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7f
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L15
            java.lang.Class<com.anythink.core.common.k.d> r0 = com.anythink.core.common.k.d.class
            monitor-exit(r0)
            return
        L15:
            java.lang.String r0 = ""
            r8 = r0
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L7f
            com.anythink.core.api.IExHandler r0 = r0.b()     // Catch: java.lang.Throwable -> L7f
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L2b
            r0 = r9
            r1 = r6
            java.lang.String r0 = r0.getUniqueId(r1)     // Catch: java.lang.Throwable -> L7f
            r8 = r0
        L2b:
            r0 = r8
            r9 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L39
            r0 = r6
            java.lang.String r0 = r(r0)     // Catch: java.lang.Throwable -> L7f
            r9 = r0
        L39:
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7f
            if (r0 != 0) goto L4c
            r0 = r9
            r8 = r0
            java.lang.String r0 = "^[0-]+$"
            r1 = r9
            boolean r0 = java.util.regex.Pattern.matches(r0, r1)     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L51
        L4c:
            r0 = r6
            java.lang.String r0 = d(r0)     // Catch: java.lang.Throwable -> L7f
            r8 = r0
        L51:
            r0 = r8
            r6 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L61
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7f
            r6 = r0
        L61:
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L7f java.lang.Throwable -> L7f
            r1 = r6
            java.lang.String r1 = com.anythink.core.common.k.f.a(r1)     // Catch: java.lang.Throwable -> L7f
            r0.k(r1)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = ""
            java.lang.String r1 = "3"
            java.lang.String r2 = ""
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L7f
            com.anythink.core.common.j.c.a(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L7f
            java.lang.Class<com.anythink.core.common.k.d> r0 = com.anythink.core.common.k.d.class
            monitor-exit(r0)
            return
        L7f:
            r6 = move-exception
            java.lang.Class<com.anythink.core.common.k.d> r0 = com.anythink.core.common.k.d.class
            monitor-exit(r0)
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.d.q(android.content.Context):void");
    }

    public static String r(final Context context) {
        synchronized (d.class) {
            try {
                if (com.anythink.core.common.b.n.a().c("gaid")) {
                    return "";
                }
                final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
                final String[] strArr = new String[1];
                newFixedThreadPool.submit(new Runnable() { // from class: com.anythink.core.common.k.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                            Class<?> cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                            strArr[0] = (String) cls2.getMethod("getId", new Class[0]).invoke(cls.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                        } catch (Throwable th) {
                            try {
                                strArr[0] = new com.anythink.core.common.b.c().a(context).a();
                            } catch (Exception e2) {
                            }
                        }
                        if (!TextUtils.isEmpty(strArr[0]) && !d.d(strArr[0])) {
                            d.a(strArr[0]);
                        }
                        try {
                            synchronized (newFixedThreadPool) {
                                newFixedThreadPool.notifyAll();
                            }
                        } catch (Throwable th2) {
                        }
                    }
                });
                try {
                    synchronized (newFixedThreadPool) {
                        newFixedThreadPool.wait(2000L);
                    }
                    newFixedThreadPool.shutdown();
                    if (strArr[0] != null) {
                        return strArr[0];
                    }
                    return "";
                } catch (Exception e2) {
                    return "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static int s(Context context) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static int t(Context context) {
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        return context2.getResources().getDisplayMetrics().widthPixels;
    }

    private static int u(Context context) {
        Context context2 = context;
        if (context == null) {
            context2 = com.anythink.core.common.b.n.a().g();
        }
        return context2.getResources().getDisplayMetrics().heightPixels;
    }

    private static int v(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || !h.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return -2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getNetworkType();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static void w(Context context) {
        a = p.b(context, com.anythink.core.common.b.g.o, g.o.e, "");
    }
}
