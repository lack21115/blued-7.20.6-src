package com.tencent.qcloud.core.logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/logger/QCloudLogger.class */
public final class QCloudLogger {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final List<LogAdapter> logAdapters = new ArrayList();

    private QCloudLogger() {
    }

    public static void addAdapter(LogAdapter logAdapter) {
        boolean z;
        if (logAdapter != null) {
            synchronized (LogAdapter.class) {
                try {
                    Iterator<LogAdapter> it = logAdapters.iterator();
                    while (true) {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().getClass().equals(logAdapter.getClass())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        logAdapters.add(logAdapter);
                    }
                } finally {
                }
            }
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        print(3, str, null, str2, objArr);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        print(3, str, th, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        print(6, str, null, str2, objArr);
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        print(6, str, th, str2, objArr);
    }

    public static <T extends LogAdapter> T getAdapter(Class<T> cls) {
        T t;
        synchronized (LogAdapter.class) {
            try {
                Iterator<LogAdapter> it = logAdapters.iterator();
                do {
                    if (!it.hasNext()) {
                        return null;
                    }
                    t = (T) it.next();
                } while (!t.getClass().equals(cls));
                return t;
            } finally {
            }
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        print(4, str, null, str2, objArr);
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        print(4, str, th, str2, objArr);
    }

    private static void print(int i, String str, Throwable th, String str2, Object... objArr) {
        String str3 = str2;
        if (objArr != null) {
            str3 = str2;
            try {
                if (objArr.length > 0) {
                    str3 = String.format(str2, objArr);
                }
            } catch (Exception e) {
                str3 = str2 + ": !!!! Log format exception: ";
            }
        }
        synchronized (LogAdapter.class) {
            try {
                for (LogAdapter logAdapter : logAdapters) {
                    if (logAdapter.isLoggable(i, str)) {
                        logAdapter.log(i, str, str3, th);
                    }
                }
            } finally {
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        print(2, str, null, str2, objArr);
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        print(2, str, th, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        print(5, str, null, str2, objArr);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        print(5, str, th, str2, objArr);
    }
}
