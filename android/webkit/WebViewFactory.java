package android.webkit;

import android.app.ActivityManagerInternal;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemProperties;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.webkit.IWebViewUpdateService;
import com.android.internal.R;
import com.android.server.LocalServices;
import dalvik.system.VMRuntime;
import java.io.File;
import java.util.Arrays;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewFactory.class */
public final class WebViewFactory {
    private static final long CHROMIUM_WEBVIEW_DEFAULT_VMSIZE_BYTES = 104857600;
    private static final String CHROMIUM_WEBVIEW_FACTORY = "com.android.webview.chromium.WebViewChromiumFactoryProvider";
    private static final String CHROMIUM_WEBVIEW_NATIVE_RELRO_32 = "/data/misc/shared_relro/libwebviewchromium32.relro";
    private static final String CHROMIUM_WEBVIEW_NATIVE_RELRO_64 = "/data/misc/shared_relro/libwebviewchromium64.relro";
    public static final String CHROMIUM_WEBVIEW_VMSIZE_SIZE_PROPERTY = "persist.sys.webview.vmsize";
    private static final boolean DEBUG = false;
    private static final String LOGTAG = "WebViewFactory";
    private static final String NULL_WEBVIEW_FACTORY = "com.android.webview.nullwebview.NullWebViewFactoryProvider";
    private static PackageInfo sPackageInfo;
    private static WebViewFactoryProvider sProviderInstance;
    private static final Object sProviderLock = new Object();
    private static boolean sAddressSpaceReserved = false;

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewFactory$RelroFileCreator.class */
    private static class RelroFileCreator {
        private RelroFileCreator() {
        }

        public static void main(String[] strArr) {
            boolean is64Bit = VMRuntime.getRuntime().is64Bit();
            try {
                if (strArr.length != 2 || strArr[0] == null || strArr[1] == null) {
                    Log.e(WebViewFactory.LOGTAG, "Invalid RelroFileCreator args: " + Arrays.toString(strArr));
                    try {
                        WebViewFactory.access$000().notifyRelroCreationCompleted(is64Bit, false);
                    } catch (RemoteException e) {
                        Log.e(WebViewFactory.LOGTAG, "error notifying update service", e);
                    }
                    if (0 == 0) {
                        Log.e(WebViewFactory.LOGTAG, "failed to create relro file");
                    }
                    System.exit(0);
                    return;
                }
                Log.v(WebViewFactory.LOGTAG, "RelroFileCreator (64bit = " + is64Bit + "),  32-bit lib: " + strArr[0] + ", 64-bit lib: " + strArr[1]);
                if (!WebViewFactory.sAddressSpaceReserved) {
                    Log.e(WebViewFactory.LOGTAG, "can't create relro file; address space not reserved");
                    try {
                        WebViewFactory.access$000().notifyRelroCreationCompleted(is64Bit, false);
                    } catch (RemoteException e2) {
                        Log.e(WebViewFactory.LOGTAG, "error notifying update service", e2);
                    }
                    if (0 == 0) {
                        Log.e(WebViewFactory.LOGTAG, "failed to create relro file");
                    }
                    System.exit(0);
                    return;
                }
                boolean nativeCreateRelroFile = WebViewFactory.nativeCreateRelroFile(strArr[0], strArr[1], WebViewFactory.CHROMIUM_WEBVIEW_NATIVE_RELRO_32, WebViewFactory.CHROMIUM_WEBVIEW_NATIVE_RELRO_64);
                if (nativeCreateRelroFile) {
                }
                try {
                    WebViewFactory.access$000().notifyRelroCreationCompleted(is64Bit, nativeCreateRelroFile);
                } catch (RemoteException e3) {
                    Log.e(WebViewFactory.LOGTAG, "error notifying update service", e3);
                }
                if (!nativeCreateRelroFile) {
                    Log.e(WebViewFactory.LOGTAG, "failed to create relro file");
                }
                System.exit(0);
            } catch (Throwable th) {
                try {
                    WebViewFactory.access$000().notifyRelroCreationCompleted(is64Bit, false);
                } catch (RemoteException e4) {
                    Log.e(WebViewFactory.LOGTAG, "error notifying update service", e4);
                }
                if (0 == 0) {
                    Log.e(WebViewFactory.LOGTAG, "failed to create relro file");
                }
                System.exit(0);
                throw th;
            }
        }
    }

    static /* synthetic */ IWebViewUpdateService access$000() {
        return getUpdateService();
    }

    private static void createRelroFile(final boolean z, String[] strArr) {
        String str = z ? Build.SUPPORTED_64_BIT_ABIS[0] : Build.SUPPORTED_32_BIT_ABIS[0];
        final String str2 = str;
        Runnable runnable = new Runnable() { // from class: android.webkit.WebViewFactory.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.e(WebViewFactory.LOGTAG, "relro file creator for " + String.this + " crashed. Proceeding without");
                    WebViewFactory.access$000().notifyRelroCreationCompleted(z, false);
                } catch (RemoteException e) {
                    Log.e(WebViewFactory.LOGTAG, "Cannot reach WebViewUpdateService. " + e.getMessage());
                }
            }
        };
        try {
            if (strArr == null || strArr[0] == null || strArr[1] == null) {
                throw new IllegalArgumentException("Native library paths to the WebView RelRo process must not be null!");
            }
            if (((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).startIsolatedProcess(RelroFileCreator.class.getName(), strArr, "WebViewLoader-" + str, str, 1037, runnable) <= 0) {
                throw new Exception("Failed to start the relro file creator process");
            }
        } catch (Throwable th) {
            Log.e(LOGTAG, "error starting relro file creator for abi " + str, th);
            runnable.run();
        }
    }

    private static Class<WebViewFactoryProvider> getFactoryClass() throws ClassNotFoundException {
        Application initialApplication = AppGlobals.getInitialApplication();
        try {
            String webViewPackageName = getWebViewPackageName();
            sPackageInfo = initialApplication.getPackageManager().getPackageInfo(webViewPackageName, 0);
            Log.i(LOGTAG, "Loading " + webViewPackageName + " version " + sPackageInfo.versionName + " (code " + sPackageInfo.versionCode + ")");
            Context createPackageContext = initialApplication.createPackageContext(webViewPackageName, 3);
            initialApplication.getAssets().addAssetPath(createPackageContext.getApplicationInfo().sourceDir);
            ClassLoader classLoader = createPackageContext.getClassLoader();
            Trace.traceBegin(16L, "Class.forName()");
            Class cls = Class.forName(CHROMIUM_WEBVIEW_FACTORY, true, classLoader);
            Trace.traceEnd(16L);
            return cls;
        } catch (PackageManager.NameNotFoundException e) {
            try {
                return Class.forName(NULL_WEBVIEW_FACTORY);
            } catch (ClassNotFoundException e2) {
                Log.e(LOGTAG, "Chromium WebView package does not exist", e);
                throw new AndroidRuntimeException(e);
            }
        }
    }

    public static PackageInfo getLoadedPackageInfo() {
        return sPackageInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00df -> B:33:0x009f). Please submit an issue!!! */
    public static WebViewFactoryProvider getProvider() {
        synchronized (sProviderLock) {
            if (sProviderInstance != null) {
                return sProviderInstance;
            }
            int myUid = Process.myUid();
            if (myUid == 0 || (myUid == 1000 && !ActivityThread.currentPackageName().equals("com.android.settings"))) {
                throw new UnsupportedOperationException("For security reasons, WebView is not allowed in privileged processes");
            }
            Trace.traceBegin(16L, "WebViewFactory.getProvider()");
            Trace.traceBegin(16L, "WebViewFactory.loadNativeLibrary()");
            loadNativeLibrary();
            Trace.traceEnd(16L);
            Trace.traceBegin(16L, "WebViewFactory.getFactoryClass()");
            try {
                Class<WebViewFactoryProvider> factoryClass = getFactoryClass();
                Trace.traceEnd(16L);
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                Trace.traceBegin(16L, "providerClass.newInstance()");
                try {
                    sProviderInstance = factoryClass.getConstructor(WebViewDelegate.class).newInstance(new WebViewDelegate());
                } catch (Exception e) {
                    try {
                        sProviderInstance = factoryClass.newInstance();
                    } catch (Exception e2) {
                        Log.e(LOGTAG, "error instantiating provider", e2);
                        throw new AndroidRuntimeException(e2);
                    }
                }
                WebViewFactoryProvider webViewFactoryProvider = sProviderInstance;
                Trace.traceEnd(16L);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                Trace.traceEnd(16L);
                return webViewFactoryProvider;
            } catch (ClassNotFoundException e3) {
                Log.e(LOGTAG, "error loading provider", e3);
                throw new AndroidRuntimeException(e3);
            }
        }
    }

    private static IWebViewUpdateService getUpdateService() {
        return IWebViewUpdateService.Stub.asInterface(ServiceManager.getService("webviewupdate"));
    }

    private static String[] getWebViewNativeLibraryPaths() throws PackageManager.NameNotFoundException {
        String str;
        String str2;
        ApplicationInfo applicationInfo = AppGlobals.getInitialApplication().getPackageManager().getApplicationInfo(getWebViewPackageName(), 0);
        boolean is64BitAbi = VMRuntime.is64BitAbi(applicationInfo.primaryCpuAbi);
        if (TextUtils.isEmpty(applicationInfo.secondaryCpuAbi)) {
            if (is64BitAbi) {
                str2 = applicationInfo.nativeLibraryDir;
                str = "";
            } else {
                str = applicationInfo.nativeLibraryDir;
                str2 = "";
            }
        } else if (is64BitAbi) {
            str2 = applicationInfo.nativeLibraryDir;
            str = applicationInfo.secondaryNativeLibraryDir;
        } else {
            str2 = applicationInfo.secondaryNativeLibraryDir;
            str = applicationInfo.nativeLibraryDir;
        }
        String str3 = str;
        if (!TextUtils.isEmpty(str)) {
            str3 = str + "/libwebviewchromium.so";
        }
        String str4 = str2;
        if (!TextUtils.isEmpty(str2)) {
            str4 = str2 + "/libwebviewchromium.so";
        }
        return new String[]{str3, str4};
    }

    public static String getWebViewPackageName() {
        Application initialApplication = AppGlobals.getInitialApplication();
        String string = initialApplication.getString(R.string.config_alternateWebViewPackageName);
        return isPackageInstalled(initialApplication, string) ? string : initialApplication.getString(R.string.config_webViewPackageName);
    }

    private static boolean isPackageInstalled(Context context, String str) {
        boolean z = false;
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                z = true;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static void loadNativeLibrary() {
        if (!sAddressSpaceReserved) {
            Log.e(LOGTAG, "can't load with relro file; address space not reserved");
            return;
        }
        try {
            getUpdateService().waitForRelroCreationCompleted(VMRuntime.getRuntime().is64Bit());
            try {
                String[] webViewNativeLibraryPaths = getWebViewNativeLibraryPaths();
                if (nativeLoadWithRelroFile(webViewNativeLibraryPaths[0], webViewNativeLibraryPaths[1], CHROMIUM_WEBVIEW_NATIVE_RELRO_32, CHROMIUM_WEBVIEW_NATIVE_RELRO_64)) {
                    return;
                }
                Log.w(LOGTAG, "failed to load with relro file, proceeding without");
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(LOGTAG, "Failed to list WebView package libraries for loadNativeLibrary", e);
            }
        } catch (RemoteException e2) {
            Log.e(LOGTAG, "error waiting for relro creation, proceeding without", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeCreateRelroFile(String str, String str2, String str3, String str4);

    private static native boolean nativeLoadWithRelroFile(String str, String str2, String str3, String str4);

    private static native boolean nativeReserveAddressSpace(long j);

    public static void onWebViewUpdateInstalled() {
        long j;
        String[] strArr = null;
        try {
            String[] webViewNativeLibraryPaths = getWebViewNativeLibraryPaths();
            strArr = webViewNativeLibraryPaths;
            if (webViewNativeLibraryPaths != null) {
                long j2 = 0;
                int length = webViewNativeLibraryPaths.length;
                int i = 0;
                while (i < length) {
                    String str = webViewNativeLibraryPaths[i];
                    if (str == null) {
                        j = j2;
                    } else {
                        File file = new File(str);
                        j = j2;
                        if (file.exists()) {
                            long length2 = file.length();
                            j = j2;
                            if (length2 > j2) {
                                j = length2;
                            }
                        }
                    }
                    i++;
                    j2 = j;
                }
                long max = Math.max(2 * j2, (long) CHROMIUM_WEBVIEW_DEFAULT_VMSIZE_BYTES);
                Log.d(LOGTAG, "Setting new address space to " + max);
                strArr = webViewNativeLibraryPaths;
                SystemProperties.set(CHROMIUM_WEBVIEW_VMSIZE_SIZE_PROPERTY, Long.toString(max));
                strArr = webViewNativeLibraryPaths;
            }
        } catch (Throwable th) {
            Log.e(LOGTAG, "error preparing webview native library", th);
        }
        prepareWebViewInSystemServer(strArr);
    }

    public static void prepareWebViewInSystemServer() {
        String[] strArr = null;
        try {
            strArr = getWebViewNativeLibraryPaths();
        } catch (Throwable th) {
            Log.e(LOGTAG, "error preparing webview native library", th);
        }
        prepareWebViewInSystemServer(strArr);
    }

    private static void prepareWebViewInSystemServer(String[] strArr) {
        if (Build.SUPPORTED_32_BIT_ABIS.length > 0) {
            createRelroFile(false, strArr);
        }
        if (Build.SUPPORTED_64_BIT_ABIS.length > 0) {
            createRelroFile(true, strArr);
        }
    }

    public static void prepareWebViewInZygote() {
        try {
            System.loadLibrary("webviewchromium_loader");
            long j = SystemProperties.getLong(CHROMIUM_WEBVIEW_VMSIZE_SIZE_PROPERTY, CHROMIUM_WEBVIEW_DEFAULT_VMSIZE_BYTES);
            sAddressSpaceReserved = nativeReserveAddressSpace(j);
            if (sAddressSpaceReserved) {
                return;
            }
            Log.e(LOGTAG, "reserving " + j + " bytes of address space failed");
        } catch (Throwable th) {
            Log.e(LOGTAG, "error preparing native loader", th);
        }
    }
}
