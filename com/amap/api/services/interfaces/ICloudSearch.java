package com.amap.api.services.interfaces;

import com.amap.api.services.cloud.CloudSearch;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/interfaces/ICloudSearch.class */
public interface ICloudSearch {
    void searchCloudAsyn(CloudSearch.Query query);

    void searchCloudDetailAsyn(String str, String str2);

    void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener);
}
