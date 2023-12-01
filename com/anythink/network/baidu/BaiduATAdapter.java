package com.anythink.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.anythink.network.baidu.BaiduATNativePortraitVideoAd;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.StyleParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATAdapter.class */
public class BaiduATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f8849a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f8850c;
    private BaiduNativeManager i;
    private double h = 0.0d;
    StyleParams.Builder d = new StyleParams.Builder();
    int e = 0;
    boolean f = false;
    boolean g = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.BaiduATAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATAdapter$2.class */
    public final class AnonymousClass2 implements BaiduATNativePortraitVideoAd.LoadCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8852a;

        AnonymousClass2(Context context) {
            this.f8852a = context;
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onFail(String str, String str2) {
            BaiduATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onSuccess(NativeResponse nativeResponse, CustomNativeAd customNativeAd) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(nativeResponse);
            BaiduATAdapter.a(BaiduATAdapter.this, arrayList, this.f8852a, customNativeAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATAdapter$a.class */
    public final class a implements BaiduNativeManager.ExpressAdListener {
        private final Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeFail(int i, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeLoad(List<ExpressResponse> list) {
            if (list == null || list.size() == 0) {
                BaiduATAdapter.this.notifyATLoadFail("", "Baidu ad return empty.");
            } else if (!BaiduATAdapter.this.f) {
                ArrayList arrayList = new ArrayList();
                for (ExpressResponse expressResponse : list) {
                    arrayList.add(new BaiduATNativeExpressFeedAd(this.b, expressResponse));
                }
                CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
                if (BaiduATAdapter.this.mLoadListener != null) {
                    BaiduATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                }
            } else {
                ExpressResponse expressResponse2 = list.get(0);
                BaiduATNativeExpressFeedAd baiduATNativeExpressFeedAd = new BaiduATNativeExpressFeedAd(this.b, expressResponse2);
                BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(expressResponse2);
                double d = 0.0d;
                try {
                    d = Double.parseDouble(expressResponse2.getECPMLevel());
                } catch (Throwable th) {
                }
                if (BaiduATAdapter.this.mBiddingListener != null) {
                    ATBiddingListener aTBiddingListener = BaiduATAdapter.this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(expressResponse2.hashCode());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), baiduATNativeExpressFeedAd);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNoAd(int i, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATAdapter$b.class */
    public final class b implements BaiduNativeManager.FeedAdListener {
        private final Context b;

        public b(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeFail(int i, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.size() == 0) {
                BaiduATAdapter.this.notifyATLoadFail("", "callback onNativeLoad but no ad");
            } else {
                BaiduATAdapter.a(BaiduATAdapter.this, list, this.b, null);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNoAd(int i, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    private void a(Context context) {
        this.i = new BaiduNativeManager(context, this.b);
        RequestParameters build = new RequestParameters.Builder().downloadAppConfirmPolicy(3).build();
        if (this.f && this.h > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATAdapter", "setBidFloor:" + ((int) this.h));
            }
            this.i.setBidFloor((int) this.h);
        }
        int i = this.e;
        if (i == 3) {
            new BaiduATNativePortraitVideoAd(context, this.i, build, this.g).load(new AnonymousClass2(context));
        } else if (i == 2) {
            this.i.loadExpressAd(build, new a(context));
        } else {
            this.i.loadFeedAd(build, new b(context));
        }
    }

    static /* synthetic */ void a(BaiduATAdapter baiduATAdapter, Context context) {
        baiduATAdapter.i = new BaiduNativeManager(context, baiduATAdapter.b);
        RequestParameters build = new RequestParameters.Builder().downloadAppConfirmPolicy(3).build();
        if (baiduATAdapter.f && baiduATAdapter.h > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATAdapter", "setBidFloor:" + ((int) baiduATAdapter.h));
            }
            baiduATAdapter.i.setBidFloor((int) baiduATAdapter.h);
        }
        int i = baiduATAdapter.e;
        if (i == 3) {
            new BaiduATNativePortraitVideoAd(context, baiduATAdapter.i, build, baiduATAdapter.g).load(new AnonymousClass2(context));
        } else if (i == 2) {
            baiduATAdapter.i.loadExpressAd(build, new a(context));
        } else {
            baiduATAdapter.i.loadFeedAd(build, new b(context));
        }
    }

    static /* synthetic */ void a(BaiduATAdapter baiduATAdapter, List list, Context context, CustomNativeAd customNativeAd) {
        ArrayList arrayList = new ArrayList();
        StyleParams build = baiduATAdapter.d.build();
        if (!baiduATAdapter.f) {
            if (baiduATAdapter.e == 3) {
                arrayList.add(customNativeAd);
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    NativeResponse nativeResponse = (NativeResponse) it.next();
                    arrayList.add(baiduATAdapter.e == 1 ? new BaiduATNativeExpressAd(context, nativeResponse, build) : new BaiduATNativeAd(context, nativeResponse));
                }
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (baiduATAdapter.mLoadListener != null) {
                baiduATAdapter.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                return;
            }
            return;
        }
        NativeResponse nativeResponse2 = (NativeResponse) list.get(0);
        int i = baiduATAdapter.e;
        if (i != 3) {
            customNativeAd = i == 1 ? new BaiduATNativeExpressAd(context, nativeResponse2, build) : new BaiduATNativeAd(context, nativeResponse2);
        }
        BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(nativeResponse2);
        double d = 0.0d;
        try {
            d = Double.parseDouble(nativeResponse2.getECPMLevel());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (baiduATAdapter.mBiddingListener != null) {
            ATBiddingListener aTBiddingListener = baiduATAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(nativeResponse2.hashCode());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAd);
        }
    }

    private void a(List<NativeResponse> list, Context context, CustomNativeAd customNativeAd) {
        ArrayList arrayList = new ArrayList();
        StyleParams build = this.d.build();
        if (!this.f) {
            if (this.e == 3) {
                arrayList.add(customNativeAd);
            } else {
                for (NativeResponse nativeResponse : list) {
                    arrayList.add(this.e == 1 ? new BaiduATNativeExpressAd(context, nativeResponse, build) : new BaiduATNativeAd(context, nativeResponse));
                }
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                return;
            }
            return;
        }
        NativeResponse nativeResponse2 = list.get(0);
        int i = this.e;
        if (i != 3) {
            customNativeAd = i == 1 ? new BaiduATNativeExpressAd(context, nativeResponse2, build) : new BaiduATNativeAd(context, nativeResponse2);
        }
        BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(nativeResponse2);
        double d = 0.0d;
        try {
            d = Double.parseDouble(nativeResponse2.getECPMLevel());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.mBiddingListener != null) {
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(nativeResponse2.hashCode());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAd);
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f8849a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f8850c = ATInitMediation.getStringFromMap(map, "payload");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        try {
            if (map2.containsKey(BaiduATConst.STYLE_BUILDER)) {
                Object obj = map2.get(BaiduATConst.STYLE_BUILDER);
                if (obj instanceof StyleParams.Builder) {
                    this.d = (StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.d.setShowActionButton(ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey("button_type")) {
                this.d.setRegionClick(ATInitMediation.getStringFromMap(map, "button_type").equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.d.setShowDialogFrame(ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            boolean z = true;
            if (ATInitMediation.getIntFromMap(map, "video_autoplay", 1) != 1) {
                z = false;
            }
            this.g = z;
        } catch (Exception e) {
            BaiduATInitManager.printLog("initRequestParams() >>> " + e.getMessage());
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.f8849a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f8850c = ATInitMediation.getStringFromMap(map, "payload");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        try {
            if (map2.containsKey(BaiduATConst.STYLE_BUILDER)) {
                Object obj = map2.get(BaiduATConst.STYLE_BUILDER);
                if (obj instanceof StyleParams.Builder) {
                    this.d = (StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.d.setShowActionButton(ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey("button_type")) {
                this.d.setRegionClick(ATInitMediation.getStringFromMap(map, "button_type").equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.d.setShowDialogFrame(ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            boolean z = true;
            if (ATInitMediation.getIntFromMap(map, "video_autoplay", 1) != 1) {
                z = false;
            }
            this.g = z;
        } catch (Exception e) {
            BaiduATInitManager.printLog("initRequestParams() >>> " + e.getMessage());
        }
        if (TextUtils.isEmpty(this.f8849a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "app_id or ad_place_id is empty.");
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATAdapter.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                BaiduATAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                try {
                    BaiduATAdapter.a(BaiduATAdapter.this, applicationContext);
                } catch (Throwable th) {
                    BaiduATAdapter baiduATAdapter = BaiduATAdapter.this;
                    baiduATAdapter.notifyATLoadFail("", "Baidu: init error, " + th.getMessage());
                }
            }
        });
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
