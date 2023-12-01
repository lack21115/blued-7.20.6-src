package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cn.class */
class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(XMPushService xMPushService) {
        this.f27980a = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.f27980a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.f27980a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("[Alarm] disable ping receiver may be failure. ".concat(String.valueOf(th)));
        }
    }
}
