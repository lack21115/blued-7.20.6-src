package com.xiaomi.channel.commonutils.logger;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/channel/commonutils/logger/LoggerInterface.class */
public interface LoggerInterface {
    void log(String str);

    void log(String str, Throwable th);

    void setTag(String str);
}
