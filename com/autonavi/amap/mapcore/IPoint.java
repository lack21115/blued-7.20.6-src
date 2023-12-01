package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/amap/mapcore/IPoint.class */
public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public IPoint() {
    }

    public IPoint(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public static IPoint obtain() {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint();
        }
        acquire.set(0, 0);
        return acquire;
    }

    public static IPoint obtain(int i, int i2) {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint(i, i2);
        }
        acquire.set(i, i2);
        return acquire;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double distance(IPoint iPoint) {
        return Math.sqrt(Math.pow(iPoint.x - this.x, 2.0d) + Math.pow(iPoint.y - this.y, 2.0d));
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
