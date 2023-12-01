package com.tencent.map.sdk.comps.offlinemap;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/offlinemap/OfflineProvince.class */
public final class OfflineProvince extends OfflineItem {
    private List<OfflineCity> mCities;

    public List<OfflineCity> getCities() {
        return this.mCities;
    }

    public void setCities(List<OfflineCity> list) {
        this.mCities = list;
    }
}
