package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.os.Build;
import com.anythink.expressad.video.module.a.a.m;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.class */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {
    public static int JNI_CALL_TYPE = 1;

    /* renamed from: a  reason: collision with root package name */
    private static NativeCrashHandler f35179a;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean o = true;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f35180c;
    private final w d;
    private NativeExceptionHandler e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private com.tencent.bugly.crashreport.crash.b n;

    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z, String str) {
        this.b = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable th) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f35130c + "/app_bugly";
        }
        this.n = bVar;
        this.f = str;
        this.f35180c = aVar;
        this.d = wVar;
        this.g = z;
        this.e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:14|(2:16|17)(20:45|46|(2:48|49)|19|20|(1:22)|23|24|(1:26)|27|(1:29)(1:42)|30|(1:32)(1:41)|33|34|(1:36)|37|38|39|40)|18|19|20|(0)|23|24|(0)|27|(0)(0)|30|(0)(0)|33|34|(0)|37|38|39|40) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0 A[Catch: all -> 0x02f6, TryCatch #1 {all -> 0x02f6, blocks: (B:23:0x00c3, B:25:0x00d0, B:27:0x00d6, B:29:0x00e1, B:30:0x00e5), top: B:85:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1 A[Catch: all -> 0x02f6, TryCatch #1 {all -> 0x02f6, blocks: (B:23:0x00c3, B:25:0x00d0, B:27:0x00d6, B:29:0x00e1, B:30:0x00e5), top: B:85:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb A[Catch: all -> 0x02f1, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x0009, B:9:0x0016, B:70:0x02dd, B:47:0x018b, B:11:0x0021, B:13:0x0034, B:15:0x0077, B:17:0x008c, B:30:0x00e5, B:32:0x00eb, B:34:0x0102, B:36:0x0108, B:39:0x0120, B:41:0x0145, B:43:0x0164, B:37:0x0115, B:33:0x00f8, B:19:0x00a2, B:21:0x00ab), top: B:87:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f8 A[Catch: all -> 0x02f1, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x0009, B:9:0x0016, B:70:0x02dd, B:47:0x018b, B:11:0x0021, B:13:0x0034, B:15:0x0077, B:17:0x008c, B:30:0x00e5, B:32:0x00eb, B:34:0x0102, B:36:0x0108, B:39:0x0120, B:41:0x0145, B:43:0x0164, B:37:0x0115, B:33:0x00f8, B:19:0x00a2, B:21:0x00ab), top: B:87:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108 A[Catch: all -> 0x02f1, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x0009, B:9:0x0016, B:70:0x02dd, B:47:0x018b, B:11:0x0021, B:13:0x0034, B:15:0x0077, B:17:0x008c, B:30:0x00e5, B:32:0x00eb, B:34:0x0102, B:36:0x0108, B:39:0x0120, B:41:0x0145, B:43:0x0164, B:37:0x0115, B:33:0x00f8, B:19:0x00a2, B:21:0x00ab), top: B:87:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0115 A[Catch: all -> 0x02f1, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x0009, B:9:0x0016, B:70:0x02dd, B:47:0x018b, B:11:0x0021, B:13:0x0034, B:15:0x0077, B:17:0x008c, B:30:0x00e5, B:32:0x00eb, B:34:0x0102, B:36:0x0108, B:39:0x0120, B:41:0x0145, B:43:0x0164, B:37:0x0115, B:33:0x00f8, B:19:0x00a2, B:21:0x00ab), top: B:87:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0145 A[Catch: all -> 0x02f1, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x0009, B:9:0x0016, B:70:0x02dd, B:47:0x018b, B:11:0x0021, B:13:0x0034, B:15:0x0077, B:17:0x008c, B:30:0x00e5, B:32:0x00eb, B:34:0x0102, B:36:0x0108, B:39:0x0120, B:41:0x0145, B:43:0x0164, B:37:0x0115, B:33:0x00f8, B:19:0x00a2, B:21:0x00ab), top: B:87:0x0002 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x02f6 -> B:30:0x00e5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r10) {
        /*
            Method dump skipped, instructions count: 773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str) {
        if (this.i && m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError e) {
                m = false;
                return false;
            } catch (Throwable th) {
                if (x.a(th)) {
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
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                x.d(th.getMessage(), new Object[0]);
                x.d("[Native] Failed to load so: %s", str);
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
            if (!this.j) {
                x.d("[Native] Native crash report has already unregistered.", new Object[0]);
            } else if (unregist() != null) {
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.j = false;
            } else {
                z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
                this.j = false;
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
            }
        }
    }

    private void c(boolean z) {
        synchronized (this) {
            if (this.k != z) {
                x.a("user change native %b", Boolean.valueOf(z));
                this.k = z;
            }
        }
    }

    public static NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                nativeCrashHandler = f35179a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    public static NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (f35179a == null) {
                    f35179a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
                }
                nativeCrashHandler = f35179a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return o;
    }

    public static void setShouldHandleInJava(boolean z) {
        o = z;
        NativeCrashHandler nativeCrashHandler = f35179a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    protected final void a() {
        int i;
        int i2;
        long b = z.b();
        long j = c.g;
        long b2 = z.b();
        File file = new File(this.f);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            int length = listFiles.length;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i3 >= length) {
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i4), Integer.valueOf(i6));
                    return;
                }
                File file2 = listFiles[i3];
                long lastModified = file2.lastModified();
                if (lastModified >= b - j) {
                    i = i4;
                    i2 = i6;
                    if (lastModified < b2 + 86400000) {
                        i3++;
                        i4 = i;
                        i5 = i2;
                    }
                }
                x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                int i7 = i4 + 1;
                i = i7;
                i2 = i6;
                if (file2.delete()) {
                    i2 = i6 + 1;
                    i = i7;
                }
                i3++;
                i4 = i;
                i5 = i2;
            }
        } catch (Throwable th) {
            x.a(th);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((!this.h && !this.i) || !l || str == null || str2 == null || str3 == null) {
            return false;
        }
        try {
            if (this.i) {
                return appendNativeLog(str, str2, str3);
            }
            Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError e) {
            l = false;
            return false;
        } catch (Throwable th) {
            if (x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.d.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!z.a(NativeCrashHandler.this.b, "native_record_lock", 10000L)) {
                    x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.o) {
                    NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a2 = b.a(NativeCrashHandler.this.b, NativeCrashHandler.this.f, NativeCrashHandler.this.e);
                if (a2 != null) {
                    x.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.n.a(a2)) {
                        NativeCrashHandler.this.n.a(a2, m.ag, false);
                    }
                    b.a(false, NativeCrashHandler.this.f);
                }
                NativeCrashHandler.this.a();
                z.b(NativeCrashHandler.this.b, "native_record_lock");
            }
        });
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 29 || Build.VERSION.SDK_INT < 26 || !com.tencent.bugly.crashreport.common.info.b.c(this.b).contains("Oppo")) {
            return;
        }
        JNI_CALL_TYPE |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public String getDumpFilePath() {
        String str;
        synchronized (this) {
            str = this.f;
        }
        return str;
    }

    public String getLogFromNative() {
        if ((this.h || this.i) && l) {
            try {
                return this.i ? getNativeLog() : (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
            } catch (UnsatisfiedLinkError e) {
                l = false;
                return null;
            } catch (Throwable th) {
                if (x.a(th)) {
                    return null;
                }
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (JNI_CALL_TYPE & 2) == 2;
    }

    public boolean isUserOpened() {
        boolean z;
        synchronized (this) {
            z = this.k;
        }
        return z;
    }

    public void onStrategyChanged(StrategyBean strategyBean) {
        synchronized (this) {
            if (strategyBean != null) {
                if (strategyBean.e != this.j) {
                    x.d("server native changed to %b", Boolean.valueOf(strategyBean.e));
                }
            }
            boolean z = com.tencent.bugly.crashreport.common.strategy.a.a().c().e && this.k;
            if (z != this.j) {
                x.a("native changed to %b", Boolean.valueOf(z));
                b(z);
            }
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.h || this.i) && l && str != null && str2 != null) {
            try {
                if (this.i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError e) {
                l = false;
                return false;
            } catch (Throwable th) {
                if (x.a(th)) {
                    return false;
                }
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f);
    }

    protected native String removeNativeKeyValue(String str);

    public void setDumpFilePath(String str) {
        synchronized (this) {
            this.f = str;
        }
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

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (x.a(e)) {
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
            com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
            boolean z2 = isUserOpened;
            if (a2 != null) {
                z2 = isUserOpened && a2.c().e;
            }
            if (z2 != this.j) {
                x.a("native changed to %b", Boolean.valueOf(z2));
                b(z2);
            }
        }
    }

    public void startNativeMonitor() {
        synchronized (this) {
            if (!this.i && !this.h) {
                String str = "Bugly";
                boolean z = !z.a(this.f35180c.n);
                String str2 = this.f35180c.n;
                if (z) {
                    str = str2;
                } else {
                    this.f35180c.getClass();
                }
                boolean a2 = a(str, z);
                this.i = a2;
                if (a2 || this.h) {
                    a(this.g);
                    if (l) {
                        setNativeAppVersion(this.f35180c.k);
                        setNativeAppChannel(this.f35180c.m);
                        setNativeAppPackage(this.f35180c.f35130c);
                        setNativeUserId(this.f35180c.g());
                        setNativeIsAppForeground(this.f35180c.a());
                        setNativeLaunchTime(this.f35180c.f35129a);
                    }
                    return;
                }
                return;
            }
            a(this.g);
        }
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.i) {
            testCrash();
        } else {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    protected native String unregist();
}
