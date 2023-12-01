package com.alibaba.mtl.log.e;

import android.os.Process;
import android.util.Log;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/i.class */
public class i {
    private static boolean I = false;
    private static boolean J = false;
    private static String af = "UTAnalytics:";

    public static void a(String str, Object obj) {
        if (n() || m()) {
            Log.w(str + af, obj + "");
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (n() || m()) {
            Log.w(str + af, obj + "", th);
        }
    }

    public static void a(String str, Object... objArr) {
        if (J) {
            String str2 = af + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (objArr != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= objArr.length) {
                        break;
                    }
                    if (objArr[i2] != null) {
                        String obj = objArr[i2].toString();
                        if (obj.endsWith(":") || obj.endsWith(": ")) {
                            sb.append(obj);
                        } else {
                            sb.append(obj);
                            sb.append(",");
                        }
                    }
                    i = i2 + 1;
                }
            }
            Log.d(str2, sb.toString());
        }
    }

    public static void a(String str, String... strArr) {
        if (J) {
            String str2 = af + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (strArr != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if (strArr[i2] != null) {
                        String str3 = strArr[i2];
                        if (str3.endsWith(":") || str3.endsWith(": ")) {
                            sb.append(str3);
                        } else {
                            sb.append(str3);
                            sb.append(",");
                        }
                    }
                    i = i2 + 1;
                }
            }
            Log.i(str2, sb.toString());
        }
    }

    public static void d(boolean z) {
        J = z;
    }

    public static boolean m() {
        return I;
    }

    public static boolean n() {
        return J;
    }
}
