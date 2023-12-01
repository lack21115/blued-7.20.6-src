package com.kwad.sdk.core.network;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/j.class */
public class j extends com.kwad.sdk.core.response.kwai.a {
    public int agA = 0;
    public String agB;
    public String agz;
    public String errorMsg;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return toJson().toString();
    }
}
