package cn.shuzilm.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/i.class */
public final class i extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4184a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.f4184a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            DUHelper.oxlbmV0d(this.f4184a, network, 1);
        } catch (Throwable th) {
        }
    }
}
