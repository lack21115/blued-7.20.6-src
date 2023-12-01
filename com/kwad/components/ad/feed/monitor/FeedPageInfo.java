package com.kwad.components.ad.feed.monitor;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/monitor/FeedPageInfo.class */
public class FeedPageInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -1423277713849754339L;
    public int adNum;
    public long convertDuration;
    public int errorCode;
    public String errorMsg;
    public int expectedRenderType;
    public String extMsg;
    public long loadDataDuration;
    public int loadStatus;
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    public FeedPageInfo setAdNum(int i) {
        this.adNum = i;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j) {
        this.convertDuration = j;
        return this;
    }

    public FeedPageInfo setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public FeedPageInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i) {
        this.expectedRenderType = i;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j) {
        this.loadDataDuration = j;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i) {
        this.loadStatus = i;
        return this;
    }

    public FeedPageInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    public FeedPageInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public FeedPageInfo setRenderType(int i) {
        this.renderType = i;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j) {
        this.resourceLoadDuration = j;
        return this;
    }

    public FeedPageInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public FeedPageInfo setType(int i) {
        this.type = i;
        return this;
    }
}
