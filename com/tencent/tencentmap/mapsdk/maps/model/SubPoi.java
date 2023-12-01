package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/SubPoi.class */
public class SubPoi extends MapPoi {
    private String id;
    private String parentId;

    public String getId() {
        return this.id;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }
}
