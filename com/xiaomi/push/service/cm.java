package com.xiaomi.push.service;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cm.class */
class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(XMPushService xMPushService) {
        this.f27979a = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27979a.f889a = true;
        try {
            com.xiaomi.channel.commonutils.logger.b.m8344a("try to trigger the wifi digest broadcast.");
            Object systemService = this.f27979a.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                com.xiaomi.push.bi.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
            }
        } catch (Throwable th) {
        }
    }
}
