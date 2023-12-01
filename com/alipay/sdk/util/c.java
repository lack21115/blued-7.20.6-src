package com.alipay.sdk.util;

import com.alipay.sdk.interior.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/c.class */
public class c {
    private static Log.ISdkLogCallback a;
    private static final String b = "alipaysdk";

    public static void a(Log.ISdkLogCallback iSdkLogCallback) {
        a = iSdkLogCallback;
    }

    private static void a(String str) {
        try {
            Log.ISdkLogCallback iSdkLogCallback = a;
            if (iSdkLogCallback != null) {
                iSdkLogCallback.onLogLine(String.format("[AlipaySDK] %s %s", new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str));
            }
        } catch (Throwable th) {
        }
    }

    public static void a(String str, String str2) {
        a(e(str, str2));
    }

    public static void a(String str, String str2, Throwable th) {
        String e = e(str, str2);
        a(e + " " + b(th));
    }

    public static void a(Throwable th) {
        if (th == null) {
            return;
        }
        try {
            a(b(th));
        } catch (Throwable th2) {
        }
    }

    private static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void b(String str, String str2) {
        a(e(str, str2));
    }

    public static void c(String str, String str2) {
        a(e(str, str2));
    }

    public static void d(String str, String str2) {
        a(e(str, str2));
    }

    private static String e(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        return String.format("[%s][%s]", str3, str4);
    }
}
