package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cn.class */
class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f41671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(XMPushService xMPushService) {
        this.f41671a = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.f41671a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.f41671a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("[Alarm] disable ping receiver may be failure. ".concat(String.valueOf(th)));
        }
    }
}
