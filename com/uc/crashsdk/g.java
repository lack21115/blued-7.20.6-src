package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/g.class */
public class g {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f26899c = !g.class.desiredAssertionStatus();
    private static CustomInfo d = null;
    private static VersionInfo e = null;

    /* renamed from: a  reason: collision with root package name */
    public static RuntimeException f26898a = null;
    public static RuntimeException b = null;
    private static final Object f = new Object();
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static String j = null;
    private static final Object k = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A() {
        return d.mLogMaxBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B() {
        return d.mLogMaxUploadBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long C() {
        return d.mMaxUploadBytesPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D() {
        return d.mMaxUploadBuiltinLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E() {
        return d.mMaxUploadCustomLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F() {
        return d.mMaxCustomLogCountPerTypePerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G() {
        return d.mInfoUpdateInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H() {
        return d.mInfoSaveFrequency;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I() {
        return d.mReservedJavaFileHandleCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J() {
        return d.mFdDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int K() {
        return d.mThreadsDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean L() {
        return d.mAutoDetectLifeCycle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean M() {
        return d.mMonitorBattery;
    }

    static int N() {
        return d.mAnrTraceStrategy;
    }

    public static boolean O() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mDebug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean P() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean Q() {
        return d.mEnableStatReport;
    }

    public static boolean R() {
        return d.mIsInternational;
    }

    public static boolean S() {
        return d.mAddPvForNewDay;
    }

    public static String T() {
        return com.uc.crashsdk.a.g.a(e.mVersion) ? a.a() : a(e.mVersion);
    }

    public static String U() {
        return com.uc.crashsdk.a.g.a(e.mSubVersion) ? "release" : e.mSubVersion;
    }

    public static String V() {
        return com.uc.crashsdk.a.g.a(e.mBuildId) ? ad() : a(e.mBuildId);
    }

    public static String W() {
        if (h == null) {
            h = com.uc.crashsdk.a.g.b() + File.separatorChar + d.mTagFilesFolderName + File.separatorChar;
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String X() {
        if (i == null) {
            i = com.uc.crashsdk.a.g.b() + File.separatorChar + d.mCrashLogsFolderName + File.separatorChar;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Y() {
        if (j == null) {
            if (com.uc.crashsdk.a.g.a(d.mLogsBackupPathName)) {
                j = (com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar) + File.separatorChar + d.mCrashLogsFolderName + File.separatorChar;
            } else {
                String trim = d.mLogsBackupPathName.trim();
                String str = trim;
                if (!trim.endsWith(File.separator)) {
                    str = trim + File.separator;
                }
                j = str;
            }
        }
        return j;
    }

    public static boolean Z() {
        return d.mEnableCrpStat;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        CustomInfo customInfo2 = customInfo;
        if (customInfo == null) {
            CustomInfo customInfo3 = d;
            customInfo2 = customInfo3 == null ? new CustomInfo() : new CustomInfo(customInfo3);
        }
        Field[] fields = customInfo2.getClass().getFields();
        for (String str : bundle.keySet()) {
            int length = fields.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < length) {
                    Field field = fields[i3];
                    if (field.getName().equals(str)) {
                        Object obj = bundle.get(str);
                        try {
                            field.set(customInfo2, obj);
                        } catch (Exception e2) {
                            com.uc.crashsdk.a.g.a(e2);
                            StringBuilder sb = new StringBuilder("Field ");
                            sb.append(str);
                            sb.append(" must be a ");
                            sb.append(field.getType().getName());
                            sb.append(", but give a ");
                            sb.append(obj != null ? obj.getClass().getName() : "(null)");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    i2 = i3 + 1;
                }
            }
        }
        return customInfo2;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo = e;
        VersionInfo versionInfo2 = versionInfo == null ? new VersionInfo() : new VersionInfo(versionInfo);
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo2.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo2.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo2.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.b = string4;
            ae();
        }
        return versionInfo2;
    }

    private static String a(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.contains("_")) {
                str2 = str.replaceAll("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        b.y();
        b.x();
        if (d.mBackupLogs) {
            File file = new File(Y());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void a(CustomInfo customInfo) {
        if (!f26899c && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!f26899c && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        d = customInfo2;
        c(customInfo2);
        if (!d.mZipLog) {
            f26898a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (d.mEncryptLog) {
            b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        e = new VersionInfo(versionInfo);
        if (b.L()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f) {
            e = new VersionInfo(versionInfo);
            e.c();
            if (b.d) {
                JNIBridge.set(109, T());
                JNIBridge.set(110, U());
                JNIBridge.set(111, V());
                JNIBridge.set(112, "211215141717");
                JNIBridge.cmd(2);
            }
        }
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean aa() {
        return d.mEnableStatToWPKDirect;
    }

    public static String ab() {
        return d.mUserId;
    }

    public static String ac() {
        return d.mChannel;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0071 -> B:18:0x0062). Please submit an issue!!! */
    private static String ad() {
        ZipFile zipFile;
        String str = g;
        if (str != null) {
            return str;
        }
        try {
            zipFile = new ZipFile(com.uc.crashsdk.a.g.c());
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            g = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
            com.uc.crashsdk.a.a.a("crashsdk", "version unique build id: " + g);
            zipFile.close();
        } catch (Throwable th2) {
            th = th2;
            try {
                g = "";
                com.uc.crashsdk.a.g.a(th);
                if (zipFile != null) {
                    zipFile.close();
                }
                return g;
            } catch (Throwable th3) {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th3;
            }
        }
        return g;
    }

    private static void ae() {
        if (b.d) {
            JNIBridge.nativeSet(24, 1L, a.b, null);
        }
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        synchronized (k) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (d == null) {
                    d = new CustomInfo();
                }
                CustomInfo customInfo2 = d;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                    z = false;
                } else {
                    customInfo2.mAppId = customInfo.mAppId;
                    if (b.d) {
                        JNIBridge.set(102, customInfo2.mAppId);
                    }
                    i3 = 1;
                    z = true;
                }
                int i5 = i3;
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i5 = i3 + 1;
                }
                int i6 = i5;
                boolean z3 = z;
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    customInfo2.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
                    if (b.d) {
                        JNIBridge.set(100, customInfo2.mNativeCrashLogFileName);
                    }
                    i6 = i5 + 1;
                    z3 = true;
                }
                int i7 = i6;
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    customInfo2.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
                    if (b.d) {
                        JNIBridge.set(101, customInfo2.mUnexpCrashLogFileName);
                    }
                    i7 = i6 + 1;
                    z3 = true;
                }
                if (z3) {
                    e.c();
                    if (b.d) {
                        JNIBridge.cmd(2);
                    }
                }
                int i8 = i7;
                if (customInfo2.mPrintStackInfos != customInfo.mPrintStackInfos) {
                    customInfo2.mPrintStackInfos = customInfo.mPrintStackInfos;
                    if (b.d) {
                        JNIBridge.set(11, customInfo2.mPrintStackInfos);
                    }
                    i8 = i7 + 1;
                }
                int i9 = i8;
                if (customInfo2.mDebug != customInfo.mDebug) {
                    customInfo2.mDebug = customInfo.mDebug;
                    if (b.d) {
                        JNIBridge.set(18, customInfo2.mDebug);
                    }
                    i9 = i8 + 1;
                }
                int i10 = i9;
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    customInfo2.mBackupLogs = customInfo.mBackupLogs;
                    if (b.d) {
                        JNIBridge.set(12, customInfo2.mBackupLogs);
                    }
                    i10 = i9 + 1;
                }
                int i11 = i10;
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    customInfo2.mOmitNativeCrash = customInfo.mOmitNativeCrash;
                    if (b.d) {
                        JNIBridge.set(21, customInfo2.mOmitNativeCrash);
                    }
                    i11 = i10 + 1;
                }
                int i12 = i11;
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    customInfo2.mCrashRestartInterval = customInfo.mCrashRestartInterval;
                    if (b.d) {
                        JNIBridge.set(13, customInfo2.mCrashRestartInterval);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.M();
                    }
                    i12 = i11 + 1;
                }
                int i13 = i12;
                if (customInfo2.mMaxBuiltinLogFilesCount != customInfo.mMaxBuiltinLogFilesCount) {
                    customInfo2.mMaxBuiltinLogFilesCount = customInfo.mMaxBuiltinLogFilesCount;
                    if (b.d) {
                        JNIBridge.set(14, customInfo2.mMaxBuiltinLogFilesCount);
                    }
                    i13 = i12 + 1;
                }
                int i14 = i13;
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    customInfo2.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
                    if (b.d) {
                        JNIBridge.set(15, customInfo2.mMaxNativeLogcatLineCount);
                    }
                    i14 = i13 + 1;
                }
                int i15 = i14;
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i15 = i14 + 1;
                }
                int i16 = i15;
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    customInfo2.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
                    if (b.d) {
                        JNIBridge.set(16, customInfo2.mMaxUnexpLogcatLineCount);
                    }
                    i16 = i15 + 1;
                }
                int i17 = i16;
                if (customInfo2.mMaxAnrLogcatLineCount != customInfo.mMaxAnrLogcatLineCount) {
                    customInfo2.mMaxAnrLogcatLineCount = customInfo.mMaxAnrLogcatLineCount;
                    if (b.d) {
                        JNIBridge.set(31, customInfo2.mMaxAnrLogcatLineCount);
                    }
                    i17 = i16 + 1;
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    customInfo2.mZipLog = customInfo.mZipLog;
                    if (!customInfo2.mZipLog) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        f26898a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i4 = i17 + 1;
                    z2 = true;
                } else {
                    i4 = i17;
                    z2 = false;
                }
                if (!a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i4++;
                    z2 = true;
                }
                if (z2 && b.d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i18 = i4;
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    customInfo2.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
                    if (b.d) {
                        JNIBridge.set(4, customInfo2.mLogMaxBytesLimit);
                    }
                    i18 = i4 + 1;
                }
                int i19 = i18;
                if (customInfo2.mEncryptLog != customInfo.mEncryptLog) {
                    customInfo2.mEncryptLog = customInfo.mEncryptLog;
                    if (customInfo2.mEncryptLog) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i19 = i18 + 1;
                }
                int i20 = i19;
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i20 = i19 + 1;
                }
                int i21 = i20;
                if (customInfo2.mSyncUploadLogs != customInfo.mSyncUploadLogs) {
                    customInfo2.mSyncUploadLogs = customInfo.mSyncUploadLogs;
                    i21 = i20 + 1;
                }
                int i22 = i21;
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i22 = i21 + 1;
                }
                int i23 = i22;
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i23 = i22 + 1;
                }
                int i24 = i23;
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i24 = i23 + 1;
                }
                int i25 = i24;
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i25 = i24 + 1;
                }
                int i26 = i25;
                if (customInfo2.mMaxUploadBuiltinLogCountPerDay != customInfo.mMaxUploadBuiltinLogCountPerDay) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = customInfo.mMaxUploadBuiltinLogCountPerDay;
                    i26 = i25 + 1;
                }
                int i27 = i26;
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i27 = i26 + 1;
                }
                int i28 = i27;
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i28 = i27 + 1;
                }
                int i29 = i28;
                if (customInfo2.mMaxAnrLogCountPerProcess != customInfo.mMaxAnrLogCountPerProcess) {
                    customInfo2.mMaxAnrLogCountPerProcess = customInfo.mMaxAnrLogCountPerProcess;
                    if (b.d) {
                        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
                    }
                    i29 = i28 + 1;
                }
                int i30 = i29;
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i30 = i29 + 1;
                }
                int i31 = i30;
                if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    int i32 = i30 + 1;
                    i31 = i32;
                    if (b.d) {
                        JNIBridge.set(5, d.mCallNativeDefaultHandler);
                        i31 = i32;
                    }
                }
                int i33 = i31;
                if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    int i34 = i31 + 1;
                    i33 = i34;
                    if (b.d) {
                        JNIBridge.set(6, d.mDumpUserSolibBuildId);
                        i33 = i34;
                    }
                }
                int i35 = i33;
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i35 = i33 + 1;
                }
                int i36 = i35;
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i36 = i35 + 1;
                }
                int i37 = i36;
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i37 = i36 + 1;
                }
                int i38 = i37;
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    customInfo2.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
                    if (b.d) {
                        JNIBridge.set(10, customInfo2.mFdDumpMinLimit);
                    }
                    i38 = i37 + 1;
                }
                int i39 = i38;
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    customInfo2.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
                    if (b.d) {
                        JNIBridge.set(22, customInfo2.mThreadsDumpMinLimit);
                    }
                    i39 = i38 + 1;
                }
                int i40 = i39;
                if (customInfo2.mInfoUpdateInterval != customInfo.mInfoUpdateInterval) {
                    if (customInfo2.mInfoUpdateInterval <= 0 && customInfo.mInfoUpdateInterval > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i40 = i39 + 1;
                }
                int i41 = i40;
                if (customInfo2.mInfoSaveFrequency != customInfo.mInfoSaveFrequency) {
                    customInfo2.mInfoSaveFrequency = customInfo.mInfoSaveFrequency;
                    i41 = i40 + 1;
                }
                int i42 = i41;
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    customInfo2.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
                    if (b.d) {
                        JNIBridge.set(9, customInfo2.mDisableBackgroundSignals);
                    }
                    i42 = i41 + 1;
                }
                int i43 = i42;
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    customInfo2.mEnableStatReport = customInfo.mEnableStatReport;
                    if (customInfo2.mEnableStatReport) {
                        e.B();
                    }
                    i43 = i42 + 1;
                }
                int i44 = i43;
                if (customInfo2.mEnableCrpStat != customInfo.mEnableCrpStat) {
                    customInfo2.mEnableCrpStat = customInfo.mEnableCrpStat;
                    i44 = i43 + 1;
                }
                int i45 = i44;
                if (customInfo2.mEnableStatToWPKDirect != customInfo.mEnableStatToWPKDirect) {
                    customInfo2.mEnableStatToWPKDirect = customInfo.mEnableStatToWPKDirect;
                    i45 = i44 + 1;
                }
                int i46 = i45;
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    customInfo2.mIsInternational = customInfo.mIsInternational;
                    if (b.d) {
                        JNIBridge.set(23, customInfo2.mIsInternational);
                    }
                    e.l();
                    com.uc.crashsdk.a.d.c();
                    h.k();
                    i46 = i45 + 1;
                }
                int i47 = i46;
                if (customInfo2.mAutoDetectLifeCycle != customInfo.mAutoDetectLifeCycle) {
                    customInfo2.mAutoDetectLifeCycle = customInfo.mAutoDetectLifeCycle;
                    if (customInfo2.mAutoDetectLifeCycle) {
                        b.C();
                    }
                    i47 = i46 + 1;
                }
                int i48 = i47;
                if (customInfo2.mMonitorBattery != customInfo.mMonitorBattery) {
                    customInfo2.mMonitorBattery = customInfo.mMonitorBattery;
                    e.c(b.B());
                    i48 = i47 + 1;
                }
                int i49 = i48;
                if (customInfo2.mUnexpSubTypes != customInfo.mUnexpSubTypes) {
                    customInfo2.mUnexpSubTypes = customInfo.mUnexpSubTypes;
                    i49 = i48 + 1;
                }
                int i50 = i49;
                if (customInfo2.mEnableMemoryGroup != customInfo.mEnableMemoryGroup) {
                    customInfo2.mEnableMemoryGroup = customInfo.mEnableMemoryGroup;
                    if (b.d) {
                        JNIBridge.set(35, customInfo2.mEnableMemoryGroup);
                    }
                    i50 = i49 + 1;
                }
                int i51 = i50;
                if (customInfo2.mEnableLibcMallocDetail != customInfo.mEnableLibcMallocDetail) {
                    customInfo2.mEnableLibcMallocDetail = customInfo.mEnableLibcMallocDetail;
                    if (b.d) {
                        JNIBridge.set(36, customInfo2.mEnableLibcMallocDetail);
                    }
                    i51 = i50 + 1;
                }
                int i52 = i51;
                if (customInfo2.mLibcMallocDetailConfig != customInfo.mLibcMallocDetailConfig) {
                    customInfo2.mLibcMallocDetailConfig = customInfo.mLibcMallocDetailConfig;
                    if (b.d) {
                        JNIBridge.set(131, customInfo2.mLibcMallocDetailConfig);
                    }
                    i52 = i51 + 1;
                }
                int i53 = i52;
                if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i53 = i52 + 1;
                }
                int i54 = i53;
                if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i54 = i53 + 1;
                }
                int i55 = i54;
                if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                    customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                    i55 = i54 + 1;
                }
                int i56 = i55;
                if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                    customInfo2.mCrashRateUploadUrl = customInfo.mCrashRateUploadUrl;
                    int i57 = i55 + 1;
                    i56 = i57;
                    if (b.d) {
                        JNIBridge.set(38, customInfo2.mCrashRateUploadUrl);
                        i56 = i57;
                    }
                }
                int i58 = i56;
                if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                    customInfo2.mCrashSDKAuthUrl = customInfo.mCrashSDKAuthUrl;
                    int i59 = i56 + 1;
                    i58 = i59;
                    if (b.d) {
                        JNIBridge.set(39, customInfo2.mCrashSDKAuthUrl);
                        i58 = i59;
                    }
                }
                i2 = i58;
            }
        }
        return i2;
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, d.mTagFilesFolderName);
        JNIBridge.set(105, d.mCrashLogsFolderName);
        JNIBridge.set(106, Y());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, T());
        JNIBridge.set(110, U());
        JNIBridge.set(111, V());
        JNIBridge.set(112, "211215141717");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.q());
        JNIBridge.set(5, d.mCallNativeDefaultHandler);
        JNIBridge.set(6, d.mDumpUserSolibBuildId);
        JNIBridge.set(7, d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, d.mNativeCrashLogFileName);
        JNIBridge.set(101, d.mUnexpCrashLogFileName);
        JNIBridge.set(35, d.mEnableMemoryGroup);
        JNIBridge.set(36, d.mEnableLibcMallocDetail);
        JNIBridge.set(131, d.mLibcMallocDetailConfig);
        JNIBridge.set(102, d.mAppId);
        JNIBridge.set(38, d.mCrashRateUploadUrl);
        JNIBridge.set(39, d.mCrashSDKAuthUrl);
    }

    public static void c() {
        JNIBridge.set(11, P());
        JNIBridge.set(12, d.mBackupLogs);
        JNIBridge.set(13, d.mCrashRestartInterval);
        JNIBridge.set(14, d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, O());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, d.mOmitNativeCrash);
        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, d.mDisableSignals);
        JNIBridge.set(9, d.mDisableBackgroundSignals);
        JNIBridge.nativeSet(3, d.mZipLog ? 1L : 0L, d.mZippedLogExtension, null);
        JNIBridge.set(4, d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(".tmp")) {
            throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long b2 = e.b();
        if (b2 >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = STMobileHumanActionNative.ST_MOBILE_BODY_CONTOUR;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (b2 >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (b2 >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        JNIBridge.set(23, d.mIsInternational);
        if (b.H()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.B());
        JNIBridge.set(2, b.F());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.f26866a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        ae();
        b.K();
        b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return d.mAppId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(d.mUnexpCrashLogFileName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return d.mJavaCrashLogFileName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h() {
        return d.mCrashRestartInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return d.mCallJavaDefaultHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return d.mDumpHprofDataForJavaOOM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        return d.mRenameFileToDefaultName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l() {
        return d.mMaxBuiltinLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m() {
        return d.mMaxCustomLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n() {
        return d.mMaxJavaLogcatLineCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o() {
        return d.mUnexpDelayMillSeconds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p() {
        return d.mUnexpSubTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        return d.mBackupLogs;
    }

    public static boolean r() {
        return d.mSyncUploadSetupCrashLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        return d.mSyncUploadLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        return d.mOmitJavaCrash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return d.mAutoDeleteOldVersionStats;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v() {
        return d.mZipLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String w() {
        return d.mZippedLogExtension;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return d.mEncryptLog;
    }

    public static String y() {
        return d.mCrashLogUploadUrl;
    }

    public static String z() {
        return d.mCrashRateUploadUrl;
    }
}
