package com.getui.gtc.dyc.a.a;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Logger f21972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.getui.gtc.dyc.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/a/a/a$a.class */
    public static class C0349a {

        /* renamed from: a  reason: collision with root package name */
        private static a f21973a = new a();
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f21972a = logger;
        logger.setGlobalTag("gtc.dyc");
        this.f21972a.setFileEnableProperty("dyc.fileLog");
        this.f21972a.setLogcatEnable(false);
        this.f21972a.setLogFileNameSuffix("gtc");
        this.f21972a.setStackOffset(1);
    }

    public static Logger a() {
        return C0349a.f21973a.f21972a;
    }

    public static void a(String str) {
        C0349a.f21973a.f21972a.e(str);
    }

    public static void a(Throwable th) {
        C0349a.f21973a.f21972a.w(th);
    }

    public static void c(Throwable th) {
        C0349a.f21973a.f21972a.e(th);
    }
}
