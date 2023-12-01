package com.huawei.hms.ads.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamicloader.g;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.c;
import com.huawei.hms.ads.uiengineloader.d;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/DynamicModule.class */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NORMAL = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final String f8839a = "DynamicModule";
    private static final int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private static final int f8840c = -100;
    private static final ThreadLocal<HashMap<String, Boolean>> d = new ThreadLocal<>();
    private static final ThreadLocal<HashMap<String, String>> e = new ThreadLocal<>();
    private static final ThreadLocal<HashMap<String, IDynamicLoader>> f = new ThreadLocal<>();
    private Context g;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/DynamicModule$DynamicLoaderClassLoader.class */
    public static class DynamicLoaderClassLoader {

        /* renamed from: a  reason: collision with root package name */
        private static HashMap<String, ClassLoader> f8844a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f8844a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f8844a.put(str, classLoader);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/DynamicModule$LoadingException.class */
    public static class LoadingException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private Bundle f8845a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f8845a = bundle;
        }

        public Bundle getBundle() {
            return this.f8845a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/DynamicModule$a.class */
    public static final class a extends Exception {
        private a(String str) {
            super(str);
        }

        /* synthetic */ a(String str, byte b) {
            this(str);
        }
    }

    private DynamicModule(Context context) {
        this.g = context;
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                aa.c(f8839a, "Get remote context is null, module:".concat(String.valueOf(str)));
                return null;
            } else if (unwrap instanceof Context) {
                aa.b(f8839a, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            } else if (unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                aa.c(f8839a, "Successfully get the bundle in exception.");
                throw new LoadingException("Failed to load, please check the bundle in exception.", (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(load), new Object[0]));
            } else {
                aa.c(f8839a, "Get remote context is null, module:".concat(String.valueOf(str)));
                return null;
            }
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            aa.c(f8839a, "Failed to get module context for:" + str + " " + e3.getClass().getSimpleName());
            return null;
        }
    }

    private static Bundle a(Context context, final String str) throws LoadingException {
        Method declaredMethod;
        ClassLoader classLoader;
        boolean z = true;
        try {
            try {
                Class<?> a2 = a(context);
                Method declaredMethod2 = a2.getDeclaredMethod("getsClassLoader", String.class);
                declaredMethod = a2.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                classLoader = (ClassLoader) declaredMethod2.invoke(null, str);
            } catch (Exception e2) {
                aa.c(f8839a, "failed to load." + e2.getClass().getSimpleName());
            }
            if (classLoader == null) {
                try {
                    aa.b(f8839a, "No available cached loader, query remote.");
                    Bundle b2 = b(context, str);
                    synchronized (DynamicModule.class) {
                        try {
                            String str2 = (String) ((HashMap) Objects.requireNonNull(e.get())).get(str);
                            if (TextUtils.isEmpty(str2)) {
                                return b2;
                            }
                            if (Build.VERSION.SDK_INT < 21) {
                                aa.b(f8839a, "The android version is below android 5.");
                                d dVar = new d(str2, context.getFilesDir().getAbsolutePath(), ClassLoader.getSystemClassLoader());
                                a(str, dVar);
                                declaredMethod.invoke(null, str, dVar);
                            } else {
                                c cVar = new c(str2, ClassLoader.getSystemClassLoader());
                                a(str, cVar);
                                declaredMethod.invoke(null, str, cVar);
                            }
                            d.set(new HashMap<String, Boolean>() { // from class: com.huawei.hms.ads.dynamic.DynamicModule.1
                                {
                                    put(str, Boolean.TRUE);
                                }
                            });
                            return b2;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (a e3) {
                }
            } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                aa.b(f8839a, "Cached loader is available, ready to use it.");
                try {
                    a(str, classLoader);
                } catch (LoadingException e4) {
                    aa.c(f8839a, "Get loader interface failed." + e4.getClass().getSimpleName());
                }
                HashMap<String, Boolean> hashMap = new HashMap<>();
                hashMap.put(str, Boolean.valueOf(z));
                d.set(hashMap);
                return new Bundle();
            }
            z = false;
            HashMap<String, Boolean> hashMap2 = new HashMap<>();
            hashMap2.put(str, Boolean.valueOf(z));
            d.set(hashMap2);
            return new Bundle();
        } catch (LoadingException e5) {
            throw e5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f3, code lost:
        if ((!android.text.TextUtils.isEmpty(r0) && r0.startsWith(com.huawei.hms.ads.dynamic.a.s)) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.hms.ads.dynamic.DynamicModule a(android.content.Context r7, java.lang.Integer r8, java.lang.String r9, android.os.Bundle r10) throws com.huawei.hms.ads.dynamic.DynamicModule.LoadingException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dynamic.DynamicModule.a(android.content.Context, java.lang.Integer, java.lang.String, android.os.Bundle):com.huawei.hms.ads.dynamic.DynamicModule");
    }

    private static DynamicModule a(Context context, String str, Bundle bundle) throws LoadingException {
        g gVar = new g();
        aa.b(f8839a, "new DynamicLoader.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Context a2 = a(context, str, bundle, gVar);
        if (a2 != null) {
            return new DynamicModule(a2);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    private static DynamicModule a(Context context, String str, Integer num, Bundle bundle) throws LoadingException {
        int intValue = num.intValue();
        bundle.putString("module_name", str);
        bundle.putInt(com.huawei.hms.ads.dynamic.a.m, intValue);
        try {
            g gVar = new g();
            aa.b(f8839a, "new DynamicLoader.");
            Context a2 = a(context.getApplicationContext() == null ? context : context.getApplicationContext(), str, bundle, gVar);
            if (a2 != null) {
                return new DynamicModule(a2);
            }
            throw new LoadingException("New version policy: Failed to get module context: null.");
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            aa.d(f8839a, "Other exception," + e3.getClass().getSimpleName());
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return new DynamicModule(context);
        }
    }

    private static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            cls = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException e2) {
            aa.c(f8839a, "ClassLoader class not found when use client context.");
            cls = null;
        }
        if (cls == null) {
            try {
                Class<?> loadClass = ((ClassLoader) Objects.requireNonNull(DynamicModule.class.getClassLoader())).loadClass(DynamicLoaderClassLoader.class.getName());
                if (loadClass != null) {
                    return loadClass;
                }
                throw new LoadingException("ClassLoader class is null.");
            } catch (ClassNotFoundException e3) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return cls;
    }

    private static void a(final String str, ClassLoader classLoader) throws LoadingException {
        try {
            final IBinder iBinder = (IBinder) classLoader.loadClass(com.huawei.hms.ads.dynamic.a.b).getConstructor(new Class[0]).newInstance(new Object[0]);
            f.set(new HashMap<String, IDynamicLoader>() { // from class: com.huawei.hms.ads.dynamic.DynamicModule.3
                {
                    put(str, IDynamicLoader.Stub.asInterface(iBinder));
                }
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage());
        }
    }

    private static Bundle b(Context context, final String str) throws LoadingException, a {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            final String string = queryHMSModuleBundle.getString("loader_path");
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                e.set(new HashMap<String, String>() { // from class: com.huawei.hms.ads.dynamic.DynamicModule.2
                    {
                        put(str, string);
                    }
                });
                aa.b(f8839a, "Query remote version by module name:" + str + " success.");
                return queryHMSModuleBundle;
            }
            aa.c(f8839a, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            queryHMSModuleBundle.putInt("module_version", -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new a("failed to Query remote version.", (byte) 0);
        }
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt(com.huawei.hms.ads.dynamic.a.h, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        String str2;
        if (context == null || str.length() == 0 || str.length() > 256) {
            aa.d(f8839a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str3 = "com.huawei.hms.ads.dynamic.descriptors." + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str3).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException e2) {
            str2 = "Cannot find the class of module descriptor for ".concat(String.valueOf(str));
            aa.c(f8839a, str2);
            return 0;
        } catch (Exception e3) {
            str2 = "Get local module info failed." + e3.getClass().getSimpleName();
            aa.c(f8839a, str2);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            aa.c(f8839a, "Get remote module info for " + str + " failed." + e3.getClass().getSimpleName());
        }
        synchronized (DynamicModule.class) {
            try {
                if (d.get() == null || d.get().get(str) == null || !d.get().get(str).booleanValue()) {
                    Bundle a2 = a(context, str);
                    if (a2.getInt("module_version") > 0) {
                        return a2;
                    }
                }
                if (d.get().get(str).booleanValue()) {
                    try {
                        return b(context, str);
                    } catch (a e4) {
                        aa.c(f8839a, "Query remote module info in HMS failed." + e4.getClass().getSimpleName());
                    }
                }
                return new Bundle();
            } finally {
            }
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle b2 = b(context, str);
            if (b2 == null || b2.isEmpty()) {
                aa.c(f8839a, "Query remote module:" + str + " info failed.");
                throw new LoadingException("Query remote module info failed: null or empty.");
            }
            return b2.getInt("module_version");
        } catch (a e2) {
            aa.c(f8839a, "Query remote module:" + str + " exception:" + e2);
            return 0;
        }
    }

    public static DynamicModule load(Context context, Integer num, String str) throws LoadingException {
        if (context == null || num == null || str == null || str.length() == 0 || str.length() > 256) {
            DynamicLoaderAnalysis.getInstance().onLoaderException(str, 1, "Null param, please check it.");
            throw new LoadingException("Null param, please check it.");
        }
        return a(context, num, str, new Bundle());
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, a {
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    Bundle call = contentResolver.call(Uri.parse(com.huawei.hms.ads.dynamic.a.f8851a), str, null, null);
                    if (call == null) {
                        aa.c(f8839a, "Failed to get bundle info:null.");
                        throw new a("Query remote version failed: null bundle info.", (byte) 0);
                    }
                    int i = call.getInt("errcode");
                    String string = call.getString("loader_path");
                    aa.b(f8839a, "bundle info: errorCode:" + i + ", moduleVersion:" + call.getInt("module_version") + ", modulePath:" + call.getString("module_path") + ", loader_version:" + call.getInt("loader_version") + ", loaderPath:" + string + ", armeabiType:" + call.getInt("armeabiType"));
                    if (i == 0) {
                        return call;
                    }
                    aa.c(f8839a, "Failed to get " + str + " bundle info, errcode:" + i);
                    throw new LoadingException("Query " + str + " unavailable, errorCode:" + i, call);
                }
                throw new a("Query remote version failed: null contentResolver.", (byte) 0);
            } catch (Exception e2) {
                throw new a("failed to get :" + str + " info.", (byte) 0);
            }
        } catch (LoadingException e3) {
            throw e3;
        }
    }

    public final Context getModuleContext() {
        return this.g;
    }
}
