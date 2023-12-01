package android.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/location/FusedBatchOptions.class */
public class FusedBatchOptions implements Parcelable {
    public static final Parcelable.Creator<FusedBatchOptions> CREATOR = new Parcelable.Creator<FusedBatchOptions>() { // from class: android.location.FusedBatchOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FusedBatchOptions createFromParcel(Parcel parcel) {
            FusedBatchOptions fusedBatchOptions = new FusedBatchOptions();
            fusedBatchOptions.setMaxPowerAllocationInMW(parcel.readDouble());
            fusedBatchOptions.setPeriodInNS(parcel.readLong());
            fusedBatchOptions.setSourceToUse(parcel.readInt());
            fusedBatchOptions.setFlag(parcel.readInt());
            return fusedBatchOptions;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FusedBatchOptions[] newArray(int i) {
            return new FusedBatchOptions[i];
        }
    };
    private volatile long mPeriodInNS = 0;
    private volatile int mSourcesToUse = 0;
    private volatile int mFlags = 0;
    private volatile double mMaxPowerAllocationInMW = 0.0d;

    /* loaded from: source-9557208-dex2jar.jar:android/location/FusedBatchOptions$BatchFlags.class */
    public static final class BatchFlags {
        public static int WAKEUP_ON_FIFO_FULL = 1;
        public static int CALLBACK_ON_LOCATION_FIX = 2;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/location/FusedBatchOptions$SourceTechnologies.class */
    public static final class SourceTechnologies {
        public static int GNSS = 1;
        public static int WIFI = 2;
        public static int SENSORS = 4;
        public static int CELL = 8;
        public static int BLUETOOTH = 16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public double getMaxPowerAllocationInMW() {
        return this.mMaxPowerAllocationInMW;
    }

    public long getPeriodInNS() {
        return this.mPeriodInNS;
    }

    public int getSourcesToUse() {
        return this.mSourcesToUse;
    }

    public boolean isFlagSet(int i) {
        return (this.mFlags & i) != 0;
    }

    public boolean isSourceToUseSet(int i) {
        return (this.mSourcesToUse & i) != 0;
    }

    public void resetFlag(int i) {
        this.mFlags &= i ^ (-1);
    }

    public void resetSourceToUse(int i) {
        this.mSourcesToUse &= i ^ (-1);
    }

    public void setFlag(int i) {
        this.mFlags |= i;
    }

    public void setMaxPowerAllocationInMW(double d) {
        this.mMaxPowerAllocationInMW = d;
    }

    public void setPeriodInNS(long j) {
        this.mPeriodInNS = j;
    }

    public void setSourceToUse(int i) {
        this.mSourcesToUse |= i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mMaxPowerAllocationInMW);
        parcel.writeLong(this.mPeriodInNS);
        parcel.writeInt(this.mSourcesToUse);
        parcel.writeInt(this.mFlags);
    }
}
