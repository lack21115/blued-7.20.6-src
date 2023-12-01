package com.bytedance.android.live.saas.middleware.alog;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/saas/middleware/alog/ILogProtocol.class */
public interface ILogProtocol {
    void bundle(int i, String str, Bundle bundle);

    void changeLevel(int i);

    void d(String str, String str2);

    void destroy();

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, Throwable th);

    void flush();

    void forceLogSharding();

    void header(int i, String str, String str2);

    void i(String str, String str2);

    void intent(int i, String str, Intent intent);

    void json(int i, String str, String str2);

    void release();

    void stacktrace(int i, String str, StackTraceElement[] stackTraceElementArr);

    void thread(int i, String str, Thread thread);

    void throwable(int i, String str, String str2, Throwable th);

    void throwable(int i, String str, Throwable th);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);

    void w(String str, Throwable th);
}
