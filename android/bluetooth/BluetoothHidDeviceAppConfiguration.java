package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Random;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHidDeviceAppConfiguration.class */
public final class BluetoothHidDeviceAppConfiguration implements Parcelable {
    public static final Parcelable.Creator<BluetoothHidDeviceAppConfiguration> CREATOR = new Parcelable.Creator<BluetoothHidDeviceAppConfiguration>() { // from class: android.bluetooth.BluetoothHidDeviceAppConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHidDeviceAppConfiguration createFromParcel(Parcel parcel) {
            return new BluetoothHidDeviceAppConfiguration(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHidDeviceAppConfiguration[] newArray(int i) {
            return new BluetoothHidDeviceAppConfiguration[i];
        }
    };
    private final long mHash;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothHidDeviceAppConfiguration() {
        this.mHash = new Random().nextLong();
    }

    BluetoothHidDeviceAppConfiguration(long j) {
        this.mHash = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof BluetoothHidDeviceAppConfiguration) {
            z = false;
            if (this.mHash == ((BluetoothHidDeviceAppConfiguration) obj).mHash) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mHash);
    }
}
