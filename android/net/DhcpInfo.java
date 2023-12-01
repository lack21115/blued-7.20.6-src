package android.net;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/DhcpInfo.class */
public class DhcpInfo implements Parcelable {
    public static final Parcelable.Creator<DhcpInfo> CREATOR = new Parcelable.Creator<DhcpInfo>() { // from class: android.net.DhcpInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DhcpInfo createFromParcel(Parcel parcel) {
            DhcpInfo dhcpInfo = new DhcpInfo();
            dhcpInfo.ipAddress = parcel.readInt();
            dhcpInfo.gateway = parcel.readInt();
            dhcpInfo.netmask = parcel.readInt();
            dhcpInfo.dns1 = parcel.readInt();
            dhcpInfo.dns2 = parcel.readInt();
            dhcpInfo.serverAddress = parcel.readInt();
            dhcpInfo.leaseDuration = parcel.readInt();
            return dhcpInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DhcpInfo[] newArray(int i) {
            return new DhcpInfo[i];
        }
    };
    public int dns1;
    public int dns2;
    public int gateway;
    public int ipAddress;
    public int leaseDuration;
    public int netmask;
    public int serverAddress;

    public DhcpInfo() {
    }

    public DhcpInfo(DhcpInfo dhcpInfo) {
        if (dhcpInfo != null) {
            this.ipAddress = dhcpInfo.ipAddress;
            this.gateway = dhcpInfo.gateway;
            this.netmask = dhcpInfo.netmask;
            this.dns1 = dhcpInfo.dns1;
            this.dns2 = dhcpInfo.dns2;
            this.serverAddress = dhcpInfo.serverAddress;
            this.leaseDuration = dhcpInfo.leaseDuration;
        }
    }

    private static void putAddress(StringBuffer stringBuffer, int i) {
        stringBuffer.append(NetworkUtils.intToInetAddress(i).getHostAddress());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ipaddr ");
        putAddress(stringBuffer, this.ipAddress);
        stringBuffer.append(" gateway ");
        putAddress(stringBuffer, this.gateway);
        stringBuffer.append(" netmask ");
        putAddress(stringBuffer, this.netmask);
        stringBuffer.append(" dns1 ");
        putAddress(stringBuffer, this.dns1);
        stringBuffer.append(" dns2 ");
        putAddress(stringBuffer, this.dns2);
        stringBuffer.append(" DHCP server ");
        putAddress(stringBuffer, this.serverAddress);
        stringBuffer.append(" lease ").append(this.leaseDuration).append(" seconds");
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ipAddress);
        parcel.writeInt(this.gateway);
        parcel.writeInt(this.netmask);
        parcel.writeInt(this.dns1);
        parcel.writeInt(this.dns2);
        parcel.writeInt(this.serverAddress);
        parcel.writeInt(this.leaseDuration);
    }
}
