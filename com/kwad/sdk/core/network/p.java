package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/p.class */
public abstract class p<R extends g, T extends BaseResultData> implements h<R, T> {
    @Override // com.kwad.sdk.core.network.h
    public void onError(R r, int i, String str) {
    }

    @Override // com.kwad.sdk.core.network.h
    public void onStartRequest(R r) {
    }

    @Override // com.kwad.sdk.core.network.h
    public void onSuccess(R r, T t) {
    }
}
