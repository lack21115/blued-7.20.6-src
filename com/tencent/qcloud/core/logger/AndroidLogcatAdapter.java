package com.tencent.qcloud.core.logger;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/logger/AndroidLogcatAdapter.class */
public final class AndroidLogcatAdapter implements LogAdapter {
    private int d(String str, String str2, Throwable th) {
        return th == null ? Log.d(str, str2) : Log.d(str, str2, th);
    }

    private int e(String str, String str2, Throwable th) {
        return th == null ? Log.e(str, str2) : Log.e(str, str2, th);
    }

    private int i(String str, String str2, Throwable th) {
        return th == null ? Log.i(str, str2) : Log.i(str, str2, th);
    }

    private int v(String str, String str2, Throwable th) {
        return th == null ? Log.v(str, str2) : Log.v(str, str2, th);
    }

    private int w(String str, String str2, Throwable th) {
        return th == null ? Log.w(str, str2) : Log.w(str, str2, th);
    }

    @Override // com.tencent.qcloud.core.logger.LogAdapter
    public boolean isLoggable(int i, String str) {
        if (TextUtils.isEmpty(str) || str.length() >= 23) {
            return false;
        }
        return Log.isLoggable(str, i);
    }

    @Override // com.tencent.qcloud.core.logger.LogAdapter
    public void log(int i, String str, String str2, Throwable th) {
        if (i == 2) {
            v(str, str2, th);
        } else if (i == 3) {
            d(str, str2, th);
        } else if (i == 4) {
            i(str, str2, th);
        } else if (i == 5) {
            w(str, str2, th);
        } else if (i != 6) {
        } else {
            e(str, str2, th);
        }
    }
}
