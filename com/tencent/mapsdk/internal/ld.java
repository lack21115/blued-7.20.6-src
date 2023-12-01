package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ld.class */
public class ld extends HeatmapInfo implements vc {

    /* renamed from: a  reason: collision with root package name */
    private GradientVectorOverlayProvider f37621a;

    public ld(GradientVectorOverlayProvider gradientVectorOverlayProvider) {
        this.f37621a = gradientVectorOverlayProvider;
        ArrayList arrayList = new ArrayList();
        arrayList.add(gradientVectorOverlayProvider.getData());
        setDataList(arrayList);
        this.radius = gradientVectorOverlayProvider.getRadius();
        this.colors = gradientVectorOverlayProvider.getColors();
        this.colorPoints = gradientVectorOverlayProvider.getColorPoints();
        this.colorMapSize = gradientVectorOverlayProvider.getColorMapSize();
        this.visible = gradientVectorOverlayProvider.isVisibility();
        this.opacity = gradientVectorOverlayProvider.getOpacity();
        this.maxZoom = gradientVectorOverlayProvider.getMaxZoom();
        this.minZoom = gradientVectorOverlayProvider.getMinZoom();
        this.maxHeight = gradientVectorOverlayProvider.getMaxHeight();
        this.draw3D = gradientVectorOverlayProvider.isEnable3D();
        this.maxIntensity = gradientVectorOverlayProvider.getMaxIntensity();
        this.minIntensity = gradientVectorOverlayProvider.getMinIntensity();
        this.intensityFlag = gradientVectorOverlayProvider.isIntensityFlag();
        this.mAnimate = gradientVectorOverlayProvider.isAnimate();
        this.mAnimateDuration = gradientVectorOverlayProvider.getAnimateDuration();
        this.level = gradientVectorOverlayProvider.getDisplayLevel();
        this.zIndex = gradientVectorOverlayProvider.getZIndex();
        Log.i("libMapEngine", "java colors : " + this.colors.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.colors.length) {
                Log.i("libMapEngine", "java opacity : " + this.opacity);
                Log.i("libMapEngine", "java colorPoints : " + this.colorPoints.length);
                Log.i("libMapEngine", "java colorMapSize : " + this.colorMapSize);
                Log.i("libMapEngine", "java notes : " + this.notes.length);
                Log.i("libMapEngine", "java nodeIndexes : " + this.nodeIndexes.length);
                return;
            }
            Log.i("libMapEngine", "java colors: " + this.colors[i2]);
            i = i2 + 1;
        }
    }

    public GradientVectorOverlayProvider a() {
        return this.f37621a;
    }
}
