package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbySearchResult.class */
public class NearbySearchResult {
    private List<NearbyInfo> a = new ArrayList();
    private int b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.a;
    }

    public int getTotalNum() {
        return this.b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.a = list;
        this.b = list.size();
    }
}
