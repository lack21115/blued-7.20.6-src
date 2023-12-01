package com.blued.android.framework.ui.xpop.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.android.internal.telephony.SmsConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/FuckRomUtils.class */
public final class FuckRomUtils {
    private static final String[] a = {"huawei"};
    private static final String[] b = {"vivo"};
    private static final String[] c = {"xiaomi"};
    private static final String[] d = {"oppo"};
    private static final String[] e = {"leeco", "letv"};
    private static final String[] f = {"360", "qiku"};
    private static final String[] g = {"zte"};
    private static final String[] h = {"oneplus"};
    private static final String[] i = {"nubia"};
    private static final String[] j = {"coolpad", "yulong"};
    private static final String[] k = {"lg", "lge"};
    private static final String[] l = {"google"};
    private static final String[] m = {"samsung"};
    private static final String[] n = {"meizu"};
    private static final String[] o = {"lenovo"};
    private static final String[] p = {"smartisan"};
    private static final String[] q = {"htc"};
    private static final String[] r = {"sony"};
    private static final String[] s = {"gionee", "amigo"};
    private static final String[] t = {"motorola"};
    private static RomInfo u = null;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/FuckRomUtils$RomInfo.class */
    public static class RomInfo {
        private String a;
        private String b;

        public String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + i.d;
        }
    }

    private FuckRomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r3.equals(com.android.internal.telephony.SmsConstants.FORMAT_UNKNOWN) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r3) {
        /*
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lf
            r0 = r3
            java.lang.String r0 = b(r0)
            r3 = r0
            goto L12
        Lf:
            java.lang.String r0 = ""
            r3 = r0
        L12:
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L24
            r0 = r3
            r4 = r0
            r0 = r3
            java.lang.String r1 = "unknown"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L39
        L24:
            java.lang.String r0 = android.os.Build.DISPLAY     // Catch: java.lang.Throwable -> L45
            r5 = r0
            r0 = r3
            r4 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L45
            if (r0 != 0) goto L39
            r0 = r5
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Throwable -> L45
            r4 = r0
            goto L39
        L39:
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L43
            java.lang.String r0 = "unknown"
            return r0
        L43:
            r0 = r4
            return r0
        L45:
            r4 = move-exception
            r0 = r3
            r4 = r0
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.xpop.util.FuckRomUtils.a(java.lang.String):java.lang.String");
    }

    public static boolean a() {
        return b[0].equals(b().a);
    }

    private static boolean a(String str, String str2, String... strArr) {
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            String str3 = strArr[i3];
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public static RomInfo b() {
        RomInfo romInfo = u;
        if (romInfo != null) {
            return romInfo;
        }
        u = new RomInfo();
        String d2 = d();
        String c2 = c();
        if (a(d2, c2, a)) {
            u.a = a[0];
            String a2 = a("ro.build.version.emui");
            String[] split = a2.split(BridgeUtil.UNDERLINE_STR);
            if (split.length > 1) {
                u.b = split[1];
            } else {
                u.b = a2;
            }
            return u;
        } else if (a(d2, c2, b)) {
            u.a = b[0];
            u.b = a("ro.vivo.os.build.display.id");
            return u;
        } else if (a(d2, c2, c)) {
            u.a = c[0];
            u.b = a("ro.build.version.incremental");
            return u;
        } else if (a(d2, c2, d)) {
            u.a = d[0];
            u.b = a("ro.build.version.opporom");
            return u;
        } else if (a(d2, c2, e)) {
            u.a = e[0];
            u.b = a("ro.letv.release.version");
            return u;
        } else if (a(d2, c2, f)) {
            u.a = f[0];
            u.b = a("ro.build.uiversion");
            return u;
        } else if (a(d2, c2, g)) {
            u.a = g[0];
            u.b = a("ro.build.MiFavor_version");
            return u;
        } else if (a(d2, c2, h)) {
            u.a = h[0];
            u.b = a("ro.rom.version");
            return u;
        } else if (a(d2, c2, i)) {
            u.a = i[0];
            u.b = a("ro.build.rom.id");
            return u;
        } else {
            if (a(d2, c2, j)) {
                u.a = j[0];
            } else if (a(d2, c2, k)) {
                u.a = k[0];
            } else if (a(d2, c2, l)) {
                u.a = l[0];
            } else if (a(d2, c2, m)) {
                u.a = m[0];
            } else if (a(d2, c2, n)) {
                u.a = n[0];
            } else if (a(d2, c2, o)) {
                u.a = o[0];
            } else if (a(d2, c2, p)) {
                u.a = p[0];
            } else if (a(d2, c2, q)) {
                u.a = q[0];
            } else if (a(d2, c2, r)) {
                u.a = r[0];
            } else if (a(d2, c2, s)) {
                u.a = s[0];
            } else if (a(d2, c2, t)) {
                u.a = t[0];
            } else {
                u.a = c2;
            }
            u.b = a("");
            return u;
        }
    }

    private static String b(String str) {
        String c2 = c(str);
        if (TextUtils.isEmpty(c2)) {
            String d2 = d(str);
            if (TextUtils.isEmpty(d2) && Build.VERSION.SDK_INT < 28) {
                return e(str);
            }
            return d2;
        }
        return c2;
    }

    private static String c() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : SmsConstants.FORMAT_UNKNOWN;
        } catch (Throwable th) {
            return SmsConstants.FORMAT_UNKNOWN;
        }
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException e2) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e3) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    return "";
                }
                return "";
            } catch (Throwable th2) {
                bufferedReader2 = bufferedReader;
                th = th2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
            if (readLine == null) {
                bufferedReader.close();
                return "";
            }
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e5) {
                return readLine;
            }
        } catch (IOException e6) {
            return "";
        }
    }

    private static String d() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : SmsConstants.FORMAT_UNKNOWN;
        } catch (Throwable th) {
            return SmsConstants.FORMAT_UNKNOWN;
        }
    }

    private static String d(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception e2) {
            return "";
        }
    }

    private static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception e2) {
            return "";
        }
    }
}
