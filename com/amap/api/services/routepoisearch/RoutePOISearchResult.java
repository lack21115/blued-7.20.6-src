package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/routepoisearch/RoutePOISearchResult.class */
public class RoutePOISearchResult {

    /* renamed from: a  reason: collision with root package name */
    private List<RoutePOIItem> f5789a;
    private RoutePOISearchQuery b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        this.f5789a = new ArrayList();
        this.f5789a = arrayList;
        this.b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f5789a;
    }
}
