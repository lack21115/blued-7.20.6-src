package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/LinkProperties.class */
public final class LinkProperties implements Parcelable {
    public static final Parcelable.Creator<LinkProperties> CREATOR = new Parcelable.Creator<LinkProperties>() { // from class: android.net.LinkProperties.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkProperties createFromParcel(Parcel parcel) {
            LinkProperties linkProperties = new LinkProperties();
            String readString = parcel.readString();
            if (readString != null) {
                linkProperties.setInterfaceName(readString);
            }
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                linkProperties.addLinkAddress((LinkAddress) parcel.readParcelable(null));
                i = i2 + 1;
            }
            int readInt2 = parcel.readInt();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt2) {
                    break;
                }
                try {
                    linkProperties.addDnsServer(InetAddress.getByAddress(parcel.createByteArray()));
                } catch (UnknownHostException e) {
                }
                i3 = i4 + 1;
            }
            linkProperties.setDomains(parcel.readString());
            linkProperties.setMtu(parcel.readInt());
            linkProperties.setTcpBufferSizes(parcel.readString());
            int readInt3 = parcel.readInt();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= readInt3) {
                    break;
                }
                linkProperties.addRoute((RouteInfo) parcel.readParcelable(null));
                i5 = i6 + 1;
            }
            if (parcel.readByte() == 1) {
                linkProperties.setHttpProxy((ProxyInfo) parcel.readParcelable(null));
            }
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, LinkProperties.class.getClassLoader());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkProperties.addStackedLink((LinkProperties) it.next());
            }
            return linkProperties;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkProperties[] newArray(int i) {
            return new LinkProperties[i];
        }
    };
    private static final int MAX_MTU = 10000;
    private static final int MIN_MTU = 68;
    private static final int MIN_MTU_V6 = 1280;
    private String mDomains;
    private ProxyInfo mHttpProxy;
    private String mIfaceName;
    private int mMtu;
    private String mTcpBufferSizes;
    private ArrayList<LinkAddress> mLinkAddresses = new ArrayList<>();
    private ArrayList<InetAddress> mDnses = new ArrayList<>();
    private ArrayList<RouteInfo> mRoutes = new ArrayList<>();
    private Hashtable<String, LinkProperties> mStackedLinks = new Hashtable<>();

    /* loaded from: source-9557208-dex2jar.jar:android/net/LinkProperties$CompareResult.class */
    public static class CompareResult<T> {
        public List<T> removed = new ArrayList();
        public List<T> added = new ArrayList();

        public String toString() {
            Iterator<T> it;
            Iterator<T> it2;
            String str = "removed=[";
            while (this.removed.iterator().hasNext()) {
                str = str + it.next().toString() + ",";
            }
            String str2 = str + "] added=[";
            while (this.added.iterator().hasNext()) {
                str2 = str2 + it2.next().toString() + ",";
            }
            return str2 + "]";
        }
    }

    public LinkProperties() {
    }

    public LinkProperties(LinkProperties linkProperties) {
        if (linkProperties != null) {
            this.mIfaceName = linkProperties.getInterfaceName();
            for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                this.mLinkAddresses.add(linkAddress);
            }
            for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                this.mDnses.add(inetAddress);
            }
            this.mDomains = linkProperties.getDomains();
            for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                this.mRoutes.add(routeInfo);
            }
            this.mHttpProxy = linkProperties.getHttpProxy() == null ? null : new ProxyInfo(linkProperties.getHttpProxy());
            for (LinkProperties linkProperties2 : linkProperties.mStackedLinks.values()) {
                addStackedLink(linkProperties2);
            }
            setMtu(linkProperties.getMtu());
            this.mTcpBufferSizes = linkProperties.mTcpBufferSizes;
        }
    }

    private int findLinkAddressIndex(LinkAddress linkAddress) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mLinkAddresses.size()) {
                return -1;
            }
            if (this.mLinkAddresses.get(i2).isSameAddressAs(linkAddress)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private boolean hasIPv4() {
        return hasIPv4Address() && hasIPv4DefaultRoute() && hasIPv4DnsServer();
    }

    private boolean hasIPv6() {
        return hasGlobalIPv6Address() && hasIPv6DefaultRoute() && hasIPv6DnsServer();
    }

    public static boolean isValidMtu(int i, boolean z) {
        return z ? i >= 1280 && i <= 10000 : i >= 68 && i <= 10000;
    }

    private RouteInfo routeWithInterface(RouteInfo routeInfo) {
        return new RouteInfo(routeInfo.getDestination(), routeInfo.getGateway(), this.mIfaceName, routeInfo.getType());
    }

    public boolean addDnsServer(InetAddress inetAddress) {
        if (inetAddress == null || this.mDnses.contains(inetAddress)) {
            return false;
        }
        this.mDnses.add(inetAddress);
        return true;
    }

    public boolean addLinkAddress(LinkAddress linkAddress) {
        if (linkAddress == null) {
            return false;
        }
        int findLinkAddressIndex = findLinkAddressIndex(linkAddress);
        if (findLinkAddressIndex < 0) {
            this.mLinkAddresses.add(linkAddress);
            return true;
        } else if (this.mLinkAddresses.get(findLinkAddressIndex).equals(linkAddress)) {
            return false;
        } else {
            this.mLinkAddresses.set(findLinkAddressIndex, linkAddress);
            return true;
        }
    }

    public boolean addRoute(RouteInfo routeInfo) {
        if (routeInfo != null) {
            String str = routeInfo.getInterface();
            if (str == null || str.equals(this.mIfaceName)) {
                RouteInfo routeWithInterface = routeWithInterface(routeInfo);
                if (this.mRoutes.contains(routeWithInterface)) {
                    return false;
                }
                this.mRoutes.add(routeWithInterface);
                return true;
            }
            throw new IllegalArgumentException("Route added with non-matching interface: " + str + " vs. " + this.mIfaceName);
        }
        return false;
    }

    public boolean addStackedLink(LinkProperties linkProperties) {
        if (linkProperties == null || linkProperties.getInterfaceName() == null) {
            return false;
        }
        this.mStackedLinks.put(linkProperties.getInterfaceName(), linkProperties);
        return true;
    }

    public void clear() {
        this.mIfaceName = null;
        this.mLinkAddresses.clear();
        this.mDnses.clear();
        this.mDomains = null;
        this.mRoutes.clear();
        this.mHttpProxy = null;
        this.mStackedLinks.clear();
        this.mMtu = 0;
        this.mTcpBufferSizes = null;
    }

    public CompareResult<LinkAddress> compareAddresses(LinkProperties linkProperties) {
        CompareResult<LinkAddress> compareResult = new CompareResult<>();
        compareResult.removed = new ArrayList(this.mLinkAddresses);
        compareResult.added.clear();
        if (linkProperties != null) {
            for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                if (!compareResult.removed.remove(linkAddress)) {
                    compareResult.added.add(linkAddress);
                }
            }
        }
        return compareResult;
    }

    public CompareResult<String> compareAllInterfaceNames(LinkProperties linkProperties) {
        CompareResult<String> compareResult = new CompareResult<>();
        compareResult.removed = getAllInterfaceNames();
        compareResult.added.clear();
        if (linkProperties != null) {
            for (String str : linkProperties.getAllInterfaceNames()) {
                if (!compareResult.removed.remove(str)) {
                    compareResult.added.add(str);
                }
            }
        }
        return compareResult;
    }

    public CompareResult<RouteInfo> compareAllRoutes(LinkProperties linkProperties) {
        CompareResult<RouteInfo> compareResult = new CompareResult<>();
        compareResult.removed = getAllRoutes();
        compareResult.added.clear();
        if (linkProperties != null) {
            for (RouteInfo routeInfo : linkProperties.getAllRoutes()) {
                if (!compareResult.removed.remove(routeInfo)) {
                    compareResult.added.add(routeInfo);
                }
            }
        }
        return compareResult;
    }

    public CompareResult<InetAddress> compareDnses(LinkProperties linkProperties) {
        CompareResult<InetAddress> compareResult = new CompareResult<>();
        compareResult.removed = new ArrayList(this.mDnses);
        compareResult.added.clear();
        if (linkProperties != null) {
            for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                if (!compareResult.removed.remove(inetAddress)) {
                    compareResult.added.add(inetAddress);
                }
            }
        }
        return compareResult;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LinkProperties) {
            LinkProperties linkProperties = (LinkProperties) obj;
            return isIdenticalInterfaceName(linkProperties) && isIdenticalAddresses(linkProperties) && isIdenticalDnses(linkProperties) && isIdenticalRoutes(linkProperties) && isIdenticalHttpProxy(linkProperties) && isIdenticalStackedLinks(linkProperties) && isIdenticalMtu(linkProperties) && isIdenticalTcpBufferSizes(linkProperties);
        }
        return false;
    }

    public List<InetAddress> getAddresses() {
        ArrayList arrayList = new ArrayList();
        Iterator<LinkAddress> it = this.mLinkAddresses.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAddress());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<InetAddress> getAllAddresses() {
        ArrayList arrayList = new ArrayList();
        Iterator<LinkAddress> it = this.mLinkAddresses.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAddress());
        }
        for (LinkProperties linkProperties : this.mStackedLinks.values()) {
            arrayList.addAll(linkProperties.getAllAddresses());
        }
        return arrayList;
    }

    public List<String> getAllInterfaceNames() {
        ArrayList arrayList = new ArrayList(this.mStackedLinks.size() + 1);
        if (this.mIfaceName != null) {
            arrayList.add(new String(this.mIfaceName));
        }
        for (LinkProperties linkProperties : this.mStackedLinks.values()) {
            arrayList.addAll(linkProperties.getAllInterfaceNames());
        }
        return arrayList;
    }

    public List<LinkAddress> getAllLinkAddresses() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mLinkAddresses);
        for (LinkProperties linkProperties : this.mStackedLinks.values()) {
            arrayList.addAll(linkProperties.getAllLinkAddresses());
        }
        return arrayList;
    }

    public List<RouteInfo> getAllRoutes() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mRoutes);
        for (LinkProperties linkProperties : this.mStackedLinks.values()) {
            arrayList.addAll(linkProperties.getAllRoutes());
        }
        return arrayList;
    }

    public List<InetAddress> getDnsServers() {
        return Collections.unmodifiableList(this.mDnses);
    }

    public String getDomains() {
        return this.mDomains;
    }

    public ProxyInfo getHttpProxy() {
        return this.mHttpProxy;
    }

    public String getInterfaceName() {
        return this.mIfaceName;
    }

    public List<LinkAddress> getLinkAddresses() {
        return Collections.unmodifiableList(this.mLinkAddresses);
    }

    public int getMtu() {
        return this.mMtu;
    }

    public List<RouteInfo> getRoutes() {
        return Collections.unmodifiableList(this.mRoutes);
    }

    public List<LinkProperties> getStackedLinks() {
        if (this.mStackedLinks.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (LinkProperties linkProperties : this.mStackedLinks.values()) {
            arrayList.add(new LinkProperties(linkProperties));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String getTcpBufferSizes() {
        return this.mTcpBufferSizes;
    }

    public boolean hasGlobalIPv6Address() {
        Iterator<LinkAddress> it = this.mLinkAddresses.iterator();
        while (it.hasNext()) {
            LinkAddress next = it.next();
            if (next != null && (next.getAddress() instanceof Inet6Address) && next.isGlobalPreferred()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasIPv4Address() {
        Iterator<LinkAddress> it = this.mLinkAddresses.iterator();
        while (it.hasNext()) {
            LinkAddress next = it.next();
            if (next != null && (next.getAddress() instanceof Inet4Address)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasIPv4DefaultRoute() {
        Iterator<RouteInfo> it = this.mRoutes.iterator();
        while (it.hasNext()) {
            if (it.next().isIPv4Default()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasIPv4DnsServer() {
        Iterator<InetAddress> it = this.mDnses.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Inet4Address) {
                return true;
            }
        }
        return false;
    }

    public boolean hasIPv6DefaultRoute() {
        Iterator<RouteInfo> it = this.mRoutes.iterator();
        while (it.hasNext()) {
            if (it.next().isIPv6Default()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasIPv6DnsServer() {
        Iterator<InetAddress> it = this.mDnses.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Inet6Address) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        if (this.mIfaceName == null) {
            hashCode = 0;
        } else {
            int hashCode2 = this.mIfaceName.hashCode();
            int size = this.mLinkAddresses.size();
            int size2 = this.mDnses.size();
            hashCode = (this.mHttpProxy == null ? 0 : this.mHttpProxy.hashCode()) + (this.mRoutes.size() * 41) + (this.mDomains == null ? 0 : this.mDomains.hashCode()) + (size2 * 37) + hashCode2 + (size * 31) + (this.mStackedLinks.hashCode() * 47);
        }
        return hashCode + (this.mMtu * 51) + (this.mTcpBufferSizes == null ? 0 : this.mTcpBufferSizes.hashCode());
    }

    public boolean isIdenticalAddresses(LinkProperties linkProperties) {
        List<InetAddress> addresses = linkProperties.getAddresses();
        List<InetAddress> addresses2 = getAddresses();
        if (addresses2.size() == addresses.size()) {
            return addresses2.containsAll(addresses);
        }
        return false;
    }

    public boolean isIdenticalDnses(LinkProperties linkProperties) {
        List<InetAddress> dnsServers = linkProperties.getDnsServers();
        String domains = linkProperties.getDomains();
        if (this.mDomains == null) {
            if (domains != null) {
                return false;
            }
        } else if (!this.mDomains.equals(domains)) {
            return false;
        }
        if (this.mDnses.size() == dnsServers.size()) {
            return this.mDnses.containsAll(dnsServers);
        }
        return false;
    }

    public boolean isIdenticalHttpProxy(LinkProperties linkProperties) {
        return getHttpProxy() == null ? linkProperties.getHttpProxy() == null : getHttpProxy().equals(linkProperties.getHttpProxy());
    }

    public boolean isIdenticalInterfaceName(LinkProperties linkProperties) {
        return TextUtils.equals(getInterfaceName(), linkProperties.getInterfaceName());
    }

    public boolean isIdenticalMtu(LinkProperties linkProperties) {
        return getMtu() == linkProperties.getMtu();
    }

    public boolean isIdenticalRoutes(LinkProperties linkProperties) {
        List<RouteInfo> routes = linkProperties.getRoutes();
        if (this.mRoutes.size() == routes.size()) {
            return this.mRoutes.containsAll(routes);
        }
        return false;
    }

    public boolean isIdenticalStackedLinks(LinkProperties linkProperties) {
        if (this.mStackedLinks.keySet().equals(linkProperties.mStackedLinks.keySet())) {
            for (LinkProperties linkProperties2 : this.mStackedLinks.values()) {
                if (!linkProperties2.equals(linkProperties.mStackedLinks.get(linkProperties2.getInterfaceName()))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isIdenticalTcpBufferSizes(LinkProperties linkProperties) {
        return Objects.equals(this.mTcpBufferSizes, linkProperties.mTcpBufferSizes);
    }

    public boolean isProvisioned() {
        return hasIPv4() || hasIPv6();
    }

    public boolean removeLinkAddress(LinkAddress linkAddress) {
        int findLinkAddressIndex = findLinkAddressIndex(linkAddress);
        if (findLinkAddressIndex >= 0) {
            this.mLinkAddresses.remove(findLinkAddressIndex);
            return true;
        }
        return false;
    }

    public boolean removeRoute(RouteInfo routeInfo) {
        return routeInfo != null && Objects.equals(this.mIfaceName, routeInfo.getInterface()) && this.mRoutes.remove(routeInfo);
    }

    public boolean removeStackedLink(String str) {
        boolean z = false;
        if (str != null) {
            z = false;
            if (this.mStackedLinks.remove(str) != null) {
                z = true;
            }
        }
        return z;
    }

    public void setDnsServers(Collection<InetAddress> collection) {
        this.mDnses.clear();
        for (InetAddress inetAddress : collection) {
            addDnsServer(inetAddress);
        }
    }

    public void setDomains(String str) {
        this.mDomains = str;
    }

    public void setHttpProxy(ProxyInfo proxyInfo) {
        this.mHttpProxy = proxyInfo;
    }

    public void setInterfaceName(String str) {
        this.mIfaceName = str;
        ArrayList<RouteInfo> arrayList = new ArrayList<>(this.mRoutes.size());
        Iterator<RouteInfo> it = this.mRoutes.iterator();
        while (it.hasNext()) {
            arrayList.add(routeWithInterface(it.next()));
        }
        this.mRoutes = arrayList;
    }

    public void setLinkAddresses(Collection<LinkAddress> collection) {
        this.mLinkAddresses.clear();
        for (LinkAddress linkAddress : collection) {
            addLinkAddress(linkAddress);
        }
    }

    public void setMtu(int i) {
        this.mMtu = i;
    }

    public void setTcpBufferSizes(String str) {
        this.mTcpBufferSizes = str;
    }

    public String toString() {
        Iterator<LinkAddress> it;
        Iterator<InetAddress> it2;
        Iterator<RouteInfo> it3;
        Iterator<LinkProperties> it4;
        String str = this.mIfaceName == null ? "" : "InterfaceName: " + this.mIfaceName + " ";
        String str2 = "LinkAddresses: [";
        while (this.mLinkAddresses.iterator().hasNext()) {
            str2 = str2 + it.next().toString() + ",";
        }
        String str3 = str2 + "] ";
        String str4 = "DnsAddresses: [";
        while (this.mDnses.iterator().hasNext()) {
            str4 = str4 + it2.next().getHostAddress() + ",";
        }
        String str5 = str4 + "] ";
        String str6 = "Domains: " + this.mDomains;
        String str7 = " MTU: " + this.mMtu;
        String str8 = this.mTcpBufferSizes != null ? " TcpBufferSizes: " + this.mTcpBufferSizes : "";
        String str9 = " Routes: [";
        while (this.mRoutes.iterator().hasNext()) {
            str9 = str9 + it3.next().toString() + ",";
        }
        String str10 = str9 + "] ";
        String str11 = this.mHttpProxy == null ? "" : " HttpProxy: " + this.mHttpProxy.toString() + " ";
        String str12 = "";
        if (this.mStackedLinks.values().size() > 0) {
            String str13 = " Stacked: [";
            while (this.mStackedLinks.values().iterator().hasNext()) {
                str13 = str13 + " [" + it4.next().toString() + " ],";
            }
            str12 = str13 + "] ";
        }
        return "{" + str + str3 + str10 + str5 + str6 + str7 + str8 + str11 + str12 + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getInterfaceName());
        parcel.writeInt(this.mLinkAddresses.size());
        Iterator<LinkAddress> it = this.mLinkAddresses.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), i);
        }
        parcel.writeInt(this.mDnses.size());
        Iterator<InetAddress> it2 = this.mDnses.iterator();
        while (it2.hasNext()) {
            parcel.writeByteArray(it2.next().getAddress());
        }
        parcel.writeString(this.mDomains);
        parcel.writeInt(this.mMtu);
        parcel.writeString(this.mTcpBufferSizes);
        parcel.writeInt(this.mRoutes.size());
        Iterator<RouteInfo> it3 = this.mRoutes.iterator();
        while (it3.hasNext()) {
            parcel.writeParcelable(it3.next(), i);
        }
        if (this.mHttpProxy != null) {
            parcel.writeByte((byte) 1);
            parcel.writeParcelable(this.mHttpProxy, i);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeList(new ArrayList(this.mStackedLinks.values()));
    }
}
