package com.kwad.sdk.core.response.model;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdStatusInfo.class */
public class AdStatusInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = 3728247893272878881L;
    public long downloadFinishTime;
    public long downloadSize;
    public int downloadType;
    public long loadDataTime;
    public boolean loadFromCache;

    public long getDownloadFinishTime() {
        return this.downloadFinishTime;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getLoadDataTime() {
        return this.loadDataTime;
    }

    public boolean isLoadFromCache() {
        return this.loadFromCache;
    }

    public void setDownloadFinishTime(long j) {
        this.downloadFinishTime = j;
    }

    public void setDownloadSize(long j) {
        this.downloadSize = j;
    }

    public void setDownloadType(int i) {
        this.downloadType = i;
    }

    public void setLoadDataTime(long j) {
        this.loadDataTime = j;
    }

    public void setLoadFromCache(boolean z) {
        this.loadFromCache = z;
    }
}
