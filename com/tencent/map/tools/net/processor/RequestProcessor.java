package com.tencent.map.tools.net.processor;

import com.tencent.map.tools.net.NetRequest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/processor/RequestProcessor.class */
public interface RequestProcessor extends Processor {
    void onRequest(NetRequest netRequest) throws Exception;
}
