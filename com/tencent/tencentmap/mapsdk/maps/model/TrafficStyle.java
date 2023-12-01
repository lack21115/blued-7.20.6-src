package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/TrafficStyle.class */
public class TrafficStyle {
    private int mWidth = 3;
    private int mStrokeWidth = 0;
    private int mSmoothColor = -16722688;
    private int mSlowColor = -16128;
    private int mCongestedColor = -46250;
    private int mSeriousCongestedColor = -7300827;
    private int mSmoothStrokeColor = -16722688;
    private int mSlowStrokeColor = -16128;
    private int mCongestedStrokeColor = -46250;
    private int mSeriousCongestedStrokeColor = -7300827;

    public TrafficStyle setCongestedColor(int i) {
        this.mCongestedColor = i;
        return this;
    }

    public TrafficStyle setCongestedStrokeColor(int i) {
        this.mCongestedStrokeColor = i;
        return this;
    }

    public TrafficStyle setSeriousCongestedColor(int i) {
        this.mSeriousCongestedColor = i;
        return this;
    }

    public TrafficStyle setSeriousCongestedStrokeColor(int i) {
        this.mSeriousCongestedStrokeColor = i;
        return this;
    }

    public TrafficStyle setSlowColor(int i) {
        this.mSlowColor = i;
        return this;
    }

    public TrafficStyle setSlowStrokeColor(int i) {
        this.mSlowStrokeColor = i;
        return this;
    }

    public TrafficStyle setSmoothColor(int i) {
        this.mSmoothColor = i;
        return this;
    }

    public TrafficStyle setSmoothStrokeColor(int i) {
        this.mSmoothStrokeColor = i;
        return this;
    }

    public TrafficStyle setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        return this;
    }

    public TrafficStyle setWidth(int i) {
        this.mWidth = i;
        return this;
    }

    public String toString() {
        return "TrafficStyle{mWidth=" + this.mWidth + ", mStrokeWidth=" + this.mStrokeWidth + ", mSmoothColor=" + this.mSmoothColor + ", mSlowColor=" + this.mSlowColor + ", mCongestedColor=" + this.mCongestedColor + ", mSeriousCongestedColor=" + this.mSeriousCongestedColor + ", mSmoothStrokeColor=" + this.mSmoothStrokeColor + ", mSlowStrokeColor=" + this.mSlowStrokeColor + ", mCongestedStrokeColor=" + this.mCongestedStrokeColor + ", mSeriousCongestedStrokeColor=" + this.mSeriousCongestedStrokeColor + '}';
    }
}
