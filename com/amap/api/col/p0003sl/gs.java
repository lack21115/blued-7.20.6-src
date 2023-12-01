package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.3sl.gs  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gs.class */
public final class gs implements IBusStationSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f5000a;
    private BusStationSearch.OnBusStationSearchListener b;

    /* renamed from: c  reason: collision with root package name */
    private BusStationQuery f5001c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    private Handler g;

    public gs(Context context, BusStationQuery busStationQuery) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f5000a = context.getApplicationContext();
        this.f5001c = busStationQuery;
        this.g = fp.a();
    }

    private void a(BusStationResult busStationResult) {
        int i;
        this.e = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = this.f;
            if (i3 > i) {
                break;
            }
            this.e.add(null);
            i2 = i3 + 1;
        }
        if (i > 0) {
            this.e.set(this.f5001c.getPageNumber(), busStationResult);
        }
    }

    private boolean a() {
        BusStationQuery busStationQuery = this.f5001c;
        return (busStationQuery == null || fe.a(busStationQuery.getQueryString())) ? false : true;
    }

    private boolean a(int i) {
        return i <= this.f && i >= 0;
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return this.e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.f5001c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            fn.a(this.f5000a);
            if (a()) {
                if (!this.f5001c.weakEquals(this.d)) {
                    this.d = this.f5001c.m2444clone();
                    this.f = 0;
                    if (this.e != null) {
                        this.e.clear();
                    }
                }
                if (this.f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new ez(this.f5000a, this.f5001c).d();
                    this.f = busStationResult.getPageCount();
                    a(busStationResult);
                    return busStationResult;
                }
                BusStationResult b = b(this.f5001c.getPageNumber());
                if (b == null) {
                    BusStationResult busStationResult2 = (BusStationResult) new ez(this.f5000a, this.f5001c).d();
                    this.e.set(this.f5001c.getPageNumber(), busStationResult2);
                    return busStationResult2;
                }
                return b;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "BusStationSearch", "searchBusStation");
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th) {
            fe.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gs.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 7;
                        fp.b bVar = new fp.b();
                        bVar.b = gs.this.b;
                        obtainMessage.obj = bVar;
                        BusStationResult searchBusStation = gs.this.searchBusStation();
                        obtainMessage.what = 1000;
                        bVar.f4962a = searchBusStation;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } finally {
                        gs.this.g.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f5001c)) {
            return;
        }
        this.f5001c = busStationQuery;
    }
}
