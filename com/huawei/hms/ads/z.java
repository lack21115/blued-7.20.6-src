package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.data.IInterstitialAd;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/z.class */
public class z {
    private String B;
    private OnMetadataChangedListener C;
    private Bundle D;
    private Context I;
    private String L;
    private RewardAdListener S;
    private AdListener Z;

    /* renamed from: a  reason: collision with root package name */
    private long f8977a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f8978c;
    private App d;
    private RewardVerifyConfig g;
    private com.huawei.openalliance.ad.inter.listeners.h h;
    private Integer i;
    private a V = a.IDLE;
    private List<IInterstitialAd> e = new ArrayList();
    private IInterstitialAd f = null;
    private IInterstitialAdStatusListener j = new IInterstitialAdStatusListener() { // from class: com.huawei.hms.ads.z.1
        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            if (z.this.Z != null) {
                z.this.Z.onAdClicked();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            if (z.this.Z != null) {
                z.this.Z.onAdClosed();
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdClosed();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            if (z.this.S != null) {
                z.this.S.onRewardAdCompleted();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i, int i2) {
            if (z.this.Z != null) {
                z.this.Z.onAdFailed(dq.Code(i));
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdFailedToLoad(dq.Code(i));
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            if (z.this.Z != null) {
                z.this.Z.onAdOpened();
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdOpened();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
            if (z.this.Z != null) {
                z.this.Z.onAdLeave();
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdLeftApp();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
            if (z.this.S != null) {
                z.this.S.onRewarded(new bx(z.this.f.B()));
            }
        }
    };
    private INonwifiActionListener k = new INonwifiActionListener() { // from class: com.huawei.hms.ads.z.2
        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(long j) {
            return false;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(AppInfo appInfo, long j) {
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/z$a.class */
    public enum a {
        IDLE,
        LOADING
    }

    public z(Context context) {
        this.I = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i) {
        ge.V("InterstitialAdManager", "onAdFailed, errorCode:" + i);
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.z.4
            @Override // java.lang.Runnable
            public void run() {
                z.this.b = System.currentTimeMillis();
                if (z.this.Z != null) {
                    z.this.Z.onAdFailed(dq.Code(i));
                }
                if (z.this.h != null) {
                    z.this.h.Code(i);
                }
                if (z.this.S != null) {
                    z.this.S.onRewardAdFailedToLoad(dq.Code(i));
                }
                eh.Code(z.this.I, i, z.this.L, 12, null, z.this.f8977a, z.this.b, z.this.f8978c);
            }
        });
    }

    private void Code(Context context) {
        for (IInterstitialAd iInterstitialAd : this.e) {
            if (iInterstitialAd != null && !iInterstitialAd.Z()) {
                this.f = iInterstitialAd;
                iInterstitialAd.Code(this.g);
                iInterstitialAd.setRewardAdListener(this.S);
                iInterstitialAd.setNonwifiActionListener(this.k);
                iInterstitialAd.show(context, this.j);
                return;
            }
        }
    }

    private void Code(AdParam adParam, AdSlotParam.a aVar) {
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.B);
        AdSlotParam.a V = aVar.Code(arrayList).V(com.huawei.openalliance.ad.utils.l.I(this.I));
        if (this.I.getResources().getConfiguration().orientation != 1) {
            i = 0;
        }
        V.Code(i).I(c.Z(this.I)).Z(c.B(this.I));
        Integer num = this.i;
        if (num != null) {
            aVar.S(num);
        }
        if (adParam != null) {
            RequestOptions Code = dr.Code(adParam.V());
            App app = Code.getApp();
            if (app != null) {
                this.d = app;
            }
            aVar.Code(Code).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).Code(this.d).I(adParam.I()).C(adParam.C());
            if (adParam.Code() != null) {
                aVar.Code(adParam.Code());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<IInterstitialAd>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        ge.V("InterstitialAdManager", sb.toString());
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.z.5
            @Override // java.lang.Runnable
            public void run() {
                z.this.b = System.currentTimeMillis();
                if (z.this.Z != null) {
                    z.this.Z.onAdLoaded();
                }
                if (z.this.S != null) {
                    z.this.S.onRewardAdLoaded();
                }
                eh.Code(z.this.I, 200, z.this.L, 12, map, z.this.f8977a, z.this.b, z.this.f8978c);
            }
        });
    }

    private boolean F() {
        if (!com.huawei.openalliance.ad.utils.v.Code(this.I)) {
            AdListener adListener = this.Z;
            if (adListener != null) {
                adListener.onAdFailed(5);
            }
            RewardAdListener rewardAdListener = this.S;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(5);
                return false;
            }
            return false;
        } else if (this.V == a.LOADING) {
            ge.V("InterstitialAdManager", "waiting for request finish");
            AdListener adListener2 = this.Z;
            if (adListener2 != null) {
                adListener2.onAdFailed(4);
            }
            RewardAdListener rewardAdListener2 = this.S;
            if (rewardAdListener2 != null) {
                rewardAdListener2.onRewardAdFailedToLoad(4);
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(this.B)) {
            ge.I("InterstitialAdManager", "empty ad ids");
            AdListener adListener3 = this.Z;
            if (adListener3 != null) {
                adListener3.onAdFailed(1);
            }
            RewardAdListener rewardAdListener3 = this.S;
            if (rewardAdListener3 != null) {
                rewardAdListener3.onRewardAdFailedToLoad(1);
                return false;
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Map<String, List<IInterstitialAd>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (List<IInterstitialAd> list : map.values()) {
            if (!aa.Code(list)) {
                for (IInterstitialAd iInterstitialAd : list) {
                    if (iInterstitialAd.f() || !iInterstitialAd.V()) {
                        ge.V("InterstitialAdManager", "ad is invalid, content id:" + iInterstitialAd.D());
                    } else {
                        this.e.add(iInterstitialAd);
                    }
                }
            }
        }
        OnMetadataChangedListener onMetadataChangedListener = this.C;
        if (onMetadataChangedListener != null) {
            onMetadataChangedListener.onMetadataChanged();
        }
    }

    public final Bundle C() {
        Bundle bundle = this.D;
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        return bundle2;
    }

    public final AdListener Code() {
        return this.Z;
    }

    public final void Code(Activity activity) {
        ge.V("InterstitialAdManager", "show activity");
        Code((Context) activity);
    }

    public final void Code(AdListener adListener) {
        this.Z = adListener;
    }

    public final void Code(AdParam adParam) {
        this.f8977a = System.currentTimeMillis();
        ge.V("InterstitialAdManager", com.huawei.openalliance.ad.constant.f.Code);
        if (F()) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(adParam, aVar);
            if (this.d != null && !com.huawei.openalliance.ad.utils.v.I(this.I)) {
                ge.I("InterstitialAdManager", "hms ver not support set appInfo.");
                Code(706);
                return;
            }
            com.huawei.openalliance.ad.utils.ac.Code(this.I.getApplicationContext(), aVar.V());
            this.V = a.LOADING;
            this.e.clear();
            BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
            baseAdReqParam.Code(this.f8977a);
            kk.Code(this.I, "interstitial_ad_load", aVar.S(), com.huawei.openalliance.ad.utils.z.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.z.3
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    z zVar;
                    int code;
                    z.this.f8978c = System.currentTimeMillis();
                    if (callResult.getCode() == 200) {
                        Map<String, List<AdContentData>> map = (Map) com.huawei.openalliance.ad.utils.z.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                        if (z.this.h != null) {
                            z.this.h.Code(map);
                        }
                        code = 204;
                        if (map != null && map.size() > 0) {
                            HashMap hashMap = new HashMap(map.size());
                            for (Map.Entry<String, List<AdContentData>> entry : map.entrySet()) {
                                String key = entry.getKey();
                                List<AdContentData> value = entry.getValue();
                                if (value != null) {
                                    ArrayList arrayList = new ArrayList(value.size());
                                    for (AdContentData adContentData : value) {
                                        if (z.this.L == null) {
                                            z.this.L = adContentData.E();
                                        }
                                        arrayList.add(new com.huawei.hms.ads.inter.data.a(adContentData));
                                    }
                                    hashMap.put(key, arrayList);
                                }
                            }
                            if (!com.huawei.openalliance.ad.utils.af.Code(hashMap)) {
                                z.this.V(hashMap);
                                if (!aa.Code(z.this.e)) {
                                    z.this.Code(hashMap);
                                    z.this.V = a.IDLE;
                                }
                            }
                        }
                        zVar = z.this;
                    } else {
                        zVar = z.this;
                        code = callResult.getCode();
                    }
                    zVar.Code(code);
                    z.this.V = a.IDLE;
                }
            }, String.class);
        }
    }

    public final void Code(OnMetadataChangedListener onMetadataChangedListener) {
        if (this.C != null) {
            ge.V("InterstitialAdManager", "Update ad metadata listener.");
        }
        this.C = onMetadataChangedListener;
    }

    public final void Code(RewardAdListener rewardAdListener) {
        if (this.S != null) {
            ge.V("InterstitialAdManager", "Update rewarded video listener.");
        }
        this.S = rewardAdListener;
    }

    public final void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.g = rewardVerifyConfig;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.h hVar) {
        this.h = hVar;
    }

    public void Code(Integer num) {
        this.i = num;
    }

    public final void Code(String str) {
        this.B = str;
    }

    public final boolean I() {
        if (aa.Code(this.e)) {
            return false;
        }
        for (IInterstitialAd iInterstitialAd : this.e) {
            if (iInterstitialAd != null && !iInterstitialAd.Z()) {
                return true;
            }
        }
        return false;
    }

    public final void S() {
        ge.V("InterstitialAdManager", "show");
        Code(this.I);
    }

    public final String V() {
        return this.B;
    }

    public final boolean Z() {
        return this.V == a.LOADING;
    }
}
