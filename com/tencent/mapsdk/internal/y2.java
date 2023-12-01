package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y2.class */
public interface y2 extends l2.a {
    @NetRequest(constQuery = "pf=androidsdk&fr=02001", method = NetMethod.POST, path = "fileupdate", queryKeys = {"sdkver", "suid", "appsuid", "nt", "api_key"})
    NetResponse configFileUpdate(String str, String str2, String str3, String str4, String str5, byte[] bArr);
}
