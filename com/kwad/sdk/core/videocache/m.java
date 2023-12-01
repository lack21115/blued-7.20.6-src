package com.kwad.sdk.core.videocache;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/m.class */
public final class m {
    public final long aoh;
    public final String aoi;
    public final String url;

    public m(String str, long j, String str2) {
        this.url = str;
        this.aoh = j;
        this.aoi = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aoh + ", mime='" + this.aoi + "'}";
    }
}
