package com.xiaomi.push.service;

import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bq.class */
public class bq {
    private static int d = 300000;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f1024a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f41649c = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f41648a = 500;

    /* renamed from: a  reason: collision with other field name */
    private long f1023a = 0;

    public bq(XMPushService xMPushService) {
        this.f1024a = xMPushService;
    }

    private int a() {
        if (this.b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f1023a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f1023a >= 310000) {
            this.f41648a = 1000;
            this.f41649c = 0;
            return 0;
        }
        int i2 = this.f41648a;
        int i3 = d;
        if (i2 >= i3) {
            return i2;
        }
        int i4 = this.f41649c + 1;
        this.f41649c = i4;
        if (i4 >= 4) {
            return i3;
        }
        this.f41648a = (int) (i2 * 1.5d);
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12165a() {
        this.f1023a = System.currentTimeMillis();
        this.f1024a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f1024a.m12095a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f1024a.m12096a(1)) {
                this.b++;
            }
            this.f1024a.a(1);
            XMPushService xMPushService = this.f1024a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.e());
        } else if (this.f1024a.m12096a(1)) {
        } else {
            int a2 = a();
            this.b++;
            com.xiaomi.channel.commonutils.logger.b.m11394a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f1024a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.e(), (long) a2);
            if (this.b == 2 && ff.m11747a().m11752a()) {
                ap.b();
            }
            if (this.b == 3) {
                ap.a();
            }
        }
    }
}
