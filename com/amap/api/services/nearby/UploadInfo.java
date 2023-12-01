package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/UploadInfo.class */
public class UploadInfo {
    private int a = 1;
    private String b;
    private LatLonPoint c;

    public int getCoordType() {
        return this.a;
    }

    public LatLonPoint getPoint() {
        return this.c;
    }

    public String getUserID() {
        return this.b;
    }

    public void setCoordType(int i) {
        if (i == 0 || i == 1) {
            this.a = i;
        } else {
            this.a = 1;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setUserID(String str) {
        this.b = str;
    }
}
