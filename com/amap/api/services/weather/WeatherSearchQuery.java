package com.amap.api.services.weather;

import com.amap.api.col.p0003sl.fe;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/weather/WeatherSearchQuery.class */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;
    private String a;
    private int b;

    public WeatherSearchQuery() {
        this.b = 1;
    }

    public WeatherSearchQuery(String str, int i) {
        this.b = 1;
        this.a = str;
        this.b = i;
    }

    /* renamed from: clone */
    public WeatherSearchQuery m8983clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            fe.a(e, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.a, this.b);
    }

    public String getCity() {
        return this.a;
    }

    public int getType() {
        return this.b;
    }
}
