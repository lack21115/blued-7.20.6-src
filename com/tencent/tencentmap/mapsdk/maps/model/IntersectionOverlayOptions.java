package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/IntersectionOverlayOptions.class */
public final class IntersectionOverlayOptions {
    private Rect mBounds;
    private byte[] mData;
    private int mDistance;
    private boolean mVisibility = true;
    private boolean mDarkMode = false;
    private boolean mRoundedCorner = false;

    public IntersectionOverlayOptions bounds(Rect rect) {
        this.mBounds = rect;
        return this;
    }

    public IntersectionOverlayOptions darkMode(boolean z) {
        this.mDarkMode = z;
        return this;
    }

    public IntersectionOverlayOptions data(byte[] bArr) {
        this.mData = bArr;
        return this;
    }

    public IntersectionOverlayOptions distance(int i) {
        this.mDistance = i;
        return this;
    }

    public Rect getBounds() {
        return this.mBounds;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public boolean isDarkMode() {
        return this.mDarkMode;
    }

    public boolean isRoundedCorner() {
        return this.mRoundedCorner;
    }

    public boolean isVisibility() {
        return this.mVisibility;
    }

    public IntersectionOverlayOptions roundedCorner(boolean z) {
        this.mRoundedCorner = z;
        return this;
    }

    public IntersectionOverlayOptions visibility(boolean z) {
        this.mVisibility = z;
        return this;
    }
}
