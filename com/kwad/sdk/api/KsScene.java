package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsScene.class */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsScene$Builder.class */
    public static class Builder {
        private KsScene scene;

        @KsAdSdkApi
        public Builder(long j) {
            KsScene ksScene = (KsScene) Loader.get().newInstance(KsScene.class);
            this.scene = ksScene;
            ksScene.setPosId(j);
        }

        @KsAdSdkApi
        public Builder action(int i) {
            this.scene.setAction(i);
            return this;
        }

        @KsAdSdkApi
        public Builder adLabel(com.kwad.sdk.api.model.a aVar) {
            this.scene.setKsAdLabel(aVar);
            return this;
        }

        @KsAdSdkApi
        public Builder adNum(int i) {
            this.scene.setAdNum(i);
            return this;
        }

        @KsAdSdkApi
        public KsScene build() {
            return this.scene;
        }

        @KsAdSdkApi
        public Builder height(int i) {
            this.scene.setHeight(i);
            return this;
        }

        @KsAdSdkApi
        public Builder posId(long j) {
            this.scene.setPosId(j);
            return this;
        }

        @KsAdSdkApi
        public Builder promoteId(String str) {
            this.scene.setPromoteId(str);
            return this;
        }

        @KsAdSdkApi
        public Builder rewardCallbackExtraData(Map<String, String> map) {
            this.scene.setRewardCallbackExtraData(map);
            return this;
        }

        @KsAdSdkApi
        public Builder screenOrientation(int i) {
            this.scene.setScreenOrientation(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setBackUrl(String str) {
            this.scene.setBackUrl(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setBidResponse(String str) {
            this.scene.setBidResponse(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setBidResponseV2(String str) {
            this.scene.setBidResponseV2(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setComment(String str) {
            this.scene.setComment(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setNativeAdExtraData(NativeAdExtraData nativeAdExtraData) {
            this.scene.setNativeAdExtraData(nativeAdExtraData);
            return this;
        }

        @KsAdSdkApi
        public Builder setSplashExtraData(SplashAdExtraData splashAdExtraData) {
            this.scene.setSplashExtraData(splashAdExtraData);
            return this;
        }

        @KsAdSdkApi
        public Builder setUserCommRateBuying(int i) {
            this.scene.setUserCommRateBuying(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setUserCommRateSharing(int i) {
            this.scene.setUserCommRateSharing(i);
            return this;
        }

        @KsAdSdkApi
        public Builder width(int i) {
            this.scene.setWidth(i);
            return this;
        }
    }

    @KsAdSdkApi
    int getAction();

    @KsAdSdkApi
    int getAdNum();

    @KsAdSdkApi
    int getAdStyle();

    @KsAdSdkApi
    String getBackUrl();

    @KsAdSdkApi
    String getBidResponse();

    @KsAdSdkApi
    String getBidResponseV2();

    @KsAdSdkApi
    String getComment();

    @KsAdSdkApi
    int getHeight();

    @KsAdSdkApi
    long getPosId();

    @KsAdSdkApi
    String getPromoteId();

    @KsAdSdkApi
    Map<String, String> getRewardCallbackExtraData();

    @KsAdSdkApi
    int getScreenOrientation();

    @KsAdSdkApi
    long getUserCommRateBuying();

    @KsAdSdkApi
    long getUserCommRateSharing();

    @KsAdSdkApi
    int getWidth();

    @KsAdSdkApi
    void setAction(int i);

    @KsAdSdkApi
    void setAdNum(int i);

    @KsAdSdkApi
    void setAdStyle(int i);

    @KsAdSdkApi
    void setBackUrl(String str);

    @KsAdSdkApi
    void setBidResponse(String str);

    @KsAdSdkApi
    void setBidResponseV2(String str);

    @KsAdSdkApi
    void setComment(String str);

    @KsAdSdkApi
    void setHeight(int i);

    @KsAdSdkApi
    void setKsAdLabel(IKsAdLabel iKsAdLabel);

    @KsAdSdkApi
    void setNativeAdExtraData(NativeAdExtraData nativeAdExtraData);

    @KsAdSdkApi
    void setPosId(long j);

    @KsAdSdkApi
    void setPromoteId(String str);

    @KsAdSdkApi
    void setRewardCallbackExtraData(Map<String, String> map);

    @KsAdSdkApi
    void setScreenOrientation(int i);

    @KsAdSdkApi
    void setSplashExtraData(SplashAdExtraData splashAdExtraData);

    @KsAdSdkApi
    void setUserCommRateBuying(int i);

    @KsAdSdkApi
    void setUserCommRateSharing(int i);

    @KsAdSdkApi
    void setWidth(int i);

    @KsAdSdkApi
    JSONObject toJson();
}
