package com.soft.blued.ui.welcome;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TopInterstitialFragment.class */
public final class TopInterstitialFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34615a = new Companion(null);
    private ATInterstitial b;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/TopInterstitialFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void b() {
        ATInterstitial aTInterstitial = new ATInterstitial(getActivity(), "b5baca53984692");
        HashMap hashMap = new HashMap();
        hashMap.put(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, true);
        aTInterstitial.setLocalExtra(hashMap);
        aTInterstitial.load();
        aTInterstitial.setAdListener(new ATInterstitialListener() { // from class: com.soft.blued.ui.welcome.TopInterstitialFragment$init$1$1
            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdClicked(ATAdInfo aTAdInfo) {
                Log.v("drb", "topon插屏广告点击");
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdClose(ATAdInfo aTAdInfo) {
                Log.v("drb", "topon插屏广告关闭");
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdLoadFail(AdError adError) {
                Log.v("drb", String.valueOf(Intrinsics.a("topon插屏广告失败：", (Object) adError)));
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdLoaded() {
                Log.v("drb", "topon插屏广告加载成功");
                ATInterstitial a2 = TopInterstitialFragment.this.a();
                if (a2 == null) {
                    return;
                }
                a2.show(TopInterstitialFragment.this.getActivity());
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdShow(ATAdInfo aTAdInfo) {
                Log.v("drb", "topon插屏广告曝光");
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoEnd(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoError(AdError adError) {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoStart(ATAdInfo aTAdInfo) {
            }
        });
        this.b = aTInterstitial;
    }

    public final ATInterstitial a() {
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        b();
        return inflater.inflate(R.layout.fragment_blued_interstitial, (ViewGroup) null);
    }
}
