package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bv.class */
public class bv {
    public static bu a(Class<? extends bu> cls, int i) {
        try {
            return (bu) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }
}
