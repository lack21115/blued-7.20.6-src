package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/FastServiceLoader.class */
public final class FastServiceLoader {
    public static final FastServiceLoader a = new FastServiceLoader();

    private FastServiceLoader() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final List<String> a(BufferedReader bufferedReader) {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt.f(linkedHashSet);
            }
            String a2 = StringsKt.a(readLine, "#", (String) null, 2, (Object) null);
            if (a2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String obj = StringsKt.b((CharSequence) a2).toString();
            String str = obj;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i2);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i = i2 + 1;
            }
            if (!z) {
                throw new IllegalArgumentException(Intrinsics.a("Illegal service provider class name: ", (Object) obj).toString());
            }
            boolean z2 = false;
            if (str.length() > 0) {
                z2 = true;
            }
            if (z2) {
                linkedHashSet.add(obj);
            }
        }
    }

    private final List<String> a(URL url) {
        String url2 = url.toString();
        if (StringsKt.a(url2, "jar", false, 2, (Object) null)) {
            String a2 = StringsKt.a(StringsKt.b(url2, "jar:file:", (String) null, 2, (Object) null), '!', (String) null, 2, (Object) null);
            String b = StringsKt.b(url2, "!/", (String) null, 2, (Object) null);
            JarFile jarFile = new JarFile(a2, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(b)), "UTF-8"));
                Throwable th = null;
                List<String> a3 = a.a(bufferedReader);
                CloseableKt.a(bufferedReader, th);
                jarFile.close();
                return a3;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        jarFile.close();
                        throw th3;
                    } catch (Throwable th4) {
                        ExceptionsKt.a(th2, th4);
                        throw th2;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        Throwable th5 = null;
        try {
            List<String> a4 = a.a(bufferedReader2);
            CloseableKt.a(bufferedReader2, th5);
            return a4;
        } finally {
        }
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return a(cls, classLoader);
        } catch (Throwable th) {
            return CollectionsKt.f(ServiceLoader.load(cls, classLoader));
        }
    }

    public final List<MainDispatcherFactory> a() {
        MainDispatcherFactory mainDispatcherFactory;
        MainDispatcherFactory mainDispatcherFactory2;
        if (FastServiceLoaderKt.a()) {
            try {
                ArrayList arrayList = new ArrayList(2);
                try {
                    mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException e) {
                    mainDispatcherFactory = null;
                }
                if (mainDispatcherFactory != null) {
                    arrayList.add(mainDispatcherFactory);
                }
                try {
                    mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException e2) {
                    mainDispatcherFactory2 = null;
                }
                if (mainDispatcherFactory2 != null) {
                    arrayList.add(mainDispatcherFactory2);
                }
                return arrayList;
            } catch (Throwable th) {
                return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
            }
        }
        return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    }

    public final <S> List<S> a(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(Intrinsics.a("META-INF/services/", (Object) cls.getName())));
        Intrinsics.c(list, "java.util.Collections.list(this)");
        ArrayList<URL> arrayList = list;
        ArrayList arrayList2 = new ArrayList();
        for (URL url : arrayList) {
            CollectionsKt.a((Collection) arrayList2, (Iterable) a.a(url));
        }
        Set h = CollectionsKt.h((Iterable) arrayList2);
        if (!h.isEmpty()) {
            Set<String> set = h;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.a(set, 10));
            for (String str : set) {
                arrayList3.add(a.a(str, classLoader, cls));
            }
            return arrayList3;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
