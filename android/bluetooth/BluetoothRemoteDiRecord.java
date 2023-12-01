package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothRemoteDiRecord.class */
public final class BluetoothRemoteDiRecord implements Parcelable {
    public static final Parcelable.Creator<BluetoothRemoteDiRecord> CREATOR = new Parcelable.Creator<BluetoothRemoteDiRecord>() { // from class: android.bluetooth.BluetoothRemoteDiRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothRemoteDiRecord createFromParcel(Parcel parcel) {
            return new BluetoothRemoteDiRecord(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothRemoteDiRecord[] newArray(int i) {
            return new BluetoothRemoteDiRecord[i];
        }
    };
    private Object mObject = new Object();
    private int mProductId;
    private int mProductVersion;
    private int mSpecificationId;
    private int mVendorId;
    private int mVendorIdSource;

    public BluetoothRemoteDiRecord(int i, int i2, int i3, int i4, int i5) {
        this.mVendorId = i;
        this.mVendorIdSource = i2;
        this.mProductId = i3;
        this.mProductVersion = i4;
        this.mSpecificationId = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getProductId() {
        int i;
        synchronized (this.mObject) {
            i = this.mProductId;
        }
        return i;
    }

    public int getProductVersion() {
        int i;
        synchronized (this.mObject) {
            i = this.mProductVersion;
        }
        return i;
    }

    public int getSpecificationId() {
        int i;
        synchronized (this.mObject) {
            i = this.mSpecificationId;
        }
        return i;
    }

    public int getVendorId() {
        int i;
        synchronized (this.mObject) {
            i = this.mVendorId;
        }
        return i;
    }

    public int getVendorIdSource() {
        int i;
        synchronized (this.mObject) {
            i = this.mVendorIdSource;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVendorId);
        parcel.writeInt(this.mVendorIdSource);
        parcel.writeInt(this.mProductId);
        parcel.writeInt(this.mProductVersion);
        parcel.writeInt(this.mSpecificationId);
    }
}
