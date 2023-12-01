package com.amap.api.services.core;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/core/SuggestionCity.class */
public class SuggestionCity {

    /* renamed from: a  reason: collision with root package name */
    private String f5616a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5617c;
    private int d;

    protected SuggestionCity() {
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.f5616a = str;
        this.b = str2;
        this.f5617c = str3;
        this.d = i;
    }

    public String getAdCode() {
        return this.f5617c;
    }

    public String getCityCode() {
        return this.b;
    }

    public String getCityName() {
        return this.f5616a;
    }

    public int getSuggestionNum() {
        return this.d;
    }

    public void setAdCode(String str) {
        this.f5617c = str;
    }

    public void setCityCode(String str) {
        this.b = str;
    }

    public void setCityName(String str) {
        this.f5616a = str;
    }

    public void setSuggestionNum(int i) {
        this.d = i;
    }
}
