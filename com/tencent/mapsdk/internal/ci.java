package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ci.class */
public class ci extends JsonComposer {
    public static int e = 0;
    public static final int f = 1000;
    public static int g = 100;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 7;
    @Json(name = "version")

    /* renamed from: a  reason: collision with root package name */
    private int f23686a;
    @Json(name = "frontier")
    private bi b;
    @Json(name = "ver_data")

    /* renamed from: c  reason: collision with root package name */
    private List<yh> f23687c;
    @Json(name = "detail")
    private List<zh> d;

    public List<yh> a() {
        return this.f23687c;
    }

    public void a(int i2) {
        this.f23686a = i2;
    }

    public void a(bi biVar) {
        this.b = biVar;
    }

    public void a(List<yh> list) {
        this.f23687c = list;
    }

    public bi b() {
        return this.b;
    }

    public void b(List<zh> list) {
        this.d = list;
    }

    public int c() {
        return this.f23686a;
    }

    public List<zh> d() {
        return this.d;
    }
}
