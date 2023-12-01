package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f4.class */
public class f4 extends JsonComposer {
    @Json(name = "enable")

    /* renamed from: a  reason: collision with root package name */
    private int f23738a;
    @Json(name = "layers")
    private List<e4> b;

    public List<e4> a() {
        return this.b;
    }

    public boolean b() {
        return this.f23738a == 1;
    }

    public String toString() {
        return "DataLayerInfo{enable=" + this.f23738a + ", layers=" + this.b + '}';
    }
}
