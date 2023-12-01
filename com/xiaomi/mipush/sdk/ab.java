package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ab.class */
public class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1093a f41196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MiTinyDataClient.a.C1093a c1093a) {
        this.f41196a = c1093a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f41196a.f117a.size() != 0) {
            this.f41196a.b();
            return;
        }
        scheduledFuture = this.f41196a.f118a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f41196a.f118a;
            scheduledFuture2.cancel(false);
            this.f41196a.f118a = null;
        }
    }
}
