package dalvik.system;

import com.baidu.mobads.sdk.internal.ci;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/BaseDexClassLoader.class */
public class BaseDexClassLoader extends ClassLoader {
    private final DexPathList pathList;

    public BaseDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(classLoader);
        this.pathList = new DexPathList(this, str, str2, file);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        ArrayList<Throwable> arrayList = new ArrayList();
        Class<?> findClass = this.pathList.findClass(str, arrayList);
        if (findClass == null) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException("Didn't find class \"" + str + "\" on path: " + this.pathList);
            for (Throwable th : arrayList) {
                classNotFoundException.addSuppressed(th);
            }
            throw classNotFoundException;
        }
        return findClass;
    }

    @Override // java.lang.ClassLoader
    public String findLibrary(String str) {
        return this.pathList.findLibrary(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public URL findResource(String str) {
        return this.pathList.findResource(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        return this.pathList.findResources(str);
    }

    public String getLdLibraryPath() {
        StringBuilder sb = new StringBuilder();
        File[] nativeLibraryDirectories = this.pathList.getNativeLibraryDirectories();
        int length = nativeLibraryDirectories.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            File file = nativeLibraryDirectories[i2];
            if (sb.length() > 0) {
                sb.append(':');
            }
            sb.append(file);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Package getPackage(String str) {
        Package r12;
        synchronized (this) {
            r12 = null;
            if (str != null) {
                r12 = null;
                if (!str.isEmpty()) {
                    Package r0 = super.getPackage(str);
                    r12 = r0;
                    if (r0 == null) {
                        r12 = definePackage(str, "Unknown", ci.d, "Unknown", "Unknown", ci.d, "Unknown", null);
                    }
                }
            }
        }
        return r12;
    }

    public String toString() {
        return getClass().getName() + "[" + this.pathList + "]";
    }
}
