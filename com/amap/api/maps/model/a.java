package com.amap.api.maps.model;

import com.amap.api.col.p0003sl.df;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/a.class */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final df f5540a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private List<WeightedLatLng> f5541c;
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
        this.f5540a = dfVar;
        this.b = i;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        arrayList.add(new a(this.f5540a.f4849a, this.f5540a.e, this.f5540a.b, this.f5540a.f, this.b + 1));
        this.d.add(new a(this.f5540a.e, this.f5540a.f4850c, this.f5540a.b, this.f5540a.f, this.b + 1));
        this.d.add(new a(this.f5540a.f4849a, this.f5540a.e, this.f5540a.f, this.f5540a.d, this.b + 1));
        this.d.add(new a(this.f5540a.e, this.f5540a.f4850c, this.f5540a.f, this.f5540a.d, this.b + 1));
        List<WeightedLatLng> list = this.f5541c;
        this.f5541c = null;
        for (WeightedLatLng weightedLatLng : list) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    private void a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.d == null) {
            if (this.f5541c == null) {
                this.f5541c = new ArrayList();
            }
            this.f5541c.add(weightedLatLng);
            if (this.f5541c.size() <= 50 || this.b >= 40) {
                return;
            }
            a();
        } else if (d2 < this.f5540a.f) {
            if (d < this.f5540a.e) {
                this.d.get(0).a(d, d2, weightedLatLng);
            } else {
                this.d.get(1).a(d, d2, weightedLatLng);
            }
        } else if (d < this.f5540a.e) {
            this.d.get(2).a(d, d2, weightedLatLng);
        } else {
            this.d.get(3).a(d, d2, weightedLatLng);
        }
    }

    private void a(df dfVar, Collection<WeightedLatLng> collection) {
        if (this.f5540a.a(dfVar)) {
            List<a> list = this.d;
            if (list != null) {
                for (a aVar : list) {
                    aVar.a(dfVar, collection);
                }
            } else if (this.f5541c != null) {
                if (dfVar.b(this.f5540a)) {
                    collection.addAll(this.f5541c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.f5541c) {
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
        if (this.f5540a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }
}
