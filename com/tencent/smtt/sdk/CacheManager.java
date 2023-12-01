package com.tencent.smtt.sdk;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/CacheManager.class */
public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            Object a3 = com.tencent.smtt.utils.i.a("android.webkit.CacheManager", "cacheDisabled");
            if (a3 == null) {
                return false;
            }
            return ((Boolean) a3).booleanValue();
        }
        return ((Boolean) a2.c().c()).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return null;
        }
        return a2.c().a(str, z);
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            try {
                return com.tencent.smtt.utils.i.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
            } catch (Exception e) {
                return null;
            }
        }
        return a2.c().g();
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        w a2 = w.a();
        return (File) ((a2 == null || !a2.b()) ? com.tencent.smtt.utils.i.a("android.webkit.CacheManager", "getCacheFileBaseDir") : a2.c().g());
    }
}
