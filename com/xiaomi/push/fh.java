package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.fd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fh.class */
public class fh {

    /* renamed from: a  reason: collision with root package name */
    private static final int f41406a = ex.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    private static long f446a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fh$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f41407a = new Hashtable<>();
    }

    public static void a() {
        if (f446a == 0 || SystemClock.elapsedRealtime() - f446a > 7200000) {
            f446a = SystemClock.elapsedRealtime();
            a(0, f41406a);
        }
    }

    public static void a(int i) {
        ey m11749a = ff.m11747a().m11749a();
        m11749a.a(ex.CHANNEL_STATS_COUNTER.a());
        m11749a.c(i);
        ff.m11747a().a(m11749a);
    }

    public static void a(int i, int i2) {
        synchronized (fh.class) {
            try {
                if (i2 < 16777215) {
                    a.f41407a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ey m11749a = ff.m11747a().m11749a();
        m11749a.a((byte) i);
        m11749a.a(i2);
        m11749a.b(i3);
        m11749a.b(str);
        m11749a.c(i4);
        ff.m11747a().a(m11749a);
    }

    public static void a(int i, int i2, String str, int i3) {
        synchronized (fh.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int i4 = (i << 24) | i2;
                if (!a.f41407a.containsKey(Integer.valueOf(i4))) {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
                    return;
                }
                ey m11749a = ff.m11747a().m11749a();
                m11749a.a(i2);
                m11749a.b((int) (currentTimeMillis - a.f41407a.get(Integer.valueOf(i4)).longValue()));
                m11749a.b(str);
                if (i3 >= 0) {
                    m11749a.c(i3);
                }
                ff.m11747a().a(m11749a);
                a.f41407a.remove(Integer.valueOf(i2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        new fa(xMPushService, bVar).a();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(String str, int i, Exception exc) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(String str, Exception exc) {
        try {
            fd.a b = fd.b(exc);
            ey m11749a = ff.m11747a().m11749a();
            m11749a.a(b.f41400a.a());
            m11749a.c(b.f435a);
            m11749a.b(str);
            if (ff.a() != null && ff.a().f438a != null) {
                m11749a.c(bh.c(ff.a().f438a) ? 1 : 0);
            }
            ff.m11747a().a(m11749a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m11755a() {
        ez m11750a = ff.m11747a().m11750a();
        if (m11750a != null) {
            return iq.a(m11750a);
        }
        return null;
    }

    public static void b() {
        a(0, f41406a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            fd.a d = fd.d(exc);
            ey m11749a = ff.m11747a().m11749a();
            m11749a.a(d.f41400a.a());
            m11749a.c(d.f435a);
            m11749a.b(str);
            if (ff.a() != null && ff.a().f438a != null) {
                m11749a.c(bh.c(ff.a().f438a) ? 1 : 0);
            }
            ff.m11747a().a(m11749a);
        } catch (NullPointerException e) {
        }
    }
}
