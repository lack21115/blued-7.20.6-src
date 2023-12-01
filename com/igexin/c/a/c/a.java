package com.igexin.c.a.c;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;
import com.igexin.c.a.d.g;
import com.igexin.push.config.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/c/a.class */
public class a {
    private static volatile a b;

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f9642c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public volatile Logger f9643a;

    private a() {
        try {
            this.f9643a = new Logger(GtcProvider.context());
            this.f9643a.setGlobalTag("gtsdk");
            this.f9643a.setLogcatEnable(false);
            this.f9643a.setLogFileNameSuffix("GTSDK");
            this.f9643a.setStackOffset(1);
            this.f9643a.setFileEnableProperty("sdk.debug");
            f9642c.add(g.h);
            f9642c.add("ScheduleQueue");
            f9642c.add("SilentTimeTimerTask");
        } catch (Throwable th) {
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void a(String str, String str2) {
        try {
            if (a().f9643a == null || str == null || f9642c.contains(str)) {
                return;
            }
            Logger logger = a().f9643a;
            logger.e(str + "|" + str2);
        } catch (Throwable th) {
        }
    }

    public static void a(String str, Object... objArr) {
        try {
            if (a().f9643a != null) {
                String str2 = str;
                if (objArr.length > 0) {
                    str2 = String.format(str, objArr);
                }
                a().f9643a.filelog(1, null, str2, null);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Throwable th) {
        try {
            if (a().f9643a != null) {
                a().f9643a.e(th);
            }
        } catch (Throwable th2) {
        }
    }

    public static void a(boolean z) {
        try {
            e.a(Boolean.valueOf(z));
            if (a().f9643a != null) {
                a().f9643a.setLogcatEnable(false);
                a().f9643a.setFileEnableProperty("sdk.debug");
            }
        } catch (Throwable th) {
        }
    }

    private static Logger b() {
        return a().f9643a;
    }

    public static void b(String str, String str2) {
        try {
            if (a().f9643a == null || str == null || f9642c.contains(str)) {
                return;
            }
            Logger logger = a().f9643a;
            logger.d(str + "|" + str2);
        } catch (Throwable th) {
        }
    }

    private static void c(String str, String str2) {
        try {
            if (a().f9643a == null || str == null || f9642c.contains(str)) {
                return;
            }
            a().f9643a.logcat(2, null, str2, null);
        } catch (Throwable th) {
        }
    }

    private static void d(String str, String str2) {
        try {
            if (a().f9643a == null || str == null || f9642c.contains(str)) {
                return;
            }
            a().f9643a.logcat(3, null, str2, null);
        } catch (Throwable th) {
        }
    }

    private static void e(String str, String str2) {
        try {
            if (a().f9643a == null || str == null || f9642c.contains(str)) {
                return;
            }
            a().f9643a.logcat(4, null, str2, null);
        } catch (Throwable th) {
        }
    }
}
