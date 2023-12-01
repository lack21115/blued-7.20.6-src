package com.kwad.sdk.api;

import android.app.Activity;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsInterstitialAd.class */
public interface KsInterstitialAd extends BaseKSAd {

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsInterstitialAd$AdInteractionListener.class */
    public interface AdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onAdClosed();

        @KsAdSdkApi
        void onAdShow();

        @KsAdSdkApi
        void onPageDismiss();

        @KsAdSdkApi
        void onSkippedAd();

        @KsAdSdkApi
        void onVideoPlayEnd();

        @KsAdSdkApi
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    int getECPM();

    int getInteractionType();

    int getMaterialType();

    @KsAdSdkApi
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
