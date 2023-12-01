package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothActivityEnergyInfo.class */
public final class BluetoothActivityEnergyInfo implements Parcelable {
    public static final int BT_STACK_STATE_INVALID = 0;
    public static final int BT_STACK_STATE_STATE_ACTIVE = 1;
    public static final int BT_STACK_STATE_STATE_IDLE = 3;
    public static final int BT_STACK_STATE_STATE_SCANNING = 2;
    public static final Parcelable.Creator<BluetoothActivityEnergyInfo> CREATOR = new Parcelable.Creator<BluetoothActivityEnergyInfo>() { // from class: android.bluetooth.BluetoothActivityEnergyInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothActivityEnergyInfo createFromParcel(Parcel parcel) {
            return new BluetoothActivityEnergyInfo(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BluetoothActivityEnergyInfo[] newArray(int i) {
            return new BluetoothActivityEnergyInfo[i];
        }
    };
    private final int mBluetoothStackState;
    private final int mControllerEnergyUsed;
    private final int mControllerIdleTimeMs;
    private final int mControllerRxTimeMs;
    private final int mControllerTxTimeMs;
    private final long timestamp = System.currentTimeMillis();

    public BluetoothActivityEnergyInfo(int i, int i2, int i3, int i4, int i5) {
        this.mBluetoothStackState = i;
        this.mControllerTxTimeMs = i2;
        this.mControllerRxTimeMs = i3;
        this.mControllerIdleTimeMs = i4;
        this.mControllerEnergyUsed = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBluetoothStackState() {
        return this.mBluetoothStackState;
    }

    public int getControllerEnergyUsed() {
        return this.mControllerEnergyUsed;
    }

    public int getControllerIdleTimeMillis() {
        return this.mControllerIdleTimeMs;
    }

    public int getControllerRxTimeMillis() {
        return this.mControllerRxTimeMs;
    }

    public int getControllerTxTimeMillis() {
        return this.mControllerTxTimeMs;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public boolean isValid() {
        return (getControllerTxTimeMillis() == 0 && getControllerRxTimeMillis() == 0 && getControllerIdleTimeMillis() == 0) ? false : true;
    }

    public String toString() {
        return "BluetoothActivityEnergyInfo{ timestamp=" + this.timestamp + " mBluetoothStackState=" + this.mBluetoothStackState + " mControllerTxTimeMs=" + this.mControllerTxTimeMs + " mControllerRxTimeMs=" + this.mControllerRxTimeMs + " mControllerIdleTimeMs=" + this.mControllerIdleTimeMs + " mControllerEnergyUsed=" + this.mControllerEnergyUsed + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mBluetoothStackState);
        parcel.writeInt(this.mControllerTxTimeMs);
        parcel.writeInt(this.mControllerRxTimeMs);
        parcel.writeInt(this.mControllerIdleTimeMs);
        parcel.writeInt(this.mControllerEnergyUsed);
    }
}
