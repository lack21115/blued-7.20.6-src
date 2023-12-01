package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/InterstitialAggregateManualTipsView.class */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager hZ;
    private ImageView iA;
    private ImageView iB;
    private int iC;
    private int iD;
    private final ViewPager.OnPageChangeListener iE;
    private ImageView iz;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    public InterstitialAggregateManualTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iE = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                ImageView imageView;
                float f;
                InterstitialAggregateManualTipsView.this.iC = i2;
                if (InterstitialAggregateManualTipsView.this.iC == InterstitialAggregateManualTipsView.this.iD - 1) {
                    imageView = InterstitialAggregateManualTipsView.this.iz;
                    f = 0.5f;
                } else {
                    imageView = InterstitialAggregateManualTipsView.this.iz;
                    f = 1.0f;
                }
                imageView.setAlpha(f);
                InterstitialAggregateManualTipsView.this.iA.setAlpha(f);
            }
        };
        this.mContext = context;
        initView();
    }

    private void cC() {
        int i = this.iC;
        if (i < this.iD - 1) {
            this.hZ.setCurrentItem(i + 1, true);
        }
    }

    private void initView() {
        k.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.iz = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.iA = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.iB = imageView;
        com.kwad.sdk.c.kwai.a.a(this, this.iz, this.iA, imageView);
    }

    public final void a(AdTemplate adTemplate, TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.hZ = transViewPager;
        this.iC = transViewPager.getCurrentItem();
        a aVar = (a) transViewPager.getAdapter();
        if (aVar == null) {
            return;
        }
        this.iD = aVar.getCount();
        new d(this.hZ.getContext()).a(this.hZ);
        this.hZ.addOnPageChangeListener(this.iE);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String cT = com.kwad.sdk.core.response.a.b.cT(cb);
        String cU = com.kwad.sdk.core.response.a.b.cU(cb);
        String cV = com.kwad.sdk.core.response.a.b.cV(cb);
        if (TextUtils.isEmpty(cT) || TextUtils.isEmpty(cU) || TextUtils.isEmpty(cV)) {
            setVisibility(8);
            return;
        }
        KSImageLoader.loadImage(this.iz, cT);
        KSImageLoader.loadImage(this.iA, cU);
        KSImageLoader.loadImage(this.iB, cV);
        com.kwad.sdk.core.report.a.b(adTemplate, 162, (JSONObject) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.ad.interstitial.e.c B;
        AdTemplate adTemplate;
        int i;
        Tracker.onClick(view);
        if (view.equals(this.iz)) {
            cC();
            adTemplate = this.mAdTemplate;
            i = 162;
        } else if (!view.equals(this.iA)) {
            if (!view.equals(this.iB) || (B = this.hZ.B(this.iC)) == null) {
                return;
            }
            B.ey();
            return;
        } else {
            cC();
            adTemplate = this.mAdTemplate;
            i = 36;
        }
        com.kwad.sdk.core.report.a.q(adTemplate, i);
    }
}
