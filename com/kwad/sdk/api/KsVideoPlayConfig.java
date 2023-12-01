package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsVideoPlayConfig.class */
public interface KsVideoPlayConfig extends Serializable {

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsVideoPlayConfig$Builder.class */
    public static class Builder {
        private boolean showLandscape;
        private String showScene;
        private boolean skipLongTime;
        private boolean videoSoundEnable = true;

        @KsAdSdkApi
        public KsVideoPlayConfig build() {
            KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) Loader.get().newInstance(KsVideoPlayConfig.class);
            ksVideoPlayConfig.setShowScene(this.showScene);
            ksVideoPlayConfig.setShowLandscape(this.showLandscape);
            ksVideoPlayConfig.setSkipThirtySecond(this.skipLongTime);
            ksVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
            return ksVideoPlayConfig;
        }

        @KsAdSdkApi
        public Builder showLandscape(boolean z) {
            this.showLandscape = z;
            return this;
        }

        @KsAdSdkApi
        public Builder showScene(String str) {
            this.showScene = str;
            return this;
        }

        @KsAdSdkApi
        public Builder skipThirtySecond(boolean z) {
            this.skipLongTime = z;
            return this;
        }

        @KsAdSdkApi
        public Builder videoSoundEnable(boolean z) {
            this.videoSoundEnable = z;
            return this;
        }
    }

    @KsAdSdkApi
    String getShowScene();

    @KsAdSdkApi
    boolean isShowLandscape();

    @KsAdSdkApi
    boolean isSkipThirtySecond();

    @KsAdSdkApi
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    void setShowLandscape(boolean z);

    @KsAdSdkApi
    void setShowScene(String str);

    @KsAdSdkApi
    void setSkipThirtySecond(boolean z);

    @KsAdSdkApi
    void setVideoSoundEnable(boolean z);
}
