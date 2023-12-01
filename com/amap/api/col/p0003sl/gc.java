package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.ga;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.amap.api.col.3sl.gc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gc.class */
final class gc extends gb {
    private double a;

    /* renamed from: com.amap.api.col.3sl.gc$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gc$a.class */
    static final class a {
        LatLonPoint a;
        double b;

        public a(double d, double d2, double d3) {
            this.a = null;
            this.b = 0.0d;
            this.a = new LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LatLonPoint latLonPoint = this.a;
            a aVar = (a) obj;
            LatLonPoint latLonPoint2 = aVar.a;
            if (latLonPoint == latLonPoint2) {
                return true;
            }
            return latLonPoint != null && ((double) fe.a(latLonPoint, latLonPoint2)) <= aVar.b;
        }
    }

    public gc(String... strArr) {
        super(strArr);
        this.a = 0.0d;
        this.a = 0.0d;
    }

    public final double a() {
        return this.a;
    }

    @Override // com.amap.api.col.p0003sl.gb
    public final void a(ga.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            this.a = aVar.d();
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
            if (bVar2 != null && bVar2.a != null && bVar2.a.equals(bVar.a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
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
            if (bVar2 != null && bVar2.a != null && bVar2.a.equals(bVar.a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
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
            if (next != null && next.a != null && next.a.equals(bVar.a) && (next.b instanceof a) && ((a) next.b).a(bVar.b)) {
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
