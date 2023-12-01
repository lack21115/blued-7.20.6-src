package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.util.l;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* renamed from: com.amap.api.col.3sl.hb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hb.class */
public final class hb implements IRouteSearch {
    private RouteSearch.OnRouteSearchListener a;
    private RouteSearch.OnTruckRouteSearchListener b;
    private RouteSearch.OnRoutePlanSearchListener c;
    private Context d;
    private Handler e;

    public hb(Context context) throws AMapException {
        hy a = hx.a(context, fd.a(false));
        if (a.a != hx.c.SuccessCode) {
            throw new AMapException(a.b, 1, a.b, a.a.a());
        }
        this.d = context.getApplicationContext();
        this.e = fp.a();
    }

    private static boolean a(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            fn.a(this.d);
            if (busRouteQuery != null) {
                if (a(busRouteQuery.getFromAndTo())) {
                    RouteSearch.BusRouteQuery m8947clone = busRouteQuery.m8947clone();
                    BusRouteResult d = new ey(this.d, m8947clone).d();
                    if (d != null) {
                        d.setBusQuery(m8947clone);
                        return d;
                    }
                    return d;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hb.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    BusRouteResult busRouteResult2 = null;
                    try {
                        try {
                            BusRouteResult calculateBusRoute = hb.this.calculateBusRoute(busRouteQuery);
                            busRouteResult2 = calculateBusRoute;
                            busRouteResult = calculateBusRoute;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, calculateBusRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, busRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.a;
                        bundle.putParcelable(l.c, busRouteResult2);
                        obtainMessage.setData(bundle);
                        hb.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            fn.a(this.d);
            if (drivePlanQuery != null) {
                if (a(drivePlanQuery.getFromAndTo())) {
                    DriveRoutePlanResult d = new fh(this.d, drivePlanQuery.m8949clone()).d();
                    if (d != null) {
                        d.setDrivePlanQuery(drivePlanQuery);
                        return d;
                    }
                    return d;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "RouteSearch", "calculateDrivePlan");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(final RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hb.6
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 105;
                    obtainMessage.arg1 = 18;
                    Bundle bundle = new Bundle();
                    DriveRoutePlanResult driveRoutePlanResult = null;
                    DriveRoutePlanResult driveRoutePlanResult2 = null;
                    try {
                        try {
                            DriveRoutePlanResult calculateDrivePlan = hb.this.calculateDrivePlan(drivePlanQuery);
                            driveRoutePlanResult2 = calculateDrivePlan;
                            driveRoutePlanResult = calculateDrivePlan;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hb.this.c;
                            bundle.putParcelable(l.c, calculateDrivePlan);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hb.this.c;
                            bundle.putParcelable(l.c, driveRoutePlanResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.c;
                        bundle.putParcelable(l.c, driveRoutePlanResult2);
                        obtainMessage.setData(bundle);
                        hb.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            fn.a(this.d);
            if (driveRouteQuery != null) {
                if (a(driveRouteQuery.getFromAndTo())) {
                    gd.a().a(driveRouteQuery.getPassedByPoints());
                    gd.a().b(driveRouteQuery.getAvoidpolygons());
                    RouteSearch.DriveRouteQuery m8951clone = driveRouteQuery.m8951clone();
                    DriveRouteResult d = new fi(this.d, m8951clone).d();
                    if (d != null) {
                        d.setDriveQuery(m8951clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hb.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    DriveRouteResult driveRouteResult2 = null;
                    try {
                        try {
                            DriveRouteResult calculateDriveRoute = hb.this.calculateDriveRoute(driveRouteQuery);
                            driveRouteResult2 = calculateDriveRoute;
                            driveRouteResult = calculateDriveRoute;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, calculateDriveRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, driveRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.a;
                        bundle.putParcelable(l.c, driveRouteResult2);
                        obtainMessage.setData(bundle);
                        hb.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            fn.a(this.d);
            if (rideRouteQuery != null) {
                if (a(rideRouteQuery.getFromAndTo())) {
                    gd.a().a(rideRouteQuery.getFromAndTo());
                    RouteSearch.RideRouteQuery m8955clone = rideRouteQuery.m8955clone();
                    RideRouteResult d = new gf(this.d, m8955clone).d();
                    if (d != null) {
                        d.setRideQuery(m8955clone);
                        return d;
                    }
                    return d;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hb.4
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    RideRouteResult rideRouteResult2 = null;
                    try {
                        try {
                            RideRouteResult calculateRideRoute = hb.this.calculateRideRoute(rideRouteQuery);
                            rideRouteResult2 = calculateRideRoute;
                            rideRouteResult = calculateRideRoute;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, calculateRideRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, rideRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.a;
                        bundle.putParcelable(l.c, rideRouteResult2);
                        obtainMessage.setData(bundle);
                        hb.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            fn.a(this.d);
            if (truckRouteQuery != null) {
                if (a(truckRouteQuery.getFromAndTo())) {
                    gd.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
                    gd.a().a(truckRouteQuery.getPassedByPoints());
                    RouteSearch.TruckRouteQuery m8957clone = truckRouteQuery.m8957clone();
                    TruckRouteRestult d = new gl(this.d, m8957clone).d();
                    if (d != null) {
                        d.setTruckQuery(m8957clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hb.5
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 104;
                    obtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestult = null;
                    TruckRouteRestult truckRouteRestult2 = null;
                    try {
                        try {
                            TruckRouteRestult calculateTruckRoute = hb.this.calculateTruckRoute(truckRouteQuery);
                            truckRouteRestult2 = calculateTruckRoute;
                            truckRouteRestult = calculateTruckRoute;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hb.this.b;
                            bundle.putParcelable(l.c, calculateTruckRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hb.this.b;
                            bundle.putParcelable(l.c, truckRouteRestult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.b;
                        bundle.putParcelable(l.c, truckRouteRestult2);
                        obtainMessage.setData(bundle);
                        hb.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            fn.a(this.d);
            if (walkRouteQuery != null) {
                if (a(walkRouteQuery.getFromAndTo())) {
                    gd.a().b(walkRouteQuery.getFromAndTo());
                    RouteSearch.WalkRouteQuery m8959clone = walkRouteQuery.m8959clone();
                    WalkRouteResult d = new gm(this.d, m8959clone).d();
                    if (d != null) {
                        d.setWalkQuery(m8959clone);
                        return d;
                    }
                    return d;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.hb.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    WalkRouteResult walkRouteResult2 = null;
                    try {
                        try {
                            WalkRouteResult calculateWalkRoute = hb.this.calculateWalkRoute(walkRouteQuery);
                            walkRouteResult2 = calculateWalkRoute;
                            walkRouteResult = calculateWalkRoute;
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, calculateWalkRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                            obtainMessage.obj = hb.this.a;
                            bundle.putParcelable(l.c, walkRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.a;
                        bundle.putParcelable(l.c, walkRouteResult2);
                        obtainMessage.setData(bundle);
                        hb.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            fe.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }
}
