package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ScatterPlotInfo.class */
public class ScatterPlotInfo extends OverlayListenerInfo {
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final int DEFAULT_MIN_ZOOM = 3;
    public double[] circleStartPoints;
    public int[] colors;
    public float[] colorsPoints;
    public int mBitmapHeight;
    public int mBitmapWidth;
    public float maxIntensity;
    public int maxZoom;
    public float minIntensity;
    public int minZoom;
    public float opacity;
    public int radius;
    public boolean visible;
    public int activeIndex = 0;
    public int mType = 0;
    public int level = 1;
    public int zIndex = 0;
    public boolean draw3D = false;
    public int colorMapSize = 200;
    public boolean mAnimate = false;
    public boolean intensityFlag = false;
    public int mMinRadius = 0;
    public int mMaxRadius = 30;
    public int mStrokeColor = -1;
    public int mStrokeWidth = 4;
    public ScatterLatLng[] notes = new ScatterLatLng[0];
    public int[] nodeIndexes = new int[0];
    public Bitmap[] mBitmaps = new Bitmap[0];

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setActiveIndex(int i) {
        this.activeIndex = i;
    }

    public void setAnimate(boolean z) {
        this.mAnimate = z;
    }

    public void setColors(int[] iArr) {
        this.colors = iArr;
    }

    public void setColorsPoints(double[] dArr) {
        this.circleStartPoints = dArr;
    }

    public void setColorsPoints(float[] fArr) {
        this.colorsPoints = fArr;
    }

    public void setDataList(List<Collection<ScatterLatLng>> list) {
        if (list == null) {
            this.notes = new ScatterLatLng[0];
            this.nodeIndexes = new int[0];
            return;
        }
        this.nodeIndexes = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.notes = (ScatterLatLng[]) arrayList.toArray(new ScatterLatLng[0]);
                return;
            }
            Collection<ScatterLatLng> collection = list.get(i2);
            this.nodeIndexes[i2] = collection.size();
            arrayList.addAll(collection);
            i = i2 + 1;
        }
    }

    public void setDraw3D(boolean z) {
        this.draw3D = z;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMaxZoom(int i) {
        if (i <= 22) {
            this.maxZoom = i;
        } else {
            this.maxZoom = 22;
        }
    }

    public void setMinZoom(int i) {
        if (i >= 3) {
            this.minZoom = i;
        } else {
            this.minZoom = 3;
        }
    }

    public void setOpacity(float f) {
        this.opacity = f;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public void setZoomLevelRange(int i, int i2) {
        if (i <= i2) {
            setMinZoom(i);
            setMaxZoom(i2);
        }
    }

    public void setzIndex(int i) {
        this.zIndex = i;
    }
}
