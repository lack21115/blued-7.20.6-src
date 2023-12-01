package com.tencent.qimei.k;

import android.util.Log;
import com.tencent.qimei.log.IObservableLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/k/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38346a = false;
    public static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public static IObservableLog f38347c;

    public static int a(StackTraceElement[] stackTraceElementArr, Class cls) {
        int i = 5;
        while (true) {
            int i2 = i;
            if (i2 >= stackTraceElementArr.length) {
                return -1;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (!(cls.equals(Log.class) && i2 < stackTraceElementArr.length - 1 && stackTraceElementArr[i2 + 1].getClassName().equals(Log.class.getName())) && className.equals(cls.getName())) {
                return i2 + 1;
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r5, java.lang.Object... r6) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.k.a.a(java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static void a(String str, String str2, Object... objArr) {
        if (a()) {
            Log.e("qm", a("Qm-Core-Error: " + str + " " + str2, objArr));
        }
    }

    public static void a(Throwable th) {
        if (th != null) {
            if (a()) {
                th.printStackTrace();
            } else {
                th.getMessage();
            }
        }
    }

    public static void a(boolean z) {
        synchronized (a.class) {
            try {
                Log.i("qm", "beacon logAble: " + z);
                f38346a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (a.class) {
            try {
                z = f38346a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a()) {
            Log.i("qm", a("Qm-Core-Info: " + str + " " + str2, objArr));
        }
    }

    public static void b(boolean z) {
        synchronized (a.class) {
            try {
                b = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (a.class) {
            try {
                z = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
