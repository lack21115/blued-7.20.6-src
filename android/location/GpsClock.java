package android.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/location/GpsClock.class */
public class GpsClock implements Parcelable {
    public static final Parcelable.Creator<GpsClock> CREATOR = new Parcelable.Creator<GpsClock>() { // from class: android.location.GpsClock.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsClock createFromParcel(Parcel parcel) {
            GpsClock gpsClock = new GpsClock();
            gpsClock.mFlags = (short) parcel.readInt();
            gpsClock.mLeapSecond = (short) parcel.readInt();
            gpsClock.mType = parcel.readByte();
            gpsClock.mTimeInNs = parcel.readLong();
            gpsClock.mTimeUncertaintyInNs = parcel.readDouble();
            gpsClock.mFullBiasInNs = parcel.readLong();
            gpsClock.mBiasInNs = parcel.readDouble();
            gpsClock.mBiasUncertaintyInNs = parcel.readDouble();
            gpsClock.mDriftInNsPerSec = parcel.readDouble();
            gpsClock.mDriftUncertaintyInNsPerSec = parcel.readDouble();
            return gpsClock;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsClock[] newArray(int i) {
            return new GpsClock[i];
        }
    };
    private static final short HAS_BIAS = 8;
    private static final short HAS_BIAS_UNCERTAINTY = 16;
    private static final short HAS_DRIFT = 32;
    private static final short HAS_DRIFT_UNCERTAINTY = 64;
    private static final short HAS_FULL_BIAS = 4;
    private static final short HAS_LEAP_SECOND = 1;
    private static final short HAS_NO_FLAGS = 0;
    private static final short HAS_TIME_UNCERTAINTY = 2;
    private static final String TAG = "GpsClock";
    public static final byte TYPE_GPS_TIME = 2;
    public static final byte TYPE_LOCAL_HW_TIME = 1;
    public static final byte TYPE_UNKNOWN = 0;
    private double mBiasInNs;
    private double mBiasUncertaintyInNs;
    private double mDriftInNsPerSec;
    private double mDriftUncertaintyInNsPerSec;
    private short mFlags;
    private long mFullBiasInNs;
    private short mLeapSecond;
    private long mTimeInNs;
    private double mTimeUncertaintyInNs;
    private byte mType;

    GpsClock() {
        initialize();
    }

    private String getTypeString() {
        switch (this.mType) {
            case 0:
                return "Unknown";
            case 1:
                return "LocalHwClock";
            case 2:
                return "GpsTime";
            default:
                return "<Invalid>";
        }
    }

    private void initialize() {
        this.mFlags = (short) 0;
        resetLeapSecond();
        setType((byte) 0);
        setTimeInNs(Long.MIN_VALUE);
        resetTimeUncertaintyInNs();
        resetFullBiasInNs();
        resetBiasInNs();
        resetBiasUncertaintyInNs();
        resetDriftInNsPerSec();
        resetDriftUncertaintyInNsPerSec();
    }

    private boolean isFlagSet(short s) {
        return (this.mFlags & s) == s;
    }

    private void resetFlag(short s) {
        this.mFlags = (short) (this.mFlags & (s ^ (-1)));
    }

    private void setFlag(short s) {
        this.mFlags = (short) (this.mFlags | s);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getBiasInNs() {
        return this.mBiasInNs;
    }

    public double getBiasUncertaintyInNs() {
        return this.mBiasUncertaintyInNs;
    }

    public double getDriftInNsPerSec() {
        return this.mDriftInNsPerSec;
    }

    public double getDriftUncertaintyInNsPerSec() {
        return this.mDriftUncertaintyInNsPerSec;
    }

    public long getFullBiasInNs() {
        return this.mFullBiasInNs;
    }

    public short getLeapSecond() {
        return this.mLeapSecond;
    }

    public long getTimeInNs() {
        return this.mTimeInNs;
    }

    public double getTimeUncertaintyInNs() {
        return this.mTimeUncertaintyInNs;
    }

    public byte getType() {
        return this.mType;
    }

    public boolean hasBiasInNs() {
        return isFlagSet((short) 8);
    }

    public boolean hasBiasUncertaintyInNs() {
        return isFlagSet((short) 16);
    }

    public boolean hasDriftInNsPerSec() {
        return isFlagSet((short) 32);
    }

    public boolean hasDriftUncertaintyInNsPerSec() {
        return isFlagSet((short) 64);
    }

    public boolean hasFullBiasInNs() {
        return isFlagSet((short) 4);
    }

    public boolean hasLeapSecond() {
        return isFlagSet((short) 1);
    }

    public boolean hasTimeUncertaintyInNs() {
        return isFlagSet((short) 2);
    }

    public void reset() {
        initialize();
    }

    public void resetBiasInNs() {
        resetFlag((short) 8);
        this.mBiasInNs = Double.NaN;
    }

    public void resetBiasUncertaintyInNs() {
        resetFlag((short) 16);
        this.mBiasUncertaintyInNs = Double.NaN;
    }

    public void resetDriftInNsPerSec() {
        resetFlag((short) 32);
        this.mDriftInNsPerSec = Double.NaN;
    }

    public void resetDriftUncertaintyInNsPerSec() {
        resetFlag((short) 64);
        this.mDriftUncertaintyInNsPerSec = Double.NaN;
    }

    public void resetFullBiasInNs() {
        resetFlag((short) 4);
        this.mFullBiasInNs = Long.MIN_VALUE;
    }

    public void resetLeapSecond() {
        resetFlag((short) 1);
        this.mLeapSecond = Short.MIN_VALUE;
    }

    public void resetTimeUncertaintyInNs() {
        resetFlag((short) 2);
        this.mTimeUncertaintyInNs = Double.NaN;
    }

    public void set(GpsClock gpsClock) {
        this.mFlags = gpsClock.mFlags;
        this.mLeapSecond = gpsClock.mLeapSecond;
        this.mType = gpsClock.mType;
        this.mTimeInNs = gpsClock.mTimeInNs;
        this.mTimeUncertaintyInNs = gpsClock.mTimeUncertaintyInNs;
        this.mFullBiasInNs = gpsClock.mFullBiasInNs;
        this.mBiasInNs = gpsClock.mBiasInNs;
        this.mBiasUncertaintyInNs = gpsClock.mBiasUncertaintyInNs;
        this.mDriftInNsPerSec = gpsClock.mDriftInNsPerSec;
        this.mDriftUncertaintyInNsPerSec = gpsClock.mDriftUncertaintyInNsPerSec;
    }

    public void setBiasInNs(double d) {
        setFlag((short) 8);
        this.mBiasInNs = d;
    }

    public void setBiasUncertaintyInNs(double d) {
        setFlag((short) 16);
        this.mBiasUncertaintyInNs = d;
    }

    public void setDriftInNsPerSec(double d) {
        setFlag((short) 32);
        this.mDriftInNsPerSec = d;
    }

    public void setDriftUncertaintyInNsPerSec(double d) {
        setFlag((short) 64);
        this.mDriftUncertaintyInNsPerSec = d;
    }

    public void setFullBiasInNs(long j) {
        setFlag((short) 4);
        this.mFullBiasInNs = j;
    }

    public void setLeapSecond(short s) {
        setFlag((short) 1);
        this.mLeapSecond = s;
    }

    public void setTimeInNs(long j) {
        this.mTimeInNs = j;
    }

    public void setTimeUncertaintyInNs(double d) {
        setFlag((short) 2);
        this.mTimeUncertaintyInNs = d;
    }

    public void setType(byte b) {
        switch (b) {
            case 0:
            case 1:
            case 2:
                this.mType = b;
                return;
            default:
                Log.d(TAG, "Sanitizing invalid 'type': " + ((int) b));
                this.mType = (byte) 0;
                return;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GpsClock:\n");
        sb.append(String.format("   %-15s = %s\n", "Type", getTypeString()));
        sb.append(String.format("   %-15s = %s\n", "LeapSecond", hasLeapSecond() ? Short.valueOf(this.mLeapSecond) : null));
        sb.append(String.format("   %-15s = %-25s   %-26s = %s\n", "TimeInNs", Long.valueOf(this.mTimeInNs), "TimeUncertaintyInNs", hasTimeUncertaintyInNs() ? Double.valueOf(this.mTimeUncertaintyInNs) : null));
        sb.append(String.format("   %-15s = %s\n", "FullBiasInNs", hasFullBiasInNs() ? Long.valueOf(this.mFullBiasInNs) : null));
        sb.append(String.format("   %-15s = %-25s   %-26s = %s\n", "BiasInNs", hasBiasInNs() ? Double.valueOf(this.mBiasInNs) : null, "BiasUncertaintyInNs", hasBiasUncertaintyInNs() ? Double.valueOf(this.mBiasUncertaintyInNs) : null));
        Double valueOf = hasDriftInNsPerSec() ? Double.valueOf(this.mDriftInNsPerSec) : null;
        Double d = null;
        if (hasDriftUncertaintyInNsPerSec()) {
            d = Double.valueOf(this.mDriftUncertaintyInNsPerSec);
        }
        sb.append(String.format("   %-15s = %-25s   %-26s = %s\n", "DriftInNsPerSec", valueOf, "DriftUncertaintyInNsPerSec", d));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mFlags);
        parcel.writeInt(this.mLeapSecond);
        parcel.writeByte(this.mType);
        parcel.writeLong(this.mTimeInNs);
        parcel.writeDouble(this.mTimeUncertaintyInNs);
        parcel.writeLong(this.mFullBiasInNs);
        parcel.writeDouble(this.mBiasInNs);
        parcel.writeDouble(this.mBiasUncertaintyInNs);
        parcel.writeDouble(this.mDriftInNsPerSec);
        parcel.writeDouble(this.mDriftUncertaintyInNsPerSec);
    }
}
