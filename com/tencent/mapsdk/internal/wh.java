package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wh.class */
public class wh {
    private static final int h = 7;

    /* renamed from: a  reason: collision with root package name */
    private yi f24407a;

    /* renamed from: c  reason: collision with root package name */
    private TileOverlayOptions f24408c;
    private vh d;
    private OverSeaTileProvider e;
    private boolean g;
    private TileOverlay b = null;
    private volatile boolean f = false;

    public wh(yi yiVar) {
        this.f24407a = null;
        this.f24407a = yiVar;
        d();
    }

    private void a() {
        yi yiVar;
        ei k;
        if (this.b != null || (yiVar = this.f24407a) == null || yiVar.getMap() == null || this.f24407a.A() == null || (k = this.d.k()) == null) {
            return;
        }
        na.c(ma.h, "获取海外图图源：" + k);
        rc A = this.f24407a.A();
        A.e(false);
        A.c(false);
        this.e = new xh(k, this.d.d(), A.w());
        String f = this.d.f();
        String g = this.d.g();
        na.c(ma.h, "海外瓦片缓存目录：" + g);
        this.f24408c = new TileOverlayOptions().tileProvider(this.e).betterQuality(false).versionInfo(f).zIndex(1).diskCacheDir(g);
        this.b = A.d0().a(this.f24408c);
        na.c(ma.h, "开启海外图");
    }

    private boolean a(x5[] x5VarArr) {
        x5[] m0;
        yi yiVar = this.f24407a;
        if (yiVar == null || (m0 = yiVar.m0()) == null || x5VarArr == null) {
            return true;
        }
        return th.a(m0, x5VarArr);
    }

    private void d() {
        if (y9.c("4.5.9", "4.0.9", 3)) {
            ha.a(mc.b(this.f24407a.getContext()).h() + "/tencentmapsdk/rastermap/unmainland");
            ha.a(mc.b(this.f24407a.getContext()).c().getPath() + "/rastermap/taiwan");
        }
    }

    private void i() {
        yi yiVar = this.f24407a;
        TileOverlay tileOverlay = this.b;
        if (yiVar == null || yiVar.getMap() == null || yiVar.A() == null || tileOverlay == null) {
            return;
        }
        VectorMap map = yiVar.getMap();
        rc A = yiVar.A();
        A.e(map.h0());
        A.c(true);
        tileOverlay.remove();
        this.b = null;
        this.f24408c = null;
    }

    public void a(Context context, OverSeaSource overSeaSource, Callback<Boolean> callback) {
        vh vhVar = new vh();
        this.d = vhVar;
        vhVar.a(context, overSeaSource, callback);
    }

    public void a(Language language) {
        if (language == null || this.d.b() == language) {
            return;
        }
        this.d.a(language);
        OverSeaTileProvider overSeaTileProvider = this.e;
        if (overSeaTileProvider != null) {
            overSeaTileProvider.onLanguageChange(language);
        }
        h();
    }

    public void a(OverSeaTileProvider overSeaTileProvider) {
        if (this.e != overSeaTileProvider) {
            na.c(ma.h, "设置自定义海外图源，old[" + this.e + "] to new[" + overSeaTileProvider + "]");
            this.e = overSeaTileProvider;
            this.g = true;
            this.d.a(overSeaTileProvider);
            List<zh> h2 = this.d.h();
            yi yiVar = this.f24407a;
            if (yiVar != null) {
                yiVar.a(false, h2);
            }
            h();
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b() {
        na.c(ma.h, "检查海外图状态");
        yi yiVar = this.f24407a;
        if (yiVar == null || yiVar.getMap() == null || this.f24407a.getMapContext() == null) {
            return;
        }
        rc mapContext = this.f24407a.getMapContext();
        if (this.f24407a.getMap().V() < 7) {
            i();
            na.c(ma.h, "级别无效");
            return;
        }
        na.c(ma.h, "级别有效");
        if (!this.d.m() || !mapContext.B()) {
            if (this.b != null) {
                i();
            }
            na.c(ma.h, "权限无效");
            return;
        }
        na.c(ma.h, "权限有效");
        if (!mapContext.A()) {
            if (this.b != null) {
                i();
            }
            na.c(ma.h, "边界线无效");
            return;
        }
        na.c(ma.h, "边界线有效");
        boolean l = this.d.l();
        StringBuilder sb = new StringBuilder();
        sb.append("数据配置模式：");
        sb.append(l ? "暗色" : "亮色");
        na.c(ma.h, sb.toString());
        boolean a2 = this.f24407a.getMapContext().a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前地图模式：");
        sb2.append(a2 ? "暗色" : "亮色");
        na.c(ma.h, sb2.toString());
        if (a2 != l) {
            na.c(ma.h, "更新暗色模式：" + a2);
            this.d.a(a2);
            i();
            OverSeaTileProvider overSeaTileProvider = this.e;
            if (overSeaTileProvider != null) {
                overSeaTileProvider.onDayNightChange(l);
            }
        }
        if (this.g) {
            this.g = false;
            i();
        }
        if (this.b == null) {
            a();
        }
    }

    public void c() {
        TileOverlay tileOverlay = this.b;
        if (tileOverlay == null) {
            return;
        }
        tileOverlay.clearTileCache();
    }

    public vh e() {
        return this.d;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.d.m();
    }

    public void h() {
        b();
        TileOverlayOptions tileOverlayOptions = this.f24408c;
        if (tileOverlayOptions != null) {
            tileOverlayOptions.versionInfo(this.d.f()).diskCacheDir(this.d.g());
        }
        TileOverlay tileOverlay = this.b;
        if (tileOverlay != null) {
            tileOverlay.reload();
        }
    }
}
