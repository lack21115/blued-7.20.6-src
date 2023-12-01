package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/PolygonOptions.class */
public class PolygonOptions {
    private static final int COLOR_DEFAULT_POLYGON = Color.argb(200, 0, 163, 255);
    private List<Integer> pattern;
    private BitmapDescriptor texture;
    private int textureSpacing;
    private int iLevel = 2;
    private float fStrokeWidth = 1.0f;
    private int iStrokeColor = -16777216;
    private boolean mClickable = true;
    private int iFillColor = COLOR_DEFAULT_POLYGON;
    private int iZindex = 0;
    private boolean boIsVisble = true;
    private final List<LatLng> listPts = new ArrayList();

    public PolygonOptions add(LatLng latLng) {
        if (latLng != null) {
            this.listPts.add(latLng);
        }
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        if (list != null) {
            this.listPts.addAll(list);
        }
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            this.listPts.addAll(Arrays.asList(latLngArr));
        }
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            for (LatLng latLng : iterable) {
                this.listPts.add(latLng);
            }
        }
        return this;
    }

    public PolygonOptions clickable(boolean z) {
        this.mClickable = z;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.iFillColor = i;
        return this;
    }

    public int getFillColor() {
        return this.iFillColor;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public List<LatLng> getPoints() {
        return this.listPts;
    }

    public int getStrokeColor() {
        return this.iStrokeColor;
    }

    public float getStrokeWidth() {
        return this.fStrokeWidth;
    }

    public BitmapDescriptor getTexture() {
        return this.texture;
    }

    public int getTextureSpacing() {
        return this.textureSpacing;
    }

    public float getZIndex() {
        return this.iZindex;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isValid() {
        List<LatLng> list = this.listPts;
        return list != null && list.size() > 2;
    }

    public boolean isVisible() {
        return this.boIsVisble;
    }

    public PolygonOptions level(int i) {
        if (i >= 0) {
            if (i > 2) {
                return this;
            }
            this.iLevel = i;
        }
        return this;
    }

    public PolygonOptions pattern(List<Integer> list) {
        this.pattern = list;
        this.texture = null;
        return this;
    }

    public void setPoints(Iterable<LatLng> iterable) {
        this.listPts.clear();
        if (iterable == null) {
            return;
        }
        addAll(iterable);
    }

    public PolygonOptions strokeColor(int i) {
        this.iStrokeColor = i;
        this.texture = null;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        if (f < 0.0f) {
            this.fStrokeWidth = 1.0f;
            return this;
        }
        this.fStrokeWidth = f;
        return this;
    }

    public PolygonOptions texture(BitmapDescriptor bitmapDescriptor) {
        this.texture = bitmapDescriptor;
        return this;
    }

    public PolygonOptions textureSpacing(int i) {
        this.textureSpacing = i;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.boIsVisble = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.iZindex = i;
        return this;
    }
}
