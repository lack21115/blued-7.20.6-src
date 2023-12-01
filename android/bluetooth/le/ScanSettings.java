package android.bluetooth.le;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/ScanSettings.class */
public final class ScanSettings implements Parcelable {
    public static final int CALLBACK_TYPE_ALL_MATCHES = 1;
    public static final int CALLBACK_TYPE_FIRST_MATCH = 2;
    public static final int CALLBACK_TYPE_MATCH_LOST = 4;
    public static final Parcelable.Creator<ScanSettings> CREATOR = new Parcelable.Creator<ScanSettings>() { // from class: android.bluetooth.le.ScanSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSettings createFromParcel(Parcel parcel) {
            return new ScanSettings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSettings[] newArray(int i) {
            return new ScanSettings[i];
        }
    };
    public static final int SCAN_MODE_BALANCED = 1;
    public static final int SCAN_MODE_LOW_LATENCY = 2;
    public static final int SCAN_MODE_LOW_POWER = 0;
    public static final int SCAN_RESULT_TYPE_ABBREVIATED = 1;
    public static final int SCAN_RESULT_TYPE_FULL = 0;
    private int mCallbackType;
    private long mReportDelayMillis;
    private int mScanMode;
    private int mScanResultType;

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/ScanSettings$Builder.class */
    public static final class Builder {
        private int mScanMode = 0;
        private int mCallbackType = 1;
        private int mScanResultType = 0;
        private long mReportDelayMillis = 0;

        private boolean isValidCallbackType(int i) {
            return i == 1 || i == 2 || i == 4 || i == 6;
        }

        public ScanSettings build() {
            return new ScanSettings(this.mScanMode, this.mCallbackType, this.mScanResultType, this.mReportDelayMillis);
        }

        public Builder setCallbackType(int i) {
            if (isValidCallbackType(i)) {
                this.mCallbackType = i;
                return this;
            }
            throw new IllegalArgumentException("invalid callback type - " + i);
        }

        public Builder setReportDelay(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("reportDelay must be > 0");
            }
            this.mReportDelayMillis = j;
            return this;
        }

        public Builder setScanMode(int i) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("invalid scan mode " + i);
            }
            this.mScanMode = i;
            return this;
        }

        public Builder setScanResultType(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("invalid scanResultType - " + i);
            }
            this.mScanResultType = i;
            return this;
        }
    }

    private ScanSettings(int i, int i2, int i3, long j) {
        this.mScanMode = i;
        this.mCallbackType = i2;
        this.mScanResultType = i3;
        this.mReportDelayMillis = j;
    }

    private ScanSettings(Parcel parcel) {
        this.mScanMode = parcel.readInt();
        this.mCallbackType = parcel.readInt();
        this.mScanResultType = parcel.readInt();
        this.mReportDelayMillis = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCallbackType() {
        return this.mCallbackType;
    }

    public long getReportDelayMillis() {
        return this.mReportDelayMillis;
    }

    public int getScanMode() {
        return this.mScanMode;
    }

    public int getScanResultType() {
        return this.mScanResultType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mScanMode);
        parcel.writeInt(this.mCallbackType);
        parcel.writeInt(this.mScanResultType);
        parcel.writeLong(this.mReportDelayMillis);
    }
}
