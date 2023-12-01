package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r6.class */
public class r6 extends x6 {
    @Json(name = "ubs")
    private a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r6$a.class */
    public static class a extends x6 {
        @Json(name = "showCount")
        private int b;

        public a(long j) {
            super(j);
            this.b = 0;
        }

        public int b() {
            int i = this.b + 1;
            this.b = i;
            return i;
        }
    }

    public r6(long j) {
        super(j);
        this.b = new a(j);
    }

    public a b() {
        return this.b;
    }
}
