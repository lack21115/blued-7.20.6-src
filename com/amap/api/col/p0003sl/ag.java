package com.amap.api.col.p0003sl;

import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* renamed from: com.amap.api.col.3sl.ag  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ag.class */
public final class ag extends AbstractCameraUpdateMessage {
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    public final void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> a = dw.a(this, this.mapConfig);
        if (a == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) a.first).floatValue());
        iGLMapState.setMapGeoCenter(((IPoint) a.second).x, ((IPoint) a.second).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
