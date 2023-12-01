package com.tencent.bugly.idasc.crashreport.crash.jni;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bc;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.proguard.aa;
import com.tencent.bugly.idasc.proguard.ab;
import com.tencent.bugly.idasc.proguard.ac;
import com.tencent.bugly.idasc.proguard.ak;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.ap;
import com.tencent.bugly.idasc.proguard.as;
import com.tencent.bugly.idasc.proguard.at;
import com.tencent.bugly.idasc.proguard.bd;
import com.tencent.bugly.idasc.proguard.be;
import com.tencent.bugly.idasc.proguard.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/crash/jni/NativeCrashHandler.class */
public class NativeCrashHandler implements q {

    /* renamed from: a  reason: collision with root package name */
    static String f35207a;
    private static NativeCrashHandler b;

    /* renamed from: c  reason: collision with root package name */
    private static int f35208c = 1;
    private static boolean n = true;
    private final Context d;
    private final aa e;
    private final ak f;
    private NativeExceptionHandler g;
    private final boolean h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private as m;

    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z, String str) {
        this.d = ap.a(context);
        if (ap.b(f35207a)) {
            String str2 = str;
            try {
                if (ap.b(str)) {
                    str2 = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable th) {
                str2 = "/data/data/" + aa.a(context).f35213c + "/app_bugly";
            }
            f35207a = str2;
        }
        this.m = asVar;
        this.e = aaVar;
        this.f = akVar;
        this.h = z;
        this.g = new bd(context, aaVar, asVar, ac.a());
    }

    private void a(boolean z) {
        synchronized (this) {
            if (this.k) {
                al.d("[Native] Native crash report has already registered.", new Object[0]);
                return;
            }
            if (this.j) {
                String regist = regist(f35207a, z, f35208c);
                if (regist != null) {
                    al.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.e.u = regist;
                    String concat = "-".concat(this.e.u);
                    if (!at.b && !this.e.h.contains(concat)) {
                        this.e.h = this.e.h.concat("-").concat(this.e.u);
                    }
                    al.a("comInfo.sdkVersion %s", this.e.h);
                    this.k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.e.e(runningCpuAbi);
                    }
                    return;
                }
            } else if (this.i) {
                try {
                    String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE}, new Object[]{f35207a, ab.d(), Integer.valueOf(z ? 1 : 5), 1});
                    String str2 = str;
                    if (str == null) {
                        Class<Integer> cls = Integer.TYPE;
                        String str3 = f35207a;
                        String d = ab.d();
                        aa.b();
                        str2 = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{str3, d, Integer.valueOf(aa.B())});
                    }
                    if (str2 != null) {
                        this.k = true;
                        this.e.u = str2;
                        ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                        int i = 5;
                        if (z) {
                            i = 1;
                        }
                        ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                        String runningCpuAbi2 = getRunningCpuAbi();
                        if (!TextUtils.isEmpty(runningCpuAbi2)) {
                            this.e.e(runningCpuAbi2);
                        }
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            this.j = false;
            this.i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str) {
        if (this.j) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError e) {
                return false;
            } catch (Throwable th) {
                if (al.a(th)) {
                    return false;
                }
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    private void b(boolean z) {
        synchronized (this) {
            if (z) {
                startNativeMonitor();
            } else {
                c();
            }
        }
    }

    private void c() {
        synchronized (this) {
            if (!this.k) {
                al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            } else if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.k = false;
            } else {
                ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
                this.k = false;
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
            }
        }
    }

    private void c(boolean z) {
        synchronized (this) {
            if (this.l != z) {
                al.a("user change native %b", Boolean.valueOf(z));
                this.l = z;
            }
        }
    }

    public static String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            try {
                str = f35207a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                nativeCrashHandler = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    public static NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (b == null) {
                    b = new NativeCrashHandler(context, aaVar, asVar, akVar, z, str);
                }
                nativeCrashHandler = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return n;
    }

    public static void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            try {
                f35207a = str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setShouldHandleInJava(boolean z) {
        n = z;
        NativeCrashHandler nativeCrashHandler = b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z));
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((!this.i && !this.j) || str == null || str2 == null || str3 == null) {
            return false;
        }
        try {
            if (this.j) {
                return appendNativeLog(str, str2, str3);
            }
            Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError e) {
            return false;
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f.a(new Runnable() { // from class: com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                int i2;
                if (!ap.a(NativeCrashHandler.this.d, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.n) {
                    NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a2 = be.a(NativeCrashHandler.this.d, NativeCrashHandler.f35207a, NativeCrashHandler.this.g);
                if (a2 != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.m.a(a2, true)) {
                        NativeCrashHandler.this.m.b(a2, false);
                    }
                    be.a(false, NativeCrashHandler.f35207a);
                }
                final NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                long b2 = ap.b();
                long j = at.j;
                long b3 = ap.b();
                File file = new File(NativeCrashHandler.f35207a);
                if (file.exists() && file.isDirectory()) {
                    try {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler.2
                                @Override // java.util.Comparator
                                public final /* synthetic */ int compare(File file2, File file3) {
                                    return Long.compare(file3.lastModified(), file2.lastModified());
                                }
                            });
                            long j2 = 0;
                            int length = listFiles.length;
                            int i3 = 0;
                            int i4 = 0;
                            int i5 = 0;
                            while (true) {
                                i = i5;
                                if (i3 >= length) {
                                    break;
                                }
                                File file2 = listFiles[i3];
                                long lastModified = file2.lastModified();
                                j2 += file2.length();
                                if (lastModified >= b2 - j && lastModified < b3 + 86400000 && j2 < at.i) {
                                    i2 = i;
                                    i3++;
                                    i5 = i2;
                                }
                                al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                int i6 = i4 + 1;
                                i4 = i6;
                                i2 = i;
                                if (file2.delete()) {
                                    i2 = i + 1;
                                    i4 = i6;
                                }
                                i3++;
                                i5 = i2;
                            }
                            al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i4), Integer.valueOf(i));
                        }
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
                ap.b(NativeCrashHandler.this.d, "native_record_lock");
            }
        });
    }

    public void disableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            f35208c = 1;
        }
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            f35208c |= 2;
        }
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.idasc.proguard.q
    public String getLogFromNative() {
        if (this.i || this.j) {
            try {
                return this.j ? getNativeLog() : (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
            } catch (UnsatisfiedLinkError e) {
                return null;
            } catch (Throwable th) {
                if (al.a(th)) {
                    return null;
                }
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.g;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable th) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        return (this.j || this.i) ? getProperties(str) : bc.b.S;
    }

    public boolean isEnableCatchAnrTrace() {
        return (f35208c & 2) == 2;
    }

    public boolean isUserOpened() {
        boolean z;
        synchronized (this) {
            z = this.l;
        }
        return z;
    }

    public void onStrategyChanged(StrategyBean strategyBean) {
        synchronized (this) {
            if (strategyBean != null) {
                if (strategyBean.f != this.k) {
                    al.d("server native changed to %b", Boolean.valueOf(strategyBean.f));
                }
            }
            boolean z = ac.a().c().f && this.l;
            if (z != this.k) {
                al.a("native changed to %b", Boolean.valueOf(z));
                b(z);
            }
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((!this.i && !this.j) || str == null || str2 == null) {
            return false;
        }
        try {
            if (this.j) {
                return putNativeKeyValue(str, str2);
            }
            Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError e) {
            return false;
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    public void removeEmptyNativeRecordFiles() {
        be.c(f35207a);
    }

    protected native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    protected native void setNativeInfo(int i, String str);

    @Override // com.tencent.bugly.idasc.proguard.q
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (al.a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public void setUserOpened(boolean z) {
        synchronized (this) {
            c(z);
            boolean isUserOpened = isUserOpened();
            ac a2 = ac.a();
            boolean z2 = isUserOpened;
            if (a2 != null) {
                z2 = isUserOpened && a2.c().f;
            }
            if (z2 != this.k) {
                al.a("native changed to %b", Boolean.valueOf(z2));
                b(z2);
            }
        }
    }

    public void startNativeMonitor() {
        synchronized (this) {
            if (!this.j && !this.i) {
                boolean z = !ap.b(this.e.t);
                if (at.b) {
                    boolean a2 = a(z ? this.e.t : "Bugly_Native_idasc", z);
                    this.j = a2;
                    if (!a2 && !z) {
                        this.i = a("NativeRQD", false);
                    }
                } else {
                    String str = "Bugly_Native_idasc";
                    String str2 = this.e.t;
                    if (z) {
                        str = str2;
                    } else {
                        this.e.getClass();
                    }
                    this.j = a(str, z);
                }
                if (this.j || this.i) {
                    a(this.h);
                    setNativeAppVersion(this.e.o);
                    setNativeAppChannel(this.e.s);
                    setNativeAppPackage(this.e.f35213c);
                    setNativeUserId(this.e.f());
                    setNativeIsAppForeground(this.e.a());
                    setNativeLaunchTime(this.e.f35211a);
                    return;
                }
                return;
            }
            a(this.h);
        }
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.j) {
            testCrash();
        } else {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, String.valueOf(z));
        a(17, String.valueOf(z2));
        a(18, String.valueOf(z3));
        testNativeCrash();
    }

    public void unBlockSigquit(boolean z) {
        a(21, z ? "true" : "false");
    }

    protected native String unregist();
}
