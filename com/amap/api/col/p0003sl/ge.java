package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ga;
import com.amap.api.col.p0003sl.gc;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.ge  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ge.class */
public final class ge extends ex<RegeocodeQuery, RegeocodeAddress> {
    public ge(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(fe.a(((RegeocodeQuery) this.b).getPoint().getLongitude()));
            sb.append(",");
            sb.append(fe.a(((RegeocodeQuery) this.b).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.b).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) this.b).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.b).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) this.b).getMode());
        }
        if (TextUtils.isEmpty(((RegeocodeQuery) this.b).getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) this.b).getExtensions());
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) this.b).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) this.b).getLatLonType());
        sb.append("&key=");
        sb.append(ho.f(this.i));
        return sb.toString();
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        JSONObject optJSONObject;
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            optJSONObject = new JSONObject(str).optJSONObject("regeocode");
        } catch (JSONException e) {
            fe.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(fm.a(optJSONObject, "formatted_address"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            fm.a(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(fm.c(optJSONObject));
        JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            fm.b(optJSONArray, regeocodeAddress);
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            fm.a(optJSONArray2, regeocodeAddress);
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            fm.c(optJSONArray3, regeocodeAddress);
            return regeocodeAddress;
        }
        return regeocodeAddress;
    }

    private static gc f() {
        gb a = ga.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (gc) a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        return a(true);
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final ga.b e() {
        gc f = f();
        double a = f != null ? f.a() : 0.0d;
        ga.b bVar = new ga.b();
        bVar.a = getURL() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        if (this.b != 0 && ((RegeocodeQuery) this.b).getPoint() != null) {
            bVar.b = new gc.a(((RegeocodeQuery) this.b).getPoint().getLatitude(), ((RegeocodeQuery) this.b).getPoint().getLongitude(), a);
        }
        return bVar;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.a() + "/geocode/regeo?";
    }
}
