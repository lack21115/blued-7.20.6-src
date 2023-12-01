package com.kwad.components.ad.splashscreen.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/l.class */
public final class l extends e implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private static long ka = 400;
    private boolean BX;
    private com.kwad.components.ad.splashscreen.d CH;
    private ViewGroup CL;
    private KsShakeView CM;
    private TextView CN;
    private com.kwad.components.ad.splashscreen.e.a Cv;
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;

    private void kV() {
        if (this.Cg != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Cv;
            if (aVar == null) {
                this.Cv = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.l.2
                    @Override // com.kwad.components.ad.splashscreen.e.a
                    public final void ac(String str) {
                        if (l.this.CN != null) {
                            TextView textView = l.this.CN;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.setAdTemplate(this.Cg.mAdTemplate);
            }
            com.kwad.components.core.d.b.c cVar = this.Cg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Cv);
            }
        }
    }

    private void lb() {
        TextView textView = this.CN;
        if (textView != null) {
            textView.setText(this.CH.kq());
        }
        KsShakeView ksShakeView = this.CM;
        if (ksShakeView != null) {
            ksShakeView.ah(this.CH.kr());
        }
        if (com.kwad.components.ad.splashscreen.e.c.c(this.Cg)) {
            com.kwad.components.ad.splashscreen.e.c.a(this.CN, -1, 60, -1, -1);
        }
    }

    private void lc() {
        if (this.CL == null || this.Cg == null) {
            return;
        }
        this.CL.setVisibility(0);
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, 185, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(final double d) {
        boolean mF = com.kwad.components.core.d.a.b.mF();
        if (!this.Cg.BH.rG() || mF) {
            bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.3
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.ef.xD();
                }
            }, null, 500L);
            return;
        }
        this.CM.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.b.l.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (l.this.Cg != null) {
                    l.this.Cg.a(1, l.this.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.l.4.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.report.i iVar) {
                            iVar.i(d);
                        }
                    });
                }
                l.this.CM.lw();
                bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.4.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                        l.this.ef.xD();
                    }
                }, null, 500L);
            }
        });
        bi.a(getContext(), this.eg);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.a.b.di(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate)) && this.Cg != null) {
            this.Cg.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.Cg == null) {
            return;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        getContext();
        this.CH = com.kwad.components.ad.splashscreen.d.a(this.Cg.mAdTemplate, cb, this.Cg.mApkDownloadHelper, 2);
        float bx = com.kwad.sdk.core.response.a.b.bx(this.Cg.mAdTemplate);
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar == null) {
            com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(bx);
            this.ef = dVar2;
            dVar2.a(this);
        } else {
            dVar.e(bx);
        }
        lb();
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            kV();
        }
        lc();
        this.ef.aX(getContext());
        this.CM.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.1
            @Override // java.lang.Runnable
            public final void run() {
                l.this.CM.lw();
            }
        });
        this.BX = com.kwad.sdk.core.response.a.c.bQ(this.Cg.mAdTemplate);
        new com.kwad.sdk.widget.f(this.CM.getContext(), this.CM, this);
        this.Cg.a(this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.BX);
        if (this.BX && this.Cg != null) {
            this.Cg.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
        com.kwad.sdk.core.report.a.ax(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.CM) || this.Cg == null || this.Cg.mAdTemplate == null || !com.kwad.sdk.core.response.a.b.di(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            return;
        }
        this.Cg.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        Context context = getContext();
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        this.CL = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_shake_root));
        this.CN = (TextView) this.CL.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.CL.findViewById(R.id.ksad_shake_view);
        this.CM = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onUnbind");
        if (this.Cg != null) {
            this.Cg.b(this);
        }
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        KsShakeView ksShakeView = this.CM;
        if (ksShakeView != null) {
            ksShakeView.jW();
        }
    }
}
