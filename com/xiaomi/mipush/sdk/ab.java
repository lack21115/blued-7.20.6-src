package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ab.class */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C0923a f27505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MiTinyDataClient.a.C0923a c0923a) {
        this.f27505a = c0923a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f27505a.f70a.size() != 0) {
            this.f27505a.b();
            return;
        }
        scheduledFuture = this.f27505a.f71a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f27505a.f71a;
            scheduledFuture2.cancel(false);
            this.f27505a.f71a = null;
        }
    }
}
