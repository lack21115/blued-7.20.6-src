package com.kwad.sdk.contentalliance.kwai.kwai;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/contentalliance/kwai/kwai/b.class */
public final class b {
    public com.kwad.sdk.contentalliance.kwai.kwai.a abv;
    public AdTemplate adTemplate;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/contentalliance/kwai/kwai/b$a.class */
    public static final class a {
        private com.kwad.sdk.contentalliance.kwai.kwai.a abv;
        private AdTemplate adTemplate;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public a(String str) {
            this.videoUrl = str;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a aV(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final a b(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
            this.abv = aVar;
            return this;
        }

        public final a bs(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a bt(String str) {
            this.manifest = str;
            return this;
        }

        public final b tR() {
            return new b(this, (byte) 0);
        }
    }

    private b(a aVar) {
        this.abv = new com.kwad.sdk.contentalliance.kwai.kwai.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.abv != null) {
            this.abv.photoId = aVar.abv.photoId;
            this.abv.clickTime = aVar.abv.clickTime;
            this.abv.adStyle = aVar.abv.adStyle;
            this.abv.contentType = aVar.abv.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }
}
