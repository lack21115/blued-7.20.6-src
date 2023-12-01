package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/IpConfiguration.class */
public class IpConfiguration implements Parcelable {
    public static final Parcelable.Creator<IpConfiguration> CREATOR = new Parcelable.Creator<IpConfiguration>() { // from class: android.net.IpConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpConfiguration createFromParcel(Parcel parcel) {
            IpConfiguration ipConfiguration = new IpConfiguration();
            ipConfiguration.ipAssignment = IpAssignment.valueOf(parcel.readString());
            ipConfiguration.proxySettings = ProxySettings.valueOf(parcel.readString());
            ipConfiguration.staticIpConfiguration = (StaticIpConfiguration) parcel.readParcelable(null);
            ipConfiguration.httpProxy = (ProxyInfo) parcel.readParcelable(null);
            return ipConfiguration;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpConfiguration[] newArray(int i) {
            return new IpConfiguration[i];
        }
    };
    private static final String TAG = "IpConfiguration";
    public ProxyInfo httpProxy;
    public IpAssignment ipAssignment;
    public ProxySettings proxySettings;
    public StaticIpConfiguration staticIpConfiguration;

    /* loaded from: source-9557208-dex2jar.jar:android/net/IpConfiguration$IpAssignment.class */
    public enum IpAssignment {
        STATIC,
        DHCP,
        UNASSIGNED
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/IpConfiguration$ProxySettings.class */
    public enum ProxySettings {
        NONE,
        STATIC,
        UNASSIGNED,
        PAC
    }

    public IpConfiguration() {
        init(IpAssignment.UNASSIGNED, ProxySettings.UNASSIGNED, null, null);
    }

    public IpConfiguration(IpAssignment ipAssignment, ProxySettings proxySettings, StaticIpConfiguration staticIpConfiguration, ProxyInfo proxyInfo) {
        init(ipAssignment, proxySettings, staticIpConfiguration, proxyInfo);
    }

    public IpConfiguration(IpConfiguration ipConfiguration) {
        this();
        if (ipConfiguration != null) {
            init(ipConfiguration.ipAssignment, ipConfiguration.proxySettings, ipConfiguration.staticIpConfiguration, ipConfiguration.httpProxy);
        }
    }

    private void init(IpAssignment ipAssignment, ProxySettings proxySettings, StaticIpConfiguration staticIpConfiguration, ProxyInfo proxyInfo) {
        this.ipAssignment = ipAssignment;
        this.proxySettings = proxySettings;
        this.staticIpConfiguration = staticIpConfiguration == null ? null : new StaticIpConfiguration(staticIpConfiguration);
        this.httpProxy = proxyInfo == null ? null : new ProxyInfo(proxyInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IpConfiguration) {
            IpConfiguration ipConfiguration = (IpConfiguration) obj;
            return this.ipAssignment == ipConfiguration.ipAssignment && this.proxySettings == ipConfiguration.proxySettings && Objects.equals(this.staticIpConfiguration, ipConfiguration.staticIpConfiguration) && Objects.equals(this.httpProxy, ipConfiguration.httpProxy);
        }
        return false;
    }

    public ProxyInfo getHttpProxy() {
        return this.httpProxy;
    }

    public IpAssignment getIpAssignment() {
        return this.ipAssignment;
    }

    public ProxySettings getProxySettings() {
        return this.proxySettings;
    }

    public StaticIpConfiguration getStaticIpConfiguration() {
        return this.staticIpConfiguration;
    }

    public int hashCode() {
        return (this.staticIpConfiguration != null ? this.staticIpConfiguration.hashCode() : 0) + 13 + (this.ipAssignment.ordinal() * 17) + (this.proxySettings.ordinal() * 47) + (this.httpProxy.hashCode() * 83);
    }

    public void setHttpProxy(ProxyInfo proxyInfo) {
        this.httpProxy = proxyInfo;
    }

    public void setIpAssignment(IpAssignment ipAssignment) {
        this.ipAssignment = ipAssignment;
    }

    public void setProxySettings(ProxySettings proxySettings) {
        this.proxySettings = proxySettings;
    }

    public void setStaticIpConfiguration(StaticIpConfiguration staticIpConfiguration) {
        this.staticIpConfiguration = staticIpConfiguration;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IP assignment: " + this.ipAssignment.toString());
        sb.append("\n");
        if (this.staticIpConfiguration != null) {
            sb.append("Static configuration: " + this.staticIpConfiguration.toString());
            sb.append("\n");
        }
        sb.append("Proxy settings: " + this.proxySettings.toString());
        sb.append("\n");
        if (this.httpProxy != null) {
            sb.append("HTTP proxy: " + this.httpProxy.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ipAssignment.name());
        parcel.writeString(this.proxySettings.name());
        parcel.writeParcelable(this.staticIpConfiguration, i);
        parcel.writeParcelable(this.httpProxy, i);
    }
}
