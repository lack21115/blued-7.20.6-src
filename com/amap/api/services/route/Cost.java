package com.amap.api.services.route;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/Cost.class */
public class Cost {

    /* renamed from: a  reason: collision with root package name */
    private float f5684a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private String f5685c;
    private float d;
    private int e;

    public float getDuration() {
        return this.f5684a;
    }

    public float getTollDistance() {
        return this.b;
    }

    public String getTollRoad() {
        return this.f5685c;
    }

    public float getTolls() {
        return this.d;
    }

    public int getTrafficLights() {
        return this.e;
    }

    public void setDuration(float f) {
        this.f5684a = f;
    }

    public void setTollDistance(float f) {
        this.b = f;
    }

    public void setTollRoad(String str) {
        this.f5685c = str;
    }

    public void setTolls(float f) {
        this.d = f;
    }

    public void setTrafficLights(int i) {
        this.e = i;
    }
}
