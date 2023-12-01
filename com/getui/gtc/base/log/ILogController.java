package com.getui.gtc.base.log;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/ILogController.class */
public interface ILogController {
    boolean isLoggable(int i, String str);

    void log(int i, String str, String str2, Throwable th);
}
