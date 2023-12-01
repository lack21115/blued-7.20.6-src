package com.autonavi.amap.mapcore;

import com.autonavi.ae.gmap.maploader.Pools;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/amap/mapcore/DPoint.class */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);
    public double x;
    public double y;

    public DPoint() {
    }

    public DPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(0.0d, 0.0d);
        return acquire;
    }

    public static DPoint obtain(double d, double d2) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d, d2);
        }
        acquire.set(d, d2);
        return acquire;
    }

    private void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DPoint) {
            DPoint dPoint = (DPoint) obj;
            return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(dPoint.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(dPoint.y);
        }
        return false;
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
