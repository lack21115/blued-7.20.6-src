package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o2.class */
public class o2 extends JsonComposer {
    @Json(name = "privacy_protection")

    /* renamed from: a  reason: collision with root package name */
    public boolean f23982a;
    @Json(name = "http_proxy")
    public List<HttpProxyRule> b;
}
