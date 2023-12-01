package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHidDeviceAppSdpSettings.class */
public final class BluetoothHidDeviceAppSdpSettings implements Parcelable {
    public static final Parcelable.Creator<BluetoothHidDeviceAppSdpSettings> CREATOR = new Parcelable.Creator<BluetoothHidDeviceAppSdpSettings>() { // from class: android.bluetooth.BluetoothHidDeviceAppSdpSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHidDeviceAppSdpSettings createFromParcel(Parcel parcel) {
            return new BluetoothHidDeviceAppSdpSettings(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readByte(), parcel.createByteArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHidDeviceAppSdpSettings[] newArray(int i) {
            return new BluetoothHidDeviceAppSdpSettings[i];
        }
    };
    public final String description;
    public final byte[] descriptors;
    public final String name;
    public final String provider;
    public final byte subclass;

    public BluetoothHidDeviceAppSdpSettings(String str, String str2, String str3, byte b, byte[] bArr) {
        this.name = str;
        this.description = str2;
        this.provider = str3;
        this.subclass = b;
        this.descriptors = (byte[]) bArr.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BluetoothHidDeviceAppSdpSettings) {
            BluetoothHidDeviceAppSdpSettings bluetoothHidDeviceAppSdpSettings = (BluetoothHidDeviceAppSdpSettings) obj;
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.provider);
        parcel.writeByte(this.subclass);
        parcel.writeByteArray(this.descriptors);
    }
}
