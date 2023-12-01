package mtopsdk.common.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/TBSdkLog.class */
public class TBSdkLog {
    private static boolean a = true;
    private static boolean b = true;
    private static LogEnable c = LogEnable.DebugEnable;
    private static Map d = new HashMap(5);

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/TBSdkLog$LogEnable.class */
    public enum LogEnable {
        VerboseEnable("V"),
        DebugEnable("D"),
        InfoEnable("I"),
        WarnEnable("W"),
        ErrorEnable("E"),
        NoneEnable("L");
        
        private String g;

        LogEnable(String str) {
            this.g = str;
        }

        public final String a() {
            return this.g;
        }
    }

    static {
        LogEnable[] values = LogEnable.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            LogEnable logEnable = values[i2];
            d.put(logEnable.a(), logEnable);
            i = i2 + 1;
        }
    }

    private static String a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("[seq:");
            sb.append(str);
            sb.append("]|");
        }
        if (strArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                sb.append(strArr[i2]);
                if (i2 < strArr.length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    public static void a(String str, String str2) {
        a(str, (String) null, str2);
    }

    public static void a(String str, String str2, String str3) {
        if (a(LogEnable.DebugEnable) && a) {
            Log.d(str, a(str2, str3));
        }
    }

    public static void a(String str, String str2, String str3, Throwable th) {
        if (a(LogEnable.WarnEnable) && a) {
            Log.w(str, a(str2, str3), th);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        a(str, null, str2, th);
    }

    public static void a(boolean z) {
        a = z;
        Log.d("mtopsdk.TBSdkLog", "[setPrintLog] printLog=" + z);
    }

    public static boolean a(LogEnable logEnable) {
        return logEnable.ordinal() >= c.ordinal();
    }

    public static void b(String str, String str2) {
        b(str, (String) null, str2);
    }

    public static void b(String str, String str2, String str3) {
        if (a(LogEnable.InfoEnable) && a) {
            Log.i(str, a(str2, str3));
        }
    }

    public static void b(String str, String str2, String str3, Throwable th) {
        if (a(LogEnable.ErrorEnable) && a) {
            Log.e(str, a(str2, str3), th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        b(str, null, str2, th);
    }

    public static void c(String str, String str2) {
        c(str, null, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (a(LogEnable.WarnEnable) && a) {
            Log.w(str, a(str2, str3));
        }
    }

    public static void d(String str, String str2) {
        d(str, null, str2);
    }

    public static void d(String str, String str2, String str3) {
        if (a(LogEnable.ErrorEnable) && a) {
            Log.e(str, a(str2, str3));
        }
    }
}
