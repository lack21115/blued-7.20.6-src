package com.tencent.smtt.export.external;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/DexLoader.class */
public class DexLoader {
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAF_PACKAGE_PREFIX = "com.taf";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mMttClassUseCorePrivate = false;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader.class */
    public static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (str != null) {
                boolean startsWith = str.startsWith(DexLoader.JAVACORE_PACKAGE_PREFIX);
                boolean z2 = startsWith;
                if (DexLoader.mMttClassUseCorePrivate) {
                    z2 = startsWith || str.startsWith(DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(DexLoader.TAF_PACKAGE_PREFIX);
                }
                if (z2) {
                    Class<?> findLoadedClass = findLoadedClass(str);
                    Class<?> cls = findLoadedClass;
                    if (findLoadedClass == null) {
                        try {
                            Log.d(DexLoader.TAG, "WebCoreClassLoader - loadClass(" + str + "," + z + ")...");
                            findLoadedClass = findClass(str);
                        } catch (ClassNotFoundException e) {
                        }
                        cls = findLoadedClass;
                        if (findLoadedClass == null) {
                            ClassLoader parent = getParent();
                            cls = findLoadedClass;
                            if (parent != null) {
                                cls = parent.loadClass(str);
                            }
                        }
                    }
                    return cls;
                }
                return super.loadClass(str, z);
            }
            return super.loadClass(str, z);
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        DexClassLoader classLoader = dexLoader.getClassLoader();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            classLoader = createDexClassLoader(strArr[i2], str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
            i = i2 + 1;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        String str4 = TextUtils.isEmpty(str2) ? str3 : str3 + File.pathSeparator + str2;
        DexClassLoader dexClassLoader = classLoader;
        for (String str5 : strArr) {
            dexClassLoader = createDexClassLoader(str5, str, str4, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.ClassLoader] */
    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        initTbsSettings(map);
        ?? callingClassLoader = VMStack.getCallingClassLoader();
        DexClassLoader classLoader = callingClassLoader == 0 ? context.getClassLoader() : callingClassLoader;
        Log.d("dexloader", "Set base classLoader for DexClassLoader: " + classLoader);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            classLoader = createDexClassLoader(strArr[i2], str2, str, classLoader, context);
            this.mClassLoader = classLoader;
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0341, code lost:
        if (r15 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0363, code lost:
        if (r15 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0366, code lost:
        r15.e();
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0374  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private dalvik.system.DexClassLoader createDexClassLoader(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.ClassLoader r11, android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.createDexClassLoader(java.lang.String, java.lang.String, java.lang.String, java.lang.ClassLoader, android.content.Context):dalvik.system.DexClassLoader");
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                file.delete();
                return;
            } else {
                delete(listFiles[i2]);
                i = i2 + 1;
            }
        }
    }

    public static String getFileNameNoEx(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.length() > 0) {
                int lastIndexOf = str.lastIndexOf(46);
                str2 = str;
                if (lastIndexOf > -1) {
                    str2 = str;
                    if (lastIndexOf < str.length()) {
                        str2 = str.substring(0, lastIndexOf);
                    }
                }
            }
        }
        return str2;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Log.d(TAG, "initTbsSettings - " + map);
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRAVITE_MTT_CLASSES);
                if (obj4 instanceof Boolean) {
                    mMttClassUseCorePrivate = ((Boolean) obj4).booleanValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (mUseTbsCorePrivateClassLoader) {
            return str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX);
        }
        return false;
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "'" + str + "' get field '" + str2 + "' failed", th);
            return null;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "'" + str + "' invoke method '" + str2 + "' failed", th);
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                String simpleName = getClass().getSimpleName();
                Log.i(simpleName, "'" + str + "' invoke static method '" + str2 + "' failed", th);
                return null;
            }
            String simpleName2 = getClass().getSimpleName();
            Log.e(simpleName2, "'" + str + "' invoke static method '" + str2 + "' failed", th);
            return th;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "loadClass '" + str + "' failed", th);
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "create " + str + " instance failed", th);
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                String simpleName = getClass().getSimpleName();
                Log.e(simpleName, "'newInstance " + str + " failed", th);
                return th;
            }
            String simpleName2 = getClass().getSimpleName();
            Log.e(simpleName2, "create '" + str + "' instance failed", th);
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "'" + str + "' set field '" + str2 + "' failed", th);
        }
    }
}
