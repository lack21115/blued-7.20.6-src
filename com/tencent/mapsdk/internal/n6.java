package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n6.class */
public class n6 extends x6 {
    @Json(name = "showCount")
    private int b;

    public n6(long j) {
        super(j);
        this.b = 0;
    }

    public int b() {
        int i = this.b + 1;
        this.b = i;
        return i;
    }
}
