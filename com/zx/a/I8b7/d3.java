package com.zx.a.I8b7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.zx.a.I8b7.z1;
import com.zx.module.annotation.Java2C;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/d3.class */
public class d3 {

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f28425a;
    public static j1 b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f28426c = new HashMap<>();

    @Java2C.Method2C
    public static native String a();

    @Java2C.Method2C
    public static native String a(Context context);

    @Java2C.Method2C
    public static native String a(String str);

    public static String a(HashMap<String, String> hashMap, String str) {
        return hashMap.containsKey(str) ? hashMap.get(str) : "";
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            return c(context).checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            try {
                z1.a.f28543a.f28542a.f28451a.a(4, null, null, th);
                return z;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return z;
            }
        }
    }

    public static boolean a(Context context, boolean z) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Throwable th) {
            return z;
        }
    }

    @Java2C.Method2C
    public static native PackageInfo b(String str);

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (r0.equals("unknown") != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L1c
            r4 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L16
            r0 = r4
            r3 = r0
            r0 = r4
            java.lang.String r1 = "unknown"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1a
        L16:
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> L1c
            r3 = r0
        L1a:
            r0 = r3
            return r0
        L1c:
            r3 = move-exception
            r0 = r3
            com.zx.a.I8b7.z1.a(r0)
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.d3.b():java.lang.String");
    }

    @Java2C.Method2C
    public static native String b(Context context);

    public static PackageManager c(Context context) {
        if (f28425a == null) {
            f28425a = context.getPackageManager();
        }
        return f28425a;
    }

    public static String c() {
        int i = 0;
        String[] strArr = new String[0];
        if (Build.VERSION.SDK_INT >= 21) {
            strArr = Build.SUPPORTED_ABIS;
        }
        String str = "";
        String str2 = str;
        if (strArr != null) {
            str2 = str;
            if (strArr.length > 0) {
                int length = strArr.length;
                while (true) {
                    str2 = str;
                    if (i >= length) {
                        break;
                    }
                    str = str + strArr[i] + ",";
                    i++;
                }
            }
        }
        return str2;
    }

    @Java2C.Method2C
    public static native j1 d(Context context);

    @Java2C.Method2C
    public static native String d();

    @Java2C.Method2C
    public static native long e(Context context);

    @Java2C.Method2C
    public static native String e();

    @Java2C.Method2C
    public static final native String f();

    @Java2C.Method2C
    private static native boolean f(Context context);

    @Java2C.Method2C
    public static native String g();

    @Java2C.Method2C
    public static native HashMap<String, String> h();

    @Java2C.Method2C
    public static native String i();

    @Java2C.Method2C
    public static native long j();

    @Java2C.Method2C
    public static native boolean k();
}
