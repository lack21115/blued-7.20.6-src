package com.xiaomi.push;

import android.os.SystemClock;
import com.heytap.mcssdk.constant.Constants;
import com.xiaomi.push.fd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fh.class */
public class fh {

    /* renamed from: a  reason: collision with root package name */
    private static final int f27715a = ex.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    private static long f399a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fh$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f27716a = new Hashtable<>();
    }

    public static void a() {
        if (f399a == 0 || SystemClock.elapsedRealtime() - f399a > Constants.MILLS_OF_WATCH_DOG) {
            f399a = SystemClock.elapsedRealtime();
            a(0, f27715a);
        }
    }

    public static void a(int i) {
        ey m8699a = ff.m8697a().m8699a();
        m8699a.a(ex.CHANNEL_STATS_COUNTER.a());
        m8699a.c(i);
        ff.m8697a().a(m8699a);
    }

    public static void a(int i, int i2) {
        synchronized (fh.class) {
            try {
                if (i2 < 16777215) {
                    a.f27716a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ey m8699a = ff.m8697a().m8699a();
        m8699a.a((byte) i);
        m8699a.a(i2);
        m8699a.b(i3);
        m8699a.b(str);
        m8699a.c(i4);
        ff.m8697a().a(m8699a);
    }

    public static void a(int i, int i2, String str, int i3) {
        synchronized (fh.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int i4 = (i << 24) | i2;
                if (!a.f27716a.containsKey(Integer.valueOf(i4))) {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
                    return;
                }
                ey m8699a = ff.m8697a().m8699a();
                m8699a.a(i2);
                m8699a.b((int) (currentTimeMillis - a.f27716a.get(Integer.valueOf(i4)).longValue()));
                m8699a.b(str);
                if (i3 >= 0) {
                    m8699a.c(i3);
                }
                ff.m8697a().a(m8699a);
                a.f27716a.remove(Integer.valueOf(i2));
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
            ey m8699a = ff.m8697a().m8699a();
            m8699a.a(b.f27709a.a());
            m8699a.c(b.f388a);
            m8699a.b(str);
            if (ff.a() != null && ff.a().f391a != null) {
                m8699a.c(bh.c(ff.a().f391a) ? 1 : 0);
            }
            ff.m8697a().a(m8699a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m8705a() {
        ez m8700a = ff.m8697a().m8700a();
        if (m8700a != null) {
            return iq.a(m8700a);
        }
        return null;
    }

    public static void b() {
        a(0, f27715a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            fd.a d = fd.d(exc);
            ey m8699a = ff.m8697a().m8699a();
            m8699a.a(d.f27709a.a());
            m8699a.c(d.f388a);
            m8699a.b(str);
            if (ff.a() != null && ff.a().f391a != null) {
                m8699a.c(bh.c(ff.a().f391a) ? 1 : 0);
            }
            ff.m8697a().a(m8699a);
        } catch (NullPointerException e) {
        }
    }
}
