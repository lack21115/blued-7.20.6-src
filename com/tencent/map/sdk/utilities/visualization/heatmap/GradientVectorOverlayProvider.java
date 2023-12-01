package com.tencent.map.sdk.utilities.visualization.heatmap;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/heatmap/GradientVectorOverlayProvider.class */
public class GradientVectorOverlayProvider extends BaseOverlayProvider {
    private static final boolean DEFAULT_ANIMATE = false;
    private static final int DEFAULT_ANIMATE_TIME = 0;
    private static final int DEFAULT_COLOR_MAP_SIZE = 500;
    private static final boolean DEFAULT_DRAW_3D = false;
    private static final int[] DEFAULT_GRADIENT_COLORS = {Color.argb(255, 77, 111, 255), Color.argb(255, 0, 238, 227), Color.argb(255, 113, 236, 80), Color.argb(255, 255, 176, 0), Color.argb(255, 255, 72, 0)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = {0.1f, 0.185f, 0.3571f, 0.6142f, 1.0f};
    public static final float DEFAULT_MAX_HEIGHT = 60.0f;
    public static final float DEFAULT_MAX_INTENSITY = 2000.0f;
    public static final float DEFAULT_MIN_INTENSITY = 0.0f;
    public static final float DEFAULT_OPACITY = 1.0f;
    public static final int DEFAULT_RADIUS = 30;
    private static final int MAX_RADIUS = 150;
    private static final int MIN_RADIUS = 18;
    private List<WeightedLatLng> dataList = new ArrayList();
    private float maxHeight = 60.0f;
    private int radius = 30;
    private int[] colors = DEFAULT_GRADIENT_COLORS;
    private float[] colorPoints = DEFAULT_GRADIENT_START_POINTS;
    private int colorMapSize = 500;
    private boolean draw3D = false;
    private float maxIntensity = 2000.0f;
    private float minIntensity = 0.0f;
    private boolean intensityFlag = false;
    private boolean mAnimate = false;
    private int mAnimationDuration = 0;

    private static List<WeightedLatLng> wrapData(List<LatLng> list) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : list) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    public GradientVectorOverlayProvider data(List<LatLng> list) {
        return weightedData(wrapData(list));
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GradientVectorOverlayProvider displayLevel(int i) {
        super.displayLevel(i);
        return this;
    }

    public GradientVectorOverlayProvider enable3D(boolean z) {
        this.draw3D = z;
        return this;
    }

    public int getAnimateDuration() {
        return this.mAnimationDuration;
    }

    public int getColorMapSize() {
        return this.colorMapSize;
    }

    public float[] getColorPoints() {
        return this.colorPoints;
    }

    public int[] getColors() {
        return this.colors;
    }

    public List<WeightedLatLng> getData() {
        return this.dataList;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    public float getMaxHeight() {
        return this.maxHeight;
    }

    public float getMaxIntensity() {
        return this.maxIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return super.getMaxZoom();
    }

    public float getMinIntensity() {
        return this.minIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return super.getMinZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return super.getOpacity();
    }

    public int getRadius() {
        return this.radius;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return super.getZIndex();
    }

    public GradientVectorOverlayProvider gradient(int[] iArr, float[] fArr) {
        boolean z;
        if (iArr != null && fArr != null && iArr.length > 0 && fArr.length > 0 && iArr.length == fArr.length) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= fArr.length) {
                    z = true;
                    break;
                } else if (fArr[i2 - 1] > fArr[i2]) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z && fArr[0] >= 0.0f && fArr[fArr.length - 1] <= 1.0f) {
                this.colors = iArr;
                this.colorPoints = fArr;
            }
        }
        return this;
    }

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isEnable3D() {
        return this.draw3D;
    }

    public boolean isIntensityFlag() {
        return this.intensityFlag;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return super.isVisibility();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GradientVectorOverlayProvider opacity(float f) {
        super.opacity(f);
        return this;
    }

    public GradientVectorOverlayProvider radius(int i) {
        if (i >= 18) {
            if (i > 150) {
                return this;
            }
            this.radius = i;
        }
        return this;
    }

    public GradientVectorOverlayProvider setAnimateDuration(int i) {
        if (i == 0) {
            this.mAnimate = false;
            this.mAnimationDuration = 0;
            return this;
        }
        if (i > 0) {
            this.mAnimationDuration = i;
            this.mAnimate = true;
        }
        return this;
    }

    public GradientVectorOverlayProvider setIntensityRange(float f, float f2) {
        if (f >= f2 || f < 0.0f) {
            this.intensityFlag = false;
            return this;
        }
        this.maxIntensity = f2;
        this.minIntensity = f;
        this.intensityFlag = true;
        return this;
    }

    public GradientVectorOverlayProvider setMaxHeight(float f) {
        if (f >= 0.0f) {
            this.maxHeight = f;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider
    public String toString() {
        return "GradientVectorOverlayProvider{dataList=" + this.dataList.size() + ", maxHeight=" + this.maxHeight + ", radius=" + this.radius + ", colors=" + Arrays.toString(this.colors) + ", colorPoints=" + Arrays.toString(this.colorPoints) + ", colorMapSize=" + this.colorMapSize + ", draw3D=" + this.draw3D + ", maxIntensity=" + this.maxIntensity + ", minIntensity=" + this.minIntensity + ", intensityFlag=" + this.intensityFlag + ", mAnimate=" + this.mAnimate + ", mAnimationDuration=" + this.mAnimationDuration + ", mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + '}';
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GradientVectorOverlayProvider visibility(boolean z) {
        super.visibility(z);
        return this;
    }

    public GradientVectorOverlayProvider weightedData(List<WeightedLatLng> list) {
        if (list != null) {
            this.dataList = list;
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public GradientVectorOverlayProvider zIndex(int i) {
        super.zIndex(i);
        return this;
    }

    public GradientVectorOverlayProvider zoomRange(int i, int i2) {
        if (i <= i2) {
            super.minZoom(i);
            super.maxZoom(i2);
        }
        return this;
    }
}
