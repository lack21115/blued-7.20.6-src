package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.jf;
import com.tencent.mapsdk.internal.n5;
import com.tencent.mapsdk.internal.x3;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mapsdk.internal.if  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/if.class */
public class Cif implements AoiLayer {
    private static final String q = AoiLayer.class.getSimpleName();
    private kf g;
    private String h;
    private int i = 20;
    private int j = -1;
    private boolean k;
    private boolean l;
    private int[] m;
    private int[] n;
    private jf o;
    private AoiLayer.OnAoiLayerLoadListener p;

    /* renamed from: com.tencent.mapsdk.internal.if$a */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/if$a.class */
    public class a extends ca.c<jf> {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(jf jfVar) {
            String str = Cif.q;
            na.c(str, "POI[" + Cif.this.h + "]的详情数据：" + jfVar);
            if (jfVar != null && !Cif.this.l) {
                if (Cif.this.j < 0) {
                    Cif cif = Cif.this;
                    cif.j = cif.a(jfVar);
                }
                Cif.this.b(jfVar);
            } else if (Cif.this.p != null) {
                Cif.this.p.onAoiLayerLoaded(false, Cif.this);
            }
            Cif.this.k = false;
            String str2 = Cif.q;
            na.c(str2, "结束POI[" + Cif.this.h + "]详情数据的更新");
        }
    }

    /* renamed from: com.tencent.mapsdk.internal.if$b */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/if$b.class */
    public class b extends ca.i<jf> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public jf call() throws Exception {
            if (Cif.this.l) {
                return null;
            }
            return Cif.this.l();
        }
    }

    /* renamed from: com.tencent.mapsdk.internal.if$c */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/if$c.class */
    public class c extends ca.c<Object> {
        public final /* synthetic */ List b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f37556c;

        public c(List list, List list2) {
            this.b = list;
            this.f37556c = list2;
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        public void callback(Object obj) {
            if (Cif.this.l) {
                return;
            }
            int size = this.b.size();
            int size2 = this.f37556c.size();
            if (size != size2) {
                String str = Cif.q;
                na.g(str, "PoiLayer的子点渲染缺失！！count:" + size2 + BridgeUtil.SPLIT_MARK + size);
            }
            Cif.this.d(this.f37556c);
        }
    }

    /* renamed from: com.tencent.mapsdk.internal.if$d */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/if$d.class */
    public class d extends ca.i<Object> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f37557c;
        public final /* synthetic */ List d;

        /* renamed from: com.tencent.mapsdk.internal.if$d$a */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/if$d$a.class */
        public class a implements Callback<jf.d> {
            public a() {
            }

            @Override // com.tencent.map.tools.Callback
            /* renamed from: a */
            public void callback(jf.d dVar) {
                if (dVar != null) {
                    d.this.d.add(dVar);
                }
            }
        }

        public d(List list, List list2) {
            this.f37557c = list;
            this.d = list2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            if (Cif.this.l) {
                return null;
            }
            Cif.this.a(this.f37557c, new a());
            return null;
        }
    }

    public Cif(kf kfVar, String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        this.g = kfVar;
        this.h = str;
        this.p = onAoiLayerLoadListener;
        a(aoiLayerOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(jf jfVar) {
        rc b2;
        kf kfVar = this.g;
        if (kfVar == null || (b2 = kfVar.b()) == null) {
            return 0;
        }
        int i = 0;
        if (jfVar != null) {
            LatLngBounds a2 = a(jfVar.f37568a);
            i = 0;
            if (a2 != null) {
                i = ((int) b2.getProjection().a(a2.getSouthWest(), a2.getNorthEast(), 0, 0, 0, 0, null)) - 2;
            }
        }
        return i;
    }

    private PolygonInfo a(jf.c cVar, List<LatLng> list) {
        q1 a2;
        Context context;
        PolygonInfo polygonInfo = new PolygonInfo();
        kf kfVar = this.g;
        if (kfVar != null && (a2 = kfVar.a()) != null && (context = a2.getContext()) != null) {
            g7.d(context);
            polygonInfo.points = (LatLng[]) list.toArray(new LatLng[0]);
            if (cVar != null) {
                polygonInfo.borderWidth = cVar.f37573c;
                polygonInfo.borderColor = Color.parseColor(cVar.b);
                polygonInfo.color = Color.parseColor(cVar.f37572a);
                polygonInfo.level = 1;
                polygonInfo.minScaleLevel = this.j;
                polygonInfo.maxScaleLevel = this.i;
            }
            return polygonInfo;
        }
        return polygonInfo;
    }

    private r5 a(jf.e eVar, jf.d dVar) {
        q1 a2;
        Context context;
        r5 r5Var = new r5();
        kf kfVar = this.g;
        if (kfVar != null && (a2 = kfVar.a()) != null && (context = a2.getContext()) != null && eVar != null) {
            int i = eVar.e;
            if (i == 0) {
                r5Var.l = "";
            } else if (i == 1) {
                r5Var.l = dVar.a();
                BitmapDescriptor bitmapDescriptor = eVar.b;
                if (bitmapDescriptor != null) {
                    r5Var.i = bitmapDescriptor.getFormater().getBitmapId();
                    Bitmap bitmap = bitmapDescriptor.getBitmap(context);
                    if (bitmap != null) {
                        r5Var.j = bitmap.getWidth();
                        r5Var.k = bitmap.getHeight();
                    }
                }
            }
            BitmapDescriptor bitmapDescriptor2 = eVar.f37576a;
            if (bitmapDescriptor2 == null) {
                return r5Var;
            }
            r5Var.f37734c = bitmapDescriptor2.getFormater().getBitmapId();
            Bitmap bitmap2 = bitmapDescriptor2.getBitmap(context);
            if (bitmap2 != null) {
                r5Var.d = bitmap2.getWidth();
                r5Var.e = bitmap2.getHeight();
            }
            r5Var.q = 2;
            int i2 = eVar.k;
            r5Var.r = i2;
            r5Var.s = ((eVar.j + 1) * 10000) + i2;
            r5Var.v = dVar.h;
            r5Var.t = this.j;
            r5Var.u = this.i;
            r5Var.h = 1.0f;
            return r5Var;
        }
        return r5Var;
    }

    private LatLngBounds a(jf.d dVar) {
        jf.a aVar;
        jf.b bVar;
        List<List<LatLng>> list;
        if (dVar == null || (aVar = dVar.i) == null || (bVar = aVar.f37570c) == null || (list = bVar.b) == null) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (List<LatLng> list2 : list) {
            builder.include(list2);
        }
        try {
            return builder.build();
        } catch (Exception e) {
            na.c(Log.getStackTraceString(e));
            return null;
        }
    }

    private String a(String str) {
        q1 a2;
        Context context;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        new r5();
        kf kfVar = this.g;
        if (kfVar != null && (a2 = kfVar.a()) != null && (context = a2.getContext()) != null) {
            int d2 = (int) g7.d(context);
            return d2 <= 1 ? str.replace("{density}", "") : d2 <= 2 ? str.replace("{density}", "@2x") : str.replace("{density}", "@3x");
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<jf.d> list, Callback<jf.d> callback) {
        q1 a2;
        Context context;
        kf kfVar = this.g;
        if (kfVar == null || (a2 = kfVar.a()) == null || (context = a2.getContext()) == null || list == null || list.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || this.l) {
                return;
            }
            jf.d dVar = list.get(i2);
            jf.e c2 = c(dVar.f);
            String a3 = a(c2.d);
            String str = q;
            na.c(str, "请求子点[" + dVar.a() + "]icon url:" + a3);
            if (!TextUtils.isEmpty(a3)) {
                BitmapDescriptor createBitmapDescriptor = a2.createBitmapDescriptor(a3, 8);
                c2.f37576a = createBitmapDescriptor;
                createBitmapDescriptor.getFormater().setScale(2);
                if (c2.f37576a.getBitmap(context) != null) {
                    na.c(str, "子点[" + dVar.a() + "]icon下载成功");
                    if (c2.e == 1) {
                        n5.a aVar = new n5.a(dVar.a(), c2.g, Color.parseColor(c2.f));
                        aVar.a(a2.getTypeface());
                        aVar.a(Color.parseColor(c2.h));
                        aVar.b(c2.i);
                        aVar.a(g7.d(context) / 2.0f);
                        BitmapDescriptor createBitmapDescriptor2 = a2.createBitmapDescriptor(aVar, 9);
                        c2.b = createBitmapDescriptor2;
                        if (createBitmapDescriptor2.getBitmap(context) != null) {
                            na.c(str, "子点[" + dVar.a() + "]文本图片创建成功");
                        } else {
                            na.g(str, "子点[" + dVar.a() + "]文本图片创建失败！");
                        }
                    }
                    if (callback != null) {
                        callback.callback(dVar);
                    }
                } else {
                    na.g(str, "子点[" + dVar.a() + "]icon下载失败！");
                }
            }
            i = i2 + 1;
        }
    }

    private Point[] a(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return new Point[0];
        }
        int size = list.size();
        Point[] pointArr = new Point[size];
        for (int i = 0; i < size; i++) {
            pointArr[i] = GeoPoint.from(list.get(i)).toPoint();
        }
        return pointArr;
    }

    private jf.c b(List<jf.e> list) {
        return c(list).l;
    }

    private void b(jf.c cVar, List<List<LatLng>> list) {
        rc b2;
        int i;
        kf kfVar = this.g;
        if (kfVar == null || (b2 = kfVar.b()) == null) {
            return;
        }
        int i2 = 0;
        if (this.m == null) {
            this.m = new int[list.size()];
            for (List<LatLng> list2 : list) {
                PolygonInfo a2 = a(cVar, list2);
                if (!this.l) {
                    this.m[i2] = b2.a(a2);
                    na.c(q, "添加PoiLayer成功,ID=" + this.m[i - 1] + "|model:" + a2);
                    i2++;
                }
            }
            return;
        }
        Iterator<List<LatLng>> it = list.iterator();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return;
            }
            PolygonInfo a3 = a(cVar, it.next());
            a3.polygonId = this.m[i4];
            if (!this.l) {
                b2.b(a3);
                na.c(q, "更新PoiLayer成功");
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(jf jfVar) {
        jf.d dVar;
        jf.b bVar;
        List<List<LatLng>> list;
        if (jfVar == null || (dVar = jfVar.f37568a) == null) {
            return;
        }
        boolean z = false;
        jf.c b2 = b(dVar.f);
        jf.a aVar = jfVar.f37568a.i;
        String str = q;
        na.c(str, "绘制PoiLayer的面，aoiStyle:" + b2 + "|poiArea:" + aVar);
        if (aVar == null || (bVar = aVar.f37570c) == null || !"Polygon".equalsIgnoreCase(bVar.f37571a) || (list = aVar.f37570c.b) == null) {
            na.g(str, "PoiLayer的面渲染失败！");
        } else {
            b(b2, list);
            z = true;
        }
        this.o = jfVar;
        AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener = this.p;
        if (onAoiLayerLoadListener != null) {
            onAoiLayerLoadListener.onAoiLayerLoaded(z, this);
        }
        if (z) {
            List<jf.d> list2 = jfVar.f37568a.j;
            ArrayList arrayList = new ArrayList();
            na.c(str, "绘制PoiLayer的子点，remotePois:" + list2);
            ca.a((ca.i) new d(list2, arrayList)).a((ca.d.b) null, (ca.c<ca.d.b>) new c(list2, arrayList));
        }
    }

    private jf.e c(List<jf.e> list) {
        jf.e eVar = new jf.e();
        jf.e eVar2 = eVar;
        if (list != null) {
            kf kfVar = this.g;
            eVar2 = eVar;
            if (kfVar != null) {
                if (kfVar.a() != null) {
                    boolean a2 = this.g.a().a();
                    Iterator<jf.e> it = list.iterator();
                    while (true) {
                        eVar2 = eVar;
                        if (!it.hasNext()) {
                            break;
                        }
                        eVar2 = it.next();
                        if ((a2 && eVar2.f37577c == 1) || (!a2 && eVar2.f37577c == 0)) {
                            break;
                        }
                    }
                } else {
                    return eVar;
                }
            }
        }
        return eVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<jf.d> list) {
        rc b2;
        kf kfVar = this.g;
        if (kfVar == null || (b2 = kfVar.b()) == null) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        int i = 0;
        for (jf.d dVar : list) {
            r5 a2 = a(c(dVar.f), dVar);
            int i2 = dVar.f37574a;
            if (i2 < 0) {
                int a3 = b2.a(a2);
                dVar.f37574a = a3;
                iArr[i] = a3;
                na.c(q, "添加子点成功！" + dVar.a() + "|id:" + a2.i);
                i++;
            } else {
                a2.b = i2;
                b2.c(a2);
                na.c(q, "更新子点成功！" + dVar.a());
            }
        }
        int[] iArr2 = new int[size];
        this.n = iArr2;
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public jf l() {
        q1 a2;
        String str = q;
        na.c(str, "请求poiDetail[" + this.h + "]");
        kf kfVar = this.g;
        if (kfVar == null || (a2 = kfVar.a()) == null) {
            return null;
        }
        NetResponse poiDetail = ((x2) ((l3) n2.a(l3.class)).d()).poiDetail(this.h, a2.q().g());
        poiDetail.charset = "UTF-8";
        x3.a aVar = new x3.a(poiDetail, jf.class);
        na.c(str, "poiDetail[" + this.h + "] resp:" + aVar.available());
        if (aVar.available()) {
            return (jf) aVar.b();
        }
        return null;
    }

    public jf.d a(long j) {
        jf.d dVar;
        List<jf.d> list;
        jf jfVar = this.o;
        if (jfVar == null || (dVar = jfVar.f37568a) == null || (list = dVar.j) == null) {
            return null;
        }
        for (jf.d dVar2 : list) {
            pd pdVar = (pd) this.g.b().g().a(pd.class, dVar2.f37574a);
            if (pdVar != null && pdVar.d() == j) {
                return dVar2;
            }
        }
        return null;
    }

    public SubPoi a(String str, jf.d dVar) {
        SubPoi subPoi = new SubPoi();
        subPoi.setParentId(str);
        subPoi.setId(dVar.b);
        subPoi.setName(dVar.a());
        subPoi.setPosition(dVar.h);
        return subPoi;
    }

    public void a(AoiLayerOptions aoiLayerOptions) {
        if (aoiLayerOptions != null) {
            if (aoiLayerOptions.getMaxLevel() != -1) {
                this.i = aoiLayerOptions.getMaxLevel();
            }
            if (aoiLayerOptions.getMinLevel() != -1) {
                this.j = aoiLayerOptions.getMinLevel();
            }
        }
        if (this.k) {
            return;
        }
        String str = q;
        na.c(str, "开始更新POI[" + this.h + "]的详情数据");
        this.k = true;
        ca.a((ca.i) new b()).a((ca.d.b) null, (ca.c<ca.d.b>) new a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cif) {
            String str = this.h;
            String str2 = ((Cif) obj).h;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    public LatLngBounds f() {
        jf jfVar = this.o;
        if (jfVar != null) {
            return a(jfVar.f37568a);
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        return this.h;
    }

    public int hashCode() {
        String str = this.h;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public LatLng location() {
        jf.d dVar;
        jf jfVar = this.o;
        if (jfVar == null || (dVar = jfVar.f37568a) == null) {
            return null;
        }
        return dVar.h;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public String name() {
        jf.d dVar;
        jf jfVar = this.o;
        if (jfVar == null || (dVar = jfVar.f37568a) == null) {
            return null;
        }
        return dVar.f37575c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer
    public boolean remove() {
        rc b2;
        boolean z;
        kf kfVar = this.g;
        if (kfVar == null || this.l || (b2 = kfVar.b()) == null) {
            return false;
        }
        int[] iArr = this.n;
        if (iArr != null) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                b2.b(iArr[i2]);
                i = i2 + 1;
            }
            this.n = null;
            z = true;
        } else {
            z = false;
        }
        int[] iArr2 = this.m;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                b2.c(iArr2[i4]);
                i3 = i4 + 1;
            }
            this.m = null;
            z = true;
        }
        this.o = null;
        this.g.a(this);
        this.l = true;
        na.c(q, "移除poiLayer[" + this.h + "]");
        return z;
    }
}
