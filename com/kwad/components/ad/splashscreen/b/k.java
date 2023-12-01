package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/k.class */
public final class k extends i implements com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.a {
    private View CC;
    private KsRotateView CD;
    private TextView CE;
    private TextView CF;
    private com.kwad.sdk.core.f.c CG;
    private com.kwad.components.ad.splashscreen.d CH;
    private Runnable CI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.3
        @Override // java.lang.Runnable
        public final void run() {
            k.this.CG.xD();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void ab(String str) {
        TextView textView = this.CF;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void ae(final String str) {
        Runnable runnable;
        long j;
        boolean rG = this.Cg.BH.rG();
        boolean mF = com.kwad.components.core.d.a.b.mF();
        if (!rG || mF) {
            runnable = this.CI;
            j = 1800;
        } else {
            this.CD.lv();
            if (this.Cg != null) {
                this.Cg.a(1, getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.k.2
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(com.kwad.sdk.core.report.i iVar) {
                        iVar.cz(str);
                    }
                });
            }
            kW();
            runnable = this.CI;
            j = 2000;
        }
        bi.a(runnable, null, j);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.Cg != null) {
            this.Cg.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        this.CC = viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_rotate_root);
        this.CE = (TextView) findViewById(R.id.ksad_rotate_text);
        this.CF = (TextView) findViewById(R.id.ksad_rotate_action);
        this.CD = (KsRotateView) findViewById(R.id.ksad_rotate_view);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kP() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.d a2 = com.kwad.components.ad.splashscreen.d.a(this.Cg.mAdTemplate, cb, this.Cg.mApkDownloadHelper, 1);
        this.CH = a2;
        TextView textView = this.CE;
        if (textView != null) {
            textView.setText(a2.getTitle());
        }
        TextView textView2 = this.CF;
        if (textView2 != null) {
            textView2.setText(this.CH.kq());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kQ() {
        if (this.CC == null || this.Cg == null) {
            return;
        }
        this.CC.setVisibility(0);
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, 184, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kR() {
        AdMatrixInfo.RotateInfo by = com.kwad.sdk.core.response.a.b.by(this.Cg.mAdTemplate);
        com.kwad.sdk.core.f.c cVar = this.CG;
        if (cVar != null) {
            cVar.a(by);
            return;
        }
        com.kwad.sdk.core.f.c cVar2 = new com.kwad.sdk.core.f.c(by);
        this.CG = cVar2;
        cVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kS() {
        this.CG.aX(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kT() {
        this.CD.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.1
            @Override // java.lang.Runnable
            public final void run() {
                k.this.CD.kT();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kU() {
        if (com.kwad.components.ad.splashscreen.e.c.c(this.Cg)) {
            com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_rotate_action), -1, 60, -1, -1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
        com.kwad.sdk.core.f.c cVar = this.CG;
        if (cVar != null) {
            cVar.aY(getContext());
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void la() {
        com.kwad.sdk.core.report.a.ax(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("SplashRotatePresenter", "onUnbind");
        com.kwad.sdk.core.f.c cVar = this.CG;
        if (cVar != null) {
            cVar.aY(getContext());
        }
        if (this.Cg != null) {
            this.Cg.b(this);
        }
    }
}
