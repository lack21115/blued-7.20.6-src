package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/interfaces/IDistrictSearch.class */
public interface IDistrictSearch {
    DistrictSearchQuery getQuery();

    DistrictResult searchDistrict() throws AMapException;

    void searchDistrictAnsy();

    void searchDistrictAsyn();

    void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener);

    void setQuery(DistrictSearchQuery districtSearchQuery);
}
