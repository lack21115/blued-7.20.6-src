package com.tencent.liteav.base;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/JNIUtils.class */
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    public static Object getClassLoader() {
        ClassLoader classLoader = sJniClassLoader;
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = JNIUtils.class.getClassLoader();
        }
        return classLoader2;
    }

    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = Boolean.FALSE;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void setClassLoader(ClassLoader classLoader) {
        sJniClassLoader = classLoader;
    }
}
