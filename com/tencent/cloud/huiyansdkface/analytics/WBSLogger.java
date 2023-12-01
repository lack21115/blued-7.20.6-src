package com.tencent.cloud.huiyansdkface.analytics;

import android.util.Log;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/WBSLogger.class */
public class WBSLogger {
    private static final String ROOT_TAG_PREFIX = "WALogger-";
    private static final String ROOT_TAT = "WALogger";
    private static int logLevel = 6;
    private static a logger;
    private static d exceptionHandler = new d() { // from class: com.tencent.cloud.huiyansdkface.analytics.WBSLogger.1
        @Override // com.tencent.cloud.huiyansdkface.analytics.WBSLogger.d
        public final void a(boolean z, Throwable th) {
            if (th == null || z) {
                return;
            }
            th.printStackTrace();
        }
    };
    private static c config = new c((byte) 0);

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/WBSLogger$a.class */
    public static abstract class a {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/WBSLogger$b.class */
    public static abstract class b extends a {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/WBSLogger$c.class */
    public static final class c {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/WBSLogger$d.class */
    public interface d {
        void a(boolean z, Throwable th);
    }

    static {
        closeLog();
    }

    public static void closeLog() {
        logLevel = 10;
    }

    public static c config() {
        return config;
    }

    public static void d(String str, String str2, Object... objArr) {
        d(str, null, str2, objArr);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        String tag = getTag(str);
        if (logger != null || logLevel > 3) {
            return;
        }
        String str3 = str2;
        if (objArr.length > 0) {
            str3 = String.format(str2, objArr);
        }
        Log.d(tag, str3, th);
        handleException(true, th);
    }

    public static void d(String str, Object... objArr) {
        d(null, null, str, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        e(str, null, str2, objArr);
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        String tag = getTag(str);
        if (logger != null || logLevel > 6) {
            return;
        }
        String str3 = str2;
        if (objArr.length > 0) {
            str3 = String.format(str2, objArr);
        }
        Log.e(tag, str3, th);
        handleException(true, th);
    }

    public static void e(String str, Object... objArr) {
        e(null, null, str, objArr);
    }

    private static String getTag(String str) {
        return str == null ? ROOT_TAT : ROOT_TAG_PREFIX.concat(String.valueOf(str));
    }

    private static void handleException(boolean z, Throwable th) {
        d dVar = exceptionHandler;
        if (dVar == null || th == null) {
            return;
        }
        dVar.a(z, th);
    }

    public static void i(String str, String str2, Object... objArr) {
        i(str, null, str2, objArr);
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        String tag = getTag(str);
        if (logger != null || logLevel > 4) {
            return;
        }
        String str3 = str2;
        if (objArr.length > 0) {
            str3 = String.format(str2, objArr);
        }
        Log.i(tag, str3, th);
        handleException(true, th);
    }

    public static void i(String str, Object... objArr) {
        i(null, null, str, objArr);
    }

    public static void setExceptionHandler(d dVar) {
        exceptionHandler = dVar;
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void setLogger(a aVar) {
        logger = aVar;
    }

    public static void setLogger(b bVar) {
        logger = bVar;
    }

    public static void setProxy(a aVar) {
        logger = aVar;
    }

    public static void throwException(Throwable th) {
        if (th == null) {
            return;
        }
        d dVar = exceptionHandler;
        if (dVar != null) {
            dVar.a(false, th);
        } else {
            th.printStackTrace();
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        v(str, null, str2, objArr);
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        String tag = getTag(str);
        if (logger != null || logLevel > 2) {
            return;
        }
        String str3 = str2;
        if (objArr.length > 0) {
            str3 = String.format(str2, objArr);
        }
        Log.v(tag, str3, th);
        handleException(true, th);
    }

    public static void v(String str, Object... objArr) {
        v(null, null, str, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        w(str, null, str2, objArr);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        String tag = getTag(str);
        if (logger != null || logLevel > 5) {
            return;
        }
        String str3 = str2;
        if (objArr.length > 0) {
            str3 = String.format(str2, objArr);
        }
        Log.w(tag, str3, th);
        handleException(true, th);
    }

    public static void w(String str, Object... objArr) {
        w(null, null, str, objArr);
    }

    public static void wtf(String str, String str2, Object... objArr) {
        wtf(str, null, str2, objArr);
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        String tag = getTag(str);
        if (logger != null || logLevel > 7) {
            return;
        }
        String str3 = str2;
        if (objArr.length > 0) {
            str3 = String.format(str2, objArr);
        }
        Log.wtf(tag, str3, th);
        handleException(true, th);
    }

    public static void wtf(String str, Object... objArr) {
        wtf(null, null, str, objArr);
    }
}
