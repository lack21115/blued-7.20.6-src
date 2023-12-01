package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/NearbySearchResult.class */
public class NearbySearchResult {

    /* renamed from: a  reason: collision with root package name */
    private List<NearbyInfo> f5656a = new ArrayList();
    private int b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f5656a;
    }

    public int getTotalNum() {
        return this.b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f5656a = list;
        this.b = list.size();
    }
}
