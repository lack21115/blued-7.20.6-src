package java.lang;

import dalvik.system.PathClassLoader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ClassLoader.class */
public abstract class ClassLoader {
    private Map<String, Package> packages;
    private ClassLoader parent;
    public final Map<List<Class<?>>, Class<?>> proxyCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/ClassLoader$SystemClassLoader.class */
    public static class SystemClassLoader {
        public static ClassLoader loader = ClassLoader.access$000();

        private SystemClassLoader() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader() {
        this(getSystemClassLoader(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader(ClassLoader classLoader) {
        this(classLoader, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassLoader(ClassLoader classLoader, boolean z) {
        this.packages = new HashMap();
        this.proxyCache = new HashMap();
        if (classLoader == null && !z) {
            throw new NullPointerException("parentLoader == null && !nullAllowed");
        }
        this.parent = classLoader;
    }

    static /* synthetic */ ClassLoader access$000() {
        return createSystemClassLoader();
    }

    private static ClassLoader createSystemClassLoader() {
        return new PathClassLoader(System.getProperty("java.class.path", "."), BootClassLoader.getInstance());
    }

    public static ClassLoader getSystemClassLoader() {
        return SystemClassLoader.loader;
    }

    public static URL getSystemResource(String str) {
        return SystemClassLoader.loader.getResource(str);
    }

    public static InputStream getSystemResourceAsStream(String str) {
        return SystemClassLoader.loader.getResourceAsStream(str);
    }

    public static Enumeration<URL> getSystemResources(String str) throws IOException {
        return SystemClassLoader.loader.getResources(str);
    }

    public void clearAssertionStatus() {
    }

    protected final Class<?> defineClass(String str, ByteBuffer byteBuffer, ProtectionDomain protectionDomain) throws ClassFormatError {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return defineClass(str, bArr, 0, bArr.length, protectionDomain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String str, byte[] bArr, int i, int i2) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String str, byte[] bArr, int i, int i2, ProtectionDomain protectionDomain) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    @Deprecated
    protected final Class<?> defineClass(byte[] bArr, int i, int i2) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
        Package r0;
        synchronized (this.packages) {
            if (this.packages.containsKey(str)) {
                throw new IllegalArgumentException("Package " + str + " already defined");
            }
            r0 = new Package(str, str2, str3, str4, str5, str6, str7, url);
            this.packages.put(str, r0);
        }
        return r0;
    }

    protected Class<?> findClass(String str) throws ClassNotFoundException {
        throw new ClassNotFoundException(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String findLibrary(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> findLoadedClass(String str) {
        return VMClassLoader.findLoadedClass(this == BootClassLoader.getInstance() ? null : this, str);
    }

    protected URL findResource(String str) {
        return null;
    }

    protected Enumeration<URL> findResources(String str) throws IOException {
        return Collections.emptyEnumeration();
    }

    protected final Class<?> findSystemClass(String str) throws ClassNotFoundException {
        return Class.forName(str, false, getSystemClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Package getPackage(String str) {
        Package r0;
        synchronized (this.packages) {
            r0 = this.packages.get(str);
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Package[] getPackages() {
        Package[] packageArr;
        synchronized (this.packages) {
            Collection<Package> values = this.packages.values();
            packageArr = new Package[values.size()];
            values.toArray(packageArr);
        }
        return packageArr;
    }

    public final ClassLoader getParent() {
        return this.parent;
    }

    public URL getResource(String str) {
        URL resource = this.parent.getResource(str);
        URL url = resource;
        if (resource == null) {
            url = findResource(str);
        }
        return url;
    }

    public InputStream getResourceAsStream(String str) {
        try {
            URL resource = getResource(str);
            if (resource != null) {
                return resource.openStream();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public Enumeration<URL> getResources(String str) throws IOException {
        return new TwoEnumerationsInOne(this.parent.getResources(str), findResources(str));
    }

    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return loadClass(str, false);
    }

    protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        Class<?> cls = findLoadedClass;
        if (findLoadedClass == null) {
            ClassNotFoundException e = null;
            try {
                findLoadedClass = this.parent.loadClass(str, false);
            } catch (ClassNotFoundException e2) {
                e = e2;
            }
            cls = findLoadedClass;
            if (findLoadedClass == null) {
                try {
                    cls = findClass(str);
                } catch (ClassNotFoundException e3) {
                    e3.addSuppressed(e);
                    throw e3;
                }
            }
        }
        return cls;
    }

    protected final void resolveClass(Class<?> cls) {
    }

    public void setClassAssertionStatus(String str, boolean z) {
    }

    public void setDefaultAssertionStatus(boolean z) {
    }

    public void setPackageAssertionStatus(String str, boolean z) {
    }

    protected final void setSigners(Class<?> cls, Object[] objArr) {
    }
}
