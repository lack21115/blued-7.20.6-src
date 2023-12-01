package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.hp;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.az  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/az.class */
public final class az extends bv<String, ay> {
    public az(Context context, String str) {
        super(context, str);
    }

    private static ay b(JSONObject jSONObject) throws AMapException {
        ay ayVar = new ay();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                ayVar.a(false);
            } else if (optString.equals("1")) {
                ayVar.a(true);
            }
            ayVar.a(jSONObject.optString("version", ""));
            return ayVar;
        } catch (Throwable th) {
            iw.c(th, "OfflineInitHandlerAbstract", "loadData parseJson");
            return ayVar;
        }
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final /* synthetic */ ay a(JSONObject jSONObject) throws AMapException {
        return b(jSONObject);
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final String a() {
        return "016";
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final JSONObject a(hp.b bVar) {
        if (bVar == null || bVar.f == null) {
            return null;
        }
        return bVar.f.optJSONObject("016");
    }

    @Override // com.amap.api.col.p0003sl.bv
    protected final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f4797a);
        return hashtable;
    }
}
