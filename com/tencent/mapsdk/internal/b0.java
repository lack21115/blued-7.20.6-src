package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b0.class */
public class b0 implements h5, le {
    private ic g;
    private s5 h;
    private boolean j;
    private yi k;
    private TencentMap.OnIndoorStateChangeListener l;
    private VectorMap m;
    private rc n;
    private d i = d.IDLE;
    private boolean o = false;
    private IndoorBuilding p = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b0$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b0.this.i == d.IDLE) {
                b0 b0Var = b0.this;
                b0Var.c(b0Var.h.e());
                return;
            }
            b0 b0Var2 = b0.this;
            b0Var2.a(b0Var2.i);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b0$b.class */
    public class b implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23610c;
        public final /* synthetic */ LatLng d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ int f;

        public b(String str, String str2, LatLng latLng, String[] strArr, int i) {
            this.b = str;
            this.f23610c = str2;
            this.d = latLng;
            this.e = strArr;
            this.f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.a(this.b, this.f23610c, this.d, this.e, this.f);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b0$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23611a;

        static {
            d.values();
            int[] iArr = new int[3];
            f23611a = iArr;
            try {
                d dVar = d.SET_TRUE;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f23611a;
                d dVar2 = d.IDLE;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f23611a;
                d dVar3 = d.SET_FALSE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b0$d.class */
    public enum d {
        IDLE,
        SET_TRUE,
        SET_FALSE
    }

    public b0(yi yiVar, String str) {
        this.l = null;
        this.m = null;
        this.k = yiVar;
        if (yiVar != null) {
            if (str == null) {
                this.g = lc.a(yiVar.getContext());
            } else {
                this.g = kc.a(yiVar.getContext(), str);
            }
            this.m = this.k.getMap();
            this.n = this.k.A();
            k();
            c(false);
        }
        VectorMap vectorMap = this.m;
        if (vectorMap != null) {
            vectorMap.a((h5) this);
            this.m.a((le) this);
            this.l = new vi(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, LatLng latLng, String[] strArr, int i) {
        eg egVar;
        w6 w;
        eg egVar2;
        yi yiVar = this.k;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        VectorMap map = this.k.getMap();
        int P = map.P();
        if (str == null || strArr == null || strArr.length <= 0 || i < 0 || P < 16) {
            n();
            if (this.o) {
                this.o = false;
                this.p = null;
                yi yiVar2 = this.k;
                if (yiVar2 != null && (egVar = yiVar2.P) != null) {
                    egVar.a((IndoorBuilding) null);
                }
                TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = this.l;
                if (onIndoorStateChangeListener != null) {
                    onIndoorStateChangeListener.onIndoorBuildingDeactivated();
                    return;
                }
                return;
            }
            return;
        }
        TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener2 = this.l;
        if (onIndoorStateChangeListener2 != null && !this.o) {
            this.o = true;
            onIndoorStateChangeListener2.onIndoorBuildingFocused();
        }
        map.k(Math.min(this.k.L, 22));
        if (this.l != null) {
            ArrayList arrayList = new ArrayList();
            for (String str3 : strArr) {
                arrayList.add(new IndoorLevel(str3));
            }
            try {
                IndoorBuilding indoorBuilding = this.p;
                if (indoorBuilding != null && indoorBuilding.getBuidlingId().equals(str)) {
                    if (this.p.getActiveLevelIndex() == i) {
                        return;
                    }
                }
            } catch (Exception e) {
            }
            IndoorBuilding indoorBuilding2 = this.p;
            if ((indoorBuilding2 == null || !str.equals(indoorBuilding2.getBuidlingId())) && (w = this.n.w()) != null) {
                w.k().b().b();
            }
            this.p = new IndoorBuilding(str, str2, latLng, arrayList, i);
            yi yiVar3 = this.k;
            if (yiVar3 != null && (egVar2 = yiVar3.P) != null && egVar2.h()) {
                this.k.P.a(this.p);
            }
            this.l.onIndoorLevelActivated(this.p);
        }
    }

    private boolean a() {
        s5 s5Var = this.h;
        return s5Var != null && s5Var.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            r7 = this;
            r0 = r7
            com.tencent.mapsdk.internal.ic r0 = r0.g
            java.lang.String r1 = "AIEnabled"
            int r0 = r0.b(r1)
            r8 = r0
            r0 = r7
            com.tencent.mapsdk.internal.ic r0 = r0.g
            java.lang.String r1 = "AIType"
            int r0 = r0.b(r1)
            r9 = r0
            r0 = r7
            com.tencent.mapsdk.internal.ic r0 = r0.g
            java.lang.String r1 = "AIBuildingList"
            java.lang.String r0 = r0.d(r1)
            r10 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L31
            if (r0 != 0) goto L3a
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Exception -> L31
            r1 = r0
            r2 = r10
            r1.<init>(r2)     // Catch: java.lang.Exception -> L31
            r10 = r0
            goto L3c
        L31:
            r10 = move-exception
            java.lang.String r0 = "TI"
            java.lang.String r1 = "indoor auth init failed"
            r2 = r10
            com.tencent.mapsdk.internal.na.a(r0, r1, r2)
        L3a:
            r0 = 0
            r10 = r0
        L3c:
            r0 = r8
            r1 = -1
            if (r0 == r1) goto L58
            r0 = r9
            r1 = -1
            if (r0 == r1) goto L58
            r0 = r10
            if (r0 == 0) goto L58
            r0 = r7
            com.tencent.mapsdk.internal.s5 r1 = new com.tencent.mapsdk.internal.s5
            r2 = r1
            r3 = r8
            r4 = r9
            r5 = r10
            r2.<init>(r3, r4, r5)
            r0.h = r1
        L58:
            r0 = r7
            com.tencent.mapsdk.vector.VectorMap r0 = r0.m
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L79
            r0 = r10
            r1 = r7
            int r1 = r1.j()
            r0.a(r1)
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L79
            r0 = r7
            com.tencent.mapsdk.vector.VectorMap r0 = r0.m
            r1 = r7
            java.lang.String[] r1 = r1.c()
            r0.a(r1)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.b0.k():void");
    }

    private void n() {
        yi yiVar = this.k;
        if (yiVar == null || yiVar.getMap() == null || this.o) {
            return;
        }
        VectorMap map = this.k.getMap();
        int min = Math.min(20, this.k.L);
        if (map.M().x() < min) {
            map.k(min);
        }
    }

    public int a(String str) {
        VectorMap vectorMap = this.m;
        if (vectorMap == null) {
            return -1;
        }
        return vectorMap.a(str);
    }

    public void a(int i) {
        rc rcVar = this.n;
        if (rcVar == null) {
            return;
        }
        rcVar.j(i);
        d();
    }

    public void a(d dVar) {
        int ordinal = dVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                c(true);
                return;
            } else if (ordinal != 2) {
                return;
            }
        }
        c(false);
    }

    public void a(s5 s5Var) {
        if (s5Var != null) {
            this.h = s5Var;
            na.a(ma.f, "IndoorAuth:" + s5Var);
            this.g.b(m4.B, s5Var.c());
            this.g.b(m4.C, s5Var.d());
            if (s5Var.a() != null) {
                this.g.b(m4.D, s5Var.a().toString());
            }
            VectorMap vectorMap = this.m;
            if (vectorMap != null) {
                vectorMap.a(j());
                if (j() == 1) {
                    this.m.a(c());
                }
            }
        } else {
            this.g.a(new String[]{m4.B, m4.C, m4.D});
        }
        if (this.h == null) {
            this.h = new s5();
        }
        ca.b(new a());
    }

    @Override // com.tencent.mapsdk.internal.h5
    public void a(z5 z5Var) {
        yi yiVar;
        if (!this.j || (yiVar = this.k) == null || yiVar.getMap() == null || this.k.k() == null || this.o) {
            return;
        }
        n();
    }

    public void a(String str, String str2) {
        rc rcVar = this.n;
        if (rcVar == null) {
            return;
        }
        rcVar.a(str, str2);
    }

    public void a(boolean z) {
        VectorMap vectorMap = this.m;
        if (vectorMap == null) {
            return;
        }
        vectorMap.h(z);
    }

    public IndoorBuilding b() {
        return this.p;
    }

    public void b(boolean z) {
        d dVar = z ? d.SET_TRUE : d.SET_FALSE;
        this.i = dVar;
        a(dVar);
    }

    public void c(boolean z) {
        this.j = z;
        if (this.n == null) {
            return;
        }
        if (!a()) {
            this.n.k(false);
            return;
        }
        this.n.k(z);
        if (z || !this.o) {
            return;
        }
        a(null, null, null, null, -1);
    }

    public String[] c() {
        s5 s5Var = this.h;
        if (s5Var != null) {
            return s5Var.b();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.le
    public void d() {
        yi yiVar;
        if (!this.j || (yiVar = this.k) == null || yiVar.getMap() == null) {
            return;
        }
        VectorMap map = this.k.getMap();
        GeoPoint geoPoint = new GeoPoint();
        dg b2 = map.b(geoPoint);
        if (b2 == null) {
            return;
        }
        ca.b(new b(b2.f23708a, b2.b, new LatLng((geoPoint.getLatitudeE6() * 1.0d) / 1000000.0d, (geoPoint.getLongitudeE6() * 1.0d) / 1000000.0d), b2.d, b2.f23709c));
    }

    public String e() {
        IndoorBuilding indoorBuilding = this.p;
        return indoorBuilding == null ? "" : indoorBuilding.getBuildingName();
    }

    public IndoorBuilding f() {
        return this.p;
    }

    public String g() {
        IndoorBuilding indoorBuilding = this.p;
        if (indoorBuilding == null) {
            return null;
        }
        return indoorBuilding.getBuidlingId();
    }

    public int h() {
        IndoorBuilding indoorBuilding = this.p;
        if (indoorBuilding == null) {
            return -1;
        }
        return indoorBuilding.getActiveLevelIndex();
    }

    public String[] i() {
        IndoorBuilding indoorBuilding = this.p;
        if (indoorBuilding == null || indoorBuilding.getLevels() == null || this.p.getLevels().isEmpty()) {
            return null;
        }
        List<IndoorLevel> levels = this.p.getLevels();
        String[] strArr = new String[levels.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= levels.size()) {
                return strArr;
            }
            strArr[i2] = levels.get(i2).getName();
            i = i2 + 1;
        }
    }

    public int j() {
        s5 s5Var = this.h;
        return (s5Var == null || !s5Var.f()) ? 0 : 1;
    }

    public boolean l() {
        return this.o;
    }

    public void m() {
        IndoorBuilding indoorBuilding = this.p;
        if (indoorBuilding != null) {
            String buidlingId = indoorBuilding.getBuidlingId();
            int activeLevelIndex = this.p.getActiveLevelIndex();
            List<IndoorLevel> levels = this.p.getLevels();
            if (levels == null || activeLevelIndex >= levels.size()) {
                return;
            }
            String name = levels.get(activeLevelIndex).getName();
            if (f7.b(buidlingId) || f7.b(name)) {
                return;
            }
            this.n.a(buidlingId, name);
        }
    }
}
