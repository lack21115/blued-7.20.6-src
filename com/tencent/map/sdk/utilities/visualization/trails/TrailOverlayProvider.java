package com.tencent.map.sdk.utilities.visualization.trails;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.TrailLatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/trails/TrailOverlayProvider.class */
public final class TrailOverlayProvider extends BaseOverlayProvider {
    private static final int DEFAULT_COLOR_MAP_SIZE = 200;
    private static final int[] DEFAULT_GRADIENT_COLORS = {Color.argb(255, 0, 128, 255), Color.argb(0, 0, 128, 255)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = {0.0f, 1.0f};
    private int mType = 0;
    private List<TrailLatLng> dataList = new ArrayList();
    private final float DEFAULT_WIDTH = 6.0f;
    private float mWidth = 6.0f;
    private final int DEFAULT_HIGHLIGHT_DURATION = 1000;
    private final int DEFAULT_ANIMATE_START_TIME = 0;
    private final int DEFAULT_ANIMATE_END_TIME = 2000;
    private int mHighLightDuration = 1000;
    private int mAnimationStartTime = 0;
    private int mAnimatationEndTime = 2000;
    private final float DEFAULT_PLAY_RATIO = 1.0f;
    private float mPlayRatio = 1.0f;
    private int[] mColors = DEFAULT_GRADIENT_COLORS;
    private float[] mColorPoints = DEFAULT_GRADIENT_START_POINTS;
    public int mColorMapSize = 200;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/trails/TrailOverlayProvider$TrailOverlayType.class */
    public enum TrailOverlayType {
        Trail
    }

    public TrailOverlayProvider data(List<TrailLatLng> list) {
        if (list != null) {
            this.dataList = list;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public TrailOverlayProvider displayLevel(int i) {
        super.displayLevel(i);
        return this;
    }

    public int getAnimateEndTime() {
        return this.mAnimatationEndTime;
    }

    public int getAnimateStartTime() {
        return this.mAnimationStartTime;
    }

    public int getColorMapSize() {
        return this.mColorMapSize;
    }

    public float[] getColorPoints() {
        return this.mColorPoints;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public List<TrailLatLng> getData() {
        return this.dataList;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    public int getHighLightDuration() {
        return this.mHighLightDuration;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return super.getMaxZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return super.getMinZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return super.getOpacity();
    }

    public TrailOverlayType getOverlayType() {
        return TrailOverlayType.values()[this.mType];
    }

    public float getPlayRatio() {
        return this.mPlayRatio;
    }

    public int getType() {
        return getOverlayType().ordinal();
    }

    public float getWidth() {
        return this.mWidth;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return super.getZIndex();
    }

    public TrailOverlayProvider gradient(int[] iArr) {
        if (iArr != null) {
            if (iArr.length == 1) {
                this.mColors = new int[]{iArr[0], iArr[0], iArr[0]};
                this.mColorPoints = new float[]{0.0f, 0.5f, 1.0f};
                return this;
            } else if (iArr.length == 2) {
                this.mColors = iArr;
                this.mColorPoints = new float[]{0.0f, 1.0f};
                return this;
            } else if (iArr.length == 3) {
                this.mColors = iArr;
                this.mColorPoints = new float[]{0.0f, 0.5f, 1.0f};
            }
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return super.isVisibility();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public TrailOverlayProvider opacity(float f) {
        super.opacity(f);
        return this;
    }

    public TrailOverlayProvider setAnimateStartTime(int i, int i2) {
        if (i < i2 && i >= 0) {
            this.mAnimationStartTime = i;
            this.mAnimatationEndTime = i2;
        }
        return this;
    }

    public TrailOverlayProvider setHighlightDuration(int i) {
        if (i > 0) {
            this.mHighLightDuration = i;
        }
        return this;
    }

    public TrailOverlayProvider setPlayRatio(float f) {
        if (f > 0.0f) {
            this.mPlayRatio = f;
        }
        return this;
    }

    public TrailOverlayProvider type(TrailOverlayType trailOverlayType) {
        this.mType = trailOverlayType.ordinal();
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public TrailOverlayProvider visibility(boolean z) {
        super.visibility(z);
        return this;
    }

    public TrailOverlayProvider width(float f) {
        if (f > 0.0f) {
            this.mWidth = f;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public TrailOverlayProvider zIndex(int i) {
        super.zIndex(i);
        return this;
    }

    public TrailOverlayProvider zoomRange(int i, int i2) {
        if (i <= i2) {
            super.minZoom(i);
            super.maxZoom(i2);
        }
        return this;
    }
}
