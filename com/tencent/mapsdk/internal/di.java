package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/di.class */
public class di extends JsonComposer {
    @Json(name = "error")

    /* renamed from: a  reason: collision with root package name */
    private int f23710a = Integer.MIN_VALUE;
    @Json(name = "info")
    private ci b;

    public int a() {
        return this.f23710a;
    }

    public void a(int i) {
        this.f23710a = i;
    }

    public void a(ci ciVar) {
        this.b = ciVar;
    }

    public ci b() {
        return this.b;
    }
}
