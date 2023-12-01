package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sb.class */
public class sb implements ResponseProcessor {
    @Override // com.tencent.map.tools.net.processor.ResponseProcessor
    public void onResponse(NetResponse netResponse) {
        try {
            try {
                if (netResponse.available()) {
                    netResponse.data = NetUtil.toBytesThrow(netResponse.dataStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            ha.a((Closeable) netResponse.dataStream);
            netResponse.dataStream = null;
        }
    }
}
