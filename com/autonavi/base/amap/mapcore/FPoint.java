package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;
import com.autonavi.ae.gmap.maploader.Pools;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/FPoint.class */
public class FPoint extends PointF {
    private static final Pools.SynchronizedPool<FPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public FPoint() {
    }

    public FPoint(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static FPoint obtain() {
        FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new FPoint();
        }
        acquire.set(0.0f, 0.0f);
        return acquire;
    }

    public static FPoint obtain(float f, float f2) {
        FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new FPoint(f, f2);
        }
        acquire.set(f, f2);
        return acquire;
    }

    @Override // android.graphics.PointF
    public boolean equals(Object obj) {
        FPoint fPoint = (FPoint) obj;
        return fPoint != null && this.x == fPoint.x && this.y == fPoint.y;
    }

    @Override // android.graphics.PointF
    public int hashCode() {
        Float.floatToIntBits(this.x);
        return Float.floatToIntBits(this.y) * 37;
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
