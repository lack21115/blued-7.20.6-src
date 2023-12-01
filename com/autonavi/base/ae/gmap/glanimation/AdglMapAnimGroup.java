package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glanimation/AdglMapAnimGroup.class */
public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    int startZoomDuration;
    AbstractAdglAnimationParam1V zoomStartParam = null;
    AbstractAdglAnimationParam1V zoomEndParam = null;
    AbstractAdglAnimationParam2V moveParam = null;
    AbstractAdglAnimationParam1V rotateMapParam = null;
    AbstractAdglAnimationParam1V rotateCameraParam = null;

    public AdglMapAnimGroup(int i) {
        reset();
        this.duration = i;
    }

    public static boolean checkLevel(float f) {
        return f >= 3.0f && f <= 20.0f;
    }

    private void initZoomEndParam(float f, float f2, int i) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i, 1.0f);
        this.zoomEndParam.setToValue(f2);
        this.zoomEndParam.setFromValue(f);
    }

    private void initZoomStartParam(float f, int i) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i, 1.0f);
        this.zoomStartParam.setToValue(f);
    }

    public void commitAnimation(Object obj) {
        float f;
        float mapZoomer;
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (this.needZoom) {
            if (this.zoomStartParam == null) {
                this.hasCheckParams = true;
                return;
            }
            this.zoomStartParam.setFromValue(gLMapState.getMapZoomer());
            if (this.hasMidZoom) {
                float toValue = this.zoomStartParam.getToValue();
                float fromValue = this.zoomEndParam.getFromValue();
                float toValue2 = this.zoomEndParam.getToValue();
                if (Math.abs(toValue - mapZoomer) < 1.0E-6d || Math.abs(fromValue - toValue2) < 1.0E-6d) {
                    this.hasMidZoom = false;
                    this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam = null;
                } else {
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam.needToCaculate();
                }
            }
            if (!this.hasMidZoom && Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) < 1.0E-6d) {
                this.needZoom = false;
            }
            if (this.needZoom) {
                if (this.hasMidZoom) {
                    int i = (this.duration - this.midZoomDuration) >> 1;
                    this.startZoomDuration = i;
                    this.endZoomDuration = i;
                } else {
                    this.startZoomDuration = this.duration;
                }
            }
        }
        if (this.needMove && this.moveParam != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            int i2 = obtain.x;
            int i3 = obtain.y;
            obtain.recycle();
            this.moveParam.setFromValue(i2, i3);
            this.needMove = this.moveParam.needToCaculate();
        }
        if (this.needRotateMap && this.rotateMapParam != null) {
            float mapAngle = gLMapState.getMapAngle();
            float toValue3 = this.rotateMapParam.getToValue();
            float f2 = toValue3;
            if (mapAngle > 180.0f) {
                f2 = toValue3;
                if (toValue3 == 0.0f) {
                    f2 = 360.0f;
                }
            }
            float f3 = ((int) f2) - ((int) mapAngle);
            if (f3 > 180.0f) {
                f = f2 - 360.0f;
            } else {
                f = f2;
                if (f3 < -180.0f) {
                    f = f2 + 360.0f;
                }
            }
            this.rotateMapParam.setFromValue(mapAngle);
            this.rotateMapParam.setToValue(f);
            this.needRotateMap = this.rotateMapParam.needToCaculate();
        }
        if (this.needRotateCamera && this.rotateCameraParam != null) {
            this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
            this.needRotateCamera = this.rotateCameraParam.needToCaculate();
        }
        if (this.needMove || this.needZoom || this.needRotateMap || this.needRotateCamera) {
            this.isOver = false;
        } else {
            this.isOver = true;
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        float f;
        float curValue;
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
        if (this.duration == 0.0f) {
            this.isOver = true;
            return;
        }
        float f2 = ((float) this.offsetTime) / this.duration;
        if (f2 > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        } else {
            f = f2;
            if (f2 < 0.0f) {
                this.isOver = true;
                return;
            }
        }
        if (this.needZoom) {
            gLMapState.getMapZoomer();
            if (this.hasMidZoom) {
                if (this.offsetTime <= this.startZoomDuration) {
                    this.zoomStartParam.setNormalizedTime(((float) this.offsetTime) / this.startZoomDuration);
                    curValue = this.zoomStartParam.getCurValue();
                } else if (this.offsetTime <= this.startZoomDuration + this.midZoomDuration) {
                    curValue = this.zoomStartParam.getToValue();
                } else {
                    this.zoomEndParam.setNormalizedTime(((float) ((this.offsetTime - this.startZoomDuration) - this.midZoomDuration)) / this.endZoomDuration);
                    curValue = this.zoomEndParam.getCurValue();
                }
                if (this.isOver) {
                    curValue = this.zoomEndParam.getToValue();
                }
            } else {
                this.zoomStartParam.setNormalizedTime(f);
                curValue = this.zoomStartParam.getCurValue();
            }
            gLMapState.setMapZoomer(curValue);
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null && this.needMove) {
            abstractAdglAnimationParam2V.setNormalizedTime(f);
            int fromXValue = (int) this.moveParam.getFromXValue();
            int fromYValue = (int) this.moveParam.getFromYValue();
            int toXValue = (int) this.moveParam.getToXValue();
            int toYValue = (int) this.moveParam.getToYValue();
            float curMult = this.moveParam.getCurMult();
            gLMapState.setMapGeoCenter(fromXValue + ((int) ((toXValue - fromXValue) * curMult)), fromYValue + ((int) ((toYValue - fromYValue) * curMult)));
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null && this.needRotateMap) {
            abstractAdglAnimationParam1V.setNormalizedTime(f);
            gLMapState.setMapAngle((int) this.rotateMapParam.getCurValue());
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V2 == null || !this.needRotateCamera) {
            return;
        }
        abstractAdglAnimationParam1V2.setNormalizedTime(f);
        gLMapState.setCameraDegree((int) this.rotateCameraParam.getCurValue());
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.zoomStartParam;
        if (abstractAdglAnimationParam1V2 != null) {
            abstractAdglAnimationParam1V2.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V3 = this.zoomEndParam;
        if (abstractAdglAnimationParam1V3 != null) {
            abstractAdglAnimationParam1V3.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V4 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V4 != null) {
            abstractAdglAnimationParam1V4.reset();
        }
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setToCameraDegree(float f, int i) {
        this.needRotateCamera = false;
        if (f > 80.0f || f < 0.0f) {
            return;
        }
        this.needRotateCamera = true;
        if (this.rotateCameraParam == null) {
            this.rotateCameraParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateCameraParam.reset();
        this.rotateCameraParam.setInterpolatorType(i, 1.0f);
        this.rotateCameraParam.setToValue(f);
    }

    public void setToMapAngle(float f, int i) {
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i, 1.0f);
        this.rotateMapParam.setToValue(f % 360.0f);
    }

    public void setToMapCenterGeo(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.needMove = true;
        if (this.moveParam == null) {
            this.moveParam = new AbstractAdglAnimationParam2V();
        }
        this.moveParam.reset();
        this.moveParam.setInterpolatorType(i3, 1.0f);
        this.moveParam.setToValue(i, i2);
    }

    public void setToMapLevel(float f, float f2, int i) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i > 0 && i < this.duration) {
            this.midZoomDuration = i;
        }
        if (checkLevel(f) && checkLevel(f2)) {
            this.hasMidZoom = true;
            initZoomStartParam(f2, 0);
            initZoomEndParam(f2, f, 0);
        } else if (checkLevel(f)) {
            this.hasMidZoom = false;
            initZoomStartParam(f, 0);
        } else if (!checkLevel(f2)) {
            this.needZoom = false;
        } else {
            this.hasMidZoom = false;
            initZoomStartParam(f2, 0);
        }
    }

    public void setToMapLevel(float f, int i) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f)) {
            initZoomStartParam(f, i);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }
}
