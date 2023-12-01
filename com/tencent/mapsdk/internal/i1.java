package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i1.class */
public class i1 {
    private IndoorBuilding f;
    private final a1 g;
    private final f1 j;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, u4> f37540a = new ConcurrentHashMap();
    private final List<u4> b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<u4> f37541c = new CopyOnWriteArrayList();
    private final List<u4> d = new CopyOnWriteArrayList();
    private final List<q4> e = new CopyOnWriteArrayList();
    private final Comparator<Levelable> h = new a();
    private final Comparator<Levelable> i = new b();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i1$a.class */
    public class a implements Comparator<Levelable> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Levelable levelable, Levelable levelable2) {
            return Float.compare(levelable.getZIndex(), levelable2.getZIndex());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i1$b.class */
    public class b implements Comparator<Levelable> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Levelable levelable, Levelable levelable2) {
            return levelable.getLevel() == levelable2.getLevel() ? Float.compare(levelable.getZIndex(), levelable2.getZIndex()) : levelable.getLevel() - levelable2.getLevel();
        }
    }

    public i1(a1 a1Var, e1 e1Var) {
        this.g = a1Var;
        this.j = new f1(e1Var);
    }

    private void a(q4 q4Var) {
        if (q4Var == null || q4Var.f() == null) {
            return;
        }
        IndoorBuilding indoorBuilding = this.f;
        if (indoorBuilding != null) {
            q4Var.a(indoorBuilding);
        } else {
            q4Var.l();
        }
        this.e.add(q4Var);
    }

    public <T extends u4> T a(String str, Class<T> cls) {
        T t = (T) this.f37540a.get(str);
        if (t == null || t.getClass() != cls) {
            return null;
        }
        return t;
    }

    public Arc a(ArcOptions arcOptions) {
        xe xeVar = new xe(arcOptions, this.g);
        s0 s0Var = new s0(xeVar);
        this.f37540a.put(xeVar.getId(), s0Var);
        this.f37541c.add(s0Var);
        a((q4) xeVar);
        return s0Var;
    }

    public Circle a(CircleOptions circleOptions) {
        ye yeVar = new ye(this.g);
        yeVar.a(circleOptions);
        t0 t0Var = new t0(yeVar);
        this.f37540a.put(yeVar.getId(), t0Var);
        this.d.add(t0Var);
        a((q4) yeVar);
        return t0Var;
    }

    public Marker a(MarkerOptions markerOptions) {
        yi yiVar = (yi) this.g;
        bf bfVar = new bf(yiVar);
        bfVar.setMarkerOptions(markerOptions);
        w0 w0Var = new w0(bfVar);
        this.f37540a.put(bfVar.getId(), w0Var);
        this.b.add(w0Var);
        yiVar.a(bfVar);
        a((q4) bfVar);
        return w0Var;
    }

    public Polygon a(PolygonOptions polygonOptions) {
        cf cfVar = new cf(this.g, polygonOptions);
        x0 x0Var = new x0(cfVar);
        this.f37540a.put(cfVar.getId(), x0Var);
        this.d.add(x0Var);
        a((q4) cfVar);
        return x0Var;
    }

    public Polyline a(PolylineOptions polylineOptions) {
        df dfVar = new df(this.g);
        dfVar.setPolylineOptions(polylineOptions);
        y0 y0Var = new y0(dfVar);
        this.f37540a.put(dfVar.getId(), y0Var);
        this.f37541c.add(y0Var);
        a((q4) dfVar);
        return y0Var;
    }

    public void a() {
        synchronized (this) {
            Iterator<u4> it = this.f37540a.values().iterator();
            while (it.hasNext()) {
                u4 next = it.next();
                if (next != null) {
                    next.remove();
                    it.remove();
                }
            }
        }
        this.b.clear();
        this.f37541c.clear();
        this.d.clear();
    }

    public void a(int i, int i2) {
        for (u4 u4Var : this.f37540a.values()) {
            if (u4Var instanceof q4) {
                ((q4) u4Var).a(i, i2);
            }
        }
    }

    public void a(u4 u4Var) {
        this.j.a(u4Var);
        if (u4Var instanceof q4) {
            a((q4) u4Var);
        }
    }

    public void a(GL10 gl10) {
        this.j.a(gl10);
    }

    public boolean a(float f, float f2) {
        return this.j.a(f, f2);
    }

    public boolean a(IndoorBuilding indoorBuilding) {
        this.f = indoorBuilding;
        boolean z = false;
        for (q4 q4Var : this.e) {
            if (q4Var.f() != null) {
                z = true;
                if (indoorBuilding != null) {
                    q4Var.a(indoorBuilding);
                } else {
                    q4Var.l();
                }
            }
        }
        return z;
    }

    public boolean a(String str) {
        p0 x;
        u4 remove = this.f37540a.remove(str);
        if (remove != null) {
            this.b.remove(remove);
            this.f37541c.remove(remove);
            this.d.remove(remove);
            if ((remove instanceof v0) && (x = ((v0) remove).x()) != null) {
                this.e.remove(x);
            }
        }
        return remove != null;
    }

    public u4 b(String str) {
        return this.f37540a.get(str);
    }

    public List<Arc> b() {
        ArrayList arrayList = new ArrayList();
        for (u4 u4Var : this.f37540a.values()) {
            if (u4Var instanceof s0) {
                arrayList.add((s0) u4Var);
            }
        }
        Collections.sort(arrayList, this.h);
        return arrayList;
    }

    public void b(u4 u4Var) {
        this.j.b(u4Var);
    }

    public List<Circle> c() {
        ArrayList arrayList = new ArrayList();
        for (u4 u4Var : this.f37540a.values()) {
            if (u4Var instanceof t0) {
                arrayList.add((t0) u4Var);
            }
        }
        Collections.sort(arrayList, this.h);
        return arrayList;
    }

    public List<u4> d() {
        return this.f37541c;
    }

    public List<Marker> e() {
        ArrayList arrayList = new ArrayList();
        for (u4 u4Var : this.f37540a.values()) {
            if (u4Var instanceof w0) {
                arrayList.add((w0) u4Var);
            }
        }
        Collections.sort(arrayList, this.h);
        return arrayList;
    }

    public Iterable<u4> f() {
        return this.f37540a.values();
    }

    public List<u4> g() {
        return this.d;
    }

    public List<u4> h() {
        return this.b;
    }

    public List<Polygon> i() {
        ArrayList arrayList = new ArrayList();
        for (u4 u4Var : this.f37540a.values()) {
            if (u4Var instanceof x0) {
                arrayList.add((x0) u4Var);
            }
        }
        Collections.sort(arrayList, this.i);
        return arrayList;
    }

    public List<Polyline> j() {
        ArrayList arrayList = new ArrayList();
        for (u4 u4Var : this.f37540a.values()) {
            if (u4Var instanceof y0) {
                arrayList.add((y0) u4Var);
            }
        }
        Collections.sort(arrayList, this.h);
        return arrayList;
    }
}
