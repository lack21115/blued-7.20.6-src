package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.hx;
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

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch.OnRouteSearchListener f5039a;
    private RouteSearch.OnTruckRouteSearchListener b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.OnRoutePlanSearchListener f5040c;
    private Context d;
    private Handler e;

    public hb(Context context) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
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
                    RouteSearch.BusRouteQuery m2504clone = busRouteQuery.m2504clone();
                    BusRouteResult d = new ey(this.d, m2504clone).d();
                    if (d != null) {
                        d.setBusQuery(m2504clone);
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
                            bundle.putInt("errorCode", 1000);
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", calculateBusRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", busRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.f5039a;
                        bundle.putParcelable("result", busRouteResult2);
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
                    DriveRoutePlanResult d = new fh(this.d, drivePlanQuery.m2506clone()).d();
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
                            bundle.putInt("errorCode", 1000);
                            obtainMessage.obj = hb.this.f5040c;
                            bundle.putParcelable("result", calculateDrivePlan);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            obtainMessage.obj = hb.this.f5040c;
                            bundle.putParcelable("result", driveRoutePlanResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.f5040c;
                        bundle.putParcelable("result", driveRoutePlanResult2);
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
                    RouteSearch.DriveRouteQuery m2508clone = driveRouteQuery.m2508clone();
                    DriveRouteResult d = new fi(this.d, m2508clone).d();
                    if (d != null) {
                        d.setDriveQuery(m2508clone);
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
                            bundle.putInt("errorCode", 1000);
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", calculateDriveRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", driveRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.f5039a;
                        bundle.putParcelable("result", driveRouteResult2);
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
                    RouteSearch.RideRouteQuery m2512clone = rideRouteQuery.m2512clone();
                    RideRouteResult d = new gf(this.d, m2512clone).d();
                    if (d != null) {
                        d.setRideQuery(m2512clone);
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
                            bundle.putInt("errorCode", 1000);
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", calculateRideRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", rideRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.f5039a;
                        bundle.putParcelable("result", rideRouteResult2);
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
                    RouteSearch.TruckRouteQuery m2514clone = truckRouteQuery.m2514clone();
                    TruckRouteRestult d = new gl(this.d, m2514clone).d();
                    if (d != null) {
                        d.setTruckQuery(m2514clone);
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
                            bundle.putInt("errorCode", 1000);
                            obtainMessage.obj = hb.this.b;
                            bundle.putParcelable("result", calculateTruckRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            obtainMessage.obj = hb.this.b;
                            bundle.putParcelable("result", truckRouteRestult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.b;
                        bundle.putParcelable("result", truckRouteRestult2);
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
                    RouteSearch.WalkRouteQuery m2516clone = walkRouteQuery.m2516clone();
                    WalkRouteResult d = new gm(this.d, m2516clone).d();
                    if (d != null) {
                        d.setWalkQuery(m2516clone);
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
                            bundle.putInt("errorCode", 1000);
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", calculateWalkRoute);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            obtainMessage.obj = hb.this.f5039a;
                            bundle.putParcelable("result", walkRouteResult);
                            obtainMessage.setData(bundle);
                            hb.this.e.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.obj = hb.this.f5039a;
                        bundle.putParcelable("result", walkRouteResult2);
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
        this.f5040c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f5039a = onRouteSearchListener;
    }
}
