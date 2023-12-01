package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.util.l;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* renamed from: com.amap.api.col.3sl.hc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hc.class */
public final class hc implements IRouteSearchV2 {
    private RouteSearchV2.OnRouteSearchListener a;
    private Context b;
    private Handler c;

    public hc(Context context) throws AMapException {
        hy a = hx.a(context, fd.a(false));
        if (a.a != hx.c.SuccessCode) {
            throw new AMapException(a.b, 1, a.b, a.a.a());
        }
        this.b = context.getApplicationContext();
        this.c = fp.a();
    }

    private static boolean a(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            fn.a(this.b);
            if (driveRouteQuery != null) {
                if (a(driveRouteQuery.getFromAndTo())) {
                    gd.a().a(driveRouteQuery.getPassedByPoints());
                    gd.a().b(driveRouteQuery.getAvoidpolygons());
                    RouteSearchV2.DriveRouteQuery m8962clone = driveRouteQuery.m8962clone();
                    DriveRouteResultV2 d = new fj(this.b, m8962clone).d();
                    if (d != null) {
                        d.setDriveQuery(m8962clone);
                        return d;
                    }
                    return d;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(final RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hc.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    DriveRouteResultV2 driveRouteResultV2 = null;
                    DriveRouteResultV2 driveRouteResultV22 = null;
                    try {
                        try {
                            DriveRouteResultV2 calculateDriveRoute = hc.this.calculateDriveRoute(driveRouteQuery);
                            driveRouteResultV22 = calculateDriveRoute;
                            driveRouteResultV2 = calculateDriveRoute;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hc.this.a;
                            bundle.putParcelable(l.c, calculateDriveRoute);
                            obtainMessage.setData(bundle);
                            hc.this.c.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hc.this.a;
                            bundle.putParcelable(l.c, driveRouteResultV2);
                            obtainMessage.setData(bundle);
                            hc.this.c.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hc.this.a;
                        bundle.putParcelable(l.c, driveRouteResultV22);
                        obtainMessage.setData(bundle);
                        hc.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }
}
