package com.huawei.hms.ads.uiengineloader;

import dalvik.system.PathClassLoader;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/c.class */
public final class c extends PathClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22548a = c.class.getSimpleName();

    public c(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException e) {
                aa.c(f22548a, "Cannot find The class:".concat(String.valueOf(str)));
            }
        }
        return super.loadClass(str, z);
    }
}
