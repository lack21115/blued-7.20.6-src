package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fe.class */
public class fe implements fx {

    /* renamed from: a  reason: collision with root package name */
    private int f41401a;

    /* renamed from: a  reason: collision with other field name */
    fu f437a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f438a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f439a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f436a = 0;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f41402c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f440a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f438a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Failed to obtain traffic data during initialization: ".concat(String.valueOf(e)));
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f436a = 0L;
        this.f41402c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bh.b(this.f438a)) {
            this.f436a = elapsedRealtime;
        }
        if (this.f438a.m12100c()) {
            this.f41402c = elapsedRealtime;
        }
    }

    private void c() {
        synchronized (this) {
            com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f440a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.f41402c);
            ey eyVar = new ey();
            eyVar.f415a = (byte) 0;
            eyVar.a(ex.CHANNEL_ONLINE_RATE.a());
            eyVar.a(this.f440a);
            eyVar.d((int) (System.currentTimeMillis() / 1000));
            eyVar.b((int) (this.b / 1000));
            eyVar.c((int) (this.d / 1000));
            ff.m11747a().a(eyVar);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f439a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11746a() {
        synchronized (this) {
            if (this.f438a == null) {
                return;
            }
            String m11535a = bh.m11535a((Context) this.f438a);
            boolean c2 = bh.c(this.f438a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f436a > 0) {
                this.b += elapsedRealtime - this.f436a;
                this.f436a = 0L;
            }
            if (this.f41402c != 0) {
                this.d += elapsedRealtime - this.f41402c;
                this.f41402c = 0L;
            }
            if (c2) {
                if ((!TextUtils.equals(this.f440a, m11535a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f440a = m11535a;
                if (this.f436a == 0) {
                    this.f436a = elapsedRealtime;
                }
                if (this.f438a.m12100c()) {
                    this.f41402c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar) {
        this.f41401a = 0;
        this.f439a = null;
        this.f437a = fuVar;
        this.f440a = bh.m11535a((Context) this.f438a);
        fh.a(0, ex.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, int i, Exception exc) {
        long j;
        if (this.f41401a == 0 && this.f439a == null) {
            this.f41401a = i;
            this.f439a = exc;
            fh.b(fuVar.mo11785a(), exc);
        }
        if (i == 22 && this.f41402c != 0) {
            long m11783a = fuVar.m11783a() - this.f41402c;
            long j2 = m11783a;
            if (m11783a < 0) {
                j2 = 0;
            }
            this.d += j2 + (ga.b() / 2);
            this.f41402c = 0L;
        }
        m11746a();
        int myUid = Process.myUid();
        long j3 = -1;
        try {
            long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
            j3 = uidRxBytes;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Failed to obtain traffic data: ".concat(String.valueOf(e)));
            j = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j3 - this.f) + ", tx=" + (j - this.e));
        this.f = j3;
        this.e = j;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, Exception exc) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.xiaomi.push.fx
    public void b(fu fuVar) {
        m11746a();
        this.f41402c = SystemClock.elapsedRealtime();
        fh.a(0, ex.CONN_SUCCESS.a(), fuVar.mo11785a(), fuVar.a());
    }
}
