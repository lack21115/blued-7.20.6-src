package com.anythink.network.gdt;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATBiddingNotice.class */
public class GDTATBiddingNotice implements ATBiddingNotice {

    /* renamed from: a  reason: collision with root package name */
    Object f6091a;

    /* JADX INFO: Access modifiers changed from: protected */
    public GDTATBiddingNotice(Object obj) {
        this.f6091a = obj;
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(27:1|(2:3|4)(3:85|(1:87)|84)|8|(2:10|(1:15)(1:14))|16|(2:17|18)|(2:20|(20:22|23|(1:25)|27|(3:29|(1:31)(1:33)|32)|34|35|(2:37|38)|41|42|(2:44|45)|47|48|(2:50|51)|53|54|(2:56|57)|59|60|(2:62|63)(2:64|(2:66|67)(4:68|(2:70|71)|72|73))))|79|23|(0)|27|(0)|34|35|(0)|41|42|(0)|47|48|(0)|53|54|(0)|59|60|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(2:3|4)(3:85|(1:87)|84)|8|(2:10|(1:15)(1:14))|16|17|18|(2:20|(20:22|23|(1:25)|27|(3:29|(1:31)(1:33)|32)|34|35|(2:37|38)|41|42|(2:44|45)|47|48|(2:50|51)|53|54|(2:56|57)|59|60|(2:62|63)(2:64|(2:66|67)(4:68|(2:70|71)|72|73))))|79|23|(0)|27|(0)|34|35|(0)|41|42|(0)|47|48|(0)|53|54|(0)|59|60|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3 A[Catch: all -> 0x0206, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0206, blocks: (B:26:0x00a1, B:28:0x00ad, B:30:0x00c0, B:33:0x00d3), top: B:86:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015c A[Catch: all -> 0x020b, TryCatch #4 {all -> 0x020b, blocks: (B:41:0x0152, B:43:0x015c), top: B:91:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0173 A[Catch: all -> 0x020f, TryCatch #5 {all -> 0x020f, blocks: (B:45:0x0169, B:47:0x0173), top: B:93:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018a A[Catch: all -> 0x0213, TryCatch #0 {all -> 0x0213, blocks: (B:49:0x0180, B:51:0x018a), top: B:84:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a1 A[Catch: all -> 0x0217, TryCatch #2 {all -> 0x0217, blocks: (B:53:0x0197, B:55:0x01a1), top: B:88:0x0197 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b8 A[Catch: all -> 0x021b, TryCatch #3 {all -> 0x021b, blocks: (B:57:0x01ae, B:59:0x01b8, B:61:0x01c8, B:63:0x01d2, B:65:0x01e4, B:67:0x01ee), top: B:90:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c8 A[Catch: all -> 0x021b, TRY_ENTER, TryCatch #3 {all -> 0x021b, blocks: (B:57:0x01ae, B:59:0x01b8, B:61:0x01c8, B:63:0x01d2, B:65:0x01e4, B:67:0x01ee), top: B:90:0x01ae }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notifyBidLoss(java.lang.String r6, double r7, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.gdt.GDTATBiddingNotice.notifyBidLoss(java.lang.String, double, java.util.Map):void");
    }

    public void notifyBidWin(double d) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf((int) d));
        try {
            if (this.f6091a instanceof RewardVideoAD) {
                RewardVideoAD rewardVideoAD = (RewardVideoAD) this.f6091a;
                hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(rewardVideoAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f6091a != null ? this.f6091a.toString() : "");
                    sb.append(": notifyBidWin: ");
                    sb.append(hashMap.toString());
                    Log.i("GDTATBiddingNotice", sb.toString());
                }
                rewardVideoAD.sendWinNotification(hashMap);
                return;
            }
        } catch (Throwable th) {
        }
        try {
            if (this.f6091a instanceof UnifiedInterstitialAD) {
                UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) this.f6091a;
                hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(unifiedInterstitialAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f6091a != null ? this.f6091a.toString() : "");
                    sb2.append(": notifyBidWin: ");
                    sb2.append(hashMap.toString());
                    Log.i("GDTATBiddingNotice", sb2.toString());
                }
                unifiedInterstitialAD.sendWinNotification(hashMap);
                return;
            }
        } catch (Throwable th2) {
        }
        try {
            if (this.f6091a instanceof SplashAD) {
                SplashAD splashAD = (SplashAD) this.f6091a;
                hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(splashAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f6091a != null ? this.f6091a.toString() : "");
                    sb3.append(": notifyBidWin: ");
                    sb3.append(hashMap.toString());
                    Log.i("GDTATBiddingNotice", sb3.toString());
                }
                splashAD.sendWinNotification(hashMap);
                return;
            }
        } catch (Throwable th3) {
        }
        try {
            if (this.f6091a instanceof UnifiedBannerView) {
                UnifiedBannerView unifiedBannerView = (UnifiedBannerView) this.f6091a;
                hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(unifiedBannerView.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.f6091a != null ? this.f6091a.toString() : "");
                    sb4.append(": notifyBidWin: ");
                    sb4.append(hashMap.toString());
                    Log.i("GDTATBiddingNotice", sb4.toString());
                }
                unifiedBannerView.sendWinNotification(hashMap);
                return;
            }
        } catch (Throwable th4) {
        }
        if (this.f6091a instanceof GDTATNativeExpressAd) {
            GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) this.f6091a;
            hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativeExpressAd.b.getECPM()));
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f6091a != null ? this.f6091a.toString() : "");
                sb5.append(": notifyBidWin: ");
                sb5.append(hashMap.toString());
                Log.i("GDTATBiddingNotice", sb5.toString());
            }
            gDTATNativeExpressAd.b.sendWinNotification(hashMap);
        } else if (this.f6091a instanceof GDTATNativePatchAd) {
            GDTATNativePatchAd gDTATNativePatchAd = (GDTATNativePatchAd) this.f6091a;
            hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativePatchAd.f6105c.getECPM()));
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.f6091a != null ? this.f6091a.toString() : "");
                sb6.append(": notifyBidWin: ");
                sb6.append(hashMap.toString());
                Log.i("GDTATBiddingNotice", sb6.toString());
            }
            gDTATNativePatchAd.f6105c.sendWinNotification(hashMap);
        } else {
            if (this.f6091a instanceof GDTATNativeAd) {
                GDTATNativeAd gDTATNativeAd = (GDTATNativeAd) this.f6091a;
                hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativeAd.f6105c.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(this.f6091a != null ? this.f6091a.toString() : "");
                    sb7.append(": notifyBidWin: ");
                    sb7.append(hashMap.toString());
                    Log.i("GDTATBiddingNotice", sb7.toString());
                }
                gDTATNativeAd.f6105c.sendWinNotification(hashMap);
                return;
            }
            this.f6091a = null;
        }
    }
}
