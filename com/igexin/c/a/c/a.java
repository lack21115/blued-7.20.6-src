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
    private static final List<String> f23250c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public volatile Logger f23251a;

    private a() {
        try {
            this.f23251a = new Logger(GtcProvider.context());
            this.f23251a.setGlobalTag("gtsdk");
            this.f23251a.setLogcatEnable(false);
            this.f23251a.setLogFileNameSuffix("GTSDK");
            this.f23251a.setStackOffset(1);
            this.f23251a.setFileEnableProperty("sdk.debug");
            f23250c.add(g.h);
            f23250c.add("ScheduleQueue");
            f23250c.add("SilentTimeTimerTask");
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
            if (a().f23251a == null || str == null || f23250c.contains(str)) {
                return;
            }
            Logger logger = a().f23251a;
            logger.e(str + "|" + str2);
        } catch (Throwable th) {
        }
    }

    public static void a(String str, Object... objArr) {
        try {
            if (a().f23251a != null) {
                String str2 = str;
                if (objArr.length > 0) {
                    str2 = String.format(str, objArr);
                }
                a().f23251a.filelog(1, null, str2, null);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Throwable th) {
        try {
            if (a().f23251a != null) {
                a().f23251a.e(th);
            }
        } catch (Throwable th2) {
        }
    }

    public static void a(boolean z) {
        try {
            e.a(Boolean.valueOf(z));
            if (a().f23251a != null) {
                a().f23251a.setLogcatEnable(false);
                a().f23251a.setFileEnableProperty("sdk.debug");
            }
        } catch (Throwable th) {
        }
    }

    private static Logger b() {
        return a().f23251a;
    }

    public static void b(String str, String str2) {
        try {
            if (a().f23251a == null || str == null || f23250c.contains(str)) {
                return;
            }
            Logger logger = a().f23251a;
            logger.d(str + "|" + str2);
        } catch (Throwable th) {
        }
    }

    private static void c(String str, String str2) {
        try {
            if (a().f23251a == null || str == null || f23250c.contains(str)) {
                return;
            }
            a().f23251a.logcat(2, null, str2, null);
        } catch (Throwable th) {
        }
    }

    private static void d(String str, String str2) {
        try {
            if (a().f23251a == null || str == null || f23250c.contains(str)) {
                return;
            }
            a().f23251a.logcat(3, null, str2, null);
        } catch (Throwable th) {
        }
    }

    private static void e(String str, String str2) {
        try {
            if (a().f23251a == null || str == null || f23250c.contains(str)) {
                return;
            }
            a().f23251a.logcat(4, null, str2, null);
        } catch (Throwable th) {
        }
    }
}
