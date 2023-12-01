package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RssiPacketCountInfo.class */
public class RssiPacketCountInfo implements Parcelable {
    public static final Parcelable.Creator<RssiPacketCountInfo> CREATOR = new Parcelable.Creator<RssiPacketCountInfo>() { // from class: android.net.wifi.RssiPacketCountInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RssiPacketCountInfo createFromParcel(Parcel parcel) {
            return new RssiPacketCountInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RssiPacketCountInfo[] newArray(int i) {
            return new RssiPacketCountInfo[i];
        }
    };
    public int rssi;
    public int rxgood;
    public int txbad;
    public int txgood;

    public RssiPacketCountInfo() {
        this.rxgood = 0;
        this.txbad = 0;
        this.txgood = 0;
        this.rssi = 0;
    }

    private RssiPacketCountInfo(Parcel parcel) {
        this.rssi = parcel.readInt();
        this.txgood = parcel.readInt();
        this.txbad = parcel.readInt();
        this.rxgood = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.rssi);
        parcel.writeInt(this.txgood);
        parcel.writeInt(this.txbad);
        parcel.writeInt(this.rxgood);
    }
}
