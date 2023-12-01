package com.anythink.network.baidu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.ExpressResponse;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativeExpressFeedAd.class */
public class BaiduATNativeExpressFeedAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6046a;
    private final ExpressResponse b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f6047c;

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativeExpressFeedAd$1.class */
    final class AnonymousClass1 implements ExpressResponse.ExpressInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdClick() {
            BaiduATNativeExpressFeedAd.this.notifyAdClicked();
            BaiduATInitManager.printLog("onAdClick() >>> ");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdExposed() {
            BaiduATNativeExpressFeedAd.this.notifyAdImpression();
            BaiduATInitManager.printLog("onAdExposed() >>> ");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderFail(View view, String str, int i) {
            BaiduATInitManager.printLog("onAdRenderFail() >>> s = " + str + " i = " + i);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderSuccess(View view, float f, float f2) {
            BaiduATInitManager.printLog("onAdRenderSuccess() >>> v = " + f + " v1 = " + f2);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdUnionClick() {
            BaiduATInitManager.printLog("onAdUnionClick() >>> ");
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativeExpressFeedAd$2.class */
    final class AnonymousClass2 implements ExpressResponse.ExpressDislikeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ExpressResponse f6049a;

        AnonymousClass2(ExpressResponse expressResponse) {
            this.f6049a = expressResponse;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeItemClick(String str) {
            BaiduATInitManager.printLog("onDislikeItemClick() >>> called reason = ".concat(String.valueOf(str)));
            BaiduATInitManager.printLog("onDislikeItemClick() >>> Dislike AD title: " + this.f6049a.getAdData().getTitle());
            BaiduATNativeExpressFeedAd.this.notifyAdDislikeClick();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowClose() {
            BaiduATInitManager.printLog("onDislikeWindowClose() >>> called");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowShow() {
            BaiduATInitManager.printLog("onDislikeWindowShow() >>> called");
        }
    }

    public BaiduATNativeExpressFeedAd(Context context, ExpressResponse expressResponse) {
        this.f6046a = context;
        this.b = expressResponse;
        this.f6047c = new FrameLayout(context);
        int adActionType = expressResponse.getAdActionType();
        int i = 3;
        if (adActionType == 1) {
            i = 2;
        } else if (adActionType == 2) {
            i = 1;
        } else if (adActionType != 3) {
            i = 0;
        }
        setNativeInteractionType(i);
    }

    private void a(ExpressResponse expressResponse) {
        expressResponse.setInteractionListener(new AnonymousClass1());
        expressResponse.setAdDislikeListener(new AnonymousClass2(expressResponse));
        expressResponse.render();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void destroy() {
        super.destroy();
        FrameLayout frameLayout = this.f6047c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f6047c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        FrameLayout frameLayout = this.f6047c;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        ExpressResponse expressResponse = this.b;
        if (expressResponse == null) {
            return;
        }
        expressResponse.setInteractionListener(new AnonymousClass1());
        expressResponse.setAdDislikeListener(new AnonymousClass2(expressResponse));
        expressResponse.render();
        View expressAdView = this.b.getExpressAdView();
        if (this.f6047c == null) {
            this.f6047c = new FrameLayout(this.f6046a);
        }
        if (this.f6047c.getChildCount() > 0) {
            this.f6047c.removeAllViews();
        }
        if (expressAdView != null) {
            ViewParent parent = expressAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(expressAdView);
            }
            this.f6047c.addView(expressAdView);
        }
    }
}
