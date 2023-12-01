package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* renamed from: com.amap.api.col.3sl.go  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/go.class */
public final class go extends gp<WeatherSearchQuery, LocalWeatherLive> {
    private LocalWeatherLive k;

    public go(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.k = new LocalWeatherLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    /* renamed from: c */
    public LocalWeatherLive a(String str) throws AMapException {
        LocalWeatherLive e = fm.e(str);
        this.k = e;
        return e;
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
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + ho.f(this.i));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.gp, com.amap.api.col.p0003sl.kb
    public final /* bridge */ /* synthetic */ String getURL() {
        return super.getURL();
    }
}
