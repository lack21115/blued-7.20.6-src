package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/a/b.class */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    protected ImageView dJ;
    protected TextView dK;
    private TextView dR;
    protected TextView eA;
    protected ImageView eB;
    protected ImageView eC;
    protected RatioFrameLayout eD;
    protected TextView eE;
    private TextView eF;
    private View eG;
    protected DownloadProgressView eH;
    protected com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected KsLogoView mLogoView;

    public b(Context context) {
        super(context);
    }

    private void a(View view, final int i) {
        if (view == this.eC) {
            ru();
            return;
        }
        bi();
        boolean z = true;
        a.C0349a ap = new a.C0349a(getContext()).I(this.mAdTemplate).an(5).ao(i).b(this.mApkDownloadHelper).ap(view == this.eH ? 1 : 2);
        if (view != this.eH) {
            z = false;
        }
        com.kwad.components.core.d.b.a.a(ap.ao(z).a(new a.b() { // from class: com.kwad.components.ad.feed.a.b.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                b.this.aL(i);
            }
        }));
    }

    private void bl() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eF = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dR = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eG = findViewById(R.id.ksad_h5_open_cover);
        this.eF.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.dR.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
        this.eG.setOnClickListener(this);
        this.eF.setOnClickListener(this);
        this.dR.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        new com.kwad.sdk.widget.f(getContext(), this.dR, this);
    }

    private void bm() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.eE = textView;
        com.kwad.sdk.c.kwai.a.a(this, this.dJ, this.dK, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dJ, this);
        new com.kwad.sdk.widget.f(getContext(), this.dK, this);
        new com.kwad.sdk.widget.f(getContext(), this.eE, this);
        this.dK.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
        this.dJ.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), this.mAdTemplate, 8);
        this.eE.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        bj();
        this.eH.D(this.mAdTemplate);
        this.eH.setOnClickListener(this);
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, this.eH.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eH.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            a(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(final AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.eA.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.mLogoView.S(adTemplate);
        this.eB.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                if (com.kwad.sdk.core.response.a.a.aM(cb).height > com.kwad.sdk.core.response.a.a.aM(cb).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.eD.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.eD.setRatio(1.7857142686843872d);
                    b.this.eD.setLayoutParams(layoutParams);
                }
                List<String> aT = com.kwad.sdk.core.response.a.a.aT(b.this.mAdInfo);
                if (aT.size() > 0) {
                    KSImageLoader.loadFeeImage(b.this.eB, aT.get(0), b.this.mAdTemplate, b.this.ey);
                } else {
                    com.kwad.sdk.core.d.b.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                }
            }
        });
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            bm();
        } else {
            bl();
        }
        com.kwad.sdk.c.kwai.a.a(this, this.eA, this.eB, this.eC);
        new com.kwad.sdk.widget.f(getContext(), this.eA, this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        this.eA = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.eD = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eB = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bn() {
        super.bn();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eH.getAppDownloadListener());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a(view, view == this.eA ? 25 : view == this.eB ? 100 : (view == this.eH || view == this.dR || view == this.eG) ? 1 : view == this.dJ ? 13 : view == this.dK ? 14 : (view == this.eE || view == this.eF) ? 101 : 35);
    }
}
