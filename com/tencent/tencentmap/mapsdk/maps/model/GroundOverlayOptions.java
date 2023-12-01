package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/GroundOverlayOptions.class */
public final class GroundOverlayOptions {
    public static Bitmap TRANSPARENT_PIXEL = Bitmap.createBitmap(new int[]{0}, 1, 1, Bitmap.Config.ARGB_8888);
    private LatLngBounds mLatLngBounds;
    private LatLng mPosition;
    private int mZIndex;
    private BitmapDescriptor mBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(TRANSPARENT_PIXEL);
    private float mZoom = 18.0f;
    private float mAnchorU = 0.5f;
    private float mAnchorV = 0.5f;
    private float mAlpha = 1.0f;
    private boolean mVisibility = true;
    private int mLevel = 1;

    public GroundOverlayOptions alpha(float f) {
        this.mAlpha = f;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.mAnchorU = f;
        this.mAnchorV = f2;
        return this;
    }

    public GroundOverlayOptions bitmap(BitmapDescriptor bitmapDescriptor) {
        this.mBitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.mAnchorU;
    }

    public float getAnchorV() {
        return this.mAnchorV;
    }

    public BitmapDescriptor getBitmap() {
        return this.mBitmapDescriptor;
    }

    public LatLngBounds getLatLngBounds() {
        return this.mLatLngBounds;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public float getZoom() {
        return this.mZoom;
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public GroundOverlayOptions latLngBounds(LatLngBounds latLngBounds) {
        this.mLatLngBounds = latLngBounds;
        return this;
    }

    public GroundOverlayOptions level(int i) {
        if (i >= 0) {
            if (i > 2) {
                return this;
            }
            this.mLevel = i;
        }
        return this;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.mVisibility = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i) {
        this.mZIndex = i;
        return this;
    }

    public GroundOverlayOptions zoom(float f) {
        this.mZoom = f;
        return this;
    }
}
