package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* renamed from: com.amap.api.col.3sl.he  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/he.class */
public final class he implements IWeatherSearch {
    private Context a;
    private WeatherSearchQuery b;
    private WeatherSearch.OnWeatherSearchListener c;
    private LocalWeatherLiveResult d;
    private LocalWeatherForecastResult e;
    private Handler f;

    public he(Context context) throws AMapException {
        this.f = null;
        hy a = hx.a(context, fd.a(false));
        if (a.a != hx.c.SuccessCode) {
            throw new AMapException(a.b, 1, a.b, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.f = fp.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherLiveResult a() throws AMapException {
        fn.a(this.a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            go goVar = new go(this.a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult(goVar.f(), goVar.d());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherForecastResult b() throws AMapException {
        fn.a(this.a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            gn gnVar = new gn(this.a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult(gnVar.f(), gnVar.d());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.he.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (he.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            fe.a(e, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        }
                    }
                    try {
                        if (he.this.b.getType() == 1) {
                            try {
                                he.this.d = he.this.a();
                                bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                                return;
                            } catch (AMapException e2) {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e2.getErrorCode());
                                fe.a(e2, "WeatherSearch", "searchWeatherAsyn");
                                return;
                            } catch (Throwable th) {
                                fe.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                                return;
                            }
                        }
                        try {
                            if (he.this.b.getType() == 2) {
                                try {
                                    he.this.e = he.this.b();
                                    bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                                } catch (AMapException e3) {
                                    bundle.putInt(MyLocationStyle.ERROR_CODE, e3.getErrorCode());
                                    fe.a(e3, "WeatherSearch", "searchWeatherAsyn");
                                } catch (Throwable th2) {
                                    fe.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                                }
                            }
                        } finally {
                            fp.k kVar = new fp.k();
                            obtainMessage.what = 1302;
                            kVar.b = he.this.c;
                            kVar.a = he.this.e;
                            obtainMessage.obj = kVar;
                            obtainMessage.setData(bundle);
                            he.this.f.sendMessage(obtainMessage);
                        }
                    } finally {
                        fp.l lVar = new fp.l();
                        obtainMessage.what = 1301;
                        lVar.b = he.this.c;
                        lVar.a = he.this.d;
                        obtainMessage.obj = lVar;
                        obtainMessage.setData(bundle);
                        he.this.f.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }
}
