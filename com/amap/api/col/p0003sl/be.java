package com.amap.api.col.p0003sl;

import android.content.Context;
import com.alipay.sdk.util.l;
import com.amap.api.col.p0003sl.hp;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.be  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/be.class */
public final class be extends bv<String, List<OfflineMapProvince>> {
    private Context d;

    public be(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.bv
    /* renamed from: b */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.d != null) {
                bu.c(jSONObject.toString(), this.d);
            }
        } catch (Throwable th) {
            iw.c(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            if (this.d != null) {
                return bu.a(jSONObject, this.d);
            }
            return null;
        } catch (JSONException e) {
            iw.c(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final String a() {
        return "015";
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final JSONObject a(hp.b bVar) {
        if (bVar == null || bVar.f == null) {
            return null;
        }
        JSONObject optJSONObject = bVar.f.optJSONObject("015");
        if (!optJSONObject.has(l.c)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(l.c, new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }

    public final void a(Context context) {
        this.d = context;
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }
}
