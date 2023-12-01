package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.kwai.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/view/playend/DrawVideoTailFrame.class */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    private KsDrawAd.AdInteractionListener bV;
    private KsAppDownloadListener cE;
    private AdBaseFrameLayout dG;
    private ImageView dH;
    private ViewGroup dI;
    private ImageView dJ;
    private TextView dK;
    private AppScoreView dL;
    private TextView dM;
    private TextView dN;
    private DrawDownloadProgressBar dO;
    private ViewGroup dP;
    private TextView dQ;
    private TextView dR;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(Context context) {
        super(context);
        D(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        D(context);
    }

    private void D(Context context) {
        k.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.dH = (ImageView) findViewById(R.id.ksad_video_cover);
        this.dI = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_name);
        this.dL = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dM = (TextView) findViewById(R.id.ksad_app_download_count);
        this.dN = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.dO = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.dP = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.dQ = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dR = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aw(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aH(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aw(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.T(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                super.onPaused(i);
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.xw(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.dO;
                drawDownloadProgressBar.f(i + "%", i);
            }
        };
    }

    public final void aX() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.cE;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.cE = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void bindView(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        AdInfo.AdMaterialInfo.MaterialFeature aN = com.kwad.sdk.core.response.a.a.aN(cb);
        String str = aN.coverUrl;
        this.mLogoView.S(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = aN.width;
            int i2 = aN.height;
            if (i > 0 && i > i2) {
                int screenWidth = com.kwad.sdk.c.kwai.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i3 = (int) (screenWidth * (i2 / i));
                ViewGroup.LayoutParams layoutParams = this.dH.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i3;
            }
            KSImageLoader.loadImage(this.dH, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), this.mAdTemplate, 11);
            this.dK.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
            float as = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
            if (as >= 3.0f) {
                this.dL.setScore(as);
                this.dL.setVisibility(0);
            }
            this.dM.setText(com.kwad.sdk.core.response.a.a.ar(this.mAdInfo));
            this.dN.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
            this.dI.setVisibility(0);
            this.dP.setVisibility(8);
        } else {
            this.dQ.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
            this.dR.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
            this.dI.setVisibility(8);
            this.dP.setVisibility(0);
        }
        this.dO.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        boolean z = true;
        a.C0349a ap = new a.C0349a(getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.dO ? 1 : 2);
        if (view != this.dO) {
            z = false;
        }
        com.kwad.components.core.d.b.a.a(ap.ao(z).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.bV != null) {
                    DrawVideoTailFrame.this.bV.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.dG.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.cE) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.dG = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    public void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
