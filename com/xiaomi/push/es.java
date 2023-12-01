package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.XMJobService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/es.class */
public final class es {

    /* renamed from: a  reason: collision with other field name */
    private static a f404a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f405a = XMJobService.class.getCanonicalName();

    /* renamed from: a  reason: collision with root package name */
    private static int f41383a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/es$a.class */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean mo11732a();
    }

    public static void a() {
        synchronized (es.class) {
            try {
                if (f404a == null) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("[Alarm] stop alarm.");
                f404a.a();
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
        if (com.xiaomi.push.es.f405a.equals(com.xiaomi.push.r.a(r0, r0.name).getSuperclass().getCanonicalName()) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.es.a(android.content.Context):void");
    }

    public static void a(Context context, int i) {
        synchronized (es.class) {
            try {
                int i2 = f41383a;
                if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                    if (i == 2) {
                        f41383a = 2;
                    } else {
                        f41383a = 0;
                    }
                }
                if (i2 != f41383a && f41383a == 2) {
                    a();
                    f404a = new ev(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(boolean z) {
        synchronized (es.class) {
            try {
                if (f404a == null) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("timer is not initialized");
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("[Alarm] register alarm. (" + z + ")");
                f404a.a(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11731a() {
        synchronized (es.class) {
            try {
                if (f404a == null) {
                    return false;
                }
                return f404a.mo11732a();
            } finally {
            }
        }
    }
}
