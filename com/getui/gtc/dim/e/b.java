package com.getui.gtc.dim.e;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/e/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Logger f21961a;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/e/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static b f21962a = new b((byte) 0);
    }

    private b() {
        Logger logger = new Logger(GtcProvider.context());
        this.f21961a = logger;
        logger.setGlobalTag("gtc.dim");
        this.f21961a.setFileEnableProperty("dim.fileLog");
        this.f21961a.setLogcatEnable(false);
        this.f21961a.setLogFileNameSuffix("gtc");
        this.f21961a.setStackOffset(1);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static void a(String str) {
        a.f21962a.f21961a.d(str);
    }

    public static void a(String str, Throwable th) {
        a.f21962a.f21961a.e(str, th);
    }

    public static void a(Throwable th) {
        a.f21962a.f21961a.w(th);
    }

    public static void b(String str) {
        a.f21962a.f21961a.w(str);
    }

    public static void b(Throwable th) {
        a.f21962a.f21961a.e(th);
    }
}
