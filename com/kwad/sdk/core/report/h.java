package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/h.class */
public class h extends b<q, g> {
    private static volatile boolean On = false;
    private static volatile h ail;
    private static u<q, g> aim;

    private h() {
    }

    private static boolean D(long j) {
        v vVar = (v) ServiceProvider.get(v.class);
        return vVar != null && vVar.D(j);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(q qVar) {
        a(qVar, false);
    }

    public static void a(q qVar, boolean z) {
        wW().b(qVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public g a(q qVar) {
        u<q, g> uVar = aim;
        return (g) (uVar != null ? uVar.xf() : super.a((h) qVar));
    }

    private void b(final q qVar, boolean z) {
        if (qVar == null || !On) {
            return;
        }
        if (z || D(qVar.aiG)) {
            ail.b(new m<q>() { // from class: com.kwad.sdk.core.report.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.m
                /* renamed from: wX */
                public q wT() {
                    return qVar.xb();
                }
            });
        } else {
            ail.a(new m<q>() { // from class: com.kwad.sdk.core.report.h.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.m
                /* renamed from: wX */
                public q wT() {
                    return qVar.xb();
                }
            });
        }
    }

    private void checkInit() {
        synchronized (this) {
            if (On) {
                return;
            }
            com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
            if (eVar == null) {
                return;
            }
            com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
            if (fVar == null) {
                return;
            }
            Context context = eVar.getContext();
            if (context == null) {
                return;
            }
            int al = fVar.al(context);
            i(context, al);
            w.init(context);
            w.xh();
            com.kwad.sdk.core.d.b.d("BatchReporter", "cache type = " + al);
            if (al == 2) {
                a(t.aU(context));
            }
            On = true;
        }
    }

    private static g p(List<q> list) {
        u<q, g> uVar = aim;
        return uVar != null ? uVar.xg() : new g(list);
    }

    private static h wW() {
        if (ail == null) {
            synchronized (h.class) {
                try {
                    if (ail == null) {
                        ail = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ail.checkInit();
        return ail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, n<q> nVar, AtomicInteger atomicInteger) {
        z<q, g> xe;
        u<q, g> uVar = aim;
        return (uVar == null || (xe = uVar.xe()) == null) ? super.a(context, nVar, atomicInteger) : xe;
    }

    @Override // com.kwad.sdk.core.report.b
    protected final /* synthetic */ g n(List<q> list) {
        return p(list);
    }
}
