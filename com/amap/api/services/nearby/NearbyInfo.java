package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbyInfo.class */
public class NearbyInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f5649a;
    private LatLonPoint b;

    /* renamed from: c  reason: collision with root package name */
    private long f5650c;
    private int d;
    private int e;

    public int getDistance() {
        return this.d;
    }

    public int getDrivingDistance() {
        return this.e;
    }

    public LatLonPoint getPoint() {
        return this.b;
    }

    public long getTimeStamp() {
        return this.f5650c;
    }

    public String getUserID() {
        return this.f5649a;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public void setDrivingDistance(int i) {
        this.e = i;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setTimeStamp(long j) {
        this.f5650c = j;
    }

    public void setUserID(String str) {
        this.f5649a = str;
    }
}
