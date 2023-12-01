package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/help/InputtipsQuery.class */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f5645a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5646c = false;
    private String d = null;
    private LatLonPoint e;

    public InputtipsQuery(String str, String str2) {
        this.f5645a = str;
        this.b = str2;
    }

    public String getCity() {
        return this.b;
    }

    public boolean getCityLimit() {
        return this.f5646c;
    }

    public String getKeyword() {
        return this.f5645a;
    }

    public LatLonPoint getLocation() {
        return this.e;
    }

    public String getType() {
        return this.d;
    }

    public void setCityLimit(boolean z) {
        this.f5646c = z;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setType(String str) {
        this.d = str;
    }
}
