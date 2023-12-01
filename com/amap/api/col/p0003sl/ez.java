package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import com.android.internal.util.cm.SpamFilter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.ez  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ez.class */
public final class ez<T> extends ex<T, Object> {
    private int k;
    private List<String> l;
    private List<SuggestionCity> m;

    public ez(Context context, T t) {
        super(context, t);
        this.k = 0;
        this.l = new ArrayList();
        this.m = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.m = fm.a(optJSONObject);
                this.l = fm.b(optJSONObject);
            }
            this.k = jSONObject.optInt(SpamFilter.SpamContract.NotificationTable.COUNT);
            if (this.b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.b, this.k, this.m, this.l, fm.f(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.b, this.k, this.m, this.l, fm.e(jSONObject));
        } catch (Exception e) {
            fe.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (this.b instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.b;
            if (TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=base");
            } else {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b(((BusLineQuery) this.b).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!fm.g(city)) {
                    String b = b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.b;
            String city2 = busStationQuery.getCity();
            if (!fm.g(city2)) {
                String b2 = b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + ho.f(this.i));
        return sb.toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        String str = this.b instanceof BusLineQuery ? ((BusLineQuery) this.b).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname";
        return fd.a() + "/bus/" + str + "?";
    }
}
