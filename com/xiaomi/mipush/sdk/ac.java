package com.xiaomi.mipush.sdk;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ac.class */
class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NotificationClickedActivity f27506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NotificationClickedActivity notificationClickedActivity) {
        this.f27506a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.e("clicked activity finish by timeout.");
        this.f27506a.finish();
    }
}
