package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yh.class */
public class yh extends JsonComposer {

    /* renamed from: c  reason: collision with root package name */
    public static final int f24441c = 1;
    public static final int d = 2;
    public static final int e = 3;
    @Json(name = "scenetype")

    /* renamed from: a  reason: collision with root package name */
    private int f24442a;
    @Json(name = "tilesrc")
    private ei b;

    public int a() {
        return this.f24442a;
    }

    public void a(int i) {
        this.f24442a = i;
    }

    public void a(ei eiVar) {
        this.b = eiVar;
    }

    public ei b() {
        return this.b;
    }
}
