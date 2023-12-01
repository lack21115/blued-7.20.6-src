package com.android.server.net;

import android.net.INetworkManagementEventObserver;
import android.net.LinkAddress;
import android.net.RouteInfo;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/net/BaseNetworkObserver.class */
public class BaseNetworkObserver extends INetworkManagementEventObserver.Stub {
    @Override // android.net.INetworkManagementEventObserver
    public void addressRemoved(String str, LinkAddress linkAddress) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void addressUpdated(String str, LinkAddress linkAddress) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceAdded(String str) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceClassDataActivityChanged(String str, boolean z, long j) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceDnsServerInfo(String str, long j, String[] strArr) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceLinkStateChanged(String str, boolean z) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceMessageRecevied(String str) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceRemoved(String str) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void interfaceStatusChanged(String str, boolean z) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void limitReached(String str, String str2) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void routeRemoved(RouteInfo routeInfo) {
    }

    @Override // android.net.INetworkManagementEventObserver
    public void routeUpdated(RouteInfo routeInfo) {
    }
}
