package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ad.class */
class ad extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NotificationClickedActivity f27507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(NotificationClickedActivity notificationClickedActivity) {
        this.f27507a = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.b("clicked activity finish by normal.");
        this.f27507a.finish();
    }
}
