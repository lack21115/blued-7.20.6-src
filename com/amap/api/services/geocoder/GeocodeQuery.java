package com.amap.api.services.geocoder;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/GeocodeQuery.class */
public class GeocodeQuery {

    /* renamed from: a  reason: collision with root package name */
    private String f5631a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5632c;

    public GeocodeQuery(String str, String str2) {
        this.f5631a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
            String str = this.b;
            if (str == null) {
                if (geocodeQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(geocodeQuery.b)) {
                return false;
            }
            String str2 = this.f5631a;
            return str2 == null ? geocodeQuery.f5631a == null : str2.equals(geocodeQuery.f5631a);
        }
        return false;
    }

    public String getCity() {
        return this.b;
    }

    public String getCountry() {
        return this.f5632c;
    }

    public String getLocationName() {
        return this.f5631a;
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f5631a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + 31) * 31) + i;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setCountry(String str) {
        this.f5632c = str;
    }

    public void setLocationName(String str) {
        this.f5631a = str;
    }
}
