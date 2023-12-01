package com.tencent.map.sdk.utilities.visualization.glmodel;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.io.File;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/glmodel/GLModelOverlayProvider.class */
public final class GLModelOverlayProvider extends BaseOverlayProvider {
    private LatLngBounds mLatLngBounds;
    private String mModelFilePath;
    private int mPixelHeight;
    private int mPixelWidth;
    private LatLng mPosition;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private IAnimatorModel.IAnimatorEndListener transAnimatorEndListener;
    private CoordType mCoordType = CoordType.GeoGraphicType;
    private double mScale = 1.0d;
    private AnimationType mAnimated = AnimationType.None;
    private float mExposure = 1.0f;
    private boolean mBuildingHidden = true;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/glmodel/GLModelOverlayProvider$AnimationType.class */
    public enum AnimationType {
        None,
        FlattenRise
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/glmodel/GLModelOverlayProvider$CoordType.class */
    public enum CoordType {
        PixelType,
        GeoGraphicType
    }

    public GLModelOverlayProvider(String str, LatLng latLng) {
        if (isModelFileValid(str)) {
            this.mModelFilePath = str;
        } else {
            this.mModelFilePath = "";
        }
        this.mPosition = latLng;
    }

    private boolean isModelFileValid(String str) {
        return (str.endsWith(".gltf") || str.endsWith(".GLTF")) && new File(str).exists();
    }

    public GLModelOverlayProvider animateType(AnimationType animationType) {
        this.mAnimated = animationType;
        return this;
    }

    public GLModelOverlayProvider coordType(CoordType coordType) {
        this.mCoordType = coordType;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GLModelOverlayProvider displayLevel(int i) {
        super.displayLevel(i);
        return this;
    }

    public AnimationType getAnimationType() {
        return this.mAnimated;
    }

    public CoordType getCoordType() {
        return this.mCoordType;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    public float getExposure() {
        return this.mExposure;
    }

    public LatLngBounds getLatLngBounds() {
        return this.mLatLngBounds;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return super.getMaxZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return super.getMinZoom();
    }

    public String getModelFilePath() {
        return this.mModelFilePath;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return super.getOpacity();
    }

    public int getPixelHeight() {
        return this.mPixelHeight;
    }

    public int getPixelWidth() {
        return this.mPixelWidth;
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

    public IAnimatorModel.IAnimatorEndListener getTransAnimatorEndListener() {
        return this.transAnimatorEndListener;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return super.getZIndex();
    }

    public boolean isBuildingHidden() {
        return this.mBuildingHidden;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isClickEnabled() {
        return this.mClickEnabled;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return super.isVisibility();
    }

    public GLModelOverlayProvider latLngBounds(List<LatLng> list) {
        if (list == null || list.size() < 2) {
            this.mLatLngBounds = null;
            return this;
        }
        this.mLatLngBounds = new LatLngBounds.Builder().include(list).build();
        return this;
    }

    public GLModelOverlayProvider modelFilePath(String str) {
        if (isModelFileValid(str)) {
            this.mModelFilePath = str;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GLModelOverlayProvider opacity(float f) {
        super.opacity(f);
        return this;
    }

    public GLModelOverlayProvider pixelBounds(int i, int i2) {
        this.mPixelWidth = i;
        this.mPixelHeight = i2;
        return this;
    }

    public GLModelOverlayProvider position(LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public GLModelOverlayProvider rotationX(float f) {
        this.mRotationX = f;
        return this;
    }

    public GLModelOverlayProvider rotationY(float f) {
        this.mRotationY = f;
        return this;
    }

    public GLModelOverlayProvider rotationZ(float f) {
        this.mRotationZ = f;
        return this;
    }

    public GLModelOverlayProvider scale(double d) {
        if (d > 0.0d) {
            this.mScale = d;
        }
        return this;
    }

    public GLModelOverlayProvider setBuildingHidden(boolean z) {
        this.mBuildingHidden = z;
        return this;
    }

    public GLModelOverlayProvider setClickEnable(boolean z) {
        super.enableClick(z);
        return this;
    }

    public GLModelOverlayProvider setExposure(float f) {
        this.mExposure = f;
        return this;
    }

    public void setTransAnimatorEndListener(IAnimatorModel.IAnimatorEndListener iAnimatorEndListener) {
        this.transAnimatorEndListener = iAnimatorEndListener;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider
    public String toString() {
        return "GLModelOverlayProvider{mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + ", mCoordType=" + this.mCoordType + ", mModelFilePath='" + this.mModelFilePath + "', mPosition=" + this.mPosition + ", mScale=" + this.mScale + ", mRotationX=" + this.mRotationX + ", mRotationY=" + this.mRotationY + ", mRotationZ=" + this.mRotationZ + ", mLatLngBounds=" + this.mLatLngBounds + ", mAnimated=" + this.mAnimated + ", mExposure=" + this.mExposure + ", mBuildingHidden=" + this.mBuildingHidden + ", mClickEnabled=" + this.mClickEnabled + '}';
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GLModelOverlayProvider visibility(boolean z) {
        super.visibility(z);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GLModelOverlayProvider zIndex(int i) {
        super.zIndex(i);
        return this;
    }

    public GLModelOverlayProvider zoomRange(int i, int i2) {
        if (i <= i2) {
            super.minZoom(i);
            super.maxZoom(i2);
        }
        return this;
    }
}
