package com.amap.api.services.routepoisearch;

import com.amap.api.col.p0003sl.fe;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/routepoisearch/RoutePOISearchQuery.class */
public class RoutePOISearchQuery implements Cloneable {
    private LatLonPoint a;
    private LatLonPoint b;
    private int c;
    private RoutePOISearch.RoutePOISearchType d;
    private int e;
    private List<LatLonPoint> f;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, RoutePOISearch.RoutePOISearchType routePOISearchType, int i2) {
        this.e = 250;
        this.a = latLonPoint;
        this.b = latLonPoint2;
        this.c = i;
        this.d = routePOISearchType;
        this.e = i2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i) {
        this.e = 250;
        this.f = list;
        this.d = routePOISearchType;
        this.e = i;
    }

    /* renamed from: clone */
    public RoutePOISearchQuery m8979clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            fe.a(e, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f;
        return (list == null || list.size() <= 0) ? new RoutePOISearchQuery(this.a, this.b, this.c, this.d, this.e) : new RoutePOISearchQuery(this.f, this.d, this.e);
    }

    public LatLonPoint getFrom() {
        return this.a;
    }

    public int getMode() {
        return this.c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f;
    }

    public int getRange() {
        return this.e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.d;
    }

    public LatLonPoint getTo() {
        return this.b;
    }
}
