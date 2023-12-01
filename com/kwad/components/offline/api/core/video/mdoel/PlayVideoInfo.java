package com.kwad.components.offline.api.core.video.mdoel;

import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/mdoel/PlayVideoInfo.class */
public class PlayVideoInfo {
    public final boolean isNoCache;
    public final KsPlayerLogParams ksplayerLogParams;
    public final String manifest;
    public final VideoPlayerStatus videoPlayerStatus;
    public final String videoUrl;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/video/mdoel/PlayVideoInfo$Builder.class */
    public static class Builder {
        private boolean isNoCache = false;
        private KsPlayerLogParams ksplayerLogParams;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public Builder(String str) {
            this.videoUrl = str;
        }

        public PlayVideoInfo build() {
            return new PlayVideoInfo(this);
        }

        public Builder ksplayerLogParams(KsPlayerLogParams ksPlayerLogParams) {
            this.ksplayerLogParams = ksPlayerLogParams;
            return this;
        }

        public Builder manifest(String str) {
            this.manifest = str;
            return this;
        }

        public Builder noCache(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public Builder videoPlayerStatus(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public Builder videoUrl(String str) {
            this.videoUrl = str;
            return this;
        }
    }

    private PlayVideoInfo(Builder builder) {
        this.ksplayerLogParams = new KsPlayerLogParams();
        this.videoUrl = builder.videoUrl;
        this.manifest = builder.manifest;
        this.videoPlayerStatus = builder.videoPlayerStatus;
        if (builder.ksplayerLogParams != null) {
            this.ksplayerLogParams.photoId = builder.ksplayerLogParams.photoId;
            this.ksplayerLogParams.clickTime = builder.ksplayerLogParams.clickTime;
            this.ksplayerLogParams.adStyle = builder.ksplayerLogParams.adStyle;
            this.ksplayerLogParams.contentType = builder.ksplayerLogParams.contentType;
        }
        this.isNoCache = builder.isNoCache;
    }
}
