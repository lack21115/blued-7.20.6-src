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
    Object f8980a;

    /* JADX INFO: Access modifiers changed from: protected */
    public KSATBiddingNotice(Object obj) {
        this.f8980a = obj;
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
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f8980a != null ? this.f8980a.getClass().getSimpleName() : "");
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
                if (this.f8980a instanceof KsRewardVideoAd) {
                    ((KsRewardVideoAd) this.f8980a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f8980a instanceof KsInterstitialAd) {
                    ((KsInterstitialAd) this.f8980a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f8980a instanceof KsFullScreenVideoAd) {
                    ((KsFullScreenVideoAd) this.f8980a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f8980a instanceof KsDrawAd) {
                    ((KsDrawAd) this.f8980a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f8980a instanceof KsFeedAd) {
                    ((KsFeedAd) this.f8980a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f8980a instanceof KsNativeAd) {
                    ((KsNativeAd) this.f8980a).reportAdExposureFailed(i, adExposureFailedReason);
                    return;
                }
            } catch (Throwable th6) {
            }
            this.f8980a = null;
        }
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d) {
        synchronized (this) {
            double d2 = d * 100.0d;
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f8980a != null ? this.f8980a.getClass().getSimpleName() : "");
                sb.append(": notifyBidWin : second price:");
                sb.append(d2);
                Log.i("KSATBiddingNotice", sb.toString());
            }
            try {
                if (this.f8980a instanceof KsRewardVideoAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsRewardVideoAd) this.f8980a).getECPM());
                    }
                    ((KsRewardVideoAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f8980a instanceof KsInterstitialAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsInterstitialAd) this.f8980a).getECPM());
                    }
                    ((KsInterstitialAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.f8980a instanceof KsFullScreenVideoAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsFullScreenVideoAd) this.f8980a).getECPM());
                    }
                    ((KsFullScreenVideoAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th3) {
            }
            try {
                if (this.f8980a instanceof KsDrawAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsDrawAd) this.f8980a).getECPM());
                    }
                    ((KsDrawAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th4) {
            }
            try {
                if (this.f8980a instanceof KsFeedAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsFeedAd) this.f8980a).getECPM());
                    }
                    ((KsFeedAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th5) {
            }
            try {
                if (this.f8980a instanceof KsNativeAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsNativeAd) this.f8980a).getECPM());
                    }
                    ((KsNativeAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th6) {
            }
            try {
                if (this.f8980a instanceof KsSplashScreenAd) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i("KSATBiddingNotice", "Origin price:" + ((KsSplashScreenAd) this.f8980a).getECPM());
                    }
                    ((KsSplashScreenAd) this.f8980a).setBidEcpm((int) d2);
                    return;
                }
            } catch (Throwable th7) {
            }
            this.f8980a = null;
        }
    }
}
