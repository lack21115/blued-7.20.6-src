package com.soft.blued.ui.pay.googlepay.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabBroadcastReceiver.class */
public class IabBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final IabBroadcastListener f32997a;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabBroadcastReceiver$IabBroadcastListener.class */
    public interface IabBroadcastListener {
        void a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IabBroadcastListener iabBroadcastListener = this.f32997a;
        if (iabBroadcastListener != null) {
            iabBroadcastListener.a();
        }
    }
}
