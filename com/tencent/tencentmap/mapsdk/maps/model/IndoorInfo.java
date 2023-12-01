package com.tencent.tencentmap.mapsdk.maps.model;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/IndoorInfo.class */
public class IndoorInfo {
    private String buildingId;
    private String floorName;

    public IndoorInfo(String str, String str2) {
        this.buildingId = str;
        this.floorName = str2;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getFloorName() {
        return this.floorName;
    }

    public String toString() {
        return this.buildingId + BridgeUtil.UNDERLINE_STR + this.floorName;
    }
}