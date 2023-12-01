package de.robv.android.xposed;

import android.annotation.SuppressLint;
import android.app.ActivityThread;
import android.app.AndroidAppHelper;
import android.app.Application;
import android.app.LoadedApk;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XResources;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import com.android.internal.os.ZygoteInit;
import com.tencent.tendinsv.a.b;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.IXposedHookCmdInit;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.services.BaseService;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XposedInit.class */
public final class XposedInit {
    @SuppressLint({"SdCardPath"})
    private static final String BASE_DIR;
    private static final String INSTALLER_PACKAGE_NAME = "de.robv.android.xposed.installer";
    private static final String INSTANT_RUN_CLASS = "com.android.tools.fd.runtime.BootstrapApplication";
    private static final String TAG = "Xposed";
    private static final String[] XRESOURCES_CONFLICTING_PACKAGES;
    private static boolean disableResources;
    private static final boolean startsSystemServer = XposedBridge.startsSystemServer();
    private static final String startClassName = XposedBridge.getStartClassName();

    static {
        BASE_DIR = Build.VERSION.SDK_INT >= 24 ? "/data/user_de/0/de.robv.android.xposed.installer/" : "/data/data/de.robv.android.xposed.installer/";
        disableResources = false;
        XRESOURCES_CONFLICTING_PACKAGES = new String[]{"com.sygic.aura"};
    }

    private XposedInit() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static XResources cloneToXResources(XC_MethodHook.MethodHookParam methodHookParam, String str) {
        Object result = methodHookParam.getResult();
        if (result == null || (result instanceof XResources) || Arrays.binarySearch(XRESOURCES_CONFLICTING_PACKAGES, AndroidAppHelper.currentPackageName()) == 0) {
            return null;
        }
        XResources xResources = (XResources) XposedBridge.cloneToSubclass(result, XResources.class);
        xResources.initObject(str);
        if (xResources.isFirstLoad()) {
            String packageName = xResources.getPackageName();
            XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam = new XC_InitPackageResources.InitPackageResourcesParam(XposedBridge.sInitPackageResourcesCallbacks);
            initPackageResourcesParam.packageName = packageName;
            initPackageResourcesParam.res = xResources;
            XCallback.callAll(initPackageResourcesParam);
        }
        methodHookParam.setResult(xResources);
        return xResources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hookResources() throws Throwable {
        Class<?> cls;
        Class<?> cls2;
        if (SELinuxHelper.getAppDataFileService().checkFileExists(BASE_DIR + "conf/disable_resources")) {
            Log.w("Xposed", "Found " + BASE_DIR + "conf/disable_resources, not hooking resources");
            disableResources = true;
        } else if (!XposedBridge.initXResourcesNative()) {
            Log.e("Xposed", "Cannot hook resources");
            disableResources = true;
        } else {
            final ThreadLocal threadLocal = new ThreadLocal();
            if (Build.VERSION.SDK_INT <= 18) {
                cls = ActivityThread.class;
                cls2 = Class.forName("android.app.ActivityThread$ResourcesKey");
            } else {
                cls = Class.forName("android.app.ResourcesManager");
                cls2 = Class.forName("android.content.res.ResourcesKey");
            }
            if (Build.VERSION.SDK_INT >= 24) {
                final Class<?> cls3 = cls2;
                XposedBridge.hookAllMethods(cls, "getOrCreateResources", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        int parameterIndexByType = XposedHelpers.getParameterIndexByType(methodHookParam.method, IBinder.class);
                        XResources cloneToXResources = XposedInit.cloneToXResources(methodHookParam, (String) XposedHelpers.getObjectField(methodHookParam.args[XposedHelpers.getParameterIndexByType(methodHookParam.method, Class.this)], "mResDir"));
                        if (cloneToXResources == null) {
                            return;
                        }
                        Object obj = methodHookParam.args[parameterIndexByType];
                        synchronized (methodHookParam.thisObject) {
                            (obj != null ? (ArrayList) XposedHelpers.getObjectField(XposedHelpers.callMethod(methodHookParam.thisObject, "getOrCreateActivityResourcesStructLocked", obj), "activityResources") : (ArrayList) XposedHelpers.getObjectField(methodHookParam.thisObject, "mResourceReferences")).add(new WeakReference(cloneToXResources));
                        }
                    }
                });
            } else {
                XposedBridge.hookAllConstructors(cls2, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.8
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        ThreadLocal.this.set(methodHookParam.thisObject);
                    }
                });
                XposedBridge.hookAllMethods(cls, "getTopLevelResources", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.9
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        Object obj = ThreadLocal.this.get();
                        if (obj == null) {
                            return;
                        }
                        ThreadLocal.this.set(null);
                        XResources cloneToXResources = XposedInit.cloneToXResources(methodHookParam, (String) XposedHelpers.getObjectField(obj, "mResDir"));
                        if (cloneToXResources != null) {
                            Map map = (Map) XposedHelpers.getObjectField(methodHookParam.thisObject, "mActiveResources");
                            Object objectField = Build.VERSION.SDK_INT <= 18 ? XposedHelpers.getObjectField(methodHookParam.thisObject, "mPackages") : methodHookParam.thisObject;
                            synchronized (objectField) {
                                try {
                                    WeakReference weakReference = (WeakReference) map.put(obj, new WeakReference(cloneToXResources));
                                    if (weakReference != null && weakReference.get() != 0 && ((Resources) weakReference.get()).getAssets() != cloneToXResources.getAssets()) {
                                        ((Resources) weakReference.get()).getAssets().close();
                                    }
                                } finally {
                                    Object obj2 = objectField;
                                }
                            }
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        ThreadLocal.this.set(null);
                    }
                });
                if (Build.VERSION.SDK_INT >= 19) {
                    XposedBridge.hookAllMethods(cls, "getTopLevelThemedResources", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.10
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // de.robv.android.xposed.XC_MethodHook
                        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            XposedInit.cloneToXResources(methodHookParam, (String) methodHookParam.args[0]);
                        }
                    });
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Set<Method> overriddenMethods = XposedHelpers.getOverriddenMethods(XResources.XTypedArray.class);
                XposedBridge.invalidateCallersNative((Member[]) overriddenMethods.toArray(new Member[overriddenMethods.size()]));
            }
            XposedBridge.hookAllConstructors(TypedArray.class, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.11
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    TypedArray typedArray = (TypedArray) methodHookParam.thisObject;
                    if (typedArray.getResources() instanceof XResources) {
                        XposedBridge.setObjectClass(typedArray, XResources.XTypedArray.class);
                    }
                }
            });
            XResources xResources = (XResources) XposedBridge.cloneToSubclass(Resources.getSystem(), XResources.class);
            xResources.initObject(null);
            XposedHelpers.setStaticObjectField(Resources.class, "mSystem", xResources);
            XResources.init(threadLocal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hookXposedInstaller(ClassLoader classLoader) {
        try {
            XposedHelpers.findAndHookMethod("de.robv.android.xposed.installer.XposedApp", classLoader, "getActiveXposedVersion", XC_MethodReplacement.returnConstant(Integer.valueOf(XposedBridge.getXposedVersion())));
            XposedHelpers.findAndHookMethod("de.robv.android.xposed.installer.XposedApp", classLoader, "onCreate", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.12
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    Application application = (Application) methodHookParam.thisObject;
                    if (application.getResources().getIdentifier("installer_needs_update", "string", XposedInit.INSTALLER_PACKAGE_NAME) == 0) {
                        Log.e("XposedInstaller", "Xposed Installer is outdated (resource string \"installer_needs_update\" is missing)");
                        Toast.makeText(application, "Please update Xposed Installer!", 1).show();
                    }
                }
            });
        } catch (Throwable th) {
            Log.e("Xposed", "Could not hook Xposed Installer", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initForZygote() throws Throwable {
        if (needsToCloseFilesForFork()) {
            XC_MethodHook xC_MethodHook = new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    XposedBridge.reopenFilesAfterForkNative();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    XposedBridge.closeFilesBeforeForkNative();
                }
            };
            Class<?> findClass = XposedHelpers.findClass("com.android.internal.os.Zygote", null);
            XposedBridge.hookAllMethods(findClass, "nativeForkAndSpecialize", xC_MethodHook);
            XposedBridge.hookAllMethods(findClass, "nativeForkSystemServer", xC_MethodHook);
        }
        final HashSet hashSet = new HashSet(1);
        XposedHelpers.findAndHookMethod(ActivityThread.class, "handleBindApplication", "android.app.ActivityThread.AppBindData", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // de.robv.android.xposed.XC_MethodHook
            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                ActivityThread activityThread = (ActivityThread) methodHookParam.thisObject;
                ApplicationInfo applicationInfo = (ApplicationInfo) XposedHelpers.getObjectField(methodHookParam.args[0], "appInfo");
                String str = applicationInfo.packageName.equals("android") ? "system" : applicationInfo.packageName;
                SELinuxHelper.initForProcess(str);
                if (((ComponentName) XposedHelpers.getObjectField(methodHookParam.args[0], "instrumentationName")) != null) {
                    Log.w("Xposed", "Instrumentation detected, disabling framework for " + str);
                    XposedBridge.disableHooks = true;
                    return;
                }
                CompatibilityInfo compatibilityInfo = (CompatibilityInfo) XposedHelpers.getObjectField(methodHookParam.args[0], "compatInfo");
                if (applicationInfo.sourceDir != null) {
                    XposedHelpers.setObjectField(activityThread, "mBoundApplication", methodHookParam.args[0]);
                    HashSet.this.add(str);
                    LoadedApk packageInfoNoCheck = activityThread.getPackageInfoNoCheck(applicationInfo, compatibilityInfo);
                    XResources.setPackageNameForResDir(applicationInfo.packageName, packageInfoNoCheck.getResDir());
                    XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                    loadPackageParam.packageName = str;
                    loadPackageParam.processName = (String) XposedHelpers.getObjectField(methodHookParam.args[0], b.a.u);
                    loadPackageParam.classLoader = packageInfoNoCheck.getClassLoader();
                    loadPackageParam.appInfo = applicationInfo;
                    loadPackageParam.isFirstApplication = true;
                    XC_LoadPackage.callAll(loadPackageParam);
                    if (str.equals(XposedInit.INSTALLER_PACKAGE_NAME)) {
                        XposedInit.hookXposedInstaller(loadPackageParam.classLoader);
                    }
                }
            }
        });
        if (Build.VERSION.SDK_INT < 21) {
            XposedHelpers.findAndHookMethod("com.android.server.ServerThread", null, Build.VERSION.SDK_INT < 19 ? "run" : "initAndLoop", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    SELinuxHelper.initForProcess("android");
                    HashSet.this.add("android");
                    XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                    loadPackageParam.packageName = "android";
                    loadPackageParam.processName = "android";
                    loadPackageParam.classLoader = XposedBridge.BOOTCLASSLOADER;
                    loadPackageParam.appInfo = null;
                    loadPackageParam.isFirstApplication = true;
                    XC_LoadPackage.callAll(loadPackageParam);
                }
            });
        } else if (startsSystemServer) {
            XposedHelpers.findAndHookMethod(ActivityThread.class, "systemMain", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    XposedHelpers.findAndHookMethod("com.android.server.SystemServer", contextClassLoader, "startBootstrapServices", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.4.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a1 -> B:22:0x0059). Please submit an issue!!! */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a5 -> B:22:0x0059). Please submit an issue!!! */
                        @Override // de.robv.android.xposed.XC_MethodHook
                        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam2) throws Throwable {
                            SELinuxHelper.initForProcess("android");
                            HashSet.this.add("android");
                            XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                            loadPackageParam.packageName = "android";
                            loadPackageParam.processName = "android";
                            loadPackageParam.classLoader = contextClassLoader;
                            loadPackageParam.appInfo = null;
                            loadPackageParam.isFirstApplication = true;
                            XC_LoadPackage.callAll(loadPackageParam);
                            try {
                                XposedHelpers.findAndHookMethod("com.android.server.pm.HwPackageManagerService", contextClassLoader, "isOdexMode", XC_MethodReplacement.returnConstant(false));
                            } catch (XposedHelpers.ClassNotFoundError e) {
                            } catch (NoSuchMethodError e2) {
                            }
                            try {
                                XposedHelpers.findAndHookMethod("com.android.server.pm." + (Build.VERSION.SDK_INT >= 23 ? "PackageDexOptimizer" : "PackageManagerService"), contextClassLoader, "dexEntryExists", String.class, XC_MethodReplacement.returnConstant(true));
                            } catch (XposedHelpers.ClassNotFoundError e3) {
                            } catch (NoSuchMethodError e4) {
                            }
                        }
                    });
                }
            });
        }
        XposedBridge.hookAllConstructors(LoadedApk.class, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // de.robv.android.xposed.XC_MethodHook
            public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                LoadedApk loadedApk = (LoadedApk) methodHookParam.thisObject;
                String packageName = loadedApk.getPackageName();
                XResources.setPackageNameForResDir(packageName, loadedApk.getResDir());
                if (!packageName.equals("android") && HashSet.this.add(packageName) && XposedHelpers.getBooleanField(loadedApk, "mIncludeCode")) {
                    XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                    loadPackageParam.packageName = packageName;
                    loadPackageParam.processName = AndroidAppHelper.currentProcessName();
                    loadPackageParam.classLoader = loadedApk.getClassLoader();
                    loadPackageParam.appInfo = loadedApk.getApplicationInfo();
                    loadPackageParam.isFirstApplication = false;
                    XC_LoadPackage.callAll(loadPackageParam);
                }
            }
        });
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", null, "getResourcesForApplication", ApplicationInfo.class, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // de.robv.android.xposed.XC_MethodHook
            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                ApplicationInfo applicationInfo = (ApplicationInfo) methodHookParam.args[0];
                XResources.setPackageNameForResDir(applicationInfo.packageName, applicationInfo.uid == Process.myUid() ? applicationInfo.sourceDir : applicationInfo.publicSourceDir);
            }
        });
        if (XposedHelpers.findFieldIfExists(ZygoteInit.class, "BOOT_START_TIME") != null) {
            XposedHelpers.setStaticLongField(ZygoteInit.class, "BOOT_START_TIME", XposedBridge.BOOT_START_TIME);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("com.android.internal.os.Zygote", null), "isEnhancedZygoteASLREnabled", false);
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private static void loadModule(String str, ClassLoader classLoader) {
        ZipFile zipFile;
        Log.i("Xposed", "Loading modules from " + str);
        if (!new File(str).exists()) {
            Log.e("Xposed", "  File does not exist");
            return;
        }
        try {
            DexFile dexFile = new DexFile(str);
            if (dexFile.loadClass(INSTANT_RUN_CLASS, classLoader) != null) {
                Log.e("Xposed", "  Cannot load module, please disable \"Instant Run\" in Android Studio.");
                XposedHelpers.closeSilently(dexFile);
            } else if (dexFile.loadClass(XposedBridge.class.getName(), classLoader) != null) {
                Log.e("Xposed", "  Cannot load module:");
                Log.e("Xposed", "  The Xposed API classes are compiled into the module's APK.");
                Log.e("Xposed", "  This may cause strange issues and must be fixed by the module developer.");
                Log.e("Xposed", "  For details, see: http://api.xposed.info/using.html");
                XposedHelpers.closeSilently(dexFile);
            } else {
                XposedHelpers.closeSilently(dexFile);
                try {
                    zipFile = new ZipFile(str);
                    try {
                        ZipEntry entry = zipFile.getEntry("assets/xposed_init");
                        if (entry == null) {
                            Log.e("Xposed", "  assets/xposed_init not found in the APK");
                            XposedHelpers.closeSilently(zipFile);
                            return;
                        }
                        InputStream inputStream = zipFile.getInputStream(entry);
                        PathClassLoader pathClassLoader = new PathClassLoader(str, XposedBridge.BOOTCLASSLOADER);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    return;
                                }
                                String trim = readLine.trim();
                                if (!trim.isEmpty() && !trim.startsWith("#")) {
                                    try {
                                        Log.i("Xposed", "  Loading class " + trim);
                                        Class<?> loadClass = pathClassLoader.loadClass(trim);
                                        if (!IXposedMod.class.isAssignableFrom(loadClass)) {
                                            Log.e("Xposed", "    This class doesn't implement any sub-interface of IXposedMod, skipping it");
                                        } else if (disableResources && IXposedHookInitPackageResources.class.isAssignableFrom(loadClass)) {
                                            Log.e("Xposed", "    This class requires resource-related hooks (which are disabled), skipping it.");
                                        } else {
                                            Object newInstance = loadClass.newInstance();
                                            if (XposedBridge.isZygote) {
                                                if (newInstance instanceof IXposedHookZygoteInit) {
                                                    IXposedHookZygoteInit.StartupParam startupParam = new IXposedHookZygoteInit.StartupParam();
                                                    startupParam.modulePath = str;
                                                    startupParam.startsSystemServer = startsSystemServer;
                                                    ((IXposedHookZygoteInit) newInstance).initZygote(startupParam);
                                                }
                                                if (newInstance instanceof IXposedHookLoadPackage) {
                                                    XposedBridge.hookLoadPackage(new IXposedHookLoadPackage.Wrapper((IXposedHookLoadPackage) newInstance));
                                                }
                                                if (newInstance instanceof IXposedHookInitPackageResources) {
                                                    XposedBridge.hookInitPackageResources(new IXposedHookInitPackageResources.Wrapper((IXposedHookInitPackageResources) newInstance));
                                                }
                                            } else if (newInstance instanceof IXposedHookCmdInit) {
                                                IXposedHookCmdInit.StartupParam startupParam2 = new IXposedHookCmdInit.StartupParam();
                                                startupParam2.modulePath = str;
                                                startupParam2.startClassName = startClassName;
                                                ((IXposedHookCmdInit) newInstance).initCmdApp(startupParam2);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        Log.e("Xposed", "    Failed to load class " + trim, th);
                                    }
                                }
                            } catch (IOException e) {
                                Log.e("Xposed", "  Failed to load module from " + str, e);
                                return;
                            } finally {
                                XposedHelpers.closeSilently(inputStream);
                                XposedHelpers.closeSilently(zipFile);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Log.e("Xposed", "  Cannot read assets/xposed_init in the APK", e);
                        XposedHelpers.closeSilently(zipFile);
                    }
                } catch (IOException e3) {
                    e = e3;
                    zipFile = null;
                }
            }
        } catch (IOException e4) {
            Log.e("Xposed", "  Cannot load module", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadModules() throws IOException {
        ClassLoader classLoader;
        String str = BASE_DIR + "conf/modules.list";
        BaseService appDataFileService = SELinuxHelper.getAppDataFileService();
        if (!appDataFileService.checkFileExists(str)) {
            Log.e("Xposed", "Cannot load any modules because " + str + " was not found");
            return;
        }
        ClassLoader classLoader2 = XposedBridge.BOOTCLASSLOADER;
        while (true) {
            classLoader = classLoader2;
            ClassLoader parent = classLoader.getParent();
            if (parent == null) {
                break;
            }
            classLoader2 = parent;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(appDataFileService.getFileInputStream(str)));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return;
            }
            loadModule(readLine, classLoader);
        }
    }

    private static boolean needsToCloseFilesForFork() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        File file = new File(Environment.getRootDirectory(), "lib/libandroid_runtime.so");
        try {
            return XposedHelpers.fileContains(file, "Unable to construct file descriptor table");
        } catch (IOException e) {
            Log.e("Xposed", "Could not check whether " + file + " has security patch level 5");
            return true;
        }
    }
}
