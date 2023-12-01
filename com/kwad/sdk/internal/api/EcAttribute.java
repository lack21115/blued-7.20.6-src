package com.kwad.sdk.internal.api;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/internal/api/EcAttribute.class */
public class EcAttribute implements Serializable {
    private static final long serialVersionUID = 5648759570127504312L;
    private String comment;
    private String promoteId;
    private long userCommRateBuying = 0;
    private long userCommRateSharing = 0;

    public String getComment() {
        return this.comment;
    }

    public String getPromoteId() {
        return this.promoteId;
    }

    public long getUserCommRateBuying() {
        return this.userCommRateBuying;
    }

    public long getUserCommRateSharing() {
        return this.userCommRateSharing;
    }

    public void setComment(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.comment = str2;
    }

    public void setPromoteId(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.promoteId = str2;
    }

    public void setUserCommRateBuying(long j) {
        this.userCommRateBuying = j;
    }

    public void setUserCommRateSharing(long j) {
        this.userCommRateSharing = j;
    }
}
