package com.web.library.groups.webviewsdk.photoview.log;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photoview/log/LogManager.class */
public final class LogManager {
    private static Logger logger = new LoggerDefault();

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger2) {
        logger = logger2;
    }
}
