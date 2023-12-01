package com.uc.crashsdk.export;

import com.kuaishou.weapon.p0.d;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/export/CustomInfo.class */
public class CustomInfo {
    public boolean mAddPvForNewDay;
    public int mAnrTraceStrategy;
    public String mAppId;
    public boolean mAutoDeleteOldVersionStats;
    public boolean mAutoDetectLifeCycle;
    public boolean mBackupLogs;
    public boolean mCallJavaDefaultHandler;
    public boolean mCallNativeDefaultHandler;
    public String mChannel;
    public String mCrashLogUploadUrl;
    public String mCrashLogsFolderName;
    public String mCrashRateUploadUrl;
    public int mCrashRestartInterval;
    public String mCrashSDKAuthUrl;
    public boolean mDebug;
    public long mDisableBackgroundSignals;
    public long mDisableSignals;
    public boolean mDumpHprofDataForJavaOOM;
    public boolean mDumpUserSolibBuildId;
    public boolean mEnableCrpStat;
    public boolean mEnableLibcMallocDetail;
    public boolean mEnableMemoryGroup;
    public boolean mEnableStatReport;
    public boolean mEnableStatToWPKDirect;
    public boolean mEncryptLog;
    public int mFdDumpMinLimit;
    public int mInfoSaveFrequency;
    public int mInfoUpdateInterval;
    public boolean mIsInternational;
    public String mJavaCrashLogFileName;
    public String mLibcMallocDetailConfig;
    public int mLogMaxBytesLimit;
    public int mLogMaxUploadBytesLimit;
    public String mLogsBackupPathName;
    public int mMaxAnrLogCountPerProcess;
    public int mMaxAnrLogcatLineCount;
    public int mMaxBuiltinLogFilesCount;
    public int mMaxCustomLogCountPerTypePerDay;
    public int mMaxCustomLogFilesCount;
    public int mMaxJavaLogcatLineCount;
    public int mMaxNativeLogcatLineCount;
    public int mMaxUnexpLogcatLineCount;
    public int mMaxUploadBuiltinLogCountPerDay;
    public long mMaxUploadBytesPerDay;
    public int mMaxUploadCustomLogCountPerDay;
    public boolean mMonitorBattery;
    public String mNativeCrashLogFileName;
    public boolean mOmitJavaCrash;
    public boolean mOmitNativeCrash;
    public boolean mPrintStackInfos;
    public boolean mRenameFileToDefaultName;
    public int mReservedJavaFileHandleCount;
    public int mReservedNativeFileHandleCount;
    public long mReservedNativeMemoryBytes;
    public boolean mSyncUploadLogs;
    public boolean mSyncUploadSetupCrashLogs;
    public String mTagFilesFolderName;
    public int mThreadsDumpMinLimit;
    public String mUnexpCrashLogFileName;
    public int mUnexpDelayMillSeconds;
    public int mUnexpSubTypes;
    public String mUserId;
    public boolean mZipLog;
    public String mZippedLogExtension;

    public CustomInfo() {
        this.mAppId = "CrashSDK";
        this.mJavaCrashLogFileName = null;
        this.mNativeCrashLogFileName = null;
        this.mUnexpCrashLogFileName = null;
        this.mTagFilesFolderName = "crashsdk/tags";
        this.mCrashLogsFolderName = "crashsdk/logs";
        this.mLogsBackupPathName = null;
        this.mMaxBuiltinLogFilesCount = 20;
        this.mMaxCustomLogFilesCount = 10;
        this.mMaxJavaLogcatLineCount = 1500;
        this.mMaxNativeLogcatLineCount = 3000;
        this.mMaxUnexpLogcatLineCount = 500;
        this.mMaxAnrLogcatLineCount = 1000;
        this.mUnexpDelayMillSeconds = 60000;
        this.mUnexpSubTypes = 32000;
        this.mBackupLogs = false;
        this.mSyncUploadSetupCrashLogs = true;
        this.mSyncUploadLogs = true;
        this.mOmitJavaCrash = false;
        this.mOmitNativeCrash = false;
        this.mDumpUserSolibBuildId = true;
        this.mAutoDeleteOldVersionStats = true;
        this.mZipLog = true;
        this.mZippedLogExtension = d.b;
        this.mLogMaxBytesLimit = 1048576;
        this.mLogMaxUploadBytesLimit = 819200;
        this.mMaxUploadBytesPerDay = 1572864L;
        this.mMaxUploadBuiltinLogCountPerDay = 25;
        this.mMaxUploadCustomLogCountPerDay = 20;
        this.mMaxCustomLogCountPerTypePerDay = 6;
        this.mMaxAnrLogCountPerProcess = 3;
        this.mCrashRestartInterval = -1;
        this.mCallJavaDefaultHandler = true;
        this.mCallNativeDefaultHandler = false;
        this.mDumpHprofDataForJavaOOM = false;
        this.mRenameFileToDefaultName = false;
        this.mInfoUpdateInterval = 50;
        this.mInfoSaveFrequency = 3;
        this.mReservedJavaFileHandleCount = 15;
        this.mReservedNativeFileHandleCount = 10;
        this.mFdDumpMinLimit = 900;
        this.mThreadsDumpMinLimit = 300;
        this.mReservedNativeMemoryBytes = 3145728L;
        this.mDisableSignals = 0L;
        this.mDisableBackgroundSignals = 16386L;
        this.mEnableStatReport = false;
        this.mIsInternational = false;
        this.mAutoDetectLifeCycle = true;
        this.mMonitorBattery = true;
        this.mAnrTraceStrategy = 2;
        this.mPrintStackInfos = false;
        this.mDebug = false;
        this.mEncryptLog = false;
        this.mAddPvForNewDay = false;
        this.mEnableMemoryGroup = false;
        this.mEnableLibcMallocDetail = false;
        this.mLibcMallocDetailConfig = null;
        this.mEnableCrpStat = false;
        this.mEnableStatToWPKDirect = false;
        this.mCrashLogUploadUrl = null;
        this.mCrashRateUploadUrl = null;
        this.mCrashSDKAuthUrl = null;
    }

    public CustomInfo(CustomInfo customInfo) {
        this.mAppId = "CrashSDK";
        this.mJavaCrashLogFileName = null;
        this.mNativeCrashLogFileName = null;
        this.mUnexpCrashLogFileName = null;
        this.mTagFilesFolderName = "crashsdk/tags";
        this.mCrashLogsFolderName = "crashsdk/logs";
        this.mLogsBackupPathName = null;
        this.mMaxBuiltinLogFilesCount = 20;
        this.mMaxCustomLogFilesCount = 10;
        this.mMaxJavaLogcatLineCount = 1500;
        this.mMaxNativeLogcatLineCount = 3000;
        this.mMaxUnexpLogcatLineCount = 500;
        this.mMaxAnrLogcatLineCount = 1000;
        this.mUnexpDelayMillSeconds = 60000;
        this.mUnexpSubTypes = 32000;
        this.mBackupLogs = false;
        this.mSyncUploadSetupCrashLogs = true;
        this.mSyncUploadLogs = true;
        this.mOmitJavaCrash = false;
        this.mOmitNativeCrash = false;
        this.mDumpUserSolibBuildId = true;
        this.mAutoDeleteOldVersionStats = true;
        this.mZipLog = true;
        this.mZippedLogExtension = d.b;
        this.mLogMaxBytesLimit = 1048576;
        this.mLogMaxUploadBytesLimit = 819200;
        this.mMaxUploadBytesPerDay = 1572864L;
        this.mMaxUploadBuiltinLogCountPerDay = 25;
        this.mMaxUploadCustomLogCountPerDay = 20;
        this.mMaxCustomLogCountPerTypePerDay = 6;
        this.mMaxAnrLogCountPerProcess = 3;
        this.mCrashRestartInterval = -1;
        this.mCallJavaDefaultHandler = true;
        this.mCallNativeDefaultHandler = false;
        this.mDumpHprofDataForJavaOOM = false;
        this.mRenameFileToDefaultName = false;
        this.mInfoUpdateInterval = 50;
        this.mInfoSaveFrequency = 3;
        this.mReservedJavaFileHandleCount = 15;
        this.mReservedNativeFileHandleCount = 10;
        this.mFdDumpMinLimit = 900;
        this.mThreadsDumpMinLimit = 300;
        this.mReservedNativeMemoryBytes = 3145728L;
        this.mDisableSignals = 0L;
        this.mDisableBackgroundSignals = 16386L;
        this.mEnableStatReport = false;
        this.mIsInternational = false;
        this.mAutoDetectLifeCycle = true;
        this.mMonitorBattery = true;
        this.mAnrTraceStrategy = 2;
        this.mPrintStackInfos = false;
        this.mDebug = false;
        this.mEncryptLog = false;
        this.mAddPvForNewDay = false;
        this.mEnableMemoryGroup = false;
        this.mEnableLibcMallocDetail = false;
        this.mLibcMallocDetailConfig = null;
        this.mEnableCrpStat = false;
        this.mEnableStatToWPKDirect = false;
        this.mCrashLogUploadUrl = null;
        this.mCrashRateUploadUrl = null;
        this.mCrashSDKAuthUrl = null;
        this.mAppId = customInfo.mAppId;
        this.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
        this.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
        this.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
        this.mTagFilesFolderName = customInfo.mTagFilesFolderName;
        this.mCrashLogsFolderName = customInfo.mCrashLogsFolderName;
        this.mLogsBackupPathName = customInfo.mLogsBackupPathName;
        this.mMaxBuiltinLogFilesCount = customInfo.mMaxBuiltinLogFilesCount;
        this.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
        this.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
        this.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
        this.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
        this.mMaxAnrLogcatLineCount = customInfo.mMaxAnrLogcatLineCount;
        this.mUnexpDelayMillSeconds = customInfo.mUnexpDelayMillSeconds;
        this.mUnexpSubTypes = customInfo.mUnexpSubTypes;
        this.mBackupLogs = customInfo.mBackupLogs;
        this.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
        this.mSyncUploadLogs = customInfo.mSyncUploadLogs;
        this.mOmitJavaCrash = customInfo.mOmitJavaCrash;
        this.mOmitNativeCrash = customInfo.mOmitNativeCrash;
        this.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
        this.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
        this.mZipLog = customInfo.mZipLog;
        this.mZippedLogExtension = customInfo.mZippedLogExtension;
        this.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
        this.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
        this.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
        this.mMaxAnrLogCountPerProcess = customInfo.mMaxAnrLogCountPerProcess;
        this.mMaxUploadBuiltinLogCountPerDay = customInfo.mMaxUploadBuiltinLogCountPerDay;
        this.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
        this.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
        this.mCrashRestartInterval = customInfo.mCrashRestartInterval;
        this.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
        this.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
        this.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
        this.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
        this.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
        this.mInfoSaveFrequency = customInfo.mInfoSaveFrequency;
        this.mReservedJavaFileHandleCount = customInfo.mReservedJavaFileHandleCount;
        this.mReservedNativeFileHandleCount = customInfo.mReservedNativeFileHandleCount;
        this.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
        this.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
        this.mReservedNativeMemoryBytes = customInfo.mReservedNativeMemoryBytes;
        this.mDisableSignals = customInfo.mDisableSignals;
        this.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
        this.mEnableStatReport = customInfo.mEnableStatReport;
        this.mEnableCrpStat = customInfo.mEnableCrpStat;
        this.mEnableStatToWPKDirect = customInfo.mEnableStatToWPKDirect;
        this.mIsInternational = customInfo.mIsInternational;
        this.mAutoDetectLifeCycle = customInfo.mAutoDetectLifeCycle;
        this.mMonitorBattery = customInfo.mMonitorBattery;
        this.mAnrTraceStrategy = customInfo.mAnrTraceStrategy;
        this.mPrintStackInfos = customInfo.mPrintStackInfos;
        this.mDebug = customInfo.mDebug;
        this.mEncryptLog = customInfo.mEncryptLog;
        this.mAddPvForNewDay = customInfo.mAddPvForNewDay;
        this.mEnableMemoryGroup = customInfo.mEnableMemoryGroup;
        this.mEnableLibcMallocDetail = customInfo.mEnableLibcMallocDetail;
        this.mLibcMallocDetailConfig = customInfo.mLibcMallocDetailConfig;
        this.mUserId = customInfo.mUserId;
        this.mChannel = customInfo.mChannel;
        this.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
        this.mCrashRateUploadUrl = customInfo.mCrashRateUploadUrl;
        this.mCrashSDKAuthUrl = customInfo.mCrashSDKAuthUrl;
    }

    public CustomInfo(String str) {
        this.mAppId = "CrashSDK";
        this.mJavaCrashLogFileName = null;
        this.mNativeCrashLogFileName = null;
        this.mUnexpCrashLogFileName = null;
        this.mTagFilesFolderName = "crashsdk/tags";
        this.mCrashLogsFolderName = "crashsdk/logs";
        this.mLogsBackupPathName = null;
        this.mMaxBuiltinLogFilesCount = 20;
        this.mMaxCustomLogFilesCount = 10;
        this.mMaxJavaLogcatLineCount = 1500;
        this.mMaxNativeLogcatLineCount = 3000;
        this.mMaxUnexpLogcatLineCount = 500;
        this.mMaxAnrLogcatLineCount = 1000;
        this.mUnexpDelayMillSeconds = 60000;
        this.mUnexpSubTypes = 32000;
        this.mBackupLogs = false;
        this.mSyncUploadSetupCrashLogs = true;
        this.mSyncUploadLogs = true;
        this.mOmitJavaCrash = false;
        this.mOmitNativeCrash = false;
        this.mDumpUserSolibBuildId = true;
        this.mAutoDeleteOldVersionStats = true;
        this.mZipLog = true;
        this.mZippedLogExtension = d.b;
        this.mLogMaxBytesLimit = 1048576;
        this.mLogMaxUploadBytesLimit = 819200;
        this.mMaxUploadBytesPerDay = 1572864L;
        this.mMaxUploadBuiltinLogCountPerDay = 25;
        this.mMaxUploadCustomLogCountPerDay = 20;
        this.mMaxCustomLogCountPerTypePerDay = 6;
        this.mMaxAnrLogCountPerProcess = 3;
        this.mCrashRestartInterval = -1;
        this.mCallJavaDefaultHandler = true;
        this.mCallNativeDefaultHandler = false;
        this.mDumpHprofDataForJavaOOM = false;
        this.mRenameFileToDefaultName = false;
        this.mInfoUpdateInterval = 50;
        this.mInfoSaveFrequency = 3;
        this.mReservedJavaFileHandleCount = 15;
        this.mReservedNativeFileHandleCount = 10;
        this.mFdDumpMinLimit = 900;
        this.mThreadsDumpMinLimit = 300;
        this.mReservedNativeMemoryBytes = 3145728L;
        this.mDisableSignals = 0L;
        this.mDisableBackgroundSignals = 16386L;
        this.mEnableStatReport = false;
        this.mIsInternational = false;
        this.mAutoDetectLifeCycle = true;
        this.mMonitorBattery = true;
        this.mAnrTraceStrategy = 2;
        this.mPrintStackInfos = false;
        this.mDebug = false;
        this.mEncryptLog = false;
        this.mAddPvForNewDay = false;
        this.mEnableMemoryGroup = false;
        this.mEnableLibcMallocDetail = false;
        this.mLibcMallocDetailConfig = null;
        this.mEnableCrpStat = false;
        this.mEnableStatToWPKDirect = false;
        this.mCrashLogUploadUrl = null;
        this.mCrashRateUploadUrl = null;
        this.mCrashSDKAuthUrl = null;
        this.mAppId = str;
    }
}