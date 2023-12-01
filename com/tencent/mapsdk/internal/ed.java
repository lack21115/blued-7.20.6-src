package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GLModelInfo;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ed.class */
public class ed extends GLModelInfo implements vc {

    /* renamed from: a  reason: collision with root package name */
    private GLModelOverlayProvider f23719a;

    public ed(GLModelOverlayProvider gLModelOverlayProvider) {
        this.f23719a = gLModelOverlayProvider;
        this.mModelFilePath = gLModelOverlayProvider.getModelFilePath();
        this.mPosition = gLModelOverlayProvider.getPosition();
        this.mCoordType = gLModelOverlayProvider.getCoordType().ordinal();
        if (gLModelOverlayProvider.getPosition() != null) {
            this.mAltitude = gLModelOverlayProvider.getPosition().getAltitude();
        }
        this.mScale = gLModelOverlayProvider.getScale();
        this.mRotationX = gLModelOverlayProvider.getRotationX();
        this.mRotationY = gLModelOverlayProvider.getRotationY();
        this.mRotationZ = gLModelOverlayProvider.getRotationZ();
        this.mLatLngBounds = gLModelOverlayProvider.getLatLngBounds();
        this.mAnimate = gLModelOverlayProvider.getAnimationType().ordinal();
        this.mMaxZoom = gLModelOverlayProvider.getMaxZoom();
        this.mMinZoom = gLModelOverlayProvider.getMinZoom();
        this.level = gLModelOverlayProvider.getDisplayLevel();
        this.exposure = gLModelOverlayProvider.getExposure();
        this.zIndex = gLModelOverlayProvider.getZIndex();
        this.opacity = gLModelOverlayProvider.getOpacity();
        this.visible = gLModelOverlayProvider.isVisibility();
        this.buildingHidden = gLModelOverlayProvider.isBuildingHidden();
        this.clickEnabled = gLModelOverlayProvider.isClickEnabled();
        this.mPixelWidth = gLModelOverlayProvider.getPixelWidth();
        this.mPixelHeight = gLModelOverlayProvider.getPixelHeight();
        this.outterVectorOverlayLoadListener = gLModelOverlayProvider.getVectorOverlayLoadedListener();
        this.outterVectorOverlayClickListener = gLModelOverlayProvider.getOnVectorOverlayClickListener();
    }

    public GLModelOverlayProvider a() {
        return this.f23719a;
    }
}
