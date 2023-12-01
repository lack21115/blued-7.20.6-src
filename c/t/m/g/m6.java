package c.t.m.g;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m6.class */
public class m6 implements TencentLocation {
    public static final m6 b = new m6();

    /* renamed from: a  reason: collision with root package name */
    public TencentLocation f3886a;

    public m6() {
    }

    public m6(TencentLocation tencentLocation) {
        this.f3886a = tencentLocation;
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

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getAccuracy() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0f;
        }
        return tencentLocation.getAccuracy();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getAddress() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getAddress();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getAltitude() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getAltitude();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Integer getAreaStat() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getAreaStat();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getBearing() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0f;
        }
        return tencentLocation.getBearing();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCity() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getCity();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityCode() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getCityCode();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityPhoneCode() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getCityPhoneCode();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getCoordinateType() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getCoordinateType();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getDirection() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getDirection();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getDistrict() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getDistrict();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getElapsedRealtime() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0L;
        }
        return tencentLocation.getElapsedRealtime();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Bundle getExtra() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getFakeProbability() {
        return a();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getFakeReason() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getFakeReason();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getGPSRssi() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getGPSRssi();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingFloor() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getIndoorBuildingFloor();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingId() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getIndoorBuildingId();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getIndoorLocationType() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getIndoorLocationType();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLatitude() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getLatitude();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLongitude() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getLongitude();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getName() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getName();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getNation() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getNation();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getNationCode() {
        return 0;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public List<TencentPoi> getPoiList() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getPoiList();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvider() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getProvider();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvince() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getProvince();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getSourceProvider() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getSourceProvider();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getSpeed() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0.0f;
        }
        return tencentLocation.getSpeed();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreet() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getStreet();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreetNo() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getStreetNo();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getTime() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0L;
        }
        return tencentLocation.getTime();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getTown() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getTown();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getVillage() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getVillage();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getadCode() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getadCode();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int isMockGps() {
        TencentLocation tencentLocation = this.f3886a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.isMockGps();
    }
}
