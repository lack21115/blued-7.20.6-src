package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.ga;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.amap.api.col.3sl.gc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gc.class */
final class gc extends gb {

    /* renamed from: a  reason: collision with root package name */
    private double f4988a;

    /* renamed from: com.amap.api.col.3sl.gc$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gc$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        LatLonPoint f4989a;
        double b;

        public a(double d, double d2, double d3) {
            this.f4989a = null;
            this.b = 0.0d;
            this.f4989a = new LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LatLonPoint latLonPoint = this.f4989a;
            a aVar = (a) obj;
            LatLonPoint latLonPoint2 = aVar.f4989a;
            if (latLonPoint == latLonPoint2) {
                return true;
            }
            return latLonPoint != null && ((double) fe.a(latLonPoint, latLonPoint2)) <= aVar.b;
        }
    }

    public gc(String... strArr) {
        super(strArr);
        this.f4988a = 0.0d;
        this.f4988a = 0.0d;
    }

    public final double a() {
        return this.f4988a;
    }

    @Override // com.amap.api.col.p0003sl.gb
    public final void a(ga.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            this.f4988a = aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.gb
    public final boolean a(LinkedHashMap<ga.b, Object> linkedHashMap, ga.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        if (bVar.b == null) {
            return super.a(linkedHashMap, bVar);
        }
        for (ga.b bVar2 : linkedHashMap.keySet()) {
            if (bVar2 != null && bVar2.f4984a != null && bVar2.f4984a.equals(bVar.f4984a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.gb
    public final Object b(LinkedHashMap<ga.b, Object> linkedHashMap, ga.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        if (bVar.b == null) {
            return super.b(linkedHashMap, bVar);
        }
        for (ga.b bVar2 : linkedHashMap.keySet()) {
            if (bVar2 != null && bVar2.f4984a != null && bVar2.f4984a.equals(bVar.f4984a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
                return linkedHashMap.get(bVar2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.gb
    public final Object c(LinkedHashMap<ga.b, Object> linkedHashMap, ga.b bVar) {
        ga.b bVar2;
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        if (bVar.b == null) {
            return super.c(linkedHashMap, bVar);
        }
        Iterator<ga.b> it = linkedHashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar2 = null;
                break;
            }
            ga.b next = it.next();
            if (next != null && next.f4984a != null && next.f4984a.equals(bVar.f4984a) && (next.b instanceof a) && ((a) next.b).a(bVar.b)) {
                bVar2 = next;
                break;
            }
        }
        if (bVar2 != null) {
            return linkedHashMap.remove(bVar2);
        }
        return null;
    }
}
