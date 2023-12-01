package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glanimation/AdglMapAnimPivotZoom.class */
public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    AbstractAdglAnimationParam1V zoomParam = null;

    public AdglMapAnimPivotZoom(int i) {
        reset();
        this.duration = i;
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        float mapZoomer = gLMapState.getMapZoomer();
        if (Math.abs(this.mapLevelTo - mapZoomer) < 1.0E-6d) {
            this.isOver = true;
            this.hasCheckParams = true;
            return;
        }
        this.zoomParam.setFromValue(mapZoomer);
        this.zoomParam.setToValue(this.mapLevelTo);
        if (!this.zoomCenter) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.beginCenterGeoX = obtain.x;
            this.beginCenterGeoY = obtain.y;
            IPoint obtain2 = IPoint.obtain();
            gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, obtain2);
            this.pivotGeoX = obtain2.x;
            this.pivotGeoY = obtain2.y;
            obtain.recycle();
            obtain2.recycle();
        }
        this.hasCheckParams = true;
        this.isOver = false;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        int i;
        float f;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
        float f2 = ((float) this.offsetTime) / this.duration;
        float f3 = f2;
        if (f2 > 1.0f) {
            this.isOver = true;
            f3 = 1.0f;
        }
        if (f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.zoomParam.setNormalizedTime(f3);
        float curValue = this.zoomParam.getCurValue();
        float f4 = curValue;
        if (curValue > 20.0f) {
            this.isOver = true;
            f4 = 20.0f;
        }
        float f5 = f4;
        if (f4 < 3.0f) {
            this.isOver = true;
            f5 = 3.0f;
        }
        if (!this.zoomCenter) {
            float pow = (float) Math.pow(2.0d, f5 - this.zoomParam.getFromValue());
            int i2 = (int) ((this.pivotGeoX - this.beginCenterGeoX) * (1.0f - (1.0f / pow)));
            int i3 = this.pivotGeoY;
            int i4 = this.beginCenterGeoY;
            gLMapState.setMapGeoCenter(i + i2, i4 + ((int) ((i3 - i4) * f)));
        }
        gLMapState.setMapZoomer(f5);
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setToMapZoomAndPivot(float f, int i, Point point) {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = new AbstractAdglAnimationParam1V();
        this.zoomParam = abstractAdglAnimationParam1V;
        abstractAdglAnimationParam1V.setInterpolatorType(i, 1.0f);
        float f2 = f;
        if (f > 20.0f) {
            f2 = 20.0f;
        }
        float f3 = f2;
        if (f2 < 3.0f) {
            f3 = 3.0f;
        }
        this.mapLevelTo = f3;
        if (point != null) {
            this.winPivotX = point.x;
            this.winPivotY = point.y;
            this.zoomCenter = false;
        }
    }
}
