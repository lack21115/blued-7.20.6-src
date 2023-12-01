package com.tencent.mapsdk.internal;

import android.os.BatteryManager;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/zh.class */
public class zh extends JsonComposer {
    @Json(name = BatteryManager.EXTRA_LEVEL)

    /* renamed from: a  reason: collision with root package name */
    private int[] f24474a;
    @Json(name = "districts")
    private List<ai> b;

    public void a(List<ai> list) {
        this.b = list;
    }

    public void a(int[] iArr) {
        this.f24474a = iArr;
    }

    public int[] a() {
        return this.f24474a;
    }

    public List<ai> b() {
        return this.b;
    }
}
