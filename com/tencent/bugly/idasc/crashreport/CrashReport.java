package com.tencent.bugly.idasc.crashreport;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.applog.util.WebViewJsUtil;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.CrashModule;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.idasc.proguard.aa;
import com.tencent.bugly.idasc.proguard.ac;
import com.tencent.bugly.idasc.proguard.ak;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.an;
import com.tencent.bugly.idasc.proguard.ap;
import com.tencent.bugly.idasc.proguard.aq;
import com.tencent.bugly.idasc.proguard.at;
import com.tencent.bugly.idasc.proguard.au;
import com.tencent.bugly.idasc.proguard.bc;
import com.tencent.bugly.idasc.proguard.p;
import com.tencent.bugly.idasc.proguard.s;
import com.tencent.bugly.idasc.proguard.w;
import com.tencent.bugly.idasc.proguard.x;
import com.tencent.bugly.idasc.proguard.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/CrashReport.class */
public class CrashReport {

    /* renamed from: a  reason: collision with root package name */
    private static Context f21498a;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/CrashReport$CrashHandleCallback.class */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/CrashReport$UserStrategy.class */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c  reason: collision with root package name */
        CrashHandleCallback f21500c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public int getCallBackType() {
            int i;
            synchronized (this) {
                i = this.f21494a;
            }
            return i;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public boolean getCloseErrorCallback() {
            boolean z;
            synchronized (this) {
                z = this.b;
            }
            return z;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public CrashHandleCallback getCrashHandleCallback() {
            CrashHandleCallback crashHandleCallback;
            synchronized (this) {
                crashHandleCallback = this.f21500c;
            }
            return crashHandleCallback;
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public void setCallBackType(int i) {
            synchronized (this) {
                this.f21494a = i;
            }
        }

        @Override // com.tencent.bugly.idasc.BuglyStrategy
        public void setCloseErrorCallback(boolean z) {
            synchronized (this) {
                this.b = z;
            }
        }

        public void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            synchronized (this) {
                this.f21500c = crashHandleCallback;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/CrashReport$a.class */
    public interface a {
        String a();

        void a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void a(String str);

        void b();

        CharSequence c();
    }

    public static void closeBugly() {
        String str;
        String str2;
        if (!p.f21636a) {
            str = al.b;
            str2 = "Can not close bugly because bugly is disable.";
        } else if (CrashModule.getInstance().hasInitialized()) {
            if (f21498a == null) {
                return;
            }
            aq a2 = aq.a();
            if (a2 != null) {
                a2.b(f21498a);
            }
            closeCrashReport();
            s.a(f21498a);
            ak a3 = ak.a();
            if (a3 != null) {
                a3.b();
                return;
            }
            return;
        } else {
            str = al.b;
            str2 = "CrashReport has not been initialed! pls to call method 'initCrashReport' first!";
        }
        Log.w(str, str2);
    }

    public static void closeCrashReport() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not close crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().c();
        } else {
            Log.w(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not close native report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().d();
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z) {
        p.f21636a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        setCollectPrivacyInfo(context, z);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context == null) {
            Log.e(al.b, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        } else {
            return aa.a(context).w();
        }
    }

    public static String getAppChannel() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get App channel because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f21498a).s;
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static String getAppID() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get App ID because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f21498a).e();
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static String getAppVer() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get app version because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f21498a).o;
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            al.d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return aa.a(context).h;
    }

    public static Context getContext() {
        return f21498a;
    }

    public static String getDeviceID(Context context) {
        return aa.a(context).g();
    }

    public static Proxy getHttpProxy() {
        return an.f21550a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f21498a).K;
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context == null) {
            al.d("Context should not be null.", new Object[0]);
            return null;
        } else {
            return aa.a(context).K;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(al.b, "getUserDataValue args context should not be null");
            return "unknown";
        } else if (ap.b(str)) {
            return null;
        } else {
            return aa.a(context).g(str);
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(al.b, "getUserDatasSize args context should not be null");
            return -1;
        } else {
            return aa.a(context).v();
        }
    }

    public static String getUserId() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get user ID because bugly is disable.");
            return "unknown";
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f21498a).f();
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(al.b, "getUserSceneTagId args context should not be null");
            return -1;
        } else {
            return aa.a(context).z();
        }
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f21498a = context;
        p.a(CrashModule.getInstance());
        p.a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f21498a = context;
        p.a(CrashModule.getInstance());
        p.a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f21498a = context;
        p.a(CrashModule.getInstance());
        p.a(context, str, z, userStrategy);
    }

    public static boolean isLastSessionCrash() {
        if (!p.f21636a) {
            Log.w(al.b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        } else {
            at a2 = at.a();
            Boolean bool = a2.A;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = aa.b().d;
            List<y> a3 = w.a().a(1);
            ArrayList arrayList = new ArrayList();
            if (a3 == null || a3.size() <= 0) {
                a2.A = Boolean.FALSE;
                return false;
            }
            for (y yVar : a3) {
                if (str.equals(yVar.f21663c)) {
                    a2.A = Boolean.TRUE;
                    arrayList.add(yVar);
                }
            }
            if (arrayList.size() > 0) {
                w.a().a(arrayList);
                return true;
            }
            return true;
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(final Throwable th, Thread thread, final boolean z) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            al.d("throwable is null, just return", new Object[0]);
        } else {
            Thread thread2 = thread;
            if (thread == null) {
                thread2 = Thread.currentThread();
            }
            final at a2 = at.a();
            final Thread thread3 = thread2;
            a2.w.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.at.3

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f21574a = false;
                final /* synthetic */ String d = null;
                final /* synthetic */ byte[] e = null;
                final /* synthetic */ boolean f = true;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        al.c("post a throwable %b", Boolean.valueOf(this.f21574a));
                        at.this.t.a(thread3, th, false, this.d, this.e, this.f);
                        if (z) {
                            al.a("clear user datas", new Object[0]);
                            aa.a(at.this.f21571c).u();
                        }
                    } catch (Throwable th2) {
                        if (!al.b(th2)) {
                            th2.printStackTrace();
                        }
                        al.e("java catch error: %s", th.toString());
                    }
                }
            });
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not post crash caught because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            au.a(thread, i, str, str2, str3, map);
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ap.b(str) || ap.b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        String str3 = replace;
        if (replace.length() > 100) {
            Log.w(al.b, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            str3 = replace.substring(0, 50);
        }
        String str4 = str2;
        if (str2.length() > 500) {
            Log.w(al.b, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str4 = str2.substring(0, 200);
        }
        aa.a(context).b(str3, str4);
        al.b(String.format("[param] putSdkData data: %s - %s", str3, str4), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "putUserData args context should not be null");
        } else if (str == null) {
            new StringBuilder().append(str);
            al.d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            new StringBuilder().append(str2);
            al.d("putUserData args value should not be null", new Object[0]);
        } else {
            String str3 = str2;
            if (str2.length() > 200) {
                al.d("user data value length over limit %d, it will be cutted!", 200);
                str3 = str2.substring(0, 200);
            }
            aa a2 = aa.a(context);
            if (a2.w().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str3);
                }
                aa.a(context).a(str, str3);
                al.c("replace KV %s %s", str, str3);
            } else if (a2.v() >= 50) {
                al.d("user data size is over limit %d, it will be cutted!", 50);
            } else {
                String str4 = str;
                if (str.length() > 50) {
                    al.d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str4 = str.substring(0, 50);
                }
                NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                if (nativeCrashHandler2 != null) {
                    nativeCrashHandler2.putKeyValueToNative(str4, str3);
                }
                aa.a(context).a(str4, str3);
                al.b("[param] set user data: %s - %s", str4, str3);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(al.b, "removeUserData args context should not be null");
            return "unknown";
        } else if (ap.b(str)) {
            return null;
        } else {
            al.b("[param] remove user data: %s", str);
            return aa.a(context).f(str);
        }
    }

    public static void setAllThreadStackEnable(Context context, boolean z, boolean z2) {
        aa a2 = aa.a(context);
        a2.Q = z;
        a2.R = z2;
    }

    public static void setAppChannel(Context context, String str) {
        String str2;
        String str3;
        if (!p.f21636a) {
            str2 = al.b;
            str3 = "Can not set App channel because Bugly is disable.";
        } else if (context == null) {
            str2 = al.b;
            str3 = "setAppChannel args context should not be null";
        } else if (str != null) {
            aa.a(context).s = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppChannel(str);
                return;
            }
            return;
        } else {
            str2 = al.b;
            str3 = "App channel is null, will not set";
        }
        Log.w(str2, str3);
    }

    public static void setAppPackage(Context context, String str) {
        String str2;
        String str3;
        if (!p.f21636a) {
            str2 = al.b;
            str3 = "Can not set App package because bugly is disable.";
        } else if (context == null) {
            str2 = al.b;
            str3 = "setAppPackage args context should not be null";
        } else if (str != null) {
            aa.a(context).f21522c = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppPackage(str);
                return;
            }
            return;
        } else {
            str2 = al.b;
            str3 = "App package is null, will not set";
        }
        Log.w(str2, str3);
    }

    public static void setAppVersion(Context context, String str) {
        String str2;
        String str3;
        if (!p.f21636a) {
            str2 = al.b;
            str3 = "Can not set App version because bugly is disable.";
        } else if (context == null) {
            str2 = al.b;
            str3 = "setAppVersion args context should not be null";
        } else if (str != null) {
            aa.a(context).o = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
                return;
            }
            return;
        } else {
            str2 = al.b;
            str3 = "App version is null, will not set";
        }
        Log.w(str2, str3);
    }

    public static void setBuglyDbName(String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(al.b, "Set Bugly DB name: ".concat(String.valueOf(str)));
        x.f21660a = str;
    }

    public static void setCollectPrivacyInfo(Context context, boolean z) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set collect privacy info enable because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setCollectPrivacyInfo args context should not be null");
        } else {
            Log.i(al.b, "setCollectPrivacyInfo: ".concat(String.valueOf(z)));
            aa.a(context).n = z;
        }
    }

    public static void setContext(Context context) {
        f21498a = context;
    }

    public static void setCrashFilter(String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.b, "Set crash stack filter: ".concat(String.valueOf(str)));
        at.q = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.b, "Set crash stack filter: ".concat(String.valueOf(str)));
        at.r = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setTombPath args context should not be null");
        } else {
            String str2 = al.b;
            if (str == null) {
                Log.w(str2, "tombstone path is null, will not set");
                return;
            }
            Log.i(str2, "user set tombstone path: ".concat(String.valueOf(str)));
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.b, "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z)));
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            an.f21550a = null;
        } else {
            an.f21550a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            an.f21550a = null;
        } else {
            an.f21550a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z) {
        al.a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            al.d("Context should not be null.", new Object[0]);
        } else {
            Object[] objArr = new Object[0];
            if (z) {
                al.c("This is a development device.", objArr);
            } else {
                al.c("This is not a development device.", objArr);
            }
            aa.a(context).I = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(al.b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a() { // from class: com.tencent.bugly.idasc.crashreport.CrashReport.1
            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final String a() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final void a(String str) {
                Tracker.loadUrl(webView, str);
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final void b() {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.idasc.crashreport.CrashReport.a
            public final CharSequence c() {
                return webView.getContentDescription();
            }
        }, z, z2);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z) {
        return setJavascriptMonitor(aVar, z, false);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z, boolean z2) {
        if (aVar == null) {
            Log.w(al.b, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            al.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            al.a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!p.f21636a) {
                Log.w(al.b, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            al.c("URL of webview is %s", aVar.a());
            if (!z2 && Build.VERSION.SDK_INT < 19) {
                al.e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            al.a("Enable the javascript needed by webview monitor.", new Object[0]);
            aVar.b();
            H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(aVar);
            if (h5JavaScriptInterface != null) {
                al.a("Add a secure javascript interface to the webview.", new Object[0]);
                aVar.a(h5JavaScriptInterface, "exceptionUploader");
            }
            if (z) {
                al.a("Inject bugly.js(v%s) to the webview.", bc.b());
                String a2 = bc.a();
                if (a2 == null) {
                    al.e("Failed to inject Bugly.js.", bc.b());
                    return false;
                }
                aVar.a(WebViewJsUtil.JS_URL_PREFIX.concat(String.valueOf(a2)));
                return true;
            }
            return true;
        }
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not put SDK extra data because bugly is disable.");
        } else if (context == null || ap.b(str) || ap.b(str2)) {
        } else {
            aa a2 = aa.a(context);
            if (str == null || str2 == null) {
                return;
            }
            synchronized (a2.T) {
                a2.K.put(str, str2);
            }
        }
    }

    public static void setServerUrl(String str) {
        if (ap.b(str) || !ap.d(str)) {
            Log.i(al.b, "URL is invalid.");
            return;
        }
        ac.a(str);
        StrategyBean.f21505a = str;
        StrategyBean.b = str;
    }

    public static void setSessionIntervalMills(long j) {
        if (p.f21636a) {
            s.a(j);
        } else {
            Log.w(al.b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(Context context, String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(al.b, "Context should not be null when bugly has not been initialed!");
        } else if (TextUtils.isEmpty(str)) {
            al.d("userId should not be null", new Object[0]);
        } else {
            String str2 = str;
            if (str.length() > 100) {
                str2 = str.substring(0, 100);
                al.d("userId %s length is over limit %d substring to %s", str, 100, str2);
            }
            if (str2.equals(aa.a(context).f())) {
                return;
            }
            aa a2 = aa.a(context);
            synchronized (a2.V) {
                a2.l = String.valueOf(str2 == null ? "10000" : str2);
            }
            al.b("[user] set userId : %s", str2);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str2);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                s.a();
            }
        }
    }

    public static void setUserId(String str) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f21498a, str);
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(al.b, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                al.d("setTag args tagId should > 0", new Object[0]);
            }
            aa a2 = aa.a(context);
            synchronized (a2.U) {
                int i2 = a2.w;
                if (i2 != i) {
                    a2.w = i;
                    al.a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(a2.w));
                }
            }
            al.b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static void startCrashReport() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not start crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            at.a().b();
        } else {
            Log.w(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            al.a("start to create a anr crash for test!", new Object[0]);
            at.a().h();
        }
    }

    public static void testJavaCrash() {
        int i;
        if (!p.f21636a) {
            Log.w(al.b, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            aa b = aa.b();
            if (b != null && (i = b.x) != 24096) {
                b.x = 24096;
                al.a("server scene tag %d changed to tag %d", Integer.valueOf(i), Integer.valueOf(b.x));
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!p.f21636a) {
            Log.w(al.b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            al.a("start to create a native crash for test!", new Object[0]);
            at.a().a(z, z2, z3);
        }
    }

    public static void uploadUserInfo() {
        if (!p.f21636a) {
            Log.w(al.b, "Can not upload user info because bugly is disable.");
        } else if (s.b == null) {
            Log.w(al.b, "Can not upload user info because bugly is not init.");
        } else {
            s.b.b();
        }
    }
}
