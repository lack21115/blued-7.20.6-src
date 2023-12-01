package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gb.class */
public abstract class gb extends fu {

    /* renamed from: a  reason: collision with root package name */
    protected Exception f27739a;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f456a;
    protected XMPushService b;

    /* renamed from: c  reason: collision with root package name */
    private int f27740c;

    /* renamed from: c  reason: collision with other field name */
    String f457c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;
    private long h;

    public gb(XMPushService xMPushService, fv fvVar) {
        super(xMPushService, fvVar);
        this.f27739a = null;
        this.f457c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    private void a(fv fvVar) {
        a(fvVar.c(), fvVar.m8742a());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(String str, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp a(String str) {
        cp a2 = ct.a().a(str, false);
        if (!a2.b()) {
            gx.a(new ge(this, str));
        }
        return a2;
    }

    @Override // com.xiaomi.push.fu
    /* renamed from: a */
    public String mo8735a() {
        return this.d;
    }

    public Socket a() {
        return new Socket();
    }

    /* renamed from: a  reason: collision with other method in class */
    protected void mo8759a() {
        synchronized (this) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, Exception exc) {
        synchronized (this) {
            if (b() == 2) {
                return;
            }
            a(2, i, exc);
            this.f440a = "";
            try {
                this.f456a.close();
            } catch (Throwable th) {
            }
            this.e = 0L;
            this.f = 0L;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (!bh.b(this.b)) {
                return;
            }
            int i = this.f27740c + 1;
            this.f27740c = i;
            if (i < 2) {
                return;
            }
            String mo8735a = mo8735a();
            com.xiaomi.channel.commonutils.logger.b.m8344a("max short conn time reached, sink down current host:".concat(String.valueOf(mo8735a)));
            a(mo8735a, 0L, exc);
        }
        this.f27740c = 0;
    }

    protected void a(String str, long j, Exception exc) {
        cp a2 = ct.a().a(fv.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0L, exc);
            ct.a().m8556c();
        }
    }

    /* renamed from: a */
    protected abstract void mo8724a(boolean z);

    @Override // com.xiaomi.push.fu
    public void a(fj[] fjVarArr) {
        throw new gf("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fu
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fu
    public void b(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        mo8724a(z);
        com.xiaomi.push.service.o.a(this.b).m9145c();
        if (z) {
            return;
        }
        this.b.a(new gc(this, 13, elapsedRealtime, currentTimeMillis), 10000L);
    }

    public String c() {
        return this.f440a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new gd(this, 2, i, exc));
    }

    public void e() {
        synchronized (this) {
            try {
                if (!c() && !b()) {
                    a(0, 0, (Exception) null);
                    a(this.f437a);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m8344a("WARNING: current xmpp has connected");
            } catch (IOException e) {
                throw new gf(e);
            }
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
