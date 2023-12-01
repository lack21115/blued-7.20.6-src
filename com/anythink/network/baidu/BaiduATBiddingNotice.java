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
    Object f6023a;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduATBiddingNotice(Object obj) {
        this.f6023a = obj;
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        synchronized (this) {
            boolean z = true;
            int hashCode = str.hashCode();
            if (hashCode != 50) {
                if (hashCode != 53) {
                    switch (hashCode) {
                        case 48627:
                            if (str.equals("102")) {
                                z = true;
                                break;
                            }
                            break;
                        case 48628:
                            if (str.equals("103")) {
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
                sb.append(this.f6023a != null ? this.f6023a.toString() : "");
                sb.append(": notifyBidLoss lossCode:");
                sb.append(str);
                sb.append(",lossReaseon:");
                sb.append(i);
                Log.i("BaiduATBiddingNotice", sb.toString());
            }
            try {
                if (this.f6023a instanceof RewardVideoAd) {
                    ((RewardVideoAd) this.f6023a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f6023a instanceof SplashAd) {
                    ((SplashAd) this.f6023a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f6023a instanceof NativeResponse) {
                    ((NativeResponse) this.f6023a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f6023a instanceof ExpressResponse) {
                    ((ExpressResponse) this.f6023a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f6023a instanceof ExpressInterstitialAd) {
                    ((ExpressInterstitialAd) this.f6023a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f6023a instanceof FullScreenVideoAd) {
                    ((FullScreenVideoAd) this.f6023a).biddingFail(String.valueOf(i));
                    return;
                }
            } catch (Throwable th6) {
            }
            this.f6023a = null;
        }
    }

    public void notifyBidWin(double d) {
        synchronized (this) {
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6023a != null ? this.f6023a.toString() : "");
                sb.append(": notifyBidWin : second price:");
                sb.append(d);
                Log.i("BaiduATBiddingNotice", sb.toString());
            }
            try {
                if (this.f6023a instanceof RewardVideoAd) {
                    ((RewardVideoAd) this.f6023a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f6023a instanceof SplashAd) {
                    ((SplashAd) this.f6023a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f6023a instanceof NativeResponse) {
                    ((NativeResponse) this.f6023a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f6023a instanceof ExpressResponse) {
                    ((ExpressResponse) this.f6023a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f6023a instanceof ExpressInterstitialAd) {
                    ((ExpressInterstitialAd) this.f6023a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f6023a instanceof FullScreenVideoAd) {
                    ((FullScreenVideoAd) this.f6023a).biddingSuccess(String.valueOf(d));
                    return;
                }
            } catch (Throwable th6) {
            }
            this.f6023a = null;
        }
    }
}
