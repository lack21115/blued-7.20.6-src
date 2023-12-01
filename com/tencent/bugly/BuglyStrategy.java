package com.tencent.bugly;

import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/BuglyStrategy.class */
public class BuglyStrategy {

    /* renamed from: c  reason: collision with root package name */
    private String f35105c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;
    private a r;
    private boolean i = true;
    private boolean j = true;
    private boolean k = true;
    private boolean l = true;
    private Class<?> m = null;
    private boolean n = true;
    private boolean o = true;
    private boolean p = true;
    private boolean q = false;

    /* renamed from: a  reason: collision with root package name */
    protected int f35104a = 31;
    protected boolean b = false;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/BuglyStrategy$a.class */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            synchronized (this) {
            }
            return null;
        }

        public byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            synchronized (this) {
            }
            return null;
        }
    }

    public String getAppChannel() {
        synchronized (this) {
            if (this.d == null) {
                return com.tencent.bugly.crashreport.common.info.a.b().m;
            }
            return this.d;
        }
    }

    public String getAppPackageName() {
        synchronized (this) {
            if (this.e == null) {
                return com.tencent.bugly.crashreport.common.info.a.b().f35130c;
            }
            return this.e;
        }
    }

    public long getAppReportDelay() {
        long j;
        synchronized (this) {
            j = this.f;
        }
        return j;
    }

    public String getAppVersion() {
        synchronized (this) {
            if (this.f35105c == null) {
                return com.tencent.bugly.crashreport.common.info.a.b().k;
            }
            return this.f35105c;
        }
    }

    public int getCallBackType() {
        int i;
        synchronized (this) {
            i = this.f35104a;
        }
        return i;
    }

    public boolean getCloseErrorCallback() {
        boolean z;
        synchronized (this) {
            z = this.b;
        }
        return z;
    }

    public a getCrashHandleCallback() {
        a aVar;
        synchronized (this) {
            aVar = this.r;
        }
        return aVar;
    }

    public String getDeviceID() {
        String str;
        synchronized (this) {
            str = this.h;
        }
        return str;
    }

    public String getLibBuglySOFilePath() {
        String str;
        synchronized (this) {
            str = this.g;
        }
        return str;
    }

    public Class<?> getUserInfoActivity() {
        Class<?> cls;
        synchronized (this) {
            cls = this.m;
        }
        return cls;
    }

    public boolean isBuglyLogUpload() {
        boolean z;
        synchronized (this) {
            z = this.n;
        }
        return z;
    }

    public boolean isEnableANRCrashMonitor() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    public boolean isEnableCatchAnrTrace() {
        boolean z;
        synchronized (this) {
            z = this.k;
        }
        return z;
    }

    public boolean isEnableNativeCrashMonitor() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    public boolean isEnableUserInfo() {
        boolean z;
        synchronized (this) {
            z = this.l;
        }
        return z;
    }

    public boolean isReplaceOldChannel() {
        return this.o;
    }

    public boolean isUploadProcess() {
        boolean z;
        synchronized (this) {
            z = this.p;
        }
        return z;
    }

    public boolean recordUserInfoOnceADay() {
        boolean z;
        synchronized (this) {
            z = this.q;
        }
        return z;
    }

    public BuglyStrategy setAppChannel(String str) {
        synchronized (this) {
            this.d = str;
        }
        return this;
    }

    public BuglyStrategy setAppPackageName(String str) {
        synchronized (this) {
            this.e = str;
        }
        return this;
    }

    public BuglyStrategy setAppReportDelay(long j) {
        synchronized (this) {
            this.f = j;
        }
        return this;
    }

    public BuglyStrategy setAppVersion(String str) {
        synchronized (this) {
            this.f35105c = str;
        }
        return this;
    }

    public BuglyStrategy setBuglyLogUpload(boolean z) {
        synchronized (this) {
            this.n = z;
        }
        return this;
    }

    public void setCallBackType(int i) {
        synchronized (this) {
            this.f35104a = i;
        }
    }

    public void setCloseErrorCallback(boolean z) {
        synchronized (this) {
            this.b = z;
        }
    }

    public BuglyStrategy setCrashHandleCallback(a aVar) {
        synchronized (this) {
            this.r = aVar;
        }
        return this;
    }

    public BuglyStrategy setDeviceID(String str) {
        synchronized (this) {
            this.h = str;
        }
        return this;
    }

    public BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        synchronized (this) {
            this.j = z;
        }
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.k = z;
    }

    public BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        synchronized (this) {
            this.i = z;
        }
        return this;
    }

    public BuglyStrategy setEnableUserInfo(boolean z) {
        synchronized (this) {
            this.l = z;
        }
        return this;
    }

    public BuglyStrategy setLibBuglySOFilePath(String str) {
        synchronized (this) {
            this.g = str;
        }
        return this;
    }

    public BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        synchronized (this) {
            this.q = z;
        }
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.o = z;
    }

    public BuglyStrategy setUploadProcess(boolean z) {
        synchronized (this) {
            this.p = z;
        }
        return this;
    }

    public BuglyStrategy setUserInfoActivity(Class<?> cls) {
        synchronized (this) {
            this.m = cls;
        }
        return this;
    }
}
