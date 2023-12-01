package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/TileOverlay.class */
public interface TileOverlay extends IOverlay {
    void clearTileCache();

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    String getId();

    void reload();

    void remove();

    void setDiskCacheDir(String str);

    void setZindex(int i);
}
