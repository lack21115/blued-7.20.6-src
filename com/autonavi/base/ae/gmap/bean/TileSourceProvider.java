package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/TileSourceProvider.class */
public interface TileSourceProvider extends TileProvider {
    void cancel(TileSourceReq tileSourceReq);

    Tile getTile(TileSourceReq tileSourceReq);
}
