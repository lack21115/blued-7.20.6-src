package com.autonavi.aps.amapapi.restruct;

import com.amap.api.maps.model.MyLocationStyle;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public int f9252a = 0;
    public double b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f9253c = 0.0d;
    public long d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 63;
    public int h = 0;

    public final String a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("time", this.d);
            jSONObject.put(com.anythink.core.common.g.c.C, this.f9253c);
            jSONObject.put("lat", this.b);
            jSONObject.put("radius", this.e);
            jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f9252a);
            jSONObject.put("reType", this.g);
            jSONObject.put("reSubType", this.h);
        } catch (Throwable th) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optDouble("lat", this.b);
            this.f9253c = jSONObject.optDouble(com.anythink.core.common.g.c.C, this.f9253c);
            this.f9252a = jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, this.f9252a);
            this.g = jSONObject.optInt("reType", this.g);
            this.h = jSONObject.optInt("reSubType", this.h);
            this.e = jSONObject.optInt("radius", this.e);
            this.d = jSONObject.optLong("time", this.d);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CoreUtil", "transformLocation");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f9252a == fVar.f9252a && Double.compare(fVar.b, this.b) == 0 && Double.compare(fVar.f9253c, this.f9253c) == 0 && this.d == fVar.d && this.e == fVar.e && this.f == fVar.f && this.g == fVar.g && this.h == fVar.h;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f9252a), Double.valueOf(this.b), Double.valueOf(this.f9253c), Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h));
    }
}
