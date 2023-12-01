package com.tencent.map.lib.models;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ArcLineOverlayInfo.class */
public class ArcLineOverlayInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    public int mType = 0;
    public int mZIndex = 0;
    public int activeIndex = 0;
    public float mOpacity = 1.0f;
    public boolean mVisibility = true;
    public int mMinZoom = 3;
    public int mMaxZoom = 22;
    public int mDisplayLevel = 1;
    public float mWidth = 4.0f;
    public int[] mColors = {Color.argb(255, 0, 255, 170), Color.argb(255, 0, 255, 170), Color.argb(255, 0, 255, 170)};
    public float[] mColorPoints = {0.0f, 0.5f, 1.0f};
    public int mColorMapSize = 200;
    public boolean mDraw3D = false;
    public boolean mAnimate = false;
    public int mHighLightDuration = 5000;
    public int mAnimateDuration = 5000;
    public int mAnimateColor = Color.BLUE;
    public FromToLatLng[] notes = new FromToLatLng[0];
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

    public void setAnimateDuration(int i) {
        this.mAnimateDuration = i;
    }

    public void setDataList(List<Collection<FromToLatLng>> list) {
        if (list == null || list.size() == 0) {
            this.notes = new FromToLatLng[0];
            this.nodeIndexes = new int[0];
            return;
        }
        this.nodeIndexes = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.notes = (FromToLatLng[]) arrayList.toArray(new FromToLatLng[0]);
                return;
            }
            Collection<FromToLatLng> collection = list.get(i2);
            this.nodeIndexes[i2] = collection.size();
            arrayList.addAll(collection);
            i = i2 + 1;
        }
    }

    public void setDisplayLevel(int i) {
        if (i == 1 || i == 2) {
            this.mDisplayLevel = i;
        }
    }

    public void setDraw3D(boolean z) {
        this.mDraw3D = z;
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

    public void setNodes(FromToLatLng[] fromToLatLngArr) {
        this.notes = fromToLatLngArr;
    }

    public void setOpacity(float f) {
        if (f > 1.0f) {
            this.mOpacity = 1.0f;
        } else if (f < 0.0f) {
            this.mOpacity = 0.0f;
        } else {
            this.mOpacity = f;
        }
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
