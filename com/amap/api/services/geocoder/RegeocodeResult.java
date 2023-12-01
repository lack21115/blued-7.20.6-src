package com.amap.api.services.geocoder;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/geocoder/RegeocodeResult.class */
public class RegeocodeResult {

    /* renamed from: a  reason: collision with root package name */
    private RegeocodeQuery f5639a;
    private RegeocodeAddress b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f5639a = regeocodeQuery;
        this.b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f5639a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f5639a = regeocodeQuery;
    }
}
