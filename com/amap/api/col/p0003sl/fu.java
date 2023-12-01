package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fu.class */
public final class fu extends ft<String, PoiItem> {
    private PoiSearch.Query k;

    public fu(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.k = null;
        this.k = query;
    }

    private static PoiItem a(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return fm.d(optJSONObject);
    }

    private static PoiItem d(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            fe.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            fe.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    private String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.b);
        sb.append("&output=json");
        PoiSearch.Query query = this.k;
        if (query == null || c(query.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(this.k.getExtensions());
        }
        sb.append("&children=1");
        sb.append("&key=" + ho.f(this.i));
        return sb.toString();
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return d(str);
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        return f();
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final ga.b e() {
        ga.b bVar = new ga.b();
        bVar.f4984a = getURL() + c() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.a() + "/place/detail?";
    }
}
