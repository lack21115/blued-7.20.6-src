package com.kwad.components.ad.fullscreen.b.b;

import android.content.Context;
import android.os.Vibrator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.sdk.R;
import com.kwad.sdk.core.f.d;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/b/b.class */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {
    private d ef;
    private Vibrator eg;
    private FrameLayout hy;
    private ImageView hz;
    private h hA = new h() { // from class: com.kwad.components.ad.fullscreen.b.b.b.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void a(PlayableSource playableSource, l lVar) {
        }

        @Override // com.kwad.components.ad.reward.d.h
        public final void ca() {
            b.this.hy.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.d.h
        public final void cb() {
            b.this.hy.setVisibility(4);
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.b.b.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (b.this.ef != null) {
                b.this.ef.aY(b.this.getContext());
            }
            if (b.this.hz != null) {
                b.this.hz.setVisibility(0);
            }
            if (com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.cb(b.this.qt.mAdTemplate))) {
                b.this.hy.setVisibility(4);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        if (this.ef != null) {
            return;
        }
        float dl = com.kwad.sdk.core.response.a.b.dl(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate));
        d dVar = new d(dl);
        this.ef = dVar;
        dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.fullscreen.b.b.b.3
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d) {
                if (com.kwad.components.core.d.a.b.mF() || !b.this.iJ()) {
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.b.b.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.ef.xD();
                        }
                    }, null, 500L);
                    return;
                }
                if (b.this.qt != null) {
                    i iVar = new i();
                    iVar.i(d);
                    b.this.qt.a(1, b.this.getContext(), 157, 1, 0L, false, iVar);
                }
                bi.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.b.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("TKFullScreenVideoPresenter", "onShakeEvent openGate2");
                        b.this.ef.xD();
                    }
                }, null, 500L);
                bi.a(b.this.getContext(), b.this.eg);
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ef.e(dl);
        this.ef.aX(getContext());
        if (getContext() != null) {
            this.eg = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        }
    }

    private void cl() {
        final String H = com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate));
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.b.b.5
            @Override // java.lang.Runnable
            public final void run() {
                ImageLoaderProxy.INSTANCE.load(b.this.hz, H);
            }
        }, 1000L);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        ImageView imageView;
        ImageView.ScaleType scaleType;
        super.ar();
        this.qt.pg = true;
        com.kwad.components.ad.reward.b.ff().a(this.hA);
        this.qt.b(this.mPlayEndPageListener);
        getContext();
        if (ai.DL()) {
            imageView = this.hz;
            scaleType = ImageView.ScaleType.FIT_XY;
        } else {
            imageView = this.hz;
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        imageView.setScaleType(scaleType);
        cl();
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.hy;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-fullscreen-video-card", this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hy = (FrameLayout) findViewById(R.id.ksad_js_full_card);
        this.hz = (ImageView) findViewById(R.id.ksad_tk_bg_view);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new ap(new ap.a() { // from class: com.kwad.components.ad.fullscreen.b.b.b.4
            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void bJ() {
                b.this.bB();
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.hy.setVisibility(8);
        this.hz.setVisibility(8);
        this.qt.pg = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.ff().b(this.hA);
    }
}
