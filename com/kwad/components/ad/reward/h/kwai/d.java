package com.kwad.components.ad.reward.h.kwai;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.h.l;
import com.kwad.components.ad.reward.h.m;
import com.kwad.components.ad.reward.h.n;
import com.kwad.components.ad.reward.h.p;
import com.kwad.components.ad.reward.h.q;
import com.kwad.components.ad.reward.h.r;
import com.kwad.components.ad.reward.h.s;
import com.kwad.components.ad.reward.h.t;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/kwai/d.class */
public final class d extends h implements s, o.b {
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private DialogInterface.OnDismissListener mTaskDismissListener;
    private WeakReference<j> qm;
    private com.kwad.components.ad.reward.b.e xi;
    private m xj;
    private l xk;
    private n xl;
    private List<AdTemplate> xm;

    public d(j jVar, long j, Context context) {
        super(j, context);
        this.xm = null;
        this.qm = new WeakReference<>(jVar);
    }

    public d(j jVar, long j, Context context, DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.xm = null;
        this.mTaskDismissListener = onDismissListener;
        this.qm = new WeakReference<>(jVar);
    }

    @Override // com.kwad.components.ad.reward.h.s
    public final void af(boolean z) {
        n nVar = this.xl;
        if (nVar != null) {
            nVar.ae(z);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void bind(Activity activity, AdTemplate adTemplate, i iVar) {
        super.bind(activity, adTemplate, iVar);
        WeakReference<j> weakReference = this.qm;
        j jVar = weakReference != null ? weakReference.get() : null;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public final ac createLogHandler(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<j> weakReference = this.qm;
        return new p(weakReference != null ? weakReference.get() : null, this.mPlayedDuration, bVar);
    }

    public final void e(List<AdTemplate> list) {
        this.xm = list;
    }

    public final BackPressHandleResult gs() {
        m mVar = this.xj;
        if (mVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        mVar.jc();
        return BackPressHandleResult.HANDLED;
    }

    public final com.kwad.components.ad.reward.b.e ji() {
        return this.xi;
    }

    public final l jj() {
        return this.xk;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.components.l lVar, ViewGroup viewGroup) {
        super.onRegisterWebCardHandler(bVar, cVar, lVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        lVar.c(new q(bVar, cVar, null, this.mPlayedDuration, this, this.mTaskDismissListener));
        com.kwad.components.ad.reward.b.e eVar = new com.kwad.components.ad.reward.b.e();
        this.xi = eVar;
        lVar.c(eVar);
        lVar.c(new t(this.mContext, this.qm.get()));
        lVar.c(new com.kwad.components.ad.reward.h.o(this.qm.get()));
        m mVar = new m();
        this.xj = mVar;
        lVar.c(mVar);
        l lVar2 = new l();
        this.xk = lVar2;
        lVar.c(lVar2);
        List<AdTemplate> list = this.xm;
        if (list != null) {
            this.xk.d(list);
            this.xm = null;
        }
        lVar.c(new r(this.qm.get(), obtainAdTemplate()));
        o oVar = new o(bVar);
        oVar.a(this);
        lVar.c(oVar);
        n nVar = new n();
        this.xl = nVar;
        lVar.c(nVar);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void unBind() {
        super.unBind();
        WeakReference<j> weakReference = this.qm;
        j jVar = weakReference != null ? weakReference.get() : null;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.o.b
    public final void x(AdTemplate adTemplate) {
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c(adTemplate, com.kwad.components.core.g.e.AGGREGATION);
        WeakReference<j> weakReference = this.qm;
        j jVar = weakReference != null ? weakReference.get() : null;
        if (jVar != null) {
            jVar.b(cVar);
        }
    }
}
