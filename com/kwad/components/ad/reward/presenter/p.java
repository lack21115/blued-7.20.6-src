package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/p.class */
public final class p extends a {
    private Runnable sC;
    private float sq;
    private q ss;
    private KsToastView sz;
    private boolean sA = false;
    private boolean sB = false;
    private boolean sD = false;
    private boolean st = false;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            p.this.sz.setVisibility(8);
        }
    };

    public p(q qVar) {
        this.ss = qVar;
    }

    static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.sD = true;
        return true;
    }

    private void hD() {
        this.sC = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.sD) {
                    return;
                }
                if (p.this.sz != null) {
                    p.this.sz.setVisibility(8);
                }
                com.kwad.components.ad.reward.b.ff().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void hE() {
        bi.b(this.sC);
        this.sC = null;
    }

    private void hy() {
        synchronized (this) {
            if (this.st) {
                return;
            }
            com.kwad.sdk.core.report.a.d(this.qt.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().bl(192).S(this.qt.oN.getPlayDuration()));
            this.st = true;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.b(this.mPlayEndPageListener);
    }

    public final void hB() {
        if (this.sB) {
            return;
        }
        hy();
        this.sB = true;
        this.sz.setVisibility(0);
        this.sz.Y(3);
        hD();
        bi.a(this.sC, null, com.anythink.expressad.video.module.a.a.m.ag);
    }

    public final void hC() {
        this.sB = false;
        this.sz.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
        this.sz = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                p.a(p.this, true);
                p.this.sz.setVisibility(8);
                com.kwad.components.ad.reward.b.ff().a(PlayableSource.PENDANT_CLICK_AUTO);
            }
        });
        this.sq = com.kwad.components.ad.reward.kwai.b.gC();
        this.sA = com.kwad.components.ad.reward.kwai.b.gD() && com.kwad.components.ad.reward.kwai.b.gE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        hE();
        this.qt.c(this.mPlayEndPageListener);
    }
}
