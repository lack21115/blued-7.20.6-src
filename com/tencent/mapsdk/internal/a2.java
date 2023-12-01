package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineCity;
import com.tencent.map.sdk.comps.offlinemap.OfflineNation;
import com.tencent.map.sdk.comps.offlinemap.OfflineProvince;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a2.class */
public class a2 extends JsonComposer {
    @Json(name = "name")

    /* renamed from: a  reason: collision with root package name */
    public String f23594a;
    @Json(name = "pinyin")
    public String b;
    @Json(name = "cityList")

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f23595c;

    public OfflineCity a(OfflineProvince offlineProvince) {
        OfflineCity offlineCity = new OfflineCity();
        offlineCity.setName(this.f23594a);
        offlineCity.setPinyin(this.b);
        offlineCity.setProvince(offlineProvince);
        return offlineCity;
    }

    public OfflineNation a() {
        OfflineNation offlineNation = new OfflineNation();
        offlineNation.setName(this.f23594a);
        offlineNation.setPinyin(this.b);
        return offlineNation;
    }

    public OfflineProvince a(List<OfflineCity> list) {
        OfflineProvince offlineProvince = new OfflineProvince();
        offlineProvince.setName(this.f23594a);
        offlineProvince.setPinyin(this.b);
        offlineProvince.setCities(list);
        return offlineProvince;
    }
}
