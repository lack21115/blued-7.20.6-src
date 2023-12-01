package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/VectorHeatOverlayOptions.class */
public final class VectorHeatOverlayOptions extends BaseOverlayProvider {
    private int[] mColors;
    private float mGap;
    private WeightedLatLng[] mNodes;
    private double[] mStartPoints;
    private int mType = 0;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private boolean mVisibility = true;
    private int mMinZoom = 3;
    private int mMaxZoom = 22;
    private double mMinIntensity = 0.0d;
    private double mMaxIntensity = 2000.0d;
    private double mMaxHeight = 2000.0d;
    private double mMinHeight = 0.0d;
    private boolean mDraw3D = false;
    private boolean mRangeFlag = false;
    private int mAnimateDuration = 5000;
    private boolean mAnimate = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/VectorHeatOverlayOptions$VectorHeatOverlayType.class */
    public enum VectorHeatOverlayType {
        HoneyComb,
        Square
    }

    public VectorHeatOverlayOptions animate(boolean z) {
        this.mAnimate = z;
        return this;
    }

    public VectorHeatOverlayOptions colors(int[] iArr) {
        this.mColors = iArr;
        return this;
    }

    public VectorHeatOverlayOptions draw3D(boolean z) {
        this.mDraw3D = z;
        return this;
    }

    public VectorHeatOverlayOptions gap(float f) {
        this.mGap = f;
        return this;
    }

    public int getAnimateTime() {
        return this.mAnimateDuration;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float getGap() {
        return this.mGap;
    }

    public double getMaxHeight() {
        return this.mMaxHeight;
    }

    public double getMaxIntensity() {
        return this.mMaxIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    public double getMinHeight() {
        return this.mMinHeight;
    }

    public double getMinIntensity() {
        return this.mMinIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return this.mMinZoom;
    }

    public WeightedLatLng[] getNodes() {
        return this.mNodes;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return this.mOpacity;
    }

    public boolean getRangeFlag() {
        return this.mRangeFlag;
    }

    public float getSize() {
        return this.mSize;
    }

    public double[] getStartPoints() {
        return this.mStartPoints;
    }

    public VectorHeatOverlayType getType() {
        return VectorHeatOverlayType.values()[this.mType];
    }

    public VectorHeatOverlayOptions heightRange(double d, double d2) {
        if (d > d2 || d < 0.0d) {
            this.mMinHeight = 0.0d;
            this.mMaxHeight = 2000.0d;
            return this;
        }
        this.mMaxHeight = d2;
        this.mMinHeight = d;
        return this;
    }

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isDraw3D() {
        return this.mDraw3D;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return this.mVisibility;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public VectorHeatOverlayOptions maxZoom(int i) {
        this.mMaxZoom = i;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public VectorHeatOverlayOptions minZoom(int i) {
        this.mMinZoom = i;
        return this;
    }

    public VectorHeatOverlayOptions nodes(WeightedLatLng[] weightedLatLngArr) {
        this.mNodes = weightedLatLngArr;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public VectorHeatOverlayOptions opacity(float f) {
        this.mOpacity = f;
        return this;
    }

    public VectorHeatOverlayOptions setAnimateTime(int i) {
        this.mAnimateDuration = i;
        return this;
    }

    public VectorHeatOverlayOptions showRange(double d, double d2) {
        if (d > d2 || d < 0.0d) {
            this.mMinIntensity = 0.0d;
            this.mMaxIntensity = 2000.0d;
            this.mRangeFlag = false;
            return this;
        }
        this.mMaxIntensity = d2;
        this.mMinIntensity = d;
        this.mRangeFlag = true;
        return this;
    }

    public VectorHeatOverlayOptions size(float f) {
        this.mSize = f;
        return this;
    }

    public VectorHeatOverlayOptions startPoints(double[] dArr) {
        this.mStartPoints = dArr;
        return this;
    }

    public VectorHeatOverlayOptions type(VectorHeatOverlayType vectorHeatOverlayType) {
        this.mType = vectorHeatOverlayType.ordinal();
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public VectorHeatOverlayOptions visibility(boolean z) {
        this.mVisibility = z;
        return this;
    }
}
