package com.soft.blued.customview.banner;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeDislikeListener;
import com.anythink.nativead.api.ATNativeEventListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.NativeAd;
import com.anythink.network.gdt.GDTATConst;
import com.anythink.network.toutiao.TTATConst;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.login.model.BluedADExtra;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/banner/TopNativeTemplateManager.class */
public class TopNativeTemplateManager<V> extends BannerAdManagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ATNative f28558a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28559c;
    private ATNativeAdView d;
    private BluedADExtra e;

    public TopNativeTemplateManager(ATNativeAdView aTNativeAdView, BluedADExtra bluedADExtra) {
        this.d = aTNativeAdView;
        this.e = bluedADExtra;
        this.b = AppInfo.l - DensityUtils.a(AppInfo.d(), 24.0f);
        if (this.e.bannerPosition == ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER || this.e.bannerPosition == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER) {
            this.b = AppInfo.l;
        }
        this.f28559c = this.b / 3;
    }

    private NativeAd a() {
        return this.e.bannerPosition == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER ? this.e.nativeAdGrid : this.e.bannerPosition == ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER ? this.e.nativeAdList : this.e.nativeAd;
    }

    private void a(NativeAd nativeAd, final BannerAdListener bannerAdListener) {
        nativeAd.setNativeEventListener(new ATNativeEventListener() { // from class: com.soft.blued.customview.banner.TopNativeTemplateManager.1
            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdClicked(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
                bannerAdListener.b();
                Log.i("drb", "native ad onAdClicked--------\n" + aTAdInfo.toString());
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdImpressed(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
                bannerAdListener.d();
                Log.i("drb", "native ad onAdImpressed--------\n" + aTAdInfo.toString());
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoEnd(ATNativeAdView aTNativeAdView) {
                Log.i("drb", "native ad onAdVideoEnd--------");
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoProgress(ATNativeAdView aTNativeAdView, int i) {
                Log.i("drb", "native ad onAdVideoProgress--------:" + i);
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoStart(ATNativeAdView aTNativeAdView) {
                Log.i("drb", "native ad onAdVideoStart--------");
            }
        });
        nativeAd.setDislikeCallbackListener(new ATNativeDislikeListener() { // from class: com.soft.blued.customview.banner.TopNativeTemplateManager.2
            @Override // com.anythink.nativead.api.ATNativeDislikeListener
            public void onAdCloseButtonClick(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
                Log.v("drb", "topon原生信息流广告：关闭按钮点击");
                bannerAdListener.c();
            }
        });
        try {
            Log.i("drb", "native ad start to render ad------------- ");
            this.d.removeAllViews();
            if (nativeAd.isNativeExpress()) {
                Log.i("drb", "topon原生模版");
                nativeAd.renderAdContainer(this.d, null);
            }
            nativeAd.prepare(this.d, null);
            nativeAd.onResume();
        } catch (Exception e) {
            Log.v("drb", "topon原生 e:" + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BannerAdListener bannerAdListener) {
        if (a() == null && this.f28558a != null) {
            if (this.e.bannerPosition == ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER) {
                this.e.nativeAdGrid = this.f28558a.getNativeAd();
            } else if (this.e.bannerPosition == ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER) {
                this.e.nativeAdList = this.f28558a.getNativeAd();
            } else {
                this.e.nativeAd = this.f28558a.getNativeAd();
            }
        }
        if (a() == null) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        Log.i("drb", "onBindAdViewHolder: NativeAd exist, start to render view.");
        Log.i("drb", "onBindAdViewHolder: RenderAd: " + a().getAdInfo().toString());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        this.d.setLayoutParams(layoutParams);
        a(a(), bannerAdListener);
    }

    @Override // com.soft.blued.customview.banner.BannerAdManagerAdapter, com.soft.blued.customview.banner.BannerAdManager
    public V a(Context context, String str, BannerAdListener bannerAdListener) {
        Log.v("drb", "getThirdBanner 请求topon原生广告");
        if (a() == null) {
            Log.v("drb", "getThirdBanner 请求topon原生广告 对象为空，首次请求");
            a(context, bannerAdListener, str);
            return null;
        }
        Log.v("drb", "getThirdBanner 请求topon原生广告 对象不为空，绘制UI");
        a(bannerAdListener);
        return null;
    }

    public void a(Context context, final BannerAdListener bannerAdListener, String str) {
        if (this.f28558a == null) {
            this.f28558a = new ATNative(context, str, new ATNativeNetworkListener() { // from class: com.soft.blued.customview.banner.TopNativeTemplateManager.3
                @Override // com.anythink.nativead.api.ATNativeNetworkListener
                public void onNativeAdLoadFail(AdError adError) {
                    Log.v("drb", "topon原生模版广告载入失败：" + adError.getFullErrorInfo());
                    try {
                        bannerAdListener.a(Integer.parseInt(adError.getCode()), adError.getDesc());
                    } catch (Exception e) {
                    }
                }

                @Override // com.anythink.nativead.api.ATNativeNetworkListener
                public void onNativeAdLoaded() {
                    Log.v("drb", "topon原生模版广告载入成功");
                    TopNativeTemplateManager.this.a(bannerAdListener);
                    bannerAdListener.a();
                }
            });
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(this.b));
        hashMap.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(this.f28559c));
        hashMap.put(TTATConst.NATIVE_AD_IMAGE_HEIGHT, 0);
        hashMap.put(GDTATConst.AD_HEIGHT, -2);
        this.f28558a.setLocalExtra(hashMap);
        this.f28558a.makeAdRequest();
        Log.i("drb", "native ad start to load ad------------- ");
    }
}
