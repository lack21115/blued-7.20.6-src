package com.youzan.androidsdk;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/YouzanLog.class */
public final class YouzanLog {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean f1048 = false;

    public static void d(String str) {
        if (!isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d("YZSDK", m9179(str));
    }

    public static void e(Object obj) {
        if (!isDebug() || obj == null) {
            return;
        }
        Log.e("YZSDK", m9179(obj));
    }

    public static void i(String str) {
        if (!isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("YZSDK", m9179(str));
    }

    public static void isDebug(boolean z) {
        f1048 = z;
    }

    public static boolean isDebug() {
        return f1048;
    }

    public static void w(String str) {
        if (!isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w("YZSDK", m9179(str));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m9179(Object obj) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > 4) {
            String fileName = stackTrace[4].getFileName();
            String methodName = stackTrace[4].getMethodName();
            int lineNumber = stackTrace[4].getLineNumber();
            String str = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
            StringBuilder sb = new StringBuilder(24);
            sb.append("(");
            sb.append(fileName);
            sb.append(':');
            sb.append(lineNumber);
            sb.append(")->");
            sb.append(str);
            sb.append(" : ");
            sb.append(obj == null ? "CONTENT IS NONE" : obj.toString());
            return sb.toString();
        }
        return "CONTENT IS NONE";
    }
}
