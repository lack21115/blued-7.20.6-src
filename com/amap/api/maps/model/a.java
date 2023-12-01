package com.amap.api.maps.model;

import com.amap.api.col.p0003sl.df;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/a.class */
final class a {
    private final df a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<a> d;

    private a(double d, double d2, double d3, double d4, int i) {
        this(new df(d, d2, d3, d4), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(df dfVar) {
        this(dfVar, 0);
    }

    private a(df dfVar, int i) {
        this.d = null;
        this.a = dfVar;
        this.b = i;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        arrayList.add(new a(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
        this.d.add(new a(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
        this.d.add(new a(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
        this.d.add(new a(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
        List<WeightedLatLng> list = this.c;
        this.c = null;
        for (WeightedLatLng weightedLatLng : list) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    private void a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.d == null) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(weightedLatLng);
            if (this.c.size() <= 50 || this.b >= 40) {
                return;
            }
            a();
        } else if (d2 < this.a.f) {
            if (d < this.a.e) {
                this.d.get(0).a(d, d2, weightedLatLng);
            } else {
                this.d.get(1).a(d, d2, weightedLatLng);
            }
        } else if (d < this.a.e) {
            this.d.get(2).a(d, d2, weightedLatLng);
        } else {
            this.d.get(3).a(d, d2, weightedLatLng);
        }
    }

    private void a(df dfVar, Collection<WeightedLatLng> collection) {
        if (this.a.a(dfVar)) {
            List<a> list = this.d;
            if (list != null) {
                for (a aVar : list) {
                    aVar.a(dfVar, collection);
                }
            } else if (this.c != null) {
                if (dfVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.c) {
                    if (dfVar.a(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<WeightedLatLng> a(df dfVar) {
        ArrayList arrayList = new ArrayList();
        a(dfVar, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }
}
