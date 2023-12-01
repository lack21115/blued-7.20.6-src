package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/TileReqTaskHandle.class */
public class TileReqTaskHandle {
    long nativeObj;
    int status;
    Tile tile;

    public void finish(Tile tile) {
        this.tile = tile;
    }
}
