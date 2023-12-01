package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d3.class */
public interface d3 extends l2.a {
    @NetRequest(constQuery = "styleid=7", method = NetMethod.URL, path = "scenic/", queryKeys = {"x", "y", com.umeng.analytics.pro.bh.aG, "version"}, useExtraQuery = false)
    String sketchTileUrl(int i, int i2, int i3, int i4);
}
