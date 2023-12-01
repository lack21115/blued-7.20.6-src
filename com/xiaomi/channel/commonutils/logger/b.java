package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/channel/commonutils/logger/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f41170a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static Context f85a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f91a = false;

    /* renamed from: b  reason: collision with other field name */
    private static boolean f92b = false;

    /* renamed from: a  reason: collision with other field name */
    private static String f88a = "XMPush-" + Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f86a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f89a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f87a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f90a = new AtomicInteger(1);

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/channel/commonutils/logger/b$a.class */
    static class a implements LoggerInterface {

        /* renamed from: a  reason: collision with root package name */
        private String f41171a = b.f88a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f41171a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f41171a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f41171a = str;
        }
    }

    public static int a() {
        return f41170a;
    }

    public static Integer a(String str) {
        if (f41170a <= 1) {
            Integer valueOf = Integer.valueOf(f90a.incrementAndGet());
            f89a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            LoggerInterface loggerInterface = f86a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f87a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m11393a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as ".concat(String.valueOf(i)));
        }
        f41170a = i;
    }

    public static void a(int i, String str) {
        if (i >= f41170a) {
            f86a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f41170a) {
            f86a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f41170a) {
            f86a.log("", th);
        }
    }

    public static void a(Context context) {
        f85a = context;
        if (j.m12048a(context)) {
            f91a = true;
        }
        if (j.m12047a()) {
            f92b = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f86a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f41170a > 1 || !f89a.containsKey(num)) {
            return;
        }
        long longValue = f89a.remove(num).longValue();
        String remove = b.remove(num);
        long currentTimeMillis = System.currentTimeMillis();
        LoggerInterface loggerInterface = f86a;
        loggerInterface.log(remove + " ends in " + (currentTimeMillis - longValue) + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m11394a(String str) {
        a(2, m11393a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m11395a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m11393a(str), th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    public static void b(String str) {
        a(0, m11393a(str));
    }

    public static void c(String str) {
        a(1, m11393a(str));
    }

    public static void d(String str) {
        a(4, m11393a(str));
    }

    public static void e(String str) {
        if (f91a) {
            m11394a(str);
            return;
        }
        Log.w(f88a, m11393a(str));
        if (f92b) {
            return;
        }
        m11394a(str);
    }
}
