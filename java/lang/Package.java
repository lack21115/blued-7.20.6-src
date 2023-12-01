package java.lang;

import dalvik.system.VMStack;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URL;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Package.class */
public class Package implements AnnotatedElement {
    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    private final String implTitle;
    private final String implVendor;
    private final String implVersion;
    private final String name;
    private final URL sealBase;
    private final String specTitle;
    private final String specVendor;
    private final String specVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Package(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
        this.name = str;
        this.specTitle = str2;
        this.specVersion = str3;
        this.specVendor = str4;
        this.implTitle = str5;
        this.implVersion = str6;
        this.implVendor = str7;
        this.sealBase = url;
    }

    public static Package getPackage(String str) {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        ClassLoader classLoader = callingClassLoader;
        if (callingClassLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader.getPackage(str);
    }

    public static Package[] getPackages() {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        ClassLoader classLoader = callingClassLoader;
        if (callingClassLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader.getPackages();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Annotation[] annotations = getAnnotations();
        int length = annotations.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            A a = (A) annotations[i2];
            if (cls.isInstance(a)) {
                return a;
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        try {
            return Class.forName(getName() + ".package-info").getAnnotations();
        } catch (Exception e) {
            return NO_ANNOTATIONS;
        }
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return getAnnotations();
    }

    public String getImplementationTitle() {
        return this.implTitle;
    }

    public String getImplementationVendor() {
        return this.implVendor;
    }

    public String getImplementationVersion() {
        return this.implVersion;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecificationTitle() {
        return this.specTitle;
    }

    public String getSpecificationVendor() {
        return this.specVendor;
    }

    public String getSpecificationVersion() {
        return this.specVersion;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public boolean isCompatibleWith(String str) throws NumberFormatException {
        String[] split = str.split("\\.");
        String[] split2 = this.specVersion.split("\\.");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(split.length, split2.length)) {
                return split.length <= split2.length;
            }
            int parseInt = Integer.parseInt(split[i2]);
            int parseInt2 = Integer.parseInt(split2[i2]);
            if (parseInt > parseInt2) {
                return false;
            }
            if (parseInt < parseInt2) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean isSealed() {
        return this.sealBase != null;
    }

    public boolean isSealed(URL url) {
        return this.sealBase != null && this.sealBase.sameFile(url);
    }

    public String toString() {
        return "package " + this.name;
    }
}
