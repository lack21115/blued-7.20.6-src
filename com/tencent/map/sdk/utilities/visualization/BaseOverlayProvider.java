package com.tencent.map.sdk.utilities.visualization;

import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/BaseOverlayProvider.class */
public abstract class BaseOverlayProvider implements VectorOverlayProvider {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    private static final float DEFAULT_OPACITY = 1.0f;
    private static final int DEFAULT_ZINDEX = 0;
    public float mOpacity = 1.0f;
    public boolean mVisibility = true;
    public int mMinZoom = 4;
    public int mMaxZoom = 22;
    public int mDisplayLevel = 1;
    public int mZIndex = 0;
    public boolean mClickEnabled = false;
    public VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadlistener = null;
    public VectorOverlay.OnVectorOverlayClickListener onVectorOverlayClickListener = null;

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider displayLevel(int i) {
        if (i == 1 || i == 2) {
            this.mDisplayLevel = i;
        }
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public void enableClick(boolean z) {
        this.mClickEnabled = z;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return this.mDisplayLevel;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return this.mMinZoom;
    }

    public VectorOverlay.OnVectorOverlayClickListener getOnVectorOverlayClickListener() {
        return this.onVectorOverlayClickListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return this.mOpacity;
    }

    public VectorOverlay.OnVectorOverlayLoadListener getVectorOverlayLoadedListener() {
        return this.onVectorOverlayLoadlistener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return this.mZIndex;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isClickEnabled() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return this.mVisibility;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider maxZoom(int i) {
        if (i <= 22) {
            this.mMaxZoom = i;
            return this;
        }
        this.mMaxZoom = 22;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider minZoom(int i) {
        if (i >= 3) {
            this.mMinZoom = i;
            return this;
        }
        this.mMinZoom = 3;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider opacity(float f) {
        if (f > 1.0f) {
            this.mOpacity = 1.0f;
            return this;
        } else if (f < 0.0f) {
            this.mOpacity = 0.0f;
            return this;
        } else {
            this.mOpacity = f;
            return this;
        }
    }

    public BaseOverlayProvider setVectorOverlayClickListener(VectorOverlay.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.onVectorOverlayClickListener = onVectorOverlayClickListener;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider setVectorOverlayLoadedListener(VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener) {
        this.onVectorOverlayLoadlistener = onVectorOverlayLoadListener;
        return this;
    }

    public String toString() {
        return "BaseOverlayProvider{mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + '}';
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider visibility(boolean z) {
        this.mVisibility = z;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider zIndex(int i) {
        this.mZIndex = i;
        return this;
    }
}
