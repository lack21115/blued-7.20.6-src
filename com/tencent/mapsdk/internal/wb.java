package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.FileUploadResetException;
import com.tencent.map.tools.net.processor.RequestProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wb.class */
public class wb extends sb implements RequestProcessor {
    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) {
        netRequest.setRespHeaders("User-ReturnCode");
    }

    @Override // com.tencent.mapsdk.internal.sb, com.tencent.map.tools.net.processor.ResponseProcessor
    public void onResponse(NetResponse netResponse) {
        String headerField = netResponse.getHeaderField("User-ReturnCode");
        int parseInt = Integer.parseInt(headerField);
        if (parseInt != 0) {
            if (parseInt == -2) {
                netResponse.exception(new FileUploadResetException());
            }
            netResponse.exception(new Exception("FileUploader user error:" + headerField));
        }
    }
}
