package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q3.class */
public class q3 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f3897a = false;
    public static volatile String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f3898c = "";
    public static volatile String d = "";
    public static volatile boolean e = true;
    public static final byte[] f = new byte[0];
    public static HashMap<String, Object> g = new HashMap<>();

    @Deprecated
    public static String a() {
        return "";
    }

    @Deprecated
    public static String a(Context context) {
        try {
            CharSequence loadLabel = context.getApplicationInfo().loadLabel(context.getPackageManager());
            String replaceAll = loadLabel == null ? GrsBaseInfo.CountryCodeSource.UNKNOWN : loadLabel.toString().replaceAll("_", "");
            String replaceAll2 = context.getPackageName().replaceAll("_", "");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            return replaceAll + "_" + replaceAll2 + "_" + packageInfo.versionCode + "_" + packageInfo.versionName;
        } catch (Throwable th) {
            return "UNKNOWN AppInfo";
        }
    }

    public static String a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "0123456789ABCDEF";
        }
        return str2;
    }

    public static void a(boolean z) {
        synchronized (q3.class) {
            try {
                f3897a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Object b(String str) {
        Object obj;
        synchronized (q3.class) {
            try {
                Object obj2 = g.get(str);
                obj = obj2;
                if (obj2 == null) {
                    Object systemService = q2.a().getSystemService(str);
                    obj = systemService;
                    if (systemService != null) {
                        g.put(str, systemService);
                        obj = systemService;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public static String b() {
        return a(q2.a());
    }

    @Deprecated
    public static String b(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static String c() {
        Context a2 = q2.a();
        CharSequence loadLabel = a2.getApplicationInfo().loadLabel(a2.getPackageManager());
        return loadLabel == null ? GrsBaseInfo.CountryCodeSource.UNKNOWN : loadLabel.toString();
    }

    public static String d() {
        return b(q2.a());
    }

    public static String e() {
        Context a2 = q2.a();
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            return "unknown";
        }
    }

    public static String f() {
        String g2 = g();
        try {
            if (TextUtils.isEmpty(d)) {
                d = p3.a(p3.a(), "loc_build_model_encr", "");
                if (TextUtils.isEmpty(d)) {
                    d = i3.a(g2, "MD5");
                    if (d.length() > 8) {
                        d = d.substring(0, 8);
                    }
                    p3.b(p3.a(), "loc_build_model_encr", d);
                }
            }
        } catch (Exception e2) {
        }
        if (!e) {
            return "_" + d;
        }
        e = false;
        return g2 + "_" + d;
    }

    public static String g() {
        o();
        if (TextUtils.isEmpty(f3898c)) {
            f3898c = p3.a(p3.a(), "loc_build_model", "");
            if (TextUtils.isEmpty(f3898c)) {
                f3898c = Build.MODEL;
                p3.b(p3.a(), "loc_build_model", f3898c);
            }
        }
        return f3898c;
    }

    @Deprecated
    public static String h() {
        return "";
    }

    @Deprecated
    public static String i() {
        return "";
    }

    @Deprecated
    public static String j() {
        return "";
    }

    public static String k() {
        if (m3.a(b)) {
            synchronized (f) {
                b = (String) p3.a(p3.a(), "loc_id_LocCommId", (Object) "");
                if (m3.a(b)) {
                    long nanoTime = System.nanoTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    b = i3.a("" + ((currentTimeMillis * 1000000) + (nanoTime % 1000000)), "MD5");
                    p3.b(p3.a(), "loc_id_LocCommId", (Object) b);
                }
            }
        }
        return b;
    }

    @Deprecated
    public static String l() {
        return "";
    }

    @Deprecated
    public static String m() {
        return "";
    }

    public static String n() {
        String str = "";
        try {
            String replaceAll = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            StringBuilder sb = new StringBuilder();
            sb.append(replaceAll.substring(0, 5));
            sb.append(replaceAll.substring(8, 10));
            sb.append(replaceAll.substring(14, 16));
            sb.append(replaceAll.substring(16, 18));
            sb.append(replaceAll.substring(20, 25));
            str = replaceAll;
            return sb.toString();
        } catch (Exception e2) {
            String str2 = str;
            if (str.length() > 16) {
                str2 = str.substring(0, 16);
            }
            return str2;
        }
    }

    public static void o() {
        synchronized (q3.class) {
        }
    }

    public static boolean p() {
        boolean z;
        synchronized (q3.class) {
            try {
                z = f3897a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
