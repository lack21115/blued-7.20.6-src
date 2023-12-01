package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/DataConnectionRealTimeInfo.class */
public class DataConnectionRealTimeInfo implements Parcelable {
    private int mDcPowerState;
    private long mTime;
    public static int DC_POWER_STATE_LOW = 1;
    public static int DC_POWER_STATE_MEDIUM = 2;
    public static int DC_POWER_STATE_HIGH = 3;
    public static int DC_POWER_STATE_UNKNOWN = Integer.MAX_VALUE;
    public static final Parcelable.Creator<DataConnectionRealTimeInfo> CREATOR = new Parcelable.Creator<DataConnectionRealTimeInfo>() { // from class: android.telephony.DataConnectionRealTimeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataConnectionRealTimeInfo createFromParcel(Parcel parcel) {
            return new DataConnectionRealTimeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataConnectionRealTimeInfo[] newArray(int i) {
            return new DataConnectionRealTimeInfo[i];
        }
    };

    public DataConnectionRealTimeInfo() {
        this.mTime = Long.MAX_VALUE;
        this.mDcPowerState = DC_POWER_STATE_UNKNOWN;
    }

    public DataConnectionRealTimeInfo(long j, int i) {
        this.mTime = j;
        this.mDcPowerState = i;
    }

    private DataConnectionRealTimeInfo(Parcel parcel) {
        this.mTime = parcel.readLong();
        this.mDcPowerState = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DataConnectionRealTimeInfo dataConnectionRealTimeInfo = (DataConnectionRealTimeInfo) obj;
            return this.mTime == dataConnectionRealTimeInfo.mTime && this.mDcPowerState == dataConnectionRealTimeInfo.mDcPowerState;
        }
        return false;
    }

    public int getDcPowerState() {
        return this.mDcPowerState;
    }

    public long getTime() {
        return this.mTime;
    }

    public int hashCode() {
        long j = (17 * 1) + this.mTime;
        return (int) (j + (17 * j) + this.mDcPowerState);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mTime=").append(this.mTime);
        stringBuffer.append(" mDcPowerState=").append(this.mDcPowerState);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mTime);
        parcel.writeInt(this.mDcPowerState);
    }
}
