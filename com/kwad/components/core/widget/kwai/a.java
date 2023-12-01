package com.kwad.components.core.widget.kwai;

import android.os.Message;
import android.view.View;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bm;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/kwai/a.class */
public abstract class a implements com.kwad.sdk.core.g.a, bm.a {
    private Set<c> Xd;
    private final int Xe;
    private final View mRootView;
    private final AtomicBoolean Xc = new AtomicBoolean(false);
    protected final bm gK = new bm(this);

    public a(View view, int i) {
        this.mRootView = view;
        this.Xe = i;
    }

    private void aT(boolean z) {
        Set<c> set = this.Xd;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.onPageVisible();
                } else {
                    cVar.onPageInvisible();
                }
            }
        }
    }

    private void iW() {
        if (this.Xc.getAndSet(true)) {
            return;
        }
        aT(true);
    }

    private void rC() {
        if (et()) {
            iW();
        } else {
            rF();
        }
    }

    private void rF() {
        if (this.Xc.getAndSet(false)) {
            aT(false);
        }
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (message.what == 666) {
            rC();
            this.gK.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void a(c cVar) {
        ah.checkUiThread();
        if (cVar == null) {
            return;
        }
        if (et()) {
            cVar.onPageVisible();
        } else {
            cVar.onPageInvisible();
        }
        if (this.Xd == null) {
            this.Xd = new HashSet();
        }
        this.Xd.add(cVar);
    }

    @Override // com.kwad.sdk.core.g.a
    public final void b(c cVar) {
        Set<c> set;
        ah.checkUiThread();
        if (cVar == null || (set = this.Xd) == null) {
            return;
        }
        set.remove(cVar);
    }

    public abstract boolean et();

    public final void rD() {
        this.gK.removeMessages(666);
        this.gK.sendEmptyMessage(666);
    }

    public final void rE() {
        rC();
        this.gK.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.g.a
    public final boolean rG() {
        return this.Xc.get();
    }

    @Override // com.kwad.sdk.core.g.a
    public final void release() {
        rE();
        Set<c> set = this.Xd;
        if (set != null) {
            set.clear();
        }
    }
}
