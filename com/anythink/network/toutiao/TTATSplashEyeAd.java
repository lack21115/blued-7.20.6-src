package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Rect;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEyeAd;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATSplashEyeAd.class */
public class TTATSplashEyeAd extends CustomSplashEyeAd {

    /* renamed from: a  reason: collision with root package name */
    CSJSplashAd f9154a;

    public TTATSplashEyeAd(ATBaseAdAdapter aTBaseAdAdapter, CSJSplashAd cSJSplashAd) {
        super(aTBaseAdAdapter);
        this.f9154a = cSJSplashAd;
    }

    private static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
        this.f9154a = null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(Context context) {
        int[] splashClickEyeSizeToDp;
        CSJSplashAd cSJSplashAd = this.f9154a;
        if (cSJSplashAd == null || context == null || (splashClickEyeSizeToDp = cSJSplashAd.getSplashClickEyeSizeToDp()) == null || splashClickEyeSizeToDp.length < 2) {
            return null;
        }
        return new int[]{a(context, splashClickEyeSizeToDp[0]), a(context, splashClickEyeSizeToDp[1])};
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        if (this.f9154a == null || this.mEyeAdContainer == null) {
            return;
        }
        this.f9154a.showSplashClickEyeView(this.mEyeAdContainer);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void show(Context context, Rect rect) {
        try {
            if (this.mEyeAdContainer == null) {
                if (this.mATSplashEyeAdListener != null) {
                    this.mATSplashEyeAdListener.onAdDismiss(false, "mEyeAdContainer = null");
                }
            } else if (this.mATSplashEyeAdListener != null) {
                this.mATSplashEyeAdListener.onAnimationStart(this.mSplashView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
