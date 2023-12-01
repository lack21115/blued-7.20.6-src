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
    private static int f27479a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static Context f38a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f44a = false;

    /* renamed from: b  reason: collision with other field name */
    private static boolean f45b = false;

    /* renamed from: a  reason: collision with other field name */
    private static String f41a = "XMPush-" + Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f39a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f42a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f40a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f43a = new AtomicInteger(1);

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/channel/commonutils/logger/b$a.class */
    static class a implements LoggerInterface {

        /* renamed from: a  reason: collision with root package name */
        private String f27480a = b.f41a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f27480a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f27480a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f27480a = str;
        }
    }

    public static int a() {
        return f27479a;
    }

    public static Integer a(String str) {
        if (f27479a <= 1) {
            Integer valueOf = Integer.valueOf(f43a.incrementAndGet());
            f42a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            LoggerInterface loggerInterface = f39a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f40a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m8343a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as ".concat(String.valueOf(i)));
        }
        f27479a = i;
    }

    public static void a(int i, String str) {
        if (i >= f27479a) {
            f39a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f27479a) {
            f39a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f27479a) {
            f39a.log("", th);
        }
    }

    public static void a(Context context) {
        f38a = context;
        if (j.m8998a(context)) {
            f44a = true;
        }
        if (j.m8997a()) {
            f45b = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f39a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f27479a > 1 || !f42a.containsKey(num)) {
            return;
        }
        long longValue = f42a.remove(num).longValue();
        String remove = b.remove(num);
        long currentTimeMillis = System.currentTimeMillis();
        LoggerInterface loggerInterface = f39a;
        loggerInterface.log(remove + " ends in " + (currentTimeMillis - longValue) + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8344a(String str) {
        a(2, m8343a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8345a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m8343a(str), th);
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
        a(0, m8343a(str));
    }

    public static void c(String str) {
        a(1, m8343a(str));
    }

    public static void d(String str) {
        a(4, m8343a(str));
    }

    public static void e(String str) {
        if (f44a) {
            m8344a(str);
            return;
        }
        Log.w(f41a, m8343a(str));
        if (f45b) {
            return;
        }
        m8344a(str);
    }
}
