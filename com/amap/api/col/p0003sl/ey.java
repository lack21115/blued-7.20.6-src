package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* renamed from: com.amap.api.col.3sl.ey  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ey.class */
public final class ey extends ex<RouteSearch.BusRouteQuery, BusRouteResult> {
    public ey(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult c(String str) throws AMapException {
        return fm.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(ho.f(this.i));
        stringBuffer.append("&origin=");
        stringBuffer.append(fe.a(((RouteSearch.BusRouteQuery) this.b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(fe.a(((RouteSearch.BusRouteQuery) this.b).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.b).getCity();
        String str = city;
        if (!fm.g(city)) {
            str = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(str);
        }
        if (!fm.g(((RouteSearch.BusRouteQuery) this.b).getCity())) {
            String b = b(str);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.b).getNightFlag());
        if (TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.b).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.a() + "/direction/transit/integrated?";
    }
}
