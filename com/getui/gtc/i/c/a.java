package com.getui.gtc.i.c;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/i/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Logger f8426a;

    /* renamed from: com.getui.gtc.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/i/c/a$a.class */
    public static final class C0182a {

        /* renamed from: a  reason: collision with root package name */
        private static a f8427a = new a((byte) 0);
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f8426a = logger;
        logger.setGlobalTag("gtc");
        this.f8426a.setFileEnableProperty("gtc.fileLog");
        this.f8426a.setLogcatEnable(false);
        this.f8426a.setLogFileNameSuffix("gtc");
        this.f8426a.setStackOffset(1);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static void a(String str) {
        C0182a.f8427a.f8426a.d(str);
    }

    public static void a(String str, Throwable th) {
        C0182a.f8427a.f8426a.e(str, th);
    }

    public static void a(Throwable th) {
        C0182a.f8427a.f8426a.w(th);
    }

    public static void b(String str) {
        C0182a.f8427a.f8426a.w(str);
    }

    public static void b(Throwable th) {
        C0182a.f8427a.f8426a.e(th);
    }

    public static void c(String str) {
        C0182a.f8427a.f8426a.e(str);
    }

    public static void c(Throwable th) {
        C0182a.f8427a.f8426a.filelog(2, null, null, th);
    }

    public static void d(String str) {
        C0182a.f8427a.f8426a.filelog(2, null, str, null);
    }
}
