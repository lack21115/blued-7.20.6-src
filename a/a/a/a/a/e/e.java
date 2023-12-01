package a.a.a.a.a.e;

import android.util.Log;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f1360a = "PLDroidMediaStreaming";
    public static int b = 4;

    /* renamed from: c  reason: collision with root package name */
    public static final e f1361c = new e("");
    public static final e d = new e("Pili-Interface");
    public static final e e = new e("Pili-System");
    public static final e f = new e("Pili-Streaming");
    public static final e g = new e("Pili-Capture");
    public static final e h = new e("Pili-Processing");
    public static final e i = new e("Pili-Encode");
    public static final e j = new e("Pili-Decode");
    public static final e k;
    public static boolean l;
    public final String m;

    static {
        new e("Pili-OpenGL");
        new e("Pili-Stat");
        k = new e("Pili-Network");
        l = false;
    }

    public e(String str) {
        this.m = str;
    }

    public static void a(int i2) {
        b = i2;
        if (i2 == 2) {
            a(true);
        }
    }

    public static void a(boolean z) {
        l = z;
    }

    public static boolean a() {
        return l;
    }

    public void a(String str) {
        c(null, str);
    }

    public void a(String str, String str2) {
        if (b > 2) {
            return;
        }
        String str3 = f1360a;
        Log.v(str3, c(str) + str2);
    }

    public void b(String str) {
        d(null, str);
    }

    public void b(String str, String str2) {
        if (b > 3) {
            return;
        }
        String str3 = f1360a;
        Log.d(str3, c(str) + str2);
    }

    public final String c(String str) {
        String str2;
        String str3 = this.m;
        if (str3 == null || "".equals(str3)) {
            str2 = "";
        } else {
            str2 = "" + this.m + ":";
        }
        String str4 = str2;
        if (str != null) {
            str4 = str2;
            if (!"".equals(str)) {
                str4 = str2 + str + ":";
            }
        }
        return str4;
    }

    public void c(String str, String str2) {
        if (b > 4) {
            return;
        }
        String str3 = f1360a;
        Log.i(str3, c(str) + str2);
    }

    public void d(String str, String str2) {
        if (b > 5) {
            return;
        }
        String str3 = f1360a;
        Log.w(str3, c(str) + str2);
    }

    public void e(String str, String str2) {
        if (b > 6) {
            return;
        }
        String str3 = f1360a;
        Log.e(str3, c(str) + str2);
    }
}
