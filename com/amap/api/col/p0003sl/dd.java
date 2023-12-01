package com.amap.api.col.p0003sl;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.amap.api.col.3sl.dd  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dd.class */
public final class dd implements TileProvider {

    /* renamed from: c  reason: collision with root package name */
    private MapConfig f4847c;

    /* renamed from: a  reason: collision with root package name */
    private final int f4846a = 256;
    private final int b = 256;
    private final boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.dd$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dd$a.class */
    public final class a extends de {

        /* renamed from: a  reason: collision with root package name */
        Random f4848a = new Random();
        private int g;
        private int h;
        private int i;
        private String j;
        private String k;

        public a(int i, int i2, int i3, String str) {
            this.k = "";
            this.g = i;
            this.h = i2;
            this.i = i3;
            this.j = str;
            this.k = c();
        }

        private String c() {
            if (dp.a(this.g, this.h, this.i) || this.i < 6) {
                return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((this.f4848a.nextInt(100000) % 4) + 1));
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                return "http://restsdk.amap.com/v4/gridmap?";
            } else {
                return null;
            }
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(ho.f(aa.f4728a));
            stringBuffer.append("&channel=amapapi");
            if (dp.a(this.g, this.h, this.i) || this.i < 6) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.i);
                stringBuffer.append("&x=");
                stringBuffer.append(this.g);
                stringBuffer.append("&y=");
                stringBuffer.append(this.h);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                stringBuffer.append("&x=");
                stringBuffer.append(this.g);
                stringBuffer.append("&y=");
                stringBuffer.append(this.h);
                stringBuffer.append("&z=");
                stringBuffer.append(this.i);
                stringBuffer.append("&ds=0");
                stringBuffer.append("&dpitype=webrd");
                stringBuffer.append("&lang=");
                stringBuffer.append(this.j);
                stringBuffer.append("&scale=2");
            }
            return this.k + a(stringBuffer.toString());
        }
    }

    public dd(MapConfig mapConfig) {
        this.f4847c = mapConfig;
    }

    private byte[] a(int i, int i2, int i3, String str) throws IOException {
        try {
            return new a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            if (!this.d) {
                if (this.f4847c.getMapLanguage().equals("zh_cn")) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return NO_TILE;
                    }
                    if (i3 < 6 || dp.a(i, i2, i3)) {
                        return NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i3 >= 6 && !dp.a(i, i2, i3)) {
                    return NO_TILE;
                }
            }
            byte[] a2 = a(i, i2, i3, this.f4847c != null ? this.f4847c.getMapLanguage() : "zh_cn");
            return a2 == null ? NO_TILE : Tile.obtain(this.f4846a, this.b, a2);
        } catch (IOException e) {
            return NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f4846a;
    }
}
