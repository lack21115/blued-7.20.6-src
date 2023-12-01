package com.tencent.qimei.g;

import android.net.ConnectivityManager;
import android.net.Network;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/g/a.class */
public class a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f24636a;

    public a(b bVar) {
        this.f24636a = bVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        boolean z;
        z = this.f24636a.f;
        if (z) {
            return;
        }
        this.f24636a.f = true;
        com.tencent.qimei.k.a.b("QM", "current network switched to the available state", new Object[0]);
        this.f24636a.b();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        this.f24636a.f = false;
        com.tencent.qimei.k.a.b("QM", "current network lost", new Object[0]);
        this.f24636a.c();
    }
}
