package com.android.server.net;

import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.RouteInfo;
import java.util.Arrays;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/net/NetlinkTracker.class */
public class NetlinkTracker extends BaseNetworkObserver {
    private static final boolean DBG = false;
    private final String TAG;
    private final Callback mCallback;
    private DnsServerRepository mDnsServerRepository;
    private final String mInterfaceName;
    private final LinkProperties mLinkProperties = new LinkProperties();

    /* loaded from: source-4181928-dex2jar.jar:com/android/server/net/NetlinkTracker$Callback.class */
    public interface Callback {
        void update(LinkProperties linkProperties);
    }

    public NetlinkTracker(String str, Callback callback) {
        this.TAG = "NetlinkTracker/" + str;
        this.mInterfaceName = str;
        this.mCallback = callback;
        this.mLinkProperties.setInterfaceName(this.mInterfaceName);
        this.mDnsServerRepository = new DnsServerRepository();
    }

    private void maybeLog(String str, Object obj) {
    }

    private void maybeLog(String str, String str2, LinkAddress linkAddress) {
    }

    @Override // com.android.server.net.BaseNetworkObserver
    public void addressRemoved(String str, LinkAddress linkAddress) {
        boolean removeLinkAddress;
        if (this.mInterfaceName.equals(str)) {
            maybeLog("addressRemoved", str, linkAddress);
            synchronized (this) {
                removeLinkAddress = this.mLinkProperties.removeLinkAddress(linkAddress);
            }
            if (removeLinkAddress) {
                this.mCallback.update(new LinkProperties(this.mLinkProperties));
            }
        }
    }

    @Override // com.android.server.net.BaseNetworkObserver
    public void addressUpdated(String str, LinkAddress linkAddress) {
        boolean addLinkAddress;
        if (this.mInterfaceName.equals(str)) {
            maybeLog("addressUpdated", str, linkAddress);
            synchronized (this) {
                addLinkAddress = this.mLinkProperties.addLinkAddress(linkAddress);
            }
            if (addLinkAddress) {
                this.mCallback.update(new LinkProperties(this.mLinkProperties));
            }
        }
    }

    public void clearLinkProperties() {
        synchronized (this) {
            this.mDnsServerRepository = new DnsServerRepository();
            this.mLinkProperties.clear();
            this.mLinkProperties.setInterfaceName(this.mInterfaceName);
        }
    }

    public LinkProperties getLinkProperties() {
        LinkProperties linkProperties;
        synchronized (this) {
            linkProperties = new LinkProperties(this.mLinkProperties);
        }
        return linkProperties;
    }

    @Override // com.android.server.net.BaseNetworkObserver
    public void interfaceDnsServerInfo(String str, long j, String[] strArr) {
        if (this.mInterfaceName.equals(str)) {
            maybeLog("interfaceDnsServerInfo", Arrays.toString(strArr));
            if (this.mDnsServerRepository.addServers(j, strArr)) {
                synchronized (this) {
                    this.mDnsServerRepository.setDnsServersOn(this.mLinkProperties);
                }
                this.mCallback.update(new LinkProperties(this.mLinkProperties));
            }
        }
    }

    @Override // com.android.server.net.BaseNetworkObserver
    public void routeRemoved(RouteInfo routeInfo) {
        boolean removeRoute;
        if (this.mInterfaceName.equals(routeInfo.getInterface())) {
            maybeLog("routeRemoved", routeInfo);
            synchronized (this) {
                removeRoute = this.mLinkProperties.removeRoute(routeInfo);
            }
            if (removeRoute) {
                this.mCallback.update(new LinkProperties(this.mLinkProperties));
            }
        }
    }

    @Override // com.android.server.net.BaseNetworkObserver
    public void routeUpdated(RouteInfo routeInfo) {
        boolean addRoute;
        if (this.mInterfaceName.equals(routeInfo.getInterface())) {
            maybeLog("routeUpdated", routeInfo);
            synchronized (this) {
                addRoute = this.mLinkProperties.addRoute(routeInfo);
            }
            if (addRoute) {
                this.mCallback.update(new LinkProperties(this.mLinkProperties));
            }
        }
    }
}
