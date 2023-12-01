package com.anythink.network.gdt;

import android.content.Context;
import android.graphics.Rect;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEyeAd;
import com.qq.e.ads.splash.SplashAD;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATSplashEyeAd.class */
public class GDTATSplashEyeAd extends CustomSplashEyeAd {

    /* renamed from: a  reason: collision with root package name */
    SplashAD f8970a;

    public GDTATSplashEyeAd(ATBaseAdAdapter aTBaseAdAdapter, SplashAD splashAD) {
        super(aTBaseAdAdapter);
        this.mAtBaseAdAdapter = aTBaseAdAdapter;
        this.f8970a = splashAD;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
        this.f8970a = null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(Context context) {
        return null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        SplashAD splashAD = this.f8970a;
        if (splashAD != null) {
            splashAD.zoomOutAnimationFinish();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void show(Context context, Rect rect) {
        try {
            if (this.mATSplashEyeAdListener != null) {
                this.mATSplashEyeAdListener.onAnimationStart(this.mSplashView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
