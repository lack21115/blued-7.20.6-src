package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.gw  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gw.class */
public final class gw implements IGeocodeSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f5014a;
    private GeocodeSearch.OnGeocodeSearchListener b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f5015c;

    public gw(Context context) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f5014a = context.getApplicationContext();
        this.f5015c = fp.a();
    }

    private static boolean a(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            fn.a(this.f5014a);
            if (a(regeocodeQuery)) {
                return new ge(this.f5014a, regeocodeQuery).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gw.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 201;
                        fp.i iVar = new fp.i();
                        iVar.b = gw.this.b;
                        obtainMessage.obj = iVar;
                        iVar.f4969a = new RegeocodeResult(regeocodeQuery, gw.this.getFromLocation(regeocodeQuery));
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } finally {
                        gw.this.f5015c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            fn.a(this.f5014a);
            if (geocodeQuery != null) {
                return new fk(this.f5014a, geocodeQuery).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gw.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    try {
                        obtainMessage.what = 200;
                        obtainMessage.arg1 = 2;
                        obtainMessage.arg2 = 1000;
                        fp.e eVar = new fp.e();
                        eVar.b = gw.this.b;
                        obtainMessage.obj = eVar;
                        eVar.f4965a = new GeocodeResult(geocodeQuery, gw.this.getFromLocationName(geocodeQuery));
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } finally {
                        gw.this.f5015c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }
}
