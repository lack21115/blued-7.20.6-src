package java.lang;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/VMClassLoader.class */
public class VMClassLoader {
    VMClassLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Class findLoadedClass(ClassLoader classLoader, String str);

    private static native String getBootClassPathResource(String str, int i);

    private static native int getBootClassPathSize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static URL getResource(String str) {
        int bootClassPathSize = getBootClassPathSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bootClassPathSize) {
                return null;
            }
            String bootClassPathResource = getBootClassPathResource(str, i2);
            if (bootClassPathResource != null) {
                try {
                    return new URL(bootClassPathResource);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<URL> getResources(String str) {
        ArrayList arrayList = new ArrayList();
        int bootClassPathSize = getBootClassPathSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bootClassPathSize) {
                return arrayList;
            }
            String bootClassPathResource = getBootClassPathResource(str, i2);
            if (bootClassPathResource != null) {
                try {
                    arrayList.add(new URL(bootClassPathResource));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }
}
