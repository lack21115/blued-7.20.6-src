package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.d;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/export/CrashApi.class */
public class CrashApi {

    /* renamed from: a  reason: collision with root package name */
    private static CrashApi f40585a;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f40586c = true;
    private static boolean d = false;
    private boolean b;

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.b = false;
        Context a2 = a(context);
        b(a2);
        b.g = z2;
        b.h = z3;
        if (b.L()) {
            b(a2);
            a(a2, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (b.g && e.e("libcrashsdk.so")) {
                b.f = true;
                b();
            }
        } else if (customInfo == null || versionInfo == null) {
            a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        } else {
            g.a(customInfo);
            try {
                a(a2, customInfo, versionInfo, iCrashClient);
            } catch (Throwable th) {
                a(th);
            }
            if (z) {
                try {
                    a();
                } catch (Throwable th2) {
                    a(th2);
                }
            }
            try {
                b.M();
                h.a();
                d.a();
                com.uc.crashsdk.a.g.j();
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
            try {
                if (!b.a(a2)) {
                    a.d("crashsdk", "registerLifecycleCallbacks failed!");
                }
            } catch (Throwable th4) {
                com.uc.crashsdk.a.g.a(th4);
            }
            try {
                com.uc.crashsdk.a.n();
                e.A();
                e.B();
            } catch (Throwable th5) {
                com.uc.crashsdk.a.g.a(th5);
            }
            try {
                if (g.r() && b.F() && !this.b) {
                    e.G();
                    this.b = true;
                }
            } catch (Throwable th6) {
                com.uc.crashsdk.a.g.b(th6);
            }
        }
    }

    private static Context a(Context context) {
        if (context == null) {
            a.d("crashsdk", "context can not be null!");
            throw null;
        } else if (!f40586c || (context instanceof Application)) {
            return context;
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null || !(applicationContext instanceof Application)) {
                a.d("crashsdk", "Can not get Application context from given context!");
                throw new IllegalArgumentException("Can not get Application context from given context!");
            }
            return applicationContext;
        }
    }

    private static void a() {
        if (b.f40574a) {
            a.b("Has enabled java log!");
            return;
        }
        e.s();
        e.o();
        b.f40574a = true;
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        com.uc.crashsdk.d.a(iCrashClient);
        g.a(customInfo, versionInfo);
        if (b.L()) {
            return;
        }
        e.p();
        e.a(context);
        e.b(context);
    }

    private static void a(Throwable th) {
        new e().a(Thread.currentThread(), th, true);
    }

    private static boolean a(String str) {
        if (b.L()) {
            a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
            return true;
        }
        return false;
    }

    private static void b() {
        synchronized (b.e) {
            if (b.g && b.f) {
                if (b.b) {
                    a.b("Has enabled native log!");
                    return;
                }
                c();
                e.D();
                b.b = true;
                JNIBridge.cmd(6);
                g.d();
            }
        }
    }

    private static void b(Context context) {
        try {
            if (d) {
                return;
            }
            com.uc.crashsdk.a.g.a(context);
            com.uc.crashsdk.a.f40557a = context.getPackageName();
            d = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    private static void c() {
        if (b.d) {
            return;
        }
        g.b();
        JNIBridge.cmd(5);
        g.c();
        b.d = true;
    }

    public static CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            try {
                if (f40585a == null) {
                    f40585a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
                }
                crashApi = f40585a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return crashApi;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = f40585a;
        if (crashApi != null) {
            return crashApi;
        }
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        f40586c = bundle2.getBoolean("useApplicationContext", true);
        Context a2 = a(context);
        b(a2);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = false;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        bundle2.putString("crver", "2.0");
        CustomInfo a3 = g.a(customInfo, bundle2);
        VersionInfo a4 = g.a(bundle2);
        boolean z2 = bundle2.getBoolean(UMCrash.KEY_ENABLE_CRASH_JAVA, true);
        boolean z3 = bundle2.getBoolean(UMCrash.KEY_ENABLE_CRASH_NATIVE, true);
        boolean z4 = bundle2.getBoolean(UMCrash.KEY_ENABLE_CRASH_UNEXP, b.F());
        boolean z5 = bundle2.getBoolean(UMCrash.KEY_ENABLE_ANR, true);
        CrashApi createInstance = createInstance(a2, a3, a4, iCrashClient, z2, z3, z4);
        createInstance.disableLog(ParcelFileDescriptor.MODE_READ_WRITE);
        b.a(z5);
        if (z3 || z4) {
            if (e.e("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle2.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && b.F()) {
            e.b(i);
        }
        return createInstance;
    }

    public static CrashApi getInstance() {
        return f40585a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return com.uc.crashsdk.a.b(str, str2);
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        if (dumpFileInfo != null) {
            if (dumpFileInfo.mCategory == null || dumpFileInfo.mFileTobeDump == null) {
                throw null;
            }
            if ((dumpFileInfo.mLogType & 1048849) == 0) {
                return 0;
            }
            return com.uc.crashsdk.a.a(dumpFileInfo.mCategory, dumpFileInfo.mFileTobeDump, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, dumpFileInfo.mLogType, dumpFileInfo.mDeleteAfterDump);
        }
        throw null;
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public void addHeaderInfo(String str, String str2) {
        if (str == null) {
            throw null;
        }
        com.uc.crashsdk.a.a(str, str2);
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            throw null;
        }
        if (str.length() <= 24) {
            String str3 = str2;
            if (str2 != null) {
                str3 = str2;
                if (str2.length() > 512) {
                    str3 = str2.substring(0, 512);
                }
            }
            return h.a(str, str3);
        }
        throw new IllegalArgumentException("key is too long!");
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        b.f = true;
        b();
        synchronized (b.e) {
            if (b.h && b.f && !b.f40575c) {
                if (!b.d) {
                    c();
                    g.d();
                }
                e.x();
                b.f40575c = true;
            }
        }
        com.uc.crashsdk.a.n();
        e.m();
    }

    public int createCachedInfo(String str, int i, int i2) {
        if (str != null) {
            if (i > 0) {
                if ((1048849 & i2) == 0) {
                    return 0;
                }
                return com.uc.crashsdk.a.a(str, i, i2);
            }
            throw new IllegalArgumentException("capacity must > 0!");
        }
        throw null;
    }

    public void disableLog(int i) {
        synchronized (b.e) {
            b.b(i);
            if (LogType.isForJava(i) && b.f40574a) {
                e.t();
                b.f40574a = false;
            }
            if (LogType.isForNative(i)) {
                if (b.b) {
                    JNIBridge.cmd(9);
                    b.b = false;
                } else {
                    b.g = false;
                }
            }
            if (LogType.isForANR(i)) {
                b.a(false);
            }
            if (LogType.isForUnexp(i)) {
                if (!b.f40575c) {
                    b.h = false;
                } else if (e.z()) {
                    b.f40575c = false;
                }
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        StringBuilder sb;
        if (customLogInfo != null) {
            if (customLogInfo.mData == null || customLogInfo.mLogType == null) {
                throw new NullPointerException("mData or mLogType is null!");
            }
            if (customLogInfo.mLogType.contains(BridgeUtil.UNDERLINE_STR) || customLogInfo.mLogType.contains(" ")) {
                throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
            }
            if (customLogInfo.mDumpTids != null && customLogInfo.mDumpTids.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
                while (true) {
                    sb = sb2;
                    if (!it.hasNext()) {
                        break;
                    }
                    sb2.append(it.next().intValue());
                    sb2.append(" ");
                }
            } else {
                sb = null;
            }
            long j = 0;
            if (customLogInfo.mAddHeader) {
                j = 1;
            }
            long j2 = j;
            if (customLogInfo.mAddFooter) {
                j2 = j | 2;
            }
            long j3 = j2;
            if (customLogInfo.mAddLogcat) {
                j3 = j2 | 4;
            }
            long j4 = j3;
            if (customLogInfo.mAddThreadsDump) {
                j4 = j3 | 8;
            }
            long j5 = j4;
            if (customLogInfo.mAddBuildId) {
                j5 = j4 | 16;
            }
            long j6 = j5;
            if (customLogInfo.mUploadNow) {
                j6 = j5 | 32;
            }
            StringBuffer stringBuffer = customLogInfo.mData;
            String str = customLogInfo.mLogType;
            ArrayList<String> arrayList = customLogInfo.mDumpFiles;
            ArrayList<String> arrayList2 = customLogInfo.mCallbacks;
            ArrayList<String> arrayList3 = customLogInfo.mCachedInfos;
            String str2 = null;
            if (sb != null) {
                str2 = sb.toString();
            }
            return e.a(stringBuffer, str, j6, arrayList, arrayList2, arrayList3, str2);
        }
        throw null;
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    public boolean generateTraces(String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (b.d) {
            return JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return e.k();
    }

    public ParcelFileDescriptor getHostFd() {
        return e.E();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return e.E();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return b.I();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return b.J();
    }

    public Throwable getUncaughtException() {
        return e.v();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return e.w();
    }

    public void onExit() {
        b.w();
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        if (valueCallback != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return com.uc.crashsdk.d.b(valueCallback);
                        }
                        throw new IllegalArgumentException("Unknown event type: " + i);
                    }
                    return com.uc.crashsdk.d.d(valueCallback);
                }
                return com.uc.crashsdk.d.c(valueCallback);
            }
            return com.uc.crashsdk.d.a(valueCallback);
        }
        throw null;
    }

    public int registerInfoCallback(String str, int i) {
        if (str != null) {
            if ((1048849 & i) == 0) {
                return 0;
            }
            return com.uc.crashsdk.a.a(str, i, null, 0L, 0);
        }
        throw null;
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, callable, 0L, 0);
    }

    public int registerThread(int i, String str) {
        return com.uc.crashsdk.a.a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        if (g.O()) {
            a.a("CrashApi::reportCrashStats. currentProcessOnly: " + z);
        }
        e.d(z);
        return e.e(z);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        if (g.O()) {
            a.a("CrashApi::resetCrashStats. currentProcessOnly: " + z);
        }
        return e.f(z);
    }

    public void setForeground(boolean z) {
        b.b(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        b.v();
    }

    public int updateCustomInfo(Bundle bundle) {
        if (bundle != null) {
            return updateCustomInfo(g.a((CustomInfo) null, bundle));
        }
        throw null;
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        if (customInfo != null) {
            return g.b(customInfo);
        }
        throw null;
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public void updateVersionInfo(Bundle bundle) {
        if (bundle == null) {
            throw null;
        }
        updateVersionInfo(g.a(bundle));
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        if (versionInfo == null) {
            throw null;
        }
        g.a(versionInfo);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        e.a(false, true);
    }
}
