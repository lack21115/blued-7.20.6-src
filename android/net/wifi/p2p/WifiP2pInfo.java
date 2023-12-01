package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pInfo.class */
public class WifiP2pInfo implements Parcelable {
    public static final Parcelable.Creator<WifiP2pInfo> CREATOR = new Parcelable.Creator<WifiP2pInfo>() { // from class: android.net.wifi.p2p.WifiP2pInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pInfo createFromParcel(Parcel parcel) {
            WifiP2pInfo wifiP2pInfo = new WifiP2pInfo();
            wifiP2pInfo.groupFormed = parcel.readByte() == 1;
            boolean z = false;
            if (parcel.readByte() == 1) {
                z = true;
            }
            wifiP2pInfo.isGroupOwner = z;
            if (parcel.readByte() == 1) {
                try {
                    wifiP2pInfo.groupOwnerAddress = InetAddress.getByAddress(parcel.createByteArray());
                } catch (UnknownHostException e) {
                    return wifiP2pInfo;
                }
            }
            return wifiP2pInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pInfo[] newArray(int i) {
            return new WifiP2pInfo[i];
        }
    };
    public boolean groupFormed;
    public InetAddress groupOwnerAddress;
    public boolean isGroupOwner;

    public WifiP2pInfo() {
    }

    public WifiP2pInfo(WifiP2pInfo wifiP2pInfo) {
        if (wifiP2pInfo != null) {
            this.groupFormed = wifiP2pInfo.groupFormed;
            this.isGroupOwner = wifiP2pInfo.isGroupOwner;
            this.groupOwnerAddress = wifiP2pInfo.groupOwnerAddress;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("groupFormed: ").append(this.groupFormed).append(" isGroupOwner: ").append(this.isGroupOwner).append(" groupOwnerAddress: ").append(this.groupOwnerAddress);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.groupFormed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isGroupOwner ? (byte) 1 : (byte) 0);
        if (this.groupOwnerAddress == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeByteArray(this.groupOwnerAddress.getAddress());
    }
}
