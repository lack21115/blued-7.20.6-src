package com.tencent.qcloud.core.logger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/logger/LogAdapter.class */
public interface LogAdapter {
    boolean isLoggable(int i, String str);

    void log(int i, String str, String str2, Throwable th);
}
