package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/message/HoverGestureMapMessage.class */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;

    public HoverGestureMapMessage(int i, float f) {
        super(i);
        this.angleDelta = 0.0f;
        this.angleDelta = f;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static HoverGestureMapMessage obtain(int i, float f) {
        HoverGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            acquire = new HoverGestureMapMessage(i, f);
        } else {
            acquire.reset();
        }
        acquire.setParams(i, f);
        return acquire;
    }

    private void setParams(int i, float f) {
        setState(i);
        this.angleDelta = f;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        float f;
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        if (cameraDegree < 0.0f) {
            f = 0.0f;
        } else if (cameraDegree > 80.0f) {
            f = 80.0f;
        } else {
            f = cameraDegree;
            if (gLMapState.getCameraDegree() > 40.0f) {
                f = cameraDegree;
                if (cameraDegree > 40.0f) {
                    f = cameraDegree;
                    if (gLMapState.getCameraDegree() > cameraDegree) {
                        f = 40.0f;
                    }
                }
            }
        }
        gLMapState.setCameraDegree(f);
        gLMapState.recalculate();
    }
}
