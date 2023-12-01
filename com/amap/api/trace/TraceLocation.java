package com.amap.api.trace;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/trace/TraceLocation.class */
public class TraceLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f5808a;
    private double b;

    /* renamed from: c  reason: collision with root package name */
    private float f5809c;
    private float d;
    private long e;

    public TraceLocation() {
    }

    public TraceLocation(double d, double d2, float f, float f2, long j) {
        this.f5808a = a(d);
        this.b = a(d2);
        this.f5809c = (int) ((f * 3600.0f) / 1000.0f);
        this.d = (int) f2;
        this.e = j;
    }

    private static double a(double d) {
        return Math.round(d * 1000000.0d) / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.d = this.d;
        traceLocation.f5808a = this.f5808a;
        traceLocation.b = this.b;
        traceLocation.f5809c = this.f5809c;
        traceLocation.e = this.e;
        return traceLocation;
    }

    public float getBearing() {
        return this.d;
    }

    public double getLatitude() {
        return this.f5808a;
    }

    public double getLongitude() {
        return this.b;
    }

    public float getSpeed() {
        return this.f5809c;
    }

    public long getTime() {
        return this.e;
    }

    public void setBearing(float f) {
        this.d = (int) f;
    }

    public void setLatitude(double d) {
        this.f5808a = a(d);
    }

    public void setLongitude(double d) {
        this.b = a(d);
    }

    public void setSpeed(float f) {
        this.f5809c = (int) ((f * 3600.0f) / 1000.0f);
    }

    public void setTime(long j) {
        this.e = j;
    }

    public String toString() {
        return this.f5808a + ",longtitude " + this.b + ",speed " + this.f5809c + ",bearing " + this.d + ",time " + this.e;
    }
}
