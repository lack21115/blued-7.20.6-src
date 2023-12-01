package com.tencent.map.tools.net.processor;

import com.tencent.map.tools.net.NetResponse;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/processor/ResponseProcessor.class */
public interface ResponseProcessor extends Processor {
    void onResponse(NetResponse netResponse) throws Exception;
}
