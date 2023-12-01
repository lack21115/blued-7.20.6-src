package com.amap.api.maps.model;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/HeatMapItem.class */
public class HeatMapItem {
    private LatLng center;
    private int[] indexes;
    private double intensity;

    public LatLng getCenter() {
        return this.center;
    }

    public int[] getIndexes() {
        return this.indexes;
    }

    public double getIntensity() {
        return this.intensity;
    }

    public void setCenter(double d, double d2) {
        this.center = new LatLng(d, d2);
    }

    public void setIndexes(int[] iArr) {
        this.indexes = iArr;
    }

    public void setIntensity(double d) {
        this.intensity = d;
    }
}
