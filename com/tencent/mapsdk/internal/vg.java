package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vg.class */
public class vg extends UrlTileProvider {
    private static final int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private static int f38075c;

    /* renamed from: a  reason: collision with root package name */
    private TileOverlayOptions f38076a;

    public vg(TileOverlayOptions tileOverlayOptions) {
        super(256, 256);
        this.f38076a = tileOverlayOptions;
        f38075c = tg.a();
        TileOverlayOptions tileOverlayOptions2 = this.f38076a;
        if (tileOverlayOptions2 != null) {
            tileOverlayOptions2.versionInfo(a());
        }
    }

    private String a() {
        return Integer.toString(f38075c);
    }

    public void b() {
        f38075c = tg.a();
        TileOverlayOptions tileOverlayOptions = this.f38076a;
        if (tileOverlayOptions != null) {
            tileOverlayOptions.versionInfo(a());
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
    public URL getTileUrl(int i, int i2, int i3) {
        String sketchTileUrl = ((d3) ((r3) n2.a(r3.class)).d()).sketchTileUrl(i, (int) ((Math.pow(2.0d, i3) - 1.0d) - i2), i3, f38075c);
        try {
            if (TextUtils.isEmpty(sketchTileUrl)) {
                return null;
            }
            return new URL(sketchTileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
