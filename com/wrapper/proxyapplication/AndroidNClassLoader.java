package com.wrapper.proxyapplication;

import android.app.Application;
import android.content.Context;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/AndroidNClassLoader.class */
class AndroidNClassLoader extends PathClassLoader {
    private static final String TAG = "SecShell";
    private static String baseApkFullPath;
    private static Object oldDexPathListHolder;

    private AndroidNClassLoader(String str, ClassLoader classLoader, Application application) {
        super(str, classLoader);
        try {
            baseApkFullPath = application.getPackageCodePath();
        } catch (Throwable th) {
        }
    }

    private static ClassLoader createAndroidNClassLoader(String str, ClassLoader classLoader, Application application) throws Exception {
        try {
            AndroidNClassLoader androidNClassLoader = new AndroidNClassLoader(str, classLoader, application);
            Field findField = ShareReflectUtil.findField(classLoader, "pathList");
            Object obj = findField.get(classLoader);
            findField.set(androidNClassLoader, recreateDexPathList(obj, androidNClassLoader, false));
            ShareReflectUtil.findField(obj, "definingContext").set(obj, androidNClassLoader);
            oldDexPathListHolder = obj;
            return androidNClassLoader;
        } catch (Throwable th) {
            return classLoader;
        }
    }

    public static ClassLoader inject(ClassLoader classLoader, Application application) throws Exception {
        try {
            ClassLoader createAndroidNClassLoader = createAndroidNClassLoader("", classLoader, application);
            reflectPackageInfoClassloader(application, createAndroidNClassLoader);
            return createAndroidNClassLoader;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Object recreateDexPathList(Object obj, ClassLoader classLoader, boolean z) throws Exception {
        try {
            Constructor<?> findConstructor = ShareReflectUtil.findConstructor(obj, ClassLoader.class, String.class, String.class, File.class);
            if (z) {
                return findConstructor.newInstance(classLoader, "", null, null);
            }
            Object[] objArr = (Object[]) ShareReflectUtil.findField(obj, "dexElements").get(obj);
            List<File> list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            StringBuilder sb = new StringBuilder();
            Field findField = ShareReflectUtil.findField(objArr.getClass().getComponentType(), "dexFile");
            int length = objArr.length;
            int i = 0;
            boolean z2 = true;
            while (true) {
                boolean z3 = z2;
                if (i >= length) {
                    break;
                }
                DexFile dexFile = (DexFile) findField.get(objArr[i]);
                boolean z4 = z3;
                if (dexFile != null) {
                    if (dexFile.getName() == null) {
                        z4 = z3;
                    } else {
                        try {
                            if (dexFile.getName().equals(baseApkFullPath)) {
                                if (z3) {
                                    z3 = false;
                                } else {
                                    sb.append(File.pathSeparator);
                                }
                                sb.append(dexFile.getName());
                                z4 = z3;
                            } else {
                                z4 = z3;
                            }
                        } catch (Throwable th) {
                            return null;
                        }
                    }
                }
                i++;
                z2 = z4;
                return null;
            }
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            boolean z5 = true;
            for (File file : list) {
                if (file != null) {
                    if (z5) {
                        z5 = false;
                    } else {
                        sb3.append(File.pathSeparator);
                    }
                    sb3.append(file.getAbsolutePath());
                }
            }
            return findConstructor.newInstance(classLoader, sb2, sb3.toString(), null);
        } catch (Throwable th2) {
            return null;
        }
    }

    private static void reflectPackageInfoClassloader(Application application, ClassLoader classLoader) throws Exception {
        try {
            Context context = (Context) ShareReflectUtil.findField(application, "mBase").get(application);
            Object obj = ShareReflectUtil.findField(context, "mPackageInfo").get(context);
            ShareReflectUtil.findField(obj, "mClassLoader").set(obj, classLoader);
        } catch (Throwable th) {
        }
    }
}
