package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.shell.events.NetFlowEvent;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h6.class */
public class h6 extends rb {
    public h6() {
    }

    public h6(HashMap<String, String> hashMap) {
        super(hashMap);
    }

    public void a() {
        u.d().onReport(new NetFlowEvent(this.f37741c));
    }

    @Override // com.tencent.mapsdk.internal.rb, com.tencent.map.tools.net.processor.ResponseProcessor
    public void onResponse(NetResponse netResponse) throws Exception {
        super.onResponse(netResponse);
        a();
    }
}
