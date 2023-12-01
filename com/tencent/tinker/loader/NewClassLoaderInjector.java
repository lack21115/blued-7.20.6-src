package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import dalvik.system.DelegateLastClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/NewClassLoaderInjector.class */
final class NewClassLoaderInjector {
    private NewClassLoaderInjector() {
        throw new UnsupportedOperationException();
    }

    private static ClassLoader createNewClassLoader(ClassLoader classLoader, File file, boolean z, String... strArr) throws Throwable {
        PathClassLoader tinkerClassLoader;
        Object obj = findField(Class.forName("dalvik.system.BaseDexClassLoader", false, classLoader), "pathList").get(classLoader);
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                if (i2 > 0) {
                    sb.append(File.pathSeparator);
                }
                sb.append(strArr[i2]);
                i = i2 + 1;
            }
        }
        String sb2 = sb.toString();
        Field findField = findField(obj.getClass(), "nativeLibraryDirectories");
        List<File> asList = findField.getType().isArray() ? Arrays.asList((File[]) findField.get(obj)) : (List) findField.get(obj);
        StringBuilder sb3 = new StringBuilder();
        boolean z2 = true;
        for (File file2 : asList) {
            if (file2 != null) {
                if (z2) {
                    z2 = false;
                } else {
                    sb3.append(File.pathSeparator);
                }
                sb3.append(file2.getAbsolutePath());
            }
        }
        String sb4 = sb3.toString();
        if (!z || Build.VERSION.SDK_INT < 27) {
            tinkerClassLoader = new TinkerClassLoader(sb2, file, sb4, classLoader);
        } else {
            PathClassLoader delegateLastClassLoader = new DelegateLastClassLoader(sb2, sb4, ClassLoader.getSystemClassLoader());
            Field declaredField = ClassLoader.class.getDeclaredField("parent");
            declaredField.setAccessible(true);
            declaredField.set(delegateLastClassLoader, classLoader);
            tinkerClassLoader = delegateLastClassLoader;
        }
        if (Build.VERSION.SDK_INT < 26) {
            findField(obj.getClass(), "definingContext").set(obj, tinkerClassLoader);
        }
        return tinkerClassLoader;
    }

    private static void doInject(Application application, ClassLoader classLoader) throws Throwable {
        Thread.currentThread().setContextClassLoader(classLoader);
        Context context = (Context) findField(application.getClass(), "mBase").get(application);
        try {
            findField(context.getClass(), "mClassLoader").set(context, classLoader);
        } catch (Throwable th) {
        }
        Object obj = findField(context.getClass(), "mPackageInfo").get(context);
        findField(obj.getClass(), "mClassLoader").set(obj, classLoader);
        if (Build.VERSION.SDK_INT < 27) {
            Resources resources = application.getResources();
            try {
                findField(resources.getClass(), "mClassLoader").set(resources, classLoader);
                Object obj2 = findField(resources.getClass(), "mDrawableInflater").get(resources);
                if (obj2 != null) {
                    findField(obj2.getClass(), "mClassLoader").set(obj2, classLoader);
                }
            } catch (Throwable th2) {
            }
        }
    }

    private static Field findField(Class<?> cls, String str) throws Throwable {
        Class<?> cls2;
        Class<?> cls3 = cls;
        while (true) {
            try {
                cls2 = cls3;
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable th) {
                if (cls2 == Object.class) {
                    throw new NoSuchFieldException("Cannot find field " + str + " in class " + cls.getName() + " and its super classes.");
                }
                cls3 = cls2.getSuperclass();
            }
        }
    }

    public static ClassLoader inject(Application application, ClassLoader classLoader, File file, boolean z, List<File> list) throws Throwable {
        int size = list.size();
        String[] strArr = new String[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                ClassLoader createNewClassLoader = createNewClassLoader(classLoader, file, z, strArr);
                doInject(application, createNewClassLoader);
                return createNewClassLoader;
            }
            strArr[i2] = list.get(i2).getAbsolutePath();
            i = i2 + 1;
        }
    }

    public static void triggerDex2Oat(Context context, File file, boolean z, String... strArr) throws Throwable {
        createNewClassLoader(context.getClassLoader(), file, z, strArr);
    }
}
