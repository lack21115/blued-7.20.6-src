package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothAudioConfig.class */
public final class BluetoothAudioConfig implements Parcelable {
    public static final Parcelable.Creator<BluetoothAudioConfig> CREATOR = new Parcelable.Creator<BluetoothAudioConfig>() { // from class: android.bluetooth.BluetoothAudioConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothAudioConfig createFromParcel(Parcel parcel) {
            return new BluetoothAudioConfig(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothAudioConfig[] newArray(int i) {
            return new BluetoothAudioConfig[i];
        }
    };
    private final int mAudioFormat;
    private final int mChannelConfig;
    private final int mSampleRate;

    public BluetoothAudioConfig(int i, int i2, int i3) {
        this.mSampleRate = i;
        this.mChannelConfig = i2;
        this.mAudioFormat = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof BluetoothAudioConfig) {
            BluetoothAudioConfig bluetoothAudioConfig = (BluetoothAudioConfig) obj;
            z = false;
            if (bluetoothAudioConfig.mSampleRate == this.mSampleRate) {
                z = false;
                if (bluetoothAudioConfig.mChannelConfig == this.mChannelConfig) {
                    z = false;
                    if (bluetoothAudioConfig.mAudioFormat == this.mAudioFormat) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int hashCode() {
        return this.mSampleRate | (this.mChannelConfig << 24) | (this.mAudioFormat << 28);
    }

    public String toString() {
        return "{mSampleRate:" + this.mSampleRate + ",mChannelConfig:" + this.mChannelConfig + ",mAudioFormat:" + this.mAudioFormat + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSampleRate);
        parcel.writeInt(this.mChannelConfig);
        parcel.writeInt(this.mAudioFormat);
    }
}
