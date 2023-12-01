package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/routepoisearch/RoutePOISearchResult.class */
public class RoutePOISearchResult {
    private List<RoutePOIItem> a;
    private RoutePOISearchQuery b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        this.a = new ArrayList();
        this.a = arrayList;
        this.b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.a;
    }
}
