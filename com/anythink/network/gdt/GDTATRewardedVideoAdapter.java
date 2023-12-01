package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATRewardedVideoAdapter.class */
public class GDTATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private static final String f = GDTATRewardedVideoAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    RewardVideoAD f8955a;
    UnifiedInterstitialAD b;

    /* renamed from: c  reason: collision with root package name */
    String f8956c;
    String d;
    String e;
    private Map<String, Object> h;
    private boolean i;
    private int g = 0;
    private int j = 1;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATRewardedVideoAdapter$2.class */
    public final class AnonymousClass2 implements RewardVideoADListener {
        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClick() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClose() {
            GDTATInitManager.getInstance().a();
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADExpose() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATRewardedVideoAdapter.this.f8955a));
            } catch (Throwable th) {
            }
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADLoad() {
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.f8955a.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.h == null) {
                        GDTATRewardedVideoAdapter.this.h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.h.putAll(extraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (GDTATRewardedVideoAdapter.this.f8955a != null && GDTATRewardedVideoAdapter.this.i) {
                GDTATRewardedVideoAdapter.this.f8955a.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.2.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            GDTATRewardedVideoAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            if (GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                GDTATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onError(AdError adError) {
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATRewardedVideoAdapter.notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        }

        public final void onReward() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onReward(Map<String, Object> map) {
            if (GDTATRewardedVideoAdapter.this.h == null) {
                GDTATRewardedVideoAdapter.this.h = new HashMap();
            }
            GDTATRewardedVideoAdapter.this.h.put("gdt_trans_id", map.get("transId"));
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoCached() {
            if (!GDTATRewardedVideoAdapter.this.k) {
                if (GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                    GDTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (GDTATRewardedVideoAdapter.this.mBiddingListener == null || GDTATRewardedVideoAdapter.this.f8955a == null) {
            } else {
                double ecpm = GDTATRewardedVideoAdapter.this.f8955a.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.f8955a);
                ATBiddingListener aTBiddingListener = GDTATRewardedVideoAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoComplete() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATRewardedVideoAdapter$3.class */
    public final class AnonymousClass3 implements UnifiedInterstitialADListener {
        AnonymousClass3() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            GDTATInitManager.getInstance().b();
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATRewardedVideoAdapter.this.b));
            } catch (Throwable th) {
            }
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.b.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.h == null) {
                        GDTATRewardedVideoAdapter.this.h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.h.putAll(extraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (GDTATRewardedVideoAdapter.this.b != null && GDTATRewardedVideoAdapter.this.i) {
                GDTATRewardedVideoAdapter.this.b.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.3.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            GDTATRewardedVideoAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            GDTATRewardedVideoAdapter.this.b.setRewardListener(new ADRewardListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.3.2
                @Override // com.qq.e.comm.listeners.ADRewardListener
                public final void onReward(Map<String, Object> map) {
                    if (GDTATRewardedVideoAdapter.this.h == null) {
                        GDTATRewardedVideoAdapter.this.h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.h.put("gdt_trans_id", map.get("transId"));
                    if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                        GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
                    }
                }
            });
            if (GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                GDTATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(AdError adError) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (!GDTATRewardedVideoAdapter.this.k) {
                if (GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                    GDTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (GDTATRewardedVideoAdapter.this.mBiddingListener != null) {
                if (GDTATRewardedVideoAdapter.this.b == null) {
                    GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT : UnifiedInterstitialAD had been destroyed.");
                    return;
                }
                double ecpm = GDTATRewardedVideoAdapter.this.b.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.b);
                ATBiddingListener aTBiddingListener = GDTATRewardedVideoAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATRewardedVideoAdapter$4.class */
    public final class AnonymousClass4 implements UnifiedInterstitialMediaListener {
        AnonymousClass4() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoComplete() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoError(AdError adError) {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                CustomRewardedVideoEventListener customRewardedVideoEventListener = GDTATRewardedVideoAdapter.this.mImpressionListener;
                StringBuilder sb = new StringBuilder();
                sb.append(adError.getErrorCode());
                customRewardedVideoEventListener.onRewardedVideoAdPlayFailed(sb.toString(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoInit() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoLoading() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageClose() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageOpen() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPause() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoReady(long j) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoStart() {
        }
    }

    private void a(Context context, Map<String, Object> map) {
        boolean z = false;
        if (this.j != 2) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            if (TextUtils.isEmpty(this.e) || this.k) {
                Context applicationContext = context.getApplicationContext();
                String str = this.d;
                if (this.g != 1) {
                    z = true;
                }
                RewardVideoAD rewardVideoAD = new RewardVideoAD(applicationContext, str, anonymousClass2, z);
                this.f8955a = rewardVideoAD;
                GDTATInitManager.getInstance();
                rewardVideoAD.setLoadAdParams(GDTATInitManager.a(map));
            } else {
                this.f8955a = new RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1, this.e);
            }
            try {
                ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
                builder.setUserId(this.mUserId);
                if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                    this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
                }
                builder.setCustomData(this.mUserData);
                this.f8955a.setServerSideVerificationOptions(builder.build());
            } catch (Throwable th) {
            }
            this.f8955a.loadAD();
        } else if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
        } else {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            if (TextUtils.isEmpty(this.e) || this.k) {
                UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3);
                this.b = unifiedInterstitialAD;
                GDTATInitManager.getInstance();
                unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
            } else {
                this.b = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3, null, this.e);
            }
            UnifiedInterstitialAD unifiedInterstitialAD2 = this.b;
            int parseInt = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
            int parseInt2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
            int parseInt3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
            if (unifiedInterstitialAD2 != null) {
                VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(parseInt == 1);
                boolean z2 = false;
                if (parseInt == 1) {
                    z2 = true;
                }
                unifiedInterstitialAD2.setVideoOption(autoPlayMuted.setDetailPageMuted(z2).setAutoPlayPolicy(parseInt2).build());
                if (parseInt3 != -1) {
                    unifiedInterstitialAD2.setMaxVideoDuration(parseInt3);
                }
            }
            this.b.setMediaListener(new AnonymousClass4());
            this.b.loadFullScreenAD();
        }
    }

    static /* synthetic */ void a(GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter, Context context, Map map) {
        boolean z = false;
        if (gDTATRewardedVideoAdapter.j != 2) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            if (TextUtils.isEmpty(gDTATRewardedVideoAdapter.e) || gDTATRewardedVideoAdapter.k) {
                Context applicationContext = context.getApplicationContext();
                String str = gDTATRewardedVideoAdapter.d;
                if (gDTATRewardedVideoAdapter.g != 1) {
                    z = true;
                }
                RewardVideoAD rewardVideoAD = new RewardVideoAD(applicationContext, str, anonymousClass2, z);
                gDTATRewardedVideoAdapter.f8955a = rewardVideoAD;
                GDTATInitManager.getInstance();
                rewardVideoAD.setLoadAdParams(GDTATInitManager.a(map));
            } else {
                gDTATRewardedVideoAdapter.f8955a = new RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.d, anonymousClass2, gDTATRewardedVideoAdapter.g != 1, gDTATRewardedVideoAdapter.e);
            }
            try {
                ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
                builder.setUserId(gDTATRewardedVideoAdapter.mUserId);
                if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserData) && gDTATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                    gDTATRewardedVideoAdapter.mUserData = gDTATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, gDTATRewardedVideoAdapter.d);
                }
                builder.setCustomData(gDTATRewardedVideoAdapter.mUserData);
                gDTATRewardedVideoAdapter.f8955a.setServerSideVerificationOptions(builder.build());
            } catch (Throwable th) {
            }
            gDTATRewardedVideoAdapter.f8955a.loadAD();
        } else if (!(context instanceof Activity)) {
            gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
        } else {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            if (TextUtils.isEmpty(gDTATRewardedVideoAdapter.e) || gDTATRewardedVideoAdapter.k) {
                UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, gDTATRewardedVideoAdapter.d, anonymousClass3);
                gDTATRewardedVideoAdapter.b = unifiedInterstitialAD;
                GDTATInitManager.getInstance();
                unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
            } else {
                gDTATRewardedVideoAdapter.b = new UnifiedInterstitialAD((Activity) context, gDTATRewardedVideoAdapter.d, anonymousClass3, null, gDTATRewardedVideoAdapter.e);
            }
            UnifiedInterstitialAD unifiedInterstitialAD2 = gDTATRewardedVideoAdapter.b;
            int parseInt = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
            int parseInt2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
            int parseInt3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
            if (unifiedInterstitialAD2 != null) {
                VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(parseInt == 1);
                boolean z2 = false;
                if (parseInt == 1) {
                    z2 = true;
                }
                unifiedInterstitialAD2.setVideoOption(autoPlayMuted.setDetailPageMuted(z2).setAutoPlayPolicy(parseInt2).build());
                if (parseInt3 != -1) {
                    unifiedInterstitialAD2.setMaxVideoDuration(parseInt3);
                }
            }
            gDTATRewardedVideoAdapter.b.setMediaListener(new AnonymousClass4());
            gDTATRewardedVideoAdapter.b.loadFullScreenAD();
        }
    }

    private static void a(UnifiedInterstitialAD unifiedInterstitialAD, Map<String, Object> map) {
        int parseInt = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int parseInt2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int parseInt3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(parseInt == 1);
            boolean z = false;
            if (parseInt == 1) {
                z = true;
            }
            unifiedInterstitialAD.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(parseInt2).build());
            if (parseInt3 != -1) {
                unifiedInterstitialAD.setMaxVideoDuration(parseInt3);
            }
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f8956c = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.j = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.i = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
    }

    private void b(Context context, Map<String, Object> map) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        boolean z = false;
        if (TextUtils.isEmpty(this.e) || this.k) {
            Context applicationContext = context.getApplicationContext();
            String str = this.d;
            if (this.g != 1) {
                z = true;
            }
            RewardVideoAD rewardVideoAD = new RewardVideoAD(applicationContext, str, anonymousClass2, z);
            this.f8955a = rewardVideoAD;
            GDTATInitManager.getInstance();
            rewardVideoAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.f8955a = new RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1, this.e);
        }
        try {
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            builder.setUserId(this.mUserId);
            if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
            }
            builder.setCustomData(this.mUserData);
            this.f8955a.setServerSideVerificationOptions(builder.build());
        } catch (Throwable th) {
        }
        this.f8955a.loadAD();
    }

    private void c(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        if (TextUtils.isEmpty(this.e) || this.k) {
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3);
            this.b = unifiedInterstitialAD;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.b = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3, null, this.e);
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.b;
        int parseInt = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int parseInt2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int parseInt3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD2 != null) {
            VideoOption.Builder autoPlayMuted = new VideoOption.Builder().setAutoPlayMuted(parseInt == 1);
            boolean z = false;
            if (parseInt == 1) {
                z = true;
            }
            unifiedInterstitialAD2.setVideoOption(autoPlayMuted.setDetailPageMuted(z).setAutoPlayPolicy(parseInt2).build());
            if (parseInt3 != -1) {
                unifiedInterstitialAD2.setMaxVideoDuration(parseInt3);
            }
        }
        this.b.setMediaListener(new AnonymousClass4());
        this.b.loadFullScreenAD();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.f8955a != null) {
            this.f8955a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        RewardVideoAD rewardVideoAD = this.f8955a;
        if (rewardVideoAD != null) {
            return rewardVideoAD.isValid();
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        this.f8956c = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.j = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.i = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (TextUtils.isEmpty(this.f8956c) || TextUtils.isEmpty(this.d)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
            return;
        }
        GDTATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                GDTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                GDTATRewardedVideoAdapter.a(GDTATRewardedVideoAdapter.this, context, map);
            }
        });
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        if (this.f8955a != null) {
            try {
                GDTATInitManager.getInstance().a(this.d, this.f8955a);
                if (activity != null) {
                    this.f8955a.showAD(activity);
                } else {
                    this.f8955a.showAD();
                }
            } catch (Throwable th) {
                GDTATInitManager.getInstance().a();
                th.printStackTrace();
            }
        }
        if (this.b != null) {
            try {
                GDTATInitManager.getInstance().a(this.d, this.b);
                this.b.showFullScreenAD(activity);
            } catch (Throwable th2) {
                GDTATInitManager.getInstance().b();
                th2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.k = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
