package com.huawei.hms.ads.uiengineloader;

import dalvik.system.DexClassLoader;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/d.class */
public final class d extends DexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22549a = d.class.getSimpleName();

    public d(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException e) {
                aa.c(f22549a, "Cannot find The class:".concat(String.valueOf(str)));
            }
        }
        return super.loadClass(str, z);
    }
}
