package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.fp;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.gz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gz.class */
public final class gz implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;

    /* renamed from: a  reason: collision with root package name */
    private PoiSearch.SearchBound f5027a;
    private PoiSearch.Query b;

    /* renamed from: c  reason: collision with root package name */
    private Context f5028c;
    private PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    private Handler j;

    public gz(Context context, PoiSearch.Query query) throws AMapException {
        this.j = null;
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f5028c = context.getApplicationContext();
        setQuery(query);
        this.j = fp.a();
    }

    private PoiResult a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private void a(PoiResult poiResult) {
        int i2;
        i = new HashMap<>();
        PoiSearch.Query query = this.b;
        if (query == null || poiResult == null || (i2 = this.h) <= 0 || i2 <= query.getPageNum()) {
            return;
        }
        i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
    }

    private boolean a() {
        PoiSearch.Query query = this.b;
        if (query == null) {
            return false;
        }
        return (fe.a(query.getQueryString()) && fe.a(this.b.getCategory())) ? false : true;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            return bound.getCenter() != null;
        } else if (!bound.getShape().equals("Polygon")) {
            if (bound.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = bound.getLowerLeft();
                LatLonPoint upperRight = bound.getUpperRight();
                return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
            }
            return true;
        } else {
            List<LatLonPoint> polyGonList = bound.getPolyGonList();
            if (polyGonList == null || polyGonList.size() == 0) {
                return false;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= polyGonList.size()) {
                    return true;
                }
                if (polyGonList.get(i3) == null) {
                    return false;
                }
                i2 = i3 + 1;
            }
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.f5027a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            fn.a(this.f5028c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (c()) {
                if (this.b != null) {
                    if ((!this.b.queryEquals(this.f) && this.f5027a == null) || (!this.b.queryEquals(this.f) && !this.f5027a.equals(this.g))) {
                        this.h = 0;
                        this.f = this.b.m2468clone();
                        if (this.f5027a != null) {
                            this.g = this.f5027a.m2469clone();
                        }
                        if (i != null) {
                            i.clear();
                        }
                    }
                    PoiSearch.SearchBound searchBound = null;
                    if (this.f5027a != null) {
                        searchBound = this.f5027a.m2469clone();
                    }
                    gd.a().a(this.b.getQueryString());
                    this.b.setPageNum(gd.a().k(this.b.getPageNum()));
                    this.b.setPageSize(gd.a().l(this.b.getPageSize()));
                    if (this.h == 0) {
                        PoiResult d = new fv(this.f5028c, new fy(this.b.m2468clone(), searchBound)).d();
                        a(d);
                        return d;
                    }
                    PoiResult a2 = a(this.b.getPageNum());
                    if (a2 == null) {
                        PoiResult d2 = new fv(this.f5028c, new fy(this.b.m2468clone(), searchBound)).d();
                        i.put(Integer.valueOf(this.b.getPageNum()), d2);
                        return d2;
                    }
                    return a2;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            fe.a(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gz.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = gz.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    PoiResult poiResult2 = null;
                    try {
                        try {
                            PoiResult searchPOI = gz.this.searchPOI();
                            poiResult2 = searchPOI;
                            poiResult = searchPOI;
                            bundle.putInt("errorCode", 1000);
                            fp.h hVar = new fp.h();
                            hVar.b = gz.this.d;
                            hVar.f4968a = searchPOI;
                            obtainMessage.obj = hVar;
                            obtainMessage.setData(bundle);
                            gz.this.j.sendMessage(obtainMessage);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            fp.h hVar2 = new fp.h();
                            hVar2.b = gz.this.d;
                            hVar2.f4968a = poiResult;
                            obtainMessage.obj = hVar2;
                            obtainMessage.setData(bundle);
                            gz.this.j.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        fp.h hVar3 = new fp.h();
                        hVar3.b = gz.this.d;
                        hVar3.f4968a = poiResult2;
                        obtainMessage.obj = hVar3;
                        obtainMessage.setData(bundle);
                        gz.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        fn.a(this.f5028c);
        PoiSearch.Query query = this.b;
        return new fu(this.f5028c, str, query != null ? query.m2468clone() : null).d();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(final String str) {
        gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gz.2
            @Override // java.lang.Runnable
            public final void run() {
                Message obtainMessage = fp.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                PoiItem poiItem2 = null;
                try {
                    try {
                        PoiItem searchPOIId = gz.this.searchPOIId(str);
                        poiItem2 = searchPOIId;
                        poiItem = searchPOIId;
                        bundle.putInt("errorCode", 1000);
                        fp.g gVar = new fp.g();
                        gVar.b = gz.this.d;
                        gVar.f4967a = searchPOIId;
                        obtainMessage.obj = gVar;
                        obtainMessage.setData(bundle);
                        gz.this.j.sendMessage(obtainMessage);
                    } catch (AMapException e) {
                        fe.a(e, "PoiSearch", "searchPOIIdAsyn");
                        PoiItem poiItem3 = poiItem;
                        bundle.putInt("errorCode", e.getErrorCode());
                        fp.g gVar2 = new fp.g();
                        gVar2.b = gz.this.d;
                        gVar2.f4967a = poiItem;
                        obtainMessage.obj = gVar2;
                        obtainMessage.setData(bundle);
                        gz.this.j.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    fp.g gVar3 = new fp.g();
                    gVar3.b = gz.this.d;
                    gVar3.f4967a = poiItem2;
                    obtainMessage.obj = gVar3;
                    obtainMessage.setData(bundle);
                    gz.this.j.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.f5027a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.b = query;
    }
}
