package com.qq.e.ads.banner2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/banner2/ADListenerAdapter.class */
class ADListenerAdapter implements ADListener {

    /* renamed from: a  reason: collision with root package name */
    private final UnifiedBannerADListener f14169a;
    private NegativeFeedbackListener b;

    /* renamed from: c  reason: collision with root package name */
    private ADRewardListener f14170c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f14169a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f14169a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
            }
        } else if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.f14169a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
        } else if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f14169a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
            }
        } else if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
            }
        } else {
            switch (type) {
                case 103:
                    UnifiedBannerADListener unifiedBannerADListener4 = this.f14169a;
                    if (unifiedBannerADListener4 != null) {
                        unifiedBannerADListener4.onADExposure();
                        return;
                    }
                    return;
                case 104:
                    if (this.f14170c == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    this.f14170c.onReward(hashMap);
                    return;
                case 105:
                    UnifiedBannerADListener unifiedBannerADListener5 = this.f14169a;
                    if (unifiedBannerADListener5 != null) {
                        unifiedBannerADListener5.onADClicked();
                        return;
                    }
                    return;
                case 106:
                    UnifiedBannerADListener unifiedBannerADListener6 = this.f14169a;
                    if (unifiedBannerADListener6 != null) {
                        unifiedBannerADListener6.onADClosed();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f14170c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.b = negativeFeedbackListener;
    }
}
