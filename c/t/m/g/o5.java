package c.t.m.g;

import com.tencent.map.geolocation.TencentPoi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o5.class */
public class o5 implements TencentPoi {

    /* renamed from: a  reason: collision with root package name */
    public String f3910a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3911c;
    public double d;
    public String e;
    public double f;
    public double g;
    public String h;

    public o5(TencentPoi tencentPoi) {
        this.f3910a = tencentPoi.getName();
        this.b = tencentPoi.getAddress();
        this.f3911c = tencentPoi.getCatalog();
        this.d = tencentPoi.getDistance();
        this.e = tencentPoi.getUid();
        this.f = tencentPoi.getLatitude();
        this.g = tencentPoi.getLongitude();
        this.h = tencentPoi.getDirection();
    }

    public o5(JSONObject jSONObject) throws JSONException {
        b(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        this.h = jSONObject.optString("direction", "");
        if (Double.isNaN(this.f)) {
            this.f = jSONObject.optDouble("pointy");
        }
        if (Double.isNaN(this.g)) {
            this.g = jSONObject.optDouble("pointx");
        }
    }

    public final void b(JSONObject jSONObject) throws JSONException {
        this.f3910a = jSONObject.optString("name");
        this.b = jSONObject.optString("addr");
        this.f3911c = jSONObject.optString("catalog");
        this.d = jSONObject.optDouble("dist");
        this.e = jSONObject.optString("uid");
        this.f = jSONObject.optDouble("latitude");
        this.g = jSONObject.optDouble("longitude");
        a(jSONObject);
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getAddress() {
        return this.b;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getCatalog() {
        return this.f3911c;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getDirection() {
        return this.h;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public double getDistance() {
        return this.d;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public double getLatitude() {
        return this.f;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public double getLongitude() {
        return this.g;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getName() {
        return this.f3910a;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getUid() {
        return this.e;
    }

    public String toString() {
        return "PoiData{name=" + this.f3910a + ",addr=" + this.b + ",catalog=" + this.f3911c + ",dist=" + this.d + ",latitude=" + this.f + ",longitude=" + this.g + ",direction=" + this.h + "," + com.alipay.sdk.util.i.d;
    }
}
