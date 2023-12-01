package com.tencent.tinker.loader;

import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerClassLoader.class */
public final class TinkerClassLoader extends PathClassLoader {
    private final ClassLoader mOriginAppClassLoader;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerClassLoader$CompoundEnumeration.class */
    class CompoundEnumeration<E> implements Enumeration<E> {
        private Enumeration<E>[] enums;
        private int index = 0;

        public CompoundEnumeration(Enumeration<E>[] enumerationArr) {
            this.enums = enumerationArr;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            while (true) {
                int i = this.index;
                Enumeration<E>[] enumerationArr = this.enums;
                if (i >= enumerationArr.length) {
                    return false;
                }
                if (enumerationArr[i] != null && enumerationArr[i].hasMoreElements()) {
                    return true;
                }
                this.index++;
            }
        }

        @Override // java.util.Enumeration
        public E nextElement() {
            if (hasMoreElements()) {
                return this.enums[this.index].nextElement();
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TinkerClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super("", str2, ClassLoader.getSystemClassLoader());
        this.mOriginAppClassLoader = classLoader;
        injectDexPath(this, str, file);
    }

    private static void injectDexPath(ClassLoader classLoader, String str, File file) {
        try {
            ArrayList arrayList = new ArrayList(16);
            String[] split = str.split(":");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                if (!str2.isEmpty()) {
                    arrayList.add(new File(str2));
                }
                i = i2 + 1;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            SystemClassLoaderAdder.injectDexesInternal(classLoader, arrayList, file);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("Fail to create TinkerClassLoader.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = super.findClass(str);
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        return cls != null ? cls : this.mOriginAppClassLoader.loadClass(str);
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        URL resource = Object.class.getClassLoader().getResource(str);
        if (resource != null) {
            return resource;
        }
        URL findResource = findResource(str);
        return findResource != null ? findResource : this.mOriginAppClassLoader.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        return new CompoundEnumeration(new Enumeration[]{Object.class.getClassLoader().getResources(str), findResources(str), this.mOriginAppClassLoader.getResources(str)});
    }
}
