package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* renamed from: com.amap.api.col.3sl.gu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gu.class */
public class gu implements IDistanceSearch {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5008a = gu.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f5009c;
    private DistanceSearch.OnDistanceSearchListener d;

    public gu(Context context) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.b = context.getApplicationContext();
        this.f5009c = fp.a();
    }

    private static boolean a(DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            fn.a(this.b);
            if (distanceQuery != null) {
                if (a(distanceQuery)) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                DistanceSearch.DistanceQuery m2479clone = distanceQuery.m2479clone();
                DistanceResult d = new ff(this.b, m2479clone).d();
                if (d != null) {
                    d.setDistanceQuery(m2479clone);
                    return d;
                }
                return d;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, f5008a, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(final DistanceSearch.DistanceQuery distanceQuery) {
        gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gu.1
            @Override // java.lang.Runnable
            public final void run() {
                Message obtainMessage = fp.a().obtainMessage();
                obtainMessage.what = 400;
                obtainMessage.arg1 = 16;
                Bundle bundle = new Bundle();
                DistanceResult distanceResult = null;
                DistanceResult distanceResult2 = null;
                try {
                    try {
                        DistanceResult calculateRouteDistance = gu.this.calculateRouteDistance(distanceQuery);
                        distanceResult2 = calculateRouteDistance;
                        distanceResult = calculateRouteDistance;
                        bundle.putInt("errorCode", 1000);
                        obtainMessage.obj = gu.this.d;
                        bundle.putParcelable("result", calculateRouteDistance);
                        obtainMessage.setData(bundle);
                        gu.this.f5009c.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                        obtainMessage.obj = gu.this.d;
                        bundle.putParcelable("result", distanceResult);
                        obtainMessage.setData(bundle);
                        gu.this.f5009c.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    obtainMessage.obj = gu.this.d;
                    bundle.putParcelable("result", distanceResult2);
                    obtainMessage.setData(bundle);
                    gu.this.f5009c.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.d = onDistanceSearchListener;
    }
}
