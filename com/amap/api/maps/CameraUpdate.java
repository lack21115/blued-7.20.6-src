package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/CameraUpdate.class */
public final class CameraUpdate {

    /* renamed from: a  reason: collision with root package name */
    AbstractCameraUpdateMessage f5510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.f5510a = abstractCameraUpdateMessage;
    }

    public final AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.f5510a;
    }
}
