package com.anythink.core.common.a;

import com.anythink.core.common.b.n;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/a/b.class */
public class b {
    private static volatile b b;

    /* renamed from: a  reason: collision with root package name */
    final String f6446a = b.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.core.common.c.f f6447c;
    private com.anythink.core.common.c.e d;

    private b() {
        if (n.a().g() != null) {
            this.f6447c = com.anythink.core.common.c.f.a(com.anythink.core.common.c.c.a(n.a().g()));
            this.d = com.anythink.core.common.c.e.a(com.anythink.core.common.c.c.a(n.a().g()));
        }
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public final List<d> a(int i) {
        return this.f6447c.a(i);
    }

    public final void a(final com.anythink.core.common.e.g gVar) {
        new StringBuilder("insertDspOfferShowRecord dspOfferId:").append(gVar.U());
        n.a();
        n.b(new Runnable() { // from class: com.anythink.core.common.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = new f();
                fVar.f6452a = gVar.T();
                fVar.b = gVar.U();
                fVar.f6454c = gVar.V();
                fVar.d = 0;
                b.this.f6447c.a(fVar);
            }
        });
    }

    public final List<d> b(int i) {
        return this.d.a(i);
    }

    public final void b() {
        n.a();
        n.b(new Runnable() { // from class: com.anythink.core.common.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.f6447c.c();
            }
        });
    }

    public final void b(final com.anythink.core.common.e.g gVar) {
        new StringBuilder("updateDspOfferShowRecord dspOfferId:").append(gVar.U());
        n.a();
        n.b(new Runnable() { // from class: com.anythink.core.common.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = new f();
                fVar.f6452a = gVar.T();
                fVar.b = gVar.U();
                fVar.f6454c = gVar.V();
                fVar.d = 1;
                b.this.f6447c.b(fVar);
            }
        });
    }

    public final void c(final com.anythink.core.common.e.g gVar) {
        if (gVar.W() != 1) {
            StringBuilder sb = new StringBuilder("adxOffer.getDspInstallIdUploadSwitch() = ");
            sb.append(gVar.W());
            sb.append(",not need to record install");
        } else if (gVar.D() == 1 || gVar.D() == 4) {
            n.a();
            n.b(new Runnable() { // from class: com.anythink.core.common.a.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    new StringBuilder("insertDspOfferInstallRecord dspOfferId:").append(gVar.U());
                    e eVar = new e();
                    eVar.f6452a = gVar.T();
                    eVar.b = gVar.U();
                    eVar.f6453c = gVar.B();
                    b.this.d.a(eVar);
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder("adxOffer.getClickType = ");
            sb2.append(gVar.D());
            sb2.append(",not need to record install");
        }
    }
}
