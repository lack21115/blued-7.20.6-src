package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/actionbar/ActionBarAppLandscape.class */
public class ActionBarAppLandscape extends LinearLayout implements c {
    private AppScoreView AK;
    private TextProgressBar AL;
    private View AM;
    private a AN;
    private KsAppDownloadListener cE;
    private ImageView dJ;
    private TextView dK;
    private TextView dM;
    private TextView eE;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/actionbar/ActionBarAppLandscape$a.class */
    public interface a {
        void R(boolean z);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void b(View view, final boolean z) {
        boolean z2 = true;
        int i = view == this.AM ? 1 : 2;
        a.C0349a b = new a.C0349a(view.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper);
        if (view != this.AL) {
            z2 = false;
        }
        com.kwad.components.core.d.b.a.a(b.ao(z2).ap(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.AN != null) {
                    ActionBarAppLandscape.this.AN.R(z);
                }
            }
        }));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.AL.f(com.kwad.sdk.core.response.a.a.aw(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.AL.f(com.kwad.sdk.core.response.a.a.aH(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.AL.f(com.kwad.sdk.core.response.a.a.aw(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.AL.f(com.kwad.sdk.core.response.a.a.T(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    ActionBarAppLandscape.this.AL.f(com.kwad.sdk.core.response.a.a.bz(i), i);
                    ActionBarAppLandscape.this.AM.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.AL.f(com.kwad.sdk.core.response.a.a.by(i), i);
                    ActionBarAppLandscape.this.AM.setVisibility(8);
                }
            };
        }
        return this.cE;
    }

    private void initView() {
        k.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_title);
        this.eE = (TextView) findViewById(R.id.ksad_app_desc);
        this.AK = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dM = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.AL = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.kwai.a.a(getContext(), 16.0f));
        this.AL.setTextColor(-1);
        this.AM = findViewById(R.id.ksad_download_bar_cover);
    }

    private void kd() {
        float as = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
        boolean z = as >= 3.0f;
        if (z) {
            this.AK.setScore(as);
            this.AK.setVisibility(0);
        }
        String ar2 = com.kwad.sdk.core.response.a.a.ar(this.mAdInfo);
        boolean isEmpty = true ^ TextUtils.isEmpty(ar2);
        if (isEmpty) {
            this.dM.setText(ar2);
            this.dM.setVisibility(0);
        }
        if (isEmpty || z) {
            this.eE.setVisibility(8);
            return;
        }
        this.eE.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
        this.AK.setVisibility(8);
        this.dM.setVisibility(8);
        this.eE.setVisibility(0);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        this.AN = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(cb), adTemplate, 12);
        this.dK.setText(com.kwad.sdk.core.response.a.a.bK(this.mAdInfo));
        kd();
        this.AL.f(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo), 0);
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.AM, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
