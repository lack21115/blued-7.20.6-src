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
    private int f37377a;
    @Json(name = "frontier")
    private bi b;
    @Json(name = "ver_data")

    /* renamed from: c  reason: collision with root package name */
    private List<yh> f37378c;
    @Json(name = "detail")
    private List<zh> d;

    public List<yh> a() {
        return this.f37378c;
    }

    public void a(int i2) {
        this.f37377a = i2;
    }

    public void a(bi biVar) {
        this.b = biVar;
    }

    public void a(List<yh> list) {
        this.f37378c = list;
    }

    public bi b() {
        return this.b;
    }

    public void b(List<zh> list) {
        this.d = list;
    }

    public int c() {
        return this.f37377a;
    }

    public List<zh> d() {
        return this.d;
    }
}
