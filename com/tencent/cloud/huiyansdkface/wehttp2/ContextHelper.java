package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/ContextHelper.class */
public class ContextHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f22388a;

    public static Context getContext() {
        return f22388a;
    }

    public static void setContext(Context context) {
        if (context != null) {
            f22388a = context.getApplicationContext();
        }
    }
}
