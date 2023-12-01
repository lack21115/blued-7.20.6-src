package c.t.m.g;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l6.class */
public class l6 implements TencentLocation {
    public static final l6 k = new l6();

    /* renamed from: a  reason: collision with root package name */
    public int f3828a;
    public TencentLocation b;

    /* renamed from: c  reason: collision with root package name */
    public double f3829c;
    public double d;
    public float e;
    public float f;
    public float g;
    public float h;
    public String i;
    public long j;

    public l6() {
        this.b = m6.b;
        this.f3828a = 404;
    }

    public l6(i6 i6Var) {
        this.b = m6.b;
        a(i6Var);
    }

    public l6(TencentLocation tencentLocation) {
        this.b = m6.b;
        try {
            this.b = new m6(tencentLocation);
        } catch (Exception e) {
        }
    }

    public final float a() {
        float f = 0.0f;
        if ((getFakeReason() & 1) != 0) {
            f = Math.max(0.0f, 0.99f);
        }
        float f2 = f;
        if ((getFakeReason() & 2) != 0) {
            f2 = Math.max(f, 0.8f);
        }
        float f3 = f2;
        if ((getFakeReason() & 4) != 0) {
            f3 = Math.max(f2, 0.8f);
        }
        float f4 = f3;
        if ((getFakeReason() & 8) != 0) {
            f4 = Math.max(f3, 0.9f);
        }
        float f5 = f4;
        if ((getFakeReason() & 16) != 0) {
            f5 = Math.max(f4, 0.9f);
        }
        float f6 = f5;
        if ((getFakeReason() & 32) != 0) {
            f6 = Math.max(f5, 0.8f);
        }
        float f7 = f6;
        if ((getFakeReason() & 64) != 0) {
            f7 = Math.max(f6, 0.9f);
        }
        return f7;
    }

    public void a(int i) {
        this.f3828a = i;
    }

    public void a(i6 i6Var) {
        try {
            this.f3828a = i6Var.f() <= 0.0d ? 5 : 0;
            this.f3829c = i6Var.d();
            this.d = i6Var.e();
            this.e = (float) i6Var.b();
            this.f = (float) i6Var.a();
            this.g = (float) i6Var.c();
            this.h = (float) i6Var.h();
            this.i = i6Var.g();
            this.j = i6Var.i();
        } catch (Exception e) {
        }
    }

    public void a(TencentLocation tencentLocation) {
        this.b = tencentLocation;
    }

    public int b() {
        return this.f3828a;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getAccuracy() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.f : tencentLocation.getAccuracy();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getAddress() {
        return this.b.getAddress();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getAltitude() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.e : tencentLocation.getAltitude();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Integer getAreaStat() {
        return this.b.getAreaStat();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getBearing() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.g : tencentLocation.getBearing();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCity() {
        return this.b.getCity();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityCode() {
        return this.b.getCityCode();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityPhoneCode() {
        return this.b.getCityPhoneCode();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getCoordinateType() {
        return this.b.getCoordinateType();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getDirection() {
        return this.b.getDirection();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getDistrict() {
        return this.b.getDistrict();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getElapsedRealtime() {
        return this.b.getElapsedRealtime();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Bundle getExtra() {
        return this.b.getExtra();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getFakeProbability() {
        return a();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getFakeReason() {
        return 0;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getGPSRssi() {
        return this.b.getGPSRssi();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingFloor() {
        return this.b.getIndoorBuildingFloor();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingId() {
        return this.b.getIndoorBuildingId();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getIndoorLocationType() {
        return this.b.getIndoorLocationType();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLatitude() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.f3829c : tencentLocation.getLatitude();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLongitude() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.d : tencentLocation.getLongitude();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getName() {
        return this.b.getName();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getNation() {
        return this.b.getNation();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getNationCode() {
        return 0;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public List<TencentPoi> getPoiList() {
        return this.b.getPoiList();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvider() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.i : tencentLocation.getProvider();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvince() {
        return this.b.getProvince();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getSourceProvider() {
        TencentLocation tencentLocation = this.b;
        if (tencentLocation == m6.b) {
            return null;
        }
        return tencentLocation.getSourceProvider();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getSpeed() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.h : tencentLocation.getSpeed();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreet() {
        return this.b.getStreet();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreetNo() {
        return this.b.getStreetNo();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getTime() {
        TencentLocation tencentLocation = this.b;
        return tencentLocation == m6.b ? this.j : tencentLocation.getTime();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getTown() {
        return this.b.getTown();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getVillage() {
        return this.b.getVillage();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getadCode() {
        return this.b.getadCode();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int isMockGps() {
        return this.b.isMockGps();
    }

    public String toString() {
        return "TencentLocation{name=" + getName() + ",address=" + getAddress() + ",provider=" + getProvider() + ",latitude=" + getLatitude() + ",longitude=" + getLongitude() + ",altitude=" + getAltitude() + ",accuracy=" + getAccuracy() + ",cityCode=" + getCityCode() + ",areaStat=" + getAreaStat() + ",nation=" + getNation() + ",province=" + getProvince() + ",city=" + getCity() + ",district=" + getDistrict() + ",street=" + getStreet() + ",streetNo=" + getStreetNo() + ",town=" + getTown() + ",village=" + getVillage() + ",bearing=" + getBearing() + ",time=" + getTime() + ",}";
    }
}
