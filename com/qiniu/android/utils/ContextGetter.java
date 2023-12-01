package com.qiniu.android.utils;

import android.app.Application;
import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/ContextGetter.class */
public final class ContextGetter {
    public static Context applicationContext() {
        try {
            return getApplicationUsingReflection().getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Application getApplicationUsingReflection() throws Exception {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    }
}
