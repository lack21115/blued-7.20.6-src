package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiActivityEnergyInfo.class */
public final class WifiActivityEnergyInfo implements Parcelable {
    public static final Parcelable.Creator<WifiActivityEnergyInfo> CREATOR = new Parcelable.Creator<WifiActivityEnergyInfo>() { // from class: android.net.wifi.WifiActivityEnergyInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiActivityEnergyInfo createFromParcel(Parcel parcel) {
            return new WifiActivityEnergyInfo(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiActivityEnergyInfo[] newArray(int i) {
            return new WifiActivityEnergyInfo[i];
        }
    };
    public static final int STACK_STATE_INVALID = 0;
    public static final int STACK_STATE_STATE_ACTIVE = 1;
    public static final int STACK_STATE_STATE_IDLE = 3;
    public static final int STACK_STATE_STATE_SCANNING = 2;
    private final int mControllerEnergyUsed;
    private final int mControllerIdleTimeMs;
    private final int mControllerRxTimeMs;
    private final int mControllerTxTimeMs;
    private final int mStackState;
    private final long timestamp = System.currentTimeMillis();

    public WifiActivityEnergyInfo(int i, int i2, int i3, int i4, int i5) {
        this.mStackState = i;
        this.mControllerTxTimeMs = i2;
        this.mControllerRxTimeMs = i3;
        this.mControllerIdleTimeMs = i4;
        this.mControllerEnergyUsed = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public int getStackState() {
        return this.mStackState;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public boolean isValid() {
        return (getControllerTxTimeMillis() == 0 && getControllerRxTimeMillis() == 0 && getControllerIdleTimeMillis() == 0) ? false : true;
    }

    public String toString() {
        return "WifiActivityEnergyInfo{ timestamp=" + this.timestamp + " mStackState=" + this.mStackState + " mControllerTxTimeMs=" + this.mControllerTxTimeMs + " mControllerRxTimeMs=" + this.mControllerRxTimeMs + " mControllerIdleTimeMs=" + this.mControllerIdleTimeMs + " mControllerEnergyUsed=" + this.mControllerEnergyUsed + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStackState);
        parcel.writeInt(this.mControllerTxTimeMs);
        parcel.writeInt(this.mControllerRxTimeMs);
        parcel.writeInt(this.mControllerIdleTimeMs);
        parcel.writeInt(this.mControllerEnergyUsed);
    }
}
