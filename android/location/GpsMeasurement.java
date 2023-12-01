package android.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/location/GpsMeasurement.class */
public class GpsMeasurement implements Parcelable {
    public static final short ADR_STATE_CYCLE_SLIP = 4;
    public static final short ADR_STATE_RESET = 2;
    public static final short ADR_STATE_UNKNOWN = 0;
    public static final short ADR_STATE_VALID = 1;
    public static final Parcelable.Creator<GpsMeasurement> CREATOR = new Parcelable.Creator<GpsMeasurement>() { // from class: android.location.GpsMeasurement.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsMeasurement createFromParcel(Parcel parcel) {
            GpsMeasurement gpsMeasurement = new GpsMeasurement();
            gpsMeasurement.mFlags = parcel.readInt();
            gpsMeasurement.mPrn = parcel.readByte();
            gpsMeasurement.mTimeOffsetInNs = parcel.readDouble();
            gpsMeasurement.mState = (short) parcel.readInt();
            gpsMeasurement.mReceivedGpsTowInNs = parcel.readLong();
            gpsMeasurement.mReceivedGpsTowUncertaintyInNs = parcel.readLong();
            gpsMeasurement.mCn0InDbHz = parcel.readDouble();
            gpsMeasurement.mPseudorangeRateInMetersPerSec = parcel.readDouble();
            gpsMeasurement.mPseudorangeRateUncertaintyInMetersPerSec = parcel.readDouble();
            gpsMeasurement.mAccumulatedDeltaRangeState = (short) parcel.readInt();
            gpsMeasurement.mAccumulatedDeltaRangeInMeters = parcel.readDouble();
            gpsMeasurement.mAccumulatedDeltaRangeUncertaintyInMeters = parcel.readDouble();
            gpsMeasurement.mPseudorangeInMeters = parcel.readDouble();
            gpsMeasurement.mPseudorangeUncertaintyInMeters = parcel.readDouble();
            gpsMeasurement.mCodePhaseInChips = parcel.readDouble();
            gpsMeasurement.mCodePhaseUncertaintyInChips = parcel.readDouble();
            gpsMeasurement.mCarrierFrequencyInHz = parcel.readFloat();
            gpsMeasurement.mCarrierCycles = parcel.readLong();
            gpsMeasurement.mCarrierPhase = parcel.readDouble();
            gpsMeasurement.mCarrierPhaseUncertainty = parcel.readDouble();
            gpsMeasurement.mLossOfLock = parcel.readByte();
            gpsMeasurement.mBitNumber = parcel.readInt();
            gpsMeasurement.mTimeFromLastBitInMs = (short) parcel.readInt();
            gpsMeasurement.mDopplerShiftInHz = parcel.readDouble();
            gpsMeasurement.mDopplerShiftUncertaintyInHz = parcel.readDouble();
            gpsMeasurement.mMultipathIndicator = parcel.readByte();
            gpsMeasurement.mSnrInDb = parcel.readDouble();
            gpsMeasurement.mElevationInDeg = parcel.readDouble();
            gpsMeasurement.mElevationUncertaintyInDeg = parcel.readDouble();
            gpsMeasurement.mAzimuthInDeg = parcel.readDouble();
            gpsMeasurement.mAzimuthUncertaintyInDeg = parcel.readDouble();
            gpsMeasurement.mUsedInFix = parcel.readInt() != 0;
            return gpsMeasurement;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsMeasurement[] newArray(int i) {
            return new GpsMeasurement[i];
        }
    };
    private static final int HAS_AZIMUTH = 8;
    private static final int HAS_AZIMUTH_UNCERTAINTY = 16;
    private static final int HAS_BIT_NUMBER = 8192;
    private static final int HAS_CARRIER_CYCLES = 1024;
    private static final int HAS_CARRIER_FREQUENCY = 512;
    private static final int HAS_CARRIER_PHASE = 2048;
    private static final int HAS_CARRIER_PHASE_UNCERTAINTY = 4096;
    private static final int HAS_CODE_PHASE = 128;
    private static final int HAS_CODE_PHASE_UNCERTAINTY = 256;
    private static final int HAS_DOPPLER_SHIFT = 32768;
    private static final int HAS_DOPPLER_SHIFT_UNCERTAINTY = 65536;
    private static final int HAS_ELEVATION = 2;
    private static final int HAS_ELEVATION_UNCERTAINTY = 4;
    private static final int HAS_NO_FLAGS = 0;
    private static final int HAS_PSEUDORANGE = 32;
    private static final int HAS_PSEUDORANGE_UNCERTAINTY = 64;
    private static final int HAS_SNR = 1;
    private static final int HAS_TIME_FROM_LAST_BIT = 16384;
    public static final byte LOSS_OF_LOCK_CYCLE_SLIP = 2;
    public static final byte LOSS_OF_LOCK_OK = 1;
    public static final byte LOSS_OF_LOCK_UNKNOWN = 0;
    public static final byte MULTIPATH_INDICATOR_DETECTED = 1;
    public static final byte MULTIPATH_INDICATOR_NOT_USED = 2;
    public static final byte MULTIPATH_INDICATOR_UNKNOWN = 0;
    public static final short STATE_BIT_SYNC = 2;
    public static final short STATE_CODE_LOCK = 1;
    public static final short STATE_SUBFRAME_SYNC = 4;
    public static final short STATE_TOW_DECODED = 8;
    public static final short STATE_UNKNOWN = 0;
    private static final String TAG = "GpsMeasurement";
    private double mAccumulatedDeltaRangeInMeters;
    private short mAccumulatedDeltaRangeState;
    private double mAccumulatedDeltaRangeUncertaintyInMeters;
    private double mAzimuthInDeg;
    private double mAzimuthUncertaintyInDeg;
    private int mBitNumber;
    private long mCarrierCycles;
    private float mCarrierFrequencyInHz;
    private double mCarrierPhase;
    private double mCarrierPhaseUncertainty;
    private double mCn0InDbHz;
    private double mCodePhaseInChips;
    private double mCodePhaseUncertaintyInChips;
    private double mDopplerShiftInHz;
    private double mDopplerShiftUncertaintyInHz;
    private double mElevationInDeg;
    private double mElevationUncertaintyInDeg;
    private int mFlags;
    private byte mLossOfLock;
    private byte mMultipathIndicator;
    private byte mPrn;
    private double mPseudorangeInMeters;
    private double mPseudorangeRateInMetersPerSec;
    private double mPseudorangeRateUncertaintyInMetersPerSec;
    private double mPseudorangeUncertaintyInMeters;
    private long mReceivedGpsTowInNs;
    private long mReceivedGpsTowUncertaintyInNs;
    private double mSnrInDb;
    private short mState;
    private short mTimeFromLastBitInMs;
    private double mTimeOffsetInNs;
    private boolean mUsedInFix;

    GpsMeasurement() {
        initialize();
    }

    private String getAccumulatedDeltaRangeStateString() {
        switch (this.mAccumulatedDeltaRangeState) {
            case 0:
                return "Unknown";
            case 1:
                return "Valid";
            case 2:
                return "Reset";
            case 3:
            default:
                return "<Invalid>";
            case 4:
                return "CycleSlip";
        }
    }

    private String getLossOfLockString() {
        switch (this.mLossOfLock) {
            case 0:
                return "Unknown";
            case 1:
                return "Ok";
            case 2:
                return "CycleSlip";
            default:
                return "<Invalid>";
        }
    }

    private String getMultipathIndicatorString() {
        switch (this.mMultipathIndicator) {
            case 0:
                return "Unknown";
            case 1:
                return "Detected";
            case 2:
                return "NotUsed";
            default:
                return "<Invalid>";
        }
    }

    private String getStateString() {
        switch (this.mState) {
            case 0:
                return "Unknown";
            case 1:
                return "CodeLock";
            case 2:
                return "BitSync";
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                return "<Invalid>";
            case 4:
                return "SubframeSync";
            case 8:
                return "TowDecoded";
        }
    }

    private void initialize() {
        this.mFlags = 0;
        setPrn(Byte.MIN_VALUE);
        setTimeOffsetInNs(-9.223372036854776E18d);
        setState((short) 0);
        setReceivedGpsTowInNs(Long.MIN_VALUE);
        setReceivedGpsTowUncertaintyInNs(Long.MAX_VALUE);
        setCn0InDbHz(Double.MIN_VALUE);
        setPseudorangeRateInMetersPerSec(Double.MIN_VALUE);
        setPseudorangeRateUncertaintyInMetersPerSec(Double.MIN_VALUE);
        setAccumulatedDeltaRangeState((short) 0);
        setAccumulatedDeltaRangeInMeters(Double.MIN_VALUE);
        setAccumulatedDeltaRangeUncertaintyInMeters(Double.MIN_VALUE);
        resetPseudorangeInMeters();
        resetPseudorangeUncertaintyInMeters();
        resetCodePhaseInChips();
        resetCodePhaseUncertaintyInChips();
        resetCarrierFrequencyInHz();
        resetCarrierCycles();
        resetCarrierPhase();
        resetCarrierPhaseUncertainty();
        setLossOfLock((byte) 0);
        resetBitNumber();
        resetTimeFromLastBitInMs();
        resetDopplerShiftInHz();
        resetDopplerShiftUncertaintyInHz();
        setMultipathIndicator((byte) 0);
        resetSnrInDb();
        resetElevationInDeg();
        resetElevationUncertaintyInDeg();
        resetAzimuthInDeg();
        resetAzimuthUncertaintyInDeg();
        setUsedInFix(false);
    }

    private boolean isFlagSet(int i) {
        return (this.mFlags & i) == i;
    }

    private void resetFlag(int i) {
        this.mFlags &= i ^ (-1);
    }

    private void setFlag(int i) {
        this.mFlags |= i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAccumulatedDeltaRangeInMeters() {
        return this.mAccumulatedDeltaRangeInMeters;
    }

    public short getAccumulatedDeltaRangeState() {
        return this.mAccumulatedDeltaRangeState;
    }

    public double getAccumulatedDeltaRangeUncertaintyInMeters() {
        return this.mAccumulatedDeltaRangeUncertaintyInMeters;
    }

    public double getAzimuthInDeg() {
        return this.mAzimuthInDeg;
    }

    public double getAzimuthUncertaintyInDeg() {
        return this.mAzimuthUncertaintyInDeg;
    }

    public int getBitNumber() {
        return this.mBitNumber;
    }

    public long getCarrierCycles() {
        return this.mCarrierCycles;
    }

    public float getCarrierFrequencyInHz() {
        return this.mCarrierFrequencyInHz;
    }

    public double getCarrierPhase() {
        return this.mCarrierPhase;
    }

    public double getCarrierPhaseUncertainty() {
        return this.mCarrierPhaseUncertainty;
    }

    public double getCn0InDbHz() {
        return this.mCn0InDbHz;
    }

    public double getCodePhaseInChips() {
        return this.mCodePhaseInChips;
    }

    public double getCodePhaseUncertaintyInChips() {
        return this.mCodePhaseUncertaintyInChips;
    }

    public double getDopplerShiftInHz() {
        return this.mDopplerShiftInHz;
    }

    public double getDopplerShiftUncertaintyInHz() {
        return this.mDopplerShiftUncertaintyInHz;
    }

    public double getElevationInDeg() {
        return this.mElevationInDeg;
    }

    public double getElevationUncertaintyInDeg() {
        return this.mElevationUncertaintyInDeg;
    }

    public byte getLossOfLock() {
        return this.mLossOfLock;
    }

    public byte getMultipathIndicator() {
        return this.mMultipathIndicator;
    }

    public byte getPrn() {
        return this.mPrn;
    }

    public double getPseudorangeInMeters() {
        return this.mPseudorangeInMeters;
    }

    public double getPseudorangeRateInMetersPerSec() {
        return this.mPseudorangeRateInMetersPerSec;
    }

    public double getPseudorangeRateUncertaintyInMetersPerSec() {
        return this.mPseudorangeRateUncertaintyInMetersPerSec;
    }

    public double getPseudorangeUncertaintyInMeters() {
        return this.mPseudorangeUncertaintyInMeters;
    }

    public long getReceivedGpsTowInNs() {
        return this.mReceivedGpsTowInNs;
    }

    public long getReceivedGpsTowUncertaintyInNs() {
        return this.mReceivedGpsTowUncertaintyInNs;
    }

    public double getSnrInDb() {
        return this.mSnrInDb;
    }

    public short getState() {
        return this.mState;
    }

    public short getTimeFromLastBitInMs() {
        return this.mTimeFromLastBitInMs;
    }

    public double getTimeOffsetInNs() {
        return this.mTimeOffsetInNs;
    }

    public boolean hasAzimuthInDeg() {
        return isFlagSet(8);
    }

    public boolean hasAzimuthUncertaintyInDeg() {
        return isFlagSet(16);
    }

    public boolean hasBitNumber() {
        return isFlagSet(8192);
    }

    public boolean hasCarrierCycles() {
        return isFlagSet(1024);
    }

    public boolean hasCarrierFrequencyInHz() {
        return isFlagSet(512);
    }

    public boolean hasCarrierPhase() {
        return isFlagSet(2048);
    }

    public boolean hasCarrierPhaseUncertainty() {
        return isFlagSet(4096);
    }

    public boolean hasCodePhaseInChips() {
        return isFlagSet(128);
    }

    public boolean hasCodePhaseUncertaintyInChips() {
        return isFlagSet(256);
    }

    public boolean hasDopplerShiftInHz() {
        return isFlagSet(32768);
    }

    public boolean hasDopplerShiftUncertaintyInHz() {
        return isFlagSet(65536);
    }

    public boolean hasElevationInDeg() {
        return isFlagSet(2);
    }

    public boolean hasElevationUncertaintyInDeg() {
        return isFlagSet(4);
    }

    public boolean hasPseudorangeInMeters() {
        return isFlagSet(32);
    }

    public boolean hasPseudorangeUncertaintyInMeters() {
        return isFlagSet(64);
    }

    public boolean hasSnrInDb() {
        return isFlagSet(1);
    }

    public boolean hasTimeFromLastBitInMs() {
        return isFlagSet(16384);
    }

    public boolean isUsedInFix() {
        return this.mUsedInFix;
    }

    public void reset() {
        initialize();
    }

    public void resetAzimuthInDeg() {
        resetFlag(8);
        this.mAzimuthInDeg = Double.NaN;
    }

    public void resetAzimuthUncertaintyInDeg() {
        resetFlag(16);
        this.mAzimuthUncertaintyInDeg = Double.NaN;
    }

    public void resetBitNumber() {
        resetFlag(8192);
        this.mBitNumber = Integer.MIN_VALUE;
    }

    public void resetCarrierCycles() {
        resetFlag(1024);
        this.mCarrierCycles = Long.MIN_VALUE;
    }

    public void resetCarrierFrequencyInHz() {
        resetFlag(512);
        this.mCarrierFrequencyInHz = Float.NaN;
    }

    public void resetCarrierPhase() {
        resetFlag(2048);
        this.mCarrierPhase = Double.NaN;
    }

    public void resetCarrierPhaseUncertainty() {
        resetFlag(4096);
        this.mCarrierPhaseUncertainty = Double.NaN;
    }

    public void resetCodePhaseInChips() {
        resetFlag(128);
        this.mCodePhaseInChips = Double.NaN;
    }

    public void resetCodePhaseUncertaintyInChips() {
        resetFlag(256);
        this.mCodePhaseUncertaintyInChips = Double.NaN;
    }

    public void resetDopplerShiftInHz() {
        resetFlag(32768);
        this.mDopplerShiftInHz = Double.NaN;
    }

    public void resetDopplerShiftUncertaintyInHz() {
        resetFlag(65536);
        this.mDopplerShiftUncertaintyInHz = Double.NaN;
    }

    public void resetElevationInDeg() {
        resetFlag(2);
        this.mElevationInDeg = Double.NaN;
    }

    public void resetElevationUncertaintyInDeg() {
        resetFlag(4);
        this.mElevationUncertaintyInDeg = Double.NaN;
    }

    public void resetPseudorangeInMeters() {
        resetFlag(32);
        this.mPseudorangeInMeters = Double.NaN;
    }

    public void resetPseudorangeUncertaintyInMeters() {
        resetFlag(64);
        this.mPseudorangeUncertaintyInMeters = Double.NaN;
    }

    public void resetSnrInDb() {
        resetFlag(1);
        this.mSnrInDb = Double.NaN;
    }

    public void resetTimeFromLastBitInMs() {
        resetFlag(16384);
        this.mTimeFromLastBitInMs = Short.MIN_VALUE;
    }

    public void set(GpsMeasurement gpsMeasurement) {
        this.mFlags = gpsMeasurement.mFlags;
        this.mPrn = gpsMeasurement.mPrn;
        this.mTimeOffsetInNs = gpsMeasurement.mTimeOffsetInNs;
        this.mState = gpsMeasurement.mState;
        this.mReceivedGpsTowInNs = gpsMeasurement.mReceivedGpsTowInNs;
        this.mReceivedGpsTowUncertaintyInNs = gpsMeasurement.mReceivedGpsTowUncertaintyInNs;
        this.mCn0InDbHz = gpsMeasurement.mCn0InDbHz;
        this.mPseudorangeRateInMetersPerSec = gpsMeasurement.mPseudorangeRateInMetersPerSec;
        this.mPseudorangeRateUncertaintyInMetersPerSec = gpsMeasurement.mPseudorangeRateUncertaintyInMetersPerSec;
        this.mAccumulatedDeltaRangeState = gpsMeasurement.mAccumulatedDeltaRangeState;
        this.mAccumulatedDeltaRangeInMeters = gpsMeasurement.mAccumulatedDeltaRangeInMeters;
        this.mAccumulatedDeltaRangeUncertaintyInMeters = gpsMeasurement.mAccumulatedDeltaRangeUncertaintyInMeters;
        this.mPseudorangeInMeters = gpsMeasurement.mPseudorangeInMeters;
        this.mPseudorangeUncertaintyInMeters = gpsMeasurement.mPseudorangeUncertaintyInMeters;
        this.mCodePhaseInChips = gpsMeasurement.mCodePhaseInChips;
        this.mCodePhaseUncertaintyInChips = gpsMeasurement.mCodePhaseUncertaintyInChips;
        this.mCarrierFrequencyInHz = gpsMeasurement.mCarrierFrequencyInHz;
        this.mCarrierCycles = gpsMeasurement.mCarrierCycles;
        this.mCarrierPhase = gpsMeasurement.mCarrierPhase;
        this.mCarrierPhaseUncertainty = gpsMeasurement.mCarrierPhaseUncertainty;
        this.mLossOfLock = gpsMeasurement.mLossOfLock;
        this.mBitNumber = gpsMeasurement.mBitNumber;
        this.mTimeFromLastBitInMs = gpsMeasurement.mTimeFromLastBitInMs;
        this.mDopplerShiftInHz = gpsMeasurement.mDopplerShiftInHz;
        this.mDopplerShiftUncertaintyInHz = gpsMeasurement.mDopplerShiftUncertaintyInHz;
        this.mMultipathIndicator = gpsMeasurement.mMultipathIndicator;
        this.mSnrInDb = gpsMeasurement.mSnrInDb;
        this.mElevationInDeg = gpsMeasurement.mElevationInDeg;
        this.mElevationUncertaintyInDeg = gpsMeasurement.mElevationUncertaintyInDeg;
        this.mAzimuthInDeg = gpsMeasurement.mAzimuthInDeg;
        this.mAzimuthUncertaintyInDeg = gpsMeasurement.mAzimuthUncertaintyInDeg;
        this.mUsedInFix = gpsMeasurement.mUsedInFix;
    }

    public void setAccumulatedDeltaRangeInMeters(double d) {
        this.mAccumulatedDeltaRangeInMeters = d;
    }

    public void setAccumulatedDeltaRangeState(short s) {
        switch (s) {
            case 0:
            case 1:
            case 2:
            case 4:
                this.mAccumulatedDeltaRangeState = s;
                return;
            case 3:
            default:
                Log.d(TAG, "Sanitizing invalid 'Accumulated Delta Range state': " + ((int) s));
                this.mAccumulatedDeltaRangeState = (short) 0;
                return;
        }
    }

    public void setAccumulatedDeltaRangeUncertaintyInMeters(double d) {
        this.mAccumulatedDeltaRangeUncertaintyInMeters = d;
    }

    public void setAzimuthInDeg(double d) {
        setFlag(8);
        this.mAzimuthInDeg = d;
    }

    public void setAzimuthUncertaintyInDeg(double d) {
        setFlag(16);
        this.mAzimuthUncertaintyInDeg = d;
    }

    public void setBitNumber(int i) {
        setFlag(8192);
        this.mBitNumber = i;
    }

    public void setCarrierCycles(long j) {
        setFlag(1024);
        this.mCarrierCycles = j;
    }

    public void setCarrierFrequencyInHz(float f) {
        setFlag(512);
        this.mCarrierFrequencyInHz = f;
    }

    public void setCarrierPhase(double d) {
        setFlag(2048);
        this.mCarrierPhase = d;
    }

    public void setCarrierPhaseUncertainty(double d) {
        setFlag(4096);
        this.mCarrierPhaseUncertainty = d;
    }

    public void setCn0InDbHz(double d) {
        this.mCn0InDbHz = d;
    }

    public void setCodePhaseInChips(double d) {
        setFlag(128);
        this.mCodePhaseInChips = d;
    }

    public void setCodePhaseUncertaintyInChips(double d) {
        setFlag(256);
        this.mCodePhaseUncertaintyInChips = d;
    }

    public void setDopplerShiftInHz(double d) {
        setFlag(32768);
        this.mDopplerShiftInHz = d;
    }

    public void setDopplerShiftUncertaintyInHz(double d) {
        setFlag(65536);
        this.mDopplerShiftUncertaintyInHz = d;
    }

    public void setElevationInDeg(double d) {
        setFlag(2);
        this.mElevationInDeg = d;
    }

    public void setElevationUncertaintyInDeg(double d) {
        setFlag(4);
        this.mElevationUncertaintyInDeg = d;
    }

    public void setLossOfLock(byte b) {
        switch (b) {
            case 0:
            case 1:
            case 2:
                this.mLossOfLock = b;
                return;
            default:
                Log.d(TAG, "Sanitizing invalid 'loss of lock': " + ((int) b));
                this.mLossOfLock = (byte) 0;
                return;
        }
    }

    public void setMultipathIndicator(byte b) {
        switch (b) {
            case 0:
            case 1:
            case 2:
                this.mMultipathIndicator = b;
                return;
            default:
                Log.d(TAG, "Sanitizing invalid 'muti-path indicator': " + ((int) b));
                this.mMultipathIndicator = (byte) 0;
                return;
        }
    }

    public void setPrn(byte b) {
        this.mPrn = b;
    }

    public void setPseudorangeInMeters(double d) {
        setFlag(32);
        this.mPseudorangeInMeters = d;
    }

    public void setPseudorangeRateInMetersPerSec(double d) {
        this.mPseudorangeRateInMetersPerSec = d;
    }

    public void setPseudorangeRateUncertaintyInMetersPerSec(double d) {
        this.mPseudorangeRateUncertaintyInMetersPerSec = d;
    }

    public void setPseudorangeUncertaintyInMeters(double d) {
        setFlag(64);
        this.mPseudorangeUncertaintyInMeters = d;
    }

    public void setReceivedGpsTowInNs(long j) {
        this.mReceivedGpsTowInNs = j;
    }

    public void setReceivedGpsTowUncertaintyInNs(long j) {
        this.mReceivedGpsTowUncertaintyInNs = j;
    }

    public void setSnrInDb(double d) {
        setFlag(1);
        this.mSnrInDb = d;
    }

    public void setState(short s) {
        switch (s) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 8:
                this.mState = s;
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                Log.d(TAG, "Sanitizing invalid 'sync state': " + ((int) s));
                this.mState = (short) 0;
                return;
        }
    }

    public void setTimeFromLastBitInMs(short s) {
        setFlag(16384);
        this.mTimeFromLastBitInMs = s;
    }

    public void setTimeOffsetInNs(double d) {
        this.mTimeOffsetInNs = d;
    }

    public void setUsedInFix(boolean z) {
        this.mUsedInFix = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GpsMeasurement:\n");
        sb.append(String.format("   %-29s = %s\n", "Prn", Byte.valueOf(this.mPrn)));
        sb.append(String.format("   %-29s = %s\n", "TimeOffsetInNs", Double.valueOf(this.mTimeOffsetInNs)));
        sb.append(String.format("   %-29s = %s\n", "State", getStateString()));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "ReceivedGpsTowInNs", Long.valueOf(this.mReceivedGpsTowInNs), "ReceivedGpsTowUncertaintyInNs", Long.valueOf(this.mReceivedGpsTowUncertaintyInNs)));
        sb.append(String.format("   %-29s = %s\n", "Cn0InDbHz", Double.valueOf(this.mCn0InDbHz)));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "PseudorangeRateInMetersPerSec", Double.valueOf(this.mPseudorangeRateInMetersPerSec), "PseudorangeRateUncertaintyInMetersPerSec", Double.valueOf(this.mPseudorangeRateUncertaintyInMetersPerSec)));
        sb.append(String.format("   %-29s = %s\n", "AccumulatedDeltaRangeState", getAccumulatedDeltaRangeStateString()));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "AccumulatedDeltaRangeInMeters", Double.valueOf(this.mAccumulatedDeltaRangeInMeters), "AccumulatedDeltaRangeUncertaintyInMeters", Double.valueOf(this.mAccumulatedDeltaRangeUncertaintyInMeters)));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "PseudorangeInMeters", hasPseudorangeInMeters() ? Double.valueOf(this.mPseudorangeInMeters) : null, "PseudorangeUncertaintyInMeters", hasPseudorangeUncertaintyInMeters() ? Double.valueOf(this.mPseudorangeUncertaintyInMeters) : null));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "CodePhaseInChips", hasCodePhaseInChips() ? Double.valueOf(this.mCodePhaseInChips) : null, "CodePhaseUncertaintyInChips", hasCodePhaseUncertaintyInChips() ? Double.valueOf(this.mCodePhaseUncertaintyInChips) : null));
        sb.append(String.format("   %-29s = %s\n", "CarrierFrequencyInHz", hasCarrierFrequencyInHz() ? Float.valueOf(this.mCarrierFrequencyInHz) : null));
        sb.append(String.format("   %-29s = %s\n", "CarrierCycles", hasCarrierCycles() ? Long.valueOf(this.mCarrierCycles) : null));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "CarrierPhase", hasCarrierPhase() ? Double.valueOf(this.mCarrierPhase) : null, "CarrierPhaseUncertainty", hasCarrierPhaseUncertainty() ? Double.valueOf(this.mCarrierPhaseUncertainty) : null));
        sb.append(String.format("   %-29s = %s\n", "LossOfLock", getLossOfLockString()));
        sb.append(String.format("   %-29s = %s\n", "BitNumber", hasBitNumber() ? Integer.valueOf(this.mBitNumber) : null));
        sb.append(String.format("   %-29s = %s\n", "TimeFromLastBitInMs", hasTimeFromLastBitInMs() ? Short.valueOf(this.mTimeFromLastBitInMs) : null));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "DopplerShiftInHz", hasDopplerShiftInHz() ? Double.valueOf(this.mDopplerShiftInHz) : null, "DopplerShiftUncertaintyInHz", hasDopplerShiftUncertaintyInHz() ? Double.valueOf(this.mDopplerShiftUncertaintyInHz) : null));
        sb.append(String.format("   %-29s = %s\n", "MultipathIndicator", getMultipathIndicatorString()));
        sb.append(String.format("   %-29s = %s\n", "SnrInDb", hasSnrInDb() ? Double.valueOf(this.mSnrInDb) : null));
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "ElevationInDeg", hasElevationInDeg() ? Double.valueOf(this.mElevationInDeg) : null, "ElevationUncertaintyInDeg", hasElevationUncertaintyInDeg() ? Double.valueOf(this.mElevationUncertaintyInDeg) : null));
        Double valueOf = hasAzimuthInDeg() ? Double.valueOf(this.mAzimuthInDeg) : null;
        Double d = null;
        if (hasAzimuthUncertaintyInDeg()) {
            d = Double.valueOf(this.mAzimuthUncertaintyInDeg);
        }
        sb.append(String.format("   %-29s = %-25s   %-40s = %s\n", "AzimuthInDeg", valueOf, "AzimuthUncertaintyInDeg", d));
        sb.append(String.format("   %-29s = %s\n", "UsedInFix", Boolean.valueOf(this.mUsedInFix)));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mFlags);
        parcel.writeByte(this.mPrn);
        parcel.writeDouble(this.mTimeOffsetInNs);
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mReceivedGpsTowInNs);
        parcel.writeLong(this.mReceivedGpsTowUncertaintyInNs);
        parcel.writeDouble(this.mCn0InDbHz);
        parcel.writeDouble(this.mPseudorangeRateInMetersPerSec);
        parcel.writeDouble(this.mPseudorangeRateUncertaintyInMetersPerSec);
        parcel.writeInt(this.mAccumulatedDeltaRangeState);
        parcel.writeDouble(this.mAccumulatedDeltaRangeInMeters);
        parcel.writeDouble(this.mAccumulatedDeltaRangeUncertaintyInMeters);
        parcel.writeDouble(this.mPseudorangeInMeters);
        parcel.writeDouble(this.mPseudorangeUncertaintyInMeters);
        parcel.writeDouble(this.mCodePhaseInChips);
        parcel.writeDouble(this.mCodePhaseUncertaintyInChips);
        parcel.writeFloat(this.mCarrierFrequencyInHz);
        parcel.writeLong(this.mCarrierCycles);
        parcel.writeDouble(this.mCarrierPhase);
        parcel.writeDouble(this.mCarrierPhaseUncertainty);
        parcel.writeByte(this.mLossOfLock);
        parcel.writeInt(this.mBitNumber);
        parcel.writeInt(this.mTimeFromLastBitInMs);
        parcel.writeDouble(this.mDopplerShiftInHz);
        parcel.writeDouble(this.mDopplerShiftUncertaintyInHz);
        parcel.writeByte(this.mMultipathIndicator);
        parcel.writeDouble(this.mSnrInDb);
        parcel.writeDouble(this.mElevationInDeg);
        parcel.writeDouble(this.mElevationUncertaintyInDeg);
        parcel.writeDouble(this.mAzimuthInDeg);
        parcel.writeDouble(this.mAzimuthUncertaintyInDeg);
        parcel.writeInt(this.mUsedInFix ? 1 : 0);
    }
}
