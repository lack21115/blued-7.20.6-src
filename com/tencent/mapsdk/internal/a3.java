package com.tencent.mapsdk.internal;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a3.class */
public interface a3 extends l2.a {
    @NetRequest(constQuery = "ctrlpf=vector&ctrlmb=and", method = NetMethod.GET, queryKeys = {"apikey", "ver", "ctrlver", "uk", "frontier", "scenetype", IAdInterListener.AdReqParam.MPT})
    NetResponse checkAuth(String str, String str2, int i, String str3, int i2, int i3, int i4);
}
