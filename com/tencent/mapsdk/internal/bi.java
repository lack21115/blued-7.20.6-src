package com.tencent.mapsdk.internal;

import com.cdo.oaps.ad.OapsWrapper;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bi.class */
public class bi extends JsonComposer {
    @Json(name = "version")

    /* renamed from: a  reason: collision with root package name */
    private int f37331a = 0;
    @Json(name = OapsWrapper.KEY_PATH)
    private String b;

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.f37331a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.f37331a;
    }
}
