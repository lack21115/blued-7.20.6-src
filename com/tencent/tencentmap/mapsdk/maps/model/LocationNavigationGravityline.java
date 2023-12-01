package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/LocationNavigationGravityline.class */
public class LocationNavigationGravityline {
    private int color;
    private LatLng destination;
    private float width;

    public LocationNavigationGravityline(float f, int i, LatLng latLng) {
        this.width = f;
        this.color = i;
        this.destination = latLng;
    }

    public int getColor() {
        return this.color;
    }

    public LatLng getDestination() {
        return this.destination;
    }

    public float getWidth() {
        return this.width;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setDestination(LatLng latLng) {
        this.destination = latLng;
    }

    public void setWidth(float f) {
        this.width = f;
    }
}
