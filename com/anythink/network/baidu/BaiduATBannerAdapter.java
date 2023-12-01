package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATBannerAdapter.class */
public class BaiduATBannerAdapter extends CustomBannerAdapter {
    private static final String d = BaiduATBannerAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f8855a;
    AdView b;

    /* renamed from: c  reason: collision with root package name */
    FrameLayout f8856c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATBannerAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATBannerAdapter$1.class */
    public final class AnonymousClass1 implements AdViewListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdClick(JSONObject jSONObject) {
            if (BaiduATBannerAdapter.this.mImpressionEventListener != null) {
                BaiduATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdClose(JSONObject jSONObject) {
            if (BaiduATBannerAdapter.this.mImpressionEventListener != null) {
                BaiduATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdFailed(String str) {
            if (BaiduATBannerAdapter.this.mLoadListener != null) {
                BaiduATBannerAdapter.this.mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdReady(AdView adView) {
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdShow(JSONObject jSONObject) {
            if (BaiduATBannerAdapter.this.mLoadListener != null) {
                BaiduATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdSwitch() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATBannerAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATBannerAdapter$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8858a;

        AnonymousClass2(Context context) {
            this.f8858a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaiduATBannerAdapter.this.f8856c = new FrameLayout(this.f8858a);
            BaiduATBannerAdapter.this.f8856c.addView(BaiduATBannerAdapter.this.b, new FrameLayout.LayoutParams(-1, -1));
            BaiduATBannerAdapter.this.f8856c.setVisibility(4);
            final ViewGroup viewGroup = (ViewGroup) ((Activity) this.f8858a).getWindow().getDecorView();
            viewGroup.addView(BaiduATBannerAdapter.this.f8856c);
            BaiduATBannerAdapter.this.postOnMainThreadDelayed(new Runnable() { // from class: com.anythink.network.baidu.BaiduATBannerAdapter.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    viewGroup.removeView(BaiduATBannerAdapter.this.f8856c);
                }
            }, 100L);
        }
    }

    private void a() {
        AdView adView = this.b;
        if (adView != null && (adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        FrameLayout frameLayout = this.f8856c;
        if (frameLayout == null || !(frameLayout.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f8856c.getParent()).removeView(this.f8856c);
    }

    private void a(Context context) {
        AdView adView = new AdView(context, this.f8855a);
        this.b = adView;
        adView.setListener(new AnonymousClass1());
        postOnMainThread(new AnonymousClass2(context));
    }

    static /* synthetic */ void a(BaiduATBannerAdapter baiduATBannerAdapter, Context context) {
        AdView adView = new AdView(context, baiduATBannerAdapter.f8855a);
        baiduATBannerAdapter.b = adView;
        adView.setListener(new AnonymousClass1());
        baiduATBannerAdapter.postOnMainThread(new AnonymousClass2(context));
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        AdView adView = this.b;
        if (adView != null) {
            adView.setListener(null);
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f8855a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.f8855a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.f8855a)) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdLoadError("", "app_id or ad_place_id is empty.");
            }
        } else if (context instanceof Activity) {
            BaiduATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATBannerAdapter.3
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (BaiduATBannerAdapter.this.mLoadListener != null) {
                        BaiduATBannerAdapter.this.mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATBannerAdapter.a(BaiduATBannerAdapter.this, context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (BaiduATBannerAdapter.this.mLoadListener != null) {
                            ATCustomLoadListener aTCustomLoadListener = BaiduATBannerAdapter.this.mLoadListener;
                            aTCustomLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                        }
                    }
                }
            });
        } else if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError("", "Baidu Banner's context must be activity.");
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean supportImpressionCallback() {
        return false;
    }
}
