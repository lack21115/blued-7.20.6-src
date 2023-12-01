package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSRatingBar;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/p.class */
public final class p extends d implements View.OnClickListener {
    private ImageView fp;
    private TextView he;
    private TextView lP;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private DetailVideoView oM;
    private com.kwad.components.ad.reward.j qt;
    private int sU = Integer.MIN_VALUE;
    private ViewGroup sn;
    private ViewStub yD;
    private KSRatingBar zA;
    private TextView zB;
    private KsStyledTextButton zC;
    private TextView zD;
    private ViewGroup zz;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/p$a.class */
    static final class a {
        private String qh;
        private String qi;
        private String title;
        private float zF;
        private String zG;

        private a() {
        }

        public static a n(AdInfo adInfo) {
            if (adInfo == null) {
                return null;
            }
            a aVar = new a();
            aVar.title = com.kwad.sdk.core.response.a.a.bK(adInfo);
            aVar.qi = com.kwad.sdk.core.response.a.a.an(adInfo);
            aVar.qh = com.kwad.sdk.core.response.a.a.bM(adInfo);
            aVar.zF = com.kwad.sdk.core.response.a.a.au(adInfo);
            aVar.zG = com.kwad.sdk.core.response.a.a.ar(adInfo);
            return aVar;
        }

        public final float getRating() {
            return this.zF;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gm() {
            return this.qh;
        }

        public final String gn() {
            return this.qi;
        }

        public final String jX() {
            return this.zG;
        }
    }

    public p(AdTemplate adTemplate, com.kwad.components.ad.reward.j jVar, ViewGroup viewGroup, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.sn = viewGroup;
        this.qt = jVar;
        this.oM = detailVideoView;
    }

    public p(AdTemplate adTemplate, com.kwad.components.ad.reward.j jVar, ViewStub viewStub, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.yD = viewStub;
        this.qt = jVar;
        this.oM = detailVideoView;
    }

    private void initView() {
        this.zz = (ViewGroup) this.sn.findViewById(R.id.ksad_play_again_end_card);
        this.mLogoView = (KsLogoView) this.sn.findViewById(R.id.ksad_play_again_end_logo);
        this.fp = (ImageView) this.sn.findViewById(R.id.ksad_play_again_end_icon);
        this.he = (TextView) this.sn.findViewById(R.id.ksad_play_again_end_title);
        this.zA = (KSRatingBar) this.sn.findViewById(R.id.ksad_play_again_end_score);
        this.zB = (TextView) this.sn.findViewById(R.id.ksad_play_again_end_count);
        this.lP = (TextView) this.sn.findViewById(R.id.ksad_play_again_end_desc);
        this.zC = (KsStyledTextButton) this.sn.findViewById(R.id.ksad_play_again_end_btn_download);
        this.zD = (TextView) this.sn.findViewById(R.id.ksad_play_again_end_btn_action);
        this.zz.setOnClickListener(this);
        this.zD.setOnClickListener(this);
        this.zC.setOnClickListener(this);
    }

    private void jV() {
        ViewGroup viewGroup = this.zz;
        if (viewGroup == null) {
            return;
        }
        viewGroup.getContext();
        boolean DL = ai.DL();
        if (this.zz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.zz.getLayoutParams();
            if (DL) {
                int dimensionPixelSize = this.zz.getResources().getDimensionPixelSize(R.dimen.ksad_play_again_end_height_with_logo);
                layoutParams.width = -1;
                layoutParams.height = dimensionPixelSize;
            } else {
                layoutParams.width = com.kwad.sdk.c.kwai.a.getScreenWidth(this.zz.getContext()) / 2;
                layoutParams.height = -1;
            }
            this.zz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(View view) {
        if (view == null || view.getWidth() == 0) {
            return;
        }
        view.getContext();
        if (ai.DL()) {
            view.setVisibility(0);
            Animator a2 = t.a(this.mAdTemplate, this.zz, this.oM);
            if (a2 != null) {
                a2.start();
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = -view.getWidth();
            this.zz.setLayoutParams(marginLayoutParams);
            Animator a3 = t.a(this.mAdTemplate, this.oM, view);
            view.setVisibility(0);
            if (a3 != null) {
                a3.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        AdTemplate adTemplate = vVar.getAdTemplate();
        this.mLogoView.S(adTemplate);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        a n = a.n(cb);
        this.he.setText(n.getTitle());
        this.zB.setText(n.jX());
        this.lP.setText(n.gn());
        this.zC.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        boolean ax = com.kwad.sdk.core.response.a.a.ax(cb);
        this.zz.getContext();
        boolean DL = ai.DL();
        Resources resources = this.zz.getResources();
        ViewGroup.LayoutParams layoutParams = this.fp.getLayoutParams();
        int i = 18;
        int i2 = 18;
        if (layoutParams != null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size);
            if (!DL) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size_horizontal);
                i = 14;
            } else if (ax) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size_download);
                i = 24;
            }
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.fp.setLayoutParams(layoutParams);
            i2 = i;
        }
        KSImageLoader.loadAppIcon(this.fp, n.gm(), adTemplate, i2);
        if (DL && ax) {
            if (n.getRating() < 0.0f) {
                this.zA.setVisibility(8);
            } else {
                this.zA.setVisibility(0);
                this.zA.setStar(n.getRating());
            }
            if (n.jX() == null) {
                this.zB.setVisibility(8);
            } else {
                this.zB.setVisibility(0);
                this.zB.setText(n.jX());
            }
        }
        if (ax) {
            return;
        }
        this.zB.setVisibility(8);
        this.zA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.d
    public final void ag(boolean z) {
        Resources resources = this.zz.getResources();
        ViewGroup.LayoutParams layoutParams = this.zz.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (z) {
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = gK().getResources().getDimensionPixelSize(R.dimen.ksad_play_again_end_animate_margin);
            }
            this.zz.setBackgroundColor(-1);
            this.he.setTextColor(resources.getColor(R.color.ksad_play_again_title_text_color));
            this.lP.setTextColor(resources.getColor(R.color.ksad_play_again_desc_text_color));
            this.sU = com.kwad.sdk.c.kwai.a.D(this.oM);
            com.kwad.sdk.c.kwai.a.n(this.oM, 49);
        } else {
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = 0;
            }
            this.he.setTextColor(resources.getColor(R.color.ksad_play_again_title_text_color_horizontal));
            this.lP.setTextColor(resources.getColor(R.color.ksad_play_again_desc_text_color_horizontal));
            this.zz.setBackgroundColor(resources.getColor(R.color.ksad_play_again_horizontal_bg));
        }
        if (marginLayoutParams != null) {
            this.zz.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.sn;
    }

    public final void hide() {
        ViewGroup viewGroup = this.sn;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void jW() {
        int i;
        DetailVideoView detailVideoView = this.oM;
        if (detailVideoView == null || (i = this.sU) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.c.kwai.a.n(detailVideoView, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view.equals(this.zD)) {
            this.qt.B(false);
            com.kwad.sdk.core.report.a.q(this.mAdTemplate, 164);
        } else if (view.equals(this.zz)) {
            this.qt.a(2, view.getContext(), 2, 2);
        } else if (view.equals(this.zC)) {
            this.qt.a(2, view.getContext(), 2, 1);
        }
    }

    public final void show() {
        ViewStub viewStub;
        if (this.sn == null && (viewStub = this.yD) != null) {
            this.sn = (ViewGroup) viewStub.inflate();
            initView();
        }
        if (this.mLogoView == null) {
            initView();
        }
        if (this.sn != null) {
            jV();
            this.sn.setVisibility(0);
            this.sn.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.p.1
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = p.this;
                    pVar.q(pVar.zz);
                }
            });
            y.b bVar = new y.b();
            bVar.akL = 205;
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 164, bVar, (JSONObject) null);
        }
    }
}
