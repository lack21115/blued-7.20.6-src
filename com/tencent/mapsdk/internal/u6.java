package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u6.class */
public class u6 extends x6 {
    @Json(name = "wtc")
    private int b;
    @Json(name = "bwtc")

    /* renamed from: c  reason: collision with root package name */
    private int f24349c;

    public u6(long j) {
        super(j);
    }

    public void a(int i) {
        this.f24349c += i;
    }

    public void b(int i) {
        this.b += i;
    }
}
