package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothMasInstance.class */
public final class BluetoothMasInstance implements Parcelable {
    public static final Parcelable.Creator<BluetoothMasInstance> CREATOR = new Parcelable.Creator<BluetoothMasInstance>() { // from class: android.bluetooth.BluetoothMasInstance.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothMasInstance createFromParcel(Parcel parcel) {
            return new BluetoothMasInstance(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothMasInstance[] newArray(int i) {
            return new BluetoothMasInstance[i];
        }
    };
    private final int mChannel;
    private final int mId;
    private final int mMsgTypes;
    private final String mName;

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothMasInstance$MessageType.class */
    public static final class MessageType {
        public static final int EMAIL = 1;
        public static final int MMS = 8;
        public static final int SMS_CDMA = 4;
        public static final int SMS_GSM = 2;
    }

    public BluetoothMasInstance(int i, String str, int i2, int i3) {
        this.mId = i;
        this.mName = str;
        this.mChannel = i2;
        this.mMsgTypes = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof BluetoothMasInstance) {
            z = false;
            if (this.mId == ((BluetoothMasInstance) obj).mId) {
                z = true;
            }
        }
        return z;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public int getId() {
        return this.mId;
    }

    public int getMsgTypes() {
        return this.mMsgTypes;
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return this.mId + (this.mChannel << 8) + (this.mMsgTypes << 16);
    }

    public boolean msgSupported(int i) {
        return (this.mMsgTypes & i) != 0;
    }

    public String toString() {
        return Integer.toString(this.mId) + ":" + this.mName + ":" + this.mChannel + ":" + Integer.toHexString(this.mMsgTypes);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mChannel);
        parcel.writeInt(this.mMsgTypes);
    }
}
