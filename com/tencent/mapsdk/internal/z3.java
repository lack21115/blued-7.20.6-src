package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.tools.Callback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z3.class */
public interface z3 extends TencentMapComponent.Component {
    VisualLayer a(VisualLayerOptions visualLayerOptions);

    void a(String str);

    void a(String str, int i);

    void a(String str, int i, int i2);

    void a(String str, Callback<byte[]> callback);

    void a(String str, byte[] bArr);

    void a(JSONObject jSONObject);

    void b(String str);

    void b(String str, Callback<byte[]> callback);

    void c(String str);

    boolean c();

    void d(String str);

    boolean e(String str);

    String f(String str);

    q1 getMapContext();
}
