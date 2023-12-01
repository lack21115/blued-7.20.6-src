package android.bluetooth.le;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/AdvertiseSettings.class */
public final class AdvertiseSettings implements Parcelable {
    public static final int ADVERTISE_MODE_BALANCED = 1;
    public static final int ADVERTISE_MODE_LOW_LATENCY = 2;
    public static final int ADVERTISE_MODE_LOW_POWER = 0;
    public static final int ADVERTISE_TX_POWER_HIGH = 3;
    public static final int ADVERTISE_TX_POWER_LOW = 1;
    public static final int ADVERTISE_TX_POWER_MEDIUM = 2;
    public static final int ADVERTISE_TX_POWER_ULTRA_LOW = 0;
    public static final Parcelable.Creator<AdvertiseSettings> CREATOR = new Parcelable.Creator<AdvertiseSettings>() { // from class: android.bluetooth.le.AdvertiseSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseSettings createFromParcel(Parcel parcel) {
            return new AdvertiseSettings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseSettings[] newArray(int i) {
            return new AdvertiseSettings[i];
        }
    };
    private static final int LIMITED_ADVERTISING_MAX_MILLIS = 180000;
    private final boolean mAdvertiseConnectable;
    private final int mAdvertiseMode;
    private final int mAdvertiseTimeoutMillis;
    private final int mAdvertiseTxPowerLevel;

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/AdvertiseSettings$Builder.class */
    public static final class Builder {
        private int mMode = 0;
        private int mTxPowerLevel = 2;
        private int mTimeoutMillis = 0;
        private boolean mConnectable = true;

        public AdvertiseSettings build() {
            return new AdvertiseSettings(this.mMode, this.mTxPowerLevel, this.mConnectable, this.mTimeoutMillis);
        }

        public Builder setAdvertiseMode(int i) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("unknown mode " + i);
            }
            this.mMode = i;
            return this;
        }

        public Builder setConnectable(boolean z) {
            this.mConnectable = z;
            return this;
        }

        public Builder setTimeout(int i) {
            if (i < 0 || i > AdvertiseSettings.LIMITED_ADVERTISING_MAX_MILLIS) {
                throw new IllegalArgumentException("timeoutMillis invalid (must be 0-180000 milliseconds)");
            }
            this.mTimeoutMillis = i;
            return this;
        }

        public Builder setTxPowerLevel(int i) {
            if (i < 0 || i > 3) {
                throw new IllegalArgumentException("unknown tx power level " + i);
            }
            this.mTxPowerLevel = i;
            return this;
        }
    }

    private AdvertiseSettings(int i, int i2, boolean z, int i3) {
        this.mAdvertiseMode = i;
        this.mAdvertiseTxPowerLevel = i2;
        this.mAdvertiseConnectable = z;
        this.mAdvertiseTimeoutMillis = i3;
    }

    private AdvertiseSettings(Parcel parcel) {
        this.mAdvertiseMode = parcel.readInt();
        this.mAdvertiseTxPowerLevel = parcel.readInt();
        this.mAdvertiseConnectable = parcel.readInt() != 0;
        this.mAdvertiseTimeoutMillis = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMode() {
        return this.mAdvertiseMode;
    }

    public int getTimeout() {
        return this.mAdvertiseTimeoutMillis;
    }

    public int getTxPowerLevel() {
        return this.mAdvertiseTxPowerLevel;
    }

    public boolean isConnectable() {
        return this.mAdvertiseConnectable;
    }

    public String toString() {
        return "Settings [mAdvertiseMode=" + this.mAdvertiseMode + ", mAdvertiseTxPowerLevel=" + this.mAdvertiseTxPowerLevel + ", mAdvertiseConnectable=" + this.mAdvertiseConnectable + ", mAdvertiseTimeoutMillis=" + this.mAdvertiseTimeoutMillis + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAdvertiseMode);
        parcel.writeInt(this.mAdvertiseTxPowerLevel);
        parcel.writeInt(this.mAdvertiseConnectable ? 1 : 0);
        parcel.writeInt(this.mAdvertiseTimeoutMillis);
    }
}
