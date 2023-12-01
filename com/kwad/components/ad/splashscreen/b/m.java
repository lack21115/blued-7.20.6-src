package com.kwad.components.ad.splashscreen.b;

import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/m.class */
public final class m extends e {
    private AdMatrixInfo.SplashSlideInfo CQ;
    private TextView CR;
    private ImageView CS;
    private com.kwad.components.ad.splashscreen.widget.c CU;
    private KsSplashSlidePathView CV;
    private com.kwad.components.core.d.b.c CW;
    private double CX;
    private com.kwad.components.ad.splashscreen.e.a Cv;
    private TextView he;
    private AdInfo mAdInfo;
    private AdBaseFrameLayout mRootContainer;

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initView() {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.m.initView():void");
    }

    private void ld() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Cv;
        if (aVar != null) {
            aVar.setAdTemplate(this.Cg.mAdTemplate);
            return;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.m.3
            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void ac(String str) {
                m.this.CR.setText(str);
            }
        };
        this.Cv = aVar2;
        this.CW.b(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        if (this.CQ != null) {
            y.b bVar = new y.b();
            bVar.bx(this.CQ.style);
            com.kwad.sdk.core.report.a.a(this.Cg.mAdTemplate, 190, bVar, (JSONObject) null);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.Cg == null) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        this.CW = this.Cg.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            ld();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((ViewStub) findViewById(R.id.ksad_slide_layout)).inflate();
        this.he = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.CR = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.CS = (ImageView) findViewById(R.id.ksad_splash_slideView);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_splash_root_container);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.ksad_splash_slideTouchView)).inflate();
        this.CV = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1
            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f, float f2, float f3, float f4) {
                final float b = com.kwad.sdk.c.kwai.a.b(m.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                if (b < m.this.CX || m.this.Cg == null) {
                    return;
                }
                m.this.Cg.a(1, m.this.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1.1
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(com.kwad.sdk.core.report.i iVar) {
                        iVar.bq(m.this.CQ.style);
                        iVar.br((int) b);
                    }
                });
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void lf() {
                if (!o.o(m.this.mAdInfo) || m.this.Cg == null) {
                    return;
                }
                m.this.Cg.c(1, m.this.getContext(), 53, 2);
            }
        });
    }
}
