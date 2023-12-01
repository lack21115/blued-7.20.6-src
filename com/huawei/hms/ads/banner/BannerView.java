package com.huawei.hms.ads.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.k;
import com.huawei.hms.ads.q;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.views.PPSBannerView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/banner/BannerView.class */
public class BannerView extends FrameLayout implements IBannerView {
    private static final String Code = BannerView.class.getSimpleName();
    private q I;
    private PPSBannerView V;

    public BannerView(Context context) {
        super(context);
        Code(context);
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
        Code(attributeSet);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
        Code(attributeSet);
    }

    private void Code(Context context) {
        this.V = new PPSBannerView(context);
        addView(this.V, new FrameLayout.LayoutParams(-2, -2));
        this.I = new k(context, this.V);
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        String str2;
        ge.Code(Code, "initDefAttr");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BannerView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    String string = obtainStyledAttributes.getString(R.styleable.BannerView_adId);
                    if (string != null && !string.isEmpty()) {
                        this.I.Code(string);
                    }
                    String string2 = obtainStyledAttributes.getString(R.styleable.BannerView_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        ge.Code(Code, "AdSize:%s", string2);
                        Code(string2);
                    }
                } catch (RuntimeException e) {
                    str = Code;
                    str2 = "initDefAttr " + e.getClass().getSimpleName();
                    ge.I(str, str2);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    str = Code;
                    str2 = "initDefAttr " + th.getClass().getSimpleName();
                    ge.I(str, str2);
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void Code(String str) {
        boolean z;
        q qVar;
        BannerAdSize bannerAdSize;
        switch (str.hashCode()) {
            case -2009976458:
                if (str.equals("BANNER_SIZE_300_250")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1952719272:
                if (str.equals("BANNER_SIZE_320_100")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1918932275:
                if (str.equals("BANNER_SIZE_ADVANCED")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1838202540:
                if (str.equals("BANNER_SIZE_360_144")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 681762071:
                if (str.equals("BANNER_SIZE_160_600")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 783647454:
                if (str.equals("BANNER_SIZE_SMART")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1393317908:
                if (str.equals("BANNER_SIZE_DYNAMIC")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1876671828:
                if (str.equals("BANNER_SIZE_320_50")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1880365919:
                if (str.equals("BANNER_SIZE_360_57")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1909233422:
                if (str.equals("BANNER_SIZE_468_60")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1991426884:
                if (str.equals("BANNER_SIZE_728_90")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_50;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_100;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_468_60;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_DYNAMIC;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_728_90;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_300_250;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_SMART;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_160_600;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_57;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_144;
                break;
            case true:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_ADVANCED;
                break;
            default:
                return;
        }
        qVar.Code(bannerAdSize);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void destroy() {
        this.V.S();
        this.I.Code();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public String getAdId() {
        return this.I.B();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public AdListener getAdListener() {
        return this.I.C();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public BannerAdSize getBannerAdSize() {
        return this.I.Z();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public boolean isLoading() {
        return this.I.S();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void loadAd(AdParam adParam) {
        this.I.Code(adParam);
        this.I.Code(this);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void pause() {
        this.I.V();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void resume() {
        this.I.I();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdId(String str) {
        this.I.Code(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdListener(AdListener adListener) {
        this.I.Code(adListener);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerAdSize(BannerAdSize bannerAdSize) {
        this.I.Code(bannerAdSize);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerRefresh(long j) {
        this.I.Code(j);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setContentBundle(String str) {
        this.I.V(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.I.Code(rewardVerifyConfig);
    }
}
