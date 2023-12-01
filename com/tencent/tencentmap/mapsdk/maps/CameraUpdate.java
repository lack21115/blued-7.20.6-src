package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/CameraUpdate.class */
public final class CameraUpdate {
    private final CamerParameter camerPara;

    public CameraUpdate(CamerParameter camerParameter) {
        this.camerPara = camerParameter;
    }

    public CamerParameter getParams() {
        return this.camerPara;
    }
}
