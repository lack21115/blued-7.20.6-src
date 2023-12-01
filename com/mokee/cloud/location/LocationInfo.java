package com.mokee.cloud.location;

import android.text.TextUtils;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/LocationInfo.class */
public class LocationInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f24209a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f24210c;
    private String d;
    private String e;
    private String f;

    public int getEngineType() {
        return this.f24209a;
    }

    public String getLocation() {
        return TextUtils.isEmpty(this.d) ? this.f : this.d;
    }

    public String getNumber() {
        return this.e;
    }

    public int getPhoneType() {
        return this.f24210c;
    }

    public long getUpdateTime() {
        return this.b;
    }

    public String getUserMark() {
        return this.d;
    }

    public void setEngineType(int i) {
        this.f24209a = i;
    }

    public void setLocation(String str) {
        this.f = str;
    }

    public void setNumber(String str) {
        this.e = str;
    }

    public void setPhoneType(int i) {
        this.f24210c = i;
    }

    public void setUpdateTime(long j) {
        this.b = j;
    }

    public void setUserMark(String str) {
        this.d = str;
    }
}
