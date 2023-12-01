package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/interfaces/IRoutePOISearch.class */
public interface IRoutePOISearch {
    RoutePOISearchQuery getQuery();

    RoutePOISearchResult searchRoutePOI() throws AMapException;

    void searchRoutePOIAsyn();

    void setQuery(RoutePOISearchQuery routePOISearchQuery);

    void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener);
}
