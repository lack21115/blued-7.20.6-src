package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.system.OsConstants;
import android.util.Pair;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

/* loaded from: source-9557208-dex2jar.jar:android/net/LinkAddress.class */
public class LinkAddress implements Parcelable {
    public static final Parcelable.Creator<LinkAddress> CREATOR = new Parcelable.Creator<LinkAddress>() { // from class: android.net.LinkAddress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkAddress createFromParcel(Parcel parcel) {
            InetAddress inetAddress = null;
            try {
                inetAddress = InetAddress.getByAddress(parcel.createByteArray());
            } catch (UnknownHostException e) {
            }
            return new LinkAddress(inetAddress, parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkAddress[] newArray(int i) {
            return new LinkAddress[i];
        }
    };
    private InetAddress address;
    private int flags;
    private int prefixLength;
    private int scope;

    public LinkAddress(String str) {
        this(str, 0, 0);
        this.scope = scopeForUnicastAddress(this.address);
    }

    public LinkAddress(String str, int i, int i2) {
        Pair<InetAddress, Integer> parseIpAndMask = NetworkUtils.parseIpAndMask(str);
        init(parseIpAndMask.first, parseIpAndMask.second.intValue(), i, i2);
    }

    public LinkAddress(InetAddress inetAddress, int i) {
        this(inetAddress, i, 0, 0);
        this.scope = scopeForUnicastAddress(inetAddress);
    }

    public LinkAddress(InetAddress inetAddress, int i, int i2, int i3) {
        init(inetAddress, i, i2, i3);
    }

    public LinkAddress(InterfaceAddress interfaceAddress) {
        this(interfaceAddress.getAddress(), interfaceAddress.getNetworkPrefixLength());
    }

    private void init(InetAddress inetAddress, int i, int i2, int i3) {
        if (inetAddress == null || inetAddress.isMulticastAddress() || i < 0 || (((inetAddress instanceof Inet4Address) && i > 32) || i > 128)) {
            throw new IllegalArgumentException("Bad LinkAddress params " + inetAddress + BridgeUtil.SPLIT_MARK + i);
        }
        this.address = inetAddress;
        this.prefixLength = i;
        this.flags = i2;
        this.scope = i3;
    }

    private boolean isIPv6ULA() {
        boolean z = false;
        if (this.address != null) {
            z = false;
            if (this.address instanceof Inet6Address) {
                z = false;
                if ((this.address.getAddress()[0] & (-4)) == -4) {
                    z = true;
                }
            }
        }
        return z;
    }

    static int scopeForUnicastAddress(InetAddress inetAddress) {
        return inetAddress.isAnyLocalAddress() ? OsConstants.RT_SCOPE_HOST : (inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress()) ? OsConstants.RT_SCOPE_LINK : ((inetAddress instanceof Inet4Address) || !inetAddress.isSiteLocalAddress()) ? OsConstants.RT_SCOPE_UNIVERSE : OsConstants.RT_SCOPE_SITE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LinkAddress) {
            LinkAddress linkAddress = (LinkAddress) obj;
            return this.address.equals(linkAddress.address) && this.prefixLength == linkAddress.prefixLength && this.flags == linkAddress.flags && this.scope == linkAddress.scope;
        }
        return false;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getNetworkPrefixLength() {
        return getPrefixLength();
    }

    public int getPrefixLength() {
        return this.prefixLength;
    }

    public int getScope() {
        return this.scope;
    }

    public int hashCode() {
        return this.address.hashCode() + (this.prefixLength * 11) + (this.flags * 19) + (this.scope * 43);
    }

    public boolean isGlobalPreferred() {
        if (this.scope == OsConstants.RT_SCOPE_UNIVERSE && !isIPv6ULA() && (this.flags & (OsConstants.IFA_F_DADFAILED | OsConstants.IFA_F_DEPRECATED)) == 0) {
            return ((long) (this.flags & OsConstants.IFA_F_TENTATIVE)) == 0 || ((long) (this.flags & OsConstants.IFA_F_OPTIMISTIC)) != 0;
        }
        return false;
    }

    public boolean isSameAddressAs(LinkAddress linkAddress) {
        return this.address.equals(linkAddress.address) && this.prefixLength == linkAddress.prefixLength;
    }

    public String toString() {
        return this.address.getHostAddress() + BridgeUtil.SPLIT_MARK + this.prefixLength;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.address.getAddress());
        parcel.writeInt(this.prefixLength);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.scope);
    }
}
