package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j6.class */
public class j6 extends x6 {
    @Json(name = "showCount")
    private int b;

    public j6(long j) {
        super(j);
        this.b = 0;
    }

    public int b() {
        int i = this.b + 1;
        this.b = i;
        return i;
    }
}
