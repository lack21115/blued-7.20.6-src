package com.tencent.bugly.crashreport;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/CrashReport.class */
public class CrashReport {

    /* renamed from: a  reason: collision with root package name */
    private static Context f35110a;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/CrashReport$CrashHandleCallback.class */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/CrashReport$UserStrategy.class */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c  reason: collision with root package name */
        private CrashHandleCallback f35112c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public int getCallBackType() {
            int i;
            synchronized (this) {
                i = this.f35104a;
            }
            return i;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public boolean getCloseErrorCallback() {
            boolean z;
            synchronized (this) {
                z = this.b;
            }
            return z;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public CrashHandleCallback getCrashHandleCallback() {
            CrashHandleCallback crashHandleCallback;
            synchronized (this) {
                crashHandleCallback = this.f35112c;
            }
            return crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public void setCallBackType(int i) {
            synchronized (this) {
                this.f35104a = i;
            }
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public void setCloseErrorCallback(boolean z) {
            synchronized (this) {
                this.b = z;
            }
        }

        public void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            synchronized (this) {
                this.f35112c = crashHandleCallback;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/CrashReport$WebViewInterface.class */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f35110a == null) {
        } else {
            BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
            if (buglyBroadcastReceiver != null) {
                buglyBroadcastReceiver.unregister(f35110a);
            }
            closeCrashReport();
            com.tencent.bugly.crashreport.biz.b.a(f35110a);
            w a2 = w.a();
            if (a2 != null) {
                a2.b();
            }
        }
    }

    public static void closeCrashReport() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not close crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            c.a().d();
        } else {
            Log.w(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not close native report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            c.a().f();
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z) {
        b.f35108a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set DB name because bugly is disable.");
        } else if (context == null) {
            Log.w(x.f35414a, "enableObtainId args context should not be null");
        } else {
            String str = x.f35414a;
            Log.i(str, "Enable identification obtaining? " + z);
            com.tencent.bugly.crashreport.common.info.a.a(context).b(z);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context == null) {
            Log.e(x.f35414a, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).w();
        }
    }

    public static String getAppChannel() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get App channel because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f35110a).m;
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static String getAppID() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get App ID because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f35110a).f();
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static String getAppVer() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get app version because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f35110a).k;
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            x.d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).c();
    }

    public static Proxy getHttpProxy() {
        return com.tencent.bugly.proguard.a.b();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f35110a).C;
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return null;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).C;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(x.f35414a, "getUserDataValue args context should not be null");
            return "unknown";
        } else if (z.a(str)) {
            return null;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).g(str);
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(x.f35414a, "getUserDatasSize args context should not be null");
            return -1;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).v();
        }
    }

    public static String getUserId() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get user ID because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f35110a).g();
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(x.f35414a, "getUserSceneTagId args context should not be null");
            return -1;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).z();
        }
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f35110a = context;
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f35110a = context;
        b.a(CrashModule.getInstance());
        b.a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        if (context != null) {
            f35110a = context;
            b.a(CrashModule.getInstance());
            b.a(context, str, z, null);
        }
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f35110a = context;
        b.a(CrashModule.getInstance());
        b.a(context, str, z, userStrategy);
    }

    public static boolean isLastSessionCrash() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return c.a().b();
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            x.d("throwable is null, just return", new Object[0]);
        } else {
            Thread thread2 = thread;
            if (thread == null) {
                thread2 = Thread.currentThread();
            }
            c.a().a(thread2, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not post crash caught because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            d.a(thread, i, str, str2, str3, map);
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || z.a(str) || z.a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        String str3 = replace;
        if (replace.length() > 100) {
            Log.w(x.f35414a, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            str3 = replace.substring(0, 50);
        }
        String str4 = str2;
        if (str2.length() > 500) {
            Log.w(x.f35414a, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str4 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).c(str3, str4);
        x.b(String.format("[param] putSdkData data: %s - %s", str3, str4), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(x.f35414a, "putUserData args context should not be null");
        } else if (str == null) {
            x.d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            x.d("putUserData args value should not be null", new Object[0]);
        } else {
            String str3 = str2;
            if (str2.length() > 200) {
                x.d("user data value length over limit %d, it will be cutted!", 200);
                str3 = str2.substring(0, 200);
            }
            com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
            if (a2.w().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str3);
                }
                com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str3);
                x.c("replace KV %s %s", str, str3);
            } else if (a2.v() >= 50) {
                x.d("user data size is over limit %d, it will be cutted!", 50);
            } else {
                String str4 = str;
                if (str.length() > 50) {
                    x.d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str4 = str.substring(0, 50);
                }
                NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                if (nativeCrashHandler2 != null) {
                    nativeCrashHandler2.putKeyValueToNative(str4, str3);
                }
                com.tencent.bugly.crashreport.common.info.a.a(context).b(str4, str3);
                x.b("[param] set user data: %s - %s", str4, str3);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(x.f35414a, "removeUserData args context should not be null");
            return "unknown";
        } else if (z.a(str)) {
            return null;
        } else {
            x.b("[param] remove user data: %s", str);
            return com.tencent.bugly.crashreport.common.info.a.a(context).f(str);
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(x.f35414a, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(x.f35414a, "App channel is null, will not set");
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).m = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(x.f35414a, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(x.f35414a, "App package is null, will not set");
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).f35130c = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppPackage(str);
            }
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(x.f35414a, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(x.f35414a, "App version is null, will not set");
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).k = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
            }
        }
    }

    public static void setBuglyDbName(String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set DB name because bugly is disable.");
            return;
        }
        String str2 = x.f35414a;
        Log.i(str2, "Set Bugly DB name: " + str);
        q.f35400a = str;
    }

    public static void setContext(Context context) {
        f35110a = context;
    }

    public static void setCrashFilter(String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = x.f35414a;
        Log.i(str2, "Set crash stack filter: " + str);
        c.n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = x.f35414a;
        Log.i(str2, "Set crash stack filter: " + str);
        c.o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set App package because bugly is disable.");
            return;
        }
        String str = x.f35414a;
        Log.i(str, "Should handle native crash in Java profile after handled in native profile: " + z);
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i) {
        com.tencent.bugly.proguard.a.a(str, i);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        com.tencent.bugly.proguard.a.a(inetAddress, i);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set 'isAppForeground' because bugly is disable.");
        } else if (context == null) {
            x.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                x.c("App is in foreground.", new Object[0]);
            } else {
                x.c("App is in background.", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            x.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                x.c("This is a development device.", new Object[0]);
            } else {
                x.c("This is not a development device.", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).A = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(x.f35414a, "WebView is null.");
            return false;
        }
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                WebView.this.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final CharSequence getContentDescription() {
                return WebView.this.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final String getUrl() {
                return WebView.this.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void loadUrl(String str) {
                Tracker.loadUrl(WebView.this, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void setJavaScriptEnabled(boolean z3) {
                WebSettings settings = WebView.this.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }
        }, z, z2);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(x.f35414a, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            x.a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!b.f35108a) {
                Log.w(x.f35414a, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            x.c("URL of webview is %s", webViewInterface.getUrl());
            if (!z2 && Build.VERSION.SDK_INT < 19) {
                x.e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            x.a("Enable the javascript needed by webview monitor.", new Object[0]);
            webViewInterface.setJavaScriptEnabled(true);
            H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
            if (h5JavaScriptInterface != null) {
                x.a("Add a secure javascript interface to the webview.", new Object[0]);
                webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
            }
            if (z) {
                x.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
                String a2 = com.tencent.bugly.crashreport.crash.h5.b.a();
                if (a2 == null) {
                    x.e("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                    return false;
                }
                webViewInterface.loadUrl("javascript:" + a2);
                return true;
            }
            return true;
        }
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not put SDK extra data because bugly is disable.");
        } else if (context == null || z.a(str) || z.a(str2)) {
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).a(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (z.a(str) || !z.c(str)) {
            Log.i(x.f35414a, "URL is invalid.");
            return;
        }
        com.tencent.bugly.crashreport.common.strategy.a.a(str);
        StrategyBean.f35133a = str;
        StrategyBean.b = str;
    }

    public static void setSessionIntervalMills(long j) {
        if (b.f35108a) {
            com.tencent.bugly.crashreport.biz.b.a(j);
        } else {
            Log.w(x.f35414a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(Context context, String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(x.f35414a, "Context should not be null when bugly has not been initialed!");
        } else if (TextUtils.isEmpty(str)) {
            x.d("userId should not be null", new Object[0]);
        } else {
            String str2 = str;
            if (str.length() > 100) {
                str2 = str.substring(0, 100);
                x.d("userId %s length is over limit %d substring to %s", str, 100, str2);
            }
            if (str2.equals(com.tencent.bugly.crashreport.common.info.a.a(context).g())) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str2);
            x.b("[user] set userId : %s", str2);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str2);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                com.tencent.bugly.crashreport.biz.b.a();
            }
        }
    }

    public static void setUserId(String str) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f35110a, str);
        } else {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(x.f35414a, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                x.d("setTag args tagId should > 0", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(i);
            x.b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static void startCrashReport() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not start crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            c.a().c();
        } else {
            Log.w(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            x.a("start to create a anr crash for test!", new Object[0]);
            c.a().k();
        }
    }

    public static void testJavaCrash() {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
            if (b != null) {
                b.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!b.f35108a) {
            Log.w(x.f35414a, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f35414a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            x.a("start to create a native crash for test!", new Object[0]);
            c.a().a(z, z2, z3);
        }
    }
}
