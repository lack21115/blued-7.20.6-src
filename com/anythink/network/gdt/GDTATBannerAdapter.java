package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.igexin.assist.sdk.AssistPushConsts;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATBannerAdapter.class */
public class GDTATBannerAdapter extends CustomBannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f6084a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f6085c;
    UnifiedBannerView d;
    int f;
    boolean g;
    boolean h;
    private final String j = GDTATBannerAdapter.class.getSimpleName();
    int e = 0;
    DownloadConfirmListener i = new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.1
        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                GDTATBannerAdapter.this.mImpressionEventListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATBannerAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATBannerAdapter$2.class */
    public final class AnonymousClass2 implements UnifiedBannerADListener {
        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClicked() {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClosed() {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATBannerAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATBannerAdapter.this.d));
            } catch (Throwable th) {
            }
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADReceive() {
            if (GDTATBannerAdapter.this.g && GDTATBannerAdapter.this.d != null) {
                GDTATBannerAdapter.this.d.setDownloadConfirmListener(GDTATBannerAdapter.this.i);
            }
            if (!GDTATBannerAdapter.this.h) {
                if (GDTATBannerAdapter.this.mLoadListener != null) {
                    GDTATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (GDTATBannerAdapter.this.mBiddingListener != null) {
                if (GDTATBannerAdapter.this.d == null) {
                    GDTATBannerAdapter.this.notifyATLoadFail("", "GDT: Offer had been destroy.");
                    return;
                }
                double ecpm = GDTATBannerAdapter.this.d.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATBannerAdapter.this.d);
                ATBiddingListener aTBiddingListener = GDTATBannerAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onNoAD(AdError adError) {
            GDTATBannerAdapter.this.d = null;
            GDTATBannerAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }
    }

    private void a(Activity activity, Map<String, Object> map) {
        UnifiedBannerView unifiedBannerView;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(this.f6085c) || this.h) {
            unifiedBannerView = new UnifiedBannerView(activity, this.b, anonymousClass2);
            GDTATInitManager.getInstance();
            unifiedBannerView.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            unifiedBannerView = new UnifiedBannerView(activity, this.b, anonymousClass2, null, this.f6085c);
        }
        int i = this.f;
        if (i > 0) {
            unifiedBannerView.setRefresh(i);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        this.d = unifiedBannerView;
        if (unifiedBannerView.getLayoutParams() == null) {
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        unifiedBannerView.loadAD();
    }

    static /* synthetic */ void a(GDTATBannerAdapter gDTATBannerAdapter, Activity activity, Map map) {
        UnifiedBannerView unifiedBannerView;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(gDTATBannerAdapter.f6085c) || gDTATBannerAdapter.h) {
            unifiedBannerView = new UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2);
            GDTATInitManager.getInstance();
            unifiedBannerView.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            unifiedBannerView = new UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2, null, gDTATBannerAdapter.f6085c);
        }
        int i = gDTATBannerAdapter.f;
        if (i > 0) {
            unifiedBannerView.setRefresh(i);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        gDTATBannerAdapter.d = unifiedBannerView;
        if (unifiedBannerView.getLayoutParams() == null) {
            gDTATBannerAdapter.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        unifiedBannerView.loadAD();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f6084a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.f6085c = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        this.g = ATInitMediation.getBooleanFromMap(map2, "ad_click_confirm_status", false);
        this.f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                int intFromMap = ATInitMediation.getIntFromMap(map, "nw_rft");
                this.f = intFromMap;
                this.f = (int) (intFromMap / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destory() {
        UnifiedBannerView unifiedBannerView = this.d;
        if (unifiedBannerView != null) {
            if (unifiedBannerView instanceof UnifiedBannerView) {
                unifiedBannerView.destroy();
            }
            this.d = null;
        }
    }

    public View getBannerView() {
        return this.d;
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.b;
    }

    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        this.f6084a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.f6085c = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        this.g = ATInitMediation.getBooleanFromMap(map2, "ad_click_confirm_status", false);
        this.f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                int intFromMap = ATInitMediation.getIntFromMap(map, "nw_rft");
                this.f = intFromMap;
                this.f = (int) (intFromMap / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f6084a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else if (context instanceof Activity) {
            runOnNetworkRequestThread(new Runnable() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.3
                @Override // java.lang.Runnable
                public final void run() {
                    GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.3.1
                        public final void onFail(String str) {
                            GDTATBannerAdapter.this.notifyATLoadFail("", str);
                        }

                        public final void onSuccess() {
                            GDTATBannerAdapter.a(GDTATBannerAdapter.this, (Activity) context, map);
                        }
                    });
                }
            });
        } else {
            notifyATLoadFail("", "Context must be activity.");
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
