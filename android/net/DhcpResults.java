package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/DhcpResults.class */
public class DhcpResults extends StaticIpConfiguration {
    public static final Parcelable.Creator<DhcpResults> CREATOR = new Parcelable.Creator<DhcpResults>() { // from class: android.net.DhcpResults.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DhcpResults createFromParcel(Parcel parcel) {
            DhcpResults dhcpResults = new DhcpResults();
            DhcpResults.readFromParcel(dhcpResults, parcel);
            return dhcpResults;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DhcpResults[] newArray(int i) {
            return new DhcpResults[i];
        }
    };
    private static final String TAG = "DhcpResults";
    public int leaseDuration;
    public InetAddress serverAddress;
    public String vendorInfo;

    public DhcpResults() {
    }

    public DhcpResults(DhcpResults dhcpResults) {
        super(dhcpResults);
        if (dhcpResults != null) {
            this.serverAddress = dhcpResults.serverAddress;
            this.vendorInfo = dhcpResults.vendorInfo;
            this.leaseDuration = dhcpResults.leaseDuration;
        }
    }

    public DhcpResults(StaticIpConfiguration staticIpConfiguration) {
        super(staticIpConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromParcel(DhcpResults dhcpResults, Parcel parcel) {
        StaticIpConfiguration.readFromParcel(dhcpResults, parcel);
        dhcpResults.leaseDuration = parcel.readInt();
        dhcpResults.serverAddress = NetworkUtils.unparcelInetAddress(parcel);
        dhcpResults.vendorInfo = parcel.readString();
    }

    public boolean addDns(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            this.dnsServers.add(NetworkUtils.numericToInetAddress(str));
            return false;
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "addDns failed with addrString " + str);
            return true;
        }
    }

    @Override // android.net.StaticIpConfiguration
    public void clear() {
        super.clear();
        this.vendorInfo = null;
        this.leaseDuration = 0;
    }

    @Override // android.net.StaticIpConfiguration
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DhcpResults) {
            DhcpResults dhcpResults = (DhcpResults) obj;
            return super.equals((StaticIpConfiguration) obj) && Objects.equals(this.serverAddress, dhcpResults.serverAddress) && Objects.equals(this.vendorInfo, dhcpResults.vendorInfo) && this.leaseDuration == dhcpResults.leaseDuration;
        }
        return false;
    }

    public boolean hasMeteredHint() {
        if (this.vendorInfo != null) {
            return this.vendorInfo.contains("ANDROID_METERED");
        }
        return false;
    }

    public void setDomains(String str) {
        this.domains = str;
    }

    public boolean setGateway(String str) {
        try {
            this.gateway = NetworkUtils.numericToInetAddress(str);
            return false;
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "setGateway failed with addrString " + str);
            return true;
        }
    }

    public boolean setIpAddress(String str, int i) {
        try {
            this.ipAddress = new LinkAddress((Inet4Address) NetworkUtils.numericToInetAddress(str), i);
            return false;
        } catch (ClassCastException | IllegalArgumentException e) {
            Log.e(TAG, "setIpAddress failed with addrString " + str + "/" + i);
            return true;
        }
    }

    public void setLeaseDuration(int i) {
        this.leaseDuration = i;
    }

    public boolean setServerAddress(String str) {
        try {
            this.serverAddress = NetworkUtils.numericToInetAddress(str);
            return false;
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "setServerAddress failed with addrString " + str);
            return true;
        }
    }

    public void setVendorInfo(String str) {
        this.vendorInfo = str;
    }

    @Override // android.net.StaticIpConfiguration
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.toString());
        stringBuffer.append(" DHCP server ").append(this.serverAddress);
        stringBuffer.append(" Vendor info ").append(this.vendorInfo);
        stringBuffer.append(" lease ").append(this.leaseDuration).append(" seconds");
        return stringBuffer.toString();
    }

    public void updateFromDhcpRequest(DhcpResults dhcpResults) {
        if (dhcpResults == null) {
            return;
        }
        if (this.gateway == null) {
            this.gateway = dhcpResults.gateway;
        }
        if (this.dnsServers.size() == 0) {
            this.dnsServers.addAll(dhcpResults.dnsServers);
        }
    }

    @Override // android.net.StaticIpConfiguration, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.leaseDuration);
        NetworkUtils.parcelInetAddress(parcel, this.serverAddress, i);
        parcel.writeString(this.vendorInfo);
    }
}
