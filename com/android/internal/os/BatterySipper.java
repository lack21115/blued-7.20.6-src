package com.android.internal.os;

import android.os.BatteryStats;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatterySipper.class */
public class BatterySipper implements Comparable<BatterySipper> {
    public long cpuFgTime;
    public long cpuTime;
    public DrainType drainType;
    public long gpsTime;
    public String[] mPackages;
    public long mobileActive;
    public int mobileActiveCount;
    public long mobileRxBytes;
    public long mobileRxPackets;
    public long mobileTxBytes;
    public long mobileTxPackets;
    public double mobilemspp;
    public double noCoveragePercent;
    public String packageWithHighestDrain;
    public double percent;
    public BatteryStats.Uid uidObj;
    public long usageTime;
    public int userId;
    public double value;
    public double[] values;
    public long wakeLockTime;
    public long wifiRunningTime;
    public long wifiRxBytes;
    public long wifiRxPackets;
    public long wifiTxBytes;
    public long wifiTxPackets;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BatterySipper$DrainType.class */
    public enum DrainType {
        IDLE,
        CELL,
        PHONE,
        WIFI,
        BLUETOOTH,
        FLASHLIGHT,
        SCREEN,
        APP,
        USER,
        UNACCOUNTED,
        OVERCOUNTED
    }

    public BatterySipper(DrainType drainType, BatteryStats.Uid uid, double[] dArr) {
        this.values = dArr;
        if (dArr != null) {
            this.value = dArr[0];
        }
        this.drainType = drainType;
        this.uidObj = uid;
    }

    @Override // java.lang.Comparable
    public int compareTo(BatterySipper batterySipper) {
        if (this.drainType != batterySipper.drainType) {
            if (this.drainType == DrainType.OVERCOUNTED) {
                return 1;
            }
            if (batterySipper.drainType == DrainType.OVERCOUNTED) {
                return -1;
            }
        }
        return Double.compare(batterySipper.value, this.value);
    }

    public void computeMobilemspp() {
        long j = this.mobileRxPackets + this.mobileTxPackets;
        this.mobilemspp = j > 0 ? this.mobileActive / j : 0.0d;
    }

    public String[] getPackages() {
        return this.mPackages;
    }

    public int getUid() {
        if (this.uidObj == null) {
            return 0;
        }
        return this.uidObj.getUid();
    }

    public double[] getValues() {
        return this.values;
    }
}
