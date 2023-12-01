package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsInnerAd.class */
public interface KsInnerAd {

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsInnerAd$KsInnerAdInteractionListener.class */
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        void onAdShow(KsInnerAd ksInnerAd);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsInnerAd$KsInnerAdType.class */
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
