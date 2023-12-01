package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vb.class */
public class vb implements RequestProcessor, ResponseProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f38069a;

    public vb(boolean z) {
        this.f38069a = z;
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) {
        if (this.f38069a) {
            na.c(ma.k, "REQ[" + netRequest.mRequestId + "][" + netRequest.mNetMethod.name() + "]: " + netRequest.toString());
        }
    }

    @Override // com.tencent.map.tools.net.processor.ResponseProcessor
    public void onResponse(NetResponse netResponse) {
        if (this.f38069a) {
            na.c(ma.k, "RESP[" + netResponse.mRequestId + "]: " + netResponse.toHumanString());
        }
    }
}
