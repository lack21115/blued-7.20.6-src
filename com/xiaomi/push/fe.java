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
    private int f27710a;

    /* renamed from: a  reason: collision with other field name */
    fu f390a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f391a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f392a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f389a = 0;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f27711c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f393a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f391a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Failed to obtain traffic data during initialization: ".concat(String.valueOf(e)));
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f389a = 0L;
        this.f27711c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bh.b(this.f391a)) {
            this.f389a = elapsedRealtime;
        }
        if (this.f391a.m9050c()) {
            this.f27711c = elapsedRealtime;
        }
    }

    private void c() {
        synchronized (this) {
            com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f393a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.f27711c);
            ey eyVar = new ey();
            eyVar.f368a = (byte) 0;
            eyVar.a(ex.CHANNEL_ONLINE_RATE.a());
            eyVar.a(this.f393a);
            eyVar.d((int) (System.currentTimeMillis() / 1000));
            eyVar.b((int) (this.b / 1000));
            eyVar.c((int) (this.d / 1000));
            ff.m8697a().a(eyVar);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f392a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8696a() {
        synchronized (this) {
            if (this.f391a == null) {
                return;
            }
            String m8485a = bh.m8485a((Context) this.f391a);
            boolean c2 = bh.c(this.f391a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f389a > 0) {
                this.b += elapsedRealtime - this.f389a;
                this.f389a = 0L;
            }
            if (this.f27711c != 0) {
                this.d += elapsedRealtime - this.f27711c;
                this.f27711c = 0L;
            }
            if (c2) {
                if ((!TextUtils.equals(this.f393a, m8485a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f393a = m8485a;
                if (this.f389a == 0) {
                    this.f389a = elapsedRealtime;
                }
                if (this.f391a.m9050c()) {
                    this.f27711c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar) {
        this.f27710a = 0;
        this.f392a = null;
        this.f390a = fuVar;
        this.f393a = bh.m8485a((Context) this.f391a);
        fh.a(0, ex.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, int i, Exception exc) {
        long j;
        if (this.f27710a == 0 && this.f392a == null) {
            this.f27710a = i;
            this.f392a = exc;
            fh.b(fuVar.mo8735a(), exc);
        }
        if (i == 22 && this.f27711c != 0) {
            long m8733a = fuVar.m8733a() - this.f27711c;
            long j2 = m8733a;
            if (m8733a < 0) {
                j2 = 0;
            }
            this.d += j2 + (ga.b() / 2);
            this.f27711c = 0L;
        }
        m8696a();
        int myUid = Process.myUid();
        long j3 = -1;
        try {
            long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
            j3 = uidRxBytes;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Failed to obtain traffic data: ".concat(String.valueOf(e)));
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
        m8696a();
        this.f27711c = SystemClock.elapsedRealtime();
        fh.a(0, ex.CONN_SUCCESS.a(), fuVar.mo8735a(), fuVar.a());
    }
}
