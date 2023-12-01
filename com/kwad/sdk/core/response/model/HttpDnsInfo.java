package com.kwad.sdk.core.response.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/HttpDnsInfo.class */
public class HttpDnsInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -6943205584670122267L;
    public List<IpInfo> recommendList = new ArrayList();
    public List<IpInfo> backUpList = new ArrayList();
    public List<IpInfo> otherList = new ArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/HttpDnsInfo$IpInfo.class */
    public static class IpInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6943205584670122266L;
        public String ip = "";
        public int weight;

        @Override // com.kwad.sdk.core.response.kwai.a
        public String toString() {
            try {
                return toJson().toString();
            } catch (Exception e) {
                return "";
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        try {
            return toJson().toString();
        } catch (Exception e) {
            return "";
        }
    }
}
