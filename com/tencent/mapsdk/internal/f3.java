package com.tencent.mapsdk.internal;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f3.class */
public interface f3 extends l2.a {
    @NetRequest(constQuery = "p_ver=1", method = NetMethod.GET, path = "map/traffic/event", queryKeys = {RemoteMessageConst.MessageBody.PARAM})
    NetResponse mapTrafficEvent(String str);
}
