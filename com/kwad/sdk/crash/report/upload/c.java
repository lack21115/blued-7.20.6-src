package com.kwad.sdk.crash.report.upload;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/upload/c.class */
public final class c extends com.kwad.sdk.core.network.b {
    public final Map<String, String> asD;

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.asD = hashMap;
        hashMap.put("did", str);
        this.asD.put("sid", str2);
        this.asD.put("fileExtend", str3);
        this.asD.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getBodyMap() {
        return this.asD;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.wm().C("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
