package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/c.class */
public class c implements Runnable {
    private static Map<Integer, c> c;
    private static boolean j = false;
    private int d;
    private int e;
    private long startTime = System.currentTimeMillis();

    private c(int i, int i2) {
        this.d = 180000;
        this.e = i;
        this.d = i2;
    }

    private static int a(int i) {
        if (i != 65133) {
            switch (i) {
                case 65501:
                    return 6;
                case 65502:
                    return 9;
                case 65503:
                    return 10;
                default:
                    return 0;
            }
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2) {
        i.a("CommitTask", "[setStatisticsInterval] eventId" + i + " statisticsInterval:" + i2);
        synchronized (c) {
            c cVar = c.get(Integer.valueOf(i));
            if (cVar == null) {
                if (i2 > 0) {
                    c cVar2 = new c(i, i2 * 1000);
                    c.put(Integer.valueOf(i), cVar2);
                    i.a("CommitTask", "post next eventId" + i + ": uploadTask.interval " + cVar2.d);
                    r.a().a(a(i), cVar2, (long) cVar2.d);
                }
            } else if (i2 > 0) {
                int i3 = cVar.d;
                int i4 = i2 * 1000;
                if (i3 != i4) {
                    r.a().f(a(i));
                    cVar.d = i4;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = cVar.d - (currentTimeMillis - cVar.startTime);
                    long j3 = j2;
                    if (j2 < 0) {
                        j3 = 0;
                    }
                    i.a("CommitTask", cVar + "post next eventId" + i + " next:" + j3 + "  uploadTask.interval: " + cVar.d);
                    r.a().a(a(i), cVar, j3);
                    cVar.startTime = currentTimeMillis;
                }
            } else {
                i.a("CommitTask", "uploadTasks.size:" + c.size());
                c.remove(Integer.valueOf(i));
                i.a("CommitTask", "uploadTasks.size:" + c.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void destroy() {
        f[] values = f.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                j = false;
                c = null;
                return;
            }
            r.a().f(a(values[i2].m8582a()));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        f[] values = f.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            e.a().m8580a(values[i2].m8582a());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init() {
        f[] values;
        if (j) {
            return;
        }
        i.a("CommitTask", "init StatisticsAlarmEvent");
        c = new ConcurrentHashMap();
        for (f fVar : f.values()) {
            if (fVar.isOpen()) {
                int m8582a = fVar.m8582a();
                c cVar = new c(m8582a, fVar.c() * 1000);
                c.put(Integer.valueOf(m8582a), cVar);
                r.a().a(a(m8582a), cVar, cVar.d);
            }
        }
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CommitTask", "check&commit event:", Integer.valueOf(this.e));
        e.a().m8580a(this.e);
        if (c.containsValue(this)) {
            this.startTime = System.currentTimeMillis();
            i.a("CommitTask", "next:" + this.e);
            r.a().a(a(this.e), this, (long) this.d);
        }
    }
}
