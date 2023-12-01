package com.tencent.map.lib.models;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.datamodels.TrailLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/TrailOverlayInfo.class */
public class TrailOverlayInfo extends OverlayListenerInfo {
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final int DEFAULT_MIN_ZOOM = 3;
    public float[] colorPoints;
    public int[] colors;
    public int mType = 0;
    public int mZIndex = 0;
    public int activeIndex = 0;
    public float mOpacity = 1.0f;
    public boolean mVisibility = true;
    public int mMinZoom = 3;
    public int mMaxZoom = 22;
    public int mDisplayLevel = 1;
    public float mWidth = 4.0f;
    public boolean mAnimate = true;
    public int mHighLightDuration = 5000;
    public int mAnimateStartTime = 0;
    public int mAnimateEndTime = 2000;
    public int mAnimateColor = Color.BLUE;
    public int colorMapSize = 200;
    public float mPlayRatio = 1.0f;
    public int mPulseInterval = 200;
    public TrailLatLng[] notes = new TrailLatLng[0];
    public int[] nodeIndexes = new int[0];

    public int getAnimateColor() {
        return this.mAnimateColor;
    }

    public boolean getIsAnimate() {
        return this.mAnimate;
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setActiveDataIndex(int i) {
        this.activeIndex = i;
    }

    public void setAnimate(boolean z) {
        this.mAnimate = z;
    }

    public void setAnimateColor(int i) {
        this.mAnimateColor = i;
    }

    public void setAnimateEndTime(int i) {
        this.mAnimateEndTime = i;
    }

    public void setAnimateStartTime(int i) {
        this.mAnimateStartTime = i;
    }

    public void setDataList(List<Collection<TrailLatLng>> list) {
        if (list == null || list.size() == 0) {
            this.notes = new TrailLatLng[0];
            this.nodeIndexes = new int[0];
            return;
        }
        this.nodeIndexes = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.notes = (TrailLatLng[]) arrayList.toArray(new TrailLatLng[0]);
                return;
            }
            Collection<TrailLatLng> collection = list.get(i2);
            this.nodeIndexes[i2] = collection.size();
            arrayList.addAll(collection);
            i = i2 + 1;
        }
    }

    public void setDisplayLevel(int i) {
        this.mDisplayLevel = i;
    }

    public void setHighLightDuration(int i) {
        this.mHighLightDuration = i;
    }

    public void setMaxZoom(int i) {
        if (i <= 22) {
            this.mMaxZoom = i;
        } else {
            this.mMaxZoom = 22;
        }
    }

    public void setMinZoom(int i) {
        if (i >= 3) {
            this.mMinZoom = i;
        } else {
            this.mMinZoom = 3;
        }
    }

    public void setNodes(TrailLatLng[] trailLatLngArr) {
        this.notes = trailLatLngArr;
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
    }

    public void setPlayRatio(float f) {
        this.mPlayRatio = f;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public void setZoomLevelRange(int i, int i2) {
        if (i <= i2) {
            setMinZoom(i);
            setMaxZoom(i2);
        }
    }

    public void setzIndex(int i) {
        this.mZIndex = i;
    }
}
