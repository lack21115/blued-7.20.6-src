package com.android.internal.app;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import com.alipay.sdk.util.i;
import com.amap.api.col.p0003sl.iu;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.util.GrowingArrayUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import dalvik.system.VMRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import libcore.util.EmptyArray;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats.class */
public final class ProcessStats implements Parcelable {
    public static final int ADJ_COUNT = 8;
    public static final int ADJ_MEM_FACTOR_COUNT = 4;
    public static final int ADJ_MEM_FACTOR_CRITICAL = 3;
    public static final int ADJ_MEM_FACTOR_LOW = 2;
    public static final int ADJ_MEM_FACTOR_MODERATE = 1;
    public static final int ADJ_MEM_FACTOR_NORMAL = 0;
    public static final int ADJ_NOTHING = -1;
    public static final int ADJ_SCREEN_MOD = 4;
    public static final int ADJ_SCREEN_OFF = 0;
    public static final int ADJ_SCREEN_ON = 4;
    static final String CSV_SEP = "\t";
    static final boolean DEBUG = false;
    static final boolean DEBUG_PARCEL = false;
    public static final int FLAG_COMPLETE = 1;
    public static final int FLAG_SHUTDOWN = 2;
    public static final int FLAG_SYSPROPS = 4;
    static final int LONGS_SIZE = 4096;
    private static final int MAGIC = 1347638355;
    private static final int PARCEL_VERSION = 18;
    public static final int PSS_AVERAGE = 2;
    public static final int PSS_COUNT = 7;
    public static final int PSS_MAXIMUM = 3;
    public static final int PSS_MINIMUM = 1;
    public static final int PSS_SAMPLE_COUNT = 0;
    public static final int PSS_USS_AVERAGE = 5;
    public static final int PSS_USS_MAXIMUM = 6;
    public static final int PSS_USS_MINIMUM = 4;
    public static final String SERVICE_NAME = "procstats";
    public static final int STATE_BACKUP = 4;
    public static final int STATE_CACHED_ACTIVITY = 11;
    public static final int STATE_CACHED_ACTIVITY_CLIENT = 12;
    public static final int STATE_CACHED_EMPTY = 13;
    public static final int STATE_COUNT = 14;
    public static final int STATE_HEAVY_WEIGHT = 5;
    public static final int STATE_HOME = 9;
    public static final int STATE_IMPORTANT_BACKGROUND = 3;
    public static final int STATE_IMPORTANT_FOREGROUND = 2;
    public static final int STATE_LAST_ACTIVITY = 10;
    public static final int STATE_NOTHING = -1;
    public static final int STATE_PERSISTENT = 0;
    public static final int STATE_RECEIVER = 8;
    public static final int STATE_SERVICE = 6;
    public static final int STATE_SERVICE_RESTARTING = 7;
    public static final int STATE_TOP = 1;
    public static final int SYS_MEM_USAGE_CACHED_AVERAGE = 2;
    public static final int SYS_MEM_USAGE_CACHED_MAXIMUM = 3;
    public static final int SYS_MEM_USAGE_CACHED_MINIMUM = 1;
    public static final int SYS_MEM_USAGE_COUNT = 16;
    public static final int SYS_MEM_USAGE_FREE_AVERAGE = 5;
    public static final int SYS_MEM_USAGE_FREE_MAXIMUM = 6;
    public static final int SYS_MEM_USAGE_FREE_MINIMUM = 4;
    public static final int SYS_MEM_USAGE_KERNEL_AVERAGE = 11;
    public static final int SYS_MEM_USAGE_KERNEL_MAXIMUM = 12;
    public static final int SYS_MEM_USAGE_KERNEL_MINIMUM = 10;
    public static final int SYS_MEM_USAGE_NATIVE_AVERAGE = 14;
    public static final int SYS_MEM_USAGE_NATIVE_MAXIMUM = 15;
    public static final int SYS_MEM_USAGE_NATIVE_MINIMUM = 13;
    public static final int SYS_MEM_USAGE_SAMPLE_COUNT = 0;
    public static final int SYS_MEM_USAGE_ZRAM_AVERAGE = 8;
    public static final int SYS_MEM_USAGE_ZRAM_MAXIMUM = 9;
    public static final int SYS_MEM_USAGE_ZRAM_MINIMUM = 7;
    static final String TAG = "ProcessStats";
    int[] mAddLongTable;
    int mAddLongTableSize;
    ArrayMap<String, Integer> mCommonStringToIndex;
    public int mFlags;
    ArrayList<String> mIndexToCommonString;
    final ArrayList<long[]> mLongs;
    public int mMemFactor;
    public final long[] mMemFactorDurations;
    int mNextLong;
    public final ProcessMap<SparseArray<PackageState>> mPackages;
    public final ProcessMap<ProcessState> mProcesses;
    public String mReadError;
    boolean mRunning;
    String mRuntime;
    public long mStartTime;
    public final long[] mSysMemUsageArgs;
    public int[] mSysMemUsageTable;
    public int mSysMemUsageTableSize;
    public long mTimePeriodEndRealtime;
    public long mTimePeriodEndUptime;
    public long mTimePeriodStartClock;
    public String mTimePeriodStartClockStr;
    public long mTimePeriodStartRealtime;
    public long mTimePeriodStartUptime;
    public static long COMMIT_PERIOD = 10800000;
    public static long COMMIT_UPTIME_PERIOD = 3600000;
    public static final int[] ALL_MEM_ADJ = {0, 1, 2, 3};
    public static final int[] ALL_SCREEN_ADJ = {0, 4};
    public static final int[] NON_CACHED_PROC_STATES = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static final int[] BACKGROUND_PROC_STATES = {2, 3, 4, 5, 6, 7, 8};
    static final int[] PROCESS_STATE_TO_STATE = {0, 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13};
    public static final int[] ALL_PROC_STATES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    static final String[] STATE_NAMES = {"Persist", "Top    ", "ImpFg  ", "ImpBg  ", "Backup ", "HeavyWt", "Service", "ServRst", "Receivr", "Home   ", "LastAct", "CchAct ", "CchCAct", "CchEmty"};
    public static final String[] ADJ_SCREEN_NAMES_CSV = {"off", "on"};
    public static final String[] ADJ_MEM_NAMES_CSV = {"norm", "mod", "low", "crit"};
    public static final String[] STATE_NAMES_CSV = {"pers", Constant.MAP_KEY_TOP, "impfg", "impbg", Context.BACKUP_SERVICE, "heavy", "service", "service-rs", SocialConstants.PARAM_RECEIVER, "home", "lastact", "cch-activity", "cch-aclient", "cch-empty"};
    static final String[] ADJ_SCREEN_TAGS = {"0", "1"};
    static final String[] ADJ_MEM_TAGS = {"n", "m", "l", "c"};
    static final String[] STATE_TAGS = {"p", "t", "f", "b", "u", IAdInterListener.AdReqParam.WIDTH, "s", "x", "r", "h", "l", "a", "c", iu.h};
    static int OFFSET_TYPE_SHIFT = 0;
    static int OFFSET_TYPE_MASK = 255;
    static int OFFSET_ARRAY_SHIFT = 8;
    static int OFFSET_ARRAY_MASK = 255;
    static int OFFSET_INDEX_SHIFT = 16;
    static int OFFSET_INDEX_MASK = 65535;
    public static final Parcelable.Creator<ProcessStats> CREATOR = new Parcelable.Creator<ProcessStats>() { // from class: com.android.internal.app.ProcessStats.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcessStats createFromParcel(Parcel parcel) {
            return new ProcessStats(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcessStats[] newArray(int i) {
            return new ProcessStats[i];
        }
    };
    static final int[] BAD_TABLE = new int[0];

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$DurationsTable.class */
    public static class DurationsTable {
        public int[] mDurationsTable;
        public int mDurationsTableSize;
        public final String mName;
        public final ProcessStats mStats;

        public DurationsTable(ProcessStats processStats, String str) {
            this.mStats = processStats;
            this.mName = str;
        }

        void addDuration(int i, long j) {
            int addLongData;
            int binarySearch = ProcessStats.binarySearch(this.mDurationsTable, this.mDurationsTableSize, i);
            if (binarySearch >= 0) {
                addLongData = this.mDurationsTable[binarySearch];
            } else {
                this.mStats.mAddLongTable = this.mDurationsTable;
                this.mStats.mAddLongTableSize = this.mDurationsTableSize;
                addLongData = this.mStats.addLongData(binarySearch ^ (-1), i, 1);
                this.mDurationsTable = this.mStats.mAddLongTable;
                this.mDurationsTableSize = this.mStats.mAddLongTableSize;
            }
            if (((addLongData >> ProcessStats.OFFSET_ARRAY_SHIFT) & ProcessStats.OFFSET_ARRAY_MASK) >= this.mStats.mLongs.size()) {
                return;
            }
            long[] jArr = this.mStats.mLongs.get((addLongData >> ProcessStats.OFFSET_ARRAY_SHIFT) & ProcessStats.OFFSET_ARRAY_MASK);
            int i2 = (addLongData >> ProcessStats.OFFSET_INDEX_SHIFT) & ProcessStats.OFFSET_INDEX_MASK;
            jArr[i2] = jArr[i2] + j;
        }

        void addDurations(DurationsTable durationsTable) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= durationsTable.mDurationsTableSize) {
                    return;
                }
                int i3 = durationsTable.mDurationsTable[i2];
                addDuration((i3 >> ProcessStats.OFFSET_TYPE_SHIFT) & ProcessStats.OFFSET_TYPE_MASK, durationsTable.mStats.getLong(i3, 0));
                i = i2 + 1;
            }
        }

        void copyDurationsTo(DurationsTable durationsTable) {
            if (this.mDurationsTable == null) {
                durationsTable.mDurationsTable = null;
                durationsTable.mDurationsTableSize = 0;
                return;
            }
            this.mStats.mAddLongTable = new int[this.mDurationsTable.length];
            this.mStats.mAddLongTableSize = 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mDurationsTableSize) {
                    durationsTable.mDurationsTable = this.mStats.mAddLongTable;
                    durationsTable.mDurationsTableSize = this.mStats.mAddLongTableSize;
                    return;
                }
                int i3 = this.mDurationsTable[i2];
                int i4 = (i3 >> ProcessStats.OFFSET_TYPE_SHIFT) & ProcessStats.OFFSET_TYPE_MASK;
                int addLongData = this.mStats.addLongData(i2, i4, 1);
                this.mStats.mAddLongTable[i2] = addLongData | i4;
                this.mStats.setLong(addLongData, 0, this.mStats.getLong(i3, 0));
                i = i2 + 1;
            }
        }

        long getDuration(int i, long j) {
            int binarySearch = ProcessStats.binarySearch(this.mDurationsTable, this.mDurationsTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mDurationsTable[binarySearch], 0);
            }
            return 0L;
        }

        boolean readDurationsFromParcel(Parcel parcel) {
            int i = 0;
            this.mDurationsTable = this.mStats.readTableFromParcel(parcel, this.mName, "durations");
            if (this.mDurationsTable == ProcessStats.BAD_TABLE) {
                return false;
            }
            if (this.mDurationsTable != null) {
                i = this.mDurationsTable.length;
            }
            this.mDurationsTableSize = i;
            return true;
        }

        void resetDurationsSafely() {
            this.mDurationsTable = null;
            this.mDurationsTableSize = 0;
        }

        void writeDurationsToParcel(Parcel parcel) {
            parcel.writeInt(this.mDurationsTableSize);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mDurationsTableSize) {
                    return;
                }
                parcel.writeInt(this.mDurationsTable[i2]);
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$PackageState.class */
    public static final class PackageState {
        public final String mPackageName;
        public final ArrayMap<String, ProcessState> mProcesses = new ArrayMap<>();
        public final ArrayMap<String, ServiceState> mServices = new ArrayMap<>();
        public final int mUid;

        public PackageState(String str, int i) {
            this.mUid = i;
            this.mPackageName = str;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$ProcessDataCollection.class */
    public static final class ProcessDataCollection {
        public long avgPss;
        public long avgUss;
        public long maxPss;
        public long maxUss;
        final int[] memStates;
        public long minPss;
        public long minUss;
        public long numPss;
        final int[] procStates;
        final int[] screenStates;
        public long totalTime;

        public ProcessDataCollection(int[] iArr, int[] iArr2, int[] iArr3) {
            this.screenStates = iArr;
            this.memStates = iArr2;
            this.procStates = iArr3;
        }

        void print(PrintWriter printWriter, long j, boolean z) {
            if (this.totalTime > j) {
                printWriter.print(PhoneConstants.APN_TYPE_ALL);
            }
            ProcessStats.printPercent(printWriter, this.totalTime / j);
            if (this.numPss > 0) {
                printWriter.print(" (");
                ProcessStats.printSizeValue(printWriter, this.minPss * 1024);
                printWriter.print("-");
                ProcessStats.printSizeValue(printWriter, this.avgPss * 1024);
                printWriter.print("-");
                ProcessStats.printSizeValue(printWriter, this.maxPss * 1024);
                printWriter.print(BridgeUtil.SPLIT_MARK);
                ProcessStats.printSizeValue(printWriter, this.minUss * 1024);
                printWriter.print("-");
                ProcessStats.printSizeValue(printWriter, this.avgUss * 1024);
                printWriter.print("-");
                ProcessStats.printSizeValue(printWriter, this.maxUss * 1024);
                if (z) {
                    printWriter.print(" over ");
                    printWriter.print(this.numPss);
                }
                printWriter.print(")");
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$ProcessState.class */
    public static final class ProcessState extends DurationsTable {
        boolean mActive;
        long mAvgCachedKillPss;
        public ProcessState mCommonProcess;
        int mCurState;
        boolean mDead;
        int mLastPssState;
        long mLastPssTime;
        long mMaxCachedKillPss;
        long mMinCachedKillPss;
        boolean mMultiPackage;
        int mNumActiveServices;
        int mNumCachedKill;
        int mNumExcessiveCpu;
        int mNumExcessiveWake;
        int mNumStartedServices;
        public final String mPackage;
        int[] mPssTable;
        int mPssTableSize;
        long mStartTime;
        ProcessState mTmpFoundSubProc;
        int mTmpNumInUse;
        public long mTmpTotalTime;
        public final int mUid;
        public final int mVersion;

        public ProcessState(ProcessState processState, String str, int i, int i2, String str2, long j) {
            super(processState.mStats, str2);
            this.mCurState = -1;
            this.mLastPssState = -1;
            this.mCommonProcess = processState;
            this.mPackage = str;
            this.mUid = i;
            this.mVersion = i2;
            this.mCurState = processState.mCurState;
            this.mStartTime = j;
        }

        public ProcessState(ProcessStats processStats, String str, int i, int i2, String str2) {
            super(processStats, str2);
            this.mCurState = -1;
            this.mLastPssState = -1;
            this.mCommonProcess = this;
            this.mPackage = str;
            this.mUid = i;
            this.mVersion = i2;
        }

        private void addCachedKill(int i, long j, long j2, long j3) {
            if (this.mNumCachedKill <= 0) {
                this.mNumCachedKill = i;
                this.mMinCachedKillPss = j;
                this.mAvgCachedKillPss = j2;
                this.mMaxCachedKillPss = j3;
                return;
            }
            if (j < this.mMinCachedKillPss) {
                this.mMinCachedKillPss = j;
            }
            if (j3 > this.mMaxCachedKillPss) {
                this.mMaxCachedKillPss = j3;
            }
            this.mAvgCachedKillPss = (long) (((this.mAvgCachedKillPss * this.mNumCachedKill) + j2) / (this.mNumCachedKill + i));
            this.mNumCachedKill += i;
        }

        private void ensureNotDead() {
            if (this.mDead) {
                Slog.wtfStack(ProcessStats.TAG, "ProcessState dead: name=" + this.mName + " pkg=" + this.mPackage + " uid=" + this.mUid + " common.name=" + this.mCommonProcess.mName);
            }
        }

        private ProcessState pullFixedProc(ArrayMap<String, ProcessStateHolder> arrayMap, int i) {
            ProcessStateHolder valueAt = arrayMap.valueAt(i);
            ProcessState processState = valueAt.state;
            ProcessState processState2 = processState;
            if (this.mDead) {
                processState2 = processState;
                if (processState.mCommonProcess != processState) {
                    Log.wtf(ProcessStats.TAG, "Pulling dead proc: name=" + this.mName + " pkg=" + this.mPackage + " uid=" + this.mUid + " common.name=" + this.mCommonProcess.mName);
                    processState2 = this.mStats.getProcessStateLocked(processState.mPackage, processState.mUid, processState.mVersion, processState.mName);
                }
            }
            ProcessState processState3 = processState2;
            if (processState2.mMultiPackage) {
                SparseArray<PackageState> sparseArray = this.mStats.mPackages.get(arrayMap.keyAt(i), processState2.mUid);
                if (sparseArray == null) {
                    throw new IllegalStateException("No existing package " + arrayMap.keyAt(i) + BridgeUtil.SPLIT_MARK + processState2.mUid + " for multi-proc " + processState2.mName);
                }
                PackageState packageState = sparseArray.get(processState2.mVersion);
                if (packageState == null) {
                    throw new IllegalStateException("No existing package " + arrayMap.keyAt(i) + BridgeUtil.SPLIT_MARK + processState2.mUid + " for multi-proc " + processState2.mName + " version " + processState2.mVersion);
                }
                processState3 = packageState.mProcesses.get(processState2.mName);
                if (processState3 == null) {
                    throw new IllegalStateException("Didn't create per-package process " + processState3.mName + " in pkg " + packageState.mPackageName + BridgeUtil.SPLIT_MARK + packageState.mUid);
                }
                valueAt.state = processState3;
            }
            return processState3;
        }

        void add(ProcessState processState) {
            addDurations(processState);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= processState.mPssTableSize) {
                    break;
                }
                int i3 = processState.mPssTable[i2];
                addPss((i3 >> ProcessStats.OFFSET_TYPE_SHIFT) & ProcessStats.OFFSET_TYPE_MASK, (int) processState.mStats.getLong(i3, 0), processState.mStats.getLong(i3, 1), processState.mStats.getLong(i3, 2), processState.mStats.getLong(i3, 3), processState.mStats.getLong(i3, 4), processState.mStats.getLong(i3, 5), processState.mStats.getLong(i3, 6));
                i = i2 + 1;
            }
            this.mNumExcessiveWake += processState.mNumExcessiveWake;
            this.mNumExcessiveCpu += processState.mNumExcessiveCpu;
            if (processState.mNumCachedKill > 0) {
                addCachedKill(processState.mNumCachedKill, processState.mMinCachedKillPss, processState.mAvgCachedKillPss, processState.mMaxCachedKillPss);
            }
        }

        void addPss(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6) {
            int addLongData;
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                addLongData = this.mPssTable[binarySearch];
            } else {
                this.mStats.mAddLongTable = this.mPssTable;
                this.mStats.mAddLongTableSize = this.mPssTableSize;
                addLongData = this.mStats.addLongData(binarySearch ^ (-1), i, 7);
                this.mPssTable = this.mStats.mAddLongTable;
                this.mPssTableSize = this.mStats.mAddLongTableSize;
            }
            if (((addLongData >> ProcessStats.OFFSET_ARRAY_SHIFT) & ProcessStats.OFFSET_ARRAY_MASK) >= this.mStats.mLongs.size()) {
                return;
            }
            long[] jArr = this.mStats.mLongs.get((addLongData >> ProcessStats.OFFSET_ARRAY_SHIFT) & ProcessStats.OFFSET_ARRAY_MASK);
            int i3 = (addLongData >> ProcessStats.OFFSET_INDEX_SHIFT) & ProcessStats.OFFSET_INDEX_MASK;
            long j7 = jArr[i3 + 0];
            if (j7 == 0) {
                jArr[i3 + 0] = i2;
                jArr[i3 + 1] = j;
                jArr[i3 + 2] = j2;
                jArr[i3 + 3] = j3;
                jArr[i3 + 4] = j4;
                jArr[i3 + 5] = j5;
                jArr[i3 + 6] = j6;
                return;
            }
            jArr[i3 + 0] = i2 + j7;
            if (jArr[i3 + 1] > j) {
                jArr[i3 + 1] = j;
            }
            jArr[i3 + 2] = (long) (((jArr[i3 + 2] * j7) + (j2 * i2)) / (i2 + j7));
            if (jArr[i3 + 3] < j3) {
                jArr[i3 + 3] = j3;
            }
            if (jArr[i3 + 4] > j4) {
                jArr[i3 + 4] = j4;
            }
            jArr[i3 + 5] = (long) (((jArr[i3 + 5] * j7) + (j5 * i2)) / (i2 + j7));
            if (jArr[i3 + 6] < j6) {
                jArr[i3 + 6] = j6;
            }
        }

        public void addPss(long j, long j2, boolean z, ArrayMap<String, ProcessStateHolder> arrayMap) {
            ensureNotDead();
            if (!z && this.mLastPssState == this.mCurState && SystemClock.uptimeMillis() < this.mLastPssTime + 30000) {
                return;
            }
            this.mLastPssState = this.mCurState;
            this.mLastPssTime = SystemClock.uptimeMillis();
            if (this.mCurState == -1) {
                return;
            }
            this.mCommonProcess.addPss(this.mCurState, 1, j, j, j, j2, j2, j2);
            if (!this.mCommonProcess.mMultiPackage || arrayMap == null) {
                return;
            }
            int size = arrayMap.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                pullFixedProc(arrayMap, i).addPss(this.mCurState, 1, j, j, j, j2, j2, j2);
                size = i;
            }
        }

        ProcessState clone(String str, long j) {
            ProcessState processState = new ProcessState(this, str, this.mUid, this.mVersion, this.mName, j);
            copyDurationsTo(processState);
            if (this.mPssTable != null) {
                this.mStats.mAddLongTable = new int[this.mPssTable.length];
                this.mStats.mAddLongTableSize = 0;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mPssTableSize) {
                        break;
                    }
                    int i3 = this.mPssTable[i2];
                    int i4 = (i3 >> ProcessStats.OFFSET_TYPE_SHIFT) & ProcessStats.OFFSET_TYPE_MASK;
                    int addLongData = this.mStats.addLongData(i2, i4, 7);
                    this.mStats.mAddLongTable[i2] = addLongData | i4;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < 7) {
                            this.mStats.setLong(addLongData, i6, this.mStats.getLong(i3, i6));
                            i5 = i6 + 1;
                        }
                    }
                    i = i2 + 1;
                }
                processState.mPssTable = this.mStats.mAddLongTable;
                processState.mPssTableSize = this.mStats.mAddLongTableSize;
            }
            processState.mNumExcessiveWake = this.mNumExcessiveWake;
            processState.mNumExcessiveCpu = this.mNumExcessiveCpu;
            processState.mNumCachedKill = this.mNumCachedKill;
            processState.mMinCachedKillPss = this.mMinCachedKillPss;
            processState.mAvgCachedKillPss = this.mAvgCachedKillPss;
            processState.mMaxCachedKillPss = this.mMaxCachedKillPss;
            processState.mActive = this.mActive;
            processState.mNumActiveServices = this.mNumActiveServices;
            processState.mNumStartedServices = this.mNumStartedServices;
            return processState;
        }

        void commitStateTime(long j) {
            if (this.mCurState != -1) {
                long j2 = j - this.mStartTime;
                if (j2 > 0) {
                    addDuration(this.mCurState, j2);
                }
            }
            this.mStartTime = j;
        }

        void decActiveServices(String str) {
            if (this.mCommonProcess != this) {
                this.mCommonProcess.decActiveServices(str);
            }
            this.mNumActiveServices--;
            if (this.mNumActiveServices < 0) {
                Slog.wtfStack(ProcessStats.TAG, "Proc active services underrun: pkg=" + this.mPackage + " uid=" + this.mUid + " proc=" + this.mName + " service=" + str);
                this.mNumActiveServices = 0;
            }
        }

        void decStartedServices(int i, long j, String str) {
            if (this.mCommonProcess != this) {
                this.mCommonProcess.decStartedServices(i, j, str);
            }
            this.mNumStartedServices--;
            if (this.mNumStartedServices == 0 && this.mCurState % 14 == 7) {
                setState(-1, j);
            } else if (this.mNumStartedServices < 0) {
                Slog.wtfStack(ProcessStats.TAG, "Proc started services underrun: pkg=" + this.mPackage + " uid=" + this.mUid + " name=" + this.mName);
                this.mNumStartedServices = 0;
            }
        }

        @Override // com.android.internal.app.ProcessStats.DurationsTable
        long getDuration(int i, long j) {
            long duration = super.getDuration(i, j);
            long j2 = duration;
            if (this.mCurState == i) {
                j2 = duration + (j - this.mStartTime);
            }
            return j2;
        }

        long getPssAverage(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 2);
            }
            return 0L;
        }

        long getPssMaximum(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 3);
            }
            return 0L;
        }

        long getPssMinimum(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 1);
            }
            return 0L;
        }

        long getPssSampleCount(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 0);
            }
            return 0L;
        }

        long getPssUssAverage(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 5);
            }
            return 0L;
        }

        long getPssUssMaximum(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 6);
            }
            return 0L;
        }

        long getPssUssMinimum(int i) {
            int binarySearch = ProcessStats.binarySearch(this.mPssTable, this.mPssTableSize, i);
            if (binarySearch >= 0) {
                return this.mStats.getLong(this.mPssTable[binarySearch], 4);
            }
            return 0L;
        }

        void incActiveServices(String str) {
            if (this.mCommonProcess != this) {
                this.mCommonProcess.incActiveServices(str);
            }
            this.mNumActiveServices++;
        }

        void incStartedServices(int i, long j, String str) {
            if (this.mCommonProcess != this) {
                this.mCommonProcess.incStartedServices(i, j, str);
            }
            this.mNumStartedServices++;
            if (this.mNumStartedServices == 1 && this.mCurState == -1) {
                setState((i * 14) + 7, j);
            }
        }

        public boolean isInUse() {
            return this.mActive || this.mNumActiveServices > 0 || this.mNumStartedServices > 0 || this.mCurState != -1;
        }

        public void makeActive() {
            ensureNotDead();
            this.mActive = true;
        }

        void makeDead() {
            this.mDead = true;
        }

        public void makeInactive() {
            this.mActive = false;
        }

        ProcessState pullFixedProc(String str) {
            ProcessState processState;
            if (this.mMultiPackage) {
                SparseArray<PackageState> sparseArray = this.mStats.mPackages.get(str, this.mUid);
                if (sparseArray == null) {
                    throw new IllegalStateException("Didn't find package " + str + " / " + this.mUid);
                }
                PackageState packageState = sparseArray.get(this.mVersion);
                if (packageState == null) {
                    throw new IllegalStateException("Didn't find package " + str + " / " + this.mUid + " vers " + this.mVersion);
                }
                ProcessState processState2 = packageState.mProcesses.get(this.mName);
                processState = processState2;
                if (processState2 == null) {
                    throw new IllegalStateException("Didn't create per-package process " + this.mName + " in pkg " + str + " / " + this.mUid + " vers " + this.mVersion);
                }
            } else {
                processState = this;
            }
            return processState;
        }

        boolean readFromParcel(Parcel parcel, boolean z) {
            int i = 0;
            boolean z2 = parcel.readInt() != 0;
            if (z) {
                this.mMultiPackage = z2;
            }
            if (readDurationsFromParcel(parcel)) {
                this.mPssTable = this.mStats.readTableFromParcel(parcel, this.mName, "pss");
                if (this.mPssTable != ProcessStats.BAD_TABLE) {
                    if (this.mPssTable != null) {
                        i = this.mPssTable.length;
                    }
                    this.mPssTableSize = i;
                    this.mNumExcessiveWake = parcel.readInt();
                    this.mNumExcessiveCpu = parcel.readInt();
                    this.mNumCachedKill = parcel.readInt();
                    if (this.mNumCachedKill > 0) {
                        this.mMinCachedKillPss = parcel.readLong();
                        this.mAvgCachedKillPss = parcel.readLong();
                        this.mMaxCachedKillPss = parcel.readLong();
                        return true;
                    }
                    this.mMaxCachedKillPss = 0L;
                    this.mAvgCachedKillPss = 0L;
                    this.mMinCachedKillPss = 0L;
                    return true;
                }
                return false;
            }
            return false;
        }

        public void reportCachedKill(ArrayMap<String, ProcessStateHolder> arrayMap, long j) {
            ensureNotDead();
            this.mCommonProcess.addCachedKill(1, j, j, j);
            if (!this.mCommonProcess.mMultiPackage) {
                return;
            }
            int size = arrayMap.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                pullFixedProc(arrayMap, i).addCachedKill(1, j, j, j);
                size = i;
            }
        }

        public void reportExcessiveCpu(ArrayMap<String, ProcessStateHolder> arrayMap) {
            ensureNotDead();
            this.mCommonProcess.mNumExcessiveCpu++;
            if (!this.mCommonProcess.mMultiPackage) {
                return;
            }
            int size = arrayMap.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                pullFixedProc(arrayMap, i).mNumExcessiveCpu++;
                size = i;
            }
        }

        public void reportExcessiveWake(ArrayMap<String, ProcessStateHolder> arrayMap) {
            ensureNotDead();
            this.mCommonProcess.mNumExcessiveWake++;
            if (!this.mCommonProcess.mMultiPackage) {
                return;
            }
            int size = arrayMap.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                pullFixedProc(arrayMap, i).mNumExcessiveWake++;
                size = i;
            }
        }

        void resetSafely(long j) {
            resetDurationsSafely();
            this.mStartTime = j;
            this.mLastPssState = -1;
            this.mLastPssTime = 0L;
            this.mPssTable = null;
            this.mPssTableSize = 0;
            this.mNumExcessiveWake = 0;
            this.mNumExcessiveCpu = 0;
            this.mNumCachedKill = 0;
            this.mMaxCachedKillPss = 0L;
            this.mAvgCachedKillPss = 0L;
            this.mMinCachedKillPss = 0L;
        }

        public void setState(int i, int i2, long j, ArrayMap<String, ProcessStateHolder> arrayMap) {
            int i3 = i < 0 ? this.mNumStartedServices > 0 ? (i2 * 14) + 7 : -1 : ProcessStats.PROCESS_STATE_TO_STATE[i] + (i2 * 14);
            this.mCommonProcess.setState(i3, j);
            if (!this.mCommonProcess.mMultiPackage || arrayMap == null) {
                return;
            }
            int size = arrayMap.size();
            while (true) {
                int i4 = size - 1;
                if (i4 < 0) {
                    return;
                }
                pullFixedProc(arrayMap, i4).setState(i3, j);
                size = i4;
            }
        }

        void setState(int i, long j) {
            ensureNotDead();
            if (this.mCurState != i) {
                commitStateTime(j);
                this.mCurState = i;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ProcessState{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(this.mName).append(BridgeUtil.SPLIT_MARK).append(this.mUid).append(" pkg=").append(this.mPackage);
            if (this.mMultiPackage) {
                sb.append(" (multi)");
            }
            if (this.mCommonProcess != this) {
                sb.append(" (sub)");
            }
            sb.append(i.d);
            return sb.toString();
        }

        void writeToParcel(Parcel parcel, long j) {
            parcel.writeInt(this.mMultiPackage ? 1 : 0);
            writeDurationsToParcel(parcel);
            parcel.writeInt(this.mPssTableSize);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mPssTableSize) {
                    break;
                }
                parcel.writeInt(this.mPssTable[i2]);
                i = i2 + 1;
            }
            parcel.writeInt(this.mNumExcessiveWake);
            parcel.writeInt(this.mNumExcessiveCpu);
            parcel.writeInt(this.mNumCachedKill);
            if (this.mNumCachedKill > 0) {
                parcel.writeLong(this.mMinCachedKillPss);
                parcel.writeLong(this.mAvgCachedKillPss);
                parcel.writeLong(this.mMaxCachedKillPss);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$ProcessStateHolder.class */
    public static final class ProcessStateHolder {
        public final int appVersion;
        public ProcessState state;

        public ProcessStateHolder(int i) {
            this.appVersion = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$PssAggr.class */
    public static class PssAggr {
        long pss = 0;
        long samples = 0;

        PssAggr() {
        }

        void add(long j, long j2) {
            this.pss = ((long) ((this.pss * this.samples) + (j * j2))) / (this.samples + j2);
            this.samples += j2;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$ServiceState.class */
    public static final class ServiceState extends DurationsTable {
        public static final int SERVICE_BOUND = 2;
        static final int SERVICE_COUNT = 4;
        public static final int SERVICE_EXEC = 3;
        public static final int SERVICE_RUN = 0;
        public static final int SERVICE_STARTED = 1;
        int mBoundCount;
        long mBoundStartTime;
        public int mBoundState;
        int mExecCount;
        long mExecStartTime;
        public int mExecState;
        Object mOwner;
        public final String mPackage;
        ProcessState mProc;
        public final String mProcessName;
        boolean mRestarting;
        int mRunCount;
        long mRunStartTime;
        public int mRunState;
        boolean mStarted;
        int mStartedCount;
        long mStartedStartTime;
        public int mStartedState;

        public ServiceState(ProcessStats processStats, String str, String str2, String str3, ProcessState processState) {
            super(processStats, str2);
            this.mRunState = -1;
            this.mStartedState = -1;
            this.mBoundState = -1;
            this.mExecState = -1;
            this.mPackage = str;
            this.mProcessName = str3;
            this.mProc = processState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getDuration(int i, int i2, long j, int i3, long j2) {
            long duration = getDuration(i + (i3 * 4), j2);
            long j3 = duration;
            if (i2 == i3) {
                j3 = duration + (j2 - j);
            }
            return j3;
        }

        private void updateRunning(int i, long j) {
            if (this.mStartedState == -1 && this.mBoundState == -1 && this.mExecState == -1) {
                i = -1;
            }
            if (this.mRunState != i) {
                if (this.mRunState != -1) {
                    addDuration((this.mRunState * 4) + 0, j - this.mRunStartTime);
                } else if (i != -1) {
                    this.mRunCount++;
                }
                this.mRunState = i;
                this.mRunStartTime = j;
            }
        }

        void add(ServiceState serviceState) {
            addDurations(serviceState);
            this.mRunCount += serviceState.mRunCount;
            this.mStartedCount += serviceState.mStartedCount;
            this.mBoundCount += serviceState.mBoundCount;
            this.mExecCount += serviceState.mExecCount;
        }

        public void applyNewOwner(Object obj) {
            if (this.mOwner != obj) {
                if (this.mOwner == null) {
                    this.mOwner = obj;
                    this.mProc.incActiveServices(this.mName);
                    return;
                }
                this.mOwner = obj;
                if (!this.mStarted && this.mBoundState == -1 && this.mExecState == -1) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.mStarted) {
                    setStarted(false, 0, uptimeMillis);
                }
                if (this.mBoundState != -1) {
                    setBound(false, 0, uptimeMillis);
                }
                if (this.mExecState != -1) {
                    setExecuting(false, 0, uptimeMillis);
                }
            }
        }

        public void clearCurrentOwner(Object obj, boolean z) {
            if (this.mOwner == obj) {
                this.mProc.decActiveServices(this.mName);
                if (this.mStarted || this.mBoundState != -1 || this.mExecState != -1) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (this.mStarted) {
                        if (!z) {
                            Slog.wtfStack(ProcessStats.TAG, "Service owner " + obj + " cleared while started: pkg=" + this.mPackage + " service=" + this.mName + " proc=" + this.mProc);
                        }
                        setStarted(false, 0, uptimeMillis);
                    }
                    if (this.mBoundState != -1) {
                        if (!z) {
                            Slog.wtfStack(ProcessStats.TAG, "Service owner " + obj + " cleared while bound: pkg=" + this.mPackage + " service=" + this.mName + " proc=" + this.mProc);
                        }
                        setBound(false, 0, uptimeMillis);
                    }
                    if (this.mExecState != -1) {
                        if (!z) {
                            Slog.wtfStack(ProcessStats.TAG, "Service owner " + obj + " cleared while exec: pkg=" + this.mPackage + " service=" + this.mName + " proc=" + this.mProc);
                        }
                        setExecuting(false, 0, uptimeMillis);
                    }
                }
                this.mOwner = null;
            }
        }

        void commitStateTime(long j) {
            if (this.mRunState != -1) {
                addDuration((this.mRunState * 4) + 0, j - this.mRunStartTime);
                this.mRunStartTime = j;
            }
            if (this.mStartedState != -1) {
                addDuration((this.mStartedState * 4) + 1, j - this.mStartedStartTime);
                this.mStartedStartTime = j;
            }
            if (this.mBoundState != -1) {
                addDuration((this.mBoundState * 4) + 2, j - this.mBoundStartTime);
                this.mBoundStartTime = j;
            }
            if (this.mExecState != -1) {
                addDuration((this.mExecState * 4) + 3, j - this.mExecStartTime);
                this.mExecStartTime = j;
            }
        }

        public boolean isInUse() {
            return this.mOwner != null || this.mRestarting;
        }

        public boolean isRestarting() {
            return this.mRestarting;
        }

        boolean readFromParcel(Parcel parcel) {
            if (readDurationsFromParcel(parcel)) {
                this.mRunCount = parcel.readInt();
                this.mStartedCount = parcel.readInt();
                this.mBoundCount = parcel.readInt();
                this.mExecCount = parcel.readInt();
                return true;
            }
            return false;
        }

        void resetSafely(long j) {
            resetDurationsSafely();
            this.mRunCount = this.mRunState != -1 ? 1 : 0;
            this.mStartedCount = this.mStartedState != -1 ? 1 : 0;
            this.mBoundCount = this.mBoundState != -1 ? 1 : 0;
            this.mExecCount = this.mExecState != -1 ? 1 : 0;
            this.mExecStartTime = j;
            this.mBoundStartTime = j;
            this.mStartedStartTime = j;
            this.mRunStartTime = j;
        }

        public void setBound(boolean z, int i, long j) {
            if (this.mOwner == null) {
                Slog.wtf(ProcessStats.TAG, "Binding service " + this + " without owner");
            }
            int i2 = z ? i : -1;
            if (this.mBoundState != i2) {
                if (this.mBoundState != -1) {
                    addDuration((this.mBoundState * 4) + 2, j - this.mBoundStartTime);
                } else if (z) {
                    this.mBoundCount++;
                }
                this.mBoundState = i2;
                this.mBoundStartTime = j;
                updateRunning(i, j);
            }
        }

        public void setExecuting(boolean z, int i, long j) {
            if (this.mOwner == null) {
                Slog.wtf(ProcessStats.TAG, "Executing service " + this + " without owner");
            }
            int i2 = z ? i : -1;
            if (this.mExecState != i2) {
                if (this.mExecState != -1) {
                    addDuration((this.mExecState * 4) + 3, j - this.mExecStartTime);
                } else if (z) {
                    this.mExecCount++;
                }
                this.mExecState = i2;
                this.mExecStartTime = j;
                updateRunning(i, j);
            }
        }

        public void setRestarting(boolean z, int i, long j) {
            this.mRestarting = z;
            updateStartedState(i, j);
        }

        public void setStarted(boolean z, int i, long j) {
            if (this.mOwner == null) {
                Slog.wtf(ProcessStats.TAG, "Starting service " + this + " without owner");
            }
            this.mStarted = z;
            updateStartedState(i, j);
        }

        public String toString() {
            return "ServiceState{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mName + " pkg=" + this.mPackage + " proc=" + Integer.toHexString(System.identityHashCode(this)) + i.d;
        }

        void updateStartedState(int i, long j) {
            boolean z = this.mStartedState != -1;
            boolean z2 = this.mStarted || this.mRestarting;
            int i2 = z2 ? i : -1;
            if (this.mStartedState != i2) {
                if (this.mStartedState != -1) {
                    addDuration((this.mStartedState * 4) + 1, j - this.mStartedStartTime);
                } else if (z2) {
                    this.mStartedCount++;
                }
                this.mStartedState = i2;
                this.mStartedStartTime = j;
                this.mProc = this.mProc.pullFixedProc(this.mPackage);
                if (z != z2) {
                    if (z2) {
                        this.mProc.incStartedServices(i, j, this.mName);
                    } else {
                        this.mProc.decStartedServices(i, j, this.mName);
                    }
                }
                updateRunning(i, j);
            }
        }

        void writeToParcel(Parcel parcel, long j) {
            writeDurationsToParcel(parcel);
            parcel.writeInt(this.mRunCount);
            parcel.writeInt(this.mStartedCount);
            parcel.writeInt(this.mBoundCount);
            parcel.writeInt(this.mExecCount);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ProcessStats$TotalMemoryUseCollection.class */
    public static class TotalMemoryUseCollection {
        final int[] memStates;
        final int[] screenStates;
        public double sysMemCachedWeight;
        public double sysMemFreeWeight;
        public double sysMemKernelWeight;
        public double sysMemNativeWeight;
        public int sysMemSamples;
        public double sysMemZRamWeight;
        public long totalTime;
        public long[] processStatePss = new long[14];
        public double[] processStateWeight = new double[14];
        public long[] processStateTime = new long[14];
        public int[] processStateSamples = new int[14];
        public long[] sysMemUsage = new long[16];

        public TotalMemoryUseCollection(int[] iArr, int[] iArr2) {
            this.screenStates = iArr;
            this.memStates = iArr2;
        }
    }

    public ProcessStats(Parcel parcel) {
        this.mPackages = new ProcessMap<>();
        this.mProcesses = new ProcessMap<>();
        this.mMemFactorDurations = new long[8];
        this.mMemFactor = -1;
        this.mSysMemUsageTable = null;
        this.mSysMemUsageTableSize = 0;
        this.mSysMemUsageArgs = new long[16];
        this.mLongs = new ArrayList<>();
        reset();
        readFromParcel(parcel);
    }

    public ProcessStats(boolean z) {
        this.mPackages = new ProcessMap<>();
        this.mProcesses = new ProcessMap<>();
        this.mMemFactorDurations = new long[8];
        this.mMemFactor = -1;
        this.mSysMemUsageTable = null;
        this.mSysMemUsageTableSize = 0;
        this.mSysMemUsageArgs = new long[16];
        this.mLongs = new ArrayList<>();
        this.mRunning = z;
        reset();
    }

    static void addSysMemUsage(long[] jArr, int i, long[] jArr2, int i2) {
        long j = jArr[i + 0];
        long j2 = jArr2[i2 + 0];
        if (j == 0) {
            jArr[i + 0] = j2;
            int i3 = 1;
            while (true) {
                int i4 = i3;
                if (i4 >= 16) {
                    return;
                }
                jArr[i + i4] = jArr2[i2 + i4];
                i3 = i4 + 1;
            }
        } else if (j2 <= 0) {
        } else {
            jArr[i + 0] = j + j2;
            int i5 = 1;
            while (true) {
                int i6 = i5;
                if (i6 >= 16) {
                    return;
                }
                if (jArr[i + i6] > jArr2[i2 + i6]) {
                    jArr[i + i6] = jArr2[i2 + i6];
                }
                jArr[i + i6 + 1] = (long) (((jArr[(i + i6) + 1] * j) + (jArr2[(i2 + i6) + 1] * j2)) / (j + j2));
                if (jArr[i + i6 + 2] < jArr2[i2 + i6 + 2]) {
                    jArr[i + i6 + 2] = jArr2[i2 + i6 + 2];
                }
                i5 = i6 + 3;
            }
        }
    }

    static int binarySearch(int[] iArr, int i, int i2) {
        int i3;
        int i4 = i - 1;
        int i5 = 0;
        int i6 = i4;
        while (true) {
            if (i5 > i6) {
                i3 = i5 ^ (-1);
                break;
            }
            int i7 = (i5 + i6) >>> 1;
            int i8 = (iArr[i7] >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK;
            if (i8 >= i2) {
                i3 = i7;
                if (i8 <= i2) {
                    break;
                }
                i6 = i7 - 1;
            } else {
                i5 = i7 + 1;
            }
        }
        return i3;
    }

    private void buildTimePeriodStartClockStr() {
        this.mTimePeriodStartClockStr = DateFormat.format("yyyy-MM-dd-HH-mm-ss", this.mTimePeriodStartClock).toString();
    }

    public static void computeProcessData(ProcessState processState, ProcessDataCollection processDataCollection, long j) {
        processDataCollection.totalTime = 0L;
        processDataCollection.maxUss = 0L;
        processDataCollection.avgUss = 0L;
        processDataCollection.minUss = 0L;
        processDataCollection.maxPss = 0L;
        processDataCollection.avgPss = 0L;
        processDataCollection.minPss = 0L;
        processDataCollection.numPss = 0L;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= processDataCollection.screenStates.length) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < processDataCollection.memStates.length) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < processDataCollection.procStates.length) {
                            int i7 = ((processDataCollection.screenStates[i2] + processDataCollection.memStates[i4]) * 14) + processDataCollection.procStates[i6];
                            processDataCollection.totalTime += processState.getDuration(i7, j);
                            long pssSampleCount = processState.getPssSampleCount(i7);
                            if (pssSampleCount > 0) {
                                long pssMinimum = processState.getPssMinimum(i7);
                                long pssAverage = processState.getPssAverage(i7);
                                long pssMaximum = processState.getPssMaximum(i7);
                                long pssUssMinimum = processState.getPssUssMinimum(i7);
                                long pssUssAverage = processState.getPssUssAverage(i7);
                                long pssUssMaximum = processState.getPssUssMaximum(i7);
                                if (processDataCollection.numPss == 0) {
                                    processDataCollection.minPss = pssMinimum;
                                    processDataCollection.avgPss = pssAverage;
                                    processDataCollection.maxPss = pssMaximum;
                                    processDataCollection.minUss = pssUssMinimum;
                                    processDataCollection.avgUss = pssUssAverage;
                                    processDataCollection.maxUss = pssUssMaximum;
                                } else {
                                    if (pssMinimum < processDataCollection.minPss) {
                                        processDataCollection.minPss = pssMinimum;
                                    }
                                    processDataCollection.avgPss = (long) (((processDataCollection.avgPss * processDataCollection.numPss) + (pssAverage * pssSampleCount)) / (processDataCollection.numPss + pssSampleCount));
                                    if (pssMaximum > processDataCollection.maxPss) {
                                        processDataCollection.maxPss = pssMaximum;
                                    }
                                    if (pssUssMinimum < processDataCollection.minUss) {
                                        processDataCollection.minUss = pssUssMinimum;
                                    }
                                    processDataCollection.avgUss = (long) (((processDataCollection.avgUss * processDataCollection.numPss) + (pssUssAverage * pssSampleCount)) / (processDataCollection.numPss + pssSampleCount));
                                    if (pssUssMaximum > processDataCollection.maxUss) {
                                        processDataCollection.maxUss = pssUssMaximum;
                                    }
                                }
                                processDataCollection.numPss += pssSampleCount;
                            }
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    static long computeProcessTimeLocked(ProcessState processState, int[] iArr, int[] iArr2, int[] iArr3, long j) {
        long j2 = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                processState.mTmpTotalTime = j2;
                return j2;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < iArr2.length) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < iArr3.length) {
                            j2 += processState.getDuration(((iArr[i2] + iArr2[i4]) * 14) + iArr3[i6], j);
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    static void dumpAdjTimesCheckin(PrintWriter printWriter, String str, long[] jArr, int i, long j, long j2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 8) {
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < 4) {
                    int i6 = i5 + i3;
                    long j3 = jArr[i6];
                    long j4 = j3;
                    if (i == i6) {
                        j4 = j3 + (j2 - j);
                    }
                    if (j4 != 0) {
                        printAdjTagAndValue(printWriter, i6, j4);
                    }
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 4;
        }
    }

    static void dumpAllProcessPssCheckin(PrintWriter printWriter, ProcessState processState) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= processState.mPssTableSize) {
                return;
            }
            int i3 = processState.mPssTable[i2];
            int i4 = OFFSET_TYPE_SHIFT;
            int i5 = OFFSET_TYPE_MASK;
            long j = processState.mStats.getLong(i3, 0);
            long j2 = processState.mStats.getLong(i3, 1);
            long j3 = processState.mStats.getLong(i3, 2);
            long j4 = processState.mStats.getLong(i3, 3);
            long j5 = processState.mStats.getLong(i3, 4);
            long j6 = processState.mStats.getLong(i3, 5);
            long j7 = processState.mStats.getLong(i3, 6);
            printWriter.print(',');
            printProcStateTag(printWriter, (i3 >> i4) & i5);
            printWriter.print(':');
            printWriter.print(j);
            printWriter.print(':');
            printWriter.print(j2);
            printWriter.print(':');
            printWriter.print(j3);
            printWriter.print(':');
            printWriter.print(j4);
            printWriter.print(':');
            printWriter.print(j5);
            printWriter.print(':');
            printWriter.print(j6);
            printWriter.print(':');
            printWriter.print(j7);
            i = i2 + 1;
        }
    }

    static void dumpAllProcessStateCheckin(PrintWriter printWriter, ProcessState processState, long j) {
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= processState.mDurationsTableSize) {
                break;
            }
            int i3 = processState.mDurationsTable[i2];
            int i4 = (i3 >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK;
            long j2 = processState.mStats.getLong(i3, 0);
            long j3 = j2;
            if (processState.mCurState == i4) {
                z = true;
                j3 = j2 + (j - processState.mStartTime);
            }
            printProcStateTagAndValue(printWriter, i4, j3);
            i = i2 + 1;
        }
        if (z || processState.mCurState == -1) {
            return;
        }
        printProcStateTagAndValue(printWriter, processState.mCurState, j - processState.mStartTime);
    }

    private void dumpProcessInternalLocked(PrintWriter printWriter, String str, ProcessState processState, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("myID=");
            printWriter.print(Integer.toHexString(System.identityHashCode(processState)));
            printWriter.print(" mCommonProcess=");
            printWriter.print(Integer.toHexString(System.identityHashCode(processState.mCommonProcess)));
            printWriter.print(" mPackage=");
            printWriter.println(processState.mPackage);
            if (processState.mMultiPackage) {
                printWriter.print(str);
                printWriter.print("mMultiPackage=");
                printWriter.println(processState.mMultiPackage);
            }
            if (processState != processState.mCommonProcess) {
                printWriter.print(str);
                printWriter.print("Common Proc: ");
                printWriter.print(processState.mCommonProcess.mName);
                printWriter.print(BridgeUtil.SPLIT_MARK);
                printWriter.print(processState.mCommonProcess.mUid);
                printWriter.print(" pkg=");
                printWriter.println(processState.mCommonProcess.mPackage);
            }
        }
        if (processState.mActive) {
            printWriter.print(str);
            printWriter.print("mActive=");
            printWriter.println(processState.mActive);
        }
        if (processState.mDead) {
            printWriter.print(str);
            printWriter.print("mDead=");
            printWriter.println(processState.mDead);
        }
        if (processState.mNumActiveServices == 0 && processState.mNumStartedServices == 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("mNumActiveServices=");
        printWriter.print(processState.mNumActiveServices);
        printWriter.print(" mNumStartedServices=");
        printWriter.println(processState.mNumStartedServices);
    }

    static void dumpProcessList(PrintWriter printWriter, String str, ArrayList<ProcessState> arrayList, int[] iArr, int[] iArr2, int[] iArr3, long j) {
        String str2 = str + "  ";
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            ProcessState processState = arrayList.get(i);
            printWriter.print(str);
            printWriter.print(processState.mName);
            printWriter.print(" / ");
            UserHandle.formatUid(printWriter, processState.mUid);
            printWriter.print(" (");
            printWriter.print(processState.mDurationsTableSize);
            printWriter.print(" entries)");
            printWriter.println(":");
            dumpProcessState(printWriter, str2, processState, iArr, iArr2, iArr3, j);
            if (processState.mPssTableSize > 0) {
                dumpProcessPss(printWriter, str2, processState, iArr, iArr2, iArr3);
            }
            size = i;
        }
    }

    public static void dumpProcessListCsv(PrintWriter printWriter, ArrayList<ProcessState> arrayList, boolean z, int[] iArr, boolean z2, int[] iArr2, boolean z3, int[] iArr3, long j) {
        printWriter.print(UMModuleRegister.PROCESS);
        printWriter.print(CSV_SEP);
        printWriter.print("uid");
        printWriter.print(CSV_SEP);
        printWriter.print("vers");
        dumpStateHeadersCsv(printWriter, CSV_SEP, z ? iArr : null, z2 ? iArr2 : null, z3 ? iArr3 : null);
        printWriter.println();
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            ProcessState processState = arrayList.get(i);
            printWriter.print(processState.mName);
            printWriter.print(CSV_SEP);
            UserHandle.formatUid(printWriter, processState.mUid);
            printWriter.print(CSV_SEP);
            printWriter.print(processState.mVersion);
            dumpProcessStateCsv(printWriter, processState, z, iArr, z2, iArr2, z3, iArr3, j);
            printWriter.println();
            size = i;
        }
    }

    static void dumpProcessPss(PrintWriter printWriter, String str, ProcessState processState, int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z = false;
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                break;
            }
            int i4 = -1;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < iArr2.length) {
                    int i7 = 0;
                    while (i7 < iArr3.length) {
                        int i8 = iArr[i3];
                        int i9 = iArr2[i6];
                        int i10 = ((i8 + i9) * 14) + iArr3[i7];
                        long pssSampleCount = processState.getPssSampleCount(i10);
                        boolean z2 = z;
                        int i11 = i4;
                        int i12 = i;
                        if (pssSampleCount > 0) {
                            z2 = z;
                            if (!z) {
                                printWriter.print(str);
                                printWriter.print("PSS/USS (");
                                printWriter.print(processState.mPssTableSize);
                                printWriter.println(" entries):");
                                z2 = true;
                            }
                            printWriter.print(str);
                            printWriter.print("  ");
                            int i13 = i;
                            if (iArr.length > 1) {
                                printScreenLabel(printWriter, i != i8 ? i8 : -1);
                                i13 = i8;
                            }
                            int i14 = i4;
                            if (iArr2.length > 1) {
                                printMemLabel(printWriter, i4 != i9 ? i9 : -1, '/');
                                i14 = i9;
                            }
                            printWriter.print(STATE_NAMES[iArr3[i7]]);
                            printWriter.print(": ");
                            printWriter.print(pssSampleCount);
                            printWriter.print(" samples ");
                            printSizeValue(printWriter, processState.getPssMinimum(i10) * 1024);
                            printWriter.print(" ");
                            printSizeValue(printWriter, processState.getPssAverage(i10) * 1024);
                            printWriter.print(" ");
                            printSizeValue(printWriter, processState.getPssMaximum(i10) * 1024);
                            printWriter.print(" / ");
                            printSizeValue(printWriter, processState.getPssUssMinimum(i10) * 1024);
                            printWriter.print(" ");
                            printSizeValue(printWriter, processState.getPssUssAverage(i10) * 1024);
                            printWriter.print(" ");
                            printSizeValue(printWriter, processState.getPssUssMaximum(i10) * 1024);
                            printWriter.println();
                            i12 = i13;
                            i11 = i14;
                        }
                        i7++;
                        z = z2;
                        i4 = i11;
                        i = i12;
                    }
                    i5 = i6 + 1;
                }
            }
            i2 = i3 + 1;
        }
        if (processState.mNumExcessiveWake != 0) {
            printWriter.print(str);
            printWriter.print("Killed for excessive wake locks: ");
            printWriter.print(processState.mNumExcessiveWake);
            printWriter.println(" times");
        }
        if (processState.mNumExcessiveCpu != 0) {
            printWriter.print(str);
            printWriter.print("Killed for excessive CPU use: ");
            printWriter.print(processState.mNumExcessiveCpu);
            printWriter.println(" times");
        }
        if (processState.mNumCachedKill != 0) {
            printWriter.print(str);
            printWriter.print("Killed from cached state: ");
            printWriter.print(processState.mNumCachedKill);
            printWriter.print(" times from pss ");
            printSizeValue(printWriter, processState.mMinCachedKillPss * 1024);
            printWriter.print("-");
            printSizeValue(printWriter, processState.mAvgCachedKillPss * 1024);
            printWriter.print("-");
            printSizeValue(printWriter, processState.mMaxCachedKillPss * 1024);
            printWriter.println();
        }
    }

    static void dumpProcessState(PrintWriter printWriter, String str, ProcessState processState, int[] iArr, int[] iArr2, int[] iArr3, long j) {
        long j2 = 0;
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                break;
            }
            int i4 = -1;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < iArr2.length) {
                    int i7 = 0;
                    while (i7 < iArr3.length) {
                        int i8 = iArr[i3];
                        int i9 = iArr2[i6];
                        int i10 = ((i8 + i9) * 14) + iArr3[i7];
                        long duration = processState.getDuration(i10, j);
                        String str2 = processState.mCurState == i10 ? " (running)" : "";
                        int i11 = i4;
                        int i12 = i;
                        long j3 = j2;
                        if (duration != 0) {
                            printWriter.print(str);
                            i12 = i;
                            if (iArr.length > 1) {
                                printScreenLabel(printWriter, i != i8 ? i8 : -1);
                                i12 = i8;
                            }
                            int i13 = i4;
                            if (iArr2.length > 1) {
                                printMemLabel(printWriter, i4 != i9 ? i9 : -1, '/');
                                i13 = i9;
                            }
                            printWriter.print(STATE_NAMES[iArr3[i7]]);
                            printWriter.print(": ");
                            TimeUtils.formatDuration(duration, printWriter);
                            printWriter.println(str2);
                            j3 = j2 + duration;
                            i11 = i13;
                        }
                        i7++;
                        i4 = i11;
                        i = i12;
                        j2 = j3;
                    }
                    i5 = i6 + 1;
                }
            }
            i2 = i3 + 1;
        }
        if (j2 != 0) {
            printWriter.print(str);
            if (iArr.length > 1) {
                printScreenLabel(printWriter, -1);
            }
            if (iArr2.length > 1) {
                printMemLabel(printWriter, -1, '/');
            }
            printWriter.print("TOTAL  : ");
            TimeUtils.formatDuration(j2, printWriter);
            printWriter.println();
        }
    }

    static void dumpProcessStateCsv(PrintWriter printWriter, ProcessState processState, boolean z, int[] iArr, boolean z2, int[] iArr2, boolean z3, int[] iArr3, long j) {
        int length = z ? iArr.length : 1;
        int length2 = z2 ? iArr2.length : 1;
        int length3 = z3 ? iArr3.length : 1;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < length3) {
                            int i7 = z ? iArr[i2] : 0;
                            int i8 = z2 ? iArr2[i4] : 0;
                            int i9 = z3 ? iArr3[i6] : 0;
                            int length4 = z ? 1 : iArr.length;
                            int length5 = z2 ? 1 : iArr2.length;
                            int length6 = z3 ? 1 : iArr3.length;
                            long j2 = 0;
                            int i10 = 0;
                            while (true) {
                                int i11 = i10;
                                if (i11 < length4) {
                                    int i12 = 0;
                                    while (true) {
                                        int i13 = i12;
                                        if (i13 < length5) {
                                            int i14 = 0;
                                            while (true) {
                                                int i15 = i14;
                                                if (i15 < length6) {
                                                    j2 += processState.getDuration(((i7 + (z ? 0 : iArr[i11]) + i8 + (z2 ? 0 : iArr2[i13])) * 14) + i9 + (z3 ? 0 : iArr3[i15]), j);
                                                    i14 = i15 + 1;
                                                }
                                            }
                                            i12 = i13 + 1;
                                        }
                                    }
                                    i10 = i11 + 1;
                                }
                            }
                            printWriter.print(CSV_SEP);
                            printWriter.print(j2);
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    static void dumpProcessSummaryDetails(PrintWriter printWriter, ProcessState processState, String str, String str2, int[] iArr, int[] iArr2, int[] iArr3, long j, long j2, boolean z) {
        ProcessDataCollection processDataCollection = new ProcessDataCollection(iArr, iArr2, iArr3);
        computeProcessData(processState, processDataCollection, j);
        if ((processDataCollection.totalTime / j2) * 100.0d >= 0.005d || processDataCollection.numPss != 0) {
            if (str != null) {
                printWriter.print(str);
            }
            if (str2 != null) {
                printWriter.print(str2);
            }
            processDataCollection.print(printWriter, j2, z);
            if (str != null) {
                printWriter.println();
            }
        }
    }

    static void dumpProcessSummaryLocked(PrintWriter printWriter, String str, ArrayList<ProcessState> arrayList, int[] iArr, int[] iArr2, int[] iArr3, boolean z, long j, long j2) {
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            ProcessState processState = arrayList.get(i);
            printWriter.print(str);
            printWriter.print("* ");
            printWriter.print(processState.mName);
            printWriter.print(" / ");
            UserHandle.formatUid(printWriter, processState.mUid);
            printWriter.print(" / v");
            printWriter.print(processState.mVersion);
            printWriter.println(":");
            dumpProcessSummaryDetails(printWriter, processState, str, "         TOTAL: ", iArr, iArr2, iArr3, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "    Persistent: ", iArr, iArr2, new int[]{0}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "           Top: ", iArr, iArr2, new int[]{1}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "        Imp Fg: ", iArr, iArr2, new int[]{2}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "        Imp Bg: ", iArr, iArr2, new int[]{3}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "        Backup: ", iArr, iArr2, new int[]{4}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "     Heavy Wgt: ", iArr, iArr2, new int[]{5}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "       Service: ", iArr, iArr2, new int[]{6}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "    Service Rs: ", iArr, iArr2, new int[]{7}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "      Receiver: ", iArr, iArr2, new int[]{8}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "        (Home): ", iArr, iArr2, new int[]{9}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "    (Last Act): ", iArr, iArr2, new int[]{10}, j, j2, true);
            dumpProcessSummaryDetails(printWriter, processState, str, "      (Cached): ", iArr, iArr2, new int[]{11, 12, 13}, j, j2, true);
            size = i;
        }
    }

    static void dumpServiceTimeCheckin(PrintWriter printWriter, String str, String str2, int i, int i2, String str3, ServiceState serviceState, int i3, int i4, int i5, long j, long j2) {
        if (i4 <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print(",");
        printWriter.print(str2);
        printWriter.print(",");
        printWriter.print(i);
        printWriter.print(",");
        printWriter.print(i2);
        printWriter.print(",");
        printWriter.print(str3);
        printWriter.print(",");
        printWriter.print(i4);
        boolean z = false;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= serviceState.mDurationsTableSize) {
                break;
            }
            int i8 = serviceState.mDurationsTable[i7];
            int i9 = (i8 >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK;
            int i10 = i9 / 4;
            if (i9 % 4 == i3) {
                long j3 = serviceState.mStats.getLong(i8, 0);
                long j4 = j3;
                if (i5 == i10) {
                    z = true;
                    j4 = j3 + (j2 - j);
                }
                printAdjTagAndValue(printWriter, i10, j4);
            }
            i6 = i7 + 1;
        }
        if (!z && i5 != -1) {
            printAdjTagAndValue(printWriter, i5, j2 - j);
        }
        printWriter.println();
    }

    public static long dumpSingleServiceTime(PrintWriter printWriter, String str, ServiceState serviceState, int i, int i2, long j, long j2) {
        long j3 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 8) {
                break;
            }
            int i6 = -1;
            int i7 = 0;
            while (i7 < 4) {
                int i8 = i7 + i5;
                long duration = serviceState.getDuration(i, i2, j, i8, j2);
                String str2 = "";
                if (i2 == i8) {
                    str2 = "";
                    if (printWriter != null) {
                        str2 = " (running)";
                    }
                }
                int i9 = i6;
                int i10 = i3;
                long j4 = j3;
                if (duration != 0) {
                    i9 = i6;
                    i10 = i3;
                    if (printWriter != null) {
                        printWriter.print(str);
                        printScreenLabel(printWriter, i3 != i5 ? i5 : -1);
                        i10 = i5;
                        printMemLabel(printWriter, i6 != i7 ? i7 : -1, (char) 0);
                        i9 = i7;
                        printWriter.print(": ");
                        TimeUtils.formatDuration(duration, printWriter);
                        printWriter.println(str2);
                    }
                    j4 = j3 + duration;
                }
                i7++;
                i6 = i9;
                i3 = i10;
                j3 = j4;
            }
            i4 = i5 + 4;
        }
        if (j3 != 0 && printWriter != null) {
            printWriter.print(str);
            printWriter.print("    TOTAL: ");
            TimeUtils.formatDuration(j3, printWriter);
            printWriter.println();
        }
        return j3;
    }

    public static long dumpSingleTime(PrintWriter printWriter, String str, long[] jArr, int i, long j, long j2) {
        long j3 = 0;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 8) {
                break;
            }
            int i5 = -1;
            int i6 = 0;
            while (i6 < 4) {
                int i7 = i6 + i4;
                long j4 = jArr[i7];
                String str2 = "";
                long j5 = j4;
                if (i == i7) {
                    long j6 = j4 + (j2 - j);
                    str2 = "";
                    j5 = j6;
                    if (printWriter != null) {
                        str2 = " (running)";
                        j5 = j6;
                    }
                }
                int i8 = i5;
                int i9 = i2;
                long j7 = j3;
                if (j5 != 0) {
                    i8 = i5;
                    i9 = i2;
                    if (printWriter != null) {
                        printWriter.print(str);
                        printScreenLabel(printWriter, i2 != i4 ? i4 : -1);
                        i9 = i4;
                        printMemLabel(printWriter, i5 != i6 ? i6 : -1, (char) 0);
                        i8 = i6;
                        printWriter.print(": ");
                        TimeUtils.formatDuration(j5, printWriter);
                        printWriter.println(str2);
                    }
                    j7 = j3 + j5;
                }
                i6++;
                i5 = i8;
                i2 = i9;
                j3 = j7;
            }
            i3 = i4 + 4;
        }
        if (j3 != 0 && printWriter != null) {
            printWriter.print(str);
            printWriter.print("    TOTAL: ");
            TimeUtils.formatDuration(j3, printWriter);
            printWriter.println();
        }
        return j3;
    }

    static void dumpStateHeadersCsv(PrintWriter printWriter, String str, int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr != null ? iArr.length : 1;
        int length2 = iArr2 != null ? iArr2.length : 1;
        int length3 = iArr3 != null ? iArr3.length : 1;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < length3) {
                            printWriter.print(str);
                            boolean z = false;
                            if (iArr != null) {
                                z = false;
                                if (iArr.length > 1) {
                                    printScreenLabelCsv(printWriter, iArr[i2]);
                                    z = true;
                                }
                            }
                            boolean z2 = z;
                            if (iArr2 != null) {
                                z2 = z;
                                if (iArr2.length > 1) {
                                    if (z) {
                                        printWriter.print("-");
                                    }
                                    printMemLabelCsv(printWriter, iArr2[i4]);
                                    z2 = true;
                                }
                            }
                            if (iArr3 != null && iArr3.length > 1) {
                                if (z2) {
                                    printWriter.print("-");
                                }
                                printWriter.print(STATE_NAMES_CSV[iArr3[i6]]);
                            }
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    static void printAdjTag(PrintWriter printWriter, int i) {
        printArrayEntry(printWriter, ADJ_MEM_TAGS, printArrayEntry(printWriter, ADJ_SCREEN_TAGS, i, 4), 1);
    }

    static void printAdjTagAndValue(PrintWriter printWriter, int i, long j) {
        printWriter.print(',');
        printAdjTag(printWriter, i);
        printWriter.print(':');
        printWriter.print(j);
    }

    static int printArrayEntry(PrintWriter printWriter, String[] strArr, int i, int i2) {
        int i3 = i / i2;
        if (i3 < 0 || i3 >= strArr.length) {
            printWriter.print('?');
        } else {
            printWriter.print(strArr[i3]);
        }
        return i - (i3 * i2);
    }

    static String printLongOffset(int i) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("a");
        sb.append((i >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK);
        sb.append("i");
        sb.append((i >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK);
        sb.append("t");
        sb.append((i >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK);
        return sb.toString();
    }

    private static void printMemLabel(PrintWriter printWriter, int i, char c2) {
        switch (i) {
            case -1:
                printWriter.print("    ");
                if (c2 != 0) {
                    printWriter.print(' ');
                    return;
                }
                return;
            case 0:
                printWriter.print("Norm");
                if (c2 != 0) {
                    printWriter.print(c2);
                    return;
                }
                return;
            case 1:
                printWriter.print("Mod ");
                if (c2 != 0) {
                    printWriter.print(c2);
                    return;
                }
                return;
            case 2:
                printWriter.print("Low ");
                if (c2 != 0) {
                    printWriter.print(c2);
                    return;
                }
                return;
            case 3:
                printWriter.print("Crit");
                if (c2 != 0) {
                    printWriter.print(c2);
                    return;
                }
                return;
            default:
                printWriter.print("????");
                if (c2 != 0) {
                    printWriter.print(c2);
                    return;
                }
                return;
        }
    }

    public static void printMemLabelCsv(PrintWriter printWriter, int i) {
        if (i >= 0) {
            if (i <= 3) {
                printWriter.print(ADJ_MEM_NAMES_CSV[i]);
            } else {
                printWriter.print("???");
            }
        }
    }

    static void printPercent(PrintWriter printWriter, double d) {
        double d2 = d * 100.0d;
        if (d2 < 1.0d) {
            printWriter.print(String.format("%.2f", Double.valueOf(d2)));
        } else if (d2 < 10.0d) {
            printWriter.print(String.format("%.1f", Double.valueOf(d2)));
        } else {
            printWriter.print(String.format("%.0f", Double.valueOf(d2)));
        }
        printWriter.print("%");
    }

    static void printProcStateTag(PrintWriter printWriter, int i) {
        printArrayEntry(printWriter, STATE_TAGS, printArrayEntry(printWriter, ADJ_MEM_TAGS, printArrayEntry(printWriter, ADJ_SCREEN_TAGS, i, 56), 14), 1);
    }

    static void printProcStateTagAndValue(PrintWriter printWriter, int i, long j) {
        printWriter.print(',');
        printProcStateTag(printWriter, i);
        printWriter.print(':');
        printWriter.print(j);
    }

    private static void printScreenLabel(PrintWriter printWriter, int i) {
        switch (i) {
            case -1:
                printWriter.print("     ");
                return;
            case 0:
                printWriter.print("SOff/");
                return;
            case 1:
            case 2:
            case 3:
            default:
                printWriter.print("????/");
                return;
            case 4:
                printWriter.print("SOn /");
                return;
        }
    }

    public static void printScreenLabelCsv(PrintWriter printWriter, int i) {
        switch (i) {
            case -1:
                return;
            case 0:
                printWriter.print(ADJ_SCREEN_NAMES_CSV[0]);
                return;
            case 1:
            case 2:
            case 3:
            default:
                printWriter.print("???");
                return;
            case 4:
                printWriter.print(ADJ_SCREEN_NAMES_CSV[1]);
                return;
        }
    }

    static void printSizeValue(PrintWriter printWriter, long j) {
        float f = (float) j;
        String str = "";
        float f2 = f;
        if (f > 900.0f) {
            str = "KB";
            f2 = f / 1024.0f;
        }
        float f3 = f2;
        if (f2 > 900.0f) {
            str = "MB";
            f3 = f2 / 1024.0f;
        }
        float f4 = f3;
        if (f3 > 900.0f) {
            str = "GB";
            f4 = f3 / 1024.0f;
        }
        float f5 = f4;
        if (f4 > 900.0f) {
            str = "TB";
            f5 = f4 / 1024.0f;
        }
        float f6 = f5;
        String str2 = str;
        if (f5 > 900.0f) {
            str2 = "PB";
            f6 = f5 / 1024.0f;
        }
        printWriter.print(f6 < 1.0f ? String.format("%.2f", Float.valueOf(f6)) : f6 < 10.0f ? String.format("%.1f", Float.valueOf(f6)) : f6 < 100.0f ? String.format("%.0f", Float.valueOf(f6)) : String.format("%.0f", Float.valueOf(f6)));
        printWriter.print(str2);
    }

    private boolean readCheckedInt(Parcel parcel, int i, String str) {
        int readInt = parcel.readInt();
        if (readInt != i) {
            this.mReadError = "bad " + str + ": " + readInt;
            return false;
        }
        return true;
    }

    private String readCommonString(Parcel parcel, int i) {
        if (i <= 9) {
            return parcel.readString();
        }
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            return this.mIndexToCommonString.get(readInt);
        }
        int i2 = readInt ^ (-1);
        String readString = parcel.readString();
        while (this.mIndexToCommonString.size() <= i2) {
            this.mIndexToCommonString.add(null);
        }
        this.mIndexToCommonString.set(i2, readString);
        return readString;
    }

    private void readCompactedLongArray(Parcel parcel, int i, long[] jArr, int i2) {
        int i3;
        int i4;
        if (i <= 10) {
            parcel.readLongArray(jArr);
            return;
        }
        int length = jArr.length;
        if (i2 > length) {
            throw new RuntimeException("bad array lengths: got " + i2 + " array is " + length);
        }
        int i5 = 0;
        while (true) {
            i3 = i5;
            if (i3 >= i2) {
                break;
            }
            int readInt = parcel.readInt();
            if (readInt >= 0) {
                jArr[i3] = readInt;
            } else {
                jArr[i3] = ((readInt ^ (-1)) << 32) | parcel.readInt();
            }
            i5 = i3 + 1;
        }
        for (i4 = i3; i4 < length; i4++) {
            jArr[i4] = 0;
        }
    }

    static byte[] readFully(InputStream inputStream, int[] iArr) throws IOException {
        int available = inputStream.available();
        byte[] bArr = new byte[available > 0 ? available + 1 : 16384];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (read < 0) {
                iArr[0] = i;
                return bArr;
            }
            int i2 = i + read;
            i = i2;
            if (i2 >= bArr.length) {
                byte[] bArr2 = new byte[i2 + 16384];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                bArr = bArr2;
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] readTableFromParcel(Parcel parcel, String str, String str2) {
        int[] iArr;
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            if (readInt != 0) {
                int[] iArr2 = new int[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    iArr = iArr2;
                    if (i2 >= readInt) {
                        break;
                    }
                    iArr2[i2] = parcel.readInt();
                    if (!validateLongOffset(iArr2[i2])) {
                        Slog.w(TAG, "Ignoring existing stats; bad " + str2 + " table entry: " + printLongOffset(iArr2[i2]));
                        return null;
                    }
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        } else {
            Slog.w(TAG, "Ignoring existing stats; bad " + str2 + " table size: " + readInt);
            iArr = BAD_TABLE;
        }
        return iArr;
    }

    private void resetCommon() {
        this.mTimePeriodStartClock = System.currentTimeMillis();
        buildTimePeriodStartClockStr();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mTimePeriodEndRealtime = elapsedRealtime;
        this.mTimePeriodStartRealtime = elapsedRealtime;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mTimePeriodEndUptime = uptimeMillis;
        this.mTimePeriodStartUptime = uptimeMillis;
        this.mLongs.clear();
        this.mLongs.add(new long[4096]);
        this.mNextLong = 0;
        Arrays.fill(this.mMemFactorDurations, 0L);
        this.mSysMemUsageTable = null;
        this.mSysMemUsageTableSize = 0;
        this.mStartTime = 0L;
        this.mReadError = null;
        this.mFlags = 0;
        evaluateSystemProperties(true);
    }

    private void writeCommonString(Parcel parcel, String str) {
        Integer num = this.mCommonStringToIndex.get(str);
        if (num != null) {
            parcel.writeInt(num.intValue());
            return;
        }
        Integer valueOf = Integer.valueOf(this.mCommonStringToIndex.size());
        this.mCommonStringToIndex.put(str, valueOf);
        parcel.writeInt(valueOf.intValue() ^ (-1));
        parcel.writeString(str);
    }

    private void writeCompactedLongArray(Parcel parcel, long[] jArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            long j = jArr[i3];
            long j2 = j;
            if (j < 0) {
                Slog.w(TAG, "Time val negative: " + j);
                j2 = 0;
            }
            if (j2 <= 2147483647L) {
                parcel.writeInt((int) j2);
            } else {
                parcel.writeInt(((int) ((j2 >> 32) & 2147483647L)) ^ (-1));
                parcel.writeInt((int) (268435455 & j2));
            }
            i2 = i3 + 1;
        }
    }

    public void add(ProcessStats processStats) {
        ArrayMap<String, SparseArray<SparseArray<PackageState>>> map = processStats.mPackages.getMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= map.size()) {
                break;
            }
            String keyAt = map.keyAt(i2);
            SparseArray<SparseArray<PackageState>> valueAt = map.valueAt(i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < valueAt.size()) {
                    int keyAt2 = valueAt.keyAt(i4);
                    SparseArray<PackageState> valueAt2 = valueAt.valueAt(i4);
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < valueAt2.size()) {
                            int keyAt3 = valueAt2.keyAt(i6);
                            PackageState valueAt3 = valueAt2.valueAt(i6);
                            int size = valueAt3.mProcesses.size();
                            int size2 = valueAt3.mServices.size();
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= size) {
                                    break;
                                }
                                ProcessState valueAt4 = valueAt3.mProcesses.valueAt(i8);
                                if (valueAt4.mCommonProcess != valueAt4) {
                                    ProcessState processStateLocked = getProcessStateLocked(keyAt, keyAt2, keyAt3, valueAt4.mName);
                                    ProcessState processState = processStateLocked;
                                    if (processStateLocked.mCommonProcess == processStateLocked) {
                                        processStateLocked.mMultiPackage = true;
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        PackageState packageStateLocked = getPackageStateLocked(keyAt, keyAt2, keyAt3);
                                        processState = processStateLocked.clone(processStateLocked.mPackage, uptimeMillis);
                                        packageStateLocked.mProcesses.put(processState.mName, processState);
                                    }
                                    processState.add(valueAt4);
                                }
                                i7 = i8 + 1;
                            }
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                if (i10 < size2) {
                                    ServiceState valueAt5 = valueAt3.mServices.valueAt(i10);
                                    getServiceStateLocked(keyAt, keyAt2, keyAt3, valueAt5.mProcessName, valueAt5.mName).add(valueAt5);
                                    i9 = i10 + 1;
                                }
                            }
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        ArrayMap<String, SparseArray<ProcessState>> map2 = processStats.mProcesses.getMap();
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= map2.size()) {
                break;
            }
            SparseArray<ProcessState> valueAt6 = map2.valueAt(i12);
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 < valueAt6.size()) {
                    int keyAt4 = valueAt6.keyAt(i14);
                    ProcessState valueAt7 = valueAt6.valueAt(i14);
                    ProcessState processState2 = this.mProcesses.get(valueAt7.mName, keyAt4);
                    ProcessState processState3 = processState2;
                    if (processState2 == null) {
                        ProcessState processState4 = new ProcessState(this, valueAt7.mPackage, keyAt4, valueAt7.mVersion, valueAt7.mName);
                        this.mProcesses.put(valueAt7.mName, keyAt4, processState4);
                        PackageState packageStateLocked2 = getPackageStateLocked(valueAt7.mPackage, keyAt4, valueAt7.mVersion);
                        processState3 = processState4;
                        if (!packageStateLocked2.mProcesses.containsKey(valueAt7.mName)) {
                            packageStateLocked2.mProcesses.put(valueAt7.mName, processState4);
                            processState3 = processState4;
                        }
                    }
                    processState3.add(valueAt7);
                    i13 = i14 + 1;
                }
            }
            i11 = i12 + 1;
        }
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= 8) {
                break;
            }
            long[] jArr = this.mMemFactorDurations;
            jArr[i16] = jArr[i16] + processStats.mMemFactorDurations[i16];
            i15 = i16 + 1;
        }
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= processStats.mSysMemUsageTableSize) {
                break;
            }
            int i19 = processStats.mSysMemUsageTable[i18];
            addSysMemUsage((i19 >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK, processStats.mLongs.get((i19 >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK), (i19 >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK);
            i17 = i18 + 1;
        }
        if (processStats.mTimePeriodStartClock < this.mTimePeriodStartClock) {
            this.mTimePeriodStartClock = processStats.mTimePeriodStartClock;
            this.mTimePeriodStartClockStr = processStats.mTimePeriodStartClockStr;
        }
        this.mTimePeriodEndRealtime += processStats.mTimePeriodEndRealtime - processStats.mTimePeriodStartRealtime;
        this.mTimePeriodEndUptime += processStats.mTimePeriodEndUptime - processStats.mTimePeriodStartUptime;
    }

    int addLongData(int i, int i2, int i3) {
        int allocLongData = allocLongData(i3);
        this.mAddLongTable = GrowingArrayUtils.insert(this.mAddLongTable != null ? this.mAddLongTable : EmptyArray.INT, this.mAddLongTableSize, i, i2 | allocLongData);
        this.mAddLongTableSize++;
        return allocLongData;
    }

    void addSysMemUsage(int i, long[] jArr, int i2) {
        int addLongData;
        int binarySearch = binarySearch(this.mSysMemUsageTable, this.mSysMemUsageTableSize, i);
        if (binarySearch >= 0) {
            addLongData = this.mSysMemUsageTable[binarySearch];
        } else {
            this.mAddLongTable = this.mSysMemUsageTable;
            this.mAddLongTableSize = this.mSysMemUsageTableSize;
            addLongData = addLongData(binarySearch ^ (-1), i, 16);
            this.mSysMemUsageTable = this.mAddLongTable;
            this.mSysMemUsageTableSize = this.mAddLongTableSize;
        }
        addSysMemUsage(this.mLongs.get((addLongData >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK), (addLongData >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK, jArr, i2);
    }

    public void addSysMemUsage(long j, long j2, long j3, long j4, long j5) {
        if (this.mMemFactor == -1) {
            return;
        }
        int i = this.mMemFactor;
        this.mSysMemUsageArgs[0] = 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 3) {
                addSysMemUsage(i * 14, this.mSysMemUsageArgs, 0);
                return;
            }
            this.mSysMemUsageArgs[i3 + 1] = j;
            this.mSysMemUsageArgs[i3 + 4] = j2;
            this.mSysMemUsageArgs[i3 + 7] = j3;
            this.mSysMemUsageArgs[i3 + 10] = j4;
            this.mSysMemUsageArgs[i3 + 13] = j5;
            i2 = i3 + 1;
        }
    }

    int allocLongData(int i) {
        int size = this.mLongs.size() - 1;
        int i2 = size;
        if (this.mNextLong + i > this.mLongs.get(size).length) {
            this.mLongs.add(new long[4096]);
            i2 = size + 1;
            this.mNextLong = 0;
        }
        int i3 = OFFSET_ARRAY_SHIFT;
        int i4 = this.mNextLong;
        int i5 = OFFSET_INDEX_SHIFT;
        this.mNextLong += i;
        return (i2 << i3) | (i4 << i5);
    }

    String collapseString(String str, String str2) {
        String str3 = str2;
        if (str2.startsWith(str)) {
            int length = str2.length();
            int length2 = str.length();
            if (length == length2) {
                str3 = "";
            } else {
                str3 = str2;
                if (length >= length2) {
                    str3 = str2;
                    if (str2.charAt(length2) == '.') {
                        return str2.substring(length2);
                    }
                }
            }
        }
        return str3;
    }

    public ArrayList<ProcessState> collectProcessesLocked(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, long j, String str, boolean z) {
        ArraySet arraySet = new ArraySet();
        ArrayMap<String, SparseArray<SparseArray<PackageState>>> map = this.mPackages.getMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= map.size()) {
                break;
            }
            String keyAt = map.keyAt(i2);
            SparseArray<SparseArray<PackageState>> valueAt = map.valueAt(i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < valueAt.size()) {
                    SparseArray<PackageState> valueAt2 = valueAt.valueAt(i4);
                    int size = valueAt2.size();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < size) {
                            PackageState valueAt3 = valueAt2.valueAt(i6);
                            int size2 = valueAt3.mProcesses.size();
                            boolean z2 = str == null || str.equals(keyAt);
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 < size2) {
                                    ProcessState valueAt4 = valueAt3.mProcesses.valueAt(i8);
                                    if ((z2 || str.equals(valueAt4.mName)) && (!z || valueAt4.isInUse())) {
                                        arraySet.add(valueAt4.mCommonProcess);
                                    }
                                    i7 = i8 + 1;
                                }
                            }
                            i5 = i6 + 1;
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        ArrayList<ProcessState> arrayList = new ArrayList<>(arraySet.size());
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= arraySet.size()) {
                Collections.sort(arrayList, new Comparator<ProcessState>() { // from class: com.android.internal.app.ProcessStats.2
                    @Override // java.util.Comparator
                    public int compare(ProcessState processState, ProcessState processState2) {
                        if (processState.mTmpTotalTime < processState2.mTmpTotalTime) {
                            return -1;
                        }
                        return processState.mTmpTotalTime > processState2.mTmpTotalTime ? 1 : 0;
                    }
                });
                return arrayList;
            }
            ProcessState processState = (ProcessState) arraySet.valueAt(i10);
            if (computeProcessTimeLocked(processState, iArr, iArr2, iArr3, j) > 0) {
                arrayList.add(processState);
                if (iArr3 != iArr4) {
                    computeProcessTimeLocked(processState, iArr, iArr2, iArr4, j);
                }
            }
            i9 = i10 + 1;
        }
    }

    public void computeTotalMemoryUse(TotalMemoryUseCollection totalMemoryUseCollection, long j) {
        long j2;
        int[] iArr;
        totalMemoryUseCollection.totalTime = 0L;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 14) {
                break;
            }
            totalMemoryUseCollection.processStateWeight[i2] = 0.0d;
            totalMemoryUseCollection.processStatePss[i2] = 0;
            totalMemoryUseCollection.processStateTime[i2] = 0;
            totalMemoryUseCollection.processStateSamples[i2] = 0;
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 16) {
                break;
            }
            totalMemoryUseCollection.sysMemUsage[i4] = 0;
            i3 = i4 + 1;
        }
        totalMemoryUseCollection.sysMemCachedWeight = 0.0d;
        totalMemoryUseCollection.sysMemFreeWeight = 0.0d;
        totalMemoryUseCollection.sysMemZRamWeight = 0.0d;
        totalMemoryUseCollection.sysMemKernelWeight = 0.0d;
        totalMemoryUseCollection.sysMemNativeWeight = 0.0d;
        totalMemoryUseCollection.sysMemSamples = 0;
        long[] jArr = new long[16];
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.mSysMemUsageTableSize) {
                break;
            }
            int i7 = this.mSysMemUsageTable[i6];
            addSysMemUsage(jArr, 0, this.mLongs.get((i7 >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK), (i7 >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK);
            i5 = i6 + 1;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= totalMemoryUseCollection.screenStates.length) {
                break;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 < totalMemoryUseCollection.memStates.length) {
                    int i12 = totalMemoryUseCollection.screenStates[i9] + totalMemoryUseCollection.memStates[i11];
                    long j3 = this.mMemFactorDurations[i12];
                    long j4 = j3;
                    if (this.mMemFactor == i12) {
                        j4 = j3 + (j - this.mStartTime);
                    }
                    totalMemoryUseCollection.totalTime += j4;
                    int binarySearch = binarySearch(this.mSysMemUsageTable, this.mSysMemUsageTableSize, i12 * 14);
                    int i13 = 0;
                    long[] jArr2 = jArr;
                    if (binarySearch >= 0) {
                        int i14 = this.mSysMemUsageTable[binarySearch];
                        long[] jArr3 = this.mLongs.get((i14 >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK);
                        int i15 = (i14 >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK;
                        i13 = 0;
                        jArr2 = jArr;
                        if (jArr3[i15 + 0] >= 3) {
                            addSysMemUsage(totalMemoryUseCollection.sysMemUsage, 0, jArr, 0);
                            jArr2 = jArr3;
                            i13 = i15;
                        }
                    }
                    totalMemoryUseCollection.sysMemCachedWeight += jArr2[i13 + 2] * j4;
                    totalMemoryUseCollection.sysMemFreeWeight += jArr2[i13 + 5] * j4;
                    totalMemoryUseCollection.sysMemZRamWeight += jArr2[i13 + 8] * j4;
                    totalMemoryUseCollection.sysMemKernelWeight += jArr2[i13 + 11] * j4;
                    totalMemoryUseCollection.sysMemNativeWeight += jArr2[i13 + 14] * j4;
                    totalMemoryUseCollection.sysMemSamples = (int) (totalMemoryUseCollection.sysMemSamples + jArr2[i13 + 0]);
                    i10 = i11 + 1;
                }
            }
            i8 = i9 + 1;
        }
        ArrayMap<String, SparseArray<ProcessState>> map = this.mProcesses.getMap();
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= map.size()) {
                return;
            }
            SparseArray<ProcessState> valueAt = map.valueAt(i17);
            int i18 = 0;
            while (true) {
                int i19 = i18;
                if (i19 < valueAt.size()) {
                    ProcessState valueAt2 = valueAt.valueAt(i19);
                    PssAggr pssAggr = new PssAggr();
                    PssAggr pssAggr2 = new PssAggr();
                    PssAggr pssAggr3 = new PssAggr();
                    boolean z = false;
                    int i20 = 0;
                    while (true) {
                        int i21 = i20;
                        if (i21 >= valueAt2.mDurationsTableSize) {
                            break;
                        }
                        int i22 = (valueAt2.mDurationsTable[i21] >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK;
                        int i23 = i22 % 14;
                        long pssSampleCount = valueAt2.getPssSampleCount(i22);
                        if (pssSampleCount > 0) {
                            long pssAverage = valueAt2.getPssAverage(i22);
                            z = true;
                            if (i23 <= 2) {
                                pssAggr.add(pssAverage, pssSampleCount);
                            } else if (i23 <= 8) {
                                pssAggr2.add(pssAverage, pssSampleCount);
                            } else {
                                pssAggr3.add(pssAverage, pssSampleCount);
                            }
                        }
                        i20 = i21 + 1;
                    }
                    if (z) {
                        boolean z2 = false;
                        if (pssAggr.samples < 3) {
                            z2 = false;
                            if (pssAggr2.samples > 0) {
                                z2 = true;
                                pssAggr.add(pssAggr2.pss, pssAggr2.samples);
                            }
                        }
                        boolean z3 = false;
                        if (pssAggr.samples < 3) {
                            z3 = false;
                            if (pssAggr3.samples > 0) {
                                z3 = true;
                                pssAggr.add(pssAggr3.pss, pssAggr3.samples);
                            }
                        }
                        boolean z4 = false;
                        if (pssAggr2.samples < 3) {
                            z4 = false;
                            if (pssAggr3.samples > 0) {
                                z4 = true;
                                pssAggr2.add(pssAggr3.pss, pssAggr3.samples);
                            }
                        }
                        if (pssAggr2.samples < 3 && !z2 && pssAggr.samples > 0) {
                            pssAggr2.add(pssAggr.pss, pssAggr.samples);
                        }
                        if (pssAggr3.samples < 3 && !z4 && pssAggr2.samples > 0) {
                            pssAggr3.add(pssAggr2.pss, pssAggr2.samples);
                        }
                        if (pssAggr3.samples < 3 && !z3 && pssAggr.samples > 0) {
                            pssAggr3.add(pssAggr.pss, pssAggr.samples);
                        }
                        int i24 = 0;
                        while (true) {
                            int i25 = i24;
                            if (i25 < valueAt2.mDurationsTableSize) {
                                int i26 = valueAt2.mDurationsTable[i25];
                                int i27 = (i26 >> OFFSET_TYPE_SHIFT) & OFFSET_TYPE_MASK;
                                long j5 = getLong(i26, 0);
                                long j6 = j5;
                                if (valueAt2.mCurState == i27) {
                                    j6 = j5 + (j - valueAt2.mStartTime);
                                }
                                int i28 = i27 % 14;
                                long[] jArr4 = totalMemoryUseCollection.processStateTime;
                                jArr4[i28] = jArr4[i28] + j6;
                                long pssSampleCount2 = valueAt2.getPssSampleCount(i27);
                                if (pssSampleCount2 > 0) {
                                    j2 = valueAt2.getPssAverage(i27);
                                } else if (i28 <= 2) {
                                    pssSampleCount2 = pssAggr.samples;
                                    j2 = pssAggr.pss;
                                } else if (i28 <= 8) {
                                    pssSampleCount2 = pssAggr2.samples;
                                    j2 = pssAggr2.pss;
                                } else {
                                    pssSampleCount2 = pssAggr3.samples;
                                    j2 = pssAggr3.pss;
                                }
                                long j7 = j2;
                                totalMemoryUseCollection.processStatePss[i28] = (long) (((totalMemoryUseCollection.processStatePss[i28] * totalMemoryUseCollection.processStateSamples[i28]) + (j7 * pssSampleCount2)) / (totalMemoryUseCollection.processStateSamples[i28] + pssSampleCount2));
                                totalMemoryUseCollection.processStateSamples[i28] = (int) (iArr[i28] + pssSampleCount2);
                                double[] dArr = totalMemoryUseCollection.processStateWeight;
                                dArr[i28] = dArr[i28] + (j7 * j6);
                                i24 = i25 + 1;
                            }
                        }
                    }
                    i18 = i19 + 1;
                }
            }
            i16 = i17 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dumpCheckinLocked(PrintWriter printWriter, String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        ArrayMap<String, SparseArray<SparseArray<PackageState>>> map = this.mPackages.getMap();
        printWriter.println("vers,5");
        printWriter.print("period,");
        printWriter.print(this.mTimePeriodStartClockStr);
        printWriter.print(",");
        printWriter.print(this.mTimePeriodStartRealtime);
        printWriter.print(",");
        printWriter.print(this.mRunning ? SystemClock.elapsedRealtime() : this.mTimePeriodEndRealtime);
        boolean z = true;
        if ((this.mFlags & 2) != 0) {
            printWriter.print(",shutdown");
            z = false;
        }
        if ((this.mFlags & 4) != 0) {
            printWriter.print(",sysprops");
            z = false;
        }
        if ((this.mFlags & 1) != 0) {
            printWriter.print(",complete");
            z = false;
        }
        if (z) {
            printWriter.print(",partial");
        }
        printWriter.println();
        printWriter.print("config,");
        printWriter.println(this.mRuntime);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= map.size()) {
                break;
            }
            String keyAt = map.keyAt(i2);
            if (str == null || str.equals(keyAt)) {
                SparseArray<SparseArray<PackageState>> valueAt = map.valueAt(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < valueAt.size()) {
                        int keyAt2 = valueAt.keyAt(i4);
                        SparseArray<PackageState> valueAt2 = valueAt.valueAt(i4);
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 < valueAt2.size()) {
                                int keyAt3 = valueAt2.keyAt(i6);
                                PackageState valueAt3 = valueAt2.valueAt(i6);
                                int size = valueAt3.mProcesses.size();
                                int size2 = valueAt3.mServices.size();
                                int i7 = 0;
                                while (true) {
                                    int i8 = i7;
                                    if (i8 >= size) {
                                        break;
                                    }
                                    ProcessState valueAt4 = valueAt3.mProcesses.valueAt(i8);
                                    printWriter.print("pkgproc,");
                                    printWriter.print(keyAt);
                                    printWriter.print(",");
                                    printWriter.print(keyAt2);
                                    printWriter.print(",");
                                    printWriter.print(keyAt3);
                                    printWriter.print(",");
                                    printWriter.print(collapseString(keyAt, valueAt3.mProcesses.keyAt(i8)));
                                    dumpAllProcessStateCheckin(printWriter, valueAt4, uptimeMillis);
                                    printWriter.println();
                                    if (valueAt4.mPssTableSize > 0) {
                                        printWriter.print("pkgpss,");
                                        printWriter.print(keyAt);
                                        printWriter.print(",");
                                        printWriter.print(keyAt2);
                                        printWriter.print(",");
                                        printWriter.print(keyAt3);
                                        printWriter.print(",");
                                        printWriter.print(collapseString(keyAt, valueAt3.mProcesses.keyAt(i8)));
                                        dumpAllProcessPssCheckin(printWriter, valueAt4);
                                        printWriter.println();
                                    }
                                    if (valueAt4.mNumExcessiveWake > 0 || valueAt4.mNumExcessiveCpu > 0 || valueAt4.mNumCachedKill > 0) {
                                        printWriter.print("pkgkills,");
                                        printWriter.print(keyAt);
                                        printWriter.print(",");
                                        printWriter.print(keyAt2);
                                        printWriter.print(",");
                                        printWriter.print(keyAt3);
                                        printWriter.print(",");
                                        printWriter.print(collapseString(keyAt, valueAt3.mProcesses.keyAt(i8)));
                                        printWriter.print(",");
                                        printWriter.print(valueAt4.mNumExcessiveWake);
                                        printWriter.print(",");
                                        printWriter.print(valueAt4.mNumExcessiveCpu);
                                        printWriter.print(",");
                                        printWriter.print(valueAt4.mNumCachedKill);
                                        printWriter.print(",");
                                        printWriter.print(valueAt4.mMinCachedKillPss);
                                        printWriter.print(":");
                                        printWriter.print(valueAt4.mAvgCachedKillPss);
                                        printWriter.print(":");
                                        printWriter.print(valueAt4.mMaxCachedKillPss);
                                        printWriter.println();
                                    }
                                    i7 = i8 + 1;
                                }
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < size2) {
                                        String collapseString = collapseString(keyAt, valueAt3.mServices.keyAt(i10));
                                        ServiceState valueAt5 = valueAt3.mServices.valueAt(i10);
                                        dumpServiceTimeCheckin(printWriter, "pkgsvc-run", keyAt, keyAt2, keyAt3, collapseString, valueAt5, 0, valueAt5.mRunCount, valueAt5.mRunState, valueAt5.mRunStartTime, uptimeMillis);
                                        dumpServiceTimeCheckin(printWriter, "pkgsvc-start", keyAt, keyAt2, keyAt3, collapseString, valueAt5, 1, valueAt5.mStartedCount, valueAt5.mStartedState, valueAt5.mStartedStartTime, uptimeMillis);
                                        dumpServiceTimeCheckin(printWriter, "pkgsvc-bound", keyAt, keyAt2, keyAt3, collapseString, valueAt5, 2, valueAt5.mBoundCount, valueAt5.mBoundState, valueAt5.mBoundStartTime, uptimeMillis);
                                        dumpServiceTimeCheckin(printWriter, "pkgsvc-exec", keyAt, keyAt2, keyAt3, collapseString, valueAt5, 3, valueAt5.mExecCount, valueAt5.mExecState, valueAt5.mExecStartTime, uptimeMillis);
                                        i9 = i10 + 1;
                                    }
                                }
                                i5 = i6 + 1;
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
        ArrayMap<String, SparseArray<ProcessState>> map2 = this.mProcesses.getMap();
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= map2.size()) {
                break;
            }
            String keyAt4 = map2.keyAt(i12);
            SparseArray<ProcessState> valueAt6 = map2.valueAt(i12);
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 < valueAt6.size()) {
                    int keyAt5 = valueAt6.keyAt(i14);
                    ProcessState valueAt7 = valueAt6.valueAt(i14);
                    if (valueAt7.mDurationsTableSize > 0) {
                        printWriter.print("proc,");
                        printWriter.print(keyAt4);
                        printWriter.print(",");
                        printWriter.print(keyAt5);
                        dumpAllProcessStateCheckin(printWriter, valueAt7, uptimeMillis);
                        printWriter.println();
                    }
                    if (valueAt7.mPssTableSize > 0) {
                        printWriter.print("pss,");
                        printWriter.print(keyAt4);
                        printWriter.print(",");
                        printWriter.print(keyAt5);
                        dumpAllProcessPssCheckin(printWriter, valueAt7);
                        printWriter.println();
                    }
                    if (valueAt7.mNumExcessiveWake > 0 || valueAt7.mNumExcessiveCpu > 0 || valueAt7.mNumCachedKill > 0) {
                        printWriter.print("kills,");
                        printWriter.print(keyAt4);
                        printWriter.print(",");
                        printWriter.print(keyAt5);
                        printWriter.print(",");
                        printWriter.print(valueAt7.mNumExcessiveWake);
                        printWriter.print(",");
                        printWriter.print(valueAt7.mNumExcessiveCpu);
                        printWriter.print(",");
                        printWriter.print(valueAt7.mNumCachedKill);
                        printWriter.print(",");
                        printWriter.print(valueAt7.mMinCachedKillPss);
                        printWriter.print(":");
                        printWriter.print(valueAt7.mAvgCachedKillPss);
                        printWriter.print(":");
                        printWriter.print(valueAt7.mMaxCachedKillPss);
                        printWriter.println();
                    }
                    i13 = i14 + 1;
                }
            }
            i11 = i12 + 1;
        }
        printWriter.print("total");
        dumpAdjTimesCheckin(printWriter, ",", this.mMemFactorDurations, this.mMemFactor, this.mStartTime, uptimeMillis);
        printWriter.println();
        if (this.mSysMemUsageTable != null) {
            printWriter.print("sysmemusage");
            int i15 = 0;
            while (true) {
                int i16 = i15;
                if (i16 >= this.mSysMemUsageTableSize) {
                    break;
                }
                int i17 = this.mSysMemUsageTable[i16];
                int i18 = OFFSET_TYPE_SHIFT;
                int i19 = OFFSET_TYPE_MASK;
                printWriter.print(",");
                printProcStateTag(printWriter, (i17 >> i18) & i19);
                int i20 = 0;
                while (true) {
                    int i21 = i20;
                    if (i21 < 16) {
                        if (i21 > 1) {
                            printWriter.print(":");
                        }
                        printWriter.print(getLong(i17, i21));
                        i20 = i21 + 1;
                    }
                }
                i15 = i16 + 1;
            }
        }
        printWriter.println();
        TotalMemoryUseCollection totalMemoryUseCollection = new TotalMemoryUseCollection(ALL_SCREEN_ADJ, ALL_MEM_ADJ);
        computeTotalMemoryUse(totalMemoryUseCollection, uptimeMillis);
        printWriter.print("weights,");
        printWriter.print(totalMemoryUseCollection.totalTime);
        printWriter.print(",");
        printWriter.print(totalMemoryUseCollection.sysMemCachedWeight);
        printWriter.print(":");
        printWriter.print(totalMemoryUseCollection.sysMemSamples);
        printWriter.print(",");
        printWriter.print(totalMemoryUseCollection.sysMemFreeWeight);
        printWriter.print(":");
        printWriter.print(totalMemoryUseCollection.sysMemSamples);
        printWriter.print(",");
        printWriter.print(totalMemoryUseCollection.sysMemZRamWeight);
        printWriter.print(":");
        printWriter.print(totalMemoryUseCollection.sysMemSamples);
        printWriter.print(",");
        printWriter.print(totalMemoryUseCollection.sysMemKernelWeight);
        printWriter.print(":");
        printWriter.print(totalMemoryUseCollection.sysMemSamples);
        printWriter.print(",");
        printWriter.print(totalMemoryUseCollection.sysMemNativeWeight);
        printWriter.print(":");
        printWriter.print(totalMemoryUseCollection.sysMemSamples);
        int i22 = 0;
        while (true) {
            int i23 = i22;
            if (i23 >= 14) {
                printWriter.println();
                return;
            }
            printWriter.print(",");
            printWriter.print(totalMemoryUseCollection.processStateWeight[i23]);
            printWriter.print(":");
            printWriter.print(totalMemoryUseCollection.processStateSamples[i23]);
            i22 = i23 + 1;
        }
    }

    void dumpFilteredSummaryLocked(PrintWriter printWriter, String str, String str2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, long j, long j2, String str3, boolean z) {
        ArrayList<ProcessState> collectProcessesLocked = collectProcessesLocked(iArr, iArr2, iArr3, iArr4, j, str3, z);
        if (collectProcessesLocked.size() > 0) {
            if (str != null) {
                printWriter.println();
                printWriter.println(str);
            }
            dumpProcessSummaryLocked(printWriter, str2, collectProcessesLocked, iArr, iArr2, iArr4, true, j, j2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x013b, code lost:
        if (r0 > 0) goto L139;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dumpLocked(java.io.PrintWriter r19, java.lang.String r20, long r21, boolean r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 1864
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.ProcessStats.dumpLocked(java.io.PrintWriter, java.lang.String, long, boolean, boolean, boolean):void");
    }

    void dumpServiceStats(PrintWriter printWriter, String str, String str2, String str3, String str4, ServiceState serviceState, int i, int i2, int i3, long j, long j2, long j3, boolean z) {
        if (i != 0) {
            if (z) {
                printWriter.print(str);
                printWriter.print(str4);
                printWriter.print(" op count ");
                printWriter.print(i);
                printWriter.println(":");
                dumpSingleServiceTime(printWriter, str2, serviceState, i2, i3, j, j2);
                return;
            }
            long dumpSingleServiceTime = dumpSingleServiceTime(null, null, serviceState, i2, i3, j, j2);
            printWriter.print(str);
            printWriter.print(str3);
            printWriter.print(str4);
            printWriter.print(" count ");
            printWriter.print(i);
            printWriter.print(" / time ");
            printPercent(printWriter, dumpSingleServiceTime / j3);
            printWriter.println();
        }
    }

    public void dumpSummaryLocked(PrintWriter printWriter, String str, long j, boolean z) {
        dumpFilteredSummaryLocked(printWriter, null, "  ", ALL_SCREEN_ADJ, ALL_MEM_ADJ, ALL_PROC_STATES, NON_CACHED_PROC_STATES, j, dumpSingleTime(null, null, this.mMemFactorDurations, this.mMemFactor, this.mStartTime, j), str, z);
        printWriter.println();
        dumpTotalsLocked(printWriter, j);
    }

    void dumpSysMemUsage(PrintWriter printWriter, String str, int[] iArr, int[] iArr2) {
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return;
            }
            int i4 = -1;
            int i5 = 0;
            while (i5 < iArr2.length) {
                int i6 = iArr[i3];
                int i7 = iArr2[i5];
                int i8 = (i6 + i7) * 14;
                long sysMemUsageValue = getSysMemUsageValue(i8, 0);
                int i9 = i4;
                int i10 = i;
                if (sysMemUsageValue > 0) {
                    printWriter.print(str);
                    i10 = i;
                    if (iArr.length > 1) {
                        printScreenLabel(printWriter, i != i6 ? i6 : -1);
                        i10 = i6;
                    }
                    int i11 = i4;
                    if (iArr2.length > 1) {
                        printMemLabel(printWriter, i4 != i7 ? i7 : -1, (char) 0);
                        i11 = i7;
                    }
                    printWriter.print(": ");
                    printWriter.print(sysMemUsageValue);
                    printWriter.println(" samples:");
                    dumpSysMemUsageCategory(printWriter, str, "  Cached", i8, 1);
                    dumpSysMemUsageCategory(printWriter, str, "  Free", i8, 4);
                    dumpSysMemUsageCategory(printWriter, str, "  ZRam", i8, 7);
                    dumpSysMemUsageCategory(printWriter, str, "  Kernel", i8, 10);
                    dumpSysMemUsageCategory(printWriter, str, "  Native", i8, 13);
                    i9 = i11;
                }
                i5++;
                i4 = i9;
                i = i10;
            }
            i2 = i3 + 1;
        }
    }

    void dumpSysMemUsageCategory(PrintWriter printWriter, String str, String str2, int i, int i2) {
        printWriter.print(str);
        printWriter.print(str2);
        printWriter.print(": ");
        printSizeValue(printWriter, getSysMemUsageValue(i, i2) * 1024);
        printWriter.print(" min, ");
        printSizeValue(printWriter, getSysMemUsageValue(i, i2 + 1) * 1024);
        printWriter.print(" avg, ");
        printSizeValue(printWriter, getSysMemUsageValue(i, i2 + 2) * 1024);
        printWriter.println(" max");
    }

    void dumpTotalsLocked(PrintWriter printWriter, long j) {
        printWriter.println("Run time Stats:");
        dumpSingleTime(printWriter, "  ", this.mMemFactorDurations, this.mMemFactor, this.mStartTime, j);
        printWriter.println();
        printWriter.println("Memory usage:");
        TotalMemoryUseCollection totalMemoryUseCollection = new TotalMemoryUseCollection(ALL_SCREEN_ADJ, ALL_MEM_ADJ);
        computeTotalMemoryUse(totalMemoryUseCollection, j);
        long printMemoryCategory = printMemoryCategory(printWriter, "  ", "Native ", totalMemoryUseCollection.sysMemNativeWeight, totalMemoryUseCollection.totalTime, printMemoryCategory(printWriter, "  ", "Kernel ", totalMemoryUseCollection.sysMemKernelWeight, totalMemoryUseCollection.totalTime, 0L, totalMemoryUseCollection.sysMemSamples), totalMemoryUseCollection.sysMemSamples);
        int i = 0;
        while (i < 14) {
            long j2 = printMemoryCategory;
            if (i != 7) {
                j2 = printMemoryCategory(printWriter, "  ", STATE_NAMES[i], totalMemoryUseCollection.processStateWeight[i], totalMemoryUseCollection.totalTime, printMemoryCategory, totalMemoryUseCollection.processStateSamples[i]);
            }
            i++;
            printMemoryCategory = j2;
        }
        long printMemoryCategory2 = printMemoryCategory(printWriter, "  ", "Z-Ram  ", totalMemoryUseCollection.sysMemZRamWeight, totalMemoryUseCollection.totalTime, printMemoryCategory(printWriter, "  ", "Free   ", totalMemoryUseCollection.sysMemFreeWeight, totalMemoryUseCollection.totalTime, printMemoryCategory(printWriter, "  ", "Cached ", totalMemoryUseCollection.sysMemCachedWeight, totalMemoryUseCollection.totalTime, printMemoryCategory, totalMemoryUseCollection.sysMemSamples), totalMemoryUseCollection.sysMemSamples), totalMemoryUseCollection.sysMemSamples);
        printWriter.print("  TOTAL  : ");
        printSizeValue(printWriter, printMemoryCategory2);
        printWriter.println();
        printMemoryCategory(printWriter, "  ", STATE_NAMES[7], totalMemoryUseCollection.processStateWeight[7], totalMemoryUseCollection.totalTime, printMemoryCategory2, totalMemoryUseCollection.processStateSamples[7]);
        printWriter.println();
        printWriter.print("          Start time: ");
        printWriter.print(DateFormat.format("yyyy-MM-dd HH:mm:ss", this.mTimePeriodStartClock));
        printWriter.println();
        printWriter.print("  Total elapsed time: ");
        TimeUtils.formatDuration((this.mRunning ? SystemClock.elapsedRealtime() : this.mTimePeriodEndRealtime) - this.mTimePeriodStartRealtime, printWriter);
        boolean z = true;
        if ((this.mFlags & 2) != 0) {
            printWriter.print(" (shutdown)");
            z = false;
        }
        if ((this.mFlags & 4) != 0) {
            printWriter.print(" (sysprops)");
            z = false;
        }
        if ((this.mFlags & 1) != 0) {
            printWriter.print(" (complete)");
            z = false;
        }
        if (z) {
            printWriter.print(" (partial)");
        }
        printWriter.print(' ');
        printWriter.print(this.mRuntime);
        printWriter.println();
    }

    public boolean evaluateSystemProperties(boolean z) {
        boolean z2 = false;
        String str = SystemProperties.get("persist.sys.dalvik.vm.lib.2", VMRuntime.getRuntime().vmLibrary());
        if (!Objects.equals(str, this.mRuntime)) {
            z2 = true;
            if (z) {
                this.mRuntime = str;
                z2 = true;
            }
        }
        return z2;
    }

    long getLong(int i, int i2) {
        return this.mLongs.get((i >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK)[((i >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK) + i2];
    }

    public PackageState getPackageStateLocked(String str, int i, int i2) {
        SparseArray<PackageState> sparseArray = this.mPackages.get(str, i);
        SparseArray<PackageState> sparseArray2 = sparseArray;
        if (sparseArray == null) {
            sparseArray2 = new SparseArray<>();
            this.mPackages.put(str, i, sparseArray2);
        }
        PackageState packageState = sparseArray2.get(i2);
        if (packageState != null) {
            return packageState;
        }
        PackageState packageState2 = new PackageState(str, i);
        sparseArray2.put(i2, packageState2);
        return packageState2;
    }

    public ProcessState getProcessStateLocked(String str, int i, int i2, String str2) {
        ProcessState processState;
        PackageState packageStateLocked = getPackageStateLocked(str, i, i2);
        ProcessState processState2 = packageStateLocked.mProcesses.get(str2);
        if (processState2 != null) {
            return processState2;
        }
        ProcessState processState3 = this.mProcesses.get(str2, i);
        ProcessState processState4 = processState3;
        if (processState3 == null) {
            processState4 = new ProcessState(this, str, i, i2, str2);
            this.mProcesses.put(str2, i, processState4);
        }
        if (processState4.mMultiPackage) {
            processState = new ProcessState(processState4, str, i, i2, str2, SystemClock.uptimeMillis());
        } else if (str.equals(processState4.mPackage) && i2 == processState4.mVersion) {
            processState = processState4;
        } else {
            processState4.mMultiPackage = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            PackageState packageStateLocked2 = getPackageStateLocked(processState4.mPackage, i, processState4.mVersion);
            if (packageStateLocked2 != null) {
                ProcessState clone = processState4.clone(processState4.mPackage, uptimeMillis);
                packageStateLocked2.mProcesses.put(processState4.mName, clone);
                int size = packageStateLocked2.mServices.size();
                while (true) {
                    int i3 = size - 1;
                    if (i3 < 0) {
                        break;
                    }
                    ServiceState valueAt = packageStateLocked2.mServices.valueAt(i3);
                    if (valueAt.mProc == processState4) {
                        valueAt.mProc = clone;
                    }
                    size = i3;
                }
            } else {
                Slog.w(TAG, "Cloning proc state: no package state " + processState4.mPackage + BridgeUtil.SPLIT_MARK + i + " for proc " + processState4.mName);
            }
            processState = new ProcessState(processState4, str, i, i2, str2, uptimeMillis);
        }
        packageStateLocked.mProcesses.put(str2, processState);
        return processState;
    }

    public ServiceState getServiceStateLocked(String str, int i, int i2, String str2, String str3) {
        PackageState packageStateLocked = getPackageStateLocked(str, i, i2);
        ServiceState serviceState = packageStateLocked.mServices.get(str3);
        if (serviceState != null) {
            return serviceState;
        }
        ServiceState serviceState2 = new ServiceState(this, str, str3, str2, str2 != null ? getProcessStateLocked(str, i, i2, str2) : null);
        packageStateLocked.mServices.put(str3, serviceState2);
        return serviceState2;
    }

    long getSysMemUsageValue(int i, int i2) {
        int binarySearch = binarySearch(this.mSysMemUsageTable, this.mSysMemUsageTableSize, i);
        if (binarySearch >= 0) {
            return getLong(this.mSysMemUsageTable[binarySearch], i2);
        }
        return 0L;
    }

    long printMemoryCategory(PrintWriter printWriter, String str, String str2, double d, long j, long j2, int i) {
        long j3 = j2;
        if (d != 0.0d) {
            long j4 = (long) ((1024.0d * d) / j);
            printWriter.print(str);
            printWriter.print(str2);
            printWriter.print(": ");
            printSizeValue(printWriter, j4);
            printWriter.print(" (");
            printWriter.print(i);
            printWriter.print(" samples)");
            printWriter.println();
            j3 = j2 + j4;
        }
        return j3;
    }

    public void read(InputStream inputStream) {
        try {
            int[] iArr = new int[1];
            byte[] readFully = readFully(inputStream, iArr);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(readFully, 0, iArr[0]);
            obtain.setDataPosition(0);
            inputStream.close();
            readFromParcel(obtain);
        } catch (IOException e) {
            this.mReadError = "caught exception: " + e;
        }
    }

    public void readFromParcel(Parcel parcel) {
        ProcessState processState;
        ProcessState processState2;
        boolean z = this.mPackages.getMap().size() > 0 || this.mProcesses.getMap().size() > 0;
        if (z) {
            resetSafely();
        }
        if (readCheckedInt(parcel, MAGIC, "magic number")) {
            int readInt = parcel.readInt();
            if (readInt != 18) {
                this.mReadError = "bad version: " + readInt;
            } else if (readCheckedInt(parcel, 14, "state count") && readCheckedInt(parcel, 8, "adj count") && readCheckedInt(parcel, 7, "pss count") && readCheckedInt(parcel, 16, "sys mem usage count") && readCheckedInt(parcel, 4096, "longs size")) {
                this.mIndexToCommonString = new ArrayList<>();
                this.mTimePeriodStartClock = parcel.readLong();
                buildTimePeriodStartClockStr();
                this.mTimePeriodStartRealtime = parcel.readLong();
                this.mTimePeriodEndRealtime = parcel.readLong();
                this.mTimePeriodStartUptime = parcel.readLong();
                this.mTimePeriodEndUptime = parcel.readLong();
                this.mRuntime = parcel.readString();
                this.mFlags = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                this.mLongs.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt2 - 1) {
                        break;
                    }
                    while (i2 >= this.mLongs.size()) {
                        this.mLongs.add(new long[4096]);
                    }
                    readCompactedLongArray(parcel, readInt, this.mLongs.get(i2), 4096);
                    i = i2 + 1;
                }
                long[] jArr = new long[4096];
                this.mNextLong = readInt3;
                readCompactedLongArray(parcel, readInt, jArr, readInt3);
                this.mLongs.add(jArr);
                readCompactedLongArray(parcel, readInt, this.mMemFactorDurations, this.mMemFactorDurations.length);
                this.mSysMemUsageTable = readTableFromParcel(parcel, TAG, "sys mem usage");
                if (this.mSysMemUsageTable != BAD_TABLE) {
                    this.mSysMemUsageTableSize = this.mSysMemUsageTable != null ? this.mSysMemUsageTable.length : 0;
                    int readInt4 = parcel.readInt();
                    int i3 = readInt4;
                    if (readInt4 < 0) {
                        this.mReadError = "bad process count: " + readInt4;
                        return;
                    }
                    while (i3 > 0) {
                        int i4 = i3 - 1;
                        String readCommonString = readCommonString(parcel, readInt);
                        if (readCommonString == null) {
                            this.mReadError = "bad process name";
                            return;
                        }
                        int readInt5 = parcel.readInt();
                        int i5 = readInt5;
                        if (readInt5 < 0) {
                            this.mReadError = "bad uid count: " + readInt5;
                            return;
                        }
                        while (true) {
                            i3 = i4;
                            if (i5 > 0) {
                                i5--;
                                int readInt6 = parcel.readInt();
                                if (readInt6 < 0) {
                                    this.mReadError = "bad uid: " + readInt6;
                                    return;
                                }
                                String readCommonString2 = readCommonString(parcel, readInt);
                                if (readCommonString2 == null) {
                                    this.mReadError = "bad process package name";
                                    return;
                                }
                                int readInt7 = parcel.readInt();
                                ProcessState processState3 = z ? this.mProcesses.get(readCommonString, readInt6) : null;
                                if (processState3 != null) {
                                    processState2 = processState3;
                                    if (!processState3.readFromParcel(parcel, false)) {
                                        return;
                                    }
                                } else {
                                    ProcessState processState4 = new ProcessState(this, readCommonString2, readInt6, readInt7, readCommonString);
                                    processState2 = processState4;
                                    if (!processState4.readFromParcel(parcel, true)) {
                                        return;
                                    }
                                }
                                this.mProcesses.put(readCommonString, readInt6, processState2);
                            }
                        }
                    }
                    int readInt8 = parcel.readInt();
                    int i6 = readInt8;
                    if (readInt8 < 0) {
                        this.mReadError = "bad package count: " + readInt8;
                        return;
                    }
                    while (i6 > 0) {
                        int i7 = i6 - 1;
                        String readCommonString3 = readCommonString(parcel, readInt);
                        if (readCommonString3 == null) {
                            this.mReadError = "bad package name";
                            return;
                        }
                        int readInt9 = parcel.readInt();
                        int i8 = readInt9;
                        if (readInt9 < 0) {
                            this.mReadError = "bad uid count: " + readInt9;
                            return;
                        }
                        while (true) {
                            i6 = i7;
                            if (i8 > 0) {
                                int i9 = i8 - 1;
                                int readInt10 = parcel.readInt();
                                if (readInt10 < 0) {
                                    this.mReadError = "bad uid: " + readInt10;
                                    return;
                                }
                                int readInt11 = parcel.readInt();
                                int i10 = readInt11;
                                if (readInt11 < 0) {
                                    this.mReadError = "bad versions count: " + readInt11;
                                    return;
                                }
                                while (true) {
                                    i8 = i9;
                                    if (i10 > 0) {
                                        int i11 = i10 - 1;
                                        int readInt12 = parcel.readInt();
                                        PackageState packageState = new PackageState(readCommonString3, readInt10);
                                        SparseArray<PackageState> sparseArray = this.mPackages.get(readCommonString3, readInt10);
                                        SparseArray<PackageState> sparseArray2 = sparseArray;
                                        if (sparseArray == null) {
                                            sparseArray2 = new SparseArray<>();
                                            this.mPackages.put(readCommonString3, readInt10, sparseArray2);
                                        }
                                        sparseArray2.put(readInt12, packageState);
                                        int readInt13 = parcel.readInt();
                                        int i12 = readInt13;
                                        if (readInt13 < 0) {
                                            this.mReadError = "bad package process count: " + readInt13;
                                            return;
                                        }
                                        while (i12 > 0) {
                                            i12--;
                                            String readCommonString4 = readCommonString(parcel, readInt);
                                            if (readCommonString4 == null) {
                                                this.mReadError = "bad package process name";
                                                return;
                                            }
                                            int readInt14 = parcel.readInt();
                                            ProcessState processState5 = this.mProcesses.get(readCommonString4, readInt10);
                                            if (processState5 == null) {
                                                this.mReadError = "no common proc: " + readCommonString4;
                                                return;
                                            } else if (readInt14 != 0) {
                                                ProcessState processState6 = z ? packageState.mProcesses.get(readCommonString4) : null;
                                                if (processState6 != null) {
                                                    processState = processState6;
                                                    if (!processState6.readFromParcel(parcel, false)) {
                                                        return;
                                                    }
                                                } else {
                                                    ProcessState processState7 = new ProcessState(processState5, readCommonString3, readInt10, readInt12, readCommonString4, 0L);
                                                    processState = processState7;
                                                    if (!processState7.readFromParcel(parcel, true)) {
                                                        return;
                                                    }
                                                }
                                                packageState.mProcesses.put(readCommonString4, processState);
                                            } else {
                                                packageState.mProcesses.put(readCommonString4, processState5);
                                            }
                                        }
                                        int readInt15 = parcel.readInt();
                                        int i13 = readInt15;
                                        if (readInt15 < 0) {
                                            this.mReadError = "bad package service count: " + readInt15;
                                            return;
                                        }
                                        while (true) {
                                            i10 = i11;
                                            if (i13 > 0) {
                                                i13--;
                                                String readString = parcel.readString();
                                                if (readString == null) {
                                                    this.mReadError = "bad package service name";
                                                    return;
                                                }
                                                String readCommonString5 = readInt > 9 ? readCommonString(parcel, readInt) : null;
                                                ServiceState serviceState = z ? packageState.mServices.get(readString) : null;
                                                ServiceState serviceState2 = serviceState;
                                                if (serviceState == null) {
                                                    serviceState2 = new ServiceState(this, readCommonString3, readString, readCommonString5, null);
                                                }
                                                if (!serviceState2.readFromParcel(parcel)) {
                                                    return;
                                                }
                                                packageState.mServices.put(readString, serviceState2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.mIndexToCommonString = null;
                }
            }
        }
    }

    public void reset() {
        resetCommon();
        this.mPackages.getMap().clear();
        this.mProcesses.getMap().clear();
        this.mMemFactor = -1;
        this.mStartTime = 0L;
    }

    public void resetSafely() {
        resetCommon();
        long uptimeMillis = SystemClock.uptimeMillis();
        ArrayMap<String, SparseArray<ProcessState>> map = this.mProcesses.getMap();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            SparseArray<ProcessState> valueAt = map.valueAt(i);
            int size2 = valueAt.size();
            while (true) {
                int i2 = size2 - 1;
                if (i2 >= 0) {
                    valueAt.valueAt(i2).mTmpNumInUse = 0;
                    size2 = i2;
                }
            }
            size = i;
        }
        ArrayMap<String, SparseArray<SparseArray<PackageState>>> map2 = this.mPackages.getMap();
        int size3 = map2.size();
        while (true) {
            int i3 = size3 - 1;
            if (i3 < 0) {
                break;
            }
            SparseArray<SparseArray<PackageState>> valueAt2 = map2.valueAt(i3);
            int size4 = valueAt2.size();
            while (true) {
                int i4 = size4 - 1;
                if (i4 < 0) {
                    break;
                }
                SparseArray<PackageState> valueAt3 = valueAt2.valueAt(i4);
                int size5 = valueAt3.size();
                while (true) {
                    int i5 = size5 - 1;
                    if (i5 < 0) {
                        break;
                    }
                    PackageState valueAt4 = valueAt3.valueAt(i5);
                    int size6 = valueAt4.mProcesses.size();
                    while (true) {
                        int i6 = size6 - 1;
                        if (i6 < 0) {
                            break;
                        }
                        ProcessState valueAt5 = valueAt4.mProcesses.valueAt(i6);
                        if (valueAt5.isInUse()) {
                            valueAt5.resetSafely(uptimeMillis);
                            valueAt5.mCommonProcess.mTmpNumInUse++;
                            valueAt5.mCommonProcess.mTmpFoundSubProc = valueAt5;
                        } else {
                            valueAt4.mProcesses.valueAt(i6).makeDead();
                            valueAt4.mProcesses.removeAt(i6);
                        }
                        size6 = i6;
                    }
                    int size7 = valueAt4.mServices.size();
                    while (true) {
                        int i7 = size7 - 1;
                        if (i7 < 0) {
                            break;
                        }
                        ServiceState valueAt6 = valueAt4.mServices.valueAt(i7);
                        if (valueAt6.isInUse()) {
                            valueAt6.resetSafely(uptimeMillis);
                        } else {
                            valueAt4.mServices.removeAt(i7);
                        }
                        size7 = i7;
                    }
                    if (valueAt4.mProcesses.size() <= 0 && valueAt4.mServices.size() <= 0) {
                        valueAt3.removeAt(i5);
                    }
                    size5 = i5;
                }
                if (valueAt3.size() <= 0) {
                    valueAt2.removeAt(i4);
                }
                size4 = i4;
            }
            if (valueAt2.size() <= 0) {
                map2.removeAt(i3);
            }
            size3 = i3;
        }
        int size8 = map.size();
        while (true) {
            int i8 = size8 - 1;
            if (i8 < 0) {
                this.mStartTime = uptimeMillis;
                return;
            }
            SparseArray<ProcessState> valueAt7 = map.valueAt(i8);
            int size9 = valueAt7.size();
            while (true) {
                int i9 = size9 - 1;
                if (i9 < 0) {
                    break;
                }
                ProcessState valueAt8 = valueAt7.valueAt(i9);
                if (!valueAt8.isInUse() && valueAt8.mTmpNumInUse <= 0) {
                    valueAt8.makeDead();
                    valueAt7.removeAt(i9);
                } else if (!valueAt8.mActive && valueAt8.mMultiPackage && valueAt8.mTmpNumInUse == 1) {
                    ProcessState processState = valueAt8.mTmpFoundSubProc;
                    processState.mCommonProcess = processState;
                    valueAt7.setValueAt(i9, processState);
                } else {
                    valueAt8.resetSafely(uptimeMillis);
                }
                size9 = i9;
            }
            if (valueAt7.size() <= 0) {
                map.removeAt(i8);
            }
            size8 = i8;
        }
    }

    void setLong(int i, int i2, long j) {
        this.mLongs.get((i >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK)[((i >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK) + i2] = j;
    }

    boolean validateLongOffset(int i) {
        return ((i >> OFFSET_ARRAY_SHIFT) & OFFSET_ARRAY_MASK) < this.mLongs.size() && ((i >> OFFSET_INDEX_SHIFT) & OFFSET_INDEX_MASK) < 4096;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, SystemClock.uptimeMillis(), i);
    }

    public void writeToParcel(Parcel parcel, long j, int i) {
        parcel.writeInt(MAGIC);
        parcel.writeInt(18);
        parcel.writeInt(14);
        parcel.writeInt(8);
        parcel.writeInt(7);
        parcel.writeInt(16);
        parcel.writeInt(4096);
        this.mCommonStringToIndex = new ArrayMap<>(this.mProcesses.mMap.size());
        ArrayMap<String, SparseArray<ProcessState>> map = this.mProcesses.getMap();
        int size = map.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            SparseArray<ProcessState> valueAt = map.valueAt(i3);
            int size2 = valueAt.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < size2) {
                    valueAt.valueAt(i5).commitStateTime(j);
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
        ArrayMap<String, SparseArray<SparseArray<PackageState>>> map2 = this.mPackages.getMap();
        int size3 = map2.size();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= size3) {
                break;
            }
            SparseArray<SparseArray<PackageState>> valueAt2 = map2.valueAt(i7);
            int size4 = valueAt2.size();
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < size4) {
                    SparseArray<PackageState> valueAt3 = valueAt2.valueAt(i9);
                    int size5 = valueAt3.size();
                    int i10 = 0;
                    while (true) {
                        int i11 = i10;
                        if (i11 < size5) {
                            PackageState valueAt4 = valueAt3.valueAt(i11);
                            int size6 = valueAt4.mProcesses.size();
                            int i12 = 0;
                            while (true) {
                                int i13 = i12;
                                if (i13 >= size6) {
                                    break;
                                }
                                ProcessState valueAt5 = valueAt4.mProcesses.valueAt(i13);
                                if (valueAt5.mCommonProcess != valueAt5) {
                                    valueAt5.commitStateTime(j);
                                }
                                i12 = i13 + 1;
                            }
                            int size7 = valueAt4.mServices.size();
                            int i14 = 0;
                            while (true) {
                                int i15 = i14;
                                if (i15 < size7) {
                                    valueAt4.mServices.valueAt(i15).commitStateTime(j);
                                    i14 = i15 + 1;
                                }
                            }
                            i10 = i11 + 1;
                        }
                    }
                    i8 = i9 + 1;
                }
            }
            i6 = i7 + 1;
        }
        parcel.writeLong(this.mTimePeriodStartClock);
        parcel.writeLong(this.mTimePeriodStartRealtime);
        parcel.writeLong(this.mTimePeriodEndRealtime);
        parcel.writeLong(this.mTimePeriodStartUptime);
        parcel.writeLong(this.mTimePeriodEndUptime);
        parcel.writeString(this.mRuntime);
        parcel.writeInt(this.mFlags);
        parcel.writeInt(this.mLongs.size());
        parcel.writeInt(this.mNextLong);
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= this.mLongs.size() - 1) {
                break;
            }
            long[] jArr = this.mLongs.get(i17);
            writeCompactedLongArray(parcel, jArr, jArr.length);
            i16 = i17 + 1;
        }
        writeCompactedLongArray(parcel, this.mLongs.get(this.mLongs.size() - 1), this.mNextLong);
        if (this.mMemFactor != -1) {
            long[] jArr2 = this.mMemFactorDurations;
            int i18 = this.mMemFactor;
            jArr2[i18] = jArr2[i18] + (j - this.mStartTime);
            this.mStartTime = j;
        }
        writeCompactedLongArray(parcel, this.mMemFactorDurations, this.mMemFactorDurations.length);
        parcel.writeInt(this.mSysMemUsageTableSize);
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= this.mSysMemUsageTableSize) {
                break;
            }
            parcel.writeInt(this.mSysMemUsageTable[i20]);
            i19 = i20 + 1;
        }
        parcel.writeInt(size);
        int i21 = 0;
        while (true) {
            int i22 = i21;
            if (i22 >= size) {
                break;
            }
            writeCommonString(parcel, map.keyAt(i22));
            SparseArray<ProcessState> valueAt6 = map.valueAt(i22);
            int size8 = valueAt6.size();
            parcel.writeInt(size8);
            int i23 = 0;
            while (true) {
                int i24 = i23;
                if (i24 < size8) {
                    parcel.writeInt(valueAt6.keyAt(i24));
                    ProcessState valueAt7 = valueAt6.valueAt(i24);
                    writeCommonString(parcel, valueAt7.mPackage);
                    parcel.writeInt(valueAt7.mVersion);
                    valueAt7.writeToParcel(parcel, j);
                    i23 = i24 + 1;
                }
            }
            i21 = i22 + 1;
        }
        parcel.writeInt(size3);
        int i25 = 0;
        while (true) {
            int i26 = i25;
            if (i26 >= size3) {
                this.mCommonStringToIndex = null;
                return;
            }
            writeCommonString(parcel, map2.keyAt(i26));
            SparseArray<SparseArray<PackageState>> valueAt8 = map2.valueAt(i26);
            int size9 = valueAt8.size();
            parcel.writeInt(size9);
            int i27 = 0;
            while (true) {
                int i28 = i27;
                if (i28 < size9) {
                    parcel.writeInt(valueAt8.keyAt(i28));
                    SparseArray<PackageState> valueAt9 = valueAt8.valueAt(i28);
                    int size10 = valueAt9.size();
                    parcel.writeInt(size10);
                    int i29 = 0;
                    while (true) {
                        int i30 = i29;
                        if (i30 < size10) {
                            parcel.writeInt(valueAt9.keyAt(i30));
                            PackageState valueAt10 = valueAt9.valueAt(i30);
                            int size11 = valueAt10.mProcesses.size();
                            parcel.writeInt(size11);
                            int i31 = 0;
                            while (true) {
                                int i32 = i31;
                                if (i32 >= size11) {
                                    break;
                                }
                                writeCommonString(parcel, valueAt10.mProcesses.keyAt(i32));
                                ProcessState valueAt11 = valueAt10.mProcesses.valueAt(i32);
                                if (valueAt11.mCommonProcess == valueAt11) {
                                    parcel.writeInt(0);
                                } else {
                                    parcel.writeInt(1);
                                    valueAt11.writeToParcel(parcel, j);
                                }
                                i31 = i32 + 1;
                            }
                            int size12 = valueAt10.mServices.size();
                            parcel.writeInt(size12);
                            int i33 = 0;
                            while (true) {
                                int i34 = i33;
                                if (i34 < size12) {
                                    parcel.writeString(valueAt10.mServices.keyAt(i34));
                                    ServiceState valueAt12 = valueAt10.mServices.valueAt(i34);
                                    writeCommonString(parcel, valueAt12.mProcessName);
                                    valueAt12.writeToParcel(parcel, j);
                                    i33 = i34 + 1;
                                }
                            }
                            i29 = i30 + 1;
                        }
                    }
                    i27 = i28 + 1;
                }
            }
            i25 = i26 + 1;
        }
    }
}
