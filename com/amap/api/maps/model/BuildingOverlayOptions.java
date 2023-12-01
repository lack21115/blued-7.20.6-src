package com.amap.api.maps.model;

import android.graphics.Color;
import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/BuildingOverlayOptions.class */
public class BuildingOverlayOptions extends BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = Color.GRAY;
    private int buildingSideColor = Color.GRAY;
    private boolean isVisible = true;
    private List<LatLng> buildingLatlngs = new ArrayList();

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public int[] getPoints() {
        synchronized (this) {
            int i = 0;
            if (this.buildingLatlngs == null || this.buildingLatlngs.size() <= 0) {
                return new int[0];
            }
            int[] iArr = new int[this.buildingLatlngs.size() * 2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= this.buildingLatlngs.size()) {
                    return iArr;
                }
                LatLng latLng = this.buildingLatlngs.get(i);
                int i4 = i3;
                if (latLng != null) {
                    Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                    int i5 = i3 + 1;
                    iArr[i3] = latLongToPixels.x;
                    i4 = i5 + 1;
                    iArr[i5] = latLongToPixels.y;
                }
                i++;
                i2 = i4;
            }
        }
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i) {
        this.buildingHeight = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i) {
        this.buildingHeightScale = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        synchronized (this) {
            this.buildingLatlngs = list;
            if (list != null && list.size() > 0) {
                this.buildingLatlngsPoints = new int[list.size() * 2];
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i >= list.size()) {
                        break;
                    }
                    LatLng latLng = list.get(i);
                    Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                    int i4 = i3 + 1;
                    this.buildingLatlngsPoints[i3] = latLongToPixels.x;
                    this.buildingLatlngsPoints[i4] = latLongToPixels.y;
                    i++;
                    i2 = i4 + 1;
                }
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i) {
        this.buildingSideColor = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i) {
        this.buildingTopColor = i;
        return this;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }

    public void setZIndex(float f) {
        this.zindex = f;
    }
}
