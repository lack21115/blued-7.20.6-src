package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetFileResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;
import com.tencent.mapsdk.internal.v3;
import com.tencent.mapsdk.internal.w3;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z2.class */
public interface z2 extends l2.a {
    @NetJceResolver(inJce = CSFileUpdateReq.class, outJce = SCFileUpdateRsp.class, queryRange = {5, 10})
    @NetRequest(constQuery = "pf=androidsdk&fr=02001", method = NetMethod.POST, path = "fileupdate", queryKeys = {"sdkver", "suid", "appsuid", "nt", "api_key"})
    w3.a<SCFileUpdateRsp> checkUpdate(String str, String str2, String str3, String str4, String str5, ArrayList<FileUpdateReq> arrayList, String str6, String str7, String str8, String str9, String str10);

    @NetFileResolver(outFile = d2.w, queryRange = {0})
    @NetRequest(authority = "mapapi.qq.com", method = NetMethod.GET, path = "sdk/config/offline_city_detail_v2.json")
    v3.a downloadOfflineMapCityList(String str);
}
