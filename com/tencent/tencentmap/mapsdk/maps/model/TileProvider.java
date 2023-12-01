package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/TileProvider.class */
public interface TileProvider {
    public static final Tile NO_TILE = Tile.EMPTY_TILE;

    Tile getTile(int i, int i2, int i3);
}
