package com.huawei.hms.framework.common;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/ContextHolder.class */
public class ContextHolder {
    private static final String TAG = "ContextHolder";
    private static Context sAppContext;
    private static Context sKitContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    public static Context getKitContext() {
        return sKitContext;
    }

    public static Context getResourceContext() {
        return getKitContext() != null ? getKitContext() : getAppContext();
    }

    public static void setAppContext(Context context) {
        CheckParamUtils.checkNotNull(context, "sAppContext == null");
        sAppContext = context.getApplicationContext();
    }

    public static void setKitContext(Context context) {
        CheckParamUtils.checkNotNull(context, "sKitContext == null");
        sKitContext = context;
    }
}
