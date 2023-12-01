package com.anythink.network.baidu;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATBiddingNotice.class */
public class BaiduATBiddingNotice implements ATBiddingNotice {

    /* renamed from: a  reason: collision with root package name */
    Object f8863a;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduATBiddingNotice(Object obj) {
        this.f8863a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        synchronized (this) {
            boolean z = true;
            int hashCode = str.hashCode();
            if (hashCode != 50) {
                if (hashCode != 53) {
                    switch (hashCode) {
                        case 48627:
                            if (str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB)) {
                                z = true;
                                break;
                            }
                            break;
                        case 48628:
                            if (str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                } else if (str.equals("5")) {
                    z = true;
                }
            } else if (str.equals("2")) {
                z = false;
            }
            int i = z ? (z || z) ? 203 : 900 : 100;
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f8863a != null ? this.f8863a.toString() : "");
                sb.append(": notifyBidLoss lossCode:");
                sb.append(str);
                sb.append(",lossReaseon:");
                sb.append(i);
                Log.i("BaiduATBiddingNotice", sb.toString());
            }
            try {
                if (this.f8863a instanceof RewardVideoAd) {
                    ((RewardVideoAd) this.f8863a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f8863a instanceof SplashAd) {
                    ((SplashAd) this.f8863a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f8863a instanceof NativeResponse) {
                    ((NativeResponse) this.f8863a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f8863a instanceof ExpressResponse) {
                    ((ExpressResponse) this.f8863a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f8863a instanceof ExpressInterstitialAd) {
                    ((ExpressInterstitialAd) this.f8863a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f8863a instanceof FullScreenVideoAd) {
                    ((FullScreenVideoAd) this.f8863a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th6) {
            }
            this.f8863a = null;
        }
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d) {
        synchronized (this) {
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f8863a != null ? this.f8863a.toString() : "");
                sb.append(": notifyBidWin : second price:");
                sb.append(d);
                Log.i("BaiduATBiddingNotice", sb.toString());
            }
            try {
                if (this.f8863a instanceof RewardVideoAd) {
                    ((RewardVideoAd) this.f8863a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f8863a instanceof SplashAd) {
                    ((SplashAd) this.f8863a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f8863a instanceof NativeResponse) {
                    ((NativeResponse) this.f8863a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f8863a instanceof ExpressResponse) {
                    ((ExpressResponse) this.f8863a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f8863a instanceof ExpressInterstitialAd) {
                    ((ExpressInterstitialAd) this.f8863a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f8863a instanceof FullScreenVideoAd) {
                    ((FullScreenVideoAd) this.f8863a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th6) {
            }
            this.f8863a = null;
        }
    }
}
