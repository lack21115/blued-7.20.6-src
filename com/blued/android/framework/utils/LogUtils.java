package com.blued.android.framework.utils;

import android.content.Intent;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.iu;
import com.blued.android.core.utils.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/LogUtils.class */
public class LogUtils {
    static StringBuffer a = new StringBuffer();
    public static String b = "LogUtils";
    private static boolean c = true;

    public static int a(String str) {
        return a("", str);
    }

    public static int a(String str, String str2) {
        if (c) {
            return Log.d("BluedLog", e("v") + str2);
        }
        return 0;
    }

    public static int a(Object... objArr) {
        return c(d(objArr));
    }

    public static void a(String str, Throwable th) {
        if (th == null) {
            return;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (TextUtils.isEmpty(str)) {
            c(b, stringWriter2);
            return;
        }
        String str2 = b;
        c(str2, str + " Catch exception: " + stringWriter2);
    }

    public static int b(String str) {
        return b("", str);
    }

    public static int b(String str, String str2) {
        if (c) {
            return Log.d("BluedLog", e("d") + str + " " + str2);
        }
        return 0;
    }

    public static int b(Object... objArr) {
        return a(d(objArr));
    }

    public static int c(String str) {
        return c("", str);
    }

    public static int c(String str, String str2) {
        if (c) {
            return Log.d("BluedLog", e("i") + str + " " + str2);
        }
        return 0;
    }

    public static int c(Object... objArr) {
        if (objArr == null) {
            Log.b("tag", "d --> null");
            return -1;
        }
        a.setLength(0);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                break;
            }
            a.append(objArr[i2] + "\n");
            i = i2 + 1;
        }
        int i3 = 0;
        if (c) {
            i3 = Log.d("BluedLog", e("d") + " " + a.toString());
        }
        return i3;
    }

    public static int d(String str) {
        return d("", str);
    }

    public static int d(String str, String str2) {
        if (c) {
            return Log.e("BluedLog", e(iu.h) + str + " " + str2);
        }
        return 0;
    }

    private static String d(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Intent) {
                sb.append(((Intent) obj).getExtras());
                sb.append("\n");
            } else if (obj instanceof Throwable) {
                sb.append(android.util.Log.getStackTraceString((Throwable) obj));
                sb.append("\n");
            } else {
                sb.append(obj.toString());
            }
            i = i2 + 1;
        }
    }

    private static String e(String str) {
        StackTraceElement stackTraceElement;
        int i;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= stackTrace.length) {
                stackTraceElement = null;
                break;
            } else if (!stackTrace[i3].getMethodName().equalsIgnoreCase(str) || (i = i3 + 2) >= stackTrace.length) {
                i2 = i3 + 1;
            } else {
                int i4 = i3 + 1;
                stackTraceElement = stackTrace[i4].getMethodName().equalsIgnoreCase(str) ? stackTrace[i] : stackTrace[i4];
            }
        }
        if (stackTraceElement == null) {
            return "";
        }
        String className = stackTraceElement.getClassName();
        return (className.contains("$") ? className.substring(className.lastIndexOf(".") + 1, className.indexOf("$")) : className.substring(className.lastIndexOf(".") + 1)) + "-> " + stackTraceElement.getMethodName() + "():";
    }
}
