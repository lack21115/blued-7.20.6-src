package android.app;

import android.os.Trace;
import android.util.ArrayMap;
import dalvik.system.PathClassLoader;

/* loaded from: source-9557208-dex2jar.jar:android/app/ApplicationLoaders.class */
class ApplicationLoaders {
    private static final ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
    private final ArrayMap<String, ClassLoader> mLoaders = new ArrayMap<>();

    ApplicationLoaders() {
    }

    public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    public ClassLoader getClassLoader(String str, String str2, ClassLoader classLoader) {
        ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
        synchronized (this.mLoaders) {
            ClassLoader classLoader2 = classLoader;
            if (classLoader == null) {
                classLoader2 = parent;
            }
            if (classLoader2 != parent) {
                Trace.traceBegin(64L, str);
                PathClassLoader pathClassLoader = new PathClassLoader(str, classLoader2);
                Trace.traceEnd(64L);
                return pathClassLoader;
            }
            ClassLoader classLoader3 = this.mLoaders.get(str);
            if (classLoader3 != null) {
                return classLoader3;
            }
            Trace.traceBegin(64L, str);
            PathClassLoader pathClassLoader2 = new PathClassLoader(str, str2, classLoader2);
            Trace.traceEnd(64L);
            this.mLoaders.put(str, pathClassLoader2);
            return pathClassLoader2;
        }
    }
}
