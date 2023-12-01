package com.getui.gtc.dim.e;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/e/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Logger f8354a;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/e/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static b f8355a = new b((byte) 0);
    }

    private b() {
        Logger logger = new Logger(GtcProvider.context());
        this.f8354a = logger;
        logger.setGlobalTag("gtc.dim");
        this.f8354a.setFileEnableProperty("dim.fileLog");
        this.f8354a.setLogcatEnable(false);
        this.f8354a.setLogFileNameSuffix("gtc");
        this.f8354a.setStackOffset(1);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static void a(String str) {
        a.f8355a.f8354a.d(str);
    }

    public static void a(String str, Throwable th) {
        a.f8355a.f8354a.e(str, th);
    }

    public static void a(Throwable th) {
        a.f8355a.f8354a.w(th);
    }

    public static void b(String str) {
        a.f8355a.f8354a.w(str);
    }

    public static void b(Throwable th) {
        a.f8355a.f8354a.e(th);
    }
}
