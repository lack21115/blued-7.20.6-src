package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.r.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/view/playcard/DrawCardH5.class */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private a dB;
    private ImageView dC;
    private TextView dD;
    private TextView dE;
    private ValueAnimator dz;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/view/playcard/DrawCardH5$a.class */
    public interface a {
        void aD();

        void aE();
    }

    public DrawCardH5(Context context) {
        super(context);
        D(context);
    }

    public DrawCardH5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawCardH5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        D(context);
    }

    private void D(Context context) {
        this.mContext = context;
        k.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.dC = (ImageView) findViewById(R.id.ksad_card_close);
        this.dD = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.dE = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void aO() {
        ValueAnimator valueAnimator = this.dz;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.dz.cancel();
        }
    }

    private void aW() {
        d(this.mHeight, 0);
    }

    private void d(int i, int i2) {
        aO();
        ValueAnimator b = m.b(this, i, i2);
        this.dz = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.dz.setDuration(300L);
        this.dz.start();
    }

    public final void a(AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.dB = aVar;
        this.dD.setText(com.kwad.sdk.core.response.a.a.an(cb));
        this.dE.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        this.dC.setOnClickListener(this);
        this.dE.setOnClickListener(this);
        this.mLogoView.S(adTemplate);
        setOnClickListener(this);
        this.dD.measure(View.MeasureSpec.makeMeasureSpec((com.kwad.sdk.utils.k.getScreenWidth(this.mContext) - (com.kwad.sdk.c.kwai.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.c.kwai.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.c.kwai.a.a(this.mContext, 100.0f) + this.dD.getMeasuredHeight();
    }

    public final void aU() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view != this.dC) {
            com.kwad.components.core.d.b.a.a(new a.C0519a(getContext()).I(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (DrawCardH5.this.dB != null) {
                        DrawCardH5.this.dB.aE();
                    }
                }
            }));
            return;
        }
        aW();
        a aVar = this.dB;
        if (aVar != null) {
            aVar.aD();
        }
    }

    public final void release() {
        aO();
    }
}
