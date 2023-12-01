package com.anythink.network.ks;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATBiddingNotice.class */
public class KSATBiddingNotice implements ATBiddingNotice {

    /* renamed from: a  reason: collision with root package name */
    Object f6140a;

    /* JADX INFO: Access modifiers changed from: protected */
    public KSATBiddingNotice(Object obj) {
        this.f6140a = obj;
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        synchronized (this) {
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6140a != null ? this.f6140a.getClass().getSimpleName() : "");
                sb.append(": notifyBidLoss lossCode:");
                sb.append(str);
                sb.append(",winPrice:");
                sb.append(d);
                Log.i("KSATBiddingNotice", sb.toString());
            }
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = (int) d;
            int i = 4;
            if (TextUtils.equals(str, "5")) {
                i = 3;
            }
            try {
                if (this.f6140a instanceof KsRewardVideoAd) {
                    ((KsRewardVideoAd) this.f6140a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f6140a instanceof KsInterstitialAd) {
                    ((KsInterstitialAd) this.f6140a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f6140a instanceof KsFullScreenVideoAd) {
                    ((KsFullScreenVideoAd) this.f6140a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f6140a instanceof KsDrawAd) {
                    ((KsDrawAd) this.f6140a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f6140a instanceof KsFeedAd) {
                    ((KsFeedAd) this.f6140a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f6140a instanceof KsNativeAd) {
                    ((KsNativeAd) this.f6140a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th6) {
            }
            this.f6140a = null;
        }
    }

    public void notifyBidWin(double d) {
        synchronized (this) {
            double d2 = d * 100.0d;
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6140a != null ? this.f6140a.getClass().getSimpleName() : "");
                sb.append(": notifyBidWin : second price:");
                sb.append(d2);
                Log.i("KSATBiddingNotice", sb.toString());
            }
            try {
                if (this.f6140a instanceof KsRewardVideoAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsRewardVideoAd) this.f6140a).getECPM());
                    }
                    ((KsRewardVideoAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f6140a instanceof KsInterstitialAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsInterstitialAd) this.f6140a).getECPM());
                    }
                    ((KsInterstitialAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f6140a instanceof KsFullScreenVideoAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsFullScreenVideoAd) this.f6140a).getECPM());
                    }
                    ((KsFullScreenVideoAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f6140a instanceof KsDrawAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsDrawAd) this.f6140a).getECPM());
                    }
                    ((KsDrawAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f6140a instanceof KsFeedAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsFeedAd) this.f6140a).getECPM());
                    }
                    ((KsFeedAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f6140a instanceof KsNativeAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsNativeAd) this.f6140a).getECPM());
                    }
                    ((KsNativeAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th6) {
            }
            try {
                if (this.f6140a instanceof KsSplashScreenAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsSplashScreenAd) this.f6140a).getECPM());
                    }
                    ((KsSplashScreenAd) this.f6140a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th7) {
            }
            this.f6140a = null;
        }
    }
}
