package com.amap.api.col.p0003sl;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.ae  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ae.class */
public final class ae implements TileSourceProvider {

    /* renamed from: a  reason: collision with root package name */
    private int f4734a = 256;
    private final TileOverlaySource b;

    /* renamed from: c  reason: collision with root package name */
    private final TileOverlaySource f4735c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ae$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ae$a.class */
    public final class a extends de {
        private String b;
        private String g;

        public a(int i, int i2, int i3, String str) {
            this.b = "";
            this.g = "";
            String format = String.format(str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
            if (!format.contains("?")) {
                this.b = format + "?";
                return;
            }
            String[] split = format.split("\\?");
            if (split.length > 1) {
                this.b = split[0] + "?";
                this.g = split[1];
            }
        }

        @Override // com.amap.api.col.p0003sl.de, com.amap.api.col.p0003sl.kb
        public final Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.g);
            stringBuffer.append("&key=");
            stringBuffer.append(ho.f(aa.f4728a));
            stringBuffer.append("&channel=amapapi");
            return this.b + a(stringBuffer.toString());
        }
    }

    public ae(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.b = tileOverlaySource;
        this.f4735c = tileOverlaySource2;
    }

    private Tile a(TileSourceReq tileSourceReq) {
        String str = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i = tileSourceReq.x > 0 ? tileSourceReq.x / 10 : tileSourceReq.x;
            int i2 = tileSourceReq.y > 0 ? tileSourceReq.y / 10 : tileSourceReq.y;
            FileInputStream fileInputStream = new FileInputStream(new File(str + tileSourceReq.zoom + BridgeUtil.SPLIT_MARK + i + BridgeUtil.SPLIT_MARK + i2 + BridgeUtil.SPLIT_MARK + tileSourceReq.x + BridgeUtil.UNDERLINE_STR + tileSourceReq.y + ".png"));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            Tile tile = new Tile(this.f4734a, this.f4734a, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (FileNotFoundException e) {
            int i3 = tileSourceReq.x >> (tileSourceReq.zoom - 6);
            int i4 = tileSourceReq.y >> (tileSourceReq.zoom - 6);
            if (i3 >= 51 && i3 <= 53 && i4 >= 28 && i4 <= 31) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    Tile tile2 = new Tile(this.f4734a, this.f4734a, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return TileProvider.NO_TILE;
                }
            }
            return TileProvider.NO_TILE;
        } catch (IOException e3) {
            return TileProvider.NO_TILE;
        }
    }

    private byte[] a(int i, int i2, int i3, String str) {
        try {
            return new a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final void cancel(TileSourceReq tileSourceReq) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final Tile getTile(TileSourceReq tileSourceReq) {
        Tile tile;
        String url;
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        Tile tile2 = TileProvider.NO_TILE;
        try {
            url = tileSourceReq.sourceType == this.f4735c.getId() ? this.f4735c.getUrl() : this.b.getUrl();
        } catch (Exception e) {
            tile = TileProvider.NO_TILE;
            e.printStackTrace();
        }
        if (url == null) {
            return TileProvider.NO_TILE;
        }
        if (MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null) {
            tile2 = a(tileSourceReq);
        }
        tile = tile2;
        if (tile2 == TileProvider.NO_TILE) {
            return new Tile(this.f4734a, this.f4734a, a(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom, url), true);
        }
        return tile;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f4734a;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f4734a;
    }
}
