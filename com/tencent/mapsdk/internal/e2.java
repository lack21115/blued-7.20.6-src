package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e2.class */
public class e2 extends JsonComposer {
    @Json(name = "domain1")

    /* renamed from: a  reason: collision with root package name */
    public String f23712a;
    @Json(name = "dirNew")
    public String b;
    @Json(name = "domain")

    /* renamed from: c  reason: collision with root package name */
    public String f23713c;
    @Json(name = "fileversion")
    public int d;
    @Json(name = "updateData")
    public List<c2> e;

    public c2 a(OfflineItem offlineItem) {
        List<c2> list = this.e;
        if (list != null) {
            for (c2 c2Var : list) {
                if (c2Var.a(offlineItem)) {
                    c2Var.f23646a = "https://" + this.f23713c + this.b;
                    return c2Var;
                }
            }
            return null;
        }
        return null;
    }
}
