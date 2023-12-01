package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/a/j.class */
public final class j extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView eA;
    private ImageView eB;
    private ImageView eC;
    private KsLogoView mLogoView;

    public j(Context context) {
        super(context);
    }

    private void c(View view, int i) {
        if (view == this.eC) {
            ru();
        } else if (com.kwad.components.core.d.b.d.b(new a.C0519a(getContext()).I(this.mAdTemplate), 1) == 1) {
            aL(i);
        } else {
            boolean ax = com.kwad.sdk.core.response.a.a.ax(this.mAdInfo);
            aL(i);
            if (ax) {
                FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.VS);
            } else {
                AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            c(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.eA.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        List<String> aT = com.kwad.sdk.core.response.a.a.aT(this.mAdInfo);
        this.mLogoView.S(adTemplate);
        if (aT.size() > 0) {
            KSImageLoader.loadFeeImage(this.eB, aT.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.b.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.c.kwai.a.a(this, this.eA, this.eB, this.eC);
        new com.kwad.sdk.widget.f(getContext(), this.eA, this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            bj();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.eA = (TextView) findViewById(R.id.ksad_ad_desc);
        this.eB = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        c(view, view == this.eA ? 25 : view == this.eB ? 100 : 35);
    }
}
