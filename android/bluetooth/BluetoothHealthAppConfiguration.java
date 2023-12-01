package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothHealthAppConfiguration.class */
public final class BluetoothHealthAppConfiguration implements Parcelable {
    public static final Parcelable.Creator<BluetoothHealthAppConfiguration> CREATOR = new Parcelable.Creator<BluetoothHealthAppConfiguration>() { // from class: android.bluetooth.BluetoothHealthAppConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHealthAppConfiguration createFromParcel(Parcel parcel) {
            return new BluetoothHealthAppConfiguration(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothHealthAppConfiguration[] newArray(int i) {
            return new BluetoothHealthAppConfiguration[i];
        }
    };
    private final int mChannelType;
    private final int mDataType;
    private final String mName;
    private final int mRole;

    BluetoothHealthAppConfiguration(String str, int i) {
        this.mName = str;
        this.mDataType = i;
        this.mRole = 2;
        this.mChannelType = 12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothHealthAppConfiguration(String str, int i, int i2, int i3) {
        this.mName = str;
        this.mDataType = i;
        this.mRole = i2;
        this.mChannelType = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof BluetoothHealthAppConfiguration) {
            BluetoothHealthAppConfiguration bluetoothHealthAppConfiguration = (BluetoothHealthAppConfiguration) obj;
            z = false;
            if (this.mName.equals(bluetoothHealthAppConfiguration.getName())) {
                z = false;
                if (this.mDataType == bluetoothHealthAppConfiguration.getDataType()) {
                    z = false;
                    if (this.mRole == bluetoothHealthAppConfiguration.getRole()) {
                        z = false;
                        if (this.mChannelType == bluetoothHealthAppConfiguration.getChannelType()) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public int getChannelType() {
        return this.mChannelType;
    }

    public int getDataType() {
        return this.mDataType;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.mRole;
    }

    public int hashCode() {
        return (((((((this.mName != null ? this.mName.hashCode() : 0) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.mDataType) * 31) + this.mRole) * 31) + this.mChannelType;
    }

    public String toString() {
        return "BluetoothHealthAppConfiguration [mName = " + this.mName + ",mDataType = " + this.mDataType + ", mRole = " + this.mRole + ",mChannelType = " + this.mChannelType + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mDataType);
        parcel.writeInt(this.mRole);
        parcel.writeInt(this.mChannelType);
    }
}
