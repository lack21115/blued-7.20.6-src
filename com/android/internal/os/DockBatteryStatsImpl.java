package com.android.internal.os;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/DockBatteryStatsImpl.class */
public final class DockBatteryStatsImpl extends BatteryStatsImpl {
    private static int sNumSpeedSteps;
    private static int sKernelWakelockUpdateVersion = 0;
    public static final Parcelable.Creator<DockBatteryStatsImpl> CREATOR = new Parcelable.Creator<DockBatteryStatsImpl>() { // from class: com.android.internal.os.DockBatteryStatsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DockBatteryStatsImpl createFromParcel(Parcel parcel) {
            return new DockBatteryStatsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DockBatteryStatsImpl[] newArray(int i) {
            return new DockBatteryStatsImpl[i];
        }
    };

    public DockBatteryStatsImpl() {
    }

    public DockBatteryStatsImpl(Parcel parcel) {
        super(parcel);
    }

    public DockBatteryStatsImpl(File file, Handler handler) {
        super(file, handler);
    }

    @Override // com.android.internal.os.BatteryStatsImpl, android.os.BatteryStats
    public int getCpuSpeedSteps() {
        return sNumSpeedSteps;
    }

    @Override // com.android.internal.os.BatteryStatsImpl
    protected int getKernelWakelockUpdateVersion() {
        return sKernelWakelockUpdateVersion;
    }

    @Override // com.android.internal.os.BatteryStatsImpl
    protected String getLogName() {
        return "DockBatteryStats";
    }

    @Override // com.android.internal.os.BatteryStatsImpl
    protected String getStatsName() {
        return "dockbatterystats";
    }

    @Override // com.android.internal.os.BatteryStatsImpl
    protected void setCpuSpeedSteps(int i) {
        sNumSpeedSteps = i;
    }

    @Override // com.android.internal.os.BatteryStatsImpl
    protected void setKernelWakelockUpdateVersion(int i) {
        sKernelWakelockUpdateVersion = i;
    }
}
