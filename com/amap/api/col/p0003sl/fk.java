package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fk.class */
public final class fk extends ex<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public fk(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            fe.a(e, "GeocodingHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            fe.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
        if (jSONObject.has("count")) {
            if (jSONObject.getInt("count") > 0) {
                return fm.g(jSONObject);
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b(((GeocodeQuery) this.b).getLocationName()));
        String city = ((GeocodeQuery) this.b).getCity();
        if (!fm.g(city)) {
            String b = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        if (!fm.g(((GeocodeQuery) this.b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(b(((GeocodeQuery) this.b).getCountry()));
        }
        stringBuffer.append("&key=" + ho.f(this.i));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final ga.b e() {
        ga.b bVar = new ga.b();
        bVar.f4984a = getURL() + c() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.a() + "/geocode/geo?";
    }
}
