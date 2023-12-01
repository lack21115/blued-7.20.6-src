package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x2.class */
public interface x2 extends l2.a {
    @NetRequest(method = NetMethod.GET, path = "map/poi/detail", queryKeys = {"id", "key"})
    NetResponse poiDetail(String str, String str2);
}
