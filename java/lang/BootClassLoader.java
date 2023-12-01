package java.lang;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/BootClassLoader.class */
public class BootClassLoader extends ClassLoader {
    private static BootClassLoader instance;

    public BootClassLoader() {
        super(null, true);
    }

    @FindBugsSuppressWarnings({"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
    public static BootClassLoader getInstance() {
        BootClassLoader bootClassLoader;
        synchronized (BootClassLoader.class) {
            try {
                if (instance == null) {
                    instance = new BootClassLoader();
                }
                bootClassLoader = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bootClassLoader;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        return Class.classForName(str, false, null);
    }

    @Override // java.lang.ClassLoader
    protected URL findResource(String str) {
        return VMClassLoader.getResource(str);
    }

    @Override // java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) throws IOException {
        return Collections.enumeration(VMClassLoader.getResources(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Package getPackage(String str) {
        Package r12;
        if (str == null || str.isEmpty()) {
            return null;
        }
        synchronized (this) {
            Package r0 = super.getPackage(str);
            r12 = r0;
            if (r0 == null) {
                r12 = definePackage(str, "Unknown", "0.0", "Unknown", "Unknown", "0.0", "Unknown", null);
            }
        }
        return r12;
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        return findResource(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        return findResources(str);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        Class<?> cls = findLoadedClass;
        if (findLoadedClass == null) {
            cls = findClass(str);
        }
        return cls;
    }
}
