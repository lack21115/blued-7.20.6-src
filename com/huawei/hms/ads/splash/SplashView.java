package com.huawei.hms.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.f;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/splash/SplashView.class */
public class SplashView extends PPSSplashView {
    private SplashAdDisplayListener D;
    private SplashAdLoadListener F;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/splash/SplashView$SplashAdLoadListener.class */
    public static abstract class SplashAdLoadListener {
        public void onAdDismissed() {
        }

        public void onAdFailedToLoad(int i) {
        }

        public void onAdLoaded() {
        }
    }

    public SplashView(Context context) {
        super(context);
    }

    public SplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void Z() {
        Integer F;
        if (isLoading()) {
            SplashAdLoadListener splashAdLoadListener = this.F;
            if (splashAdLoadListener != null) {
                splashAdLoadListener.onAdFailedToLoad(4);
                return;
            }
            return;
        }
        ki splashPresenter = getSplashPresenter();
        if (splashPresenter.V()) {
            AdSlotParam adSlotParam = getAdSlotParam();
            if (!splashPresenter.B() || adSlotParam == null || (F = adSlotParam.F()) == null || F.intValue() != 0) {
                if (adSlotParam != null) {
                    ac.Code(getContext().getApplicationContext(), adSlotParam.B());
                }
                getSplashPresenter().Code();
                return;
            }
            String str = null;
            List<String> Code = adSlotParam.Code();
            if (!aa.Code(Code)) {
                str = Code.get(0);
            }
            splashPresenter.Code(str, 1);
            splashPresenter.C();
        }
    }

    private void setAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
        this.F = splashAdLoadListener;
        getSplashPresenter().Code(splashAdLoadListener);
        if (getAdMediator() != null) {
            getAdMediator().Code(splashAdLoadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lh
    public void Code(int i) {
        super.Code(i);
        getAdMediator().Code(this.F);
        getAdMediator().Code(this.D);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.ls
    public void destroyView() {
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public boolean isLoaded() {
        return super.isLoaded();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public boolean isLoading() {
        return super.isLoading();
    }

    public void load(String str, int i, AdParam adParam, SplashAdLoadListener splashAdLoadListener) {
        this.C = System.currentTimeMillis();
        ge.V("SplashView", f.Code);
        setAdLoadListener(splashAdLoadListener);
        AdSlotParam.a aVar = new AdSlotParam.a();
        SplashAd.Code(getContext(), str, i, adParam, aVar);
        super.setAdSlotParam(aVar.S());
        Z();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.ls
    public void pauseView() {
        super.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.ls
    public void resumeView() {
        super.resumeView();
    }

    public void setAdDisplayListener(SplashAdDisplayListener splashAdDisplayListener) {
        this.D = splashAdDisplayListener;
        if (getAdMediator() != null) {
            getAdMediator().Code(this.D);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setAudioFocusType(int i) {
        super.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogo(View view) {
        super.setLogo(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogo(View view, int i) {
        super.setLogo(view, i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogoBitmap(Bitmap bitmap) {
        super.setLogoBitmap(bitmap);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogoResId(int i) {
        super.setLogoResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setMediaNameResId(int i) {
        super.setMediaNameResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setMediaNameString(String str) {
        super.setMediaNameString(str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        super.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setSloganResId(int i) {
        super.setSloganResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setSloganView(View view) {
        super.setSloganView(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setWideSloganResId(int i) {
        super.setWideSloganResId(i);
    }
}
