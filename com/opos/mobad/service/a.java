package com.opos.mobad.service;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.m.a.g;
import com.opos.mobad.m.a.h;
import com.opos.mobad.m.a.i;
import com.opos.mobad.m.a.v;
import com.opos.mobad.m.a.w;
import com.opos.mobad.service.h.b;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a.class */
public class a {
    private static volatile a f;

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0728a f27276a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f27277c = 0;
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger g = new AtomicInteger(0);

    /* renamed from: com.opos.mobad.service.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a$a.class */
    public interface InterfaceC0728a {
        void a(int i);

        void a(String str);
    }

    private a() {
    }

    private static final com.opos.mobad.m.a.h a(Context context) {
        com.opos.mobad.m.a.g b = new g.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(context)).d(com.opos.mobad.service.e.a.a().f()).e(com.opos.mobad.service.e.a.a().g()).f(com.opos.mobad.service.e.a.a().h()).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).g(com.opos.mobad.service.e.a.a().l()).b();
        return new h.a().a(b).a(new i.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).b(com.opos.cmn.an.b.a.a(context)).a(com.opos.cmn.an.b.c.a()).b();
    }

    public static final a a() {
        a aVar;
        a aVar2 = f;
        if (aVar2 == null) {
            synchronized (a.class) {
                try {
                    a aVar3 = f;
                    aVar = aVar3;
                    if (aVar3 == null) {
                        aVar = new a();
                        f = aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    private FutureTask<Integer> a(final Context context, final String str, final boolean z) {
        if (TextUtils.isEmpty(this.b) || this.f27277c == 0) {
            return null;
        }
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() { // from class: com.opos.mobad.service.a.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() throws Exception {
                b.C0737b c2 = a.this.c(context, str);
                return Integer.valueOf((c2 == null || c2.f27378a != 200 || c2.f27379c == 0) ? z ? a.this.g() : a.this.f() : ((v) c2.f27379c).i.booleanValue() ? 1 : ((v) c2.f27379c).h == w.VIP ? 2 : 0);
            }
        });
        com.opos.cmn.an.j.b.c(futureTask);
        return futureTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.service.h.b.C0737b<com.opos.mobad.m.a.v> c(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            com.opos.mobad.m.a.t$a r0 = new com.opos.mobad.m.a.t$a
            r1 = r0
            r1.<init>()
            r1 = r7
            java.lang.String r1 = r1.b
            com.opos.mobad.m.a.t$a r0 = r0.a(r1)
            r12 = r0
            r0 = r7
            int r0 = r0.f27277c
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 == r1) goto L36
            r0 = r10
            if (r0 == 0) goto L2e
            r0 = r10
            r1 = 1
            if (r0 == r1) goto L26
            goto L36
        L26:
            com.opos.mobad.m.a.w r0 = com.opos.mobad.m.a.w.VIP
            r11 = r0
            goto L3b
        L2e:
            com.opos.mobad.m.a.w r0 = com.opos.mobad.m.a.w.NORMAL
            r11 = r0
            goto L3b
        L36:
            com.opos.mobad.m.a.w r0 = com.opos.mobad.m.a.w.UNKNOWN_STATUS
            r11 = r0
        L3b:
            r0 = r12
            r1 = r11
            com.opos.mobad.m.a.t$a r0 = r0.a(r1)
            r0 = r8
            java.lang.String r1 = "https://uapi.ads.heytapmobi.com/union/instant/vip/right"
            com.opos.mobad.m.a.u$a r2 = new com.opos.mobad.m.a.u$a
            r3 = r2
            r3.<init>()
            r3 = r12
            com.opos.mobad.m.a.t r3 = r3.b()
            com.opos.mobad.m.a.u$a r2 = r2.a(r3)
            r3 = r8
            com.opos.mobad.m.a.h r3 = a(r3)
            com.opos.mobad.m.a.u$a r2 = r2.a(r3)
            r3 = r9
            com.opos.mobad.m.a.u$a r2 = r2.a(r3)
            r3 = r8
            java.lang.String r3 = r3.getPackageName()
            com.opos.mobad.m.a.u$a r2 = r2.b(r3)
            com.opos.mobad.m.a.u r2 = r2.b()
            byte[] r2 = r2.b()
            com.opos.mobad.service.a$2 r3 = new com.opos.mobad.service.a$2
            r4 = r3
            r5 = r7
            r4.<init>()
            com.opos.mobad.service.h.b$b r0 = com.opos.mobad.service.h.b.a(r0, r1, r2, r3)
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            java.lang.String r1 = "check result:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            if (r0 == 0) goto L99
            r0 = r9
            T r0 = r0.f27379c
            com.opos.mobad.m.a.v r0 = (com.opos.mobad.m.a.v) r0
            r8 = r0
            goto L9b
        L99:
            r0 = 0
            r8 = r0
        L9b:
            r0 = r11
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "am"
            r1 = r11
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.c(android.content.Context, java.lang.String):com.opos.mobad.service.h.b$b");
    }

    public FutureTask<Integer> a(Context context, String str) {
        return a(context, str, false);
    }

    public void a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        InterfaceC0728a interfaceC0728a;
        com.opos.cmn.an.f.a.b("am", "do exercise");
        com.opos.mobad.service.i.d.a().a(str, str2, str3, str4, str5, str6, this.b);
        if (TextUtils.isEmpty(this.b) || (interfaceC0728a = this.f27276a) == null) {
            return;
        }
        try {
            interfaceC0728a.a(i);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("am", "on exercise fail", th);
        }
    }

    public FutureTask<Integer> b(Context context, String str) {
        return a(context, str, true);
    }

    public void b() {
        this.b = null;
        this.f27277c = 0;
        this.f27276a = null;
        this.d = new AtomicInteger(0);
        this.e = new AtomicInteger(0);
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f27277c;
    }

    public void e() {
        InterfaceC0728a interfaceC0728a = this.f27276a;
        if (interfaceC0728a != null) {
            try {
                interfaceC0728a.a(this.b);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("am", "promote fail", th);
            }
        }
    }

    public int f() {
        return (this.d.get() > 60 || this.d.incrementAndGet() > 60) ? 0 : 1;
    }

    public int g() {
        return (this.g.get() > 10 || this.e.incrementAndGet() > 10) ? 0 : 1;
    }
}
