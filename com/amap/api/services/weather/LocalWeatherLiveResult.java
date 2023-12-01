package com.amap.api.services.weather;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/weather/LocalWeatherLiveResult.class */
public class LocalWeatherLiveResult {

    /* renamed from: a  reason: collision with root package name */
    private WeatherSearchQuery f5804a;
    private LocalWeatherLive b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f5804a = weatherSearchQuery;
        this.b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f5804a;
    }
}
