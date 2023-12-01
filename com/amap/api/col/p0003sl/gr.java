package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.3sl.gr  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gr.class */
public final class gr implements IBusLineSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f4997a;
    private BusLineSearch.OnBusLineSearchListener b;

    /* renamed from: c  reason: collision with root package name */
    private BusLineQuery f4998c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    private Handler g;

    public gr(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.g = null;
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f4997a = context.getApplicationContext();
        this.f4998c = busLineQuery;
        if (busLineQuery != null) {
            this.d = busLineQuery.m2441clone();
        }
        this.g = fp.a();
    }

    private void a(BusLineResult busLineResult) {
        int i;
        this.f = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = this.e;
            if (i3 >= i) {
                break;
            }
            this.f.add(null);
            i2 = i3 + 1;
        }
        if (i < 0 || !a(this.f4998c.getPageNumber())) {
            return;
        }
        this.f.set(this.f4998c.getPageNumber(), busLineResult);
    }

    private boolean a() {
        BusLineQuery busLineQuery = this.f4998c;
        return (busLineQuery == null || fe.a(busLineQuery.getQueryString())) ? false : true;
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    private BusLineResult b(int i) {
        if (a(i)) {
            return this.f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.f4998c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            fn.a(this.f4997a);
            if (this.d == null || !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.f4998c.weakEquals(this.d)) {
                this.d = this.f4998c.m2441clone();
                this.e = 0;
                if (this.f != null) {
                    this.f.clear();
                }
            }
            if (this.e == 0) {
                BusLineResult busLineResult = (BusLineResult) new ez(this.f4997a, this.f4998c.m2441clone()).d();
                a(busLineResult);
                return busLineResult;
            }
            BusLineResult b = b(this.f4998c.getPageNumber());
            if (b == null) {
                BusLineResult busLineResult2 = (BusLineResult) new ez(this.f4997a, this.f4998c).d();
                this.f.set(this.f4998c.getPageNumber(), busLineResult2);
                return busLineResult2;
            }
            return b;
        } catch (AMapException e) {
            fe.a(e, "BusLineSearch", "searchBusLine");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gr.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = fp.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 1000;
                        fp.a aVar = new fp.a();
                        obtainMessage.obj = aVar;
                        aVar.b = gr.this.b;
                        aVar.f4961a = gr.this.searchBusLine();
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } finally {
                        gr.this.g.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (this.f4998c.weakEquals(busLineQuery)) {
            return;
        }
        this.f4998c = busLineQuery;
        this.d = busLineQuery.m2441clone();
    }
}
