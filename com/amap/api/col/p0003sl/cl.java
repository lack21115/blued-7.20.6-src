package com.amap.api.col.p0003sl;

import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3sl.cl  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cl.class */
public final class cl {

    /* renamed from: a  reason: collision with root package name */
    private final IAMapDelegate f4808a;
    private TileOverlay b;

    /* renamed from: c  reason: collision with root package name */
    private TileOverlay f4809c;
    private boolean d = false;
    private boolean e = false;

    public cl(IAMapDelegate iAMapDelegate) {
        this.f4808a = iAMapDelegate;
    }

    private void b() {
        if (this.b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new dd(this.f4808a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.d);
            try {
                this.b = this.f4808a.addTileOverlay(tileProvider);
                this.f4809c = this.f4808a.addTileOverlay(tileProvider);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void c() {
        boolean e = e();
        if (e) {
            b();
        }
        if (this.d != e) {
            this.d = e;
            TileOverlay tileOverlay = this.b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(e);
            }
        }
    }

    private void d() {
        boolean f = f();
        if (f) {
            b();
        }
        if (this.e != f) {
            this.e = f;
            TileOverlay tileOverlay = this.f4809c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(f);
            }
        }
    }

    private boolean e() {
        IAMapDelegate iAMapDelegate = this.f4808a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
    }

    private static boolean f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }
}
