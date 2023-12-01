package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.wg;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.lang.reflect.Field;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ug.class */
public class ug implements wg.b {
    public static final String e = "rastermap/handdraw";
    private static final int f = 4;
    private static final int g = 20;
    private yi b;
    private TileOverlayOptions d;

    /* renamed from: a  reason: collision with root package name */
    private final Object f24360a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private TileOverlay f24361c = null;

    public ug(yi yiVar) {
        this.b = null;
        this.b = yiVar;
        if (yiVar != null) {
            tg.a(yiVar.getContext());
            new wg(this.b.getContext(), this).a();
        }
    }

    @Override // com.tencent.mapsdk.internal.wg.b
    public void a() {
        d();
    }

    public void b() {
        yi yiVar;
        if (this.f24361c != null || (yiVar = this.b) == null || yiVar.getMap() == null) {
            return;
        }
        VectorMap map = this.b.getMap();
        if (this.d == null) {
            this.d = new TileOverlayOptions();
            this.d.tileProvider(new vg(this.d)).diskCacheDir(e).zIndex(2);
        }
        map.k(19);
        this.f24361c = map.addTileOverlay(this.d);
        f();
    }

    public boolean c() {
        return this.f24361c != null;
    }

    public void d() {
        TileOverlayOptions tileOverlayOptions = this.d;
        if (tileOverlayOptions != null) {
            ((vg) tileOverlayOptions.getTileProvider()).b();
        }
        synchronized (this.f24360a) {
            TileOverlay tileOverlay = this.f24361c;
            if (tileOverlay != null) {
                tileOverlay.clearTileCache();
                this.f24361c.reload();
            }
        }
    }

    public void e() {
        synchronized (this.f24360a) {
            TileOverlay tileOverlay = this.f24361c;
            if (tileOverlay == null) {
                return;
            }
            tileOverlay.remove();
            this.f24361c = null;
        }
    }

    public void f() {
        synchronized (this.f24360a) {
            TileOverlay tileOverlay = this.f24361c;
            if (tileOverlay == null) {
                return;
            }
            Field[] declaredFields = tileOverlay.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Field field = declaredFields[i2];
                if (field.getType() == kg.class) {
                    try {
                        field.setAccessible(true);
                        ((kg) field.get(this.f24361c)).b(4, 20);
                        field.setAccessible(false);
                        return;
                    } catch (IllegalAccessException e2) {
                        na.b("SketchOverlayManager set data level with reflect", e2);
                        return;
                    }
                }
                i = i2 + 1;
            }
        }
    }
}
