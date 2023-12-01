package com.android.internal.os;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkStats;
import android.net.wifi.WifiManager;
import android.os.BatteryStats;
import android.os.Build;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.WorkSource;
import android.telephony.DataConnectionRealTimeInfo;
import android.telephony.SignalStrength;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LogWriter;
import android.util.MutableInt;
import android.util.Printer;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.android.internal.annotations.GuardedBy;
import com.android.internal.net.NetworkStatsFactory;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastPrintWriter;
import com.android.internal.util.JournaledFile;
import com.android.server.NetworkManagementSocketTagger;
import java.awt.font.NumericShaper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl.class */
public class BatteryStatsImpl extends BatteryStats {
    private static final int BATTERY_PLUGGED_NONE = 0;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_HISTORY = false;
    static final long DELAY_UPDATE_WAKELOCKS = 5000;
    static final int DELTA_BATTERY_LEVEL_FLAG = 524288;
    static final int DELTA_EVENT_FLAG = 8388608;
    static final int DELTA_STATE2_FLAG = 2097152;
    static final int DELTA_STATE_FLAG = 1048576;
    static final int DELTA_STATE_MASK = -16777216;
    static final int DELTA_TIME_ABS = 524285;
    static final int DELTA_TIME_INT = 524286;
    static final int DELTA_TIME_LONG = 524287;
    static final int DELTA_TIME_MASK = 524287;
    static final int DELTA_WAKELOCK_FLAG = 4194304;
    private static final int MAGIC = -1166707595;
    static final int MAX_HISTORY_BUFFER = 262144;
    private static final int MAX_HISTORY_ITEMS = 2000;
    static final int MAX_LEVEL_STEPS = 200;
    static final int MAX_MAX_HISTORY_BUFFER = 327680;
    private static final int MAX_MAX_HISTORY_ITEMS = 3000;
    private static final int MAX_WAKELOCKS_PER_UID = 100;
    static final int MSG_REPORT_POWER_CHANGE = 2;
    static final int MSG_UPDATE_WAKELOCKS = 1;
    static final int NET_UPDATE_ALL = 65535;
    static final int NET_UPDATE_MOBILE = 1;
    static final int NET_UPDATE_WIFI = 2;
    static final int STATE_BATTERY_HEALTH_MASK = 7;
    static final int STATE_BATTERY_HEALTH_SHIFT = 26;
    static final int STATE_BATTERY_PLUG_MASK = 3;
    static final int STATE_BATTERY_PLUG_SHIFT = 24;
    static final int STATE_BATTERY_STATUS_MASK = 7;
    static final int STATE_BATTERY_STATUS_SHIFT = 29;
    private static final String TAG = "BatteryStatsImpl";
    private static final boolean USE_OLD_HISTORY = false;
    private static final int VERSION = 116;
    private static int sNumSpeedSteps;
    final BatteryStats.HistoryEventTracker mActiveEvents;
    int mAudioOnNesting;
    StopwatchTimer mAudioOnTimer;
    final ArrayList<StopwatchTimer> mAudioTurnedOnTimers;
    boolean mBluetoothOn;
    StopwatchTimer mBluetoothOnTimer;
    private int mBluetoothPingCount;
    private int mBluetoothPingStart;
    int mBluetoothState;
    final StopwatchTimer[] mBluetoothStateTimer;
    BluetoothHeadset mBtHeadset;
    private BatteryCallback mCallback;
    int mChangedStates;
    int mChangedStates2;
    final long[] mChargeStepDurations;
    public final AtomicFile mCheckinFile;
    private NetworkStats mCurMobileSnapshot;
    int mCurStepMode;
    private NetworkStats mCurWifiSnapshot;
    int mCurrentBatteryLevel;
    int mDischargeAmountScreenOff;
    int mDischargeAmountScreenOffSinceCharge;
    int mDischargeAmountScreenOn;
    int mDischargeAmountScreenOnSinceCharge;
    int mDischargeCurrentLevel;
    int mDischargePlugLevel;
    int mDischargeScreenOffUnplugLevel;
    int mDischargeScreenOnUnplugLevel;
    int mDischargeStartLevel;
    final long[] mDischargeStepDurations;
    int mDischargeUnplugLevel;
    boolean mDistributeWakelockCpu;
    String mEndPlatformVersion;
    private final JournaledFile mFile;
    boolean mFlashlightOn;
    StopwatchTimer mFlashlightOnTimer;
    final ArrayList<StopwatchTimer> mFullTimers;
    final ArrayList<StopwatchTimer> mFullWifiLockTimers;
    boolean mGlobalWifiRunning;
    StopwatchTimer mGlobalWifiRunningTimer;
    int mGpsNesting;
    public final MyHandler mHandler;
    boolean mHaveBatteryLevel;
    int mHighDischargeAmountSinceCharge;
    BatteryStats.HistoryItem mHistory;
    final BatteryStats.HistoryItem mHistoryAddTmp;
    long mHistoryBaseTime;
    final Parcel mHistoryBuffer;
    int mHistoryBufferLastPos;
    BatteryStats.HistoryItem mHistoryCache;
    final BatteryStats.HistoryItem mHistoryCur;
    BatteryStats.HistoryItem mHistoryEnd;
    private BatteryStats.HistoryItem mHistoryIterator;
    BatteryStats.HistoryItem mHistoryLastEnd;
    final BatteryStats.HistoryItem mHistoryLastLastWritten;
    final BatteryStats.HistoryItem mHistoryLastWritten;
    boolean mHistoryOverflow;
    final BatteryStats.HistoryItem mHistoryReadTmp;
    final HashMap<BatteryStats.HistoryTag, Integer> mHistoryTagPool;
    int mInitStepMode;
    private String mInitialAcquireWakeName;
    private int mInitialAcquireWakeUid;
    boolean mInteractive;
    StopwatchTimer mInteractiveTimer;
    final SparseIntArray mIsolatedUids;
    private boolean mIteratingHistory;
    private final HashMap<String, SamplingTimer> mKernelWakelockStats;
    int mLastChargeStepLevel;
    long mLastChargeStepTime;
    int mLastDischargeStepLevel;
    long mLastDischargeStepTime;
    long mLastHistoryElapsedRealtime;
    private NetworkStats mLastMobileSnapshot;
    final ArrayList<StopwatchTimer> mLastPartialTimers;
    long mLastRecordedClockRealtime;
    long mLastRecordedClockTime;
    String mLastWakeupReason;
    long mLastWakeupUptimeMs;
    private NetworkStats mLastWifiSnapshot;
    long mLastWriteTime;
    private int mLoadedNumConnectivityChange;
    int mLowDischargeAmountSinceCharge;
    boolean mLowPowerModeEnabled;
    StopwatchTimer mLowPowerModeEnabledTimer;
    int mMaxChargeStepLevel;
    int mMinDischargeStepLevel;
    @GuardedBy("this")
    private String[] mMobileIfaces;
    LongSamplingCounter mMobileRadioActiveAdjustedTime;
    StopwatchTimer mMobileRadioActivePerAppTimer;
    long mMobileRadioActiveStartTime;
    StopwatchTimer mMobileRadioActiveTimer;
    LongSamplingCounter mMobileRadioActiveUnknownCount;
    LongSamplingCounter mMobileRadioActiveUnknownTime;
    int mMobileRadioPowerState;
    int mModStepMode;
    final LongSamplingCounter[] mNetworkByteActivityCounters;
    final LongSamplingCounter[] mNetworkPacketActivityCounters;
    private final NetworkStatsFactory mNetworkStatsFactory;
    int mNextHistoryTagIdx;
    boolean mNoAutoReset;
    int mNumChargeStepDurations;
    private int mNumConnectivityChange;
    int mNumDischargeStepDurations;
    int mNumHistoryItems;
    int mNumHistoryTagChars;
    boolean mOnBattery;
    boolean mOnBatteryInternal;
    final TimeBase mOnBatteryScreenOffTimeBase;
    final TimeBase mOnBatteryTimeBase;
    final ArrayList<StopwatchTimer> mPartialTimers;
    Parcel mPendingWrite;
    int mPhoneDataConnectionType;
    final StopwatchTimer[] mPhoneDataConnectionsTimer;
    boolean mPhoneOn;
    StopwatchTimer mPhoneOnTimer;
    private int mPhoneServiceState;
    private int mPhoneServiceStateRaw;
    StopwatchTimer mPhoneSignalScanningTimer;
    int mPhoneSignalStrengthBin;
    int mPhoneSignalStrengthBinRaw;
    final StopwatchTimer[] mPhoneSignalStrengthsTimer;
    private int mPhoneSimStateRaw;
    private final Map<String, KernelWakelockStats> mProcWakelockFileStats;
    private final long[] mProcWakelocksData;
    private final String[] mProcWakelocksName;
    int mReadHistoryChars;
    String[] mReadHistoryStrings;
    int[] mReadHistoryUids;
    private boolean mReadOverflow;
    long mRealtime;
    long mRealtimeStart;
    boolean mRecordAllHistory;
    boolean mRecordingHistory;
    int mScreenBrightnessBin;
    final StopwatchTimer[] mScreenBrightnessTimer;
    StopwatchTimer mScreenOnTimer;
    int mScreenState;
    int mSensorNesting;
    final SparseArray<ArrayList<StopwatchTimer>> mSensorTimers;
    boolean mShuttingDown;
    long mStartClockTime;
    int mStartCount;
    String mStartPlatformVersion;
    private NetworkStats mTmpNetworkStats;
    private final NetworkStats.Entry mTmpNetworkStatsEntry;
    long mTrackRunningHistoryElapsedRealtime;
    long mTrackRunningHistoryUptime;
    final SparseArray<Uid> mUidStats;
    private int mUnpluggedNumConnectivityChange;
    long mUptime;
    long mUptimeStart;
    int mVideoOnNesting;
    StopwatchTimer mVideoOnTimer;
    final ArrayList<StopwatchTimer> mVideoTurnedOnTimers;
    boolean mWakeLockImportant;
    int mWakeLockNesting;
    private final HashMap<String, SamplingTimer> mWakeupReasonStats;
    final SparseArray<ArrayList<StopwatchTimer>> mWifiBatchedScanTimers;
    int mWifiFullLockNesting;
    @GuardedBy("this")
    private String[] mWifiIfaces;
    int mWifiMulticastNesting;
    final ArrayList<StopwatchTimer> mWifiMulticastTimers;
    boolean mWifiOn;
    StopwatchTimer mWifiOnTimer;
    final ArrayList<StopwatchTimer> mWifiRunningTimers;
    int mWifiScanNesting;
    final ArrayList<StopwatchTimer> mWifiScanTimers;
    int mWifiSignalStrengthBin;
    final StopwatchTimer[] mWifiSignalStrengthsTimer;
    int mWifiState;
    final StopwatchTimer[] mWifiStateTimer;
    int mWifiSupplState;
    final StopwatchTimer[] mWifiSupplStateTimer;
    final ArrayList<StopwatchTimer> mWindowTimers;
    final ReentrantLock mWriteLock;
    private static int sKernelWakelockUpdateVersion = 0;
    private static final int[] PROC_WAKELOCKS_FORMAT = {5129, 8201, 9, 9, 9, 8201};
    private static final int[] WAKEUP_SOURCES_FORMAT = {4105, 8457, 265, 265, 265, 265, 8457};
    public static final Parcelable.Creator<BatteryStatsImpl> CREATOR = new Parcelable.Creator<BatteryStatsImpl>() { // from class: com.android.internal.os.BatteryStatsImpl.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatteryStatsImpl createFromParcel(Parcel parcel) {
            return new BatteryStatsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatteryStatsImpl[] newArray(int i) {
            return new BatteryStatsImpl[i];
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$BatchTimer.class */
    public static final class BatchTimer extends Timer {
        boolean mInDischarge;
        long mLastAddedDuration;
        long mLastAddedTime;
        final Uid mUid;

        BatchTimer(Uid uid, int i, TimeBase timeBase) {
            super(i, timeBase);
            this.mUid = uid;
            this.mInDischarge = timeBase.isRunning();
        }

        BatchTimer(Uid uid, int i, TimeBase timeBase, Parcel parcel) {
            super(i, timeBase, parcel);
            this.mUid = uid;
            this.mLastAddedTime = parcel.readLong();
            this.mLastAddedDuration = parcel.readLong();
            this.mInDischarge = timeBase.isRunning();
        }

        private long computeOverage(long j) {
            long j2 = 0;
            if (this.mLastAddedTime > 0) {
                j2 = (this.mLastTime + this.mLastAddedDuration) - j;
            }
            return j2;
        }

        private void recomputeLastDuration(long j, boolean z) {
            long computeOverage = computeOverage(j);
            if (computeOverage > 0) {
                if (this.mInDischarge) {
                    this.mTotalTime -= computeOverage;
                }
                if (z) {
                    this.mLastAddedTime = 0L;
                    return;
                }
                this.mLastAddedTime = j;
                this.mLastAddedDuration -= computeOverage;
            }
        }

        public void abortLastDuration(BatteryStatsImpl batteryStatsImpl) {
            recomputeLastDuration(SystemClock.elapsedRealtime() * 1000, true);
        }

        public void addDuration(BatteryStatsImpl batteryStatsImpl, long j) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            recomputeLastDuration(elapsedRealtime, true);
            this.mLastAddedTime = elapsedRealtime;
            this.mLastAddedDuration = j * 1000;
            if (this.mInDischarge) {
                this.mTotalTime += this.mLastAddedDuration;
                this.mCount++;
            }
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        protected int computeCurrentCountLocked() {
            return this.mCount;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        protected long computeRunTimeLocked(long j) {
            long computeOverage = computeOverage(SystemClock.elapsedRealtime() * 1000);
            if (computeOverage > 0) {
                this.mTotalTime = computeOverage;
                return computeOverage;
            }
            return this.mTotalTime;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        public void logState(Printer printer, String str) {
            super.logState(printer, str);
            printer.println(str + "mLastAddedTime=" + this.mLastAddedTime + " mLastAddedDuration=" + this.mLastAddedDuration);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer, com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long j, long j2, long j3) {
            recomputeLastDuration(j, false);
            this.mInDischarge = true;
            if (this.mLastAddedTime == j) {
                this.mTotalTime += this.mLastAddedDuration;
            }
            super.onTimeStarted(j, j2, j3);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer, com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long j, long j2, long j3) {
            recomputeLastDuration(SystemClock.elapsedRealtime() * 1000, false);
            this.mInDischarge = false;
            super.onTimeStopped(j, j2, j3);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        boolean reset(boolean z) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            recomputeLastDuration(elapsedRealtime, true);
            boolean z2 = this.mLastAddedTime == elapsedRealtime;
            super.reset(!z2 && z);
            return !z2;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel parcel, long j) {
            super.writeToParcel(parcel, j);
            parcel.writeLong(this.mLastAddedTime);
            parcel.writeLong(this.mLastAddedDuration);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$BatteryCallback.class */
    public interface BatteryCallback {
        void batteryNeedsCpuUpdate();

        void batteryPowerChanged(boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Counter.class */
    public static class Counter extends BatteryStats.Counter implements TimeBaseObs {
        final AtomicInteger mCount = new AtomicInteger();
        int mLastCount;
        int mLoadedCount;
        int mPluggedCount;
        final TimeBase mTimeBase;
        int mUnpluggedCount;

        Counter(TimeBase timeBase) {
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        Counter(TimeBase timeBase, Parcel parcel) {
            this.mTimeBase = timeBase;
            this.mPluggedCount = parcel.readInt();
            this.mCount.set(this.mPluggedCount);
            this.mLoadedCount = parcel.readInt();
            this.mLastCount = 0;
            this.mUnpluggedCount = parcel.readInt();
            timeBase.add(this);
        }

        public static void writeCounterToParcel(Parcel parcel, Counter counter) {
            if (counter == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            counter.writeToParcel(parcel);
        }

        void detach() {
            this.mTimeBase.remove(this);
        }

        public int getCountLocked(int i) {
            int i2;
            int i3 = this.mCount.get();
            if (i == 2) {
                i2 = i3 - this.mUnpluggedCount;
            } else {
                i2 = i3;
                if (i != 0) {
                    return i3 - this.mLoadedCount;
                }
            }
            return i2;
        }

        public void logState(Printer printer, String str) {
            printer.println(str + "mCount=" + this.mCount.get() + " mLoadedCount=" + this.mLoadedCount + " mLastCount=" + this.mLastCount + " mUnpluggedCount=" + this.mUnpluggedCount + " mPluggedCount=" + this.mPluggedCount);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long j, long j2, long j3) {
            this.mUnpluggedCount = this.mPluggedCount;
            this.mCount.set(this.mPluggedCount);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long j, long j2, long j3) {
            this.mPluggedCount = this.mCount.get();
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            this.mLoadedCount = parcel.readInt();
            this.mCount.set(this.mLoadedCount);
            this.mLastCount = 0;
            int i = this.mLoadedCount;
            this.mPluggedCount = i;
            this.mUnpluggedCount = i;
        }

        void reset(boolean z) {
            this.mCount.set(0);
            this.mUnpluggedCount = 0;
            this.mPluggedCount = 0;
            this.mLastCount = 0;
            this.mLoadedCount = 0;
            if (z) {
                detach();
            }
        }

        void stepAtomic() {
            this.mCount.incrementAndGet();
        }

        void writeSummaryFromParcelLocked(Parcel parcel) {
            parcel.writeInt(this.mCount.get());
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.mCount.get());
            parcel.writeInt(this.mLoadedCount);
            parcel.writeInt(this.mUnpluggedCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$KernelWakelockStats.class */
    public class KernelWakelockStats {
        public int mCount;
        public long mTotalTime;
        public int mVersion;

        KernelWakelockStats(int i, long j, int i2) {
            this.mCount = i;
            this.mTotalTime = j;
            this.mVersion = i2;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$LongSamplingCounter.class */
    public static class LongSamplingCounter extends BatteryStats.LongCounter implements TimeBaseObs {
        long mCount;
        long mLastCount;
        long mLoadedCount;
        long mPluggedCount;
        final TimeBase mTimeBase;
        long mUnpluggedCount;

        LongSamplingCounter(TimeBase timeBase) {
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        LongSamplingCounter(TimeBase timeBase, Parcel parcel) {
            this.mTimeBase = timeBase;
            this.mPluggedCount = parcel.readLong();
            this.mCount = this.mPluggedCount;
            this.mLoadedCount = parcel.readLong();
            this.mLastCount = 0L;
            this.mUnpluggedCount = parcel.readLong();
            timeBase.add(this);
        }

        void addCountLocked(long j) {
            this.mCount += j;
        }

        void detach() {
            this.mTimeBase.remove(this);
        }

        public long getCountLocked(int i) {
            long j;
            long j2 = this.mCount;
            if (i == 2) {
                j = j2 - this.mUnpluggedCount;
            } else {
                j = j2;
                if (i != 0) {
                    return j2 - this.mLoadedCount;
                }
            }
            return j;
        }

        public void logState(Printer printer, String str) {
            printer.println(str + "mCount=" + this.mCount + " mLoadedCount=" + this.mLoadedCount + " mLastCount=" + this.mLastCount + " mUnpluggedCount=" + this.mUnpluggedCount + " mPluggedCount=" + this.mPluggedCount);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long j, long j2, long j3) {
            this.mUnpluggedCount = this.mPluggedCount;
            this.mCount = this.mPluggedCount;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long j, long j2, long j3) {
            this.mPluggedCount = this.mCount;
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            this.mLoadedCount = parcel.readLong();
            this.mCount = this.mLoadedCount;
            this.mLastCount = 0L;
            long j = this.mLoadedCount;
            this.mPluggedCount = j;
            this.mUnpluggedCount = j;
        }

        void reset(boolean z) {
            this.mCount = 0L;
            this.mUnpluggedCount = 0L;
            this.mPluggedCount = 0L;
            this.mLastCount = 0L;
            this.mLoadedCount = 0L;
            if (z) {
                detach();
            }
        }

        void writeSummaryFromParcelLocked(Parcel parcel) {
            parcel.writeLong(this.mCount);
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeLong(this.mCount);
            parcel.writeLong(this.mLoadedCount);
            parcel.writeLong(this.mUnpluggedCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$MyHandler.class */
    public final class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BatteryCallback batteryCallback = BatteryStatsImpl.this.mCallback;
            switch (message.what) {
                case 1:
                    if (batteryCallback != null) {
                        batteryCallback.batteryNeedsCpuUpdate();
                        return;
                    }
                    return;
                case 2:
                    if (batteryCallback != null) {
                        batteryCallback.batteryPowerChanged(message.arg1 != 0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$OverflowArrayMap.class */
    public abstract class OverflowArrayMap<T> {
        private static final String OVERFLOW_NAME = "*overflow*";
        ArrayMap<String, MutableInt> mActiveOverflow;
        T mCurOverflow;
        final ArrayMap<String, T> mMap = new ArrayMap<>();

        public OverflowArrayMap() {
        }

        public void add(String str, T t) {
            this.mMap.put(str, t);
            if (OVERFLOW_NAME.equals(str)) {
                this.mCurOverflow = t;
            }
        }

        public void cleanup() {
            if (this.mActiveOverflow != null && this.mActiveOverflow.size() == 0) {
                this.mActiveOverflow = null;
            }
            if (this.mActiveOverflow == null) {
                if (this.mMap.containsKey(OVERFLOW_NAME)) {
                    Slog.wtf(BatteryStatsImpl.TAG, "Cleaning up with no active overflow, but have overflow entry " + this.mMap.get(OVERFLOW_NAME));
                    this.mMap.remove(OVERFLOW_NAME);
                }
                this.mCurOverflow = null;
            } else if (this.mCurOverflow == null || !this.mMap.containsKey(OVERFLOW_NAME)) {
                Slog.wtf(BatteryStatsImpl.TAG, "Cleaning up with active overflow, but no overflow entry: cur=" + this.mCurOverflow + " map=" + this.mMap.get(OVERFLOW_NAME));
            }
        }

        public void clear() {
            this.mMap.clear();
            this.mCurOverflow = null;
            this.mActiveOverflow = null;
        }

        public ArrayMap<String, T> getMap() {
            return this.mMap;
        }

        public abstract T instantiateObject();

        public T startObject(String str) {
            MutableInt mutableInt;
            T t = this.mMap.get(str);
            if (t != null) {
                return t;
            }
            if (this.mActiveOverflow != null && (mutableInt = this.mActiveOverflow.get(str)) != null) {
                T t2 = this.mCurOverflow;
                T t3 = t2;
                if (t2 == null) {
                    Slog.wtf(BatteryStatsImpl.TAG, "Have active overflow " + str + " but null overflow");
                    t3 = instantiateObject();
                    this.mCurOverflow = t3;
                    this.mMap.put(OVERFLOW_NAME, t3);
                }
                mutableInt.value++;
                return t3;
            } else if (this.mMap.size() < 100) {
                T instantiateObject = instantiateObject();
                this.mMap.put(str, instantiateObject);
                return instantiateObject;
            } else {
                T t4 = this.mCurOverflow;
                T t5 = t4;
                if (t4 == null) {
                    t5 = instantiateObject();
                    this.mCurOverflow = t5;
                    this.mMap.put(OVERFLOW_NAME, t5);
                }
                if (this.mActiveOverflow == null) {
                    this.mActiveOverflow = new ArrayMap<>();
                }
                this.mActiveOverflow.put(str, new MutableInt(1));
                return t5;
            }
        }

        public T stopObject(String str) {
            MutableInt mutableInt;
            T t;
            T t2 = this.mMap.get(str);
            if (t2 != null) {
                return t2;
            }
            if (this.mActiveOverflow == null || (mutableInt = this.mActiveOverflow.get(str)) == null || (t = this.mCurOverflow) == null) {
                Slog.wtf(BatteryStatsImpl.TAG, "Unable to find object for " + str + " mapsize=" + this.mMap.size() + " activeoverflow=" + this.mActiveOverflow + " curoverflow=" + this.mCurOverflow);
                return null;
            }
            mutableInt.value--;
            if (mutableInt.value <= 0) {
                this.mActiveOverflow.remove(str);
            }
            return t;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$SamplingCounter.class */
    public static class SamplingCounter extends Counter {
        SamplingCounter(TimeBase timeBase) {
            super(timeBase);
        }

        SamplingCounter(TimeBase timeBase, Parcel parcel) {
            super(timeBase, parcel);
        }

        public void addCountAtomic(long j) {
            this.mCount.addAndGet((int) j);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$SamplingTimer.class */
    public static final class SamplingTimer extends Timer {
        int mCurrentReportedCount;
        long mCurrentReportedTotalTime;
        boolean mTimeBaseRunning;
        boolean mTrackingReportedValues;
        int mUnpluggedReportedCount;
        long mUnpluggedReportedTotalTime;
        int mUpdateVersion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        SamplingTimer(TimeBase timeBase, Parcel parcel) {
            super(0, timeBase, parcel);
            boolean z = true;
            this.mCurrentReportedCount = parcel.readInt();
            this.mUnpluggedReportedCount = parcel.readInt();
            this.mCurrentReportedTotalTime = parcel.readLong();
            this.mUnpluggedReportedTotalTime = parcel.readLong();
            this.mTrackingReportedValues = parcel.readInt() != 1 ? false : z;
            this.mTimeBaseRunning = timeBase.isRunning();
        }

        SamplingTimer(TimeBase timeBase, boolean z) {
            super(0, timeBase);
            this.mTrackingReportedValues = z;
            this.mTimeBaseRunning = timeBase.isRunning();
        }

        public void addCurrentReportedCount(int i) {
            updateCurrentReportedCount(this.mCurrentReportedCount + i);
        }

        public void addCurrentReportedTotalTime(long j) {
            updateCurrentReportedTotalTime(this.mCurrentReportedTotalTime + j);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        protected int computeCurrentCountLocked() {
            return ((this.mTimeBaseRunning && this.mTrackingReportedValues) ? this.mCurrentReportedCount - this.mUnpluggedReportedCount : 0) + this.mCount;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        protected long computeRunTimeLocked(long j) {
            return ((this.mTimeBaseRunning && this.mTrackingReportedValues) ? this.mCurrentReportedTotalTime - this.mUnpluggedReportedTotalTime : 0L) + this.mTotalTime;
        }

        public int getUpdateVersion() {
            return this.mUpdateVersion;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        public void logState(Printer printer, String str) {
            super.logState(printer, str);
            printer.println(str + "mCurrentReportedCount=" + this.mCurrentReportedCount + " mUnpluggedReportedCount=" + this.mUnpluggedReportedCount + " mCurrentReportedTotalTime=" + this.mCurrentReportedTotalTime + " mUnpluggedReportedTotalTime=" + this.mUnpluggedReportedTotalTime);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer, com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStarted(long j, long j2, long j3) {
            super.onTimeStarted(j, j2, j3);
            if (this.mTrackingReportedValues) {
                this.mUnpluggedReportedTotalTime = this.mCurrentReportedTotalTime;
                this.mUnpluggedReportedCount = this.mCurrentReportedCount;
            }
            this.mTimeBaseRunning = true;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer, com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long j, long j2, long j3) {
            super.onTimeStopped(j, j2, j3);
            this.mTimeBaseRunning = false;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        void readSummaryFromParcelLocked(Parcel parcel) {
            boolean z = true;
            super.readSummaryFromParcelLocked(parcel);
            long readLong = parcel.readLong();
            this.mCurrentReportedTotalTime = readLong;
            this.mUnpluggedReportedTotalTime = readLong;
            int readInt = parcel.readInt();
            this.mCurrentReportedCount = readInt;
            this.mUnpluggedReportedCount = readInt;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.mTrackingReportedValues = z;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        boolean reset(boolean z) {
            super.reset(z);
            setStale();
            return true;
        }

        public void setStale() {
            this.mTrackingReportedValues = false;
            this.mUnpluggedReportedTotalTime = 0L;
            this.mUnpluggedReportedCount = 0;
        }

        public void setUpdateVersion(int i) {
            this.mUpdateVersion = i;
        }

        public void updateCurrentReportedCount(int i) {
            if (this.mTimeBaseRunning && this.mUnpluggedReportedCount == 0) {
                this.mUnpluggedReportedCount = i;
                this.mTrackingReportedValues = true;
            }
            this.mCurrentReportedCount = i;
        }

        public void updateCurrentReportedTotalTime(long j) {
            if (this.mTimeBaseRunning && this.mUnpluggedReportedTotalTime == 0) {
                this.mUnpluggedReportedTotalTime = j;
                this.mTrackingReportedValues = true;
            }
            this.mCurrentReportedTotalTime = j;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        void writeSummaryFromParcelLocked(Parcel parcel, long j) {
            super.writeSummaryFromParcelLocked(parcel, j);
            parcel.writeLong(this.mCurrentReportedTotalTime);
            parcel.writeInt(this.mCurrentReportedCount);
            parcel.writeInt(this.mTrackingReportedValues ? 1 : 0);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel parcel, long j) {
            super.writeToParcel(parcel, j);
            parcel.writeInt(this.mCurrentReportedCount);
            parcel.writeInt(this.mUnpluggedReportedCount);
            parcel.writeLong(this.mCurrentReportedTotalTime);
            parcel.writeLong(this.mUnpluggedReportedTotalTime);
            parcel.writeInt(this.mTrackingReportedValues ? 1 : 0);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$StopwatchTimer.class */
    public static final class StopwatchTimer extends Timer {
        long mAcquireTime;
        boolean mInList;
        int mNesting;
        long mTimeout;
        final ArrayList<StopwatchTimer> mTimerPool;
        final Uid mUid;
        long mUpdateTime;

        StopwatchTimer(Uid uid, int i, ArrayList<StopwatchTimer> arrayList, TimeBase timeBase) {
            super(i, timeBase);
            this.mUid = uid;
            this.mTimerPool = arrayList;
        }

        StopwatchTimer(Uid uid, int i, ArrayList<StopwatchTimer> arrayList, TimeBase timeBase, Parcel parcel) {
            super(i, timeBase, parcel);
            this.mUid = uid;
            this.mTimerPool = arrayList;
            this.mUpdateTime = parcel.readLong();
        }

        private static long refreshTimersLocked(long j, ArrayList<StopwatchTimer> arrayList, StopwatchTimer stopwatchTimer) {
            long j2 = 0;
            int size = arrayList.size();
            int i = size - 1;
            while (i >= 0) {
                StopwatchTimer stopwatchTimer2 = arrayList.get(i);
                long j3 = j - stopwatchTimer2.mUpdateTime;
                long j4 = j2;
                if (j3 > 0) {
                    long j5 = j3 / size;
                    if (stopwatchTimer2 == stopwatchTimer) {
                        j2 = j5;
                    }
                    stopwatchTimer2.mTotalTime += j5;
                    j4 = j2;
                }
                stopwatchTimer2.mUpdateTime = j;
                i--;
                j2 = j4;
            }
            return j2;
        }

        long checkpointRunningLocked(long j) {
            if (this.mNesting > 0) {
                long realtime = this.mTimeBase.getRealtime(1000 * j);
                if (this.mTimerPool != null) {
                    return refreshTimersLocked(realtime, this.mTimerPool, this);
                }
                long j2 = realtime - this.mUpdateTime;
                this.mUpdateTime = realtime;
                this.mTotalTime += j2;
                return j2;
            }
            return 0L;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        protected int computeCurrentCountLocked() {
            return this.mCount;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        protected long computeRunTimeLocked(long j) {
            long j2 = j;
            if (this.mTimeout > 0) {
                j2 = j;
                if (j > this.mUpdateTime + this.mTimeout) {
                    j2 = this.mUpdateTime + this.mTimeout;
                }
            }
            long j3 = this.mTotalTime;
            long j4 = 0;
            if (this.mNesting > 0) {
                j4 = (j2 - this.mUpdateTime) / (this.mTimerPool != null ? this.mTimerPool.size() : 1);
            }
            return j4 + j3;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        void detach() {
            super.detach();
            if (this.mTimerPool != null) {
                this.mTimerPool.remove(this);
            }
        }

        boolean isRunningLocked() {
            return this.mNesting > 0;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        public void logState(Printer printer, String str) {
            super.logState(printer, str);
            printer.println(str + "mNesting=" + this.mNesting + " mUpdateTime=" + this.mUpdateTime + " mAcquireTime=" + this.mAcquireTime);
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer, com.android.internal.os.BatteryStatsImpl.TimeBaseObs
        public void onTimeStopped(long j, long j2, long j3) {
            if (this.mNesting > 0) {
                super.onTimeStopped(j, j2, j3);
                this.mUpdateTime = j3;
            }
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        void readSummaryFromParcelLocked(Parcel parcel) {
            super.readSummaryFromParcelLocked(parcel);
            this.mNesting = 0;
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        boolean reset(boolean z) {
            boolean z2 = this.mNesting <= 0;
            super.reset(z2 && z);
            if (this.mNesting > 0) {
                this.mUpdateTime = this.mTimeBase.getRealtime(SystemClock.elapsedRealtime() * 1000);
            }
            this.mAcquireTime = this.mTotalTime;
            return z2;
        }

        void setTimeout(long j) {
            this.mTimeout = j;
        }

        void startRunningLocked(long j) {
            int i = this.mNesting;
            this.mNesting = i + 1;
            if (i == 0) {
                long realtime = this.mTimeBase.getRealtime(1000 * j);
                this.mUpdateTime = realtime;
                if (this.mTimerPool != null) {
                    refreshTimersLocked(realtime, this.mTimerPool, null);
                    this.mTimerPool.add(this);
                }
                this.mCount++;
                this.mAcquireTime = this.mTotalTime;
            }
        }

        void stopAllRunningLocked(long j) {
            if (this.mNesting > 0) {
                this.mNesting = 1;
                stopRunningLocked(j);
            }
        }

        void stopRunningLocked(long j) {
            if (this.mNesting == 0) {
                return;
            }
            int i = this.mNesting - 1;
            this.mNesting = i;
            if (i == 0) {
                long realtime = this.mTimeBase.getRealtime(1000 * j);
                if (this.mTimerPool != null) {
                    refreshTimersLocked(realtime, this.mTimerPool, null);
                    this.mTimerPool.remove(this);
                } else {
                    this.mNesting = 1;
                    this.mTotalTime = computeRunTimeLocked(realtime);
                    this.mNesting = 0;
                }
                if (this.mTotalTime == this.mAcquireTime) {
                    this.mCount--;
                }
            }
        }

        @Override // com.android.internal.os.BatteryStatsImpl.Timer
        public void writeToParcel(Parcel parcel, long j) {
            super.writeToParcel(parcel, j);
            parcel.writeLong(this.mUpdateTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$TimeBase.class */
    public static class TimeBase {
        private final ArrayList<TimeBaseObs> mObservers = new ArrayList<>();
        private long mPastRealtime;
        private long mPastUptime;
        private long mRealtime;
        private long mRealtimeStart;
        private boolean mRunning;
        private long mUnpluggedRealtime;
        private long mUnpluggedUptime;
        private long mUptime;
        private long mUptimeStart;

        TimeBase() {
        }

        public void add(TimeBaseObs timeBaseObs) {
            this.mObservers.add(timeBaseObs);
        }

        public long computeRealtime(long j, int i) {
            switch (i) {
                case 0:
                    return this.mRealtime + getRealtime(j);
                case 1:
                    return getRealtime(j);
                case 2:
                    return getRealtime(j) - this.mUnpluggedRealtime;
                default:
                    return 0L;
            }
        }

        public long computeUptime(long j, int i) {
            switch (i) {
                case 0:
                    return this.mUptime + getUptime(j);
                case 1:
                    return getUptime(j);
                case 2:
                    return getUptime(j) - this.mUnpluggedUptime;
                default:
                    return 0L;
            }
        }

        public void dump(PrintWriter printWriter, String str) {
            StringBuilder sb = new StringBuilder(128);
            printWriter.print(str);
            printWriter.print("mRunning=");
            printWriter.println(this.mRunning);
            sb.setLength(0);
            sb.append(str);
            sb.append("mUptime=");
            BatteryStats.formatTimeMs(sb, this.mUptime / 1000);
            printWriter.println(sb.toString());
            sb.setLength(0);
            sb.append(str);
            sb.append("mRealtime=");
            BatteryStats.formatTimeMs(sb, this.mRealtime / 1000);
            printWriter.println(sb.toString());
            sb.setLength(0);
            sb.append(str);
            sb.append("mPastUptime=");
            BatteryStats.formatTimeMs(sb, this.mPastUptime / 1000);
            sb.append("mUptimeStart=");
            BatteryStats.formatTimeMs(sb, this.mUptimeStart / 1000);
            sb.append("mUnpluggedUptime=");
            BatteryStats.formatTimeMs(sb, this.mUnpluggedUptime / 1000);
            printWriter.println(sb.toString());
            sb.setLength(0);
            sb.append(str);
            sb.append("mPastRealtime=");
            BatteryStats.formatTimeMs(sb, this.mPastRealtime / 1000);
            sb.append("mRealtimeStart=");
            BatteryStats.formatTimeMs(sb, this.mRealtimeStart / 1000);
            sb.append("mUnpluggedRealtime=");
            BatteryStats.formatTimeMs(sb, this.mUnpluggedRealtime / 1000);
            printWriter.println(sb.toString());
        }

        public long getRealtime(long j) {
            long j2 = this.mPastRealtime;
            long j3 = j2;
            if (this.mRunning) {
                j3 = j2 + (j - this.mRealtimeStart);
            }
            return j3;
        }

        public long getRealtimeStart() {
            return this.mRealtimeStart;
        }

        public long getUptime(long j) {
            long j2 = this.mPastUptime;
            long j3 = j2;
            if (this.mRunning) {
                j3 = j2 + (j - this.mUptimeStart);
            }
            return j3;
        }

        public long getUptimeStart() {
            return this.mUptimeStart;
        }

        public void init(long j, long j2) {
            this.mRealtime = 0L;
            this.mUptime = 0L;
            this.mPastUptime = 0L;
            this.mPastRealtime = 0L;
            this.mUptimeStart = j;
            this.mRealtimeStart = j2;
            this.mUnpluggedUptime = getUptime(this.mUptimeStart);
            this.mUnpluggedRealtime = getRealtime(this.mRealtimeStart);
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void readFromParcel(Parcel parcel) {
            this.mRunning = false;
            this.mUptime = parcel.readLong();
            this.mPastUptime = parcel.readLong();
            this.mUptimeStart = parcel.readLong();
            this.mRealtime = parcel.readLong();
            this.mPastRealtime = parcel.readLong();
            this.mRealtimeStart = parcel.readLong();
            this.mUnpluggedUptime = parcel.readLong();
            this.mUnpluggedRealtime = parcel.readLong();
        }

        public void readSummaryFromParcel(Parcel parcel) {
            this.mUptime = parcel.readLong();
            this.mRealtime = parcel.readLong();
        }

        public void remove(TimeBaseObs timeBaseObs) {
            if (this.mObservers.remove(timeBaseObs)) {
                return;
            }
            Slog.wtf(BatteryStatsImpl.TAG, "Removed unknown observer: " + timeBaseObs);
        }

        public void reset(long j, long j2) {
            if (!this.mRunning) {
                this.mPastUptime = 0L;
                this.mPastRealtime = 0L;
                return;
            }
            this.mUptimeStart = j;
            this.mRealtimeStart = j2;
            this.mUnpluggedUptime = getUptime(j);
            this.mUnpluggedRealtime = getRealtime(j2);
        }

        public boolean setRunning(boolean z, long j, long j2) {
            if (this.mRunning == z) {
                return false;
            }
            this.mRunning = z;
            if (z) {
                this.mUptimeStart = j;
                this.mRealtimeStart = j2;
                long uptime = getUptime(j);
                this.mUnpluggedUptime = uptime;
                long realtime = getRealtime(j2);
                this.mUnpluggedRealtime = realtime;
                int size = this.mObservers.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        return true;
                    }
                    this.mObservers.get(i).onTimeStarted(j2, uptime, realtime);
                    size = i;
                }
            } else {
                this.mPastUptime += j - this.mUptimeStart;
                this.mPastRealtime += j2 - this.mRealtimeStart;
                long uptime2 = getUptime(j);
                long realtime2 = getRealtime(j2);
                int size2 = this.mObservers.size();
                while (true) {
                    int i2 = size2 - 1;
                    if (i2 < 0) {
                        return true;
                    }
                    this.mObservers.get(i2).onTimeStopped(j2, uptime2, realtime2);
                    size2 = i2;
                }
            }
        }

        public void writeSummaryToParcel(Parcel parcel, long j, long j2) {
            parcel.writeLong(computeUptime(j, 0));
            parcel.writeLong(computeRealtime(j2, 0));
        }

        public void writeToParcel(Parcel parcel, long j, long j2) {
            long uptime = getUptime(j);
            long realtime = getRealtime(j2);
            parcel.writeLong(this.mUptime);
            parcel.writeLong(uptime);
            parcel.writeLong(this.mUptimeStart);
            parcel.writeLong(this.mRealtime);
            parcel.writeLong(realtime);
            parcel.writeLong(this.mRealtimeStart);
            parcel.writeLong(this.mUnpluggedUptime);
            parcel.writeLong(this.mUnpluggedRealtime);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$TimeBaseObs.class */
    public interface TimeBaseObs {
        void onTimeStarted(long j, long j2, long j3);

        void onTimeStopped(long j, long j2, long j3);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Timer.class */
    public static abstract class Timer extends BatteryStats.Timer implements TimeBaseObs {
        int mCount;
        int mLastCount;
        long mLastTime;
        int mLoadedCount;
        long mLoadedTime;
        final TimeBase mTimeBase;
        long mTotalTime;
        final int mType;
        int mUnpluggedCount;
        long mUnpluggedTime;

        Timer(int i, TimeBase timeBase) {
            this.mType = i;
            this.mTimeBase = timeBase;
            timeBase.add(this);
        }

        Timer(int i, TimeBase timeBase, Parcel parcel) {
            this.mType = i;
            this.mTimeBase = timeBase;
            this.mCount = parcel.readInt();
            this.mLoadedCount = parcel.readInt();
            this.mLastCount = 0;
            this.mUnpluggedCount = parcel.readInt();
            this.mTotalTime = parcel.readLong();
            this.mLoadedTime = parcel.readLong();
            this.mLastTime = 0L;
            this.mUnpluggedTime = parcel.readLong();
            timeBase.add(this);
        }

        public static void writeTimerToParcel(Parcel parcel, Timer timer, long j) {
            if (timer == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            timer.writeToParcel(parcel, j);
        }

        protected abstract int computeCurrentCountLocked();

        protected abstract long computeRunTimeLocked(long j);

        void detach() {
            this.mTimeBase.remove(this);
        }

        public int getCountLocked(int i) {
            int i2;
            int computeCurrentCountLocked = computeCurrentCountLocked();
            if (i == 2) {
                i2 = computeCurrentCountLocked - this.mUnpluggedCount;
            } else {
                i2 = computeCurrentCountLocked;
                if (i != 0) {
                    return computeCurrentCountLocked - this.mLoadedCount;
                }
            }
            return i2;
        }

        public long getTotalTimeLocked(long j, int i) {
            long j2;
            long computeRunTimeLocked = computeRunTimeLocked(this.mTimeBase.getRealtime(j));
            if (i == 2) {
                j2 = computeRunTimeLocked - this.mUnpluggedTime;
            } else {
                j2 = computeRunTimeLocked;
                if (i != 0) {
                    return computeRunTimeLocked - this.mLoadedTime;
                }
            }
            return j2;
        }

        public void logState(Printer printer, String str) {
            printer.println(str + "mCount=" + this.mCount + " mLoadedCount=" + this.mLoadedCount + " mLastCount=" + this.mLastCount + " mUnpluggedCount=" + this.mUnpluggedCount);
            printer.println(str + "mTotalTime=" + this.mTotalTime + " mLoadedTime=" + this.mLoadedTime);
            printer.println(str + "mLastTime=" + this.mLastTime + " mUnpluggedTime=" + this.mUnpluggedTime);
        }

        public void onTimeStarted(long j, long j2, long j3) {
            this.mUnpluggedTime = computeRunTimeLocked(j3);
            this.mUnpluggedCount = this.mCount;
        }

        public void onTimeStopped(long j, long j2, long j3) {
            this.mTotalTime = computeRunTimeLocked(j3);
            this.mCount = computeCurrentCountLocked();
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            long readLong = parcel.readLong();
            this.mLoadedTime = readLong;
            this.mTotalTime = readLong;
            this.mLastTime = 0L;
            this.mUnpluggedTime = this.mTotalTime;
            int readInt = parcel.readInt();
            this.mLoadedCount = readInt;
            this.mCount = readInt;
            this.mLastCount = 0;
            this.mUnpluggedCount = this.mCount;
        }

        boolean reset(boolean z) {
            this.mLastTime = 0L;
            this.mLoadedTime = 0L;
            this.mTotalTime = 0L;
            this.mLastCount = 0;
            this.mLoadedCount = 0;
            this.mCount = 0;
            if (z) {
                detach();
                return true;
            }
            return true;
        }

        void writeSummaryFromParcelLocked(Parcel parcel, long j) {
            parcel.writeLong(computeRunTimeLocked(this.mTimeBase.getRealtime(j)));
            parcel.writeInt(this.mCount);
        }

        public void writeToParcel(Parcel parcel, long j) {
            parcel.writeInt(this.mCount);
            parcel.writeInt(this.mLoadedCount);
            parcel.writeInt(this.mUnpluggedCount);
            parcel.writeLong(computeRunTimeLocked(this.mTimeBase.getRealtime(j)));
            parcel.writeLong(this.mLoadedTime);
            parcel.writeLong(this.mUnpluggedTime);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Uid.class */
    public final class Uid extends BatteryStats.Uid {
        static final int NO_BATCHED_SCAN_STARTED = -1;
        static final int PROCESS_STATE_NONE = 3;
        StopwatchTimer mAudioTurnedOnTimer;
        StopwatchTimer mForegroundActivityTimer;
        boolean mFullWifiLockOut;
        StopwatchTimer mFullWifiLockTimer;
        LongSamplingCounter mMobileRadioActiveCount;
        LongSamplingCounter mMobileRadioActiveTime;
        LongSamplingCounter[] mNetworkByteActivityCounters;
        LongSamplingCounter[] mNetworkPacketActivityCounters;
        final int mUid;
        Counter[] mUserActivityCounters;
        BatchTimer mVibratorOnTimer;
        StopwatchTimer mVideoTurnedOnTimer;
        boolean mWifiMulticastEnabled;
        StopwatchTimer mWifiMulticastTimer;
        boolean mWifiRunning;
        StopwatchTimer mWifiRunningTimer;
        boolean mWifiScanStarted;
        StopwatchTimer mWifiScanTimer;
        int mWifiBatchedScanBinStarted = -1;
        int mProcessState = 3;
        final OverflowArrayMap<Wakelock> mWakelockStats = new OverflowArrayMap<Wakelock>() { // from class: com.android.internal.os.BatteryStatsImpl.Uid.1
            {
                BatteryStatsImpl batteryStatsImpl = BatteryStatsImpl.this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.internal.os.BatteryStatsImpl.OverflowArrayMap
            public Wakelock instantiateObject() {
                return new Wakelock();
            }
        };
        final OverflowArrayMap<StopwatchTimer> mSyncStats = new OverflowArrayMap<StopwatchTimer>() { // from class: com.android.internal.os.BatteryStatsImpl.Uid.2
            {
                BatteryStatsImpl batteryStatsImpl = BatteryStatsImpl.this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.internal.os.BatteryStatsImpl.OverflowArrayMap
            public StopwatchTimer instantiateObject() {
                return new StopwatchTimer(Uid.this, 13, null, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
        };
        final OverflowArrayMap<StopwatchTimer> mJobStats = new OverflowArrayMap<StopwatchTimer>() { // from class: com.android.internal.os.BatteryStatsImpl.Uid.3
            {
                BatteryStatsImpl batteryStatsImpl = BatteryStatsImpl.this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.internal.os.BatteryStatsImpl.OverflowArrayMap
            public StopwatchTimer instantiateObject() {
                return new StopwatchTimer(Uid.this, 14, null, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
        };
        final SparseArray<Sensor> mSensorStats = new SparseArray<>();
        final ArrayMap<String, Proc> mProcessStats = new ArrayMap<>();
        final ArrayMap<String, Pkg> mPackageStats = new ArrayMap<>();
        final SparseArray<BatteryStats.Uid.Pid> mPids = new SparseArray<>();
        StopwatchTimer[] mWifiBatchedScanTimer = new StopwatchTimer[5];
        StopwatchTimer[] mProcessStateTimer = new StopwatchTimer[3];

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Uid$Pkg.class */
        public final class Pkg extends BatteryStats.Uid.Pkg implements TimeBaseObs {
            int mLastWakeups;
            int mLoadedWakeups;
            final HashMap<String, Serv> mServiceStats = new HashMap<>();
            int mUnpluggedWakeups;
            int mWakeups;

            /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Uid$Pkg$Serv.class */
            public final class Serv extends BatteryStats.Uid.Pkg.Serv implements TimeBaseObs {
                int mLastLaunches;
                long mLastStartTime;
                int mLastStarts;
                boolean mLaunched;
                long mLaunchedSince;
                long mLaunchedTime;
                int mLaunches;
                int mLoadedLaunches;
                long mLoadedStartTime;
                int mLoadedStarts;
                boolean mRunning;
                long mRunningSince;
                long mStartTime;
                int mStarts;
                int mUnpluggedLaunches;
                long mUnpluggedStartTime;
                int mUnpluggedStarts;

                Serv() {
                    super(Pkg.this);
                    BatteryStatsImpl.this.mOnBatteryTimeBase.add(this);
                }

                void detach() {
                    BatteryStatsImpl.this.mOnBatteryTimeBase.remove(this);
                }

                public BatteryStatsImpl getBatteryStats() {
                    return BatteryStatsImpl.this;
                }

                long getLaunchTimeToNowLocked(long j) {
                    return !this.mLaunched ? this.mLaunchedTime : (this.mLaunchedTime + j) - this.mLaunchedSince;
                }

                public int getLaunches(int i) {
                    int i2;
                    int i3 = this.mLaunches;
                    if (i == 1) {
                        i2 = i3 - this.mLoadedLaunches;
                    } else {
                        i2 = i3;
                        if (i == 2) {
                            return i3 - this.mUnpluggedLaunches;
                        }
                    }
                    return i2;
                }

                public long getStartTime(long j, int i) {
                    long j2;
                    long startTimeToNowLocked = getStartTimeToNowLocked(j);
                    if (i == 1) {
                        j2 = startTimeToNowLocked - this.mLoadedStartTime;
                    } else {
                        j2 = startTimeToNowLocked;
                        if (i == 2) {
                            return startTimeToNowLocked - this.mUnpluggedStartTime;
                        }
                    }
                    return j2;
                }

                long getStartTimeToNowLocked(long j) {
                    return !this.mRunning ? this.mStartTime : (this.mStartTime + j) - this.mRunningSince;
                }

                public int getStarts(int i) {
                    int i2;
                    int i3 = this.mStarts;
                    if (i == 1) {
                        i2 = i3 - this.mLoadedStarts;
                    } else {
                        i2 = i3;
                        if (i == 2) {
                            return i3 - this.mUnpluggedStarts;
                        }
                    }
                    return i2;
                }

                @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
                public void onTimeStarted(long j, long j2, long j3) {
                    this.mUnpluggedStartTime = getStartTimeToNowLocked(j2);
                    this.mUnpluggedStarts = this.mStarts;
                    this.mUnpluggedLaunches = this.mLaunches;
                }

                @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
                public void onTimeStopped(long j, long j2, long j3) {
                }

                void readFromParcelLocked(Parcel parcel) {
                    this.mStartTime = parcel.readLong();
                    this.mRunningSince = parcel.readLong();
                    this.mRunning = parcel.readInt() != 0;
                    this.mStarts = parcel.readInt();
                    this.mLaunchedTime = parcel.readLong();
                    this.mLaunchedSince = parcel.readLong();
                    this.mLaunched = parcel.readInt() != 0;
                    this.mLaunches = parcel.readInt();
                    this.mLoadedStartTime = parcel.readLong();
                    this.mLoadedStarts = parcel.readInt();
                    this.mLoadedLaunches = parcel.readInt();
                    this.mLastStartTime = 0L;
                    this.mLastStarts = 0;
                    this.mLastLaunches = 0;
                    this.mUnpluggedStartTime = parcel.readLong();
                    this.mUnpluggedStarts = parcel.readInt();
                    this.mUnpluggedLaunches = parcel.readInt();
                }

                public void startLaunchedLocked() {
                    if (this.mLaunched) {
                        return;
                    }
                    this.mLaunches++;
                    this.mLaunchedSince = BatteryStatsImpl.this.getBatteryUptimeLocked();
                    this.mLaunched = true;
                }

                public void startRunningLocked() {
                    if (this.mRunning) {
                        return;
                    }
                    this.mStarts++;
                    this.mRunningSince = BatteryStatsImpl.this.getBatteryUptimeLocked();
                    this.mRunning = true;
                }

                public void stopLaunchedLocked() {
                    if (this.mLaunched) {
                        long batteryUptimeLocked = BatteryStatsImpl.this.getBatteryUptimeLocked() - this.mLaunchedSince;
                        if (batteryUptimeLocked > 0) {
                            this.mLaunchedTime += batteryUptimeLocked;
                        } else {
                            this.mLaunches--;
                        }
                        this.mLaunched = false;
                    }
                }

                public void stopRunningLocked() {
                    if (this.mRunning) {
                        long batteryUptimeLocked = BatteryStatsImpl.this.getBatteryUptimeLocked() - this.mRunningSince;
                        if (batteryUptimeLocked > 0) {
                            this.mStartTime += batteryUptimeLocked;
                        } else {
                            this.mStarts--;
                        }
                        this.mRunning = false;
                    }
                }

                void writeToParcelLocked(Parcel parcel) {
                    parcel.writeLong(this.mStartTime);
                    parcel.writeLong(this.mRunningSince);
                    parcel.writeInt(this.mRunning ? 1 : 0);
                    parcel.writeInt(this.mStarts);
                    parcel.writeLong(this.mLaunchedTime);
                    parcel.writeLong(this.mLaunchedSince);
                    parcel.writeInt(this.mLaunched ? 1 : 0);
                    parcel.writeInt(this.mLaunches);
                    parcel.writeLong(this.mLoadedStartTime);
                    parcel.writeInt(this.mLoadedStarts);
                    parcel.writeInt(this.mLoadedLaunches);
                    parcel.writeLong(this.mUnpluggedStartTime);
                    parcel.writeInt(this.mUnpluggedStarts);
                    parcel.writeInt(this.mUnpluggedLaunches);
                }
            }

            Pkg() {
                BatteryStatsImpl.this.mOnBatteryScreenOffTimeBase.add(this);
            }

            void detach() {
                BatteryStatsImpl.this.mOnBatteryScreenOffTimeBase.remove(this);
            }

            public BatteryStatsImpl getBatteryStats() {
                return BatteryStatsImpl.this;
            }

            public Map<String, ? extends BatteryStats.Uid.Pkg.Serv> getServiceStats() {
                return this.mServiceStats;
            }

            public int getWakeups(int i) {
                int i2;
                int i3 = this.mWakeups;
                if (i == 1) {
                    i2 = i3 - this.mLoadedWakeups;
                } else {
                    i2 = i3;
                    if (i == 2) {
                        return i3 - this.mUnpluggedWakeups;
                    }
                }
                return i2;
            }

            public void incWakeupsLocked() {
                this.mWakeups++;
            }

            final Serv newServiceStatsLocked() {
                return new Serv();
            }

            @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
            public void onTimeStarted(long j, long j2, long j3) {
                this.mUnpluggedWakeups = this.mWakeups;
            }

            @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
            public void onTimeStopped(long j, long j2, long j3) {
            }

            void readFromParcelLocked(Parcel parcel) {
                this.mWakeups = parcel.readInt();
                this.mLoadedWakeups = parcel.readInt();
                this.mLastWakeups = 0;
                this.mUnpluggedWakeups = parcel.readInt();
                int readInt = parcel.readInt();
                this.mServiceStats.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return;
                    }
                    String readString = parcel.readString();
                    Serv serv = new Serv();
                    this.mServiceStats.put(readString, serv);
                    serv.readFromParcelLocked(parcel);
                    i = i2 + 1;
                }
            }

            void writeToParcelLocked(Parcel parcel) {
                parcel.writeInt(this.mWakeups);
                parcel.writeInt(this.mLoadedWakeups);
                parcel.writeInt(this.mUnpluggedWakeups);
                parcel.writeInt(this.mServiceStats.size());
                for (Map.Entry<String, Serv> entry : this.mServiceStats.entrySet()) {
                    parcel.writeString(entry.getKey());
                    entry.getValue().writeToParcelLocked(parcel);
                }
            }
        }

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Uid$Proc.class */
        public final class Proc extends BatteryStats.Uid.Proc implements TimeBaseObs {
            ArrayList<BatteryStats.Uid.Proc.ExcessivePower> mExcessivePower;
            long mForegroundTime;
            long mLoadedForegroundTime;
            int mLoadedNumAnrs;
            int mLoadedNumCrashes;
            int mLoadedStarts;
            long mLoadedSystemTime;
            long mLoadedUserTime;
            final String mName;
            int mNumAnrs;
            int mNumCrashes;
            SamplingCounter[] mSpeedBins;
            int mStarts;
            long mSystemTime;
            long mUnpluggedForegroundTime;
            int mUnpluggedNumAnrs;
            int mUnpluggedNumCrashes;
            int mUnpluggedStarts;
            long mUnpluggedSystemTime;
            long mUnpluggedUserTime;
            long mUserTime;
            boolean mActive = true;
            int mProcessState = 3;

            Proc(String str) {
                this.mName = str;
                BatteryStatsImpl.this.mOnBatteryTimeBase.add(this);
                this.mSpeedBins = new SamplingCounter[BatteryStatsImpl.this.getCpuSpeedSteps()];
            }

            public void addCpuTimeLocked(int i, int i2) {
                this.mUserTime += i;
                this.mSystemTime += i2;
            }

            public void addExcessiveCpu(long j, long j2) {
                if (this.mExcessivePower == null) {
                    this.mExcessivePower = new ArrayList<>();
                }
                BatteryStats.Uid.Proc.ExcessivePower excessivePower = new BatteryStats.Uid.Proc.ExcessivePower();
                excessivePower.type = 2;
                excessivePower.overTime = j;
                excessivePower.usedTime = j2;
                this.mExcessivePower.add(excessivePower);
            }

            public void addExcessiveWake(long j, long j2) {
                if (this.mExcessivePower == null) {
                    this.mExcessivePower = new ArrayList<>();
                }
                BatteryStats.Uid.Proc.ExcessivePower excessivePower = new BatteryStats.Uid.Proc.ExcessivePower();
                excessivePower.type = 1;
                excessivePower.overTime = j;
                excessivePower.usedTime = j2;
                this.mExcessivePower.add(excessivePower);
            }

            public void addForegroundTimeLocked(long j) {
                this.mForegroundTime += j;
            }

            public void addSpeedStepTimes(long[] jArr) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mSpeedBins.length || i2 >= jArr.length) {
                        return;
                    }
                    if (jArr[i2] != 0) {
                        SamplingCounter samplingCounter = this.mSpeedBins[i2];
                        SamplingCounter samplingCounter2 = samplingCounter;
                        if (samplingCounter == null) {
                            SamplingCounter[] samplingCounterArr = this.mSpeedBins;
                            samplingCounter2 = new SamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase);
                            samplingCounterArr[i2] = samplingCounter2;
                        }
                        samplingCounter2.addCountAtomic(jArr[i2]);
                    }
                    i = i2 + 1;
                }
            }

            public int countExcessivePowers() {
                if (this.mExcessivePower != null) {
                    return this.mExcessivePower.size();
                }
                return 0;
            }

            void detach() {
                this.mActive = false;
                BatteryStatsImpl.this.mOnBatteryTimeBase.remove(this);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mSpeedBins.length) {
                        return;
                    }
                    SamplingCounter samplingCounter = this.mSpeedBins[i2];
                    if (samplingCounter != null) {
                        BatteryStatsImpl.this.mOnBatteryTimeBase.remove(samplingCounter);
                        this.mSpeedBins[i2] = null;
                    }
                    i = i2 + 1;
                }
            }

            public BatteryStatsImpl getBatteryStats() {
                return BatteryStatsImpl.this;
            }

            public BatteryStats.Uid.Proc.ExcessivePower getExcessivePower(int i) {
                if (this.mExcessivePower != null) {
                    return this.mExcessivePower.get(i);
                }
                return null;
            }

            public long getForegroundTime(int i) {
                long j;
                long j2 = this.mForegroundTime;
                if (i == 1) {
                    j = j2 - this.mLoadedForegroundTime;
                } else {
                    j = j2;
                    if (i == 2) {
                        return j2 - this.mUnpluggedForegroundTime;
                    }
                }
                return j;
            }

            public int getNumAnrs(int i) {
                int i2;
                int i3 = this.mNumAnrs;
                if (i == 1) {
                    i2 = i3 - this.mLoadedNumAnrs;
                } else {
                    i2 = i3;
                    if (i == 2) {
                        return i3 - this.mUnpluggedNumAnrs;
                    }
                }
                return i2;
            }

            public int getNumCrashes(int i) {
                int i2;
                int i3 = this.mNumCrashes;
                if (i == 1) {
                    i2 = i3 - this.mLoadedNumCrashes;
                } else {
                    i2 = i3;
                    if (i == 2) {
                        return i3 - this.mUnpluggedNumCrashes;
                    }
                }
                return i2;
            }

            public int getStarts(int i) {
                int i2;
                int i3 = this.mStarts;
                if (i == 1) {
                    i2 = i3 - this.mLoadedStarts;
                } else {
                    i2 = i3;
                    if (i == 2) {
                        return i3 - this.mUnpluggedStarts;
                    }
                }
                return i2;
            }

            public long getSystemTime(int i) {
                long j;
                long j2 = this.mSystemTime;
                if (i == 1) {
                    j = j2 - this.mLoadedSystemTime;
                } else {
                    j = j2;
                    if (i == 2) {
                        return j2 - this.mUnpluggedSystemTime;
                    }
                }
                return j;
            }

            public long getTimeAtCpuSpeedStep(int i, int i2) {
                long j = 0;
                if (i < this.mSpeedBins.length) {
                    SamplingCounter samplingCounter = this.mSpeedBins[i];
                    j = 0;
                    if (samplingCounter != null) {
                        j = samplingCounter.getCountLocked(i2);
                    }
                }
                return j;
            }

            public long getUserTime(int i) {
                long j;
                long j2 = this.mUserTime;
                if (i == 1) {
                    j = j2 - this.mLoadedUserTime;
                } else {
                    j = j2;
                    if (i == 2) {
                        return j2 - this.mUnpluggedUserTime;
                    }
                }
                return j;
            }

            public void incNumAnrsLocked() {
                this.mNumAnrs++;
            }

            public void incNumCrashesLocked() {
                this.mNumCrashes++;
            }

            public void incStartsLocked() {
                this.mStarts++;
            }

            public boolean isActive() {
                return this.mActive;
            }

            @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
            public void onTimeStarted(long j, long j2, long j3) {
                this.mUnpluggedUserTime = this.mUserTime;
                this.mUnpluggedSystemTime = this.mSystemTime;
                this.mUnpluggedForegroundTime = this.mForegroundTime;
                this.mUnpluggedStarts = this.mStarts;
                this.mUnpluggedNumCrashes = this.mNumCrashes;
                this.mUnpluggedNumAnrs = this.mNumAnrs;
            }

            @Override // com.android.internal.os.BatteryStatsImpl.TimeBaseObs
            public void onTimeStopped(long j, long j2, long j3) {
            }

            boolean readExcessivePowerFromParcelLocked(Parcel parcel) {
                int readInt = parcel.readInt();
                if (readInt == 0) {
                    this.mExcessivePower = null;
                    return true;
                } else if (readInt > 10000) {
                    Slog.w(BatteryStatsImpl.TAG, "File corrupt: too many excessive power entries " + readInt);
                    return false;
                } else {
                    this.mExcessivePower = new ArrayList<>();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= readInt) {
                            return true;
                        }
                        BatteryStats.Uid.Proc.ExcessivePower excessivePower = new BatteryStats.Uid.Proc.ExcessivePower();
                        excessivePower.type = parcel.readInt();
                        excessivePower.overTime = parcel.readLong();
                        excessivePower.usedTime = parcel.readLong();
                        this.mExcessivePower.add(excessivePower);
                        i = i2 + 1;
                    }
                }
            }

            void readFromParcelLocked(Parcel parcel) {
                this.mUserTime = parcel.readLong();
                this.mSystemTime = parcel.readLong();
                this.mForegroundTime = parcel.readLong();
                this.mStarts = parcel.readInt();
                this.mNumCrashes = parcel.readInt();
                this.mNumAnrs = parcel.readInt();
                this.mLoadedUserTime = parcel.readLong();
                this.mLoadedSystemTime = parcel.readLong();
                this.mLoadedForegroundTime = parcel.readLong();
                this.mLoadedStarts = parcel.readInt();
                this.mLoadedNumCrashes = parcel.readInt();
                this.mLoadedNumAnrs = parcel.readInt();
                this.mUnpluggedUserTime = parcel.readLong();
                this.mUnpluggedSystemTime = parcel.readLong();
                this.mUnpluggedForegroundTime = parcel.readLong();
                this.mUnpluggedStarts = parcel.readInt();
                this.mUnpluggedNumCrashes = parcel.readInt();
                this.mUnpluggedNumAnrs = parcel.readInt();
                int readInt = parcel.readInt();
                int cpuSpeedSteps = BatteryStatsImpl.this.getCpuSpeedSteps();
                int i = cpuSpeedSteps;
                if (readInt >= cpuSpeedSteps) {
                    i = readInt;
                }
                this.mSpeedBins = new SamplingCounter[i];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= readInt) {
                        readExcessivePowerFromParcelLocked(parcel);
                        return;
                    }
                    if (parcel.readInt() != 0) {
                        this.mSpeedBins[i3] = new SamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                    }
                    i2 = i3 + 1;
                }
            }

            void reset() {
                this.mForegroundTime = 0L;
                this.mSystemTime = 0L;
                this.mUserTime = 0L;
                this.mNumAnrs = 0;
                this.mNumCrashes = 0;
                this.mStarts = 0;
                this.mLoadedForegroundTime = 0L;
                this.mLoadedSystemTime = 0L;
                this.mLoadedUserTime = 0L;
                this.mLoadedNumAnrs = 0;
                this.mLoadedNumCrashes = 0;
                this.mLoadedStarts = 0;
                this.mUnpluggedForegroundTime = 0L;
                this.mUnpluggedSystemTime = 0L;
                this.mUnpluggedUserTime = 0L;
                this.mUnpluggedNumAnrs = 0;
                this.mUnpluggedNumCrashes = 0;
                this.mUnpluggedStarts = 0;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mSpeedBins.length) {
                        this.mExcessivePower = null;
                        return;
                    }
                    SamplingCounter samplingCounter = this.mSpeedBins[i2];
                    if (samplingCounter != null) {
                        samplingCounter.reset(false);
                    }
                    i = i2 + 1;
                }
            }

            void writeExcessivePowerToParcelLocked(Parcel parcel) {
                if (this.mExcessivePower == null) {
                    parcel.writeInt(0);
                    return;
                }
                int size = this.mExcessivePower.size();
                parcel.writeInt(size);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return;
                    }
                    BatteryStats.Uid.Proc.ExcessivePower excessivePower = this.mExcessivePower.get(i2);
                    parcel.writeInt(excessivePower.type);
                    parcel.writeLong(excessivePower.overTime);
                    parcel.writeLong(excessivePower.usedTime);
                    i = i2 + 1;
                }
            }

            void writeToParcelLocked(Parcel parcel) {
                parcel.writeLong(this.mUserTime);
                parcel.writeLong(this.mSystemTime);
                parcel.writeLong(this.mForegroundTime);
                parcel.writeInt(this.mStarts);
                parcel.writeInt(this.mNumCrashes);
                parcel.writeInt(this.mNumAnrs);
                parcel.writeLong(this.mLoadedUserTime);
                parcel.writeLong(this.mLoadedSystemTime);
                parcel.writeLong(this.mLoadedForegroundTime);
                parcel.writeInt(this.mLoadedStarts);
                parcel.writeInt(this.mLoadedNumCrashes);
                parcel.writeInt(this.mLoadedNumAnrs);
                parcel.writeLong(this.mUnpluggedUserTime);
                parcel.writeLong(this.mUnpluggedSystemTime);
                parcel.writeLong(this.mUnpluggedForegroundTime);
                parcel.writeInt(this.mUnpluggedStarts);
                parcel.writeInt(this.mUnpluggedNumCrashes);
                parcel.writeInt(this.mUnpluggedNumAnrs);
                parcel.writeInt(this.mSpeedBins.length);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mSpeedBins.length) {
                        writeExcessivePowerToParcelLocked(parcel);
                        return;
                    }
                    SamplingCounter samplingCounter = this.mSpeedBins[i2];
                    if (samplingCounter != null) {
                        parcel.writeInt(1);
                        samplingCounter.writeToParcel(parcel);
                    } else {
                        parcel.writeInt(0);
                    }
                    i = i2 + 1;
                }
            }
        }

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Uid$Sensor.class */
        public final class Sensor extends BatteryStats.Uid.Sensor {
            final int mHandle;
            StopwatchTimer mTimer;

            public Sensor(int i) {
                this.mHandle = i;
            }

            private StopwatchTimer readTimerFromParcel(TimeBase timeBase, Parcel parcel) {
                if (parcel.readInt() == 0) {
                    return null;
                }
                ArrayList<StopwatchTimer> arrayList = BatteryStatsImpl.this.mSensorTimers.get(this.mHandle);
                ArrayList<StopwatchTimer> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<>();
                    BatteryStatsImpl.this.mSensorTimers.put(this.mHandle, arrayList2);
                }
                return new StopwatchTimer(Uid.this, 0, arrayList2, timeBase, parcel);
            }

            public int getHandle() {
                return this.mHandle;
            }

            public Timer getSensorTime() {
                return this.mTimer;
            }

            void readFromParcelLocked(TimeBase timeBase, Parcel parcel) {
                this.mTimer = readTimerFromParcel(timeBase, parcel);
            }

            boolean reset() {
                if (this.mTimer.reset(true)) {
                    this.mTimer = null;
                    return true;
                }
                return false;
            }

            void writeToParcelLocked(Parcel parcel, long j) {
                Timer.writeTimerToParcel(parcel, this.mTimer, j);
            }
        }

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsImpl$Uid$Wakelock.class */
        public final class Wakelock extends BatteryStats.Uid.Wakelock {
            StopwatchTimer mTimerFull;
            StopwatchTimer mTimerPartial;
            StopwatchTimer mTimerWindow;

            public Wakelock() {
            }

            private StopwatchTimer readTimerFromParcel(int i, ArrayList<StopwatchTimer> arrayList, TimeBase timeBase, Parcel parcel) {
                if (parcel.readInt() == 0) {
                    return null;
                }
                return new StopwatchTimer(Uid.this, i, arrayList, timeBase, parcel);
            }

            public StopwatchTimer getStopwatchTimer(int i) {
                switch (i) {
                    case 0:
                        StopwatchTimer stopwatchTimer = this.mTimerPartial;
                        StopwatchTimer stopwatchTimer2 = stopwatchTimer;
                        if (stopwatchTimer == null) {
                            stopwatchTimer2 = new StopwatchTimer(Uid.this, 0, BatteryStatsImpl.this.mPartialTimers, BatteryStatsImpl.this.mOnBatteryScreenOffTimeBase);
                            this.mTimerPartial = stopwatchTimer2;
                        }
                        return stopwatchTimer2;
                    case 1:
                        StopwatchTimer stopwatchTimer3 = this.mTimerFull;
                        StopwatchTimer stopwatchTimer4 = stopwatchTimer3;
                        if (stopwatchTimer3 == null) {
                            stopwatchTimer4 = new StopwatchTimer(Uid.this, 1, BatteryStatsImpl.this.mFullTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
                            this.mTimerFull = stopwatchTimer4;
                        }
                        return stopwatchTimer4;
                    case 2:
                        StopwatchTimer stopwatchTimer5 = this.mTimerWindow;
                        StopwatchTimer stopwatchTimer6 = stopwatchTimer5;
                        if (stopwatchTimer5 == null) {
                            stopwatchTimer6 = new StopwatchTimer(Uid.this, 2, BatteryStatsImpl.this.mWindowTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
                            this.mTimerWindow = stopwatchTimer6;
                        }
                        return stopwatchTimer6;
                    default:
                        throw new IllegalArgumentException("type=" + i);
                }
            }

            public Timer getWakeTime(int i) {
                switch (i) {
                    case 0:
                        return this.mTimerPartial;
                    case 1:
                        return this.mTimerFull;
                    case 2:
                        return this.mTimerWindow;
                    default:
                        throw new IllegalArgumentException("type = " + i);
                }
            }

            void readFromParcelLocked(TimeBase timeBase, TimeBase timeBase2, Parcel parcel) {
                this.mTimerPartial = readTimerFromParcel(0, BatteryStatsImpl.this.mPartialTimers, timeBase2, parcel);
                this.mTimerFull = readTimerFromParcel(1, BatteryStatsImpl.this.mFullTimers, timeBase, parcel);
                this.mTimerWindow = readTimerFromParcel(2, BatteryStatsImpl.this.mWindowTimers, timeBase, parcel);
            }

            boolean reset() {
                boolean z = false;
                if (this.mTimerFull != null) {
                    z = false | (!this.mTimerFull.reset(false));
                }
                boolean z2 = z;
                if (this.mTimerPartial != null) {
                    z2 = z | (!this.mTimerPartial.reset(false));
                }
                boolean z3 = z2;
                if (this.mTimerWindow != null) {
                    z3 = z2 | (!this.mTimerWindow.reset(false));
                }
                if (!z3) {
                    if (this.mTimerFull != null) {
                        this.mTimerFull.detach();
                        this.mTimerFull = null;
                    }
                    if (this.mTimerPartial != null) {
                        this.mTimerPartial.detach();
                        this.mTimerPartial = null;
                    }
                    if (this.mTimerWindow != null) {
                        this.mTimerWindow.detach();
                        this.mTimerWindow = null;
                    }
                }
                return !z3;
            }

            void writeToParcelLocked(Parcel parcel, long j) {
                Timer.writeTimerToParcel(parcel, this.mTimerPartial, j);
                Timer.writeTimerToParcel(parcel, this.mTimerFull, j);
                Timer.writeTimerToParcel(parcel, this.mTimerWindow, j);
            }
        }

        public Uid(int i) {
            this.mUid = i;
            this.mWifiRunningTimer = new StopwatchTimer(this, 4, BatteryStatsImpl.this.mWifiRunningTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            this.mFullWifiLockTimer = new StopwatchTimer(this, 5, BatteryStatsImpl.this.mFullWifiLockTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            this.mWifiScanTimer = new StopwatchTimer(this, 6, BatteryStatsImpl.this.mWifiScanTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            this.mWifiMulticastTimer = new StopwatchTimer(this, 7, BatteryStatsImpl.this.mWifiMulticastTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
        }

        public StopwatchTimer createAudioTurnedOnTimerLocked() {
            if (this.mAudioTurnedOnTimer == null) {
                this.mAudioTurnedOnTimer = new StopwatchTimer(this, 15, BatteryStatsImpl.this.mAudioTurnedOnTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            return this.mAudioTurnedOnTimer;
        }

        public StopwatchTimer createForegroundActivityTimerLocked() {
            if (this.mForegroundActivityTimer == null) {
                this.mForegroundActivityTimer = new StopwatchTimer(this, 10, null, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            return this.mForegroundActivityTimer;
        }

        public BatchTimer createVibratorOnTimerLocked() {
            if (this.mVibratorOnTimer == null) {
                this.mVibratorOnTimer = new BatchTimer(this, 9, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            return this.mVibratorOnTimer;
        }

        public StopwatchTimer createVideoTurnedOnTimerLocked() {
            if (this.mVideoTurnedOnTimer == null) {
                this.mVideoTurnedOnTimer = new StopwatchTimer(this, 8, BatteryStatsImpl.this.mVideoTurnedOnTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            return this.mVideoTurnedOnTimer;
        }

        public long getAudioTurnedOnTime(long j, int i) {
            if (this.mAudioTurnedOnTimer == null) {
                return 0L;
            }
            return this.mAudioTurnedOnTimer.getTotalTimeLocked(j, i);
        }

        public BatteryStatsImpl getBatteryStats() {
            return BatteryStatsImpl.this;
        }

        public Timer getForegroundActivityTimer() {
            return this.mForegroundActivityTimer;
        }

        public long getFullWifiLockTime(long j, int i) {
            if (this.mFullWifiLockTimer == null) {
                return 0L;
            }
            return this.mFullWifiLockTimer.getTotalTimeLocked(j, i);
        }

        public Map<String, ? extends BatteryStats.Timer> getJobStats() {
            return this.mJobStats.getMap();
        }

        public int getMobileRadioActiveCount(int i) {
            if (this.mMobileRadioActiveCount != null) {
                return (int) this.mMobileRadioActiveCount.getCountLocked(i);
            }
            return 0;
        }

        public long getMobileRadioActiveTime(int i) {
            if (this.mMobileRadioActiveTime != null) {
                return this.mMobileRadioActiveTime.getCountLocked(i);
            }
            return 0L;
        }

        public long getNetworkActivityBytes(int i, int i2) {
            if (this.mNetworkByteActivityCounters == null || i < 0 || i >= this.mNetworkByteActivityCounters.length) {
                return 0L;
            }
            return this.mNetworkByteActivityCounters[i].getCountLocked(i2);
        }

        public long getNetworkActivityPackets(int i, int i2) {
            if (this.mNetworkPacketActivityCounters == null || i < 0 || i >= this.mNetworkPacketActivityCounters.length) {
                return 0L;
            }
            return this.mNetworkPacketActivityCounters[i].getCountLocked(i2);
        }

        public Map<String, ? extends BatteryStats.Uid.Pkg> getPackageStats() {
            return this.mPackageStats;
        }

        public Pkg getPackageStatsLocked(String str) {
            Pkg pkg = this.mPackageStats.get(str);
            Pkg pkg2 = pkg;
            if (pkg == null) {
                pkg2 = new Pkg();
                this.mPackageStats.put(str, pkg2);
            }
            return pkg2;
        }

        public SparseArray<? extends BatteryStats.Uid.Pid> getPidStats() {
            return this.mPids;
        }

        public BatteryStats.Uid.Pid getPidStatsLocked(int i) {
            BatteryStats.Uid.Pid pid = this.mPids.get(i);
            BatteryStats.Uid.Pid pid2 = pid;
            if (pid == null) {
                pid2 = new BatteryStats.Uid.Pid(this);
                this.mPids.put(i, pid2);
            }
            return pid2;
        }

        public long getProcessStateTime(int i, long j, int i2) {
            if (i < 0 || i >= 3 || this.mProcessStateTimer[i] == null) {
                return 0L;
            }
            return this.mProcessStateTimer[i].getTotalTimeLocked(j, i2);
        }

        public Map<String, ? extends BatteryStats.Uid.Proc> getProcessStats() {
            return this.mProcessStats;
        }

        public Proc getProcessStatsLocked(String str) {
            Proc proc = this.mProcessStats.get(str);
            Proc proc2 = proc;
            if (proc == null) {
                proc2 = new Proc(str);
                this.mProcessStats.put(str, proc2);
            }
            return proc2;
        }

        public SparseArray<? extends BatteryStats.Uid.Sensor> getSensorStats() {
            return this.mSensorStats;
        }

        public StopwatchTimer getSensorTimerLocked(int i, boolean z) {
            StopwatchTimer stopwatchTimer;
            Sensor sensor = this.mSensorStats.get(i);
            Sensor sensor2 = sensor;
            if (sensor == null) {
                if (!z) {
                    stopwatchTimer = null;
                    return stopwatchTimer;
                }
                sensor2 = new Sensor(i);
                this.mSensorStats.put(i, sensor2);
            }
            StopwatchTimer stopwatchTimer2 = sensor2.mTimer;
            stopwatchTimer = stopwatchTimer2;
            if (stopwatchTimer2 == null) {
                ArrayList<StopwatchTimer> arrayList = BatteryStatsImpl.this.mSensorTimers.get(i);
                ArrayList<StopwatchTimer> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<>();
                    BatteryStatsImpl.this.mSensorTimers.put(i, arrayList2);
                }
                StopwatchTimer stopwatchTimer3 = new StopwatchTimer(this, 3, arrayList2, BatteryStatsImpl.this.mOnBatteryTimeBase);
                sensor2.mTimer = stopwatchTimer3;
                return stopwatchTimer3;
            }
            return stopwatchTimer;
        }

        public Pkg.Serv getServiceStatsLocked(String str, String str2) {
            Pkg packageStatsLocked = getPackageStatsLocked(str);
            Pkg.Serv serv = packageStatsLocked.mServiceStats.get(str2);
            Pkg.Serv serv2 = serv;
            if (serv == null) {
                serv2 = packageStatsLocked.newServiceStatsLocked();
                packageStatsLocked.mServiceStats.put(str2, serv2);
            }
            return serv2;
        }

        public Map<String, ? extends BatteryStats.Timer> getSyncStats() {
            return this.mSyncStats.getMap();
        }

        public int getUid() {
            return this.mUid;
        }

        public int getUserActivityCount(int i, int i2) {
            if (this.mUserActivityCounters == null) {
                return 0;
            }
            return this.mUserActivityCounters[i].getCountLocked(i2);
        }

        public Timer getVibratorOnTimer() {
            return this.mVibratorOnTimer;
        }

        public long getVideoTurnedOnTime(long j, int i) {
            if (this.mVideoTurnedOnTimer == null) {
                return 0L;
            }
            return this.mVideoTurnedOnTimer.getTotalTimeLocked(j, i);
        }

        public Map<String, ? extends BatteryStats.Uid.Wakelock> getWakelockStats() {
            return this.mWakelockStats.getMap();
        }

        public long getWifiBatchedScanTime(int i, long j, int i2) {
            if (i < 0 || i >= 5 || this.mWifiBatchedScanTimer[i] == null) {
                return 0L;
            }
            return this.mWifiBatchedScanTimer[i].getTotalTimeLocked(j, i2);
        }

        public long getWifiMulticastTime(long j, int i) {
            if (this.mWifiMulticastTimer == null) {
                return 0L;
            }
            return this.mWifiMulticastTimer.getTotalTimeLocked(j, i);
        }

        public long getWifiRunningTime(long j, int i) {
            if (this.mWifiRunningTimer == null) {
                return 0L;
            }
            return this.mWifiRunningTimer.getTotalTimeLocked(j, i);
        }

        public long getWifiScanTime(long j, int i) {
            if (this.mWifiScanTimer == null) {
                return 0L;
            }
            return this.mWifiScanTimer.getTotalTimeLocked(j, i);
        }

        public boolean hasNetworkActivity() {
            return this.mNetworkByteActivityCounters != null;
        }

        public boolean hasUserActivity() {
            return this.mUserActivityCounters != null;
        }

        void initNetworkActivityLocked() {
            this.mNetworkByteActivityCounters = new LongSamplingCounter[4];
            this.mNetworkPacketActivityCounters = new LongSamplingCounter[4];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    this.mMobileRadioActiveTime = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase);
                    this.mMobileRadioActiveCount = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase);
                    return;
                }
                this.mNetworkByteActivityCounters[i2] = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase);
                this.mNetworkPacketActivityCounters[i2] = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase);
                i = i2 + 1;
            }
        }

        void initUserActivityLocked() {
            this.mUserActivityCounters = new Counter[3];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    return;
                }
                this.mUserActivityCounters[i2] = new Counter(BatteryStatsImpl.this.mOnBatteryTimeBase);
                i = i2 + 1;
            }
        }

        void makeProcessState(int i, Parcel parcel) {
            if (i < 0 || i >= 3) {
                return;
            }
            if (parcel == null) {
                this.mProcessStateTimer[i] = new StopwatchTimer(this, 12, null, BatteryStatsImpl.this.mOnBatteryTimeBase);
            } else {
                this.mProcessStateTimer[i] = new StopwatchTimer(this, 12, null, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            }
        }

        void makeWifiBatchedScanBin(int i, Parcel parcel) {
            if (i < 0 || i >= 5) {
                return;
            }
            ArrayList<StopwatchTimer> arrayList = BatteryStatsImpl.this.mWifiBatchedScanTimers.get(i);
            ArrayList<StopwatchTimer> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
                BatteryStatsImpl.this.mWifiBatchedScanTimers.put(i, arrayList2);
            }
            if (parcel == null) {
                this.mWifiBatchedScanTimer[i] = new StopwatchTimer(this, 11, arrayList2, BatteryStatsImpl.this.mOnBatteryTimeBase);
            } else {
                this.mWifiBatchedScanTimer[i] = new StopwatchTimer(this, 11, arrayList2, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            }
        }

        public void noteActivityPausedLocked(long j) {
            if (this.mForegroundActivityTimer != null) {
                this.mForegroundActivityTimer.stopRunningLocked(j);
            }
        }

        public void noteActivityResumedLocked(long j) {
            createForegroundActivityTimerLocked().startRunningLocked(j);
        }

        public void noteAudioTurnedOffLocked(long j) {
            if (this.mAudioTurnedOnTimer != null) {
                this.mAudioTurnedOnTimer.stopRunningLocked(j);
            }
        }

        public void noteAudioTurnedOnLocked(long j) {
            createAudioTurnedOnTimerLocked().startRunningLocked(j);
        }

        public void noteFullWifiLockAcquiredLocked(long j) {
            if (this.mFullWifiLockOut) {
                return;
            }
            this.mFullWifiLockOut = true;
            if (this.mFullWifiLockTimer == null) {
                this.mFullWifiLockTimer = new StopwatchTimer(this, 5, BatteryStatsImpl.this.mFullWifiLockTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            this.mFullWifiLockTimer.startRunningLocked(j);
        }

        public void noteFullWifiLockReleasedLocked(long j) {
            if (this.mFullWifiLockOut) {
                this.mFullWifiLockOut = false;
                this.mFullWifiLockTimer.stopRunningLocked(j);
            }
        }

        void noteMobileRadioActiveTimeLocked(long j) {
            if (this.mNetworkByteActivityCounters == null) {
                initNetworkActivityLocked();
            }
            this.mMobileRadioActiveTime.addCountLocked(j);
            this.mMobileRadioActiveCount.addCountLocked(1L);
        }

        void noteNetworkActivityLocked(int i, long j, long j2) {
            if (this.mNetworkByteActivityCounters == null) {
                initNetworkActivityLocked();
            }
            if (i < 0 || i >= 4) {
                Slog.w(BatteryStatsImpl.TAG, "Unknown network activity type " + i + " was specified.", new Throwable());
                return;
            }
            this.mNetworkByteActivityCounters[i].addCountLocked(j);
            this.mNetworkPacketActivityCounters[i].addCountLocked(j2);
        }

        public void noteResetAudioLocked(long j) {
            if (this.mAudioTurnedOnTimer != null) {
                this.mAudioTurnedOnTimer.stopAllRunningLocked(j);
            }
        }

        public void noteResetVideoLocked(long j) {
            if (this.mVideoTurnedOnTimer != null) {
                this.mVideoTurnedOnTimer.stopAllRunningLocked(j);
            }
        }

        public void noteStartGps(long j) {
            StopwatchTimer sensorTimerLocked = getSensorTimerLocked(-10000, true);
            if (sensorTimerLocked != null) {
                sensorTimerLocked.startRunningLocked(j);
            }
        }

        public void noteStartJobLocked(String str, long j) {
            StopwatchTimer startObject = this.mJobStats.startObject(str);
            if (startObject != null) {
                startObject.startRunningLocked(j);
            }
        }

        public void noteStartSensor(int i, long j) {
            StopwatchTimer sensorTimerLocked = getSensorTimerLocked(i, true);
            if (sensorTimerLocked != null) {
                sensorTimerLocked.startRunningLocked(j);
            }
        }

        public void noteStartSyncLocked(String str, long j) {
            StopwatchTimer startObject = this.mSyncStats.startObject(str);
            if (startObject != null) {
                startObject.startRunningLocked(j);
            }
        }

        public void noteStartWakeLocked(int i, String str, int i2, long j) {
            Wakelock startObject = this.mWakelockStats.startObject(str);
            if (startObject != null) {
                startObject.getStopwatchTimer(i2).startRunningLocked(j);
            }
            if (i < 0 || i2 != 0) {
                return;
            }
            BatteryStats.Uid.Pid pidStatsLocked = getPidStatsLocked(i);
            int i3 = pidStatsLocked.mWakeNesting;
            pidStatsLocked.mWakeNesting = i3 + 1;
            if (i3 == 0) {
                pidStatsLocked.mWakeStartMs = j;
            }
        }

        public void noteStopGps(long j) {
            StopwatchTimer sensorTimerLocked = getSensorTimerLocked(-10000, false);
            if (sensorTimerLocked != null) {
                sensorTimerLocked.stopRunningLocked(j);
            }
        }

        public void noteStopJobLocked(String str, long j) {
            StopwatchTimer stopObject = this.mJobStats.stopObject(str);
            if (stopObject != null) {
                stopObject.stopRunningLocked(j);
            }
        }

        public void noteStopSensor(int i, long j) {
            StopwatchTimer sensorTimerLocked = getSensorTimerLocked(i, false);
            if (sensorTimerLocked != null) {
                sensorTimerLocked.stopRunningLocked(j);
            }
        }

        public void noteStopSyncLocked(String str, long j) {
            StopwatchTimer stopObject = this.mSyncStats.stopObject(str);
            if (stopObject != null) {
                stopObject.stopRunningLocked(j);
            }
        }

        public void noteStopWakeLocked(int i, String str, int i2, long j) {
            BatteryStats.Uid.Pid pid;
            Wakelock stopObject = this.mWakelockStats.stopObject(str);
            if (stopObject != null) {
                stopObject.getStopwatchTimer(i2).stopRunningLocked(j);
            }
            if (i < 0 || i2 != 0 || (pid = this.mPids.get(i)) == null || pid.mWakeNesting <= 0) {
                return;
            }
            int i3 = pid.mWakeNesting;
            pid.mWakeNesting = i3 - 1;
            if (i3 == 1) {
                pid.mWakeSumMs += j - pid.mWakeStartMs;
                pid.mWakeStartMs = 0L;
            }
        }

        public void noteUserActivityLocked(int i) {
            if (this.mUserActivityCounters == null) {
                initUserActivityLocked();
            }
            if (i < 0 || i >= 3) {
                Slog.w(BatteryStatsImpl.TAG, "Unknown user activity type " + i + " was specified.", new Throwable());
            } else {
                this.mUserActivityCounters[i].stepAtomic();
            }
        }

        public void noteVibratorOffLocked() {
            if (this.mVibratorOnTimer != null) {
                this.mVibratorOnTimer.abortLastDuration(BatteryStatsImpl.this);
            }
        }

        public void noteVibratorOnLocked(long j) {
            createVibratorOnTimerLocked().addDuration(BatteryStatsImpl.this, j);
        }

        public void noteVideoTurnedOffLocked(long j) {
            if (this.mVideoTurnedOnTimer != null) {
                this.mVideoTurnedOnTimer.stopRunningLocked(j);
            }
        }

        public void noteVideoTurnedOnLocked(long j) {
            createVideoTurnedOnTimerLocked().startRunningLocked(j);
        }

        public void noteWifiBatchedScanStartedLocked(int i, long j) {
            int i2;
            int i3 = i;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i3 <= 8 || i2 >= 5) {
                    break;
                }
                i3 >>= 3;
                i4 = i2 + 1;
            }
            if (this.mWifiBatchedScanBinStarted == i2) {
                return;
            }
            if (this.mWifiBatchedScanBinStarted != -1) {
                this.mWifiBatchedScanTimer[this.mWifiBatchedScanBinStarted].stopRunningLocked(j);
            }
            this.mWifiBatchedScanBinStarted = i2;
            if (this.mWifiBatchedScanTimer[i2] == null) {
                makeWifiBatchedScanBin(i2, null);
            }
            this.mWifiBatchedScanTimer[i2].startRunningLocked(j);
        }

        public void noteWifiBatchedScanStoppedLocked(long j) {
            if (this.mWifiBatchedScanBinStarted != -1) {
                this.mWifiBatchedScanTimer[this.mWifiBatchedScanBinStarted].stopRunningLocked(j);
                this.mWifiBatchedScanBinStarted = -1;
            }
        }

        public void noteWifiMulticastDisabledLocked(long j) {
            if (this.mWifiMulticastEnabled) {
                this.mWifiMulticastEnabled = false;
                this.mWifiMulticastTimer.stopRunningLocked(j);
            }
        }

        public void noteWifiMulticastEnabledLocked(long j) {
            if (this.mWifiMulticastEnabled) {
                return;
            }
            this.mWifiMulticastEnabled = true;
            if (this.mWifiMulticastTimer == null) {
                this.mWifiMulticastTimer = new StopwatchTimer(this, 7, BatteryStatsImpl.this.mWifiMulticastTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            this.mWifiMulticastTimer.startRunningLocked(j);
        }

        public void noteWifiRunningLocked(long j) {
            if (this.mWifiRunning) {
                return;
            }
            this.mWifiRunning = true;
            if (this.mWifiRunningTimer == null) {
                this.mWifiRunningTimer = new StopwatchTimer(this, 4, BatteryStatsImpl.this.mWifiRunningTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            this.mWifiRunningTimer.startRunningLocked(j);
        }

        public void noteWifiScanStartedLocked(long j) {
            if (this.mWifiScanStarted) {
                return;
            }
            this.mWifiScanStarted = true;
            if (this.mWifiScanTimer == null) {
                this.mWifiScanTimer = new StopwatchTimer(this, 6, BatteryStatsImpl.this.mWifiScanTimers, BatteryStatsImpl.this.mOnBatteryTimeBase);
            }
            this.mWifiScanTimer.startRunningLocked(j);
        }

        public void noteWifiScanStoppedLocked(long j) {
            if (this.mWifiScanStarted) {
                this.mWifiScanStarted = false;
                this.mWifiScanTimer.stopRunningLocked(j);
            }
        }

        public void noteWifiStoppedLocked(long j) {
            if (this.mWifiRunning) {
                this.mWifiRunning = false;
                this.mWifiRunningTimer.stopRunningLocked(j);
            }
        }

        void readFromParcelLocked(TimeBase timeBase, TimeBase timeBase2, Parcel parcel) {
            int readInt = parcel.readInt();
            this.mWakelockStats.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                String readString = parcel.readString();
                Wakelock wakelock = new Wakelock();
                wakelock.readFromParcelLocked(timeBase, timeBase2, parcel);
                this.mWakelockStats.add(readString, wakelock);
                i = i2 + 1;
            }
            int readInt2 = parcel.readInt();
            this.mSyncStats.clear();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt2) {
                    break;
                }
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    this.mSyncStats.add(readString2, new StopwatchTimer(this, 13, null, timeBase, parcel));
                }
                i3 = i4 + 1;
            }
            int readInt3 = parcel.readInt();
            this.mJobStats.clear();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= readInt3) {
                    break;
                }
                String readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    this.mJobStats.add(readString3, new StopwatchTimer(this, 14, null, timeBase, parcel));
                }
                i5 = i6 + 1;
            }
            int readInt4 = parcel.readInt();
            this.mSensorStats.clear();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= readInt4) {
                    break;
                }
                int readInt5 = parcel.readInt();
                Sensor sensor = new Sensor(readInt5);
                sensor.readFromParcelLocked(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                this.mSensorStats.put(readInt5, sensor);
                i7 = i8 + 1;
            }
            int readInt6 = parcel.readInt();
            this.mProcessStats.clear();
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= readInt6) {
                    break;
                }
                String readString4 = parcel.readString();
                Proc proc = new Proc(readString4);
                proc.readFromParcelLocked(parcel);
                this.mProcessStats.put(readString4, proc);
                i9 = i10 + 1;
            }
            int readInt7 = parcel.readInt();
            this.mPackageStats.clear();
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= readInt7) {
                    break;
                }
                String readString5 = parcel.readString();
                Pkg pkg = new Pkg();
                pkg.readFromParcelLocked(parcel);
                this.mPackageStats.put(readString5, pkg);
                i11 = i12 + 1;
            }
            this.mWifiRunning = false;
            if (parcel.readInt() != 0) {
                this.mWifiRunningTimer = new StopwatchTimer(this, 4, BatteryStatsImpl.this.mWifiRunningTimers, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mWifiRunningTimer = null;
            }
            this.mFullWifiLockOut = false;
            if (parcel.readInt() != 0) {
                this.mFullWifiLockTimer = new StopwatchTimer(this, 5, BatteryStatsImpl.this.mFullWifiLockTimers, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mFullWifiLockTimer = null;
            }
            this.mWifiScanStarted = false;
            if (parcel.readInt() != 0) {
                this.mWifiScanTimer = new StopwatchTimer(this, 6, BatteryStatsImpl.this.mWifiScanTimers, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mWifiScanTimer = null;
            }
            this.mWifiBatchedScanBinStarted = -1;
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= 5) {
                    break;
                }
                if (parcel.readInt() != 0) {
                    makeWifiBatchedScanBin(i14, parcel);
                } else {
                    this.mWifiBatchedScanTimer[i14] = null;
                }
                i13 = i14 + 1;
            }
            this.mWifiMulticastEnabled = false;
            if (parcel.readInt() != 0) {
                this.mWifiMulticastTimer = new StopwatchTimer(this, 7, BatteryStatsImpl.this.mWifiMulticastTimers, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mWifiMulticastTimer = null;
            }
            if (parcel.readInt() != 0) {
                this.mAudioTurnedOnTimer = new StopwatchTimer(this, 15, BatteryStatsImpl.this.mAudioTurnedOnTimers, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mAudioTurnedOnTimer = null;
            }
            if (parcel.readInt() != 0) {
                this.mVideoTurnedOnTimer = new StopwatchTimer(this, 8, BatteryStatsImpl.this.mVideoTurnedOnTimers, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mVideoTurnedOnTimer = null;
            }
            if (parcel.readInt() != 0) {
                this.mForegroundActivityTimer = new StopwatchTimer(this, 10, null, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mForegroundActivityTimer = null;
            }
            this.mProcessState = 3;
            int i15 = 0;
            while (true) {
                int i16 = i15;
                if (i16 >= 3) {
                    break;
                }
                if (parcel.readInt() != 0) {
                    makeProcessState(i16, parcel);
                } else {
                    this.mProcessStateTimer[i16] = null;
                }
                i15 = i16 + 1;
            }
            if (parcel.readInt() != 0) {
                this.mVibratorOnTimer = new BatchTimer(this, 9, BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
            } else {
                this.mVibratorOnTimer = null;
            }
            if (parcel.readInt() != 0) {
                this.mUserActivityCounters = new Counter[3];
                int i17 = 0;
                while (true) {
                    int i18 = i17;
                    if (i18 >= 3) {
                        break;
                    }
                    this.mUserActivityCounters[i18] = new Counter(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                    i17 = i18 + 1;
                }
            } else {
                this.mUserActivityCounters = null;
            }
            if (parcel.readInt() == 0) {
                this.mNetworkByteActivityCounters = null;
                this.mNetworkPacketActivityCounters = null;
                return;
            }
            this.mNetworkByteActivityCounters = new LongSamplingCounter[4];
            this.mNetworkPacketActivityCounters = new LongSamplingCounter[4];
            int i19 = 0;
            while (true) {
                int i20 = i19;
                if (i20 >= 4) {
                    this.mMobileRadioActiveTime = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                    this.mMobileRadioActiveCount = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                    return;
                }
                this.mNetworkByteActivityCounters[i20] = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                this.mNetworkPacketActivityCounters[i20] = new LongSamplingCounter(BatteryStatsImpl.this.mOnBatteryTimeBase, parcel);
                i19 = i20 + 1;
            }
        }

        public void readJobSummaryFromParcelLocked(String str, Parcel parcel) {
            StopwatchTimer instantiateObject = this.mJobStats.instantiateObject();
            instantiateObject.readSummaryFromParcelLocked(parcel);
            this.mJobStats.add(str, instantiateObject);
        }

        public void readSyncSummaryFromParcelLocked(String str, Parcel parcel) {
            StopwatchTimer instantiateObject = this.mSyncStats.instantiateObject();
            instantiateObject.readSummaryFromParcelLocked(parcel);
            this.mSyncStats.add(str, instantiateObject);
        }

        public void readWakeSummaryFromParcelLocked(String str, Parcel parcel) {
            Wakelock wakelock = new Wakelock();
            this.mWakelockStats.add(str, wakelock);
            if (parcel.readInt() != 0) {
                wakelock.getStopwatchTimer(1).readSummaryFromParcelLocked(parcel);
            }
            if (parcel.readInt() != 0) {
                wakelock.getStopwatchTimer(0).readSummaryFromParcelLocked(parcel);
            }
            if (parcel.readInt() != 0) {
                wakelock.getStopwatchTimer(2).readSummaryFromParcelLocked(parcel);
            }
        }

        public void reportExcessiveCpuLocked(String str, long j, long j2) {
            Proc processStatsLocked = getProcessStatsLocked(str);
            if (processStatsLocked != null) {
                processStatsLocked.addExcessiveCpu(j, j2);
            }
        }

        public void reportExcessiveWakeLocked(String str, long j, long j2) {
            Proc processStatsLocked = getProcessStatsLocked(str);
            if (processStatsLocked != null) {
                processStatsLocked.addExcessiveWake(j, j2);
            }
        }

        boolean reset() {
            boolean z = this.mWifiRunningTimer != null ? false | (!this.mWifiRunningTimer.reset(false)) | this.mWifiRunning : false;
            boolean z2 = z;
            if (this.mFullWifiLockTimer != null) {
                z2 = z | (!this.mFullWifiLockTimer.reset(false)) | this.mFullWifiLockOut;
            }
            boolean z3 = z2;
            if (this.mWifiScanTimer != null) {
                z3 = z2 | (!this.mWifiScanTimer.reset(false)) | this.mWifiScanStarted;
            }
            boolean z4 = z3;
            if (this.mWifiBatchedScanTimer != null) {
                int i = 0;
                while (i < 5) {
                    boolean z5 = z3;
                    if (this.mWifiBatchedScanTimer[i] != null) {
                        z5 = z3 | (!this.mWifiBatchedScanTimer[i].reset(false));
                    }
                    i++;
                    z3 = z5;
                }
                z4 = z3 | (this.mWifiBatchedScanBinStarted != -1);
            }
            boolean z6 = z4;
            if (this.mWifiMulticastTimer != null) {
                z6 = z4 | (!this.mWifiMulticastTimer.reset(false)) | this.mWifiMulticastEnabled;
            }
            boolean z7 = z6;
            if (this.mAudioTurnedOnTimer != null) {
                z7 = z6 | (!this.mAudioTurnedOnTimer.reset(false));
            }
            boolean z8 = z7;
            if (this.mVideoTurnedOnTimer != null) {
                z8 = z7 | (!this.mVideoTurnedOnTimer.reset(false));
            }
            boolean z9 = z8;
            if (this.mForegroundActivityTimer != null) {
                z9 = z8 | (!this.mForegroundActivityTimer.reset(false));
            }
            boolean z10 = z9;
            if (this.mProcessStateTimer != null) {
                int i2 = 0;
                while (i2 < 3) {
                    boolean z11 = z9;
                    if (this.mProcessStateTimer[i2] != null) {
                        z11 = z9 | (!this.mProcessStateTimer[i2].reset(false));
                    }
                    i2++;
                    z9 = z11;
                }
                z10 = z9 | (this.mProcessState != 3);
            }
            boolean z12 = z10;
            if (this.mVibratorOnTimer != null) {
                if (this.mVibratorOnTimer.reset(false)) {
                    this.mVibratorOnTimer.detach();
                    this.mVibratorOnTimer = null;
                    z12 = z10;
                } else {
                    z12 = true;
                }
            }
            if (this.mUserActivityCounters != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 3) {
                        break;
                    }
                    this.mUserActivityCounters[i4].reset(false);
                    i3 = i4 + 1;
                }
            }
            if (this.mNetworkByteActivityCounters != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= 4) {
                        break;
                    }
                    this.mNetworkByteActivityCounters[i6].reset(false);
                    this.mNetworkPacketActivityCounters[i6].reset(false);
                    i5 = i6 + 1;
                }
                this.mMobileRadioActiveTime.reset(false);
                this.mMobileRadioActiveCount.reset(false);
            }
            ArrayMap<String, Wakelock> map = this.mWakelockStats.getMap();
            int size = map.size();
            while (true) {
                int i7 = size - 1;
                if (i7 < 0) {
                    break;
                }
                if (map.valueAt(i7).reset()) {
                    map.removeAt(i7);
                } else {
                    z12 = true;
                }
                size = i7;
            }
            this.mWakelockStats.cleanup();
            ArrayMap<String, StopwatchTimer> map2 = this.mSyncStats.getMap();
            int size2 = map2.size();
            while (true) {
                int i8 = size2 - 1;
                if (i8 < 0) {
                    break;
                }
                StopwatchTimer valueAt = map2.valueAt(i8);
                if (valueAt.reset(false)) {
                    map2.removeAt(i8);
                    valueAt.detach();
                } else {
                    z12 = true;
                }
                size2 = i8;
            }
            this.mSyncStats.cleanup();
            ArrayMap<String, StopwatchTimer> map3 = this.mJobStats.getMap();
            int size3 = map3.size();
            while (true) {
                int i9 = size3 - 1;
                if (i9 < 0) {
                    break;
                }
                StopwatchTimer valueAt2 = map3.valueAt(i9);
                if (valueAt2.reset(false)) {
                    map3.removeAt(i9);
                    valueAt2.detach();
                } else {
                    z12 = true;
                }
                size3 = i9;
            }
            this.mJobStats.cleanup();
            int size4 = this.mSensorStats.size();
            while (true) {
                int i10 = size4 - 1;
                if (i10 < 0) {
                    break;
                }
                if (this.mSensorStats.valueAt(i10).reset()) {
                    this.mSensorStats.removeAt(i10);
                } else {
                    z12 = true;
                }
                size4 = i10;
            }
            int size5 = this.mProcessStats.size();
            while (true) {
                int i11 = size5 - 1;
                if (i11 < 0) {
                    break;
                }
                Proc valueAt3 = this.mProcessStats.valueAt(i11);
                if (valueAt3.mProcessState == 3) {
                    valueAt3.detach();
                    this.mProcessStats.removeAt(i11);
                } else {
                    valueAt3.reset();
                    z12 = true;
                }
                size5 = i11;
            }
            boolean z13 = z12;
            if (this.mPids.size() > 0) {
                int size6 = this.mPids.size();
                while (true) {
                    int i12 = size6 - 1;
                    z13 = z12;
                    if (i12 < 0) {
                        break;
                    }
                    if (this.mPids.valueAt(i12).mWakeNesting > 0) {
                        z12 = true;
                    } else {
                        this.mPids.removeAt(i12);
                    }
                    size6 = i12;
                }
            }
            if (this.mPackageStats.size() > 0) {
                for (Map.Entry<String, Pkg> entry : this.mPackageStats.entrySet()) {
                    Pkg value = entry.getValue();
                    value.detach();
                    if (value.mServiceStats.size() > 0) {
                        for (Map.Entry<String, Pkg.Serv> entry2 : value.mServiceStats.entrySet()) {
                            entry2.getValue().detach();
                        }
                    }
                }
                this.mPackageStats.clear();
            }
            if (!z13) {
                if (this.mWifiRunningTimer != null) {
                    this.mWifiRunningTimer.detach();
                }
                if (this.mFullWifiLockTimer != null) {
                    this.mFullWifiLockTimer.detach();
                }
                if (this.mWifiScanTimer != null) {
                    this.mWifiScanTimer.detach();
                }
                int i13 = 0;
                while (true) {
                    int i14 = i13;
                    if (i14 >= 5) {
                        break;
                    }
                    if (this.mWifiBatchedScanTimer[i14] != null) {
                        this.mWifiBatchedScanTimer[i14].detach();
                    }
                    i13 = i14 + 1;
                }
                if (this.mWifiMulticastTimer != null) {
                    this.mWifiMulticastTimer.detach();
                }
                if (this.mAudioTurnedOnTimer != null) {
                    this.mAudioTurnedOnTimer.detach();
                    this.mAudioTurnedOnTimer = null;
                }
                if (this.mVideoTurnedOnTimer != null) {
                    this.mVideoTurnedOnTimer.detach();
                    this.mVideoTurnedOnTimer = null;
                }
                if (this.mForegroundActivityTimer != null) {
                    this.mForegroundActivityTimer.detach();
                    this.mForegroundActivityTimer = null;
                }
                if (this.mUserActivityCounters != null) {
                    int i15 = 0;
                    while (true) {
                        int i16 = i15;
                        if (i16 >= 3) {
                            break;
                        }
                        this.mUserActivityCounters[i16].detach();
                        i15 = i16 + 1;
                    }
                }
                if (this.mNetworkByteActivityCounters != null) {
                    int i17 = 0;
                    while (true) {
                        int i18 = i17;
                        if (i18 >= 4) {
                            break;
                        }
                        this.mNetworkByteActivityCounters[i18].detach();
                        this.mNetworkPacketActivityCounters[i18].detach();
                        i17 = i18 + 1;
                    }
                }
                this.mPids.clear();
            }
            return !z13;
        }

        public void updateProcessStateLocked(String str, int i, long j) {
            updateRealProcessStateLocked(str, i <= 3 ? 0 : i <= 8 ? 1 : 2, j);
        }

        public void updateRealProcessStateLocked(String str, int i, long j) {
            boolean z = true;
            Proc processStatsLocked = getProcessStatsLocked(str);
            if (processStatsLocked.mProcessState != i) {
                if (i >= processStatsLocked.mProcessState) {
                    z = this.mProcessState == processStatsLocked.mProcessState;
                } else if (this.mProcessState <= i) {
                    z = false;
                }
                processStatsLocked.mProcessState = i;
                if (z) {
                    int i2 = 3;
                    int size = this.mProcessStats.size() - 1;
                    while (size >= 0) {
                        Proc valueAt = this.mProcessStats.valueAt(size);
                        int i3 = i2;
                        if (valueAt.mProcessState < i2) {
                            i3 = valueAt.mProcessState;
                        }
                        size--;
                        i2 = i3;
                    }
                    updateUidProcessStateLocked(i2, j);
                }
            }
        }

        void updateUidProcessStateLocked(int i, long j) {
            if (this.mProcessState == i) {
                return;
            }
            if (this.mProcessState != 3) {
                this.mProcessStateTimer[this.mProcessState].stopRunningLocked(j);
            }
            this.mProcessState = i;
            if (i != 3) {
                if (this.mProcessStateTimer[i] == null) {
                    makeProcessState(i, null);
                }
                this.mProcessStateTimer[i].startRunningLocked(j);
            }
        }

        void writeToParcelLocked(Parcel parcel, long j) {
            ArrayMap<String, Wakelock> map = this.mWakelockStats.getMap();
            int size = map.size();
            parcel.writeInt(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                parcel.writeString(map.keyAt(i2));
                map.valueAt(i2).writeToParcelLocked(parcel, j);
                i = i2 + 1;
            }
            ArrayMap<String, StopwatchTimer> map2 = this.mSyncStats.getMap();
            int size2 = map2.size();
            parcel.writeInt(size2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                parcel.writeString(map2.keyAt(i4));
                Timer.writeTimerToParcel(parcel, map2.valueAt(i4), j);
                i3 = i4 + 1;
            }
            ArrayMap<String, StopwatchTimer> map3 = this.mJobStats.getMap();
            int size3 = map3.size();
            parcel.writeInt(size3);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size3) {
                    break;
                }
                parcel.writeString(map3.keyAt(i6));
                Timer.writeTimerToParcel(parcel, map3.valueAt(i6), j);
                i5 = i6 + 1;
            }
            int size4 = this.mSensorStats.size();
            parcel.writeInt(size4);
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size4) {
                    break;
                }
                parcel.writeInt(this.mSensorStats.keyAt(i8));
                this.mSensorStats.valueAt(i8).writeToParcelLocked(parcel, j);
                i7 = i8 + 1;
            }
            int size5 = this.mProcessStats.size();
            parcel.writeInt(size5);
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= size5) {
                    break;
                }
                parcel.writeString(this.mProcessStats.keyAt(i10));
                this.mProcessStats.valueAt(i10).writeToParcelLocked(parcel);
                i9 = i10 + 1;
            }
            parcel.writeInt(this.mPackageStats.size());
            for (Map.Entry<String, Pkg> entry : this.mPackageStats.entrySet()) {
                parcel.writeString(entry.getKey());
                entry.getValue().writeToParcelLocked(parcel);
            }
            if (this.mWifiRunningTimer != null) {
                parcel.writeInt(1);
                this.mWifiRunningTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            if (this.mFullWifiLockTimer != null) {
                parcel.writeInt(1);
                this.mFullWifiLockTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            if (this.mWifiScanTimer != null) {
                parcel.writeInt(1);
                this.mWifiScanTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= 5) {
                    break;
                }
                if (this.mWifiBatchedScanTimer[i12] != null) {
                    parcel.writeInt(1);
                    this.mWifiBatchedScanTimer[i12].writeToParcel(parcel, j);
                } else {
                    parcel.writeInt(0);
                }
                i11 = i12 + 1;
            }
            if (this.mWifiMulticastTimer != null) {
                parcel.writeInt(1);
                this.mWifiMulticastTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            if (this.mAudioTurnedOnTimer != null) {
                parcel.writeInt(1);
                this.mAudioTurnedOnTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            if (this.mVideoTurnedOnTimer != null) {
                parcel.writeInt(1);
                this.mVideoTurnedOnTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            if (this.mForegroundActivityTimer != null) {
                parcel.writeInt(1);
                this.mForegroundActivityTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= 3) {
                    break;
                }
                if (this.mProcessStateTimer[i14] != null) {
                    parcel.writeInt(1);
                    this.mProcessStateTimer[i14].writeToParcel(parcel, j);
                } else {
                    parcel.writeInt(0);
                }
                i13 = i14 + 1;
            }
            if (this.mVibratorOnTimer != null) {
                parcel.writeInt(1);
                this.mVibratorOnTimer.writeToParcel(parcel, j);
            } else {
                parcel.writeInt(0);
            }
            if (this.mUserActivityCounters != null) {
                parcel.writeInt(1);
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= 3) {
                        break;
                    }
                    this.mUserActivityCounters[i16].writeToParcel(parcel);
                    i15 = i16 + 1;
                }
            } else {
                parcel.writeInt(0);
            }
            if (this.mNetworkByteActivityCounters == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            int i17 = 0;
            while (true) {
                int i18 = i17;
                if (i18 >= 4) {
                    this.mMobileRadioActiveTime.writeToParcel(parcel);
                    this.mMobileRadioActiveCount.writeToParcel(parcel);
                    return;
                }
                this.mNetworkByteActivityCounters[i18].writeToParcel(parcel);
                this.mNetworkPacketActivityCounters[i18].writeToParcel(parcel);
                i17 = i18 + 1;
            }
        }
    }

    public BatteryStatsImpl() {
        this.mIsolatedUids = new SparseIntArray();
        this.mUidStats = new SparseArray<>();
        this.mPartialTimers = new ArrayList<>();
        this.mFullTimers = new ArrayList<>();
        this.mWindowTimers = new ArrayList<>();
        this.mSensorTimers = new SparseArray<>();
        this.mWifiRunningTimers = new ArrayList<>();
        this.mFullWifiLockTimers = new ArrayList<>();
        this.mWifiMulticastTimers = new ArrayList<>();
        this.mWifiScanTimers = new ArrayList<>();
        this.mWifiBatchedScanTimers = new SparseArray<>();
        this.mAudioTurnedOnTimers = new ArrayList<>();
        this.mVideoTurnedOnTimers = new ArrayList<>();
        this.mLastPartialTimers = new ArrayList<>();
        this.mOnBatteryTimeBase = new TimeBase();
        this.mOnBatteryScreenOffTimeBase = new TimeBase();
        this.mActiveEvents = new BatteryStats.HistoryEventTracker();
        this.mHaveBatteryLevel = false;
        this.mRecordingHistory = false;
        this.mHistoryBuffer = Parcel.obtain();
        this.mHistoryLastWritten = new BatteryStats.HistoryItem();
        this.mHistoryLastLastWritten = new BatteryStats.HistoryItem();
        this.mHistoryReadTmp = new BatteryStats.HistoryItem();
        this.mHistoryAddTmp = new BatteryStats.HistoryItem();
        this.mHistoryTagPool = new HashMap<>();
        this.mNextHistoryTagIdx = 0;
        this.mNumHistoryTagChars = 0;
        this.mHistoryBufferLastPos = -1;
        this.mHistoryOverflow = false;
        this.mLastHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryUptime = 0L;
        this.mHistoryCur = new BatteryStats.HistoryItem();
        this.mScreenState = 0;
        this.mScreenBrightnessBin = -1;
        this.mScreenBrightnessTimer = new StopwatchTimer[5];
        this.mPhoneSignalStrengthBin = -1;
        this.mPhoneSignalStrengthBinRaw = -1;
        this.mPhoneSignalStrengthsTimer = new StopwatchTimer[5];
        this.mPhoneDataConnectionType = -1;
        this.mPhoneDataConnectionsTimer = new StopwatchTimer[17];
        this.mNetworkByteActivityCounters = new LongSamplingCounter[4];
        this.mNetworkPacketActivityCounters = new LongSamplingCounter[4];
        this.mWifiState = -1;
        this.mWifiStateTimer = new StopwatchTimer[8];
        this.mWifiSupplState = -1;
        this.mWifiSupplStateTimer = new StopwatchTimer[13];
        this.mWifiSignalStrengthBin = -1;
        this.mWifiSignalStrengthsTimer = new StopwatchTimer[5];
        this.mBluetoothState = -1;
        this.mBluetoothStateTimer = new StopwatchTimer[4];
        this.mMobileRadioPowerState = DataConnectionRealTimeInfo.DC_POWER_STATE_LOW;
        this.mInitStepMode = 0;
        this.mCurStepMode = 0;
        this.mModStepMode = 0;
        this.mDischargeStepDurations = new long[200];
        this.mChargeStepDurations = new long[200];
        this.mLastWriteTime = 0L;
        this.mBluetoothPingStart = -1;
        this.mPhoneServiceState = -1;
        this.mPhoneServiceStateRaw = -1;
        this.mPhoneSimStateRaw = -1;
        this.mKernelWakelockStats = new HashMap<>();
        this.mLastWakeupReason = null;
        this.mLastWakeupUptimeMs = 0L;
        this.mWakeupReasonStats = new HashMap<>();
        this.mProcWakelocksName = new String[3];
        this.mProcWakelocksData = new long[3];
        this.mProcWakelockFileStats = new HashMap();
        this.mNetworkStatsFactory = new NetworkStatsFactory();
        this.mCurMobileSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mLastMobileSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mCurWifiSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mLastWifiSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mTmpNetworkStatsEntry = new NetworkStats.Entry();
        this.mMobileIfaces = new String[0];
        this.mWifiIfaces = new String[0];
        this.mChangedStates = 0;
        this.mChangedStates2 = 0;
        this.mInitialAcquireWakeUid = -1;
        this.mWifiFullLockNesting = 0;
        this.mWifiScanNesting = 0;
        this.mWifiMulticastNesting = 0;
        this.mPendingWrite = null;
        this.mWriteLock = new ReentrantLock();
        this.mFile = null;
        this.mCheckinFile = null;
        this.mHandler = null;
        clearHistoryLocked();
    }

    public BatteryStatsImpl(Parcel parcel) {
        this.mIsolatedUids = new SparseIntArray();
        this.mUidStats = new SparseArray<>();
        this.mPartialTimers = new ArrayList<>();
        this.mFullTimers = new ArrayList<>();
        this.mWindowTimers = new ArrayList<>();
        this.mSensorTimers = new SparseArray<>();
        this.mWifiRunningTimers = new ArrayList<>();
        this.mFullWifiLockTimers = new ArrayList<>();
        this.mWifiMulticastTimers = new ArrayList<>();
        this.mWifiScanTimers = new ArrayList<>();
        this.mWifiBatchedScanTimers = new SparseArray<>();
        this.mAudioTurnedOnTimers = new ArrayList<>();
        this.mVideoTurnedOnTimers = new ArrayList<>();
        this.mLastPartialTimers = new ArrayList<>();
        this.mOnBatteryTimeBase = new TimeBase();
        this.mOnBatteryScreenOffTimeBase = new TimeBase();
        this.mActiveEvents = new BatteryStats.HistoryEventTracker();
        this.mHaveBatteryLevel = false;
        this.mRecordingHistory = false;
        this.mHistoryBuffer = Parcel.obtain();
        this.mHistoryLastWritten = new BatteryStats.HistoryItem();
        this.mHistoryLastLastWritten = new BatteryStats.HistoryItem();
        this.mHistoryReadTmp = new BatteryStats.HistoryItem();
        this.mHistoryAddTmp = new BatteryStats.HistoryItem();
        this.mHistoryTagPool = new HashMap<>();
        this.mNextHistoryTagIdx = 0;
        this.mNumHistoryTagChars = 0;
        this.mHistoryBufferLastPos = -1;
        this.mHistoryOverflow = false;
        this.mLastHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryUptime = 0L;
        this.mHistoryCur = new BatteryStats.HistoryItem();
        this.mScreenState = 0;
        this.mScreenBrightnessBin = -1;
        this.mScreenBrightnessTimer = new StopwatchTimer[5];
        this.mPhoneSignalStrengthBin = -1;
        this.mPhoneSignalStrengthBinRaw = -1;
        this.mPhoneSignalStrengthsTimer = new StopwatchTimer[5];
        this.mPhoneDataConnectionType = -1;
        this.mPhoneDataConnectionsTimer = new StopwatchTimer[17];
        this.mNetworkByteActivityCounters = new LongSamplingCounter[4];
        this.mNetworkPacketActivityCounters = new LongSamplingCounter[4];
        this.mWifiState = -1;
        this.mWifiStateTimer = new StopwatchTimer[8];
        this.mWifiSupplState = -1;
        this.mWifiSupplStateTimer = new StopwatchTimer[13];
        this.mWifiSignalStrengthBin = -1;
        this.mWifiSignalStrengthsTimer = new StopwatchTimer[5];
        this.mBluetoothState = -1;
        this.mBluetoothStateTimer = new StopwatchTimer[4];
        this.mMobileRadioPowerState = DataConnectionRealTimeInfo.DC_POWER_STATE_LOW;
        this.mInitStepMode = 0;
        this.mCurStepMode = 0;
        this.mModStepMode = 0;
        this.mDischargeStepDurations = new long[200];
        this.mChargeStepDurations = new long[200];
        this.mLastWriteTime = 0L;
        this.mBluetoothPingStart = -1;
        this.mPhoneServiceState = -1;
        this.mPhoneServiceStateRaw = -1;
        this.mPhoneSimStateRaw = -1;
        this.mKernelWakelockStats = new HashMap<>();
        this.mLastWakeupReason = null;
        this.mLastWakeupUptimeMs = 0L;
        this.mWakeupReasonStats = new HashMap<>();
        this.mProcWakelocksName = new String[3];
        this.mProcWakelocksData = new long[3];
        this.mProcWakelockFileStats = new HashMap();
        this.mNetworkStatsFactory = new NetworkStatsFactory();
        this.mCurMobileSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mLastMobileSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mCurWifiSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mLastWifiSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mTmpNetworkStatsEntry = new NetworkStats.Entry();
        this.mMobileIfaces = new String[0];
        this.mWifiIfaces = new String[0];
        this.mChangedStates = 0;
        this.mChangedStates2 = 0;
        this.mInitialAcquireWakeUid = -1;
        this.mWifiFullLockNesting = 0;
        this.mWifiScanNesting = 0;
        this.mWifiMulticastNesting = 0;
        this.mPendingWrite = null;
        this.mWriteLock = new ReentrantLock();
        this.mFile = null;
        this.mCheckinFile = null;
        this.mHandler = null;
        clearHistoryLocked();
        readFromParcel(parcel);
    }

    public BatteryStatsImpl(File file, Handler handler) {
        this.mIsolatedUids = new SparseIntArray();
        this.mUidStats = new SparseArray<>();
        this.mPartialTimers = new ArrayList<>();
        this.mFullTimers = new ArrayList<>();
        this.mWindowTimers = new ArrayList<>();
        this.mSensorTimers = new SparseArray<>();
        this.mWifiRunningTimers = new ArrayList<>();
        this.mFullWifiLockTimers = new ArrayList<>();
        this.mWifiMulticastTimers = new ArrayList<>();
        this.mWifiScanTimers = new ArrayList<>();
        this.mWifiBatchedScanTimers = new SparseArray<>();
        this.mAudioTurnedOnTimers = new ArrayList<>();
        this.mVideoTurnedOnTimers = new ArrayList<>();
        this.mLastPartialTimers = new ArrayList<>();
        this.mOnBatteryTimeBase = new TimeBase();
        this.mOnBatteryScreenOffTimeBase = new TimeBase();
        this.mActiveEvents = new BatteryStats.HistoryEventTracker();
        this.mHaveBatteryLevel = false;
        this.mRecordingHistory = false;
        this.mHistoryBuffer = Parcel.obtain();
        this.mHistoryLastWritten = new BatteryStats.HistoryItem();
        this.mHistoryLastLastWritten = new BatteryStats.HistoryItem();
        this.mHistoryReadTmp = new BatteryStats.HistoryItem();
        this.mHistoryAddTmp = new BatteryStats.HistoryItem();
        this.mHistoryTagPool = new HashMap<>();
        this.mNextHistoryTagIdx = 0;
        this.mNumHistoryTagChars = 0;
        this.mHistoryBufferLastPos = -1;
        this.mHistoryOverflow = false;
        this.mLastHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryUptime = 0L;
        this.mHistoryCur = new BatteryStats.HistoryItem();
        this.mScreenState = 0;
        this.mScreenBrightnessBin = -1;
        this.mScreenBrightnessTimer = new StopwatchTimer[5];
        this.mPhoneSignalStrengthBin = -1;
        this.mPhoneSignalStrengthBinRaw = -1;
        this.mPhoneSignalStrengthsTimer = new StopwatchTimer[5];
        this.mPhoneDataConnectionType = -1;
        this.mPhoneDataConnectionsTimer = new StopwatchTimer[17];
        this.mNetworkByteActivityCounters = new LongSamplingCounter[4];
        this.mNetworkPacketActivityCounters = new LongSamplingCounter[4];
        this.mWifiState = -1;
        this.mWifiStateTimer = new StopwatchTimer[8];
        this.mWifiSupplState = -1;
        this.mWifiSupplStateTimer = new StopwatchTimer[13];
        this.mWifiSignalStrengthBin = -1;
        this.mWifiSignalStrengthsTimer = new StopwatchTimer[5];
        this.mBluetoothState = -1;
        this.mBluetoothStateTimer = new StopwatchTimer[4];
        this.mMobileRadioPowerState = DataConnectionRealTimeInfo.DC_POWER_STATE_LOW;
        this.mInitStepMode = 0;
        this.mCurStepMode = 0;
        this.mModStepMode = 0;
        this.mDischargeStepDurations = new long[200];
        this.mChargeStepDurations = new long[200];
        this.mLastWriteTime = 0L;
        this.mBluetoothPingStart = -1;
        this.mPhoneServiceState = -1;
        this.mPhoneServiceStateRaw = -1;
        this.mPhoneSimStateRaw = -1;
        this.mKernelWakelockStats = new HashMap<>();
        this.mLastWakeupReason = null;
        this.mLastWakeupUptimeMs = 0L;
        this.mWakeupReasonStats = new HashMap<>();
        this.mProcWakelocksName = new String[3];
        this.mProcWakelocksData = new long[3];
        this.mProcWakelockFileStats = new HashMap();
        this.mNetworkStatsFactory = new NetworkStatsFactory();
        this.mCurMobileSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mLastMobileSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mCurWifiSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mLastWifiSnapshot = new NetworkStats(SystemClock.elapsedRealtime(), 50);
        this.mTmpNetworkStatsEntry = new NetworkStats.Entry();
        this.mMobileIfaces = new String[0];
        this.mWifiIfaces = new String[0];
        this.mChangedStates = 0;
        this.mChangedStates2 = 0;
        this.mInitialAcquireWakeUid = -1;
        this.mWifiFullLockNesting = 0;
        this.mWifiScanNesting = 0;
        this.mWifiMulticastNesting = 0;
        this.mPendingWrite = null;
        this.mWriteLock = new ReentrantLock();
        if (file != null) {
            this.mFile = new JournaledFile(new File(file, getStatsName() + ".bin"), new File(file, getStatsName() + ".bin.tmp"));
        } else {
            this.mFile = null;
        }
        this.mCheckinFile = new AtomicFile(new File(file, getStatsName() + "-checkin.bin"));
        this.mHandler = new MyHandler(handler.getLooper());
        this.mStartCount++;
        this.mScreenOnTimer = new StopwatchTimer(null, -1, null, this.mOnBatteryTimeBase);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            this.mScreenBrightnessTimer[i2] = new StopwatchTimer(null, (-100) - i2, null, this.mOnBatteryTimeBase);
            i = i2 + 1;
        }
        this.mInteractiveTimer = new StopwatchTimer(null, -9, null, this.mOnBatteryTimeBase);
        this.mLowPowerModeEnabledTimer = new StopwatchTimer(null, -2, null, this.mOnBatteryTimeBase);
        this.mPhoneOnTimer = new StopwatchTimer(null, -3, null, this.mOnBatteryTimeBase);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                break;
            }
            this.mPhoneSignalStrengthsTimer[i4] = new StopwatchTimer(null, (-200) - i4, null, this.mOnBatteryTimeBase);
            i3 = i4 + 1;
        }
        this.mPhoneSignalScanningTimer = new StopwatchTimer(null, -199, null, this.mOnBatteryTimeBase);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 17) {
                break;
            }
            this.mPhoneDataConnectionsTimer[i6] = new StopwatchTimer(null, (-300) - i6, null, this.mOnBatteryTimeBase);
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 4) {
                break;
            }
            this.mNetworkByteActivityCounters[i8] = new LongSamplingCounter(this.mOnBatteryTimeBase);
            this.mNetworkPacketActivityCounters[i8] = new LongSamplingCounter(this.mOnBatteryTimeBase);
            i7 = i8 + 1;
        }
        this.mMobileRadioActiveTimer = new StopwatchTimer(null, -400, null, this.mOnBatteryTimeBase);
        this.mMobileRadioActivePerAppTimer = new StopwatchTimer(null, -401, null, this.mOnBatteryTimeBase);
        this.mMobileRadioActiveAdjustedTime = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mMobileRadioActiveUnknownTime = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mMobileRadioActiveUnknownCount = new LongSamplingCounter(this.mOnBatteryTimeBase);
        this.mWifiOnTimer = new StopwatchTimer(null, -4, null, this.mOnBatteryTimeBase);
        this.mGlobalWifiRunningTimer = new StopwatchTimer(null, -5, null, this.mOnBatteryTimeBase);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 8) {
                break;
            }
            this.mWifiStateTimer[i10] = new StopwatchTimer(null, (-600) - i10, null, this.mOnBatteryTimeBase);
            i9 = i10 + 1;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= 13) {
                break;
            }
            this.mWifiSupplStateTimer[i12] = new StopwatchTimer(null, (-700) - i12, null, this.mOnBatteryTimeBase);
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= 5) {
                break;
            }
            this.mWifiSignalStrengthsTimer[i14] = new StopwatchTimer(null, (-800) - i14, null, this.mOnBatteryTimeBase);
            i13 = i14 + 1;
        }
        this.mBluetoothOnTimer = new StopwatchTimer(null, -6, null, this.mOnBatteryTimeBase);
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= 4) {
                this.mAudioOnTimer = new StopwatchTimer(null, -7, null, this.mOnBatteryTimeBase);
                this.mVideoOnTimer = new StopwatchTimer(null, -8, null, this.mOnBatteryTimeBase);
                this.mFlashlightOnTimer = new StopwatchTimer(null, -9, null, this.mOnBatteryTimeBase);
                this.mOnBatteryInternal = false;
                this.mOnBattery = false;
                initTimes(SystemClock.uptimeMillis() * 1000, SystemClock.elapsedRealtime() * 1000);
                String str = Build.ID;
                this.mEndPlatformVersion = str;
                this.mStartPlatformVersion = str;
                this.mDischargeStartLevel = 0;
                this.mDischargeUnplugLevel = 0;
                this.mDischargePlugLevel = -1;
                this.mDischargeCurrentLevel = 0;
                this.mCurrentBatteryLevel = 0;
                initDischarge();
                clearHistoryLocked();
                return;
            }
            this.mBluetoothStateTimer[i16] = new StopwatchTimer(null, (-500) - i16, null, this.mOnBatteryTimeBase);
            i15 = i16 + 1;
        }
    }

    private void addHistoryBufferLocked(long j, long j2, byte b, BatteryStats.HistoryItem historyItem) {
        if (this.mIteratingHistory) {
            throw new IllegalStateException("Can't do this while iterating history!");
        }
        this.mHistoryBufferLastPos = this.mHistoryBuffer.dataPosition();
        this.mHistoryLastLastWritten.setTo(this.mHistoryLastWritten);
        this.mHistoryLastWritten.setTo(this.mHistoryBaseTime + j, b, historyItem);
        writeHistoryDelta(this.mHistoryBuffer, this.mHistoryLastWritten, this.mHistoryLastLastWritten);
        this.mLastHistoryElapsedRealtime = j;
        historyItem.wakelockTag = null;
        historyItem.wakeReasonTag = null;
        historyItem.eventCode = 0;
        historyItem.eventTag = null;
    }

    private static int addLevelSteps(long[] jArr, int i, long j, int i2, long j2, long j3) {
        int i3 = i;
        if (j >= 0) {
            i3 = i;
            if (i2 > 0) {
                long j4 = j3 - j;
                int i4 = 0;
                while (i4 < i2) {
                    System.arraycopy(jArr, 0, jArr, 1, jArr.length - 1);
                    long j5 = j4 / (i2 - i4);
                    long j6 = j4 - j5;
                    long j7 = j5;
                    if (j5 > 1099511627775L) {
                        j7 = 1099511627775L;
                    }
                    jArr[0] = j7 | j2;
                    i4++;
                    j4 = j6;
                }
                int i5 = i + i2;
                i3 = i5;
                if (i5 > jArr.length) {
                    i3 = jArr.length;
                }
            }
        }
        return i3;
    }

    private int buildBatteryLevelInt(BatteryStats.HistoryItem historyItem) {
        return ((historyItem.batteryLevel << 25) & (-33554432)) | ((historyItem.batteryTemperature << 14) & 33538048) | (historyItem.batteryVoltage & 16383);
    }

    private int buildStateInt(BatteryStats.HistoryItem historyItem) {
        int i = 0;
        if ((historyItem.batteryPlugType & 1) != 0) {
            i = 1;
        } else if ((historyItem.batteryPlugType & 2) != 0) {
            i = 2;
        } else if ((historyItem.batteryPlugType & 4) != 0) {
            i = 3;
        }
        return ((historyItem.batteryStatus & 7) << 29) | ((historyItem.batteryHealth & 7) << 26) | ((i & 3) << 24) | (historyItem.states & 16777215);
    }

    private long computeTimePerLevel(long[] jArr, int i) {
        if (i <= 0) {
            return -1L;
        }
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return j / i;
            }
            j += jArr[i3] & 1099511627775L;
            i2 = i3 + 1;
        }
    }

    private static String[] excludeFromStringArray(String[] strArr, String str) {
        int indexOf = ArrayUtils.indexOf(strArr, str);
        if (indexOf >= 0) {
            String[] strArr2 = new String[strArr.length - 1];
            if (indexOf > 0) {
                System.arraycopy(strArr, 0, strArr2, 0, indexOf);
            }
            if (indexOf < strArr.length - 1) {
                System.arraycopy(strArr, indexOf + 1, strArr2, indexOf, (strArr.length - indexOf) - 1);
            }
            return strArr2;
        }
        return strArr;
    }

    private int fixPhoneServiceState(int i, int i2) {
        int i3 = i;
        if (this.mPhoneSimStateRaw == 1) {
            i3 = i;
            if (i == 1) {
                i3 = i;
                if (i2 > 0) {
                    i3 = 0;
                }
            }
        }
        return i3;
    }

    private int getCurrentBluetoothPingCount() {
        if (this.mBtHeadset != null) {
            List<BluetoothDevice> connectedDevices = this.mBtHeadset.getConnectedDevices();
            if (connectedDevices.size() > 0) {
                return this.mBtHeadset.getBatteryUsageHint(connectedDevices.get(0));
            }
            return -1;
        }
        return -1;
    }

    private static String[] includeInStringArray(String[] strArr, String str) {
        if (ArrayUtils.indexOf(strArr, str) >= 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    private void initActiveHistoryEventsLocked(long j, long j2) {
        HashMap stateForEvent;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return;
            }
            if ((this.mRecordAllHistory || i2 != 1) && (stateForEvent = this.mActiveEvents.getStateForEvent(i2)) != null) {
                for (Map.Entry entry : stateForEvent.entrySet()) {
                    SparseIntArray sparseIntArray = (SparseIntArray) entry.getValue();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < sparseIntArray.size()) {
                            addHistoryEventLocked(j, j2, i2, (String) entry.getKey(), sparseIntArray.keyAt(i4));
                            i3 = i4 + 1;
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private final Map<String, KernelWakelockStats> parseProcWakelocks(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i2 >= i || bArr[i2] == 10 || bArr[i2] == 0) {
                break;
            }
            i5 = i2 + 1;
        }
        int i6 = i2 + 1;
        int i7 = i6;
        synchronized (this) {
            Map<String, KernelWakelockStats> map = this.mProcWakelockFileStats;
            setKernelWakelockUpdateVersion(getKernelWakelockUpdateVersion() + 1);
            while (i6 < i) {
                int i8 = i7;
                while (true) {
                    i3 = i8;
                    if (i3 >= i || bArr[i3] == 10 || bArr[i3] == 0) {
                        break;
                    }
                    i8 = i3 + 1;
                }
                i6 = i3 + 1;
                if (i6 >= i - 1) {
                    return map;
                }
                String[] strArr = this.mProcWakelocksName;
                long[] jArr = this.mProcWakelocksData;
                int i9 = i7;
                while (true) {
                    int i10 = i9;
                    if (i10 >= i6) {
                        break;
                    }
                    if ((bArr[i10] & 128) != 0) {
                        bArr[i10] = 63;
                    }
                    i9 = i10 + 1;
                }
                boolean parseProcLine = Process.parseProcLine(bArr, i7, i6, z ? WAKEUP_SOURCES_FORMAT : PROC_WAKELOCKS_FORMAT, strArr, jArr, null);
                String str = strArr[0];
                int i11 = (int) jArr[1];
                long j = z ? jArr[2] * 1000 : (jArr[2] + 500) / 1000;
                int i12 = i4;
                if (parseProcLine) {
                    i12 = i4;
                    if (str.length() > 0) {
                        if (map.containsKey(str)) {
                            KernelWakelockStats kernelWakelockStats = map.get(str);
                            if (kernelWakelockStats.mVersion == getKernelWakelockUpdateVersion()) {
                                kernelWakelockStats.mCount += i11;
                                kernelWakelockStats.mTotalTime += j;
                                i12 = i4;
                            } else {
                                kernelWakelockStats.mCount = i11;
                                kernelWakelockStats.mTotalTime = j;
                                kernelWakelockStats.mVersion = getKernelWakelockUpdateVersion();
                                i12 = i4 + 1;
                            }
                        } else {
                            map.put(str, new KernelWakelockStats(i11, j, getKernelWakelockUpdateVersion()));
                            i12 = i4 + 1;
                        }
                    }
                }
                i7 = i6;
                i4 = i12;
            }
            if (map.size() != i4) {
                Iterator<KernelWakelockStats> it = map.values().iterator();
                while (it.hasNext()) {
                    if (it.next().mVersion != getKernelWakelockUpdateVersion()) {
                        it.remove();
                    }
                }
            }
            return map;
        }
    }

    private void readHistoryTag(int i, BatteryStats.HistoryTag historyTag) {
        historyTag.string = this.mReadHistoryStrings[i];
        historyTag.uid = this.mReadHistoryUids[i];
        historyTag.poolIdx = i;
    }

    private final Map<String, KernelWakelockStats> readKernelWakelockStats() {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[8192];
        boolean z = false;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/wakelocks");
            } catch (IOException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            try {
                fileInputStream = new FileInputStream("/d/wakeup_sources");
                z = true;
            } catch (FileNotFoundException e3) {
                return null;
            }
        }
        int read = fileInputStream.read(bArr);
        fileInputStream.close();
        int i = read;
        if (read > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = read;
                if (i3 >= read) {
                    break;
                } else if (bArr[i3] == 0) {
                    i = i3;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return parseProcWakelocks(bArr, i, z);
    }

    private void recordCurrentTimeChangeLocked(long j, long j2, long j3) {
        if (this.mRecordingHistory) {
            this.mHistoryCur.currentTime = j;
            this.mLastRecordedClockTime = j;
            this.mLastRecordedClockRealtime = j2;
            addHistoryBufferLocked(j2, j3, (byte) 5, this.mHistoryCur);
            this.mHistoryCur.currentTime = 0L;
        }
    }

    private void recordShutdownLocked(long j, long j2) {
        if (this.mRecordingHistory) {
            this.mHistoryCur.currentTime = System.currentTimeMillis();
            this.mLastRecordedClockTime = this.mHistoryCur.currentTime;
            this.mLastRecordedClockRealtime = j;
            addHistoryBufferLocked(j, j2, (byte) 8, this.mHistoryCur);
            this.mHistoryCur.currentTime = 0L;
        }
    }

    private void requestWakelockCpuUpdate() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), DELAY_UPDATE_WAKELOCKS);
    }

    private void resetAllStatsLocked() {
        this.mStartCount = 0;
        initTimes(SystemClock.uptimeMillis() * 1000, SystemClock.elapsedRealtime() * 1000);
        this.mScreenOnTimer.reset(false);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            this.mScreenBrightnessTimer[i2].reset(false);
            i = i2 + 1;
        }
        this.mInteractiveTimer.reset(false);
        this.mLowPowerModeEnabledTimer.reset(false);
        this.mPhoneOnTimer.reset(false);
        this.mAudioOnTimer.reset(false);
        this.mVideoOnTimer.reset(false);
        this.mFlashlightOnTimer.reset(false);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                break;
            }
            this.mPhoneSignalStrengthsTimer[i4].reset(false);
            i3 = i4 + 1;
        }
        this.mPhoneSignalScanningTimer.reset(false);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 17) {
                break;
            }
            this.mPhoneDataConnectionsTimer[i6].reset(false);
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 4) {
                break;
            }
            this.mNetworkByteActivityCounters[i8].reset(false);
            this.mNetworkPacketActivityCounters[i8].reset(false);
            i7 = i8 + 1;
        }
        this.mMobileRadioActiveTimer.reset(false);
        this.mMobileRadioActivePerAppTimer.reset(false);
        this.mMobileRadioActiveAdjustedTime.reset(false);
        this.mMobileRadioActiveUnknownTime.reset(false);
        this.mMobileRadioActiveUnknownCount.reset(false);
        this.mWifiOnTimer.reset(false);
        this.mGlobalWifiRunningTimer.reset(false);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 8) {
                break;
            }
            this.mWifiStateTimer[i10].reset(false);
            i9 = i10 + 1;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= 13) {
                break;
            }
            this.mWifiSupplStateTimer[i12].reset(false);
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= 5) {
                break;
            }
            this.mWifiSignalStrengthsTimer[i14].reset(false);
            i13 = i14 + 1;
        }
        this.mBluetoothOnTimer.reset(false);
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= 4) {
                break;
            }
            this.mBluetoothStateTimer[i16].reset(false);
            i15 = i16 + 1;
        }
        this.mUnpluggedNumConnectivityChange = 0;
        this.mLoadedNumConnectivityChange = 0;
        this.mNumConnectivityChange = 0;
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= this.mUidStats.size()) {
                break;
            }
            int i19 = i18;
            if (this.mUidStats.valueAt(i18).reset()) {
                this.mUidStats.remove(this.mUidStats.keyAt(i18));
                i19 = i18 - 1;
            }
            i17 = i19 + 1;
        }
        if (this.mKernelWakelockStats.size() > 0) {
            for (SamplingTimer samplingTimer : this.mKernelWakelockStats.values()) {
                this.mOnBatteryScreenOffTimeBase.remove(samplingTimer);
            }
            this.mKernelWakelockStats.clear();
        }
        if (this.mWakeupReasonStats.size() > 0) {
            for (SamplingTimer samplingTimer2 : this.mWakeupReasonStats.values()) {
                this.mOnBatteryTimeBase.remove(samplingTimer2);
            }
            this.mWakeupReasonStats.clear();
        }
        initDischarge();
        clearHistoryLocked();
    }

    private void startRecordingHistory(long j, long j2, boolean z) {
        this.mRecordingHistory = true;
        this.mHistoryCur.currentTime = System.currentTimeMillis();
        this.mLastRecordedClockTime = this.mHistoryCur.currentTime;
        this.mLastRecordedClockRealtime = j;
        addHistoryBufferLocked(j, j2, z ? (byte) 7 : (byte) 5, this.mHistoryCur);
        this.mHistoryCur.currentTime = 0L;
        if (z) {
            initActiveHistoryEventsLocked(j, j2);
        }
    }

    private void updateAllPhoneStateLocked(int i, int i2, int i3) {
        boolean z;
        boolean z2;
        int i4;
        this.mPhoneServiceStateRaw = i;
        this.mPhoneSimStateRaw = i2;
        this.mPhoneSignalStrengthBinRaw = i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i5 = i;
        if (i2 == 1) {
            i5 = i;
            if (i == 1) {
                i5 = i;
                if (i3 > 0) {
                    i5 = 0;
                }
            }
        }
        if (i5 == 3) {
            i4 = -1;
            z2 = false;
            z = false;
        } else {
            z = false;
            z2 = false;
            i4 = i3;
            if (i5 != 0) {
                z = false;
                z2 = false;
                i4 = i3;
                if (i5 == 1) {
                    z = false;
                    z2 = true;
                    i4 = 0;
                    if (!this.mPhoneSignalScanningTimer.isRunningLocked()) {
                        this.mHistoryCur.states |= 2097152;
                        z = true;
                        this.mPhoneSignalScanningTimer.startRunningLocked(elapsedRealtime);
                        z2 = true;
                        i4 = 0;
                    }
                }
            }
        }
        boolean z3 = z;
        if (!z2) {
            z3 = z;
            if (this.mPhoneSignalScanningTimer.isRunningLocked()) {
                this.mHistoryCur.states &= -2097153;
                z3 = true;
                this.mPhoneSignalScanningTimer.stopRunningLocked(elapsedRealtime);
            }
        }
        boolean z4 = z3;
        if (this.mPhoneServiceState != i5) {
            this.mHistoryCur.states = (this.mHistoryCur.states & (-449)) | (i5 << 6);
            z4 = true;
            this.mPhoneServiceState = i5;
        }
        boolean z5 = z4;
        if (this.mPhoneSignalStrengthBin != i4) {
            if (this.mPhoneSignalStrengthBin >= 0) {
                this.mPhoneSignalStrengthsTimer[this.mPhoneSignalStrengthBin].stopRunningLocked(elapsedRealtime);
            }
            if (i4 >= 0) {
                if (!this.mPhoneSignalStrengthsTimer[i4].isRunningLocked()) {
                    this.mPhoneSignalStrengthsTimer[i4].startRunningLocked(elapsedRealtime);
                }
                this.mHistoryCur.states = (this.mHistoryCur.states & (-57)) | (i4 << 3);
                z4 = true;
            } else {
                stopAllPhoneSignalStrengthTimersLocked(-1);
            }
            this.mPhoneSignalStrengthBin = i4;
            z5 = z4;
        }
        if (z5) {
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
    }

    private void updateNetworkActivityLocked(int i, long j) {
        if (!SystemProperties.getBoolean(NetworkManagementSocketTagger.PROP_QTAGUID_ENABLED, false)) {
            return;
        }
        if ((i & 1) != 0 && this.mMobileIfaces.length > 0) {
            NetworkStats networkStats = this.mCurMobileSnapshot;
            try {
                NetworkStats readNetworkStatsDetail = this.mNetworkStatsFactory.readNetworkStatsDetail(-1, this.mMobileIfaces, 0, this.mLastMobileSnapshot);
                this.mCurMobileSnapshot = readNetworkStatsDetail;
                this.mLastMobileSnapshot = networkStats;
                if (this.mOnBatteryInternal) {
                    NetworkStats subtract = NetworkStats.subtract(readNetworkStatsDetail, networkStats, (NetworkStats.NonMonotonicObserver) null, (Object) null, this.mTmpNetworkStats);
                    this.mTmpNetworkStats = subtract;
                    long checkpointRunningLocked = this.mMobileRadioActivePerAppTimer.checkpointRunningLocked(j);
                    long totalPackets = subtract.getTotalPackets();
                    int size = subtract.size();
                    int i2 = 0;
                    while (i2 < size) {
                        NetworkStats.Entry values = subtract.getValues(i2, this.mTmpNetworkStatsEntry);
                        long j2 = checkpointRunningLocked;
                        long j3 = totalPackets;
                        if (values.rxBytes != 0) {
                            if (values.txBytes == 0) {
                                j3 = totalPackets;
                                j2 = checkpointRunningLocked;
                            } else {
                                Uid uidStatsLocked = getUidStatsLocked(mapUid(values.uid));
                                uidStatsLocked.noteNetworkActivityLocked(0, values.rxBytes, values.rxPackets);
                                uidStatsLocked.noteNetworkActivityLocked(1, values.txBytes, values.txPackets);
                                j2 = checkpointRunningLocked;
                                j3 = totalPackets;
                                if (checkpointRunningLocked > 0) {
                                    long j4 = values.rxPackets + values.txPackets;
                                    long j5 = (checkpointRunningLocked * j4) / totalPackets;
                                    uidStatsLocked.noteMobileRadioActiveTimeLocked(j5);
                                    j2 = checkpointRunningLocked - j5;
                                    j3 = totalPackets - j4;
                                }
                                this.mNetworkByteActivityCounters[0].addCountLocked(values.rxBytes);
                                this.mNetworkByteActivityCounters[1].addCountLocked(values.txBytes);
                                this.mNetworkPacketActivityCounters[0].addCountLocked(values.rxPackets);
                                this.mNetworkPacketActivityCounters[1].addCountLocked(values.txPackets);
                            }
                        }
                        i2++;
                        checkpointRunningLocked = j2;
                        totalPackets = j3;
                    }
                    if (checkpointRunningLocked > 0) {
                        this.mMobileRadioActiveUnknownTime.addCountLocked(checkpointRunningLocked);
                        this.mMobileRadioActiveUnknownCount.addCountLocked(1L);
                    }
                }
            } catch (IOException e) {
                Log.wtf(TAG, "Failed to read mobile network stats", e);
                return;
            }
        }
        if ((i & 2) == 0 || this.mWifiIfaces.length <= 0) {
            return;
        }
        NetworkStats networkStats2 = this.mCurWifiSnapshot;
        try {
            NetworkStats readNetworkStatsDetail2 = this.mNetworkStatsFactory.readNetworkStatsDetail(-1, this.mWifiIfaces, 0, this.mLastWifiSnapshot);
            this.mCurWifiSnapshot = readNetworkStatsDetail2;
            this.mLastWifiSnapshot = networkStats2;
            if (!this.mOnBatteryInternal) {
                return;
            }
            NetworkStats subtract2 = NetworkStats.subtract(readNetworkStatsDetail2, networkStats2, (NetworkStats.NonMonotonicObserver) null, (Object) null, this.mTmpNetworkStats);
            this.mTmpNetworkStats = subtract2;
            int size2 = subtract2.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    return;
                }
                NetworkStats.Entry values2 = subtract2.getValues(i4, this.mTmpNetworkStatsEntry);
                if (values2.rxBytes != 0 && values2.txBytes != 0) {
                    Uid uidStatsLocked2 = getUidStatsLocked(mapUid(values2.uid));
                    uidStatsLocked2.noteNetworkActivityLocked(2, values2.rxBytes, values2.rxPackets);
                    uidStatsLocked2.noteNetworkActivityLocked(3, values2.txBytes, values2.txPackets);
                    this.mNetworkByteActivityCounters[2].addCountLocked(values2.rxBytes);
                    this.mNetworkByteActivityCounters[3].addCountLocked(values2.txBytes);
                    this.mNetworkPacketActivityCounters[2].addCountLocked(values2.rxPackets);
                    this.mNetworkPacketActivityCounters[3].addCountLocked(values2.txPackets);
                }
                i3 = i4 + 1;
            }
        } catch (IOException e2) {
            Log.wtf(TAG, "Failed to read wifi network stats", e2);
        }
    }

    private int writeHistoryTag(BatteryStats.HistoryTag historyTag) {
        Integer num = this.mHistoryTagPool.get(historyTag);
        if (num != null) {
            return num.intValue();
        }
        int i = this.mNextHistoryTagIdx;
        BatteryStats.HistoryTag historyTag2 = new BatteryStats.HistoryTag();
        historyTag2.setTo(historyTag);
        historyTag.poolIdx = i;
        this.mHistoryTagPool.put(historyTag2, Integer.valueOf(i));
        this.mNextHistoryTagIdx++;
        this.mNumHistoryTagChars += historyTag2.string.length() + 1;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00be, code lost:
        if (r13.wakelockTag == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d3, code lost:
        if (r13.wakeReasonTag == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e8, code lost:
        if (r13.eventCode == 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void addHistoryBufferLocked(long r9, long r11, android.os.BatteryStats.HistoryItem r13) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.BatteryStatsImpl.addHistoryBufferLocked(long, long, android.os.BatteryStats$HistoryItem):void");
    }

    void addHistoryEventLocked(long j, long j2, int i, String str, int i2) {
        this.mHistoryCur.eventCode = i;
        this.mHistoryCur.eventTag = this.mHistoryCur.localEventTag;
        this.mHistoryCur.eventTag.string = str;
        this.mHistoryCur.eventTag.uid = i2;
        addHistoryRecordLocked(j, j2);
    }

    void addHistoryRecordInnerLocked(long j, long j2, BatteryStats.HistoryItem historyItem) {
        addHistoryBufferLocked(j, j2, historyItem);
    }

    void addHistoryRecordLocked(long j, long j2) {
        if (this.mTrackRunningHistoryElapsedRealtime != 0) {
            long j3 = j - this.mTrackRunningHistoryElapsedRealtime;
            long j4 = j2 - this.mTrackRunningHistoryUptime;
            if (j4 < j3 - 20) {
                this.mHistoryAddTmp.setTo(this.mHistoryLastWritten);
                this.mHistoryAddTmp.wakelockTag = null;
                this.mHistoryAddTmp.wakeReasonTag = null;
                this.mHistoryAddTmp.eventCode = 0;
                this.mHistoryAddTmp.states &= Integer.MAX_VALUE;
                addHistoryRecordInnerLocked(j - (j3 - j4), j2, this.mHistoryAddTmp);
            }
        }
        this.mHistoryCur.states |= Integer.MIN_VALUE;
        this.mTrackRunningHistoryElapsedRealtime = j;
        this.mTrackRunningHistoryUptime = j2;
        addHistoryRecordInnerLocked(j, j2, this.mHistoryCur);
    }

    void addHistoryRecordLocked(long j, long j2, byte b, BatteryStats.HistoryItem historyItem) {
        BatteryStats.HistoryItem historyItem2 = this.mHistoryCache;
        if (historyItem2 != null) {
            this.mHistoryCache = historyItem2.next;
        } else {
            historyItem2 = new BatteryStats.HistoryItem();
        }
        historyItem2.setTo(this.mHistoryBaseTime + j, b, historyItem);
        addHistoryRecordLocked(historyItem2);
    }

    void addHistoryRecordLocked(BatteryStats.HistoryItem historyItem) {
        this.mNumHistoryItems++;
        historyItem.next = null;
        this.mHistoryLastEnd = this.mHistoryEnd;
        if (this.mHistoryEnd != null) {
            this.mHistoryEnd.next = historyItem;
            this.mHistoryEnd = historyItem;
            return;
        }
        this.mHistoryEnd = historyItem;
        this.mHistory = historyItem;
    }

    public void addIsolatedUidLocked(int i, int i2) {
        this.mIsolatedUids.put(i, i2);
    }

    void aggregateLastWakeupUptimeLocked(long j) {
        if (this.mLastWakeupReason != null) {
            long j2 = this.mLastWakeupUptimeMs;
            SamplingTimer wakeupReasonTimerLocked = getWakeupReasonTimerLocked(this.mLastWakeupReason);
            wakeupReasonTimerLocked.addCurrentReportedCount(1);
            wakeupReasonTimerLocked.addCurrentReportedTotalTime(1000 * (j - j2));
            this.mLastWakeupReason = null;
        }
    }

    void clearHistoryLocked() {
        this.mHistoryBaseTime = 0L;
        this.mLastHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryElapsedRealtime = 0L;
        this.mTrackRunningHistoryUptime = 0L;
        this.mHistoryBuffer.setDataSize(0);
        this.mHistoryBuffer.setDataPosition(0);
        this.mHistoryBuffer.setDataCapacity(131072);
        this.mHistoryLastLastWritten.clear();
        this.mHistoryLastWritten.clear();
        this.mHistoryTagPool.clear();
        this.mNextHistoryTagIdx = 0;
        this.mNumHistoryTagChars = 0;
        this.mHistoryBufferLastPos = -1;
        this.mHistoryOverflow = false;
        this.mLastRecordedClockTime = 0L;
        this.mLastRecordedClockRealtime = 0L;
    }

    public void commitCurrentHistoryBatchLocked() {
        this.mHistoryLastWritten.cmd = (byte) -1;
    }

    public void commitPendingDataToDisk() {
        synchronized (this) {
            Parcel parcel = this.mPendingWrite;
            this.mPendingWrite = null;
            if (parcel == null) {
                return;
            }
            this.mWriteLock.lock();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mFile.chooseForWrite());
                fileOutputStream.write(parcel.marshall());
                fileOutputStream.flush();
                FileUtils.sync(fileOutputStream);
                fileOutputStream.close();
                this.mFile.commit();
            } catch (IOException e) {
                Slog.w("BatteryStats", "Error writing battery statistics", e);
                this.mFile.rollback();
            } finally {
                parcel.recycle();
                this.mWriteLock.unlock();
            }
        }
    }

    public long computeBatteryRealtime(long j, int i) {
        return this.mOnBatteryTimeBase.computeRealtime(j, i);
    }

    public long computeBatteryScreenOffRealtime(long j, int i) {
        return this.mOnBatteryScreenOffTimeBase.computeRealtime(j, i);
    }

    public long computeBatteryScreenOffUptime(long j, int i) {
        return this.mOnBatteryScreenOffTimeBase.computeUptime(j, i);
    }

    public long computeBatteryTimeRemaining(long j) {
        if (this.mOnBattery && this.mNumDischargeStepDurations >= 1) {
            long computeTimePerLevel = computeTimePerLevel(this.mDischargeStepDurations, this.mNumDischargeStepDurations);
            if (computeTimePerLevel > 0) {
                return this.mCurrentBatteryLevel * computeTimePerLevel * 1000;
            }
            return -1L;
        }
        return -1L;
    }

    public long computeBatteryUptime(long j, int i) {
        return this.mOnBatteryTimeBase.computeUptime(j, i);
    }

    public long computeChargeTimeRemaining(long j) {
        if (!this.mOnBattery && this.mNumChargeStepDurations >= 1) {
            long computeTimePerLevel = computeTimePerLevel(this.mChargeStepDurations, this.mNumChargeStepDurations);
            if (computeTimePerLevel > 0) {
                return (100 - this.mCurrentBatteryLevel) * computeTimePerLevel * 1000;
            }
            return -1L;
        }
        return -1L;
    }

    public long computeRealtime(long j, int i) {
        switch (i) {
            case 0:
                return this.mRealtime + (j - this.mRealtimeStart);
            case 1:
                return j - this.mRealtimeStart;
            case 2:
                return j - this.mOnBatteryTimeBase.getRealtimeStart();
            default:
                return 0L;
        }
    }

    public long computeUptime(long j, int i) {
        switch (i) {
            case 0:
                return this.mUptime + (j - this.mUptimeStart);
            case 1:
                return j - this.mUptimeStart;
            case 2:
                return j - this.mOnBatteryTimeBase.getUptimeStart();
            default:
                return 0L;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void distributeWorkLocked(int i) {
        Uid uid = this.mUidStats.get(1010);
        if (uid == null) {
            return;
        }
        long computeBatteryRealtime = computeBatteryRealtime(SystemClock.elapsedRealtime() * 1000, i);
        int size = uid.mProcessStats.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return;
            }
            Uid.Proc valueAt = uid.mProcessStats.valueAt(i2);
            long globalWifiRunningTime = getGlobalWifiRunningTime(computeBatteryRealtime, i);
            int i3 = 0;
            while (i3 < this.mUidStats.size()) {
                Uid valueAt2 = this.mUidStats.valueAt(i3);
                long j = globalWifiRunningTime;
                if (valueAt2.mUid != 1010) {
                    long wifiRunningTime = valueAt2.getWifiRunningTime(computeBatteryRealtime, i);
                    j = globalWifiRunningTime;
                    if (wifiRunningTime > 0) {
                        Uid.Proc processStatsLocked = valueAt2.getProcessStatsLocked("*wifi*");
                        long userTime = (valueAt.getUserTime(i) * wifiRunningTime) / globalWifiRunningTime;
                        processStatsLocked.mUserTime += userTime;
                        valueAt.mUserTime -= userTime;
                        long systemTime = (valueAt.getSystemTime(i) * wifiRunningTime) / globalWifiRunningTime;
                        processStatsLocked.mSystemTime += systemTime;
                        valueAt.mSystemTime -= systemTime;
                        long foregroundTime = (valueAt.getForegroundTime(i) * wifiRunningTime) / globalWifiRunningTime;
                        processStatsLocked.mForegroundTime += foregroundTime;
                        valueAt.mForegroundTime -= foregroundTime;
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= valueAt.mSpeedBins.length) {
                                break;
                            }
                            SamplingCounter samplingCounter = valueAt.mSpeedBins[i5];
                            if (samplingCounter != null) {
                                long countLocked = (samplingCounter.getCountLocked(i) * wifiRunningTime) / globalWifiRunningTime;
                                SamplingCounter samplingCounter2 = processStatsLocked.mSpeedBins[i5];
                                SamplingCounter samplingCounter3 = samplingCounter2;
                                if (samplingCounter2 == null) {
                                    samplingCounter3 = new SamplingCounter(this.mOnBatteryTimeBase);
                                    processStatsLocked.mSpeedBins[i5] = samplingCounter3;
                                }
                                samplingCounter3.mCount.addAndGet((int) countLocked);
                                samplingCounter.mCount.addAndGet((int) (-countLocked));
                            }
                            i4 = i5 + 1;
                        }
                        j = globalWifiRunningTime - wifiRunningTime;
                    }
                }
                i3++;
                globalWifiRunningTime = j;
            }
            size = i2;
        }
    }

    public void dumpLocked(Context context, PrintWriter printWriter, int i, int i2, long j) {
        super.dumpLocked(context, printWriter, i, i2, j);
    }

    public void finishAddingCpuLocked(int i, int i2, int i3, long[] jArr) {
        Uid uidStatsLocked;
        int size = this.mPartialTimers.size();
        if (i != 0) {
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                StopwatchTimer stopwatchTimer = this.mPartialTimers.get(i5);
                int i6 = i4;
                if (stopwatchTimer.mInList) {
                    Uid uid = stopwatchTimer.mUid;
                    i6 = i4;
                    if (uid != null) {
                        i6 = i4;
                        if (uid.mUid != 1000) {
                            i6 = i4 + 1;
                        }
                    }
                }
                i5++;
                i4 = i6;
            }
            int i7 = i2;
            int i8 = i3;
            if (i4 != 0) {
                int i9 = i4;
                int i10 = 0;
                while (true) {
                    i7 = i2;
                    i8 = i3;
                    if (i10 >= size) {
                        break;
                    }
                    StopwatchTimer stopwatchTimer2 = this.mPartialTimers.get(i10);
                    int i11 = i9;
                    int i12 = i2;
                    int i13 = i3;
                    if (stopwatchTimer2.mInList) {
                        Uid uid2 = stopwatchTimer2.mUid;
                        i11 = i9;
                        i12 = i2;
                        i13 = i3;
                        if (uid2 != null) {
                            i11 = i9;
                            i12 = i2;
                            i13 = i3;
                            if (uid2.mUid != 1000) {
                                int i14 = i2 / i9;
                                int i15 = i3 / i9;
                                i12 = i2 - i14;
                                i13 = i3 - i15;
                                i11 = i9 - 1;
                                Uid.Proc processStatsLocked = uid2.getProcessStatsLocked("*wakelock*");
                                processStatsLocked.addCpuTimeLocked(i14, i15);
                                processStatsLocked.addSpeedStepTimes(jArr);
                            }
                        }
                    }
                    i10++;
                    i9 = i11;
                    i2 = i12;
                    i3 = i13;
                }
            }
            if ((i7 != 0 || i8 != 0) && (uidStatsLocked = getUidStatsLocked(1000)) != null) {
                Uid.Proc processStatsLocked2 = uidStatsLocked.getProcessStatsLocked("*lost*");
                processStatsLocked2.addCpuTimeLocked(i7, i8);
                processStatsLocked2.addSpeedStepTimes(jArr);
            }
        }
        int size2 = this.mLastPartialTimers.size();
        boolean z = size != size2;
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= size2 || z) {
                break;
            }
            z |= this.mPartialTimers.get(i17) != this.mLastPartialTimers.get(i17);
            i16 = i17 + 1;
        }
        if (z) {
            int i18 = 0;
            while (true) {
                int i19 = i18;
                if (i19 >= size2) {
                    break;
                }
                this.mLastPartialTimers.get(i19).mInList = false;
                i18 = i19 + 1;
            }
            this.mLastPartialTimers.clear();
            int i20 = 0;
            while (true) {
                int i21 = i20;
                if (i21 >= size) {
                    return;
                }
                StopwatchTimer stopwatchTimer3 = this.mPartialTimers.get(i21);
                stopwatchTimer3.mInList = true;
                this.mLastPartialTimers.add(stopwatchTimer3);
                i20 = i21 + 1;
            }
        } else {
            int i22 = 0;
            while (true) {
                int i23 = i22;
                if (i23 >= size2) {
                    return;
                }
                this.mPartialTimers.get(i23).mInList = true;
                i22 = i23 + 1;
            }
        }
    }

    public void finishIteratingHistoryLocked() {
        this.mIteratingHistory = false;
        this.mHistoryBuffer.setDataPosition(this.mHistoryBuffer.dataSize());
        this.mReadHistoryStrings = null;
    }

    public void finishIteratingOldHistoryLocked() {
        this.mIteratingHistory = false;
        this.mHistoryBuffer.setDataPosition(this.mHistoryBuffer.dataSize());
        this.mHistoryIterator = null;
    }

    public long getAwakeTimeBattery() {
        return computeBatteryUptime(getBatteryUptimeLocked(), 1);
    }

    public long getAwakeTimePlugged() {
        return (SystemClock.uptimeMillis() * 1000) - getAwakeTimeBattery();
    }

    public long getBatteryRealtime(long j) {
        return this.mOnBatteryTimeBase.getRealtime(j);
    }

    public long getBatteryUptime(long j) {
        return this.mOnBatteryTimeBase.getUptime(j);
    }

    long getBatteryUptimeLocked() {
        return this.mOnBatteryTimeBase.getUptime(SystemClock.uptimeMillis() * 1000);
    }

    public long getBluetoothOnTime(long j, int i) {
        return this.mBluetoothOnTimer.getTotalTimeLocked(j, i);
    }

    public int getBluetoothPingCount() {
        if (this.mBluetoothPingStart == -1) {
            return this.mBluetoothPingCount;
        }
        if (this.mBtHeadset != null) {
            return getCurrentBluetoothPingCount() - this.mBluetoothPingStart;
        }
        return 0;
    }

    public int getBluetoothStateCount(int i, int i2) {
        return this.mBluetoothStateTimer[i].getCountLocked(i2);
    }

    public long getBluetoothStateTime(int i, long j, int i2) {
        return this.mBluetoothStateTimer[i].getTotalTimeLocked(j, i2);
    }

    public long[] getChargeStepDurationsArray() {
        return this.mChargeStepDurations;
    }

    public int getCpuSpeedSteps() {
        return sNumSpeedSteps;
    }

    public int getDischargeAmount(int i) {
        int highDischargeAmountSinceCharge = i == 0 ? getHighDischargeAmountSinceCharge() : getDischargeStartLevel() - getDischargeCurrentLevel();
        int i2 = highDischargeAmountSinceCharge;
        if (highDischargeAmountSinceCharge < 0) {
            i2 = 0;
        }
        return i2;
    }

    public int getDischargeAmountScreenOff() {
        int i;
        synchronized (this) {
            int i2 = this.mDischargeAmountScreenOff;
            i = i2;
            if (this.mOnBattery) {
                i = i2;
                if (this.mScreenState != 2) {
                    i = i2;
                    if (this.mDischargeCurrentLevel < this.mDischargeScreenOffUnplugLevel) {
                        i = i2 + (this.mDischargeScreenOffUnplugLevel - this.mDischargeCurrentLevel);
                    }
                }
            }
        }
        return i;
    }

    public int getDischargeAmountScreenOffSinceCharge() {
        int i;
        synchronized (this) {
            int i2 = this.mDischargeAmountScreenOffSinceCharge;
            i = i2;
            if (this.mOnBattery) {
                i = i2;
                if (this.mScreenState != 2) {
                    i = i2;
                    if (this.mDischargeCurrentLevel < this.mDischargeScreenOffUnplugLevel) {
                        i = i2 + (this.mDischargeScreenOffUnplugLevel - this.mDischargeCurrentLevel);
                    }
                }
            }
        }
        return i;
    }

    public int getDischargeAmountScreenOn() {
        int i;
        synchronized (this) {
            int i2 = this.mDischargeAmountScreenOn;
            i = i2;
            if (this.mOnBattery) {
                i = i2;
                if (this.mScreenState == 2) {
                    i = i2;
                    if (this.mDischargeCurrentLevel < this.mDischargeScreenOnUnplugLevel) {
                        i = i2 + (this.mDischargeScreenOnUnplugLevel - this.mDischargeCurrentLevel);
                    }
                }
            }
        }
        return i;
    }

    public int getDischargeAmountScreenOnSinceCharge() {
        int i;
        synchronized (this) {
            int i2 = this.mDischargeAmountScreenOnSinceCharge;
            i = i2;
            if (this.mOnBattery) {
                i = i2;
                if (this.mScreenState == 2) {
                    i = i2;
                    if (this.mDischargeCurrentLevel < this.mDischargeScreenOnUnplugLevel) {
                        i = i2 + (this.mDischargeScreenOnUnplugLevel - this.mDischargeCurrentLevel);
                    }
                }
            }
        }
        return i;
    }

    public int getDischargeCurrentLevel() {
        int dischargeCurrentLevelLocked;
        synchronized (this) {
            dischargeCurrentLevelLocked = getDischargeCurrentLevelLocked();
        }
        return dischargeCurrentLevelLocked;
    }

    public int getDischargeCurrentLevelLocked() {
        return this.mDischargeCurrentLevel;
    }

    public int getDischargeStartLevel() {
        int dischargeStartLevelLocked;
        synchronized (this) {
            dischargeStartLevelLocked = getDischargeStartLevelLocked();
        }
        return dischargeStartLevelLocked;
    }

    public int getDischargeStartLevelLocked() {
        return this.mDischargeUnplugLevel;
    }

    public long[] getDischargeStepDurationsArray() {
        return this.mDischargeStepDurations;
    }

    public String getEndPlatformVersion() {
        return this.mEndPlatformVersion;
    }

    public long getFlashlightOnCount(int i) {
        return this.mFlashlightOnTimer.getCountLocked(i);
    }

    public long getFlashlightOnTime(long j, int i) {
        return this.mFlashlightOnTimer.getTotalTimeLocked(j, i);
    }

    public long getGlobalWifiRunningTime(long j, int i) {
        return this.mGlobalWifiRunningTimer.getTotalTimeLocked(j, i);
    }

    public int getHighDischargeAmountSinceCharge() {
        int i;
        synchronized (this) {
            int i2 = this.mHighDischargeAmountSinceCharge;
            i = i2;
            if (this.mOnBattery) {
                i = i2;
                if (this.mDischargeCurrentLevel < this.mDischargeUnplugLevel) {
                    i = i2 + (this.mDischargeUnplugLevel - this.mDischargeCurrentLevel);
                }
            }
        }
        return i;
    }

    public long getHistoryBaseTime() {
        return this.mHistoryBaseTime;
    }

    public int getHistoryStringPoolBytes() {
        return (this.mReadHistoryStrings.length * 12) + (this.mReadHistoryChars * 2);
    }

    public int getHistoryStringPoolSize() {
        return this.mReadHistoryStrings.length;
    }

    public String getHistoryTagPoolString(int i) {
        return this.mReadHistoryStrings[i];
    }

    public int getHistoryTagPoolUid(int i) {
        return this.mReadHistoryUids[i];
    }

    public int getHistoryTotalSize() {
        return 262144;
    }

    public int getHistoryUsedSize() {
        return this.mHistoryBuffer.dataSize();
    }

    public long getInteractiveTime(long j, int i) {
        return this.mInteractiveTimer.getTotalTimeLocked(j, i);
    }

    public boolean getIsOnBattery() {
        return this.mOnBattery;
    }

    public Map<String, ? extends Timer> getKernelWakelockStats() {
        return this.mKernelWakelockStats;
    }

    public SamplingTimer getKernelWakelockTimerLocked(String str) {
        SamplingTimer samplingTimer = this.mKernelWakelockStats.get(str);
        SamplingTimer samplingTimer2 = samplingTimer;
        if (samplingTimer == null) {
            samplingTimer2 = new SamplingTimer(this.mOnBatteryScreenOffTimeBase, true);
            this.mKernelWakelockStats.put(str, samplingTimer2);
        }
        return samplingTimer2;
    }

    protected int getKernelWakelockUpdateVersion() {
        return sKernelWakelockUpdateVersion;
    }

    protected String getLogName() {
        return "BatteryStats";
    }

    public int getLowDischargeAmountSinceCharge() {
        int i;
        synchronized (this) {
            int i2 = this.mLowDischargeAmountSinceCharge;
            i = i2;
            if (this.mOnBattery) {
                i = i2;
                if (this.mDischargeCurrentLevel < this.mDischargeUnplugLevel) {
                    i = i2 + ((this.mDischargeUnplugLevel - this.mDischargeCurrentLevel) - 1);
                }
            }
        }
        return i;
    }

    public int getLowPowerModeEnabledCount(int i) {
        return this.mLowPowerModeEnabledTimer.getCountLocked(i);
    }

    public long getLowPowerModeEnabledTime(long j, int i) {
        return this.mLowPowerModeEnabledTimer.getTotalTimeLocked(j, i);
    }

    public long getMobileRadioActiveAdjustedTime(int i) {
        return this.mMobileRadioActiveAdjustedTime.getCountLocked(i);
    }

    public int getMobileRadioActiveCount(int i) {
        return this.mMobileRadioActiveTimer.getCountLocked(i);
    }

    public long getMobileRadioActiveTime(long j, int i) {
        return this.mMobileRadioActiveTimer.getTotalTimeLocked(j, i);
    }

    public int getMobileRadioActiveUnknownCount(int i) {
        return (int) this.mMobileRadioActiveUnknownCount.getCountLocked(i);
    }

    public long getMobileRadioActiveUnknownTime(int i) {
        return this.mMobileRadioActiveUnknownTime.getCountLocked(i);
    }

    public long getNetworkActivityBytes(int i, int i2) {
        if (i < 0 || i >= this.mNetworkByteActivityCounters.length) {
            return 0L;
        }
        return this.mNetworkByteActivityCounters[i].getCountLocked(i2);
    }

    public long getNetworkActivityPackets(int i, int i2) {
        if (i < 0 || i >= this.mNetworkPacketActivityCounters.length) {
            return 0L;
        }
        return this.mNetworkPacketActivityCounters[i].getCountLocked(i2);
    }

    public boolean getNextHistoryLocked(BatteryStats.HistoryItem historyItem) {
        int dataPosition = this.mHistoryBuffer.dataPosition();
        if (dataPosition == 0) {
            historyItem.clear();
        }
        if (dataPosition >= this.mHistoryBuffer.dataSize()) {
            return false;
        }
        long j = historyItem.time;
        long j2 = historyItem.currentTime;
        readHistoryDelta(this.mHistoryBuffer, historyItem);
        if (historyItem.cmd == 5 || historyItem.cmd == 7 || j2 == 0) {
            return true;
        }
        historyItem.currentTime = (historyItem.time - j) + j2;
        return true;
    }

    public boolean getNextOldHistoryLocked(BatteryStats.HistoryItem historyItem) {
        boolean z = this.mHistoryBuffer.dataPosition() >= this.mHistoryBuffer.dataSize();
        if (!z) {
            readHistoryDelta(this.mHistoryBuffer, this.mHistoryReadTmp);
            this.mReadOverflow = (this.mHistoryReadTmp.cmd == 6) | this.mReadOverflow;
        }
        BatteryStats.HistoryItem historyItem2 = this.mHistoryIterator;
        if (historyItem2 == null) {
            if (this.mReadOverflow || z) {
                return false;
            }
            Slog.w(TAG, "Old history ends before new history!");
            return false;
        }
        historyItem.setTo(historyItem2);
        this.mHistoryIterator = historyItem2.next;
        if (this.mReadOverflow) {
            return true;
        }
        if (z) {
            Slog.w(TAG, "New history ends before old history!");
            return true;
        } else if (historyItem.same(this.mHistoryReadTmp)) {
            return true;
        } else {
            FastPrintWriter fastPrintWriter = new FastPrintWriter((Writer) new LogWriter(5, TAG));
            fastPrintWriter.println("Histories differ!");
            fastPrintWriter.println("Old history:");
            new BatteryStats.HistoryPrinter().printNextItem(fastPrintWriter, historyItem, 0L, false, true);
            fastPrintWriter.println("New history:");
            new BatteryStats.HistoryPrinter().printNextItem(fastPrintWriter, this.mHistoryReadTmp, 0L, false, true);
            fastPrintWriter.flush();
            return true;
        }
    }

    public int getNumChargeStepDurations() {
        return this.mNumChargeStepDurations;
    }

    public int getNumConnectivityChange(int i) {
        int i2;
        int i3 = this.mNumConnectivityChange;
        if (i == 1) {
            i2 = i3 - this.mLoadedNumConnectivityChange;
        } else {
            i2 = i3;
            if (i == 2) {
                return i3 - this.mUnpluggedNumConnectivityChange;
            }
        }
        return i2;
    }

    public int getNumDischargeStepDurations() {
        return this.mNumDischargeStepDurations;
    }

    public Uid.Pkg getPackageStatsLocked(int i, String str) {
        return getUidStatsLocked(mapUid(i)).getPackageStatsLocked(str);
    }

    public int getParcelVersion() {
        return 116;
    }

    public int getPhoneDataConnectionCount(int i, int i2) {
        return this.mPhoneDataConnectionsTimer[i].getCountLocked(i2);
    }

    public long getPhoneDataConnectionTime(int i, long j, int i2) {
        return this.mPhoneDataConnectionsTimer[i].getTotalTimeLocked(j, i2);
    }

    public int getPhoneOnCount(int i) {
        return this.mPhoneOnTimer.getCountLocked(i);
    }

    public long getPhoneOnTime(long j, int i) {
        return this.mPhoneOnTimer.getTotalTimeLocked(j, i);
    }

    public long getPhoneSignalScanningTime(long j, int i) {
        return this.mPhoneSignalScanningTimer.getTotalTimeLocked(j, i);
    }

    public int getPhoneSignalStrengthCount(int i, int i2) {
        return this.mPhoneSignalStrengthsTimer[i].getCountLocked(i2);
    }

    public long getPhoneSignalStrengthTime(int i, long j, int i2) {
        return this.mPhoneSignalStrengthsTimer[i].getTotalTimeLocked(j, i2);
    }

    public Uid.Proc getProcessStatsLocked(int i, String str) {
        return getUidStatsLocked(mapUid(i)).getProcessStatsLocked(str);
    }

    public long getProcessWakeTime(int i, int i2, long j) {
        long j2 = 0;
        Uid uid = this.mUidStats.get(mapUid(i));
        long j3 = 0;
        if (uid != null) {
            BatteryStats.Uid.Pid pid = uid.mPids.get(i2);
            j3 = 0;
            if (pid != null) {
                long j4 = pid.mWakeSumMs;
                if (pid.mWakeNesting > 0) {
                    j2 = j - pid.mWakeStartMs;
                }
                j3 = j2 + j4;
            }
        }
        return j3;
    }

    public long getScreenBrightnessTime(int i, long j, int i2) {
        return this.mScreenBrightnessTimer[i].getTotalTimeLocked(j, i2);
    }

    public int getScreenOnCount(int i) {
        return this.mScreenOnTimer.getCountLocked(i);
    }

    public long getScreenOnTime(long j, int i) {
        return this.mScreenOnTimer.getTotalTimeLocked(j, i);
    }

    public Uid.Pkg.Serv getServiceStatsLocked(int i, String str, String str2) {
        return getUidStatsLocked(mapUid(i)).getServiceStatsLocked(str, str2);
    }

    public long getStartClockTime() {
        if (!isStartClockTimeValid()) {
            this.mStartClockTime = System.currentTimeMillis();
            if (isStartClockTimeValid()) {
                recordCurrentTimeChangeLocked(this.mStartClockTime, SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
            }
        }
        return this.mStartClockTime;
    }

    public int getStartCount() {
        return this.mStartCount;
    }

    public String getStartPlatformVersion() {
        return this.mStartPlatformVersion;
    }

    protected String getStatsName() {
        return "batterystats";
    }

    public SparseArray<? extends BatteryStats.Uid> getUidStats() {
        return this.mUidStats;
    }

    public Uid getUidStatsLocked(int i) {
        Uid uid = this.mUidStats.get(i);
        Uid uid2 = uid;
        if (uid == null) {
            uid2 = new Uid(i);
            this.mUidStats.put(i, uid2);
        }
        return uid2;
    }

    public Map<String, ? extends Timer> getWakeupReasonStats() {
        return this.mWakeupReasonStats;
    }

    public SamplingTimer getWakeupReasonTimerLocked(String str) {
        SamplingTimer samplingTimer = this.mWakeupReasonStats.get(str);
        SamplingTimer samplingTimer2 = samplingTimer;
        if (samplingTimer == null) {
            samplingTimer2 = new SamplingTimer(this.mOnBatteryTimeBase, true);
            this.mWakeupReasonStats.put(str, samplingTimer2);
        }
        return samplingTimer2;
    }

    public long getWifiOnTime(long j, int i) {
        return this.mWifiOnTimer.getTotalTimeLocked(j, i);
    }

    public int getWifiSignalStrengthCount(int i, int i2) {
        return this.mWifiSignalStrengthsTimer[i].getCountLocked(i2);
    }

    public long getWifiSignalStrengthTime(int i, long j, int i2) {
        return this.mWifiSignalStrengthsTimer[i].getTotalTimeLocked(j, i2);
    }

    public int getWifiStateCount(int i, int i2) {
        return this.mWifiStateTimer[i].getCountLocked(i2);
    }

    public long getWifiStateTime(int i, long j, int i2) {
        return this.mWifiStateTimer[i].getTotalTimeLocked(j, i2);
    }

    public int getWifiSupplStateCount(int i, int i2) {
        return this.mWifiSupplStateTimer[i].getCountLocked(i2);
    }

    public long getWifiSupplStateTime(int i, long j, int i2) {
        return this.mWifiSupplStateTimer[i].getTotalTimeLocked(j, i2);
    }

    void initDischarge() {
        this.mLowDischargeAmountSinceCharge = 0;
        this.mHighDischargeAmountSinceCharge = 0;
        this.mDischargeAmountScreenOn = 0;
        this.mDischargeAmountScreenOnSinceCharge = 0;
        this.mDischargeAmountScreenOff = 0;
        this.mDischargeAmountScreenOffSinceCharge = 0;
        this.mLastDischargeStepTime = -1L;
        this.mNumDischargeStepDurations = 0;
        this.mLastChargeStepTime = -1L;
        this.mNumChargeStepDurations = 0;
    }

    void initTimes(long j, long j2) {
        this.mStartClockTime = System.currentTimeMillis();
        this.mOnBatteryTimeBase.init(j, j2);
        this.mOnBatteryScreenOffTimeBase.init(j, j2);
        this.mRealtime = 0L;
        this.mUptime = 0L;
        this.mRealtimeStart = j2;
        this.mUptimeStart = j;
    }

    public boolean isOnBattery() {
        return this.mOnBattery;
    }

    public boolean isScreenOn() {
        return this.mScreenState == 2;
    }

    boolean isStartClockTimeValid() {
        return this.mStartClockTime > 31536000000L;
    }

    public int mapUid(int i) {
        int i2 = this.mIsolatedUids.get(i, -1);
        return i2 > 0 ? i2 : i;
    }

    public void noteActivityPausedLocked(int i) {
        getUidStatsLocked(mapUid(i)).noteActivityPausedLocked(SystemClock.elapsedRealtime());
    }

    public void noteActivityResumedLocked(int i) {
        getUidStatsLocked(mapUid(i)).noteActivityResumedLocked(SystemClock.elapsedRealtime());
    }

    public void noteAudioOffLocked(int i) {
        if (this.mAudioOnNesting == 0) {
            return;
        }
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = this.mAudioOnNesting - 1;
        this.mAudioOnNesting = i2;
        if (i2 == 0) {
            this.mHistoryCur.states &= -4194305;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mAudioOnTimer.stopRunningLocked(elapsedRealtime);
        }
        getUidStatsLocked(mapUid).noteAudioTurnedOffLocked(elapsedRealtime);
    }

    public void noteAudioOnLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mAudioOnNesting == 0) {
            this.mHistoryCur.states |= 4194304;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mAudioOnTimer.startRunningLocked(elapsedRealtime);
        }
        this.mAudioOnNesting++;
        getUidStatsLocked(mapUid).noteAudioTurnedOnLocked(elapsedRealtime);
    }

    public void noteBluetoothOffLocked() {
        if (this.mBluetoothOn) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHistoryCur.states &= -65537;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mBluetoothOn = false;
            this.mBluetoothOnTimer.stopRunningLocked(elapsedRealtime);
        }
    }

    public void noteBluetoothOnLocked() {
        if (this.mBluetoothOn) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHistoryCur.states |= 65536;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mBluetoothOn = true;
        this.mBluetoothOnTimer.startRunningLocked(elapsedRealtime);
    }

    public void noteBluetoothStateLocked(int i) {
        if (this.mBluetoothState != i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mBluetoothState >= 0) {
                this.mBluetoothStateTimer[this.mBluetoothState].stopRunningLocked(elapsedRealtime);
            }
            this.mBluetoothState = i;
            this.mBluetoothStateTimer[i].startRunningLocked(elapsedRealtime);
        }
    }

    public void noteChangeWakelockFromSourceLocked(WorkSource workSource, int i, String str, String str2, int i2, WorkSource workSource2, int i3, String str3, String str4, int i4, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        int size = workSource2.size();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                break;
            }
            noteStartWakeLocked(workSource2.get(i6), i3, str3, str4, i4, z, elapsedRealtime, uptimeMillis);
            i5 = i6 + 1;
        }
        int size2 = workSource.size();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= size2) {
                return;
            }
            noteStopWakeLocked(workSource.get(i8), i, str, str2, i2, elapsedRealtime, uptimeMillis);
            i7 = i8 + 1;
        }
    }

    public void noteConnectivityChangedLocked(int i, String str) {
        addHistoryEventLocked(SystemClock.elapsedRealtime(), SystemClock.uptimeMillis(), 9, str, i);
        this.mNumConnectivityChange++;
    }

    public void noteCurrentTimeChangedLocked() {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (isStartClockTimeValid() && this.mLastRecordedClockTime != 0) {
            long j = this.mLastRecordedClockTime + (elapsedRealtime - this.mLastRecordedClockRealtime);
            if (currentTimeMillis >= j - 500 && currentTimeMillis <= j + 500) {
                return;
            }
        }
        recordCurrentTimeChangeLocked(currentTimeMillis, elapsedRealtime, uptimeMillis);
        if (isStartClockTimeValid()) {
            this.mStartClockTime = currentTimeMillis;
        }
    }

    public void noteEventLocked(int i, String str, int i2) {
        int mapUid = mapUid(i2);
        if (this.mActiveEvents.updateState(i, str, mapUid, 0)) {
            addHistoryEventLocked(SystemClock.elapsedRealtime(), SystemClock.uptimeMillis(), i, str, mapUid);
        }
    }

    public void noteFlashlightOffLocked() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mFlashlightOn) {
            this.mHistoryCur.states2 &= -134217729;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mFlashlightOn = false;
            this.mFlashlightOnTimer.stopRunningLocked(elapsedRealtime);
        }
    }

    public void noteFlashlightOnLocked() {
        if (this.mFlashlightOn) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHistoryCur.states2 |= 134217728;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mFlashlightOn = true;
        this.mFlashlightOnTimer.startRunningLocked(elapsedRealtime);
    }

    public void noteFullWifiLockAcquiredFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteFullWifiLockAcquiredLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteFullWifiLockAcquiredLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mWifiFullLockNesting == 0) {
            this.mHistoryCur.states |= 268435456;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        this.mWifiFullLockNesting++;
        getUidStatsLocked(mapUid).noteFullWifiLockAcquiredLocked(elapsedRealtime);
    }

    public void noteFullWifiLockReleasedFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteFullWifiLockReleasedLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteFullWifiLockReleasedLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mWifiFullLockNesting--;
        if (this.mWifiFullLockNesting == 0) {
            this.mHistoryCur.states &= -268435457;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        getUidStatsLocked(mapUid).noteFullWifiLockReleasedLocked(elapsedRealtime);
    }

    public void noteInteractiveLocked(boolean z) {
        if (this.mInteractive != z) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mInteractive = z;
            if (z) {
                this.mInteractiveTimer.startRunningLocked(elapsedRealtime);
            } else {
                this.mInteractiveTimer.stopRunningLocked(elapsedRealtime);
            }
        }
    }

    public void noteJobFinishLocked(String str, int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        getUidStatsLocked(mapUid).noteStopJobLocked(str, elapsedRealtime);
        if (this.mActiveEvents.updateState((int) GL10.GL_LIGHT6, str, mapUid, 0)) {
            addHistoryEventLocked(elapsedRealtime, uptimeMillis, GL10.GL_LIGHT6, str, mapUid);
        }
    }

    public void noteJobStartLocked(String str, int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        getUidStatsLocked(mapUid).noteStartJobLocked(str, elapsedRealtime);
        if (this.mActiveEvents.updateState((int) GL11ExtensionPack.GL_FUNC_ADD, str, mapUid, 0)) {
            addHistoryEventLocked(elapsedRealtime, uptimeMillis, GL11ExtensionPack.GL_FUNC_ADD, str, mapUid);
        }
    }

    public void noteLowPowerMode(boolean z) {
        if (this.mLowPowerModeEnabled != z) {
            int i = z ? 4 : 0;
            this.mModStepMode |= (this.mCurStepMode & 4) ^ i;
            this.mCurStepMode = (this.mCurStepMode & (-5)) | i;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mLowPowerModeEnabled = z;
            if (z) {
                this.mHistoryCur.states2 |= Integer.MIN_VALUE;
                this.mLowPowerModeEnabledTimer.startRunningLocked(elapsedRealtime);
            } else {
                this.mHistoryCur.states2 &= Integer.MAX_VALUE;
                this.mLowPowerModeEnabledTimer.stopRunningLocked(elapsedRealtime);
            }
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
    }

    public void noteMobileRadioPowerState(int i, long j) {
        long j2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mMobileRadioPowerState != i) {
            boolean z = i == DataConnectionRealTimeInfo.DC_POWER_STATE_MEDIUM || i == DataConnectionRealTimeInfo.DC_POWER_STATE_HIGH;
            if (z) {
                j2 = elapsedRealtime;
                this.mMobileRadioActiveStartTime = elapsedRealtime;
                this.mHistoryCur.states |= 33554432;
            } else {
                long j3 = j / 1000000;
                long j4 = this.mMobileRadioActiveStartTime;
                if (j3 < j4) {
                    Slog.wtf(TAG, "Data connection inactive timestamp " + j3 + " is before start time " + j4);
                    j2 = elapsedRealtime;
                } else {
                    j2 = j3;
                    if (j3 < elapsedRealtime) {
                        this.mMobileRadioActiveAdjustedTime.addCountLocked(elapsedRealtime - j3);
                        j2 = j3;
                    }
                }
                this.mHistoryCur.states &= -33554433;
            }
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mMobileRadioPowerState = i;
            if (z) {
                this.mMobileRadioActiveTimer.startRunningLocked(elapsedRealtime);
                this.mMobileRadioActivePerAppTimer.startRunningLocked(elapsedRealtime);
                return;
            }
            this.mMobileRadioActiveTimer.stopRunningLocked(j2);
            updateNetworkActivityLocked(1, j2);
            this.mMobileRadioActivePerAppTimer.stopRunningLocked(j2);
        }
    }

    public void noteNetworkInterfaceTypeLocked(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (ConnectivityManager.isNetworkTypeMobile(i)) {
            this.mMobileIfaces = includeInStringArray(this.mMobileIfaces, str);
        } else {
            this.mMobileIfaces = excludeFromStringArray(this.mMobileIfaces, str);
        }
        if (ConnectivityManager.isNetworkTypeWifi(i)) {
            this.mWifiIfaces = includeInStringArray(this.mWifiIfaces, str);
        } else {
            this.mWifiIfaces = excludeFromStringArray(this.mWifiIfaces, str);
        }
    }

    public void noteNetworkStatsEnabledLocked() {
        updateNetworkActivityLocked(65535, SystemClock.elapsedRealtime());
    }

    public void notePhoneDataConnectionStateLocked(int i, boolean z) {
        int i2 = 0;
        if (z) {
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 4;
                    break;
                case 5:
                    i2 = 5;
                    break;
                case 6:
                    i2 = 6;
                    break;
                case 7:
                    i2 = 7;
                    break;
                case 8:
                    i2 = 8;
                    break;
                case 9:
                    i2 = 9;
                    break;
                case 10:
                    i2 = 10;
                    break;
                case 11:
                    i2 = 11;
                    break;
                case 12:
                    i2 = 12;
                    break;
                case 13:
                    i2 = 13;
                    break;
                case 14:
                    i2 = 14;
                    break;
                case 15:
                    i2 = 15;
                    break;
                default:
                    i2 = 16;
                    break;
            }
        }
        if (this.mPhoneDataConnectionType != i2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHistoryCur.states = (this.mHistoryCur.states & (-15873)) | (i2 << 9);
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            if (this.mPhoneDataConnectionType >= 0) {
                this.mPhoneDataConnectionsTimer[this.mPhoneDataConnectionType].stopRunningLocked(elapsedRealtime);
            }
            this.mPhoneDataConnectionType = i2;
            this.mPhoneDataConnectionsTimer[i2].startRunningLocked(elapsedRealtime);
        }
    }

    public void notePhoneOffLocked() {
        if (this.mPhoneOn) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHistoryCur.states &= -262145;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mPhoneOn = false;
            this.mPhoneOnTimer.stopRunningLocked(elapsedRealtime);
        }
    }

    public void notePhoneOnLocked() {
        if (this.mPhoneOn) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHistoryCur.states |= 262144;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mPhoneOn = true;
        this.mPhoneOnTimer.startRunningLocked(elapsedRealtime);
    }

    public void notePhoneSignalStrengthLocked(SignalStrength signalStrength) {
        updateAllPhoneStateLocked(this.mPhoneServiceStateRaw, this.mPhoneSimStateRaw, signalStrength.getLevel());
    }

    public void notePhoneStateLocked(int i, int i2) {
        updateAllPhoneStateLocked(i, i2, this.mPhoneSignalStrengthBinRaw);
    }

    public void noteProcessAnrLocked(String str, int i) {
        int mapUid = mapUid(i);
        if (isOnBattery()) {
            getUidStatsLocked(mapUid).getProcessStatsLocked(str).incNumAnrsLocked();
        }
    }

    public void noteProcessCrashLocked(String str, int i) {
        int mapUid = mapUid(i);
        if (isOnBattery()) {
            getUidStatsLocked(mapUid).getProcessStatsLocked(str).incNumCrashesLocked();
        }
    }

    public void noteProcessDiedLocked(int i, int i2) {
        Uid uid = this.mUidStats.get(mapUid(i));
        if (uid != null) {
            uid.mPids.remove(i2);
        }
    }

    public void noteProcessFinishLocked(String str, int i) {
        int mapUid = mapUid(i);
        if (this.mActiveEvents.updateState((int) GL10.GL_LIGHT1, str, mapUid, 0)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            getUidStatsLocked(mapUid).updateProcessStateLocked(str, 3, elapsedRealtime);
            if (this.mRecordAllHistory) {
                addHistoryEventLocked(elapsedRealtime, uptimeMillis, GL10.GL_LIGHT1, str, mapUid);
            }
        }
    }

    public void noteProcessStartLocked(String str, int i) {
        int mapUid = mapUid(i);
        if (isOnBattery()) {
            getUidStatsLocked(mapUid).getProcessStatsLocked(str).incStartsLocked();
        }
        if (this.mActiveEvents.updateState(32769, str, mapUid, 0) && this.mRecordAllHistory) {
            addHistoryEventLocked(SystemClock.elapsedRealtime(), SystemClock.uptimeMillis(), 32769, str, mapUid);
        }
    }

    public void noteProcessStateLocked(String str, int i, int i2) {
        int mapUid = mapUid(i);
        getUidStatsLocked(mapUid).updateProcessStateLocked(str, i2, SystemClock.elapsedRealtime());
    }

    public void noteResetAudioLocked() {
        if (this.mAudioOnNesting <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mAudioOnNesting = 0;
        this.mHistoryCur.states &= -4194305;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mAudioOnTimer.stopAllRunningLocked(elapsedRealtime);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mUidStats.size()) {
                return;
            }
            this.mUidStats.valueAt(i2).noteResetAudioLocked(elapsedRealtime);
            i = i2 + 1;
        }
    }

    public void noteResetVideoLocked() {
        if (this.mVideoOnNesting <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mAudioOnNesting = 0;
        this.mHistoryCur.states2 &= -1073741825;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mVideoOnTimer.stopAllRunningLocked(elapsedRealtime);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mUidStats.size()) {
                return;
            }
            this.mUidStats.valueAt(i2).noteResetVideoLocked(elapsedRealtime);
            i = i2 + 1;
        }
    }

    public void noteScreenBrightnessLocked(int i) {
        int i2;
        int i3 = i / 51;
        if (i3 < 0) {
            i2 = 0;
        } else {
            i2 = i3;
            if (i3 >= 5) {
                i2 = 4;
            }
        }
        if (this.mScreenBrightnessBin != i2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHistoryCur.states = (this.mHistoryCur.states & (-8)) | (i2 << 0);
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            if (this.mScreenState == 2) {
                if (this.mScreenBrightnessBin >= 0) {
                    this.mScreenBrightnessTimer[this.mScreenBrightnessBin].stopRunningLocked(elapsedRealtime);
                }
                this.mScreenBrightnessTimer[i2].startRunningLocked(elapsedRealtime);
            }
            this.mScreenBrightnessBin = i2;
        }
    }

    public void noteScreenStateLocked(int i) {
        if (this.mScreenState != i) {
            int i2 = this.mScreenState;
            this.mScreenState = i;
            if (i != 0) {
                int i3 = i - 1;
                if (i3 < 4) {
                    this.mModStepMode |= (this.mCurStepMode & 3) ^ i3;
                    this.mCurStepMode = (this.mCurStepMode & (-4)) | i3;
                } else {
                    Slog.wtf(TAG, "Unexpected screen state: " + i);
                }
            }
            if (i == 2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uptimeMillis = SystemClock.uptimeMillis();
                this.mHistoryCur.states |= 1048576;
                addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
                this.mScreenOnTimer.startRunningLocked(elapsedRealtime);
                if (this.mScreenBrightnessBin >= 0) {
                    this.mScreenBrightnessTimer[this.mScreenBrightnessBin].startRunningLocked(elapsedRealtime);
                }
                updateTimeBasesLocked(this.mOnBatteryTimeBase.isRunning(), false, SystemClock.uptimeMillis() * 1000, 1000 * elapsedRealtime);
                noteStartWakeLocked(-1, -1, "screen", null, 0, false, elapsedRealtime, uptimeMillis);
                if (this.mOnBatteryInternal) {
                    updateDischargeScreenLevelsLocked(false, true);
                }
            } else if (i2 == 2) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                this.mHistoryCur.states &= -1048577;
                addHistoryRecordLocked(elapsedRealtime2, uptimeMillis2);
                this.mScreenOnTimer.stopRunningLocked(elapsedRealtime2);
                if (this.mScreenBrightnessBin >= 0) {
                    this.mScreenBrightnessTimer[this.mScreenBrightnessBin].stopRunningLocked(elapsedRealtime2);
                }
                noteStopWakeLocked(-1, -1, "screen", "screen", 0, elapsedRealtime2, uptimeMillis2);
                updateTimeBasesLocked(this.mOnBatteryTimeBase.isRunning(), true, SystemClock.uptimeMillis() * 1000, 1000 * elapsedRealtime2);
                if (this.mOnBatteryInternal) {
                    updateDischargeScreenLevelsLocked(true, false);
                }
            }
        }
    }

    public void noteStartGpsLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mGpsNesting == 0) {
            this.mHistoryCur.states |= 536870912;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        this.mGpsNesting++;
        getUidStatsLocked(mapUid).noteStartGps(elapsedRealtime);
    }

    public void noteStartSensorLocked(int i, int i2) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mSensorNesting == 0) {
            this.mHistoryCur.states |= 8388608;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        this.mSensorNesting++;
        getUidStatsLocked(mapUid).noteStartSensor(i2, elapsedRealtime);
    }

    public void noteStartWakeFromSourceLocked(WorkSource workSource, int i, String str, String str2, int i2, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        int size = workSource.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            noteStartWakeLocked(workSource.get(i4), i, str, str2, i2, z, elapsedRealtime, uptimeMillis);
            i3 = i4 + 1;
        }
    }

    public void noteStartWakeLocked(int i, int i2, String str, String str2, int i3, boolean z, long j, long j2) {
        int mapUid = mapUid(i);
        if (i3 == 0) {
            aggregateLastWakeupUptimeLocked(j2);
            String str3 = str2;
            if (str2 == null) {
                str3 = str;
            }
            if (this.mRecordAllHistory && this.mActiveEvents.updateState(32773, str3, mapUid, 0)) {
                addHistoryEventLocked(j, j2, 32773, str3, mapUid);
            }
            if (this.mWakeLockNesting == 0) {
                this.mHistoryCur.states |= 1073741824;
                this.mHistoryCur.wakelockTag = this.mHistoryCur.localWakelockTag;
                BatteryStats.HistoryTag historyTag = this.mHistoryCur.wakelockTag;
                this.mInitialAcquireWakeName = str3;
                historyTag.string = str3;
                BatteryStats.HistoryTag historyTag2 = this.mHistoryCur.wakelockTag;
                this.mInitialAcquireWakeUid = mapUid;
                historyTag2.uid = mapUid;
                this.mWakeLockImportant = !z;
                addHistoryRecordLocked(j, j2);
            } else if (!this.mWakeLockImportant && !z && this.mHistoryLastWritten.cmd == 0) {
                if (this.mHistoryLastWritten.wakelockTag != null) {
                    this.mHistoryLastWritten.wakelockTag = null;
                    this.mHistoryCur.wakelockTag = this.mHistoryCur.localWakelockTag;
                    BatteryStats.HistoryTag historyTag3 = this.mHistoryCur.wakelockTag;
                    this.mInitialAcquireWakeName = str3;
                    historyTag3.string = str3;
                    BatteryStats.HistoryTag historyTag4 = this.mHistoryCur.wakelockTag;
                    this.mInitialAcquireWakeUid = mapUid;
                    historyTag4.uid = mapUid;
                    addHistoryRecordLocked(j, j2);
                }
                this.mWakeLockImportant = true;
            }
            this.mWakeLockNesting++;
        }
        if (mapUid >= 0) {
            requestWakelockCpuUpdate();
            getUidStatsLocked(mapUid).noteStartWakeLocked(i2, str, i3, j);
        }
    }

    public void noteStopGpsLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mGpsNesting--;
        if (this.mGpsNesting == 0) {
            this.mHistoryCur.states &= -536870913;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        getUidStatsLocked(mapUid).noteStopGps(elapsedRealtime);
    }

    public void noteStopSensorLocked(int i, int i2) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mSensorNesting--;
        if (this.mSensorNesting == 0) {
            this.mHistoryCur.states &= -8388609;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        getUidStatsLocked(mapUid).noteStopSensor(i2, elapsedRealtime);
    }

    public void noteStopWakeFromSourceLocked(WorkSource workSource, int i, String str, String str2, int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        int size = workSource.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            noteStopWakeLocked(workSource.get(i4), i, str, str2, i2, elapsedRealtime, uptimeMillis);
            i3 = i4 + 1;
        }
    }

    public void noteStopWakeLocked(int i, int i2, String str, String str2, int i3, long j, long j2) {
        int mapUid = mapUid(i);
        if (i3 == 0) {
            this.mWakeLockNesting--;
            if (this.mRecordAllHistory) {
                String str3 = str2;
                if (str2 == null) {
                    str3 = str;
                }
                if (this.mActiveEvents.updateState((int) GL10.GL_LIGHT5, str3, mapUid, 0)) {
                    addHistoryEventLocked(j, j2, GL10.GL_LIGHT5, str3, mapUid);
                }
            }
            if (this.mWakeLockNesting == 0) {
                this.mHistoryCur.states &= -1073741825;
                this.mInitialAcquireWakeName = null;
                this.mInitialAcquireWakeUid = -1;
                addHistoryRecordLocked(j, j2);
            }
        }
        if (mapUid >= 0) {
            requestWakelockCpuUpdate();
            getUidStatsLocked(mapUid).noteStopWakeLocked(i2, str, i3, j);
        }
    }

    public void noteSyncFinishLocked(String str, int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        getUidStatsLocked(mapUid).noteStopSyncLocked(str, elapsedRealtime);
        if (this.mActiveEvents.updateState(16388, str, mapUid, 0)) {
            addHistoryEventLocked(elapsedRealtime, uptimeMillis, 16388, str, mapUid);
        }
    }

    public void noteSyncStartLocked(String str, int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        getUidStatsLocked(mapUid).noteStartSyncLocked(str, elapsedRealtime);
        if (this.mActiveEvents.updateState(32772, str, mapUid, 0)) {
            addHistoryEventLocked(elapsedRealtime, uptimeMillis, 32772, str, mapUid);
        }
    }

    public void noteUserActivityLocked(int i, int i2) {
        if (this.mOnBatteryInternal) {
            getUidStatsLocked(mapUid(i)).noteUserActivityLocked(i2);
        }
    }

    public void noteVibratorOffLocked(int i) {
        getUidStatsLocked(mapUid(i)).noteVibratorOffLocked();
    }

    public void noteVibratorOnLocked(int i, long j) {
        getUidStatsLocked(mapUid(i)).noteVibratorOnLocked(j);
    }

    public void noteVideoOffLocked(int i) {
        if (this.mVideoOnNesting == 0) {
            return;
        }
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = this.mVideoOnNesting - 1;
        this.mVideoOnNesting = i2;
        if (i2 == 0) {
            this.mHistoryCur.states2 &= -1073741825;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mVideoOnTimer.stopRunningLocked(elapsedRealtime);
        }
        getUidStatsLocked(mapUid).noteVideoTurnedOffLocked(elapsedRealtime);
    }

    public void noteVideoOnLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mVideoOnNesting == 0) {
            this.mHistoryCur.states2 |= 1073741824;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mVideoOnTimer.startRunningLocked(elapsedRealtime);
        }
        this.mVideoOnNesting++;
        getUidStatsLocked(mapUid).noteVideoTurnedOnLocked(elapsedRealtime);
    }

    public void noteWakeupReasonLocked(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        aggregateLastWakeupUptimeLocked(uptimeMillis);
        this.mHistoryCur.wakeReasonTag = this.mHistoryCur.localWakeReasonTag;
        this.mHistoryCur.wakeReasonTag.string = str;
        this.mHistoryCur.wakeReasonTag.uid = 0;
        this.mLastWakeupReason = str;
        this.mLastWakeupUptimeMs = uptimeMillis;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
    }

    public void noteWifiBatchedScanStartedFromSourceLocked(WorkSource workSource, int i) {
        int size = workSource.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            noteWifiBatchedScanStartedLocked(workSource.get(i3), i);
            i2 = i3 + 1;
        }
    }

    public void noteWifiBatchedScanStartedLocked(int i, int i2) {
        int mapUid = mapUid(i);
        getUidStatsLocked(mapUid).noteWifiBatchedScanStartedLocked(i2, SystemClock.elapsedRealtime());
    }

    public void noteWifiBatchedScanStoppedFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteWifiBatchedScanStoppedLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteWifiBatchedScanStoppedLocked(int i) {
        int mapUid = mapUid(i);
        getUidStatsLocked(mapUid).noteWifiBatchedScanStoppedLocked(SystemClock.elapsedRealtime());
    }

    public void noteWifiMulticastDisabledFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteWifiMulticastDisabledLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteWifiMulticastDisabledLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mWifiMulticastNesting--;
        if (this.mWifiMulticastNesting == 0) {
            this.mHistoryCur.states &= -67108865;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        getUidStatsLocked(mapUid).noteWifiMulticastDisabledLocked(elapsedRealtime);
    }

    public void noteWifiMulticastEnabledFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteWifiMulticastEnabledLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteWifiMulticastEnabledLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mWifiMulticastNesting == 0) {
            this.mHistoryCur.states |= 67108864;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        this.mWifiMulticastNesting++;
        getUidStatsLocked(mapUid).noteWifiMulticastEnabledLocked(elapsedRealtime);
    }

    public void noteWifiOffLocked() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mWifiOn) {
            this.mHistoryCur.states2 &= -268435457;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            this.mWifiOn = false;
            this.mWifiOnTimer.stopRunningLocked(elapsedRealtime);
        }
    }

    public void noteWifiOnLocked() {
        if (this.mWifiOn) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHistoryCur.states2 |= 268435456;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mWifiOn = true;
        this.mWifiOnTimer.startRunningLocked(elapsedRealtime);
    }

    public void noteWifiRssiChangedLocked(int i) {
        int calculateSignalLevel = WifiManager.calculateSignalLevel(i, 5);
        if (this.mWifiSignalStrengthBin != calculateSignalLevel) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.mWifiSignalStrengthBin >= 0) {
                this.mWifiSignalStrengthsTimer[this.mWifiSignalStrengthBin].stopRunningLocked(elapsedRealtime);
            }
            if (calculateSignalLevel >= 0) {
                if (!this.mWifiSignalStrengthsTimer[calculateSignalLevel].isRunningLocked()) {
                    this.mWifiSignalStrengthsTimer[calculateSignalLevel].startRunningLocked(elapsedRealtime);
                }
                this.mHistoryCur.states2 = (this.mHistoryCur.states2 & (-113)) | (calculateSignalLevel << 4);
                addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
            } else {
                stopAllWifiSignalStrengthTimersLocked(-1);
            }
            this.mWifiSignalStrengthBin = calculateSignalLevel;
        }
    }

    public void noteWifiRunningChangedLocked(WorkSource workSource, WorkSource workSource2) {
        if (!this.mGlobalWifiRunning) {
            Log.w(TAG, "noteWifiRunningChangedLocked -- called while WIFI not running");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            getUidStatsLocked(mapUid(workSource.get(i2))).noteWifiStoppedLocked(elapsedRealtime);
            i = i2 + 1;
        }
        int size2 = workSource2.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return;
            }
            getUidStatsLocked(mapUid(workSource2.get(i4))).noteWifiRunningLocked(elapsedRealtime);
            i3 = i4 + 1;
        }
    }

    public void noteWifiRunningLocked(WorkSource workSource) {
        if (this.mGlobalWifiRunning) {
            Log.w(TAG, "noteWifiRunningLocked -- called while WIFI running");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHistoryCur.states2 |= 536870912;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mGlobalWifiRunning = true;
        this.mGlobalWifiRunningTimer.startRunningLocked(elapsedRealtime);
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            getUidStatsLocked(mapUid(workSource.get(i2))).noteWifiRunningLocked(elapsedRealtime);
            i = i2 + 1;
        }
    }

    public void noteWifiScanStartedFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteWifiScanStartedLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteWifiScanStartedLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mWifiScanNesting == 0) {
            this.mHistoryCur.states |= 134217728;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        this.mWifiScanNesting++;
        getUidStatsLocked(mapUid).noteWifiScanStartedLocked(elapsedRealtime);
    }

    public void noteWifiScanStoppedFromSourceLocked(WorkSource workSource) {
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            noteWifiScanStoppedLocked(workSource.get(i2));
            i = i2 + 1;
        }
    }

    public void noteWifiScanStoppedLocked(int i) {
        int mapUid = mapUid(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mWifiScanNesting--;
        if (this.mWifiScanNesting == 0) {
            this.mHistoryCur.states &= -134217729;
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
        getUidStatsLocked(mapUid).noteWifiScanStoppedLocked(elapsedRealtime);
    }

    public void noteWifiStateLocked(int i, String str) {
        if (this.mWifiState != i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mWifiState >= 0) {
                this.mWifiStateTimer[this.mWifiState].stopRunningLocked(elapsedRealtime);
            }
            this.mWifiState = i;
            this.mWifiStateTimer[i].startRunningLocked(elapsedRealtime);
        }
    }

    public void noteWifiStoppedLocked(WorkSource workSource) {
        if (!this.mGlobalWifiRunning) {
            Log.w(TAG, "noteWifiStoppedLocked -- called while WIFI not running");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHistoryCur.states2 &= -536870913;
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        this.mGlobalWifiRunning = false;
        this.mGlobalWifiRunningTimer.stopRunningLocked(elapsedRealtime);
        int size = workSource.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            getUidStatsLocked(mapUid(workSource.get(i2))).noteWifiStoppedLocked(elapsedRealtime);
            i = i2 + 1;
        }
    }

    public void noteWifiSupplicantStateChangedLocked(int i, boolean z) {
        if (this.mWifiSupplState != i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.mWifiSupplState >= 0) {
                this.mWifiSupplStateTimer[this.mWifiSupplState].stopRunningLocked(elapsedRealtime);
            }
            this.mWifiSupplState = i;
            this.mWifiSupplStateTimer[i].startRunningLocked(elapsedRealtime);
            this.mHistoryCur.states2 = (this.mHistoryCur.states2 & (-16)) | (i << 0);
            addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        }
    }

    public void prepareForDumpLocked() {
        pullPendingStateUpdatesLocked();
        getStartClockTime();
    }

    public void pullPendingStateUpdatesLocked() {
        updateKernelWakelocksLocked();
        updateNetworkActivityLocked(65535, SystemClock.elapsedRealtime());
        if (this.mOnBatteryInternal) {
            boolean z = this.mScreenState == 2;
            updateDischargeScreenLevelsLocked(z, z);
        }
    }

    public void readFromParcel(Parcel parcel) {
        readFromParcelLocked(parcel);
    }

    void readFromParcelLocked(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt != MAGIC) {
            throw new ParcelFormatException("Bad magic number: #" + Integer.toHexString(readInt));
        }
        readHistory(parcel, false);
        this.mStartCount = parcel.readInt();
        this.mStartClockTime = parcel.readLong();
        this.mStartPlatformVersion = parcel.readString();
        this.mEndPlatformVersion = parcel.readString();
        this.mUptime = parcel.readLong();
        this.mUptimeStart = parcel.readLong();
        this.mRealtime = parcel.readLong();
        this.mRealtimeStart = parcel.readLong();
        this.mOnBattery = parcel.readInt() != 0;
        this.mOnBatteryInternal = false;
        this.mOnBatteryTimeBase.readFromParcel(parcel);
        this.mOnBatteryScreenOffTimeBase.readFromParcel(parcel);
        this.mScreenState = 0;
        this.mScreenOnTimer = new StopwatchTimer(null, -1, null, this.mOnBatteryTimeBase, parcel);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            this.mScreenBrightnessTimer[i2] = new StopwatchTimer(null, (-100) - i2, null, this.mOnBatteryTimeBase, parcel);
            i = i2 + 1;
        }
        this.mInteractive = false;
        this.mInteractiveTimer = new StopwatchTimer(null, -9, null, this.mOnBatteryTimeBase, parcel);
        this.mPhoneOn = false;
        this.mLowPowerModeEnabledTimer = new StopwatchTimer(null, -2, null, this.mOnBatteryTimeBase, parcel);
        this.mPhoneOnTimer = new StopwatchTimer(null, -3, null, this.mOnBatteryTimeBase, parcel);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                break;
            }
            this.mPhoneSignalStrengthsTimer[i4] = new StopwatchTimer(null, (-200) - i4, null, this.mOnBatteryTimeBase, parcel);
            i3 = i4 + 1;
        }
        this.mPhoneSignalScanningTimer = new StopwatchTimer(null, -199, null, this.mOnBatteryTimeBase, parcel);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 17) {
                break;
            }
            this.mPhoneDataConnectionsTimer[i6] = new StopwatchTimer(null, (-300) - i6, null, this.mOnBatteryTimeBase, parcel);
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 4) {
                break;
            }
            this.mNetworkByteActivityCounters[i8] = new LongSamplingCounter(this.mOnBatteryTimeBase, parcel);
            this.mNetworkPacketActivityCounters[i8] = new LongSamplingCounter(this.mOnBatteryTimeBase, parcel);
            i7 = i8 + 1;
        }
        this.mMobileRadioPowerState = DataConnectionRealTimeInfo.DC_POWER_STATE_LOW;
        this.mMobileRadioActiveTimer = new StopwatchTimer(null, -400, null, this.mOnBatteryTimeBase, parcel);
        this.mMobileRadioActivePerAppTimer = new StopwatchTimer(null, -401, null, this.mOnBatteryTimeBase, parcel);
        this.mMobileRadioActiveAdjustedTime = new LongSamplingCounter(this.mOnBatteryTimeBase, parcel);
        this.mMobileRadioActiveUnknownTime = new LongSamplingCounter(this.mOnBatteryTimeBase, parcel);
        this.mMobileRadioActiveUnknownCount = new LongSamplingCounter(this.mOnBatteryTimeBase, parcel);
        this.mWifiOn = false;
        this.mWifiOnTimer = new StopwatchTimer(null, -4, null, this.mOnBatteryTimeBase, parcel);
        this.mGlobalWifiRunning = false;
        this.mGlobalWifiRunningTimer = new StopwatchTimer(null, -5, null, this.mOnBatteryTimeBase, parcel);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 8) {
                break;
            }
            this.mWifiStateTimer[i10] = new StopwatchTimer(null, (-600) - i10, null, this.mOnBatteryTimeBase, parcel);
            i9 = i10 + 1;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= 13) {
                break;
            }
            this.mWifiSupplStateTimer[i12] = new StopwatchTimer(null, (-700) - i12, null, this.mOnBatteryTimeBase, parcel);
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= 5) {
                break;
            }
            this.mWifiSignalStrengthsTimer[i14] = new StopwatchTimer(null, (-800) - i14, null, this.mOnBatteryTimeBase, parcel);
            i13 = i14 + 1;
        }
        this.mBluetoothOn = false;
        this.mBluetoothOnTimer = new StopwatchTimer(null, -6, null, this.mOnBatteryTimeBase, parcel);
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= 4) {
                break;
            }
            this.mBluetoothStateTimer[i16] = new StopwatchTimer(null, (-500) - i16, null, this.mOnBatteryTimeBase, parcel);
            i15 = i16 + 1;
        }
        this.mNumConnectivityChange = parcel.readInt();
        this.mLoadedNumConnectivityChange = parcel.readInt();
        this.mUnpluggedNumConnectivityChange = parcel.readInt();
        this.mAudioOnNesting = 0;
        this.mAudioOnTimer = new StopwatchTimer(null, -7, null, this.mOnBatteryTimeBase);
        this.mVideoOnNesting = 0;
        this.mVideoOnTimer = new StopwatchTimer(null, -8, null, this.mOnBatteryTimeBase);
        this.mFlashlightOn = false;
        this.mFlashlightOnTimer = new StopwatchTimer(null, -9, null, this.mOnBatteryTimeBase, parcel);
        this.mDischargeUnplugLevel = parcel.readInt();
        this.mDischargePlugLevel = parcel.readInt();
        this.mDischargeCurrentLevel = parcel.readInt();
        this.mCurrentBatteryLevel = parcel.readInt();
        this.mLowDischargeAmountSinceCharge = parcel.readInt();
        this.mHighDischargeAmountSinceCharge = parcel.readInt();
        this.mDischargeAmountScreenOn = parcel.readInt();
        this.mDischargeAmountScreenOnSinceCharge = parcel.readInt();
        this.mDischargeAmountScreenOff = parcel.readInt();
        this.mDischargeAmountScreenOffSinceCharge = parcel.readInt();
        this.mNumDischargeStepDurations = parcel.readInt();
        parcel.readLongArray(this.mDischargeStepDurations);
        this.mNumChargeStepDurations = parcel.readInt();
        parcel.readLongArray(this.mChargeStepDurations);
        this.mLastWriteTime = parcel.readLong();
        this.mBluetoothPingCount = parcel.readInt();
        this.mBluetoothPingStart = -1;
        this.mKernelWakelockStats.clear();
        int readInt2 = parcel.readInt();
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= readInt2) {
                break;
            }
            if (parcel.readInt() != 0) {
                this.mKernelWakelockStats.put(parcel.readString(), new SamplingTimer(this.mOnBatteryScreenOffTimeBase, parcel));
            }
            i17 = i18 + 1;
        }
        this.mWakeupReasonStats.clear();
        int readInt3 = parcel.readInt();
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= readInt3) {
                break;
            }
            if (parcel.readInt() != 0) {
                this.mWakeupReasonStats.put(parcel.readString(), new SamplingTimer(this.mOnBatteryTimeBase, parcel));
            }
            i19 = i20 + 1;
        }
        this.mPartialTimers.clear();
        this.mFullTimers.clear();
        this.mWindowTimers.clear();
        this.mWifiRunningTimers.clear();
        this.mFullWifiLockTimers.clear();
        this.mWifiScanTimers.clear();
        this.mWifiBatchedScanTimers.clear();
        this.mWifiMulticastTimers.clear();
        this.mAudioTurnedOnTimers.clear();
        this.mVideoTurnedOnTimers.clear();
        setCpuSpeedSteps(parcel.readInt());
        int readInt4 = parcel.readInt();
        this.mUidStats.clear();
        int i21 = 0;
        while (true) {
            int i22 = i21;
            if (i22 >= readInt4) {
                return;
            }
            int readInt5 = parcel.readInt();
            Uid uid = new Uid(readInt5);
            uid.readFromParcelLocked(this.mOnBatteryTimeBase, this.mOnBatteryScreenOffTimeBase, parcel);
            this.mUidStats.append(readInt5, uid);
            i21 = i22 + 1;
        }
    }

    void readHistory(Parcel parcel, boolean z) {
        long readLong = parcel.readLong();
        this.mHistoryBuffer.setDataSize(0);
        this.mHistoryBuffer.setDataPosition(0);
        this.mHistoryTagPool.clear();
        this.mNextHistoryTagIdx = 0;
        this.mNumHistoryTagChars = 0;
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                break;
            }
            int readInt2 = parcel.readInt();
            String readString = parcel.readString();
            int readInt3 = parcel.readInt();
            BatteryStats.HistoryTag historyTag = new BatteryStats.HistoryTag();
            historyTag.string = readString;
            historyTag.uid = readInt3;
            historyTag.poolIdx = readInt2;
            this.mHistoryTagPool.put(historyTag, Integer.valueOf(readInt2));
            if (readInt2 >= this.mNextHistoryTagIdx) {
                this.mNextHistoryTagIdx = readInt2 + 1;
            }
            this.mNumHistoryTagChars += historyTag.string.length() + 1;
            i = i2 + 1;
        }
        int readInt4 = parcel.readInt();
        int dataPosition = parcel.dataPosition();
        if (readInt4 >= 983040) {
            Slog.w(TAG, "File corrupt: history data buffer too large " + readInt4);
        } else if ((readInt4 & (-4)) != readInt4) {
            Slog.w(TAG, "File corrupt: history data buffer not aligned " + readInt4);
        } else {
            this.mHistoryBuffer.appendFrom(parcel, dataPosition, readInt4);
            parcel.setDataPosition(dataPosition + readInt4);
        }
        if (z) {
            readOldHistory(parcel);
        }
        this.mHistoryBaseTime = readLong;
        if (this.mHistoryBaseTime > 0) {
            this.mHistoryBaseTime = (this.mHistoryBaseTime - SystemClock.elapsedRealtime()) + 1;
        }
    }

    public void readHistoryDelta(Parcel parcel, BatteryStats.HistoryItem historyItem) {
        int readInt = parcel.readInt();
        int i = readInt & NumericShaper.ALL_RANGES;
        historyItem.cmd = (byte) 0;
        historyItem.numReadInts = 1;
        if (i < DELTA_TIME_ABS) {
            historyItem.time += i;
        } else if (i == DELTA_TIME_ABS) {
            historyItem.time = parcel.readLong();
            historyItem.numReadInts += 2;
            historyItem.readFromParcel(parcel);
            return;
        } else if (i == DELTA_TIME_INT) {
            historyItem.time += parcel.readInt();
            historyItem.numReadInts++;
        } else {
            historyItem.time += parcel.readLong();
            historyItem.numReadInts += 2;
        }
        if ((524288 & readInt) != 0) {
            int readInt2 = parcel.readInt();
            historyItem.batteryLevel = (byte) ((readInt2 >> 25) & 127);
            historyItem.batteryTemperature = (short) ((readInt2 << 7) >> 21);
            historyItem.batteryVoltage = (char) (readInt2 & View.PUBLIC_STATUS_BAR_VISIBILITY_MASK);
            historyItem.numReadInts++;
        }
        if ((1048576 & readInt) != 0) {
            int readInt3 = parcel.readInt();
            historyItem.states = ((-16777216) & readInt) | (16777215 & readInt3);
            historyItem.batteryStatus = (byte) ((readInt3 >> 29) & 7);
            historyItem.batteryHealth = (byte) ((readInt3 >> 26) & 7);
            historyItem.batteryPlugType = (byte) ((readInt3 >> 24) & 3);
            switch (historyItem.batteryPlugType) {
                case 1:
                    historyItem.batteryPlugType = (byte) 1;
                    break;
                case 2:
                    historyItem.batteryPlugType = (byte) 2;
                    break;
                case 3:
                    historyItem.batteryPlugType = (byte) 4;
                    break;
            }
            historyItem.numReadInts++;
        } else {
            historyItem.states = ((-16777216) & readInt) | (historyItem.states & 16777215);
        }
        if ((2097152 & readInt) != 0) {
            historyItem.states2 = parcel.readInt();
        }
        if ((4194304 & readInt) != 0) {
            int readInt4 = parcel.readInt();
            int i2 = readInt4 & 65535;
            int i3 = (readInt4 >> 16) & 65535;
            if (i2 != 65535) {
                historyItem.wakelockTag = historyItem.localWakelockTag;
                readHistoryTag(i2, historyItem.wakelockTag);
            } else {
                historyItem.wakelockTag = null;
            }
            if (i3 != 65535) {
                historyItem.wakeReasonTag = historyItem.localWakeReasonTag;
                readHistoryTag(i3, historyItem.wakeReasonTag);
            } else {
                historyItem.wakeReasonTag = null;
            }
            historyItem.numReadInts++;
        } else {
            historyItem.wakelockTag = null;
            historyItem.wakeReasonTag = null;
        }
        if ((8388608 & readInt) == 0) {
            historyItem.eventCode = 0;
            return;
        }
        historyItem.eventTag = historyItem.localEventTag;
        int readInt5 = parcel.readInt();
        historyItem.eventCode = 65535 & readInt5;
        readHistoryTag((readInt5 >> 16) & 65535, historyItem.eventTag);
        historyItem.numReadInts++;
    }

    public void readLocked() {
        File chooseForRead;
        if (this.mFile == null) {
            Slog.w("BatteryStats", "readLocked: no file associated with this instance");
            return;
        }
        this.mUidStats.clear();
        try {
            chooseForRead = this.mFile.chooseForRead();
        } catch (Exception e) {
            Slog.e("BatteryStats", "Error reading battery statistics", e);
        }
        if (chooseForRead.exists()) {
            FileInputStream fileInputStream = new FileInputStream(chooseForRead);
            byte[] readFully = BatteryStatsHelper.readFully(fileInputStream);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(readFully, 0, readFully.length);
            obtain.setDataPosition(0);
            fileInputStream.close();
            readSummaryFromParcel(obtain);
            this.mEndPlatformVersion = Build.ID;
            if (this.mHistoryBuffer.dataPosition() > 0) {
                this.mRecordingHistory = true;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uptimeMillis = SystemClock.uptimeMillis();
                addHistoryBufferLocked(elapsedRealtime, uptimeMillis, (byte) 4, this.mHistoryCur);
                startRecordingHistory(elapsedRealtime, uptimeMillis, false);
            }
        }
    }

    void readOldHistory(Parcel parcel) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x0723, code lost:
        r0 = r7.readInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x072e, code lost:
        if (r0 <= 10000) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0731, code lost:
        android.util.Slog.w(com.android.internal.os.BatteryStatsImpl.TAG, "File corrupt: too many packages " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x074c, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x074d, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x074f, code lost:
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0752, code lost:
        if (r9 >= r0) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0755, code lost:
        r0 = r7.readString();
        r0 = r0.getPackageStatsLocked(r0);
        r0 = r7.readInt();
        r0.mLoadedWakeups = r0;
        r0.mWakeups = r0;
        r0 = r7.readInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0783, code lost:
        if (r0 <= 1000) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0786, code lost:
        android.util.Slog.w(com.android.internal.os.BatteryStatsImpl.TAG, "File corrupt: too many services " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x07a1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x07a2, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x07a5, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x07a9, code lost:
        if (r10 >= r0) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x07ac, code lost:
        r0 = r0.getServiceStatsLocked(r0, r7.readString());
        r0 = r7.readLong();
        r0.mLoadedStartTime = r0;
        r0.mStartTime = r0;
        r0 = r7.readInt();
        r0.mLoadedStarts = r0;
        r0.mStarts = r0;
        r0 = r7.readInt();
        r0.mLoadedLaunches = r0;
        r0.mLaunches = r0;
        r0 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x07fe, code lost:
        r0 = r9 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readSummaryFromParcel(android.os.Parcel r7) {
        /*
            Method dump skipped, instructions count: 2060
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.BatteryStatsImpl.readSummaryFromParcel(android.os.Parcel):void");
    }

    public void removeIsolatedUidLocked(int i, int i2) {
        if (this.mIsolatedUids.get(i, -1) == i2) {
            this.mIsolatedUids.delete(i);
        }
    }

    public void removeUidStatsLocked(int i) {
        this.mUidStats.remove(i);
    }

    public void reportExcessiveCpuLocked(int i, String str, long j, long j2) {
        Uid uid = this.mUidStats.get(mapUid(i));
        if (uid != null) {
            uid.reportExcessiveCpuLocked(str, j, j2);
        }
    }

    public void reportExcessiveWakeLocked(int i, String str, long j, long j2) {
        Uid uid = this.mUidStats.get(mapUid(i));
        if (uid != null) {
            uid.reportExcessiveWakeLocked(str, j, j2);
        }
    }

    public void resetAllStatsCmdLocked() {
        resetAllStatsLocked();
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis * 1000;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime * 1000;
        this.mDischargeStartLevel = this.mHistoryCur.batteryLevel;
        pullPendingStateUpdatesLocked();
        addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
        byte b = this.mHistoryCur.batteryLevel;
        this.mCurrentBatteryLevel = b;
        this.mDischargePlugLevel = b;
        this.mDischargeUnplugLevel = b;
        this.mDischargeCurrentLevel = b;
        this.mOnBatteryTimeBase.reset(j, j2);
        this.mOnBatteryScreenOffTimeBase.reset(j, j2);
        if ((this.mHistoryCur.states & 524288) == 0) {
            if (this.mScreenState == 2) {
                this.mDischargeScreenOnUnplugLevel = this.mHistoryCur.batteryLevel;
                this.mDischargeScreenOffUnplugLevel = 0;
            } else {
                this.mDischargeScreenOnUnplugLevel = 0;
                this.mDischargeScreenOffUnplugLevel = this.mHistoryCur.batteryLevel;
            }
            this.mDischargeAmountScreenOn = 0;
            this.mDischargeAmountScreenOff = 0;
        }
        initActiveHistoryEventsLocked(elapsedRealtime, uptimeMillis);
    }

    public void setBatteryState(int i, int i2, int i3, int i4, int i5, int i6) {
        synchronized (this) {
            boolean z = i3 == 0 && !(i == 2 && i == 5);
            long uptimeMillis = SystemClock.uptimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            byte b = this.mHistoryCur.batteryStatus;
            if (!this.mHaveBatteryLevel) {
                this.mHaveBatteryLevel = true;
                if (z == this.mOnBattery) {
                    if (z) {
                        this.mHistoryCur.states &= -524289;
                    } else {
                        this.mHistoryCur.states |= 524288;
                    }
                }
                b = i;
            }
            if (z) {
                this.mDischargeCurrentLevel = i4;
                if (!this.mRecordingHistory) {
                    this.mRecordingHistory = true;
                    startRecordingHistory(elapsedRealtime, uptimeMillis, true);
                }
            } else if (i4 < 96 && !this.mRecordingHistory) {
                this.mRecordingHistory = true;
                startRecordingHistory(elapsedRealtime, uptimeMillis, true);
            }
            this.mCurrentBatteryLevel = i4;
            if (this.mDischargePlugLevel < 0) {
                this.mDischargePlugLevel = i4;
            }
            if (z != this.mOnBattery) {
                this.mHistoryCur.batteryLevel = (byte) i4;
                this.mHistoryCur.batteryStatus = (byte) i;
                this.mHistoryCur.batteryHealth = (byte) i2;
                this.mHistoryCur.batteryPlugType = (byte) i3;
                this.mHistoryCur.batteryTemperature = (short) i5;
                this.mHistoryCur.batteryVoltage = (char) i6;
                setOnBatteryLocked(elapsedRealtime, uptimeMillis, z, b, i4);
            } else {
                boolean z2 = false;
                if (this.mHistoryCur.batteryLevel != i4) {
                    this.mHistoryCur.batteryLevel = (byte) i4;
                    z2 = true;
                }
                if (this.mHistoryCur.batteryStatus != i) {
                    this.mHistoryCur.batteryStatus = (byte) i;
                    z2 = true;
                }
                if (this.mHistoryCur.batteryHealth != i2) {
                    this.mHistoryCur.batteryHealth = (byte) i2;
                    z2 = true;
                }
                if (this.mHistoryCur.batteryPlugType != i3) {
                    this.mHistoryCur.batteryPlugType = (byte) i3;
                    z2 = true;
                }
                if (i5 >= this.mHistoryCur.batteryTemperature + 10 || i5 <= this.mHistoryCur.batteryTemperature - 10) {
                    this.mHistoryCur.batteryTemperature = (short) i5;
                    z2 = true;
                }
                if (i6 > this.mHistoryCur.batteryVoltage + 20 || i6 < this.mHistoryCur.batteryVoltage - 20) {
                    this.mHistoryCur.batteryVoltage = (char) i6;
                    z2 = true;
                }
                if (z2) {
                    addHistoryRecordLocked(elapsedRealtime, uptimeMillis);
                }
                long j = (this.mInitStepMode << 48) | (this.mModStepMode << 56) | ((i4 & 255) << 40);
                if (z) {
                    if (this.mLastDischargeStepLevel != i4 && this.mMinDischargeStepLevel > i4) {
                        this.mNumDischargeStepDurations = addLevelSteps(this.mDischargeStepDurations, this.mNumDischargeStepDurations, this.mLastDischargeStepTime, this.mLastDischargeStepLevel - i4, j, elapsedRealtime);
                        this.mLastDischargeStepLevel = i4;
                        this.mMinDischargeStepLevel = i4;
                        this.mLastDischargeStepTime = elapsedRealtime;
                        this.mInitStepMode = this.mCurStepMode;
                        this.mModStepMode = 0;
                    }
                } else if (this.mLastChargeStepLevel != i4 && this.mMaxChargeStepLevel < i4) {
                    this.mNumChargeStepDurations = addLevelSteps(this.mChargeStepDurations, this.mNumChargeStepDurations, this.mLastChargeStepTime, i4 - this.mLastChargeStepLevel, j, elapsedRealtime);
                    this.mLastChargeStepLevel = i4;
                    this.mMaxChargeStepLevel = i4;
                    this.mLastChargeStepTime = elapsedRealtime;
                    this.mInitStepMode = this.mCurStepMode;
                    this.mModStepMode = 0;
                }
            }
            if (!z && i == 5) {
                this.mRecordingHistory = false;
            }
        }
    }

    public void setBtHeadset(BluetoothHeadset bluetoothHeadset) {
        if (bluetoothHeadset != null && this.mBtHeadset == null && isOnBattery() && this.mBluetoothPingStart == -1) {
            this.mBluetoothPingStart = getCurrentBluetoothPingCount();
        }
        this.mBtHeadset = bluetoothHeadset;
    }

    public void setCallback(BatteryCallback batteryCallback) {
        this.mCallback = batteryCallback;
    }

    protected void setCpuSpeedSteps(int i) {
        sNumSpeedSteps = i;
    }

    protected void setKernelWakelockUpdateVersion(int i) {
        sKernelWakelockUpdateVersion = i;
    }

    public void setNoAutoReset(boolean z) {
        this.mNoAutoReset = z;
    }

    public void setNumSpeedSteps(int i) {
        if (getCpuSpeedSteps() == 0) {
            setCpuSpeedSteps(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
        if (r8.mHistoryBuffer.dataSize() >= 262144) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setOnBatteryLocked(long r9, long r11, boolean r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.BatteryStatsImpl.setOnBatteryLocked(long, long, boolean, int, int):void");
    }

    public void setRadioScanningTimeout(long j) {
        if (this.mPhoneSignalScanningTimer != null) {
            this.mPhoneSignalScanningTimer.setTimeout(j);
        }
    }

    public void setRecordAllHistoryLocked(boolean z) {
        this.mRecordAllHistory = z;
        if (z) {
            HashMap stateForEvent = this.mActiveEvents.getStateForEvent(1);
            if (stateForEvent != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uptimeMillis = SystemClock.uptimeMillis();
                for (Map.Entry entry : stateForEvent.entrySet()) {
                    SparseIntArray sparseIntArray = (SparseIntArray) entry.getValue();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < sparseIntArray.size()) {
                            addHistoryEventLocked(elapsedRealtime, uptimeMillis, 32769, (String) entry.getKey(), sparseIntArray.keyAt(i2));
                            i = i2 + 1;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.mActiveEvents.removeEvents(5);
        HashMap stateForEvent2 = this.mActiveEvents.getStateForEvent(1);
        if (stateForEvent2 != null) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long uptimeMillis2 = SystemClock.uptimeMillis();
            for (Map.Entry entry2 : stateForEvent2.entrySet()) {
                SparseIntArray sparseIntArray2 = (SparseIntArray) entry2.getValue();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < sparseIntArray2.size()) {
                        addHistoryEventLocked(elapsedRealtime2, uptimeMillis2, GL10.GL_LIGHT1, (String) entry2.getKey(), sparseIntArray2.keyAt(i4));
                        i3 = i4 + 1;
                    }
                }
            }
        }
    }

    public void shutdownLocked() {
        recordShutdownLocked(SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
        writeSyncLocked();
        this.mShuttingDown = true;
    }

    public int startAddingCpuLocked() {
        Uid uid;
        this.mHandler.removeMessages(1);
        int size = this.mPartialTimers.size();
        if (size == 0) {
            this.mLastPartialTimers.clear();
            this.mDistributeWakelockCpu = false;
            return 0;
        } else if (!this.mOnBatteryScreenOffTimeBase.isRunning() && !this.mDistributeWakelockCpu) {
            return 0;
        } else {
            this.mDistributeWakelockCpu = false;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return 0;
                }
                StopwatchTimer stopwatchTimer = this.mPartialTimers.get(i2);
                if (stopwatchTimer.mInList && (uid = stopwatchTimer.mUid) != null && uid.mUid != 1000) {
                    return 50;
                }
                i = i2 + 1;
            }
        }
    }

    public boolean startIteratingHistoryLocked() {
        if (this.mHistoryBuffer.dataSize() <= 0) {
            return false;
        }
        this.mHistoryBuffer.setDataPosition(0);
        this.mReadOverflow = false;
        this.mIteratingHistory = true;
        this.mReadHistoryStrings = new String[this.mHistoryTagPool.size()];
        this.mReadHistoryUids = new int[this.mHistoryTagPool.size()];
        this.mReadHistoryChars = 0;
        for (Map.Entry<BatteryStats.HistoryTag, Integer> entry : this.mHistoryTagPool.entrySet()) {
            BatteryStats.HistoryTag key = entry.getKey();
            int intValue = entry.getValue().intValue();
            this.mReadHistoryStrings[intValue] = key.string;
            this.mReadHistoryUids[intValue] = key.uid;
            this.mReadHistoryChars += key.string.length() + 1;
        }
        return true;
    }

    public boolean startIteratingOldHistoryLocked() {
        BatteryStats.HistoryItem historyItem = this.mHistory;
        this.mHistoryIterator = historyItem;
        if (historyItem == null) {
            return false;
        }
        this.mHistoryBuffer.setDataPosition(0);
        this.mHistoryReadTmp.clear();
        this.mReadOverflow = false;
        this.mIteratingHistory = true;
        return true;
    }

    void stopAllPhoneSignalStrengthTimersLocked(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 5) {
                return;
            }
            if (i3 != i) {
                while (this.mPhoneSignalStrengthsTimer[i3].isRunningLocked()) {
                    this.mPhoneSignalStrengthsTimer[i3].stopRunningLocked(elapsedRealtime);
                }
            }
            i2 = i3 + 1;
        }
    }

    void stopAllWifiSignalStrengthTimersLocked(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 5) {
                return;
            }
            if (i3 != i) {
                while (this.mWifiSignalStrengthsTimer[i3].isRunningLocked()) {
                    this.mWifiSignalStrengthsTimer[i3].stopRunningLocked(elapsedRealtime);
                }
            }
            i2 = i3 + 1;
        }
    }

    void updateDischargeScreenLevelsLocked(boolean z, boolean z2) {
        if (z) {
            int i = this.mDischargeScreenOnUnplugLevel - this.mDischargeCurrentLevel;
            if (i > 0) {
                this.mDischargeAmountScreenOn += i;
                this.mDischargeAmountScreenOnSinceCharge += i;
            }
        } else {
            int i2 = this.mDischargeScreenOffUnplugLevel - this.mDischargeCurrentLevel;
            if (i2 > 0) {
                this.mDischargeAmountScreenOff += i2;
                this.mDischargeAmountScreenOffSinceCharge += i2;
            }
        }
        if (z2) {
            this.mDischargeScreenOnUnplugLevel = this.mDischargeCurrentLevel;
            this.mDischargeScreenOffUnplugLevel = 0;
            return;
        }
        this.mDischargeScreenOnUnplugLevel = 0;
        this.mDischargeScreenOffUnplugLevel = this.mDischargeCurrentLevel;
    }

    public void updateKernelWakelocksLocked() {
        Map<String, KernelWakelockStats> readKernelWakelockStats = readKernelWakelockStats();
        if (readKernelWakelockStats == null) {
            Slog.w(TAG, "Couldn't get kernel wake lock stats");
            return;
        }
        for (Map.Entry<String, KernelWakelockStats> entry : readKernelWakelockStats.entrySet()) {
            String key = entry.getKey();
            KernelWakelockStats value = entry.getValue();
            SamplingTimer samplingTimer = this.mKernelWakelockStats.get(key);
            SamplingTimer samplingTimer2 = samplingTimer;
            if (samplingTimer == null) {
                samplingTimer2 = new SamplingTimer(this.mOnBatteryScreenOffTimeBase, true);
                this.mKernelWakelockStats.put(key, samplingTimer2);
            }
            samplingTimer2.updateCurrentReportedCount(value.mCount);
            samplingTimer2.updateCurrentReportedTotalTime(value.mTotalTime);
            samplingTimer2.setUpdateVersion(getKernelWakelockUpdateVersion());
        }
        if (readKernelWakelockStats.size() != this.mKernelWakelockStats.size()) {
            for (Map.Entry<String, SamplingTimer> entry2 : this.mKernelWakelockStats.entrySet()) {
                SamplingTimer value2 = entry2.getValue();
                if (value2.getUpdateVersion() != getKernelWakelockUpdateVersion()) {
                    value2.setStale();
                }
            }
        }
    }

    public void updateTimeBasesLocked(boolean z, boolean z2, long j, long j2) {
        if (this.mOnBatteryTimeBase.setRunning(z, j, j2)) {
            if (z) {
                this.mBluetoothPingStart = getCurrentBluetoothPingCount();
                this.mBluetoothPingCount = 0;
            } else {
                this.mBluetoothPingCount = getBluetoothPingCount();
                this.mBluetoothPingStart = -1;
            }
        }
        boolean z3 = z && z2;
        if (z3 != this.mOnBatteryScreenOffTimeBase.isRunning()) {
            updateKernelWakelocksLocked();
            requestWakelockCpuUpdate();
            if (!z3) {
                this.mDistributeWakelockCpu = true;
            }
            this.mOnBatteryScreenOffTimeBase.setRunning(z3, j, j2);
        }
    }

    public void writeAsyncLocked() {
        writeLocked(false);
    }

    void writeHistory(Parcel parcel, boolean z, boolean z2) {
        parcel.writeLong(this.mHistoryBaseTime + this.mLastHistoryElapsedRealtime);
        if (!z) {
            parcel.writeInt(0);
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.mHistoryTagPool.size());
        for (Map.Entry<BatteryStats.HistoryTag, Integer> entry : this.mHistoryTagPool.entrySet()) {
            BatteryStats.HistoryTag key = entry.getKey();
            parcel.writeInt(entry.getValue().intValue());
            parcel.writeString(key.string);
            parcel.writeInt(key.uid);
        }
        parcel.writeInt(this.mHistoryBuffer.dataSize());
        parcel.appendFrom(this.mHistoryBuffer, 0, this.mHistoryBuffer.dataSize());
        if (z2) {
            writeOldHistory(parcel);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
        if (r7.wakeReasonTag != null) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeHistoryDelta(android.os.Parcel r6, android.os.BatteryStats.HistoryItem r7, android.os.BatteryStats.HistoryItem r8) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.BatteryStatsImpl.writeHistoryDelta(android.os.Parcel, android.os.BatteryStats$HistoryItem, android.os.BatteryStats$HistoryItem):void");
    }

    void writeLocked(boolean z) {
        if (this.mFile == null) {
            Slog.w("BatteryStats", "writeLocked: no file associated with this instance");
        } else if (this.mShuttingDown) {
        } else {
            Parcel obtain = Parcel.obtain();
            writeSummaryToParcel(obtain, true);
            this.mLastWriteTime = SystemClock.elapsedRealtime();
            if (this.mPendingWrite != null) {
                this.mPendingWrite.recycle();
            }
            this.mPendingWrite = obtain;
            if (z) {
                commitPendingDataToDisk();
            } else {
                BackgroundThread.getHandler().post(new Runnable() { // from class: com.android.internal.os.BatteryStatsImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BatteryStatsImpl.this.commitPendingDataToDisk();
                    }
                });
            }
        }
    }

    void writeOldHistory(Parcel parcel) {
    }

    public void writeSummaryToParcel(Parcel parcel, boolean z) {
        pullPendingStateUpdatesLocked();
        long startClockTime = getStartClockTime();
        long uptimeMillis = SystemClock.uptimeMillis() * 1000;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        parcel.writeInt(116);
        writeHistory(parcel, z, true);
        parcel.writeInt(this.mStartCount);
        parcel.writeLong(computeUptime(uptimeMillis, 0));
        parcel.writeLong(computeRealtime(elapsedRealtime, 0));
        parcel.writeLong(startClockTime);
        parcel.writeString(this.mStartPlatformVersion);
        parcel.writeString(this.mEndPlatformVersion);
        this.mOnBatteryTimeBase.writeSummaryToParcel(parcel, uptimeMillis, elapsedRealtime);
        this.mOnBatteryScreenOffTimeBase.writeSummaryToParcel(parcel, uptimeMillis, elapsedRealtime);
        parcel.writeInt(this.mDischargeUnplugLevel);
        parcel.writeInt(this.mDischargePlugLevel);
        parcel.writeInt(this.mDischargeCurrentLevel);
        parcel.writeInt(this.mCurrentBatteryLevel);
        parcel.writeInt(getLowDischargeAmountSinceCharge());
        parcel.writeInt(getHighDischargeAmountSinceCharge());
        parcel.writeInt(getDischargeAmountScreenOnSinceCharge());
        parcel.writeInt(getDischargeAmountScreenOffSinceCharge());
        parcel.writeInt(this.mNumDischargeStepDurations);
        parcel.writeLongArray(this.mDischargeStepDurations);
        parcel.writeInt(this.mNumChargeStepDurations);
        parcel.writeLongArray(this.mChargeStepDurations);
        this.mScreenOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            this.mScreenBrightnessTimer[i2].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i = i2 + 1;
        }
        this.mInteractiveTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        this.mLowPowerModeEnabledTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        this.mPhoneOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                break;
            }
            this.mPhoneSignalStrengthsTimer[i4].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i3 = i4 + 1;
        }
        this.mPhoneSignalScanningTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 17) {
                break;
            }
            this.mPhoneDataConnectionsTimer[i6].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 4) {
                break;
            }
            this.mNetworkByteActivityCounters[i8].writeSummaryFromParcelLocked(parcel);
            this.mNetworkPacketActivityCounters[i8].writeSummaryFromParcelLocked(parcel);
            i7 = i8 + 1;
        }
        this.mMobileRadioActiveTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        this.mMobileRadioActivePerAppTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        this.mMobileRadioActiveAdjustedTime.writeSummaryFromParcelLocked(parcel);
        this.mMobileRadioActiveUnknownTime.writeSummaryFromParcelLocked(parcel);
        this.mMobileRadioActiveUnknownCount.writeSummaryFromParcelLocked(parcel);
        this.mWifiOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        this.mGlobalWifiRunningTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 8) {
                break;
            }
            this.mWifiStateTimer[i10].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i9 = i10 + 1;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= 13) {
                break;
            }
            this.mWifiSupplStateTimer[i12].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i11 = i12 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= 5) {
                break;
            }
            this.mWifiSignalStrengthsTimer[i14].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i13 = i14 + 1;
        }
        this.mBluetoothOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= 4) {
                break;
            }
            this.mBluetoothStateTimer[i16].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            i15 = i16 + 1;
        }
        parcel.writeInt(this.mNumConnectivityChange);
        this.mFlashlightOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
        parcel.writeInt(this.mKernelWakelockStats.size());
        for (Map.Entry<String, SamplingTimer> entry : this.mKernelWakelockStats.entrySet()) {
            SamplingTimer value = entry.getValue();
            if (value != null) {
                parcel.writeInt(1);
                parcel.writeString(entry.getKey());
                value.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
        }
        parcel.writeInt(this.mWakeupReasonStats.size());
        for (Map.Entry<String, SamplingTimer> entry2 : this.mWakeupReasonStats.entrySet()) {
            SamplingTimer value2 = entry2.getValue();
            if (value2 != null) {
                parcel.writeInt(1);
                parcel.writeString(entry2.getKey());
                value2.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
        }
        parcel.writeInt(getCpuSpeedSteps());
        int size = this.mUidStats.size();
        parcel.writeInt(size);
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= size) {
                return;
            }
            parcel.writeInt(this.mUidStats.keyAt(i18));
            Uid valueAt = this.mUidStats.valueAt(i18);
            if (valueAt.mWifiRunningTimer != null) {
                parcel.writeInt(1);
                valueAt.mWifiRunningTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mFullWifiLockTimer != null) {
                parcel.writeInt(1);
                valueAt.mFullWifiLockTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mWifiScanTimer != null) {
                parcel.writeInt(1);
                valueAt.mWifiScanTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            int i19 = 0;
            while (true) {
                int i20 = i19;
                if (i20 >= 5) {
                    break;
                }
                if (valueAt.mWifiBatchedScanTimer[i20] != null) {
                    parcel.writeInt(1);
                    valueAt.mWifiBatchedScanTimer[i20].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
                i19 = i20 + 1;
            }
            if (valueAt.mWifiMulticastTimer != null) {
                parcel.writeInt(1);
                valueAt.mWifiMulticastTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mAudioTurnedOnTimer != null) {
                parcel.writeInt(1);
                valueAt.mAudioTurnedOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mVideoTurnedOnTimer != null) {
                parcel.writeInt(1);
                valueAt.mVideoTurnedOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mForegroundActivityTimer != null) {
                parcel.writeInt(1);
                valueAt.mForegroundActivityTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            int i21 = 0;
            while (true) {
                int i22 = i21;
                if (i22 >= 3) {
                    break;
                }
                if (valueAt.mProcessStateTimer[i22] != null) {
                    parcel.writeInt(1);
                    valueAt.mProcessStateTimer[i22].writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
                i21 = i22 + 1;
            }
            if (valueAt.mVibratorOnTimer != null) {
                parcel.writeInt(1);
                valueAt.mVibratorOnTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mUserActivityCounters != null) {
                parcel.writeInt(1);
                int i23 = 0;
                while (true) {
                    int i24 = i23;
                    if (i24 >= 3) {
                        break;
                    }
                    valueAt.mUserActivityCounters[i24].writeSummaryFromParcelLocked(parcel);
                    i23 = i24 + 1;
                }
            } else {
                parcel.writeInt(0);
            }
            if (valueAt.mNetworkByteActivityCounters == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                int i25 = 0;
                while (true) {
                    int i26 = i25;
                    if (i26 >= 4) {
                        break;
                    }
                    valueAt.mNetworkByteActivityCounters[i26].writeSummaryFromParcelLocked(parcel);
                    valueAt.mNetworkPacketActivityCounters[i26].writeSummaryFromParcelLocked(parcel);
                    i25 = i26 + 1;
                }
                valueAt.mMobileRadioActiveTime.writeSummaryFromParcelLocked(parcel);
                valueAt.mMobileRadioActiveCount.writeSummaryFromParcelLocked(parcel);
            }
            ArrayMap<String, Uid.Wakelock> map = valueAt.mWakelockStats.getMap();
            int size2 = map.size();
            parcel.writeInt(size2);
            int i27 = 0;
            while (true) {
                int i28 = i27;
                if (i28 >= size2) {
                    break;
                }
                parcel.writeString(map.keyAt(i28));
                Uid.Wakelock valueAt2 = map.valueAt(i28);
                if (valueAt2.mTimerFull != null) {
                    parcel.writeInt(1);
                    valueAt2.mTimerFull.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
                if (valueAt2.mTimerPartial != null) {
                    parcel.writeInt(1);
                    valueAt2.mTimerPartial.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
                if (valueAt2.mTimerWindow != null) {
                    parcel.writeInt(1);
                    valueAt2.mTimerWindow.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
                i27 = i28 + 1;
            }
            ArrayMap<String, StopwatchTimer> map2 = valueAt.mSyncStats.getMap();
            int size3 = map2.size();
            parcel.writeInt(size3);
            int i29 = 0;
            while (true) {
                int i30 = i29;
                if (i30 >= size3) {
                    break;
                }
                parcel.writeString(map2.keyAt(i30));
                map2.valueAt(i30).writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                i29 = i30 + 1;
            }
            ArrayMap<String, StopwatchTimer> map3 = valueAt.mJobStats.getMap();
            int size4 = map3.size();
            parcel.writeInt(size4);
            int i31 = 0;
            while (true) {
                int i32 = i31;
                if (i32 >= size4) {
                    break;
                }
                parcel.writeString(map3.keyAt(i32));
                map3.valueAt(i32).writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                i31 = i32 + 1;
            }
            int size5 = valueAt.mSensorStats.size();
            parcel.writeInt(size5);
            int i33 = 0;
            while (true) {
                int i34 = i33;
                if (i34 >= size5) {
                    break;
                }
                parcel.writeInt(valueAt.mSensorStats.keyAt(i34));
                Uid.Sensor valueAt3 = valueAt.mSensorStats.valueAt(i34);
                if (valueAt3.mTimer != null) {
                    parcel.writeInt(1);
                    valueAt3.mTimer.writeSummaryFromParcelLocked(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
                i33 = i34 + 1;
            }
            int size6 = valueAt.mProcessStats.size();
            parcel.writeInt(size6);
            int i35 = 0;
            while (true) {
                int i36 = i35;
                if (i36 >= size6) {
                    break;
                }
                parcel.writeString(valueAt.mProcessStats.keyAt(i36));
                Uid.Proc valueAt4 = valueAt.mProcessStats.valueAt(i36);
                parcel.writeLong(valueAt4.mUserTime);
                parcel.writeLong(valueAt4.mSystemTime);
                parcel.writeLong(valueAt4.mForegroundTime);
                parcel.writeInt(valueAt4.mStarts);
                parcel.writeInt(valueAt4.mNumCrashes);
                parcel.writeInt(valueAt4.mNumAnrs);
                int length = valueAt4.mSpeedBins.length;
                parcel.writeInt(length);
                int i37 = 0;
                while (true) {
                    int i38 = i37;
                    if (i38 < length) {
                        if (valueAt4.mSpeedBins[i38] != null) {
                            parcel.writeInt(1);
                            valueAt4.mSpeedBins[i38].writeSummaryFromParcelLocked(parcel);
                        } else {
                            parcel.writeInt(0);
                        }
                        i37 = i38 + 1;
                    }
                }
                valueAt4.writeExcessivePowerToParcelLocked(parcel);
                i35 = i36 + 1;
            }
            int size7 = valueAt.mPackageStats.size();
            parcel.writeInt(size7);
            if (size7 > 0) {
                for (Map.Entry<String, Uid.Pkg> entry3 : valueAt.mPackageStats.entrySet()) {
                    parcel.writeString(entry3.getKey());
                    Uid.Pkg value3 = entry3.getValue();
                    parcel.writeInt(value3.mWakeups);
                    int size8 = value3.mServiceStats.size();
                    parcel.writeInt(size8);
                    if (size8 > 0) {
                        for (Map.Entry<String, Uid.Pkg.Serv> entry4 : value3.mServiceStats.entrySet()) {
                            parcel.writeString(entry4.getKey());
                            Uid.Pkg.Serv value4 = entry4.getValue();
                            parcel.writeLong(value4.getStartTimeToNowLocked(this.mOnBatteryTimeBase.getUptime(uptimeMillis)));
                            parcel.writeInt(value4.mStarts);
                            parcel.writeInt(value4.mLaunches);
                        }
                    }
                }
            }
            i17 = i18 + 1;
        }
    }

    public void writeSyncLocked() {
        writeLocked(true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcelLocked(parcel, true, i);
    }

    void writeToParcelLocked(Parcel parcel, boolean z, int i) {
        pullPendingStateUpdatesLocked();
        long startClockTime = getStartClockTime();
        long uptimeMillis = SystemClock.uptimeMillis() * 1000;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        this.mOnBatteryTimeBase.getRealtime(elapsedRealtime);
        this.mOnBatteryScreenOffTimeBase.getRealtime(elapsedRealtime);
        parcel.writeInt(MAGIC);
        writeHistory(parcel, true, false);
        parcel.writeInt(this.mStartCount);
        parcel.writeLong(startClockTime);
        parcel.writeString(this.mStartPlatformVersion);
        parcel.writeString(this.mEndPlatformVersion);
        parcel.writeLong(this.mUptime);
        parcel.writeLong(this.mUptimeStart);
        parcel.writeLong(this.mRealtime);
        parcel.writeLong(this.mRealtimeStart);
        parcel.writeInt(this.mOnBattery ? 1 : 0);
        this.mOnBatteryTimeBase.writeToParcel(parcel, uptimeMillis, elapsedRealtime);
        this.mOnBatteryScreenOffTimeBase.writeToParcel(parcel, uptimeMillis, elapsedRealtime);
        this.mScreenOnTimer.writeToParcel(parcel, elapsedRealtime);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 5) {
                break;
            }
            this.mScreenBrightnessTimer[i3].writeToParcel(parcel, elapsedRealtime);
            i2 = i3 + 1;
        }
        this.mInteractiveTimer.writeToParcel(parcel, elapsedRealtime);
        this.mLowPowerModeEnabledTimer.writeToParcel(parcel, elapsedRealtime);
        this.mPhoneOnTimer.writeToParcel(parcel, elapsedRealtime);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 5) {
                break;
            }
            this.mPhoneSignalStrengthsTimer[i5].writeToParcel(parcel, elapsedRealtime);
            i4 = i5 + 1;
        }
        this.mPhoneSignalScanningTimer.writeToParcel(parcel, elapsedRealtime);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 17) {
                break;
            }
            this.mPhoneDataConnectionsTimer[i7].writeToParcel(parcel, elapsedRealtime);
            i6 = i7 + 1;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= 4) {
                break;
            }
            this.mNetworkByteActivityCounters[i9].writeToParcel(parcel);
            this.mNetworkPacketActivityCounters[i9].writeToParcel(parcel);
            i8 = i9 + 1;
        }
        this.mMobileRadioActiveTimer.writeToParcel(parcel, elapsedRealtime);
        this.mMobileRadioActivePerAppTimer.writeToParcel(parcel, elapsedRealtime);
        this.mMobileRadioActiveAdjustedTime.writeToParcel(parcel);
        this.mMobileRadioActiveUnknownTime.writeToParcel(parcel);
        this.mMobileRadioActiveUnknownCount.writeToParcel(parcel);
        this.mWifiOnTimer.writeToParcel(parcel, elapsedRealtime);
        this.mGlobalWifiRunningTimer.writeToParcel(parcel, elapsedRealtime);
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= 8) {
                break;
            }
            this.mWifiStateTimer[i11].writeToParcel(parcel, elapsedRealtime);
            i10 = i11 + 1;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= 13) {
                break;
            }
            this.mWifiSupplStateTimer[i13].writeToParcel(parcel, elapsedRealtime);
            i12 = i13 + 1;
        }
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= 5) {
                break;
            }
            this.mWifiSignalStrengthsTimer[i15].writeToParcel(parcel, elapsedRealtime);
            i14 = i15 + 1;
        }
        this.mBluetoothOnTimer.writeToParcel(parcel, elapsedRealtime);
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= 4) {
                break;
            }
            this.mBluetoothStateTimer[i17].writeToParcel(parcel, elapsedRealtime);
            i16 = i17 + 1;
        }
        parcel.writeInt(this.mNumConnectivityChange);
        parcel.writeInt(this.mLoadedNumConnectivityChange);
        parcel.writeInt(this.mUnpluggedNumConnectivityChange);
        this.mFlashlightOnTimer.writeToParcel(parcel, elapsedRealtime);
        parcel.writeInt(this.mDischargeUnplugLevel);
        parcel.writeInt(this.mDischargePlugLevel);
        parcel.writeInt(this.mDischargeCurrentLevel);
        parcel.writeInt(this.mCurrentBatteryLevel);
        parcel.writeInt(this.mLowDischargeAmountSinceCharge);
        parcel.writeInt(this.mHighDischargeAmountSinceCharge);
        parcel.writeInt(this.mDischargeAmountScreenOn);
        parcel.writeInt(this.mDischargeAmountScreenOnSinceCharge);
        parcel.writeInt(this.mDischargeAmountScreenOff);
        parcel.writeInt(this.mDischargeAmountScreenOffSinceCharge);
        parcel.writeInt(this.mNumDischargeStepDurations);
        parcel.writeLongArray(this.mDischargeStepDurations);
        parcel.writeInt(this.mNumChargeStepDurations);
        parcel.writeLongArray(this.mChargeStepDurations);
        parcel.writeLong(this.mLastWriteTime);
        parcel.writeInt(getBluetoothPingCount());
        if (z) {
            parcel.writeInt(this.mKernelWakelockStats.size());
            for (Map.Entry<String, SamplingTimer> entry : this.mKernelWakelockStats.entrySet()) {
                SamplingTimer value = entry.getValue();
                if (value != null) {
                    parcel.writeInt(1);
                    parcel.writeString(entry.getKey());
                    value.writeToParcel(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
            }
            parcel.writeInt(this.mWakeupReasonStats.size());
            for (Map.Entry<String, SamplingTimer> entry2 : this.mWakeupReasonStats.entrySet()) {
                SamplingTimer value2 = entry2.getValue();
                if (value2 != null) {
                    parcel.writeInt(1);
                    parcel.writeString(entry2.getKey());
                    value2.writeToParcel(parcel, elapsedRealtime);
                } else {
                    parcel.writeInt(0);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(getCpuSpeedSteps());
        if (!z) {
            parcel.writeInt(0);
            return;
        }
        int size = this.mUidStats.size();
        parcel.writeInt(size);
        int i18 = 0;
        while (true) {
            int i19 = i18;
            if (i19 >= size) {
                return;
            }
            parcel.writeInt(this.mUidStats.keyAt(i19));
            this.mUidStats.valueAt(i19).writeToParcelLocked(parcel, elapsedRealtime);
            i18 = i19 + 1;
        }
    }

    public void writeToParcelWithoutUids(Parcel parcel, int i) {
        writeToParcelLocked(parcel, false, i);
    }
}
