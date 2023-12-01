package com.amap.api.col.p0003sl;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.gd  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gd.class */
public class gd {
    private static volatile gd r;

    /* renamed from: a  reason: collision with root package name */
    boolean f4990a = true;
    boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f4991c = true;
    boolean d = true;
    boolean e = true;
    boolean f = true;
    boolean g = true;
    int h = 25;
    int i = 100;
    int j = 100;
    int k = 100;
    int l = 6;
    int m = 100;
    int n = 5000;
    int o = 1200;
    int p = 100000000;
    int q = 16;

    public static gd a() {
        if (r == null) {
            synchronized (gd.class) {
                try {
                    if (r == null) {
                        r = new gd();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return r;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void a(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.o < fe.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void a(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double a2;
        LatLonPoint latLonPoint;
        LatLonPoint next;
        if (!this.f4991c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double d = 0.0d;
        if (list == null || list.size() == 0) {
            a2 = fe.a(fromAndTo.getFrom(), fromAndTo.getTo());
        } else {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            Iterator<LatLonPoint> it = list.iterator();
            LatLonPoint latLonPoint2 = from;
            while (true) {
                latLonPoint = latLonPoint2;
                if (!it.hasNext()) {
                    break;
                }
                d += fe.a(latLonPoint, next);
                latLonPoint2 = it.next();
            }
            a2 = d + fe.a(latLonPoint, to);
        }
        if (this.n < a2 / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void a(String str) throws AMapException {
        if (str != null && this.b && str.length() > this.i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }

    public final void a(List<LatLonPoint> list) throws AMapException {
        if (this.g && list != null) {
            if (this.l < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
        }
    }

    public final void a(boolean z) {
        this.f4990a = z;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final void b(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.k < fe.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void b(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f4990a && list != null) {
            if (this.j < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
            }
            for (List<LatLonPoint> list2 : list) {
                double b = fe.b(list2);
                if (this.q < list2.size()) {
                    throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                }
                if (this.p < b) {
                    throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                }
            }
        }
    }

    public final void b(boolean z) {
        this.f4991c = z;
    }

    public final void c(int i) {
        this.j = i;
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final void d(int i) {
        this.k = i;
    }

    public final void d(boolean z) {
        this.e = z;
    }

    public final void e(int i) {
        this.l = i;
    }

    public final void e(boolean z) {
        this.f = z;
    }

    public final void f(int i) {
        this.m = i;
    }

    public final void f(boolean z) {
        this.g = z;
    }

    public final void g(int i) {
        this.n = i;
    }

    public final void g(boolean z) {
        this.b = z;
    }

    public final void h(int i) {
        this.o = i;
    }

    public final void i(int i) {
        this.p = i;
    }

    public final void j(int i) {
        this.q = i;
    }

    public final int k(int i) {
        int i2;
        if (this.d && (i2 = this.m) < i) {
            return i2;
        }
        return i;
    }

    public final int l(int i) {
        int i2;
        if (this.d && (i2 = this.h) < i) {
            return i2;
        }
        return i;
    }
}
