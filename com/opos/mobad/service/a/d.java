package com.opos.mobad.service.a;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.m.a.r;
import com.opos.mobad.m.a.s;
import com.opos.mobad.provider.strategy.AppInfo;
import com.opos.mobad.provider.strategy.StrategyInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f27288a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.provider.strategy.b f27289c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/d$a.class */
    public interface a {
        void a();

        void a(r rVar, long j);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/d$b.class */
    public interface b {
        void a();

        void a(Bundle bundle);
    }

    public d(Context context, String str, String str2) {
        this.f27288a = str;
        this.b = str2;
        this.f27289c = new com.opos.mobad.provider.strategy.b(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<s> list, long j) {
        com.opos.cmn.an.f.a.b("DispatchController", "write strategy:", list);
        try {
            Bundle bundle = new Bundle();
            for (s sVar : list) {
                bundle.putByteArray(sVar.l, s.f26363c.b((com.heytap.nearx.a.a.e<s>) sVar));
            }
            this.f27289c.a(this.f27288a, new StrategyInfo(j, bundle));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("DispatchController", "write strategy fail", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar, long j) {
        com.opos.cmn.an.f.a.b("DispatchController", "write app:" + rVar);
        try {
            this.f27289c.a(this.b, this.f27288a, new AppInfo(j, r.f26361c.b((com.heytap.nearx.a.a.e<r>) rVar)));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("DispatchController", "write app fail", e);
        }
    }

    public void a(final r rVar, final long j) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(rVar.c().a(new ArrayList(0)).b(), j);
                d.this.a(rVar.g, rVar.j != null ? rVar.j.longValue() : 0L);
            }
        });
    }

    public void a(final a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppInfo b2 = d.this.f27289c.b(d.this.f27288a);
                    if (b2 == null) {
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    r a2 = r.f26361c.a(b2.b);
                    long j = b2.f27133a;
                    if (aVar != null) {
                        aVar.a(a2, j);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readAppInfo fail", e);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        });
    }

    public void a(final b bVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle a2 = d.this.f27289c.a(d.this.f27288a);
                    if (a2 != null) {
                        if (bVar != null) {
                            bVar.a(a2);
                            return;
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail with strategyInfo null");
                    if (bVar != null) {
                        bVar.a();
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail", e);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                }
            }
        });
    }
}
