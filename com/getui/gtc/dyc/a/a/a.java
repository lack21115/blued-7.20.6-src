package com.getui.gtc.dyc.a.a;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Logger f8365a;

    /* renamed from: com.getui.gtc.dyc.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/a/a/a$a.class */
    static class C0179a {

        /* renamed from: a  reason: collision with root package name */
        private static a f8366a = new a();
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f8365a = logger;
        logger.setGlobalTag("gtc.dyc");
        this.f8365a.setFileEnableProperty("dyc.fileLog");
        this.f8365a.setLogcatEnable(false);
        this.f8365a.setLogFileNameSuffix("gtc");
        this.f8365a.setStackOffset(1);
    }

    public static Logger a() {
        return C0179a.f8366a.f8365a;
    }

    public static void a(String str) {
        C0179a.f8366a.f8365a.e(str);
    }

    public static void a(Throwable th) {
        C0179a.f8366a.f8365a.w(th);
    }

    public static void c(Throwable th) {
        C0179a.f8366a.f8365a.e(th);
    }
}
