package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bb;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/c.class */
public final class c extends e implements com.kwad.sdk.core.g.c {
    private TextView BY;
    private com.kwad.components.ad.splashscreen.widget.a BZ;
    private AdInfo.AdPreloadInfo Ca;
    private boolean Cb = false;
    private View Cc;
    private AdInfo rS;

    private SplashSkipViewModel kE() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        int i = this.rS.adSplashInfo.imageDisplaySecond <= 0 ? 5 : this.rS.adSplashInfo.imageDisplaySecond;
        int min = Math.min(this.rS.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.a.a.F(this.rS));
        if (com.kwad.sdk.core.response.a.a.aU(this.rS)) {
            i = min;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF() {
        this.Cg.ky();
        JSONObject jSONObject = new JSONObject();
        if (this.Cg.BG != null) {
            try {
                jSONObject.put("duration", this.Cg.BG.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        y.a aVar = new y.a();
        if (this.Cg.mTimerHelper != null) {
            aVar.duration = this.Cg.mTimerHelper.getTime();
        }
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, new com.kwad.sdk.core.report.i().bk(1).bp(22).a(aVar), jSONObject);
    }

    private void kH() {
        synchronized (this) {
            if (!this.Cb && this.BZ != null) {
                if (com.kwad.sdk.core.response.a.a.ce(this.rS) && com.kwad.sdk.core.response.a.a.cf(this.rS)) {
                    com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, 124, (JSONObject) null);
                    this.Cb = true;
                }
            }
        }
    }

    private static boolean q(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.a.a.cc(adInfo);
    }

    private void r(AdInfo adInfo) {
        this.BY = (TextView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_preload_tips);
        this.Ca = adInfo.adPreloadInfo;
        this.BY.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.Ca;
        if (adPreloadInfo == null || bb.isNullString(adPreloadInfo.preloadTips)) {
            this.BY.setVisibility(8);
            return;
        }
        this.BY.setVisibility(0);
        this.BY.setText(this.Ca.preloadTips);
    }

    private void s(AdInfo adInfo) {
        this.Cc = this.Cg.mRootContainer.findViewById(R.id.ksad_skip_view_area);
        if (!com.kwad.sdk.core.response.a.a.cd(adInfo) || adInfo.adSplashInfo.skipButtonPosition != 0) {
            this.Cc.setVisibility(8);
            return;
        }
        this.Cc.setVisibility(0);
        this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                c.this.kF();
            }
        });
        this.Cc.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ((View) c.this.BZ).post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int af = c.this.BZ.af(35);
                        ViewGroup.LayoutParams layoutParams = c.this.Cc.getLayoutParams();
                        layoutParams.width = af + com.kwad.sdk.c.kwai.a.a(c.this.Cg.mRootContainer.getContext(), 66.0f);
                        c.this.Cc.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        AdBaseFrameLayout adBaseFrameLayout;
        int i;
        super.ar();
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onBind");
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        this.rS = cb;
        r(cb);
        if (q(this.rS)) {
            adBaseFrameLayout = this.Cg.mRootContainer;
            i = R.id.ksad_splash_skip_view;
        } else {
            adBaseFrameLayout = this.Cg.mRootContainer;
            i = R.id.ksad_splash_circle_skip_view;
        }
        this.BZ = (com.kwad.components.ad.splashscreen.widget.a) adBaseFrameLayout.findViewById(i);
        this.BZ.a(kE(), this.rS);
        this.BZ.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.b.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void ac(int i2) {
                c.this.Cg.ab(i2);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kI() {
                c.this.kF();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kJ() {
                c.this.kG();
            }
        });
        s(this.rS);
        this.Cg.BH.a(this);
    }

    public final void kG() {
        this.Cg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.d.a.b.mF()) {
                    c.this.Cg.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Cg.kw();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onPageInvisible");
        this.BZ.u(this.rS);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onPageVisible");
        this.BZ.v(this.rS);
        kH();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Cg.BH.b(this);
        this.BZ.bn();
    }
}
