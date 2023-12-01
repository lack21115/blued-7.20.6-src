package com.tencent.map.lib.models;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/AggregationOverlayInfo.class */
public class AggregationOverlayInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    public int mType = 0;
    public float mSize = 2000.0f;
    public float mGap = 0.0f;
    public float mOpacity = 1.0f;
    public boolean mVisibility = true;
    public int mMinZoom = 3;
    public int mMaxZoom = 22;
    public int mDisplayLevel = 1;
    public int mZIndex = 0;
    public double mMinHeight = 0.0d;
    public double mMaxHeight = 1000.0d;
    public double mMinIntensity = 0.0d;
    public double mMaxIntensity = 2000.0d;
    public boolean mRangeFlag = false;
    public int[] mColors = {1174031124, -1711650028, -637908204};
    public double[] mStartPoints = {0.0d, 0.6d, 0.8d};
    public boolean mDraw3D = false;
    public boolean mAnimate = false;
    public int mAnimateDuration = 5000;
    public WeightedLatLng[] mNodes = new WeightedLatLng[0];

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setAnimate(boolean z) {
        this.mAnimate = z;
    }

    public void setAnimateTime(int i) {
        this.mAnimateDuration = i;
    }

    public void setColors(int[] iArr) {
        this.mColors = iArr;
    }

    public void setDisplayLevel(int i) {
        if (i == 1 || i == 2) {
            this.mDisplayLevel = i;
        }
    }

    public void setDraw3D(boolean z) {
        this.mDraw3D = z;
    }

    public void setGap(float f) {
        this.mGap = f;
    }

    public void setHeightRange(double d, double d2) {
        if (d > d2 || d < 0.0d) {
            this.mMinHeight = 0.0d;
            this.mMaxHeight = 1000.0d;
            return;
        }
        this.mMaxHeight = d2;
        this.mMinHeight = d;
    }

    public void setMaxZoom(int i) {
        if (i <= 22) {
            this.mMaxZoom = i;
        } else {
            this.mMaxZoom = 22;
        }
    }

    public void setMinZoom(int i) {
        if (i >= 3) {
            this.mMinZoom = i;
        } else {
            this.mMinZoom = 3;
        }
    }

    public void setNodes(WeightedLatLng[] weightedLatLngArr) {
        this.mNodes = weightedLatLngArr;
    }

    public void setOpacity(float f) {
        if (f > 1.0f) {
            this.mOpacity = 1.0f;
        } else if (f < 0.0f) {
            this.mOpacity = 0.0f;
        } else {
            this.mOpacity = f;
        }
    }

    public void setShowRange(double d, double d2) {
        if (d > d2 || d < 0.0d) {
            this.mMinIntensity = 0.0d;
            this.mMaxIntensity = 2000.0d;
            this.mRangeFlag = false;
            return;
        }
        this.mMinIntensity = d;
        this.mMaxIntensity = d2;
        this.mRangeFlag = true;
    }

    public void setSize(float f) {
        this.mSize = f;
    }

    public void setStartPoints(double[] dArr) {
        this.mStartPoints = dArr;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    public void setZIndex(int i) {
        this.mZIndex = i;
    }

    public void setZoomLevelRange(int i, int i2) {
        if (i <= i2) {
            setMinZoom(i);
            setMaxZoom(i2);
        }
    }
}
