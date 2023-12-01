package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fu.class */
public class fu extends af {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fu$a.class */
    static class a implements IInterstitialAdStatusListener {
        private String Code;
        private RemoteCallResultCallback<String> V;

        a(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.b));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.F));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.f8827a));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i, int i2) {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.L));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.D));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
        }
    }

    public fu() {
        super(ai.i);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.fu.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    af.Code(remoteCallResultCallback, fu.this.Code, 3002, null, true);
                    ge.Code("JsbStartInterstitialAdActivity", "adContentData is null, start activity failed");
                    return;
                }
                new com.huawei.hms.ads.inter.data.a(adContentData).show(fu.this.Code(context), new a(remoteCallResultCallback, fu.this.Code));
                fu.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
