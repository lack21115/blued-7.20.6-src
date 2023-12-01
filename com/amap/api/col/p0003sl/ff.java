package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.ff  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ff.class */
public final class ff extends ex<DistanceSearch.DistanceQuery, DistanceResult> {
    private final String k;
    private final String l;
    private final String m;

    public ff(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.k = "/distance?";
        this.l = "|";
        this.m = ",";
    }

    private static DistanceResult c(String str) throws AMapException {
        return fm.i(str);
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
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.b).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                LatLonPoint latLonPoint = origins.get(i2);
                if (latLonPoint != null) {
                    double a = fe.a(latLonPoint.getLatitude());
                    stringBuffer.append(fe.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a);
                    if (i2 < size) {
                        stringBuffer.append("|");
                    }
                }
                i = i2 + 1;
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.b).getDestination();
        if (destination != null) {
            double a2 = fe.a(destination.getLatitude());
            double a3 = fe.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a3);
            stringBuffer.append(",");
            stringBuffer.append(a2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.b).getType());
        if (TextUtils.isEmpty(((DistanceSearch.DistanceQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.b).getExtensions());
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) this.b).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.b).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.a() + "/distance?";
    }
}
