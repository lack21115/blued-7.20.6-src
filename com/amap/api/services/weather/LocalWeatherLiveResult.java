package com.amap.api.services.weather;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/weather/LocalWeatherLiveResult.class */
public class LocalWeatherLiveResult {
    private WeatherSearchQuery a;
    private LocalWeatherLive b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.a = weatherSearchQuery;
        this.b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.a;
    }
}
