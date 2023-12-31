package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/RegeocodeQuery.class */
public class RegeocodeQuery {
    private LatLonPoint a;
    private float b;
    private String c = GeocodeSearch.AMAP;
    private String d = "";
    private String e = "distance";
    private String f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.b = 1000.0f;
        this.a = latLonPoint;
        this.b = f;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
            String str = this.c;
            if (str == null) {
                if (regeocodeQuery.c != null) {
                    return false;
                }
            } else if (!str.equals(regeocodeQuery.c)) {
                return false;
            }
            LatLonPoint latLonPoint = this.a;
            if (latLonPoint == null) {
                if (regeocodeQuery.a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(regeocodeQuery.a)) {
                return false;
            }
            if (Float.floatToIntBits(this.b) == Float.floatToIntBits(regeocodeQuery.b) && this.e.equals(regeocodeQuery.e)) {
                String str2 = this.f;
                return str2 == null ? regeocodeQuery.f == null : str2.equals(regeocodeQuery.f);
            }
            return false;
        }
        return false;
    }

    public String getExtensions() {
        return this.f;
    }

    public String getLatLonType() {
        return this.c;
    }

    public String getMode() {
        return this.e;
    }

    public String getPoiType() {
        return this.d;
    }

    public LatLonPoint getPoint() {
        return this.a;
    }

    public float getRadius() {
        return this.b;
    }

    public int hashCode() {
        String str = this.c;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        LatLonPoint latLonPoint = this.a;
        if (latLonPoint != null) {
            i = latLonPoint.hashCode();
        }
        return ((((hashCode + 31) * 31) + i) * 31) + Float.floatToIntBits(this.b);
    }

    public void setExtensions(String str) {
        this.f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
                this.c = str;
            }
        }
    }

    public void setMode(String str) {
        this.e = str;
    }

    public void setPoiType(String str) {
        this.d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setRadius(float f) {
        this.b = f;
    }
}
