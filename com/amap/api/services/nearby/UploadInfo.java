package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/nearby/UploadInfo.class */
public class UploadInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f5657a = 1;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f5658c;

    public int getCoordType() {
        return this.f5657a;
    }

    public LatLonPoint getPoint() {
        return this.f5658c;
    }

    public String getUserID() {
        return this.b;
    }

    public void setCoordType(int i) {
        if (i == 0 || i == 1) {
            this.f5657a = i;
        } else {
            this.f5657a = 1;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f5658c = latLonPoint;
    }

    public void setUserID(String str) {
        this.b = str;
    }
}
