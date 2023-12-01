package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/CameraUpdate.class */
public final class CameraUpdate {
    AbstractCameraUpdateMessage a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.a = abstractCameraUpdateMessage;
    }

    public final AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.a;
    }
}
