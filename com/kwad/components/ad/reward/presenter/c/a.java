package com.kwad.components.ad.reward.presenter.c;

import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.presenter.c.a.c;
import com.kwad.components.ad.reward.presenter.c.a.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/a.class */
public class a extends com.kwad.components.ad.reward.presenter.a implements f, h {
    private e gG = new e() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    };

    public a() {
        cj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return getPriority() - fVar.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        this.qt.b(this);
        com.kwad.components.ad.reward.b.ff().a(this);
    }

    private void ew() {
        List<Presenter> Bg = Bg();
        if (Bg == null) {
            return;
        }
        for (Presenter presenter : Bg) {
            if (presenter instanceof c) {
                ((c) presenter).iz();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            cc();
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        ew();
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        ew();
    }

    protected void cj() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.c.a.a());
        a(new com.kwad.components.ad.reward.presenter.c.a.b());
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.c(this);
        com.kwad.components.ad.reward.b.ff().b(this);
    }
}
