package com.kwad.sdk.crash.model.message;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/model/message/AnrReason.class */
public class AnrReason extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = 2458805633316742361L;
    public String mLongMsg;
    public String mShortMsg;
    public String mTag;

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return "mTag: " + this.mTag + "\nmShortMsg: " + this.mShortMsg + "\nmLongMsg: " + this.mLongMsg + '\n';
    }
}
