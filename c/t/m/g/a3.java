package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a3.class */
public class a3 {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, HandlerThread> f3692a = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static ConcurrentHashMap<String, Long> f3693c = new ConcurrentHashMap<>();

    public static HandlerThread a(String str, int i) {
        HandlerThread handlerThread;
        synchronized (a3.class) {
            try {
                HandlerThread handlerThread2 = f3692a.get(str);
                if (handlerThread2 == null) {
                    HandlerThread handlerThread3 = new HandlerThread(str, i);
                    handlerThread3.start();
                    f3692a.put(str, handlerThread3);
                    b.put(str, 1);
                    handlerThread = handlerThread3;
                } else {
                    ConcurrentHashMap<String, Integer> concurrentHashMap = b;
                    concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
                    handlerThread = handlerThread2;
                }
            } finally {
            }
        }
        return handlerThread;
    }

    public static void a(String str) {
        a(str, 0L);
    }

    public static void a(String str, long j) {
        synchronized (a3.class) {
            try {
                if (b.containsKey(str)) {
                    int intValue = b.get(str).intValue() - 1;
                    if (intValue == 0) {
                        b.remove(str);
                        HandlerThread remove = f3692a.remove(str);
                        long j2 = j;
                        if (f3693c.containsKey(str)) {
                            j2 = Math.max(j, f3693c.remove(str).longValue() - System.currentTimeMillis());
                        }
                        b3.a(remove, null, j2, false);
                    } else {
                        b.put(str, Integer.valueOf(intValue));
                        long j3 = 0;
                        if (j != 0) {
                            if (f3693c.containsKey(str)) {
                                j3 = f3693c.get(str).longValue();
                            }
                            f3693c.put(str, Long.valueOf(Math.max(System.currentTimeMillis() + j, j3)));
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static void a(String str, Runnable runnable) {
        synchronized (a3.class) {
            try {
                c3.a(new Handler(b(str).getLooper()), runnable);
                a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static HandlerThread b(String str) {
        HandlerThread a2;
        synchronized (a3.class) {
            try {
                a2 = a(str, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }
}
