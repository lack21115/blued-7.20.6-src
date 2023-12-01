package com.tencent.map.lib.models;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/GLModelInfo.class */
public class GLModelInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    public double mAltitude;
    public int mCoordType;
    public LatLngBounds mLatLngBounds;
    public String mModelFilePath;
    public LatLng mPosition;
    public float mRotationX;
    public float mRotationY;
    public float mRotationZ;
    public double mScale = 1.0d;
    public int mAnimate = 0;
    public int mMinZoom = 3;
    public int mMaxZoom = 22;
    public float opacity = 1.0f;
    public int level = 1;
    public int zIndex = 0;
    public boolean visible = true;
    public float exposure = 1.0f;
    public boolean buildingHidden = true;
    public boolean clickEnabled = false;
    public int mPixelWidth = 64;
    public int mPixelHeight = 64;

    public void enableClick(boolean z) {
        this.clickEnabled = z;
    }

    public float getExposure() {
        return this.exposure;
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getRotationZ() {
        return this.mRotationZ;
    }

    public double getScale() {
        return this.mScale;
    }

    public boolean isClickEnabled() {
        return this.clickEnabled;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setCoordType(int i) {
        this.mCoordType = i;
    }

    public void setExposure(float f) {
        this.exposure = f;
    }

    public void setLevel(int i) {
        if (i == 1 || i == 2) {
            this.level = i;
        }
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

    public void setModelPosition(LatLng latLng) {
        this.mPosition = latLng;
        this.mAltitude = latLng.getAltitude();
    }

    public void setOpacity(float f) {
        if (f > 1.0f) {
            this.opacity = 1.0f;
        } else if (f < 0.0f) {
            this.opacity = 0.0f;
        } else {
            this.opacity = f;
        }
    }

    public void setPixelBound(int i, int i2) {
        this.mPixelWidth = i;
        this.mPixelHeight = i2;
    }

    public void setRotationX(float f) {
        this.mRotationX = f;
    }

    public void setRotationY(float f) {
        this.mRotationY = f;
    }

    public void setRotationZ(float f) {
        this.mRotationZ = f;
    }

    public void setScale(float f) {
        this.mScale = f;
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
