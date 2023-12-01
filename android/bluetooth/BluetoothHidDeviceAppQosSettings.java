package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHidDeviceAppQosSettings.class */
public final class BluetoothHidDeviceAppQosSettings implements Parcelable {
    public static final Parcelable.Creator<BluetoothHidDeviceAppQosSettings> CREATOR = new Parcelable.Creator<BluetoothHidDeviceAppQosSettings>() { // from class: android.bluetooth.BluetoothHidDeviceAppQosSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHidDeviceAppQosSettings createFromParcel(Parcel parcel) {
            return new BluetoothHidDeviceAppQosSettings(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHidDeviceAppQosSettings[] newArray(int i) {
            return new BluetoothHidDeviceAppQosSettings[i];
        }
    };
    public static final int MAX = -1;
    public static final int SERVICE_BEST_EFFORT = 1;
    public static final int SERVICE_GUARANTEED = 2;
    public static final int SERVICE_NO_TRAFFIC = 0;
    public final int delayVariation;
    public final int latency;
    public final int peakBandwidth;
    public final int serviceType;
    public final int tokenBucketSize;
    public final int tokenRate;

    public BluetoothHidDeviceAppQosSettings(int i, int i2, int i3, int i4, int i5, int i6) {
        this.serviceType = i;
        this.tokenRate = i2;
        this.tokenBucketSize = i3;
        this.peakBandwidth = i4;
        this.latency = i5;
        this.delayVariation = i6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BluetoothHidDeviceAppQosSettings) {
            BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings = (BluetoothHidDeviceAppQosSettings) obj;
            return false;
        }
        return false;
    }

    public int[] toArray() {
        return new int[]{this.serviceType, this.tokenRate, this.tokenBucketSize, this.peakBandwidth, this.latency, this.delayVariation};
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.serviceType);
        parcel.writeInt(this.tokenRate);
        parcel.writeInt(this.tokenBucketSize);
        parcel.writeInt(this.peakBandwidth);
        parcel.writeInt(this.latency);
        parcel.writeInt(this.delayVariation);
    }
}
