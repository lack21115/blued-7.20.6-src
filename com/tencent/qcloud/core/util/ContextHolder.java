package com.tencent.qcloud.core.util;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/util/ContextHolder.class */
public class ContextHolder {
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    public static void setContext(Context context) {
        appContext = context.getApplicationContext();
    }
}
