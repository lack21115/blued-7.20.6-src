package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z6.class */
public class z6 extends x6 {
    @Json(name = "customLayerTimes")
    private int b;

    public z6(long j) {
        super(j);
    }

    public int b() {
        int i = this.b + 1;
        this.b = i;
        return i;
    }
}
