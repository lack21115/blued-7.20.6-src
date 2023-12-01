package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;
import com.tencent.smtt.sdk.TbsVideoCacheTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u2.class */
public interface u2 extends l2.a {
    @NetRequest(constQuery = "channel=1&output=json&uuid=unknown", method = NetMethod.GET, path = "mkey/index.php/mkey/check", queryKeys = {"key", "key2", "pid", "pid2", "hm", "suid", com.umeng.analytics.pro.bh.x, "psv", "ver", "pf", "nt"})
    NetResponse checkAuth(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, String str10);

    @NetRequest(constQuery = "channel=1&output=json", method = NetMethod.GET, path = "sdkapis/v1/cos_token", queryKeys = {TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, "key", "pid"})
    NetResponse uploadToken(String str, String str2, String str3);
}
