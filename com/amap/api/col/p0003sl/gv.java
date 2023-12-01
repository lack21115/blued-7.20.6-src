package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* renamed from: com.amap.api.col.3sl.gv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gv.class */
public final class gv implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;

    /* renamed from: a  reason: collision with root package name */
    private Context f5011a;
    private DistrictSearchQuery b;

    /* renamed from: c  reason: collision with root package name */
    private DistrictSearch.OnDistrictSearchListener f5012c;
    private DistrictSearchQuery d;
    private int e;
    private Handler g;

    public gv(Context context) throws AMapException {
        hy a2 = hx.a(context, fd.a(false));
        if (a2.f5127a != hx.c.SuccessCode) {
            throw new AMapException(a2.b, 1, a2.b, a2.f5127a.a());
        }
        this.f5011a = context.getApplicationContext();
        this.g = fp.a();
    }

    private DistrictResult a(int i) throws AMapException {
        if (b(i)) {
            return f.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private void a(DistrictResult districtResult) {
        int i;
        f = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.b;
        if (districtSearchQuery == null || districtResult == null || (i = this.e) <= 0 || i <= districtSearchQuery.getPageNum()) {
            return;
        }
        f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
    }

    private boolean a() {
        return this.b != null;
    }

    private boolean b(int i) {
        return i < this.e && i >= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        try {
            DistrictResult districtResult = new DistrictResult();
            fn.a(this.f5011a);
            if (!a()) {
                this.b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.b.m2455clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.m2455clone();
                if (f != null) {
                    f.clear();
                }
            }
            if (this.e == 0) {
                DistrictResult d = new fg(this.f5011a, this.b.m2455clone()).d();
                if (d == null) {
                    return d;
                }
                this.e = d.getPageCount();
                a(d);
                return d;
            }
            DistrictResult a2 = a(this.b.getPageNum());
            DistrictResult districtResult2 = a2;
            if (a2 == null) {
                DistrictResult d2 = new fg(this.f5011a, this.b.m2455clone()).d();
                districtResult2 = d2;
                if (this.b != null) {
                    if (d2 == null) {
                        return d2;
                    }
                    districtResult2 = d2;
                    if (this.e > 0) {
                        districtResult2 = d2;
                        if (this.e > this.b.getPageNum()) {
                            f.put(Integer.valueOf(this.b.getPageNum()), d2);
                            districtResult2 = d2;
                        }
                    }
                }
            }
            return districtResult2;
        } catch (AMapException e) {
            fe.a(e, "DistrictSearch", "searchDistrict");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            gk.a().a(new Runnable() { // from class: com.amap.api.col.3sl.gv.1
                /* JADX WARN: Not initialized variable reg: 7, insn: 0x0126: MOVE  (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:27:0x0109 */
                @Override // java.lang.Runnable
                public final void run() {
                    Parcelable parcelable;
                    Message obtainMessage = fp.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(gv.this.b);
                    DistrictResult districtResult2 = districtResult;
                    try {
                        try {
                            DistrictResult searchDistrict = gv.this.searchDistrict();
                            if (searchDistrict != null) {
                                districtResult2 = searchDistrict;
                                districtResult = searchDistrict;
                                searchDistrict.setAMapException(new AMapException());
                            }
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = gv.this.f5012c;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("result", searchDistrict);
                            obtainMessage.setData(bundle);
                            if (gv.this.g != null) {
                                gv.this.g.sendMessage(obtainMessage);
                            }
                        } catch (AMapException e) {
                            districtResult.setAMapException(e);
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = gv.this.f5012c;
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("result", districtResult);
                            obtainMessage.setData(bundle2);
                            if (gv.this.g != null) {
                                gv.this.g.sendMessage(obtainMessage);
                            }
                        } catch (Throwable th) {
                            fe.a(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = gv.this.f5012c;
                            Bundle bundle3 = new Bundle();
                            bundle3.putParcelable("result", districtResult2);
                            obtainMessage.setData(bundle3);
                            if (gv.this.g != null) {
                                gv.this.g.sendMessage(obtainMessage);
                            }
                        }
                    } catch (Throwable th2) {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = gv.this.f5012c;
                        Bundle bundle4 = new Bundle();
                        bundle4.putParcelable("result", parcelable);
                        obtainMessage.setData(bundle4);
                        if (gv.this.g != null) {
                            gv.this.g.sendMessage(obtainMessage);
                        }
                        throw th2;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f5012c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }
}
