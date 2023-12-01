package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/e.class */
public final class e {
    private static final List<String> Zv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/e$a.class */
    public static final class a extends DexClassLoader {
        private final ClassLoader Zw;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.Zw = classLoader;
            new StringBuilder("pcl").append(this.Zw.getClass().getName());
        }

        private static boolean ba(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) {
            if (ba(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException e) {
            }
            return findLoadedClass != null ? findLoadedClass : super.loadClass(str, z);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        Zv = arrayList;
        arrayList.add("com.kwad.sdk");
        Zv.add("com.ksad");
        Zv.add("com.kwai");
        Zv.add("kwad.support");
        Zv.add("android.support.rastermill");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (t.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
