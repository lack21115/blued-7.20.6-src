package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/RouteInfo.class */
public final class RouteInfo implements Parcelable {
    public static final Parcelable.Creator<RouteInfo> CREATOR = new Parcelable.Creator<RouteInfo>() { // from class: android.net.RouteInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteInfo createFromParcel(Parcel parcel) {
            IpPrefix ipPrefix = (IpPrefix) parcel.readParcelable(null);
            InetAddress inetAddress = null;
            try {
                inetAddress = InetAddress.getByAddress(parcel.createByteArray());
            } catch (UnknownHostException e) {
            }
            return new RouteInfo(ipPrefix, inetAddress, parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteInfo[] newArray(int i) {
            return new RouteInfo[i];
        }
    };
    public static final int RTN_THROW = 9;
    public static final int RTN_UNICAST = 1;
    public static final int RTN_UNREACHABLE = 7;
    private final IpPrefix mDestination;
    private final InetAddress mGateway;
    private final boolean mHasGateway;
    private final String mInterface;
    private final boolean mIsHost;
    private final int mType;

    public RouteInfo(IpPrefix ipPrefix) {
        this(ipPrefix, (InetAddress) null, (String) null);
    }

    public RouteInfo(IpPrefix ipPrefix, int i) {
        this(ipPrefix, null, null, i);
    }

    public RouteInfo(IpPrefix ipPrefix, InetAddress inetAddress) {
        this(ipPrefix, inetAddress, (String) null);
    }

    public RouteInfo(IpPrefix ipPrefix, InetAddress inetAddress, String str) {
        this(ipPrefix, inetAddress, str, 1);
    }

    public RouteInfo(IpPrefix ipPrefix, InetAddress inetAddress, String str, int i) {
        boolean z = false;
        switch (i) {
            case 1:
            case 7:
            case 9:
                IpPrefix ipPrefix2 = ipPrefix;
                if (ipPrefix == null) {
                    if (inetAddress == null) {
                        throw new IllegalArgumentException("Invalid arguments passed in: " + inetAddress + "," + ipPrefix);
                    }
                    ipPrefix2 = inetAddress instanceof Inet4Address ? new IpPrefix(Inet4Address.ANY, 0) : new IpPrefix(Inet6Address.ANY, 0);
                }
                InetAddress inetAddress2 = inetAddress == null ? ipPrefix2.getAddress() instanceof Inet4Address ? Inet4Address.ANY : Inet6Address.ANY : inetAddress;
                this.mHasGateway = inetAddress2.isAnyLocalAddress() ? z : true;
                if (((ipPrefix2.getAddress() instanceof Inet4Address) && !(inetAddress2 instanceof Inet4Address)) || ((ipPrefix2.getAddress() instanceof Inet6Address) && !(inetAddress2 instanceof Inet6Address))) {
                    throw new IllegalArgumentException("address family mismatch in RouteInfo constructor");
                }
                this.mDestination = ipPrefix2;
                this.mGateway = inetAddress2;
                this.mInterface = str;
                this.mType = i;
                this.mIsHost = isHost();
                return;
            default:
                throw new IllegalArgumentException("Unknown route type " + i);
        }
    }

    public RouteInfo(LinkAddress linkAddress) {
        this(linkAddress, (InetAddress) null, (String) null);
    }

    public RouteInfo(LinkAddress linkAddress, InetAddress inetAddress) {
        this(linkAddress, inetAddress, (String) null);
    }

    public RouteInfo(LinkAddress linkAddress, InetAddress inetAddress, String str) {
        this(linkAddress == null ? null : new IpPrefix(linkAddress.getAddress(), linkAddress.getPrefixLength()), inetAddress, str);
    }

    public RouteInfo(InetAddress inetAddress) {
        this((IpPrefix) null, inetAddress, (String) null);
    }

    private boolean isHost() {
        if ((this.mDestination.getAddress() instanceof Inet4Address) && this.mDestination.getPrefixLength() == 32) {
            return true;
        }
        return (this.mDestination.getAddress() instanceof Inet6Address) && this.mDestination.getPrefixLength() == 128;
    }

    public static RouteInfo makeHostRoute(InetAddress inetAddress, String str) {
        return makeHostRoute(inetAddress, null, str);
    }

    public static RouteInfo makeHostRoute(InetAddress inetAddress, InetAddress inetAddress2, String str) {
        if (inetAddress == null) {
            return null;
        }
        return inetAddress instanceof Inet4Address ? new RouteInfo(new IpPrefix(inetAddress, 32), inetAddress2, str) : new RouteInfo(new IpPrefix(inetAddress, 128), inetAddress2, str);
    }

    public static RouteInfo selectBestRoute(Collection<RouteInfo> collection, InetAddress inetAddress) {
        RouteInfo routeInfo;
        if (collection != null && inetAddress != null) {
            Iterator<RouteInfo> it = collection.iterator();
            RouteInfo routeInfo2 = null;
            while (true) {
                routeInfo = routeInfo2;
                if (!it.hasNext()) {
                    break;
                }
                RouteInfo next = it.next();
                if (NetworkUtils.addressTypeMatches(next.mDestination.getAddress(), inetAddress) && (routeInfo2 == null || routeInfo2.mDestination.getPrefixLength() < next.mDestination.getPrefixLength())) {
                    if (next.matches(inetAddress)) {
                        routeInfo2 = next;
                    }
                }
            }
        } else {
            routeInfo = null;
        }
        return routeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RouteInfo) {
            RouteInfo routeInfo = (RouteInfo) obj;
            return Objects.equals(this.mDestination, routeInfo.getDestination()) && Objects.equals(this.mGateway, routeInfo.getGateway()) && Objects.equals(this.mInterface, routeInfo.getInterface()) && this.mType == routeInfo.getType();
        }
        return false;
    }

    public IpPrefix getDestination() {
        return this.mDestination;
    }

    public LinkAddress getDestinationLinkAddress() {
        return new LinkAddress(this.mDestination.getAddress(), this.mDestination.getPrefixLength());
    }

    public InetAddress getGateway() {
        return this.mGateway;
    }

    public String getInterface() {
        return this.mInterface;
    }

    public int getType() {
        return this.mType;
    }

    public boolean hasGateway() {
        return this.mHasGateway;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mDestination.hashCode();
        int hashCode2 = this.mGateway == null ? 0 : this.mGateway.hashCode() * 47;
        if (this.mInterface != null) {
            i = this.mInterface.hashCode() * 67;
        }
        return hashCode2 + (hashCode * 41) + i + (this.mType * 71);
    }

    public boolean isDefaultRoute() {
        return this.mType == 1 && this.mDestination.getPrefixLength() == 0;
    }

    public boolean isHostRoute() {
        return this.mIsHost;
    }

    public boolean isIPv4Default() {
        return isDefaultRoute() && (this.mDestination.getAddress() instanceof Inet4Address);
    }

    public boolean isIPv6Default() {
        return isDefaultRoute() && (this.mDestination.getAddress() instanceof Inet6Address);
    }

    public boolean matches(InetAddress inetAddress) {
        if (inetAddress == null) {
            return false;
        }
        return this.mDestination.getAddress().equals(NetworkUtils.getNetworkPart(inetAddress, this.mDestination.getPrefixLength()));
    }

    public String toString() {
        String str;
        String ipPrefix = this.mDestination != null ? this.mDestination.toString() : "";
        if (this.mType == 7) {
            str = ipPrefix + " unreachable";
        } else if (this.mType == 9) {
            return ipPrefix + " throw";
        } else {
            String str2 = ipPrefix + " ->";
            String str3 = str2;
            if (this.mGateway != null) {
                str3 = str2 + " " + this.mGateway.getHostAddress();
            }
            String str4 = str3;
            if (this.mInterface != null) {
                str4 = str3 + " " + this.mInterface;
            }
            str = str4;
            if (this.mType != 1) {
                return str4 + " unknown type " + this.mType;
            }
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mDestination, i);
        parcel.writeByteArray(this.mGateway == null ? null : this.mGateway.getAddress());
        parcel.writeString(this.mInterface);
        parcel.writeInt(this.mType);
    }
}
