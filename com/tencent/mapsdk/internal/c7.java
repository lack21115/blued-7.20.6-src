package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.tools.net.NetUtil;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c7.class */
public class c7 {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static int D = 0;
    public static int E = 0;
    public static int F = 0;
    public static int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    public static int K = 0;
    public static int L = 0;
    public static int M = 0;
    public static int N = 0;
    public static int O = 0;
    private static final int P = 4000000;
    private static final int Q = 53500000;
    private static final int R = 73670000;
    private static final int S = 135100000;
    private static final int T = -85000000;
    private static final int U = 85000000;
    private static final int V = -180000000;
    private static final int W = 180000000;
    private static int X = 0;
    private static int Y = 0;
    private static float Z = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    public static final File f23659a;
    private static final int a0 = 20;
    public static final File b;
    private static final double b0 = 6378137.0d;

    /* renamed from: c  reason: collision with root package name */
    public static final File f23660c;
    private static final double c0 = 4.007501668557849E7d;
    private static final String d = "Tencent";
    private static final double d0 = 0.017453292519943295d;
    private static final String e = "MapSDK";
    private static final double e0 = 2.68435456E8d;
    private static final String f = "Caches";
    private static String g;
    private static String h;
    private static String i;
    private static b j;
    private static final String k;
    private static final String l;
    public static final String m = "tencentmap/mapsdk_vector/";
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static int u = 0;
    private static String v;
    private static String w;
    private static float x = 0.0f;
    private static final int y = 100;
    public static final int z = -1;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c7$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f23661a;

        private b(boolean z) {
            this.f23661a = z;
        }

        public final String a() {
            return (c7.h == null || c7.h.equals(c7.g)) ? c7.g : c7.h;
        }

        public final String b() {
            return this.f23661a ? "" : c7.w;
        }

        public final String c() {
            return c7.o == null ? "" : c7.o;
        }

        public final float d() {
            return c7.Z;
        }

        public final float e() {
            return c7.x;
        }

        public final String f() {
            return (this.f23661a || c7.v == null) ? "" : c7.v;
        }

        public final String g() {
            return (this.f23661a || c7.r == null) ? "" : c7.r;
        }

        public final String h() {
            return (this.f23661a || c7.q == null) ? "" : c7.q;
        }

        public final String i() {
            return c7.l;
        }

        public final String j() {
            return c7.k;
        }

        public final String k() {
            return (this.f23661a || c7.s == null) ? "" : c7.s;
        }

        public final int l() {
            if (this.f23661a) {
                return 0;
            }
            return c7.u;
        }

        public final String m() {
            return (c7.i == null || TextUtils.isEmpty(c7.i) || c7.i.equals(c7.t)) ? c7.t == null ? "" : c7.t : c7.i;
        }

        public final String n() {
            return (this.f23661a || c7.p == null) ? "" : c7.p;
        }

        public final int o() {
            return c7.X;
        }

        public final String p() {
            return NetUtil.STR_UserAgent;
        }
    }

    static {
        File file = new File(Environment.getExternalStorageDirectory(), D());
        f23659a = file;
        File file2 = new File(file, C());
        b = file2;
        f23660c = new File(file2, B());
        g = null;
        h = null;
        i = null;
        String str = mi.j;
        k = str;
        l = str;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = 0;
        v = null;
        w = "undefined";
        x = 1.0f;
        D = 2;
        E = 0;
        F = 0;
        G = 0;
        K = 2;
        L = P;
        M = Q;
        N = R;
        O = S;
        X = 0;
        Y = 160;
        Z = 0.0f;
    }

    public static String A() {
        return J().h();
    }

    public static String B() {
        return f;
    }

    public static String C() {
        return e;
    }

    public static String D() {
        return d;
    }

    public static String E() {
        return J().i();
    }

    public static String F() {
        return J().j();
    }

    public static String G() {
        return J().k();
    }

    public static b H() {
        return new b(false);
    }

    public static int I() {
        return J().l();
    }

    private static b J() {
        b bVar = j;
        return bVar != null ? bVar : new b(false);
    }

    public static String K() {
        return J().n();
    }

    public static int L() {
        return J().o();
    }

    public static String M() {
        return J().c();
    }

    public static String N() {
        return J().m();
    }

    public static String O() {
        return J().p();
    }

    public static void P() {
        j = null;
        i = null;
        h = null;
    }

    public static double a(double d2, double d3) {
        return (d2 * 6.698324247899813d) / Math.cos(d3 * d0);
    }

    public static float a(int i2) {
        return i2 / 255.0f;
    }

    public static String a(String str, String str2) {
        String e2;
        if (f7.b(str)) {
            str = "";
        }
        if (f7.b(str2)) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder(256);
        sb.append("key=");
        sb.append(t());
        sb.append("&pid=");
        sb.append(N());
        sb.append("&key2=");
        sb.append(str);
        sb.append("&pid2=");
        sb.append(str2);
        sb.append("&psv=");
        sb.append(M());
        sb.append("&ver=");
        sb.append(E());
        sb.append("&pf=");
        sb.append(O());
        sb.append("&hm=");
        sb.append(y());
        sb.append("&suid=");
        sb.append(A());
        sb.append("&os=");
        sb.append(I());
        sb.append("&dip=");
        sb.append(K());
        sb.append("&nt=");
        sb.append(G());
        sb.append("&channel=1&output=json");
        if (!TextUtils.isEmpty(w)) {
            try {
                e2 = URLEncoder.encode(w, "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e2 = e(w);
            }
            sb.append("&cuid=");
            sb.append(e2);
            sb.append("&uuid=");
            sb.append(e2);
        }
        return sb.toString();
    }

    private static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.toString();
            }
            sb.append(Integer.toHexString(bArr[i3] & 255));
            sb.append(str);
            i2 = i3 + 1;
        }
    }

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        X = displayMetrics.widthPixels * displayMetrics.heightPixels;
        if (Build.VERSION.SDK_INT < 24) {
            b(displayMetrics);
        } else {
            a(displayMetrics);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        ga.e = f23660c;
        h = str;
        i = str2;
        w = str3;
        if (X == 0) {
            a(context);
        }
        if (v == null) {
            try {
                String c2 = g7.c();
                v = c2;
                String b2 = b(c2);
                v = b2;
                v = URLEncoder.encode(b2, "utf-8");
            } catch (Exception e2) {
            }
        }
        if (u == 0) {
            u = Build.VERSION.SDK_INT;
        }
        if (t == null) {
            try {
                String packageName = context.getPackageName();
                t = packageName;
                String b3 = b(packageName);
                t = b3;
                t = URLEncoder.encode(b3, "utf-8");
            } catch (Exception e3) {
            }
        }
        if (n == null) {
            try {
                String a2 = g7.a(context);
                n = a2;
                String b4 = b(a2);
                n = b4;
                n = URLEncoder.encode(b4, "utf-8");
            } catch (Exception e4) {
            }
        }
        if (o == null) {
            try {
                String b5 = g7.b(context);
                o = b5;
                String b6 = b(b5);
                o = b6;
                o = URLEncoder.encode(b6, "utf-8");
            } catch (Exception e5) {
            }
        }
        if (p == null) {
            try {
                String g2 = g7.g(context);
                p = g2;
                String b7 = b(g2);
                p = b7;
                p = URLEncoder.encode(b7, "utf-8");
            } catch (Exception e6) {
            }
        }
        if (q == null) {
            try {
                String h2 = g7.h(context);
                q = h2;
                String b8 = b(h2);
                q = b8;
                q = URLEncoder.encode(b8, "utf-8");
            } catch (Exception e7) {
            }
        }
        if (TextUtils.isEmpty(r)) {
            try {
                String e8 = g7.e(context);
                r = e8;
                String b9 = b(e8);
                r = b9;
                r = URLEncoder.encode(b9, "utf-8");
            } catch (Exception e9) {
            }
        }
        if (s == null) {
            try {
                String netTypeStr = NetUtil.getNetTypeStr(context);
                s = netTypeStr;
                String b10 = b(netTypeStr);
                s = b10;
                s = URLEncoder.encode(b10, "utf-8");
            } catch (Exception e10) {
            }
        }
        if (g == null) {
            try {
                String a3 = g7.a(context, "TencentMapSDK");
                g = a3;
                g = URLEncoder.encode(a3, "utf-8");
            } catch (Exception e11) {
            }
        }
        if (x == 1.0f) {
            x = 320.0f / context.getResources().getDisplayMetrics().densityDpi;
        }
        Z = context.getResources().getDisplayMetrics().density;
    }

    private static void a(DisplayMetrics displayMetrics) {
        Y = displayMetrics.densityDpi;
        r();
    }

    public static void a(boolean z2) {
        j = new b(z2);
    }

    public static boolean a(Context context, byte[] bArr, String str) {
        File fileStreamPath = context.getFileStreamPath("tecentmap");
        if (!fileStreamPath.exists()) {
            fileStreamPath.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fileStreamPath.getPath());
        sb.append("/");
        sb.append(str);
        return ha.a(bArr, sb.toString(), false) != 0;
    }

    public static byte[] a(Context context, String str) {
        File fileStreamPath = context.getFileStreamPath("tecentmap");
        InputStream c2 = ha.c(fileStreamPath.getPath() + "/" + str);
        byte[] b2 = ha.b(c2);
        ha.a((Closeable) c2);
        return b2;
    }

    public static String[] a(String str) {
        String[] strArr = new String[3];
        try {
            JSONObject jSONObject = new JSONObject(str);
            strArr[0] = jSONObject.optString("version");
            strArr[1] = jSONObject.optString("data");
            strArr[2] = jSONObject.optString("otherDistrict");
            return strArr;
        } catch (JSONException e2) {
            return strArr;
        }
    }

    public static int b(String str, String str2) {
        if (f7.b(str2)) {
            return 1;
        }
        if (f7.b(str)) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length;
        int i2 = length;
        if (length > split2.length) {
            i2 = split2.length;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                if (split.length > split2.length) {
                    return 1;
                }
                return split.length == split2.length ? 0 : -1;
            }
            String str3 = split2[i4];
            String str4 = split[i4];
            String str5 = str3;
            if (TextUtils.isEmpty(str3)) {
                str5 = "0";
            }
            String str6 = str4;
            if (TextUtils.isEmpty(str4)) {
                str6 = "0";
            }
            if (Integer.valueOf(str5).intValue() < Integer.valueOf(str6).intValue()) {
                return 1;
            }
            if (Integer.valueOf(str5).intValue() > Integer.valueOf(str6).intValue()) {
                return -1;
            }
            i3 = i4 + 1;
        }
    }

    public static String b(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        try {
            return URLEncoder.encode((applicationInfo != null ? applicationInfo.loadLabel(packageManager) : "can't find app name").toString(), "utf-8");
        } catch (Exception e3) {
            return "can't find app name";
        }
    }

    private static String b(String str) {
        return str == null ? "" : str.replace(ContainerUtils.FIELD_DELIMITER, "").replace("#", "").replace("?", "");
    }

    private static void b(DisplayMetrics displayMetrics) {
        Field field;
        try {
            field = displayMetrics.getClass().getField("densityDpi");
        } catch (NoSuchFieldException | SecurityException e2) {
            field = null;
        }
        if (field == null) {
            s();
            return;
        }
        try {
            Y = field.getInt(displayMetrics);
            r();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        }
    }

    public static void b(boolean z2) {
        if (z2) {
            N = R;
            O = S;
            M = Q;
            L = P;
            return;
        }
        N = -180000000;
        O = 180000000;
        M = 85000000;
        L = -85000000;
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest(), "");
        } catch (Exception e2) {
            return str;
        }
    }

    public static String d(String str) {
        StringBuilder sb = new StringBuilder(256);
        if (!TextUtils.isEmpty(q)) {
            sb.append("&suid=");
            sb.append(A());
        }
        if (!TextUtils.isEmpty(r)) {
            sb.append("&duid=");
            sb.append(z());
        }
        if (!TextUtils.isEmpty(t)) {
            sb.append("&appid=");
            sb.append(N());
        }
        if (!TextUtils.isEmpty(k)) {
            sb.append("&sdkver=");
            sb.append(F());
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append("&ui=");
            sb.append(str);
        }
        if (!TextUtils.isEmpty(w)) {
            sb.append("&appsuid=");
            try {
                sb.append(URLEncoder.encode(w, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                sb.append(e(w));
            }
            sb.append("&cuid=");
            sb.append(w);
        }
        sb.append("&api_key=" + t());
        return sb.toString();
    }

    private static String e(String str) throws PatternSyntaxException {
        return Pattern.compile(LocationProvider.BAD_CHARS_REGEX).matcher(str).replaceAll("").trim();
    }

    private static void r() {
        int i2 = Y;
        if (i2 <= 120) {
            K = 1;
        } else if (i2 <= 160) {
            K = 2;
        } else if (i2 <= 240) {
            K = 3;
        } else {
            s();
        }
    }

    private static void s() {
        int i2 = X;
        if (i2 > 153600) {
            K = 3;
        } else if (i2 < 153600) {
            K = 1;
        } else {
            K = 2;
        }
    }

    public static String t() {
        return J().a();
    }

    public static String u() {
        return J().b();
    }

    public static Date v() {
        return Calendar.getInstance().getTime();
    }

    public static float w() {
        return J().d();
    }

    public static float x() {
        return J().e();
    }

    public static String y() {
        return J().f();
    }

    public static String z() {
        return J().g();
    }
}
