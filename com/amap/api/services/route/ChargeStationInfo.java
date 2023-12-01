package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/ChargeStationInfo.class */
public class ChargeStationInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f5682a;
    private LatLonPoint b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f5683c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public int getAmperage() {
        return this.l;
    }

    public String getBrandName() {
        return this.f;
    }

    public int getChargePercent() {
        return this.h;
    }

    public int getChargeTime() {
        return this.i;
    }

    public int getMaxPower() {
        return this.g;
    }

    public String getName() {
        return this.e;
    }

    public String getPoiId() {
        return this.d;
    }

    public LatLonPoint getProjectivePoint() {
        return this.f5683c;
    }

    public int getRemainingCapacity() {
        return this.j;
    }

    public LatLonPoint getShowPoint() {
        return this.b;
    }

    public int getStepIndex() {
        return this.f5682a;
    }

    public int getVoltage() {
        return this.k;
    }

    public void setAmperage(int i) {
        this.l = i;
    }

    public void setBrandName(String str) {
        this.f = str;
    }

    public void setChargePercent(int i) {
        this.h = i;
    }

    public void setChargeTime(int i) {
        this.i = i;
    }

    public void setMaxPower(int i) {
        this.g = i;
    }

    public void setName(String str) {
        this.e = str;
    }

    public void setPoiId(String str) {
        this.d = str;
    }

    public void setProjectivePoint(LatLonPoint latLonPoint) {
        this.f5683c = latLonPoint;
    }

    public void setRemainingCapacity(int i) {
        this.j = i;
    }

    public void setShowPoint(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setStepIndex(int i) {
        this.f5682a = i;
    }

    public void setVoltage(int i) {
        this.k = i;
    }
}
