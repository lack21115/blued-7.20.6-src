package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23831a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23832c = 2;
    public static final int d = 3;
    public static final int e = -1;
    public static int f = -1;
    static ThreadLocal<StringBuilder> g = new ThreadLocal<>();
    private static int h;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        Throwable th2 = th;
        while (true) {
            Throwable th3 = th2;
            if (th3 == null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                return stringWriter.toString();
            } else if (th3 instanceof UnknownHostException) {
                return "";
            } else {
                th2 = th3.getCause();
            }
        }
    }

    private static void a(int i, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else if (i != 2) {
                return;
            } else {
                Log.e("WeaponSDK", str);
                return;
            }
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        String str2 = fileName;
        if (fileName.length() > 5) {
            str2 = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb2 = g.get();
        StringBuilder sb3 = sb2;
        if (sb2 == null) {
            sb3 = new StringBuilder();
            g.set(sb3);
        }
        synchronized (sb3) {
            try {
                sb3.setLength(0);
                sb3.append("[");
                sb3.append(h);
                sb3.append("][");
                sb3.append(str2);
                sb3.append(':');
                sb3.append(lineNumber);
                sb3.append('.');
                sb3.append(methodName);
                sb3.append("] ");
                sb3.append(str);
                sb = sb3.toString();
                h++;
            } catch (Throwable th) {
                StringBuilder sb4 = sb3;
                throw th;
            }
        }
        if (i == 0) {
            Log.i("WeaponSDK", sb);
        } else if (i == 1) {
            Log.d("WeaponSDK", sb);
        } else if (i != 2) {
        } else {
            Log.e("WeaponSDK", sb);
        }
    }

    public static void a(String str) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static void b(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str);
        }
    }

    public static void b(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str);
        }
    }

    public static void c(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void d(String str) {
    }
}
