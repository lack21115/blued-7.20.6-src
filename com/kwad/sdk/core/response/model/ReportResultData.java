package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.network.BaseResultData;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/ReportResultData.class */
public class ReportResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final int CODE_RESULT_CHEATING_FLOW = 110009;

    public boolean isCheatingFlow() {
        return this.result == CODE_RESULT_CHEATING_FLOW;
    }
}
