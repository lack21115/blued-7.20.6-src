package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetErrorException;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/UrlTileProvider.class */
public abstract class UrlTileProvider implements TileProvider {
    private final int mHeight;
    private final int mWidth;

    public UrlTileProvider() {
        this(256, 256);
    }

    public UrlTileProvider(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        Tile tile = TileProvider.NO_TILE;
        if (tileUrl == null) {
            return tile;
        }
        NetResponse requestTileData = requestTileData(tileUrl.toString());
        byte[] bArr = null;
        if (requestTileData != null) {
            if (requestTileData.available()) {
                bArr = requestTileData.data;
            } else {
                bArr = null;
                if (requestTileData.exception instanceof NetErrorException) {
                    return requestTileData.statusCode == 404 ? tile : new Tile(this.mWidth, this.mHeight, null);
                }
            }
        }
        Tile tile2 = tile;
        if (bArr != null) {
            tile2 = tile;
            if (bArr.length != 0) {
                tile2 = new Tile(this.mWidth, this.mHeight, bArr);
            }
        }
        return tile2;
    }

    public abstract URL getTileUrl(int i, int i2, int i3);

    public NetResponse requestTileData(String str) {
        try {
            return NetManager.getInstance().builder().url(str).doGet();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
