package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/GeocodeResult.class */
public class GeocodeResult {
    private GeocodeQuery a;
    private List<GeocodeAddress> b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        this.b = new ArrayList();
        this.a = geocodeQuery;
        this.b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.a = geocodeQuery;
    }
}
