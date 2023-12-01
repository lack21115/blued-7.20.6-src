package com.amap.api.services.weather;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/weather/LocalWeatherForecastResult.class */
public class LocalWeatherForecastResult {

    /* renamed from: a  reason: collision with root package name */
    private WeatherSearchQuery f5801a;
    private LocalWeatherForecast b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f5801a = weatherSearchQuery;
        this.b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f5801a;
    }
}
