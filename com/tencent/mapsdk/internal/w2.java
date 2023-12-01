package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w2.class */
public interface w2 extends l2.a {
    @NetRequest(method = NetMethod.URL, path = "indoor_map")
    String getIndoorMapUrl();
}
