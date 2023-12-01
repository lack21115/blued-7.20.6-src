package com.kwad.sdk.api.model;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/model/a.class */
public final class a implements IKsAdLabel {
    public int aaM;
    public int aaN;
    public String aaO;
    public String aaP;
    public String aaQ;
    public String aaR;
    public String aaS;
    public long aaT;

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getChannel() {
        return this.aaS;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final long getCpmBidFloor() {
        return this.aaT;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getHistoryTitle() {
        return this.aaR;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPostTitle() {
        return this.aaQ;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPrevTitle() {
        return this.aaP;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdAge() {
        return this.aaM;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdGender() {
        return this.aaN;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getThirdInterest() {
        return this.aaO;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setChannel(String str) {
        this.aaS = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setCpmBidFloor(long j) {
        this.aaT = j;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setHistoryTitle(String str) {
        this.aaR = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPostTitle(String str) {
        this.aaQ = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPrevTitle(String str) {
        this.aaP = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdAge(int i) {
        this.aaM = i;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdGender(int i) {
        this.aaN = i;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdInterest(String str) {
        this.aaO = str;
    }
}
