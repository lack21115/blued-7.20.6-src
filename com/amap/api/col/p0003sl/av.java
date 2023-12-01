package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;

/* renamed from: com.amap.api.col.3sl.av  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/av.class */
public final class av implements AMapLocationListener, LocationSource {
    private LocationSource.OnLocationChangedListener d;
    private AMapLocationClient e;
    private AMapLocationClientOption f;
    private Context g;
    private Bundle c = null;
    boolean a = false;
    long b = 2000;

    public av(Context context) {
        this.g = context;
    }

    private void a(boolean z) {
        AMapLocationClient aMapLocationClient;
        if (this.f != null && (aMapLocationClient = this.e) != null) {
            try {
                aMapLocationClient.onDestroy();
                AMapLocationClient aMapLocationClient2 = new AMapLocationClient(this.g);
                this.e = aMapLocationClient2;
                aMapLocationClient2.setLocationListener(this);
                this.f.setOnceLocation(z);
                this.f.setNeedAddress(false);
                if (!z) {
                    this.f.setInterval(this.b);
                }
                this.e.setLocationOption(this.f);
                this.e.startLocation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.a = z;
    }

    public final void a(int i) {
        if (i == 1 || i == 0) {
            a(true);
        } else {
            a(false);
        }
    }

    public final void a(long j) {
        AMapLocationClientOption aMapLocationClientOption = this.f;
        if (aMapLocationClientOption != null && this.e != null && aMapLocationClientOption.getInterval() != j) {
            this.f.setInterval(j);
            this.e.setLocationOption(this.f);
        }
        this.b = j;
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.d = onLocationChangedListener;
        if (hx.a(this.g, dw.a()).a == hx.c.SuccessCode && this.e == null) {
            try {
                this.e = new AMapLocationClient(this.g);
                this.f = new AMapLocationClientOption();
                this.e.setLocationListener(this);
                this.f.setInterval(this.b);
                this.f.setOnceLocation(this.a);
                this.f.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                this.f.setNeedAddress(false);
                this.e.setLocationOption(this.f);
                this.e.startLocation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.d = null;
        AMapLocationClient aMapLocationClient = this.e;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.e.onDestroy();
        }
        this.e = null;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        try {
            if (this.d == null || aMapLocation == null) {
                return;
            }
            Bundle extras = aMapLocation.getExtras();
            this.c = extras;
            if (extras == null) {
                this.c = new Bundle();
            }
            this.c.putInt(MyLocationStyle.ERROR_CODE, aMapLocation.getErrorCode());
            this.c.putString(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
            this.c.putInt(MyLocationStyle.LOCATION_TYPE, aMapLocation.getLocationType());
            this.c.putFloat("Accuracy", aMapLocation.getAccuracy());
            this.c.putString("AdCode", aMapLocation.getAdCode());
            this.c.putString("Address", aMapLocation.getAddress());
            this.c.putString("AoiName", aMapLocation.getAoiName());
            this.c.putString("City", aMapLocation.getCity());
            this.c.putString("CityCode", aMapLocation.getCityCode());
            this.c.putString("Country", aMapLocation.getCountry());
            this.c.putString("District", aMapLocation.getDistrict());
            this.c.putString("Street", aMapLocation.getStreet());
            this.c.putString("StreetNum", aMapLocation.getStreetNum());
            this.c.putString("PoiName", aMapLocation.getPoiName());
            this.c.putString("Province", aMapLocation.getProvince());
            this.c.putFloat("Speed", aMapLocation.getSpeed());
            this.c.putString("Floor", aMapLocation.getFloor());
            this.c.putFloat("Bearing", aMapLocation.getBearing());
            this.c.putString("BuildingId", aMapLocation.getBuildingId());
            this.c.putDouble("Altitude", aMapLocation.getAltitude());
            aMapLocation.setExtras(this.c);
            this.d.onLocationChanged(aMapLocation);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
