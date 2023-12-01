package com.amap.api.maps.model;

import com.amap.api.col.p0003sl.de;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/MVTTileProvider.class */
public final class MVTTileProvider implements TileProvider {
    private String id;
    private String key;
    private int tileSize = 256;
    private String url;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/MVTTileProvider$a.class */
    public final class a extends de {

        /* renamed from: a  reason: collision with root package name */
        String f5527a;

        public a(String str) {
            this.isPostFlag = false;
            this.f5527a = str;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            return this.f5527a;
        }
    }

    public MVTTileProvider(String str, String str2, String str3) {
        this.url = str;
        this.key = str2;
        this.id = str3;
    }

    private String a(int i, int i2, int i3, int i4) {
        return String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.id, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private byte[] a(int i, int i2, int i3) {
        try {
            return new a(a(i, i2, i3, this.tileSize)).makeHttpRequestWithInterrupted();
        } catch (Exception e) {
            return null;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        byte[] a2 = a(i3, i, i2);
        if (a2 == null) {
            return TileProvider.NO_TILE;
        }
        int i4 = this.tileSize;
        return new Tile(i4, i4, a2, false);
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.tileSize;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.tileSize;
    }

    public final String getUrl() {
        return this.url;
    }
}
