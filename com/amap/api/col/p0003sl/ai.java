package com.amap.api.col.p0003sl;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* renamed from: com.amap.api.col.3sl.ai  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ai.class */
public final class ai extends AbstractCameraUpdateMessage {
    private static void a(IGLMapState iGLMapState, int i, int i2, Point point) {
        iGLMapState.screenToP20Point(i, i2, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f = this.xPixel;
        float f2 = this.yPixel;
        float f3 = this.width / 2.0f;
        float f4 = this.height / 2.0f;
        Point point = new Point();
        a(iGLMapState, (int) (f3 + f), (int) (f4 + f2), point);
        iGLMapState.setMapGeoCenter(point.x, point.y);
    }
}
