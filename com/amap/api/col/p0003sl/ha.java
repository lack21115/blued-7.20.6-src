package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* renamed from: com.amap.api.col.3sl.ha  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ha.class */
public final class ha implements IRoutePOISearch {

    /* renamed from: a  reason: collision with root package name */
    private RoutePOISearchQuery f5036a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private RoutePOISearch.OnRoutePOISearchListener f5037c;
    private Handler d;

    public ha(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.d = null;
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.b = context;
        this.f5036a = routePOISearchQuery;
        this.d = fp.a();
    }

    private boolean a() {
        RoutePOISearchQuery routePOISearchQuery = this.f5036a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.f5036a.getFrom() == null && this.f5036a.getTo() == null && this.f5036a.getPolylines() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.f5036a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            fn.a(this.b);
            if (a()) {
                return new gg(this.b, this.f5036a.m2536clone()).d();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.ha.1
            @Override // java.lang.Runnable
            public final void run() {
                Message obtainMessage = ha.this.d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResult = null;
                RoutePOISearchResult routePOISearchResult2 = null;
                try {
                    try {
                        RoutePOISearchResult searchRoutePOI = ha.this.searchRoutePOI();
                        routePOISearchResult2 = searchRoutePOI;
                        routePOISearchResult = searchRoutePOI;
                        bundle.putInt("errorCode", 1000);
                        fp.j jVar = new fp.j();
                        jVar.b = ha.this.f5037c;
                        jVar.f4970a = searchRoutePOI;
                        obtainMessage.obj = jVar;
                        obtainMessage.setData(bundle);
                        ha.this.d.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                        fp.j jVar2 = new fp.j();
                        jVar2.b = ha.this.f5037c;
                        jVar2.f4970a = routePOISearchResult;
                        obtainMessage.obj = jVar2;
                        obtainMessage.setData(bundle);
                        ha.this.d.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    fp.j jVar3 = new fp.j();
                    jVar3.b = ha.this.f5037c;
                    jVar3.f4970a = routePOISearchResult2;
                    obtainMessage.obj = jVar3;
                    obtainMessage.setData(bundle);
                    ha.this.d.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f5036a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f5037c = onRoutePOISearchListener;
    }
}
