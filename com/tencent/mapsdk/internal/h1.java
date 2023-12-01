package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.b7;
import com.tencent.mapsdk.internal.d0;
import com.tencent.mapsdk.internal.l1;
import com.tencent.mapsdk.internal.oi;
import com.tencent.mapsdk.internal.qh;
import com.tencent.mapsdk.internal.t4;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1.class */
public final class h1 implements i5, j0, k0, m0 {
    private x1 d;
    private volatile yi e;
    private Context f;
    private String g;
    private l1 h;
    private pg j;
    private yg k;
    private tf l;
    private CameraPosition s;
    private float w;
    private t4 x;
    private mf i = null;
    private final GeoPoint m = null;
    private final GeoPoint n = null;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private final byte[] t = new byte[0];
    private int u = 0;
    private int v = 1000;
    private final h y = new h(false);
    private final h z = new h(true);
    private d0.h A = new a();
    private final oi.c B = new b();
    private l5 C = new f();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$a.class */
    public class a implements d0.h {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.d0.h
        public void a(a9 a9Var) {
            yi yiVar;
            VectorMap map;
            if (a9Var.f37291a == 10000 && (a9Var instanceof oi) && (yiVar = h1.this.e) != null && (map = yiVar.getMap()) != null) {
                oi oiVar = (oi) a9Var;
                if (oiVar.p()) {
                    map.d((yiVar.Z0 / 2) - oiVar.f(), (yiVar.a1 / 2) - oiVar.g());
                }
                if (oiVar.s()) {
                    map.d(oiVar.l(), oiVar.m());
                }
                if (oiVar.u()) {
                    map.c(oiVar.k());
                }
                if (oiVar.o()) {
                    int h = oiVar.h();
                    int i = oiVar.i();
                    map.e(h, i);
                    if (oiVar.q()) {
                        yiVar.c(h, i);
                    }
                }
                if (oiVar.r()) {
                    map.b(oiVar.j());
                }
                if (oiVar.t()) {
                    map.d(oiVar.n());
                }
                if (oiVar.p()) {
                    map.d(oiVar.f() - (yiVar.Z0 / 2), oiVar.g() - (yiVar.a1 / 2));
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$b.class */
    public class b implements oi.c {
        public b() {
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public float a() {
            if (h1.this.e == null) {
                return 0.0f;
            }
            return h1.this.o();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public void a(Runnable runnable) {
            if (runnable == null || h1.this.e == null) {
                return;
            }
            ca.a(runnable, 100L);
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public GeoPoint b() {
            if (h1.this.e == null) {
                return null;
            }
            return h1.this.e.getMap().s();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public GeoPoint c() {
            if (h1.this.e == null) {
                return null;
            }
            return h1.this.e.c();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public float d() {
            if (h1.this.e == null) {
                return 0.0f;
            }
            return h1.this.e.getMap().T();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public float e() {
            if (h1.this.e == null) {
                return 0.0f;
            }
            return h1.this.e.getMap().U();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public int f() {
            if (h1.this.e == null) {
                return 0;
            }
            return h1.this.e.getMap().P();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public boolean g() {
            if (h1.this.e == null) {
                return false;
            }
            return h1.this.e.i().l();
        }

        @Override // com.tencent.mapsdk.internal.oi.c
        public float h() {
            if (h1.this.e == null) {
                return 0.0f;
            }
            return h1.this.e.getMap().Z();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$c.class */
    public class c implements t4.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f37499a;
        public final /* synthetic */ TencentMap.CancelableCallback b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f37500c;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$c$a.class */
        public class a implements Runnable {
            public final /* synthetic */ float b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ GeoPoint f37501c;

            public a(float f, GeoPoint geoPoint) {
                this.b = f;
                this.f37501c = geoPoint;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h1.this.e == null) {
                    return;
                }
                c cVar = c.this;
                if (!cVar.f37499a) {
                    h1.this.e.getMap().h(this.f37501c);
                    h1.this.e.getMap().b(this.b);
                    return;
                }
                double maxZoomLevel = (((int) h1.this.getMaxZoomLevel()) - (Math.log(1.0f / this.b) / Math.log(2.0d))) - 2.0d;
                double d = maxZoomLevel;
                if (maxZoomLevel < 0.0d) {
                    d = 0.0d;
                }
                oi oiVar = new oi(10000);
                oiVar.a(this.f37501c.getLatitudeE6(), this.f37501c.getLongitudeE6());
                oiVar.f((float) d);
                oiVar.a(h1.this.B);
                oiVar.a(c.this.b);
                oiVar.a(c.this.f37500c);
                h1.this.e.getMap().a(oiVar);
            }
        }

        public c(boolean z, TencentMap.CancelableCallback cancelableCallback, long j) {
            this.f37499a = z;
            this.b = cancelableCallback;
            this.f37500c = j;
        }

        @Override // com.tencent.mapsdk.internal.t4.a
        public void a(float f, GeoPoint geoPoint, double d) {
            if (h1.this.e == null) {
                return;
            }
            ca.b(new a(f, geoPoint));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$d.class */
    public class d implements t4.a {
        public d() {
        }

        @Override // com.tencent.mapsdk.internal.t4.a
        public void a(float f, GeoPoint geoPoint, double d) {
            LatLng d2 = fa.d(geoPoint);
            double log = 20 - (Math.log(1.0f / f) / Math.log(2.0d));
            double d3 = log;
            if (log < 0.0d) {
                d3 = 0.0d;
            }
            h1 h1Var = h1.this;
            h1Var.s = new CameraPosition(d2, (float) d3, h1Var.e.getMap().Z(), h1.this.e.getMap().T());
            synchronized (h1.this.t) {
                h1.this.t.notifyAll();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$e.class */
    public class e implements t4.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TencentMap.AsyncOperateCallback f37503a;

        public e(TencentMap.AsyncOperateCallback asyncOperateCallback) {
            this.f37503a = asyncOperateCallback;
        }

        @Override // com.tencent.mapsdk.internal.t4.a
        public void a(float f, GeoPoint geoPoint, double d) {
            LatLng d2 = fa.d(geoPoint);
            double log = 20 - (Math.log(1.0f / f) / Math.log(2.0d));
            double d3 = log;
            if (log < 0.0d) {
                d3 = 0.0d;
            }
            h1 h1Var = h1.this;
            h1Var.s = new CameraPosition(d2, (float) d3, h1Var.e.getMap().Z(), h1.this.e.getMap().T());
            TencentMap.AsyncOperateCallback asyncOperateCallback = this.f37503a;
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(h1.this.s);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$f.class */
    public class f implements l5 {

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$f$a.class */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h1.this.e == null) {
                    return;
                }
                h1.this.e.c(h1.this.e.getMap().M().x());
            }
        }

        public f() {
        }

        @Override // com.tencent.mapsdk.internal.l5
        public void b() {
            ca.b(new a());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$g.class */
    public interface g {
        void a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h1$h.class */
    public class h implements g {

        /* renamed from: a  reason: collision with root package name */
        private boolean f37504a;

        public h(boolean z) {
            this.f37504a = false;
            this.f37504a = z;
        }

        @Override // com.tencent.mapsdk.internal.h1.g
        public void a() {
            if (h1.this.e.Z0 == 0 || h1.this.e.a1 == 0) {
                return;
            }
            h1.this.e.a((g) null);
            if (h1.this.e.S0 == null || h1.this.e.T0 == null) {
                return;
            }
            LatLng latLng = new LatLng(0.0d, 0.0d);
            float a2 = (h1.this.e.V0 == 0 && h1.this.e.W0 == 0 && h1.this.e.X0 == 0 && h1.this.e.Y0 == 0) ? h1.this.x.a(h1.this.e.S0, h1.this.e.T0, 0, 0, 0, 0, latLng) : h1.this.x.a(h1.this.e.S0, h1.this.e.T0, h1.this.e.V0, h1.this.e.W0, h1.this.e.X0, h1.this.e.Y0, latLng);
            TencentMap.CancelableCallback cancelableCallback = h1.this.e.h0;
            if (this.f37504a) {
                oi oiVar = new oi(10000);
                oiVar.c(0.0f);
                oiVar.d(0.0f);
                oiVar.a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                oiVar.f(a2);
                oiVar.a(h1.this.B);
                oiVar.a(cancelableCallback);
                h1.this.e.getMap().a(oiVar);
            } else {
                h1.this.e.getMap().b(0.0f);
                h1.this.e.getMap().d(0.0f);
                h1.this.e.getMap().e((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                h1.this.b(a2, false, 0L, null);
            }
            h1.this.e.S0 = null;
            h1.this.e.T0 = null;
            h1.this.e.V0 = 0;
            h1.this.e.W0 = 0;
            h1.this.e.X0 = 0;
            h1.this.e.Y0 = 0;
            h1.this.e.h0 = null;
        }
    }

    public h1(e1 e1Var, x1 x1Var, TencentMapOptions tencentMapOptions) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.w = 1.0f;
        Context applicationContext = e1Var.getContext().getApplicationContext();
        this.f = applicationContext;
        this.w = g7.d(applicationContext);
        this.d = x1Var;
        this.e = (yi) e1Var.j();
        b7.a aVar = b7.e;
        if (aVar == null || aVar.b() == 0) {
            b7.e = new b7.a(this.f, Math.max(10, tencentMapOptions.getMaxIconMemoryCacheSize()) * 1048576);
        } else {
            b7.e.c();
        }
        this.e.a(this);
        this.x = this.e.getMap().getProjection();
        this.e.getMap().a(this.A);
        this.e.getMap().a(this.C);
        if (tencentMapOptions != null && !f7.b(tencentMapOptions.getSubKey())) {
            this.g = tencentMapOptions.getSubKey();
        }
        pg d0 = this.e.A().d0();
        this.j = d0;
        this.l = new tf(this.f, d0, this.e.h0());
        this.k = new yg(this.f, this.g);
        if (this.h == null) {
            this.h = new l1(e1Var, this.e.F(), this.d);
        }
    }

    private int a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (latLngBounds == null) {
            return -1;
        }
        int i5 = -1;
        if (latLngBounds.northeast != null) {
            if (latLngBounds.southwest == null) {
                return -1;
            }
            if (this.e.Z0 != 0 && this.e.a1 != 0) {
                this.e.a((g) null);
                LatLng latLng = new LatLng();
                float a2 = this.x.a(latLngBounds.southwest, latLngBounds.northeast, i, i2, i3, i4, latLng);
                if (a2 < 0.0f) {
                    return (int) a2;
                }
                if (!z) {
                    this.e.getMap().e((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                    b(a2, false, j, null);
                    this.e.getMap().b(0.0f);
                    this.e.getMap().d(0.0f);
                    return 0;
                }
                oi oiVar = new oi(10000);
                oiVar.c(0.0f);
                oiVar.d(0.0f);
                oiVar.a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                oiVar.f(a2);
                oiVar.a(this.B);
                oiVar.a(cancelableCallback);
                oiVar.a(j);
                this.e.getMap().a(oiVar);
                return 0;
            }
            this.e.S0 = latLngBounds.southwest;
            this.e.T0 = latLngBounds.northeast;
            this.e.V0 = i;
            this.e.W0 = i2;
            this.e.X0 = i3;
            this.e.Y0 = i4;
            this.e.h0 = cancelableCallback;
            if (z) {
                this.e.a(this.z);
            } else {
                this.e.a(this.y);
            }
            int j2 = g7.j(this.f);
            int i6 = g7.i(this.f);
            i5 = -1;
            if (i + i2 + this.o + this.q <= j2) {
                if (i3 + i4 + this.p + this.r > i6) {
                    return -1;
                }
                i5 = 0;
            }
        }
        return i5;
    }

    private int a(LatLngBounds latLngBounds, int i, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (latLngBounds == null) {
            return -1;
        }
        int i2 = -1;
        if (latLngBounds.northeast != null) {
            if (latLngBounds.southwest == null) {
                return -1;
            }
            if (this.e.Z0 != 0 && this.e.a1 != 0) {
                this.e.a((g) null);
                LatLng latLng = new LatLng(0.0d, 0.0d);
                float a2 = this.x.a(latLngBounds.southwest, latLngBounds.northeast, i, i, i, i, latLng);
                if (a2 < 0.0f) {
                    return (int) a2;
                }
                if (!z) {
                    this.e.getMap().e((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                    b(a2, false, j, null);
                    return 0;
                }
                oi oiVar = new oi(10000);
                oiVar.a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                oiVar.f(a2);
                oiVar.a(this.B);
                oiVar.a(cancelableCallback);
                oiVar.a(j);
                this.e.getMap().a(oiVar);
                return 0;
            }
            this.e.S0 = latLngBounds.southwest;
            this.e.T0 = latLngBounds.northeast;
            this.e.U0 = i;
            this.e.h0 = cancelableCallback;
            if (z) {
                this.e.a(this.z);
            } else {
                this.e.a(this.y);
            }
            int j2 = g7.j(this.f);
            int i3 = g7.i(this.f);
            int i4 = i * 2;
            i2 = -1;
            if (this.o + i4 + this.q <= j2) {
                if (i4 + this.p + this.r > i3) {
                    return -1;
                }
                i2 = 0;
            }
        }
        return i2;
    }

    private int a(List<u4> list, int i, int i2, int i3, int i4, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        t4 projection = this.e.getMap().getProjection();
        if (projection == null) {
            return Integer.MIN_VALUE;
        }
        int i5 = -1;
        if (list != null) {
            if (list.isEmpty()) {
                return -1;
            }
            ArrayList arrayList = new ArrayList();
            for (u4 u4Var : list) {
                if (u4Var != null && u4Var.getGroupBounds() != null) {
                    arrayList.addAll(u4Var.getGroupBounds());
                }
            }
            if (this.e.Z0 != 0 && this.e.a1 != 0) {
                if (i + i2 > this.e.Z0 || i3 + i4 > this.e.a1) {
                    return -1;
                }
                projection.a(arrayList, null, new Rect(i, i3, i2, i4), new c(z, cancelableCallback, j));
                return 0;
            }
            int j2 = g7.j(this.f);
            int i6 = g7.i(this.f);
            i5 = -1;
            if (i + i2 <= j2) {
                if (i3 + i4 > i6) {
                    return -1;
                }
                i5 = 0;
            }
        }
        return i5;
    }

    private void a(double d2, double d3, float f2, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null) {
            return;
        }
        int i = (int) (d2 * 1000000.0d);
        int i2 = (int) (d3 * 1000000.0d);
        int Q = this.e.getMap().Q();
        float R = this.e.getMap().R();
        float f3 = f2;
        if (f2 < R) {
            f3 = R;
        }
        float f4 = Q;
        float f5 = f3;
        if (f3 > f4) {
            f5 = f4;
        }
        double pow = 1.0d / Math.pow(2.0d, f4 - f5);
        if (!z) {
            this.e.getMap().e(i, i2);
            this.e.getMap().b((float) pow);
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.a(i, i2);
        oiVar.f(f5);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private void a(double d2, double d3, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null) {
            return;
        }
        int i = (int) (d2 * 1000000.0d);
        int i2 = (int) (d3 * 1000000.0d);
        if (!z) {
            this.e.getMap().e(i, i2);
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.a(i, i2);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private void a(float f2, float f3, float f4, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null || f2 == 0.0f) {
            return;
        }
        if (!z) {
            double d2 = f3;
            double d3 = f4;
            this.e.getMap().a((float) (1.0d / (f2 < 0.0f ? Math.pow(2.0d, Math.abs(f2)) : Math.pow(0.5d, Math.abs(f2)))), d2, d3, d2, d3, (Runnable) null);
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.b((int) f3, (int) f4);
        oiVar.e(f2);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private void a(float f2, float f3, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (!z) {
            this.e.getMap().b(f2);
            if (f3 >= 0.0f) {
                this.e.getMap().d(f3);
                return;
            }
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.c(f2);
        if (f3 >= 0.0f) {
            oiVar.d(f3);
        }
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private void a(float f2, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null || f2 == 0.0f) {
            return;
        }
        if (!z) {
            this.e.getMap().b(this.e.getMap().U() * ((float) (1.0d / (f2 < 0.0f ? Math.pow(2.0d, Math.abs(f2)) : Math.pow(0.5d, Math.abs(f2))))));
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.e(f2);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private void a(CameraPosition cameraPosition, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null || cameraPosition == null) {
            return;
        }
        GeoPoint from = GeoPoint.from(cameraPosition.target);
        float f2 = cameraPosition.zoom;
        int Q = this.e.getMap().Q();
        float R = this.e.getMap().R();
        float f3 = f2;
        if (f2 < R) {
            f3 = R;
        }
        float f4 = Q;
        float f5 = f3;
        if (f3 > f4) {
            f5 = f4;
        }
        if (!z) {
            double pow = 1.0d / Math.pow(2.0d, f4 - f5);
            if (from != null) {
                this.e.getMap().e(from.getLatitudeE6(), from.getLongitudeE6());
            }
            this.e.getMap().b((float) pow);
            this.e.getMap().b(cameraPosition.bearing);
            if (cameraPosition.tilt >= 0.0f) {
                this.e.getMap().d(cameraPosition.tilt);
                return;
            }
            return;
        }
        oi oiVar = new oi(10000);
        if (from != null) {
            oiVar.a(from.getLatitudeE6(), from.getLongitudeE6());
        }
        oiVar.f(f5);
        oiVar.c(cameraPosition.bearing);
        float f6 = cameraPosition.tilt;
        if (f6 >= 0.0f) {
            oiVar.d(f6);
        }
        oiVar.a(this.B);
        oiVar.a(j);
        oiVar.a(cancelableCallback);
        this.e.getMap().a(oiVar);
    }

    private void a(boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (!z) {
            this.e.getMap().c(this.e.getMap().U() * 2.0f);
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.e(1.0f);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private List<u4> b(List<IOverlay> list) {
        ArrayList arrayList = new ArrayList();
        for (IOverlay iOverlay : list) {
            if (iOverlay instanceof u4) {
                arrayList.add((u4) iOverlay);
            }
        }
        return arrayList;
    }

    private void b(float f2, float f3, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null) {
            return;
        }
        if (f2 == 0.0f && f3 == 0.0f) {
            return;
        }
        if (!z) {
            this.e.getMap().d((int) f2, (int) f3);
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.c((int) f2, (int) f3);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (this.e == null) {
            return;
        }
        if (!z) {
            this.e.getMap().b((float) (1.0d / Math.pow(2.0d, this.e.getMap().Q() - Math.min(f2, Math.min(this.e.getMap().P(), this.e.i().l() ? 22 : 20)))));
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.f(f2);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    private void b(boolean z, long j, TencentMap.CancelableCallback cancelableCallback) {
        if (!z) {
            this.e.getMap().c(this.e.getMap().U() / 2.0f);
            return;
        }
        oi oiVar = new oi(10000);
        oiVar.e(-1.0f);
        oiVar.a(this.B);
        oiVar.a(cancelableCallback);
        oiVar.a(j);
        this.e.getMap().a(oiVar);
    }

    public float a(double d2, LatLng latLng) {
        if (latLng == null) {
            return 0.0f;
        }
        return this.e.getMap().a(d2, new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d)));
    }

    public float a(float f2, int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        int i5 = this.e.Z0;
        int i6 = this.e.a1;
        if (i5 == 0 || i6 == 0 || latLng == null || latLng2 == null) {
            return 0.0f;
        }
        int Q = this.e.getMap().Q();
        p5 a2 = this.x.a(this.f, latLng);
        p5 a3 = this.x.a(this.f, latLng2);
        double d2 = a3.b - a2.b;
        double d3 = d2;
        if (d2 < 0.0d) {
            d3 = Math.abs(d2);
        }
        double d4 = a3.f37683c - a2.f37683c;
        double d5 = d4;
        if (d4 < 0.0d) {
            d5 = Math.abs(d4);
        }
        int i7 = (i5 - i) - i2;
        if (f2 == 90.0f) {
            f2 = 89.0f;
        }
        int cos = (int) (((i6 - i3) - i4) / Math.cos((f2 * 3.141592653589793d) / 180.0d));
        int i8 = i7;
        if (i7 <= 0) {
            i8 = 1;
        }
        int i9 = cos;
        if (cos <= 0) {
            i9 = 1;
        }
        double log = Math.log((d3 * 1.0d) / i8) / Math.log(2.0d);
        double log2 = Math.log((d5 * 1.0d) / i9) / Math.log(2.0d);
        double d6 = log;
        if (log < 0.0d) {
            d6 = 0.0d;
        }
        if (log2 < 0.0d) {
            log2 = 0.0d;
        }
        return (float) (Q - Math.max(d6, log2));
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float a(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return this.x.a(latLng, latLng2, i, i2, i3, i4, latLng3);
    }

    public int a(int i, int i2, int i3, int i4, boolean z) {
        int a2 = this.e.getMap().a(i, i2, i3, i4, z);
        if (a2 == 0) {
            this.o = i;
            this.p = i2;
            this.q = i3;
            this.r = i4;
        }
        return a2;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int a(String str) {
        if (this.e == null || this.e.i() == null) {
            return -1;
        }
        return this.e.i().a(str);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int a(byte[] bArr, String str) {
        return -1;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public List<Rect> a(List<String> list) {
        gg N;
        ArrayList arrayList = null;
        if (list != null) {
            if (!list.isEmpty() && this.e != null) {
                ArrayList arrayList2 = new ArrayList(list.size());
                t4 projection = this.e.getMap().getProjection();
                Iterator<String> it = list.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    ze a2 = this.e.a(it.next());
                    if (a2 != null) {
                        if (a2 instanceof bf) {
                            arrayList2.add(((bf) a2).getScreenBound(projection));
                        } else if ((a2 instanceof df) && (N = ((df) a2).N()) != null) {
                            arrayList2.add(N.b(projection));
                        }
                    }
                }
            } else {
                return null;
            }
        }
        return arrayList;
    }

    public void a(float f2, float f3) {
        this.e.getMap().h(f2, f3);
    }

    public void a(float f2, float f3, float f4) {
        this.e.setMapCenterAndScale(f2, f3, f4);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(float f2, float f3, boolean z) {
        if (this.e == null) {
            return;
        }
        this.e.getMap().a(f2, f3, 0, z);
    }

    @Override // com.tencent.mapsdk.internal.i5
    public void a(int i, int i2) {
        if (i == 0 || i2 == 0) {
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.e.getMap().a(i, i2, i3, i4);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(Handler handler, Bitmap.Config config, int i) {
        this.e.a(handler, config, i);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(d5 d5Var) {
        VectorMap map;
        if (this.e == null || (map = this.e.getMap()) == null) {
            return;
        }
        map.a(d5Var);
    }

    public void a(l1.d dVar) {
        this.h.a(dVar);
    }

    public void a(qh.j jVar, TencentMapOptions tencentMapOptions) {
        this.h.a(jVar, tencentMapOptions);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        if (this.e == null) {
            return;
        }
        this.e.b(onCameraChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(TencentMap.OnDismissCallback onDismissCallback) {
        this.e.a(onDismissCallback);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.e.a(onIndoorStateChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        this.e.a(onMapPoiClickListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(Language language) {
        VectorMap map;
        if (this.e == null || (map = this.e.getMap()) == null) {
            return;
        }
        map.a(language);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(LatLng latLng, float f2, float f3, boolean z) {
        animateToNaviPosition(latLng, f2, f3, 0.0f, z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(LatLng latLng, LatLng latLng2, float f2) {
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(LatLngBounds latLngBounds, int i) {
        if (this.e == null || this.e.getMap() == null) {
            return;
        }
        this.e.A().a(latLngBounds, i);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(List<MapRouteSection> list, List<LatLng> list2) {
        VectorMap map;
        if (this.e == null || (map = this.e.getMap()) == null) {
            return;
        }
        map.a(list, GeoPoint.from(list2));
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void a(boolean z) {
        if (this.e == null) {
            return;
        }
        this.e.a(z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions) {
        tf tfVar = this.l;
        if (tfVar == null || this.j == null) {
            return null;
        }
        return tfVar.a(customLayerOptions);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.e.n.add(onMapLoadedCallback);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        if (this.e == null) {
            return;
        }
        this.e.b(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        pg pgVar = this.j;
        if (pgVar == null) {
            return null;
        }
        return pgVar.a(tileOverlayOptions);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int animateCamera(CameraUpdate cameraUpdate, long j, TencentMap.CancelableCallback cancelableCallback) {
        CamerParameter params;
        if (cameraUpdate == null || (params = cameraUpdate.getParams()) == null) {
            return -1;
        }
        if (j < 0) {
            j = 0;
        }
        switch (params.iCamerType) {
            case 0:
                a(true, j, cancelableCallback);
                return 0;
            case 1:
                b(true, j, cancelableCallback);
                return 0;
            case 2:
                b(params.scrollBy_xPixel, params.scrollBy_yPixel, true, j, cancelableCallback);
                return 0;
            case 3:
                b(params.zoomTo_zoom, true, j, cancelableCallback);
                return 0;
            case 4:
                a(params.zoomBy_amount, true, j, cancelableCallback);
                return 0;
            case 5:
                float f2 = params.zoomBy_Point_amount;
                Point point = params.zoomBy_Point_focus;
                a(f2, point.x, point.y, true, j, cancelableCallback);
                return 0;
            case 6:
                a(params.newCameraPosition_cameraPosition, true, j, cancelableCallback);
                return 0;
            case 7:
                LatLng latLng = params.newLatLng_latLng;
                a(latLng.latitude, latLng.longitude, true, j, cancelableCallback);
                return 0;
            case 8:
                LatLng latLng2 = params.newLatLngZoom_latLng;
                a(latLng2.latitude, latLng2.longitude, params.newLatLngZoom_zoom, true, j, cancelableCallback);
                return 0;
            case 9:
                return a(params.newLatLngBounds_bounds, params.newLatLngBounds_padding, true, j, cancelableCallback);
            case 10:
                LatLngBounds latLngBounds = params.newLatLngBounds_dimension_bounds;
                int i = params.newLatLngBounds_dimension_padding;
                return a(latLngBounds, i, i, i, i, true, j, cancelableCallback);
            case 11:
                return a(params.newLatLngBounds_dimension_bounds, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, true, j, cancelableCallback);
            case 12:
                a(params.rotateto_rotate, params.rotateto_skew, true, j, cancelableCallback);
                return 0;
            case 13:
                return a(b(params.elements), params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, true, j, cancelableCallback);
            default:
                return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void animateToNaviPosition(LatLng latLng, float f2, float f3, float f4, boolean z) {
        oi oiVar = new oi(10000);
        oiVar.a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        oiVar.f(f4);
        oiVar.c(f2);
        oiVar.d(f3);
        oiVar.a(this.B);
        oiVar.a(true);
        oiVar.a(1000L);
        if (z) {
            oiVar.b(this.e.H(), this.e.q());
        } else {
            oiVar.b(this.e.C(), this.e.n());
        }
        this.e.getMap().o();
        this.e.getMap().a(oiVar);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void animateToNaviPosition2(LatLng latLng, float f2, float f3, float f4, boolean z) {
        oi oiVar = new oi(10000);
        oiVar.a((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        oiVar.f(f4);
        oiVar.c(f2);
        oiVar.d(f3);
        oiVar.a(this.B);
        oiVar.a(true);
        oiVar.a(1000L);
        this.e.getMap().o();
        this.e.getMap().a(oiVar);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void b(d5 d5Var) {
        VectorMap map;
        if (this.e == null || (map = this.e.getMap()) == null) {
            return;
        }
        map.b(d5Var);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void b(boolean z) {
        if (this.e == null || this.e.i() == null) {
            return;
        }
        this.e.i().a(z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public boolean b() {
        if (this.e == null) {
            return false;
        }
        return this.e.b();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public IndoorBuilding c() {
        if (this.e == null || this.e.i() == null) {
            return null;
        }
        return this.e.i().f();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void c(boolean z) {
        if (this.e == null) {
            return;
        }
        this.e.i(z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float calNaviLevel(LatLngBounds latLngBounds, float f2, int i, boolean z) {
        if (latLngBounds == null) {
            return 0.0f;
        }
        int q = z ? this.e.q() : this.e.n();
        if (!z) {
            f2 = 0.0f;
        }
        int i2 = q;
        if (q < 0) {
            i2 = this.e.Z0 / 2;
        }
        return a(f2, 0, 0, i, this.e.a1 - i2, latLngBounds.southwest, latLngBounds.northeast);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float calNaviLevel2(LatLng latLng, LatLng latLng2, float f2, float f3, int i, boolean z) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        if (!z) {
            f2 = 0.0f;
        }
        return a(f2, 0, 0, i, 0, builder.build().southwest, builder.build().northeast);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float calNaviLevel3(LatLng latLng, LatLng latLng2, float f2, int i, int i2, int i3, int i4, boolean z) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        if (!z) {
            f2 = 0.0f;
        }
        return a(f2, i, i2, i3, i4, builder.build().southwest, builder.build().northeast);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public CameraPosition calculateZoomToSpanLevel(List<u4> list, List<LatLng> list2, int i, int i2, int i3, int i4) {
        if (this.e.Z0 == 0 || this.e.a1 == 0) {
            int j = g7.j(this.f);
            int i5 = g7.i(this.f);
            if (i + i2 > j || i3 + i4 > i5) {
                return null;
            }
        } else if (i + i2 > this.e.Z0 || i3 + i4 > this.e.a1) {
            return null;
        }
        t4 projection = this.e.getMap().getProjection();
        if (projection == null) {
            return null;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (u4 u4Var : list) {
                if (u4Var != null && u4Var.getGroupBounds() != null) {
                    arrayList.addAll(u4Var.getGroupBounds());
                }
            }
            Rect rect = new Rect(i, i3, i2, i4);
            this.s = null;
            projection.a(arrayList, GeoPoint.from(list2), rect, new d());
            synchronized (this.t) {
                try {
                    this.t.wait(1000L);
                } catch (InterruptedException e2) {
                    na.b(Log.getStackTraceString(e2));
                    Thread.currentThread().interrupt();
                }
            }
            return this.s;
        } else if (list2 == null || list2.isEmpty()) {
            return null;
        } else {
            if (list2.size() == 1) {
                return new CameraPosition(list2.get(0), this.e.getMap().M().x(), this.e.getMap().Z(), this.e.getMap().T());
            }
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            double d5 = 0.0d;
            for (LatLng latLng : list2) {
                if (latLng != null) {
                    double d6 = d2;
                    if (d2 == 0.0d) {
                        d6 = latLng.latitude;
                    }
                    double d7 = d3;
                    if (d3 == 0.0d) {
                        d7 = latLng.longitude;
                    }
                    double d8 = d4;
                    double d9 = d8;
                    if (d8 == 0.0d) {
                        d9 = latLng.latitude;
                    }
                    double d10 = d5;
                    double d11 = d10;
                    if (d10 == 0.0d) {
                        d11 = latLng.longitude;
                    }
                    double d12 = d11;
                    double d13 = latLng.latitude;
                    if (d13 < d6) {
                        d6 = d13;
                    }
                    double d14 = d9;
                    if (d13 > d9) {
                        d14 = d13;
                    }
                    double d15 = latLng.longitude;
                    double d16 = d7;
                    if (d15 < d7) {
                        d16 = d15;
                    }
                    double d17 = d12;
                    if (d15 > d12) {
                        d17 = d15;
                    }
                    d2 = d6;
                    d3 = d16;
                    d4 = d14;
                    d5 = d17;
                }
            }
            LatLng latLng2 = new LatLng(d2, d3);
            LatLng latLng3 = new LatLng(d4, d5);
            LatLng latLng4 = new LatLng(0.0d, 0.0d);
            float a2 = a(i, i2, i3, i4, latLng2, latLng3, latLng4);
            if (a2 < 0.0f) {
                return null;
            }
            return new CameraPosition(latLng4, a2, this.e.getMap().Z(), this.e.getMap().T());
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public CameraPosition calculateZoomToSpanLevelAsync(List<u4> list, List<LatLng> list2, int i, int i2, int i3, int i4, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback) {
        if (this.e.Z0 == 0 || this.e.a1 == 0) {
            g7.j(this.f);
            g7.i(this.f);
        } else if (i + i2 > this.e.Z0 || i3 + i4 > this.e.a1) {
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(null);
                return null;
            }
            return null;
        }
        t4 projection = this.e.getMap().getProjection();
        if (projection == null) {
            return null;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (u4 u4Var : list) {
                if (u4Var != null && u4Var.getGroupBounds() != null) {
                    arrayList.addAll(u4Var.getGroupBounds());
                }
            }
            Rect rect = new Rect(i, i3, i2, i4);
            this.s = null;
            projection.a(arrayList, GeoPoint.from(list2), rect, new e(asyncOperateCallback));
            return null;
        } else if (list2 == null || list2.isEmpty()) {
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(null);
                return null;
            }
            return null;
        } else if (list2.size() == 1) {
            CameraPosition cameraPosition = new CameraPosition(list2.get(0), this.e.getMap().U(), this.e.getMap().Z(), this.e.getMap().T());
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(cameraPosition);
            }
            return cameraPosition;
        } else {
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            double d5 = 0.0d;
            for (LatLng latLng : list2) {
                if (latLng != null) {
                    double d6 = d2;
                    if (d2 == 0.0d) {
                        d6 = latLng.latitude;
                    }
                    double d7 = d3;
                    if (d3 == 0.0d) {
                        d7 = latLng.longitude;
                    }
                    double d8 = d4;
                    double d9 = d8;
                    if (d8 == 0.0d) {
                        d9 = latLng.latitude;
                    }
                    double d10 = d5;
                    double d11 = d10;
                    if (d10 == 0.0d) {
                        d11 = latLng.longitude;
                    }
                    double d12 = d11;
                    double d13 = latLng.latitude;
                    if (d13 < d6) {
                        d6 = d13;
                    }
                    double d14 = d9;
                    if (d13 > d9) {
                        d14 = d13;
                    }
                    double d15 = latLng.longitude;
                    double d16 = d7;
                    if (d15 < d7) {
                        d16 = d15;
                    }
                    double d17 = d12;
                    if (d15 > d12) {
                        d17 = d15;
                    }
                    d2 = d6;
                    d3 = d16;
                    d4 = d14;
                    d5 = d17;
                }
            }
            LatLng latLng2 = new LatLng(d2, d3);
            LatLng latLng3 = new LatLng(d4, d5);
            LatLng latLng4 = new LatLng(0.0d, 0.0d);
            float a2 = a(i, i2, i3, i4, latLng2, latLng3, latLng4);
            if (a2 < 0.0f) {
                if (asyncOperateCallback != null) {
                    asyncOperateCallback.onOperateFinished(null);
                    return null;
                }
                return null;
            }
            CameraPosition cameraPosition2 = new CameraPosition(latLng4, a2, this.e.getMap().Z(), this.e.getMap().T());
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(cameraPosition2);
            }
            return cameraPosition2;
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void clearRouteNameSegments() {
        VectorMap map;
        if (this.e == null || (map = this.e.getMap()) == null) {
            return;
        }
        map.clearRouteNameSegments();
    }

    public void d(boolean z) {
        this.d.setZOrderMediaOverlay(z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public String e() {
        if (this.e == null || this.e.i() == null) {
            return null;
        }
        return this.e.i().g();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void enableMultipleInfowindow(boolean z) {
        if (this.e != null) {
            this.e.d1 = z;
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public String f() {
        if (this.e == null || this.e.i() == null) {
            return null;
        }
        return this.e.i().e();
    }

    @Override // com.tencent.mapsdk.internal.k0
    public LatLng fromScreenLocation(Point point) {
        yi yiVar;
        if (point == null || (yiVar = this.e) == null || yiVar.getMap() == null || yiVar.getMap().getProjection() == null) {
            return null;
        }
        return fa.d(yiVar.getMap().getProjection().a(new p5(point.x, point.y)));
    }

    @Override // com.tencent.mapsdk.internal.j0
    public ArrayList<MapPoi> g() {
        if (this.e == null) {
            return null;
        }
        return this.e.A().Y();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public CameraPosition getCameraPosition() {
        LatLng d2 = fa.d(this.e.getMap().s());
        float T = this.e.getMap().T();
        float f2 = T;
        if (T < 0.0f) {
            f2 = (T % 360.0f) + 360.0f;
        }
        return CameraPosition.builder().zoom(o()).target(d2).bearing(f2).tilt(this.e.getMap().Z()).build();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public String getCityName(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return this.e.getMap().a(GeoPoint.from(latLng));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [com.tencent.mapsdk.internal.ic] */
    @Override // com.tencent.mapsdk.internal.j0
    public String getDebugError() {
        if (this.f == null || this.e == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cfgVer", (!f7.b(this.g) ? kc.a(this.f, this.g) : lc.a(this.f)).a());
            int j = g7.j(this.f);
            int i = g7.i(this.f);
            jSONObject.put("resolution", "{" + j + "," + i + com.alipay.sdk.util.i.d);
            jSONObject.put("density", (double) this.w);
            jSONObject.put("renderStatus", this.e.getMap().I());
            jSONObject.put("renderError", this.e.getMap().H());
            jSONObject.put("sdkver", "4.5.9.6");
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int getIndoorFloorId() {
        if (this.e == null || this.e.i() == null) {
            return -1;
        }
        return this.e.i().h();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public Language getLanguage() {
        VectorMap map;
        if (this.e != null && (map = this.e.getMap()) != null) {
            return map.K();
        }
        return Language.zh;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int getMapStyle() {
        int m = this.e.getMapContext().h().m();
        yg ygVar = this.k;
        if (ygVar != null) {
            return ygVar.b(m);
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int getMapType() {
        return this.v;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float getMaxZoomLevel() {
        return this.e.getMap().P();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float getMinZoomLevel() {
        return this.e.getMap().R();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public String getVersion() {
        return c7.F();
    }

    @Override // com.tencent.mapsdk.internal.m0
    public x1 getView() {
        return this.d;
    }

    @Override // com.tencent.mapsdk.internal.k0
    public VisibleRegion getVisibleRegion() {
        Point point = new Point(0, this.e.a1);
        Point point2 = new Point(this.e.Z0, this.e.a1);
        Point point3 = new Point(0, 0);
        Point point4 = new Point(this.e.Z0, 0);
        LatLng fromScreenLocation = fromScreenLocation(point);
        LatLng fromScreenLocation2 = fromScreenLocation(point2);
        LatLng fromScreenLocation3 = fromScreenLocation(point3);
        LatLng fromScreenLocation4 = fromScreenLocation(point4);
        return new VisibleRegion(fromScreenLocation, fromScreenLocation2, fromScreenLocation3, fromScreenLocation4, LatLngBounds.builder().include(fromScreenLocation).include(fromScreenLocation2).include(fromScreenLocation3).include(fromScreenLocation4).build());
    }

    @Override // com.tencent.mapsdk.internal.j0
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return a(0, 0, 0, 0, latLng, latLng2, (LatLng) null);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public String[] h() {
        if (this.e == null || this.e.i() == null) {
            return null;
        }
        return this.e.i().i();
    }

    public void i() {
        if (this.e != null) {
            this.e.getMap().b(this.C);
            this.e.e();
            this.e = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        b7.a aVar = b7.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public boolean isHandDrawMapEnable() {
        if (this.e == null) {
            return false;
        }
        return this.e.isHandDrawMapEnable();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public boolean isTrafficEnabled() {
        return this.e.getMap().j0();
    }

    public Context j() {
        return this.f;
    }

    public tf k() {
        return this.l;
    }

    public yi l() {
        return this.e;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void loadKMLFile(String str) {
        rc A;
        if (this.e == null || (A = this.e.A()) == null) {
            return;
        }
        A.c(str);
        A.w0();
    }

    public yg m() {
        return this.k;
    }

    @Override // com.tencent.mapsdk.internal.k0
    public double metersPerPixel(double d2) {
        return this.e.getMap().getProjection().metersPerPixel(d2);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public int moveCamera(CameraUpdate cameraUpdate) {
        CamerParameter params;
        if (cameraUpdate == null || (params = cameraUpdate.getParams()) == null) {
            return -1;
        }
        switch (params.iCamerType) {
            case 0:
                a(false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 1:
                b(false, 0L, null);
                return 0;
            case 2:
                b(params.scrollBy_xPixel, params.scrollBy_yPixel, false, 0L, null);
                return 0;
            case 3:
                b(params.zoomTo_zoom, false, 0L, null);
                return 0;
            case 4:
                a(params.zoomBy_amount, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 5:
                float f2 = params.zoomBy_Point_amount;
                Point point = params.zoomBy_Point_focus;
                a(f2, point.x, point.y, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 6:
                a(params.newCameraPosition_cameraPosition, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 7:
                LatLng latLng = params.newLatLng_latLng;
                if (latLng != null) {
                    a(latLng.latitude, latLng.longitude, false, 0L, (TencentMap.CancelableCallback) null);
                    return 0;
                }
                return 0;
            case 8:
                LatLng latLng2 = params.newLatLngZoom_latLng;
                if (latLng2 != null) {
                    a(latLng2.latitude, latLng2.longitude, params.newLatLngZoom_zoom, false, 0L, (TencentMap.CancelableCallback) null);
                    return 0;
                }
                return 0;
            case 9:
                return a(params.newLatLngBounds_bounds, params.newLatLngBounds_padding, false, 0L, (TencentMap.CancelableCallback) null);
            case 10:
                LatLngBounds latLngBounds = params.newLatLngBounds_dimension_bounds;
                int i = params.newLatLngBounds_dimension_padding;
                return a(latLngBounds, i, i, i, i, false, 0L, (TencentMap.CancelableCallback) null);
            case 11:
                return a(params.newLatLngBounds_dimension_bounds, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, false, 0L, (TencentMap.CancelableCallback) null);
            case 12:
                a(params.rotateto_rotate, params.rotateto_skew, false, 0L, (TencentMap.CancelableCallback) null);
                return 0;
            case 13:
                return a(b(params.elements), params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom, false, 0L, (TencentMap.CancelableCallback) null);
            default:
                return 0;
        }
    }

    public l1 n() {
        return this.h;
    }

    public float o() {
        return this.e.getMap().M().x();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void onDestroy() {
        this.d.onDestroy();
        mf mfVar = this.i;
        if (mfVar != null) {
            mfVar.a();
            this.i = null;
        }
        l1 l1Var = this.h;
        if (l1Var != null) {
            l1Var.c();
            this.h = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void onPause() {
        this.d.onPause();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void onRestart() {
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void onResume() {
        this.d.onResume();
        l1 l1Var = this.h;
        if (l1Var != null) {
            l1Var.e();
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void onStart() {
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void onStop() {
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.e.n.remove(onMapLoadedCallback);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        if (this.e == null) {
            return;
        }
        this.e.a(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setCompassExtraPadding(int i) {
        if (this.e == null) {
            return;
        }
        this.e.setCompassExtraPadding(i);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setCompassExtraPadding(int i, int i2) {
        if (this.e == null) {
            return;
        }
        this.e.setCompassExtraPadding(i, i2);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setForeignLanguage(Language language) {
        if (this.e == null || this.e.n0() == null) {
            return;
        }
        this.e.n0().a(language);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setHandDrawMapEnable(boolean z) {
        if (this.e == null) {
            return;
        }
        if (z) {
            this.e.t();
        } else {
            this.e.y();
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setIndoorEnabled(boolean z) {
        if (this.e == null || this.e.i() == null) {
            return;
        }
        this.e.i().b(z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setIndoorFloor(int i) {
        if (this.e == null || this.e.i() == null) {
            return;
        }
        this.e.i().a(i);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setIndoorFloor(String str, String str2) {
        rc A;
        if (this.e == null || this.e.getMap() == null || (A = this.e.A()) == null) {
            return;
        }
        A.a(str, str2);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setMapStyle(int i) {
        int mapStyle = getMapStyle();
        this.u = i;
        if (i == mapStyle || mapStyle == 1011 || mapStyle == 1008) {
            return;
        }
        yg ygVar = this.k;
        int i2 = i;
        if (ygVar != null) {
            xg a2 = ygVar.a(i);
            if (a2 != null) {
                int i3 = a2.b;
                w6 w = this.e.A().w();
                i2 = i3;
                if (w != null) {
                    w.e().a(a2.f38114c);
                    i2 = i3;
                }
            } else if (i >= 1000) {
                i2 = i - 1000;
            } else {
                i2 = i;
                if (i > 8) {
                    i2 = i;
                    if (i < 989) {
                        i2 = i + 11;
                    }
                }
            }
        }
        this.e.A().m(i2);
        c7.b(true);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setMapType(int i) {
        if (i == 1000 || i == 1011 || i == 1008) {
            if (i == 1008) {
                this.e.A().w().f().b();
            }
            this.v = i;
            int i2 = i;
            if (i == 1000) {
                i2 = this.u;
            }
            yg ygVar = this.k;
            int i3 = i2;
            if (ygVar != null) {
                xg a2 = ygVar.a(i2);
                i3 = i2;
                if (a2 != null) {
                    i3 = a2.b;
                }
            }
            this.e.A().m(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setMaxZoomLevel(int i) {
        if (this.e == null) {
            return;
        }
        this.e.L = i;
        VectorMap map = this.e.getMap();
        if (map == null) {
            return;
        }
        map.k(i);
        map.v0();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setMinZoomLevel(int i) {
        VectorMap map;
        if (this.e == null || (map = this.e.getMap()) == null) {
            return;
        }
        map.l(i);
        map.v0();
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setNaviFixingProportion(float f2, float f3) {
        float f4;
        float f5;
        if (this.e == null) {
            return;
        }
        if (f2 < 0.0f) {
            f4 = 0.0f;
        } else {
            f4 = f2;
            if (f2 > 1.0f) {
                f4 = 1.0f;
            }
        }
        if (f3 < 0.0f) {
            f5 = 0.0f;
        } else {
            f5 = f3;
            if (f3 > 1.0f) {
                f5 = 1.0f;
            }
        }
        this.e.a((int) (this.e.Z0 * f4), (int) (this.e.a1 * f5));
        this.e.w0 = f4;
        this.e.x0 = f5;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setNaviFixingProportion2D(float f2, float f3) {
        float f4;
        float f5;
        if (this.e == null) {
            return;
        }
        if (f2 < 0.0f) {
            f4 = 0.0f;
        } else {
            f4 = f2;
            if (f2 > 1.0f) {
                f4 = 1.0f;
            }
        }
        if (f3 < 0.0f) {
            f5 = 0.0f;
        } else {
            f5 = f3;
            if (f3 > 1.0f) {
                f5 = 1.0f;
            }
        }
        this.e.b((int) (this.e.Z0 * f4), (int) (this.e.a1 * f5));
        this.e.y0 = f4;
        this.e.z0 = f5;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        if (this.e == null) {
            return;
        }
        this.e.c(onCameraChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        if (this.e != null) {
            this.e.i0 = onCompassClickedListener;
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.e.b0 = onInfoWindowClickListener;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        this.e.U = onMapClickListener;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        this.e.X = onMapLongClickListener;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        this.e.a0 = onMarkerClickListener;
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnScaleViewChangedListener(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        if (this.e == null) {
            return;
        }
        this.e.a(onScaleViewChangedListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnTapMapViewInfoWindowHidden(boolean z) {
        if (this.e != null) {
            this.e.setOnTapMapViewInfoWindowHidden(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        if (this.e == null || this.e.getMap() == null) {
            return;
        }
        this.e.a(onTrafficEventClickListener);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setPoisEnabled(boolean z) {
        if (this.e == null || this.e.getMap() == null) {
            return;
        }
        this.e.getMap().b(z);
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void setTrafficEnabled(boolean z) {
        VectorMap map = this.e.getMap();
        if (z) {
            map.m(true);
        } else {
            map.m(false);
        }
    }

    @Override // com.tencent.mapsdk.internal.j0
    public void stopAnimation() {
        this.e.getMap().o();
    }

    @Override // com.tencent.mapsdk.internal.k0
    public Point toScreenLocation(LatLng latLng) {
        p5 a2;
        if (latLng == null) {
            return null;
        }
        yi yiVar = this.e;
        Point point = null;
        if (yiVar != null) {
            point = null;
            if (yiVar.getMap() != null) {
                if (yiVar.getMap().getProjection() == null || (a2 = yiVar.getMap().getProjection().a(GeoPoint.from(latLng))) == null) {
                    return null;
                }
                point = new Point();
                point.x = (int) Math.round(a2.b);
                point.y = (int) Math.round(a2.f37683c);
            }
        }
        return point;
    }
}
