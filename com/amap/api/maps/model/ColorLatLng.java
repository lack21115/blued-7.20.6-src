package com.amap.api.maps.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/ColorLatLng.class */
public class ColorLatLng {
    private int color;
    private List<LatLng> latLngs;

    public ColorLatLng(List<LatLng> list, int i) {
        ArrayList arrayList = new ArrayList();
        this.latLngs = arrayList;
        arrayList.clear();
        this.latLngs.addAll(list);
        this.color = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorLatLng colorLatLng = (ColorLatLng) obj;
        return this.color == colorLatLng.color && Objects.equals(this.latLngs, colorLatLng.latLngs);
    }

    public int getColor() {
        return this.color;
    }

    public List<LatLng> getLatLngs() {
        return this.latLngs;
    }

    public int hashCode() {
        return Objects.hash(this.latLngs, Integer.valueOf(this.color));
    }

    public String toString() {
        return "ColorLatLng{latLngs=" + this.latLngs + ", color=" + this.color + '}';
    }
}
