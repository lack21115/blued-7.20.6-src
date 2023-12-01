package com.tencent.map.sdk.utilities.visualization.aggregation;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/aggregation/AggregationOverlayProvider.class */
public abstract class AggregationOverlayProvider extends BaseOverlayProvider {
    private static final double DEFAULT_MAX_HEIGHT = 100.0d;
    private static final int DEFAULT_MAX_INTENSITY = 2000;
    private static final int DEFAULT_MIN_INTENSITY = 0;
    private static final int DEFAULT_MIN_SIZE = 10;
    private static final int DEFAULT_SIZE = 2000;
    private WeightedLatLng[] mNodes;
    private static final int[] DEFAULT_COLORS = {Color.argb(255, 31, 44, 71), Color.argb(255, 40, 72, 138), Color.argb(255, 38, 97, 217), Color.argb(255, 90, 140, 242), Color.argb(255, 153, 187, 255)};
    private static final double DEFAULT_MIN_HEIGHT = 0.0d;
    private static final double[] DEFAULT_START_POINTS = {DEFAULT_MIN_HEIGHT, 0.10000000149011612d, 0.15000000596046448d, 0.30000001192092896d, 0.5d};
    private int mType = 0;
    private float mSize = 2000.0f;
    private float mGap = 0.0f;
    private int[] mColors = DEFAULT_COLORS;
    private double[] mStartPoints = DEFAULT_START_POINTS;
    private double mMinIntensity = DEFAULT_MIN_HEIGHT;
    private double mMaxIntensity = 2000.0d;
    private boolean mRangeFlag = false;
    private double mMaxHeight = DEFAULT_MAX_HEIGHT;
    private double mMinHeight = DEFAULT_MIN_HEIGHT;
    private boolean mDraw3D = false;
    private boolean mAnimate = false;
    private int mAnimateDuration = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/aggregation/AggregationOverlayProvider$AggregationOverlayType.class */
    public enum AggregationOverlayType {
        HoneyComb,
        Square
    }

    public AggregationOverlayProvider colors(int[] iArr, double[] dArr) {
        boolean z;
        if (iArr != null && dArr != null && iArr.length > 0 && dArr.length > 0 && iArr.length == dArr.length) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= dArr.length) {
                    z = true;
                    break;
                } else if (dArr[i2 - 1] > dArr[i2]) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z && dArr[0] >= DEFAULT_MIN_HEIGHT && dArr[dArr.length - 1] <= 1.0d) {
                this.mColors = iArr;
                this.mStartPoints = dArr;
            }
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public AggregationOverlayProvider displayLevel(int i) {
        super.displayLevel(i);
        return this;
    }

    public AggregationOverlayProvider enable3D(boolean z) {
        this.mDraw3D = z;
        return this;
    }

    public AggregationOverlayProvider gap(float f) {
        if (f >= 0.0f) {
            this.mGap = f;
        }
        return this;
    }

    public int getAnimateDuration() {
        return this.mAnimateDuration;
    }

    public int[] getColors() {
        return this.mColors;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return super.getDisplayLevel();
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
        return super.getMaxZoom();
    }

    public double getMinHeight() {
        return this.mMinHeight;
    }

    public double getMinIntensity() {
        return this.mMinIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return super.getMinZoom();
    }

    public WeightedLatLng[] getNodes() {
        return this.mNodes;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return super.getOpacity();
    }

    public AggregationOverlayType getOverlayType() {
        return AggregationOverlayType.values()[this.mType];
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

    public int getType() {
        return getOverlayType().ordinal();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return super.getZIndex();
    }

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isEnable3D() {
        return this.mDraw3D;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return super.isVisibility();
    }

    public AggregationOverlayProvider nodes(WeightedLatLng[] weightedLatLngArr) {
        if (weightedLatLngArr != null) {
            this.mNodes = weightedLatLngArr;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public AggregationOverlayProvider opacity(float f) {
        super.opacity(f);
        return this;
    }

    public AggregationOverlayProvider setAnimateDuration(int i) {
        if (i == 0) {
            this.mAnimate = false;
            this.mAnimateDuration = 0;
            return this;
        }
        if (i > 0) {
            this.mAnimateDuration = i;
            this.mAnimate = true;
        }
        return this;
    }

    public AggregationOverlayProvider setHeightRange(double d, double d2) {
        if (d <= d2 && d >= DEFAULT_MIN_HEIGHT) {
            this.mMaxHeight = d2;
            this.mMinHeight = d;
        }
        return this;
    }

    public AggregationOverlayProvider setIntensityRange(double d, double d2) {
        if (d < d2 && d >= DEFAULT_MIN_HEIGHT) {
            this.mMaxIntensity = d2;
            this.mMinIntensity = d;
            this.mRangeFlag = true;
        }
        return this;
    }

    public AggregationOverlayProvider size(float f) {
        if (f < 10.0f) {
            return this;
        }
        this.mSize = f;
        return this;
    }

    public AggregationOverlayProvider type(AggregationOverlayType aggregationOverlayType) {
        this.mType = aggregationOverlayType.ordinal();
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public AggregationOverlayProvider visibility(boolean z) {
        super.visibility(z);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public AggregationOverlayProvider zIndex(int i) {
        super.zIndex(i);
        return this;
    }

    public AggregationOverlayProvider zoomRange(int i, int i2) {
        if (i <= i2) {
            super.minZoom(i);
            super.maxZoom(i2);
        }
        return this;
    }
}
