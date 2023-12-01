package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xd.class */
public class xd extends TrailOverlayInfo implements vc {

    /* renamed from: a  reason: collision with root package name */
    private TrailOverlayProvider f38111a;

    public xd(TrailOverlayProvider trailOverlayProvider) {
        this.f38111a = trailOverlayProvider;
        ArrayList arrayList = new ArrayList();
        arrayList.add(trailOverlayProvider.getData());
        setDataList(arrayList);
        this.mType = trailOverlayProvider.getType();
        this.mOpacity = trailOverlayProvider.getOpacity();
        this.mVisibility = trailOverlayProvider.isVisibility();
        this.mMinZoom = trailOverlayProvider.getMinZoom();
        this.mMaxZoom = trailOverlayProvider.getMaxZoom();
        this.mWidth = trailOverlayProvider.getWidth();
        this.mZIndex = trailOverlayProvider.getZIndex();
        this.mAnimateStartTime = trailOverlayProvider.getAnimateStartTime();
        this.mAnimateEndTime = trailOverlayProvider.getAnimateEndTime();
        this.mHighLightDuration = trailOverlayProvider.getHighLightDuration();
        this.mPlayRatio = trailOverlayProvider.getPlayRatio();
        this.mDisplayLevel = trailOverlayProvider.getDisplayLevel();
        this.colorMapSize = trailOverlayProvider.getColorMapSize();
        this.colorPoints = trailOverlayProvider.getColorPoints();
        this.colors = trailOverlayProvider.getColors();
    }

    public TrailOverlayProvider a() {
        return this.f38111a;
    }
}
