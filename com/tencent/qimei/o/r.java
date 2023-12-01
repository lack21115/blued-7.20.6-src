package com.tencent.qimei.o;

import android.os.SystemClock;
import com.anythink.core.api.ErrorCode;
import com.tencent.connect.common.Constants;
import com.tencent.qimei.o.m;
import com.tencent.qimei.sdk.Qimei;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/r.class */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, r> f38391a = new ConcurrentHashMap();
    public b d;
    public long f;
    public long g;
    public String i;
    public AtomicInteger b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public long f38392c = 0;
    public AtomicBoolean e = new AtomicBoolean(false);
    public boolean h = false;
    public a j = new a(3, new n(this));

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/r$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f38393a;
        public final InterfaceC0977a b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicInteger f38394c = new AtomicInteger();

        /* renamed from: com.tencent.qimei.o.r$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/r$a$a.class */
        public interface InterfaceC0977a {
        }

        public a(int i, InterfaceC0977a interfaceC0977a) {
            this.f38393a = i;
            this.b = interfaceC0977a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/r$b.class */
    public interface b {
    }

    public r(String str) {
        this.i = "";
        this.i = str;
    }

    public static r a(String str, b bVar) {
        r rVar;
        synchronized (r.class) {
            try {
                r rVar2 = f38391a.get(str);
                rVar = rVar2;
                if (rVar2 == null) {
                    rVar = new r(str);
                    rVar.d = bVar;
                    f38391a.put(str, rVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    public static /* synthetic */ void b(r rVar) {
        String str = rVar.i;
        int nextInt = com.tencent.qimei.s.e.f38413a.nextInt(101);
        com.tencent.qimei.k.a.b("CollectRate", "抽样结果为：sample = %d", Integer.valueOf(nextInt));
        if (!(nextInt <= com.tencent.qimei.v.d.a(str).C())) {
            com.tencent.qimei.k.a.b("上报", "Qm性能上报被抽样拦截～", new Object[0]);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - rVar.g;
        long j2 = uptimeMillis - rVar.f;
        long j3 = com.tencent.qimei.c.c.j().d;
        long j4 = 0;
        b bVar = rVar.d;
        if (bVar != null) {
            j4 = ((u) bVar).l;
        }
        String str2 = rVar.i;
        com.tencent.qimei.n.c a2 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_QM_USED_TIME.K, Long.valueOf(j)).a(com.tencent.qimei.n.e.REPORT_QM_LOCAL_USED_TIME.K, Long.valueOf(j2)).a(com.tencent.qimei.n.e.REPORT_OD_USED_TIME.K, Long.valueOf(j3)).a(com.tencent.qimei.n.e.REPORT_QM_INIT_TIME.K, Long.valueOf(j4));
        a2.f38356a = str2;
        a2.f38357c = "/report";
        a2.a(com.huawei.hms.ads.dynamicloader.b.f);
        com.tencent.qimei.k.a.b("QM", "Qm性能上报(appKey: %s), %d %d %d %d", rVar.i, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
    }

    public void a() {
        this.e.set(false);
    }

    public final void a(String str, int i, String str2) {
        a aVar = this.j;
        boolean z = true;
        if (aVar.f38394c.get() < aVar.f38393a - 1) {
            z = false;
        }
        if (z) {
            String str3 = this.i;
            com.tencent.qimei.n.c a2 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_QM_ERROR_CODE.K, str.equals("451") ? ErrorCode.networkError : Constants.DEFAULT_UIN).a(com.tencent.qimei.n.e.REPORT_QM_ERROR_DESC.K, "error code: " + i + ", msg:" + str2);
            a2.f38356a = str3;
            a2.f38357c = "/report";
            a2.a(com.huawei.hms.ads.dynamicloader.b.g);
        }
        c();
    }

    public final void a(String str, String str2) {
        com.tencent.qimei.f.b bVar = com.tencent.qimei.f.b.KEY_CODE;
        bVar.f = str;
        String a2 = bVar.a(this.i);
        if (!a2.equals("0")) {
            c();
            return;
        }
        String d = com.tencent.qimei.a.a.d(m.b.KEY_DATA.a(str, new m.b[0]), str2);
        com.tencent.qimei.k.a.b("QM", "(appKey: %s)Qm响应 data解密: %s", this.i, d);
        if (d == null || d.isEmpty()) {
            String str3 = this.i;
            com.tencent.qimei.n.c a3 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_QM_ERROR_CODE.K, ErrorCode.serverError);
            String str4 = com.tencent.qimei.n.e.REPORT_QM_ERROR_DESC.K;
            com.tencent.qimei.n.c a4 = a3.a(str4, "decrypt error, aes key: " + str2 + ", content:" + str);
            a4.f38356a = str3;
            a4.f38357c = "/report";
            a4.a(com.huawei.hms.ads.dynamicloader.b.g);
            c();
            return;
        }
        l a5 = l.a(this.i);
        Qimei qimei = a5.f38381c;
        a5.b(d);
        Qimei qimei2 = a5.f38381c;
        boolean z = a5.g;
        if (qimei != null && !qimei.isEmpty()) {
            String a6 = qimei.a();
            String b2 = qimei.b();
            if (a6 != null && b2 != null && (a6.isEmpty() || !b2.isEmpty())) {
                String a7 = qimei2.a();
                String b3 = qimei2.b();
                if ((a7.isEmpty() || !b3.isEmpty()) && (!a6.equals(a7) || !b2.equals(b3))) {
                    String str5 = this.i;
                    com.tencent.qimei.n.c a8 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_QM_CHANGE_OLD_Q16.K, a6).a(com.tencent.qimei.n.e.REPORT_QM_CHANGE_OLD_Q36.K, b2).a(com.tencent.qimei.n.e.REPORT_QM_CHANGE_NEW_Q16.K, a7).a(com.tencent.qimei.n.e.REPORT_QM_CHANGE_NEW_Q36.K, b3).a(com.tencent.qimei.n.e.REPORT_QM_FROM_BEACON.K, z ? "1" : "0");
                    a8.f38356a = str5;
                    a8.f38357c = "/report";
                    a8.a(com.anythink.expressad.foundation.g.a.j);
                }
            }
        }
        Qimei qimei3 = l.a(this.i).f38381c;
        if (qimei3 == null || qimei3.isEmpty()) {
            String str6 = this.i;
            com.tencent.qimei.n.c a9 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_QM_ERROR_CODE.K, "1004").a(com.tencent.qimei.n.e.REPORT_QM_ERROR_DESC.K, a2);
            a9.f38356a = str6;
            a9.f38357c = "/report";
            a9.a(com.huawei.hms.ads.dynamicloader.b.g);
        }
        Qimei qimei4 = a5.f38381c;
        if (qimei4 != null && !qimei4.isEmpty()) {
            b();
            com.tencent.qimei.a.a.e(this.i, d);
            a5.e = this.f38392c;
            a5.d = a5.b();
            com.tencent.qimei.i.f.a(a5.b).a("tt", a5.d);
        }
        a();
    }

    public final void b() {
        com.tencent.qimei.b.a.a().a(new q(this));
    }

    public final void c() {
        com.tencent.qimei.k.a.b("QM", "Qm请求失败(appKey: %s)", this.i);
        a();
        if (this.h) {
            this.h = false;
            return;
        }
        a aVar = this.j;
        aVar.f38394c.getAndIncrement();
        boolean z = aVar.f38394c.get() >= aVar.f38393a;
        if (z) {
            aVar.f38394c.set(0);
            a.InterfaceC0977a interfaceC0977a = aVar.b;
            if (interfaceC0977a != null) {
                n nVar = (n) interfaceC0977a;
                if (!com.tencent.qimei.v.d.a(nVar.f38387a.i).u().isEmpty()) {
                    nVar.f38387a.h = true;
                    com.tencent.qimei.b.a.a().a(10000L, nVar.f38387a);
                }
            }
        }
        if (z) {
            return;
        }
        com.tencent.qimei.b.a.a().a(10000L, this);
    }

    public final void d() {
        com.tencent.qimei.b.a.a().a(300L, new p(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.o.r.run():void");
    }
}
