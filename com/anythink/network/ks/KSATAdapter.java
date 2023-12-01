package com.anythink.network.ks;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATAdapter.class */
public class KSATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    long f8972a;
    String b = "0";

    /* renamed from: c  reason: collision with root package name */
    boolean f8973c = false;
    String d = "0";
    String e;
    Context f;
    boolean g;
    double h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATAdapter$2.class */
    public final class AnonymousClass2 implements KsLoadManager.DrawAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8975a;

        AnonymousClass2(Context context) {
            this.f8975a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onDrawAdLoad(List<KsDrawAd> list) {
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (KsDrawAd ksDrawAd : list) {
                arrayList.add(new KSATDrawAd(this.f8975a, ksDrawAd));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (!KSATAdapter.this.g) {
                if (KSATAdapter.this.mLoadListener != null) {
                    KSATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsDrawAd ksDrawAd2 = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                double d = 0.0d;
                try {
                    d = ksDrawAd2.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksDrawAd2);
                ATBiddingListener aTBiddingListener = KSATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onError(int i, String str) {
            KSATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATAdapter$3.class */
    public final class AnonymousClass3 implements KsLoadManager.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8976a;

        AnonymousClass3(Context context) {
            this.f8976a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i, String str) {
            KSATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(List<KsFeedAd> list) {
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (KsFeedAd ksFeedAd : list) {
                arrayList.add(new KSATFeedAd(this.f8976a, ksFeedAd, KSATAdapter.this.f8973c));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (!KSATAdapter.this.g) {
                if (KSATAdapter.this.mLoadListener != null) {
                    KSATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsFeedAd ksFeedAd2 = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                double d = 0.0d;
                try {
                    d = ksFeedAd2.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksFeedAd2);
                ATBiddingListener aTBiddingListener = KSATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.ks.KSATAdapter$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATAdapter$4.class */
    public final class AnonymousClass4 implements KsLoadManager.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8977a;

        AnonymousClass4(Context context) {
            this.f8977a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onError(int i, String str) {
            KSATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onNativeAdLoad(List<KsNativeAd> list) {
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (KsNativeAd ksNativeAd : list) {
                arrayList.add(new KSATNativeAd(this.f8977a, ksNativeAd, KSATAdapter.this.f8973c));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (!KSATAdapter.this.g) {
                if (KSATAdapter.this.mLoadListener != null) {
                    KSATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsNativeAd ksNativeAd2 = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                double d = 0.0d;
                try {
                    d = ksNativeAd2.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksNativeAd2);
                ATBiddingListener aTBiddingListener = KSATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
            }
        }
    }

    private void a(Context context, Map<String, Object> map, int i) {
        Object obj = null;
        Object obj2 = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? map.get(ATAdConst.KEY.AD_WIDTH) : null;
        if (map.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
            obj = map.get(ATAdConst.KEY.AD_HEIGHT);
        }
        KsScene.Builder adNum = new KsScene.Builder(this.f8972a).adNum(this.g ? 1 : Math.min(i, 5));
        if (obj2 != null) {
            try {
                int parseDouble = (int) Double.parseDouble(obj2.toString());
                if (parseDouble > 0) {
                    adNum.width(parseDouble);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj != null) {
            try {
                int parseDouble2 = (int) Double.parseDouble(obj.toString());
                if (parseDouble2 > 0) {
                    adNum.height(parseDouble2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.e)) {
            adNum.setBidResponseV2(this.e);
            adNum.adNum(1);
        }
        KsScene build = adNum.build();
        if (TextUtils.equals("1", this.d)) {
            KsAdSDK.getLoadManager().loadDrawAd(build, new AnonymousClass2(context));
        } else if (TextUtils.equals("1", this.b)) {
            KsAdSDK.getLoadManager().loadConfigFeedAd(build, new AnonymousClass3(context));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(build, new AnonymousClass4(context));
        }
    }

    static /* synthetic */ void a(KSATAdapter kSATAdapter, Context context, Map map, int i) {
        Object obj = null;
        Object obj2 = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? map.get(ATAdConst.KEY.AD_WIDTH) : null;
        if (map.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
            obj = map.get(ATAdConst.KEY.AD_HEIGHT);
        }
        KsScene.Builder adNum = new KsScene.Builder(kSATAdapter.f8972a).adNum(kSATAdapter.g ? 1 : Math.min(i, 5));
        if (obj2 != null) {
            try {
                int parseDouble = (int) Double.parseDouble(obj2.toString());
                if (parseDouble > 0) {
                    adNum.width(parseDouble);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj != null) {
            try {
                int parseDouble2 = (int) Double.parseDouble(obj.toString());
                if (parseDouble2 > 0) {
                    adNum.height(parseDouble2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(kSATAdapter.e)) {
            adNum.setBidResponseV2(kSATAdapter.e);
            adNum.adNum(1);
        }
        KsScene build = adNum.build();
        if (TextUtils.equals("1", kSATAdapter.d)) {
            KsAdSDK.getLoadManager().loadDrawAd(build, new AnonymousClass2(context));
        } else if (TextUtils.equals("1", kSATAdapter.b)) {
            KsAdSDK.getLoadManager().loadConfigFeedAd(build, new AnonymousClass3(context));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(build, new AnonymousClass4(context));
        }
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.f8972a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException e) {
        }
        this.b = ATInitMediation.getStringFromMap(map, "layout_type", "0");
        if (map.containsKey("video_sound")) {
            this.f8973c = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "video_sound"));
        }
        this.d = ATInitMediation.getStringFromMap(map, "unit_type", "0");
        this.h = ATInitMediation.getDoubleFromMap(map, g.k.o);
        if (map.containsKey("payload")) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.h);
            return true;
        }
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f8972a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.f8972a);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, final Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
            return;
        }
        this.f = context.getApplicationContext();
        KSATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATAdapter.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                KSATAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                KSATAdapter kSATAdapter = KSATAdapter.this;
                KSATAdapter.a(kSATAdapter, kSATAdapter.f, map2, KSATAdapter.this.mRequestNum);
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.g = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
