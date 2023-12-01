package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c3.class */
public interface c3 extends l2.a {
    @NetRequest(constQuery = "styleid=0", method = NetMethod.URL, path = "satellite", queryKeys = {com.umeng.analytics.pro.bh.aG, "x", "y", "version"}, useExtraQuery = false)
    String satelliteUrl(String str, String str2, String str3, String str4);

    @NetRequest(constQuery = "styleid=0", method = NetMethod.URL, path = "satellite", queryKeys = {com.umeng.analytics.pro.bh.aG, "x", "y", "version"})
    String satelliteUrl2(String str, String str2, String str3, String str4);
}
