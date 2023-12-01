package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.k;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CpuChannelResponse.class */
public class CpuChannelResponse {
    private k mCpuChannelInfo;

    public CpuChannelResponse(k kVar) {
        this.mCpuChannelInfo = kVar;
    }

    public int getChannelId() {
        k kVar = this.mCpuChannelInfo;
        if (kVar != null) {
            return kVar.a();
        }
        return -1;
    }

    public String getChannelName() {
        k kVar = this.mCpuChannelInfo;
        return kVar != null ? kVar.b() : "";
    }
}
