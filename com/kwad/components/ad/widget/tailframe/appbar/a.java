package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/tailframe/appbar/a.class */
public abstract class a extends LinearLayout {
    protected AppScoreView AK;
    protected TextProgressBar Ba;
    protected View FY;
    protected TextView Hi;
    protected TextView dM;
    protected ValueAnimator iW;
    protected ImageView lv;
    protected TextView lw;
    protected View xF;
    protected Button xG;
    protected Button xH;
    protected KsAppTagsView xN;
    protected com.kwad.components.ad.g.a xQ;
    private Runnable xR;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(k.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }

    private void initView() {
        this.FY = k.inflate(getContext(), getLayoutId(), this);
        this.lv = (ImageView) findViewById(R.id.ksad_app_icon);
        this.lw = (TextView) findViewById(R.id.ksad_app_name);
        this.AK = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dM = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Hi = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.Ba = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.kwai.a.a(getContext(), 16.0f));
        this.Ba.setTextColor(-1);
        this.xN = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.xG = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.xH = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xF = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.xQ = new com.kwad.components.ad.g.a(this.FY);
    }

    private void lS() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.iW = ofFloat;
            ofFloat.setDuration(1200L);
            this.iW.setRepeatCount(-1);
            this.iW.setRepeatMode(1);
            this.iW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.Ba.setScaleY(floatValue);
                    a.this.Ba.setScaleX(floatValue);
                }
            });
            this.iW.start();
        }
    }

    public void bindView(AdTemplate adTemplate) {
        ImageView imageView;
        String bM;
        AdInfo cb = d.cb(adTemplate);
        if (d.p(adTemplate)) {
            imageView = this.lv;
            bM = com.kwad.sdk.core.response.a.a.cn(cb);
        } else {
            imageView = this.lv;
            bM = com.kwad.sdk.core.response.a.a.bM(cb);
        }
        KSImageLoader.loadAppIcon(imageView, bM, adTemplate, 12);
        this.lw.setText(com.kwad.sdk.core.response.a.a.bK(cb));
        if (!d.p(adTemplate)) {
            float as = com.kwad.sdk.core.response.a.a.as(cb);
            if (as >= 3.0f) {
                this.AK.setScore(as);
                this.AK.setVisibility(0);
            } else {
                this.AK.setVisibility(8);
            }
            String ar2 = com.kwad.sdk.core.response.a.a.ar(cb);
            if (TextUtils.isEmpty(ar2)) {
                this.dM.setVisibility(8);
            } else {
                this.dM.setText(ar2);
                this.dM.setVisibility(0);
            }
        }
        this.Hi.setText(com.kwad.sdk.core.response.a.a.an(cb));
        if (d.p(adTemplate)) {
            this.Ba.setVisibility(8);
            this.xF.setVisibility(0);
            this.xH.setText("查看详情");
            Button button = this.xG;
            StringBuilder sb = new StringBuilder();
            sb.append(com.kwad.sdk.core.config.d.uA());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.xR == null) {
                    this.xR = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.xQ.lB();
                        }
                    };
                }
                this.xF.postDelayed(this.xR, 1600L);
            }
        } else {
            this.Ba.setVisibility(0);
            this.xF.setVisibility(8);
            Runnable runnable = this.xR;
            if (runnable != null) {
                this.xF.removeCallbacks(runnable);
                this.xR = null;
            }
            x(d.cb(adTemplate));
        }
        if (d.p(adTemplate)) {
            List<String> bS = c.bS(adTemplate);
            if (bS.size() > 0) {
                this.xN.setVisibility(0);
            } else {
                this.xN.setVisibility(8);
            }
            this.xN.setAppTags(bS);
        }
    }

    public View getBtnInstallContainer() {
        return this.xF;
    }

    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.Ba;
    }

    public final void ki() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.iW.cancel();
            this.iW.end();
        }
        Runnable runnable = this.xR;
        if (runnable != null) {
            this.xF.removeCallbacks(runnable);
            this.xR = null;
        }
        this.xQ.lC();
    }

    public final void x(AdInfo adInfo) {
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            ki();
        } else {
            lS();
        }
    }
}
