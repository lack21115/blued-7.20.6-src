package com.android.internal.os;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.BatteryStats;
import android.os.Bundle;
import android.os.MemoryFile;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.app.IBatteryStats;
import com.android.internal.os.BatterySipper;
import com.android.internal.telephony.PhoneConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatteryStatsHelper.class */
public final class BatteryStatsHelper {
    private static final boolean DEBUG = false;
    private static Intent sBatteryBroadcastXfer;
    private static BatteryStats sDockStatsXfer;
    private static BatteryStats sStatsXfer;
    private long mAppMobileActive;
    private long mAppWifiRunning;
    private Intent mBatteryBroadcast;
    private IBatteryStats mBatteryInfo;
    long mBatteryRealtime;
    private final BatteryManager mBatteryService;
    long mBatteryTimeRemaining;
    long mBatteryUptime;
    private double mBluetoothPower;
    private final List<BatterySipper> mBluetoothSippers;
    long mChargeTimeRemaining;
    private final boolean mCollectBatteryBroadcast;
    private double mComputedPower;
    private final Context mContext;
    private BatteryStats mDockStats;
    private double mMaxDrainedPower;
    private double mMaxPower;
    private double mMaxRealPower;
    private double mMinDrainedPower;
    private final List<BatterySipper> mMobilemsppList;
    private PowerProfile mPowerProfile;
    long mRawRealtime;
    long mRawUptime;
    private BatteryStats mStats;
    private long mStatsPeriod;
    private int mStatsType;
    private double mTotalPower;
    long mTypeBatteryRealtime;
    long mTypeBatteryUptime;
    private final List<BatterySipper> mUsageList;
    private final SparseArray<Double> mUserPower;
    private final SparseArray<List<BatterySipper>> mUserSippers;
    private final boolean mWifiOnly;
    private double mWifiPower;
    private final List<BatterySipper> mWifiSippers;
    private static final String TAG = BatteryStatsHelper.class.getSimpleName();
    private static ArrayMap<File, BatteryStats> sFileXfer = new ArrayMap<>();

    public BatteryStatsHelper(Context context) {
        this(context, true);
    }

    public BatteryStatsHelper(Context context, boolean z) {
        this.mUsageList = new ArrayList();
        this.mWifiSippers = new ArrayList();
        this.mBluetoothSippers = new ArrayList();
        this.mUserSippers = new SparseArray<>();
        this.mUserPower = new SparseArray<>();
        this.mMobilemsppList = new ArrayList();
        this.mStatsType = 0;
        this.mStatsPeriod = 0L;
        this.mMaxPower = 1.0d;
        this.mMaxRealPower = 1.0d;
        this.mContext = context;
        this.mBatteryService = (BatteryManager) context.getSystemService("batterymanager");
        this.mCollectBatteryBroadcast = z;
        this.mWifiOnly = checkWifiOnly(context);
    }

    public BatteryStatsHelper(Context context, boolean z, boolean z2) {
        this.mUsageList = new ArrayList();
        this.mWifiSippers = new ArrayList();
        this.mBluetoothSippers = new ArrayList();
        this.mUserSippers = new SparseArray<>();
        this.mUserPower = new SparseArray<>();
        this.mMobilemsppList = new ArrayList();
        this.mStatsType = 0;
        this.mStatsPeriod = 0L;
        this.mMaxPower = 1.0d;
        this.mMaxRealPower = 1.0d;
        this.mContext = context;
        this.mBatteryService = (BatteryManager) context.getSystemService("batterymanager");
        this.mCollectBatteryBroadcast = z;
        this.mWifiOnly = z2;
    }

    private void addBluetoothUsage() {
        long bluetoothOnTime = this.mStats.getBluetoothOnTime(this.mRawRealtime, this.mStatsType) / 1000;
        double averagePower = ((bluetoothOnTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_BLUETOOTH_ON)) / 3600000.0d) + ((this.mStats.getBluetoothPingCount() * this.mPowerProfile.getAveragePower(PowerProfile.POWER_BLUETOOTH_AT_CMD)) / 3600000.0d);
        if (this.mBluetoothPower + averagePower != 0.0d) {
            aggregateSippers(addEntry(BatterySipper.DrainType.BLUETOOTH, bluetoothOnTime, this.mBluetoothPower + averagePower), this.mBluetoothSippers, "Bluetooth");
        }
    }

    private BatterySipper addEntry(BatterySipper.DrainType drainType, long j, double d) {
        this.mComputedPower += d;
        if (d > this.mMaxRealPower) {
            this.mMaxRealPower = d;
        }
        return addEntryNoTotal(drainType, j, d);
    }

    private BatterySipper addEntryNoTotal(BatterySipper.DrainType drainType, long j, double d) {
        if (d > this.mMaxPower) {
            this.mMaxPower = d;
        }
        BatterySipper batterySipper = new BatterySipper(drainType, null, new double[]{d});
        batterySipper.usageTime = j;
        this.mUsageList.add(batterySipper);
        return batterySipper;
    }

    private void addFlashlightUsage() {
        long flashlightOnTime = this.mStats.getFlashlightOnTime(this.mRawRealtime, this.mStatsType) / 1000;
        double averagePower = (flashlightOnTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_FLASHLIGHT)) / 3600000.0d;
        if (averagePower != 0.0d) {
            addEntry(BatterySipper.DrainType.FLASHLIGHT, flashlightOnTime, averagePower);
        }
    }

    private void addIdleUsage() {
        long screenOnTime = (this.mTypeBatteryRealtime - this.mStats.getScreenOnTime(this.mRawRealtime, this.mStatsType)) / 1000;
        double averagePower = (screenOnTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_CPU_IDLE)) / 3600000.0d;
        if (averagePower != 0.0d) {
            addEntry(BatterySipper.DrainType.IDLE, screenOnTime, averagePower);
        }
    }

    private void addPhoneUsage() {
        long phoneOnTime = this.mStats.getPhoneOnTime(this.mRawRealtime, this.mStatsType) / 1000;
        double averagePower = (this.mPowerProfile.getAveragePower(PowerProfile.POWER_RADIO_ACTIVE) * phoneOnTime) / 3600000.0d;
        if (averagePower != 0.0d) {
            addEntry(BatterySipper.DrainType.PHONE, phoneOnTime, averagePower);
        }
    }

    private void addRadioUsage() {
        double d = 0.0d;
        long j = 0;
        long j2 = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            long phoneSignalStrengthTime = this.mStats.getPhoneSignalStrengthTime(i2, this.mRawRealtime, this.mStatsType) / 1000;
            d += (phoneSignalStrengthTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_RADIO_ON, i2)) / 3600000.0d;
            j += phoneSignalStrengthTime;
            if (i2 == 0) {
                j2 = phoneSignalStrengthTime;
            }
            i = i2 + 1;
        }
        double phoneSignalScanningTime = d + (((this.mStats.getPhoneSignalScanningTime(this.mRawRealtime, this.mStatsType) / 1000) * this.mPowerProfile.getAveragePower(PowerProfile.POWER_RADIO_SCANNING)) / 3600000.0d);
        long mobileRadioActiveTime = (this.mStats.getMobileRadioActiveTime(this.mRawRealtime, this.mStatsType) - this.mAppMobileActive) / 1000;
        double d2 = phoneSignalScanningTime;
        if (mobileRadioActiveTime > 0) {
            d2 = phoneSignalScanningTime + (getMobilePowerPerMs() * mobileRadioActiveTime);
        }
        if (d2 != 0.0d) {
            BatterySipper addEntry = addEntry(BatterySipper.DrainType.CELL, j, d2);
            if (j != 0) {
                addEntry.noCoveragePercent = (j2 * 100.0d) / j;
            }
            addEntry.mobileActive = mobileRadioActiveTime;
            addEntry.mobileActiveCount = this.mStats.getMobileRadioActiveUnknownCount(this.mStatsType);
        }
    }

    private void addScreenUsage() {
        long screenOnTime = this.mStats.getScreenOnTime(this.mRawRealtime, this.mStatsType) / 1000;
        double averagePower = 0.0d + (screenOnTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_SCREEN_ON));
        double averagePower2 = this.mPowerProfile.getAveragePower(PowerProfile.POWER_SCREEN_FULL);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            averagePower += (((i2 + 0.5f) * averagePower2) / 5.0d) * (this.mStats.getScreenBrightnessTime(i2, this.mRawRealtime, this.mStatsType) / 1000);
            i = i2 + 1;
        }
        double d = averagePower / 3600000.0d;
        if (d != 0.0d) {
            addEntry(BatterySipper.DrainType.SCREEN, screenOnTime, d);
        }
    }

    private void addUserUsage() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mUserSippers.size()) {
                return;
            }
            int keyAt = this.mUserSippers.keyAt(i2);
            List<BatterySipper> valueAt = this.mUserSippers.valueAt(i2);
            Double d = this.mUserPower.get(keyAt);
            BatterySipper addEntry = addEntry(BatterySipper.DrainType.USER, 0L, d != null ? d.doubleValue() : 0.0d);
            addEntry.userId = keyAt;
            aggregateSippers(addEntry, valueAt, "User");
            i = i2 + 1;
        }
    }

    private void addWiFiUsage() {
        long wifiOnTime = this.mStats.getWifiOnTime(this.mRawRealtime, this.mStatsType) / 1000;
        long globalWifiRunningTime = (this.mStats.getGlobalWifiRunningTime(this.mRawRealtime, this.mStatsType) / 1000) - this.mAppWifiRunning;
        long j = globalWifiRunningTime;
        if (globalWifiRunningTime < 0) {
            j = 0;
        }
        double averagePower = (((0 * wifiOnTime) * this.mPowerProfile.getAveragePower(PowerProfile.POWER_WIFI_ON)) + (j * this.mPowerProfile.getAveragePower(PowerProfile.POWER_WIFI_ON))) / 3600000.0d;
        if (this.mWifiPower + averagePower != 0.0d) {
            aggregateSippers(addEntry(BatterySipper.DrainType.WIFI, j, this.mWifiPower + averagePower), this.mWifiSippers, "WIFI");
        }
    }

    private void aggregateSippers(BatterySipper batterySipper, List<BatterySipper> list, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                batterySipper.computeMobilemspp();
                return;
            }
            BatterySipper batterySipper2 = list.get(i2);
            batterySipper.cpuTime += batterySipper2.cpuTime;
            batterySipper.gpsTime += batterySipper2.gpsTime;
            batterySipper.wifiRunningTime += batterySipper2.wifiRunningTime;
            batterySipper.cpuFgTime += batterySipper2.cpuFgTime;
            batterySipper.wakeLockTime += batterySipper2.wakeLockTime;
            batterySipper.mobileRxPackets += batterySipper2.mobileRxPackets;
            batterySipper.mobileTxPackets += batterySipper2.mobileTxPackets;
            batterySipper.mobileActive += batterySipper2.mobileActive;
            batterySipper.mobileActiveCount += batterySipper2.mobileActiveCount;
            batterySipper.wifiRxPackets += batterySipper2.wifiRxPackets;
            batterySipper.wifiTxPackets += batterySipper2.wifiTxPackets;
            batterySipper.mobileRxBytes += batterySipper2.mobileRxBytes;
            batterySipper.mobileTxBytes += batterySipper2.mobileTxBytes;
            batterySipper.wifiRxBytes += batterySipper2.wifiRxBytes;
            batterySipper.wifiTxBytes += batterySipper2.wifiTxBytes;
            i = i2 + 1;
        }
    }

    public static boolean checkWifiOnly(Context context) {
        boolean z = false;
        if (!((ConnectivityManager) context.getSystemService("connectivity")).isNetworkSupported(0)) {
            z = true;
        }
        return z;
    }

    private void clearAllStats() {
        clearStats();
        sStatsXfer = null;
        sDockStatsXfer = null;
        sBatteryBroadcastXfer = null;
        for (File file : sFileXfer.keySet()) {
            file.delete();
        }
        sFileXfer.clear();
    }

    public static void dropFile(Context context, String str) {
        makeFilePath(context, str).delete();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x005a -> B:10:0x0051). Please submit an issue!!! */
    private static BatteryStatsImpl getDockStats(IBatteryStats iBatteryStats) {
        try {
            ParcelFileDescriptor dockStatisticsStream = iBatteryStats.getDockStatisticsStream();
            if (dockStatisticsStream != null) {
                try {
                    byte[] readFully = readFully(new ParcelFileDescriptor.AutoCloseInputStream(dockStatisticsStream), MemoryFile.getSize(dockStatisticsStream.getFileDescriptor()));
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(readFully, 0, readFully.length);
                    obtain.setDataPosition(0);
                    DockBatteryStatsImpl createFromParcel = DockBatteryStatsImpl.CREATOR.createFromParcel(obtain);
                    createFromParcel.distributeWorkLocked(0);
                    return createFromParcel;
                } catch (IOException e) {
                    Log.w(TAG, "Unable to read statistics stream", e);
                }
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "RemoteException:", e2);
        }
        return new BatteryStatsImpl();
    }

    private double getMobilePowerPerMs() {
        return this.mPowerProfile.getAveragePower(PowerProfile.POWER_RADIO_ACTIVE) / 3600000.0d;
    }

    private double getMobilePowerPerPacket() {
        double averagePower = this.mPowerProfile.getAveragePower(PowerProfile.POWER_RADIO_ACTIVE) / 3600.0d;
        long networkActivityPackets = this.mStats.getNetworkActivityPackets(0, this.mStatsType) + this.mStats.getNetworkActivityPackets(1, this.mStatsType);
        long mobileRadioActiveTime = this.mStats.getMobileRadioActiveTime(this.mRawRealtime, this.mStatsType) / 1000;
        return (averagePower / ((networkActivityPackets == 0 || mobileRadioActiveTime == 0) ? 12.20703125d : networkActivityPackets / mobileRadioActiveTime)) / 3600.0d;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x005a -> B:10:0x0051). Please submit an issue!!! */
    private static BatteryStatsImpl getStats(IBatteryStats iBatteryStats) {
        try {
            ParcelFileDescriptor statisticsStream = iBatteryStats.getStatisticsStream();
            if (statisticsStream != null) {
                try {
                    byte[] readFully = readFully(new ParcelFileDescriptor.AutoCloseInputStream(statisticsStream), MemoryFile.getSize(statisticsStream.getFileDescriptor()));
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(readFully, 0, readFully.length);
                    obtain.setDataPosition(0);
                    BatteryStatsImpl createFromParcel = BatteryStatsImpl.CREATOR.createFromParcel(obtain);
                    createFromParcel.distributeWorkLocked(0);
                    return createFromParcel;
                } catch (IOException e) {
                    Log.w(TAG, "Unable to read statistics stream", e);
                }
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "RemoteException:", e2);
        }
        return new BatteryStatsImpl();
    }

    private double getWifiPowerPerPacket() {
        return ((this.mPowerProfile.getAveragePower(PowerProfile.POWER_WIFI_ACTIVE) / 3600.0d) / 61.03515625d) / 3600.0d;
    }

    private void loadDockStats() {
        if (this.mBatteryInfo == null) {
            return;
        }
        if (this.mBatteryService.isDockBatterySupported()) {
            this.mDockStats = getDockStats(this.mBatteryInfo);
        } else {
            this.mDockStats = null;
        }
    }

    private void loadStats() {
        if (this.mBatteryInfo == null) {
            return;
        }
        this.mStats = getStats(this.mBatteryInfo);
        if (this.mCollectBatteryBroadcast) {
            this.mBatteryBroadcast = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    private static File makeFilePath(Context context, String str) {
        return new File(context.getFilesDir(), str);
    }

    public static String makemAh(double d) {
        return d < 1.0E-5d ? String.format("%.8f", Double.valueOf(d)) : d < 1.0E-4d ? String.format("%.7f", Double.valueOf(d)) : d < 0.001d ? String.format("%.6f", Double.valueOf(d)) : d < 0.01d ? String.format("%.5f", Double.valueOf(d)) : d < 0.1d ? String.format("%.4f", Double.valueOf(d)) : d < 1.0d ? String.format("%.3f", Double.valueOf(d)) : d < 10.0d ? String.format("%.2f", Double.valueOf(d)) : d < 100.0d ? String.format("%.1f", Double.valueOf(d)) : String.format("%.0f", Double.valueOf(d));
    }

    private void processAppUsage(SparseArray<UserHandle> sparseArray) {
        double d;
        BatterySipper batterySipper;
        double averagePower;
        long j;
        boolean z = sparseArray.get(-1) != null;
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        int i = this.mStatsType;
        int numSpeedSteps = this.mPowerProfile.getNumSpeedSteps();
        double[] dArr = new double[numSpeedSteps];
        long[] jArr = new long[numSpeedSteps];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numSpeedSteps) {
                break;
            }
            dArr[i3] = this.mPowerProfile.getAveragePower(PowerProfile.POWER_CPU_ACTIVE, i3);
            i2 = i3 + 1;
        }
        double mobilePowerPerPacket = getMobilePowerPerPacket();
        double mobilePowerPerMs = getMobilePowerPerMs();
        double wifiPowerPerPacket = getWifiPowerPerPacket();
        long j2 = 0;
        BatterySipper batterySipper2 = null;
        this.mStatsPeriod = this.mTypeBatteryRealtime;
        SparseArray uidStats = this.mStats.getUidStats();
        int size = uidStats.size();
        int i4 = 0;
        while (i4 < size) {
            BatteryStats.Uid uid = (BatteryStats.Uid) uidStats.valueAt(i4);
            double d2 = 0.0d;
            double d3 = 0.0d;
            String str = null;
            String str2 = null;
            Map processStats = uid.getProcessStats();
            long j3 = 0;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            double d4 = 0.0d;
            if (processStats.size() > 0) {
                Iterator it = processStats.entrySet().iterator();
                while (true) {
                    j5 = j4;
                    j6 = j3;
                    str = str2;
                    d4 = d2;
                    if (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        BatteryStats.Uid.Proc proc = (BatteryStats.Uid.Proc) entry.getValue();
                        long userTime = proc.getUserTime(i);
                        long systemTime = proc.getSystemTime(i);
                        long foregroundTime = j4 + (10 * proc.getForegroundTime(i));
                        long j7 = (userTime + systemTime) * 10;
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 < numSpeedSteps) {
                                jArr[i7] = proc.getTimeAtCpuSpeedStep(i7, i);
                                i5 = (int) (i5 + jArr[i7]);
                                i6 = i7 + 1;
                            } else {
                                int i8 = i5;
                                if (i5 == 0) {
                                    i8 = 1;
                                }
                                double d5 = 0.0d;
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < numSpeedSteps) {
                                        d5 += j7 * (jArr[i10] / i8) * dArr[i10];
                                        i9 = i10 + 1;
                                    } else {
                                        long j8 = j3 + j7;
                                        double d6 = d2 + d5;
                                        if (str2 == null || str2.startsWith(PhoneConstants.APN_TYPE_ALL)) {
                                            str2 = (String) entry.getKey();
                                            j4 = foregroundTime;
                                            j3 = j8;
                                            d3 = d5;
                                            d2 = d6;
                                        } else {
                                            j4 = foregroundTime;
                                            j3 = j8;
                                            d2 = d6;
                                            if (d3 < d5) {
                                                j4 = foregroundTime;
                                                j3 = j8;
                                                d2 = d6;
                                                if (!((String) entry.getKey()).startsWith(PhoneConstants.APN_TYPE_ALL)) {
                                                    str2 = (String) entry.getKey();
                                                    j4 = foregroundTime;
                                                    j3 = j8;
                                                    d3 = d5;
                                                    d2 = d6;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            long j9 = j6;
            if (j5 > j6) {
                j9 = j5;
            }
            double d7 = d4 / 3600000.0d;
            long j10 = 0;
            for (Map.Entry entry2 : uid.getWakelockStats().entrySet()) {
                BatteryStats.Timer wakeTime = ((BatteryStats.Uid.Wakelock) entry2.getValue()).getWakeTime(0);
                if (wakeTime != null) {
                    j10 += wakeTime.getTotalTimeLocked(this.mRawRealtime, i);
                }
            }
            j2 += j10;
            long j11 = j10 / 1000;
            double averagePower2 = (j11 * this.mPowerProfile.getAveragePower(PowerProfile.POWER_CPU_AWAKE)) / 3600000.0d;
            long networkActivityPackets = uid.getNetworkActivityPackets(0, this.mStatsType);
            long networkActivityPackets2 = uid.getNetworkActivityPackets(1, this.mStatsType);
            long networkActivityBytes = uid.getNetworkActivityBytes(0, this.mStatsType);
            long networkActivityBytes2 = uid.getNetworkActivityBytes(1, this.mStatsType);
            long mobileRadioActiveTime = uid.getMobileRadioActiveTime(this.mStatsType);
            if (mobileRadioActiveTime > 0) {
                this.mAppMobileActive += mobileRadioActiveTime;
                d = (mobileRadioActiveTime * mobilePowerPerMs) / 1000.0d;
            } else {
                d = (networkActivityPackets + networkActivityPackets2) * mobilePowerPerPacket;
            }
            long networkActivityPackets3 = uid.getNetworkActivityPackets(2, this.mStatsType);
            long networkActivityPackets4 = uid.getNetworkActivityPackets(3, this.mStatsType);
            long networkActivityBytes3 = uid.getNetworkActivityBytes(2, this.mStatsType);
            long networkActivityBytes4 = uid.getNetworkActivityBytes(3, this.mStatsType);
            double d8 = networkActivityPackets3 + networkActivityPackets4;
            long wifiRunningTime = uid.getWifiRunningTime(this.mRawRealtime, i) / 1000;
            this.mAppWifiRunning += wifiRunningTime;
            double averagePower3 = d7 + averagePower2 + d + (d8 * wifiPowerPerPacket) + ((wifiRunningTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_WIFI_ON)) / 3600000.0d) + (((uid.getWifiScanTime(this.mRawRealtime, i) / 1000) * this.mPowerProfile.getAveragePower(PowerProfile.POWER_WIFI_SCAN)) / 3600000.0d);
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 < 5) {
                    averagePower3 += ((uid.getWifiBatchedScanTime(i12, this.mRawRealtime, i) / 1000) * this.mPowerProfile.getAveragePower(PowerProfile.POWER_WIFI_BATCHED_SCAN, i12)) / 3600000.0d;
                    i11 = i12 + 1;
                } else {
                    SparseArray sensorStats = uid.getSensorStats();
                    int size2 = sensorStats.size();
                    int i13 = 0;
                    double d9 = averagePower3;
                    long j12 = 0;
                    while (true) {
                        long j13 = j12;
                        if (i13 < size2) {
                            BatteryStats.Uid.Sensor sensor = (BatteryStats.Uid.Sensor) sensorStats.valueAt(i13);
                            int keyAt = sensorStats.keyAt(i13);
                            long totalTimeLocked = sensor.getSensorTime().getTotalTimeLocked(this.mRawRealtime, i) / 1000;
                            switch (keyAt) {
                                case -10000:
                                    averagePower = this.mPowerProfile.getAveragePower(PowerProfile.POWER_GPS_ON);
                                    j = totalTimeLocked;
                                    break;
                                default:
                                    Iterator<Sensor> it2 = sensorManager.getSensorList(-1).iterator();
                                    while (true) {
                                        j = j13;
                                        averagePower = 0.0d;
                                        if (it2.hasNext()) {
                                            Sensor next = it2.next();
                                            if (next.getHandle() == keyAt) {
                                                averagePower = next.getPower();
                                                j = j13;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                            }
                            d9 += (totalTimeLocked * averagePower) / 3600000.0d;
                            i13++;
                            j12 = j;
                        } else {
                            int userId = UserHandle.getUserId(uid.getUid());
                            if (d9 == 0.0d) {
                                batterySipper = batterySipper2;
                                if (uid.getUid() != 0) {
                                    i4++;
                                    batterySipper2 = batterySipper;
                                }
                            }
                            BatterySipper batterySipper3 = new BatterySipper(BatterySipper.DrainType.APP, uid, new double[]{d9});
                            batterySipper3.cpuTime = j9;
                            batterySipper3.gpsTime = j13;
                            batterySipper3.wifiRunningTime = wifiRunningTime;
                            batterySipper3.cpuFgTime = j5;
                            batterySipper3.wakeLockTime = j11;
                            batterySipper3.mobileRxPackets = networkActivityPackets;
                            batterySipper3.mobileTxPackets = networkActivityPackets2;
                            batterySipper3.mobileActive = mobileRadioActiveTime / 1000;
                            batterySipper3.mobileActiveCount = uid.getMobileRadioActiveCount(this.mStatsType);
                            batterySipper3.wifiRxPackets = networkActivityPackets3;
                            batterySipper3.wifiTxPackets = networkActivityPackets4;
                            batterySipper3.mobileRxBytes = networkActivityBytes;
                            batterySipper3.mobileTxBytes = networkActivityBytes2;
                            batterySipper3.wifiRxBytes = networkActivityBytes3;
                            batterySipper3.wifiTxBytes = networkActivityBytes4;
                            batterySipper3.packageWithHighestDrain = str;
                            if (uid.getUid() == 1010) {
                                this.mWifiSippers.add(batterySipper3);
                                this.mWifiPower += d9;
                            } else if (uid.getUid() == 1002) {
                                this.mBluetoothSippers.add(batterySipper3);
                                this.mBluetoothPower += d9;
                            } else if (z || sparseArray.get(userId) != null || UserHandle.getAppId(uid.getUid()) < 10000) {
                                this.mUsageList.add(batterySipper3);
                                if (d9 > this.mMaxPower) {
                                    this.mMaxPower = d9;
                                }
                                if (d9 > this.mMaxRealPower) {
                                    this.mMaxRealPower = d9;
                                }
                                this.mComputedPower += d9;
                            } else {
                                List<BatterySipper> list = this.mUserSippers.get(userId);
                                ArrayList arrayList = list;
                                if (list == null) {
                                    arrayList = new ArrayList();
                                    this.mUserSippers.put(userId, arrayList);
                                }
                                arrayList.add(batterySipper3);
                                if (d9 != 0.0d) {
                                    Double d10 = this.mUserPower.get(userId);
                                    this.mUserPower.put(userId, d10 == null ? Double.valueOf(d9) : Double.valueOf(d10.doubleValue() + d9));
                                }
                            }
                            batterySipper = batterySipper2;
                            if (uid.getUid() == 0) {
                                batterySipper = batterySipper3;
                            }
                            i4++;
                            batterySipper2 = batterySipper;
                        }
                    }
                }
            }
        }
        if (batterySipper2 != null) {
            long screenOnTime = (this.mBatteryUptime / 1000) - ((j2 / 1000) + (this.mStats.getScreenOnTime(this.mRawRealtime, i) / 1000));
            if (screenOnTime > 0) {
                double averagePower4 = (screenOnTime * this.mPowerProfile.getAveragePower(PowerProfile.POWER_CPU_AWAKE)) / 3600000.0d;
                batterySipper2.wakeLockTime += screenOnTime;
                batterySipper2.value += averagePower4;
                double[] dArr2 = batterySipper2.values;
                dArr2[0] = dArr2[0] + averagePower4;
                if (batterySipper2.value > this.mMaxPower) {
                    this.mMaxPower = batterySipper2.value;
                }
                if (batterySipper2.value > this.mMaxRealPower) {
                    this.mMaxRealPower = batterySipper2.value;
                }
                this.mComputedPower += averagePower4;
            }
        }
    }

    private void processMiscUsage() {
        addUserUsage();
        addPhoneUsage();
        addScreenUsage();
        addFlashlightUsage();
        addWiFiUsage();
        addBluetoothUsage();
        addIdleUsage();
        if (this.mWifiOnly) {
            return;
        }
        addRadioUsage();
    }

    public static byte[] readFully(FileInputStream fileInputStream) throws IOException {
        return readFully(fileInputStream, fileInputStream.available());
    }

    public static byte[] readFully(FileInputStream fileInputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int read = fileInputStream.read(bArr, i2, bArr.length - i2);
            if (read <= 0) {
                return bArr;
            }
            int i3 = i2 + read;
            int available = fileInputStream.available();
            i2 = i3;
            if (available > bArr.length - i3) {
                byte[] bArr2 = new byte[i3 + available];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                bArr = bArr2;
                i2 = i3;
            }
        }
    }

    public static BatteryStats statsFromFile(Context context, String str) {
        FileInputStream fileInputStream;
        IOException e;
        synchronized (sFileXfer) {
            File makeFilePath = makeFilePath(context, str);
            BatteryStats batteryStats = sFileXfer.get(makeFilePath);
            if (batteryStats != null) {
                return batteryStats;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(makeFilePath);
                    try {
                        byte[] readFully = readFully(fileInputStream);
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(readFully, 0, readFully.length);
                        obtain.setDataPosition(0);
                        BatteryStatsImpl createFromParcel = BatteryStatsImpl.CREATOR.createFromParcel(obtain);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        return createFromParcel;
                    } catch (IOException e3) {
                        e = e3;
                        Log.w(TAG, "Unable to read history to file", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        return getStats(IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats")));
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    fileInputStream = null;
                    e = e6;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void clearStats() {
        this.mStats = null;
        this.mDockStats = null;
    }

    public void create(BatteryStats batteryStats) {
        this.mPowerProfile = new PowerProfile(this.mContext);
        this.mStats = batteryStats;
    }

    public void create(Bundle bundle) {
        if (bundle != null) {
            this.mStats = sStatsXfer;
            this.mDockStats = sDockStatsXfer;
            this.mBatteryBroadcast = sBatteryBroadcastXfer;
        }
        this.mBatteryInfo = IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
        this.mPowerProfile = new PowerProfile(this.mContext);
    }

    public Intent getBatteryBroadcast() {
        if (this.mBatteryBroadcast == null && this.mCollectBatteryBroadcast) {
            loadStats();
            loadDockStats();
        }
        return this.mBatteryBroadcast;
    }

    public long getBatteryTimeRemaining() {
        return this.mBatteryTimeRemaining;
    }

    public long getChargeTimeRemaining() {
        return this.mChargeTimeRemaining;
    }

    public double getComputedPower() {
        return this.mComputedPower;
    }

    public BatteryStats getDockStats() {
        if (this.mDockStats == null) {
            loadDockStats();
        }
        return this.mDockStats;
    }

    public double getMaxDrainedPower() {
        return this.mMaxDrainedPower;
    }

    public double getMaxPower() {
        return this.mMaxPower;
    }

    public double getMaxRealPower() {
        return this.mMaxRealPower;
    }

    public double getMinDrainedPower() {
        return this.mMinDrainedPower;
    }

    public List<BatterySipper> getMobilemsppList() {
        return this.mMobilemsppList;
    }

    public PowerProfile getPowerProfile() {
        return this.mPowerProfile;
    }

    public BatteryStats getStats() {
        if (this.mStats == null) {
            loadStats();
        }
        return this.mStats;
    }

    public long getStatsPeriod() {
        return this.mStatsPeriod;
    }

    public int getStatsType() {
        return this.mStatsType;
    }

    public double getTotalPower() {
        return this.mTotalPower;
    }

    public List<BatterySipper> getUsageList() {
        return this.mUsageList;
    }

    public void internalStoreStatsHistoryInFile(BatteryStats batteryStats, String str) {
        FileOutputStream fileOutputStream;
        synchronized (sFileXfer) {
            File makeFilePath = makeFilePath(this.mContext, str);
            sFileXfer.put(makeFilePath, batteryStats);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(makeFilePath);
                    try {
                        Parcel obtain = Parcel.obtain();
                        batteryStats.writeToParcelWithoutUids(obtain, 0);
                        fileOutputStream3.write(obtain.marshall());
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                        fileOutputStream = fileOutputStream3;
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        Log.w(TAG, "Unable to write history to file", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = null;
            }
        }
    }

    public void refreshStats(int i, int i2) {
        SparseArray<UserHandle> sparseArray = new SparseArray<>(1);
        sparseArray.put(i2, new UserHandle(i2));
        refreshStats(i, sparseArray);
    }

    public void refreshStats(int i, SparseArray<UserHandle> sparseArray) {
        refreshStats(i, sparseArray, SystemClock.elapsedRealtime() * 1000, SystemClock.uptimeMillis() * 1000);
    }

    public void refreshStats(int i, SparseArray<UserHandle> sparseArray, long j, long j2) {
        getStats();
        getDockStats();
        this.mMaxPower = 0.0d;
        this.mMaxRealPower = 0.0d;
        this.mComputedPower = 0.0d;
        this.mTotalPower = 0.0d;
        this.mWifiPower = 0.0d;
        this.mBluetoothPower = 0.0d;
        this.mAppMobileActive = 0L;
        this.mAppWifiRunning = 0L;
        this.mUsageList.clear();
        this.mWifiSippers.clear();
        this.mBluetoothSippers.clear();
        this.mUserSippers.clear();
        this.mUserPower.clear();
        this.mMobilemsppList.clear();
        if (this.mStats == null) {
            return;
        }
        this.mStatsType = i;
        this.mRawUptime = j2;
        this.mRawRealtime = j;
        this.mBatteryUptime = this.mStats.getBatteryUptime(j2);
        this.mBatteryRealtime = this.mStats.getBatteryRealtime(j);
        this.mTypeBatteryUptime = this.mStats.computeBatteryUptime(j2, this.mStatsType);
        this.mTypeBatteryRealtime = this.mStats.computeBatteryRealtime(j, this.mStatsType);
        this.mBatteryTimeRemaining = this.mStats.computeBatteryTimeRemaining(j);
        this.mChargeTimeRemaining = this.mStats.computeChargeTimeRemaining(j);
        this.mMinDrainedPower = (this.mStats.getLowDischargeAmountSinceCharge() * this.mPowerProfile.getBatteryCapacity()) / 100.0d;
        this.mMaxDrainedPower = (this.mStats.getHighDischargeAmountSinceCharge() * this.mPowerProfile.getBatteryCapacity()) / 100.0d;
        processAppUsage(sparseArray);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mUsageList.size()) {
                break;
            }
            BatterySipper batterySipper = this.mUsageList.get(i3);
            batterySipper.computeMobilemspp();
            if (batterySipper.mobilemspp != 0.0d) {
                this.mMobilemsppList.add(batterySipper);
            }
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.mUserSippers.size()) {
                break;
            }
            List<BatterySipper> valueAt = this.mUserSippers.valueAt(i5);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < valueAt.size()) {
                    BatterySipper batterySipper2 = valueAt.get(i7);
                    batterySipper2.computeMobilemspp();
                    if (batterySipper2.mobilemspp != 0.0d) {
                        this.mMobilemsppList.add(batterySipper2);
                    }
                    i6 = i7 + 1;
                }
            }
            i4 = i5 + 1;
        }
        Collections.sort(this.mMobilemsppList, new Comparator<BatterySipper>() { // from class: com.android.internal.os.BatteryStatsHelper.1
            @Override // java.util.Comparator
            public int compare(BatterySipper batterySipper3, BatterySipper batterySipper4) {
                if (batterySipper3.mobilemspp < batterySipper4.mobilemspp) {
                    return 1;
                }
                return batterySipper3.mobilemspp > batterySipper4.mobilemspp ? -1 : 0;
            }
        });
        processMiscUsage();
        this.mTotalPower = this.mComputedPower;
        if (this.mStats.getLowDischargeAmountSinceCharge() > 1) {
            if (this.mMinDrainedPower > this.mComputedPower) {
                double d = this.mMinDrainedPower;
                double d2 = this.mComputedPower;
                this.mTotalPower = this.mMinDrainedPower;
                addEntryNoTotal(BatterySipper.DrainType.UNACCOUNTED, 0L, d - d2);
            } else if (this.mMaxDrainedPower < this.mComputedPower) {
                addEntryNoTotal(BatterySipper.DrainType.OVERCOUNTED, 0L, this.mComputedPower - this.mMaxDrainedPower);
            }
        }
        Collections.sort(this.mUsageList);
    }

    public void refreshStats(int i, List<UserHandle> list) {
        int size = list.size();
        SparseArray<UserHandle> sparseArray = new SparseArray<>(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                refreshStats(i, sparseArray);
                return;
            }
            UserHandle userHandle = list.get(i3);
            sparseArray.put(userHandle.getIdentifier(), userHandle);
            i2 = i3 + 1;
        }
    }

    public void resetStatistics() {
        try {
            clearAllStats();
            this.mBatteryInfo.resetStatistics();
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException:", e);
        }
    }

    public void storeDockStatsHistoryInFile(String str) {
        internalStoreStatsHistoryInFile(getDockStats(), str);
    }

    public void storeState() {
        sStatsXfer = this.mStats;
        sDockStatsXfer = this.mDockStats;
        sBatteryBroadcastXfer = this.mBatteryBroadcast;
    }

    public void storeStatsHistoryInFile(String str) {
        internalStoreStatsHistoryInFile(getStats(), str);
    }
}
