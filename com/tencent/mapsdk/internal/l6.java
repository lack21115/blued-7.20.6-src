package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l6.class */
public class l6 extends x6 {
    @Json(name = "styles")
    private List<a> b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l6$a.class */
    public static class a extends x6 {
        @Json(name = "id")
        private int b;
        @Json(name = "showCount")

        /* renamed from: c  reason: collision with root package name */
        private int f37608c;

        public a(long j, int i) {
            super(j);
            this.b = 0;
            this.f37608c = 0;
            this.b = i;
            this.f37608c = 1;
        }

        public static /* synthetic */ int b(a aVar) {
            int i = aVar.f37608c + 1;
            aVar.f37608c = i;
            return i;
        }
    }

    public l6(long j) {
        super(j);
        this.b = new ArrayList();
    }

    public int a(int i) {
        for (a aVar : this.b) {
            if (aVar.b == i) {
                return a.b(aVar);
            }
        }
        this.b.add(new a(this.f38104a, i));
        return 1;
    }
}
