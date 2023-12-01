package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* renamed from: com.amap.api.col.3sl.gn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gn.class */
public final class gn extends gp<WeatherSearchQuery, LocalWeatherForecast> {
    private LocalWeatherForecast k;

    public gn(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.k = new LocalWeatherForecast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    /* renamed from: c */
    public LocalWeatherForecast a(String str) throws AMapException {
        LocalWeatherForecast f = fm.f(str);
        this.k = f;
        return f;
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.b).getCity();
        if (!fm.g(city)) {
            String b = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + ho.f(this.i));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.gp, com.amap.api.col.p0003sl.kb
    public final /* bridge */ /* synthetic */ String getURL() {
        return super.getURL();
    }
}
