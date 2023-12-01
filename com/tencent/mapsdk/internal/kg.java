package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.internal.m9;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kg.class */
public class kg extends ze implements TileOverlayCallback {
    private static final String J = "%s" + File.separatorChar + "%d-%d-%d";
    public static final String K = "/tile/";
    private static final long L = 1024;
    public int B;
    private Map<String, Integer> C;
    private pg D;
    private TileOverlayOptions E;
    private m9<mg> F;
    private kb G;
    private BlockingQueue<Runnable> H;
    private final pb I;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kg$a.class */
    public class a extends pb {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.pb, com.tencent.mapsdk.internal.jb
        public void c(String str) {
            Runnable c2;
            kb kbVar = kg.this.G;
            if (kbVar == null || (c2 = kbVar.c(str)) == null) {
                return;
            }
            kg.this.H.remove(c2);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kg$b.class */
    public static class b implements m9.b<mg> {
        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.tencent.mapsdk.internal.m9.b
        public boolean a(mg mgVar) {
            if (mgVar != null) {
                mgVar.h();
                return true;
            }
            return true;
        }
    }

    public kg(pg pgVar, TileOverlayOptions tileOverlayOptions) {
        super((a1) pgVar.b().j());
        this.C = new Hashtable();
        this.I = new a();
        this.D = pgVar;
        this.E = tileOverlayOptions;
        if (tileOverlayOptions == null) {
            this.B = -1;
            return;
        }
        this.F = J();
        this.B = this.D.a(this, this.E.isBetterQuality());
        c(this.E.getZIndex());
    }

    private m9<mg> J() {
        TileOverlayOptions tileOverlayOptions;
        if (this.D == null) {
            return null;
        }
        MemoryCache.a aVar = new MemoryCache.a();
        aVar.a(this.E.getMaxMemoryCacheSize(this.D.b()));
        aVar.a(new b(null));
        if (TextUtils.isEmpty(this.D.f) || (tileOverlayOptions = this.E) == null || TextUtils.isEmpty(tileOverlayOptions.getDiskCacheDir())) {
            return q9.b(mg.class, aVar);
        }
        DiskCache.d dVar = new DiskCache.d();
        if (!TextUtils.isEmpty(P())) {
            dVar.a(1024L);
        }
        String str = P() + this.E.getDiskCacheDir();
        dVar.a(new File(this.D.f));
        dVar.a(str);
        dVar.a(-1);
        dVar.a(new lg());
        dVar.a(new ng(this.D.f + File.separator + str));
        return q9.b(mg.class, aVar, dVar);
    }

    private void clearCache() {
        m9<mg> m9Var = this.F;
        if (m9Var == null) {
            return;
        }
        if (m9Var instanceof p9) {
            m9 a2 = ((p9) m9Var).a(0);
            if (a2 instanceof MemoryCache) {
                a2.clear();
            }
            m9 a3 = ((p9) this.F).a(1);
            if (a3 instanceof DiskCache) {
                ((DiskCache) a3).m();
            }
        } else if (m9Var instanceof MemoryCache) {
            m9Var.clear();
        }
        this.C.clear();
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        if (this.D == null || this.B < 0) {
            return;
        }
        clearCache();
        synchronized (this) {
            kb kbVar = this.G;
            if (kbVar != null) {
                kbVar.a();
                this.G = null;
            }
        }
        this.D.c(this.B);
    }

    public og K() {
        return new og(this.D);
    }

    public kb L() {
        kb kbVar;
        synchronized (this) {
            if (this.G == null) {
                kb kbVar2 = new kb();
                this.G = kbVar2;
                kbVar2.a(this.I);
                ThreadPoolExecutor b2 = h7.b();
                this.H = b2.getQueue();
                this.G.a(b2);
            }
            kbVar = this.G;
        }
        return kbVar;
    }

    public int M() {
        return this.B;
    }

    public pg N() {
        return this.D;
    }

    public TileProvider O() {
        return this.E.getTileProvider();
    }

    public String P() {
        return K;
    }

    public void a(String str) {
        if (this.E == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.E.diskCacheDir(str);
        this.F = J();
    }

    public byte[] a(int i, int i2, int i3) {
        TileOverlayOptions tileOverlayOptions = this.E;
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null || i3 < 0) {
            na.g(ma.b, "无效坐标，返回空瓦块");
            return b7.a();
        }
        String format = String.format(J, ga.b(this.E.getVersionInfo()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        Tile tile = this.E.getTileProvider().getTile(i, i2, i3);
        if (tile == null) {
            na.g(ma.b, "Provider没有瓦片数据，返回空瓦块");
            return b7.a();
        }
        byte[] bArr = tile.mData;
        if (bArr != null && bArr.length > 0) {
            ra.a(ma.b, "cacheId", (Object) format);
            mg mgVar = new mg(bArr);
            m9<mg> m9Var = this.F;
            if (m9Var != null) {
                t9 b2 = q9.b(m9Var);
                if (b2 != null) {
                    b2.b(format, (String) mgVar);
                    return bArr;
                }
                this.F.a(format, (String) mgVar);
            }
        }
        return bArr;
    }

    public int b(int i) {
        return i + 100;
    }

    public void b(int i, int i2) {
        int i3;
        pg pgVar = this.D;
        if (pgVar == null || (i3 = this.B) < 0) {
            return;
        }
        pgVar.a(i3, i, i2);
    }

    public void c(int i) {
        if (this.D == null || this.B < 0) {
            return;
        }
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.D.a(this.B, b(i2));
    }

    public void clearTileCache() {
        m9<mg> m9Var = this.F;
        if (m9Var == null) {
            return;
        }
        m9Var.clear();
        this.C.clear();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null && (obj instanceof kg)) {
            if (this.B == ((kg) obj).B) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return y().hashCode();
    }

    @Override // com.tencent.map.lib.callbacks.TileOverlayCallback
    public Bitmap onLoadTile(int i, int i2, int i3, byte[] bArr) {
        int i4;
        TileOverlayOptions tileOverlayOptions = this.E;
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        String format = String.format(J, ga.b(this.E.getVersionInfo()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        int i5 = ra.i(ma.b, "load-count");
        int g = ra.g(ma.b, "cache-count");
        int g2 = ra.g(ma.b, "data-count");
        int g3 = ra.g(ma.b, "req-count");
        int g4 = ra.g(ma.b, "cancel-count");
        mg mgVar = (mg) q9.b(this.F).b(format, mg.class);
        if (mgVar != null) {
            int i6 = ra.i(ma.b, "cache-count");
            int a2 = mgVar.a();
            i4 = a2;
            g = i6;
            if (i5 == g3 + g2 + i6 + g4) {
                ra.j(ma.b);
                i4 = a2;
                g = i6;
            }
        } else {
            i4 = 0;
        }
        ra.a("get from cache of cacheId:" + format, "dataLength:" + i4, "loadCount:" + i5, "reqCount:" + g3, "dataCount:" + g2, "cacheCount:" + g, "cancelCount:" + g4);
        if (mgVar != null) {
            this.C.remove(format);
            mgVar.f();
            return mgVar.d();
        }
        Integer num = this.C.get(format);
        if (num != null && num.intValue() > 10) {
            int i7 = 0;
            for (Map.Entry<String, Integer> entry : this.C.entrySet()) {
                int i8 = i7;
                if (entry.getValue().intValue() > 10) {
                    i8 = i7 + 1;
                }
                i7 = i8;
                if (i8 > 50) {
                    na.b("超过50个瓦片请求大于10次，重新加载TileOverlay");
                    reload();
                    return null;
                }
            }
            return null;
        }
        this.C.put(format, Integer.valueOf(num == null ? 0 : num.intValue() + 1));
        StringBuilder sb = new StringBuilder(128);
        sb.append(pg.g);
        sb.append("://");
        sb.append(pg.h);
        sb.append(BridgeUtil.SPLIT_MARK);
        sb.append(this.B);
        sb.append("?");
        sb.append("x=");
        sb.append(i);
        sb.append("&y=");
        sb.append(i2);
        sb.append("&z=");
        sb.append(i3);
        byte[] bytes = sb.toString().getBytes();
        System.arraycopy((Object) bytes, 0, (Object) bArr, 0, bytes.length);
        return null;
    }

    @Override // com.tencent.map.lib.callbacks.TileOverlayCallback
    public void onLoadTileFinish(int i, int i2, int i3) {
        mg mgVar = (mg) q9.b(this.F).b(String.format(J, ga.b(this.E.getVersionInfo()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)), mg.class);
        if (mgVar != null) {
            mgVar.c();
        }
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        return false;
    }

    @Override // com.tencent.map.lib.callbacks.TileOverlayCallback
    public void onWriteTile(int i, int i2, int i3, String str, byte[] bArr) {
    }

    public void reload() {
        if (this.D == null || this.B < 0) {
            return;
        }
        clearCache();
        this.D.b(this.B);
        BlockingQueue<Runnable> blockingQueue = this.H;
        if (blockingQueue != null) {
            blockingQueue.clear();
        }
    }

    @Override // com.tencent.mapsdk.internal.v0
    public p0 x() {
        return null;
    }
}
