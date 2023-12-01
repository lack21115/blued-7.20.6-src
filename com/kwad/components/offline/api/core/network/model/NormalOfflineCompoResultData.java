package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.network.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/model/NormalOfflineCompoResultData.class */
public class NormalOfflineCompoResultData extends BaseOfflineCompoResultData {
    public int code;
    public String data;
    public String header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.agf;
        this.header = null;
    }
}
